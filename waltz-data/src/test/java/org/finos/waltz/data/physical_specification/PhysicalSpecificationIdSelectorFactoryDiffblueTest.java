package org.finos.waltz.data.physical_specification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
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
import org.finos.waltz.model.application.ApplicationKind;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PhysicalSpecificationIdSelectorFactoryDiffblueTest {
  /**
   * Test {@link PhysicalSpecificationIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <p>Method under test: {@link PhysicalSpecificationIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Select PhysicalSpecificationIdSelectorFactory.apply(IdSelectionOptions)"
  })
  void testApplyWithIdSelectionOptions() {
    // Arrange
    PhysicalSpecificationIdSelectorFactory physicalSpecificationIdSelectorFactory =
        new PhysicalSpecificationIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> physicalSpecificationIdSelectorFactory.apply(options));
    verify(options).entityReference();
  }

  /**
   * Test {@link PhysicalSpecificationIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <p>Method under test: {@link PhysicalSpecificationIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Select PhysicalSpecificationIdSelectorFactory.apply(IdSelectionOptions)"
  })
  void testApplyWithIdSelectionOptions2() {
    // Arrange
    PhysicalSpecificationIdSelectorFactory physicalSpecificationIdSelectorFactory =
        new PhysicalSpecificationIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Act
    physicalSpecificationIdSelectorFactory.apply(options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
  }

  /**
   * Test {@link PhysicalSpecificationIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <p>Method under test: {@link PhysicalSpecificationIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Select PhysicalSpecificationIdSelectorFactory.apply(IdSelectionOptions)"
  })
  void testApplyWithIdSelectionOptions3() {
    // Arrange
    PhysicalSpecificationIdSelectorFactory physicalSpecificationIdSelectorFactory =
        new PhysicalSpecificationIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.AGGREGATE_OVERLAY_DIAGRAM)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> physicalSpecificationIdSelectorFactory.apply(options));
    verify(options).entityReference();
  }

  /**
   * Test {@link PhysicalSpecificationIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <ul>
   *   <li>Given builder addOmitApplicationKinds {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given builder addOmitApplicationKinds 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Select PhysicalSpecificationIdSelectorFactory.apply(IdSelectionOptions)"
  })
  void testApplyWithIdSelectionOptions_givenBuilderAddOmitApplicationKindsInHouse() {
    // Arrange
    PhysicalSpecificationIdSelectorFactory physicalSpecificationIdSelectorFactory =
        new PhysicalSpecificationIdSelectorFactory();

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.filters()).thenReturn(builderResult.build());
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act
    physicalSpecificationIdSelectorFactory.apply(options);

    // Assert
    verify(options, atLeast(1)).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).scope();
  }

  /**
   * Test {@link PhysicalSpecificationIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <ul>
   *   <li>Given builder build.
   *   <li>Then calls {@link IdSelectionOptions#filters()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given builder build; then calls filters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Select PhysicalSpecificationIdSelectorFactory.apply(IdSelectionOptions)"
  })
  void testApplyWithIdSelectionOptions_givenBuilderBuild_thenCallsFilters() {
    // Arrange
    PhysicalSpecificationIdSelectorFactory physicalSpecificationIdSelectorFactory =
        new PhysicalSpecificationIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act
    physicalSpecificationIdSelectorFactory.apply(options);

    // Assert
    verify(options, atLeast(1)).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
  }

  /**
   * Test {@link PhysicalSpecificationIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code PENDING}.
   *   <li>Then calls {@link IdSelectionOptions#filters()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given HashSet() add 'PENDING'; then calls filters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Select PhysicalSpecificationIdSelectorFactory.apply(IdSelectionOptions)"
  })
  void testApplyWithIdSelectionOptions_givenHashSetAddPending_thenCallsFilters() {
    // Arrange
    PhysicalSpecificationIdSelectorFactory physicalSpecificationIdSelectorFactory =
        new PhysicalSpecificationIdSelectorFactory();

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.PENDING);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act
    physicalSpecificationIdSelectorFactory.apply(options);

    // Assert
    verify(options, atLeast(1)).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
  }

  /**
   * Test new {@link PhysicalSpecificationIdSelectorFactory} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * PhysicalSpecificationIdSelectorFactory}
   */
  @Test
  @DisplayName("Test new PhysicalSpecificationIdSelectorFactory (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhysicalSpecificationIdSelectorFactory.<init>()"})
  void testNewPhysicalSpecificationIdSelectorFactory() {
    // Arrange and Act
    PhysicalSpecificationIdSelectorFactory actualPhysicalSpecificationIdSelectorFactory =
        new PhysicalSpecificationIdSelectorFactory();
    Builder builderResult = ImmutableIdSelectionOptions.builder();
    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);
    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions options =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    actualPhysicalSpecificationIdSelectorFactory.apply(options);

    // Assert that nothing has changed
    EntityReference entityReferenceResult = options.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    SelectionFilters filtersResult2 = options.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ACTOR, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, options.scope());
    assertTrue(options.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
  }

  /**
   * Test new {@link PhysicalSpecificationIdSelectorFactory} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * PhysicalSpecificationIdSelectorFactory}
   */
  @Test
  @DisplayName("Test new PhysicalSpecificationIdSelectorFactory (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhysicalSpecificationIdSelectorFactory.<init>()"})
  void testNewPhysicalSpecificationIdSelectorFactory2() {
    // Arrange and Act
    PhysicalSpecificationIdSelectorFactory actualPhysicalSpecificationIdSelectorFactory =
        new PhysicalSpecificationIdSelectorFactory();
    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.REMOVED);
    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);
    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions options =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    actualPhysicalSpecificationIdSelectorFactory.apply(options);

    // Assert that nothing has changed
    EntityReference entityReferenceResult = options.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    SelectionFilters filtersResult2 = options.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult = options.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ACTOR, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, options.scope());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.REMOVED));
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
  }
}
