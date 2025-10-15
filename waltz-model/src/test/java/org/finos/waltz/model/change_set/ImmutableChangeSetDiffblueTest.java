package org.finos.waltz.model.change_set;

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
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagram;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramKind;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.ImmutableApplication;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.change_set.ImmutableChangeSet.Builder;
import org.finos.waltz.model.change_set.ImmutableChangeSet.Json;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.rating.RagRating;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableChangeSetDiffblueTest {
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
   *   <li>{@link Builder#kind(EntityKind)}
   *   <li>{@link Builder#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link Builder#parentEntity(EntityReference)}
   *   <li>{@link Builder#plannedDate(LocalDateTime)}
   *   <li>{@link Builder#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeSet Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.entityLifecycleStatus(EntityLifecycleStatus)",
    "Builder Builder.externalId(String)",
    "Builder Builder.kind(EntityKind)",
    "Builder Builder.lastUpdatedAt(LocalDateTime)",
    "Builder Builder.parentEntity(EntityReference)",
    "Builder Builder.plannedDate(LocalDateTime)",
    "Builder Builder.provenance(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualExternalIdResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.of(1L);
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    Builder actualNameResult =
        actualIdResult
            .id(id)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(lastUpdatedAt)
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    Builder actualParentEntityResult = actualNameResult.parentEntity(parentEntity);
    Builder actualPlannedDateResult =
        actualParentEntityResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay());
    Optional<? extends LocalDateTime> plannedDate =
        Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    ImmutableChangeSet actualImmutableChangeSet =
        actualPlannedDateResult.plannedDate(plannedDate).provenance("Provenance").build();

    // Assert
    assertEquals("2020-03-01", actualImmutableChangeSet.lastUpdatedBy());
    assertEquals("Name", actualImmutableChangeSet.name());
    assertEquals("Provenance", actualImmutableChangeSet.provenance());
    assertEquals(
        "The characteristics of someone or something", actualImmutableChangeSet.description());
    assertEquals(EntityKind.ALL, actualImmutableChangeSet.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualImmutableChangeSet.entityLifecycleStatus());
    assertSame(lastUpdatedAt, actualImmutableChangeSet.lastUpdatedAt());
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
    Builder builderResult = ImmutableChangeSet.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act
    Builder actualExternalIdResult = builderResult.externalId(externalId);

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#from(ChangeSet)} with {@code ChangeSet}.
   *
   * <p>Method under test: {@link Builder#from(ChangeSet)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeSet) with 'ChangeSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ChangeSet)"})
  void testBuilderFromWithChangeSet() {
    // Arrange
    Builder builderResult = ImmutableChangeSet.builder();

    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet instance =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableChangeSet actualImmutableChangeSet = builderResult.build();
    assertEquals(instance, actualImmutableChangeSet);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ChangeSet)} with {@code ChangeSet}.
   *
   * <p>Method under test: {@link Builder#from(ChangeSet)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeSet) with 'ChangeSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ChangeSet)"})
  void testBuilderFromWithChangeSet2() {
    // Arrange
    Builder builderResult = ImmutableChangeSet.builder();

    Builder nameResult =
        ImmutableChangeSet.builder()
            .description(null)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet instance =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableChangeSet actualImmutableChangeSet = builderResult.build();
    assertEquals(instance, actualImmutableChangeSet);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ChangeSet)} with {@code ChangeSet}.
   *
   * <p>Method under test: {@link Builder#from(ChangeSet)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeSet) with 'ChangeSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ChangeSet)"})
  void testBuilderFromWithChangeSet3() {
    // Arrange
    Builder builderResult = ImmutableChangeSet.builder();

    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    Optional<? extends EntityReference> parentEntity = Optional.empty();
    ImmutableChangeSet instance =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableChangeSet actualImmutableChangeSet = builderResult.build();
    assertEquals(instance, actualImmutableChangeSet);
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
    Builder builderResult = ImmutableChangeSet.builder();

    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet instance =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableChangeSet actualImmutableChangeSet =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableChangeSet);
    ImmutableChangeSet actualImmutableChangeSet2 = builderResult.build();
    assertEquals(instance, actualImmutableChangeSet2);
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
    Builder builderResult = ImmutableChangeSet.builder();

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
    Builder builderResult = ImmutableChangeSet.builder();

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
    Builder builderResult = ImmutableChangeSet.builder();

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
    Builder builderResult = ImmutableChangeSet.builder();

    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet instance =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableChangeSet actualImmutableChangeSet =
        builderResult.from((EntityKindProvider) instance).build();
    assertEquals(instance, actualImmutableChangeSet);
    ImmutableChangeSet actualImmutableChangeSet2 = builderResult.build();
    assertEquals(instance, actualImmutableChangeSet2);
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
    Builder builderResult = ImmutableChangeSet.builder();

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
    Builder builderResult = ImmutableChangeSet.builder();

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
    Builder builderResult = ImmutableChangeSet.builder();

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
    Builder builderResult = ImmutableChangeSet.builder();

    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet instance =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableChangeSet actualImmutableChangeSet =
        builderResult.from((EntityLifecycleStatusProvider) instance).build();
    assertEquals(instance, actualImmutableChangeSet);
    ImmutableChangeSet actualImmutableChangeSet2 = builderResult.build();
    assertEquals(instance, actualImmutableChangeSet2);
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
    Builder builderResult = ImmutableChangeSet.builder();

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
  void testBuilderFromWithEntityLifecycleStatusProvider4() {
    // Arrange
    Builder builderResult = ImmutableChangeSet.builder();

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
  void testBuilderFromWithEntityLifecycleStatusProvider5() {
    // Arrange
    Builder builderResult = ImmutableChangeSet.builder();

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
  void testBuilderFromWithEntityLifecycleStatusProvider6() {
    // Arrange
    Builder builderResult = ImmutableChangeSet.builder();

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
    Builder builderResult = ImmutableChangeSet.builder();

    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet instance =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableChangeSet actualImmutableChangeSet =
        builderResult.from((ExternalIdProvider) instance).build();
    assertEquals(instance, actualImmutableChangeSet);
    ImmutableChangeSet actualImmutableChangeSet2 = builderResult.build();
    assertEquals(instance, actualImmutableChangeSet2);
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
    Builder builderResult = ImmutableChangeSet.builder();

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
    Builder builderResult = ImmutableChangeSet.builder();

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
    Builder builderResult = ImmutableChangeSet.builder();

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
    Builder builderResult = ImmutableChangeSet.builder();

    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet instance =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableChangeSet actualImmutableChangeSet = builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableChangeSet);
    ImmutableChangeSet actualImmutableChangeSet2 = builderResult.build();
    assertEquals(instance, actualImmutableChangeSet2);
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
    Builder builderResult = ImmutableChangeSet.builder();

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
    Builder builderResult = ImmutableChangeSet.builder();

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
    Builder builderResult = ImmutableChangeSet.builder();

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
    Builder builderResult = ImmutableChangeSet.builder();

    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet instance =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableChangeSet actualImmutableChangeSet =
        builderResult.from((LastUpdatedProvider) instance).build();
    assertEquals(instance, actualImmutableChangeSet);
    ImmutableChangeSet actualImmutableChangeSet2 = builderResult.build();
    assertEquals(instance, actualImmutableChangeSet2);
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
    Builder builderResult = ImmutableChangeSet.builder();

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
    Builder builderResult = ImmutableChangeSet.builder();

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
    Builder builderResult = ImmutableChangeSet.builder();

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
    Builder builderResult = ImmutableChangeSet.builder();

    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet instance =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableChangeSet actualImmutableChangeSet =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableChangeSet);
    ImmutableChangeSet actualImmutableChangeSet2 = builderResult.build();
    assertEquals(instance, actualImmutableChangeSet2);
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
    Builder builderResult = ImmutableChangeSet.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableChangeSet.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
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
    Builder builderResult = ImmutableChangeSet.builder();

    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet instance =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableChangeSet actualImmutableChangeSet =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableChangeSet);
    ImmutableChangeSet actualImmutableChangeSet2 = builderResult.build();
    assertEquals(instance, actualImmutableChangeSet2);
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
    Builder builderResult = ImmutableChangeSet.builder();

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
    ImmutableChangeSet immutableChangeSet = builderResult.build();
    assertEquals("2020-03-01", immutableChangeSet.lastUpdatedBy());
    assertEquals("Name", immutableChangeSet.name());
    assertEquals("Provenance", immutableChangeSet.provenance());
    assertEquals("The characteristics of someone or something", immutableChangeSet.description());
    assertEquals(EntityKind.CHANGE_SET, actualFromResult.build().kind());
    assertEquals(EntityKind.CHANGE_SET, immutableChangeSet.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, immutableChangeSet.entityLifecycleStatus());
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
    Builder builderResult = ImmutableChangeSet.builder();

    Builder nameResult =
        ImmutableChangeSet.builder()
            .description(null)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet instance =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableChangeSet actualImmutableChangeSet =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableChangeSet);
    ImmutableChangeSet actualImmutableChangeSet2 = builderResult.build();
    assertEquals(instance, actualImmutableChangeSet2);
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
    Builder builderResult = ImmutableChangeSet.builder();

    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    Optional<? extends EntityReference> parentEntity = Optional.empty();
    ImmutableChangeSet instance =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableChangeSet actualImmutableChangeSet =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableChangeSet);
    ImmutableChangeSet actualImmutableChangeSet2 = builderResult.build();
    assertEquals(instance, actualImmutableChangeSet2);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <ul>
   *   <li>Then builder build kind is {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'; then builder build kind is 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider_thenBuilderBuildKindIsAll() {
    // Arrange
    Builder builderResult = ImmutableChangeSet.builder();

    // Act
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
    ImmutableChangeSet immutableChangeSet = builderResult.build();
    assertEquals("2020-03-01", immutableChangeSet.lastUpdatedBy());
    assertEquals("Name", immutableChangeSet.name());
    assertEquals("Provenance", immutableChangeSet.provenance());
    assertEquals("The characteristics of someone or something", immutableChangeSet.description());
    assertEquals(EntityKind.ALL, immutableChangeSet.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, immutableChangeSet.entityLifecycleStatus());
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <ul>
   *   <li>Then return build description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'; then return build description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider_thenReturnBuildDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutableChangeSet.builder();

    // Act and Assert
    ImmutableChangeSet immutableChangeSet =
        builderResult
            .from(
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
                        .build())
            .build();
    assertNull(immutableChangeSet.description());
    ImmutableChangeSet immutableChangeSet2 = builderResult.build();
    assertNull(immutableChangeSet2.description());
    assertEquals(EntityKind.CHANGE_SET, immutableChangeSet.kind());
    assertEquals(EntityKind.CHANGE_SET, immutableChangeSet2.kind());
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
    Builder builderResult = ImmutableChangeSet.builder();

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
    Builder builderResult = ImmutableChangeSet.builder();
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
    Builder builderResult = ImmutableChangeSet.builder();

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
    Builder builderResult = ImmutableChangeSet.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#parentEntity(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#parentEntity(Optional)}
   */
  @Test
  @DisplayName("Test Builder parentEntity(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parentEntity(Optional)"})
  void testBuilderParentEntityWithOptional() {
    // Arrange
    Builder builderResult = ImmutableChangeSet.builder();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);

    // Act
    Builder actualParentEntityResult = builderResult.parentEntity(parentEntity);

    // Assert
    assertSame(builderResult, actualParentEntityResult);
  }

  /**
   * Test Builder {@link Builder#plannedDate(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#plannedDate(Optional)}
   */
  @Test
  @DisplayName("Test Builder plannedDate(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.plannedDate(Optional)"})
  void testBuilderPlannedDateWithOptional() {
    // Arrange
    Builder builderResult = ImmutableChangeSet.builder();
    Optional<? extends LocalDateTime> plannedDate =
        Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    Builder actualPlannedDateResult = builderResult.plannedDate(plannedDate);

    // Assert
    assertSame(builderResult, actualPlannedDateResult);
  }

  /**
   * Test {@link ImmutableChangeSet#copyOf(ChangeSet)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeSet#copyOf(ChangeSet)}
   */
  @Test
  @DisplayName("Test copyOf(ChangeSet); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeSet ImmutableChangeSet.copyOf(ChangeSet)"})
  void testCopyOf_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet instance =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableChangeSet actualCopyOfResult = ImmutableChangeSet.copyOf(instance);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableChangeSet#entityLifecycleStatus()}.
   *
   * <p>Method under test: {@link ImmutableChangeSet#entityLifecycleStatus()}
   */
  @Test
  @DisplayName("Test entityLifecycleStatus()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityLifecycleStatus ImmutableChangeSet.entityLifecycleStatus()"})
  void testEntityLifecycleStatus() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);

    // Act and Assert
    assertEquals(
        EntityLifecycleStatus.ACTIVE,
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableChangeSet#equals(Object)}, and {@link ImmutableChangeSet#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableChangeSet#equals(Object)}
   *   <li>{@link ImmutableChangeSet#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeSet.equals(Object)",
    "int ImmutableChangeSet.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet immutableChangeSet =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    Builder nameResult2 =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity2 = Optional.of(immutableEntityReference2);
    ImmutableChangeSet immutableChangeSet2 =
        nameResult2
            .parentEntity(parentEntity2)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertEquals(immutableChangeSet, immutableChangeSet2);
    assertEquals(immutableChangeSet.hashCode(), immutableChangeSet2.hashCode());
  }

  /**
   * Test {@link ImmutableChangeSet#equals(Object)}, and {@link ImmutableChangeSet#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableChangeSet#equals(Object)}
   *   <li>{@link ImmutableChangeSet#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeSet.equals(Object)",
    "int ImmutableChangeSet.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet immutableChangeSet =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertEquals(immutableChangeSet, immutableChangeSet);
    int expectedHashCodeResult = immutableChangeSet.hashCode();
    assertEquals(expectedHashCodeResult, immutableChangeSet.hashCode());
  }

  /**
   * Test {@link ImmutableChangeSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeSet.equals(Object)",
    "int ImmutableChangeSet.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet immutableChangeSet =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    Builder nameResult2 =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity2 = Optional.of(immutableEntityReference2);

    // Act and Assert
    assertNotEquals(
        immutableChangeSet,
        nameResult2
            .parentEntity(parentEntity2)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableChangeSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeSet.equals(Object)",
    "int ImmutableChangeSet.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet immutableChangeSet =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    Builder nameResult2 =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity2 = Optional.of(immutableEntityReference2);

    // Act and Assert
    assertNotEquals(
        immutableChangeSet,
        nameResult2
            .parentEntity(parentEntity2)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableChangeSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeSet.equals(Object)",
    "int ImmutableChangeSet.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(2L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet immutableChangeSet =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    Builder nameResult2 =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity2 = Optional.of(immutableEntityReference2);

    // Act and Assert
    assertNotEquals(
        immutableChangeSet,
        nameResult2
            .parentEntity(parentEntity2)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableChangeSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeSet.equals(Object)",
    "int ImmutableChangeSet.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet immutableChangeSet =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    Builder nameResult2 =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity2 = Optional.of(immutableEntityReference2);

    // Act and Assert
    assertNotEquals(
        immutableChangeSet,
        nameResult2
            .parentEntity(parentEntity2)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableChangeSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeSet.equals(Object)",
    "int ImmutableChangeSet.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet immutableChangeSet =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    Builder nameResult2 =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity2 = Optional.of(immutableEntityReference2);

    // Act and Assert
    assertNotEquals(
        immutableChangeSet,
        nameResult2
            .parentEntity(parentEntity2)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableChangeSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeSet.equals(Object)",
    "int ImmutableChangeSet.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020/03/01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet immutableChangeSet =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    Builder nameResult2 =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity2 = Optional.of(immutableEntityReference2);

    // Act and Assert
    assertNotEquals(
        immutableChangeSet,
        nameResult2
            .parentEntity(parentEntity2)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableChangeSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeSet.equals(Object)",
    "int ImmutableChangeSet.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("2020-03-01");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet immutableChangeSet =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    Builder nameResult2 =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity2 = Optional.of(immutableEntityReference2);

    // Act and Assert
    assertNotEquals(
        immutableChangeSet,
        nameResult2
            .parentEntity(parentEntity2)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableChangeSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeSet.equals(Object)",
    "int ImmutableChangeSet.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet immutableChangeSet =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    Builder nameResult2 =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity2 = Optional.of(immutableEntityReference2);

    // Act and Assert
    assertNotEquals(
        immutableChangeSet,
        nameResult2
            .parentEntity(parentEntity2)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableChangeSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeSet.equals(Object)",
    "int ImmutableChangeSet.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet immutableChangeSet =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.now().atStartOfDay())
            .provenance("Provenance")
            .build();

    Builder nameResult2 =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity2 = Optional.of(immutableEntityReference2);

    // Act and Assert
    assertNotEquals(
        immutableChangeSet,
        nameResult2
            .parentEntity(parentEntity2)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableChangeSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeSet.equals(Object)",
    "int ImmutableChangeSet.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet immutableChangeSet =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Name")
            .build();

    Builder nameResult2 =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity2 = Optional.of(immutableEntityReference2);

    // Act and Assert
    assertNotEquals(
        immutableChangeSet,
        nameResult2
            .parentEntity(parentEntity2)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableChangeSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeSet.equals(Object)",
    "int ImmutableChangeSet.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);

    // Act and Assert
    assertNotEquals(
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableChangeSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeSet.equals(Object)",
    "int ImmutableChangeSet.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);

    // Act and Assert
    assertNotEquals(
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build(),
        "Different type to ImmutableChangeSet");
  }

  /**
   * Test {@link ImmutableChangeSet#externalId()}.
   *
   * <p>Method under test: {@link ImmutableChangeSet#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableChangeSet.externalId()"})
  void testExternalId() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);

    // Act
    Optional<String> actualExternalIdResult =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .externalId();

    // Assert
    assertEquals("42", actualExternalIdResult.get());
    assertTrue(actualExternalIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableChangeSet#fromJson(Json)}.
   *
   * <p>Method under test: {@link ImmutableChangeSet#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeSet ImmutableChangeSet.fromJson(Json)"})
  void testFromJson() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setEntityLifecycleStatus(null);
    json.setName("lastUpdatedBy");
    json.setDescription(null);
    json.setLastUpdatedAt(null);
    json.setLastUpdatedBy("Json");
    json.setExternalId(null);
    json.setProvenance(null);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> parentEntity = Optional.of(immutableEntityReference);
    json.setParentEntity(parentEntity);
    json.setPlannedDate(null);
    json.setKind(null);

    // Act
    ImmutableChangeSet actualFromJsonResult = ImmutableChangeSet.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("lastUpdatedBy", actualFromJsonResult.name());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.CHANGE_SET, actualFromJsonResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualFromJsonResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableChangeSet#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   *   <li>When {@link Json} (default constructor) EntityLifecycleStatus is {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeSet#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'ACTIVE'; when Json (default constructor) EntityLifecycleStatus is 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeSet ImmutableChangeSet.fromJson(Json)"})
  void testFromJson_givenActive_whenJsonEntityLifecycleStatusIsActive() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setEntityLifecycleStatus(EntityLifecycleStatus.ACTIVE);
    json.setName("lastUpdatedBy");
    json.setDescription(null);
    json.setLastUpdatedAt(null);
    json.setLastUpdatedBy("Json");
    json.setExternalId(null);
    json.setProvenance(null);
    json.setParentEntity(null);
    json.setPlannedDate(null);
    json.setKind(null);

    // Act
    ImmutableChangeSet actualFromJsonResult = ImmutableChangeSet.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("lastUpdatedBy", actualFromJsonResult.name());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.CHANGE_SET, actualFromJsonResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualFromJsonResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableChangeSet#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   *   <li>When {@link Json} (default constructor) Kind is {@code ALL}.
   *   <li>Then return kind is {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeSet#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'ALL'; when Json (default constructor) Kind is 'ALL'; then return kind is 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeSet ImmutableChangeSet.fromJson(Json)"})
  void testFromJson_givenAll_whenJsonKindIsAll_thenReturnKindIsAll() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setEntityLifecycleStatus(null);
    json.setName("lastUpdatedBy");
    json.setDescription(null);
    json.setLastUpdatedAt(null);
    json.setLastUpdatedBy("Json");
    json.setExternalId(null);
    json.setProvenance(null);
    json.setParentEntity(null);
    json.setPlannedDate(null);
    json.setKind(EntityKind.ALL);

    // Act
    ImmutableChangeSet actualFromJsonResult = ImmutableChangeSet.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("lastUpdatedBy", actualFromJsonResult.name());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualFromJsonResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableChangeSet#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code lastUpdatedBy}.
   *   <li>Then return lastUpdatedBy is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeSet#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'lastUpdatedBy'; then return lastUpdatedBy is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeSet ImmutableChangeSet.fromJson(Json)"})
  void testFromJson_givenLastUpdatedBy_thenReturnLastUpdatedByIsJson() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setEntityLifecycleStatus(null);
    json.setName("lastUpdatedBy");
    json.setDescription(null);
    json.setLastUpdatedAt(null);
    json.setLastUpdatedBy("Json");
    json.setExternalId(null);
    json.setProvenance(null);
    json.setParentEntity(null);
    json.setPlannedDate(null);
    json.setKind(null);

    // Act
    ImmutableChangeSet actualFromJsonResult = ImmutableChangeSet.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("lastUpdatedBy", actualFromJsonResult.name());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.CHANGE_SET, actualFromJsonResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualFromJsonResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableChangeSet#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code name}.
   *   <li>When {@link Json} (default constructor) Provenance is {@code name}.
   *   <li>Then return provenance is {@code name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeSet#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'name'; when Json (default constructor) Provenance is 'name'; then return provenance is 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeSet ImmutableChangeSet.fromJson(Json)"})
  void testFromJson_givenName_whenJsonProvenanceIsName_thenReturnProvenanceIsName() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setEntityLifecycleStatus(null);
    json.setName("lastUpdatedBy");
    json.setDescription(null);
    json.setLastUpdatedAt(null);
    json.setLastUpdatedBy("Json");
    json.setExternalId(null);
    json.setProvenance("name");
    json.setParentEntity(null);
    json.setPlannedDate(null);
    json.setKind(null);

    // Act
    ImmutableChangeSet actualFromJsonResult = ImmutableChangeSet.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("lastUpdatedBy", actualFromJsonResult.name());
    assertEquals("name", actualFromJsonResult.provenance());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.CHANGE_SET, actualFromJsonResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualFromJsonResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableChangeSet#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of {@link LocalDate} with {@code 1970} and one and one atStartOfDay.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeSet#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given of LocalDate with '1970' and one and one atStartOfDay")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeSet ImmutableChangeSet.fromJson(Json)"})
  void testFromJson_givenOfLocalDateWith1970AndOneAndOneAtStartOfDay() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setEntityLifecycleStatus(null);
    json.setName("lastUpdatedBy");
    json.setDescription(null);
    json.setLastUpdatedAt(null);
    json.setLastUpdatedBy("Json");
    json.setExternalId(null);
    json.setProvenance(null);
    json.setParentEntity(null);
    Optional<LocalDateTime> plannedDate = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setPlannedDate(plannedDate);
    json.setKind(null);

    // Act
    ImmutableChangeSet actualFromJsonResult = ImmutableChangeSet.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("lastUpdatedBy", actualFromJsonResult.name());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.CHANGE_SET, actualFromJsonResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualFromJsonResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableChangeSet#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of {@code name}.
   *   <li>When {@link Json} (default constructor) ExternalId is of {@code name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeSet#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of 'name'; when Json (default constructor) ExternalId is of 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeSet ImmutableChangeSet.fromJson(Json)"})
  void testFromJson_givenOfName_whenJsonExternalIdIsOfName() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setEntityLifecycleStatus(null);
    json.setName("lastUpdatedBy");
    json.setDescription(null);
    json.setLastUpdatedAt(null);
    json.setLastUpdatedBy("Json");
    Optional<String> externalId = Optional.of("name");
    json.setExternalId(externalId);
    json.setProvenance(null);
    json.setParentEntity(null);
    json.setPlannedDate(null);
    json.setKind(null);

    // Act
    ImmutableChangeSet actualFromJsonResult = ImmutableChangeSet.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("lastUpdatedBy", actualFromJsonResult.name());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.CHANGE_SET, actualFromJsonResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualFromJsonResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableChangeSet#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of three.
   *   <li>When {@link Json} (default constructor) Id is of three.
   *   <li>Then return lastUpdatedBy is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeSet#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of three; when Json (default constructor) Id is of three; then return lastUpdatedBy is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeSet ImmutableChangeSet.fromJson(Json)"})
  void testFromJson_givenOfThree_whenJsonIdIsOfThree_thenReturnLastUpdatedByIsJson() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(3L);
    json.setId(id);
    json.setEntityLifecycleStatus(null);
    json.setName("lastUpdatedBy");
    json.setDescription(null);
    json.setLastUpdatedAt(null);
    json.setLastUpdatedBy("Json");
    json.setExternalId(null);
    json.setProvenance(null);
    json.setParentEntity(null);
    json.setPlannedDate(null);
    json.setKind(null);

    // Act
    ImmutableChangeSet actualFromJsonResult = ImmutableChangeSet.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("lastUpdatedBy", actualFromJsonResult.name());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.CHANGE_SET, actualFromJsonResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualFromJsonResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableChangeSet#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return description is {@code The characteristics of someone or something}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeSet#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return description is 'The characteristics of someone or something'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeSet ImmutableChangeSet.fromJson(Json)"})
  void testFromJson_thenReturnDescriptionIsTheCharacteristicsOfSomeoneOrSomething() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setEntityLifecycleStatus(null);
    json.setName("lastUpdatedBy");
    json.setDescription("The characteristics of someone or something");
    json.setLastUpdatedAt(null);
    json.setLastUpdatedBy("Json");
    json.setExternalId(null);
    json.setProvenance(null);
    json.setParentEntity(null);
    json.setPlannedDate(null);
    json.setKind(null);

    // Act
    ImmutableChangeSet actualFromJsonResult = ImmutableChangeSet.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("The characteristics of someone or something", actualFromJsonResult.description());
    assertEquals("lastUpdatedBy", actualFromJsonResult.name());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertEquals(EntityKind.CHANGE_SET, actualFromJsonResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualFromJsonResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableChangeSet#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalDate is {@link LocalDate} with {@code 1970} and one and
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeSet#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return lastUpdatedAt toLocalDate is LocalDate with '1970' and one and one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeSet ImmutableChangeSet.fromJson(Json)"})
  void testFromJson_thenReturnLastUpdatedAtToLocalDateIsLocalDateWith1970AndOneAndOne() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setEntityLifecycleStatus(null);
    json.setName("lastUpdatedBy");
    json.setDescription(null);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    json.setLastUpdatedAt(ofResult.atStartOfDay());
    json.setLastUpdatedBy("Json");
    json.setExternalId(null);
    json.setProvenance(null);
    json.setParentEntity(null);
    json.setPlannedDate(null);
    json.setKind(null);

    // Act
    ImmutableChangeSet actualFromJsonResult = ImmutableChangeSet.fromJson(json);

    // Assert
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.CHANGE_SET, actualFromJsonResult.kind());
    LocalDateTime lastUpdatedAtResult = actualFromJsonResult.lastUpdatedAt();
    assertSame(ofResult, lastUpdatedAtResult.toLocalDate());
    assertSame(json.lastUpdatedAt, lastUpdatedAtResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableChangeSet#description()}
   *   <li>{@link ImmutableChangeSet#lastUpdatedBy()}
   *   <li>{@link ImmutableChangeSet#name()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableChangeSet.description()",
    "String ImmutableChangeSet.lastUpdatedBy()",
    "String ImmutableChangeSet.name()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet immutableChangeSet =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    String actualDescriptionResult = immutableChangeSet.description();
    String actualLastUpdatedByResult = immutableChangeSet.lastUpdatedBy();

    // Assert
    assertEquals("2020-03-01", actualLastUpdatedByResult);
    assertEquals("Name", immutableChangeSet.name());
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
  }

  /**
   * Test {@link ImmutableChangeSet#id()}.
   *
   * <p>Method under test: {@link ImmutableChangeSet#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableChangeSet.id()"})
  void testId() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);

    // Act
    Optional<Long> actualIdResult =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
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
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.kind);
    assertNull(actualJson.entityLifecycleStatus);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.parentEntity.isPresent());
    assertFalse(actualJson.plannedDate.isPresent());
  }

  /**
   * Test Json {@link Json#parentEntity()}.
   *
   * <p>Method under test: {@link Json#parentEntity()}
   */
  @Test
  @DisplayName("Test Json parentEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.parentEntity()"})
  void testJsonParentEntity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().parentEntity());
  }

  /**
   * Test Json {@link Json#plannedDate()}.
   *
   * <p>Method under test: {@link Json#plannedDate()}
   */
  @Test
  @DisplayName("Test Json plannedDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.plannedDate()"})
  void testJsonPlannedDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().plannedDate());
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
   * Test {@link ImmutableChangeSet#kind()}.
   *
   * <p>Method under test: {@link ImmutableChangeSet#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ImmutableChangeSet.kind()"})
  void testKind() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);

    // Act and Assert
    assertEquals(
        EntityKind.ALL,
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .kind());
  }

  /**
   * Test {@link ImmutableChangeSet#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link ImmutableChangeSet#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableChangeSet.lastUpdatedAt()"})
  void testLastUpdatedAt() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);

    // Act
    LocalDateTime actualLastUpdatedAtResult =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
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
   * Test {@link ImmutableChangeSet#parentEntity()}.
   *
   * <p>Method under test: {@link ImmutableChangeSet#parentEntity()}
   */
  @Test
  @DisplayName("Test parentEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableChangeSet.parentEntity()"})
  void testParentEntity() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);

    // Act and Assert
    assertEquals(
        parentEntity,
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .parentEntity());
  }

  /**
   * Test {@link ImmutableChangeSet#plannedDate()}.
   *
   * <p>Method under test: {@link ImmutableChangeSet#plannedDate()}
   */
  @Test
  @DisplayName("Test plannedDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableChangeSet.plannedDate()"})
  void testPlannedDate() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    Optional<LocalDateTime> actualPlannedDateResult =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(ofResult.atStartOfDay())
            .provenance("Provenance")
            .build()
            .plannedDate();

    // Assert
    LocalDateTime getResult = actualPlannedDateResult.get();
    assertEquals("00:00", getResult.toLocalTime().toString());
    LocalDate toLocalDateResult = getResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertTrue(actualPlannedDateResult.isPresent());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableChangeSet#provenance()}.
   *
   * <p>Method under test: {@link ImmutableChangeSet#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableChangeSet.provenance()"})
  void testProvenance() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);

    // Act and Assert
    assertEquals(
        "Provenance",
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .provenance());
  }

  /**
   * Test {@link ImmutableChangeSet#toString()}.
   *
   * <p>Method under test: {@link ImmutableChangeSet#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableChangeSet.toString()"})
  void testToString() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);

    // Act and Assert
    assertEquals(
        "ChangeSet{id=1, entityLifecycleStatus=ACTIVE, name=Name, lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy"
            + "=2020-03-01, externalId=42, provenance=Provenance, parentEntity=EntityReference{kind=ALL, id=1,"
            + " entityLifecycleStatus=ACTIVE}, plannedDate=1970-01-01T00:00, kind=ALL}",
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableChangeSet#toString()}.
   *
   * <p>Method under test: {@link ImmutableChangeSet#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableChangeSet.toString()"})
  void testToString2() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    Optional<? extends EntityReference> parentEntity = Optional.empty();

    // Act and Assert
    assertEquals(
        "ChangeSet{id=1, entityLifecycleStatus=ACTIVE, name=Name, lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy"
            + "=2020-03-01, externalId=42, provenance=Provenance, plannedDate=1970-01-01T00:00, kind=ALL}",
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableChangeSet#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableChangeSet#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeSet ImmutableChangeSet.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet immutableChangeSet =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableChangeSet actualWithDescriptionResult = immutableChangeSet.withDescription("42");

    // Assert
    assertEquals(immutableChangeSet, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableChangeSet#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableChangeSet#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeSet ImmutableChangeSet.withDescription(String)"})
  void testWithDescription2() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("42")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet immutableChangeSet =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableChangeSet actualWithDescriptionResult = immutableChangeSet.withDescription("42");

    // Assert
    assertSame(immutableChangeSet, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableChangeSet#withEntityLifecycleStatus(EntityLifecycleStatus)}.
   *
   * <p>Method under test: {@link
   * ImmutableChangeSet#withEntityLifecycleStatus(EntityLifecycleStatus)}
   */
  @Test
  @DisplayName("Test withEntityLifecycleStatus(EntityLifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeSet ImmutableChangeSet.withEntityLifecycleStatus(EntityLifecycleStatus)"
  })
  void testWithEntityLifecycleStatus() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet immutableChangeSet =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableChangeSet actualWithEntityLifecycleStatusResult =
        immutableChangeSet.withEntityLifecycleStatus(EntityLifecycleStatus.ACTIVE);

    // Assert
    assertSame(immutableChangeSet, actualWithEntityLifecycleStatusResult);
  }

  /**
   * Test {@link ImmutableChangeSet#withEntityLifecycleStatus(EntityLifecycleStatus)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableChangeSet#withEntityLifecycleStatus(EntityLifecycleStatus)}
   */
  @Test
  @DisplayName(
      "Test withEntityLifecycleStatus(EntityLifecycleStatus); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeSet ImmutableChangeSet.withEntityLifecycleStatus(EntityLifecycleStatus)"
  })
  void testWithEntityLifecycleStatus_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);

    // Act
    ImmutableChangeSet actualWithEntityLifecycleStatusResult =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .withEntityLifecycleStatus(EntityLifecycleStatus.ACTIVE);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithEntityLifecycleStatusResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithEntityLifecycleStatusResult.lastUpdatedBy());
    assertEquals("Name", actualWithEntityLifecycleStatusResult.name());
    assertEquals("Provenance", actualWithEntityLifecycleStatusResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithEntityLifecycleStatusResult.description());
    assertEquals(EntityKind.ALL, actualWithEntityLifecycleStatusResult.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE,
        actualWithEntityLifecycleStatusResult.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableChangeSet#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableChangeSet#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeSet ImmutableChangeSet.withExternalId(Optional)"})
  void testWithExternalIdWithOptional() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet immutableChangeSet =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableChangeSet actualWithExternalIdResult = immutableChangeSet.withExternalId(optional);

    // Assert
    assertSame(immutableChangeSet, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableChangeSet#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeSet#withExternalId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(Optional) with 'optional'; then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeSet ImmutableChangeSet.withExternalId(Optional)"})
  void testWithExternalIdWithOptional_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet immutableChangeSet =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableChangeSet actualWithExternalIdResult = immutableChangeSet.withExternalId(optional);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithExternalIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithExternalIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithExternalIdResult.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableChangeSet#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableChangeSet#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeSet ImmutableChangeSet.withExternalId(String)"})
  void testWithExternalIdWithValue() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet immutableChangeSet =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableChangeSet actualWithExternalIdResult = immutableChangeSet.withExternalId("42");

    // Assert
    assertSame(immutableChangeSet, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableChangeSet#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeSet#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeSet ImmutableChangeSet.withExternalId(String)"})
  void testWithExternalIdWithValue_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);

    // Act
    ImmutableChangeSet actualWithExternalIdResult =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithExternalIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithExternalIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithExternalIdResult.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableChangeSet#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableChangeSet#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeSet ImmutableChangeSet.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet immutableChangeSet =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableChangeSet actualWithIdResult = immutableChangeSet.withId(optional);

    // Assert
    assertSame(immutableChangeSet, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableChangeSet#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeSet#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeSet ImmutableChangeSet.withId(Optional)"})
  void testWithIdWithOptional_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(2L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet immutableChangeSet =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableChangeSet actualWithIdResult = immutableChangeSet.withId(optional);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithIdResult.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableChangeSet#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableChangeSet#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeSet ImmutableChangeSet.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet immutableChangeSet =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableChangeSet actualWithIdResult = immutableChangeSet.withId(1L);

    // Assert
    assertSame(immutableChangeSet, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableChangeSet#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeSet#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeSet ImmutableChangeSet.withId(long)"})
  void testWithIdWithValue_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);

    // Act
    ImmutableChangeSet actualWithIdResult =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .withId(42L);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithIdResult.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableChangeSet#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableChangeSet#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeSet ImmutableChangeSet.withKind(EntityKind)"})
  void testWithKind() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet immutableChangeSet =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableChangeSet actualWithKindResult = immutableChangeSet.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableChangeSet, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableChangeSet#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeSet#withKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test withKind(EntityKind); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeSet ImmutableChangeSet.withKind(EntityKind)"})
  void testWithKind_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);

    // Act
    ImmutableChangeSet actualWithKindResult =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithKindResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithKindResult.lastUpdatedBy());
    assertEquals("Name", actualWithKindResult.name());
    assertEquals("Provenance", actualWithKindResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithKindResult.description());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithKindResult.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableChangeSet#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableChangeSet#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeSet ImmutableChangeSet.withLastUpdatedAt(LocalDateTime)"})
  void testWithLastUpdatedAt() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet immutableChangeSet =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableChangeSet actualWithLastUpdatedAtResult =
        immutableChangeSet.withLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableChangeSet, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableChangeSet#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableChangeSet#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeSet ImmutableChangeSet.withLastUpdatedBy(String)"})
  void testWithLastUpdatedBy() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("42")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet immutableChangeSet =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableChangeSet actualWithLastUpdatedByResult = immutableChangeSet.withLastUpdatedBy("42");

    // Assert
    assertSame(immutableChangeSet, actualWithLastUpdatedByResult);
  }

  /**
   * Test {@link ImmutableChangeSet#withLastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeSet#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName(
      "Test withLastUpdatedBy(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeSet ImmutableChangeSet.withLastUpdatedBy(String)"})
  void testWithLastUpdatedBy_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);

    // Act
    ImmutableChangeSet actualWithLastUpdatedByResult =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .withLastUpdatedBy("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithLastUpdatedByResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithLastUpdatedByResult.lastUpdatedBy());
    assertEquals("Name", actualWithLastUpdatedByResult.name());
    assertEquals("Provenance", actualWithLastUpdatedByResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithLastUpdatedByResult.description());
    assertEquals(EntityKind.ALL, actualWithLastUpdatedByResult.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE, actualWithLastUpdatedByResult.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableChangeSet#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableChangeSet#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeSet ImmutableChangeSet.withName(String)"})
  void testWithName() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("42");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet immutableChangeSet =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableChangeSet actualWithNameResult = immutableChangeSet.withName("42");

    // Assert
    assertSame(immutableChangeSet, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableChangeSet#withName(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeSet#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeSet ImmutableChangeSet.withName(String)"})
  void testWithName_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);

    // Act
    ImmutableChangeSet actualWithNameResult =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .withName("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithNameResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithNameResult.lastUpdatedBy());
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Provenance", actualWithNameResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(EntityKind.ALL, actualWithNameResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithNameResult.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableChangeSet#withParentEntity(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableChangeSet#withParentEntity(Optional)}
   */
  @Test
  @DisplayName("Test withParentEntity(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeSet ImmutableChangeSet.withParentEntity(Optional)"})
  void testWithParentEntityWithOptional() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet immutableChangeSet =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> optional = Optional.of(immutableEntityReference2);

    // Act
    ImmutableChangeSet actualWithParentEntityResult = immutableChangeSet.withParentEntity(optional);

    // Assert
    assertEquals(immutableChangeSet, actualWithParentEntityResult);
  }

  /**
   * Test {@link ImmutableChangeSet#withParentEntity(EntityReference)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableChangeSet#withParentEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test withParentEntity(EntityReference) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeSet ImmutableChangeSet.withParentEntity(EntityReference)"})
  void testWithParentEntityWithValue() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet immutableChangeSet =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableChangeSet actualWithParentEntityResult =
        immutableChangeSet.withParentEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableChangeSet, actualWithParentEntityResult);
  }

  /**
   * Test {@link ImmutableChangeSet#withPlannedDate(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableChangeSet#withPlannedDate(Optional)}
   */
  @Test
  @DisplayName("Test withPlannedDate(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeSet ImmutableChangeSet.withPlannedDate(Optional)"})
  void testWithPlannedDateWithOptional() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet immutableChangeSet =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();
    Optional<? extends LocalDateTime> optional =
        Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    ImmutableChangeSet actualWithPlannedDateResult = immutableChangeSet.withPlannedDate(optional);

    // Assert
    assertEquals(immutableChangeSet, actualWithPlannedDateResult);
  }

  /**
   * Test {@link ImmutableChangeSet#withPlannedDate(LocalDateTime)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableChangeSet#withPlannedDate(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withPlannedDate(LocalDateTime) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeSet ImmutableChangeSet.withPlannedDate(LocalDateTime)"})
  void testWithPlannedDateWithValue() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet immutableChangeSet =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableChangeSet actualWithPlannedDateResult =
        immutableChangeSet.withPlannedDate(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableChangeSet, actualWithPlannedDateResult);
  }

  /**
   * Test {@link ImmutableChangeSet#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableChangeSet#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeSet ImmutableChangeSet.withProvenance(String)"})
  void testWithProvenance() {
    // Arrange
    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);
    ImmutableChangeSet immutableChangeSet =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("42")
            .build();

    // Act
    ImmutableChangeSet actualWithProvenanceResult = immutableChangeSet.withProvenance("42");

    // Assert
    assertSame(immutableChangeSet, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableChangeSet#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeSet#withProvenance(String)}
   */
  @Test
  @DisplayName(
      "Test withProvenance(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeSet ImmutableChangeSet.withProvenance(String)"})
  void testWithProvenance_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder nameResult =
        ImmutableChangeSet.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> parentEntity = Optional.of(immutableEntityReference);

    // Act
    ImmutableChangeSet actualWithProvenanceResult =
        nameResult
            .parentEntity(parentEntity)
            .plannedDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build()
            .withProvenance("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithProvenanceResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithProvenanceResult.lastUpdatedBy());
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals("Name", actualWithProvenanceResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithProvenanceResult.description());
    assertEquals(EntityKind.ALL, actualWithProvenanceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithProvenanceResult.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }
}
