package org.finos.waltz.model.measurable;

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
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityLifecycleStatusProvider;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.ExternalParentIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableEnumValue;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ParentIdProvider;
import org.finos.waltz.model.PositionProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagram;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramKind;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.ImmutableApplication;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.measurable.ImmutableMeasurable.Builder;
import org.finos.waltz.model.measurable.ImmutableMeasurable.Json;
import org.finos.waltz.model.measurable_category.ImmutableMeasurableCategory;
import org.finos.waltz.model.rating.RagRating;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#entityLifecycleStatus(EntityLifecycleStatus)}
   *   <li>{@link Builder#externalId(String)}
   *   <li>{@link Builder#externalParentId(String)}
   *   <li>{@link Builder#kind(EntityKind)}
   *   <li>{@link Builder#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link Builder#organisationalUnitId(Long)}
   *   <li>{@link Builder#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurable Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.entityLifecycleStatus(EntityLifecycleStatus)",
    "Builder Builder.externalId(String)",
    "Builder Builder.externalParentId(String)",
    "Builder Builder.kind(EntityKind)",
    "Builder Builder.lastUpdatedAt(LocalDateTime)",
    "Builder Builder.organisationalUnitId(Long)",
    "Builder Builder.provenance(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualExternalIdResult =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");
    Optional<String> externalId = Optional.of("42");
    Builder actualExternalParentIdResult =
        actualExternalIdResult.externalId(externalId).externalParentId("42");
    Optional<String> externalParentId = Optional.of("42");
    Builder actualIdResult = actualExternalParentIdResult.externalParentId(externalParentId).id(1L);
    Optional<Long> id = Optional.of(42L);
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    Builder actualParentIdResult =
        actualIdResult
            .id(id)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(lastUpdatedAt)
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L);
    Optional<Long> parentId = Optional.of(42L);
    ImmutableMeasurable actualImmutableMeasurable =
        actualParentIdResult.parentId(parentId).provenance("Provenance").build();

    // Assert
    assertEquals("2020-03-01", actualImmutableMeasurable.lastUpdatedBy());
    assertEquals("Name", actualImmutableMeasurable.name());
    assertEquals("Provenance", actualImmutableMeasurable.provenance());
    assertEquals(
        "The characteristics of someone or something", actualImmutableMeasurable.description());
    assertEquals(0, actualImmutableMeasurable.position());
    assertEquals(1L, actualImmutableMeasurable.organisationalUnitId().longValue());
    assertEquals(1L, actualImmutableMeasurable.categoryId());
    assertEquals(EntityKind.ALL, actualImmutableMeasurable.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualImmutableMeasurable.entityLifecycleStatus());
    assertTrue(actualImmutableMeasurable.concrete());
    assertSame(lastUpdatedAt, actualImmutableMeasurable.lastUpdatedAt());
  }

  /**
   * Test Builder {@link Builder#categoryId(long)}.
   *
   * <p>Method under test: {@link Builder#categoryId(long)}
   */
  @Test
  @DisplayName("Test Builder categoryId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.categoryId(long)"})
  void testBuilderCategoryId() {
    // Arrange
    Builder builderResult = ImmutableMeasurable.builder();

    // Act
    Builder actualCategoryIdResult = builderResult.categoryId(1L);

    // Assert
    assertSame(builderResult, actualCategoryIdResult);
  }

  /**
   * Test Builder {@link Builder#concrete(boolean)}.
   *
   * <p>Method under test: {@link Builder#concrete(boolean)}
   */
  @Test
  @DisplayName("Test Builder concrete(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.concrete(boolean)"})
  void testBuilderConcrete() {
    // Arrange
    Builder builderResult = ImmutableMeasurable.builder();

    // Act
    Builder actualConcreteResult = builderResult.concrete(true);

    // Assert
    assertSame(builderResult, actualConcreteResult);
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
    Builder builderResult = ImmutableMeasurable.builder();
    Optional<String> externalId = Optional.of("42");

    // Act
    Builder actualExternalIdResult = builderResult.externalId(externalId);

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#externalParentId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#externalParentId(Optional)}
   */
  @Test
  @DisplayName("Test Builder externalParentId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.externalParentId(Optional)"})
  void testBuilderExternalParentIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableMeasurable.builder();
    Optional<String> externalParentId = Optional.of("42");

    // Act
    Builder actualExternalParentIdResult = builderResult.externalParentId(externalParentId);

    // Assert
    assertSame(builderResult, actualExternalParentIdResult);
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
    Builder builderResult = ImmutableMeasurable.builder();
    ImmutableMeasurable instance =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableMeasurable actualImmutableMeasurable =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableMeasurable);
    ImmutableMeasurable actualImmutableMeasurable2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurable2);
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
    Builder builderResult = ImmutableMeasurable.builder();

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
    Builder builderResult = ImmutableMeasurable.builder();

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
    Builder builderResult = ImmutableMeasurable.builder();

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
    Builder builderResult = ImmutableMeasurable.builder();
    ImmutableMeasurable instance =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableMeasurable actualImmutableMeasurable =
        builderResult.from((EntityKindProvider) instance).build();
    assertEquals(instance, actualImmutableMeasurable);
    ImmutableMeasurable actualImmutableMeasurable2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurable2);
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
    Builder builderResult = ImmutableMeasurable.builder();

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
    Builder builderResult = ImmutableMeasurable.builder();

    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Test Builder {@link Builder#from(EntityLifecycleStatusProvider)} with {@code
   * EntityLifecycleStatusProvider}.
   *
   * <p>Method under test: {@link Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityLifecycleStatusProvider) with 'EntityLifecycleStatusProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityLifecycleStatusProvider)"})
  void testBuilderFromWithEntityLifecycleStatusProvider() {
    // Arrange
    Builder builderResult = ImmutableMeasurable.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (EntityLifecycleStatusProvider)
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityLifecycleStatusProvider)} with {@code
   * EntityLifecycleStatusProvider}.
   *
   * <p>Method under test: {@link Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityLifecycleStatusProvider) with 'EntityLifecycleStatusProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityLifecycleStatusProvider)"})
  void testBuilderFromWithEntityLifecycleStatusProvider2() {
    // Arrange
    Builder builderResult = ImmutableMeasurable.builder();
    ImmutableMeasurable instance =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableMeasurable actualImmutableMeasurable =
        builderResult.from((EntityLifecycleStatusProvider) instance).build();
    assertEquals(instance, actualImmutableMeasurable);
    ImmutableMeasurable actualImmutableMeasurable2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurable2);
  }

  /**
   * Test Builder {@link Builder#from(EntityLifecycleStatusProvider)} with {@code
   * EntityLifecycleStatusProvider}.
   *
   * <p>Method under test: {@link Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityLifecycleStatusProvider) with 'EntityLifecycleStatusProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityLifecycleStatusProvider)"})
  void testBuilderFromWithEntityLifecycleStatusProvider3() {
    // Arrange
    Builder builderResult = ImmutableMeasurable.builder();
    ImmutableMeasurable instance =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(null)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableMeasurable actualImmutableMeasurable =
        builderResult.from((EntityLifecycleStatusProvider) instance).build();
    assertEquals(instance, actualImmutableMeasurable);
    ImmutableMeasurable actualImmutableMeasurable2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurable2);
  }

  /**
   * Test Builder {@link Builder#from(EntityLifecycleStatusProvider)} with {@code
   * EntityLifecycleStatusProvider}.
   *
   * <p>Method under test: {@link Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityLifecycleStatusProvider) with 'EntityLifecycleStatusProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityLifecycleStatusProvider)"})
  void testBuilderFromWithEntityLifecycleStatusProvider4() {
    // Arrange
    Builder builderResult = ImmutableMeasurable.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (EntityLifecycleStatusProvider)
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
   * Test Builder {@link Builder#from(EntityLifecycleStatusProvider)} with {@code
   * EntityLifecycleStatusProvider}.
   *
   * <p>Method under test: {@link Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityLifecycleStatusProvider) with 'EntityLifecycleStatusProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityLifecycleStatusProvider)"})
  void testBuilderFromWithEntityLifecycleStatusProvider5() {
    // Arrange
    Builder builderResult = ImmutableMeasurable.builder();

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    // Act
    Builder actualFromResult =
        builderResult.from(
            (EntityLifecycleStatusProvider)
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityLifecycleStatusProvider)} with {@code
   * EntityLifecycleStatusProvider}.
   *
   * <p>Method under test: {@link Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityLifecycleStatusProvider) with 'EntityLifecycleStatusProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityLifecycleStatusProvider)"})
  void testBuilderFromWithEntityLifecycleStatusProvider6() {
    // Arrange
    Builder builderResult = ImmutableMeasurable.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (EntityLifecycleStatusProvider)
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
   * Test Builder {@link Builder#from(EntityLifecycleStatusProvider)} with {@code
   * EntityLifecycleStatusProvider}.
   *
   * <p>Method under test: {@link Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityLifecycleStatusProvider) with 'EntityLifecycleStatusProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityLifecycleStatusProvider)"})
  void testBuilderFromWithEntityLifecycleStatusProvider7() {
    // Arrange
    Builder builderResult = ImmutableMeasurable.builder();

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.empty();

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    // Act
    Builder actualFromResult =
        builderResult.from(
            (EntityLifecycleStatusProvider)
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build());

    // Assert
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
    Builder builderResult = ImmutableMeasurable.builder();
    ImmutableMeasurable instance =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableMeasurable actualImmutableMeasurable =
        builderResult.from((ExternalIdProvider) instance).build();
    assertEquals(instance, actualImmutableMeasurable);
    ImmutableMeasurable actualImmutableMeasurable2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurable2);
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
    Builder builderResult = ImmutableMeasurable.builder();

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
    Builder builderResult = ImmutableMeasurable.builder();

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
    Builder builderResult = ImmutableMeasurable.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Test Builder {@link Builder#from(ExternalParentIdProvider)} with {@code
   * ExternalParentIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(ExternalParentIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalParentIdProvider) with 'ExternalParentIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalParentIdProvider)"})
  void testBuilderFromWithExternalParentIdProvider() {
    // Arrange
    Builder builderResult = ImmutableMeasurable.builder();
    ImmutableMeasurable instance =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableMeasurable actualImmutableMeasurable =
        builderResult.from((ExternalParentIdProvider) instance).build();
    assertEquals(instance, actualImmutableMeasurable);
    ImmutableMeasurable actualImmutableMeasurable2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurable2);
  }

  /**
   * Test Builder {@link Builder#from(ExternalParentIdProvider)} with {@code
   * ExternalParentIdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalParentIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ExternalParentIdProvider) with 'ExternalParentIdProvider'; given empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalParentIdProvider)"})
  void testBuilderFromWithExternalParentIdProvider_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableMeasurable.builder();

    ExternalParentIdProvider instance = mock(ExternalParentIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalParentId()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalParentId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalParentIdProvider)} with {@code
   * ExternalParentIdProvider}.
   *
   * <ul>
   *   <li>Given of {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalParentIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ExternalParentIdProvider) with 'ExternalParentIdProvider'; given of '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalParentIdProvider)"})
  void testBuilderFromWithExternalParentIdProvider_givenOf42() {
    // Arrange
    Builder builderResult = ImmutableMeasurable.builder();

    ExternalParentIdProvider instance = mock(ExternalParentIdProvider.class);
    Optional<String> ofResult = Optional.of("42");
    when(instance.externalParentId()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalParentId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalParentIdProvider)} with {@code
   * ExternalParentIdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalParentIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ExternalParentIdProvider) with 'ExternalParentIdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalParentIdProvider)"})
  void testBuilderFromWithExternalParentIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableMeasurable.builder();

    ExternalParentIdProvider instance = mock(ExternalParentIdProvider.class);
    when(instance.externalParentId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalParentId();
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
    Builder builderResult = ImmutableMeasurable.builder();
    ImmutableMeasurable instance =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableMeasurable actualImmutableMeasurable =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableMeasurable);
    ImmutableMeasurable actualImmutableMeasurable2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurable2);
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
    Builder builderResult = ImmutableMeasurable.builder();

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
    Builder builderResult = ImmutableMeasurable.builder();

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
    Builder builderResult = ImmutableMeasurable.builder();

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
    Builder builderResult = ImmutableMeasurable.builder();
    ImmutableMeasurable instance =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableMeasurable actualImmutableMeasurable =
        builderResult.from((LastUpdatedProvider) instance).build();
    assertEquals(instance, actualImmutableMeasurable);
    ImmutableMeasurable actualImmutableMeasurable2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurable2);
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
    Builder builderResult = ImmutableMeasurable.builder();

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
    Builder builderResult = ImmutableMeasurable.builder();

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
    Builder builderResult = ImmutableMeasurable.builder();

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
   * Test Builder {@link Builder#from(Measurable)} with {@code Measurable}.
   *
   * <p>Method under test: {@link Builder#from(Measurable)}
   */
  @Test
  @DisplayName("Test Builder from(Measurable) with 'Measurable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Measurable)"})
  void testBuilderFromWithMeasurable() {
    // Arrange
    Builder builderResult = ImmutableMeasurable.builder();
    ImmutableMeasurable instance =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableMeasurable actualImmutableMeasurable = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableMeasurable);
    ImmutableMeasurable actualImmutableMeasurable2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurable2);
  }

  /**
   * Test Builder {@link Builder#from(Measurable)} with {@code Measurable}.
   *
   * <p>Method under test: {@link Builder#from(Measurable)}
   */
  @Test
  @DisplayName("Test Builder from(Measurable) with 'Measurable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Measurable)"})
  void testBuilderFromWithMeasurable2() {
    // Arrange
    Builder builderResult = ImmutableMeasurable.builder();
    ImmutableMeasurable instance =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(null)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableMeasurable actualImmutableMeasurable = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableMeasurable);
    ImmutableMeasurable actualImmutableMeasurable2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurable2);
  }

  /**
   * Test Builder {@link Builder#from(Measurable)} with {@code Measurable}.
   *
   * <p>Method under test: {@link Builder#from(Measurable)}
   */
  @Test
  @DisplayName("Test Builder from(Measurable) with 'Measurable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Measurable)"})
  void testBuilderFromWithMeasurable3() {
    // Arrange
    Builder builderResult = ImmutableMeasurable.builder();
    ImmutableMeasurable instance =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(false)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableMeasurable actualImmutableMeasurable = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableMeasurable);
    ImmutableMeasurable actualImmutableMeasurable2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurable2);
  }

  /**
   * Test Builder {@link Builder#from(Measurable)} with {@code Measurable}.
   *
   * <p>Method under test: {@link Builder#from(Measurable)}
   */
  @Test
  @DisplayName("Test Builder from(Measurable) with 'Measurable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Measurable)"})
  void testBuilderFromWithMeasurable4() {
    // Arrange
    Builder builderResult = ImmutableMeasurable.builder();
    ImmutableMeasurable instance =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description(null)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableMeasurable actualImmutableMeasurable = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableMeasurable);
    ImmutableMeasurable actualImmutableMeasurable2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurable2);
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
    Builder builderResult = ImmutableMeasurable.builder();
    ImmutableMeasurable instance =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableMeasurable actualImmutableMeasurable =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableMeasurable);
    ImmutableMeasurable actualImmutableMeasurable2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurable2);
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
    Builder builderResult = ImmutableMeasurable.builder();
    ImmutableMeasurable instance =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(null)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableMeasurable actualImmutableMeasurable =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableMeasurable);
    ImmutableMeasurable actualImmutableMeasurable2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurable2);
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
  void testBuilderFromWithNameProvider3() {
    // Arrange
    Builder builderResult = ImmutableMeasurable.builder();
    ImmutableMeasurable instance =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(false)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableMeasurable actualImmutableMeasurable =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableMeasurable);
    ImmutableMeasurable actualImmutableMeasurable2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurable2);
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
  void testBuilderFromWithNameProvider4() {
    // Arrange
    Builder builderResult = ImmutableMeasurable.builder();
    ImmutableMeasurable instance =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description(null)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableMeasurable actualImmutableMeasurable =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableMeasurable);
    ImmutableMeasurable actualImmutableMeasurable2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurable2);
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
    Builder builderResult = ImmutableMeasurable.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ParentIdProvider)} with {@code ParentIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(ParentIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ParentIdProvider) with 'ParentIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ParentIdProvider)"})
  void testBuilderFromWithParentIdProvider() {
    // Arrange
    Builder builderResult = ImmutableMeasurable.builder();
    ImmutableMeasurable instance =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableMeasurable actualImmutableMeasurable =
        builderResult.from((ParentIdProvider) instance).build();
    assertEquals(instance, actualImmutableMeasurable);
    ImmutableMeasurable actualImmutableMeasurable2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurable2);
  }

  /**
   * Test Builder {@link Builder#from(ParentIdProvider)} with {@code ParentIdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ParentIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ParentIdProvider) with 'ParentIdProvider'; given empty; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ParentIdProvider)"})
  void testBuilderFromWithParentIdProvider_givenEmpty_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurable.builder();

    ParentIdProvider instance = mock(ParentIdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.parentId()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).parentId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ParentIdProvider)} with {@code ParentIdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ParentIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ParentIdProvider) with 'ParentIdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ParentIdProvider)"})
  void testBuilderFromWithParentIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableMeasurable.builder();

    ParentIdProvider instance = mock(ParentIdProvider.class);
    when(instance.parentId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).parentId();
  }

  /**
   * Test Builder {@link Builder#from(PositionProvider)} with {@code PositionProvider}.
   *
   * <p>Method under test: {@link Builder#from(PositionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(PositionProvider) with 'PositionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PositionProvider)"})
  void testBuilderFromWithPositionProvider() {
    // Arrange
    Builder builderResult = ImmutableMeasurable.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (PositionProvider)
                ImmutableEnumValue.builder()
                    .description("The characteristics of someone or something")
                    .icon("Icon")
                    .iconColor("Icon Color")
                    .key("Key")
                    .name("Name")
                    .type("Type")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PositionProvider)} with {@code PositionProvider}.
   *
   * <p>Method under test: {@link Builder#from(PositionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(PositionProvider) with 'PositionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PositionProvider)"})
  void testBuilderFromWithPositionProvider2() {
    // Arrange
    Builder builderResult = ImmutableMeasurable.builder();
    ImmutableMeasurable instance =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableMeasurable actualImmutableMeasurable =
        builderResult.from((PositionProvider) instance).build();
    assertEquals(instance, actualImmutableMeasurable);
    ImmutableMeasurable actualImmutableMeasurable2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurable2);
  }

  /**
   * Test Builder {@link Builder#from(PositionProvider)} with {@code PositionProvider}.
   *
   * <p>Method under test: {@link Builder#from(PositionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(PositionProvider) with 'PositionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PositionProvider)"})
  void testBuilderFromWithPositionProvider3() {
    // Arrange
    Builder builderResult = ImmutableMeasurable.builder();
    ImmutableMeasurable instance =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(null)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableMeasurable actualImmutableMeasurable =
        builderResult.from((PositionProvider) instance).build();
    assertEquals(instance, actualImmutableMeasurable);
    ImmutableMeasurable actualImmutableMeasurable2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurable2);
  }

  /**
   * Test Builder {@link Builder#from(PositionProvider)} with {@code PositionProvider}.
   *
   * <p>Method under test: {@link Builder#from(PositionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(PositionProvider) with 'PositionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PositionProvider)"})
  void testBuilderFromWithPositionProvider4() {
    // Arrange
    Builder builderResult = ImmutableMeasurable.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (PositionProvider)
                ImmutableMeasurableCategory.builder()
                    .allowPrimaryRatings(true)
                    .constrainingAssessmentDefinitionId(1L)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .icon("Icon")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .ratingEditorRole("Rating Editor Role")
                    .ratingSchemeId(1L)
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PositionProvider)} with {@code PositionProvider}.
   *
   * <p>Method under test: {@link Builder#from(PositionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(PositionProvider) with 'PositionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PositionProvider)"})
  void testBuilderFromWithPositionProvider5() {
    // Arrange
    Builder builderResult = ImmutableMeasurable.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (PositionProvider)
                ImmutableMeasurableCategory.builder()
                    .allowPrimaryRatings(true)
                    .constrainingAssessmentDefinitionId(1L)
                    .description(null)
                    .externalId("42")
                    .icon("Icon")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .ratingEditorRole("Rating Editor Role")
                    .ratingSchemeId(1L)
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PositionProvider)} with {@code PositionProvider}.
   *
   * <p>Method under test: {@link Builder#from(PositionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(PositionProvider) with 'PositionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PositionProvider)"})
  void testBuilderFromWithPositionProvider6() {
    // Arrange
    Builder builderResult = ImmutableMeasurable.builder();
    ImmutableMeasurable instance =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(false)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableMeasurable actualImmutableMeasurable =
        builderResult.from((PositionProvider) instance).build();
    assertEquals(instance, actualImmutableMeasurable);
    ImmutableMeasurable actualImmutableMeasurable2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurable2);
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
    Builder builderResult = ImmutableMeasurable.builder();

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
    Builder builderResult = ImmutableMeasurable.builder();
    ImmutableMeasurable instance =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableMeasurable actualImmutableMeasurable =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableMeasurable);
    ImmutableMeasurable actualImmutableMeasurable2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurable2);
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
    Builder builderResult = ImmutableMeasurable.builder();
    ImmutableMeasurable instance =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(null)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableMeasurable actualImmutableMeasurable =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableMeasurable);
    ImmutableMeasurable actualImmutableMeasurable2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurable2);
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
    Builder builderResult = ImmutableMeasurable.builder();

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
    Builder builderResult = ImmutableMeasurable.builder();

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
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider6() {
    // Arrange
    Builder builderResult = ImmutableMeasurable.builder();
    ImmutableMeasurable instance =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(false)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableMeasurable actualImmutableMeasurable =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableMeasurable);
    ImmutableMeasurable actualImmutableMeasurable2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurable2);
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
    Builder builderResult = ImmutableMeasurable.builder();

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
    Builder builderResult = ImmutableMeasurable.builder();
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
    Builder builderResult = ImmutableMeasurable.builder();

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
    Builder builderResult = ImmutableMeasurable.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#parentId(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#parentId(long)}
   */
  @Test
  @DisplayName("Test Builder parentId(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parentId(long)"})
  void testBuilderParentIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableMeasurable.builder();

    // Act
    Builder actualParentIdResult = builderResult.parentId(1L);

    // Assert
    assertSame(builderResult, actualParentIdResult);
  }

  /**
   * Test Builder {@link Builder#parentId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#parentId(Optional)}
   */
  @Test
  @DisplayName("Test Builder parentId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parentId(Optional)"})
  void testBuilderParentIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableMeasurable.builder();
    Optional<Long> parentId = Optional.of(42L);

    // Act
    Builder actualParentIdResult = builderResult.parentId(parentId);

    // Assert
    assertSame(builderResult, actualParentIdResult);
  }

  /**
   * Test Builder {@link Builder#position(int)}.
   *
   * <p>Method under test: {@link Builder#position(int)}
   */
  @Test
  @DisplayName("Test Builder position(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.position(int)"})
  void testBuilderPosition() {
    // Arrange
    Builder builderResult = ImmutableMeasurable.builder();

    // Act
    Builder actualPositionResult = builderResult.position(1);

    // Assert
    assertSame(builderResult, actualPositionResult);
  }

  /**
   * Test {@link ImmutableMeasurable#copyOf(Measurable)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurable#copyOf(Measurable)}
   */
  @Test
  @DisplayName("Test copyOf(Measurable); then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurable ImmutableMeasurable.copyOf(Measurable)"})
  void testCopyOf_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableMeasurable instance =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableMeasurable actualCopyOfResult = ImmutableMeasurable.copyOf(instance);

    // Assert
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(0, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.organisationalUnitId().longValue());
    assertEquals(1L, actualCopyOfResult.categoryId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertTrue(actualCopyOfResult.concrete());
    assertSame(ofResult, actualCopyOfResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurable#entityLifecycleStatus()}.
   *
   * <p>Method under test: {@link ImmutableMeasurable#entityLifecycleStatus()}
   */
  @Test
  @DisplayName("Test entityLifecycleStatus()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityLifecycleStatus ImmutableMeasurable.entityLifecycleStatus()"})
  void testEntityLifecycleStatus() {
    // Arrange, Act and Assert
    assertEquals(
        EntityLifecycleStatus.ACTIVE,
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build()
            .entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableMeasurable#equals(Object)}, and {@link ImmutableMeasurable#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurable#equals(Object)}
   *   <li>{@link ImmutableMeasurable#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurable.equals(Object)",
    "int ImmutableMeasurable.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();
    ImmutableMeasurable immutableMeasurable2 =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertEquals(immutableMeasurable, immutableMeasurable2);
    assertEquals(immutableMeasurable.hashCode(), immutableMeasurable2.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurable#equals(Object)}, and {@link ImmutableMeasurable#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurable#equals(Object)}
   *   <li>{@link ImmutableMeasurable#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurable.equals(Object)",
    "int ImmutableMeasurable.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertEquals(immutableMeasurable, immutableMeasurable);
    int expectedHashCodeResult = immutableMeasurable.hashCode();
    assertEquals(expectedHashCodeResult, immutableMeasurable.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurable.equals(Object)",
    "int ImmutableMeasurable.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(2L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurable,
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableMeasurable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurable.equals(Object)",
    "int ImmutableMeasurable.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(false)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurable,
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableMeasurable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurable.equals(Object)",
    "int ImmutableMeasurable.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurable,
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableMeasurable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurable.equals(Object)",
    "int ImmutableMeasurable.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("Name")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurable,
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableMeasurable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurable.equals(Object)",
    "int ImmutableMeasurable.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurable,
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableMeasurable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurable.equals(Object)",
    "int ImmutableMeasurable.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(2L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurable,
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableMeasurable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurable.equals(Object)",
    "int ImmutableMeasurable.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurable,
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableMeasurable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurable.equals(Object)",
    "int ImmutableMeasurable.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurable,
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableMeasurable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurable.equals(Object)",
    "int ImmutableMeasurable.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020/03/01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurable,
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableMeasurable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurable.equals(Object)",
    "int ImmutableMeasurable.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("2020-03-01")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurable,
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableMeasurable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurable.equals(Object)",
    "int ImmutableMeasurable.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(2L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurable,
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableMeasurable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurable.equals(Object)",
    "int ImmutableMeasurable.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(2L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurable,
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableMeasurable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurable.equals(Object)",
    "int ImmutableMeasurable.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurable,
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableMeasurable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurable.equals(Object)",
    "int ImmutableMeasurable.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableMeasurable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurable.equals(Object)",
    "int ImmutableMeasurable.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build(),
        "Different type to ImmutableMeasurable");
  }

  /**
   * Test {@link ImmutableMeasurable#externalId()}.
   *
   * <p>Method under test: {@link ImmutableMeasurable#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableMeasurable.externalId()"})
  void testExternalId() {
    // Arrange and Act
    Optional<String> actualExternalIdResult =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build()
            .externalId();

    // Assert
    assertEquals("42", actualExternalIdResult.get());
    assertTrue(actualExternalIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableMeasurable#externalParentId()}.
   *
   * <p>Method under test: {@link ImmutableMeasurable#externalParentId()}
   */
  @Test
  @DisplayName("Test externalParentId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableMeasurable.externalParentId()"})
  void testExternalParentId() {
    // Arrange and Act
    Optional<String> actualExternalParentIdResult =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build()
            .externalParentId();

    // Assert
    assertEquals("42", actualExternalParentIdResult.get());
    assertTrue(actualExternalParentIdResult.isPresent());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurable#categoryId()}
   *   <li>{@link ImmutableMeasurable#concrete()}
   *   <li>{@link ImmutableMeasurable#description()}
   *   <li>{@link ImmutableMeasurable#lastUpdatedBy()}
   *   <li>{@link ImmutableMeasurable#name()}
   *   <li>{@link ImmutableMeasurable#organisationalUnitId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long ImmutableMeasurable.categoryId()",
    "boolean ImmutableMeasurable.concrete()",
    "String ImmutableMeasurable.description()",
    "String ImmutableMeasurable.lastUpdatedBy()",
    "String ImmutableMeasurable.name()",
    "Long ImmutableMeasurable.organisationalUnitId()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act
    long actualCategoryIdResult = immutableMeasurable.categoryId();
    boolean actualConcreteResult = immutableMeasurable.concrete();
    String actualDescriptionResult = immutableMeasurable.description();
    String actualLastUpdatedByResult = immutableMeasurable.lastUpdatedBy();
    String actualNameResult = immutableMeasurable.name();

    // Assert
    assertEquals("2020-03-01", actualLastUpdatedByResult);
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1L, immutableMeasurable.organisationalUnitId().longValue());
    assertEquals(1L, actualCategoryIdResult);
    assertTrue(actualConcreteResult);
  }

  /**
   * Test {@link ImmutableMeasurable#id()}.
   *
   * <p>Method under test: {@link ImmutableMeasurable#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableMeasurable.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#categoryId()}.
   *
   * <p>Method under test: {@link Json#categoryId()}
   */
  @Test
  @DisplayName("Test Json categoryId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.categoryId()"})
  void testJsonCategoryId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().categoryId());
  }

  /**
   * Test Json {@link Json#concrete()}.
   *
   * <p>Method under test: {@link Json#concrete()}
   */
  @Test
  @DisplayName("Test Json concrete()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.concrete()"})
  void testJsonConcrete() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().concrete());
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
   * Test Json {@link Json#entityLifecycleStatus()}.
   *
   * <p>Method under test: {@link Json#entityLifecycleStatus()}
   */
  @Test
  @DisplayName("Test Json entityLifecycleStatus()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityLifecycleStatus Json.entityLifecycleStatus()"})
  void testJsonEntityLifecycleStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entityLifecycleStatus());
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
   * Test Json {@link Json#externalParentId()}.
   *
   * <p>Method under test: {@link Json#externalParentId()}
   */
  @Test
  @DisplayName("Test Json externalParentId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.externalParentId()"})
  void testJsonExternalParentId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().externalParentId());
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
    assertNull(actualJson.organisationalUnitId);
    assertNull(actualJson.description);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.kind);
    assertNull(actualJson.entityLifecycleStatus);
    assertEquals(0, actualJson.position);
    assertEquals(0L, actualJson.categoryId);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.externalParentId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.parentId.isPresent());
    assertFalse(actualJson.categoryIdIsSet);
    assertFalse(actualJson.concrete);
    assertFalse(actualJson.concreteIsSet);
    assertFalse(actualJson.positionIsSet);
  }

  /**
   * Test Json {@link Json#organisationalUnitId()}.
   *
   * <p>Method under test: {@link Json#organisationalUnitId()}
   */
  @Test
  @DisplayName("Test Json organisationalUnitId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.organisationalUnitId()"})
  void testJsonOrganisationalUnitId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().organisationalUnitId());
  }

  /**
   * Test Json {@link Json#parentId()}.
   *
   * <p>Method under test: {@link Json#parentId()}
   */
  @Test
  @DisplayName("Test Json parentId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.parentId()"})
  void testJsonParentId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().parentId());
  }

  /**
   * Test Json {@link Json#position()}.
   *
   * <p>Method under test: {@link Json#position()}
   */
  @Test
  @DisplayName("Test Json position()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.position()"})
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().position());
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
   * Test Json {@link Json#setCategoryId(long)}.
   *
   * <p>Method under test: {@link Json#setCategoryId(long)}
   */
  @Test
  @DisplayName("Test Json setCategoryId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setCategoryId(long)"})
  void testJsonSetCategoryId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setCategoryId(1L);

    // Assert
    assertEquals(1L, json.categoryId);
    assertTrue(json.categoryIdIsSet);
  }

  /**
   * Test Json {@link Json#setConcrete(boolean)}.
   *
   * <p>Method under test: {@link Json#setConcrete(boolean)}
   */
  @Test
  @DisplayName("Test Json setConcrete(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setConcrete(boolean)"})
  void testJsonSetConcrete() {
    // Arrange
    Json json = new Json();

    // Act
    json.setConcrete(true);

    // Assert
    assertTrue(json.concrete);
    assertTrue(json.concreteIsSet);
  }

  /**
   * Test Json {@link Json#setPosition(int)}.
   *
   * <p>Method under test: {@link Json#setPosition(int)}
   */
  @Test
  @DisplayName("Test Json setPosition(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setPosition(int)"})
  void testJsonSetPosition() {
    // Arrange
    Json json = new Json();

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }

  /**
   * Test {@link ImmutableMeasurable#kind()}.
   *
   * <p>Method under test: {@link ImmutableMeasurable#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ImmutableMeasurable.kind()"})
  void testKind() {
    // Arrange, Act and Assert
    assertEquals(
        EntityKind.ALL,
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build()
            .kind());
  }

  /**
   * Test {@link ImmutableMeasurable#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link ImmutableMeasurable#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableMeasurable.lastUpdatedAt()"})
  void testLastUpdatedAt() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    LocalDateTime actualLastUpdatedAtResult =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
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
   * Test {@link ImmutableMeasurable#parentId()}.
   *
   * <p>Method under test: {@link ImmutableMeasurable#parentId()}
   */
  @Test
  @DisplayName("Test parentId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableMeasurable.parentId()"})
  void testParentId() {
    // Arrange and Act
    Optional<Long> actualParentIdResult =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build()
            .parentId();

    // Assert
    assertEquals(1L, actualParentIdResult.get().longValue());
    assertTrue(actualParentIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableMeasurable#position()}.
   *
   * <p>Method under test: {@link ImmutableMeasurable#position()}
   */
  @Test
  @DisplayName("Test position()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ImmutableMeasurable.position()"})
  void testPosition() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build()
            .position());
  }

  /**
   * Test {@link ImmutableMeasurable#provenance()}.
   *
   * <p>Method under test: {@link ImmutableMeasurable#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableMeasurable.provenance()"})
  void testProvenance() {
    // Arrange, Act and Assert
    assertEquals(
        "Provenance",
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build()
            .provenance());
  }

  /**
   * Test {@link ImmutableMeasurable#toString()}.
   *
   * <p>Method under test: {@link ImmutableMeasurable#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableMeasurable.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "Measurable{id=1, name=Name, parentId=1, externalId=42, entityLifecycleStatus=ACTIVE, externalParentId=42,"
            + " lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01, provenance=Provenance, position=0, categoryId=1,"
            + " concrete=true, organisationalUnitId=1, kind=ALL}",
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableMeasurable#toString()}.
   *
   * <p>Method under test: {@link ImmutableMeasurable#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableMeasurable.toString()"})
  void testToString2() {
    // Arrange, Act and Assert
    assertEquals(
        "Measurable{id=1, name=Name, parentId=1, externalId=42, entityLifecycleStatus=ACTIVE, externalParentId=42,"
            + " lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01, provenance=Provenance, position=0, categoryId=1,"
            + " concrete=true, kind=ALL}",
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(null)
            .parentId(1L)
            .provenance("Provenance")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableMeasurable#withCategoryId(long)}.
   *
   * <p>Method under test: {@link ImmutableMeasurable#withCategoryId(long)}
   */
  @Test
  @DisplayName("Test withCategoryId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurable ImmutableMeasurable.withCategoryId(long)"})
  void testWithCategoryId() {
    // Arrange
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(42L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableMeasurable actualWithCategoryIdResult = immutableMeasurable.withCategoryId(42L);

    // Assert
    assertSame(immutableMeasurable, actualWithCategoryIdResult);
  }

  /**
   * Test {@link ImmutableMeasurable#withCategoryId(long)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurable#withCategoryId(long)}
   */
  @Test
  @DisplayName("Test withCategoryId(long); then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurable ImmutableMeasurable.withCategoryId(long)"})
  void testWithCategoryId_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurable actualWithCategoryIdResult =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build()
            .withCategoryId(42L);

    // Assert
    assertEquals("2020-03-01", actualWithCategoryIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithCategoryIdResult.name());
    assertEquals("Provenance", actualWithCategoryIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithCategoryIdResult.description());
    assertEquals(0, actualWithCategoryIdResult.position());
    assertEquals(1L, actualWithCategoryIdResult.organisationalUnitId().longValue());
    assertEquals(42L, actualWithCategoryIdResult.categoryId());
    assertEquals(EntityKind.ALL, actualWithCategoryIdResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithCategoryIdResult.entityLifecycleStatus());
    assertTrue(actualWithCategoryIdResult.concrete());
    assertSame(ofResult, actualWithCategoryIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurable#withConcrete(boolean)}.
   *
   * <p>Method under test: {@link ImmutableMeasurable#withConcrete(boolean)}
   */
  @Test
  @DisplayName("Test withConcrete(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurable ImmutableMeasurable.withConcrete(boolean)"})
  void testWithConcrete() {
    // Arrange
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableMeasurable actualWithConcreteResult = immutableMeasurable.withConcrete(true);

    // Assert
    assertSame(immutableMeasurable, actualWithConcreteResult);
  }

  /**
   * Test {@link ImmutableMeasurable#withConcrete(boolean)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurable#withConcrete(boolean)}
   */
  @Test
  @DisplayName("Test withConcrete(boolean); then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurable ImmutableMeasurable.withConcrete(boolean)"})
  void testWithConcrete_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurable actualWithConcreteResult =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(false)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build()
            .withConcrete(true);

    // Assert
    assertEquals("2020-03-01", actualWithConcreteResult.lastUpdatedBy());
    assertEquals("Name", actualWithConcreteResult.name());
    assertEquals("Provenance", actualWithConcreteResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithConcreteResult.description());
    assertEquals(0, actualWithConcreteResult.position());
    assertEquals(1L, actualWithConcreteResult.organisationalUnitId().longValue());
    assertEquals(1L, actualWithConcreteResult.categoryId());
    assertEquals(EntityKind.ALL, actualWithConcreteResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithConcreteResult.entityLifecycleStatus());
    assertTrue(actualWithConcreteResult.concrete());
    assertSame(ofResult, actualWithConcreteResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurable#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableMeasurable#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurable ImmutableMeasurable.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableMeasurable actualWithDescriptionResult = immutableMeasurable.withDescription("42");

    // Assert
    assertEquals(immutableMeasurable, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableMeasurable#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableMeasurable#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurable ImmutableMeasurable.withDescription(String)"})
  void testWithDescription2() {
    // Arrange
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("42")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableMeasurable actualWithDescriptionResult = immutableMeasurable.withDescription("42");

    // Assert
    assertSame(immutableMeasurable, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableMeasurable#withEntityLifecycleStatus(EntityLifecycleStatus)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurable#withEntityLifecycleStatus(EntityLifecycleStatus)}
   */
  @Test
  @DisplayName("Test withEntityLifecycleStatus(EntityLifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurable ImmutableMeasurable.withEntityLifecycleStatus(EntityLifecycleStatus)"
  })
  void testWithEntityLifecycleStatus() {
    // Arrange
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableMeasurable actualWithEntityLifecycleStatusResult =
        immutableMeasurable.withEntityLifecycleStatus(EntityLifecycleStatus.ACTIVE);

    // Assert
    assertSame(immutableMeasurable, actualWithEntityLifecycleStatusResult);
  }

  /**
   * Test {@link ImmutableMeasurable#withEntityLifecycleStatus(EntityLifecycleStatus)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableMeasurable#withEntityLifecycleStatus(EntityLifecycleStatus)}
   */
  @Test
  @DisplayName(
      "Test withEntityLifecycleStatus(EntityLifecycleStatus); then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurable ImmutableMeasurable.withEntityLifecycleStatus(EntityLifecycleStatus)"
  })
  void testWithEntityLifecycleStatus_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurable actualWithEntityLifecycleStatusResult =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build()
            .withEntityLifecycleStatus(EntityLifecycleStatus.ACTIVE);

    // Assert
    assertEquals("2020-03-01", actualWithEntityLifecycleStatusResult.lastUpdatedBy());
    assertEquals("Name", actualWithEntityLifecycleStatusResult.name());
    assertEquals("Provenance", actualWithEntityLifecycleStatusResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithEntityLifecycleStatusResult.description());
    assertEquals(0, actualWithEntityLifecycleStatusResult.position());
    assertEquals(1L, actualWithEntityLifecycleStatusResult.organisationalUnitId().longValue());
    assertEquals(1L, actualWithEntityLifecycleStatusResult.categoryId());
    assertEquals(EntityKind.ALL, actualWithEntityLifecycleStatusResult.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE,
        actualWithEntityLifecycleStatusResult.entityLifecycleStatus());
    assertTrue(actualWithEntityLifecycleStatusResult.concrete());
    assertSame(ofResult, actualWithEntityLifecycleStatusResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurable#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableMeasurable#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurable ImmutableMeasurable.withExternalId(Optional)"})
  void testWithExternalIdWithOptional() {
    // Arrange
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableMeasurable actualWithExternalIdResult = immutableMeasurable.withExternalId(optional);

    // Assert
    assertSame(immutableMeasurable, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableMeasurable#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurable#withExternalId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(Optional) with 'optional'; then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurable ImmutableMeasurable.withExternalId(Optional)"})
  void testWithExternalIdWithOptional_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("External Id")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableMeasurable actualWithExternalIdResult = immutableMeasurable.withExternalId(optional);

    // Assert
    assertEquals("2020-03-01", actualWithExternalIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(0, actualWithExternalIdResult.position());
    assertEquals(1L, actualWithExternalIdResult.organisationalUnitId().longValue());
    assertEquals(1L, actualWithExternalIdResult.categoryId());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithExternalIdResult.entityLifecycleStatus());
    assertTrue(actualWithExternalIdResult.concrete());
    assertSame(ofResult, actualWithExternalIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurable#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableMeasurable#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurable ImmutableMeasurable.withExternalId(String)"})
  void testWithExternalIdWithValue() {
    // Arrange
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableMeasurable actualWithExternalIdResult = immutableMeasurable.withExternalId("42");

    // Assert
    assertSame(immutableMeasurable, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableMeasurable#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurable#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurable ImmutableMeasurable.withExternalId(String)"})
  void testWithExternalIdWithValue_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurable actualWithExternalIdResult =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("2020-03-01", actualWithExternalIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(0, actualWithExternalIdResult.position());
    assertEquals(1L, actualWithExternalIdResult.organisationalUnitId().longValue());
    assertEquals(1L, actualWithExternalIdResult.categoryId());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithExternalIdResult.entityLifecycleStatus());
    assertTrue(actualWithExternalIdResult.concrete());
    assertSame(ofResult, actualWithExternalIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurable#withExternalParentId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableMeasurable#withExternalParentId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalParentId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurable ImmutableMeasurable.withExternalParentId(Optional)"})
  void testWithExternalParentIdWithOptional() {
    // Arrange
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableMeasurable actualWithExternalParentIdResult =
        immutableMeasurable.withExternalParentId(optional);

    // Assert
    assertSame(immutableMeasurable, actualWithExternalParentIdResult);
  }

  /**
   * Test {@link ImmutableMeasurable#withExternalParentId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurable#withExternalParentId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withExternalParentId(Optional) with 'optional'; then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurable ImmutableMeasurable.withExternalParentId(Optional)"})
  void testWithExternalParentIdWithOptional_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("External Parent Id")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableMeasurable actualWithExternalParentIdResult =
        immutableMeasurable.withExternalParentId(optional);

    // Assert
    assertEquals("2020-03-01", actualWithExternalParentIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithExternalParentIdResult.name());
    assertEquals("Provenance", actualWithExternalParentIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithExternalParentIdResult.description());
    assertEquals(0, actualWithExternalParentIdResult.position());
    assertEquals(1L, actualWithExternalParentIdResult.organisationalUnitId().longValue());
    assertEquals(1L, actualWithExternalParentIdResult.categoryId());
    assertEquals(EntityKind.ALL, actualWithExternalParentIdResult.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE, actualWithExternalParentIdResult.entityLifecycleStatus());
    assertTrue(actualWithExternalParentIdResult.concrete());
    assertSame(ofResult, actualWithExternalParentIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurable#withExternalParentId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableMeasurable#withExternalParentId(String)}
   */
  @Test
  @DisplayName("Test withExternalParentId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurable ImmutableMeasurable.withExternalParentId(String)"})
  void testWithExternalParentIdWithValue() {
    // Arrange
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableMeasurable actualWithExternalParentIdResult =
        immutableMeasurable.withExternalParentId("42");

    // Assert
    assertSame(immutableMeasurable, actualWithExternalParentIdResult);
  }

  /**
   * Test {@link ImmutableMeasurable#withExternalParentId(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurable#withExternalParentId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalParentId(String) with 'value'; then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurable ImmutableMeasurable.withExternalParentId(String)"})
  void testWithExternalParentIdWithValue_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurable actualWithExternalParentIdResult =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build()
            .withExternalParentId("0123456789ABCDEF");

    // Assert
    assertEquals("2020-03-01", actualWithExternalParentIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithExternalParentIdResult.name());
    assertEquals("Provenance", actualWithExternalParentIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithExternalParentIdResult.description());
    assertEquals(0, actualWithExternalParentIdResult.position());
    assertEquals(1L, actualWithExternalParentIdResult.organisationalUnitId().longValue());
    assertEquals(1L, actualWithExternalParentIdResult.categoryId());
    assertEquals(EntityKind.ALL, actualWithExternalParentIdResult.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE, actualWithExternalParentIdResult.entityLifecycleStatus());
    assertTrue(actualWithExternalParentIdResult.concrete());
    assertSame(ofResult, actualWithExternalParentIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurable#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableMeasurable#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurable ImmutableMeasurable.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableMeasurable actualWithIdResult = immutableMeasurable.withId(optional);

    // Assert
    assertSame(immutableMeasurable, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableMeasurable#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of forty-two.
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurable#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; when of forty-two; then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurable ImmutableMeasurable.withId(Optional)"})
  void testWithIdWithOptional_whenOfFortyTwo_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableMeasurable actualWithIdResult = immutableMeasurable.withId(optional);

    // Assert
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(0, actualWithIdResult.position());
    assertEquals(1L, actualWithIdResult.organisationalUnitId().longValue());
    assertEquals(1L, actualWithIdResult.categoryId());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithIdResult.entityLifecycleStatus());
    assertTrue(actualWithIdResult.concrete());
    assertSame(ofResult, actualWithIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurable#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableMeasurable#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurable ImmutableMeasurable.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableMeasurable actualWithIdResult = immutableMeasurable.withId(1L);

    // Assert
    assertSame(immutableMeasurable, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableMeasurable#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurable#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; when forty-two; then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurable ImmutableMeasurable.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurable actualWithIdResult =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build()
            .withId(42L);

    // Assert
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(0, actualWithIdResult.position());
    assertEquals(1L, actualWithIdResult.organisationalUnitId().longValue());
    assertEquals(1L, actualWithIdResult.categoryId());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithIdResult.entityLifecycleStatus());
    assertTrue(actualWithIdResult.concrete());
    assertSame(ofResult, actualWithIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurable#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableMeasurable#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurable ImmutableMeasurable.withKind(EntityKind)"})
  void testWithKind() {
    // Arrange
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableMeasurable actualWithKindResult = immutableMeasurable.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableMeasurable, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableMeasurable#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurable#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind); then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurable ImmutableMeasurable.withKind(EntityKind)"})
  void testWithKind_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurable actualWithKindResult =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    assertEquals("2020-03-01", actualWithKindResult.lastUpdatedBy());
    assertEquals("Name", actualWithKindResult.name());
    assertEquals("Provenance", actualWithKindResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithKindResult.description());
    assertEquals(0, actualWithKindResult.position());
    assertEquals(1L, actualWithKindResult.organisationalUnitId().longValue());
    assertEquals(1L, actualWithKindResult.categoryId());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithKindResult.entityLifecycleStatus());
    assertTrue(actualWithKindResult.concrete());
    assertSame(ofResult, actualWithKindResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurable#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableMeasurable#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurable ImmutableMeasurable.withLastUpdatedAt(LocalDateTime)"})
  void testWithLastUpdatedAt() {
    // Arrange
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableMeasurable actualWithLastUpdatedAtResult =
        immutableMeasurable.withLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableMeasurable, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableMeasurable#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableMeasurable#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurable ImmutableMeasurable.withLastUpdatedBy(String)"})
  void testWithLastUpdatedBy() {
    // Arrange
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("42")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableMeasurable actualWithLastUpdatedByResult = immutableMeasurable.withLastUpdatedBy("42");

    // Assert
    assertSame(immutableMeasurable, actualWithLastUpdatedByResult);
  }

  /**
   * Test {@link ImmutableMeasurable#withLastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurable#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String); then return lastUpdatedBy is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurable ImmutableMeasurable.withLastUpdatedBy(String)"})
  void testWithLastUpdatedBy_thenReturnLastUpdatedByIs42() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurable actualWithLastUpdatedByResult =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build()
            .withLastUpdatedBy("42");

    // Assert
    assertEquals("42", actualWithLastUpdatedByResult.lastUpdatedBy());
    assertEquals("Name", actualWithLastUpdatedByResult.name());
    assertEquals("Provenance", actualWithLastUpdatedByResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithLastUpdatedByResult.description());
    assertEquals(0, actualWithLastUpdatedByResult.position());
    assertEquals(1L, actualWithLastUpdatedByResult.organisationalUnitId().longValue());
    assertEquals(1L, actualWithLastUpdatedByResult.categoryId());
    assertEquals(EntityKind.ALL, actualWithLastUpdatedByResult.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE, actualWithLastUpdatedByResult.entityLifecycleStatus());
    assertTrue(actualWithLastUpdatedByResult.concrete());
    assertSame(ofResult, actualWithLastUpdatedByResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurable#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableMeasurable#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurable ImmutableMeasurable.withName(String)"})
  void testWithName() {
    // Arrange
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("42")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableMeasurable actualWithNameResult = immutableMeasurable.withName("42");

    // Assert
    assertSame(immutableMeasurable, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableMeasurable#withName(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurable#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurable ImmutableMeasurable.withName(String)"})
  void testWithName_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurable actualWithNameResult =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build()
            .withName("42");

    // Assert
    assertEquals("2020-03-01", actualWithNameResult.lastUpdatedBy());
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Provenance", actualWithNameResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(0, actualWithNameResult.position());
    assertEquals(1L, actualWithNameResult.organisationalUnitId().longValue());
    assertEquals(1L, actualWithNameResult.categoryId());
    assertEquals(EntityKind.ALL, actualWithNameResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithNameResult.entityLifecycleStatus());
    assertTrue(actualWithNameResult.concrete());
    assertSame(ofResult, actualWithNameResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurable#withOrganisationalUnitId(Long)}.
   *
   * <p>Method under test: {@link ImmutableMeasurable#withOrganisationalUnitId(Long)}
   */
  @Test
  @DisplayName("Test withOrganisationalUnitId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurable ImmutableMeasurable.withOrganisationalUnitId(Long)"})
  void testWithOrganisationalUnitId() {
    // Arrange
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableMeasurable actualWithOrganisationalUnitIdResult =
        immutableMeasurable.withOrganisationalUnitId(1L);

    // Assert
    assertSame(immutableMeasurable, actualWithOrganisationalUnitIdResult);
  }

  /**
   * Test {@link ImmutableMeasurable#withOrganisationalUnitId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurable#withOrganisationalUnitId(Long)}
   */
  @Test
  @DisplayName(
      "Test withOrganisationalUnitId(Long); when forty-two; then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurable ImmutableMeasurable.withOrganisationalUnitId(Long)"})
  void testWithOrganisationalUnitId_whenFortyTwo_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurable actualWithOrganisationalUnitIdResult =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build()
            .withOrganisationalUnitId(42L);

    // Assert
    assertEquals("2020-03-01", actualWithOrganisationalUnitIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithOrganisationalUnitIdResult.name());
    assertEquals("Provenance", actualWithOrganisationalUnitIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithOrganisationalUnitIdResult.description());
    assertEquals(0, actualWithOrganisationalUnitIdResult.position());
    assertEquals(1L, actualWithOrganisationalUnitIdResult.categoryId());
    assertEquals(42L, actualWithOrganisationalUnitIdResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualWithOrganisationalUnitIdResult.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE, actualWithOrganisationalUnitIdResult.entityLifecycleStatus());
    assertTrue(actualWithOrganisationalUnitIdResult.concrete());
    assertSame(ofResult, actualWithOrganisationalUnitIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurable#withParentId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableMeasurable#withParentId(Optional)}
   */
  @Test
  @DisplayName("Test withParentId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurable ImmutableMeasurable.withParentId(Optional)"})
  void testWithParentIdWithOptional() {
    // Arrange
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableMeasurable actualWithParentIdResult = immutableMeasurable.withParentId(optional);

    // Assert
    assertSame(immutableMeasurable, actualWithParentIdResult);
  }

  /**
   * Test {@link ImmutableMeasurable#withParentId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of forty-two.
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurable#withParentId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withParentId(Optional) with 'optional'; when of forty-two; then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurable ImmutableMeasurable.withParentId(Optional)"})
  void testWithParentIdWithOptional_whenOfFortyTwo_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableMeasurable actualWithParentIdResult = immutableMeasurable.withParentId(optional);

    // Assert
    assertEquals("2020-03-01", actualWithParentIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithParentIdResult.name());
    assertEquals("Provenance", actualWithParentIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithParentIdResult.description());
    assertEquals(0, actualWithParentIdResult.position());
    assertEquals(1L, actualWithParentIdResult.organisationalUnitId().longValue());
    assertEquals(1L, actualWithParentIdResult.categoryId());
    assertEquals(EntityKind.ALL, actualWithParentIdResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithParentIdResult.entityLifecycleStatus());
    assertTrue(actualWithParentIdResult.concrete());
    assertSame(ofResult, actualWithParentIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurable#withParentId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableMeasurable#withParentId(long)}
   */
  @Test
  @DisplayName("Test withParentId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurable ImmutableMeasurable.withParentId(long)"})
  void testWithParentIdWithValue() {
    // Arrange
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableMeasurable actualWithParentIdResult = immutableMeasurable.withParentId(1L);

    // Assert
    assertSame(immutableMeasurable, actualWithParentIdResult);
  }

  /**
   * Test {@link ImmutableMeasurable#withParentId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurable#withParentId(long)}
   */
  @Test
  @DisplayName(
      "Test withParentId(long) with 'value'; when forty-two; then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurable ImmutableMeasurable.withParentId(long)"})
  void testWithParentIdWithValue_whenFortyTwo_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurable actualWithParentIdResult =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build()
            .withParentId(42L);

    // Assert
    assertEquals("2020-03-01", actualWithParentIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithParentIdResult.name());
    assertEquals("Provenance", actualWithParentIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithParentIdResult.description());
    assertEquals(0, actualWithParentIdResult.position());
    assertEquals(1L, actualWithParentIdResult.organisationalUnitId().longValue());
    assertEquals(1L, actualWithParentIdResult.categoryId());
    assertEquals(EntityKind.ALL, actualWithParentIdResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithParentIdResult.entityLifecycleStatus());
    assertTrue(actualWithParentIdResult.concrete());
    assertSame(ofResult, actualWithParentIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurable#withPosition(int)}.
   *
   * <p>Method under test: {@link ImmutableMeasurable#withPosition(int)}
   */
  @Test
  @DisplayName("Test withPosition(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurable ImmutableMeasurable.withPosition(int)"})
  void testWithPosition() {
    // Arrange
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableMeasurable actualWithPositionResult = immutableMeasurable.withPosition(0);

    // Assert
    assertSame(immutableMeasurable, actualWithPositionResult);
  }

  /**
   * Test {@link ImmutableMeasurable#withPosition(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurable#withPosition(int)}
   */
  @Test
  @DisplayName("Test withPosition(int); when forty-two; then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurable ImmutableMeasurable.withPosition(int)"})
  void testWithPosition_whenFortyTwo_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurable actualWithPositionResult =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build()
            .withPosition(42);

    // Assert
    assertEquals("2020-03-01", actualWithPositionResult.lastUpdatedBy());
    assertEquals("Name", actualWithPositionResult.name());
    assertEquals("Provenance", actualWithPositionResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithPositionResult.description());
    assertEquals(1L, actualWithPositionResult.organisationalUnitId().longValue());
    assertEquals(1L, actualWithPositionResult.categoryId());
    assertEquals(42, actualWithPositionResult.position());
    assertEquals(EntityKind.ALL, actualWithPositionResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithPositionResult.entityLifecycleStatus());
    assertTrue(actualWithPositionResult.concrete());
    assertSame(ofResult, actualWithPositionResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurable#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableMeasurable#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurable ImmutableMeasurable.withProvenance(String)"})
  void testWithProvenance() {
    // Arrange
    ImmutableMeasurable immutableMeasurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("42")
            .build();

    // Act
    ImmutableMeasurable actualWithProvenanceResult = immutableMeasurable.withProvenance("42");

    // Assert
    assertSame(immutableMeasurable, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableMeasurable#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurable#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String); then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurable ImmutableMeasurable.withProvenance(String)"})
  void testWithProvenance_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurable actualWithProvenanceResult =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build()
            .withProvenance("42");

    // Assert
    assertEquals("2020-03-01", actualWithProvenanceResult.lastUpdatedBy());
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals("Name", actualWithProvenanceResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithProvenanceResult.description());
    assertEquals(0, actualWithProvenanceResult.position());
    assertEquals(1L, actualWithProvenanceResult.organisationalUnitId().longValue());
    assertEquals(1L, actualWithProvenanceResult.categoryId());
    assertEquals(EntityKind.ALL, actualWithProvenanceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithProvenanceResult.entityLifecycleStatus());
    assertTrue(actualWithProvenanceResult.concrete());
    assertSame(ofResult, actualWithProvenanceResult.lastUpdatedAt().toLocalDate());
  }
}
