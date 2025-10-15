package org.finos.waltz.model.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
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
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.application.ImmutableApplicationIdSelectionOptions.Builder;
import org.finos.waltz.model.application.ImmutableApplicationIdSelectionOptions.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableApplicationIdSelectionOptionsDiffblueTest {
  /**
   * Test {@link ImmutableApplicationIdSelectionOptions#applicationKinds()}.
   *
   * <p>Method under test: {@link ImmutableApplicationIdSelectionOptions#applicationKinds()}
   */
  @Test
  @DisplayName("Test applicationKinds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ImmutableApplicationIdSelectionOptions.applicationKinds()"})
  void testApplicationKinds() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build()
            .applicationKinds()
            .isEmpty());
  }

  /**
   * Test Builder {@link Builder#addAllApplicationKinds(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllApplicationKinds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllApplicationKinds(Iterable); given 'IN_HOUSE'; when LinkedHashSet() add 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllApplicationKinds(Iterable)"})
  void testBuilderAddAllApplicationKinds_givenInHouse_whenLinkedHashSetAddInHouse() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    LinkedHashSet<ApplicationKind> elements = new LinkedHashSet<>();
    elements.add(ApplicationKind.IN_HOUSE);

    // Act
    Builder actualAddAllApplicationKindsResult = builderResult.addAllApplicationKinds(elements);

    // Assert
    assertSame(builderResult, actualAddAllApplicationKindsResult);
  }

  /**
   * Test Builder {@link Builder#addAllApplicationKinds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllApplicationKinds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllApplicationKinds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllApplicationKinds(Iterable)"})
  void testBuilderAddAllApplicationKinds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    // Act
    Builder actualAddAllApplicationKindsResult =
        builderResult.addAllApplicationKinds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllApplicationKindsResult);
  }

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
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    // Act
    Builder actualAddAllEntityLifecycleStatusesResult =
        builderResult.addAllEntityLifecycleStatuses(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllEntityLifecycleStatusesResult);
  }

  /**
   * Test Builder {@link Builder#addApplicationKinds(ApplicationKind)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addApplicationKinds(ApplicationKind)}
   */
  @Test
  @DisplayName("Test Builder addApplicationKinds(ApplicationKind) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addApplicationKinds(ApplicationKind)"})
  void testBuilderAddApplicationKindsWithElement() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    // Act
    Builder actualAddApplicationKindsResult =
        builderResult.addApplicationKinds(ApplicationKind.IN_HOUSE);

    // Assert
    assertSame(builderResult, actualAddApplicationKindsResult);
  }

  /**
   * Test Builder {@link Builder#addApplicationKinds(ApplicationKind[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addApplicationKinds(ApplicationKind[])}
   */
  @Test
  @DisplayName("Test Builder addApplicationKinds(ApplicationKind[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addApplicationKinds(ApplicationKind[])"})
  void testBuilderAddApplicationKindsWithElements() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    // Act
    Builder actualAddApplicationKindsResult =
        builderResult.addApplicationKinds(ApplicationKind.IN_HOUSE);

    // Assert
    assertSame(builderResult, actualAddApplicationKindsResult);
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
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    // Act
    Builder actualAddEntityLifecycleStatusesResult =
        builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

    // Assert
    assertSame(builderResult, actualAddEntityLifecycleStatusesResult);
  }

  /**
   * Test Builder {@link Builder#applicationKinds(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#applicationKinds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder applicationKinds(Iterable); given 'IN_HOUSE'; when LinkedHashSet() add 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.applicationKinds(Iterable)"})
  void testBuilderApplicationKinds_givenInHouse_whenLinkedHashSetAddInHouse() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    LinkedHashSet<ApplicationKind> elements = new LinkedHashSet<>();
    elements.add(ApplicationKind.IN_HOUSE);

    // Act
    Builder actualApplicationKindsResult = builderResult.applicationKinds(elements);

    // Assert
    assertSame(builderResult, actualApplicationKindsResult);
  }

  /**
   * Test Builder {@link Builder#applicationKinds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#applicationKinds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder applicationKinds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.applicationKinds(Iterable)"})
  void testBuilderApplicationKinds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    // Act
    Builder actualApplicationKindsResult = builderResult.applicationKinds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualApplicationKindsResult);
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
    "ImmutableApplicationIdSelectionOptions Builder.build()",
    "Builder Builder.filters(SelectionFilters)",
    "Builder Builder.joiningEntityKind(EntityKind)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableApplicationIdSelectionOptions.builder();
    Builder actualAddAllApplicationKindsResult =
        actualBuilderResult.addAllApplicationKinds(new ArrayList<>());
    Builder actualAddEntityLifecycleStatusesResult =
        actualAddAllApplicationKindsResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .addApplicationKinds(ApplicationKind.IN_HOUSE)
            .addApplicationKinds(ApplicationKind.IN_HOUSE)
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
    ImmutableApplicationIdSelectionOptions actualImmutableApplicationIdSelectionOptions =
        actualFiltersResult
            .joiningEntityKind(joiningEntityKind)
            .joiningEntityKind(EntityKind.ALL)
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Assert
    SelectionFilters filtersResult = actualImmutableApplicationIdSelectionOptions.filters();
    assertTrue(filtersResult instanceof ImmutableSelectionFilters);
    Set<ApplicationKind> applicationKindsResult =
        actualImmutableApplicationIdSelectionOptions.applicationKinds();
    assertEquals(1, applicationKindsResult.size());
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult =
        actualImmutableApplicationIdSelectionOptions.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    assertEquals(HierarchyQueryScope.EXACT, actualImmutableApplicationIdSelectionOptions.scope());
    assertTrue(applicationKindsResult.contains(ApplicationKind.IN_HOUSE));
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertSame(entityReference, actualImmutableApplicationIdSelectionOptions.entityReference());
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
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder entityReference(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    // Act
    Builder actualEntityReferenceResult =
        builderResult.entityReference(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualEntityReferenceResult);
  }

  /**
   * Test Builder {@link Builder#from(ApplicationIdSelectionOptions)} with {@code
   * ApplicationIdSelectionOptions}.
   *
   * <p>Method under test: {@link Builder#from(ApplicationIdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ApplicationIdSelectionOptions) with 'ApplicationIdSelectionOptions'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ApplicationIdSelectionOptions)"})
  void testBuilderFromWithApplicationIdSelectionOptions() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    Builder builderResult2 = ImmutableApplicationIdSelectionOptions.builder();

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
    ImmutableApplicationIdSelectionOptions instance =
        joiningEntityKindResult
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableApplicationIdSelectionOptions actualImmutableApplicationIdSelectionOptions =
        builderResult.build();
    assertEquals(instance, actualImmutableApplicationIdSelectionOptions);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ApplicationIdSelectionOptions)} with {@code
   * ApplicationIdSelectionOptions}.
   *
   * <p>Method under test: {@link Builder#from(ApplicationIdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ApplicationIdSelectionOptions) with 'ApplicationIdSelectionOptions'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ApplicationIdSelectionOptions)"})
  void testBuilderFromWithApplicationIdSelectionOptions2() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    Builder builderResult2 = ImmutableApplicationIdSelectionOptions.builder();
    builderResult2.addApplicationKinds(ApplicationKind.IN_HOUSE);

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
    ImmutableApplicationIdSelectionOptions instance =
        joiningEntityKindResult
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act and Assert
    Set<ApplicationKind> applicationKindsResult =
        builderResult.from(instance).build().applicationKinds();
    assertEquals(1, applicationKindsResult.size());
    assertTrue(applicationKindsResult.contains(ApplicationKind.IN_HOUSE));
    ImmutableApplicationIdSelectionOptions actualImmutableApplicationIdSelectionOptions =
        builderResult.build();
    assertEquals(instance, actualImmutableApplicationIdSelectionOptions);
  }

  /**
   * Test Builder {@link Builder#from(ApplicationIdSelectionOptions)} with {@code
   * ApplicationIdSelectionOptions}.
   *
   * <p>Method under test: {@link Builder#from(ApplicationIdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ApplicationIdSelectionOptions) with 'ApplicationIdSelectionOptions'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ApplicationIdSelectionOptions)"})
  void testBuilderFromWithApplicationIdSelectionOptions3() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    Builder builderResult2 = ImmutableApplicationIdSelectionOptions.builder();

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
    Optional<? extends EntityKind> joiningEntityKind = Optional.empty();

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableApplicationIdSelectionOptions instance =
        joiningEntityKindResult
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableApplicationIdSelectionOptions actualImmutableApplicationIdSelectionOptions =
        builderResult.build();
    assertEquals(instance, actualImmutableApplicationIdSelectionOptions);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdSelectionOptions)} with {@code IdSelectionOptions}.
   *
   * <p>Method under test: {@link Builder#from(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test Builder from(IdSelectionOptions) with 'IdSelectionOptions'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdSelectionOptions)"})
  void testBuilderFromWithIdSelectionOptions() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
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

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    ImmutableApplicationIdSelectionOptions immutableApplicationIdSelectionOptions =
        builderResult
            .from(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();
    Set<ApplicationKind> applicationKindsResult =
        immutableApplicationIdSelectionOptions.applicationKinds();
    assertEquals(7, applicationKindsResult.size());
    ImmutableApplicationIdSelectionOptions immutableApplicationIdSelectionOptions2 =
        builderResult.build();
    Set<ApplicationKind> applicationKindsResult2 =
        immutableApplicationIdSelectionOptions2.applicationKinds();
    assertEquals(7, applicationKindsResult2.size());
    assertEquals(HierarchyQueryScope.EXACT, immutableApplicationIdSelectionOptions2.scope());
    assertTrue(applicationKindsResult.contains(ApplicationKind.EUC));
    assertTrue(applicationKindsResult.contains(ApplicationKind.EXTERNALLY_HOSTED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.INTERNALLY_HOSTED));
    assertTrue(applicationKindsResult2.contains(ApplicationKind.EUC));
    assertTrue(applicationKindsResult2.contains(ApplicationKind.EXTERNALLY_HOSTED));
    assertTrue(applicationKindsResult2.contains(ApplicationKind.INTERNALLY_HOSTED));
    assertTrue(applicationKindsResult2.contains(ApplicationKind.IN_HOUSE));
    assertTrue(immutableApplicationIdSelectionOptions.entityLifecycleStatuses().isEmpty());
    assertTrue(immutableApplicationIdSelectionOptions2.entityLifecycleStatuses().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(IdSelectionOptions)} with {@code IdSelectionOptions}.
   *
   * <p>Method under test: {@link Builder#from(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test Builder from(IdSelectionOptions) with 'IdSelectionOptions'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdSelectionOptions)"})
  void testBuilderFromWithIdSelectionOptions2() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    Builder builderResult2 = ImmutableApplicationIdSelectionOptions.builder();

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
    ImmutableApplicationIdSelectionOptions instance =
        joiningEntityKindResult
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act and Assert
    ImmutableApplicationIdSelectionOptions actualImmutableApplicationIdSelectionOptions =
        builderResult.from((IdSelectionOptions) instance).build();
    assertEquals(instance, actualImmutableApplicationIdSelectionOptions);
    ImmutableApplicationIdSelectionOptions actualImmutableApplicationIdSelectionOptions2 =
        builderResult.build();
    assertEquals(instance, actualImmutableApplicationIdSelectionOptions2);
  }

  /**
   * Test Builder {@link Builder#from(IdSelectionOptions)} with {@code IdSelectionOptions}.
   *
   * <p>Method under test: {@link Builder#from(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test Builder from(IdSelectionOptions) with 'IdSelectionOptions'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdSelectionOptions)"})
  void testBuilderFromWithIdSelectionOptions3() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
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

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    ImmutableApplicationIdSelectionOptions immutableApplicationIdSelectionOptions =
        builderResult
            .from(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .build();
    Set<ApplicationKind> applicationKindsResult =
        immutableApplicationIdSelectionOptions.applicationKinds();
    assertEquals(7, applicationKindsResult.size());
    ImmutableApplicationIdSelectionOptions immutableApplicationIdSelectionOptions2 =
        builderResult.build();
    Set<ApplicationKind> applicationKindsResult2 =
        immutableApplicationIdSelectionOptions2.applicationKinds();
    assertEquals(7, applicationKindsResult2.size());
    assertEquals(HierarchyQueryScope.EXACT, immutableApplicationIdSelectionOptions2.scope());
    assertTrue(applicationKindsResult.contains(ApplicationKind.EUC));
    assertTrue(applicationKindsResult.contains(ApplicationKind.EXTERNALLY_HOSTED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.INTERNALLY_HOSTED));
    assertTrue(applicationKindsResult2.contains(ApplicationKind.EUC));
    assertTrue(applicationKindsResult2.contains(ApplicationKind.EXTERNALLY_HOSTED));
    assertTrue(applicationKindsResult2.contains(ApplicationKind.INTERNALLY_HOSTED));
    assertTrue(applicationKindsResult2.contains(ApplicationKind.IN_HOUSE));
    assertTrue(immutableApplicationIdSelectionOptions.entityLifecycleStatuses().isEmpty());
    assertTrue(immutableApplicationIdSelectionOptions2.entityLifecycleStatuses().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(IdSelectionOptions)} with {@code IdSelectionOptions}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test Builder from(IdSelectionOptions) with 'IdSelectionOptions'; given 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdSelectionOptions)"})
  void testBuilderFromWithIdSelectionOptions_givenInHouse() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    Builder builderResult2 = ImmutableApplicationIdSelectionOptions.builder();
    builderResult2.addApplicationKinds(ApplicationKind.IN_HOUSE);

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
    ImmutableApplicationIdSelectionOptions instance =
        joiningEntityKindResult
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act and Assert
    ImmutableApplicationIdSelectionOptions actualImmutableApplicationIdSelectionOptions =
        builderResult.from((IdSelectionOptions) instance).build();
    assertEquals(instance, actualImmutableApplicationIdSelectionOptions);
    ImmutableApplicationIdSelectionOptions actualImmutableApplicationIdSelectionOptions2 =
        builderResult.build();
    assertEquals(instance, actualImmutableApplicationIdSelectionOptions2);
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
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();
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
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

    // Act
    Builder actualScopeResult = builderResult.scope(HierarchyQueryScope.EXACT);

    // Assert
    assertSame(builderResult, actualScopeResult);
  }

  /**
   * Test {@link ImmutableApplicationIdSelectionOptions#copyOf(ApplicationIdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableApplicationIdSelectionOptions#copyOf(ApplicationIdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test copyOf(ApplicationIdSelectionOptions); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationIdSelectionOptions ImmutableApplicationIdSelectionOptions.copyOf(ApplicationIdSelectionOptions)"
  })
  void testCopyOf_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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
    ImmutableApplicationIdSelectionOptions instance =
        joiningEntityKindResult
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    ImmutableApplicationIdSelectionOptions actualCopyOfResult =
        ImmutableApplicationIdSelectionOptions.copyOf(instance);

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
    assertTrue(actualCopyOfResult.applicationKinds().isEmpty());
  }

  /**
   * Test {@link ImmutableApplicationIdSelectionOptions#entityLifecycleStatuses()}.
   *
   * <p>Method under test: {@link ImmutableApplicationIdSelectionOptions#entityLifecycleStatuses()}
   */
  @Test
  @DisplayName("Test entityLifecycleStatuses()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ImmutableApplicationIdSelectionOptions.entityLifecycleStatuses()"})
  void testEntityLifecycleStatuses() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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
    Set<EntityLifecycleStatus> actualEntityLifecycleStatusesResult =
        joiningEntityKindResult
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build()
            .entityLifecycleStatuses();

    // Assert
    assertEquals(1, actualEntityLifecycleStatusesResult.size());
    assertTrue(actualEntityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
  }

  /**
   * Test {@link ImmutableApplicationIdSelectionOptions#equals(Object)}, and {@link
   * ImmutableApplicationIdSelectionOptions#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableApplicationIdSelectionOptions#equals(Object)}
   *   <li>{@link ImmutableApplicationIdSelectionOptions#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationIdSelectionOptions.equals(Object)",
    "int ImmutableApplicationIdSelectionOptions.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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
    ImmutableApplicationIdSelectionOptions immutableApplicationIdSelectionOptions =
        joiningEntityKindResult
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    Builder builderResult2 = ImmutableApplicationIdSelectionOptions.builder();

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
    ImmutableApplicationIdSelectionOptions immutableApplicationIdSelectionOptions2 =
        joiningEntityKindResult2
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act and Assert
    assertEquals(immutableApplicationIdSelectionOptions, immutableApplicationIdSelectionOptions2);
    assertEquals(
        immutableApplicationIdSelectionOptions.hashCode(),
        immutableApplicationIdSelectionOptions2.hashCode());
  }

  /**
   * Test {@link ImmutableApplicationIdSelectionOptions#equals(Object)}, and {@link
   * ImmutableApplicationIdSelectionOptions#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableApplicationIdSelectionOptions#equals(Object)}
   *   <li>{@link ImmutableApplicationIdSelectionOptions#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationIdSelectionOptions.equals(Object)",
    "int ImmutableApplicationIdSelectionOptions.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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
    ImmutableApplicationIdSelectionOptions immutableApplicationIdSelectionOptions =
        joiningEntityKindResult
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act and Assert
    assertEquals(immutableApplicationIdSelectionOptions, immutableApplicationIdSelectionOptions);
    int expectedHashCodeResult = immutableApplicationIdSelectionOptions.hashCode();
    assertEquals(expectedHashCodeResult, immutableApplicationIdSelectionOptions.hashCode());
  }

  /**
   * Test {@link ImmutableApplicationIdSelectionOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationIdSelectionOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationIdSelectionOptions.equals(Object)",
    "int ImmutableApplicationIdSelectionOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();
    builderResult.addAllEntityLifecycleStatuses(new ArrayList<>());

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
    ImmutableApplicationIdSelectionOptions immutableApplicationIdSelectionOptions =
        joiningEntityKindResult
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    Builder builderResult2 = ImmutableApplicationIdSelectionOptions.builder();

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
        immutableApplicationIdSelectionOptions,
        joiningEntityKindResult2
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());
  }

  /**
   * Test {@link ImmutableApplicationIdSelectionOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationIdSelectionOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationIdSelectionOptions.equals(Object)",
    "int ImmutableApplicationIdSelectionOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();
    builderResult.addApplicationKinds(ApplicationKind.IN_HOUSE);

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
    ImmutableApplicationIdSelectionOptions immutableApplicationIdSelectionOptions =
        joiningEntityKindResult
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    Builder builderResult2 = ImmutableApplicationIdSelectionOptions.builder();

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
        immutableApplicationIdSelectionOptions,
        joiningEntityKindResult2
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());
  }

  /**
   * Test {@link ImmutableApplicationIdSelectionOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationIdSelectionOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationIdSelectionOptions.equals(Object)",
    "int ImmutableApplicationIdSelectionOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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
    ImmutableApplicationIdSelectionOptions immutableApplicationIdSelectionOptions =
        joiningEntityKindResult
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    Builder builderResult2 = ImmutableApplicationIdSelectionOptions.builder();

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
        immutableApplicationIdSelectionOptions,
        joiningEntityKindResult2
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());
  }

  /**
   * Test {@link ImmutableApplicationIdSelectionOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationIdSelectionOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationIdSelectionOptions.equals(Object)",
    "int ImmutableApplicationIdSelectionOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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
    ImmutableApplicationIdSelectionOptions immutableApplicationIdSelectionOptions =
        joiningEntityKindResult
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    Builder builderResult2 = ImmutableApplicationIdSelectionOptions.builder();

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
        immutableApplicationIdSelectionOptions,
        joiningEntityKindResult2
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());
  }

  /**
   * Test {@link ImmutableApplicationIdSelectionOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationIdSelectionOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationIdSelectionOptions.equals(Object)",
    "int ImmutableApplicationIdSelectionOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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
    ImmutableApplicationIdSelectionOptions immutableApplicationIdSelectionOptions =
        joiningEntityKindResult
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.PARENTS)
            .build();

    Builder builderResult2 = ImmutableApplicationIdSelectionOptions.builder();

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
        immutableApplicationIdSelectionOptions,
        joiningEntityKindResult2
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build());
  }

  /**
   * Test {@link ImmutableApplicationIdSelectionOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationIdSelectionOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationIdSelectionOptions.equals(Object)",
    "int ImmutableApplicationIdSelectionOptions.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableApplicationIdSelectionOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationIdSelectionOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableApplicationIdSelectionOptions.equals(Object)",
    "int ImmutableApplicationIdSelectionOptions.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build(),
        "Different type to ImmutableApplicationIdSelectionOptions");
  }

  /**
   * Test {@link ImmutableApplicationIdSelectionOptions#filters()}.
   *
   * <p>Method under test: {@link ImmutableApplicationIdSelectionOptions#filters()}
   */
  @Test
  @DisplayName("Test filters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SelectionFilters ImmutableApplicationIdSelectionOptions.filters()"})
  void testFilters() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build()
            .filters();

    // Assert
    assertTrue(actualFiltersResult instanceof ImmutableSelectionFilters);
    assertTrue(actualFiltersResult.omitApplicationKinds().isEmpty());
    assertSame(SelectionFilters.NO_FILTERS, actualFiltersResult);
  }

  /**
   * Test {@link ImmutableApplicationIdSelectionOptions#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code EXACT}.
   *   <li>Then filters return {@link ImmutableSelectionFilters}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationIdSelectionOptions#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'EXACT'; then filters return ImmutableSelectionFilters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationIdSelectionOptions ImmutableApplicationIdSelectionOptions.fromJson(Json)"
  })
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
    ImmutableApplicationIdSelectionOptions actualFromJsonResult =
        ImmutableApplicationIdSelectionOptions.fromJson(json);

    // Assert
    SelectionFilters filtersResult = actualFromJsonResult.filters();
    assertTrue(filtersResult instanceof ImmutableSelectionFilters);
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult =
        actualFromJsonResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    Set<ApplicationKind> applicationKindsResult = actualFromJsonResult.applicationKinds();
    assertEquals(7, applicationKindsResult.size());
    assertEquals(HierarchyQueryScope.EXACT, actualFromJsonResult.scope());
    assertTrue(applicationKindsResult.contains(ApplicationKind.CUSTOMISED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.EUC));
    assertTrue(applicationKindsResult.contains(ApplicationKind.EXTERNALLY_HOSTED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.INTERNALLY_HOSTED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.IN_HOUSE));
    assertTrue(applicationKindsResult.contains(ApplicationKind.THIRD_PARTY));
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(filtersResult.omitApplicationKinds().isEmpty());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Test {@link ImmutableApplicationIdSelectionOptions#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link SelectionFilters#NO_FILTERS}.
   *   <li>Then return filters is {@link Json} (default constructor) {@link Json#filters}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableApplicationIdSelectionOptions#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given NO_FILTERS; then return filters is Json (default constructor) filters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationIdSelectionOptions ImmutableApplicationIdSelectionOptions.fromJson(Json)"
  })
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
    ImmutableApplicationIdSelectionOptions actualFromJsonResult =
        ImmutableApplicationIdSelectionOptions.fromJson(json);

    // Assert
    SelectionFilters filtersResult = actualFromJsonResult.filters();
    assertTrue(filtersResult instanceof ImmutableSelectionFilters);
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult =
        actualFromJsonResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    Set<ApplicationKind> applicationKindsResult = actualFromJsonResult.applicationKinds();
    assertEquals(7, applicationKindsResult.size());
    assertEquals(HierarchyQueryScope.EXACT, actualFromJsonResult.scope());
    assertTrue(applicationKindsResult.contains(ApplicationKind.CUSTOMISED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.EUC));
    assertTrue(applicationKindsResult.contains(ApplicationKind.EXTERNALLY_HOSTED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.INTERNALLY_HOSTED));
    assertTrue(applicationKindsResult.contains(ApplicationKind.IN_HOUSE));
    assertTrue(applicationKindsResult.contains(ApplicationKind.THIRD_PARTY));
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
   *   <li>{@link ImmutableApplicationIdSelectionOptions#entityReference()}
   *   <li>{@link ImmutableApplicationIdSelectionOptions#scope()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityReference ImmutableApplicationIdSelectionOptions.entityReference()",
    "HierarchyQueryScope ImmutableApplicationIdSelectionOptions.scope()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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
    ImmutableApplicationIdSelectionOptions immutableApplicationIdSelectionOptions =
        joiningEntityKindResult
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    EntityReference actualEntityReferenceResult =
        immutableApplicationIdSelectionOptions.entityReference();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals(HierarchyQueryScope.EXACT, immutableApplicationIdSelectionOptions.scope());
  }

  /**
   * Test {@link ImmutableApplicationIdSelectionOptions#joiningEntityKind()}.
   *
   * <p>Method under test: {@link ImmutableApplicationIdSelectionOptions#joiningEntityKind()}
   */
  @Test
  @DisplayName("Test joiningEntityKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableApplicationIdSelectionOptions.joiningEntityKind()"})
  void testJoiningEntityKind() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build()
            .joiningEntityKind());
  }

  /**
   * Test Json {@link Json#applicationKinds()}.
   *
   * <p>Method under test: {@link Json#applicationKinds()}
   */
  @Test
  @DisplayName("Test Json applicationKinds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.applicationKinds()"})
  void testJsonApplicationKinds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().applicationKinds());
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
    assertFalse(actualJson.applicationKindsIsSet);
    assertFalse(actualJson.entityLifecycleStatusesIsSet);
    assertTrue(actualJson.applicationKinds.isEmpty());
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
   * Test Json {@link Json#setApplicationKinds(Set)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   *   <li>Then {@link Json} (default constructor) {@link Json#applicationKinds} size is one.
   * </ul>
   *
   * <p>Method under test: {@link Json#setApplicationKinds(Set)}
   */
  @Test
  @DisplayName(
      "Test Json setApplicationKinds(Set); given 'IN_HOUSE'; then Json (default constructor) applicationKinds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setApplicationKinds(Set)"})
  void testJsonSetApplicationKinds_givenInHouse_thenJsonApplicationKindsSizeIsOne() {
    // Arrange
    Json json = new Json();

    HashSet<ApplicationKind> applicationKinds = new HashSet<>();
    applicationKinds.add(ApplicationKind.IN_HOUSE);

    // Act
    json.setApplicationKinds(applicationKinds);

    // Assert
    Set<ApplicationKind> applicationKindSet = json.applicationKinds;
    assertEquals(1, applicationKindSet.size());
    assertTrue(applicationKindSet.contains(ApplicationKind.IN_HOUSE));
    assertTrue(json.applicationKindsIsSet);
  }

  /**
   * Test Json {@link Json#setApplicationKinds(Set)}.
   *
   * <ul>
   *   <li>Then {@link Json} (default constructor) {@link Json#applicationKinds} size is two.
   * </ul>
   *
   * <p>Method under test: {@link Json#setApplicationKinds(Set)}
   */
  @Test
  @DisplayName(
      "Test Json setApplicationKinds(Set); then Json (default constructor) applicationKinds size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setApplicationKinds(Set)"})
  void testJsonSetApplicationKinds_thenJsonApplicationKindsSizeIsTwo() {
    // Arrange
    Json json = new Json();

    HashSet<ApplicationKind> applicationKinds = new HashSet<>();
    applicationKinds.add(ApplicationKind.INTERNALLY_HOSTED);
    applicationKinds.add(ApplicationKind.IN_HOUSE);

    // Act
    json.setApplicationKinds(applicationKinds);

    // Assert
    Set<ApplicationKind> applicationKindSet = json.applicationKinds;
    assertEquals(2, applicationKindSet.size());
    assertTrue(applicationKindSet.contains(ApplicationKind.INTERNALLY_HOSTED));
    assertTrue(applicationKindSet.contains(ApplicationKind.IN_HOUSE));
    assertTrue(json.applicationKindsIsSet);
  }

  /**
   * Test Json {@link Json#setApplicationKinds(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then {@link Json} (default constructor) {@link Json#applicationKinds} Empty.
   * </ul>
   *
   * <p>Method under test: {@link Json#setApplicationKinds(Set)}
   */
  @Test
  @DisplayName(
      "Test Json setApplicationKinds(Set); when HashSet(); then Json (default constructor) applicationKinds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setApplicationKinds(Set)"})
  void testJsonSetApplicationKinds_whenHashSet_thenJsonApplicationKindsEmpty() {
    // Arrange
    Json json = new Json();

    // Act
    json.setApplicationKinds(new HashSet<>());

    // Assert
    assertTrue(json.applicationKinds.isEmpty());
    assertTrue(json.applicationKindsIsSet);
  }

  /**
   * Test Json {@link Json#setApplicationKinds(Set)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link Json} (default constructor) {@link Json#applicationKinds} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Json#setApplicationKinds(Set)}
   */
  @Test
  @DisplayName(
      "Test Json setApplicationKinds(Set); when 'null'; then Json (default constructor) applicationKinds is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setApplicationKinds(Set)"})
  void testJsonSetApplicationKinds_whenNull_thenJsonApplicationKindsIsNull() {
    // Arrange
    Json json = new Json();

    // Act
    json.setApplicationKinds(null);

    // Assert
    assertNull(json.applicationKinds);
    assertFalse(json.applicationKindsIsSet);
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
   * Test {@link ImmutableApplicationIdSelectionOptions#toString()}.
   *
   * <p>Method under test: {@link ImmutableApplicationIdSelectionOptions#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ImmutableApplicationIdSelectionOptions.toString()"})
  void testToString() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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
        "ApplicationIdSelectionOptions{entityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE},"
            + " scope=EXACT, joiningEntityKind=ALL, entityLifecycleStatuses=[ACTIVE], filters=SelectionFilters"
            + "{omitApplicationKinds=[]}, applicationKinds=[]}",
        joiningEntityKindResult
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableApplicationIdSelectionOptions#toString()}.
   *
   * <p>Method under test: {@link ImmutableApplicationIdSelectionOptions#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ImmutableApplicationIdSelectionOptions.toString()"})
  void testToString2() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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
        "ApplicationIdSelectionOptions{entityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE},"
            + " scope=EXACT, entityLifecycleStatuses=[ACTIVE], filters=SelectionFilters{omitApplicationKinds=[]},"
            + " applicationKinds=[]}",
        joiningEntityKindResult
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableApplicationIdSelectionOptions#withApplicationKinds(ApplicationKind[])}
   * with {@code ApplicationKind[]}.
   *
   * <p>Method under test: {@link
   * ImmutableApplicationIdSelectionOptions#withApplicationKinds(ApplicationKind[])}
   */
  @Test
  @DisplayName("Test withApplicationKinds(ApplicationKind[]) with 'ApplicationKind[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationIdSelectionOptions ImmutableApplicationIdSelectionOptions.withApplicationKinds(ApplicationKind[])"
  })
  void testWithApplicationKindsWithApplicationKind() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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
    ImmutableApplicationIdSelectionOptions actualWithApplicationKindsResult =
        joiningEntityKindResult
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build()
            .withApplicationKinds(ApplicationKind.IN_HOUSE);

    // Assert
    EntityReference entityReferenceResult = actualWithApplicationKindsResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    SelectionFilters filtersResult2 = actualWithApplicationKindsResult.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    Set<ApplicationKind> applicationKindsResult =
        actualWithApplicationKindsResult.applicationKinds();
    assertEquals(1, applicationKindsResult.size());
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult =
        actualWithApplicationKindsResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, actualWithApplicationKindsResult.scope());
    assertTrue(applicationKindsResult.contains(ApplicationKind.IN_HOUSE));
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
  }

  /**
   * Test {@link ImmutableApplicationIdSelectionOptions#withApplicationKinds(Iterable)} with {@code
   * Iterable}.
   *
   * <p>Method under test: {@link
   * ImmutableApplicationIdSelectionOptions#withApplicationKinds(Iterable)}
   */
  @Test
  @DisplayName("Test withApplicationKinds(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationIdSelectionOptions ImmutableApplicationIdSelectionOptions.withApplicationKinds(Iterable)"
  })
  void testWithApplicationKindsWithIterable() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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
    ImmutableApplicationIdSelectionOptions immutableApplicationIdSelectionOptions =
        joiningEntityKindResult
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    LinkedHashSet<ApplicationKind> elements = new LinkedHashSet<>();
    elements.add(ApplicationKind.IN_HOUSE);

    // Act
    ImmutableApplicationIdSelectionOptions actualWithApplicationKindsResult =
        immutableApplicationIdSelectionOptions.withApplicationKinds(elements);

    // Assert
    EntityReference entityReferenceResult = actualWithApplicationKindsResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    SelectionFilters filtersResult2 = actualWithApplicationKindsResult.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult =
        actualWithApplicationKindsResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, actualWithApplicationKindsResult.scope());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
    assertEquals(elements, actualWithApplicationKindsResult.applicationKinds());
  }

  /**
   * Test {@link
   * ImmutableApplicationIdSelectionOptions#withEntityLifecycleStatuses(EntityLifecycleStatus[])}
   * with {@code EntityLifecycleStatus[]}.
   *
   * <p>Method under test: {@link
   * ImmutableApplicationIdSelectionOptions#withEntityLifecycleStatuses(EntityLifecycleStatus[])}
   */
  @Test
  @DisplayName(
      "Test withEntityLifecycleStatuses(EntityLifecycleStatus[]) with 'EntityLifecycleStatus[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationIdSelectionOptions ImmutableApplicationIdSelectionOptions.withEntityLifecycleStatuses(EntityLifecycleStatus[])"
  })
  void testWithEntityLifecycleStatusesWithEntityLifecycleStatus() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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
    ImmutableApplicationIdSelectionOptions immutableApplicationIdSelectionOptions =
        joiningEntityKindResult
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    ImmutableApplicationIdSelectionOptions actualWithEntityLifecycleStatusesResult =
        immutableApplicationIdSelectionOptions.withEntityLifecycleStatuses(
            EntityLifecycleStatus.ACTIVE);

    // Assert
    assertEquals(immutableApplicationIdSelectionOptions, actualWithEntityLifecycleStatusesResult);
  }

  /**
   * Test {@link ImmutableApplicationIdSelectionOptions#withEntityLifecycleStatuses(Iterable)} with
   * {@code Iterable}.
   *
   * <p>Method under test: {@link
   * ImmutableApplicationIdSelectionOptions#withEntityLifecycleStatuses(Iterable)}
   */
  @Test
  @DisplayName("Test withEntityLifecycleStatuses(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationIdSelectionOptions ImmutableApplicationIdSelectionOptions.withEntityLifecycleStatuses(Iterable)"
  })
  void testWithEntityLifecycleStatusesWithIterable() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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
    ImmutableApplicationIdSelectionOptions immutableApplicationIdSelectionOptions =
        joiningEntityKindResult
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    LinkedHashSet<EntityLifecycleStatus> elements = new LinkedHashSet<>();
    elements.add(EntityLifecycleStatus.ACTIVE);

    // Act
    ImmutableApplicationIdSelectionOptions actualWithEntityLifecycleStatusesResult =
        immutableApplicationIdSelectionOptions.withEntityLifecycleStatuses(elements);

    // Assert
    assertEquals(immutableApplicationIdSelectionOptions, actualWithEntityLifecycleStatusesResult);
  }

  /**
   * Test {@link ImmutableApplicationIdSelectionOptions#withEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableApplicationIdSelectionOptions#withEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationIdSelectionOptions ImmutableApplicationIdSelectionOptions.withEntityReference(EntityReference)"
  })
  void testWithEntityReference() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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
    ImmutableApplicationIdSelectionOptions immutableApplicationIdSelectionOptions =
        joiningEntityKindResult
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    ImmutableApplicationIdSelectionOptions actualWithEntityReferenceResult =
        immutableApplicationIdSelectionOptions.withEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableApplicationIdSelectionOptions, actualWithEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableApplicationIdSelectionOptions#withFilters(SelectionFilters)}.
   *
   * <p>Method under test: {@link
   * ImmutableApplicationIdSelectionOptions#withFilters(SelectionFilters)}
   */
  @Test
  @DisplayName("Test withFilters(SelectionFilters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationIdSelectionOptions ImmutableApplicationIdSelectionOptions.withFilters(SelectionFilters)"
  })
  void testWithFilters() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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
    ImmutableApplicationIdSelectionOptions immutableApplicationIdSelectionOptions =
        joiningEntityKindResult
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    ImmutableApplicationIdSelectionOptions actualWithFiltersResult =
        immutableApplicationIdSelectionOptions.withFilters(SelectionFilters.NO_FILTERS);

    // Assert
    assertSame(immutableApplicationIdSelectionOptions, actualWithFiltersResult);
  }

  /**
   * Test {@link ImmutableApplicationIdSelectionOptions#withFilters(SelectionFilters)}.
   *
   * <p>Method under test: {@link
   * ImmutableApplicationIdSelectionOptions#withFilters(SelectionFilters)}
   */
  @Test
  @DisplayName("Test withFilters(SelectionFilters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationIdSelectionOptions ImmutableApplicationIdSelectionOptions.withFilters(SelectionFilters)"
  })
  void testWithFilters2() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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
    ImmutableApplicationIdSelectionOptions immutableApplicationIdSelectionOptions =
        joiningEntityKindResult
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    ImmutableApplicationIdSelectionOptions actualWithFiltersResult =
        immutableApplicationIdSelectionOptions.withFilters(SelectionFilters.NO_FILTERS);

    // Assert
    assertEquals(immutableApplicationIdSelectionOptions, actualWithFiltersResult);
  }

  /**
   * Test {@link ImmutableApplicationIdSelectionOptions#withJoiningEntityKind(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link
   * ImmutableApplicationIdSelectionOptions#withJoiningEntityKind(Optional)}
   */
  @Test
  @DisplayName("Test withJoiningEntityKind(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationIdSelectionOptions ImmutableApplicationIdSelectionOptions.withJoiningEntityKind(Optional)"
  })
  void testWithJoiningEntityKindWithOptional() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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
    ImmutableApplicationIdSelectionOptions immutableApplicationIdSelectionOptions =
        joiningEntityKindResult
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    Optional<? extends EntityKind> optional = Optional.of(EntityKind.ALL);

    // Act
    ImmutableApplicationIdSelectionOptions actualWithJoiningEntityKindResult =
        immutableApplicationIdSelectionOptions.withJoiningEntityKind(optional);

    // Assert
    assertSame(immutableApplicationIdSelectionOptions, actualWithJoiningEntityKindResult);
  }

  /**
   * Test {@link ImmutableApplicationIdSelectionOptions#withJoiningEntityKind(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link
   * ImmutableApplicationIdSelectionOptions#withJoiningEntityKind(Optional)}
   */
  @Test
  @DisplayName("Test withJoiningEntityKind(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationIdSelectionOptions ImmutableApplicationIdSelectionOptions.withJoiningEntityKind(Optional)"
  })
  void testWithJoiningEntityKindWithOptional2() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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
    ImmutableApplicationIdSelectionOptions immutableApplicationIdSelectionOptions =
        joiningEntityKindResult
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    Optional<? extends EntityKind> optional = Optional.of(EntityKind.ALL);

    // Act
    ImmutableApplicationIdSelectionOptions actualWithJoiningEntityKindResult =
        immutableApplicationIdSelectionOptions.withJoiningEntityKind(optional);

    // Assert
    EntityReference entityReferenceResult = actualWithJoiningEntityKindResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    SelectionFilters filtersResult2 = actualWithJoiningEntityKindResult.filters();
    assertTrue(filtersResult2 instanceof ImmutableSelectionFilters);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult =
        actualWithJoiningEntityKindResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, actualWithJoiningEntityKindResult.scope());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
    assertTrue(actualWithJoiningEntityKindResult.applicationKinds().isEmpty());
  }

  /**
   * Test {@link ImmutableApplicationIdSelectionOptions#withJoiningEntityKind(EntityKind)} with
   * {@code value}.
   *
   * <p>Method under test: {@link
   * ImmutableApplicationIdSelectionOptions#withJoiningEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withJoiningEntityKind(EntityKind) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationIdSelectionOptions ImmutableApplicationIdSelectionOptions.withJoiningEntityKind(EntityKind)"
  })
  void testWithJoiningEntityKindWithValue() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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
    ImmutableApplicationIdSelectionOptions immutableApplicationIdSelectionOptions =
        joiningEntityKindResult
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    ImmutableApplicationIdSelectionOptions actualWithJoiningEntityKindResult =
        immutableApplicationIdSelectionOptions.withJoiningEntityKind(EntityKind.ALL);

    // Assert
    assertSame(immutableApplicationIdSelectionOptions, actualWithJoiningEntityKindResult);
  }

  /**
   * Test {@link ImmutableApplicationIdSelectionOptions#withJoiningEntityKind(EntityKind)} with
   * {@code value}.
   *
   * <p>Method under test: {@link
   * ImmutableApplicationIdSelectionOptions#withJoiningEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withJoiningEntityKind(EntityKind) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationIdSelectionOptions ImmutableApplicationIdSelectionOptions.withJoiningEntityKind(EntityKind)"
  })
  void testWithJoiningEntityKindWithValue2() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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
    ImmutableApplicationIdSelectionOptions actualWithJoiningEntityKindResult =
        joiningEntityKindResult
            .addAllApplicationKinds(new ArrayList<>())
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
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult =
        actualWithJoiningEntityKindResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, actualWithJoiningEntityKindResult.scope());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
    assertTrue(actualWithJoiningEntityKindResult.applicationKinds().isEmpty());
  }

  /**
   * Test {@link ImmutableApplicationIdSelectionOptions#withScope(HierarchyQueryScope)}.
   *
   * <p>Method under test: {@link
   * ImmutableApplicationIdSelectionOptions#withScope(HierarchyQueryScope)}
   */
  @Test
  @DisplayName("Test withScope(HierarchyQueryScope)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationIdSelectionOptions ImmutableApplicationIdSelectionOptions.withScope(HierarchyQueryScope)"
  })
  void testWithScope() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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
    ImmutableApplicationIdSelectionOptions immutableApplicationIdSelectionOptions =
        joiningEntityKindResult
            .addAllApplicationKinds(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    ImmutableApplicationIdSelectionOptions actualWithScopeResult =
        immutableApplicationIdSelectionOptions.withScope(HierarchyQueryScope.EXACT);

    // Assert
    assertSame(immutableApplicationIdSelectionOptions, actualWithScopeResult);
  }

  /**
   * Test {@link ImmutableApplicationIdSelectionOptions#withScope(HierarchyQueryScope)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableApplicationIdSelectionOptions#withScope(HierarchyQueryScope)}
   */
  @Test
  @DisplayName(
      "Test withScope(HierarchyQueryScope); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableApplicationIdSelectionOptions ImmutableApplicationIdSelectionOptions.withScope(HierarchyQueryScope)"
  })
  void testWithScope_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableApplicationIdSelectionOptions.builder();

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
    ImmutableApplicationIdSelectionOptions actualWithScopeResult =
        joiningEntityKindResult
            .addAllApplicationKinds(new ArrayList<>())
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
    Set<EntityLifecycleStatus> entityLifecycleStatusesResult =
        actualWithScopeResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(HierarchyQueryScope.EXACT, actualWithScopeResult.scope());
    assertTrue(entityLifecycleStatusesResult.contains(EntityLifecycleStatus.ACTIVE));
    assertTrue(filtersResult2.omitApplicationKinds().isEmpty());
    assertTrue(actualWithScopeResult.applicationKinds().isEmpty());
  }
}
