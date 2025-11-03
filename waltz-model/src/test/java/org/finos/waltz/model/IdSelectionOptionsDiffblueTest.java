package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import org.finos.waltz.model.ImmutableEntityReference.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class IdSelectionOptionsDiffblueTest {
  /**
   * Test {@link IdSelectionOptions#mkOpts(EntityReference, HierarchyQueryScope, EntityKind)} with {@code ref}, {@code scope}, {@code joiningEntityKind}.
   * <ul>
   *   <li>Then return {@link ImmutableIdSelectionOptions}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdSelectionOptions#mkOpts(EntityReference, HierarchyQueryScope, EntityKind)}
   */
  @Test
  @DisplayName("Test mkOpts(EntityReference, HierarchyQueryScope, EntityKind) with 'ref', 'scope', 'joiningEntityKind'; then return ImmutableIdSelectionOptions")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IdSelectionOptions IdSelectionOptions.mkOpts(EntityReference, HierarchyQueryScope, EntityKind)"})
  void testMkOptsWithRefScopeJoiningEntityKind_thenReturnImmutableIdSelectionOptions() {
    // Arrange
    Json ref = new Json();

    // Act
    IdSelectionOptions actualMkOptsResult = IdSelectionOptions.mkOpts(ref, HierarchyQueryScope.EXACT, EntityKind.ALL);

    // Assert
    assertTrue(actualMkOptsResult instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult = actualMkOptsResult.filters();
    assertTrue(filtersResult instanceof ImmutableSelectionFilters);
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult = actualMkOptsResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    assertEquals(HierarchyQueryScope.EXACT, actualMkOptsResult.scope());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(filtersResult.omitApplicationKinds().isEmpty());
    assertSame(ref, actualMkOptsResult.entityReference());
  }

  /**
   * Test {@link IdSelectionOptions#mkOpts(EntityReference, HierarchyQueryScope)} with {@code ref}, {@code scope}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return {@link ImmutableIdSelectionOptions}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdSelectionOptions#mkOpts(EntityReference, HierarchyQueryScope)}
   */
  @Test
  @DisplayName("Test mkOpts(EntityReference, HierarchyQueryScope) with 'ref', 'scope'; when Json (default constructor); then return ImmutableIdSelectionOptions")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IdSelectionOptions IdSelectionOptions.mkOpts(EntityReference, HierarchyQueryScope)"})
  void testMkOptsWithRefScope_whenJson_thenReturnImmutableIdSelectionOptions() {
    // Arrange
    Json ref = new Json();

    // Act
    IdSelectionOptions actualMkOptsResult = IdSelectionOptions.mkOpts(ref, HierarchyQueryScope.EXACT);

    // Assert
    assertTrue(actualMkOptsResult instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult = actualMkOptsResult.filters();
    assertTrue(filtersResult instanceof ImmutableSelectionFilters);
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult = actualMkOptsResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    assertEquals(HierarchyQueryScope.EXACT, actualMkOptsResult.scope());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(filtersResult.omitApplicationKinds().isEmpty());
    assertSame(ref, actualMkOptsResult.entityReference());
  }

  /**
   * Test {@link IdSelectionOptions#mkOpts(EntityReference)} with {@code ref}.
   * <ul>
   *   <li>Given {@code ACTOR}.</li>
   *   <li>Then return scope is {@code EXACT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdSelectionOptions#mkOpts(EntityReference)}
   */
  @Test
  @DisplayName("Test mkOpts(EntityReference) with 'ref'; given 'ACTOR'; then return scope is 'EXACT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IdSelectionOptions IdSelectionOptions.mkOpts(EntityReference)"})
  void testMkOptsWithRef_givenActor_thenReturnScopeIsExact() {
    // Arrange
    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenReturn(EntityKind.ACTOR);

    // Act
    IdSelectionOptions actualMkOptsResult = IdSelectionOptions.mkOpts(ref);

    // Assert
    verify(ref).kind();
    assertTrue(actualMkOptsResult instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult = actualMkOptsResult.filters();
    assertTrue(filtersResult instanceof ImmutableSelectionFilters);
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult = actualMkOptsResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    assertEquals(HierarchyQueryScope.EXACT, actualMkOptsResult.scope());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(filtersResult.omitApplicationKinds().isEmpty());
    assertSame(ref, actualMkOptsResult.entityReference());
  }

  /**
   * Test {@link IdSelectionOptions#mkOpts(EntityReference)} with {@code ref}.
   * <ul>
   *   <li>Given {@code ALL}.</li>
   *   <li>Then return scope is {@code CHILDREN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdSelectionOptions#mkOpts(EntityReference)}
   */
  @Test
  @DisplayName("Test mkOpts(EntityReference) with 'ref'; given 'ALL'; then return scope is 'CHILDREN'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IdSelectionOptions IdSelectionOptions.mkOpts(EntityReference)"})
  void testMkOptsWithRef_givenAll_thenReturnScopeIsChildren() {
    // Arrange
    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    IdSelectionOptions actualMkOptsResult = IdSelectionOptions.mkOpts(ref);

    // Assert
    verify(ref).kind();
    assertTrue(actualMkOptsResult instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult = actualMkOptsResult.filters();
    assertTrue(filtersResult instanceof ImmutableSelectionFilters);
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult = actualMkOptsResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    assertEquals(HierarchyQueryScope.CHILDREN, actualMkOptsResult.scope());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(filtersResult.omitApplicationKinds().isEmpty());
    assertSame(ref, actualMkOptsResult.entityReference());
  }

  /**
   * Test {@link IdSelectionOptions#mkOptsForAllLifecycleStates(EntityReference, HierarchyQueryScope)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return {@link ImmutableIdSelectionOptions}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdSelectionOptions#mkOptsForAllLifecycleStates(EntityReference, HierarchyQueryScope)}
   */
  @Test
  @DisplayName("Test mkOptsForAllLifecycleStates(EntityReference, HierarchyQueryScope); when Json (default constructor); then return ImmutableIdSelectionOptions")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "IdSelectionOptions IdSelectionOptions.mkOptsForAllLifecycleStates(EntityReference, HierarchyQueryScope)"})
  void testMkOptsForAllLifecycleStates_whenJson_thenReturnImmutableIdSelectionOptions() {
    // Arrange
    Json ref = new Json();

    // Act
    IdSelectionOptions actualMkOptsForAllLifecycleStatesResult = IdSelectionOptions.mkOptsForAllLifecycleStates(ref,
        HierarchyQueryScope.EXACT);

    // Assert
    assertTrue(actualMkOptsForAllLifecycleStatesResult instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult = actualMkOptsForAllLifecycleStatesResult.filters();
    assertTrue(filtersResult instanceof ImmutableSelectionFilters);
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult = actualMkOptsForAllLifecycleStatesResult
        .entityLifecycleStatuses();
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
   * <ul>
   *   <li>When {@code ACTOR}.</li>
   *   <li>Then return {@code EXACT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdSelectionOptions#determineDefaultScope(EntityKind)}
   */
  @Test
  @DisplayName("Test determineDefaultScope(EntityKind); when 'ACTOR'; then return 'EXACT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"HierarchyQueryScope IdSelectionOptions.determineDefaultScope(EntityKind)"})
  void testDetermineDefaultScope_whenActor_thenReturnExact() {
    // Arrange, Act and Assert
    assertEquals(HierarchyQueryScope.EXACT, IdSelectionOptions.determineDefaultScope(EntityKind.ACTOR));
  }

  /**
   * Test {@link IdSelectionOptions#determineDefaultScope(EntityKind)}.
   * <ul>
   *   <li>When {@code ALL}.</li>
   *   <li>Then return {@code CHILDREN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdSelectionOptions#determineDefaultScope(EntityKind)}
   */
  @Test
  @DisplayName("Test determineDefaultScope(EntityKind); when 'ALL'; then return 'CHILDREN'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"HierarchyQueryScope IdSelectionOptions.determineDefaultScope(EntityKind)"})
  void testDetermineDefaultScope_whenAll_thenReturnChildren() {
    // Arrange, Act and Assert
    assertEquals(HierarchyQueryScope.CHILDREN, IdSelectionOptions.determineDefaultScope(EntityKind.ALL));
  }
}
