package org.finos.waltz.model.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.SelectionFilters;
import org.junit.jupiter.api.Test;

class ApplicationIdSelectionOptionsDiffblueTest {
  /**
   * Method under test:
   * {@link ApplicationIdSelectionOptions#mkOpts(EntityReference)}
   */
  @Test
  void testMkOpts() {
    // Arrange
    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    ApplicationIdSelectionOptions actualMkOptsResult = ApplicationIdSelectionOptions.mkOpts(ref);

    // Assert
    verify(ref).kind();
    SelectionFilters filtersResult = actualMkOptsResult.filters();
    assertTrue(filtersResult instanceof ImmutableSelectionFilters);
    assertTrue(actualMkOptsResult instanceof ImmutableApplicationIdSelectionOptions);
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult = actualMkOptsResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    Set<ApplicationKind> applicationKindsResult = actualMkOptsResult.applicationKinds();
    assertEquals(7, applicationKindsResult.size());
    assertEquals(HierarchyQueryScope.CHILDREN, actualMkOptsResult.scope());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(applicationKindsResult.contains(ApplicationKind.CUSTOMISED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.EUC));
    assertTrue(applicationKindsResult.contains(ApplicationKind.EXTERNALLY_HOSTED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.INTERNALLY_HOSTED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.IN_HOUSE));
    assertTrue(applicationKindsResult.contains(ApplicationKind.THIRD_PARTY));
    assertTrue(filtersResult.omitApplicationKinds().isEmpty());
    assertSame(ref, actualMkOptsResult.entityReference());
  }

  /**
   * Method under test:
   * {@link ApplicationIdSelectionOptions#mkOpts(EntityReference)}
   */
  @Test
  void testMkOpts2() {
    // Arrange
    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenReturn(EntityKind.ACTOR);

    // Act
    ApplicationIdSelectionOptions actualMkOptsResult = ApplicationIdSelectionOptions.mkOpts(ref);

    // Assert
    verify(ref).kind();
    SelectionFilters filtersResult = actualMkOptsResult.filters();
    assertTrue(filtersResult instanceof ImmutableSelectionFilters);
    assertTrue(actualMkOptsResult instanceof ImmutableApplicationIdSelectionOptions);
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult = actualMkOptsResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    Set<ApplicationKind> applicationKindsResult = actualMkOptsResult.applicationKinds();
    assertEquals(7, applicationKindsResult.size());
    assertEquals(HierarchyQueryScope.EXACT, actualMkOptsResult.scope());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(applicationKindsResult.contains(ApplicationKind.CUSTOMISED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.EUC));
    assertTrue(applicationKindsResult.contains(ApplicationKind.EXTERNALLY_HOSTED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.INTERNALLY_HOSTED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.IN_HOUSE));
    assertTrue(applicationKindsResult.contains(ApplicationKind.THIRD_PARTY));
    assertTrue(filtersResult.omitApplicationKinds().isEmpty());
    assertSame(ref, actualMkOptsResult.entityReference());
  }

  /**
   * Method under test:
   * {@link ApplicationIdSelectionOptions#mkOpts(EntityReference, HierarchyQueryScope)}
   */
  @Test
  void testMkOpts3() {
    // Arrange
    EntityReference ref = mock(EntityReference.class);

    // Act
    ApplicationIdSelectionOptions actualMkOptsResult = ApplicationIdSelectionOptions.mkOpts(ref,
        HierarchyQueryScope.EXACT);

    // Assert
    SelectionFilters filtersResult = actualMkOptsResult.filters();
    assertTrue(filtersResult instanceof ImmutableSelectionFilters);
    assertTrue(actualMkOptsResult instanceof ImmutableApplicationIdSelectionOptions);
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult = actualMkOptsResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    Set<ApplicationKind> applicationKindsResult = actualMkOptsResult.applicationKinds();
    assertEquals(7, applicationKindsResult.size());
    assertEquals(HierarchyQueryScope.EXACT, actualMkOptsResult.scope());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(applicationKindsResult.contains(ApplicationKind.CUSTOMISED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.EUC));
    assertTrue(applicationKindsResult.contains(ApplicationKind.EXTERNALLY_HOSTED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.INTERNALLY_HOSTED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.IN_HOUSE));
    assertTrue(applicationKindsResult.contains(ApplicationKind.THIRD_PARTY));
    assertTrue(filtersResult.omitApplicationKinds().isEmpty());
    assertSame(ref, actualMkOptsResult.entityReference());
  }

  /**
   * Method under test:
   * {@link ApplicationIdSelectionOptions#mkOpts(EntityReference, HierarchyQueryScope, Set, Set)}
   */
  @Test
  void testMkOpts4() {
    // Arrange
    EntityReference ref = mock(EntityReference.class);
    HashSet<EntityLifecycleStatus> entityLifecycleStatuses = new HashSet<>();

    // Act
    ApplicationIdSelectionOptions actualMkOptsResult = ApplicationIdSelectionOptions.mkOpts(ref,
        HierarchyQueryScope.EXACT, entityLifecycleStatuses, new HashSet<>());

    // Assert
    SelectionFilters filtersResult = actualMkOptsResult.filters();
    assertTrue(filtersResult instanceof ImmutableSelectionFilters);
    assertTrue(actualMkOptsResult instanceof ImmutableApplicationIdSelectionOptions);
    assertEquals(HierarchyQueryScope.EXACT, actualMkOptsResult.scope());
    assertTrue(actualMkOptsResult.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult.omitApplicationKinds().isEmpty());
    assertTrue(actualMkOptsResult.applicationKinds().isEmpty());
    assertSame(ref, actualMkOptsResult.entityReference());
  }

  /**
   * Method under test:
   * {@link ApplicationIdSelectionOptions#mkOpts(EntityReference, HierarchyQueryScope, Set, Set)}
   */
  @Test
  void testMkOpts5() {
    // Arrange
    EntityReference ref = mock(EntityReference.class);

    // Act
    ApplicationIdSelectionOptions actualMkOptsResult = ApplicationIdSelectionOptions.mkOpts(ref,
        HierarchyQueryScope.EXACT, null, null);

    // Assert
    SelectionFilters filtersResult = actualMkOptsResult.filters();
    assertTrue(filtersResult instanceof ImmutableSelectionFilters);
    assertTrue(actualMkOptsResult instanceof ImmutableApplicationIdSelectionOptions);
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult = actualMkOptsResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    Set<ApplicationKind> applicationKindsResult = actualMkOptsResult.applicationKinds();
    assertEquals(7, applicationKindsResult.size());
    assertEquals(HierarchyQueryScope.EXACT, actualMkOptsResult.scope());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(applicationKindsResult.contains(ApplicationKind.CUSTOMISED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.EUC));
    assertTrue(applicationKindsResult.contains(ApplicationKind.EXTERNALLY_HOSTED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.INTERNALLY_HOSTED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.IN_HOUSE));
    assertTrue(applicationKindsResult.contains(ApplicationKind.THIRD_PARTY));
    assertTrue(filtersResult.omitApplicationKinds().isEmpty());
    assertSame(ref, actualMkOptsResult.entityReference());
  }

  /**
   * Method under test:
   * {@link ApplicationIdSelectionOptions#mkOpts(EntityReference, HierarchyQueryScope, Set, Set)}
   */
  @Test
  void testMkOpts6() {
    // Arrange
    EntityReference ref = mock(EntityReference.class);

    LinkedHashSet<ApplicationKind> applicationKinds = new LinkedHashSet<>();
    applicationKinds.add(ApplicationKind.IN_HOUSE);

    // Act
    ApplicationIdSelectionOptions actualMkOptsResult = ApplicationIdSelectionOptions.mkOpts(ref,
        HierarchyQueryScope.EXACT, null, applicationKinds);

    // Assert
    SelectionFilters filtersResult = actualMkOptsResult.filters();
    assertTrue(filtersResult instanceof ImmutableSelectionFilters);
    assertTrue(actualMkOptsResult instanceof ImmutableApplicationIdSelectionOptions);
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult = actualMkOptsResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    Set<ApplicationKind> applicationKindsResult = actualMkOptsResult.applicationKinds();
    assertEquals(1, applicationKindsResult.size());
    assertEquals(HierarchyQueryScope.EXACT, actualMkOptsResult.scope());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(applicationKindsResult.contains(ApplicationKind.IN_HOUSE));
    assertTrue(filtersResult.omitApplicationKinds().isEmpty());
    assertSame(ref, actualMkOptsResult.entityReference());
  }

  /**
   * Method under test:
   * {@link ApplicationIdSelectionOptions#mkOpts(EntityReference, HierarchyQueryScope, Set, Set)}
   */
  @Test
  void testMkOpts7() {
    // Arrange
    EntityReference ref = mock(EntityReference.class);

    LinkedHashSet<EntityLifecycleStatus> entityLifecycleStatuses = new LinkedHashSet<>();
    entityLifecycleStatuses.add(EntityLifecycleStatus.ACTIVE);

    // Act
    ApplicationIdSelectionOptions actualMkOptsResult = ApplicationIdSelectionOptions.mkOpts(ref,
        HierarchyQueryScope.EXACT, entityLifecycleStatuses, null);

    // Assert
    SelectionFilters filtersResult = actualMkOptsResult.filters();
    assertTrue(filtersResult instanceof ImmutableSelectionFilters);
    assertTrue(actualMkOptsResult instanceof ImmutableApplicationIdSelectionOptions);
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult = actualMkOptsResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    Set<ApplicationKind> applicationKindsResult = actualMkOptsResult.applicationKinds();
    assertEquals(7, applicationKindsResult.size());
    assertEquals(HierarchyQueryScope.EXACT, actualMkOptsResult.scope());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(applicationKindsResult.contains(ApplicationKind.CUSTOMISED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.EUC));
    assertTrue(applicationKindsResult.contains(ApplicationKind.EXTERNALLY_HOSTED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.INTERNALLY_HOSTED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.IN_HOUSE));
    assertTrue(applicationKindsResult.contains(ApplicationKind.THIRD_PARTY));
    assertTrue(filtersResult.omitApplicationKinds().isEmpty());
    assertSame(ref, actualMkOptsResult.entityReference());
  }

  /**
   * Method under test:
   * {@link ApplicationIdSelectionOptions#mkOpts(IdSelectionOptions)}
   */
  @Test
  void testMkOpts8() {
    // Arrange and Act
    ApplicationIdSelectionOptions actualMkOptsResult = ApplicationIdSelectionOptions
        .mkOpts(new ImmutableApplicationIdSelectionOptions.Json());

    // Assert
    assertTrue(actualMkOptsResult instanceof ImmutableApplicationIdSelectionOptions.Json);
    assertNull(((ImmutableApplicationIdSelectionOptions.Json) actualMkOptsResult).entityReference);
    assertNull(((ImmutableApplicationIdSelectionOptions.Json) actualMkOptsResult).scope);
    assertNull(((ImmutableApplicationIdSelectionOptions.Json) actualMkOptsResult).filters);
    assertFalse(((ImmutableApplicationIdSelectionOptions.Json) actualMkOptsResult).joiningEntityKind.isPresent());
    assertFalse(((ImmutableApplicationIdSelectionOptions.Json) actualMkOptsResult).applicationKindsIsSet);
    assertFalse(((ImmutableApplicationIdSelectionOptions.Json) actualMkOptsResult).entityLifecycleStatusesIsSet);
    assertTrue(((ImmutableApplicationIdSelectionOptions.Json) actualMkOptsResult).applicationKinds.isEmpty());
    assertTrue(((ImmutableApplicationIdSelectionOptions.Json) actualMkOptsResult).entityLifecycleStatuses.isEmpty());
  }

  /**
   * Method under test:
   * {@link ApplicationIdSelectionOptions#mkOpts(IdSelectionOptions)}
   */
  @Test
  void testMkOpts9() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Json options = new ImmutableApplicationIdSelectionOptions.Json();
    options.setEntityReference(mock(EntityReference.class));

    // Act
    ApplicationIdSelectionOptions actualMkOptsResult = ApplicationIdSelectionOptions.mkOpts(options);

    // Assert
    assertTrue(actualMkOptsResult instanceof ImmutableApplicationIdSelectionOptions.Json);
    assertNull(((ImmutableApplicationIdSelectionOptions.Json) actualMkOptsResult).scope);
    assertNull(((ImmutableApplicationIdSelectionOptions.Json) actualMkOptsResult).filters);
    assertFalse(((ImmutableApplicationIdSelectionOptions.Json) actualMkOptsResult).joiningEntityKind.isPresent());
    assertFalse(((ImmutableApplicationIdSelectionOptions.Json) actualMkOptsResult).applicationKindsIsSet);
    assertFalse(((ImmutableApplicationIdSelectionOptions.Json) actualMkOptsResult).entityLifecycleStatusesIsSet);
    assertTrue(((ImmutableApplicationIdSelectionOptions.Json) actualMkOptsResult).applicationKinds.isEmpty());
    assertTrue(((ImmutableApplicationIdSelectionOptions.Json) actualMkOptsResult).entityLifecycleStatuses.isEmpty());
  }

  /**
   * Method under test:
   * {@link ApplicationIdSelectionOptions#mkOpts(IdSelectionOptions, Set)}
   */
  @Test
  void testMkOpts10() {
    // Arrange
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(mock(EntityReference.class));
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());

    // Act
    ApplicationIdSelectionOptions actualMkOptsResult = ApplicationIdSelectionOptions.mkOpts(options, new HashSet<>());

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).scope();
    SelectionFilters filtersResult = actualMkOptsResult.filters();
    assertTrue(filtersResult instanceof ImmutableSelectionFilters);
    assertTrue(actualMkOptsResult instanceof ImmutableApplicationIdSelectionOptions);
    assertEquals(HierarchyQueryScope.EXACT, actualMkOptsResult.scope());
    assertTrue(actualMkOptsResult.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult.omitApplicationKinds().isEmpty());
    assertTrue(actualMkOptsResult.applicationKinds().isEmpty());
  }

  /**
   * Method under test:
   * {@link ApplicationIdSelectionOptions#mkOpts(IdSelectionOptions, Set)}
   */
  @Test
  void testMkOpts11() {
    // Arrange
    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(mock(EntityReference.class));
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);

    // Act
    ApplicationIdSelectionOptions actualMkOptsResult = ApplicationIdSelectionOptions.mkOpts(options, new HashSet<>());

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).scope();
    SelectionFilters filtersResult = actualMkOptsResult.filters();
    assertTrue(filtersResult instanceof ImmutableSelectionFilters);
    assertTrue(actualMkOptsResult instanceof ImmutableApplicationIdSelectionOptions);
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult = actualMkOptsResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    assertEquals(HierarchyQueryScope.EXACT, actualMkOptsResult.scope());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(filtersResult.omitApplicationKinds().isEmpty());
    assertTrue(actualMkOptsResult.applicationKinds().isEmpty());
  }

  /**
   * Method under test:
   * {@link ApplicationIdSelectionOptions#mkOpts(IdSelectionOptions, Set)}
   */
  @Test
  void testMkOpts12() {
    // Arrange
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(mock(EntityReference.class));
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());

    HashSet<ApplicationKind> applicationKinds = new HashSet<>();
    applicationKinds.add(ApplicationKind.IN_HOUSE);

    // Act
    ApplicationIdSelectionOptions actualMkOptsResult = ApplicationIdSelectionOptions.mkOpts(options, applicationKinds);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).scope();
    SelectionFilters filtersResult = actualMkOptsResult.filters();
    assertTrue(filtersResult instanceof ImmutableSelectionFilters);
    assertTrue(actualMkOptsResult instanceof ImmutableApplicationIdSelectionOptions);
    Set<ApplicationKind> applicationKindsResult = actualMkOptsResult.applicationKinds();
    assertEquals(1, applicationKindsResult.size());
    assertEquals(HierarchyQueryScope.EXACT, actualMkOptsResult.scope());
    assertTrue(applicationKindsResult.contains(ApplicationKind.IN_HOUSE));
    assertTrue(actualMkOptsResult.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult.omitApplicationKinds().isEmpty());
  }
}
