package org.finos.waltz.service.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.GenericSelector;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.assessment_definition.AssessmentDefinitionDao;
import org.finos.waltz.data.assessment_rating.AssessmentRatingDao;
import org.finos.waltz.data.measurable.MeasurableDao;
import org.finos.waltz.data.measurable_category.MeasurableCategoryDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.rating_scheme.RatingSchemeDAO;
import org.finos.waltz.model.Cardinality;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.ApplicationsView;
import org.finos.waltz.model.application.AssessmentsView;
import org.finos.waltz.model.application.ImmutableApplication;
import org.finos.waltz.model.application.ImmutableApplicationsView;
import org.finos.waltz.model.application.ImmutableAssessmentsView;
import org.finos.waltz.model.application.ImmutableMeasurableRatingsView;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.application.MeasurableRatingsView;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_definition.AssessmentVisibility;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentDefinition;
import org.finos.waltz.model.assessment_rating.AssessmentRating;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentRating;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.measurable.ImmutableMeasurable;
import org.finos.waltz.model.measurable.Measurable;
import org.finos.waltz.model.measurable_category.ImmutableMeasurableCategory;
import org.finos.waltz.model.measurable_category.MeasurableCategory;
import org.finos.waltz.model.measurable_rating.ImmutableMeasurableRating;
import org.finos.waltz.model.measurable_rating.MeasurableRating;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.rating.RagRating;
import org.finos.waltz.model.rating.RatingSchemeItem;
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
class ApplicationViewServiceDiffblueTest {
  @Mock private ApplicationDao applicationDao;

  @InjectMocks private ApplicationViewService applicationViewService;

  @Mock private AssessmentDefinitionDao assessmentDefinitionDao;

  @Mock private AssessmentRatingDao assessmentRatingDao;

  @Mock private MeasurableCategoryDao measurableCategoryDao;

  @Mock private MeasurableDao measurableDao;

  @Mock private MeasurableRatingDao measurableRatingDao;

  @Mock private RatingSchemeDAO ratingSchemeDAO;

  /**
   * Test {@link ApplicationViewService#getViewBySelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ApplicationViewService#getViewBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getViewBySelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationsView ApplicationViewService.getViewBySelector(IdSelectionOptions)"
  })
  void testGetViewBySelector() {
    // Arrange
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentRatingDao.findBySelectorForDefinitions(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryDao.findAll()).thenReturn(new ArrayList<>());
    when(measurableRatingDao.findPrimaryRatingsForGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
    ApplicationsView actualViewBySelector =
        applicationViewService.getViewBySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(eq(EntityKind.APPLICATION), isA(Optional.class));
    verify(assessmentRatingDao)
        .findBySelectorForDefinitions(isA(GenericSelector.class), isA(Set.class));
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(measurableCategoryDao).findAll();
    verify(measurableRatingDao).findPrimaryRatingsForGenericSelector(isA(GenericSelector.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForSchemeIds(isA(Set.class));
    assertTrue(actualViewBySelector instanceof ImmutableApplicationsView);
    assertTrue(actualViewBySelector.primaryAssessments() instanceof ImmutableAssessmentsView);
    assertTrue(actualViewBySelector.primaryRatings() instanceof ImmutableMeasurableRatingsView);
  }

  /**
   * Test {@link ApplicationViewService#getViewBySelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ApplicationViewService#getViewBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getViewBySelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationsView ApplicationViewService.getViewBySelector(IdSelectionOptions)"
  })
  void testGetViewBySelector2() {
    // Arrange
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentRatingDao.findBySelectorForDefinitions(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryDao.findAll()).thenReturn(new ArrayList<>());
    when(measurableRatingDao.findPrimaryRatingsForGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
    ApplicationsView actualViewBySelector =
        applicationViewService.getViewBySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(eq(EntityKind.APPLICATION), isA(Optional.class));
    verify(assessmentRatingDao)
        .findBySelectorForDefinitions(isA(GenericSelector.class), isA(Set.class));
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(measurableCategoryDao).findAll();
    verify(measurableRatingDao).findPrimaryRatingsForGenericSelector(isA(GenericSelector.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForSchemeIds(isA(Set.class));
    assertTrue(actualViewBySelector instanceof ImmutableApplicationsView);
    assertTrue(actualViewBySelector.primaryAssessments() instanceof ImmutableAssessmentsView);
    assertTrue(actualViewBySelector.primaryRatings() instanceof ImmutableMeasurableRatingsView);
  }

  /**
   * Test {@link ApplicationViewService#getViewBySelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ApplicationViewService#getViewBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getViewBySelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationsView ApplicationViewService.getViewBySelector(IdSelectionOptions)"
  })
  void testGetViewBySelector3() {
    // Arrange
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentRatingDao.findBySelectorForDefinitions(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryDao.findAll()).thenReturn(new ArrayList<>());
    when(measurableRatingDao.findPrimaryRatingsForGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
    ApplicationsView actualViewBySelector =
        applicationViewService.getViewBySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(eq(EntityKind.APPLICATION), isA(Optional.class));
    verify(assessmentRatingDao)
        .findBySelectorForDefinitions(isA(GenericSelector.class), isA(Set.class));
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(measurableCategoryDao).findAll();
    verify(measurableRatingDao).findPrimaryRatingsForGenericSelector(isA(GenericSelector.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForSchemeIds(isA(Set.class));
    assertTrue(actualViewBySelector instanceof ImmutableApplicationsView);
    assertTrue(actualViewBySelector.primaryAssessments() instanceof ImmutableAssessmentsView);
    assertTrue(actualViewBySelector.primaryRatings() instanceof ImmutableMeasurableRatingsView);
  }

  /**
   * Test {@link ApplicationViewService#getViewBySelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ApplicationViewService#getViewBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getViewBySelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationsView ApplicationViewService.getViewBySelector(IdSelectionOptions)"
  })
  void testGetViewBySelector4() {
    // Arrange
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentRatingDao.findBySelectorForDefinitions(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryDao.findAll()).thenReturn(new ArrayList<>());
    when(measurableRatingDao.findPrimaryRatingsForGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
    ApplicationsView actualViewBySelector =
        applicationViewService.getViewBySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(eq(EntityKind.APPLICATION), isA(Optional.class));
    verify(assessmentRatingDao)
        .findBySelectorForDefinitions(isA(GenericSelector.class), isA(Set.class));
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(measurableCategoryDao).findAll();
    verify(measurableRatingDao).findPrimaryRatingsForGenericSelector(isA(GenericSelector.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForSchemeIds(isA(Set.class));
    assertTrue(actualViewBySelector instanceof ImmutableApplicationsView);
    assertTrue(actualViewBySelector.primaryAssessments() instanceof ImmutableAssessmentsView);
    assertTrue(actualViewBySelector.primaryRatings() instanceof ImmutableMeasurableRatingsView);
  }

  /**
   * Test {@link ApplicationViewService#getViewBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   *   <li>When builder addEntityLifecycleStatuses {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationViewService#getViewBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getViewBySelector(IdSelectionOptions); given 'ACTIVE'; when builder addEntityLifecycleStatuses 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationsView ApplicationViewService.getViewBySelector(IdSelectionOptions)"
  })
  void testGetViewBySelector_givenActive_whenBuilderAddEntityLifecycleStatusesActive() {
    // Arrange
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentRatingDao.findBySelectorForDefinitions(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryDao.findAll()).thenReturn(new ArrayList<>());
    when(measurableRatingDao.findPrimaryRatingsForGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
    ApplicationsView actualViewBySelector =
        applicationViewService.getViewBySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(eq(EntityKind.APPLICATION), isA(Optional.class));
    verify(assessmentRatingDao)
        .findBySelectorForDefinitions(isA(GenericSelector.class), isA(Set.class));
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(measurableCategoryDao).findAll();
    verify(measurableRatingDao).findPrimaryRatingsForGenericSelector(isA(GenericSelector.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForSchemeIds(isA(Set.class));
    assertTrue(actualViewBySelector instanceof ImmutableApplicationsView);
    assertTrue(actualViewBySelector.primaryAssessments() instanceof ImmutableAssessmentsView);
    assertTrue(actualViewBySelector.primaryRatings() instanceof ImmutableMeasurableRatingsView);
  }

  /**
   * Test {@link ApplicationViewService#getViewBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   *   <li>When builder addOmitApplicationKinds {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationViewService#getViewBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getViewBySelector(IdSelectionOptions); given 'IN_HOUSE'; when builder addOmitApplicationKinds 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationsView ApplicationViewService.getViewBySelector(IdSelectionOptions)"
  })
  void testGetViewBySelector_givenInHouse_whenBuilderAddOmitApplicationKindsInHouse() {
    // Arrange
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentRatingDao.findBySelectorForDefinitions(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryDao.findAll()).thenReturn(new ArrayList<>());
    when(measurableRatingDao.findPrimaryRatingsForGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
    ApplicationsView actualViewBySelector =
        applicationViewService.getViewBySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(eq(EntityKind.APPLICATION), isA(Optional.class));
    verify(assessmentRatingDao)
        .findBySelectorForDefinitions(isA(GenericSelector.class), isA(Set.class));
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(measurableCategoryDao).findAll();
    verify(measurableRatingDao).findPrimaryRatingsForGenericSelector(isA(GenericSelector.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForSchemeIds(isA(Set.class));
    assertTrue(actualViewBySelector instanceof ImmutableApplicationsView);
    assertTrue(actualViewBySelector.primaryAssessments() instanceof ImmutableAssessmentsView);
    assertTrue(actualViewBySelector.primaryRatings() instanceof ImmutableMeasurableRatingsView);
  }

  /**
   * Test {@link ApplicationViewService#getViewBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   *   <li>When builder addEntityLifecycleStatuses {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationViewService#getViewBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getViewBySelector(IdSelectionOptions); given 'PENDING'; when builder addEntityLifecycleStatuses 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationsView ApplicationViewService.getViewBySelector(IdSelectionOptions)"
  })
  void testGetViewBySelector_givenPending_whenBuilderAddEntityLifecycleStatusesPending() {
    // Arrange
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentRatingDao.findBySelectorForDefinitions(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryDao.findAll()).thenReturn(new ArrayList<>());
    when(measurableRatingDao.findPrimaryRatingsForGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
    ApplicationsView actualViewBySelector =
        applicationViewService.getViewBySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(eq(EntityKind.APPLICATION), isA(Optional.class));
    verify(assessmentRatingDao)
        .findBySelectorForDefinitions(isA(GenericSelector.class), isA(Set.class));
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(measurableCategoryDao).findAll();
    verify(measurableRatingDao).findPrimaryRatingsForGenericSelector(isA(GenericSelector.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForSchemeIds(isA(Set.class));
    assertTrue(actualViewBySelector instanceof ImmutableApplicationsView);
    assertTrue(actualViewBySelector.primaryAssessments() instanceof ImmutableAssessmentsView);
    assertTrue(actualViewBySelector.primaryRatings() instanceof ImmutableMeasurableRatingsView);
  }

  /**
   * Test {@link ApplicationViewService#getViewBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return applications size is one.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationViewService#getViewBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getViewBySelector(IdSelectionOptions); then return applications size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationsView ApplicationViewService.getViewBySelector(IdSelectionOptions)"
  })
  void testGetViewBySelector_thenReturnApplicationsSizeIsOne() {
    // Arrange
    ArrayList<Application> applicationList = new ArrayList<>();

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    applicationList.add(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(applicationList);
    when(assessmentRatingDao.findBySelectorForDefinitions(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryDao.findAll()).thenReturn(new ArrayList<>());
    when(measurableRatingDao.findPrimaryRatingsForGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
    ApplicationsView actualViewBySelector =
        applicationViewService.getViewBySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(eq(EntityKind.APPLICATION), isA(Optional.class));
    verify(assessmentRatingDao)
        .findBySelectorForDefinitions(isA(GenericSelector.class), isA(Set.class));
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(measurableCategoryDao).findAll();
    verify(measurableRatingDao).findPrimaryRatingsForGenericSelector(isA(GenericSelector.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForSchemeIds(isA(Set.class));
    assertTrue(actualViewBySelector instanceof ImmutableApplicationsView);
    AssessmentsView primaryAssessmentsResult = actualViewBySelector.primaryAssessments();
    assertTrue(primaryAssessmentsResult instanceof ImmutableAssessmentsView);
    MeasurableRatingsView primaryRatingsResult = actualViewBySelector.primaryRatings();
    assertTrue(primaryRatingsResult instanceof ImmutableMeasurableRatingsView);
    assertEquals(1, actualViewBySelector.applications().size());
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        primaryAssessmentsResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, primaryAssessmentsResult.assessmentRatings());
    assertSame(assessmentDefinitionsResult, primaryAssessmentsResult.ratingSchemeItems());
    assertSame(assessmentDefinitionsResult, primaryRatingsResult.measurableCategories());
    assertSame(assessmentDefinitionsResult, primaryRatingsResult.measurableHierarchy());
    assertSame(assessmentDefinitionsResult, primaryRatingsResult.measurableRatings());
    assertSame(assessmentDefinitionsResult, primaryRatingsResult.measurables());
    assertSame(assessmentDefinitionsResult, primaryRatingsResult.ratingSchemeItems());
  }

  /**
   * Test {@link ApplicationViewService#getViewBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return applications size is one.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationViewService#getViewBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getViewBySelector(IdSelectionOptions); then return applications size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationsView ApplicationViewService.getViewBySelector(IdSelectionOptions)"
  })
  void testGetViewBySelector_thenReturnApplicationsSizeIsOne2() {
    // Arrange
    ArrayList<Application> applicationList = new ArrayList<>();

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    applicationList.add(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());

    ImmutableApplication.Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));
    applicationList.add(
        overallRatingResult2
            .parentAssetCode(parentAssetCode2)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(applicationList);
    when(assessmentRatingDao.findBySelectorForDefinitions(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryDao.findAll()).thenReturn(new ArrayList<>());
    when(measurableRatingDao.findPrimaryRatingsForGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
    ApplicationsView actualViewBySelector =
        applicationViewService.getViewBySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(eq(EntityKind.APPLICATION), isA(Optional.class));
    verify(assessmentRatingDao)
        .findBySelectorForDefinitions(isA(GenericSelector.class), isA(Set.class));
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(measurableCategoryDao).findAll();
    verify(measurableRatingDao).findPrimaryRatingsForGenericSelector(isA(GenericSelector.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForSchemeIds(isA(Set.class));
    assertTrue(actualViewBySelector instanceof ImmutableApplicationsView);
    AssessmentsView primaryAssessmentsResult = actualViewBySelector.primaryAssessments();
    assertTrue(primaryAssessmentsResult instanceof ImmutableAssessmentsView);
    MeasurableRatingsView primaryRatingsResult = actualViewBySelector.primaryRatings();
    assertTrue(primaryRatingsResult instanceof ImmutableMeasurableRatingsView);
    assertEquals(1, actualViewBySelector.applications().size());
    Set<AssessmentDefinition> assessmentDefinitionsResult =
        primaryAssessmentsResult.assessmentDefinitions();
    assertTrue(assessmentDefinitionsResult.isEmpty());
    assertSame(assessmentDefinitionsResult, primaryAssessmentsResult.assessmentRatings());
    assertSame(assessmentDefinitionsResult, primaryAssessmentsResult.ratingSchemeItems());
    assertSame(assessmentDefinitionsResult, primaryRatingsResult.measurableCategories());
    assertSame(assessmentDefinitionsResult, primaryRatingsResult.measurableHierarchy());
    assertSame(assessmentDefinitionsResult, primaryRatingsResult.measurableRatings());
    assertSame(assessmentDefinitionsResult, primaryRatingsResult.measurables());
    assertSame(assessmentDefinitionsResult, primaryRatingsResult.ratingSchemeItems());
  }

  /**
   * Test {@link ApplicationViewService#getViewBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return primaryAssessments assessmentDefinitions size is one.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationViewService#getViewBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getViewBySelector(IdSelectionOptions); then return primaryAssessments assessmentDefinitions size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationsView ApplicationViewService.getViewBySelector(IdSelectionOptions)"
  })
  void testGetViewBySelector_thenReturnPrimaryAssessmentsAssessmentDefinitionsSizeIsOne() {
    // Arrange
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentRatingDao.findBySelectorForDefinitions(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();

    ImmutableAssessmentDefinition.Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    assessmentDefinitionSet.add(
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build());
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(assessmentDefinitionSet);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryDao.findAll()).thenReturn(new ArrayList<>());
    when(measurableRatingDao.findPrimaryRatingsForGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
    ApplicationsView actualViewBySelector =
        applicationViewService.getViewBySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(eq(EntityKind.APPLICATION), isA(Optional.class));
    verify(assessmentRatingDao)
        .findBySelectorForDefinitions(isA(GenericSelector.class), isA(Set.class));
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(measurableCategoryDao).findAll();
    verify(measurableRatingDao).findPrimaryRatingsForGenericSelector(isA(GenericSelector.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForSchemeIds(isA(Set.class));
    assertTrue(actualViewBySelector instanceof ImmutableApplicationsView);
    AssessmentsView primaryAssessmentsResult = actualViewBySelector.primaryAssessments();
    assertTrue(primaryAssessmentsResult instanceof ImmutableAssessmentsView);
    assertTrue(actualViewBySelector.primaryRatings() instanceof ImmutableMeasurableRatingsView);
    assertEquals(1, primaryAssessmentsResult.assessmentDefinitions().size());
  }

  /**
   * Test {@link ApplicationViewService#getViewBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return primaryAssessments assessmentRatings size is one.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationViewService#getViewBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getViewBySelector(IdSelectionOptions); then return primaryAssessments assessmentRatings size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationsView ApplicationViewService.getViewBySelector(IdSelectionOptions)"
  })
  void testGetViewBySelector_thenReturnPrimaryAssessmentsAssessmentRatingsSizeIsOne() {
    // Arrange
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    HashSet<AssessmentRating> assessmentRatingSet = new HashSet<>();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatingSet.add(
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());
    when(assessmentRatingDao.findBySelectorForDefinitions(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(assessmentRatingSet);
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryDao.findAll()).thenReturn(new ArrayList<>());
    when(measurableRatingDao.findPrimaryRatingsForGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
    ApplicationsView actualViewBySelector =
        applicationViewService.getViewBySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(eq(EntityKind.APPLICATION), isA(Optional.class));
    verify(assessmentRatingDao)
        .findBySelectorForDefinitions(isA(GenericSelector.class), isA(Set.class));
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(measurableCategoryDao).findAll();
    verify(measurableRatingDao).findPrimaryRatingsForGenericSelector(isA(GenericSelector.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForSchemeIds(isA(Set.class));
    assertTrue(actualViewBySelector instanceof ImmutableApplicationsView);
    AssessmentsView primaryAssessmentsResult = actualViewBySelector.primaryAssessments();
    assertTrue(primaryAssessmentsResult instanceof ImmutableAssessmentsView);
    assertTrue(actualViewBySelector.primaryRatings() instanceof ImmutableMeasurableRatingsView);
    assertEquals(1, primaryAssessmentsResult.assessmentRatings().size());
  }

  /**
   * Test {@link ApplicationViewService#getViewBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return primaryAssessments ratingSchemeItemsById size is one.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationViewService#getViewBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getViewBySelector(IdSelectionOptions); then return primaryAssessments ratingSchemeItemsById size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationsView ApplicationViewService.getViewBySelector(IdSelectionOptions)"
  })
  void testGetViewBySelector_thenReturnPrimaryAssessmentsRatingSchemeItemsByIdSizeIsOne() {
    // Arrange
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentRatingDao.findBySelectorForDefinitions(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());

    HashSet<RatingSchemeItem> ratingSchemeItemSet = new HashSet<>();
    ratingSchemeItemSet.add(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(ratingSchemeItemSet);
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryDao.findAll()).thenReturn(new ArrayList<>());
    when(measurableRatingDao.findPrimaryRatingsForGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
    ApplicationsView actualViewBySelector =
        applicationViewService.getViewBySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(eq(EntityKind.APPLICATION), isA(Optional.class));
    verify(assessmentRatingDao)
        .findBySelectorForDefinitions(isA(GenericSelector.class), isA(Set.class));
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(measurableCategoryDao).findAll();
    verify(measurableRatingDao).findPrimaryRatingsForGenericSelector(isA(GenericSelector.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForSchemeIds(isA(Set.class));
    assertTrue(actualViewBySelector instanceof ImmutableApplicationsView);
    AssessmentsView primaryAssessmentsResult = actualViewBySelector.primaryAssessments();
    assertTrue(primaryAssessmentsResult instanceof ImmutableAssessmentsView);
    Map<Long, RatingSchemeItem> ratingSchemeItemsByIdResult =
        primaryAssessmentsResult.ratingSchemeItemsById();
    assertEquals(1, ratingSchemeItemsByIdResult.size());
    RatingSchemeItem getResult = ratingSchemeItemsByIdResult.get(1L);
    assertTrue(getResult instanceof ImmutableRatingSchemeItem);
    assertEquals("Color", getResult.color());
    assertEquals("Name", getResult.name());
    assertEquals("Rating Group", getResult.ratingGroup());
    assertEquals("Rating", getResult.rating());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(0, getResult.position());
    assertEquals(1, primaryAssessmentsResult.ratingSchemeItems().size());
    assertEquals(1L, getResult.ratingSchemeId());
    assertFalse(getResult.isRestricted());
    assertFalse(getResult.requiresComment());
    assertTrue(getResult.userSelectable());
  }

  /**
   * Test {@link ApplicationViewService#getViewBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return primaryRatings measurableCategories size is one.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationViewService#getViewBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getViewBySelector(IdSelectionOptions); then return primaryRatings measurableCategories size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationsView ApplicationViewService.getViewBySelector(IdSelectionOptions)"
  })
  void testGetViewBySelector_thenReturnPrimaryRatingsMeasurableCategoriesSizeIsOne() {
    // Arrange
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentRatingDao.findBySelectorForDefinitions(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    ArrayList<MeasurableCategory> measurableCategoryList = new ArrayList<>();
    measurableCategoryList.add(
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build());
    when(measurableCategoryDao.findAll()).thenReturn(measurableCategoryList);
    when(measurableRatingDao.findPrimaryRatingsForGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
    ApplicationsView actualViewBySelector =
        applicationViewService.getViewBySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(eq(EntityKind.APPLICATION), isA(Optional.class));
    verify(assessmentRatingDao)
        .findBySelectorForDefinitions(isA(GenericSelector.class), isA(Set.class));
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(measurableCategoryDao).findAll();
    verify(measurableRatingDao).findPrimaryRatingsForGenericSelector(isA(GenericSelector.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForSchemeIds(isA(Set.class));
    assertTrue(actualViewBySelector instanceof ImmutableApplicationsView);
    assertTrue(actualViewBySelector.primaryAssessments() instanceof ImmutableAssessmentsView);
    MeasurableRatingsView primaryRatingsResult = actualViewBySelector.primaryRatings();
    assertTrue(primaryRatingsResult instanceof ImmutableMeasurableRatingsView);
    assertEquals(1, primaryRatingsResult.measurableCategories().size());
  }

  /**
   * Test {@link ApplicationViewService#getViewBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return primaryRatings measurableCategories size is one.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationViewService#getViewBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getViewBySelector(IdSelectionOptions); then return primaryRatings measurableCategories size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationsView ApplicationViewService.getViewBySelector(IdSelectionOptions)"
  })
  void testGetViewBySelector_thenReturnPrimaryRatingsMeasurableCategoriesSizeIsOne2() {
    // Arrange
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentRatingDao.findBySelectorForDefinitions(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    ArrayList<MeasurableCategory> measurableCategoryList = new ArrayList<>();
    measurableCategoryList.add(
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build());
    measurableCategoryList.add(
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build());
    when(measurableCategoryDao.findAll()).thenReturn(measurableCategoryList);
    when(measurableRatingDao.findPrimaryRatingsForGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
    ApplicationsView actualViewBySelector =
        applicationViewService.getViewBySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(eq(EntityKind.APPLICATION), isA(Optional.class));
    verify(assessmentRatingDao)
        .findBySelectorForDefinitions(isA(GenericSelector.class), isA(Set.class));
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(measurableCategoryDao).findAll();
    verify(measurableRatingDao).findPrimaryRatingsForGenericSelector(isA(GenericSelector.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForSchemeIds(isA(Set.class));
    assertTrue(actualViewBySelector instanceof ImmutableApplicationsView);
    assertTrue(actualViewBySelector.primaryAssessments() instanceof ImmutableAssessmentsView);
    MeasurableRatingsView primaryRatingsResult = actualViewBySelector.primaryRatings();
    assertTrue(primaryRatingsResult instanceof ImmutableMeasurableRatingsView);
    assertEquals(1, primaryRatingsResult.measurableCategories().size());
  }

  /**
   * Test {@link ApplicationViewService#getViewBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return primaryRatings measurableRatings size is one.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationViewService#getViewBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getViewBySelector(IdSelectionOptions); then return primaryRatings measurableRatings size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationsView ApplicationViewService.getViewBySelector(IdSelectionOptions)"
  })
  void testGetViewBySelector_thenReturnPrimaryRatingsMeasurableRatingsSizeIsOne() {
    // Arrange
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentRatingDao.findBySelectorForDefinitions(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryDao.findAll()).thenReturn(new ArrayList<>());

    HashSet<MeasurableRating> measurableRatingSet = new HashSet<>();

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    measurableRatingSet.add(
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableId(1L)
            .provenance("Provenance")
            .rating('A')
            .ratingId(1L)
            .build());
    when(measurableRatingDao.findPrimaryRatingsForGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(measurableRatingSet);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
    ApplicationsView actualViewBySelector =
        applicationViewService.getViewBySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(eq(EntityKind.APPLICATION), isA(Optional.class));
    verify(assessmentRatingDao)
        .findBySelectorForDefinitions(isA(GenericSelector.class), isA(Set.class));
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(measurableCategoryDao).findAll();
    verify(measurableRatingDao).findPrimaryRatingsForGenericSelector(isA(GenericSelector.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForSchemeIds(isA(Set.class));
    assertTrue(actualViewBySelector instanceof ImmutableApplicationsView);
    MeasurableRatingsView primaryRatingsResult = actualViewBySelector.primaryRatings();
    assertTrue(primaryRatingsResult instanceof ImmutableMeasurableRatingsView);
    assertEquals(1, primaryRatingsResult.measurableRatings().size());
  }

  /**
   * Test {@link ApplicationViewService#getViewBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return primaryRatings measurables size is one.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationViewService#getViewBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getViewBySelector(IdSelectionOptions); then return primaryRatings measurables size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationsView ApplicationViewService.getViewBySelector(IdSelectionOptions)"
  })
  void testGetViewBySelector_thenReturnPrimaryRatingsMeasurablesSizeIsOne() {
    // Arrange
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentRatingDao.findBySelectorForDefinitions(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryDao.findAll()).thenReturn(new ArrayList<>());
    when(measurableRatingDao.findPrimaryRatingsForGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());

    ArrayList<Measurable> measurableList = new ArrayList<>();
    measurableList.add(
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(measurableList);

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
    ApplicationsView actualViewBySelector =
        applicationViewService.getViewBySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(eq(EntityKind.APPLICATION), isA(Optional.class));
    verify(assessmentRatingDao)
        .findBySelectorForDefinitions(isA(GenericSelector.class), isA(Set.class));
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(measurableCategoryDao).findAll();
    verify(measurableRatingDao).findPrimaryRatingsForGenericSelector(isA(GenericSelector.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForSchemeIds(isA(Set.class));
    assertTrue(actualViewBySelector instanceof ImmutableApplicationsView);
    assertTrue(actualViewBySelector.primaryAssessments() instanceof ImmutableAssessmentsView);
    MeasurableRatingsView primaryRatingsResult = actualViewBySelector.primaryRatings();
    assertTrue(primaryRatingsResult instanceof ImmutableMeasurableRatingsView);
    assertEquals(1, primaryRatingsResult.measurables().size());
  }

  /**
   * Test {@link ApplicationViewService#getViewBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return primaryRatings measurables size is one.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationViewService#getViewBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getViewBySelector(IdSelectionOptions); then return primaryRatings measurables size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationsView ApplicationViewService.getViewBySelector(IdSelectionOptions)"
  })
  void testGetViewBySelector_thenReturnPrimaryRatingsMeasurablesSizeIsOne2() {
    // Arrange
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentRatingDao.findBySelectorForDefinitions(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryDao.findAll()).thenReturn(new ArrayList<>());
    when(measurableRatingDao.findPrimaryRatingsForGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());

    ArrayList<Measurable> measurableList = new ArrayList<>();
    measurableList.add(
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build());
    measurableList.add(
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(measurableList);

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
    ApplicationsView actualViewBySelector =
        applicationViewService.getViewBySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(eq(EntityKind.APPLICATION), isA(Optional.class));
    verify(assessmentRatingDao)
        .findBySelectorForDefinitions(isA(GenericSelector.class), isA(Set.class));
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(measurableCategoryDao).findAll();
    verify(measurableRatingDao).findPrimaryRatingsForGenericSelector(isA(GenericSelector.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForSchemeIds(isA(Set.class));
    assertTrue(actualViewBySelector instanceof ImmutableApplicationsView);
    assertTrue(actualViewBySelector.primaryAssessments() instanceof ImmutableAssessmentsView);
    MeasurableRatingsView primaryRatingsResult = actualViewBySelector.primaryRatings();
    assertTrue(primaryRatingsResult instanceof ImmutableMeasurableRatingsView);
    assertEquals(1, primaryRatingsResult.measurables().size());
  }

  /**
   * Test {@link ApplicationViewService#getViewBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return primaryRatings ratingSchemeItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationViewService#getViewBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getViewBySelector(IdSelectionOptions); then return primaryRatings ratingSchemeItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationsView ApplicationViewService.getViewBySelector(IdSelectionOptions)"
  })
  void testGetViewBySelector_thenReturnPrimaryRatingsRatingSchemeItemsSizeIsOne() {
    // Arrange
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentRatingDao.findBySelectorForDefinitions(
            Mockito.<GenericSelector>any(), Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());

    HashSet<RatingSchemeItem> ratingSchemeItemSet = new HashSet<>();
    ratingSchemeItemSet.add(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(ratingSchemeItemSet);
    when(measurableCategoryDao.findAll()).thenReturn(new ArrayList<>());
    when(measurableRatingDao.findPrimaryRatingsForGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
    ApplicationsView actualViewBySelector =
        applicationViewService.getViewBySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(eq(EntityKind.APPLICATION), isA(Optional.class));
    verify(assessmentRatingDao)
        .findBySelectorForDefinitions(isA(GenericSelector.class), isA(Set.class));
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(measurableCategoryDao).findAll();
    verify(measurableRatingDao).findPrimaryRatingsForGenericSelector(isA(GenericSelector.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForSchemeIds(isA(Set.class));
    assertTrue(actualViewBySelector instanceof ImmutableApplicationsView);
    MeasurableRatingsView primaryRatingsResult = actualViewBySelector.primaryRatings();
    assertTrue(primaryRatingsResult instanceof ImmutableMeasurableRatingsView);
    assertEquals(1, primaryRatingsResult.ratingSchemeItems().size());
  }
}
