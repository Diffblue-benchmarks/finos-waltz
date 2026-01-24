package org.finos.waltz.model.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.application.ImmutableApplicationIdSelectionOptions.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ApplicationIdSelectionOptionsDiffblueTest {
  /**
   * Test {@link ApplicationIdSelectionOptions#mkOpts(IdSelectionOptions)} with {@code options}.
   *
   * <p>Method under test: {@link ApplicationIdSelectionOptions#mkOpts(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkOpts(IdSelectionOptions) with 'options'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationIdSelectionOptions ApplicationIdSelectionOptions.mkOpts(IdSelectionOptions)"
  })
  void testMkOptsWithOptions() {
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
    ImmutableIdSelectionOptions options =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    ApplicationIdSelectionOptions actualMkOptsResult =
        ApplicationIdSelectionOptions.mkOpts(options);

    // Assert
    EntityReference entityReferenceResult = actualMkOptsResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    SelectionFilters filtersResult2 = actualMkOptsResult.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    assertTrue(actualMkOptsResult instanceof ImmutableApplicationIdSelectionOptions);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    Set<ApplicationKind> applicationKindsResult = actualMkOptsResult.applicationKinds();
    assertEquals(7, applicationKindsResult.size());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertTrue(applicationKindsResult.contains(ApplicationKind.CUSTOMISED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.EUC));
    assertTrue(applicationKindsResult.contains(ApplicationKind.EXTERNALLY_HOSTED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.INTERNALLY_HOSTED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.IN_HOUSE));
    assertTrue(applicationKindsResult.contains(ApplicationKind.THIRD_PARTY));
    assertTrue(actualMkOptsResult.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
  }

  /**
   * Test {@link ApplicationIdSelectionOptions#mkOpts(IdSelectionOptions, Set)} with {@code
   * options}, {@code applicationKinds}.
   *
   * <ul>
   *   <li>Then return applicationKinds is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationIdSelectionOptions#mkOpts(IdSelectionOptions, Set)}
   */
  @Test
  @DisplayName(
      "Test mkOpts(IdSelectionOptions, Set) with 'options', 'applicationKinds'; then return applicationKinds is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationIdSelectionOptions ApplicationIdSelectionOptions.mkOpts(IdSelectionOptions, Set)"
  })
  void testMkOptsWithOptionsApplicationKinds_thenReturnApplicationKindsIsHashSet() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Builder builderResult =
        ImmutableApplicationIdSelectionOptions.builder();

    ImmutableApplicationIdSelectionOptions.Builder filtersResult =
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

    ImmutableApplicationIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableApplicationIdSelectionOptions options =
        joiningEntityKindResult
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    HashSet<ApplicationKind> applicationKinds = new HashSet<>();
    applicationKinds.add(ApplicationKind.EXTERNALLY_HOSTED);
    applicationKinds.add(ApplicationKind.IN_HOUSE);

    // Act
    ApplicationIdSelectionOptions actualMkOptsResult =
        ApplicationIdSelectionOptions.mkOpts(options, applicationKinds);

    // Assert
    assertTrue(actualMkOptsResult instanceof ImmutableApplicationIdSelectionOptions);
    assertEquals(applicationKinds, actualMkOptsResult.applicationKinds());
  }

  /**
   * Test {@link ApplicationIdSelectionOptions#mkOpts(IdSelectionOptions, Set)} with {@code
   * options}, {@code applicationKinds}.
   *
   * <ul>
   *   <li>Then return applicationKinds is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationIdSelectionOptions#mkOpts(IdSelectionOptions, Set)}
   */
  @Test
  @DisplayName(
      "Test mkOpts(IdSelectionOptions, Set) with 'options', 'applicationKinds'; then return applicationKinds is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationIdSelectionOptions ApplicationIdSelectionOptions.mkOpts(IdSelectionOptions, Set)"
  })
  void testMkOptsWithOptionsApplicationKinds_thenReturnApplicationKindsIsLinkedHashSet() {
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
    ImmutableIdSelectionOptions options =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    LinkedHashSet<ApplicationKind> applicationKinds = new LinkedHashSet<>();
    applicationKinds.add(ApplicationKind.IN_HOUSE);

    // Act
    ApplicationIdSelectionOptions actualMkOptsResult =
        ApplicationIdSelectionOptions.mkOpts(options, applicationKinds);

    // Assert
    EntityReference entityReferenceResult = actualMkOptsResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    SelectionFilters filtersResult2 = actualMkOptsResult.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    assertTrue(actualMkOptsResult instanceof ImmutableApplicationIdSelectionOptions);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, actualMkOptsResult.scope());
    assertTrue(actualMkOptsResult.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
    assertEquals(applicationKinds, actualMkOptsResult.applicationKinds());
  }

  /**
   * Test {@link ApplicationIdSelectionOptions#mkOpts(IdSelectionOptions, Set)} with {@code
   * options}, {@code applicationKinds}.
   *
   * <ul>
   *   <li>Then return applicationKinds size is seven.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationIdSelectionOptions#mkOpts(IdSelectionOptions, Set)}
   */
  @Test
  @DisplayName(
      "Test mkOpts(IdSelectionOptions, Set) with 'options', 'applicationKinds'; then return applicationKinds size is seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationIdSelectionOptions ApplicationIdSelectionOptions.mkOpts(IdSelectionOptions, Set)"
  })
  void testMkOptsWithOptionsApplicationKinds_thenReturnApplicationKindsSizeIsSeven() {
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
    ImmutableIdSelectionOptions options =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    ApplicationIdSelectionOptions actualMkOptsResult =
        ApplicationIdSelectionOptions.mkOpts(options, null);

    // Assert
    assertTrue(actualMkOptsResult instanceof ImmutableApplicationIdSelectionOptions);
    Set<ApplicationKind> applicationKindsResult = actualMkOptsResult.applicationKinds();
    assertEquals(7, applicationKindsResult.size());
    assertTrue(applicationKindsResult.contains(ApplicationKind.CUSTOMISED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.EUC));
    assertTrue(applicationKindsResult.contains(ApplicationKind.EXTERNALLY_HOSTED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.INTERNALLY_HOSTED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.THIRD_PARTY));
  }

  /**
   * Test {@link ApplicationIdSelectionOptions#mkOpts(IdSelectionOptions, Set)} with {@code
   * options}, {@code applicationKinds}.
   *
   * <ul>
   *   <li>Then return entityLifecycleStatuses Empty.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationIdSelectionOptions#mkOpts(IdSelectionOptions, Set)}
   */
  @Test
  @DisplayName(
      "Test mkOpts(IdSelectionOptions, Set) with 'options', 'applicationKinds'; then return entityLifecycleStatuses Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationIdSelectionOptions ApplicationIdSelectionOptions.mkOpts(IdSelectionOptions, Set)"
  })
  void testMkOptsWithOptionsApplicationKinds_thenReturnEntityLifecycleStatusesEmpty() {
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
    ImmutableIdSelectionOptions options =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    ApplicationIdSelectionOptions actualMkOptsResult =
        ApplicationIdSelectionOptions.mkOpts(options, new HashSet<>());

    // Assert
    EntityReference entityReferenceResult = actualMkOptsResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    SelectionFilters filtersResult2 = actualMkOptsResult.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    assertTrue(actualMkOptsResult instanceof ImmutableApplicationIdSelectionOptions);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, actualMkOptsResult.scope());
    assertTrue(actualMkOptsResult.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
    assertTrue(actualMkOptsResult.applicationKinds().isEmpty());
  }

  /**
   * Test {@link ApplicationIdSelectionOptions#mkOpts(IdSelectionOptions, Set)} with {@code
   * options}, {@code applicationKinds}.
   *
   * <ul>
   *   <li>Then return entityLifecycleStatuses size is one.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationIdSelectionOptions#mkOpts(IdSelectionOptions, Set)}
   */
  @Test
  @DisplayName(
      "Test mkOpts(IdSelectionOptions, Set) with 'options', 'applicationKinds'; then return entityLifecycleStatuses size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationIdSelectionOptions ApplicationIdSelectionOptions.mkOpts(IdSelectionOptions, Set)"
  })
  void testMkOptsWithOptionsApplicationKinds_thenReturnEntityLifecycleStatusesSizeIsOne() {
    // Arrange
    ImmutableApplicationIdSelectionOptions.Builder builderResult =
        ImmutableApplicationIdSelectionOptions.builder();

    ImmutableApplicationIdSelectionOptions.Builder filtersResult =
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

    ImmutableApplicationIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableApplicationIdSelectionOptions options =
        joiningEntityKindResult
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    ApplicationIdSelectionOptions actualMkOptsResult =
        ApplicationIdSelectionOptions.mkOpts(options, new HashSet<>());

    // Assert
    EntityReference entityReferenceResult = actualMkOptsResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    SelectionFilters filtersResult2 = actualMkOptsResult.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    assertTrue(actualMkOptsResult instanceof ImmutableApplicationIdSelectionOptions);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult =
        actualMkOptsResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, actualMkOptsResult.scope());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
    assertTrue(actualMkOptsResult.applicationKinds().isEmpty());
  }

  /**
   * Test {@link ApplicationIdSelectionOptions#mkOpts(IdSelectionOptions)} with {@code options}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   *   <li>Then return entityLifecycleStatuses size is one.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationIdSelectionOptions#mkOpts(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test mkOpts(IdSelectionOptions) with 'options'; given 'ACTIVE'; then return entityLifecycleStatuses size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationIdSelectionOptions ApplicationIdSelectionOptions.mkOpts(IdSelectionOptions)"
  })
  void testMkOptsWithOptions_givenActive_thenReturnEntityLifecycleStatusesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

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
    ImmutableIdSelectionOptions options =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    ApplicationIdSelectionOptions actualMkOptsResult =
        ApplicationIdSelectionOptions.mkOpts(options);

    // Assert
    assertTrue(actualMkOptsResult.entityReference() instanceof ImmutableEntityReference);
    assertTrue(actualMkOptsResult.filters() instanceof ImmutableSelectionFilters);
    assertTrue(actualMkOptsResult instanceof ImmutableApplicationIdSelectionOptions);
    assertEquals(1, actualMkOptsResult.entityLifecycleStatuses().size());
    assertEquals(7, actualMkOptsResult.applicationKinds().size());
    assertEquals(HierarchyQueryScope.EXACT, actualMkOptsResult.scope());
  }

  /**
   * Test {@link ApplicationIdSelectionOptions#mkOpts(IdSelectionOptions)} with {@code options}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return {@link Json}.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationIdSelectionOptions#mkOpts(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test mkOpts(IdSelectionOptions) with 'options'; when Json (default constructor); then return Json")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationIdSelectionOptions ApplicationIdSelectionOptions.mkOpts(IdSelectionOptions)"
  })
  void testMkOptsWithOptions_whenJson_thenReturnJson() {
    // Arrange and Act
    ApplicationIdSelectionOptions actualMkOptsResult =
        ApplicationIdSelectionOptions.mkOpts(new Json());

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
   * Test {@link ApplicationIdSelectionOptions#mkOpts(EntityReference)} with {@code ref}.
   *
   * <p>Method under test: {@link ApplicationIdSelectionOptions#mkOpts(EntityReference)}
   */
  @Test
  @DisplayName("Test mkOpts(EntityReference) with 'ref'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationIdSelectionOptions ApplicationIdSelectionOptions.mkOpts(EntityReference)"
  })
  void testMkOptsWithRef() {
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
    ApplicationIdSelectionOptions actualMkOptsResult = ApplicationIdSelectionOptions.mkOpts(ref);

    // Assert
    assertTrue(actualMkOptsResult instanceof ImmutableApplicationIdSelectionOptions);
    assertSame(ref, actualMkOptsResult.entityReference());
  }

  /**
   * Test {@link ApplicationIdSelectionOptions#mkOpts(EntityReference, HierarchyQueryScope, Set,
   * Set)} with {@code ref}, {@code scope}, {@code entityLifecycleStatuses}, {@code
   * applicationKinds}.
   *
   * <p>Method under test: {@link ApplicationIdSelectionOptions#mkOpts(EntityReference,
   * HierarchyQueryScope, Set, Set)}
   */
  @Test
  @DisplayName(
      "Test mkOpts(EntityReference, HierarchyQueryScope, Set, Set) with 'ref', 'scope', 'entityLifecycleStatuses', 'applicationKinds'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationIdSelectionOptions ApplicationIdSelectionOptions.mkOpts(EntityReference, HierarchyQueryScope, Set, Set)"
  })
  void testMkOptsWithRefScopeEntityLifecycleStatusesApplicationKinds() {
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
    HashSet<EntityLifecycleStatus> entityLifecycleStatuses = new HashSet<>();

    // Act
    ApplicationIdSelectionOptions actualMkOptsResult =
        ApplicationIdSelectionOptions.mkOpts(
            ref, HierarchyQueryScope.EXACT, entityLifecycleStatuses, new HashSet<>());

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
   * Test {@link ApplicationIdSelectionOptions#mkOpts(EntityReference, HierarchyQueryScope, Set,
   * Set)} with {@code ref}, {@code scope}, {@code entityLifecycleStatuses}, {@code
   * applicationKinds}.
   *
   * <p>Method under test: {@link ApplicationIdSelectionOptions#mkOpts(EntityReference,
   * HierarchyQueryScope, Set, Set)}
   */
  @Test
  @DisplayName(
      "Test mkOpts(EntityReference, HierarchyQueryScope, Set, Set) with 'ref', 'scope', 'entityLifecycleStatuses', 'applicationKinds'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationIdSelectionOptions ApplicationIdSelectionOptions.mkOpts(EntityReference, HierarchyQueryScope, Set, Set)"
  })
  void testMkOptsWithRefScopeEntityLifecycleStatusesApplicationKinds2() {
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

    LinkedHashSet<EntityLifecycleStatus> entityLifecycleStatuses = new LinkedHashSet<>();
    entityLifecycleStatuses.add(EntityLifecycleStatus.ACTIVE);

    LinkedHashSet<ApplicationKind> applicationKinds = new LinkedHashSet<>();
    applicationKinds.add(ApplicationKind.IN_HOUSE);

    // Act
    ApplicationIdSelectionOptions actualMkOptsResult =
        ApplicationIdSelectionOptions.mkOpts(
            ref, HierarchyQueryScope.EXACT, entityLifecycleStatuses, applicationKinds);

    // Assert
    SelectionFilters filtersResult = actualMkOptsResult.filters();
    assertTrue(filtersResult instanceof ImmutableSelectionFilters);
    assertTrue(actualMkOptsResult instanceof ImmutableApplicationIdSelectionOptions);
    assertEquals(HierarchyQueryScope.EXACT, actualMkOptsResult.scope());
    assertTrue(filtersResult.omitApplicationKinds().isEmpty());
    assertEquals(entityLifecycleStatuses, actualMkOptsResult.entityLifecycleStatuses());
    assertEquals(applicationKinds, actualMkOptsResult.applicationKinds());
    assertSame(ref, actualMkOptsResult.entityReference());
  }

  /**
   * Test {@link ApplicationIdSelectionOptions#mkOpts(EntityReference, HierarchyQueryScope, Set,
   * Set)} with {@code ref}, {@code scope}, {@code entityLifecycleStatuses}, {@code
   * applicationKinds}.
   *
   * <p>Method under test: {@link ApplicationIdSelectionOptions#mkOpts(EntityReference,
   * HierarchyQueryScope, Set, Set)}
   */
  @Test
  @DisplayName(
      "Test mkOpts(EntityReference, HierarchyQueryScope, Set, Set) with 'ref', 'scope', 'entityLifecycleStatuses', 'applicationKinds'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationIdSelectionOptions ApplicationIdSelectionOptions.mkOpts(EntityReference, HierarchyQueryScope, Set, Set)"
  })
  void testMkOptsWithRefScopeEntityLifecycleStatusesApplicationKinds3() {
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

    LinkedHashSet<EntityLifecycleStatus> entityLifecycleStatuses = new LinkedHashSet<>();
    entityLifecycleStatuses.add(EntityLifecycleStatus.ACTIVE);

    // Act
    ApplicationIdSelectionOptions actualMkOptsResult =
        ApplicationIdSelectionOptions.mkOpts(
            ref, HierarchyQueryScope.EXACT, entityLifecycleStatuses, null);

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
  }

  /**
   * Test {@link ApplicationIdSelectionOptions#mkOpts(EntityReference, HierarchyQueryScope, Set,
   * Set)} with {@code ref}, {@code scope}, {@code entityLifecycleStatuses}, {@code
   * applicationKinds}.
   *
   * <p>Method under test: {@link ApplicationIdSelectionOptions#mkOpts(EntityReference,
   * HierarchyQueryScope, Set, Set)}
   */
  @Test
  @DisplayName(
      "Test mkOpts(EntityReference, HierarchyQueryScope, Set, Set) with 'ref', 'scope', 'entityLifecycleStatuses', 'applicationKinds'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationIdSelectionOptions ApplicationIdSelectionOptions.mkOpts(EntityReference, HierarchyQueryScope, Set, Set)"
  })
  void testMkOptsWithRefScopeEntityLifecycleStatusesApplicationKinds4() {
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

    LinkedHashSet<ApplicationKind> applicationKinds = new LinkedHashSet<>();
    applicationKinds.add(ApplicationKind.IN_HOUSE);

    // Act
    ApplicationIdSelectionOptions actualMkOptsResult =
        ApplicationIdSelectionOptions.mkOpts(
            ref, HierarchyQueryScope.EXACT, null, applicationKinds);

    // Assert
    SelectionFilters filtersResult = actualMkOptsResult.filters();
    assertTrue(filtersResult instanceof ImmutableSelectionFilters);
    assertTrue(actualMkOptsResult instanceof ImmutableApplicationIdSelectionOptions);
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult =
        actualMkOptsResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    assertEquals(HierarchyQueryScope.EXACT, actualMkOptsResult.scope());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(filtersResult.omitApplicationKinds().isEmpty());
    assertEquals(applicationKinds, actualMkOptsResult.applicationKinds());
    assertSame(ref, actualMkOptsResult.entityReference());
  }

  /**
   * Test {@link ApplicationIdSelectionOptions#mkOpts(EntityReference, HierarchyQueryScope, Set,
   * Set)} with {@code ref}, {@code scope}, {@code entityLifecycleStatuses}, {@code
   * applicationKinds}.
   *
   * <p>Method under test: {@link ApplicationIdSelectionOptions#mkOpts(EntityReference,
   * HierarchyQueryScope, Set, Set)}
   */
  @Test
  @DisplayName(
      "Test mkOpts(EntityReference, HierarchyQueryScope, Set, Set) with 'ref', 'scope', 'entityLifecycleStatuses', 'applicationKinds'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationIdSelectionOptions ApplicationIdSelectionOptions.mkOpts(EntityReference, HierarchyQueryScope, Set, Set)"
  })
  void testMkOptsWithRefScopeEntityLifecycleStatusesApplicationKinds5() {
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

    HashSet<EntityLifecycleStatus> entityLifecycleStatuses = new HashSet<>();
    entityLifecycleStatuses.add(EntityLifecycleStatus.REMOVED);
    entityLifecycleStatuses.add(EntityLifecycleStatus.ACTIVE);

    // Act
    ApplicationIdSelectionOptions actualMkOptsResult =
        ApplicationIdSelectionOptions.mkOpts(
            ref, HierarchyQueryScope.EXACT, entityLifecycleStatuses, new HashSet<>());

    // Assert
    assertTrue(actualMkOptsResult instanceof ImmutableApplicationIdSelectionOptions);
    assertTrue(actualMkOptsResult.applicationKinds().isEmpty());
    assertEquals(entityLifecycleStatuses, actualMkOptsResult.entityLifecycleStatuses());
  }

  /**
   * Test {@link ApplicationIdSelectionOptions#mkOpts(EntityReference, HierarchyQueryScope)} with
   * {@code ref}, {@code scope}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationIdSelectionOptions#mkOpts(EntityReference,
   * HierarchyQueryScope)}
   */
  @Test
  @DisplayName(
      "Test mkOpts(EntityReference, HierarchyQueryScope) with 'ref', 'scope'; then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationIdSelectionOptions ApplicationIdSelectionOptions.mkOpts(EntityReference, HierarchyQueryScope)"
  })
  void testMkOptsWithRefScope_thenEntityReferenceReturnImmutableEntityReference() {
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
    ApplicationIdSelectionOptions actualMkOptsResult =
        ApplicationIdSelectionOptions.mkOpts(ref, HierarchyQueryScope.EXACT);

    // Assert
    EntityReference entityReferenceResult = actualMkOptsResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualMkOptsResult.filters() instanceof ImmutableSelectionFilters);
    assertTrue(actualMkOptsResult instanceof ImmutableApplicationIdSelectionOptions);
    assertEquals(1, actualMkOptsResult.entityLifecycleStatuses().size());
    assertEquals(7, actualMkOptsResult.applicationKinds().size());
    assertEquals(HierarchyQueryScope.EXACT, actualMkOptsResult.scope());
    assertSame(ref, entityReferenceResult);
  }

  /**
   * Test {@link ApplicationIdSelectionOptions#mkOpts(EntityReference)} with {@code ref}.
   *
   * <ul>
   *   <li>Then return scope is {@code CHILDREN}.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationIdSelectionOptions#mkOpts(EntityReference)}
   */
  @Test
  @DisplayName("Test mkOpts(EntityReference) with 'ref'; then return scope is 'CHILDREN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationIdSelectionOptions ApplicationIdSelectionOptions.mkOpts(EntityReference)"
  })
  void testMkOptsWithRef_thenReturnScopeIsChildren() {
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
    ApplicationIdSelectionOptions actualMkOptsResult = ApplicationIdSelectionOptions.mkOpts(ref);

    // Assert
    assertTrue(actualMkOptsResult instanceof ImmutableApplicationIdSelectionOptions);
    assertEquals(HierarchyQueryScope.CHILDREN, actualMkOptsResult.scope());
    assertSame(ref, actualMkOptsResult.entityReference());
  }

  /**
   * Test {@link ApplicationIdSelectionOptions#mkOpts(EntityReference)} with {@code ref}.
   *
   * <ul>
   *   <li>Then return scope is {@code EXACT}.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationIdSelectionOptions#mkOpts(EntityReference)}
   */
  @Test
  @DisplayName("Test mkOpts(EntityReference) with 'ref'; then return scope is 'EXACT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationIdSelectionOptions ApplicationIdSelectionOptions.mkOpts(EntityReference)"
  })
  void testMkOptsWithRef_thenReturnScopeIsExact() {
    // Arrange
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .name("Name")
            .build();

    // Act
    ApplicationIdSelectionOptions actualMkOptsResult = ApplicationIdSelectionOptions.mkOpts(ref);

    // Assert
    assertTrue(actualMkOptsResult instanceof ImmutableApplicationIdSelectionOptions);
    assertEquals(HierarchyQueryScope.EXACT, actualMkOptsResult.scope());
    assertSame(ref, actualMkOptsResult.entityReference());
  }
}
