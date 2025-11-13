package org.finos.waltz.model.app_group;

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
import java.util.Optional;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityLifecycleStatusProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.IsReadOnlyProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagram;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramKind;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry.Builder;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry.Json;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.ImmutableApplication;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentRating;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.rating.RagRating;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAppGroupEntryDiffblueTest {
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
   *   <li>{@link Builder#name(String)}
   *   <li>{@link Builder#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppGroupEntry Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.entityLifecycleStatus(EntityLifecycleStatus)",
    "Builder Builder.externalId(String)",
    "Builder Builder.name(String)",
    "Builder Builder.provenance(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualExternalIdResult =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");
    Optional<String> externalId = Optional.of("42");
    Builder actualNameResult =
        actualExternalIdResult.externalId(externalId).id(1L).kind(EntityKind.ALL).name("Name");
    Optional<String> name = Optional.of("42");
    ImmutableAppGroupEntry actualImmutableAppGroupEntry =
        actualNameResult.name(name).provenance("Provenance").build();

    // Assert
    assertEquals("Provenance", actualImmutableAppGroupEntry.provenance());
    assertEquals(
        "The characteristics of someone or something", actualImmutableAppGroupEntry.description());
    assertEquals(1L, actualImmutableAppGroupEntry.id());
    assertEquals(EntityKind.ALL, actualImmutableAppGroupEntry.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE, actualImmutableAppGroupEntry.entityLifecycleStatus());
    assertFalse(actualImmutableAppGroupEntry.isReadOnly());
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
    Builder builderResult = ImmutableAppGroupEntry.builder();
    Optional<String> externalId = Optional.of("42");

    // Act
    Builder actualExternalIdResult = builderResult.externalId(externalId);

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#from(AppGroupEntry)} with {@code AppGroupEntry}.
   *
   * <p>Method under test: {@link Builder#from(AppGroupEntry)}
   */
  @Test
  @DisplayName("Test Builder from(AppGroupEntry) with 'AppGroupEntry'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AppGroupEntry)"})
  void testBuilderFromWithAppGroupEntry() {
    // Arrange
    Builder builderResult = ImmutableAppGroupEntry.builder();
    ImmutableAppGroupEntry instance =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAppGroupEntry actualImmutableAppGroupEntry = builderResult.build();
    assertEquals(instance, actualImmutableAppGroupEntry);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AppGroupEntry)} with {@code AppGroupEntry}.
   *
   * <p>Method under test: {@link Builder#from(AppGroupEntry)}
   */
  @Test
  @DisplayName("Test Builder from(AppGroupEntry) with 'AppGroupEntry'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AppGroupEntry)"})
  void testBuilderFromWithAppGroupEntry2() {
    // Arrange
    Builder builderResult = ImmutableAppGroupEntry.builder();
    ImmutableAppGroupEntry instance =
        ImmutableAppGroupEntry.builder()
            .description(null)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAppGroupEntry actualImmutableAppGroupEntry = builderResult.build();
    assertEquals(instance, actualImmutableAppGroupEntry);
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
    Builder builderResult = ImmutableAppGroupEntry.builder();

    // Act
    builderResult.from(
        (DescriptionProvider)
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    ImmutableAppGroupEntry immutableAppGroupEntry = builderResult.build();
    assertEquals(
        "The characteristics of someone or something", immutableAppGroupEntry.description());
    assertEquals("waltz", immutableAppGroupEntry.provenance());
    assertEquals(1L, immutableAppGroupEntry.id());
    assertEquals(EntityKind.ALL, immutableAppGroupEntry.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, immutableAppGroupEntry.entityLifecycleStatus());
    assertFalse(immutableAppGroupEntry.isReadOnly());
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
    Builder builderResult = ImmutableAppGroupEntry.builder();
    ImmutableAppGroupEntry instance =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableAppGroupEntry actualImmutableAppGroupEntry = builderResult.build();
    assertEquals(instance, actualImmutableAppGroupEntry);
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
  void testBuilderFromWithDescriptionProvider3() {
    // Arrange
    Builder builderResult = ImmutableAppGroupEntry.builder();

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
    Builder builderResult = ImmutableAppGroupEntry.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
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
  void testBuilderFromWithEntityLifecycleStatusProvider() {
    // Arrange
    Builder builderResult = ImmutableAppGroupEntry.builder();

    // Act
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
    ImmutableAppGroupEntry immutableAppGroupEntry = builderResult.build();
    assertEquals(
        "The characteristics of someone or something", immutableAppGroupEntry.description());
    assertEquals("waltz", immutableAppGroupEntry.provenance());
    assertEquals(1L, immutableAppGroupEntry.id());
    assertEquals(EntityKind.ALL, immutableAppGroupEntry.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, immutableAppGroupEntry.entityLifecycleStatus());
    assertFalse(immutableAppGroupEntry.isReadOnly());
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
    Builder builderResult = ImmutableAppGroupEntry.builder();
    ImmutableAppGroupEntry instance =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((EntityLifecycleStatusProvider) instance);

    // Assert
    ImmutableAppGroupEntry actualImmutableAppGroupEntry = builderResult.build();
    assertEquals(instance, actualImmutableAppGroupEntry);
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
  void testBuilderFromWithEntityLifecycleStatusProvider3() {
    // Arrange
    Builder builderResult = ImmutableAppGroupEntry.builder();

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
  void testBuilderFromWithEntityLifecycleStatusProvider4() {
    // Arrange
    Builder builderResult = ImmutableAppGroupEntry.builder();

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
    Builder builderResult = ImmutableAppGroupEntry.builder();

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
            .description(null)
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
   * Test Builder {@link Builder#from(EntityReference)} with {@code EntityReference}.
   *
   * <p>Method under test: {@link Builder#from(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder from(EntityReference) with 'EntityReference'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityReference)"})
  void testBuilderFromWithEntityReference() {
    // Arrange
    Builder builderResult = ImmutableAppGroupEntry.builder();

    // Act
    builderResult.from(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Assert
    ImmutableAppGroupEntry immutableAppGroupEntry = builderResult.build();
    assertEquals(
        "The characteristics of someone or something", immutableAppGroupEntry.description());
    assertEquals("waltz", immutableAppGroupEntry.provenance());
    assertEquals(1L, immutableAppGroupEntry.id());
    assertEquals(EntityKind.ALL, immutableAppGroupEntry.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, immutableAppGroupEntry.entityLifecycleStatus());
    assertFalse(immutableAppGroupEntry.isReadOnly());
  }

  /**
   * Test Builder {@link Builder#from(EntityReference)} with {@code EntityReference}.
   *
   * <p>Method under test: {@link Builder#from(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder from(EntityReference) with 'EntityReference'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityReference)"})
  void testBuilderFromWithEntityReference2() {
    // Arrange
    Builder builderResult = ImmutableAppGroupEntry.builder();
    ImmutableAppGroupEntry instance =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((EntityReference) instance);

    // Assert
    ImmutableAppGroupEntry actualImmutableAppGroupEntry = builderResult.build();
    assertEquals(instance, actualImmutableAppGroupEntry);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityReference)} with {@code EntityReference}.
   *
   * <ul>
   *   <li>Then builder build description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityReference) with 'EntityReference'; then builder build description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityReference)"})
  void testBuilderFromWithEntityReference_thenBuilderBuildDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutableAppGroupEntry.builder();

    // Act
    builderResult.from(
        ImmutableEntityReference.builder()
            .description(null)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Assert
    ImmutableAppGroupEntry immutableAppGroupEntry = builderResult.build();
    assertEquals("waltz", immutableAppGroupEntry.provenance());
    assertNull(immutableAppGroupEntry.description());
    assertEquals(1L, immutableAppGroupEntry.id());
    assertEquals(EntityKind.ALL, immutableAppGroupEntry.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, immutableAppGroupEntry.entityLifecycleStatus());
    assertFalse(immutableAppGroupEntry.isReadOnly());
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
    Builder builderResult = ImmutableAppGroupEntry.builder();

    // Act
    builderResult.from(
        (ExternalIdProvider)
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    ImmutableAppGroupEntry immutableAppGroupEntry = builderResult.build();
    assertEquals(
        "The characteristics of someone or something", immutableAppGroupEntry.description());
    assertEquals("waltz", immutableAppGroupEntry.provenance());
    assertEquals(1L, immutableAppGroupEntry.id());
    assertEquals(EntityKind.ALL, immutableAppGroupEntry.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, immutableAppGroupEntry.entityLifecycleStatus());
    assertFalse(immutableAppGroupEntry.isReadOnly());
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
  void testBuilderFromWithExternalIdProvider2() {
    // Arrange
    Builder builderResult = ImmutableAppGroupEntry.builder();
    ImmutableAppGroupEntry instance =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ExternalIdProvider) instance);

    // Assert
    ImmutableAppGroupEntry actualImmutableAppGroupEntry = builderResult.build();
    assertEquals(instance, actualImmutableAppGroupEntry);
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableAppGroupEntry.builder();

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
    Builder builderResult = ImmutableAppGroupEntry.builder();

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
   *   <li>Then builder build description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; then builder build description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_thenBuilderBuildDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutableAppGroupEntry.builder();

    // Act
    builderResult.from(
        (ExternalIdProvider)
            ImmutableEntityReference.builder()
                .description(null)
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    ImmutableAppGroupEntry immutableAppGroupEntry = builderResult.build();
    assertEquals("waltz", immutableAppGroupEntry.provenance());
    assertNull(immutableAppGroupEntry.description());
    assertEquals(1L, immutableAppGroupEntry.id());
    assertEquals(EntityKind.ALL, immutableAppGroupEntry.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, immutableAppGroupEntry.entityLifecycleStatus());
    assertFalse(immutableAppGroupEntry.isReadOnly());
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
    Builder builderResult = ImmutableAppGroupEntry.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
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
    Builder builderResult = ImmutableAppGroupEntry.builder();
    ImmutableAppGroupEntry instance =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IsReadOnlyProvider) instance);

    // Assert
    ImmutableAppGroupEntry actualImmutableAppGroupEntry = builderResult.build();
    assertEquals(instance, actualImmutableAppGroupEntry);
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
    Builder builderResult = ImmutableAppGroupEntry.builder();

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
  void testBuilderFromWithIsReadOnlyProvider3() {
    // Arrange
    Builder builderResult = ImmutableAppGroupEntry.builder();
    ImmutableAppGroupEntry instance =
        ImmutableAppGroupEntry.builder()
            .description(null)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IsReadOnlyProvider) instance);

    // Assert
    ImmutableAppGroupEntry actualImmutableAppGroupEntry = builderResult.build();
    assertEquals(instance, actualImmutableAppGroupEntry);
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
    Builder builderResult = ImmutableAppGroupEntry.builder();

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
    Builder builderResult = ImmutableAppGroupEntry.builder();
    ImmutableAppGroupEntry instance =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ProvenanceProvider) instance);

    // Assert
    ImmutableAppGroupEntry actualImmutableAppGroupEntry = builderResult.build();
    assertEquals(instance, actualImmutableAppGroupEntry);
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
  void testBuilderFromWithProvenanceProvider3() {
    // Arrange
    Builder builderResult = ImmutableAppGroupEntry.builder();

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
    Builder builderResult = ImmutableAppGroupEntry.builder();

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
   * Test Builder {@link Builder#id(long)}.
   *
   * <p>Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderId() {
    // Arrange
    Builder builderResult = ImmutableAppGroupEntry.builder();

    // Act
    Builder actualIdResult = builderResult.id(1L);

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
    Builder builderResult = ImmutableAppGroupEntry.builder();

    // Act
    Builder actualIsReadOnlyResult = builderResult.isReadOnly(true);

    // Assert
    assertSame(builderResult, actualIsReadOnlyResult);
  }

  /**
   * Test Builder {@link Builder#kind(EntityKind)}.
   *
   * <p>Method under test: {@link Builder#kind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder kind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.kind(EntityKind)"})
  void testBuilderKind() {
    // Arrange
    Builder builderResult = ImmutableAppGroupEntry.builder();

    // Act
    Builder actualKindResult = builderResult.kind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualKindResult);
  }

  /**
   * Test Builder {@link Builder#name(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#name(Optional)}
   */
  @Test
  @DisplayName("Test Builder name(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(Optional)"})
  void testBuilderNameWithOptional() {
    // Arrange
    Builder builderResult = ImmutableAppGroupEntry.builder();
    Optional<String> name = Optional.of("42");

    // Act
    Builder actualNameResult = builderResult.name(name);

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test {@link ImmutableAppGroupEntry#copyOf(AppGroupEntry)}.
   *
   * <ul>
   *   <li>Then return {@code Provenance}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupEntry#copyOf(AppGroupEntry)}
   */
  @Test
  @DisplayName("Test copyOf(AppGroupEntry); then return 'Provenance'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroupEntry ImmutableAppGroupEntry.copyOf(AppGroupEntry)"})
  void testCopyOf_thenReturnProvenance() {
    // Arrange
    ImmutableAppGroupEntry instance =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableAppGroupEntry actualCopyOfResult = ImmutableAppGroupEntry.copyOf(instance);

    // Assert
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.id());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertFalse(actualCopyOfResult.isReadOnly());
  }

  /**
   * Test {@link ImmutableAppGroupEntry#entityLifecycleStatus()}.
   *
   * <p>Method under test: {@link ImmutableAppGroupEntry#entityLifecycleStatus()}
   */
  @Test
  @DisplayName("Test entityLifecycleStatus()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityLifecycleStatus ImmutableAppGroupEntry.entityLifecycleStatus()"})
  void testEntityLifecycleStatus() {
    // Arrange, Act and Assert
    assertEquals(
        EntityLifecycleStatus.ACTIVE,
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build()
            .entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableAppGroupEntry#equals(Object)}, and {@link
   * ImmutableAppGroupEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppGroupEntry#equals(Object)}
   *   <li>{@link ImmutableAppGroupEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroupEntry.equals(Object)",
    "int ImmutableAppGroupEntry.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAppGroupEntry immutableAppGroupEntry =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();
    ImmutableAppGroupEntry immutableAppGroupEntry2 =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertEquals(immutableAppGroupEntry, immutableAppGroupEntry2);
    assertEquals(immutableAppGroupEntry.hashCode(), immutableAppGroupEntry2.hashCode());
  }

  /**
   * Test {@link ImmutableAppGroupEntry#equals(Object)}, and {@link
   * ImmutableAppGroupEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppGroupEntry#equals(Object)}
   *   <li>{@link ImmutableAppGroupEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroupEntry.equals(Object)",
    "int ImmutableAppGroupEntry.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAppGroupEntry immutableAppGroupEntry =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertEquals(immutableAppGroupEntry, immutableAppGroupEntry);
    int expectedHashCodeResult = immutableAppGroupEntry.hashCode();
    assertEquals(expectedHashCodeResult, immutableAppGroupEntry.hashCode());
  }

  /**
   * Test {@link ImmutableAppGroupEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroupEntry.equals(Object)",
    "int ImmutableAppGroupEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableAppGroupEntry immutableAppGroupEntry =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAppGroupEntry,
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableAppGroupEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroupEntry.equals(Object)",
    "int ImmutableAppGroupEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableAppGroupEntry immutableAppGroupEntry =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(2L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAppGroupEntry,
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableAppGroupEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroupEntry.equals(Object)",
    "int ImmutableAppGroupEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableAppGroupEntry immutableAppGroupEntry =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAppGroupEntry,
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableAppGroupEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroupEntry.equals(Object)",
    "int ImmutableAppGroupEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableAppGroupEntry immutableAppGroupEntry =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("entityLifecycleStatus")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAppGroupEntry,
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableAppGroupEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroupEntry.equals(Object)",
    "int ImmutableAppGroupEntry.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAppGroupEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroupEntry.equals(Object)",
    "int ImmutableAppGroupEntry.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build(),
        "Different type to ImmutableAppGroupEntry");
  }

  /**
   * Test {@link ImmutableAppGroupEntry#externalId()}.
   *
   * <p>Method under test: {@link ImmutableAppGroupEntry#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableAppGroupEntry.externalId()"})
  void testExternalId() {
    // Arrange and Act
    Optional<String> actualExternalIdResult =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
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
   *   <li>{@link ImmutableAppGroupEntry#toString()}
   *   <li>{@link ImmutableAppGroupEntry#description()}
   *   <li>{@link ImmutableAppGroupEntry#id()}
   *   <li>{@link ImmutableAppGroupEntry#kind()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableAppGroupEntry.description()",
    "long ImmutableAppGroupEntry.id()",
    "EntityKind ImmutableAppGroupEntry.kind()",
    "String ImmutableAppGroupEntry.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAppGroupEntry immutableAppGroupEntry =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    String actualToStringResult = immutableAppGroupEntry.toString();
    String actualDescriptionResult = immutableAppGroupEntry.description();
    long actualIdResult = immutableAppGroupEntry.id();

    // Assert
    assertEquals(
        "AppGroupEntry{provenance=Provenance, isReadOnly=false, kind=ALL, id=1, entityLifecycleStatus=ACTIVE}",
        actualToStringResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1L, actualIdResult);
    assertEquals(EntityKind.ALL, immutableAppGroupEntry.kind());
  }

  /**
   * Test {@link ImmutableAppGroupEntry#isReadOnly()}.
   *
   * <p>Method under test: {@link ImmutableAppGroupEntry#isReadOnly()}
   */
  @Test
  @DisplayName("Test isReadOnly()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableAppGroupEntry.isReadOnly()"})
  void testIsReadOnly() {
    // Arrange, Act and Assert
    assertFalse(
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
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
  @MethodsUnderTest({"long Json.id()"})
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
   * Test Json {@link Json#name()}.
   *
   * <p>Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.name()"})
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
    assertNull(actualJson.provenance);
    assertNull(actualJson.kind);
    assertNull(actualJson.entityLifecycleStatus);
    assertEquals(0L, actualJson.id);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.name.isPresent());
    assertFalse(actualJson.idIsSet);
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
   * Test Json {@link Json#setId(long)}.
   *
   * <p>Method under test: {@link Json#setId(long)}
   */
  @Test
  @DisplayName("Test Json setId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setId(long)"})
  void testJsonSetId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setId(1L);

    // Assert
    assertEquals(1L, json.id);
    assertTrue(json.idIsSet);
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
   * Test {@link ImmutableAppGroupEntry#name()}.
   *
   * <p>Method under test: {@link ImmutableAppGroupEntry#name()}
   */
  @Test
  @DisplayName("Test name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableAppGroupEntry.name()"})
  void testName() {
    // Arrange and Act
    Optional<String> actualNameResult =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build()
            .name();

    // Assert
    assertEquals("Name", actualNameResult.get());
    assertTrue(actualNameResult.isPresent());
  }

  /**
   * Test {@link ImmutableAppGroupEntry#provenance()}.
   *
   * <p>Method under test: {@link ImmutableAppGroupEntry#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableAppGroupEntry.provenance()"})
  void testProvenance() {
    // Arrange, Act and Assert
    assertEquals(
        "Provenance",
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build()
            .provenance());
  }

  /**
   * Test {@link ImmutableAppGroupEntry#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableAppGroupEntry#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroupEntry ImmutableAppGroupEntry.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    ImmutableAppGroupEntry immutableAppGroupEntry =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableAppGroupEntry actualWithDescriptionResult =
        immutableAppGroupEntry.withDescription("42");

    // Assert
    assertEquals(immutableAppGroupEntry, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableAppGroupEntry#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableAppGroupEntry#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroupEntry ImmutableAppGroupEntry.withDescription(String)"})
  void testWithDescription2() {
    // Arrange
    ImmutableAppGroupEntry immutableAppGroupEntry =
        ImmutableAppGroupEntry.builder()
            .description("42")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableAppGroupEntry actualWithDescriptionResult =
        immutableAppGroupEntry.withDescription("42");

    // Assert
    assertSame(immutableAppGroupEntry, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableAppGroupEntry#withEntityLifecycleStatus(EntityLifecycleStatus)}.
   *
   * <p>Method under test: {@link
   * ImmutableAppGroupEntry#withEntityLifecycleStatus(EntityLifecycleStatus)}
   */
  @Test
  @DisplayName("Test withEntityLifecycleStatus(EntityLifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppGroupEntry ImmutableAppGroupEntry.withEntityLifecycleStatus(EntityLifecycleStatus)"
  })
  void testWithEntityLifecycleStatus() {
    // Arrange
    ImmutableAppGroupEntry immutableAppGroupEntry =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableAppGroupEntry actualWithEntityLifecycleStatusResult =
        immutableAppGroupEntry.withEntityLifecycleStatus(EntityLifecycleStatus.ACTIVE);

    // Assert
    assertSame(immutableAppGroupEntry, actualWithEntityLifecycleStatusResult);
  }

  /**
   * Test {@link ImmutableAppGroupEntry#withEntityLifecycleStatus(EntityLifecycleStatus)}.
   *
   * <ul>
   *   <li>Then return {@code Provenance}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAppGroupEntry#withEntityLifecycleStatus(EntityLifecycleStatus)}
   */
  @Test
  @DisplayName("Test withEntityLifecycleStatus(EntityLifecycleStatus); then return 'Provenance'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppGroupEntry ImmutableAppGroupEntry.withEntityLifecycleStatus(EntityLifecycleStatus)"
  })
  void testWithEntityLifecycleStatus_thenReturnProvenance() {
    // Arrange and Act
    ImmutableAppGroupEntry actualWithEntityLifecycleStatusResult =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build()
            .withEntityLifecycleStatus(EntityLifecycleStatus.ACTIVE);

    // Assert
    assertEquals("Provenance", actualWithEntityLifecycleStatusResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithEntityLifecycleStatusResult.description());
    assertEquals(1L, actualWithEntityLifecycleStatusResult.id());
    assertEquals(EntityKind.ALL, actualWithEntityLifecycleStatusResult.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE,
        actualWithEntityLifecycleStatusResult.entityLifecycleStatus());
    assertFalse(actualWithEntityLifecycleStatusResult.isReadOnly());
  }

  /**
   * Test {@link ImmutableAppGroupEntry#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableAppGroupEntry#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroupEntry ImmutableAppGroupEntry.withExternalId(Optional)"})
  void testWithExternalIdWithOptional() {
    // Arrange
    ImmutableAppGroupEntry immutableAppGroupEntry =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableAppGroupEntry actualWithExternalIdResult =
        immutableAppGroupEntry.withExternalId(optional);

    // Assert
    assertSame(immutableAppGroupEntry, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableAppGroupEntry#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableAppGroupEntry#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroupEntry ImmutableAppGroupEntry.withExternalId(Optional)"})
  void testWithExternalIdWithOptional2() {
    // Arrange
    ImmutableAppGroupEntry immutableAppGroupEntry =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("External Id")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableAppGroupEntry actualWithExternalIdResult =
        immutableAppGroupEntry.withExternalId(optional);

    // Assert
    assertEquals(immutableAppGroupEntry, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableAppGroupEntry#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupEntry#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroupEntry ImmutableAppGroupEntry.withExternalId(String)"})
  void testWithExternalIdWithValue_when42() {
    // Arrange
    ImmutableAppGroupEntry immutableAppGroupEntry =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableAppGroupEntry actualWithExternalIdResult = immutableAppGroupEntry.withExternalId("42");

    // Assert
    assertSame(immutableAppGroupEntry, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableAppGroupEntry#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupEntry#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'; when '0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroupEntry ImmutableAppGroupEntry.withExternalId(String)"})
  void testWithExternalIdWithValue_when0123456789abcdef() {
    // Arrange
    ImmutableAppGroupEntry immutableAppGroupEntry =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableAppGroupEntry actualWithExternalIdResult =
        immutableAppGroupEntry.withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals(immutableAppGroupEntry, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableAppGroupEntry#withId(long)}.
   *
   * <p>Method under test: {@link ImmutableAppGroupEntry#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroupEntry ImmutableAppGroupEntry.withId(long)"})
  void testWithId() {
    // Arrange
    ImmutableAppGroupEntry immutableAppGroupEntry =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(42L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableAppGroupEntry actualWithIdResult = immutableAppGroupEntry.withId(42L);

    // Assert
    assertSame(immutableAppGroupEntry, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableAppGroupEntry#withId(long)}.
   *
   * <ul>
   *   <li>Then return {@code Provenance}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupEntry#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long); then return 'Provenance'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroupEntry ImmutableAppGroupEntry.withId(long)"})
  void testWithId_thenReturnProvenance() {
    // Arrange and Act
    ImmutableAppGroupEntry actualWithIdResult =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build()
            .withId(42L);

    // Assert
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(42L, actualWithIdResult.id());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithIdResult.entityLifecycleStatus());
    assertFalse(actualWithIdResult.isReadOnly());
  }

  /**
   * Test {@link ImmutableAppGroupEntry#withIsReadOnly(boolean)}.
   *
   * <p>Method under test: {@link ImmutableAppGroupEntry#withIsReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test withIsReadOnly(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroupEntry ImmutableAppGroupEntry.withIsReadOnly(boolean)"})
  void testWithIsReadOnly() {
    // Arrange
    ImmutableAppGroupEntry immutableAppGroupEntry =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableAppGroupEntry actualWithIsReadOnlyResult =
        immutableAppGroupEntry.withIsReadOnly(false);

    // Assert
    assertSame(immutableAppGroupEntry, actualWithIsReadOnlyResult);
  }

  /**
   * Test {@link ImmutableAppGroupEntry#withIsReadOnly(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@code Provenance}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupEntry#withIsReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test withIsReadOnly(boolean); when 'true'; then return 'Provenance'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroupEntry ImmutableAppGroupEntry.withIsReadOnly(boolean)"})
  void testWithIsReadOnly_whenTrue_thenReturnProvenance() {
    // Arrange and Act
    ImmutableAppGroupEntry actualWithIsReadOnlyResult =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build()
            .withIsReadOnly(true);

    // Assert
    assertEquals("Provenance", actualWithIsReadOnlyResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithIsReadOnlyResult.description());
    assertEquals(1L, actualWithIsReadOnlyResult.id());
    assertEquals(EntityKind.ALL, actualWithIsReadOnlyResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithIsReadOnlyResult.entityLifecycleStatus());
    assertTrue(actualWithIsReadOnlyResult.isReadOnly());
  }

  /**
   * Test {@link ImmutableAppGroupEntry#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableAppGroupEntry#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroupEntry ImmutableAppGroupEntry.withKind(EntityKind)"})
  void testWithKind() {
    // Arrange
    ImmutableAppGroupEntry immutableAppGroupEntry =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableAppGroupEntry actualWithKindResult = immutableAppGroupEntry.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableAppGroupEntry, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableAppGroupEntry#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return {@code Provenance}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupEntry#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind); then return 'Provenance'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroupEntry ImmutableAppGroupEntry.withKind(EntityKind)"})
  void testWithKind_thenReturnProvenance() {
    // Arrange and Act
    ImmutableAppGroupEntry actualWithKindResult =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .name("Name")
            .provenance("Provenance")
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    assertEquals("Provenance", actualWithKindResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithKindResult.description());
    assertEquals(1L, actualWithKindResult.id());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithKindResult.entityLifecycleStatus());
    assertFalse(actualWithKindResult.isReadOnly());
  }

  /**
   * Test {@link ImmutableAppGroupEntry#withName(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableAppGroupEntry#withName(Optional)}
   */
  @Test
  @DisplayName("Test withName(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroupEntry ImmutableAppGroupEntry.withName(Optional)"})
  void testWithNameWithOptional() {
    // Arrange
    ImmutableAppGroupEntry immutableAppGroupEntry =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableAppGroupEntry actualWithNameResult = immutableAppGroupEntry.withName(optional);

    // Assert
    assertEquals(immutableAppGroupEntry, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableAppGroupEntry#withName(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableAppGroupEntry#withName(Optional)}
   */
  @Test
  @DisplayName("Test withName(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroupEntry ImmutableAppGroupEntry.withName(Optional)"})
  void testWithNameWithOptional2() {
    // Arrange
    ImmutableAppGroupEntry immutableAppGroupEntry =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("42")
            .provenance("Provenance")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableAppGroupEntry actualWithNameResult = immutableAppGroupEntry.withName(optional);

    // Assert
    assertSame(immutableAppGroupEntry, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableAppGroupEntry#withName(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableAppGroupEntry#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroupEntry ImmutableAppGroupEntry.withName(String)"})
  void testWithNameWithValue() {
    // Arrange
    ImmutableAppGroupEntry immutableAppGroupEntry =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableAppGroupEntry actualWithNameResult = immutableAppGroupEntry.withName("42");

    // Assert
    assertEquals(immutableAppGroupEntry, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableAppGroupEntry#withName(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableAppGroupEntry#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroupEntry ImmutableAppGroupEntry.withName(String)"})
  void testWithNameWithValue2() {
    // Arrange
    ImmutableAppGroupEntry immutableAppGroupEntry =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("42")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableAppGroupEntry actualWithNameResult = immutableAppGroupEntry.withName("42");

    // Assert
    assertSame(immutableAppGroupEntry, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableAppGroupEntry#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableAppGroupEntry#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroupEntry ImmutableAppGroupEntry.withProvenance(String)"})
  void testWithProvenance() {
    // Arrange
    ImmutableAppGroupEntry immutableAppGroupEntry =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("42")
            .build();

    // Act
    ImmutableAppGroupEntry actualWithProvenanceResult = immutableAppGroupEntry.withProvenance("42");

    // Assert
    assertSame(immutableAppGroupEntry, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableAppGroupEntry#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then return provenance is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupEntry#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String); then return provenance is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroupEntry ImmutableAppGroupEntry.withProvenance(String)"})
  void testWithProvenance_thenReturnProvenanceIs42() {
    // Arrange and Act
    ImmutableAppGroupEntry actualWithProvenanceResult =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build()
            .withProvenance("42");

    // Assert
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithProvenanceResult.description());
    assertEquals(1L, actualWithProvenanceResult.id());
    assertEquals(EntityKind.ALL, actualWithProvenanceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithProvenanceResult.entityLifecycleStatus());
    assertFalse(actualWithProvenanceResult.isReadOnly());
  }
}
