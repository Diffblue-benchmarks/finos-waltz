package org.finos.waltz.model.legal_entity;

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
import org.finos.waltz.model.Cardinality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagram;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramKind;
import org.finos.waltz.model.legal_entity.ImmutableLegalEntityRelationshipKind.Builder;
import org.finos.waltz.model.legal_entity.ImmutableLegalEntityRelationshipKind.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableLegalEntityRelationshipKindDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#cardinality(Cardinality)}
   *   <li>{@link Builder#kind(EntityKind)}
   *   <li>{@link Builder#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link Builder#provenance(String)}
   *   <li>{@link Builder#requiredRole(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipKind Builder.build()",
    "Builder Builder.cardinality(Cardinality)",
    "Builder Builder.kind(EntityKind)",
    "Builder Builder.lastUpdatedAt(LocalDateTime)",
    "Builder Builder.provenance(String)",
    "Builder Builder.requiredRole(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualIdResult =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    Optional<Long> id = Optional.of(1L);
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    ImmutableLegalEntityRelationshipKind actualImmutableLegalEntityRelationshipKind =
        actualIdResult
            .id(id)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(lastUpdatedAt)
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build();

    // Assert
    assertEquals("2020-03-01", actualImmutableLegalEntityRelationshipKind.lastUpdatedBy());
    assertEquals("42", actualImmutableLegalEntityRelationshipKind.externalId());
    assertEquals("Name", actualImmutableLegalEntityRelationshipKind.name());
    assertEquals("Provenance", actualImmutableLegalEntityRelationshipKind.provenance());
    assertEquals("Required Role", actualImmutableLegalEntityRelationshipKind.requiredRole());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableLegalEntityRelationshipKind.description());
    assertEquals(Cardinality.ZERO_ONE, actualImmutableLegalEntityRelationshipKind.cardinality());
    assertEquals(EntityKind.ALL, actualImmutableLegalEntityRelationshipKind.kind());
    assertEquals(EntityKind.ALL, actualImmutableLegalEntityRelationshipKind.targetKind());
    assertSame(lastUpdatedAt, actualImmutableLegalEntityRelationshipKind.lastUpdatedAt());
  }

  /**
   * Test Builder {@link Builder#description(String)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#description(String)}
   */
  @Test
  @DisplayName("Test Builder description(String); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.description(String)"})
  void testBuilderDescription_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();

    // Act
    Builder actualDescriptionResult =
        builderResult.description("The characteristics of someone or something");

    // Assert
    assertSame(builderResult, actualDescriptionResult);
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
    Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();

    // Act
    Builder actualExternalIdResult = builderResult.externalId("42");

    // Assert
    assertSame(builderResult, actualExternalIdResult);
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
    Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();
    ImmutableLegalEntityRelationshipKind instance =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableLegalEntityRelationshipKind actualImmutableLegalEntityRelationshipKind =
        builderResult.from((EntityKindProvider) instance).build();
    assertEquals(instance, actualImmutableLegalEntityRelationshipKind);
    ImmutableLegalEntityRelationshipKind actualImmutableLegalEntityRelationshipKind2 =
        builderResult.build();
    assertEquals(instance, actualImmutableLegalEntityRelationshipKind2);
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
    Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();

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
    Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();

    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
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
    Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();
    ImmutableLegalEntityRelationshipKind instance =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableLegalEntityRelationshipKind actualImmutableLegalEntityRelationshipKind =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableLegalEntityRelationshipKind);
    ImmutableLegalEntityRelationshipKind actualImmutableLegalEntityRelationshipKind2 =
        builderResult.build();
    assertEquals(instance, actualImmutableLegalEntityRelationshipKind2);
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
    Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();

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
    Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();

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
    Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();

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
    Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();
    ImmutableLegalEntityRelationshipKind instance =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableLegalEntityRelationshipKind actualImmutableLegalEntityRelationshipKind =
        builderResult.from((LastUpdatedProvider) instance).build();
    assertEquals(instance, actualImmutableLegalEntityRelationshipKind);
    ImmutableLegalEntityRelationshipKind actualImmutableLegalEntityRelationshipKind2 =
        builderResult.build();
    assertEquals(instance, actualImmutableLegalEntityRelationshipKind2);
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
    Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();

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
    Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();

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
    Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();

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
   * Test Builder {@link Builder#from(LegalEntityRelationshipKind)} with {@code
   * LegalEntityRelationshipKind}.
   *
   * <p>Method under test: {@link Builder#from(LegalEntityRelationshipKind)}
   */
  @Test
  @DisplayName("Test Builder from(LegalEntityRelationshipKind) with 'LegalEntityRelationshipKind'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LegalEntityRelationshipKind)"})
  void testBuilderFromWithLegalEntityRelationshipKind() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();
    ImmutableLegalEntityRelationshipKind instance =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableLegalEntityRelationshipKind actualImmutableLegalEntityRelationshipKind =
        builderResult.build();
    assertEquals(instance, actualImmutableLegalEntityRelationshipKind);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(LegalEntityRelationshipKind)} with {@code
   * LegalEntityRelationshipKind}.
   *
   * <p>Method under test: {@link Builder#from(LegalEntityRelationshipKind)}
   */
  @Test
  @DisplayName("Test Builder from(LegalEntityRelationshipKind) with 'LegalEntityRelationshipKind'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LegalEntityRelationshipKind)"})
  void testBuilderFromWithLegalEntityRelationshipKind2() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();
    ImmutableLegalEntityRelationshipKind instance =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole(null)
            .targetKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableLegalEntityRelationshipKind actualImmutableLegalEntityRelationshipKind =
        builderResult.build();
    assertEquals(instance, actualImmutableLegalEntityRelationshipKind);
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
    Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();

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
    Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();
    ImmutableLegalEntityRelationshipKind instance =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableLegalEntityRelationshipKind actualImmutableLegalEntityRelationshipKind =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableLegalEntityRelationshipKind);
    ImmutableLegalEntityRelationshipKind actualImmutableLegalEntityRelationshipKind2 =
        builderResult.build();
    assertEquals(instance, actualImmutableLegalEntityRelationshipKind2);
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
    Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();

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
    Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();
    ImmutableLegalEntityRelationshipKind instance =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole(null)
            .targetKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableLegalEntityRelationshipKind actualImmutableLegalEntityRelationshipKind =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableLegalEntityRelationshipKind);
    ImmutableLegalEntityRelationshipKind actualImmutableLegalEntityRelationshipKind2 =
        builderResult.build();
    assertEquals(instance, actualImmutableLegalEntityRelationshipKind2);
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
    Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();

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
    Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();
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
    Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();

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
    Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#targetKind(EntityKind)}.
   *
   * <p>Method under test: {@link Builder#targetKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder targetKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.targetKind(EntityKind)"})
  void testBuilderTargetKind() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();

    // Act
    Builder actualTargetKindResult = builderResult.targetKind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualTargetKindResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#cardinality()}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#cardinality()}
   */
  @Test
  @DisplayName("Test cardinality()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Cardinality ImmutableLegalEntityRelationshipKind.cardinality()"})
  void testCardinality() {
    // Arrange, Act and Assert
    assertEquals(
        Cardinality.ZERO_ONE,
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build()
            .cardinality());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#copyOf(LegalEntityRelationshipKind)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableLegalEntityRelationshipKind#copyOf(LegalEntityRelationshipKind)}
   */
  @Test
  @DisplayName(
      "Test copyOf(LegalEntityRelationshipKind); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipKind ImmutableLegalEntityRelationshipKind.copyOf(LegalEntityRelationshipKind)"
  })
  void testCopyOf_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableLegalEntityRelationshipKind instance =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableLegalEntityRelationshipKind actualCopyOfResult =
        ImmutableLegalEntityRelationshipKind.copyOf(instance);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("Required Role", actualCopyOfResult.requiredRole());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(Cardinality.ZERO_ONE, actualCopyOfResult.cardinality());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.targetKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#equals(Object)}, and {@link
   * ImmutableLegalEntityRelationshipKind#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLegalEntityRelationshipKind#equals(Object)}
   *   <li>{@link ImmutableLegalEntityRelationshipKind#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipKind.equals(Object)",
    "int ImmutableLegalEntityRelationshipKind.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableLegalEntityRelationshipKind immutableLegalEntityRelationshipKind =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build();
    ImmutableLegalEntityRelationshipKind immutableLegalEntityRelationshipKind2 =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertEquals(immutableLegalEntityRelationshipKind, immutableLegalEntityRelationshipKind2);
    assertEquals(
        immutableLegalEntityRelationshipKind.hashCode(),
        immutableLegalEntityRelationshipKind2.hashCode());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#equals(Object)}, and {@link
   * ImmutableLegalEntityRelationshipKind#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLegalEntityRelationshipKind#equals(Object)}
   *   <li>{@link ImmutableLegalEntityRelationshipKind#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipKind.equals(Object)",
    "int ImmutableLegalEntityRelationshipKind.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableLegalEntityRelationshipKind immutableLegalEntityRelationshipKind =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertEquals(immutableLegalEntityRelationshipKind, immutableLegalEntityRelationshipKind);
    int expectedHashCodeResult = immutableLegalEntityRelationshipKind.hashCode();
    assertEquals(expectedHashCodeResult, immutableLegalEntityRelationshipKind.hashCode());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipKind.equals(Object)",
    "int ImmutableLegalEntityRelationshipKind.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableLegalEntityRelationshipKind immutableLegalEntityRelationshipKind =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_MANY)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableLegalEntityRelationshipKind,
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipKind.equals(Object)",
    "int ImmutableLegalEntityRelationshipKind.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableLegalEntityRelationshipKind immutableLegalEntityRelationshipKind =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("Provenance")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableLegalEntityRelationshipKind,
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipKind.equals(Object)",
    "int ImmutableLegalEntityRelationshipKind.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableLegalEntityRelationshipKind immutableLegalEntityRelationshipKind =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("Provenance")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableLegalEntityRelationshipKind,
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipKind.equals(Object)",
    "int ImmutableLegalEntityRelationshipKind.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableLegalEntityRelationshipKind immutableLegalEntityRelationshipKind =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableLegalEntityRelationshipKind,
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipKind.equals(Object)",
    "int ImmutableLegalEntityRelationshipKind.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableLegalEntityRelationshipKind immutableLegalEntityRelationshipKind =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableLegalEntityRelationshipKind,
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipKind.equals(Object)",
    "int ImmutableLegalEntityRelationshipKind.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableLegalEntityRelationshipKind immutableLegalEntityRelationshipKind =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableLegalEntityRelationshipKind,
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipKind.equals(Object)",
    "int ImmutableLegalEntityRelationshipKind.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImmutableLegalEntityRelationshipKind immutableLegalEntityRelationshipKind =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020/03/01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableLegalEntityRelationshipKind,
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipKind.equals(Object)",
    "int ImmutableLegalEntityRelationshipKind.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ImmutableLegalEntityRelationshipKind immutableLegalEntityRelationshipKind =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Provenance")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableLegalEntityRelationshipKind,
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipKind.equals(Object)",
    "int ImmutableLegalEntityRelationshipKind.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ImmutableLegalEntityRelationshipKind immutableLegalEntityRelationshipKind =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("2020-03-01")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableLegalEntityRelationshipKind,
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipKind.equals(Object)",
    "int ImmutableLegalEntityRelationshipKind.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ImmutableLegalEntityRelationshipKind immutableLegalEntityRelationshipKind =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Provenance")
            .targetKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableLegalEntityRelationshipKind,
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipKind.equals(Object)",
    "int ImmutableLegalEntityRelationshipKind.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    ImmutableLegalEntityRelationshipKind immutableLegalEntityRelationshipKind =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ACTOR)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableLegalEntityRelationshipKind,
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipKind.equals(Object)",
    "int ImmutableLegalEntityRelationshipKind.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipKind.equals(Object)",
    "int ImmutableLegalEntityRelationshipKind.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build(),
        "Different type to ImmutableLegalEntityRelationshipKind");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLegalEntityRelationshipKind#description()}
   *   <li>{@link ImmutableLegalEntityRelationshipKind#externalId()}
   *   <li>{@link ImmutableLegalEntityRelationshipKind#lastUpdatedBy()}
   *   <li>{@link ImmutableLegalEntityRelationshipKind#name()}
   *   <li>{@link ImmutableLegalEntityRelationshipKind#requiredRole()}
   *   <li>{@link ImmutableLegalEntityRelationshipKind#targetKind()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableLegalEntityRelationshipKind.description()",
    "String ImmutableLegalEntityRelationshipKind.externalId()",
    "String ImmutableLegalEntityRelationshipKind.lastUpdatedBy()",
    "String ImmutableLegalEntityRelationshipKind.name()",
    "String ImmutableLegalEntityRelationshipKind.requiredRole()",
    "EntityKind ImmutableLegalEntityRelationshipKind.targetKind()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableLegalEntityRelationshipKind immutableLegalEntityRelationshipKind =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build();

    // Act
    String actualDescriptionResult = immutableLegalEntityRelationshipKind.description();
    String actualExternalIdResult = immutableLegalEntityRelationshipKind.externalId();
    String actualLastUpdatedByResult = immutableLegalEntityRelationshipKind.lastUpdatedBy();
    String actualNameResult = immutableLegalEntityRelationshipKind.name();
    String actualRequiredRoleResult = immutableLegalEntityRelationshipKind.requiredRole();

    // Assert
    assertEquals("2020-03-01", actualLastUpdatedByResult);
    assertEquals("42", actualExternalIdResult);
    assertEquals("Name", actualNameResult);
    assertEquals("Required Role", actualRequiredRoleResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(EntityKind.ALL, immutableLegalEntityRelationshipKind.targetKind());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#id()}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableLegalEntityRelationshipKind.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#cardinality()}.
   *
   * <p>Method under test: {@link Json#cardinality()}
   */
  @Test
  @DisplayName("Test Json cardinality()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Cardinality Json.cardinality()"})
  void testJsonCardinality() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().cardinality());
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
    assertNull(actualJson.externalId);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.requiredRole);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.cardinality);
    assertNull(actualJson.kind);
    assertNull(actualJson.targetKind);
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
   * Test Json {@link Json#requiredRole()}.
   *
   * <p>Method under test: {@link Json#requiredRole()}
   */
  @Test
  @DisplayName("Test Json requiredRole()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.requiredRole()"})
  void testJsonRequiredRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().requiredRole());
  }

  /**
   * Test Json {@link Json#targetKind()}.
   *
   * <p>Method under test: {@link Json#targetKind()}
   */
  @Test
  @DisplayName("Test Json targetKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.targetKind()"})
  void testJsonTargetKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().targetKind());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#kind()}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ImmutableLegalEntityRelationshipKind.kind()"})
  void testKind() {
    // Arrange, Act and Assert
    assertEquals(
        EntityKind.ALL,
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build()
            .kind());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableLegalEntityRelationshipKind.lastUpdatedAt()"})
  void testLastUpdatedAt() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    LocalDateTime actualLastUpdatedAtResult =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build()
            .lastUpdatedAt();

    // Assert
    assertEquals("00:00", actualLastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualLastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#provenance()}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableLegalEntityRelationshipKind.provenance()"})
  void testProvenance() {
    // Arrange, Act and Assert
    assertEquals(
        "Provenance",
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build()
            .provenance());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#toString()}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableLegalEntityRelationshipKind.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "LegalEntityRelationshipKind{id=1, provenance=Provenance, lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy"
            + "=2020-03-01, name=Name, description=The characteristics of someone or something, externalId=42,"
            + " targetKind=ALL, requiredRole=Required Role, cardinality=ZERO_ONE, kind=ALL}",
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#toString()}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableLegalEntityRelationshipKind.toString()"})
  void testToString2() {
    // Arrange, Act and Assert
    assertEquals(
        "LegalEntityRelationshipKind{id=1, provenance=Provenance, lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy"
            + "=2020-03-01, name=Name, description=The characteristics of someone or something, externalId=42,"
            + " targetKind=ALL, cardinality=ZERO_ONE, kind=ALL}",
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole(null)
            .targetKind(EntityKind.ALL)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#withCardinality(Cardinality)}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#withCardinality(Cardinality)}
   */
  @Test
  @DisplayName("Test withCardinality(Cardinality)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipKind ImmutableLegalEntityRelationshipKind.withCardinality(Cardinality)"
  })
  void testWithCardinality() {
    // Arrange
    ImmutableLegalEntityRelationshipKind immutableLegalEntityRelationshipKind =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableLegalEntityRelationshipKind actualWithCardinalityResult =
        immutableLegalEntityRelationshipKind.withCardinality(Cardinality.ZERO_ONE);

    // Assert
    assertSame(immutableLegalEntityRelationshipKind, actualWithCardinalityResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#withCardinality(Cardinality)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#withCardinality(Cardinality)}
   */
  @Test
  @DisplayName(
      "Test withCardinality(Cardinality); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipKind ImmutableLegalEntityRelationshipKind.withCardinality(Cardinality)"
  })
  void testWithCardinality_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableLegalEntityRelationshipKind actualWithCardinalityResult =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_MANY)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build()
            .withCardinality(Cardinality.ZERO_ONE);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithCardinalityResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithCardinalityResult.lastUpdatedBy());
    assertEquals("42", actualWithCardinalityResult.externalId());
    assertEquals("Name", actualWithCardinalityResult.name());
    assertEquals("Provenance", actualWithCardinalityResult.provenance());
    assertEquals("Required Role", actualWithCardinalityResult.requiredRole());
    assertEquals(
        "The characteristics of someone or something", actualWithCardinalityResult.description());
    assertEquals(Cardinality.ZERO_ONE, actualWithCardinalityResult.cardinality());
    assertEquals(EntityKind.ALL, actualWithCardinalityResult.kind());
    assertEquals(EntityKind.ALL, actualWithCardinalityResult.targetKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipKind ImmutableLegalEntityRelationshipKind.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutableLegalEntityRelationshipKind immutableLegalEntityRelationshipKind =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("42")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableLegalEntityRelationshipKind actualWithDescriptionResult =
        immutableLegalEntityRelationshipKind.withDescription("42");

    // Assert
    assertSame(immutableLegalEntityRelationshipKind, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#withDescription(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#withDescription(String)}
   */
  @Test
  @DisplayName(
      "Test withDescription(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipKind ImmutableLegalEntityRelationshipKind.withDescription(String)"
  })
  void testWithDescription_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableLegalEntityRelationshipKind actualWithDescriptionResult =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build()
            .withDescription("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithDescriptionResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithDescriptionResult.lastUpdatedBy());
    assertEquals("42", actualWithDescriptionResult.description());
    assertEquals("42", actualWithDescriptionResult.externalId());
    assertEquals("Name", actualWithDescriptionResult.name());
    assertEquals("Provenance", actualWithDescriptionResult.provenance());
    assertEquals("Required Role", actualWithDescriptionResult.requiredRole());
    assertEquals(Cardinality.ZERO_ONE, actualWithDescriptionResult.cardinality());
    assertEquals(EntityKind.ALL, actualWithDescriptionResult.kind());
    assertEquals(EntityKind.ALL, actualWithDescriptionResult.targetKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#withExternalId(String)}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipKind ImmutableLegalEntityRelationshipKind.withExternalId(String)"
  })
  void testWithExternalId() {
    // Arrange
    ImmutableLegalEntityRelationshipKind immutableLegalEntityRelationshipKind =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("0123456789ABCDEF")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableLegalEntityRelationshipKind actualWithExternalIdResult =
        immutableLegalEntityRelationshipKind.withExternalId("0123456789ABCDEF");

    // Assert
    assertSame(immutableLegalEntityRelationshipKind, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#withExternalId(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipKind ImmutableLegalEntityRelationshipKind.withExternalId(String)"
  })
  void testWithExternalId_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableLegalEntityRelationshipKind actualWithExternalIdResult =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithExternalIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    assertEquals("0123456789ABCDEF", actualWithExternalIdResult.externalId());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithExternalIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals("Required Role", actualWithExternalIdResult.requiredRole());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(Cardinality.ZERO_ONE, actualWithExternalIdResult.cardinality());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.targetKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipKind ImmutableLegalEntityRelationshipKind.withId(Optional)"
  })
  void testWithIdWithOptional() {
    // Arrange
    ImmutableLegalEntityRelationshipKind immutableLegalEntityRelationshipKind =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableLegalEntityRelationshipKind actualWithIdResult =
        immutableLegalEntityRelationshipKind.withId(optional);

    // Assert
    assertSame(immutableLegalEntityRelationshipKind, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipKind ImmutableLegalEntityRelationshipKind.withId(Optional)"
  })
  void testWithIdWithOptional_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableLegalEntityRelationshipKind immutableLegalEntityRelationshipKind =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableLegalEntityRelationshipKind actualWithIdResult =
        immutableLegalEntityRelationshipKind.withId(optional);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("42", actualWithIdResult.externalId());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("Required Role", actualWithIdResult.requiredRole());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(Cardinality.ZERO_ONE, actualWithIdResult.cardinality());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(EntityKind.ALL, actualWithIdResult.targetKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipKind ImmutableLegalEntityRelationshipKind.withId(long)"
  })
  void testWithIdWithValue() {
    // Arrange
    ImmutableLegalEntityRelationshipKind immutableLegalEntityRelationshipKind =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableLegalEntityRelationshipKind actualWithIdResult =
        immutableLegalEntityRelationshipKind.withId(1L);

    // Assert
    assertSame(immutableLegalEntityRelationshipKind, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipKind ImmutableLegalEntityRelationshipKind.withId(long)"
  })
  void testWithIdWithValue_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableLegalEntityRelationshipKind actualWithIdResult =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build()
            .withId(42L);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("42", actualWithIdResult.externalId());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("Required Role", actualWithIdResult.requiredRole());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(Cardinality.ZERO_ONE, actualWithIdResult.cardinality());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(EntityKind.ALL, actualWithIdResult.targetKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipKind ImmutableLegalEntityRelationshipKind.withKind(EntityKind)"
  })
  void testWithKind() {
    // Arrange
    ImmutableLegalEntityRelationshipKind immutableLegalEntityRelationshipKind =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableLegalEntityRelationshipKind actualWithKindResult =
        immutableLegalEntityRelationshipKind.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableLegalEntityRelationshipKind, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#withKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test withKind(EntityKind); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipKind ImmutableLegalEntityRelationshipKind.withKind(EntityKind)"
  })
  void testWithKind_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableLegalEntityRelationshipKind actualWithKindResult =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithKindResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithKindResult.lastUpdatedBy());
    assertEquals("42", actualWithKindResult.externalId());
    assertEquals("Name", actualWithKindResult.name());
    assertEquals("Provenance", actualWithKindResult.provenance());
    assertEquals("Required Role", actualWithKindResult.requiredRole());
    assertEquals("The characteristics of someone or something", actualWithKindResult.description());
    assertEquals(Cardinality.ZERO_ONE, actualWithKindResult.cardinality());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    assertEquals(EntityKind.ALL, actualWithKindResult.targetKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link
   * ImmutableLegalEntityRelationshipKind#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipKind ImmutableLegalEntityRelationshipKind.withLastUpdatedAt(LocalDateTime)"
  })
  void testWithLastUpdatedAt() {
    // Arrange
    ImmutableLegalEntityRelationshipKind immutableLegalEntityRelationshipKind =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableLegalEntityRelationshipKind actualWithLastUpdatedAtResult =
        immutableLegalEntityRelationshipKind.withLastUpdatedAt(
            LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableLegalEntityRelationshipKind, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipKind ImmutableLegalEntityRelationshipKind.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy() {
    // Arrange
    ImmutableLegalEntityRelationshipKind immutableLegalEntityRelationshipKind =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("42")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableLegalEntityRelationshipKind actualWithLastUpdatedByResult =
        immutableLegalEntityRelationshipKind.withLastUpdatedBy("42");

    // Assert
    assertSame(immutableLegalEntityRelationshipKind, actualWithLastUpdatedByResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#withLastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName(
      "Test withLastUpdatedBy(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipKind ImmutableLegalEntityRelationshipKind.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableLegalEntityRelationshipKind actualWithLastUpdatedByResult =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build()
            .withLastUpdatedBy("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithLastUpdatedByResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithLastUpdatedByResult.externalId());
    assertEquals("42", actualWithLastUpdatedByResult.lastUpdatedBy());
    assertEquals("Name", actualWithLastUpdatedByResult.name());
    assertEquals("Provenance", actualWithLastUpdatedByResult.provenance());
    assertEquals("Required Role", actualWithLastUpdatedByResult.requiredRole());
    assertEquals(
        "The characteristics of someone or something", actualWithLastUpdatedByResult.description());
    assertEquals(Cardinality.ZERO_ONE, actualWithLastUpdatedByResult.cardinality());
    assertEquals(EntityKind.ALL, actualWithLastUpdatedByResult.kind());
    assertEquals(EntityKind.ALL, actualWithLastUpdatedByResult.targetKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipKind ImmutableLegalEntityRelationshipKind.withName(String)"
  })
  void testWithName() {
    // Arrange
    ImmutableLegalEntityRelationshipKind immutableLegalEntityRelationshipKind =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("42")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableLegalEntityRelationshipKind actualWithNameResult =
        immutableLegalEntityRelationshipKind.withName("42");

    // Assert
    assertSame(immutableLegalEntityRelationshipKind, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#withName(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipKind ImmutableLegalEntityRelationshipKind.withName(String)"
  })
  void testWithName_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableLegalEntityRelationshipKind actualWithNameResult =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
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
    assertEquals("Provenance", actualWithNameResult.provenance());
    assertEquals("Required Role", actualWithNameResult.requiredRole());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(Cardinality.ZERO_ONE, actualWithNameResult.cardinality());
    assertEquals(EntityKind.ALL, actualWithNameResult.kind());
    assertEquals(EntityKind.ALL, actualWithNameResult.targetKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipKind ImmutableLegalEntityRelationshipKind.withProvenance(String)"
  })
  void testWithProvenance() {
    // Arrange
    ImmutableLegalEntityRelationshipKind immutableLegalEntityRelationshipKind =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("42")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableLegalEntityRelationshipKind actualWithProvenanceResult =
        immutableLegalEntityRelationshipKind.withProvenance("42");

    // Assert
    assertSame(immutableLegalEntityRelationshipKind, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#withProvenance(String)}
   */
  @Test
  @DisplayName(
      "Test withProvenance(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipKind ImmutableLegalEntityRelationshipKind.withProvenance(String)"
  })
  void testWithProvenance_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableLegalEntityRelationshipKind actualWithProvenanceResult =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
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
    assertEquals("Name", actualWithProvenanceResult.name());
    assertEquals("Required Role", actualWithProvenanceResult.requiredRole());
    assertEquals(
        "The characteristics of someone or something", actualWithProvenanceResult.description());
    assertEquals(Cardinality.ZERO_ONE, actualWithProvenanceResult.cardinality());
    assertEquals(EntityKind.ALL, actualWithProvenanceResult.kind());
    assertEquals(EntityKind.ALL, actualWithProvenanceResult.targetKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#withRequiredRole(String)}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#withRequiredRole(String)}
   */
  @Test
  @DisplayName("Test withRequiredRole(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipKind ImmutableLegalEntityRelationshipKind.withRequiredRole(String)"
  })
  void testWithRequiredRole() {
    // Arrange
    ImmutableLegalEntityRelationshipKind immutableLegalEntityRelationshipKind =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("42")
            .targetKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableLegalEntityRelationshipKind actualWithRequiredRoleResult =
        immutableLegalEntityRelationshipKind.withRequiredRole("42");

    // Assert
    assertSame(immutableLegalEntityRelationshipKind, actualWithRequiredRoleResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#withRequiredRole(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#withRequiredRole(String)}
   */
  @Test
  @DisplayName(
      "Test withRequiredRole(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipKind ImmutableLegalEntityRelationshipKind.withRequiredRole(String)"
  })
  void testWithRequiredRole_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableLegalEntityRelationshipKind actualWithRequiredRoleResult =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build()
            .withRequiredRole("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithRequiredRoleResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithRequiredRoleResult.lastUpdatedBy());
    assertEquals("42", actualWithRequiredRoleResult.externalId());
    assertEquals("42", actualWithRequiredRoleResult.requiredRole());
    assertEquals("Name", actualWithRequiredRoleResult.name());
    assertEquals("Provenance", actualWithRequiredRoleResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithRequiredRoleResult.description());
    assertEquals(Cardinality.ZERO_ONE, actualWithRequiredRoleResult.cardinality());
    assertEquals(EntityKind.ALL, actualWithRequiredRoleResult.kind());
    assertEquals(EntityKind.ALL, actualWithRequiredRoleResult.targetKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#withTargetKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#withTargetKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withTargetKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipKind ImmutableLegalEntityRelationshipKind.withTargetKind(EntityKind)"
  })
  void testWithTargetKind() {
    // Arrange
    ImmutableLegalEntityRelationshipKind immutableLegalEntityRelationshipKind =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableLegalEntityRelationshipKind actualWithTargetKindResult =
        immutableLegalEntityRelationshipKind.withTargetKind(EntityKind.ALL);

    // Assert
    assertSame(immutableLegalEntityRelationshipKind, actualWithTargetKindResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipKind#withTargetKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipKind#withTargetKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test withTargetKind(EntityKind); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipKind ImmutableLegalEntityRelationshipKind.withTargetKind(EntityKind)"
  })
  void testWithTargetKind_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableLegalEntityRelationshipKind actualWithTargetKindResult =
        ImmutableLegalEntityRelationshipKind.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .requiredRole("Required Role")
            .targetKind(EntityKind.ACTOR)
            .build()
            .withTargetKind(EntityKind.ALL);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithTargetKindResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithTargetKindResult.lastUpdatedBy());
    assertEquals("42", actualWithTargetKindResult.externalId());
    assertEquals("Name", actualWithTargetKindResult.name());
    assertEquals("Provenance", actualWithTargetKindResult.provenance());
    assertEquals("Required Role", actualWithTargetKindResult.requiredRole());
    assertEquals(
        "The characteristics of someone or something", actualWithTargetKindResult.description());
    assertEquals(Cardinality.ZERO_ONE, actualWithTargetKindResult.cardinality());
    assertEquals(EntityKind.ALL, actualWithTargetKindResult.kind());
    assertEquals(EntityKind.ALL, actualWithTargetKindResult.targetKind());
    assertSame(ofResult, toLocalDateResult);
  }
}
