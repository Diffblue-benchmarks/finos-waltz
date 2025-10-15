package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Json;
import org.finos.waltz.model.application.ImmutableApplicationIdSelectionOptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableIdSelectionOptionsDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllEntityLifecycleStatuses(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllEntityLifecycleStatuses(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllEntityLifecycleStatuses(Iterable); given 'ACTIVE'; when LinkedHashSet() add 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllEntityLifecycleStatuses(Iterable)"})
  void testBuilderAddAllEntityLifecycleStatuses_givenActive_whenLinkedHashSetAddActive() {
    // Arrange
    Builder builderResult = ImmutableIdSelectionOptions.builder();

    LinkedHashSet<EntityLifecycleStatus> elements = new LinkedHashSet<>();
    elements.add(EntityLifecycleStatus.ACTIVE);

    // Act
    Builder actualAddAllEntityLifecycleStatusesResult =
        builderResult.addAllEntityLifecycleStatuses(elements);

    // Assert
    assertSame(builderResult, actualAddAllEntityLifecycleStatusesResult);
  }

  /**
   * Test Builder {@link Builder#addAllEntityLifecycleStatuses(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllEntityLifecycleStatuses(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllEntityLifecycleStatuses(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllEntityLifecycleStatuses(Iterable)"})
  void testBuilderAddAllEntityLifecycleStatuses_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableIdSelectionOptions.builder();

    // Act
    Builder actualAddAllEntityLifecycleStatusesResult =
        builderResult.addAllEntityLifecycleStatuses(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllEntityLifecycleStatusesResult);
  }

  /**
   * Test Builder {@link Builder#addEntityLifecycleStatuses(EntityLifecycleStatus)} with {@code
   * element}.
   *
   * <p>Method under test: {@link Builder#addEntityLifecycleStatuses(EntityLifecycleStatus)}
   */
  @Test
  @DisplayName("Test Builder addEntityLifecycleStatuses(EntityLifecycleStatus) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addEntityLifecycleStatuses(EntityLifecycleStatus)"})
  void testBuilderAddEntityLifecycleStatusesWithElement() {
    // Arrange
    Builder builderResult = ImmutableIdSelectionOptions.builder();

    // Act
    Builder actualAddEntityLifecycleStatusesResult =
        builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

    // Assert
    assertSame(builderResult, actualAddEntityLifecycleStatusesResult);
  }

  /**
   * Test Builder {@link Builder#addEntityLifecycleStatuses(EntityLifecycleStatus[])} with {@code
   * elements}.
   *
   * <p>Method under test: {@link Builder#addEntityLifecycleStatuses(EntityLifecycleStatus[])}
   */
  @Test
  @DisplayName("Test Builder addEntityLifecycleStatuses(EntityLifecycleStatus[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addEntityLifecycleStatuses(EntityLifecycleStatus[])"})
  void testBuilderAddEntityLifecycleStatusesWithElements() {
    // Arrange
    Builder builderResult = ImmutableIdSelectionOptions.builder();

    // Act
    Builder actualAddEntityLifecycleStatusesResult =
        builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

    // Assert
    assertSame(builderResult, actualAddEntityLifecycleStatusesResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#filters(SelectionFilters)}
   *   <li>{@link Builder#joiningEntityKind(EntityKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableIdSelectionOptions Builder.build()",
    "Builder Builder.filters(SelectionFilters)",
    "Builder Builder.joiningEntityKind(EntityKind)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableIdSelectionOptions.builder();
    Builder actualAddEntityLifecycleStatusesResult =
        actualBuilderResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE)
            .addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualFiltersResult =
        actualAddEntityLifecycleStatusesResult
            .entityReference(entityReference)
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);
    ImmutableIdSelectionOptions actualImmutableIdSelectionOptions =
        actualFiltersResult
            .joiningEntityKind(joiningEntityKind)
            .joiningEntityKind(EntityKind.ALL)
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Assert
    SelectionFilters filtersResult = actualImmutableIdSelectionOptions.filters();
    assertTrue(filtersResult instanceof ImmutableSelectionFilters);
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult =
        actualImmutableIdSelectionOptions.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    assertEquals(HierarchyQueryScope.EXACT, actualImmutableIdSelectionOptions.scope());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertSame(entityReference, actualImmutableIdSelectionOptions.entityReference());
    assertSame(SelectionFilters.NO_FILTERS, filtersResult);
  }

  /**
   * Test Builder {@link Builder#entityLifecycleStatuses(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entityLifecycleStatuses(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder entityLifecycleStatuses(Iterable); given 'ACTIVE'; when LinkedHashSet() add 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityLifecycleStatuses(Iterable)"})
  void testBuilderEntityLifecycleStatuses_givenActive_whenLinkedHashSetAddActive() {
    // Arrange
    Builder builderResult = ImmutableIdSelectionOptions.builder();

    LinkedHashSet<EntityLifecycleStatus> elements = new LinkedHashSet<>();
    elements.add(EntityLifecycleStatus.ACTIVE);

    // Act
    Builder actualEntityLifecycleStatusesResult = builderResult.entityLifecycleStatuses(elements);

    // Assert
    assertSame(builderResult, actualEntityLifecycleStatusesResult);
  }

  /**
   * Test Builder {@link Builder#entityLifecycleStatuses(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entityLifecycleStatuses(Iterable)}
   */
  @Test
  @DisplayName("Test Builder entityLifecycleStatuses(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityLifecycleStatuses(Iterable)"})
  void testBuilderEntityLifecycleStatuses_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableIdSelectionOptions.builder();

    // Act
    Builder actualEntityLifecycleStatusesResult =
        builderResult.entityLifecycleStatuses(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualEntityLifecycleStatusesResult);
  }

  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link ImmutableEntityReference.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder entityReference(EntityReference); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableIdSelectionOptions.builder();

    // Act
    Builder actualEntityReferenceResult =
        builderResult.entityReference(new ImmutableEntityReference.Json());

    // Assert
    assertSame(builderResult, actualEntityReferenceResult);
  }

  /**
   * Test Builder {@link Builder#from(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link Builder#from(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test Builder from(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdSelectionOptions)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableIdSelectionOptions.builder();

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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions instance =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableIdSelectionOptions actualImmutableIdSelectionOptions = builderResult.build();
    assertEquals(instance, actualImmutableIdSelectionOptions);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link Builder#from(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test Builder from(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdSelectionOptions)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableApplicationIdSelectionOptions.Builder builderResult2 =
        ImmutableApplicationIdSelectionOptions.builder();

    ImmutableApplicationIdSelectionOptions.Builder filtersResult =
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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableApplicationIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult =
        builderResult
            .from(
                joiningEntityKindResult
                    .addAllApplicationKinds(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build()
            .entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    ImmutableIdSelectionOptions immutableIdSelectionOptions = builderResult.build();
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult2 =
        immutableIdSelectionOptions.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult2.size());
    assertEquals(HierarchyQueryScope.EXACT, immutableIdSelectionOptions.scope());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(entityLifecycleStatusesResult2.contains(EntityLifecycleStatus.ACTIVE));
  }

  /**
   * Test Builder {@link Builder#from(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link Builder#from(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test Builder from(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdSelectionOptions)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableApplicationIdSelectionOptions.Builder builderResult2 =
        ImmutableApplicationIdSelectionOptions.builder();

    ImmutableApplicationIdSelectionOptions.Builder filtersResult =
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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind = Optional.empty();

    ImmutableApplicationIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult =
        builderResult
            .from(
                joiningEntityKindResult
                    .addAllApplicationKinds(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build()
            .entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    ImmutableIdSelectionOptions immutableIdSelectionOptions = builderResult.build();
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult2 =
        immutableIdSelectionOptions.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult2.size());
    assertEquals(HierarchyQueryScope.EXACT, immutableIdSelectionOptions.scope());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(entityLifecycleStatusesResult2.contains(EntityLifecycleStatus.ACTIVE));
  }

  /**
   * Test Builder {@link Builder#joiningEntityKind(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#joiningEntityKind(Optional)}
   */
  @Test
  @DisplayName("Test Builder joiningEntityKind(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.joiningEntityKind(Optional)"})
  void testBuilderJoiningEntityKindWithOptional() {
    // Arrange
    Builder builderResult = ImmutableIdSelectionOptions.builder();
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    // Act
    Builder actualJoiningEntityKindResult = builderResult.joiningEntityKind(joiningEntityKind);

    // Assert
    assertSame(builderResult, actualJoiningEntityKindResult);
  }

  /**
   * Test Builder {@link Builder#scope(HierarchyQueryScope)}.
   *
   * <p>Method under test: {@link Builder#scope(HierarchyQueryScope)}
   */
  @Test
  @DisplayName("Test Builder scope(HierarchyQueryScope)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.scope(HierarchyQueryScope)"})
  void testBuilderScope() {
    // Arrange
    Builder builderResult = ImmutableIdSelectionOptions.builder();

    // Act
    Builder actualScopeResult = builderResult.scope(HierarchyQueryScope.EXACT);

    // Assert
    assertSame(builderResult, actualScopeResult);
  }

  /**
   * Test {@link ImmutableIdSelectionOptions#copyOf(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ImmutableIdSelectionOptions#copyOf(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test copyOf(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableIdSelectionOptions ImmutableIdSelectionOptions.copyOf(IdSelectionOptions)"
  })
  void testCopyOf() {
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
    ImmutableApplicationIdSelectionOptions instance =
        joiningEntityKindResult
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    ImmutableIdSelectionOptions actualCopyOfResult = ImmutableIdSelectionOptions.copyOf(instance);

    // Assert
    EntityReference entityReferenceResult = actualCopyOfResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    SelectionFilters filtersResult2 = actualCopyOfResult.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult =
        actualCopyOfResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, actualCopyOfResult.scope());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
  }

  /**
   * Test {@link ImmutableIdSelectionOptions#copyOf(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ImmutableIdSelectionOptions#copyOf(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test copyOf(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableIdSelectionOptions ImmutableIdSelectionOptions.copyOf(IdSelectionOptions)"
  })
  void testCopyOf2() {
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
    Optional<? extends EntityKind> joiningEntityKind = Optional.empty();

    ImmutableApplicationIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableApplicationIdSelectionOptions instance =
        joiningEntityKindResult
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    ImmutableIdSelectionOptions actualCopyOfResult = ImmutableIdSelectionOptions.copyOf(instance);

    // Assert
    EntityReference entityReferenceResult = actualCopyOfResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    SelectionFilters filtersResult2 = actualCopyOfResult.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult =
        actualCopyOfResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, actualCopyOfResult.scope());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
  }

  /**
   * Test {@link ImmutableIdSelectionOptions#copyOf(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return entityLifecycleStatuses Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableIdSelectionOptions#copyOf(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test copyOf(IdSelectionOptions); then return entityLifecycleStatuses Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableIdSelectionOptions ImmutableIdSelectionOptions.copyOf(IdSelectionOptions)"
  })
  void testCopyOf_thenReturnEntityLifecycleStatusesEmpty() {
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
    ImmutableIdSelectionOptions instance =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    ImmutableIdSelectionOptions actualCopyOfResult = ImmutableIdSelectionOptions.copyOf(instance);

    // Assert
    EntityReference entityReferenceResult = actualCopyOfResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    SelectionFilters filtersResult2 = actualCopyOfResult.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, actualCopyOfResult.scope());
    assertTrue(actualCopyOfResult.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
  }

  /**
   * Test {@link ImmutableIdSelectionOptions#entityLifecycleStatuses()}.
   *
   * <p>Method under test: {@link ImmutableIdSelectionOptions#entityLifecycleStatuses()}
   */
  @Test
  @DisplayName("Test entityLifecycleStatuses()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ImmutableIdSelectionOptions.entityLifecycleStatuses()"})
  void testEntityLifecycleStatuses() {
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
   * Test {@link ImmutableIdSelectionOptions#equals(Object)}, and {@link
   * ImmutableIdSelectionOptions#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableIdSelectionOptions#equals(Object)}
   *   <li>{@link ImmutableIdSelectionOptions#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableIdSelectionOptions.equals(Object)",
    "int ImmutableIdSelectionOptions.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);
    ImmutableIdSelectionOptions immutableIdSelectionOptions2 =
        joiningEntityKindResult2
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act and Assert
    assertEquals(immutableIdSelectionOptions, immutableIdSelectionOptions2);
    assertEquals(immutableIdSelectionOptions.hashCode(), immutableIdSelectionOptions2.hashCode());
  }

  /**
   * Test {@link ImmutableIdSelectionOptions#equals(Object)}, and {@link
   * ImmutableIdSelectionOptions#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableIdSelectionOptions#equals(Object)}
   *   <li>{@link ImmutableIdSelectionOptions#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableIdSelectionOptions.equals(Object)",
    "int ImmutableIdSelectionOptions.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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

    // Act and Assert
    assertEquals(immutableIdSelectionOptions, immutableIdSelectionOptions);
    int expectedHashCodeResult = immutableIdSelectionOptions.hashCode();
    assertEquals(expectedHashCodeResult, immutableIdSelectionOptions.hashCode());
  }

  /**
   * Test {@link ImmutableIdSelectionOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableIdSelectionOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableIdSelectionOptions.equals(Object)",
    "int ImmutableIdSelectionOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
    ImmutableIdSelectionOptions immutableIdSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act and Assert
    assertNotEquals(
        immutableIdSelectionOptions,
        joiningEntityKindResult2
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());
  }

  /**
   * Test {@link ImmutableIdSelectionOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableIdSelectionOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableIdSelectionOptions.equals(Object)",
    "int ImmutableIdSelectionOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
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

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act and Assert
    assertNotEquals(
        immutableIdSelectionOptions,
        joiningEntityKindResult2
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());
  }

  /**
   * Test {@link ImmutableIdSelectionOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableIdSelectionOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableIdSelectionOptions.equals(Object)",
    "int ImmutableIdSelectionOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder entityReferenceResult =
        builderResult.entityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder filtersResult = entityReferenceResult.filters(new ImmutableSelectionFilters.Json());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions immutableIdSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act and Assert
    assertNotEquals(
        immutableIdSelectionOptions,
        joiningEntityKindResult2
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());
  }

  /**
   * Test {@link ImmutableIdSelectionOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableIdSelectionOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableIdSelectionOptions.equals(Object)",
    "int ImmutableIdSelectionOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
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
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ACTOR);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions immutableIdSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act and Assert
    assertNotEquals(
        immutableIdSelectionOptions,
        joiningEntityKindResult2
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());
  }

  /**
   * Test {@link ImmutableIdSelectionOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableIdSelectionOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableIdSelectionOptions.equals(Object)",
    "int ImmutableIdSelectionOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
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
            .scope(HierarchyQueryScope.PARENTS)
            .build();

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
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
            .filters(SelectionFilters.NO_FILTERS);
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act and Assert
    assertNotEquals(
        immutableIdSelectionOptions,
        joiningEntityKindResult2
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());
  }

  /**
   * Test {@link ImmutableIdSelectionOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableIdSelectionOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableIdSelectionOptions.equals(Object)",
    "int ImmutableIdSelectionOptions.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
    assertNotEquals(
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableIdSelectionOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableIdSelectionOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableIdSelectionOptions.equals(Object)",
    "int ImmutableIdSelectionOptions.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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
    assertNotEquals(
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build(),
        "Different type to ImmutableIdSelectionOptions");
  }

  /**
   * Test {@link ImmutableIdSelectionOptions#filters()}.
   *
   * <p>Method under test: {@link ImmutableIdSelectionOptions#filters()}
   */
  @Test
  @DisplayName("Test filters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SelectionFilters ImmutableIdSelectionOptions.filters()"})
  void testFilters() {
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

    // Act
    SelectionFilters actualFiltersResult =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build()
            .filters();

    // Assert
    assertTrue(actualFiltersResult instanceof ImmutableSelectionFilters);
    assertTrue(actualFiltersResult.omitApplicationKinds().isEmpty());
    assertSame(SelectionFilters.NO_FILTERS, actualFiltersResult);
  }

  /**
   * Test {@link ImmutableIdSelectionOptions#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code EXACT}.
   *   <li>Then filters return {@link ImmutableSelectionFilters}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableIdSelectionOptions#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'EXACT'; then filters return ImmutableSelectionFilters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableIdSelectionOptions ImmutableIdSelectionOptions.fromJson(Json)"})
  void testFromJson_givenExact_thenFiltersReturnImmutableSelectionFilters() {
    // Arrange
    Json json = new Json();
    json.setScope(HierarchyQueryScope.EXACT);
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    ImmutableIdSelectionOptions actualFromJsonResult = ImmutableIdSelectionOptions.fromJson(json);

    // Assert
    SelectionFilters filtersResult = actualFromJsonResult.filters();
    assertTrue(filtersResult instanceof ImmutableSelectionFilters);
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult =
        actualFromJsonResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    assertEquals(HierarchyQueryScope.EXACT, actualFromJsonResult.scope());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(filtersResult.omitApplicationKinds().isEmpty());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Test {@link ImmutableIdSelectionOptions#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link SelectionFilters#NO_FILTERS}.
   *   <li>Then return filters is {@link Json} (default constructor) {@link Json#filters}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableIdSelectionOptions#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given NO_FILTERS; then return filters is Json (default constructor) filters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableIdSelectionOptions ImmutableIdSelectionOptions.fromJson(Json)"})
  void testFromJson_givenNo_filters_thenReturnFiltersIsJsonFilters() {
    // Arrange
    Json json = new Json();
    json.setFilters(SelectionFilters.NO_FILTERS);
    json.setScope(HierarchyQueryScope.EXACT);
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    ImmutableIdSelectionOptions actualFromJsonResult = ImmutableIdSelectionOptions.fromJson(json);

    // Assert
    SelectionFilters filtersResult = actualFromJsonResult.filters();
    assertTrue(filtersResult instanceof ImmutableSelectionFilters);
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult =
        actualFromJsonResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    assertEquals(HierarchyQueryScope.EXACT, actualFromJsonResult.scope());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(filtersResult.omitApplicationKinds().isEmpty());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
    assertSame(json.filters, filtersResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableIdSelectionOptions#entityReference()}
   *   <li>{@link ImmutableIdSelectionOptions#scope()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityReference ImmutableIdSelectionOptions.entityReference()",
    "HierarchyQueryScope ImmutableIdSelectionOptions.scope()"
  })
  void testGettersAndSetters() {
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
    EntityReference actualEntityReferenceResult = immutableIdSelectionOptions.entityReference();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals(HierarchyQueryScope.EXACT, immutableIdSelectionOptions.scope());
  }

  /**
   * Test {@link ImmutableIdSelectionOptions#joiningEntityKind()}.
   *
   * <p>Method under test: {@link ImmutableIdSelectionOptions#joiningEntityKind()}
   */
  @Test
  @DisplayName("Test joiningEntityKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableIdSelectionOptions.joiningEntityKind()"})
  void testJoiningEntityKind() {
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
    assertEquals(
        joiningEntityKind,
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build()
            .joiningEntityKind());
  }

  /**
   * Test Json {@link Json#entityLifecycleStatuses()}.
   *
   * <p>Method under test: {@link Json#entityLifecycleStatuses()}
   */
  @Test
  @DisplayName("Test Json entityLifecycleStatuses()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.entityLifecycleStatuses()"})
  void testJsonEntityLifecycleStatuses() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entityLifecycleStatuses());
  }

  /**
   * Test Json {@link Json#entityReference()}.
   *
   * <p>Method under test: {@link Json#entityReference()}
   */
  @Test
  @DisplayName("Test Json entityReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.entityReference()"})
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entityReference());
  }

  /**
   * Test Json {@link Json#filters()}.
   *
   * <p>Method under test: {@link Json#filters()}
   */
  @Test
  @DisplayName("Test Json filters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SelectionFilters Json.filters()"})
  void testJsonFilters() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().filters());
  }

  /**
   * Test Json {@link Json#joiningEntityKind()}.
   *
   * <p>Method under test: {@link Json#joiningEntityKind()}
   */
  @Test
  @DisplayName("Test Json joiningEntityKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.joiningEntityKind()"})
  void testJsonJoiningEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().joiningEntityKind());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.entityReference);
    assertNull(actualJson.scope);
    assertNull(actualJson.filters);
    assertFalse(actualJson.joiningEntityKind.isPresent());
    assertFalse(actualJson.entityLifecycleStatusesIsSet);
    assertTrue(actualJson.entityLifecycleStatuses.isEmpty());
  }

  /**
   * Test Json {@link Json#scope()}.
   *
   * <p>Method under test: {@link Json#scope()}
   */
  @Test
  @DisplayName("Test Json scope()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HierarchyQueryScope Json.scope()"})
  void testJsonScope() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().scope());
  }

  /**
   * Test Json {@link Json#setEntityLifecycleStatuses(Set)}.
   *
   * <ul>
   *   <li>Then {@link Json} (default constructor) {@link Json#entityLifecycleStatuses} Empty.
   * </ul>
   *
   * <p>Method under test: {@link Json#setEntityLifecycleStatuses(Set)}
   */
  @Test
  @DisplayName(
      "Test Json setEntityLifecycleStatuses(Set); then Json (default constructor) entityLifecycleStatuses Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setEntityLifecycleStatuses(Set)"})
  void testJsonSetEntityLifecycleStatuses_thenJsonEntityLifecycleStatusesEmpty() {
    // Arrange
    Json json = new Json();

    // Act
    json.setEntityLifecycleStatuses(new HashSet<>());

    // Assert
    assertTrue(json.entityLifecycleStatuses.isEmpty());
    assertTrue(json.entityLifecycleStatusesIsSet);
  }

  /**
   * Test Json {@link Json#setEntityLifecycleStatuses(Set)}.
   *
   * <ul>
   *   <li>Then {@link Json} (default constructor) {@link Json#entityLifecycleStatuses} is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link Json#setEntityLifecycleStatuses(Set)}
   */
  @Test
  @DisplayName(
      "Test Json setEntityLifecycleStatuses(Set); then Json (default constructor) entityLifecycleStatuses is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setEntityLifecycleStatuses(Set)"})
  void testJsonSetEntityLifecycleStatuses_thenJsonEntityLifecycleStatusesIsNull() {
    // Arrange
    Json json = new Json();

    // Act
    json.setEntityLifecycleStatuses(null);

    // Assert
    assertNull(json.entityLifecycleStatuses);
    assertFalse(json.entityLifecycleStatusesIsSet);
  }

  /**
   * Test Json {@link Json#setEntityLifecycleStatuses(Set)}.
   *
   * <ul>
   *   <li>Then {@link Json} (default constructor) {@link Json#entityLifecycleStatuses} size is one.
   * </ul>
   *
   * <p>Method under test: {@link Json#setEntityLifecycleStatuses(Set)}
   */
  @Test
  @DisplayName(
      "Test Json setEntityLifecycleStatuses(Set); then Json (default constructor) entityLifecycleStatuses size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setEntityLifecycleStatuses(Set)"})
  void testJsonSetEntityLifecycleStatuses_thenJsonEntityLifecycleStatusesSizeIsOne() {
    // Arrange
    Json json = new Json();

    HashSet<EntityLifecycleStatus> entityLifecycleStatuses = new HashSet<>();
    entityLifecycleStatuses.add(EntityLifecycleStatus.ACTIVE);

    // Act
    json.setEntityLifecycleStatuses(entityLifecycleStatuses);

    // Assert
    Set<EntityLifecycleStatus> entityLifecycleStatusSet = json.entityLifecycleStatuses;
    assertEquals(1, entityLifecycleStatusSet.size());
    assertTrue(entityLifecycleStatusSet.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(json.entityLifecycleStatusesIsSet);
  }

  /**
   * Test Json {@link Json#setEntityLifecycleStatuses(Set)}.
   *
   * <ul>
   *   <li>Then {@link Json} (default constructor) {@link Json#entityLifecycleStatuses} size is two.
   * </ul>
   *
   * <p>Method under test: {@link Json#setEntityLifecycleStatuses(Set)}
   */
  @Test
  @DisplayName(
      "Test Json setEntityLifecycleStatuses(Set); then Json (default constructor) entityLifecycleStatuses size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setEntityLifecycleStatuses(Set)"})
  void testJsonSetEntityLifecycleStatuses_thenJsonEntityLifecycleStatusesSizeIsTwo() {
    // Arrange
    Json json = new Json();

    HashSet<EntityLifecycleStatus> entityLifecycleStatuses = new HashSet<>();
    entityLifecycleStatuses.add(EntityLifecycleStatus.PENDING);
    entityLifecycleStatuses.add(EntityLifecycleStatus.ACTIVE);

    // Act
    json.setEntityLifecycleStatuses(entityLifecycleStatuses);

    // Assert
    Set<EntityLifecycleStatus> entityLifecycleStatusSet = json.entityLifecycleStatuses;
    assertEquals(2, entityLifecycleStatusSet.size());
    assertTrue(entityLifecycleStatusSet.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(entityLifecycleStatusSet.contains(EntityLifecycleStatus.PENDING));
    assertTrue(json.entityLifecycleStatusesIsSet);
  }

  /**
   * Test {@link ImmutableIdSelectionOptions#toString()}.
   *
   * <p>Method under test: {@link ImmutableIdSelectionOptions#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ImmutableIdSelectionOptions.toString()"})
  void testToString() {
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
    assertEquals(
        "IdSelectionOptions{entityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE},"
            + " scope=EXACT, joiningEntityKind=ALL, entityLifecycleStatuses=[], filters=SelectionFilters{omitApplic"
            + "ationKinds=[]}}",
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableIdSelectionOptions#toString()}.
   *
   * <p>Method under test: {@link ImmutableIdSelectionOptions#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ImmutableIdSelectionOptions.toString()"})
  void testToString2() {
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
    Optional<? extends EntityKind> joiningEntityKind = Optional.empty();

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertEquals(
        "IdSelectionOptions{entityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE},"
            + " scope=EXACT, entityLifecycleStatuses=[], filters=SelectionFilters{omitApplicationKinds=[]}}",
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableIdSelectionOptions#withEntityLifecycleStatuses(EntityLifecycleStatus[])}
   * with {@code EntityLifecycleStatus[]}.
   *
   * <p>Method under test: {@link
   * ImmutableIdSelectionOptions#withEntityLifecycleStatuses(EntityLifecycleStatus[])}
   */
  @Test
  @DisplayName(
      "Test withEntityLifecycleStatuses(EntityLifecycleStatus[]) with 'EntityLifecycleStatus[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableIdSelectionOptions ImmutableIdSelectionOptions.withEntityLifecycleStatuses(EntityLifecycleStatus[])"
  })
  void testWithEntityLifecycleStatusesWithEntityLifecycleStatus() {
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

    // Act
    ImmutableIdSelectionOptions actualWithEntityLifecycleStatusesResult =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build()
            .withEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

    // Assert
    EntityReference entityReferenceResult =
        actualWithEntityLifecycleStatusesResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    SelectionFilters filtersResult2 = actualWithEntityLifecycleStatusesResult.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult =
        actualWithEntityLifecycleStatusesResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, actualWithEntityLifecycleStatusesResult.scope());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
  }

  /**
   * Test {@link ImmutableIdSelectionOptions#withEntityLifecycleStatuses(Iterable)} with {@code
   * Iterable}.
   *
   * <p>Method under test: {@link ImmutableIdSelectionOptions#withEntityLifecycleStatuses(Iterable)}
   */
  @Test
  @DisplayName("Test withEntityLifecycleStatuses(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableIdSelectionOptions ImmutableIdSelectionOptions.withEntityLifecycleStatuses(Iterable)"
  })
  void testWithEntityLifecycleStatusesWithIterable() {
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

    LinkedHashSet<EntityLifecycleStatus> elements = new LinkedHashSet<>();
    elements.add(EntityLifecycleStatus.ACTIVE);

    // Act
    ImmutableIdSelectionOptions actualWithEntityLifecycleStatusesResult =
        immutableIdSelectionOptions.withEntityLifecycleStatuses(elements);

    // Assert
    EntityReference entityReferenceResult =
        actualWithEntityLifecycleStatusesResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    SelectionFilters filtersResult2 = actualWithEntityLifecycleStatusesResult.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, actualWithEntityLifecycleStatusesResult.scope());
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
    assertEquals(elements, actualWithEntityLifecycleStatusesResult.entityLifecycleStatuses());
  }

  /**
   * Test {@link ImmutableIdSelectionOptions#withEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableIdSelectionOptions#withEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableIdSelectionOptions ImmutableIdSelectionOptions.withEntityReference(EntityReference)"
  })
  void testWithEntityReference() {
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
    ImmutableIdSelectionOptions actualWithEntityReferenceResult =
        immutableIdSelectionOptions.withEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableIdSelectionOptions, actualWithEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableIdSelectionOptions#withFilters(SelectionFilters)}.
   *
   * <p>Method under test: {@link ImmutableIdSelectionOptions#withFilters(SelectionFilters)}
   */
  @Test
  @DisplayName("Test withFilters(SelectionFilters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableIdSelectionOptions ImmutableIdSelectionOptions.withFilters(SelectionFilters)"
  })
  void testWithFilters() {
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
    ImmutableIdSelectionOptions actualWithFiltersResult =
        immutableIdSelectionOptions.withFilters(SelectionFilters.NO_FILTERS);

    // Assert
    assertSame(immutableIdSelectionOptions, actualWithFiltersResult);
  }

  /**
   * Test {@link ImmutableIdSelectionOptions#withFilters(SelectionFilters)}.
   *
   * <p>Method under test: {@link ImmutableIdSelectionOptions#withFilters(SelectionFilters)}
   */
  @Test
  @DisplayName("Test withFilters(SelectionFilters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableIdSelectionOptions ImmutableIdSelectionOptions.withFilters(SelectionFilters)"
  })
  void testWithFilters2() {
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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions immutableIdSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    ImmutableIdSelectionOptions actualWithFiltersResult =
        immutableIdSelectionOptions.withFilters(SelectionFilters.NO_FILTERS);

    // Assert
    assertEquals(immutableIdSelectionOptions, actualWithFiltersResult);
  }

  /**
   * Test {@link ImmutableIdSelectionOptions#withJoiningEntityKind(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableIdSelectionOptions#withJoiningEntityKind(Optional)}
   */
  @Test
  @DisplayName("Test withJoiningEntityKind(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableIdSelectionOptions ImmutableIdSelectionOptions.withJoiningEntityKind(Optional)"
  })
  void testWithJoiningEntityKindWithOptional() {
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
    Optional<? extends EntityKind> optional = Optional.of(EntityKind.ALL);

    // Act
    ImmutableIdSelectionOptions actualWithJoiningEntityKindResult =
        immutableIdSelectionOptions.withJoiningEntityKind(optional);

    // Assert
    assertSame(immutableIdSelectionOptions, actualWithJoiningEntityKindResult);
  }

  /**
   * Test {@link ImmutableIdSelectionOptions#withJoiningEntityKind(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableIdSelectionOptions#withJoiningEntityKind(Optional)}
   */
  @Test
  @DisplayName("Test withJoiningEntityKind(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableIdSelectionOptions ImmutableIdSelectionOptions.withJoiningEntityKind(Optional)"
  })
  void testWithJoiningEntityKindWithOptional2() {
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
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ACTOR);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions immutableIdSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    Optional<? extends EntityKind> optional = Optional.of(EntityKind.ALL);

    // Act
    ImmutableIdSelectionOptions actualWithJoiningEntityKindResult =
        immutableIdSelectionOptions.withJoiningEntityKind(optional);

    // Assert
    EntityReference entityReferenceResult = actualWithJoiningEntityKindResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    SelectionFilters filtersResult2 = actualWithJoiningEntityKindResult.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, actualWithJoiningEntityKindResult.scope());
    assertTrue(actualWithJoiningEntityKindResult.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
  }

  /**
   * Test {@link ImmutableIdSelectionOptions#withJoiningEntityKind(EntityKind)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableIdSelectionOptions#withJoiningEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withJoiningEntityKind(EntityKind) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableIdSelectionOptions ImmutableIdSelectionOptions.withJoiningEntityKind(EntityKind)"
  })
  void testWithJoiningEntityKindWithValue() {
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
    ImmutableIdSelectionOptions actualWithJoiningEntityKindResult =
        immutableIdSelectionOptions.withJoiningEntityKind(EntityKind.ALL);

    // Assert
    assertSame(immutableIdSelectionOptions, actualWithJoiningEntityKindResult);
  }

  /**
   * Test {@link ImmutableIdSelectionOptions#withJoiningEntityKind(EntityKind)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableIdSelectionOptions#withJoiningEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withJoiningEntityKind(EntityKind) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableIdSelectionOptions ImmutableIdSelectionOptions.withJoiningEntityKind(EntityKind)"
  })
  void testWithJoiningEntityKindWithValue2() {
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
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ACTOR);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    ImmutableIdSelectionOptions actualWithJoiningEntityKindResult =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build()
            .withJoiningEntityKind(EntityKind.ALL);

    // Assert
    EntityReference entityReferenceResult = actualWithJoiningEntityKindResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    SelectionFilters filtersResult2 = actualWithJoiningEntityKindResult.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, actualWithJoiningEntityKindResult.scope());
    assertTrue(actualWithJoiningEntityKindResult.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
  }

  /**
   * Test {@link ImmutableIdSelectionOptions#withScope(HierarchyQueryScope)}.
   *
   * <p>Method under test: {@link ImmutableIdSelectionOptions#withScope(HierarchyQueryScope)}
   */
  @Test
  @DisplayName("Test withScope(HierarchyQueryScope)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableIdSelectionOptions ImmutableIdSelectionOptions.withScope(HierarchyQueryScope)"
  })
  void testWithScope() {
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
    ImmutableIdSelectionOptions actualWithScopeResult =
        immutableIdSelectionOptions.withScope(HierarchyQueryScope.EXACT);

    // Assert
    assertSame(immutableIdSelectionOptions, actualWithScopeResult);
  }

  /**
   * Test {@link ImmutableIdSelectionOptions#withScope(HierarchyQueryScope)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableIdSelectionOptions#withScope(HierarchyQueryScope)}
   */
  @Test
  @DisplayName(
      "Test withScope(HierarchyQueryScope); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableIdSelectionOptions ImmutableIdSelectionOptions.withScope(HierarchyQueryScope)"
  })
  void testWithScope_thenEntityReferenceReturnImmutableEntityReference() {
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

    // Act
    ImmutableIdSelectionOptions actualWithScopeResult =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.PARENTS)
            .build()
            .withScope(HierarchyQueryScope.EXACT);

    // Assert
    EntityReference entityReferenceResult = actualWithScopeResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    SelectionFilters filtersResult2 = actualWithScopeResult.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, actualWithScopeResult.scope());
    assertTrue(actualWithScopeResult.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
  }
}
