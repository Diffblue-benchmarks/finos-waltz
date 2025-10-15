package org.finos.waltz.data.measurable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MeasurableIdSelectorFactoryDiffblueTest {
  /**
   * Test {@link MeasurableIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <p>Method under test: {@link MeasurableIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Select MeasurableIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions() {
    // Arrange
    MeasurableIdSelectorFactory measurableIdSelectorFactory = new MeasurableIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> measurableIdSelectorFactory.apply(options));
    verify(options).entityReference();
  }

  /**
   * Test {@link MeasurableIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <p>Method under test: {@link MeasurableIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Select MeasurableIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions2() {
    // Arrange
    MeasurableIdSelectorFactory measurableIdSelectorFactory = new MeasurableIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
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
    measurableIdSelectorFactory.apply(options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
  }

  /**
   * Test {@link MeasurableIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <p>Method under test: {@link MeasurableIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Select MeasurableIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions3() {
    // Arrange
    MeasurableIdSelectorFactory measurableIdSelectorFactory = new MeasurableIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenThrow(new UnsupportedOperationException());
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
        UnsupportedOperationException.class, () -> measurableIdSelectorFactory.apply(options));
    verify(options).entityReference();
    verify(options).scope();
  }

  /**
   * Test {@link MeasurableIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <p>Method under test: {@link MeasurableIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Select MeasurableIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions4() {
    // Arrange
    MeasurableIdSelectorFactory measurableIdSelectorFactory = new MeasurableIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> measurableIdSelectorFactory.apply(options));
    verify(options, atLeast(1)).entityReference();
  }

  /**
   * Test {@link MeasurableIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <ul>
   *   <li>Given builder addOmitApplicationKinds {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given builder addOmitApplicationKinds 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Select MeasurableIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_givenBuilderAddOmitApplicationKindsInHouse() {
    // Arrange
    MeasurableIdSelectorFactory measurableIdSelectorFactory = new MeasurableIdSelectorFactory();

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
    ImmutableSelectionFilters immutableSelectionFilters = builderResult.build();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> emptyResult = Optional.empty();
    when(options.joiningEntityKind()).thenReturn(emptyResult);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(immutableSelectionFilters);
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
    measurableIdSelectorFactory.apply(options);

    // Assert
    verify(options, atLeast(1)).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).joiningEntityKind();
    verify(options, atLeast(1)).scope();
  }

  /**
   * Test {@link MeasurableIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>Then calls {@link IdSelectionOptions#filters()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given empty; then calls filters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Select MeasurableIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_givenEmpty_thenCallsFilters() {
    // Arrange
    MeasurableIdSelectorFactory measurableIdSelectorFactory = new MeasurableIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> emptyResult = Optional.empty();
    when(options.joiningEntityKind()).thenReturn(emptyResult);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
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
    measurableIdSelectorFactory.apply(options);

    // Assert
    verify(options, atLeast(1)).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).joiningEntityKind();
    verify(options, atLeast(1)).scope();
  }

  /**
   * Test {@link MeasurableIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code PENDING}.
   *   <li>Then calls {@link IdSelectionOptions#filters()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given HashSet() add 'PENDING'; then calls filters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Select MeasurableIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_givenHashSetAddPending_thenCallsFilters() {
    // Arrange
    MeasurableIdSelectorFactory measurableIdSelectorFactory = new MeasurableIdSelectorFactory();

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.PENDING);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> emptyResult = Optional.empty();
    when(options.joiningEntityKind()).thenReturn(emptyResult);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
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
    measurableIdSelectorFactory.apply(options);

    // Assert
    verify(options, atLeast(1)).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).joiningEntityKind();
    verify(options, atLeast(1)).scope();
  }

  /**
   * Test {@link MeasurableIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code REMOVED}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given HashSet() add 'REMOVED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Select MeasurableIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_givenHashSetAddRemoved() {
    // Arrange
    MeasurableIdSelectorFactory measurableIdSelectorFactory = new MeasurableIdSelectorFactory();

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.REMOVED);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
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
    measurableIdSelectorFactory.apply(options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
  }

  /**
   * Test {@link MeasurableIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code REMOVED}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given HashSet() add 'REMOVED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Select MeasurableIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_givenHashSetAddRemoved2() {
    // Arrange
    MeasurableIdSelectorFactory measurableIdSelectorFactory = new MeasurableIdSelectorFactory();

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);
    entityLifecycleStatusSet.add(EntityLifecycleStatus.REMOVED);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
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
    measurableIdSelectorFactory.apply(options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
  }

  /**
   * Test {@link MeasurableIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <ul>
   *   <li>Given of {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given of 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Select MeasurableIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_givenOfAll() {
    // Arrange
    MeasurableIdSelectorFactory measurableIdSelectorFactory = new MeasurableIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(options.joiningEntityKind()).thenReturn(ofResult);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
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
    measurableIdSelectorFactory.apply(options);

    // Assert
    verify(options, atLeast(1)).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).joiningEntityKind();
    verify(options, atLeast(1)).scope();
  }

  /**
   * Test {@link MeasurableIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Select MeasurableIdSelectorFactory.apply(IdSelectionOptions)"})
  void testApplyWithIdSelectionOptions_thenReturnNull() {
    // Arrange
    MeasurableIdSelectorFactory measurableIdSelectorFactory = new MeasurableIdSelectorFactory();

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

    // Act
    Select<Record1<Long>> actualApplyResult = measurableIdSelectorFactory.apply(options);

    // Assert
    verify(options).entityReference();
    assertNull(actualApplyResult);
  }

  /**
   * Test new {@link MeasurableIdSelectorFactory} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * MeasurableIdSelectorFactory}
   */
  @Test
  @DisplayName("Test new MeasurableIdSelectorFactory (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MeasurableIdSelectorFactory.<init>()"})
  void testNewMeasurableIdSelectorFactory() {
    // Arrange and Act
    MeasurableIdSelectorFactory actualMeasurableIdSelectorFactory =
        new MeasurableIdSelectorFactory();
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
    actualMeasurableIdSelectorFactory.apply(options);

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
   * Test new {@link MeasurableIdSelectorFactory} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * MeasurableIdSelectorFactory}
   */
  @Test
  @DisplayName("Test new MeasurableIdSelectorFactory (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MeasurableIdSelectorFactory.<init>()"})
  void testNewMeasurableIdSelectorFactory2() {
    // Arrange and Act
    MeasurableIdSelectorFactory actualMeasurableIdSelectorFactory =
        new MeasurableIdSelectorFactory();
    Builder builderResult = ImmutableIdSelectionOptions.builder();
    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.AGGREGATE_OVERLAY_DIAGRAM)
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
    Select<Record1<Long>> actualApplyResult = actualMeasurableIdSelectorFactory.apply(options);

    // Assert
    EntityReference entityReferenceResult = options.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    SelectionFilters filtersResult2 = options.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertNull(actualApplyResult);
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.AGGREGATE_OVERLAY_DIAGRAM, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, options.scope());
    assertTrue(options.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
  }

  /**
   * Test new {@link MeasurableIdSelectorFactory} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * MeasurableIdSelectorFactory}
   */
  @Test
  @DisplayName("Test new MeasurableIdSelectorFactory (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MeasurableIdSelectorFactory.<init>()"})
  void testNewMeasurableIdSelectorFactory3() {
    // Arrange and Act
    MeasurableIdSelectorFactory actualMeasurableIdSelectorFactory =
        new MeasurableIdSelectorFactory();
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
    actualMeasurableIdSelectorFactory.apply(options);

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
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
  }

  /**
   * Test new {@link MeasurableIdSelectorFactory} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * MeasurableIdSelectorFactory}
   */
  @Test
  @DisplayName("Test new MeasurableIdSelectorFactory (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MeasurableIdSelectorFactory.<init>()"})
  void testNewMeasurableIdSelectorFactory4() {
    // Arrange and Act
    MeasurableIdSelectorFactory actualMeasurableIdSelectorFactory =
        new MeasurableIdSelectorFactory();
    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.PENDING);
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);
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
    actualMeasurableIdSelectorFactory.apply(options);

    // Assert that nothing has changed
    EntityReference entityReferenceResult = options.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    SelectionFilters filtersResult2 = options.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult = options.entityLifecycleStatuses();
    assertEquals(2, entityLifecycleStatusesResult.size());
    assertEquals(EntityKind.ACTOR, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, options.scope());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.PENDING));
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
  }
}
