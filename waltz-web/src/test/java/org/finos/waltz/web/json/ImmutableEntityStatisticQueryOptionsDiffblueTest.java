package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
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
import org.finos.waltz.web.json.ImmutableEntityStatisticQueryOptions.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEntityStatisticQueryOptionsDiffblueTest {
  /**
   * Test Builder {@link ImmutableEntityStatisticQueryOptions.Builder#addAllStatisticIds(Iterable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableEntityStatisticQueryOptions.Builder#addAllStatisticIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllStatisticIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticQueryOptions.Builder ImmutableEntityStatisticQueryOptions.Builder.addAllStatisticIds(Iterable)"
  })
  void testBuilderAddAllStatisticIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    ImmutableEntityStatisticQueryOptions.Builder builderResult =
        ImmutableEntityStatisticQueryOptions.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableEntityStatisticQueryOptions.Builder actualAddAllStatisticIdsResult =
        builderResult.addAllStatisticIds(elements);

    // Assert
    assertSame(builderResult, actualAddAllStatisticIdsResult);
  }

  /**
   * Test Builder {@link ImmutableEntityStatisticQueryOptions.Builder#addAllStatisticIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableEntityStatisticQueryOptions.Builder#addAllStatisticIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllStatisticIds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticQueryOptions.Builder ImmutableEntityStatisticQueryOptions.Builder.addAllStatisticIds(Iterable)"
  })
  void testBuilderAddAllStatisticIds_whenArrayList() {
    // Arrange
    ImmutableEntityStatisticQueryOptions.Builder builderResult =
        ImmutableEntityStatisticQueryOptions.builder();

    // Act
    ImmutableEntityStatisticQueryOptions.Builder actualAddAllStatisticIdsResult =
        builderResult.addAllStatisticIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllStatisticIdsResult);
  }

  /**
   * Test Builder {@link ImmutableEntityStatisticQueryOptions.Builder#addStatisticIds(long)} with
   * {@code element}.
   *
   * <p>Method under test: {@link
   * ImmutableEntityStatisticQueryOptions.Builder#addStatisticIds(long)}
   */
  @Test
  @DisplayName("Test Builder addStatisticIds(long) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticQueryOptions.Builder ImmutableEntityStatisticQueryOptions.Builder.addStatisticIds(long)"
  })
  void testBuilderAddStatisticIdsWithElement() {
    // Arrange
    ImmutableEntityStatisticQueryOptions.Builder builderResult =
        ImmutableEntityStatisticQueryOptions.builder();

    // Act
    ImmutableEntityStatisticQueryOptions.Builder actualAddStatisticIdsResult =
        builderResult.addStatisticIds(1L);

    // Assert
    assertSame(builderResult, actualAddStatisticIdsResult);
  }

  /**
   * Test Builder {@link ImmutableEntityStatisticQueryOptions.Builder#addStatisticIds(long[])} with
   * {@code elements}.
   *
   * <p>Method under test: {@link
   * ImmutableEntityStatisticQueryOptions.Builder#addStatisticIds(long[])}
   */
  @Test
  @DisplayName("Test Builder addStatisticIds(long[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticQueryOptions.Builder ImmutableEntityStatisticQueryOptions.Builder.addStatisticIds(long[])"
  })
  void testBuilderAddStatisticIdsWithElements() {
    // Arrange
    ImmutableEntityStatisticQueryOptions.Builder builderResult =
        ImmutableEntityStatisticQueryOptions.builder();

    // Act
    ImmutableEntityStatisticQueryOptions.Builder actualAddStatisticIdsResult =
        builderResult.addStatisticIds(1L, -2L, 1L, -2L);

    // Assert
    assertSame(builderResult, actualAddStatisticIdsResult);
  }

  /**
   * Test Builder {@link ImmutableEntityStatisticQueryOptions.Builder#build()}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticQueryOptions.Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticQueryOptions ImmutableEntityStatisticQueryOptions.Builder.build()"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableEntityStatisticQueryOptions.Builder actualBuilderResult =
        ImmutableEntityStatisticQueryOptions.builder();
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
    ImmutableIdSelectionOptions selector =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    ImmutableEntityStatisticQueryOptions actualImmutableEntityStatisticQueryOptions =
        actualBuilderResult.selector(selector).build();

    // Assert
    assertTrue(actualImmutableEntityStatisticQueryOptions.statisticIds().isEmpty());
    assertSame(selector, actualImmutableEntityStatisticQueryOptions.selector());
  }

  /**
   * Test Builder {@link
   * ImmutableEntityStatisticQueryOptions.Builder#from(EntityStatisticQueryOptions)}.
   *
   * <p>Method under test: {@link
   * ImmutableEntityStatisticQueryOptions.Builder#from(EntityStatisticQueryOptions)}
   */
  @Test
  @DisplayName("Test Builder from(EntityStatisticQueryOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticQueryOptions.Builder ImmutableEntityStatisticQueryOptions.Builder.from(EntityStatisticQueryOptions)"
  })
  void testBuilderFrom() {
    // Arrange
    ImmutableEntityStatisticQueryOptions.Builder builderResult =
        ImmutableEntityStatisticQueryOptions.builder();

    ImmutableEntityStatisticQueryOptions.Builder builderResult2 =
        ImmutableEntityStatisticQueryOptions.builder();
    builderResult2.addStatisticIds(-2L);

    Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult3
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
    ImmutableEntityStatisticQueryOptions instance =
        builderResult2
            .selector(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    // Act
    ImmutableEntityStatisticQueryOptions.Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEntityStatisticQueryOptions actualImmutableEntityStatisticQueryOptions =
        builderResult.build();
    assertEquals(instance, actualImmutableEntityStatisticQueryOptions);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link
   * ImmutableEntityStatisticQueryOptions.Builder#from(EntityStatisticQueryOptions)}.
   *
   * <ul>
   *   <li>Then build selector entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableEntityStatisticQueryOptions.Builder#from(EntityStatisticQueryOptions)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityStatisticQueryOptions); then build selector entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticQueryOptions.Builder ImmutableEntityStatisticQueryOptions.Builder.from(EntityStatisticQueryOptions)"
  })
  void testBuilderFrom_thenBuildSelectorEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    ImmutableEntityStatisticQueryOptions.Builder builderResult =
        ImmutableEntityStatisticQueryOptions.builder();

    ImmutableEntityStatisticQueryOptions.Builder builderResult2 =
        ImmutableEntityStatisticQueryOptions.builder();

    Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult3
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
    ImmutableEntityStatisticQueryOptions immutableEntityStatisticQueryOptions =
        builderResult
            .from(
                builderResult2
                    .selector(
                        joiningEntityKindResult
                            .addAllEntityLifecycleStatuses(new ArrayList<>())
                            .scope(HierarchyQueryScope.EXACT)
                            .build())
                    .build())
            .build();
    IdSelectionOptions selectorResult = immutableEntityStatisticQueryOptions.selector();
    EntityReference entityReferenceResult = selectorResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(selectorResult instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult2 = selectorResult.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertTrue(immutableEntityStatisticQueryOptions.statisticIds().isEmpty());
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
  }

  /**
   * Test Builder {@link ImmutableEntityStatisticQueryOptions.Builder#selector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@link IdSelectionOptions}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableEntityStatisticQueryOptions.Builder#selector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test Builder selector(IdSelectionOptions); when IdSelectionOptions; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticQueryOptions.Builder ImmutableEntityStatisticQueryOptions.Builder.selector(IdSelectionOptions)"
  })
  void testBuilderSelector_whenIdSelectionOptions_thenReturnBuilder() {
    // Arrange
    ImmutableEntityStatisticQueryOptions.Builder builderResult =
        ImmutableEntityStatisticQueryOptions.builder();
    IdSelectionOptions selector = mock(IdSelectionOptions.class);

    // Act
    ImmutableEntityStatisticQueryOptions.Builder actualSelectorResult =
        builderResult.selector(selector);

    // Assert
    assertSame(builderResult, actualSelectorResult);
    assertSame(selector, builderResult.build().selector());
  }

  /**
   * Test Builder {@link ImmutableEntityStatisticQueryOptions.Builder#statisticIds(Iterable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableEntityStatisticQueryOptions.Builder#statisticIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder statisticIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticQueryOptions.Builder ImmutableEntityStatisticQueryOptions.Builder.statisticIds(Iterable)"
  })
  void testBuilderStatisticIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    ImmutableEntityStatisticQueryOptions.Builder builderResult =
        ImmutableEntityStatisticQueryOptions.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableEntityStatisticQueryOptions.Builder actualStatisticIdsResult =
        builderResult.statisticIds(elements);

    // Assert
    assertSame(builderResult, actualStatisticIdsResult);
  }

  /**
   * Test Builder {@link ImmutableEntityStatisticQueryOptions.Builder#statisticIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableEntityStatisticQueryOptions.Builder#statisticIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder statisticIds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticQueryOptions.Builder ImmutableEntityStatisticQueryOptions.Builder.statisticIds(Iterable)"
  })
  void testBuilderStatisticIds_whenArrayList() {
    // Arrange
    ImmutableEntityStatisticQueryOptions.Builder builderResult =
        ImmutableEntityStatisticQueryOptions.builder();

    // Act
    ImmutableEntityStatisticQueryOptions.Builder actualStatisticIdsResult =
        builderResult.statisticIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualStatisticIdsResult);
  }

  /**
   * Test {@link ImmutableEntityStatisticQueryOptions#copyOf(EntityStatisticQueryOptions)}.
   *
   * <ul>
   *   <li>Then selector entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableEntityStatisticQueryOptions#copyOf(EntityStatisticQueryOptions)}
   */
  @Test
  @DisplayName(
      "Test copyOf(EntityStatisticQueryOptions); then selector entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticQueryOptions ImmutableEntityStatisticQueryOptions.copyOf(EntityStatisticQueryOptions)"
  })
  void testCopyOf_thenSelectorEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    ImmutableEntityStatisticQueryOptions.Builder builderResult =
        ImmutableEntityStatisticQueryOptions.builder();

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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableEntityStatisticQueryOptions instance =
        builderResult
            .selector(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    // Act
    ImmutableEntityStatisticQueryOptions actualCopyOfResult =
        ImmutableEntityStatisticQueryOptions.copyOf(instance);

    // Assert
    IdSelectionOptions selectorResult = actualCopyOfResult.selector();
    EntityReference entityReferenceResult = selectorResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(selectorResult instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult2 = selectorResult.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, selectorResult.scope());
    assertTrue(actualCopyOfResult.statisticIds().isEmpty());
    assertTrue(selectorResult.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
  }

  /**
   * Test {@link ImmutableEntityStatisticQueryOptions#equals(Object)}, and {@link
   * ImmutableEntityStatisticQueryOptions#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityStatisticQueryOptions#equals(Object)}
   *   <li>{@link ImmutableEntityStatisticQueryOptions#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticQueryOptions.equals(Object)",
    "int ImmutableEntityStatisticQueryOptions.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableEntityStatisticQueryOptions.Builder builderResult =
        ImmutableEntityStatisticQueryOptions.builder();

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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableEntityStatisticQueryOptions immutableEntityStatisticQueryOptions =
        builderResult
            .selector(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    ImmutableEntityStatisticQueryOptions.Builder builderResult3 =
        ImmutableEntityStatisticQueryOptions.builder();

    Builder builderResult4 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
        builderResult4
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
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);
    ImmutableEntityStatisticQueryOptions immutableEntityStatisticQueryOptions2 =
        builderResult3
            .selector(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableEntityStatisticQueryOptions, immutableEntityStatisticQueryOptions2);
    assertEquals(
        immutableEntityStatisticQueryOptions.hashCode(),
        immutableEntityStatisticQueryOptions2.hashCode());
  }

  /**
   * Test {@link ImmutableEntityStatisticQueryOptions#equals(Object)}, and {@link
   * ImmutableEntityStatisticQueryOptions#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityStatisticQueryOptions#equals(Object)}
   *   <li>{@link ImmutableEntityStatisticQueryOptions#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticQueryOptions.equals(Object)",
    "int ImmutableEntityStatisticQueryOptions.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableEntityStatisticQueryOptions.Builder builderResult =
        ImmutableEntityStatisticQueryOptions.builder();

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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableEntityStatisticQueryOptions immutableEntityStatisticQueryOptions =
        builderResult
            .selector(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableEntityStatisticQueryOptions, immutableEntityStatisticQueryOptions);
    int expectedHashCodeResult = immutableEntityStatisticQueryOptions.hashCode();
    assertEquals(expectedHashCodeResult, immutableEntityStatisticQueryOptions.hashCode());
  }

  /**
   * Test {@link ImmutableEntityStatisticQueryOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticQueryOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticQueryOptions.equals(Object)",
    "int ImmutableEntityStatisticQueryOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableEntityStatisticQueryOptions.Builder builderResult =
        ImmutableEntityStatisticQueryOptions.builder();
    builderResult.addStatisticIds(1L);

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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableEntityStatisticQueryOptions immutableEntityStatisticQueryOptions =
        builderResult
            .selector(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    ImmutableEntityStatisticQueryOptions.Builder builderResult3 =
        ImmutableEntityStatisticQueryOptions.builder();

    Builder builderResult4 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
        builderResult4
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
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act and Assert
    assertNotEquals(
        immutableEntityStatisticQueryOptions,
        builderResult3
            .selector(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableEntityStatisticQueryOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticQueryOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticQueryOptions.equals(Object)",
    "int ImmutableEntityStatisticQueryOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableEntityStatisticQueryOptions immutableEntityStatisticQueryOptions =
        ImmutableEntityStatisticQueryOptions.builder()
            .selector(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    ImmutableEntityStatisticQueryOptions.Builder builderResult2 =
        ImmutableEntityStatisticQueryOptions.builder();

    Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
        builderResult3
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
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act and Assert
    assertNotEquals(
        immutableEntityStatisticQueryOptions,
        builderResult2
            .selector(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableEntityStatisticQueryOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticQueryOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticQueryOptions.equals(Object)",
    "int ImmutableEntityStatisticQueryOptions.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableEntityStatisticQueryOptions.Builder builderResult =
        ImmutableEntityStatisticQueryOptions.builder();

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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertNotEquals(
        builderResult
            .selector(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableEntityStatisticQueryOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticQueryOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityStatisticQueryOptions.equals(Object)",
    "int ImmutableEntityStatisticQueryOptions.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableEntityStatisticQueryOptions.Builder builderResult =
        ImmutableEntityStatisticQueryOptions.builder();

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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertNotEquals(
        builderResult
            .selector(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build(),
        "Different type to ImmutableEntityStatisticQueryOptions");
  }

  /**
   * Test {@link ImmutableEntityStatisticQueryOptions#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add one.
   *   <li>Then return statisticIds is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticQueryOptions#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList() add one; then return statisticIds is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticQueryOptions ImmutableEntityStatisticQueryOptions.fromJson(Json)"
  })
  void testFromJson_givenArrayListAddOne_thenReturnStatisticIdsIsArrayList() {
    // Arrange
    ArrayList<Long> statisticIds = new ArrayList<>();
    statisticIds.add(1L);
    statisticIds.add(1L);

    Json json = new Json();

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
    json.setSelector(
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());
    json.setStatisticIds(statisticIds);

    // Act
    ImmutableEntityStatisticQueryOptions actualFromJsonResult =
        ImmutableEntityStatisticQueryOptions.fromJson(json);

    // Assert
    assertEquals(statisticIds, actualFromJsonResult.statisticIds());
  }

  /**
   * Test {@link ImmutableEntityStatisticQueryOptions#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add one.
   *   <li>Then return statisticIds size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticQueryOptions#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList() add one; then return statisticIds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticQueryOptions ImmutableEntityStatisticQueryOptions.fromJson(Json)"
  })
  void testFromJson_givenArrayListAddOne_thenReturnStatisticIdsSizeIsOne() {
    // Arrange
    ArrayList<Long> statisticIds = new ArrayList<>();
    statisticIds.add(1L);

    Json json = new Json();

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
    json.setSelector(
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());
    json.setStatisticIds(statisticIds);

    // Act
    ImmutableEntityStatisticQueryOptions actualFromJsonResult =
        ImmutableEntityStatisticQueryOptions.fromJson(json);

    // Assert
    List<Long> statisticIdsResult = actualFromJsonResult.statisticIds();
    assertEquals(1, statisticIdsResult.size());
    assertEquals(1L, statisticIdsResult.get(0).longValue());
  }

  /**
   * Test {@link ImmutableEntityStatisticQueryOptions#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return statisticIds Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticQueryOptions#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList(); then return statisticIds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticQueryOptions ImmutableEntityStatisticQueryOptions.fromJson(Json)"
  })
  void testFromJson_givenArrayList_thenReturnStatisticIdsEmpty() {
    // Arrange
    Json json = new Json();

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
    json.setSelector(
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());
    json.setStatisticIds(new ArrayList<>());

    // Act
    ImmutableEntityStatisticQueryOptions actualFromJsonResult =
        ImmutableEntityStatisticQueryOptions.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.statisticIds().isEmpty());
    IdSelectionOptions expectedSelectorResult = json.selector;
    assertSame(expectedSelectorResult, actualFromJsonResult.selector());
  }

  /**
   * Test {@link ImmutableEntityStatisticQueryOptions#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) StatisticIds is {@code null}.
   *   <li>Then return statisticIds Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityStatisticQueryOptions#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) StatisticIds is 'null'; then return statisticIds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticQueryOptions ImmutableEntityStatisticQueryOptions.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonStatisticIdsIsNull_thenReturnStatisticIdsEmpty() {
    // Arrange
    Json json = new Json();

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
    json.setSelector(
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());
    json.setStatisticIds(null);

    // Act
    ImmutableEntityStatisticQueryOptions actualFromJsonResult =
        ImmutableEntityStatisticQueryOptions.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.statisticIds().isEmpty());
    IdSelectionOptions expectedSelectorResult = json.selector;
    assertSame(expectedSelectorResult, actualFromJsonResult.selector());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityStatisticQueryOptions#toString()}
   *   <li>{@link ImmutableEntityStatisticQueryOptions#selector()}
   *   <li>{@link ImmutableEntityStatisticQueryOptions#statisticIds()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IdSelectionOptions ImmutableEntityStatisticQueryOptions.selector()",
    "List ImmutableEntityStatisticQueryOptions.statisticIds()",
    "String ImmutableEntityStatisticQueryOptions.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableEntityStatisticQueryOptions.Builder builderResult =
        ImmutableEntityStatisticQueryOptions.builder();

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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableEntityStatisticQueryOptions immutableEntityStatisticQueryOptions =
        builderResult
            .selector(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableEntityStatisticQueryOptions.toString();
    IdSelectionOptions actualSelectorResult = immutableEntityStatisticQueryOptions.selector();

    // Assert
    assertTrue(actualSelectorResult instanceof ImmutableIdSelectionOptions);
    assertEquals(
        "EntityStatisticQueryOptions{selector=IdSelectionOptions{entityReference=EntityReference{kind=ALL, id=1,"
            + " entityLifecycleStatus=ACTIVE}, scope=EXACT, joiningEntityKind=ALL, entityLifecycleStatuses=[],"
            + " filters=SelectionFilters{omitApplicationKinds=[]}}, statisticIds=[]}",
        actualToStringResult);
    assertTrue(immutableEntityStatisticQueryOptions.statisticIds().isEmpty());
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
    assertNull(actualJson.selector);
    assertTrue(actualJson.statisticIds.isEmpty());
  }

  /**
   * Test Json {@link Json#selector()}.
   *
   * <p>Method under test: {@link Json#selector()}
   */
  @Test
  @DisplayName("Test Json selector()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IdSelectionOptions Json.selector()"})
  void testJsonSelector() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().selector());
  }

  /**
   * Test Json {@link Json#statisticIds()}.
   *
   * <p>Method under test: {@link Json#statisticIds()}
   */
  @Test
  @DisplayName("Test Json statisticIds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.statisticIds()"})
  void testJsonStatisticIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().statisticIds());
  }

  /**
   * Test {@link ImmutableEntityStatisticQueryOptions#withSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * ImmutableEntityStatisticQueryOptions#withSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test withSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticQueryOptions ImmutableEntityStatisticQueryOptions.withSelector(IdSelectionOptions)"
  })
  void testWithSelector() {
    // Arrange
    ImmutableEntityStatisticQueryOptions.Builder builderResult =
        ImmutableEntityStatisticQueryOptions.builder();

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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableEntityStatisticQueryOptions immutableEntityStatisticQueryOptions =
        builderResult
            .selector(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
        builderResult3
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
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act
    ImmutableEntityStatisticQueryOptions actualWithSelectorResult =
        immutableEntityStatisticQueryOptions.withSelector(
            joiningEntityKindResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    assertEquals(immutableEntityStatisticQueryOptions, actualWithSelectorResult);
  }

  /**
   * Test {@link ImmutableEntityStatisticQueryOptions#withStatisticIds(Iterable)} with {@code
   * Iterable}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticQueryOptions#withStatisticIds(Iterable)}
   */
  @Test
  @DisplayName("Test withStatisticIds(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticQueryOptions ImmutableEntityStatisticQueryOptions.withStatisticIds(Iterable)"
  })
  void testWithStatisticIdsWithIterable() {
    // Arrange
    ImmutableEntityStatisticQueryOptions.Builder builderResult =
        ImmutableEntityStatisticQueryOptions.builder();

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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableEntityStatisticQueryOptions immutableEntityStatisticQueryOptions =
        builderResult
            .selector(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableEntityStatisticQueryOptions actualWithStatisticIdsResult =
        immutableEntityStatisticQueryOptions.withStatisticIds(elements);

    // Assert
    IdSelectionOptions selectorResult = actualWithStatisticIdsResult.selector();
    EntityReference entityReferenceResult = selectorResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(selectorResult instanceof ImmutableIdSelectionOptions);
    SelectionFilters filtersResult2 = selectorResult.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    List<Long> statisticIdsResult = actualWithStatisticIdsResult.statisticIds();
    assertEquals(1, statisticIdsResult.size());
    assertEquals(1L, statisticIdsResult.get(0).longValue());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, selectorResult.scope());
    assertTrue(selectorResult.entityLifecycleStatuses().isEmpty());
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
  }

  /**
   * Test {@link ImmutableEntityStatisticQueryOptions#withStatisticIds(long[])} with {@code long[]}.
   *
   * <p>Method under test: {@link ImmutableEntityStatisticQueryOptions#withStatisticIds(long[])}
   */
  @Test
  @DisplayName("Test withStatisticIds(long[]) with 'long[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityStatisticQueryOptions ImmutableEntityStatisticQueryOptions.withStatisticIds(long[])"
  })
  void testWithStatisticIdsWithLong() {
    // Arrange
    ImmutableEntityStatisticQueryOptions.Builder builderResult =
        ImmutableEntityStatisticQueryOptions.builder();

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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    ImmutableEntityStatisticQueryOptions actualWithStatisticIdsResult =
        builderResult
            .selector(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build()
            .withStatisticIds(1L, -1L, 1L, -1L);

    // Assert
    IdSelectionOptions selectorResult = actualWithStatisticIdsResult.selector();
    assertTrue(selectorResult.entityReference() instanceof ImmutableEntityReference);
    assertTrue(selectorResult instanceof ImmutableIdSelectionOptions);
    assertTrue(selectorResult.filters() instanceof ImmutableSelectionFilters);
    List<Long> statisticIdsResult = actualWithStatisticIdsResult.statisticIds();
    assertEquals(4, statisticIdsResult.size());
    assertEquals(-1L, statisticIdsResult.get(1).longValue());
    assertEquals(-1L, statisticIdsResult.get(3).longValue());
    assertEquals(1L, statisticIdsResult.get(0).longValue());
    assertEquals(1L, statisticIdsResult.get(2).longValue());
    assertEquals(HierarchyQueryScope.EXACT, selectorResult.scope());
    assertTrue(selectorResult.entityLifecycleStatuses().isEmpty());
  }
}
