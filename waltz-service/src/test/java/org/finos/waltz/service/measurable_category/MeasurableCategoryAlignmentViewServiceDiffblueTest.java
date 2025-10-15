package org.finos.waltz.service.measurable_category;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.measurable_category.MeasurableCategoryAlignmentViewDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.measurable.MeasurableCategoryAlignment;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MeasurableCategoryAlignmentViewServiceDiffblueTest {
  @Mock private MeasurableCategoryAlignmentViewDao measurableCategoryAlignmentViewDao;

  @InjectMocks
  private MeasurableCategoryAlignmentViewService measurableCategoryAlignmentViewService;

  /**
   * Test {@link
   * MeasurableCategoryAlignmentViewService#findAlignmentsByAppSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * MeasurableCategoryAlignmentViewService#findAlignmentsByAppSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findAlignmentsByAppSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableCategoryAlignmentViewService.findAlignmentsByAppSelector(IdSelectionOptions)"
  })
  void testFindAlignmentsByAppSelector() {
    // Arrange
    when(measurableCategoryAlignmentViewDao.findAlignmentsByAppSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

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
    Set<MeasurableCategoryAlignment> actualFindAlignmentsByAppSelectorResult =
        measurableCategoryAlignmentViewService.findAlignmentsByAppSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(measurableCategoryAlignmentViewDao).findAlignmentsByAppSelector(isA(Select.class));
    assertTrue(actualFindAlignmentsByAppSelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * MeasurableCategoryAlignmentViewService#findAlignmentsByAppSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * MeasurableCategoryAlignmentViewService#findAlignmentsByAppSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findAlignmentsByAppSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableCategoryAlignmentViewService.findAlignmentsByAppSelector(IdSelectionOptions)"
  })
  void testFindAlignmentsByAppSelector2() {
    // Arrange
    when(measurableCategoryAlignmentViewDao.findAlignmentsByAppSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

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
    Set<MeasurableCategoryAlignment> actualFindAlignmentsByAppSelectorResult =
        measurableCategoryAlignmentViewService.findAlignmentsByAppSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(measurableCategoryAlignmentViewDao).findAlignmentsByAppSelector(isA(Select.class));
    assertTrue(actualFindAlignmentsByAppSelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * MeasurableCategoryAlignmentViewService#findAlignmentsByAppSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * MeasurableCategoryAlignmentViewService#findAlignmentsByAppSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findAlignmentsByAppSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableCategoryAlignmentViewService.findAlignmentsByAppSelector(IdSelectionOptions)"
  })
  void testFindAlignmentsByAppSelector3() {
    // Arrange
    when(measurableCategoryAlignmentViewDao.findAlignmentsByAppSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

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
    Set<MeasurableCategoryAlignment> actualFindAlignmentsByAppSelectorResult =
        measurableCategoryAlignmentViewService.findAlignmentsByAppSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(measurableCategoryAlignmentViewDao).findAlignmentsByAppSelector(isA(Select.class));
    assertTrue(actualFindAlignmentsByAppSelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * MeasurableCategoryAlignmentViewService#findAlignmentsByAppSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * MeasurableCategoryAlignmentViewService#findAlignmentsByAppSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findAlignmentsByAppSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableCategoryAlignmentViewService.findAlignmentsByAppSelector(IdSelectionOptions)"
  })
  void testFindAlignmentsByAppSelector4() {
    // Arrange
    when(measurableCategoryAlignmentViewDao.findAlignmentsByAppSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

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
    Set<MeasurableCategoryAlignment> actualFindAlignmentsByAppSelectorResult =
        measurableCategoryAlignmentViewService.findAlignmentsByAppSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(measurableCategoryAlignmentViewDao).findAlignmentsByAppSelector(isA(Select.class));
    assertTrue(actualFindAlignmentsByAppSelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * MeasurableCategoryAlignmentViewService#findAlignmentsByAppSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableCategoryAlignmentViewService#findAlignmentsByAppSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findAlignmentsByAppSelector(IdSelectionOptions); given 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableCategoryAlignmentViewService.findAlignmentsByAppSelector(IdSelectionOptions)"
  })
  void testFindAlignmentsByAppSelector_givenActive() {
    // Arrange
    when(measurableCategoryAlignmentViewDao.findAlignmentsByAppSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

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
    Set<MeasurableCategoryAlignment> actualFindAlignmentsByAppSelectorResult =
        measurableCategoryAlignmentViewService.findAlignmentsByAppSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(measurableCategoryAlignmentViewDao).findAlignmentsByAppSelector(isA(Select.class));
    assertTrue(actualFindAlignmentsByAppSelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * MeasurableCategoryAlignmentViewService#findAlignmentsByAppSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableCategoryAlignmentViewService#findAlignmentsByAppSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findAlignmentsByAppSelector(IdSelectionOptions); given 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableCategoryAlignmentViewService.findAlignmentsByAppSelector(IdSelectionOptions)"
  })
  void testFindAlignmentsByAppSelector_givenInHouse() {
    // Arrange
    when(measurableCategoryAlignmentViewDao.findAlignmentsByAppSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

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
    Set<MeasurableCategoryAlignment> actualFindAlignmentsByAppSelectorResult =
        measurableCategoryAlignmentViewService.findAlignmentsByAppSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(measurableCategoryAlignmentViewDao).findAlignmentsByAppSelector(isA(Select.class));
    assertTrue(actualFindAlignmentsByAppSelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * MeasurableCategoryAlignmentViewService#findAlignmentsByAppSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableCategoryAlignmentViewService#findAlignmentsByAppSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findAlignmentsByAppSelector(IdSelectionOptions); given 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set MeasurableCategoryAlignmentViewService.findAlignmentsByAppSelector(IdSelectionOptions)"
  })
  void testFindAlignmentsByAppSelector_givenPending() {
    // Arrange
    when(measurableCategoryAlignmentViewDao.findAlignmentsByAppSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

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
    Set<MeasurableCategoryAlignment> actualFindAlignmentsByAppSelectorResult =
        measurableCategoryAlignmentViewService.findAlignmentsByAppSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(measurableCategoryAlignmentViewDao).findAlignmentsByAppSelector(isA(Select.class));
    assertTrue(actualFindAlignmentsByAppSelectorResult.isEmpty());
  }
}
