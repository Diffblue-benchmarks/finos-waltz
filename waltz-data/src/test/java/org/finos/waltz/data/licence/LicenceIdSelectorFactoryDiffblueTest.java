package org.finos.waltz.data.licence;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
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
import org.finos.waltz.model.application.ImmutableApplicationIdSelectionOptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LicenceIdSelectorFactoryDiffblueTest {
  /**
   * Test {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select LicenceIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions() {
    // Arrange
    LicenceIdSelectorFactory licenceIdSelectorFactory = new LicenceIdSelectorFactory();

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

    // Act
    assertDoesNotThrow(
        () ->
            licenceIdSelectorFactory.mkForOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build()));
  }

  /**
   * Test {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select LicenceIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions2() {
    // Arrange
    LicenceIdSelectorFactory licenceIdSelectorFactory = new LicenceIdSelectorFactory();

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

    // Act
    assertDoesNotThrow(
        () ->
            licenceIdSelectorFactory.mkForOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build()));
  }

  /**
   * Test {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select LicenceIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions3() {
    // Arrange
    LicenceIdSelectorFactory licenceIdSelectorFactory = new LicenceIdSelectorFactory();

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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableApplicationIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    assertDoesNotThrow(
        () ->
            licenceIdSelectorFactory.mkForOptions(
                joiningEntityKindResult
                    .addAllApplicationKinds(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build()));
  }

  /**
   * Test {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test mkForOptions(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select LicenceIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions4() {
    // Arrange
    LicenceIdSelectorFactory licenceIdSelectorFactory = new LicenceIdSelectorFactory();

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
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableApplicationIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    assertDoesNotThrow(
        () ->
            licenceIdSelectorFactory.mkForOptions(
                joiningEntityKindResult
                    .addAllApplicationKinds(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build()));
  }

  /**
   * Test {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   *   <li>When builder addEntityLifecycleStatuses {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test mkForOptions(IdSelectionOptions); given 'ACTIVE'; when builder addEntityLifecycleStatuses 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select LicenceIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenActive_whenBuilderAddEntityLifecycleStatusesActive() {
    // Arrange
    LicenceIdSelectorFactory licenceIdSelectorFactory = new LicenceIdSelectorFactory();

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

    // Act
    assertDoesNotThrow(
        () ->
            licenceIdSelectorFactory.mkForOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build()));
  }

  /**
   * Test {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   *   <li>When builder addOmitApplicationKinds {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test mkForOptions(IdSelectionOptions); given 'IN_HOUSE'; when builder addOmitApplicationKinds 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select LicenceIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenInHouse_whenBuilderAddOmitApplicationKindsInHouse() {
    // Arrange
    LicenceIdSelectorFactory licenceIdSelectorFactory = new LicenceIdSelectorFactory();

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

    // Act
    assertDoesNotThrow(
        () ->
            licenceIdSelectorFactory.mkForOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build()));
  }

  /**
   * Test {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   *   <li>When builder addOmitApplicationKinds {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test mkForOptions(IdSelectionOptions); given 'IN_HOUSE'; when builder addOmitApplicationKinds 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select LicenceIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenInHouse_whenBuilderAddOmitApplicationKindsInHouse2() {
    // Arrange
    LicenceIdSelectorFactory licenceIdSelectorFactory = new LicenceIdSelectorFactory();

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
    ImmutableSelectionFilters filters = builderResult.build();

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
            .filters(filters);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableApplicationIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    assertDoesNotThrow(
        () ->
            licenceIdSelectorFactory.mkForOptions(
                joiningEntityKindResult
                    .addAllApplicationKinds(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build()));
  }

  /**
   * Test {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   *   <li>When builder addEntityLifecycleStatuses {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link LicenceIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test mkForOptions(IdSelectionOptions); given 'PENDING'; when builder addEntityLifecycleStatuses 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.jooq.Select LicenceIdSelectorFactory.mkForOptions(IdSelectionOptions)"})
  void testMkForOptions_givenPending_whenBuilderAddEntityLifecycleStatusesPending() {
    // Arrange
    LicenceIdSelectorFactory licenceIdSelectorFactory = new LicenceIdSelectorFactory();

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

    // Act
    assertDoesNotThrow(
        () ->
            licenceIdSelectorFactory.mkForOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build()));
  }
}
