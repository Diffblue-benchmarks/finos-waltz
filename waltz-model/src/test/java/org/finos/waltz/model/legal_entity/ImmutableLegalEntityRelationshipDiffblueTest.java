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
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.IsReadOnlyProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagram;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramKind;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentRating;
import org.finos.waltz.model.legal_entity.ImmutableLegalEntityRelationship.Builder;
import org.finos.waltz.model.legal_entity.ImmutableLegalEntityRelationship.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableLegalEntityRelationshipDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#externalId(String)}
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
    "ImmutableLegalEntityRelationship Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.externalId(String)",
    "Builder Builder.kind(EntityKind)",
    "Builder Builder.lastUpdatedAt(LocalDateTime)",
    "Builder Builder.provenance(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualExternalIdResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<String> externalId = Optional.of("42");
    Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.of(42L);
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    Builder actualLastUpdatedByResult =
        actualIdResult
            .id(id)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(lastUpdatedAt)
            .lastUpdatedBy("2020-03-01");
    ImmutableEntityReference legalEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualRelationshipKindIdResult =
        actualLastUpdatedByResult
            .legalEntityReference(legalEntityReference)
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableEntityReference targetEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableLegalEntityRelationship actualImmutableLegalEntityRelationship =
        actualRelationshipKindIdResult.targetEntityReference(targetEntityReference).build();

    // Assert
    assertEquals("2020-03-01", actualImmutableLegalEntityRelationship.lastUpdatedBy());
    assertEquals("Provenance", actualImmutableLegalEntityRelationship.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableLegalEntityRelationship.description());
    assertEquals(1L, actualImmutableLegalEntityRelationship.relationshipKindId().longValue());
    assertEquals(EntityKind.ALL, actualImmutableLegalEntityRelationship.kind());
    assertFalse(actualImmutableLegalEntityRelationship.isReadOnly());
    assertSame(lastUpdatedAt, actualImmutableLegalEntityRelationship.lastUpdatedAt());
    assertSame(legalEntityReference, actualImmutableLegalEntityRelationship.legalEntityReference());
    assertSame(
        targetEntityReference, actualImmutableLegalEntityRelationship.targetEntityReference());
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
    Builder builderResult = ImmutableLegalEntityRelationship.builder();
    Optional<String> externalId = Optional.of("42");

    // Act
    Builder actualExternalIdResult = builderResult.externalId(externalId);

    // Assert
    assertSame(builderResult, actualExternalIdResult);
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
    Builder builderResult = ImmutableLegalEntityRelationship.builder();

    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship instance =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    ImmutableLegalEntityRelationship actualImmutableLegalEntityRelationship =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableLegalEntityRelationship);
    ImmutableLegalEntityRelationship actualImmutableLegalEntityRelationship2 =
        builderResult.build();
    assertEquals(instance, actualImmutableLegalEntityRelationship2);
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
    Builder builderResult = ImmutableLegalEntityRelationship.builder();

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
    Builder builderResult = ImmutableLegalEntityRelationship.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableLegalEntityRelationship.builder();

    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship instance =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    ImmutableLegalEntityRelationship actualImmutableLegalEntityRelationship =
        builderResult.from((EntityKindProvider) instance).build();
    assertEquals(instance, actualImmutableLegalEntityRelationship);
    ImmutableLegalEntityRelationship actualImmutableLegalEntityRelationship2 =
        builderResult.build();
    assertEquals(instance, actualImmutableLegalEntityRelationship2);
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
    Builder builderResult = ImmutableLegalEntityRelationship.builder();

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
    Builder builderResult = ImmutableLegalEntityRelationship.builder();

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
    Builder builderResult = ImmutableLegalEntityRelationship.builder();

    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship instance =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    ImmutableLegalEntityRelationship actualImmutableLegalEntityRelationship =
        builderResult.from((ExternalIdProvider) instance).build();
    assertEquals(instance, actualImmutableLegalEntityRelationship);
    ImmutableLegalEntityRelationship actualImmutableLegalEntityRelationship2 =
        builderResult.build();
    assertEquals(instance, actualImmutableLegalEntityRelationship2);
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
    Builder builderResult = ImmutableLegalEntityRelationship.builder();

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
   *   <li>Given of {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given of '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenOf42() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationship.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("42");
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
    Builder builderResult = ImmutableLegalEntityRelationship.builder();

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
    Builder builderResult = ImmutableLegalEntityRelationship.builder();

    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship instance =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    ImmutableLegalEntityRelationship actualImmutableLegalEntityRelationship =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableLegalEntityRelationship);
    ImmutableLegalEntityRelationship actualImmutableLegalEntityRelationship2 =
        builderResult.build();
    assertEquals(instance, actualImmutableLegalEntityRelationship2);
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
    Builder builderResult = ImmutableLegalEntityRelationship.builder();

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
    Builder builderResult = ImmutableLegalEntityRelationship.builder();

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
    Builder builderResult = ImmutableLegalEntityRelationship.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(IsReadOnlyProvider)} with {@code IsReadOnlyProvider}.
   *
   * <p>Method under test: {@link Builder#from(IsReadOnlyProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IsReadOnlyProvider) with 'IsReadOnlyProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IsReadOnlyProvider)"})
  void testBuilderFromWithIsReadOnlyProvider() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationship.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (IsReadOnlyProvider)
                ImmutableAppGroupEntry.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .provenance("Provenance")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IsReadOnlyProvider)} with {@code IsReadOnlyProvider}.
   *
   * <p>Method under test: {@link Builder#from(IsReadOnlyProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IsReadOnlyProvider) with 'IsReadOnlyProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IsReadOnlyProvider)"})
  void testBuilderFromWithIsReadOnlyProvider2() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationship.builder();

    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship instance =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    ImmutableLegalEntityRelationship actualImmutableLegalEntityRelationship =
        builderResult.from((IsReadOnlyProvider) instance).build();
    assertEquals(instance, actualImmutableLegalEntityRelationship);
    ImmutableLegalEntityRelationship actualImmutableLegalEntityRelationship2 =
        builderResult.build();
    assertEquals(instance, actualImmutableLegalEntityRelationship2);
  }

  /**
   * Test Builder {@link Builder#from(IsReadOnlyProvider)} with {@code IsReadOnlyProvider}.
   *
   * <p>Method under test: {@link Builder#from(IsReadOnlyProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IsReadOnlyProvider) with 'IsReadOnlyProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IsReadOnlyProvider)"})
  void testBuilderFromWithIsReadOnlyProvider3() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationship.builder();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    // Act
    Builder actualFromResult =
        builderResult.from(
            (IsReadOnlyProvider)
                commentResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .id(1L)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .provenance("Provenance")
                    .ratingId(1L)
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IsReadOnlyProvider)} with {@code IsReadOnlyProvider}.
   *
   * <p>Method under test: {@link Builder#from(IsReadOnlyProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IsReadOnlyProvider) with 'IsReadOnlyProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IsReadOnlyProvider)"})
  void testBuilderFromWithIsReadOnlyProvider4() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationship.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (IsReadOnlyProvider)
                ImmutableAppGroupEntry.builder()
                    .description(null)
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .provenance("Provenance")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableLegalEntityRelationship.builder();

    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship instance =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    ImmutableLegalEntityRelationship actualImmutableLegalEntityRelationship =
        builderResult.from((LastUpdatedProvider) instance).build();
    assertEquals(instance, actualImmutableLegalEntityRelationship);
    ImmutableLegalEntityRelationship actualImmutableLegalEntityRelationship2 =
        builderResult.build();
    assertEquals(instance, actualImmutableLegalEntityRelationship2);
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
    Builder builderResult = ImmutableLegalEntityRelationship.builder();

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
    Builder builderResult = ImmutableLegalEntityRelationship.builder();

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
    Builder builderResult = ImmutableLegalEntityRelationship.builder();

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
   * Test Builder {@link Builder#from(LegalEntityRelationship)} with {@code
   * LegalEntityRelationship}.
   *
   * <p>Method under test: {@link Builder#from(LegalEntityRelationship)}
   */
  @Test
  @DisplayName("Test Builder from(LegalEntityRelationship) with 'LegalEntityRelationship'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LegalEntityRelationship)"})
  void testBuilderFromWithLegalEntityRelationship() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationship.builder();

    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship instance =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    ImmutableLegalEntityRelationship actualImmutableLegalEntityRelationship =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableLegalEntityRelationship);
    ImmutableLegalEntityRelationship actualImmutableLegalEntityRelationship2 =
        builderResult.build();
    assertEquals(instance, actualImmutableLegalEntityRelationship2);
  }

  /**
   * Test Builder {@link Builder#from(LegalEntityRelationship)} with {@code
   * LegalEntityRelationship}.
   *
   * <p>Method under test: {@link Builder#from(LegalEntityRelationship)}
   */
  @Test
  @DisplayName("Test Builder from(LegalEntityRelationship) with 'LegalEntityRelationship'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LegalEntityRelationship)"})
  void testBuilderFromWithLegalEntityRelationship2() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationship.builder();

    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description(null)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship instance =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    ImmutableLegalEntityRelationship actualImmutableLegalEntityRelationship =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableLegalEntityRelationship);
    ImmutableLegalEntityRelationship actualImmutableLegalEntityRelationship2 =
        builderResult.build();
    assertEquals(instance, actualImmutableLegalEntityRelationship2);
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
    Builder builderResult = ImmutableLegalEntityRelationship.builder();

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
    Builder builderResult = ImmutableLegalEntityRelationship.builder();

    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship instance =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    ImmutableLegalEntityRelationship actualImmutableLegalEntityRelationship =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableLegalEntityRelationship);
    ImmutableLegalEntityRelationship actualImmutableLegalEntityRelationship2 =
        builderResult.build();
    assertEquals(instance, actualImmutableLegalEntityRelationship2);
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
    Builder builderResult = ImmutableLegalEntityRelationship.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
                ImmutableLegalEntity.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
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
  void testBuilderFromWithProvenanceProvider4() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationship.builder();

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
  void testBuilderFromWithProvenanceProvider5() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationship.builder();

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
    Builder builderResult = ImmutableLegalEntityRelationship.builder();

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
    Builder builderResult = ImmutableLegalEntityRelationship.builder();
    Optional<Long> id = Optional.of(42L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#isReadOnly(boolean)}.
   *
   * <p>Method under test: {@link Builder#isReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test Builder isReadOnly(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isReadOnly(boolean)"})
  void testBuilderIsReadOnly() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationship.builder();

    // Act
    Builder actualIsReadOnlyResult = builderResult.isReadOnly(true);

    // Assert
    assertSame(builderResult, actualIsReadOnlyResult);
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
    Builder builderResult = ImmutableLegalEntityRelationship.builder();

    // Act
    Builder actualLastUpdatedByResult = builderResult.lastUpdatedBy("2020-03-01");

    // Assert
    assertSame(builderResult, actualLastUpdatedByResult);
  }

  /**
   * Test Builder {@link Builder#legalEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#legalEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder legalEntityReference(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.legalEntityReference(EntityReference)"})
  void testBuilderLegalEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationship.builder();

    // Act
    Builder actualLegalEntityReferenceResult =
        builderResult.legalEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualLegalEntityReferenceResult);
  }

  /**
   * Test Builder {@link Builder#relationshipKindId(Long)}.
   *
   * <p>Method under test: {@link Builder#relationshipKindId(Long)}
   */
  @Test
  @DisplayName("Test Builder relationshipKindId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.relationshipKindId(Long)"})
  void testBuilderRelationshipKindId() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationship.builder();

    // Act
    Builder actualRelationshipKindIdResult = builderResult.relationshipKindId(1L);

    // Assert
    assertSame(builderResult, actualRelationshipKindIdResult);
  }

  /**
   * Test Builder {@link Builder#targetEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#targetEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder targetEntityReference(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.targetEntityReference(EntityReference)"})
  void testBuilderTargetEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationship.builder();

    // Act
    Builder actualTargetEntityReferenceResult =
        builderResult.targetEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualTargetEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#copyOf(LegalEntityRelationship)}.
   *
   * <ul>
   *   <li>Then legalEntityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#copyOf(LegalEntityRelationship)}
   */
  @Test
  @DisplayName(
      "Test copyOf(LegalEntityRelationship); then legalEntityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationship ImmutableLegalEntityRelationship.copyOf(LegalEntityRelationship)"
  })
  void testCopyOf_thenLegalEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship instance =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableLegalEntityRelationship actualCopyOfResult =
        ImmutableLegalEntityRelationship.copyOf(instance);

    // Assert
    EntityReference legalEntityReferenceResult = actualCopyOfResult.legalEntityReference();
    assertTrue(legalEntityReferenceResult instanceof ImmutableEntityReference);
    EntityReference targetEntityReferenceResult = actualCopyOfResult.targetEntityReference();
    assertTrue(targetEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(
        "The characteristics of someone or something", legalEntityReferenceResult.description());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.relationshipKindId().longValue());
    assertEquals(1L, legalEntityReferenceResult.id());
    assertEquals(EntityKind.ALL, legalEntityReferenceResult.kind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, legalEntityReferenceResult.entityLifecycleStatus());
    assertFalse(actualCopyOfResult.isReadOnly());
    assertEquals(legalEntityReferenceResult, targetEntityReferenceResult);
    assertSame(ofResult, actualCopyOfResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#equals(Object)}, and {@link
   * ImmutableLegalEntityRelationship#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLegalEntityRelationship#equals(Object)}
   *   <li>{@link ImmutableLegalEntityRelationship#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationship.equals(Object)",
    "int ImmutableLegalEntityRelationship.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship immutableLegalEntityRelationship =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder lastUpdatedByResult2 =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult2 =
        lastUpdatedByResult2
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship immutableLegalEntityRelationship2 =
        relationshipKindIdResult2
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableLegalEntityRelationship, immutableLegalEntityRelationship2);
    assertEquals(
        immutableLegalEntityRelationship.hashCode(), immutableLegalEntityRelationship2.hashCode());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#equals(Object)}, and {@link
   * ImmutableLegalEntityRelationship#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLegalEntityRelationship#equals(Object)}
   *   <li>{@link ImmutableLegalEntityRelationship#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationship.equals(Object)",
    "int ImmutableLegalEntityRelationship.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship immutableLegalEntityRelationship =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableLegalEntityRelationship, immutableLegalEntityRelationship);
    int expectedHashCodeResult = immutableLegalEntityRelationship.hashCode();
    assertEquals(expectedHashCodeResult, immutableLegalEntityRelationship.hashCode());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationship.equals(Object)",
    "int ImmutableLegalEntityRelationship.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("Provenance")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship immutableLegalEntityRelationship =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder lastUpdatedByResult2 =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult2 =
        lastUpdatedByResult2
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);

    // Act and Assert
    assertNotEquals(
        immutableLegalEntityRelationship,
        relationshipKindIdResult2
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationship.equals(Object)",
    "int ImmutableLegalEntityRelationship.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship immutableLegalEntityRelationship =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder lastUpdatedByResult2 =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult2 =
        lastUpdatedByResult2
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);

    // Act and Assert
    assertNotEquals(
        immutableLegalEntityRelationship,
        relationshipKindIdResult2
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationship.equals(Object)",
    "int ImmutableLegalEntityRelationship.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship immutableLegalEntityRelationship =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder lastUpdatedByResult2 =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult2 =
        lastUpdatedByResult2
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);

    // Act and Assert
    assertNotEquals(
        immutableLegalEntityRelationship,
        relationshipKindIdResult2
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationship.equals(Object)",
    "int ImmutableLegalEntityRelationship.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship immutableLegalEntityRelationship =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder lastUpdatedByResult2 =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult2 =
        lastUpdatedByResult2
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);

    // Act and Assert
    assertNotEquals(
        immutableLegalEntityRelationship,
        relationshipKindIdResult2
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationship.equals(Object)",
    "int ImmutableLegalEntityRelationship.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020/03/01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship immutableLegalEntityRelationship =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder lastUpdatedByResult2 =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult2 =
        lastUpdatedByResult2
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);

    // Act and Assert
    assertNotEquals(
        immutableLegalEntityRelationship,
        relationshipKindIdResult2
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationship.equals(Object)",
    "int ImmutableLegalEntityRelationship.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship immutableLegalEntityRelationship =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder lastUpdatedByResult2 =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult2 =
        lastUpdatedByResult2
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);

    // Act and Assert
    assertNotEquals(
        immutableLegalEntityRelationship,
        relationshipKindIdResult2
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationship.equals(Object)",
    "int ImmutableLegalEntityRelationship.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("2020-03-01")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship immutableLegalEntityRelationship =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder lastUpdatedByResult2 =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult2 =
        lastUpdatedByResult2
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);

    // Act and Assert
    assertNotEquals(
        immutableLegalEntityRelationship,
        relationshipKindIdResult2
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationship.equals(Object)",
    "int ImmutableLegalEntityRelationship.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(2L);
    ImmutableLegalEntityRelationship immutableLegalEntityRelationship =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder lastUpdatedByResult2 =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult2 =
        lastUpdatedByResult2
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);

    // Act and Assert
    assertNotEquals(
        immutableLegalEntityRelationship,
        relationshipKindIdResult2
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationship.equals(Object)",
    "int ImmutableLegalEntityRelationship.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship immutableLegalEntityRelationship =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder lastUpdatedByResult2 =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult2 =
        lastUpdatedByResult2
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);

    // Act and Assert
    assertNotEquals(
        immutableLegalEntityRelationship,
        relationshipKindIdResult2
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationship.equals(Object)",
    "int ImmutableLegalEntityRelationship.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);

    // Act and Assert
    assertNotEquals(
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationship.equals(Object)",
    "int ImmutableLegalEntityRelationship.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);

    // Act and Assert
    assertNotEquals(
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        "Different type to ImmutableLegalEntityRelationship");
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#externalId()}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableLegalEntityRelationship.externalId()"})
  void testExternalId() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);

    // Act
    Optional<String> actualExternalIdResult =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
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
   *   <li>{@link ImmutableLegalEntityRelationship#description()}
   *   <li>{@link ImmutableLegalEntityRelationship#lastUpdatedBy()}
   *   <li>{@link ImmutableLegalEntityRelationship#legalEntityReference()}
   *   <li>{@link ImmutableLegalEntityRelationship#relationshipKindId()}
   *   <li>{@link ImmutableLegalEntityRelationship#targetEntityReference()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableLegalEntityRelationship.description()",
    "String ImmutableLegalEntityRelationship.lastUpdatedBy()",
    "EntityReference ImmutableLegalEntityRelationship.legalEntityReference()",
    "Long ImmutableLegalEntityRelationship.relationshipKindId()",
    "EntityReference ImmutableLegalEntityRelationship.targetEntityReference()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship immutableLegalEntityRelationship =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    String actualDescriptionResult = immutableLegalEntityRelationship.description();
    String actualLastUpdatedByResult = immutableLegalEntityRelationship.lastUpdatedBy();
    EntityReference actualLegalEntityReferenceResult =
        immutableLegalEntityRelationship.legalEntityReference();
    Long actualRelationshipKindIdResult = immutableLegalEntityRelationship.relationshipKindId();
    EntityReference actualTargetEntityReferenceResult =
        immutableLegalEntityRelationship.targetEntityReference();

    // Assert
    assertTrue(actualLegalEntityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualTargetEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualLastUpdatedByResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1L, actualRelationshipKindIdResult.longValue());
    assertEquals(actualLegalEntityReferenceResult, actualTargetEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#id()}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableLegalEntityRelationship.id()"})
  void testId() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);

    // Act
    Optional<Long> actualIdResult =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#isReadOnly()}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#isReadOnly()}
   */
  @Test
  @DisplayName("Test isReadOnly()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableLegalEntityRelationship.isReadOnly()"})
  void testIsReadOnly() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);

    // Act and Assert
    assertFalse(
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .isReadOnly());
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
   * Test Json {@link Json#isReadOnly()}.
   *
   * <p>Method under test: {@link Json#isReadOnly()}
   */
  @Test
  @DisplayName("Test Json isReadOnly()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isReadOnly()"})
  void testJsonIsReadOnly() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isReadOnly());
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
   * Test Json {@link Json#legalEntityReference()}.
   *
   * <p>Method under test: {@link Json#legalEntityReference()}
   */
  @Test
  @DisplayName("Test Json legalEntityReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.legalEntityReference()"})
  void testJsonLegalEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().legalEntityReference());
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
    assertNull(actualJson.relationshipKindId);
    assertNull(actualJson.description);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.provenance);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.kind);
    assertNull(actualJson.legalEntityReference);
    assertNull(actualJson.targetEntityReference);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.isReadOnly);
    assertFalse(actualJson.isReadOnlyIsSet);
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
   * Test Json {@link Json#relationshipKindId()}.
   *
   * <p>Method under test: {@link Json#relationshipKindId()}
   */
  @Test
  @DisplayName("Test Json relationshipKindId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.relationshipKindId()"})
  void testJsonRelationshipKindId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().relationshipKindId());
  }

  /**
   * Test Json {@link Json#setIsReadOnly(boolean)}.
   *
   * <p>Method under test: {@link Json#setIsReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsReadOnly(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setIsReadOnly(boolean)"})
  void testJsonSetIsReadOnly() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsReadOnly(true);

    // Assert
    assertTrue(json.isReadOnly);
    assertTrue(json.isReadOnlyIsSet);
  }

  /**
   * Test Json {@link Json#targetEntityReference()}.
   *
   * <p>Method under test: {@link Json#targetEntityReference()}
   */
  @Test
  @DisplayName("Test Json targetEntityReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.targetEntityReference()"})
  void testJsonTargetEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().targetEntityReference());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#kind()}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ImmutableLegalEntityRelationship.kind()"})
  void testKind() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);

    // Act and Assert
    assertEquals(
        EntityKind.ALL,
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .kind());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableLegalEntityRelationship.lastUpdatedAt()"})
  void testLastUpdatedAt() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);

    // Act
    LocalDateTime actualLastUpdatedAtResult =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .lastUpdatedAt();

    // Assert
    assertEquals("00:00", actualLastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualLastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#provenance()}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableLegalEntityRelationship.provenance()"})
  void testProvenance() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);

    // Act and Assert
    assertEquals(
        "Provenance",
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .provenance());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#toString()}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableLegalEntityRelationship.toString()"})
  void testToString() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);

    // Act and Assert
    assertEquals(
        "LegalEntityRelationship{id=1, provenance=Provenance, lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy"
            + "=2020-03-01, externalId=42, isReadOnly=false, legalEntityReference=EntityReference{kind=ALL, id=1,"
            + " entityLifecycleStatus=ACTIVE}, relationshipKindId=1, targetEntityReference=EntityReference{kind=ALL,"
            + " id=1, entityLifecycleStatus=ACTIVE}, kind=ALL}",
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationship ImmutableLegalEntityRelationship.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship immutableLegalEntityRelationship =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableLegalEntityRelationship actualWithDescriptionResult =
        immutableLegalEntityRelationship.withDescription("42");

    // Assert
    assertEquals(immutableLegalEntityRelationship, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationship ImmutableLegalEntityRelationship.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("42")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship immutableLegalEntityRelationship =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableLegalEntityRelationship actualWithDescriptionResult =
        immutableLegalEntityRelationship.withDescription("42");

    // Assert
    assertSame(immutableLegalEntityRelationship, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationship ImmutableLegalEntityRelationship.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship immutableLegalEntityRelationship =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableLegalEntityRelationship actualWithExternalIdResult =
        immutableLegalEntityRelationship.withExternalId(optional);

    // Assert
    assertSame(immutableLegalEntityRelationship, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationship ImmutableLegalEntityRelationship.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional2() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("External Id")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship immutableLegalEntityRelationship =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableLegalEntityRelationship actualWithExternalIdResult =
        immutableLegalEntityRelationship.withExternalId(optional);

    // Assert
    EntityReference legalEntityReferenceResult = actualWithExternalIdResult.legalEntityReference();
    assertTrue(legalEntityReferenceResult instanceof ImmutableEntityReference);
    EntityReference targetEntityReferenceResult =
        actualWithExternalIdResult.targetEntityReference();
    assertTrue(targetEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithExternalIdResult.lastUpdatedBy());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", legalEntityReferenceResult.description());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(1L, actualWithExternalIdResult.relationshipKindId().longValue());
    assertEquals(1L, legalEntityReferenceResult.id());
    assertEquals(EntityKind.ALL, legalEntityReferenceResult.kind());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, legalEntityReferenceResult.entityLifecycleStatus());
    assertFalse(actualWithExternalIdResult.isReadOnly());
    assertEquals(legalEntityReferenceResult, targetEntityReferenceResult);
    assertSame(ofResult, actualWithExternalIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationship ImmutableLegalEntityRelationship.withExternalId(String)"
  })
  void testWithExternalIdWithValue() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);

    // Act
    ImmutableLegalEntityRelationship actualWithExternalIdResult =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    EntityReference legalEntityReferenceResult = actualWithExternalIdResult.legalEntityReference();
    assertTrue(legalEntityReferenceResult instanceof ImmutableEntityReference);
    EntityReference targetEntityReferenceResult =
        actualWithExternalIdResult.targetEntityReference();
    assertTrue(targetEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithExternalIdResult.lastUpdatedBy());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", legalEntityReferenceResult.description());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(1L, actualWithExternalIdResult.relationshipKindId().longValue());
    assertEquals(1L, legalEntityReferenceResult.id());
    assertEquals(EntityKind.ALL, legalEntityReferenceResult.kind());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, legalEntityReferenceResult.entityLifecycleStatus());
    assertFalse(actualWithExternalIdResult.isReadOnly());
    assertEquals(legalEntityReferenceResult, targetEntityReferenceResult);
    assertSame(ofResult, actualWithExternalIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationship ImmutableLegalEntityRelationship.withExternalId(String)"
  })
  void testWithExternalIdWithValue2() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship immutableLegalEntityRelationship =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableLegalEntityRelationship actualWithExternalIdResult =
        immutableLegalEntityRelationship.withExternalId("42");

    // Assert
    assertSame(immutableLegalEntityRelationship, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationship ImmutableLegalEntityRelationship.withId(Optional)"
  })
  void testWithIdWithOptional() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship immutableLegalEntityRelationship =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableLegalEntityRelationship actualWithIdResult =
        immutableLegalEntityRelationship.withId(optional);

    // Assert
    assertSame(immutableLegalEntityRelationship, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then legalEntityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; then legalEntityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationship ImmutableLegalEntityRelationship.withId(Optional)"
  })
  void testWithIdWithOptional_thenLegalEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship immutableLegalEntityRelationship =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableLegalEntityRelationship actualWithIdResult =
        immutableLegalEntityRelationship.withId(optional);

    // Assert
    EntityReference legalEntityReferenceResult = actualWithIdResult.legalEntityReference();
    assertTrue(legalEntityReferenceResult instanceof ImmutableEntityReference);
    EntityReference targetEntityReferenceResult = actualWithIdResult.targetEntityReference();
    assertTrue(targetEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", legalEntityReferenceResult.description());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1L, actualWithIdResult.relationshipKindId().longValue());
    assertEquals(1L, legalEntityReferenceResult.id());
    assertEquals(EntityKind.ALL, legalEntityReferenceResult.kind());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, legalEntityReferenceResult.entityLifecycleStatus());
    assertFalse(actualWithIdResult.isReadOnly());
    assertEquals(legalEntityReferenceResult, targetEntityReferenceResult);
    assertSame(ofResult, actualWithIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationship ImmutableLegalEntityRelationship.withId(long)"
  })
  void testWithIdWithValue() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship immutableLegalEntityRelationship =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableLegalEntityRelationship actualWithIdResult =
        immutableLegalEntityRelationship.withId(1L);

    // Assert
    assertSame(immutableLegalEntityRelationship, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>Then legalEntityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; then legalEntityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationship ImmutableLegalEntityRelationship.withId(long)"
  })
  void testWithIdWithValue_thenLegalEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);

    // Act
    ImmutableLegalEntityRelationship actualWithIdResult =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withId(42L);

    // Assert
    EntityReference legalEntityReferenceResult = actualWithIdResult.legalEntityReference();
    assertTrue(legalEntityReferenceResult instanceof ImmutableEntityReference);
    EntityReference targetEntityReferenceResult = actualWithIdResult.targetEntityReference();
    assertTrue(targetEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", legalEntityReferenceResult.description());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1L, actualWithIdResult.relationshipKindId().longValue());
    assertEquals(1L, legalEntityReferenceResult.id());
    assertEquals(EntityKind.ALL, legalEntityReferenceResult.kind());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, legalEntityReferenceResult.entityLifecycleStatus());
    assertFalse(actualWithIdResult.isReadOnly());
    assertEquals(legalEntityReferenceResult, targetEntityReferenceResult);
    assertSame(ofResult, actualWithIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#withIsReadOnly(boolean)}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#withIsReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test withIsReadOnly(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationship ImmutableLegalEntityRelationship.withIsReadOnly(boolean)"
  })
  void testWithIsReadOnly() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship immutableLegalEntityRelationship =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableLegalEntityRelationship actualWithIsReadOnlyResult =
        immutableLegalEntityRelationship.withIsReadOnly(false);

    // Assert
    assertSame(immutableLegalEntityRelationship, actualWithIsReadOnlyResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#withIsReadOnly(boolean)}.
   *
   * <ul>
   *   <li>Then legalEntityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#withIsReadOnly(boolean)}
   */
  @Test
  @DisplayName(
      "Test withIsReadOnly(boolean); then legalEntityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationship ImmutableLegalEntityRelationship.withIsReadOnly(boolean)"
  })
  void testWithIsReadOnly_thenLegalEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);

    // Act
    ImmutableLegalEntityRelationship actualWithIsReadOnlyResult =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withIsReadOnly(true);

    // Assert
    EntityReference legalEntityReferenceResult = actualWithIsReadOnlyResult.legalEntityReference();
    assertTrue(legalEntityReferenceResult instanceof ImmutableEntityReference);
    EntityReference targetEntityReferenceResult =
        actualWithIsReadOnlyResult.targetEntityReference();
    assertTrue(targetEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithIsReadOnlyResult.lastUpdatedBy());
    assertEquals("Provenance", actualWithIsReadOnlyResult.provenance());
    assertEquals(
        "The characteristics of someone or something", legalEntityReferenceResult.description());
    assertEquals(
        "The characteristics of someone or something", actualWithIsReadOnlyResult.description());
    assertEquals(1L, actualWithIsReadOnlyResult.relationshipKindId().longValue());
    assertEquals(1L, legalEntityReferenceResult.id());
    assertEquals(EntityKind.ALL, legalEntityReferenceResult.kind());
    assertEquals(EntityKind.ALL, actualWithIsReadOnlyResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, legalEntityReferenceResult.entityLifecycleStatus());
    assertTrue(actualWithIsReadOnlyResult.isReadOnly());
    assertEquals(legalEntityReferenceResult, targetEntityReferenceResult);
    assertSame(ofResult, actualWithIsReadOnlyResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationship ImmutableLegalEntityRelationship.withKind(EntityKind)"
  })
  void testWithKind() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship immutableLegalEntityRelationship =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableLegalEntityRelationship actualWithKindResult =
        immutableLegalEntityRelationship.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableLegalEntityRelationship, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then legalEntityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#withKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test withKind(EntityKind); then legalEntityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationship ImmutableLegalEntityRelationship.withKind(EntityKind)"
  })
  void testWithKind_thenLegalEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);

    // Act
    ImmutableLegalEntityRelationship actualWithKindResult =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    EntityReference legalEntityReferenceResult = actualWithKindResult.legalEntityReference();
    assertTrue(legalEntityReferenceResult instanceof ImmutableEntityReference);
    EntityReference targetEntityReferenceResult = actualWithKindResult.targetEntityReference();
    assertTrue(targetEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithKindResult.lastUpdatedBy());
    assertEquals("Provenance", actualWithKindResult.provenance());
    assertEquals(
        "The characteristics of someone or something", legalEntityReferenceResult.description());
    assertEquals("The characteristics of someone or something", actualWithKindResult.description());
    assertEquals(1L, actualWithKindResult.relationshipKindId().longValue());
    assertEquals(1L, legalEntityReferenceResult.id());
    assertEquals(EntityKind.ALL, legalEntityReferenceResult.kind());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, legalEntityReferenceResult.entityLifecycleStatus());
    assertFalse(actualWithKindResult.isReadOnly());
    assertEquals(legalEntityReferenceResult, targetEntityReferenceResult);
    assertSame(ofResult, actualWithKindResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationship ImmutableLegalEntityRelationship.withLastUpdatedAt(LocalDateTime)"
  })
  void testWithLastUpdatedAt() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship immutableLegalEntityRelationship =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableLegalEntityRelationship actualWithLastUpdatedAtResult =
        immutableLegalEntityRelationship.withLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableLegalEntityRelationship, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationship ImmutableLegalEntityRelationship.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("42");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship immutableLegalEntityRelationship =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableLegalEntityRelationship actualWithLastUpdatedByResult =
        immutableLegalEntityRelationship.withLastUpdatedBy("42");

    // Assert
    assertSame(immutableLegalEntityRelationship, actualWithLastUpdatedByResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#withLastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>Then legalEntityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName(
      "Test withLastUpdatedBy(String); then legalEntityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationship ImmutableLegalEntityRelationship.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy_thenLegalEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);

    // Act
    ImmutableLegalEntityRelationship actualWithLastUpdatedByResult =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withLastUpdatedBy("42");

    // Assert
    EntityReference legalEntityReferenceResult =
        actualWithLastUpdatedByResult.legalEntityReference();
    assertTrue(legalEntityReferenceResult instanceof ImmutableEntityReference);
    EntityReference targetEntityReferenceResult =
        actualWithLastUpdatedByResult.targetEntityReference();
    assertTrue(targetEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithLastUpdatedByResult.lastUpdatedBy());
    assertEquals("Provenance", actualWithLastUpdatedByResult.provenance());
    assertEquals(
        "The characteristics of someone or something", legalEntityReferenceResult.description());
    assertEquals(
        "The characteristics of someone or something", actualWithLastUpdatedByResult.description());
    assertEquals(1L, actualWithLastUpdatedByResult.relationshipKindId().longValue());
    assertEquals(1L, legalEntityReferenceResult.id());
    assertEquals(EntityKind.ALL, legalEntityReferenceResult.kind());
    assertEquals(EntityKind.ALL, actualWithLastUpdatedByResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, legalEntityReferenceResult.entityLifecycleStatus());
    assertFalse(actualWithLastUpdatedByResult.isReadOnly());
    assertEquals(legalEntityReferenceResult, targetEntityReferenceResult);
    assertSame(ofResult, actualWithLastUpdatedByResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#withLegalEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableLegalEntityRelationship#withLegalEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withLegalEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationship ImmutableLegalEntityRelationship.withLegalEntityReference(EntityReference)"
  })
  void testWithLegalEntityReference() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship immutableLegalEntityRelationship =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableLegalEntityRelationship actualWithLegalEntityReferenceResult =
        immutableLegalEntityRelationship.withLegalEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableLegalEntityRelationship, actualWithLegalEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationship ImmutableLegalEntityRelationship.withProvenance(String)"
  })
  void testWithProvenance() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("42")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship immutableLegalEntityRelationship =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableLegalEntityRelationship actualWithProvenanceResult =
        immutableLegalEntityRelationship.withProvenance("42");

    // Assert
    assertSame(immutableLegalEntityRelationship, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then legalEntityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#withProvenance(String)}
   */
  @Test
  @DisplayName(
      "Test withProvenance(String); then legalEntityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationship ImmutableLegalEntityRelationship.withProvenance(String)"
  })
  void testWithProvenance_thenLegalEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);

    // Act
    ImmutableLegalEntityRelationship actualWithProvenanceResult =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withProvenance("42");

    // Assert
    EntityReference legalEntityReferenceResult = actualWithProvenanceResult.legalEntityReference();
    assertTrue(legalEntityReferenceResult instanceof ImmutableEntityReference);
    EntityReference targetEntityReferenceResult =
        actualWithProvenanceResult.targetEntityReference();
    assertTrue(targetEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithProvenanceResult.lastUpdatedBy());
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals(
        "The characteristics of someone or something", legalEntityReferenceResult.description());
    assertEquals(
        "The characteristics of someone or something", actualWithProvenanceResult.description());
    assertEquals(1L, actualWithProvenanceResult.relationshipKindId().longValue());
    assertEquals(1L, legalEntityReferenceResult.id());
    assertEquals(EntityKind.ALL, legalEntityReferenceResult.kind());
    assertEquals(EntityKind.ALL, actualWithProvenanceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, legalEntityReferenceResult.entityLifecycleStatus());
    assertFalse(actualWithProvenanceResult.isReadOnly());
    assertEquals(legalEntityReferenceResult, targetEntityReferenceResult);
    assertSame(ofResult, actualWithProvenanceResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#withRelationshipKindId(Long)}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#withRelationshipKindId(Long)}
   */
  @Test
  @DisplayName("Test withRelationshipKindId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationship ImmutableLegalEntityRelationship.withRelationshipKindId(Long)"
  })
  void testWithRelationshipKindId() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);

    // Act
    ImmutableLegalEntityRelationship actualWithRelationshipKindIdResult =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withRelationshipKindId(42L);

    // Assert
    EntityReference legalEntityReferenceResult =
        actualWithRelationshipKindIdResult.legalEntityReference();
    assertTrue(legalEntityReferenceResult instanceof ImmutableEntityReference);
    EntityReference targetEntityReferenceResult =
        actualWithRelationshipKindIdResult.targetEntityReference();
    assertTrue(targetEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithRelationshipKindIdResult.lastUpdatedBy());
    assertEquals("Provenance", actualWithRelationshipKindIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", legalEntityReferenceResult.description());
    assertEquals(
        "The characteristics of someone or something",
        actualWithRelationshipKindIdResult.description());
    assertEquals(1L, legalEntityReferenceResult.id());
    assertEquals(42L, actualWithRelationshipKindIdResult.relationshipKindId().longValue());
    assertEquals(EntityKind.ALL, legalEntityReferenceResult.kind());
    assertEquals(EntityKind.ALL, actualWithRelationshipKindIdResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, legalEntityReferenceResult.entityLifecycleStatus());
    assertFalse(actualWithRelationshipKindIdResult.isReadOnly());
    assertEquals(legalEntityReferenceResult, targetEntityReferenceResult);
    assertSame(ofResult, actualWithRelationshipKindIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#withRelationshipKindId(Long)}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationship#withRelationshipKindId(Long)}
   */
  @Test
  @DisplayName("Test withRelationshipKindId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationship ImmutableLegalEntityRelationship.withRelationshipKindId(Long)"
  })
  void testWithRelationshipKindId2() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship immutableLegalEntityRelationship =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableLegalEntityRelationship actualWithRelationshipKindIdResult =
        immutableLegalEntityRelationship.withRelationshipKindId(1L);

    // Assert
    assertSame(immutableLegalEntityRelationship, actualWithRelationshipKindIdResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationship#withTargetEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableLegalEntityRelationship#withTargetEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withTargetEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationship ImmutableLegalEntityRelationship.withTargetEntityReference(EntityReference)"
  })
  void testWithTargetEntityReference() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    ImmutableLegalEntityRelationship immutableLegalEntityRelationship =
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableLegalEntityRelationship actualWithTargetEntityReferenceResult =
        immutableLegalEntityRelationship.withTargetEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableLegalEntityRelationship, actualWithTargetEntityReferenceResult);
  }
}
