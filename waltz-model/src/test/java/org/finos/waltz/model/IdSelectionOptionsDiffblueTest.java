package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Set;
import org.junit.jupiter.api.Test;

class IdSelectionOptionsDiffblueTest {
  /**
   * Method under test:
   * {@link IdSelectionOptions#determineDefaultScope(EntityKind)}
   */
  @Test
  void testDetermineDefaultScope() {
    // Arrange, Act and Assert
    assertEquals(HierarchyQueryScope.CHILDREN, IdSelectionOptions.determineDefaultScope(EntityKind.ALL));
    assertEquals(HierarchyQueryScope.EXACT, IdSelectionOptions.determineDefaultScope(EntityKind.ACTOR));
  }

  /**
   * Method under test: {@link IdSelectionOptions#mkOpts(EntityReference)}
   */
  @Test
  void testMkOpts() {
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
   * Method under test: {@link IdSelectionOptions#mkOpts(EntityReference)}
   */
  @Test
  void testMkOpts2() {
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
   * Method under test:
   * {@link IdSelectionOptions#mkOpts(EntityReference, HierarchyQueryScope)}
   */
  @Test
  void testMkOpts3() {
    // Arrange
    ImmutableEntityReference.Json ref = new ImmutableEntityReference.Json();

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
   * Method under test:
   * {@link IdSelectionOptions#mkOpts(EntityReference, HierarchyQueryScope, EntityKind)}
   */
  @Test
  void testMkOpts4() {
    // Arrange
    ImmutableEntityReference.Json ref = new ImmutableEntityReference.Json();

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
   * Method under test:
   * {@link IdSelectionOptions#mkOptsForAllLifecycleStates(EntityReference, HierarchyQueryScope)}
   */
  @Test
  void testMkOptsForAllLifecycleStates() {
    // Arrange
    ImmutableEntityReference.Json ref = new ImmutableEntityReference.Json();

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
}
