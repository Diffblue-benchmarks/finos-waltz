package org.finos.waltz.service.cost_kind;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.GenericSelector;
import org.finos.waltz.data.cost.CostKindDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.cost.CostKindWithYears;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CostKindServiceDiffblueTest {
  /**
   * Test {@link CostKindService#findAll()}.
   *
   * <p>Method under test: {@link CostKindService#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CostKindService.findAll()"})
  void testFindAll() {
    // Arrange
    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findAll()).thenReturn(new HashSet<>());

    // Act
    Set<CostKindWithYears> actualFindAllResult = new CostKindService(costKindDao).findAll();

    // Assert
    verify(costKindDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link CostKindService#findCostKindsBySubjectKind(EntityKind)}.
   *
   * <p>Method under test: {@link CostKindService#findCostKindsBySubjectKind(EntityKind)}
   */
  @Test
  @DisplayName("Test findCostKindsBySubjectKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CostKindService.findCostKindsBySubjectKind(EntityKind)"})
  void testFindCostKindsBySubjectKind() {
    // Arrange
    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findCostKindsBySubjectKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<CostKindWithYears> actualFindCostKindsBySubjectKindResult =
        new CostKindService(costKindDao).findCostKindsBySubjectKind(EntityKind.ALL);

    // Assert
    verify(costKindDao).findCostKindsBySubjectKind(EntityKind.ALL);
    assertTrue(actualFindCostKindsBySubjectKindResult.isEmpty());
  }

  /**
   * Test {@link CostKindService#findCostKindsSelectorRoute(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link CostKindService#findCostKindsSelectorRoute(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findCostKindsSelectorRoute(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set CostKindService.findCostKindsSelectorRoute(EntityKind, IdSelectionOptions)"
  })
  void testFindCostKindsSelectorRoute() {
    // Arrange
    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findCostKindsBySelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    CostKindService costKindService = new CostKindService(costKindDao);

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
    Set<CostKindWithYears> actualFindCostKindsSelectorRouteResult =
        costKindService.findCostKindsSelectorRoute(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(costKindDao).findCostKindsBySelector(isA(GenericSelector.class));
    assertTrue(actualFindCostKindsSelectorRouteResult.isEmpty());
  }

  /**
   * Test {@link CostKindService#findCostKindsSelectorRoute(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link CostKindService#findCostKindsSelectorRoute(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findCostKindsSelectorRoute(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set CostKindService.findCostKindsSelectorRoute(EntityKind, IdSelectionOptions)"
  })
  void testFindCostKindsSelectorRoute2() {
    // Arrange
    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findCostKindsBySelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    CostKindService costKindService = new CostKindService(costKindDao);

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
    Set<CostKindWithYears> actualFindCostKindsSelectorRouteResult =
        costKindService.findCostKindsSelectorRoute(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(costKindDao).findCostKindsBySelector(isA(GenericSelector.class));
    assertTrue(actualFindCostKindsSelectorRouteResult.isEmpty());
  }

  /**
   * Test {@link CostKindService#findCostKindsSelectorRoute(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link CostKindService#findCostKindsSelectorRoute(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findCostKindsSelectorRoute(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set CostKindService.findCostKindsSelectorRoute(EntityKind, IdSelectionOptions)"
  })
  void testFindCostKindsSelectorRoute3() {
    // Arrange
    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findCostKindsBySelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    CostKindService costKindService = new CostKindService(costKindDao);

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.APPLICATION)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Set<CostKindWithYears> actualFindCostKindsSelectorRouteResult =
        costKindService.findCostKindsSelectorRoute(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(costKindDao).findCostKindsBySelector(isA(GenericSelector.class));
    assertTrue(actualFindCostKindsSelectorRouteResult.isEmpty());
  }

  /**
   * Test {@link CostKindService#findCostKindsSelectorRoute(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link CostKindService#findCostKindsSelectorRoute(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findCostKindsSelectorRoute(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set CostKindService.findCostKindsSelectorRoute(EntityKind, IdSelectionOptions)"
  })
  void testFindCostKindsSelectorRoute4() {
    // Arrange
    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findCostKindsBySelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    CostKindService costKindService = new CostKindService(costKindDao);

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.APP_GROUP)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Set<CostKindWithYears> actualFindCostKindsSelectorRouteResult =
        costKindService.findCostKindsSelectorRoute(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(costKindDao).findCostKindsBySelector(isA(GenericSelector.class));
    assertTrue(actualFindCostKindsSelectorRouteResult.isEmpty());
  }

  /**
   * Test {@link CostKindService#findCostKindsSelectorRoute(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link CostKindService#findCostKindsSelectorRoute(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findCostKindsSelectorRoute(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set CostKindService.findCostKindsSelectorRoute(EntityKind, IdSelectionOptions)"
  })
  void testFindCostKindsSelectorRoute5() {
    // Arrange
    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findCostKindsBySelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    CostKindService costKindService = new CostKindService(costKindDao);

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

    // Act
    Set<CostKindWithYears> actualFindCostKindsSelectorRouteResult =
        costKindService.findCostKindsSelectorRoute(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(costKindDao).findCostKindsBySelector(isA(GenericSelector.class));
    assertTrue(actualFindCostKindsSelectorRouteResult.isEmpty());
  }

  /**
   * Test {@link CostKindService#findCostKindsSelectorRoute(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link CostKindService#findCostKindsSelectorRoute(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findCostKindsSelectorRoute(EntityKind, IdSelectionOptions); given 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set CostKindService.findCostKindsSelectorRoute(EntityKind, IdSelectionOptions)"
  })
  void testFindCostKindsSelectorRoute_givenActive() {
    // Arrange
    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findCostKindsBySelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    CostKindService costKindService = new CostKindService(costKindDao);

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
    Set<CostKindWithYears> actualFindCostKindsSelectorRouteResult =
        costKindService.findCostKindsSelectorRoute(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(costKindDao).findCostKindsBySelector(isA(GenericSelector.class));
    assertTrue(actualFindCostKindsSelectorRouteResult.isEmpty());
  }

  /**
   * Test {@link CostKindService#findCostKindsSelectorRoute(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link CostKindService#findCostKindsSelectorRoute(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findCostKindsSelectorRoute(EntityKind, IdSelectionOptions); given 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set CostKindService.findCostKindsSelectorRoute(EntityKind, IdSelectionOptions)"
  })
  void testFindCostKindsSelectorRoute_givenInHouse() {
    // Arrange
    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findCostKindsBySelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    CostKindService costKindService = new CostKindService(costKindDao);

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
    Set<CostKindWithYears> actualFindCostKindsSelectorRouteResult =
        costKindService.findCostKindsSelectorRoute(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(costKindDao).findCostKindsBySelector(isA(GenericSelector.class));
    assertTrue(actualFindCostKindsSelectorRouteResult.isEmpty());
  }

  /**
   * Test {@link CostKindService#findCostKindsSelectorRoute(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link CostKindService#findCostKindsSelectorRoute(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findCostKindsSelectorRoute(EntityKind, IdSelectionOptions); given 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set CostKindService.findCostKindsSelectorRoute(EntityKind, IdSelectionOptions)"
  })
  void testFindCostKindsSelectorRoute_givenPending() {
    // Arrange
    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findCostKindsBySelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    CostKindService costKindService = new CostKindService(costKindDao);

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
    Set<CostKindWithYears> actualFindCostKindsSelectorRouteResult =
        costKindService.findCostKindsSelectorRoute(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(costKindDao).findCostKindsBySelector(isA(GenericSelector.class));
    assertTrue(actualFindCostKindsSelectorRouteResult.isEmpty());
  }

  /**
   * Test {@link CostKindService#findCostKindsSelectorRoute(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link CostKindService#findCostKindsSelectorRoute(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findCostKindsSelectorRoute(EntityKind, IdSelectionOptions); given 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set CostKindService.findCostKindsSelectorRoute(EntityKind, IdSelectionOptions)"
  })
  void testFindCostKindsSelectorRoute_givenPending2() {
    // Arrange
    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findCostKindsBySelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    CostKindService costKindService = new CostKindService(costKindDao);

    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.PENDING);

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.APP_GROUP)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Set<CostKindWithYears> actualFindCostKindsSelectorRouteResult =
        costKindService.findCostKindsSelectorRoute(
            EntityKind.APPLICATION,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(costKindDao).findCostKindsBySelector(isA(GenericSelector.class));
    assertTrue(actualFindCostKindsSelectorRouteResult.isEmpty());
  }
}
