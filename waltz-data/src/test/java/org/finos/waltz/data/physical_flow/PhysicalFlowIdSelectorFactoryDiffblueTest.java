package org.finos.waltz.data.physical_flow;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.application.ApplicationKind;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PhysicalFlowIdSelectorFactoryDiffblueTest {
  /**
   * Test {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <p>Method under test: {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select PhysicalFlowIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions() {
    // Arrange
    PhysicalFlowIdSelectorFactory physicalFlowIdSelectorFactory =
        new PhysicalFlowIdSelectorFactory();

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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            physicalFlowIdSelectorFactory.apply(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build()));
  }

  /**
   * Test {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <p>Method under test: {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select PhysicalFlowIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions2() {
    // Arrange
    PhysicalFlowIdSelectorFactory physicalFlowIdSelectorFactory =
        new PhysicalFlowIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> physicalFlowIdSelectorFactory.apply(options));
    verify(options).entityReference();
  }

  /**
   * Test {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <p>Method under test: {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select PhysicalFlowIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions3() {
    // Arrange
    PhysicalFlowIdSelectorFactory physicalFlowIdSelectorFactory =
        new PhysicalFlowIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> physicalFlowIdSelectorFactory.apply(options));
    verify(options).entityReference();
  }

  /**
   * Test {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <p>Method under test: {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select PhysicalFlowIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions4() {
    // Arrange
    PhysicalFlowIdSelectorFactory physicalFlowIdSelectorFactory =
        new PhysicalFlowIdSelectorFactory();

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
    physicalFlowIdSelectorFactory.apply(options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
  }

  /**
   * Test {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <p>Method under test: {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select PhysicalFlowIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions5() {
    // Arrange
    PhysicalFlowIdSelectorFactory physicalFlowIdSelectorFactory =
        new PhysicalFlowIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenThrow(new UnsupportedOperationException());
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

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> physicalFlowIdSelectorFactory.apply(options));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
  }

  /**
   * Test {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <p>Method under test: {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select PhysicalFlowIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions6() {
    // Arrange
    PhysicalFlowIdSelectorFactory physicalFlowIdSelectorFactory =
        new PhysicalFlowIdSelectorFactory();

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
                .kind(EntityKind.APPLICATION)
                .name("Name")
                .build());

    // Act
    physicalFlowIdSelectorFactory.apply(options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
  }

  /**
   * Test {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <ul>
   *   <li>Given builder addOmitApplicationKinds {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given builder addOmitApplicationKinds 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select PhysicalFlowIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_givenBuilderAddOmitApplicationKindsInHouse() {
    // Arrange
    PhysicalFlowIdSelectorFactory physicalFlowIdSelectorFactory =
        new PhysicalFlowIdSelectorFactory();

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
    physicalFlowIdSelectorFactory.apply(options);

    // Assert
    verify(options, atLeast(1)).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).scope();
  }

  /**
   * Test {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <ul>
   *   <li>Given builder build.
   *   <li>Then calls {@link IdSelectionOptions#filters()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given builder build; then calls filters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select PhysicalFlowIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_givenBuilderBuild_thenCallsFilters() {
    // Arrange
    PhysicalFlowIdSelectorFactory physicalFlowIdSelectorFactory =
        new PhysicalFlowIdSelectorFactory();

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
    physicalFlowIdSelectorFactory.apply(options);

    // Assert
    verify(options, atLeast(1)).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
  }

  /**
   * Test {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code PENDING}.
   *   <li>Then calls {@link IdSelectionOptions#filters()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given HashSet() add 'PENDING'; then calls filters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select PhysicalFlowIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_givenHashSetAddPending_thenCallsFilters() {
    // Arrange
    PhysicalFlowIdSelectorFactory physicalFlowIdSelectorFactory =
        new PhysicalFlowIdSelectorFactory();

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
    physicalFlowIdSelectorFactory.apply(options);

    // Assert
    verify(options, atLeast(1)).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
  }

  /**
   * Test {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code REMOVED}.
   *   <li>Then calls {@link IdSelectionOptions#filters()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given HashSet() add 'REMOVED'; then calls filters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select PhysicalFlowIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_givenHashSetAddRemoved_thenCallsFilters() {
    // Arrange
    PhysicalFlowIdSelectorFactory physicalFlowIdSelectorFactory =
        new PhysicalFlowIdSelectorFactory();

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.REMOVED);
    entityLifecycleStatusSet.addAll(new ArrayList<>());

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
    physicalFlowIdSelectorFactory.apply(options);

    // Assert
    verify(options, atLeast(1)).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
  }

  /**
   * Test {@link PhysicalFlowIdSelectorFactory#getLifecycleCondition(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PhysicalFlowIdSelectorFactory#getLifecycleCondition(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getLifecycleCondition(IdSelectionOptions); given HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Condition PhysicalFlowIdSelectorFactory.getLifecycleCondition(IdSelectionOptions)"
  })
  void testGetLifecycleCondition_givenHashSet() {
    // Arrange
    PhysicalFlowIdSelectorFactory physicalFlowIdSelectorFactory =
        new PhysicalFlowIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());

    // Act
    physicalFlowIdSelectorFactory.getLifecycleCondition(options);

    // Assert
    verify(options).entityLifecycleStatuses();
  }

  /**
   * Test {@link PhysicalFlowIdSelectorFactory#getLifecycleCondition(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code REMOVED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PhysicalFlowIdSelectorFactory#getLifecycleCondition(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getLifecycleCondition(IdSelectionOptions); given HashSet() add 'REMOVED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Condition PhysicalFlowIdSelectorFactory.getLifecycleCondition(IdSelectionOptions)"
  })
  void testGetLifecycleCondition_givenHashSetAddRemoved() {
    // Arrange
    PhysicalFlowIdSelectorFactory physicalFlowIdSelectorFactory =
        new PhysicalFlowIdSelectorFactory();

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.REMOVED);
    entityLifecycleStatusSet.addAll(new ArrayList<>());

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);

    // Act
    physicalFlowIdSelectorFactory.getLifecycleCondition(options);

    // Assert
    verify(options).entityLifecycleStatuses();
  }

  /**
   * Test {@link PhysicalFlowIdSelectorFactory#getLifecycleCondition(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PhysicalFlowIdSelectorFactory#getLifecycleCondition(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getLifecycleCondition(IdSelectionOptions); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Condition PhysicalFlowIdSelectorFactory.getLifecycleCondition(IdSelectionOptions)"
  })
  void testGetLifecycleCondition_thenThrowUnsupportedOperationException() {
    // Arrange
    PhysicalFlowIdSelectorFactory physicalFlowIdSelectorFactory =
        new PhysicalFlowIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> physicalFlowIdSelectorFactory.getLifecycleCondition(options));
    verify(options).entityLifecycleStatuses();
  }
}
