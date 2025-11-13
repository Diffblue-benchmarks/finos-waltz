package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.ImmutableEntityReference.Json;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class IdSelectionOptionsDiffblueTest {
  /**
   * Test {@link IdSelectionOptions#entityLifecycleStatuses()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link IdSelectionOptions#entityLifecycleStatuses()}
   */
  @Test
  @DisplayName("Test entityLifecycleStatuses(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set IdSelectionOptions.entityLifecycleStatuses()"})
  void testEntityLifecycleStatuses_thenReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertTrue(
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build()
            .entityLifecycleStatuses()
            .isEmpty());
  }

  /**
   * Test {@link IdSelectionOptions#filters()}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableSelectionFilters}.
   * </ul>
   *
   * <p>Method under test: {@link IdSelectionOptions#filters()}
   */
  @Test
  @DisplayName("Test filters(); then return ImmutableSelectionFilters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SelectionFilters IdSelectionOptions.filters()"})
  void testFilters_thenReturnImmutableSelectionFilters() {
    // Arrange
    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions immutableIdSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    SelectionFilters actualFiltersResult = immutableIdSelectionOptions.filters();

    // Assert
    assertTrue(actualFiltersResult instanceof ImmutableSelectionFilters);
    assertTrue(actualFiltersResult.omitApplicationKinds().isEmpty());
    SelectionFilters selectionFilters = SelectionFilters.NO_FILTERS;
    assertSame(selectionFilters, actualFiltersResult);
    assertSame(selectionFilters, immutableIdSelectionOptions.filters());
  }

  /**
   * Test {@link IdSelectionOptions#mkOpts(EntityReference)} with {@code ref}.
   *
   * <p>Method under test: {@link IdSelectionOptions#mkOpts(EntityReference)}
   */
  @Test
  @DisplayName("Test mkOpts(EntityReference) with 'ref'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IdSelectionOptions IdSelectionOptions.mkOpts(EntityReference)"})
  void testMkOptsWithRef() {
    // Arrange
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    IdSelectionOptions actualMkOptsResult = IdSelectionOptions.mkOpts(ref);

    // Assert
    assertTrue(actualMkOptsResult instanceof ImmutableIdSelectionOptions);
    assertSame(ref, actualMkOptsResult.entityReference());
  }

  /**
   * Test {@link IdSelectionOptions#mkOpts(EntityReference, HierarchyQueryScope, EntityKind)} with
   * {@code ref}, {@code scope}, {@code joiningEntityKind}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableIdSelectionOptions}.
   * </ul>
   *
   * <p>Method under test: {@link IdSelectionOptions#mkOpts(EntityReference, HierarchyQueryScope,
   * EntityKind)}
   */
  @Test
  @DisplayName(
      "Test mkOpts(EntityReference, HierarchyQueryScope, EntityKind) with 'ref', 'scope', 'joiningEntityKind'; then return ImmutableIdSelectionOptions")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IdSelectionOptions IdSelectionOptions.mkOpts(EntityReference, HierarchyQueryScope, EntityKind)"
  })
  void testMkOptsWithRefScopeJoiningEntityKind_thenReturnImmutableIdSelectionOptions() {
    // Arrange
    Json ref = new Json();

    // Act
    IdSelectionOptions actualMkOptsResult =
        IdSelectionOptions.mkOpts(ref, HierarchyQueryScope.EXACT, EntityKind.ALL);

    // Assert
    assertTrue(actualMkOptsResult instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult = actualMkOptsResult.filters();
    assertTrue(filtersResult instanceof ImmutableSelectionFilters);
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult =
        actualMkOptsResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    assertEquals(HierarchyQueryScope.EXACT, actualMkOptsResult.scope());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(filtersResult.omitApplicationKinds().isEmpty());
    assertSame(ref, actualMkOptsResult.entityReference());
  }

  /**
   * Test {@link IdSelectionOptions#mkOpts(EntityReference, HierarchyQueryScope)} with {@code ref},
   * {@code scope}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return {@link ImmutableIdSelectionOptions}.
   * </ul>
   *
   * <p>Method under test: {@link IdSelectionOptions#mkOpts(EntityReference, HierarchyQueryScope)}
   */
  @Test
  @DisplayName(
      "Test mkOpts(EntityReference, HierarchyQueryScope) with 'ref', 'scope'; when Json (default constructor); then return ImmutableIdSelectionOptions")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IdSelectionOptions IdSelectionOptions.mkOpts(EntityReference, HierarchyQueryScope)"
  })
  void testMkOptsWithRefScope_whenJson_thenReturnImmutableIdSelectionOptions() {
    // Arrange
    Json ref = new Json();

    // Act
    IdSelectionOptions actualMkOptsResult =
        IdSelectionOptions.mkOpts(ref, HierarchyQueryScope.EXACT);

    // Assert
    assertTrue(actualMkOptsResult instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult = actualMkOptsResult.filters();
    assertTrue(filtersResult instanceof ImmutableSelectionFilters);
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult =
        actualMkOptsResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    assertEquals(HierarchyQueryScope.EXACT, actualMkOptsResult.scope());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(filtersResult.omitApplicationKinds().isEmpty());
    assertSame(ref, actualMkOptsResult.entityReference());
  }

  /**
   * Test {@link IdSelectionOptions#mkOpts(EntityReference)} with {@code ref}.
   *
   * <ul>
   *   <li>Then return scope is {@code CHILDREN}.
   * </ul>
   *
   * <p>Method under test: {@link IdSelectionOptions#mkOpts(EntityReference)}
   */
  @Test
  @DisplayName("Test mkOpts(EntityReference) with 'ref'; then return scope is 'CHILDREN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IdSelectionOptions IdSelectionOptions.mkOpts(EntityReference)"})
  void testMkOptsWithRef_thenReturnScopeIsChildren() {
    // Arrange
    ImmutableAppGroupEntry ref =
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
    IdSelectionOptions actualMkOptsResult = IdSelectionOptions.mkOpts(ref);

    // Assert
    assertTrue(actualMkOptsResult instanceof ImmutableIdSelectionOptions);
    assertEquals(HierarchyQueryScope.CHILDREN, actualMkOptsResult.scope());
    assertSame(ref, actualMkOptsResult.entityReference());
  }

  /**
   * Test {@link IdSelectionOptions#mkOpts(EntityReference)} with {@code ref}.
   *
   * <ul>
   *   <li>Then return scope is {@code EXACT}.
   * </ul>
   *
   * <p>Method under test: {@link IdSelectionOptions#mkOpts(EntityReference)}
   */
  @Test
  @DisplayName("Test mkOpts(EntityReference) with 'ref'; then return scope is 'EXACT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IdSelectionOptions IdSelectionOptions.mkOpts(EntityReference)"})
  void testMkOptsWithRef_thenReturnScopeIsExact() {
    // Arrange
    ImmutableAppGroupEntry ref =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    IdSelectionOptions actualMkOptsResult = IdSelectionOptions.mkOpts(ref);

    // Assert
    assertTrue(actualMkOptsResult instanceof ImmutableIdSelectionOptions);
    assertEquals(HierarchyQueryScope.EXACT, actualMkOptsResult.scope());
    assertSame(ref, actualMkOptsResult.entityReference());
  }

  /**
   * Test {@link IdSelectionOptions#mkOptsForAllLifecycleStates(EntityReference,
   * HierarchyQueryScope)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return {@link ImmutableIdSelectionOptions}.
   * </ul>
   *
   * <p>Method under test: {@link IdSelectionOptions#mkOptsForAllLifecycleStates(EntityReference,
   * HierarchyQueryScope)}
   */
  @Test
  @DisplayName(
      "Test mkOptsForAllLifecycleStates(EntityReference, HierarchyQueryScope); when Json (default constructor); then return ImmutableIdSelectionOptions")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IdSelectionOptions IdSelectionOptions.mkOptsForAllLifecycleStates(EntityReference, HierarchyQueryScope)"
  })
  void testMkOptsForAllLifecycleStates_whenJson_thenReturnImmutableIdSelectionOptions() {
    // Arrange
    Json ref = new Json();

    // Act
    IdSelectionOptions actualMkOptsForAllLifecycleStatesResult =
        IdSelectionOptions.mkOptsForAllLifecycleStates(ref, HierarchyQueryScope.EXACT);

    // Assert
    assertTrue(actualMkOptsForAllLifecycleStatesResult instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult = actualMkOptsForAllLifecycleStatesResult.filters();
    assertTrue(filtersResult instanceof ImmutableSelectionFilters);
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult =
        actualMkOptsForAllLifecycleStatesResult.entityLifecycleStatuses();
    assertEquals(3, entityLifecycleStatusesResult.size());
    assertEquals(HierarchyQueryScope.EXACT, actualMkOptsForAllLifecycleStatesResult.scope());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.PENDING));
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.REMOVED));
    assertTrue(filtersResult.omitApplicationKinds().isEmpty());
    assertSame(ref, actualMkOptsForAllLifecycleStatesResult.entityReference());
  }

  /**
   * Test {@link IdSelectionOptions#determineDefaultScope(EntityKind)}.
   *
   * <ul>
   *   <li>When {@code ACTOR}.
   *   <li>Then return {@code EXACT}.
   * </ul>
   *
   * <p>Method under test: {@link IdSelectionOptions#determineDefaultScope(EntityKind)}
   */
  @Test
  @DisplayName("Test determineDefaultScope(EntityKind); when 'ACTOR'; then return 'EXACT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HierarchyQueryScope IdSelectionOptions.determineDefaultScope(EntityKind)"})
  void testDetermineDefaultScope_whenActor_thenReturnExact() {
    // Arrange, Act and Assert
    assertEquals(
        HierarchyQueryScope.EXACT, IdSelectionOptions.determineDefaultScope(EntityKind.ACTOR));
  }

  /**
   * Test {@link IdSelectionOptions#determineDefaultScope(EntityKind)}.
   *
   * <ul>
   *   <li>When {@code ALL}.
   *   <li>Then return {@code CHILDREN}.
   * </ul>
   *
   * <p>Method under test: {@link IdSelectionOptions#determineDefaultScope(EntityKind)}
   */
  @Test
  @DisplayName("Test determineDefaultScope(EntityKind); when 'ALL'; then return 'CHILDREN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HierarchyQueryScope IdSelectionOptions.determineDefaultScope(EntityKind)"})
  void testDetermineDefaultScope_whenAll_thenReturnChildren() {
    // Arrange, Act and Assert
    assertEquals(
        HierarchyQueryScope.CHILDREN, IdSelectionOptions.determineDefaultScope(EntityKind.ALL));
  }
}
