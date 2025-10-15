package org.finos.waltz.data.legal_entity;

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

class LegalEntityRelationshipIdSelectorFactoryDiffblueTest {
  /**
   * Test {@link LegalEntityRelationshipIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <p>Method under test: {@link
   * LegalEntityRelationshipIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Select LegalEntityRelationshipIdSelectorFactory.apply(IdSelectionOptions)"
  })
  void testApplyWithIdSelectionOptions() {
    // Arrange
    LegalEntityRelationshipIdSelectorFactory legalEntityRelationshipIdSelectorFactory =
        new LegalEntityRelationshipIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> legalEntityRelationshipIdSelectorFactory.apply(options));
    verify(options).entityReference();
  }

  /**
   * Test {@link LegalEntityRelationshipIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <p>Method under test: {@link
   * LegalEntityRelationshipIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test apply(IdSelectionOptions) with 'IdSelectionOptions'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Select LegalEntityRelationshipIdSelectorFactory.apply(IdSelectionOptions)"
  })
  void testApplyWithIdSelectionOptions2() {
    // Arrange
    LegalEntityRelationshipIdSelectorFactory legalEntityRelationshipIdSelectorFactory =
        new LegalEntityRelationshipIdSelectorFactory();

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
        () -> legalEntityRelationshipIdSelectorFactory.apply(options));
    verify(options).entityReference();
  }

  /**
   * Test {@link LegalEntityRelationshipIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <ul>
   *   <li>Given builder addOmitApplicationKinds {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LegalEntityRelationshipIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given builder addOmitApplicationKinds 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Select LegalEntityRelationshipIdSelectorFactory.apply(IdSelectionOptions)"
  })
  void testApplyWithIdSelectionOptions_givenBuilderAddOmitApplicationKindsInHouse() {
    // Arrange
    LegalEntityRelationshipIdSelectorFactory legalEntityRelationshipIdSelectorFactory =
        new LegalEntityRelationshipIdSelectorFactory();

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
    ImmutableSelectionFilters immutableSelectionFilters = builderResult.build();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(immutableSelectionFilters);
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

    // Act
    legalEntityRelationshipIdSelectorFactory.apply(options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
  }

  /**
   * Test {@link LegalEntityRelationshipIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <ul>
   *   <li>Given {@link HierarchyQueryScope#EXACT}.
   *   <li>Then calls {@link IdSelectionOptions#scope()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LegalEntityRelationshipIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given EXACT; then calls scope()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Select LegalEntityRelationshipIdSelectorFactory.apply(IdSelectionOptions)"
  })
  void testApplyWithIdSelectionOptions_givenExact_thenCallsScope() {
    // Arrange
    LegalEntityRelationshipIdSelectorFactory legalEntityRelationshipIdSelectorFactory =
        new LegalEntityRelationshipIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
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
    legalEntityRelationshipIdSelectorFactory.apply(options);

    // Assert
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
  }

  /**
   * Test {@link LegalEntityRelationshipIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <ul>
   *   <li>Given {@link HierarchyQueryScope#EXACT}.
   *   <li>Then calls {@link IdSelectionOptions#scope()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LegalEntityRelationshipIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given EXACT; then calls scope()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Select LegalEntityRelationshipIdSelectorFactory.apply(IdSelectionOptions)"
  })
  void testApplyWithIdSelectionOptions_givenExact_thenCallsScope2() {
    // Arrange
    LegalEntityRelationshipIdSelectorFactory legalEntityRelationshipIdSelectorFactory =
        new LegalEntityRelationshipIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
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
    legalEntityRelationshipIdSelectorFactory.apply(options);

    // Assert
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
  }

  /**
   * Test {@link LegalEntityRelationshipIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <ul>
   *   <li>Given {@link HierarchyQueryScope#EXACT}.
   *   <li>Then calls {@link IdSelectionOptions#scope()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LegalEntityRelationshipIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given EXACT; then calls scope()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Select LegalEntityRelationshipIdSelectorFactory.apply(IdSelectionOptions)"
  })
  void testApplyWithIdSelectionOptions_givenExact_thenCallsScope3() {
    // Arrange
    LegalEntityRelationshipIdSelectorFactory legalEntityRelationshipIdSelectorFactory =
        new LegalEntityRelationshipIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
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
    legalEntityRelationshipIdSelectorFactory.apply(options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
  }

  /**
   * Test {@link LegalEntityRelationshipIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LegalEntityRelationshipIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given HashSet() add 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Select LegalEntityRelationshipIdSelectorFactory.apply(IdSelectionOptions)"
  })
  void testApplyWithIdSelectionOptions_givenHashSetAddActive() {
    // Arrange
    LegalEntityRelationshipIdSelectorFactory legalEntityRelationshipIdSelectorFactory =
        new LegalEntityRelationshipIdSelectorFactory();

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
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

    // Act
    legalEntityRelationshipIdSelectorFactory.apply(options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
  }

  /**
   * Test {@link LegalEntityRelationshipIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LegalEntityRelationshipIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test apply(IdSelectionOptions) with 'IdSelectionOptions'; given HashSet() add 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Select LegalEntityRelationshipIdSelectorFactory.apply(IdSelectionOptions)"
  })
  void testApplyWithIdSelectionOptions_givenHashSetAddPending() {
    // Arrange
    LegalEntityRelationshipIdSelectorFactory legalEntityRelationshipIdSelectorFactory =
        new LegalEntityRelationshipIdSelectorFactory();

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.PENDING);
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
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

    // Act
    legalEntityRelationshipIdSelectorFactory.apply(options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
  }

  /**
   * Test {@link LegalEntityRelationshipIdSelectorFactory#apply(IdSelectionOptions)} with {@code
   * IdSelectionOptions}.
   *
   * <ul>
   *   <li>Then calls {@link IdSelectionOptions#entityLifecycleStatuses()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LegalEntityRelationshipIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test apply(IdSelectionOptions) with 'IdSelectionOptions'; then calls entityLifecycleStatuses()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.Select LegalEntityRelationshipIdSelectorFactory.apply(IdSelectionOptions)"
  })
  void testApplyWithIdSelectionOptions_thenCallsEntityLifecycleStatuses() {
    // Arrange
    LegalEntityRelationshipIdSelectorFactory legalEntityRelationshipIdSelectorFactory =
        new LegalEntityRelationshipIdSelectorFactory();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
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

    // Act
    legalEntityRelationshipIdSelectorFactory.apply(options);

    // Assert
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
  }

  /**
   * Test new {@link LegalEntityRelationshipIdSelectorFactory} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * LegalEntityRelationshipIdSelectorFactory}
   */
  @Test
  @DisplayName("Test new LegalEntityRelationshipIdSelectorFactory (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegalEntityRelationshipIdSelectorFactory.<init>()"})
  void testNewLegalEntityRelationshipIdSelectorFactory() {
    // Arrange and Act
    LegalEntityRelationshipIdSelectorFactory actualLegalEntityRelationshipIdSelectorFactory =
        new LegalEntityRelationshipIdSelectorFactory();
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
    ImmutableIdSelectionOptions options =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    actualLegalEntityRelationshipIdSelectorFactory.apply(options);

    // Assert that nothing has changed
    EntityReference entityReferenceResult = options.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    SelectionFilters filtersResult2 = options.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, options.scope());
    assertTrue(options.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
  }

  /**
   * Test new {@link LegalEntityRelationshipIdSelectorFactory} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * LegalEntityRelationshipIdSelectorFactory}
   */
  @Test
  @DisplayName("Test new LegalEntityRelationshipIdSelectorFactory (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegalEntityRelationshipIdSelectorFactory.<init>()"})
  void testNewLegalEntityRelationshipIdSelectorFactory2() {
    // Arrange and Act
    LegalEntityRelationshipIdSelectorFactory actualLegalEntityRelationshipIdSelectorFactory =
        new LegalEntityRelationshipIdSelectorFactory();
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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);
    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions options =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    actualLegalEntityRelationshipIdSelectorFactory.apply(options);

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
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, options.scope());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
  }

  /**
   * Test new {@link LegalEntityRelationshipIdSelectorFactory} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * LegalEntityRelationshipIdSelectorFactory}
   */
  @Test
  @DisplayName("Test new LegalEntityRelationshipIdSelectorFactory (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegalEntityRelationshipIdSelectorFactory.<init>()"})
  void testNewLegalEntityRelationshipIdSelectorFactory3() {
    // Arrange and Act
    LegalEntityRelationshipIdSelectorFactory actualLegalEntityRelationshipIdSelectorFactory =
        new LegalEntityRelationshipIdSelectorFactory();
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
                    .kind(EntityKind.ALL)
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
    actualLegalEntityRelationshipIdSelectorFactory.apply(options);

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
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, options.scope());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.PENDING));
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
  }

  /**
   * Test new {@link LegalEntityRelationshipIdSelectorFactory} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * LegalEntityRelationshipIdSelectorFactory}
   */
  @Test
  @DisplayName("Test new LegalEntityRelationshipIdSelectorFactory (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegalEntityRelationshipIdSelectorFactory.<init>()"})
  void testNewLegalEntityRelationshipIdSelectorFactory4() {
    // Arrange and Act
    LegalEntityRelationshipIdSelectorFactory actualLegalEntityRelationshipIdSelectorFactory =
        new LegalEntityRelationshipIdSelectorFactory();
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
    actualLegalEntityRelationshipIdSelectorFactory.apply(options);

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
   * Test new {@link LegalEntityRelationshipIdSelectorFactory} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * LegalEntityRelationshipIdSelectorFactory}
   */
  @Test
  @DisplayName("Test new LegalEntityRelationshipIdSelectorFactory (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegalEntityRelationshipIdSelectorFactory.<init>()"})
  void testNewLegalEntityRelationshipIdSelectorFactory5() {
    // Arrange and Act
    LegalEntityRelationshipIdSelectorFactory actualLegalEntityRelationshipIdSelectorFactory =
        new LegalEntityRelationshipIdSelectorFactory();
    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
    ImmutableSelectionFilters filters = builderResult.build();
    Builder builderResult2 = ImmutableIdSelectionOptions.builder();
    Builder filtersResult =
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
            .filters(filters);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);
    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions options =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    actualLegalEntityRelationshipIdSelectorFactory.apply(options);

    // Assert that nothing has changed
    EntityReference entityReferenceResult = options.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    SelectionFilters filtersResult2 = options.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    Set<ApplicationKind> omitApplicationKindsResult = filtersResult2.omitApplicationKinds();
    assertEquals(1, omitApplicationKindsResult.size());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, options.scope());
    assertTrue(omitApplicationKindsResult.contains(ApplicationKind.IN_HOUSE));
    assertTrue(options.entityLifecycleStatuses().isEmpty());
  }
}
