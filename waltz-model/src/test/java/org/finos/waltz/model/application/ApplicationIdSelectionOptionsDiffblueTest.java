package org.finos.waltz.model.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.finos.waltz.model.application.ImmutableApplicationIdSelectionOptions.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ApplicationIdSelectionOptionsDiffblueTest {
  /**
   * Test {@link ApplicationIdSelectionOptions#mkOpts(IdSelectionOptions, Set)} with {@code options}, {@code applicationKinds}.
   * <ul>
   *   <li>Then filters return {@link ImmutableSelectionFilters}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApplicationIdSelectionOptions#mkOpts(IdSelectionOptions, Set)}
   */
  @Test
  @DisplayName("Test mkOpts(IdSelectionOptions, Set) with 'options', 'applicationKinds'; then filters return ImmutableSelectionFilters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ApplicationIdSelectionOptions ApplicationIdSelectionOptions.mkOpts(IdSelectionOptions, Set)"})
  void testMkOptsWithOptionsApplicationKinds_thenFiltersReturnImmutableSelectionFilters() {
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
   * Test {@link ApplicationIdSelectionOptions#mkOpts(IdSelectionOptions, Set)} with {@code options}, {@code applicationKinds}.
   * <ul>
   *   <li>Then return applicationKinds is {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApplicationIdSelectionOptions#mkOpts(IdSelectionOptions, Set)}
   */
  @Test
  @DisplayName("Test mkOpts(IdSelectionOptions, Set) with 'options', 'applicationKinds'; then return applicationKinds is HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ApplicationIdSelectionOptions ApplicationIdSelectionOptions.mkOpts(IdSelectionOptions, Set)"})
  void testMkOptsWithOptionsApplicationKinds_thenReturnApplicationKindsIsHashSet() {
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
    assertEquals(HierarchyQueryScope.EXACT, actualMkOptsResult.scope());
    assertTrue(actualMkOptsResult.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult.omitApplicationKinds().isEmpty());
    assertEquals(applicationKinds, actualMkOptsResult.applicationKinds());
  }

  /**
   * Test {@link ApplicationIdSelectionOptions#mkOpts(IdSelectionOptions, Set)} with {@code options}, {@code applicationKinds}.
   * <ul>
   *   <li>Then return entityLifecycleStatuses size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApplicationIdSelectionOptions#mkOpts(IdSelectionOptions, Set)}
   */
  @Test
  @DisplayName("Test mkOpts(IdSelectionOptions, Set) with 'options', 'applicationKinds'; then return entityLifecycleStatuses size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ApplicationIdSelectionOptions ApplicationIdSelectionOptions.mkOpts(IdSelectionOptions, Set)"})
  void testMkOptsWithOptionsApplicationKinds_thenReturnEntityLifecycleStatusesSizeIsOne() {
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
    assertTrue(actualMkOptsResult instanceof ImmutableApplicationIdSelectionOptions);
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult = actualMkOptsResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(actualMkOptsResult.applicationKinds().isEmpty());
  }

  /**
   * Test {@link ApplicationIdSelectionOptions#mkOpts(IdSelectionOptions)} with {@code options}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return {@link Json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApplicationIdSelectionOptions#mkOpts(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkOpts(IdSelectionOptions) with 'options'; when Json (default constructor); then return Json")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ApplicationIdSelectionOptions ApplicationIdSelectionOptions.mkOpts(IdSelectionOptions)"})
  void testMkOptsWithOptions_whenJson_thenReturnJson() {
    // Arrange and Act
    ApplicationIdSelectionOptions actualMkOptsResult = ApplicationIdSelectionOptions.mkOpts(new Json());

    // Assert
    assertTrue(actualMkOptsResult instanceof Json);
    assertNull(((Json) actualMkOptsResult).entityReference);
    assertNull(((Json) actualMkOptsResult).scope);
    assertNull(((Json) actualMkOptsResult).filters);
    assertFalse(((Json) actualMkOptsResult).joiningEntityKind.isPresent());
    assertFalse(((Json) actualMkOptsResult).applicationKindsIsSet);
    assertFalse(((Json) actualMkOptsResult).entityLifecycleStatusesIsSet);
    assertTrue(((Json) actualMkOptsResult).applicationKinds.isEmpty());
    assertTrue(((Json) actualMkOptsResult).entityLifecycleStatuses.isEmpty());
  }

  /**
   * Test {@link ApplicationIdSelectionOptions#mkOpts(EntityReference, HierarchyQueryScope, Set, Set)} with {@code ref}, {@code scope}, {@code entityLifecycleStatuses}, {@code applicationKinds}.
   * <p>
   * Method under test: {@link ApplicationIdSelectionOptions#mkOpts(EntityReference, HierarchyQueryScope, Set, Set)}
   */
  @Test
  @DisplayName("Test mkOpts(EntityReference, HierarchyQueryScope, Set, Set) with 'ref', 'scope', 'entityLifecycleStatuses', 'applicationKinds'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ApplicationIdSelectionOptions ApplicationIdSelectionOptions.mkOpts(EntityReference, HierarchyQueryScope, Set, Set)"})
  void testMkOptsWithRefScopeEntityLifecycleStatusesApplicationKinds() {
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
   * Test {@link ApplicationIdSelectionOptions#mkOpts(EntityReference, HierarchyQueryScope, Set, Set)} with {@code ref}, {@code scope}, {@code entityLifecycleStatuses}, {@code applicationKinds}.
   * <p>
   * Method under test: {@link ApplicationIdSelectionOptions#mkOpts(EntityReference, HierarchyQueryScope, Set, Set)}
   */
  @Test
  @DisplayName("Test mkOpts(EntityReference, HierarchyQueryScope, Set, Set) with 'ref', 'scope', 'entityLifecycleStatuses', 'applicationKinds'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ApplicationIdSelectionOptions ApplicationIdSelectionOptions.mkOpts(EntityReference, HierarchyQueryScope, Set, Set)"})
  void testMkOptsWithRefScopeEntityLifecycleStatusesApplicationKinds2() {
    // Arrange and Act
    ApplicationIdSelectionOptions actualMkOptsResult = ApplicationIdSelectionOptions.mkOpts(mock(EntityReference.class),
        HierarchyQueryScope.EXACT, null, null);

    // Assert
    assertTrue(actualMkOptsResult instanceof ImmutableApplicationIdSelectionOptions);
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult = actualMkOptsResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    Set<ApplicationKind> applicationKindsResult = actualMkOptsResult.applicationKinds();
    assertEquals(7, applicationKindsResult.size());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(applicationKindsResult.contains(ApplicationKind.CUSTOMISED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.EUC));
    assertTrue(applicationKindsResult.contains(ApplicationKind.EXTERNALLY_HOSTED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.INTERNALLY_HOSTED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.IN_HOUSE));
    assertTrue(applicationKindsResult.contains(ApplicationKind.THIRD_PARTY));
  }

  /**
   * Test {@link ApplicationIdSelectionOptions#mkOpts(EntityReference, HierarchyQueryScope, Set, Set)} with {@code ref}, {@code scope}, {@code entityLifecycleStatuses}, {@code applicationKinds}.
   * <p>
   * Method under test: {@link ApplicationIdSelectionOptions#mkOpts(EntityReference, HierarchyQueryScope, Set, Set)}
   */
  @Test
  @DisplayName("Test mkOpts(EntityReference, HierarchyQueryScope, Set, Set) with 'ref', 'scope', 'entityLifecycleStatuses', 'applicationKinds'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ApplicationIdSelectionOptions ApplicationIdSelectionOptions.mkOpts(EntityReference, HierarchyQueryScope, Set, Set)"})
  void testMkOptsWithRefScopeEntityLifecycleStatusesApplicationKinds3() {
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
    assertEquals(HierarchyQueryScope.EXACT, actualMkOptsResult.scope());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(filtersResult.omitApplicationKinds().isEmpty());
    assertEquals(applicationKinds, actualMkOptsResult.applicationKinds());
    assertSame(ref, actualMkOptsResult.entityReference());
  }

  /**
   * Test {@link ApplicationIdSelectionOptions#mkOpts(EntityReference, HierarchyQueryScope, Set, Set)} with {@code ref}, {@code scope}, {@code entityLifecycleStatuses}, {@code applicationKinds}.
   * <p>
   * Method under test: {@link ApplicationIdSelectionOptions#mkOpts(EntityReference, HierarchyQueryScope, Set, Set)}
   */
  @Test
  @DisplayName("Test mkOpts(EntityReference, HierarchyQueryScope, Set, Set) with 'ref', 'scope', 'entityLifecycleStatuses', 'applicationKinds'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ApplicationIdSelectionOptions ApplicationIdSelectionOptions.mkOpts(EntityReference, HierarchyQueryScope, Set, Set)"})
  void testMkOptsWithRefScopeEntityLifecycleStatusesApplicationKinds4() {
    // Arrange
    EntityReference ref = mock(EntityReference.class);

    LinkedHashSet<EntityLifecycleStatus> entityLifecycleStatuses = new LinkedHashSet<>();
    entityLifecycleStatuses.add(EntityLifecycleStatus.ACTIVE);

    // Act
    ApplicationIdSelectionOptions actualMkOptsResult = ApplicationIdSelectionOptions.mkOpts(ref,
        HierarchyQueryScope.EXACT, entityLifecycleStatuses, null);

    // Assert
    assertTrue(actualMkOptsResult instanceof ImmutableApplicationIdSelectionOptions);
    Set<ApplicationKind> applicationKindsResult = actualMkOptsResult.applicationKinds();
    assertEquals(7, applicationKindsResult.size());
    assertTrue(applicationKindsResult.contains(ApplicationKind.CUSTOMISED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.EUC));
    assertTrue(applicationKindsResult.contains(ApplicationKind.EXTERNALLY_HOSTED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.INTERNALLY_HOSTED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.IN_HOUSE));
    assertTrue(applicationKindsResult.contains(ApplicationKind.THIRD_PARTY));
    assertEquals(entityLifecycleStatuses, actualMkOptsResult.entityLifecycleStatuses());
  }

  /**
   * Test {@link ApplicationIdSelectionOptions#mkOpts(EntityReference, HierarchyQueryScope)} with {@code ref}, {@code scope}.
   * <ul>
   *   <li>Then filters return {@link ImmutableSelectionFilters}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApplicationIdSelectionOptions#mkOpts(EntityReference, HierarchyQueryScope)}
   */
  @Test
  @DisplayName("Test mkOpts(EntityReference, HierarchyQueryScope) with 'ref', 'scope'; then filters return ImmutableSelectionFilters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ApplicationIdSelectionOptions ApplicationIdSelectionOptions.mkOpts(EntityReference, HierarchyQueryScope)"})
  void testMkOptsWithRefScope_thenFiltersReturnImmutableSelectionFilters() {
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
   * Test {@link ApplicationIdSelectionOptions#mkOpts(EntityReference)} with {@code ref}.
   * <ul>
   *   <li>Given {@code ACTOR}.</li>
   *   <li>Then return scope is {@code EXACT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApplicationIdSelectionOptions#mkOpts(EntityReference)}
   */
  @Test
  @DisplayName("Test mkOpts(EntityReference) with 'ref'; given 'ACTOR'; then return scope is 'EXACT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ApplicationIdSelectionOptions ApplicationIdSelectionOptions.mkOpts(EntityReference)"})
  void testMkOptsWithRef_givenActor_thenReturnScopeIsExact() {
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
   * Test {@link ApplicationIdSelectionOptions#mkOpts(EntityReference)} with {@code ref}.
   * <ul>
   *   <li>Given {@code ALL}.</li>
   *   <li>Then return scope is {@code CHILDREN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApplicationIdSelectionOptions#mkOpts(EntityReference)}
   */
  @Test
  @DisplayName("Test mkOpts(EntityReference) with 'ref'; given 'ALL'; then return scope is 'CHILDREN'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ApplicationIdSelectionOptions ApplicationIdSelectionOptions.mkOpts(EntityReference)"})
  void testMkOptsWithRef_givenAll_thenReturnScopeIsChildren() {
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
}
