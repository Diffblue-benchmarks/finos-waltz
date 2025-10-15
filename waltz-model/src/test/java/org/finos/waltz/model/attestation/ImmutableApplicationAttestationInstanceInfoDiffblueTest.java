package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.attestation.ImmutableApplicationAttestationInstanceInfo.Json;
import org.finos.waltz.model.attestation.ImmutableApplicationAttestationSummaryFilters.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableApplicationAttestationInstanceInfoDiffblueTest {
  /**
   * Test Builder {@link ImmutableApplicationAttestationInstanceInfo.Builder#build()}.
   *
   * <p>Method under test: {@link ImmutableApplicationAttestationInstanceInfo.Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationAttestationInstanceInfo ImmutableApplicationAttestationInstanceInfo.Builder.build()"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableApplicationAttestationInstanceInfo.Builder actualBuilderResult =
        ImmutableApplicationAttestationInstanceInfo.builder();
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);
    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);
    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    ImmutableApplicationAttestationSummaryFilters filters =
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(LocalDate.of(1970, 1, 1))
            .build();
    ImmutableApplicationAttestationInstanceInfo.Builder actualFiltersResult =
        actualBuilderResult.filters(filters);
    ImmutableIdSelectionOptions.Builder builderResult2 = ImmutableIdSelectionOptions.builder();
    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);
    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions selectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    ImmutableApplicationAttestationInstanceInfo actualImmutableApplicationAttestationInstanceInfo =
        actualFiltersResult.selectionOptions(selectionOptions).build();

    // Assert
    ApplicationAttestationSummaryFilters filtersResult2 =
        actualImmutableApplicationAttestationInstanceInfo.filters();
    assertTrue(filtersResult2 instanceof ImmutableApplicationAttestationSummaryFilters);
    assertSame(
        selectionOptions, actualImmutableApplicationAttestationInstanceInfo.selectionOptions());
    assertSame(filters, filtersResult2);
  }

  /**
   * Test Builder {@link
   * ImmutableApplicationAttestationInstanceInfo.Builder#filters(ApplicationAttestationSummaryFilters)}.
   *
   * <ul>
   *   <li>When {@link ImmutableApplicationAttestationSummaryFilters.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableApplicationAttestationInstanceInfo.Builder#filters(ApplicationAttestationSummaryFilters)}
   */
  @Test
  @DisplayName(
      "Test Builder filters(ApplicationAttestationSummaryFilters); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationAttestationInstanceInfo.Builder ImmutableApplicationAttestationInstanceInfo.Builder.filters(ApplicationAttestationSummaryFilters)"
  })
  void testBuilderFilters_whenJson_thenReturnBuilder() {
    // Arrange
    ImmutableApplicationAttestationInstanceInfo.Builder builderResult =
        ImmutableApplicationAttestationInstanceInfo.builder();

    // Act
    ImmutableApplicationAttestationInstanceInfo.Builder actualFiltersResult =
        builderResult.filters(new ImmutableApplicationAttestationSummaryFilters.Json());

    // Assert
    assertSame(builderResult, actualFiltersResult);
  }

  /**
   * Test Builder {@link
   * ImmutableApplicationAttestationInstanceInfo.Builder#from(ApplicationAttestationInstanceInfo)}.
   *
   * <p>Method under test: {@link
   * ImmutableApplicationAttestationInstanceInfo.Builder#from(ApplicationAttestationInstanceInfo)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationAttestationInstanceInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationAttestationInstanceInfo.Builder ImmutableApplicationAttestationInstanceInfo.Builder.from(ApplicationAttestationInstanceInfo)"
  })
  void testBuilderFrom() {
    // Arrange
    ImmutableApplicationAttestationInstanceInfo.Builder builderResult =
        ImmutableApplicationAttestationInstanceInfo.builder();

    ImmutableApplicationAttestationInstanceInfo.Builder builderResult2 =
        ImmutableApplicationAttestationInstanceInfo.builder();

    Builder builderResult3 = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult3.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    ImmutableApplicationAttestationInstanceInfo.Builder filtersResult =
        builderResult2.filters(
            appLifecyclePhaseResult
                .attestationState(attestationState)
                .attestationsFromDate(LocalDate.of(1970, 1, 1))
                .build());

    ImmutableIdSelectionOptions.Builder builderResult4 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult2 =
        builderResult4
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult2.joiningEntityKind(joiningEntityKind);
    ImmutableApplicationAttestationInstanceInfo instance =
        filtersResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    // Act
    ImmutableApplicationAttestationInstanceInfo.Builder actualFromResult =
        builderResult.from(instance);

    // Assert
    ImmutableApplicationAttestationInstanceInfo actualImmutableApplicationAttestationInstanceInfo =
        builderResult.build();
    assertEquals(instance, actualImmutableApplicationAttestationInstanceInfo);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link
   * ImmutableApplicationAttestationInstanceInfo.Builder#selectionOptions(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@link IdSelectionOptions}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableApplicationAttestationInstanceInfo.Builder#selectionOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test Builder selectionOptions(IdSelectionOptions); when IdSelectionOptions; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationAttestationInstanceInfo.Builder ImmutableApplicationAttestationInstanceInfo.Builder.selectionOptions(IdSelectionOptions)"
  })
  void testBuilderSelectionOptions_whenIdSelectionOptions_thenReturnBuilder() {
    // Arrange
    ImmutableApplicationAttestationInstanceInfo.Builder builderResult =
        ImmutableApplicationAttestationInstanceInfo.builder();

    // Act
    ImmutableApplicationAttestationInstanceInfo.Builder actualSelectionOptionsResult =
        builderResult.selectionOptions(mock(IdSelectionOptions.class));

    // Assert
    assertSame(builderResult, actualSelectionOptionsResult);
  }

  /**
   * Test {@link
   * ImmutableApplicationAttestationInstanceInfo#copyOf(ApplicationAttestationInstanceInfo)}.
   *
   * <ul>
   *   <li>Then selectionOptions entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableApplicationAttestationInstanceInfo#copyOf(ApplicationAttestationInstanceInfo)}
   */
  @Test
  @DisplayName(
      "Test copyOf(ApplicationAttestationInstanceInfo); then selectionOptions entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationAttestationInstanceInfo ImmutableApplicationAttestationInstanceInfo.copyOf(ApplicationAttestationInstanceInfo)"
  })
  void testCopyOf_thenSelectionOptionsEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    ImmutableApplicationAttestationInstanceInfo.Builder builderResult =
        ImmutableApplicationAttestationInstanceInfo.builder();

    Builder builderResult2 = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult2.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    ImmutableApplicationAttestationInstanceInfo.Builder filtersResult =
        builderResult.filters(
            appLifecyclePhaseResult
                .attestationState(attestationState)
                .attestationsFromDate(LocalDate.of(1970, 1, 1))
                .build());

    ImmutableIdSelectionOptions.Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult2 =
        builderResult3
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult2.joiningEntityKind(joiningEntityKind);
    ImmutableApplicationAttestationInstanceInfo instance =
        filtersResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    // Act
    ImmutableApplicationAttestationInstanceInfo actualCopyOfResult =
        ImmutableApplicationAttestationInstanceInfo.copyOf(instance);

    // Assert
    IdSelectionOptions selectionOptionsResult = actualCopyOfResult.selectionOptions();
    EntityReference entityReferenceResult = selectionOptionsResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(selectionOptionsResult instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult3 = selectionOptionsResult.filters();
    assertTrue(filtersResult3 instanceof ImmutableSelectionFilters);
    assertTrue(
        actualCopyOfResult.filters() instanceof ImmutableApplicationAttestationSummaryFilters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, selectionOptionsResult.scope());
    assertTrue(selectionOptionsResult.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult3.omitApplicationKinds().isEmpty());
  }

  /**
   * Test {@link ImmutableApplicationAttestationInstanceInfo#equals(Object)}, and {@link
   * ImmutableApplicationAttestationInstanceInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableApplicationAttestationInstanceInfo#equals(Object)}
   *   <li>{@link ImmutableApplicationAttestationInstanceInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationAttestationInstanceInfo.equals(Object)",
    "int ImmutableApplicationAttestationInstanceInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableApplicationAttestationInstanceInfo.Builder builderResult =
        ImmutableApplicationAttestationInstanceInfo.builder();

    Builder builderResult2 = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult2.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    ImmutableApplicationAttestationInstanceInfo.Builder filtersResult =
        builderResult.filters(
            appLifecyclePhaseResult
                .attestationState(attestationState)
                .attestationsFromDate(LocalDate.of(1970, 1, 1))
                .build());

    ImmutableIdSelectionOptions.Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult2 =
        builderResult3
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult2.joiningEntityKind(joiningEntityKind);
    ImmutableApplicationAttestationInstanceInfo immutableApplicationAttestationInstanceInfo =
        filtersResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    ImmutableApplicationAttestationInstanceInfo.Builder builderResult4 =
        ImmutableApplicationAttestationInstanceInfo.builder();

    Builder builderResult5 = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality2 = Optional.of(Criticality.LOW);

    Builder appCriticalityResult2 = builderResult5.appCriticality(appCriticality2);
    Optional<? extends LifecyclePhase> appLifecyclePhase2 = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult2 = appCriticalityResult2.appLifecyclePhase(appLifecyclePhase2);
    Optional<? extends AttestationState> attestationState2 = Optional.of(AttestationState.ATTESTED);

    ImmutableApplicationAttestationInstanceInfo.Builder filtersResult3 =
        builderResult4.filters(
            appLifecyclePhaseResult2
                .attestationState(attestationState2)
                .attestationsFromDate(LocalDate.of(1970, 1, 1))
                .build());

    ImmutableIdSelectionOptions.Builder builderResult6 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult4 =
        builderResult6
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult2 =
        filtersResult4.joiningEntityKind(joiningEntityKind2);
    ImmutableApplicationAttestationInstanceInfo immutableApplicationAttestationInstanceInfo2 =
        filtersResult3
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    // Act and Assert
    assertEquals(
        immutableApplicationAttestationInstanceInfo, immutableApplicationAttestationInstanceInfo2);
    assertEquals(
        immutableApplicationAttestationInstanceInfo.hashCode(),
        immutableApplicationAttestationInstanceInfo2.hashCode());
  }

  /**
   * Test {@link ImmutableApplicationAttestationInstanceInfo#equals(Object)}, and {@link
   * ImmutableApplicationAttestationInstanceInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableApplicationAttestationInstanceInfo#equals(Object)}
   *   <li>{@link ImmutableApplicationAttestationInstanceInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationAttestationInstanceInfo.equals(Object)",
    "int ImmutableApplicationAttestationInstanceInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableApplicationAttestationInstanceInfo.Builder builderResult =
        ImmutableApplicationAttestationInstanceInfo.builder();

    Builder builderResult2 = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult2.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    ImmutableApplicationAttestationInstanceInfo.Builder filtersResult =
        builderResult.filters(
            appLifecyclePhaseResult
                .attestationState(attestationState)
                .attestationsFromDate(LocalDate.of(1970, 1, 1))
                .build());

    ImmutableIdSelectionOptions.Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult2 =
        builderResult3
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult2.joiningEntityKind(joiningEntityKind);
    ImmutableApplicationAttestationInstanceInfo immutableApplicationAttestationInstanceInfo =
        filtersResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    // Act and Assert
    assertEquals(
        immutableApplicationAttestationInstanceInfo, immutableApplicationAttestationInstanceInfo);
    int expectedHashCodeResult = immutableApplicationAttestationInstanceInfo.hashCode();
    assertEquals(expectedHashCodeResult, immutableApplicationAttestationInstanceInfo.hashCode());
  }

  /**
   * Test {@link ImmutableApplicationAttestationInstanceInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationAttestationInstanceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationAttestationInstanceInfo.equals(Object)",
    "int ImmutableApplicationAttestationInstanceInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableApplicationAttestationInstanceInfo.Builder builderResult =
        ImmutableApplicationAttestationInstanceInfo.builder();

    Builder builderResult2 = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.MEDIUM);

    Builder appCriticalityResult = builderResult2.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    ImmutableApplicationAttestationInstanceInfo.Builder filtersResult =
        builderResult.filters(
            appLifecyclePhaseResult
                .attestationState(attestationState)
                .attestationsFromDate(LocalDate.of(1970, 1, 1))
                .build());

    ImmutableIdSelectionOptions.Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult2 =
        builderResult3
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult2.joiningEntityKind(joiningEntityKind);
    ImmutableApplicationAttestationInstanceInfo immutableApplicationAttestationInstanceInfo =
        filtersResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    ImmutableApplicationAttestationInstanceInfo.Builder builderResult4 =
        ImmutableApplicationAttestationInstanceInfo.builder();

    Builder builderResult5 = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality2 = Optional.of(Criticality.LOW);

    Builder appCriticalityResult2 = builderResult5.appCriticality(appCriticality2);
    Optional<? extends LifecyclePhase> appLifecyclePhase2 = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult2 = appCriticalityResult2.appLifecyclePhase(appLifecyclePhase2);
    Optional<? extends AttestationState> attestationState2 = Optional.of(AttestationState.ATTESTED);

    ImmutableApplicationAttestationInstanceInfo.Builder filtersResult3 =
        builderResult4.filters(
            appLifecyclePhaseResult2
                .attestationState(attestationState2)
                .attestationsFromDate(LocalDate.of(1970, 1, 1))
                .build());

    ImmutableIdSelectionOptions.Builder builderResult6 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult4 =
        builderResult6
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult2 =
        filtersResult4.joiningEntityKind(joiningEntityKind2);

    // Act and Assert
    assertNotEquals(
        immutableApplicationAttestationInstanceInfo,
        filtersResult3
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableApplicationAttestationInstanceInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationAttestationInstanceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationAttestationInstanceInfo.equals(Object)",
    "int ImmutableApplicationAttestationInstanceInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions selectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    ImmutableApplicationAttestationInstanceInfo.Builder builderResult2 =
        ImmutableApplicationAttestationInstanceInfo.builder();

    Builder builderResult3 = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult3.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    ImmutableApplicationAttestationInstanceInfo immutableApplicationAttestationInstanceInfo =
        builderResult2
            .filters(
                appLifecyclePhaseResult
                    .attestationState(attestationState)
                    .attestationsFromDate(LocalDate.of(1970, 1, 1))
                    .build())
            .selectionOptions(selectionOptions)
            .build();

    ImmutableApplicationAttestationInstanceInfo.Builder builderResult4 =
        ImmutableApplicationAttestationInstanceInfo.builder();

    Builder builderResult5 = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality2 = Optional.of(Criticality.LOW);

    Builder appCriticalityResult2 = builderResult5.appCriticality(appCriticality2);
    Optional<? extends LifecyclePhase> appLifecyclePhase2 = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult2 = appCriticalityResult2.appLifecyclePhase(appLifecyclePhase2);
    Optional<? extends AttestationState> attestationState2 = Optional.of(AttestationState.ATTESTED);

    ImmutableApplicationAttestationInstanceInfo.Builder filtersResult2 =
        builderResult4.filters(
            appLifecyclePhaseResult2
                .attestationState(attestationState2)
                .attestationsFromDate(LocalDate.of(1970, 1, 1))
                .build());

    ImmutableIdSelectionOptions.Builder builderResult6 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult3 =
        builderResult6
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult2 =
        filtersResult3.joiningEntityKind(joiningEntityKind2);

    // Act and Assert
    assertNotEquals(
        immutableApplicationAttestationInstanceInfo,
        filtersResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableApplicationAttestationInstanceInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationAttestationInstanceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationAttestationInstanceInfo.equals(Object)",
    "int ImmutableApplicationAttestationInstanceInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableApplicationAttestationInstanceInfo.Builder builderResult =
        ImmutableApplicationAttestationInstanceInfo.builder();

    Builder builderResult2 = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult2.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    ImmutableApplicationAttestationInstanceInfo.Builder filtersResult =
        builderResult.filters(
            appLifecyclePhaseResult
                .attestationState(attestationState)
                .attestationsFromDate(LocalDate.of(1970, 1, 1))
                .build());

    ImmutableIdSelectionOptions.Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult2 =
        builderResult3
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult2.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertNotEquals(
        filtersResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableApplicationAttestationInstanceInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationAttestationInstanceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationAttestationInstanceInfo.equals(Object)",
    "int ImmutableApplicationAttestationInstanceInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableApplicationAttestationInstanceInfo.Builder builderResult =
        ImmutableApplicationAttestationInstanceInfo.builder();

    Builder builderResult2 = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult2.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    ImmutableApplicationAttestationInstanceInfo.Builder filtersResult =
        builderResult.filters(
            appLifecyclePhaseResult
                .attestationState(attestationState)
                .attestationsFromDate(LocalDate.of(1970, 1, 1))
                .build());

    ImmutableIdSelectionOptions.Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult2 =
        builderResult3
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult2.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertNotEquals(
        filtersResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build(),
        "Different type to ImmutableApplicationAttestationInstanceInfo");
  }

  /**
   * Test {@link ImmutableApplicationAttestationInstanceInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then filters return {@link ImmutableApplicationAttestationSummaryFilters}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationAttestationInstanceInfo#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then filters return ImmutableApplicationAttestationSummaryFilters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationAttestationInstanceInfo ImmutableApplicationAttestationInstanceInfo.fromJson(Json)"
  })
  void testFromJson_thenFiltersReturnImmutableApplicationAttestationSummaryFilters() {
    // Arrange
    Json json = new Json();

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    json.setSelectionOptions(
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());

    Builder builderResult2 = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult2.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    json.setFilters(
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(LocalDate.of(1970, 1, 1))
            .build());

    // Act
    ImmutableApplicationAttestationInstanceInfo actualFromJsonResult =
        ImmutableApplicationAttestationInstanceInfo.fromJson(json);

    // Assert
    ApplicationAttestationSummaryFilters filtersResult2 = actualFromJsonResult.filters();
    assertTrue(filtersResult2 instanceof ImmutableApplicationAttestationSummaryFilters);
    assertSame(json.filters, filtersResult2);
    IdSelectionOptions expectedSelectionOptionsResult = json.selectionOptions;
    assertSame(expectedSelectionOptionsResult, actualFromJsonResult.selectionOptions());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableApplicationAttestationInstanceInfo#toString()}
   *   <li>{@link ImmutableApplicationAttestationInstanceInfo#filters()}
   *   <li>{@link ImmutableApplicationAttestationInstanceInfo#selectionOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationAttestationSummaryFilters ImmutableApplicationAttestationInstanceInfo.filters()",
    "IdSelectionOptions ImmutableApplicationAttestationInstanceInfo.selectionOptions()",
    "String ImmutableApplicationAttestationInstanceInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableApplicationAttestationInstanceInfo.Builder builderResult =
        ImmutableApplicationAttestationInstanceInfo.builder();

    Builder builderResult2 = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult2.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    ImmutableApplicationAttestationInstanceInfo.Builder filtersResult =
        builderResult.filters(
            appLifecyclePhaseResult
                .attestationState(attestationState)
                .attestationsFromDate(LocalDate.of(1970, 1, 1))
                .build());

    ImmutableIdSelectionOptions.Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult2 =
        builderResult3
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult2.joiningEntityKind(joiningEntityKind);
    ImmutableApplicationAttestationInstanceInfo immutableApplicationAttestationInstanceInfo =
        filtersResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableApplicationAttestationInstanceInfo.toString();
    ApplicationAttestationSummaryFilters actualFiltersResult =
        immutableApplicationAttestationInstanceInfo.filters();

    // Assert
    assertTrue(
        immutableApplicationAttestationInstanceInfo.selectionOptions()
            instanceof ImmutableIdSelectionOptions);
    assertTrue(actualFiltersResult instanceof ImmutableApplicationAttestationSummaryFilters);
    assertEquals(
        "ApplicationAttestationInstanceInfo{selectionOptions=IdSelectionOptions{entityReference=EntityReference"
            + "{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, scope=EXACT, joiningEntityKind=ALL, entityLifecycleStatuses"
            + "=[], filters=SelectionFilters{omitApplicationKinds=[]}}, filters=ApplicationAttestationSummaryFilters"
            + "{attestationsFromDate=1970-01-01, appLifecyclePhase=PRODUCTION, appCriticality=LOW, attestationState"
            + "=ATTESTED}}",
        actualToStringResult);
  }

  /**
   * Test Json {@link Json#filters()}.
   *
   * <p>Method under test: {@link Json#filters()}
   */
  @Test
  @DisplayName("Test Json filters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ApplicationAttestationSummaryFilters Json.filters()"})
  void testJsonFilters() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().filters());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setFilters(ApplicationAttestationSummaryFilters)}
   *   <li>{@link Json#setSelectionOptions(IdSelectionOptions)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setFilters(ApplicationAttestationSummaryFilters)",
    "void Json.setSelectionOptions(IdSelectionOptions)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    Builder builderResult = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);
    Builder appCriticalityResult = builderResult.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);
    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);
    actualJson.setFilters(
        appLifecyclePhaseResult
            .attestationState(attestationState)
            .attestationsFromDate(LocalDate.of(1970, 1, 1))
            .build());
    ImmutableIdSelectionOptions.Builder builderResult2 = ImmutableIdSelectionOptions.builder();
    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);
    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    actualJson.setSelectionOptions(
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());

    // Assert
    IdSelectionOptions idSelectionOptions = actualJson.selectionOptions;
    EntityReference entityReferenceResult = idSelectionOptions.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(idSelectionOptions instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult2 = idSelectionOptions.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    assertTrue(actualJson.filters instanceof ImmutableApplicationAttestationSummaryFilters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, idSelectionOptions.scope());
    assertTrue(idSelectionOptions.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
  }

  /**
   * Test Json {@link Json#selectionOptions()}.
   *
   * <p>Method under test: {@link Json#selectionOptions()}
   */
  @Test
  @DisplayName("Test Json selectionOptions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IdSelectionOptions Json.selectionOptions()"})
  void testJsonSelectionOptions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().selectionOptions());
  }

  /**
   * Test {@link
   * ImmutableApplicationAttestationInstanceInfo#withFilters(ApplicationAttestationSummaryFilters)}.
   *
   * <p>Method under test: {@link
   * ImmutableApplicationAttestationInstanceInfo#withFilters(ApplicationAttestationSummaryFilters)}
   */
  @Test
  @DisplayName("Test withFilters(ApplicationAttestationSummaryFilters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationAttestationInstanceInfo ImmutableApplicationAttestationInstanceInfo.withFilters(ApplicationAttestationSummaryFilters)"
  })
  void testWithFilters() {
    // Arrange
    ImmutableApplicationAttestationInstanceInfo.Builder builderResult =
        ImmutableApplicationAttestationInstanceInfo.builder();

    Builder builderResult2 = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult2.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    ImmutableApplicationAttestationInstanceInfo.Builder filtersResult =
        builderResult.filters(
            appLifecyclePhaseResult
                .attestationState(attestationState)
                .attestationsFromDate(LocalDate.of(1970, 1, 1))
                .build());

    ImmutableIdSelectionOptions.Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult2 =
        builderResult3
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult2.joiningEntityKind(joiningEntityKind);
    ImmutableApplicationAttestationInstanceInfo immutableApplicationAttestationInstanceInfo =
        filtersResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    Builder builderResult4 = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality2 = Optional.of(Criticality.LOW);

    Builder appCriticalityResult2 = builderResult4.appCriticality(appCriticality2);
    Optional<? extends LifecyclePhase> appLifecyclePhase2 = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult2 = appCriticalityResult2.appLifecyclePhase(appLifecyclePhase2);
    Optional<? extends AttestationState> attestationState2 = Optional.of(AttestationState.ATTESTED);

    // Act
    ImmutableApplicationAttestationInstanceInfo actualWithFiltersResult =
        immutableApplicationAttestationInstanceInfo.withFilters(
            appLifecyclePhaseResult2
                .attestationState(attestationState2)
                .attestationsFromDate(LocalDate.of(1970, 1, 1))
                .build());

    // Assert
    assertEquals(immutableApplicationAttestationInstanceInfo, actualWithFiltersResult);
  }

  /**
   * Test {@link
   * ImmutableApplicationAttestationInstanceInfo#withSelectionOptions(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ImmutableApplicationAttestationInstanceInfo#withSelectionOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test withSelectionOptions(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationAttestationInstanceInfo ImmutableApplicationAttestationInstanceInfo.withSelectionOptions(IdSelectionOptions)"
  })
  void testWithSelectionOptions() {
    // Arrange
    ImmutableApplicationAttestationInstanceInfo.Builder builderResult =
        ImmutableApplicationAttestationInstanceInfo.builder();

    Builder builderResult2 = ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    Builder appCriticalityResult = builderResult2.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    Builder appLifecyclePhaseResult = appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    ImmutableApplicationAttestationInstanceInfo.Builder filtersResult =
        builderResult.filters(
            appLifecyclePhaseResult
                .attestationState(attestationState)
                .attestationsFromDate(LocalDate.of(1970, 1, 1))
                .build());

    ImmutableIdSelectionOptions.Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult2 =
        builderResult3
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult2.joiningEntityKind(joiningEntityKind);
    ImmutableApplicationAttestationInstanceInfo immutableApplicationAttestationInstanceInfo =
        filtersResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    ImmutableIdSelectionOptions.Builder builderResult4 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult3 =
        builderResult4
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult2 =
        filtersResult3.joiningEntityKind(joiningEntityKind2);

    // Act
    ImmutableApplicationAttestationInstanceInfo actualWithSelectionOptionsResult =
        immutableApplicationAttestationInstanceInfo.withSelectionOptions(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertEquals(immutableApplicationAttestationInstanceInfo, actualWithSelectionOptionsResult);
  }
}
