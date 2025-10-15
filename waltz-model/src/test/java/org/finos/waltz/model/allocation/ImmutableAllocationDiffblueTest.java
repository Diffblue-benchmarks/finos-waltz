package org.finos.waltz.model.allocation;

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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagram;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramKind;
import org.finos.waltz.model.allocation.ImmutableAllocation.Builder;
import org.finos.waltz.model.allocation.ImmutableAllocation.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAllocationDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#externalId(String)}
   *   <li>{@link Builder#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link Builder#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAllocation Builder.build()",
    "Builder Builder.externalId(String)",
    "Builder Builder.lastUpdatedAt(LocalDateTime)",
    "Builder Builder.provenance(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualExternalIdResult = ImmutableAllocation.builder().externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.of(1L);
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    ImmutableAllocation actualImmutableAllocation =
        actualIdResult
            .id(id)
            .lastUpdatedAt(lastUpdatedAt)
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build();

    // Assert
    assertEquals("2020-03-01", actualImmutableAllocation.lastUpdatedBy());
    assertEquals("Provenance", actualImmutableAllocation.provenance());
    assertEquals(1, actualImmutableAllocation.percentage());
    assertEquals(1L, actualImmutableAllocation.measurableRatingId().longValue());
    assertEquals(1L, actualImmutableAllocation.schemeId());
    assertSame(lastUpdatedAt, actualImmutableAllocation.lastUpdatedAt());
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
    Builder builderResult = ImmutableAllocation.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act
    Builder actualExternalIdResult = builderResult.externalId(externalId);

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#from(Allocation)} with {@code Allocation}.
   *
   * <p>Method under test: {@link Builder#from(Allocation)}
   */
  @Test
  @DisplayName("Test Builder from(Allocation) with 'Allocation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Allocation)"})
  void testBuilderFromWithAllocation() {
    // Arrange
    Builder builderResult = ImmutableAllocation.builder();
    ImmutableAllocation instance =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAllocation actualImmutableAllocation = builderResult.build();
    assertEquals(instance, actualImmutableAllocation);
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableAllocation.builder();
    ImmutableAllocation instance =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build();

    // Act and Assert
    ImmutableAllocation actualImmutableAllocation =
        builderResult.from((ExternalIdProvider) instance).build();
    assertEquals(instance, actualImmutableAllocation);
    ImmutableAllocation actualImmutableAllocation2 = builderResult.build();
    assertEquals(instance, actualImmutableAllocation2);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableAllocation.builder();

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
   *   <li>Given of {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given of 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenOfFoo() {
    // Arrange
    Builder builderResult = ImmutableAllocation.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

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
    Builder builderResult = ImmutableAllocation.builder();

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
    Builder builderResult = ImmutableAllocation.builder();
    ImmutableAllocation instance =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build();

    // Act and Assert
    ImmutableAllocation actualImmutableAllocation =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableAllocation);
    ImmutableAllocation actualImmutableAllocation2 = builderResult.build();
    assertEquals(instance, actualImmutableAllocation2);
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
    Builder builderResult = ImmutableAllocation.builder();

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
    Builder builderResult = ImmutableAllocation.builder();

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
    Builder builderResult = ImmutableAllocation.builder();

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
    Builder builderResult = ImmutableAllocation.builder();
    ImmutableAllocation instance =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build();

    // Act and Assert
    ImmutableAllocation actualImmutableAllocation =
        builderResult.from((LastUpdatedProvider) instance).build();
    assertEquals(instance, actualImmutableAllocation);
    ImmutableAllocation actualImmutableAllocation2 = builderResult.build();
    assertEquals(instance, actualImmutableAllocation2);
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
    Builder builderResult = ImmutableAllocation.builder();

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
    Builder builderResult = ImmutableAllocation.builder();

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
    Builder builderResult = ImmutableAllocation.builder();

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
    Builder builderResult = ImmutableAllocation.builder();

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
    Builder builderResult = ImmutableAllocation.builder();
    ImmutableAllocation instance =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build();

    // Act and Assert
    ImmutableAllocation actualImmutableAllocation =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableAllocation);
    ImmutableAllocation actualImmutableAllocation2 = builderResult.build();
    assertEquals(instance, actualImmutableAllocation2);
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
    Builder builderResult = ImmutableAllocation.builder();

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
    Builder builderResult = ImmutableAllocation.builder();

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
    Builder builderResult = ImmutableAllocation.builder();
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
    Builder builderResult = ImmutableAllocation.builder();

    // Act
    Builder actualLastUpdatedByResult = builderResult.lastUpdatedBy("2020-03-01");

    // Assert
    assertSame(builderResult, actualLastUpdatedByResult);
  }

  /**
   * Test Builder {@link Builder#measurableRatingId(Long)}.
   *
   * <p>Method under test: {@link Builder#measurableRatingId(Long)}
   */
  @Test
  @DisplayName("Test Builder measurableRatingId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.measurableRatingId(Long)"})
  void testBuilderMeasurableRatingId() {
    // Arrange
    Builder builderResult = ImmutableAllocation.builder();

    // Act
    Builder actualMeasurableRatingIdResult = builderResult.measurableRatingId(1L);

    // Assert
    assertSame(builderResult, actualMeasurableRatingIdResult);
  }

  /**
   * Test Builder {@link Builder#percentage(int)}.
   *
   * <p>Method under test: {@link Builder#percentage(int)}
   */
  @Test
  @DisplayName("Test Builder percentage(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.percentage(int)"})
  void testBuilderPercentage() {
    // Arrange
    Builder builderResult = ImmutableAllocation.builder();

    // Act
    Builder actualPercentageResult = builderResult.percentage(1);

    // Assert
    assertSame(builderResult, actualPercentageResult);
  }

  /**
   * Test Builder {@link Builder#schemeId(long)}.
   *
   * <p>Method under test: {@link Builder#schemeId(long)}
   */
  @Test
  @DisplayName("Test Builder schemeId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.schemeId(long)"})
  void testBuilderSchemeId() {
    // Arrange
    Builder builderResult = ImmutableAllocation.builder();

    // Act
    Builder actualSchemeIdResult = builderResult.schemeId(1L);

    // Assert
    assertSame(builderResult, actualSchemeIdResult);
  }

  /**
   * Test {@link ImmutableAllocation#copyOf(Allocation)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocation#copyOf(Allocation)}
   */
  @Test
  @DisplayName("Test copyOf(Allocation); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAllocation ImmutableAllocation.copyOf(Allocation)"})
  void testCopyOf_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableAllocation instance =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build();

    // Act
    ImmutableAllocation actualCopyOfResult = ImmutableAllocation.copyOf(instance);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(1, actualCopyOfResult.percentage());
    assertEquals(1L, actualCopyOfResult.measurableRatingId().longValue());
    assertEquals(1L, actualCopyOfResult.schemeId());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAllocation#equals(Object)}, and {@link ImmutableAllocation#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAllocation#equals(Object)}
   *   <li>{@link ImmutableAllocation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAllocation.equals(Object)",
    "int ImmutableAllocation.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAllocation immutableAllocation =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build();
    ImmutableAllocation immutableAllocation2 =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableAllocation, immutableAllocation2);
    assertEquals(immutableAllocation.hashCode(), immutableAllocation2.hashCode());
  }

  /**
   * Test {@link ImmutableAllocation#equals(Object)}, and {@link ImmutableAllocation#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAllocation#equals(Object)}
   *   <li>{@link ImmutableAllocation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAllocation.equals(Object)",
    "int ImmutableAllocation.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAllocation immutableAllocation =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableAllocation, immutableAllocation);
    int expectedHashCodeResult = immutableAllocation.hashCode();
    assertEquals(expectedHashCodeResult, immutableAllocation.hashCode());
  }

  /**
   * Test {@link ImmutableAllocation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAllocation.equals(Object)",
    "int ImmutableAllocation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableAllocation immutableAllocation =
        ImmutableAllocation.builder()
            .externalId("2020-03-01")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAllocation,
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableAllocation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAllocation.equals(Object)",
    "int ImmutableAllocation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableAllocation immutableAllocation =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(2L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAllocation,
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableAllocation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAllocation.equals(Object)",
    "int ImmutableAllocation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableAllocation immutableAllocation =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAllocation,
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableAllocation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAllocation.equals(Object)",
    "int ImmutableAllocation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableAllocation immutableAllocation =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020/03/01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAllocation,
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableAllocation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAllocation.equals(Object)",
    "int ImmutableAllocation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableAllocation immutableAllocation =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(2L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAllocation,
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableAllocation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAllocation.equals(Object)",
    "int ImmutableAllocation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableAllocation immutableAllocation =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(0)
            .provenance("Provenance")
            .schemeId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAllocation,
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableAllocation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAllocation.equals(Object)",
    "int ImmutableAllocation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImmutableAllocation immutableAllocation =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("2020-03-01")
            .schemeId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAllocation,
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableAllocation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAllocation.equals(Object)",
    "int ImmutableAllocation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ImmutableAllocation immutableAllocation =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(2L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAllocation,
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableAllocation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAllocation.equals(Object)",
    "int ImmutableAllocation.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAllocation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAllocation.equals(Object)",
    "int ImmutableAllocation.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build(),
        "Different type to ImmutableAllocation");
  }

  /**
   * Test {@link ImmutableAllocation#externalId()}.
   *
   * <p>Method under test: {@link ImmutableAllocation#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableAllocation.externalId()"})
  void testExternalId() {
    // Arrange and Act
    Optional<String> actualExternalIdResult =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build()
            .externalId();

    // Assert
    assertEquals("42", actualExternalIdResult.get());
    assertTrue(actualExternalIdResult.isPresent());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAllocation#lastUpdatedBy()}
   *   <li>{@link ImmutableAllocation#measurableRatingId()}
   *   <li>{@link ImmutableAllocation#percentage()}
   *   <li>{@link ImmutableAllocation#schemeId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableAllocation.lastUpdatedBy()",
    "Long ImmutableAllocation.measurableRatingId()",
    "int ImmutableAllocation.percentage()",
    "long ImmutableAllocation.schemeId()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAllocation immutableAllocation =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build();

    // Act
    String actualLastUpdatedByResult = immutableAllocation.lastUpdatedBy();
    Long actualMeasurableRatingIdResult = immutableAllocation.measurableRatingId();
    int actualPercentageResult = immutableAllocation.percentage();
    long actualSchemeIdResult = immutableAllocation.schemeId();

    // Assert
    assertEquals("2020-03-01", actualLastUpdatedByResult);
    assertEquals(1, actualPercentageResult);
    assertEquals(1L, actualMeasurableRatingIdResult.longValue());
    assertEquals(1L, actualSchemeIdResult);
  }

  /**
   * Test {@link ImmutableAllocation#id()}.
   *
   * <p>Method under test: {@link ImmutableAllocation#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableAllocation.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
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
   * Test Json {@link Json#measurableRatingId()}.
   *
   * <p>Method under test: {@link Json#measurableRatingId()}
   */
  @Test
  @DisplayName("Test Json measurableRatingId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.measurableRatingId()"})
  void testJsonMeasurableRatingId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().measurableRatingId());
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
    assertNull(actualJson.measurableRatingId);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.provenance);
    assertNull(actualJson.lastUpdatedAt);
    assertEquals(0, actualJson.percentage);
    assertEquals(0L, actualJson.schemeId);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.percentageIsSet);
    assertFalse(actualJson.schemeIdIsSet);
  }

  /**
   * Test Json {@link Json#percentage()}.
   *
   * <p>Method under test: {@link Json#percentage()}
   */
  @Test
  @DisplayName("Test Json percentage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.percentage()"})
  void testJsonPercentage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().percentage());
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
   * Test Json {@link Json#schemeId()}.
   *
   * <p>Method under test: {@link Json#schemeId()}
   */
  @Test
  @DisplayName("Test Json schemeId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.schemeId()"})
  void testJsonSchemeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().schemeId());
  }

  /**
   * Test Json {@link Json#setPercentage(int)}.
   *
   * <p>Method under test: {@link Json#setPercentage(int)}
   */
  @Test
  @DisplayName("Test Json setPercentage(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setPercentage(int)"})
  void testJsonSetPercentage() {
    // Arrange
    Json json = new Json();

    // Act
    json.setPercentage(1);

    // Assert
    assertEquals(1, json.percentage);
    assertTrue(json.percentageIsSet);
  }

  /**
   * Test Json {@link Json#setSchemeId(long)}.
   *
   * <p>Method under test: {@link Json#setSchemeId(long)}
   */
  @Test
  @DisplayName("Test Json setSchemeId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setSchemeId(long)"})
  void testJsonSetSchemeId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setSchemeId(1L);

    // Assert
    assertEquals(1L, json.schemeId);
    assertTrue(json.schemeIdIsSet);
  }

  /**
   * Test {@link ImmutableAllocation#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link ImmutableAllocation#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableAllocation.lastUpdatedAt()"})
  void testLastUpdatedAt() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    LocalDateTime actualLastUpdatedAtResult =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build()
            .lastUpdatedAt();

    // Assert
    assertEquals("00:00", actualLastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualLastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAllocation#provenance()}.
   *
   * <p>Method under test: {@link ImmutableAllocation#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableAllocation.provenance()"})
  void testProvenance() {
    // Arrange, Act and Assert
    assertEquals(
        "Provenance",
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build()
            .provenance());
  }

  /**
   * Test {@link ImmutableAllocation#toString()}.
   *
   * <p>Method under test: {@link ImmutableAllocation#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableAllocation.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "Allocation{id=1, lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01, provenance=Provenance,"
            + " externalId=42, schemeId=1, measurableRatingId=1, percentage=1}",
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableAllocation#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableAllocation#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAllocation ImmutableAllocation.withExternalId(Optional)"})
  void testWithExternalIdWithOptional() {
    // Arrange
    ImmutableAllocation immutableAllocation =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableAllocation actualWithExternalIdResult = immutableAllocation.withExternalId(optional);

    // Assert
    assertSame(immutableAllocation, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableAllocation#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocation#withExternalId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(Optional) with 'optional'; then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAllocation ImmutableAllocation.withExternalId(Optional)"})
  void testWithExternalIdWithOptional_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableAllocation immutableAllocation =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableAllocation actualWithExternalIdResult = immutableAllocation.withExternalId(optional);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithExternalIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithExternalIdResult.lastUpdatedBy());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals(1, actualWithExternalIdResult.percentage());
    assertEquals(1L, actualWithExternalIdResult.measurableRatingId().longValue());
    assertEquals(1L, actualWithExternalIdResult.schemeId());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAllocation#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableAllocation#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAllocation ImmutableAllocation.withExternalId(String)"})
  void testWithExternalIdWithValue() {
    // Arrange
    ImmutableAllocation immutableAllocation =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build();

    // Act
    ImmutableAllocation actualWithExternalIdResult = immutableAllocation.withExternalId("42");

    // Assert
    assertSame(immutableAllocation, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableAllocation#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocation#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAllocation ImmutableAllocation.withExternalId(String)"})
  void testWithExternalIdWithValue_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAllocation actualWithExternalIdResult =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithExternalIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithExternalIdResult.lastUpdatedBy());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals(1, actualWithExternalIdResult.percentage());
    assertEquals(1L, actualWithExternalIdResult.measurableRatingId().longValue());
    assertEquals(1L, actualWithExternalIdResult.schemeId());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAllocation#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableAllocation#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAllocation ImmutableAllocation.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    ImmutableAllocation immutableAllocation =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableAllocation actualWithIdResult = immutableAllocation.withId(optional);

    // Assert
    assertSame(immutableAllocation, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableAllocation#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocation#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAllocation ImmutableAllocation.withId(Optional)"})
  void testWithIdWithOptional_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableAllocation immutableAllocation =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(2L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableAllocation actualWithIdResult = immutableAllocation.withId(optional);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals(1, actualWithIdResult.percentage());
    assertEquals(1L, actualWithIdResult.measurableRatingId().longValue());
    assertEquals(1L, actualWithIdResult.schemeId());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAllocation#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableAllocation#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAllocation ImmutableAllocation.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    ImmutableAllocation immutableAllocation =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build();

    // Act
    ImmutableAllocation actualWithIdResult = immutableAllocation.withId(1L);

    // Assert
    assertSame(immutableAllocation, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableAllocation#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocation#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAllocation ImmutableAllocation.withId(long)"})
  void testWithIdWithValue_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAllocation actualWithIdResult =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build()
            .withId(42L);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals(1, actualWithIdResult.percentage());
    assertEquals(1L, actualWithIdResult.measurableRatingId().longValue());
    assertEquals(1L, actualWithIdResult.schemeId());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAllocation#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableAllocation#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAllocation ImmutableAllocation.withLastUpdatedAt(LocalDateTime)"})
  void testWithLastUpdatedAt() {
    // Arrange
    ImmutableAllocation immutableAllocation =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build();

    // Act
    ImmutableAllocation actualWithLastUpdatedAtResult =
        immutableAllocation.withLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableAllocation, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableAllocation#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableAllocation#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAllocation ImmutableAllocation.withLastUpdatedBy(String)"})
  void testWithLastUpdatedBy() {
    // Arrange
    ImmutableAllocation immutableAllocation =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("42")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build();

    // Act
    ImmutableAllocation actualWithLastUpdatedByResult = immutableAllocation.withLastUpdatedBy("42");

    // Assert
    assertSame(immutableAllocation, actualWithLastUpdatedByResult);
  }

  /**
   * Test {@link ImmutableAllocation#withLastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocation#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName(
      "Test withLastUpdatedBy(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAllocation ImmutableAllocation.withLastUpdatedBy(String)"})
  void testWithLastUpdatedBy_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAllocation actualWithLastUpdatedByResult =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build()
            .withLastUpdatedBy("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithLastUpdatedByResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithLastUpdatedByResult.lastUpdatedBy());
    assertEquals("Provenance", actualWithLastUpdatedByResult.provenance());
    assertEquals(1, actualWithLastUpdatedByResult.percentage());
    assertEquals(1L, actualWithLastUpdatedByResult.measurableRatingId().longValue());
    assertEquals(1L, actualWithLastUpdatedByResult.schemeId());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAllocation#withMeasurableRatingId(Long)}.
   *
   * <p>Method under test: {@link ImmutableAllocation#withMeasurableRatingId(Long)}
   */
  @Test
  @DisplayName("Test withMeasurableRatingId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAllocation ImmutableAllocation.withMeasurableRatingId(Long)"})
  void testWithMeasurableRatingId() {
    // Arrange
    ImmutableAllocation immutableAllocation =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build();

    // Act
    ImmutableAllocation actualWithMeasurableRatingIdResult =
        immutableAllocation.withMeasurableRatingId(1L);

    // Assert
    assertSame(immutableAllocation, actualWithMeasurableRatingIdResult);
  }

  /**
   * Test {@link ImmutableAllocation#withMeasurableRatingId(Long)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocation#withMeasurableRatingId(Long)}
   */
  @Test
  @DisplayName(
      "Test withMeasurableRatingId(Long); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAllocation ImmutableAllocation.withMeasurableRatingId(Long)"})
  void testWithMeasurableRatingId_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAllocation actualWithMeasurableRatingIdResult =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build()
            .withMeasurableRatingId(42L);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithMeasurableRatingIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithMeasurableRatingIdResult.lastUpdatedBy());
    assertEquals("Provenance", actualWithMeasurableRatingIdResult.provenance());
    assertEquals(1, actualWithMeasurableRatingIdResult.percentage());
    assertEquals(1L, actualWithMeasurableRatingIdResult.schemeId());
    assertEquals(42L, actualWithMeasurableRatingIdResult.measurableRatingId().longValue());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAllocation#withPercentage(int)}.
   *
   * <p>Method under test: {@link ImmutableAllocation#withPercentage(int)}
   */
  @Test
  @DisplayName("Test withPercentage(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAllocation ImmutableAllocation.withPercentage(int)"})
  void testWithPercentage() {
    // Arrange
    ImmutableAllocation immutableAllocation =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(42)
            .provenance("Provenance")
            .schemeId(1L)
            .build();

    // Act
    ImmutableAllocation actualWithPercentageResult = immutableAllocation.withPercentage(42);

    // Assert
    assertSame(immutableAllocation, actualWithPercentageResult);
  }

  /**
   * Test {@link ImmutableAllocation#withPercentage(int)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocation#withPercentage(int)}
   */
  @Test
  @DisplayName(
      "Test withPercentage(int); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAllocation ImmutableAllocation.withPercentage(int)"})
  void testWithPercentage_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAllocation actualWithPercentageResult =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build()
            .withPercentage(42);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithPercentageResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithPercentageResult.lastUpdatedBy());
    assertEquals("Provenance", actualWithPercentageResult.provenance());
    assertEquals(1L, actualWithPercentageResult.measurableRatingId().longValue());
    assertEquals(1L, actualWithPercentageResult.schemeId());
    assertEquals(42, actualWithPercentageResult.percentage());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAllocation#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableAllocation#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAllocation ImmutableAllocation.withProvenance(String)"})
  void testWithProvenance() {
    // Arrange
    ImmutableAllocation immutableAllocation =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("42")
            .schemeId(1L)
            .build();

    // Act
    ImmutableAllocation actualWithProvenanceResult = immutableAllocation.withProvenance("42");

    // Assert
    assertSame(immutableAllocation, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableAllocation#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocation#withProvenance(String)}
   */
  @Test
  @DisplayName(
      "Test withProvenance(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAllocation ImmutableAllocation.withProvenance(String)"})
  void testWithProvenance_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAllocation actualWithProvenanceResult =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build()
            .withProvenance("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithProvenanceResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithProvenanceResult.lastUpdatedBy());
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals(1, actualWithProvenanceResult.percentage());
    assertEquals(1L, actualWithProvenanceResult.measurableRatingId().longValue());
    assertEquals(1L, actualWithProvenanceResult.schemeId());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAllocation#withSchemeId(long)}.
   *
   * <p>Method under test: {@link ImmutableAllocation#withSchemeId(long)}
   */
  @Test
  @DisplayName("Test withSchemeId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAllocation ImmutableAllocation.withSchemeId(long)"})
  void testWithSchemeId() {
    // Arrange
    ImmutableAllocation immutableAllocation =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(42L)
            .build();

    // Act
    ImmutableAllocation actualWithSchemeIdResult = immutableAllocation.withSchemeId(42L);

    // Assert
    assertSame(immutableAllocation, actualWithSchemeIdResult);
  }

  /**
   * Test {@link ImmutableAllocation#withSchemeId(long)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocation#withSchemeId(long)}
   */
  @Test
  @DisplayName("Test withSchemeId(long); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAllocation ImmutableAllocation.withSchemeId(long)"})
  void testWithSchemeId_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAllocation actualWithSchemeIdResult =
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build()
            .withSchemeId(42L);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithSchemeIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithSchemeIdResult.lastUpdatedBy());
    assertEquals("Provenance", actualWithSchemeIdResult.provenance());
    assertEquals(1, actualWithSchemeIdResult.percentage());
    assertEquals(1L, actualWithSchemeIdResult.measurableRatingId().longValue());
    assertEquals(42L, actualWithSchemeIdResult.schemeId());
    assertSame(ofResult, toLocalDateResult);
  }
}
