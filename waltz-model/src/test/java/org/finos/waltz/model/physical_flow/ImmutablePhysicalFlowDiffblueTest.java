package org.finos.waltz.model.physical_flow;

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
import org.finos.waltz.model.CreatedUserTimestampProvider;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityLifecycleStatusProvider;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.FreshnessIndicator;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableUserTimestamp;
import org.finos.waltz.model.IsRemovedProvider;
import org.finos.waltz.model.LastAttestedProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagram;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramKind;
import org.finos.waltz.model.app_group.AppGroupKind;
import org.finos.waltz.model.app_group.ImmutableAppGroup;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.ImmutableApplication;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.flow_diagram.ImmutableFlowDiagram;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlow;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlow.Builder;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlow.Json;
import org.finos.waltz.model.rating.RagRating;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalFlowDiffblueTest {
  /**
   * Test Builder {@link Builder#basisOffset(int)}.
   *
   * <p>Method under test: {@link Builder#basisOffset(int)}
   */
  @Test
  @DisplayName("Test Builder basisOffset(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.basisOffset(int)"})
  void testBuilderBasisOffset() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();

    // Act
    Builder actualBasisOffsetResult = builderResult.basisOffset(1);

    // Assert
    assertSame(builderResult, actualBasisOffsetResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#created(UserTimestamp)}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#entityLifecycleStatus(EntityLifecycleStatus)}
   *   <li>{@link Builder#externalId(String)}
   *   <li>{@link Builder#freshnessIndicator(FreshnessIndicator)}
   *   <li>{@link Builder#kind(EntityKind)}
   *   <li>{@link Builder#lastAttestedAt(LocalDateTime)}
   *   <li>{@link Builder#lastAttestedBy(String)}
   *   <li>{@link Builder#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link Builder#name(String)}
   *   <li>{@link Builder#provenance(String)}
   *   <li>{@link Builder#transport(TransportKindValue)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlow Builder.build()",
    "Builder Builder.created(UserTimestamp)",
    "Builder Builder.description(String)",
    "Builder Builder.entityLifecycleStatus(EntityLifecycleStatus)",
    "Builder Builder.externalId(String)",
    "Builder Builder.freshnessIndicator(FreshnessIndicator)",
    "Builder Builder.kind(EntityKind)",
    "Builder Builder.lastAttestedAt(LocalDateTime)",
    "Builder Builder.lastAttestedBy(String)",
    "Builder Builder.lastUpdatedAt(LocalDateTime)",
    "Builder Builder.name(String)",
    "Builder Builder.provenance(String)",
    "Builder Builder.transport(TransportKindValue)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBasisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    Builder actualCreatedResult = actualBasisOffsetResult.created(created);
    Builder actualCreatedResult2 =
        actualCreatedResult.created(
            ImmutableUserTimestamp.builder()
                .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                .by("By")
                .build());
    CriticalityValue criticality = CriticalityValue.of("42");
    Builder actualExternalIdResult =
        actualCreatedResult2
            .criticality(criticality)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");
    Optional<String> externalId = Optional.of("42");
    Builder actualExternalIdResult2 = actualExternalIdResult.externalId(externalId);
    FrequencyKindValue frequency = FrequencyKindValue.of("42");
    Builder actualIdResult =
        actualExternalIdResult2
            .frequency(frequency)
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L);
    Optional<Long> id = Optional.of(42L);
    Builder actualLastAttestedAtResult =
        actualIdResult
            .id(id)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    Optional<? extends LocalDateTime> lastAttestedAt =
        Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    Builder actualLastAttestedByResult =
        actualLastAttestedAtResult
            .lastAttestedAt(lastAttestedAt)
            .lastAttestedBy("Last Attested By");
    Optional<String> lastAttestedBy = Optional.of("42");
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    Builder actualSpecificationDefinitionIdResult =
        actualLastAttestedByResult
            .lastAttestedBy(lastAttestedBy)
            .lastUpdatedAt(lastUpdatedAt)
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L);
    Optional<Long> specificationDefinitionId = Optional.of(42L);
    Builder actualSpecificationIdResult =
        actualSpecificationDefinitionIdResult
            .specificationDefinitionId(specificationDefinitionId)
            .specificationId(1L);
    TransportKindValue transport = TransportKindValue.of("42");
    ImmutablePhysicalFlow actualImmutablePhysicalFlow =
        actualSpecificationIdResult.transport(transport).build();

    // Assert
    assertEquals("2020-03-01", actualImmutablePhysicalFlow.lastUpdatedBy());
    CriticalityValue criticalityResult = actualImmutablePhysicalFlow.criticality();
    assertEquals("42", criticalityResult.value());
    FrequencyKindValue frequencyResult = actualImmutablePhysicalFlow.frequency();
    assertEquals("42", frequencyResult.value());
    TransportKindValue transportResult = actualImmutablePhysicalFlow.transport();
    assertEquals("42", transportResult.value());
    assertEquals("Name", actualImmutablePhysicalFlow.name());
    assertEquals("Provenance", actualImmutablePhysicalFlow.provenance());
    assertEquals(
        "The characteristics of someone or something", actualImmutablePhysicalFlow.description());
    assertEquals(1, actualImmutablePhysicalFlow.basisOffset());
    assertEquals(1L, actualImmutablePhysicalFlow.logicalFlowId());
    assertEquals(1L, actualImmutablePhysicalFlow.specificationId());
    assertEquals(EntityKind.ALL, actualImmutablePhysicalFlow.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualImmutablePhysicalFlow.entityLifecycleStatus());
    assertEquals(
        FreshnessIndicator.NEVER_OBSERVED, actualImmutablePhysicalFlow.freshnessIndicator());
    assertFalse(actualImmutablePhysicalFlow.isReadOnly());
    assertFalse(actualImmutablePhysicalFlow.isRemoved());
    assertSame(lastUpdatedAt, actualImmutablePhysicalFlow.lastUpdatedAt());
    assertSame(criticality, criticalityResult);
    assertSame(frequency, frequencyResult);
    assertSame(transport, transportResult);
  }

  /**
   * Test Builder {@link Builder#created(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#created(Optional)}
   */
  @Test
  @DisplayName("Test Builder created(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.created(Optional)"})
  void testBuilderCreatedWithOptional() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act
    Builder actualCreatedResult = builderResult.created(created);

    // Assert
    assertSame(builderResult, actualCreatedResult);
  }

  /**
   * Test Builder {@link Builder#criticality(CriticalityValue)}.
   *
   * <ul>
   *   <li>When {@link CriticalityValue} with value is {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#criticality(CriticalityValue)}
   */
  @Test
  @DisplayName(
      "Test Builder criticality(CriticalityValue); when CriticalityValue with value is '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.criticality(CriticalityValue)"})
  void testBuilderCriticality_whenCriticalityValueWithValueIs42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();

    // Act
    Builder actualCriticalityResult = builderResult.criticality(CriticalityValue.of("42"));

    // Assert
    assertSame(builderResult, actualCriticalityResult);
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
    Builder builderResult = ImmutablePhysicalFlow.builder();
    Optional<String> externalId = Optional.of("42");

    // Act
    Builder actualExternalIdResult = builderResult.externalId(externalId);

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#frequency(FrequencyKindValue)}.
   *
   * <ul>
   *   <li>When {@link FrequencyKindValue} with value is {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#frequency(FrequencyKindValue)}
   */
  @Test
  @DisplayName(
      "Test Builder frequency(FrequencyKindValue); when FrequencyKindValue with value is '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.frequency(FrequencyKindValue)"})
  void testBuilderFrequency_whenFrequencyKindValueWithValueIs42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();

    // Act
    Builder actualFrequencyResult = builderResult.frequency(FrequencyKindValue.of("42"));

    // Assert
    assertSame(builderResult, actualFrequencyResult);
  }

  /**
   * Test Builder {@link Builder#from(CreatedUserTimestampProvider)} with {@code
   * CreatedUserTimestampProvider}.
   *
   * <p>Method under test: {@link Builder#from(CreatedUserTimestampProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CreatedUserTimestampProvider) with 'CreatedUserTimestampProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CreatedUserTimestampProvider)"})
  void testBuilderFromWithCreatedUserTimestampProvider() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow instance =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act and Assert
    ImmutablePhysicalFlow actualImmutablePhysicalFlow =
        builderResult.from((CreatedUserTimestampProvider) instance).build();
    assertEquals(instance, actualImmutablePhysicalFlow);
    ImmutablePhysicalFlow actualImmutablePhysicalFlow2 = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlow2);
  }

  /**
   * Test Builder {@link Builder#from(CreatedUserTimestampProvider)} with {@code
   * CreatedUserTimestampProvider}.
   *
   * <p>Method under test: {@link Builder#from(CreatedUserTimestampProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CreatedUserTimestampProvider) with 'CreatedUserTimestampProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CreatedUserTimestampProvider)"})
  void testBuilderFromWithCreatedUserTimestampProvider2() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();

    CreatedUserTimestampProvider instance = mock(CreatedUserTimestampProvider.class);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<UserTimestamp> ofResult = Optional.of(immutableUserTimestamp);
    when(instance.created()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CreatedUserTimestampProvider)} with {@code
   * CreatedUserTimestampProvider}.
   *
   * <ul>
   *   <li>Given empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CreatedUserTimestampProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CreatedUserTimestampProvider) with 'CreatedUserTimestampProvider'; given empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CreatedUserTimestampProvider)"})
  void testBuilderFromWithCreatedUserTimestampProvider_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();

    CreatedUserTimestampProvider instance = mock(CreatedUserTimestampProvider.class);
    Optional<UserTimestamp> emptyResult = Optional.empty();
    when(instance.created()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CreatedUserTimestampProvider)} with {@code
   * CreatedUserTimestampProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CreatedUserTimestampProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CreatedUserTimestampProvider) with 'CreatedUserTimestampProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CreatedUserTimestampProvider)"})
  void testBuilderFromWithCreatedUserTimestampProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();

    CreatedUserTimestampProvider instance = mock(CreatedUserTimestampProvider.class);
    when(instance.created()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).created();
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
    Builder builderResult = ImmutablePhysicalFlow.builder();

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow instance =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act and Assert
    ImmutablePhysicalFlow actualImmutablePhysicalFlow =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutablePhysicalFlow);
    ImmutablePhysicalFlow actualImmutablePhysicalFlow2 = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlow2);
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
    Builder builderResult = ImmutablePhysicalFlow.builder();

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
    Builder builderResult = ImmutablePhysicalFlow.builder();

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
    Builder builderResult = ImmutablePhysicalFlow.builder();

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow instance =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act and Assert
    ImmutablePhysicalFlow actualImmutablePhysicalFlow =
        builderResult.from((EntityKindProvider) instance).build();
    assertEquals(instance, actualImmutablePhysicalFlow);
    ImmutablePhysicalFlow actualImmutablePhysicalFlow2 = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlow2);
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
    Builder builderResult = ImmutablePhysicalFlow.builder();

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
    Builder builderResult = ImmutablePhysicalFlow.builder();

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
    Builder builderResult = ImmutablePhysicalFlow.builder();

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
    Builder builderResult = ImmutablePhysicalFlow.builder();

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow instance =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act and Assert
    ImmutablePhysicalFlow actualImmutablePhysicalFlow =
        builderResult.from((EntityLifecycleStatusProvider) instance).build();
    assertEquals(instance, actualImmutablePhysicalFlow);
    ImmutablePhysicalFlow actualImmutablePhysicalFlow2 = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlow2);
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
    Builder builderResult = ImmutablePhysicalFlow.builder();

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
    Builder builderResult = ImmutablePhysicalFlow.builder();

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
    Builder builderResult = ImmutablePhysicalFlow.builder();

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
    Builder builderResult = ImmutablePhysicalFlow.builder();

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
    Builder builderResult = ImmutablePhysicalFlow.builder();

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow instance =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act and Assert
    ImmutablePhysicalFlow actualImmutablePhysicalFlow =
        builderResult.from((ExternalIdProvider) instance).build();
    assertEquals(instance, actualImmutablePhysicalFlow);
    ImmutablePhysicalFlow actualImmutablePhysicalFlow2 = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlow2);
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
    Builder builderResult = ImmutablePhysicalFlow.builder();

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
    Builder builderResult = ImmutablePhysicalFlow.builder();

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
    Builder builderResult = ImmutablePhysicalFlow.builder();

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow instance =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act and Assert
    ImmutablePhysicalFlow actualImmutablePhysicalFlow =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutablePhysicalFlow);
    ImmutablePhysicalFlow actualImmutablePhysicalFlow2 = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlow2);
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
    Builder builderResult = ImmutablePhysicalFlow.builder();

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
    Builder builderResult = ImmutablePhysicalFlow.builder();

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
    Builder builderResult = ImmutablePhysicalFlow.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(IsRemovedProvider)} with {@code IsRemovedProvider}.
   *
   * <p>Method under test: {@link Builder#from(IsRemovedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IsRemovedProvider) with 'IsRemovedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IsRemovedProvider)"})
  void testBuilderFromWithIsRemovedProvider() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (IsRemovedProvider)
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IsRemovedProvider)} with {@code IsRemovedProvider}.
   *
   * <p>Method under test: {@link Builder#from(IsRemovedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IsRemovedProvider) with 'IsRemovedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IsRemovedProvider)"})
  void testBuilderFromWithIsRemovedProvider2() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow instance =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act and Assert
    ImmutablePhysicalFlow actualImmutablePhysicalFlow =
        builderResult.from((IsRemovedProvider) instance).build();
    assertEquals(instance, actualImmutablePhysicalFlow);
    ImmutablePhysicalFlow actualImmutablePhysicalFlow2 = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlow2);
  }

  /**
   * Test Builder {@link Builder#from(IsRemovedProvider)} with {@code IsRemovedProvider}.
   *
   * <p>Method under test: {@link Builder#from(IsRemovedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IsRemovedProvider) with 'IsRemovedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IsRemovedProvider)"})
  void testBuilderFromWithIsRemovedProvider3() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();

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
            (IsRemovedProvider)
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IsRemovedProvider)} with {@code IsRemovedProvider}.
   *
   * <p>Method under test: {@link Builder#from(IsRemovedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IsRemovedProvider) with 'IsRemovedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IsRemovedProvider)"})
  void testBuilderFromWithIsRemovedProvider4() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (IsRemovedProvider)
                ImmutableFlowDiagram.builder()
                    .description("The characteristics of someone or something")
                    .editorRole("Editor Role")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IsRemovedProvider)} with {@code IsRemovedProvider}.
   *
   * <p>Method under test: {@link Builder#from(IsRemovedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IsRemovedProvider) with 'IsRemovedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IsRemovedProvider)"})
  void testBuilderFromWithIsRemovedProvider5() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();

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
            (IsRemovedProvider)
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IsRemovedProvider)} with {@code IsRemovedProvider}.
   *
   * <p>Method under test: {@link Builder#from(IsRemovedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IsRemovedProvider) with 'IsRemovedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IsRemovedProvider)"})
  void testBuilderFromWithIsRemovedProvider6() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();

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
            (IsRemovedProvider)
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IsRemovedProvider)} with {@code IsRemovedProvider}.
   *
   * <p>Method under test: {@link Builder#from(IsRemovedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IsRemovedProvider) with 'IsRemovedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IsRemovedProvider)"})
  void testBuilderFromWithIsRemovedProvider7() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    Optional<? extends UserTimestamp> created = Optional.empty();

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow instance =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act and Assert
    ImmutablePhysicalFlow actualImmutablePhysicalFlow =
        builderResult.from((IsRemovedProvider) instance).build();
    assertEquals(instance, actualImmutablePhysicalFlow);
    ImmutablePhysicalFlow actualImmutablePhysicalFlow2 = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlow2);
  }

  /**
   * Test Builder {@link Builder#from(LastAttestedProvider)} with {@code LastAttestedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastAttestedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastAttestedProvider) with 'LastAttestedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastAttestedProvider)"})
  void testBuilderFromWithLastAttestedProvider() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();

    ImmutableLogicalFlow.Builder builderResult2 = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutableLogicalFlow.Builder provenanceResult =
        builderResult2
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    ImmutableLogicalFlow.Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    Builder actualFromResult =
        builderResult.from(
            (LastAttestedProvider)
                sourceResult
                    .target(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(LastAttestedProvider)} with {@code LastAttestedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastAttestedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastAttestedProvider) with 'LastAttestedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastAttestedProvider)"})
  void testBuilderFromWithLastAttestedProvider2() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow instance =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act and Assert
    ImmutablePhysicalFlow actualImmutablePhysicalFlow =
        builderResult.from((LastAttestedProvider) instance).build();
    assertEquals(instance, actualImmutablePhysicalFlow);
    ImmutablePhysicalFlow actualImmutablePhysicalFlow2 = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlow2);
  }

  /**
   * Test Builder {@link Builder#from(LastAttestedProvider)} with {@code LastAttestedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastAttestedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastAttestedProvider) with 'LastAttestedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastAttestedProvider)"})
  void testBuilderFromWithLastAttestedProvider3() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();

    ImmutableLogicalFlow.Builder builderResult2 = ImmutableLogicalFlow.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();

    ImmutableLogicalFlow.Builder provenanceResult =
        builderResult2
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    ImmutableLogicalFlow.Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    Builder actualFromResult =
        builderResult.from(
            (LastAttestedProvider)
                sourceResult
                    .target(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(LastAttestedProvider)} with {@code LastAttestedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastAttestedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastAttestedProvider) with 'LastAttestedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastAttestedProvider)"})
  void testBuilderFromWithLastAttestedProvider4() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    Optional<? extends UserTimestamp> created = Optional.empty();

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow instance =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act and Assert
    ImmutablePhysicalFlow actualImmutablePhysicalFlow =
        builderResult.from((LastAttestedProvider) instance).build();
    assertEquals(instance, actualImmutablePhysicalFlow);
    ImmutablePhysicalFlow actualImmutablePhysicalFlow2 = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlow2);
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
    Builder builderResult = ImmutablePhysicalFlow.builder();

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow instance =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act and Assert
    ImmutablePhysicalFlow actualImmutablePhysicalFlow =
        builderResult.from((LastUpdatedProvider) instance).build();
    assertEquals(instance, actualImmutablePhysicalFlow);
    ImmutablePhysicalFlow actualImmutablePhysicalFlow2 = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlow2);
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
    Builder builderResult = ImmutablePhysicalFlow.builder();

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
    Builder builderResult = ImmutablePhysicalFlow.builder();

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
    Builder builderResult = ImmutablePhysicalFlow.builder();

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
   * Test Builder {@link Builder#from(PhysicalFlow)} with {@code PhysicalFlow}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalFlow)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlow) with 'PhysicalFlow'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlow)"})
  void testBuilderFromWithPhysicalFlow() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow instance =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePhysicalFlow actualImmutablePhysicalFlow = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlow);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlow)} with {@code PhysicalFlow}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalFlow)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlow) with 'PhysicalFlow'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlow)"})
  void testBuilderFromWithPhysicalFlow2() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    Optional<? extends UserTimestamp> created = Optional.empty();

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow instance =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePhysicalFlow actualImmutablePhysicalFlow = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlow);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlow)} with {@code PhysicalFlow}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalFlow)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlow) with 'PhysicalFlow'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlow)"})
  void testBuilderFromWithPhysicalFlow3() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description(null)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow instance =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePhysicalFlow actualImmutablePhysicalFlow = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlow);
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
    Builder builderResult = ImmutablePhysicalFlow.builder();

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
    Builder builderResult = ImmutablePhysicalFlow.builder();

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow instance =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act and Assert
    ImmutablePhysicalFlow actualImmutablePhysicalFlow =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutablePhysicalFlow);
    ImmutablePhysicalFlow actualImmutablePhysicalFlow2 = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlow2);
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
    Builder builderResult = ImmutablePhysicalFlow.builder();

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
    Builder builderResult = ImmutablePhysicalFlow.builder();

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
  void testBuilderFromWithProvenanceProvider5() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    Optional<? extends UserTimestamp> created = Optional.empty();

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow instance =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act and Assert
    ImmutablePhysicalFlow actualImmutablePhysicalFlow =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutablePhysicalFlow);
    ImmutablePhysicalFlow actualImmutablePhysicalFlow2 = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlow2);
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
    Builder builderResult = ImmutablePhysicalFlow.builder();

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
    Builder builderResult = ImmutablePhysicalFlow.builder();
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
    Builder builderResult = ImmutablePhysicalFlow.builder();

    // Act
    Builder actualIsReadOnlyResult = builderResult.isReadOnly(true);

    // Assert
    assertSame(builderResult, actualIsReadOnlyResult);
  }

  /**
   * Test Builder {@link Builder#isRemoved(boolean)}.
   *
   * <p>Method under test: {@link Builder#isRemoved(boolean)}
   */
  @Test
  @DisplayName("Test Builder isRemoved(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isRemoved(boolean)"})
  void testBuilderIsRemoved() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();

    // Act
    Builder actualIsRemovedResult = builderResult.isRemoved(true);

    // Assert
    assertSame(builderResult, actualIsRemovedResult);
  }

  /**
   * Test Builder {@link Builder#lastAttestedAt(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#lastAttestedAt(Optional)}
   */
  @Test
  @DisplayName("Test Builder lastAttestedAt(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.lastAttestedAt(Optional)"})
  void testBuilderLastAttestedAtWithOptional() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();
    Optional<? extends LocalDateTime> lastAttestedAt =
        Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    Builder actualLastAttestedAtResult = builderResult.lastAttestedAt(lastAttestedAt);

    // Assert
    assertSame(builderResult, actualLastAttestedAtResult);
  }

  /**
   * Test Builder {@link Builder#lastAttestedBy(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#lastAttestedBy(Optional)}
   */
  @Test
  @DisplayName("Test Builder lastAttestedBy(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.lastAttestedBy(Optional)"})
  void testBuilderLastAttestedByWithOptional() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();
    Optional<String> lastAttestedBy = Optional.of("42");

    // Act
    Builder actualLastAttestedByResult = builderResult.lastAttestedBy(lastAttestedBy);

    // Assert
    assertSame(builderResult, actualLastAttestedByResult);
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
    Builder builderResult = ImmutablePhysicalFlow.builder();

    // Act
    Builder actualLastUpdatedByResult = builderResult.lastUpdatedBy("2020-03-01");

    // Assert
    assertSame(builderResult, actualLastUpdatedByResult);
  }

  /**
   * Test Builder {@link Builder#logicalFlowId(long)}.
   *
   * <p>Method under test: {@link Builder#logicalFlowId(long)}
   */
  @Test
  @DisplayName("Test Builder logicalFlowId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.logicalFlowId(long)"})
  void testBuilderLogicalFlowId() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();

    // Act
    Builder actualLogicalFlowIdResult = builderResult.logicalFlowId(1L);

    // Assert
    assertSame(builderResult, actualLogicalFlowIdResult);
  }

  /**
   * Test Builder {@link Builder#specificationDefinitionId(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#specificationDefinitionId(long)}
   */
  @Test
  @DisplayName("Test Builder specificationDefinitionId(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.specificationDefinitionId(long)"})
  void testBuilderSpecificationDefinitionIdWithLong() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();

    // Act
    Builder actualSpecificationDefinitionIdResult = builderResult.specificationDefinitionId(1L);

    // Assert
    assertSame(builderResult, actualSpecificationDefinitionIdResult);
  }

  /**
   * Test Builder {@link Builder#specificationDefinitionId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#specificationDefinitionId(Optional)}
   */
  @Test
  @DisplayName("Test Builder specificationDefinitionId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.specificationDefinitionId(Optional)"})
  void testBuilderSpecificationDefinitionIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();
    Optional<Long> specificationDefinitionId = Optional.of(42L);

    // Act
    Builder actualSpecificationDefinitionIdResult =
        builderResult.specificationDefinitionId(specificationDefinitionId);

    // Assert
    assertSame(builderResult, actualSpecificationDefinitionIdResult);
  }

  /**
   * Test Builder {@link Builder#specificationId(long)}.
   *
   * <p>Method under test: {@link Builder#specificationId(long)}
   */
  @Test
  @DisplayName("Test Builder specificationId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.specificationId(long)"})
  void testBuilderSpecificationId() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlow.builder();

    // Act
    Builder actualSpecificationIdResult = builderResult.specificationId(1L);

    // Assert
    assertSame(builderResult, actualSpecificationIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlow#copyOf(PhysicalFlow)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#copyOf(PhysicalFlow)}
   */
  @Test
  @DisplayName("Test copyOf(PhysicalFlow); then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlow ImmutablePhysicalFlow.copyOf(PhysicalFlow)"})
  void testCopyOf_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder externalIdResult =
        createdResult
            .criticality(criticality)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(frequency)
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    TransportKindValue transport = TransportKindValue.of("42");
    ImmutablePhysicalFlow instance = specificationIdResult.transport(transport).build();

    // Act
    ImmutablePhysicalFlow actualCopyOfResult = ImmutablePhysicalFlow.copyOf(instance);

    // Assert
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.basisOffset());
    assertEquals(1L, actualCopyOfResult.logicalFlowId());
    assertEquals(1L, actualCopyOfResult.specificationId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertEquals(FreshnessIndicator.NEVER_OBSERVED, actualCopyOfResult.freshnessIndicator());
    assertFalse(actualCopyOfResult.isReadOnly());
    assertFalse(actualCopyOfResult.isRemoved());
    assertSame(criticality, actualCopyOfResult.criticality());
    assertSame(frequency, actualCopyOfResult.frequency());
    assertSame(transport, actualCopyOfResult.transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#created()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#created()}
   */
  @Test
  @DisplayName("Test created()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutablePhysicalFlow.created()"})
  void testCreated() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act and Assert
    assertEquals(
        created, specificationIdResult.transport(TransportKindValue.of("42")).build().created());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#entityLifecycleStatus()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#entityLifecycleStatus()}
   */
  @Test
  @DisplayName("Test entityLifecycleStatus()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityLifecycleStatus ImmutablePhysicalFlow.entityLifecycleStatus()"})
  void testEntityLifecycleStatus() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act and Assert
    assertEquals(
        EntityLifecycleStatus.ACTIVE,
        specificationIdResult
            .transport(TransportKindValue.of("42"))
            .build()
            .entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#equals(Object)}, and {@link
   * ImmutablePhysicalFlow#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlow#equals(Object)}
   *   <li>{@link ImmutablePhysicalFlow#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlow.equals(Object)",
    "int ImmutablePhysicalFlow.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    Builder createdResult2 = basisOffsetResult2.created(created2);

    Builder externalIdResult2 =
        createdResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult2 =
        externalIdResult2
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow2 =
        specificationIdResult2.transport(TransportKindValue.of("42")).build();

    // Act and Assert
    assertEquals(immutablePhysicalFlow, immutablePhysicalFlow2);
    assertEquals(immutablePhysicalFlow.hashCode(), immutablePhysicalFlow2.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#equals(Object)}, and {@link
   * ImmutablePhysicalFlow#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlow#equals(Object)}
   *   <li>{@link ImmutablePhysicalFlow#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlow.equals(Object)",
    "int ImmutablePhysicalFlow.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act and Assert
    assertEquals(immutablePhysicalFlow, immutablePhysicalFlow);
    int expectedHashCodeResult = immutablePhysicalFlow.hashCode();
    assertEquals(expectedHashCodeResult, immutablePhysicalFlow.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlow.equals(Object)",
    "int ImmutablePhysicalFlow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(6);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    Builder createdResult2 = basisOffsetResult2.created(created2);

    Builder externalIdResult2 =
        createdResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult2 =
        externalIdResult2
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlow,
        specificationIdResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlow.equals(Object)",
    "int ImmutablePhysicalFlow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder().at(LocalDate.now().atStartOfDay()).by("By").build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    Builder createdResult2 = basisOffsetResult2.created(created2);

    Builder externalIdResult2 =
        createdResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult2 =
        externalIdResult2
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlow,
        specificationIdResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlow.equals(Object)",
    "int ImmutablePhysicalFlow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("By"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    Builder createdResult2 = basisOffsetResult2.created(created2);

    Builder externalIdResult2 =
        createdResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult2 =
        externalIdResult2
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlow,
        specificationIdResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlow.equals(Object)",
    "int ImmutablePhysicalFlow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    Builder createdResult2 = basisOffsetResult2.created(created2);

    Builder externalIdResult2 =
        createdResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult2 =
        externalIdResult2
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlow,
        specificationIdResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlow.equals(Object)",
    "int ImmutablePhysicalFlow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("By");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    Builder createdResult2 = basisOffsetResult2.created(created2);

    Builder externalIdResult2 =
        createdResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult2 =
        externalIdResult2
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlow,
        specificationIdResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlow.equals(Object)",
    "int ImmutablePhysicalFlow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("By"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    Builder createdResult2 = basisOffsetResult2.created(created2);

    Builder externalIdResult2 =
        createdResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult2 =
        externalIdResult2
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlow,
        specificationIdResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlow.equals(Object)",
    "int ImmutablePhysicalFlow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.HISTORICALLY_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    Builder createdResult2 = basisOffsetResult2.created(created2);

    Builder externalIdResult2 =
        createdResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult2 =
        externalIdResult2
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlow,
        specificationIdResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlow.equals(Object)",
    "int ImmutablePhysicalFlow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(2L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    Builder createdResult2 = basisOffsetResult2.created(created2);

    Builder externalIdResult2 =
        createdResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult2 =
        externalIdResult2
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlow,
        specificationIdResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlow.equals(Object)",
    "int ImmutablePhysicalFlow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ACTOR)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    Builder createdResult2 = basisOffsetResult2.created(created2);

    Builder externalIdResult2 =
        createdResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult2 =
        externalIdResult2
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlow,
        specificationIdResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlow.equals(Object)",
    "int ImmutablePhysicalFlow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.now().atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    Builder createdResult2 = basisOffsetResult2.created(created2);

    Builder externalIdResult2 =
        createdResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult2 =
        externalIdResult2
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlow,
        specificationIdResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlow.equals(Object)",
    "int ImmutablePhysicalFlow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    Builder createdResult2 = basisOffsetResult2.created(created2);

    Builder externalIdResult2 =
        createdResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult2 =
        externalIdResult2
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlow,
        specificationIdResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlow.equals(Object)",
    "int ImmutablePhysicalFlow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    Builder createdResult2 = basisOffsetResult2.created(created2);

    Builder externalIdResult2 =
        createdResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult2 =
        externalIdResult2
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlow,
        specificationIdResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlow.equals(Object)",
    "int ImmutablePhysicalFlow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020/03/01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    Builder createdResult2 = basisOffsetResult2.created(created2);

    Builder externalIdResult2 =
        createdResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult2 =
        externalIdResult2
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlow,
        specificationIdResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlow.equals(Object)",
    "int ImmutablePhysicalFlow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(2L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    Builder createdResult2 = basisOffsetResult2.created(created2);

    Builder externalIdResult2 =
        createdResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult2 =
        externalIdResult2
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlow,
        specificationIdResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlow.equals(Object)",
    "int ImmutablePhysicalFlow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("By")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    Builder createdResult2 = basisOffsetResult2.created(created2);

    Builder externalIdResult2 =
        createdResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult2 =
        externalIdResult2
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlow,
        specificationIdResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlow.equals(Object)",
    "int ImmutablePhysicalFlow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("By")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    Builder createdResult2 = basisOffsetResult2.created(created2);

    Builder externalIdResult2 =
        createdResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult2 =
        externalIdResult2
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlow,
        specificationIdResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlow.equals(Object)",
    "int ImmutablePhysicalFlow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(2L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    Builder createdResult2 = basisOffsetResult2.created(created2);

    Builder externalIdResult2 =
        createdResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult2 =
        externalIdResult2
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlow,
        specificationIdResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlow.equals(Object)",
    "int ImmutablePhysicalFlow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(2L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    Builder createdResult2 = basisOffsetResult2.created(created2);

    Builder externalIdResult2 =
        createdResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult2 =
        externalIdResult2
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlow,
        specificationIdResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlow.equals(Object)",
    "int ImmutablePhysicalFlow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("By")).build();

    Builder basisOffsetResult2 = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    Builder createdResult2 = basisOffsetResult2.created(created2);

    Builder externalIdResult2 =
        createdResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult2 =
        externalIdResult2
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlow,
        specificationIdResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlow.equals(Object)",
    "int ImmutablePhysicalFlow.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act and Assert
    assertNotEquals(specificationIdResult.transport(TransportKindValue.of("42")).build(), null);
  }

  /**
   * Test {@link ImmutablePhysicalFlow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlow.equals(Object)",
    "int ImmutablePhysicalFlow.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act and Assert
    assertNotEquals(
        specificationIdResult.transport(TransportKindValue.of("42")).build(),
        "Different type to ImmutablePhysicalFlow");
  }

  /**
   * Test {@link ImmutablePhysicalFlow#externalId()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutablePhysicalFlow.externalId()"})
  void testExternalId() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act
    Optional<String> actualExternalIdResult =
        specificationIdResult.transport(TransportKindValue.of("42")).build().externalId();

    // Assert
    assertEquals("42", actualExternalIdResult.get());
    assertTrue(actualExternalIdResult.isPresent());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#freshnessIndicator()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#freshnessIndicator()}
   */
  @Test
  @DisplayName("Test freshnessIndicator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FreshnessIndicator ImmutablePhysicalFlow.freshnessIndicator()"})
  void testFreshnessIndicator() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act and Assert
    assertEquals(
        FreshnessIndicator.NEVER_OBSERVED,
        specificationIdResult.transport(TransportKindValue.of("42")).build().freshnessIndicator());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlow#basisOffset()}
   *   <li>{@link ImmutablePhysicalFlow#criticality()}
   *   <li>{@link ImmutablePhysicalFlow#description()}
   *   <li>{@link ImmutablePhysicalFlow#frequency()}
   *   <li>{@link ImmutablePhysicalFlow#lastUpdatedBy()}
   *   <li>{@link ImmutablePhysicalFlow#logicalFlowId()}
   *   <li>{@link ImmutablePhysicalFlow#name()}
   *   <li>{@link ImmutablePhysicalFlow#specificationId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ImmutablePhysicalFlow.basisOffset()",
    "CriticalityValue ImmutablePhysicalFlow.criticality()",
    "String ImmutablePhysicalFlow.description()",
    "FrequencyKindValue ImmutablePhysicalFlow.frequency()",
    "String ImmutablePhysicalFlow.lastUpdatedBy()",
    "long ImmutablePhysicalFlow.logicalFlowId()",
    "String ImmutablePhysicalFlow.name()",
    "long ImmutablePhysicalFlow.specificationId()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder externalIdResult =
        createdResult
            .criticality(criticality)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(frequency)
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act
    int actualBasisOffsetResult = immutablePhysicalFlow.basisOffset();
    CriticalityValue actualCriticalityResult = immutablePhysicalFlow.criticality();
    String actualDescriptionResult = immutablePhysicalFlow.description();
    FrequencyKindValue actualFrequencyResult = immutablePhysicalFlow.frequency();
    String actualLastUpdatedByResult = immutablePhysicalFlow.lastUpdatedBy();
    long actualLogicalFlowIdResult = immutablePhysicalFlow.logicalFlowId();
    String actualNameResult = immutablePhysicalFlow.name();
    long actualSpecificationIdResult = immutablePhysicalFlow.specificationId();

    // Assert
    assertEquals("2020-03-01", actualLastUpdatedByResult);
    assertEquals("42", actualCriticalityResult.value());
    assertEquals("42", actualFrequencyResult.value());
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1, actualBasisOffsetResult);
    assertEquals(1L, actualLogicalFlowIdResult);
    assertEquals(1L, actualSpecificationIdResult);
    assertSame(criticality, actualCriticalityResult);
    assertSame(frequency, actualFrequencyResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlow#id()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutablePhysicalFlow.id()"})
  void testId() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act
    Optional<Long> actualIdResult =
        specificationIdResult.transport(TransportKindValue.of("42")).build().id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#isReadOnly()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#isReadOnly()}
   */
  @Test
  @DisplayName("Test isReadOnly()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutablePhysicalFlow.isReadOnly()"})
  void testIsReadOnly() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act and Assert
    assertFalse(specificationIdResult.transport(TransportKindValue.of("42")).build().isReadOnly());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#isRemoved()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#isRemoved()}
   */
  @Test
  @DisplayName("Test isRemoved()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutablePhysicalFlow.isRemoved()"})
  void testIsRemoved() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act and Assert
    assertFalse(specificationIdResult.transport(TransportKindValue.of("42")).build().isRemoved());
  }

  /**
   * Test Json {@link Json#basisOffset()}.
   *
   * <p>Method under test: {@link Json#basisOffset()}
   */
  @Test
  @DisplayName("Test Json basisOffset()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.basisOffset()"})
  void testJsonBasisOffset() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().basisOffset());
  }

  /**
   * Test Json {@link Json#created()}.
   *
   * <p>Method under test: {@link Json#created()}
   */
  @Test
  @DisplayName("Test Json created()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.created()"})
  void testJsonCreated() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().created());
  }

  /**
   * Test Json {@link Json#criticality()}.
   *
   * <p>Method under test: {@link Json#criticality()}
   */
  @Test
  @DisplayName("Test Json criticality()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CriticalityValue Json.criticality()"})
  void testJsonCriticality() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().criticality());
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
   * Test Json {@link Json#frequency()}.
   *
   * <p>Method under test: {@link Json#frequency()}
   */
  @Test
  @DisplayName("Test Json frequency()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FrequencyKindValue Json.frequency()"})
  void testJsonFrequency() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().frequency());
  }

  /**
   * Test Json {@link Json#freshnessIndicator()}.
   *
   * <p>Method under test: {@link Json#freshnessIndicator()}
   */
  @Test
  @DisplayName("Test Json freshnessIndicator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FreshnessIndicator Json.freshnessIndicator()"})
  void testJsonFreshnessIndicator() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().freshnessIndicator());
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
   * Test Json {@link Json#isRemoved()}.
   *
   * <p>Method under test: {@link Json#isRemoved()}
   */
  @Test
  @DisplayName("Test Json isRemoved()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isRemoved()"})
  void testJsonIsRemoved() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isRemoved());
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
   * Test Json {@link Json#lastAttestedAt()}.
   *
   * <p>Method under test: {@link Json#lastAttestedAt()}
   */
  @Test
  @DisplayName("Test Json lastAttestedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.lastAttestedAt()"})
  void testJsonLastAttestedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lastAttestedAt());
  }

  /**
   * Test Json {@link Json#lastAttestedBy()}.
   *
   * <p>Method under test: {@link Json#lastAttestedBy()}
   */
  @Test
  @DisplayName("Test Json lastAttestedBy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.lastAttestedBy()"})
  void testJsonLastAttestedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lastAttestedBy());
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
   * Test Json {@link Json#logicalFlowId()}.
   *
   * <p>Method under test: {@link Json#logicalFlowId()}
   */
  @Test
  @DisplayName("Test Json logicalFlowId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.logicalFlowId()"})
  void testJsonLogicalFlowId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().logicalFlowId());
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
    assertNull(actualJson.freshnessIndicator);
    assertNull(actualJson.criticality);
    assertNull(actualJson.frequency);
    assertNull(actualJson.transport);
    assertEquals(0, actualJson.basisOffset);
    assertEquals(0L, actualJson.logicalFlowId);
    assertEquals(0L, actualJson.specificationId);
    assertFalse(actualJson.created.isPresent());
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.lastAttestedAt.isPresent());
    assertFalse(actualJson.lastAttestedBy.isPresent());
    assertFalse(actualJson.specificationDefinitionId.isPresent());
    assertFalse(actualJson.basisOffsetIsSet);
    assertFalse(actualJson.isReadOnly);
    assertFalse(actualJson.isReadOnlyIsSet);
    assertFalse(actualJson.isRemoved);
    assertFalse(actualJson.isRemovedIsSet);
    assertFalse(actualJson.logicalFlowIdIsSet);
    assertFalse(actualJson.specificationIdIsSet);
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
   * Test Json {@link Json#setBasisOffset(int)}.
   *
   * <p>Method under test: {@link Json#setBasisOffset(int)}
   */
  @Test
  @DisplayName("Test Json setBasisOffset(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setBasisOffset(int)"})
  void testJsonSetBasisOffset() {
    // Arrange
    Json json = new Json();

    // Act
    json.setBasisOffset(1);

    // Assert
    assertEquals(1, json.basisOffset);
    assertTrue(json.basisOffsetIsSet);
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
   * Test Json {@link Json#setIsRemoved(boolean)}.
   *
   * <p>Method under test: {@link Json#setIsRemoved(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsRemoved(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setIsRemoved(boolean)"})
  void testJsonSetIsRemoved() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsRemoved(true);

    // Assert
    assertTrue(json.isRemoved);
    assertTrue(json.isRemovedIsSet);
  }

  /**
   * Test Json {@link Json#setLogicalFlowId(long)}.
   *
   * <p>Method under test: {@link Json#setLogicalFlowId(long)}
   */
  @Test
  @DisplayName("Test Json setLogicalFlowId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setLogicalFlowId(long)"})
  void testJsonSetLogicalFlowId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setLogicalFlowId(1L);

    // Assert
    assertEquals(1L, json.logicalFlowId);
    assertTrue(json.logicalFlowIdIsSet);
  }

  /**
   * Test Json {@link Json#setSpecificationId(long)}.
   *
   * <p>Method under test: {@link Json#setSpecificationId(long)}
   */
  @Test
  @DisplayName("Test Json setSpecificationId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setSpecificationId(long)"})
  void testJsonSetSpecificationId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setSpecificationId(1L);

    // Assert
    assertEquals(1L, json.specificationId);
    assertTrue(json.specificationIdIsSet);
  }

  /**
   * Test Json {@link Json#specificationDefinitionId()}.
   *
   * <p>Method under test: {@link Json#specificationDefinitionId()}
   */
  @Test
  @DisplayName("Test Json specificationDefinitionId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.specificationDefinitionId()"})
  void testJsonSpecificationDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().specificationDefinitionId());
  }

  /**
   * Test Json {@link Json#specificationId()}.
   *
   * <p>Method under test: {@link Json#specificationId()}
   */
  @Test
  @DisplayName("Test Json specificationId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.specificationId()"})
  void testJsonSpecificationId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().specificationId());
  }

  /**
   * Test Json {@link Json#transport()}.
   *
   * <p>Method under test: {@link Json#transport()}
   */
  @Test
  @DisplayName("Test Json transport()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TransportKindValue Json.transport()"})
  void testJsonTransport() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#kind()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ImmutablePhysicalFlow.kind()"})
  void testKind() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act and Assert
    assertEquals(
        EntityKind.ALL,
        specificationIdResult.transport(TransportKindValue.of("42")).build().kind());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#lastAttestedAt()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#lastAttestedAt()}
   */
  @Test
  @DisplayName("Test lastAttestedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutablePhysicalFlow.lastAttestedAt()"})
  void testLastAttestedAt() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(ofResult.atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act
    Optional<LocalDateTime> actualLastAttestedAtResult =
        specificationIdResult.transport(TransportKindValue.of("42")).build().lastAttestedAt();

    // Assert
    LocalDateTime getResult = actualLastAttestedAtResult.get();
    assertEquals("00:00", getResult.toLocalTime().toString());
    LocalDate toLocalDateResult = getResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertTrue(actualLastAttestedAtResult.isPresent());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlow#lastAttestedBy()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#lastAttestedBy()}
   */
  @Test
  @DisplayName("Test lastAttestedBy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutablePhysicalFlow.lastAttestedBy()"})
  void testLastAttestedBy() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act
    Optional<String> actualLastAttestedByResult =
        specificationIdResult.transport(TransportKindValue.of("42")).build().lastAttestedBy();

    // Assert
    assertEquals("Last Attested By", actualLastAttestedByResult.get());
    assertTrue(actualLastAttestedByResult.isPresent());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutablePhysicalFlow.lastUpdatedAt()"})
  void testLastUpdatedAt() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act
    LocalDateTime actualLastUpdatedAtResult =
        specificationIdResult.transport(TransportKindValue.of("42")).build().lastUpdatedAt();

    // Assert
    assertEquals("00:00", actualLastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualLastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlow#provenance()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutablePhysicalFlow.provenance()"})
  void testProvenance() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act and Assert
    assertEquals(
        "Provenance",
        specificationIdResult.transport(TransportKindValue.of("42")).build().provenance());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#specificationDefinitionId()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#specificationDefinitionId()}
   */
  @Test
  @DisplayName("Test specificationDefinitionId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutablePhysicalFlow.specificationDefinitionId()"})
  void testSpecificationDefinitionId() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act
    Optional<Long> actualSpecificationDefinitionIdResult =
        specificationIdResult
            .transport(TransportKindValue.of("42"))
            .build()
            .specificationDefinitionId();

    // Assert
    assertEquals(1L, actualSpecificationDefinitionIdResult.get().longValue());
    assertTrue(actualSpecificationDefinitionIdResult.isPresent());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#toString()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutablePhysicalFlow.toString()"})
  void testToString() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act and Assert
    assertEquals(
        "PhysicalFlow{id=1, isRemoved=false, created=UserTimestamp{at=1970-01-01T00:00, by=By, atTimestamp=1970-01-01"
            + " 00:00:00.0}, provenance=Provenance, lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01,"
            + " lastAttestedAt=1970-01-01T00:00, lastAttestedBy=Last Attested By, entityLifecycleStatus=ACTIVE,"
            + " externalId=42, logicalFlowId=1, specificationId=1, name=Name, frequency=42, basisOffset=1, transport=42,"
            + " freshnessIndicator=NEVER_OBSERVED, specificationDefinitionId=1, criticality=42, kind=ALL, isReadOnly"
            + "=false}",
        specificationIdResult.transport(TransportKindValue.of("42")).build().toString());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#toString()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutablePhysicalFlow.toString()"})
  void testToString2() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    Optional<? extends UserTimestamp> created = Optional.empty();

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act and Assert
    assertEquals(
        "PhysicalFlow{id=1, isRemoved=false, provenance=Provenance, lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy"
            + "=2020-03-01, lastAttestedAt=1970-01-01T00:00, lastAttestedBy=Last Attested By, entityLifecycleStatus=ACTIVE,"
            + " externalId=42, logicalFlowId=1, specificationId=1, name=Name, frequency=42, basisOffset=1, transport=42,"
            + " freshnessIndicator=NEVER_OBSERVED, specificationDefinitionId=1, criticality=42, kind=ALL, isReadOnly"
            + "=false}",
        specificationIdResult.transport(TransportKindValue.of("42")).build().toString());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#toString()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutablePhysicalFlow.toString()"})
  void testToString3() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name(null)
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act and Assert
    assertEquals(
        "PhysicalFlow{id=1, isRemoved=false, created=UserTimestamp{at=1970-01-01T00:00, by=By, atTimestamp"
            + "=1970-01-01 00:00:00.0}, provenance=Provenance, lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01,"
            + " lastAttestedAt=1970-01-01T00:00, lastAttestedBy=Last Attested By, entityLifecycleStatus=ACTIVE,"
            + " externalId=42, logicalFlowId=1, specificationId=1, frequency=42, basisOffset=1, transport=42,"
            + " freshnessIndicator=NEVER_OBSERVED, specificationDefinitionId=1, criticality=42, kind=ALL,"
            + " isReadOnly=false}",
        specificationIdResult.transport(TransportKindValue.of("42")).build().toString());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#transport()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#transport()}
   */
  @Test
  @DisplayName("Test transport()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TransportKindValue ImmutablePhysicalFlow.transport()"})
  void testTransport() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    TransportKindValue transport = TransportKindValue.of("42");

    // Act
    TransportKindValue actualTransportResult =
        specificationIdResult.transport(transport).build().transport();

    // Assert
    assertEquals("42", actualTransportResult.value());
    assertSame(transport, actualTransportResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withBasisOffset(int)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withBasisOffset(int)}
   */
  @Test
  @DisplayName("Test withBasisOffset(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlow ImmutablePhysicalFlow.withBasisOffset(int)"})
  void testWithBasisOffset() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(42);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlow actualWithBasisOffsetResult = immutablePhysicalFlow.withBasisOffset(42);

    // Assert
    assertSame(immutablePhysicalFlow, actualWithBasisOffsetResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withBasisOffset(int)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withBasisOffset(int)}
   */
  @Test
  @DisplayName("Test withBasisOffset(int); then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlow ImmutablePhysicalFlow.withBasisOffset(int)"})
  void testWithBasisOffset_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder externalIdResult =
        createdResult
            .criticality(criticality)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(frequency)
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    TransportKindValue transport = TransportKindValue.of("42");

    // Act
    ImmutablePhysicalFlow actualWithBasisOffsetResult =
        specificationIdResult.transport(transport).build().withBasisOffset(42);

    // Assert
    assertEquals("2020-03-01", actualWithBasisOffsetResult.lastUpdatedBy());
    assertEquals("Name", actualWithBasisOffsetResult.name());
    assertEquals("Provenance", actualWithBasisOffsetResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithBasisOffsetResult.description());
    assertEquals(1L, actualWithBasisOffsetResult.logicalFlowId());
    assertEquals(1L, actualWithBasisOffsetResult.specificationId());
    assertEquals(42, actualWithBasisOffsetResult.basisOffset());
    assertEquals(EntityKind.ALL, actualWithBasisOffsetResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithBasisOffsetResult.entityLifecycleStatus());
    assertEquals(
        FreshnessIndicator.NEVER_OBSERVED, actualWithBasisOffsetResult.freshnessIndicator());
    assertFalse(actualWithBasisOffsetResult.isReadOnly());
    assertFalse(actualWithBasisOffsetResult.isRemoved());
    assertSame(criticality, actualWithBasisOffsetResult.criticality());
    assertSame(frequency, actualWithBasisOffsetResult.frequency());
    assertSame(transport, actualWithBasisOffsetResult.transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withCreated(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withCreated(Optional)}
   */
  @Test
  @DisplayName("Test withCreated(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlow ImmutablePhysicalFlow.withCreated(Optional)"})
  void testWithCreatedWithOptional() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> optional = Optional.of(immutableUserTimestamp2);

    // Act
    ImmutablePhysicalFlow actualWithCreatedResult = immutablePhysicalFlow.withCreated(optional);

    // Assert
    assertEquals(immutablePhysicalFlow, actualWithCreatedResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withCreated(UserTimestamp)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withCreated(UserTimestamp)}
   */
  @Test
  @DisplayName("Test withCreated(UserTimestamp) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlow ImmutablePhysicalFlow.withCreated(UserTimestamp)"})
  void testWithCreatedWithValue() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlow actualWithCreatedResult =
        immutablePhysicalFlow.withCreated(
            ImmutableUserTimestamp.builder()
                .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                .by("By")
                .build());

    // Assert
    assertEquals(immutablePhysicalFlow, actualWithCreatedResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withCriticality(CriticalityValue)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withCriticality(CriticalityValue)}
   */
  @Test
  @DisplayName("Test withCriticality(CriticalityValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlow ImmutablePhysicalFlow.withCriticality(CriticalityValue)"
  })
  void testWithCriticality() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlow actualWithCriticalityResult =
        immutablePhysicalFlow.withCriticality(CriticalityValue.of("42"));

    // Assert
    assertEquals(immutablePhysicalFlow, actualWithCriticalityResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlow ImmutablePhysicalFlow.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlow actualWithDescriptionResult = immutablePhysicalFlow.withDescription("42");

    // Assert
    assertEquals(immutablePhysicalFlow, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlow ImmutablePhysicalFlow.withDescription(String)"})
  void testWithDescription2() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("42")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlow actualWithDescriptionResult = immutablePhysicalFlow.withDescription("42");

    // Assert
    assertSame(immutablePhysicalFlow, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withEntityLifecycleStatus(EntityLifecycleStatus)}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlow#withEntityLifecycleStatus(EntityLifecycleStatus)}
   */
  @Test
  @DisplayName("Test withEntityLifecycleStatus(EntityLifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlow ImmutablePhysicalFlow.withEntityLifecycleStatus(EntityLifecycleStatus)"
  })
  void testWithEntityLifecycleStatus() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlow actualWithEntityLifecycleStatusResult =
        immutablePhysicalFlow.withEntityLifecycleStatus(EntityLifecycleStatus.ACTIVE);

    // Assert
    assertSame(immutablePhysicalFlow, actualWithEntityLifecycleStatusResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withEntityLifecycleStatus(EntityLifecycleStatus)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlow#withEntityLifecycleStatus(EntityLifecycleStatus)}
   */
  @Test
  @DisplayName(
      "Test withEntityLifecycleStatus(EntityLifecycleStatus); then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlow ImmutablePhysicalFlow.withEntityLifecycleStatus(EntityLifecycleStatus)"
  })
  void testWithEntityLifecycleStatus_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder externalIdResult =
        createdResult
            .criticality(criticality)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
            .externalId("42");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(frequency)
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    TransportKindValue transport = TransportKindValue.of("42");

    // Act
    ImmutablePhysicalFlow actualWithEntityLifecycleStatusResult =
        specificationIdResult
            .transport(transport)
            .build()
            .withEntityLifecycleStatus(EntityLifecycleStatus.ACTIVE);

    // Assert
    assertEquals("2020-03-01", actualWithEntityLifecycleStatusResult.lastUpdatedBy());
    assertEquals("Name", actualWithEntityLifecycleStatusResult.name());
    assertEquals("Provenance", actualWithEntityLifecycleStatusResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithEntityLifecycleStatusResult.description());
    assertEquals(1, actualWithEntityLifecycleStatusResult.basisOffset());
    assertEquals(1L, actualWithEntityLifecycleStatusResult.logicalFlowId());
    assertEquals(1L, actualWithEntityLifecycleStatusResult.specificationId());
    assertEquals(EntityKind.ALL, actualWithEntityLifecycleStatusResult.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE,
        actualWithEntityLifecycleStatusResult.entityLifecycleStatus());
    assertEquals(
        FreshnessIndicator.NEVER_OBSERVED,
        actualWithEntityLifecycleStatusResult.freshnessIndicator());
    assertFalse(actualWithEntityLifecycleStatusResult.isReadOnly());
    assertFalse(actualWithEntityLifecycleStatusResult.isRemoved());
    assertSame(criticality, actualWithEntityLifecycleStatusResult.criticality());
    assertSame(frequency, actualWithEntityLifecycleStatusResult.frequency());
    assertSame(transport, actualWithEntityLifecycleStatusResult.transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlow ImmutablePhysicalFlow.withExternalId(Optional)"})
  void testWithExternalIdWithOptional() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutablePhysicalFlow actualWithExternalIdResult =
        immutablePhysicalFlow.withExternalId(optional);

    // Assert
    assertSame(immutablePhysicalFlow, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withExternalId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(Optional) with 'optional'; then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlow ImmutablePhysicalFlow.withExternalId(Optional)"})
  void testWithExternalIdWithOptional_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder externalIdResult =
        createdResult
            .criticality(criticality)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("External Id");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(frequency)
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    TransportKindValue transport = TransportKindValue.of("42");
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(transport).build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutablePhysicalFlow actualWithExternalIdResult =
        immutablePhysicalFlow.withExternalId(optional);

    // Assert
    assertEquals("2020-03-01", actualWithExternalIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(1, actualWithExternalIdResult.basisOffset());
    assertEquals(1L, actualWithExternalIdResult.logicalFlowId());
    assertEquals(1L, actualWithExternalIdResult.specificationId());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithExternalIdResult.entityLifecycleStatus());
    assertEquals(
        FreshnessIndicator.NEVER_OBSERVED, actualWithExternalIdResult.freshnessIndicator());
    assertFalse(actualWithExternalIdResult.isReadOnly());
    assertFalse(actualWithExternalIdResult.isRemoved());
    assertSame(criticality, actualWithExternalIdResult.criticality());
    assertSame(frequency, actualWithExternalIdResult.frequency());
    assertSame(transport, actualWithExternalIdResult.transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlow ImmutablePhysicalFlow.withExternalId(String)"})
  void testWithExternalIdWithValue() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlow actualWithExternalIdResult = immutablePhysicalFlow.withExternalId("42");

    // Assert
    assertSame(immutablePhysicalFlow, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlow ImmutablePhysicalFlow.withExternalId(String)"})
  void testWithExternalIdWithValue_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder externalIdResult =
        createdResult
            .criticality(criticality)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(frequency)
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    TransportKindValue transport = TransportKindValue.of("42");

    // Act
    ImmutablePhysicalFlow actualWithExternalIdResult =
        specificationIdResult.transport(transport).build().withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("2020-03-01", actualWithExternalIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(1, actualWithExternalIdResult.basisOffset());
    assertEquals(1L, actualWithExternalIdResult.logicalFlowId());
    assertEquals(1L, actualWithExternalIdResult.specificationId());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithExternalIdResult.entityLifecycleStatus());
    assertEquals(
        FreshnessIndicator.NEVER_OBSERVED, actualWithExternalIdResult.freshnessIndicator());
    assertFalse(actualWithExternalIdResult.isReadOnly());
    assertFalse(actualWithExternalIdResult.isRemoved());
    assertSame(criticality, actualWithExternalIdResult.criticality());
    assertSame(frequency, actualWithExternalIdResult.frequency());
    assertSame(transport, actualWithExternalIdResult.transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withFrequency(FrequencyKindValue)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withFrequency(FrequencyKindValue)}
   */
  @Test
  @DisplayName("Test withFrequency(FrequencyKindValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlow ImmutablePhysicalFlow.withFrequency(FrequencyKindValue)"
  })
  void testWithFrequency() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlow actualWithFrequencyResult =
        immutablePhysicalFlow.withFrequency(FrequencyKindValue.of("42"));

    // Assert
    assertEquals(immutablePhysicalFlow, actualWithFrequencyResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withFreshnessIndicator(FreshnessIndicator)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withFreshnessIndicator(FreshnessIndicator)}
   */
  @Test
  @DisplayName("Test withFreshnessIndicator(FreshnessIndicator)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlow ImmutablePhysicalFlow.withFreshnessIndicator(FreshnessIndicator)"
  })
  void testWithFreshnessIndicator() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlow actualWithFreshnessIndicatorResult =
        immutablePhysicalFlow.withFreshnessIndicator(FreshnessIndicator.NEVER_OBSERVED);

    // Assert
    assertSame(immutablePhysicalFlow, actualWithFreshnessIndicatorResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withFreshnessIndicator(FreshnessIndicator)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withFreshnessIndicator(FreshnessIndicator)}
   */
  @Test
  @DisplayName(
      "Test withFreshnessIndicator(FreshnessIndicator); then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlow ImmutablePhysicalFlow.withFreshnessIndicator(FreshnessIndicator)"
  })
  void testWithFreshnessIndicator_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder externalIdResult =
        createdResult
            .criticality(criticality)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(frequency)
            .freshnessIndicator(FreshnessIndicator.HISTORICALLY_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    TransportKindValue transport = TransportKindValue.of("42");

    // Act
    ImmutablePhysicalFlow actualWithFreshnessIndicatorResult =
        specificationIdResult
            .transport(transport)
            .build()
            .withFreshnessIndicator(FreshnessIndicator.NEVER_OBSERVED);

    // Assert
    assertEquals("2020-03-01", actualWithFreshnessIndicatorResult.lastUpdatedBy());
    assertEquals("Name", actualWithFreshnessIndicatorResult.name());
    assertEquals("Provenance", actualWithFreshnessIndicatorResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithFreshnessIndicatorResult.description());
    assertEquals(1, actualWithFreshnessIndicatorResult.basisOffset());
    assertEquals(1L, actualWithFreshnessIndicatorResult.logicalFlowId());
    assertEquals(1L, actualWithFreshnessIndicatorResult.specificationId());
    assertEquals(EntityKind.ALL, actualWithFreshnessIndicatorResult.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE, actualWithFreshnessIndicatorResult.entityLifecycleStatus());
    assertEquals(
        FreshnessIndicator.NEVER_OBSERVED, actualWithFreshnessIndicatorResult.freshnessIndicator());
    assertFalse(actualWithFreshnessIndicatorResult.isReadOnly());
    assertFalse(actualWithFreshnessIndicatorResult.isRemoved());
    assertSame(criticality, actualWithFreshnessIndicatorResult.criticality());
    assertSame(frequency, actualWithFreshnessIndicatorResult.frequency());
    assertSame(transport, actualWithFreshnessIndicatorResult.transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlow ImmutablePhysicalFlow.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutablePhysicalFlow actualWithIdResult = immutablePhysicalFlow.withId(optional);

    // Assert
    assertSame(immutablePhysicalFlow, actualWithIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of forty-two.
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; when of forty-two; then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlow ImmutablePhysicalFlow.withId(Optional)"})
  void testWithIdWithOptional_whenOfFortyTwo_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder externalIdResult =
        createdResult
            .criticality(criticality)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(frequency)
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    TransportKindValue transport = TransportKindValue.of("42");
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(transport).build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutablePhysicalFlow actualWithIdResult = immutablePhysicalFlow.withId(optional);

    // Assert
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1, actualWithIdResult.basisOffset());
    assertEquals(1L, actualWithIdResult.logicalFlowId());
    assertEquals(1L, actualWithIdResult.specificationId());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithIdResult.entityLifecycleStatus());
    assertEquals(FreshnessIndicator.NEVER_OBSERVED, actualWithIdResult.freshnessIndicator());
    assertFalse(actualWithIdResult.isReadOnly());
    assertFalse(actualWithIdResult.isRemoved());
    assertSame(criticality, actualWithIdResult.criticality());
    assertSame(frequency, actualWithIdResult.frequency());
    assertSame(transport, actualWithIdResult.transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlow ImmutablePhysicalFlow.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlow actualWithIdResult = immutablePhysicalFlow.withId(1L);

    // Assert
    assertSame(immutablePhysicalFlow, actualWithIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; when forty-two; then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlow ImmutablePhysicalFlow.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder externalIdResult =
        createdResult
            .criticality(criticality)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(frequency)
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    TransportKindValue transport = TransportKindValue.of("42");

    // Act
    ImmutablePhysicalFlow actualWithIdResult =
        specificationIdResult.transport(transport).build().withId(42L);

    // Assert
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1, actualWithIdResult.basisOffset());
    assertEquals(1L, actualWithIdResult.logicalFlowId());
    assertEquals(1L, actualWithIdResult.specificationId());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithIdResult.entityLifecycleStatus());
    assertEquals(FreshnessIndicator.NEVER_OBSERVED, actualWithIdResult.freshnessIndicator());
    assertFalse(actualWithIdResult.isReadOnly());
    assertFalse(actualWithIdResult.isRemoved());
    assertSame(criticality, actualWithIdResult.criticality());
    assertSame(frequency, actualWithIdResult.frequency());
    assertSame(transport, actualWithIdResult.transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withIsReadOnly(boolean)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withIsReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test withIsReadOnly(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlow ImmutablePhysicalFlow.withIsReadOnly(boolean)"})
  void testWithIsReadOnly() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlow actualWithIsReadOnlyResult = immutablePhysicalFlow.withIsReadOnly(false);

    // Assert
    assertSame(immutablePhysicalFlow, actualWithIsReadOnlyResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withIsReadOnly(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withIsReadOnly(boolean)}
   */
  @Test
  @DisplayName(
      "Test withIsReadOnly(boolean); when 'true'; then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlow ImmutablePhysicalFlow.withIsReadOnly(boolean)"})
  void testWithIsReadOnly_whenTrue_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder externalIdResult =
        createdResult
            .criticality(criticality)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(frequency)
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    TransportKindValue transport = TransportKindValue.of("42");

    // Act
    ImmutablePhysicalFlow actualWithIsReadOnlyResult =
        specificationIdResult.transport(transport).build().withIsReadOnly(true);

    // Assert
    assertEquals("2020-03-01", actualWithIsReadOnlyResult.lastUpdatedBy());
    assertEquals("Name", actualWithIsReadOnlyResult.name());
    assertEquals("Provenance", actualWithIsReadOnlyResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithIsReadOnlyResult.description());
    assertEquals(1, actualWithIsReadOnlyResult.basisOffset());
    assertEquals(1L, actualWithIsReadOnlyResult.logicalFlowId());
    assertEquals(1L, actualWithIsReadOnlyResult.specificationId());
    assertEquals(EntityKind.ALL, actualWithIsReadOnlyResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithIsReadOnlyResult.entityLifecycleStatus());
    assertEquals(
        FreshnessIndicator.NEVER_OBSERVED, actualWithIsReadOnlyResult.freshnessIndicator());
    assertFalse(actualWithIsReadOnlyResult.isRemoved());
    assertTrue(actualWithIsReadOnlyResult.isReadOnly());
    assertSame(criticality, actualWithIsReadOnlyResult.criticality());
    assertSame(frequency, actualWithIsReadOnlyResult.frequency());
    assertSame(transport, actualWithIsReadOnlyResult.transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withIsRemoved(boolean)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withIsRemoved(boolean)}
   */
  @Test
  @DisplayName("Test withIsRemoved(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlow ImmutablePhysicalFlow.withIsRemoved(boolean)"})
  void testWithIsRemoved() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlow actualWithIsRemovedResult = immutablePhysicalFlow.withIsRemoved(false);

    // Assert
    assertSame(immutablePhysicalFlow, actualWithIsRemovedResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withIsRemoved(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withIsRemoved(boolean)}
   */
  @Test
  @DisplayName(
      "Test withIsRemoved(boolean); when 'true'; then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlow ImmutablePhysicalFlow.withIsRemoved(boolean)"})
  void testWithIsRemoved_whenTrue_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder externalIdResult =
        createdResult
            .criticality(criticality)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(frequency)
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    TransportKindValue transport = TransportKindValue.of("42");

    // Act
    ImmutablePhysicalFlow actualWithIsRemovedResult =
        specificationIdResult.transport(transport).build().withIsRemoved(true);

    // Assert
    assertEquals("2020-03-01", actualWithIsRemovedResult.lastUpdatedBy());
    assertEquals("Name", actualWithIsRemovedResult.name());
    assertEquals("Provenance", actualWithIsRemovedResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithIsRemovedResult.description());
    assertEquals(1, actualWithIsRemovedResult.basisOffset());
    assertEquals(1L, actualWithIsRemovedResult.logicalFlowId());
    assertEquals(1L, actualWithIsRemovedResult.specificationId());
    assertEquals(EntityKind.ALL, actualWithIsRemovedResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithIsRemovedResult.entityLifecycleStatus());
    assertEquals(FreshnessIndicator.NEVER_OBSERVED, actualWithIsRemovedResult.freshnessIndicator());
    assertFalse(actualWithIsRemovedResult.isReadOnly());
    assertTrue(actualWithIsRemovedResult.isRemoved());
    assertSame(criticality, actualWithIsRemovedResult.criticality());
    assertSame(frequency, actualWithIsRemovedResult.frequency());
    assertSame(transport, actualWithIsRemovedResult.transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlow ImmutablePhysicalFlow.withKind(EntityKind)"})
  void testWithKind() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlow actualWithKindResult = immutablePhysicalFlow.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutablePhysicalFlow, actualWithKindResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind); then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlow ImmutablePhysicalFlow.withKind(EntityKind)"})
  void testWithKind_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder externalIdResult =
        createdResult
            .criticality(criticality)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(frequency)
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ACTOR)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    TransportKindValue transport = TransportKindValue.of("42");

    // Act
    ImmutablePhysicalFlow actualWithKindResult =
        specificationIdResult.transport(transport).build().withKind(EntityKind.ALL);

    // Assert
    assertEquals("2020-03-01", actualWithKindResult.lastUpdatedBy());
    assertEquals("Name", actualWithKindResult.name());
    assertEquals("Provenance", actualWithKindResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithKindResult.description());
    assertEquals(1, actualWithKindResult.basisOffset());
    assertEquals(1L, actualWithKindResult.logicalFlowId());
    assertEquals(1L, actualWithKindResult.specificationId());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithKindResult.entityLifecycleStatus());
    assertEquals(FreshnessIndicator.NEVER_OBSERVED, actualWithKindResult.freshnessIndicator());
    assertFalse(actualWithKindResult.isReadOnly());
    assertFalse(actualWithKindResult.isRemoved());
    assertSame(criticality, actualWithKindResult.criticality());
    assertSame(frequency, actualWithKindResult.frequency());
    assertSame(transport, actualWithKindResult.transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withLastAttestedAt(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withLastAttestedAt(Optional)}
   */
  @Test
  @DisplayName("Test withLastAttestedAt(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlow ImmutablePhysicalFlow.withLastAttestedAt(Optional)"})
  void testWithLastAttestedAtWithOptional() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();
    Optional<? extends LocalDateTime> optional =
        Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    ImmutablePhysicalFlow actualWithLastAttestedAtResult =
        immutablePhysicalFlow.withLastAttestedAt(optional);

    // Assert
    assertEquals(immutablePhysicalFlow, actualWithLastAttestedAtResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withLastAttestedAt(LocalDateTime)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withLastAttestedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastAttestedAt(LocalDateTime) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlow ImmutablePhysicalFlow.withLastAttestedAt(LocalDateTime)"
  })
  void testWithLastAttestedAtWithValue() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlow actualWithLastAttestedAtResult =
        immutablePhysicalFlow.withLastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutablePhysicalFlow, actualWithLastAttestedAtResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withLastAttestedBy(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withLastAttestedBy(Optional)}
   */
  @Test
  @DisplayName("Test withLastAttestedBy(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlow ImmutablePhysicalFlow.withLastAttestedBy(Optional)"})
  void testWithLastAttestedByWithOptional() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutablePhysicalFlow actualWithLastAttestedByResult =
        immutablePhysicalFlow.withLastAttestedBy(optional);

    // Assert
    assertSame(immutablePhysicalFlow, actualWithLastAttestedByResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withLastAttestedBy(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withLastAttestedBy(Optional)}
   */
  @Test
  @DisplayName(
      "Test withLastAttestedBy(Optional) with 'optional'; then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlow ImmutablePhysicalFlow.withLastAttestedBy(Optional)"})
  void testWithLastAttestedByWithOptional_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder externalIdResult =
        createdResult
            .criticality(criticality)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(frequency)
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    TransportKindValue transport = TransportKindValue.of("42");
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(transport).build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutablePhysicalFlow actualWithLastAttestedByResult =
        immutablePhysicalFlow.withLastAttestedBy(optional);

    // Assert
    assertEquals("2020-03-01", actualWithLastAttestedByResult.lastUpdatedBy());
    assertEquals("Name", actualWithLastAttestedByResult.name());
    assertEquals("Provenance", actualWithLastAttestedByResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithLastAttestedByResult.description());
    assertEquals(1, actualWithLastAttestedByResult.basisOffset());
    assertEquals(1L, actualWithLastAttestedByResult.logicalFlowId());
    assertEquals(1L, actualWithLastAttestedByResult.specificationId());
    assertEquals(EntityKind.ALL, actualWithLastAttestedByResult.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE, actualWithLastAttestedByResult.entityLifecycleStatus());
    assertEquals(
        FreshnessIndicator.NEVER_OBSERVED, actualWithLastAttestedByResult.freshnessIndicator());
    assertFalse(actualWithLastAttestedByResult.isReadOnly());
    assertFalse(actualWithLastAttestedByResult.isRemoved());
    assertSame(criticality, actualWithLastAttestedByResult.criticality());
    assertSame(frequency, actualWithLastAttestedByResult.frequency());
    assertSame(transport, actualWithLastAttestedByResult.transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withLastAttestedBy(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withLastAttestedBy(String)}
   */
  @Test
  @DisplayName("Test withLastAttestedBy(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlow ImmutablePhysicalFlow.withLastAttestedBy(String)"})
  void testWithLastAttestedByWithValue() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlow actualWithLastAttestedByResult =
        immutablePhysicalFlow.withLastAttestedBy("42");

    // Assert
    assertSame(immutablePhysicalFlow, actualWithLastAttestedByResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withLastAttestedBy(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withLastAttestedBy(String)}
   */
  @Test
  @DisplayName(
      "Test withLastAttestedBy(String) with 'value'; then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlow ImmutablePhysicalFlow.withLastAttestedBy(String)"})
  void testWithLastAttestedByWithValue_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder externalIdResult =
        createdResult
            .criticality(criticality)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(frequency)
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    TransportKindValue transport = TransportKindValue.of("42");

    // Act
    ImmutablePhysicalFlow actualWithLastAttestedByResult =
        specificationIdResult.transport(transport).build().withLastAttestedBy("42");

    // Assert
    assertEquals("2020-03-01", actualWithLastAttestedByResult.lastUpdatedBy());
    assertEquals("Name", actualWithLastAttestedByResult.name());
    assertEquals("Provenance", actualWithLastAttestedByResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithLastAttestedByResult.description());
    assertEquals(1, actualWithLastAttestedByResult.basisOffset());
    assertEquals(1L, actualWithLastAttestedByResult.logicalFlowId());
    assertEquals(1L, actualWithLastAttestedByResult.specificationId());
    assertEquals(EntityKind.ALL, actualWithLastAttestedByResult.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE, actualWithLastAttestedByResult.entityLifecycleStatus());
    assertEquals(
        FreshnessIndicator.NEVER_OBSERVED, actualWithLastAttestedByResult.freshnessIndicator());
    assertFalse(actualWithLastAttestedByResult.isReadOnly());
    assertFalse(actualWithLastAttestedByResult.isRemoved());
    assertSame(criticality, actualWithLastAttestedByResult.criticality());
    assertSame(frequency, actualWithLastAttestedByResult.frequency());
    assertSame(transport, actualWithLastAttestedByResult.transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlow ImmutablePhysicalFlow.withLastUpdatedAt(LocalDateTime)"
  })
  void testWithLastUpdatedAt() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlow actualWithLastUpdatedAtResult =
        immutablePhysicalFlow.withLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutablePhysicalFlow, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlow ImmutablePhysicalFlow.withLastUpdatedBy(String)"})
  void testWithLastUpdatedBy() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("42")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlow actualWithLastUpdatedByResult =
        immutablePhysicalFlow.withLastUpdatedBy("42");

    // Assert
    assertSame(immutablePhysicalFlow, actualWithLastUpdatedByResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withLastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String); then return lastUpdatedBy is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlow ImmutablePhysicalFlow.withLastUpdatedBy(String)"})
  void testWithLastUpdatedBy_thenReturnLastUpdatedByIs42() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder externalIdResult =
        createdResult
            .criticality(criticality)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(frequency)
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    TransportKindValue transport = TransportKindValue.of("42");

    // Act
    ImmutablePhysicalFlow actualWithLastUpdatedByResult =
        specificationIdResult.transport(transport).build().withLastUpdatedBy("42");

    // Assert
    assertEquals("42", actualWithLastUpdatedByResult.lastUpdatedBy());
    assertEquals("Name", actualWithLastUpdatedByResult.name());
    assertEquals("Provenance", actualWithLastUpdatedByResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithLastUpdatedByResult.description());
    assertEquals(1, actualWithLastUpdatedByResult.basisOffset());
    assertEquals(1L, actualWithLastUpdatedByResult.logicalFlowId());
    assertEquals(1L, actualWithLastUpdatedByResult.specificationId());
    assertEquals(EntityKind.ALL, actualWithLastUpdatedByResult.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE, actualWithLastUpdatedByResult.entityLifecycleStatus());
    assertEquals(
        FreshnessIndicator.NEVER_OBSERVED, actualWithLastUpdatedByResult.freshnessIndicator());
    assertFalse(actualWithLastUpdatedByResult.isReadOnly());
    assertFalse(actualWithLastUpdatedByResult.isRemoved());
    assertSame(criticality, actualWithLastUpdatedByResult.criticality());
    assertSame(frequency, actualWithLastUpdatedByResult.frequency());
    assertSame(transport, actualWithLastUpdatedByResult.transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withLogicalFlowId(long)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withLogicalFlowId(long)}
   */
  @Test
  @DisplayName("Test withLogicalFlowId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlow ImmutablePhysicalFlow.withLogicalFlowId(long)"})
  void testWithLogicalFlowId() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(42L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlow actualWithLogicalFlowIdResult =
        immutablePhysicalFlow.withLogicalFlowId(42L);

    // Assert
    assertSame(immutablePhysicalFlow, actualWithLogicalFlowIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withLogicalFlowId(long)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withLogicalFlowId(long)}
   */
  @Test
  @DisplayName("Test withLogicalFlowId(long); then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlow ImmutablePhysicalFlow.withLogicalFlowId(long)"})
  void testWithLogicalFlowId_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder externalIdResult =
        createdResult
            .criticality(criticality)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(frequency)
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    TransportKindValue transport = TransportKindValue.of("42");

    // Act
    ImmutablePhysicalFlow actualWithLogicalFlowIdResult =
        specificationIdResult.transport(transport).build().withLogicalFlowId(42L);

    // Assert
    assertEquals("2020-03-01", actualWithLogicalFlowIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithLogicalFlowIdResult.name());
    assertEquals("Provenance", actualWithLogicalFlowIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithLogicalFlowIdResult.description());
    assertEquals(1, actualWithLogicalFlowIdResult.basisOffset());
    assertEquals(1L, actualWithLogicalFlowIdResult.specificationId());
    assertEquals(42L, actualWithLogicalFlowIdResult.logicalFlowId());
    assertEquals(EntityKind.ALL, actualWithLogicalFlowIdResult.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE, actualWithLogicalFlowIdResult.entityLifecycleStatus());
    assertEquals(
        FreshnessIndicator.NEVER_OBSERVED, actualWithLogicalFlowIdResult.freshnessIndicator());
    assertFalse(actualWithLogicalFlowIdResult.isReadOnly());
    assertFalse(actualWithLogicalFlowIdResult.isRemoved());
    assertSame(criticality, actualWithLogicalFlowIdResult.criticality());
    assertSame(frequency, actualWithLogicalFlowIdResult.frequency());
    assertSame(transport, actualWithLogicalFlowIdResult.transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withName(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlow ImmutablePhysicalFlow.withName(String)"})
  void testWithName() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("42")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlow actualWithNameResult = immutablePhysicalFlow.withName("42");

    // Assert
    assertSame(immutablePhysicalFlow, actualWithNameResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withName(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlow ImmutablePhysicalFlow.withName(String)"})
  void testWithName_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder externalIdResult =
        createdResult
            .criticality(criticality)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(frequency)
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    TransportKindValue transport = TransportKindValue.of("42");

    // Act
    ImmutablePhysicalFlow actualWithNameResult =
        specificationIdResult.transport(transport).build().withName("42");

    // Assert
    assertEquals("2020-03-01", actualWithNameResult.lastUpdatedBy());
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Provenance", actualWithNameResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(1, actualWithNameResult.basisOffset());
    assertEquals(1L, actualWithNameResult.logicalFlowId());
    assertEquals(1L, actualWithNameResult.specificationId());
    assertEquals(EntityKind.ALL, actualWithNameResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithNameResult.entityLifecycleStatus());
    assertEquals(FreshnessIndicator.NEVER_OBSERVED, actualWithNameResult.freshnessIndicator());
    assertFalse(actualWithNameResult.isReadOnly());
    assertFalse(actualWithNameResult.isRemoved());
    assertSame(criticality, actualWithNameResult.criticality());
    assertSame(frequency, actualWithNameResult.frequency());
    assertSame(transport, actualWithNameResult.transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlow ImmutablePhysicalFlow.withProvenance(String)"})
  void testWithProvenance() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("42")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlow actualWithProvenanceResult = immutablePhysicalFlow.withProvenance("42");

    // Assert
    assertSame(immutablePhysicalFlow, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String); then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlow ImmutablePhysicalFlow.withProvenance(String)"})
  void testWithProvenance_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder externalIdResult =
        createdResult
            .criticality(criticality)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(frequency)
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    TransportKindValue transport = TransportKindValue.of("42");

    // Act
    ImmutablePhysicalFlow actualWithProvenanceResult =
        specificationIdResult.transport(transport).build().withProvenance("42");

    // Assert
    assertEquals("2020-03-01", actualWithProvenanceResult.lastUpdatedBy());
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals("Name", actualWithProvenanceResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithProvenanceResult.description());
    assertEquals(1, actualWithProvenanceResult.basisOffset());
    assertEquals(1L, actualWithProvenanceResult.logicalFlowId());
    assertEquals(1L, actualWithProvenanceResult.specificationId());
    assertEquals(EntityKind.ALL, actualWithProvenanceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithProvenanceResult.entityLifecycleStatus());
    assertEquals(
        FreshnessIndicator.NEVER_OBSERVED, actualWithProvenanceResult.freshnessIndicator());
    assertFalse(actualWithProvenanceResult.isReadOnly());
    assertFalse(actualWithProvenanceResult.isRemoved());
    assertSame(criticality, actualWithProvenanceResult.criticality());
    assertSame(frequency, actualWithProvenanceResult.frequency());
    assertSame(transport, actualWithProvenanceResult.transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withSpecificationDefinitionId(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withSpecificationDefinitionId(Optional)}
   */
  @Test
  @DisplayName("Test withSpecificationDefinitionId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlow ImmutablePhysicalFlow.withSpecificationDefinitionId(Optional)"
  })
  void testWithSpecificationDefinitionIdWithOptional() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutablePhysicalFlow actualWithSpecificationDefinitionIdResult =
        immutablePhysicalFlow.withSpecificationDefinitionId(optional);

    // Assert
    assertSame(immutablePhysicalFlow, actualWithSpecificationDefinitionIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withSpecificationDefinitionId(Optional)} with {@code
   * optional}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withSpecificationDefinitionId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withSpecificationDefinitionId(Optional) with 'optional'; then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlow ImmutablePhysicalFlow.withSpecificationDefinitionId(Optional)"
  })
  void testWithSpecificationDefinitionIdWithOptional_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder externalIdResult =
        createdResult
            .criticality(criticality)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(frequency)
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    TransportKindValue transport = TransportKindValue.of("42");
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(transport).build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutablePhysicalFlow actualWithSpecificationDefinitionIdResult =
        immutablePhysicalFlow.withSpecificationDefinitionId(optional);

    // Assert
    assertEquals("2020-03-01", actualWithSpecificationDefinitionIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithSpecificationDefinitionIdResult.name());
    assertEquals("Provenance", actualWithSpecificationDefinitionIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithSpecificationDefinitionIdResult.description());
    assertEquals(1, actualWithSpecificationDefinitionIdResult.basisOffset());
    assertEquals(1L, actualWithSpecificationDefinitionIdResult.logicalFlowId());
    assertEquals(1L, actualWithSpecificationDefinitionIdResult.specificationId());
    assertEquals(EntityKind.ALL, actualWithSpecificationDefinitionIdResult.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE,
        actualWithSpecificationDefinitionIdResult.entityLifecycleStatus());
    assertEquals(
        FreshnessIndicator.NEVER_OBSERVED,
        actualWithSpecificationDefinitionIdResult.freshnessIndicator());
    assertFalse(actualWithSpecificationDefinitionIdResult.isReadOnly());
    assertFalse(actualWithSpecificationDefinitionIdResult.isRemoved());
    assertSame(criticality, actualWithSpecificationDefinitionIdResult.criticality());
    assertSame(frequency, actualWithSpecificationDefinitionIdResult.frequency());
    assertSame(transport, actualWithSpecificationDefinitionIdResult.transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withSpecificationDefinitionId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withSpecificationDefinitionId(long)}
   */
  @Test
  @DisplayName("Test withSpecificationDefinitionId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlow ImmutablePhysicalFlow.withSpecificationDefinitionId(long)"
  })
  void testWithSpecificationDefinitionIdWithValue() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlow actualWithSpecificationDefinitionIdResult =
        immutablePhysicalFlow.withSpecificationDefinitionId(1L);

    // Assert
    assertSame(immutablePhysicalFlow, actualWithSpecificationDefinitionIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withSpecificationDefinitionId(long)} with {@code value}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withSpecificationDefinitionId(long)}
   */
  @Test
  @DisplayName(
      "Test withSpecificationDefinitionId(long) with 'value'; then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlow ImmutablePhysicalFlow.withSpecificationDefinitionId(long)"
  })
  void testWithSpecificationDefinitionIdWithValue_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder externalIdResult =
        createdResult
            .criticality(criticality)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(frequency)
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    TransportKindValue transport = TransportKindValue.of("42");

    // Act
    ImmutablePhysicalFlow actualWithSpecificationDefinitionIdResult =
        specificationIdResult.transport(transport).build().withSpecificationDefinitionId(42L);

    // Assert
    assertEquals("2020-03-01", actualWithSpecificationDefinitionIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithSpecificationDefinitionIdResult.name());
    assertEquals("Provenance", actualWithSpecificationDefinitionIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithSpecificationDefinitionIdResult.description());
    assertEquals(1, actualWithSpecificationDefinitionIdResult.basisOffset());
    assertEquals(1L, actualWithSpecificationDefinitionIdResult.logicalFlowId());
    assertEquals(1L, actualWithSpecificationDefinitionIdResult.specificationId());
    assertEquals(EntityKind.ALL, actualWithSpecificationDefinitionIdResult.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE,
        actualWithSpecificationDefinitionIdResult.entityLifecycleStatus());
    assertEquals(
        FreshnessIndicator.NEVER_OBSERVED,
        actualWithSpecificationDefinitionIdResult.freshnessIndicator());
    assertFalse(actualWithSpecificationDefinitionIdResult.isReadOnly());
    assertFalse(actualWithSpecificationDefinitionIdResult.isRemoved());
    assertSame(criticality, actualWithSpecificationDefinitionIdResult.criticality());
    assertSame(frequency, actualWithSpecificationDefinitionIdResult.frequency());
    assertSame(transport, actualWithSpecificationDefinitionIdResult.transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withSpecificationId(long)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withSpecificationId(long)}
   */
  @Test
  @DisplayName("Test withSpecificationId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlow ImmutablePhysicalFlow.withSpecificationId(long)"})
  void testWithSpecificationId() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(42L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlow actualWithSpecificationIdResult =
        immutablePhysicalFlow.withSpecificationId(42L);

    // Assert
    assertSame(immutablePhysicalFlow, actualWithSpecificationIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withSpecificationId(long)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withSpecificationId(long)}
   */
  @Test
  @DisplayName("Test withSpecificationId(long); then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlow ImmutablePhysicalFlow.withSpecificationId(long)"})
  void testWithSpecificationId_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder externalIdResult =
        createdResult
            .criticality(criticality)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(frequency)
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    TransportKindValue transport = TransportKindValue.of("42");

    // Act
    ImmutablePhysicalFlow actualWithSpecificationIdResult =
        specificationIdResult.transport(transport).build().withSpecificationId(42L);

    // Assert
    assertEquals("2020-03-01", actualWithSpecificationIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithSpecificationIdResult.name());
    assertEquals("Provenance", actualWithSpecificationIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithSpecificationIdResult.description());
    assertEquals(1, actualWithSpecificationIdResult.basisOffset());
    assertEquals(1L, actualWithSpecificationIdResult.logicalFlowId());
    assertEquals(42L, actualWithSpecificationIdResult.specificationId());
    assertEquals(EntityKind.ALL, actualWithSpecificationIdResult.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE, actualWithSpecificationIdResult.entityLifecycleStatus());
    assertEquals(
        FreshnessIndicator.NEVER_OBSERVED, actualWithSpecificationIdResult.freshnessIndicator());
    assertFalse(actualWithSpecificationIdResult.isReadOnly());
    assertFalse(actualWithSpecificationIdResult.isRemoved());
    assertSame(criticality, actualWithSpecificationIdResult.criticality());
    assertSame(frequency, actualWithSpecificationIdResult.frequency());
    assertSame(transport, actualWithSpecificationIdResult.transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlow#withTransport(TransportKindValue)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlow#withTransport(TransportKindValue)}
   */
  @Test
  @DisplayName("Test withTransport(TransportKindValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlow ImmutablePhysicalFlow.withTransport(TransportKindValue)"
  })
  void testWithTransport() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow immutablePhysicalFlow =
        specificationIdResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlow actualWithTransportResult =
        immutablePhysicalFlow.withTransport(TransportKindValue.of("42"));

    // Assert
    assertEquals(immutablePhysicalFlow, actualWithTransportResult);
  }
}
