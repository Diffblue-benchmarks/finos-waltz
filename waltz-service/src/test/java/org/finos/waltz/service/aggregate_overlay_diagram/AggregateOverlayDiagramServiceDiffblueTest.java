package org.finos.waltz.service.aggregate_overlay_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.aggregate_overlay_diagram.AggregateOverlayDiagramDao;
import org.finos.waltz.data.aggregate_overlay_diagram.AggregateOverlayDiagramPresetDao;
import org.finos.waltz.data.aggregate_overlay_diagram.AggregatedEntitiesWidgetDao;
import org.finos.waltz.data.aggregate_overlay_diagram.AppChangesWidgetDao;
import org.finos.waltz.data.aggregate_overlay_diagram.AppCostWidgetDao;
import org.finos.waltz.data.aggregate_overlay_diagram.AppCountWidgetDao;
import org.finos.waltz.data.aggregate_overlay_diagram.AssessmentRatingWidgetDao;
import org.finos.waltz.data.aggregate_overlay_diagram.AttestationWidgetDao;
import org.finos.waltz.data.aggregate_overlay_diagram.BackingEntityWidgetDao;
import org.finos.waltz.data.aggregate_overlay_diagram.ComplexityWidgetDao;
import org.finos.waltz.data.aggregate_overlay_diagram.RatingCostWidgetDao;
import org.finos.waltz.data.aggregate_overlay_diagram.TargetAppCostWidgetDao;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.complexity.ComplexityKindDao;
import org.finos.waltz.data.cost.CostKindDao;
import org.finos.waltz.data.measurable.MeasurableDao;
import org.finos.waltz.model.AssessmentBasedSelectionFilter;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ReleaseLifecycleStatusChangeCommand;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.aggregate_overlay_diagram.AggregateOverlayDiagram;
import org.finos.waltz.model.aggregate_overlay_diagram.AggregateOverlayDiagramInfo;
import org.finos.waltz.model.aggregate_overlay_diagram.AggregateOverlayDiagramPreset;
import org.finos.waltz.model.aggregate_overlay_diagram.BackingEntity;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagramInfo;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramKind;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramPresetCreateCommand;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramSaveCommand;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.AggregatedEntitiesWidgetData;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.AggregatedEntitiesWidgetDatum;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ApplicationChangeWidgetData;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ApplicationChangeWidgetDatum;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.AssessmentRatingsWidgetData;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.AttestationWidgetData;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.BackingEntityWidgetData;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.BackingEntityWidgetDatum;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ComplexityWidgetData;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.CountWidgetData;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.CountWidgetDatum;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableAggregatedEntitiesWidgetData;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableApplicationChangeWidgetData;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableAssessmentRatingsWidgetData;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableAttestationWidgetData;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableBackingEntityWidgetData;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableComplexityWidgetData;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableCountWidgetData;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableTargetCostWidgetData;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.TargetCostWidgetData;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.TargetCostWidgetDatum;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.AppChangeWidgetParameters;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.AppComplexityWidgetParameters;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.AppCountWidgetParameters;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.AssessmentWidgetParameters;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.AttestationWidgetParameters;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.TargetAppCostWidgetParameters;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.application.ApplicationKind;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AggregateOverlayDiagramServiceDiffblueTest {
  /**
   * Method under test: {@link AggregateOverlayDiagramService#getById(Long)}
   */
  @Test
  void testGetById() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.findBackingEntities(Mockito.<Long>any())).thenReturn(new HashSet<>());
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any())).thenReturn(mock(AggregateOverlayDiagram.class));

    // Act
    AggregateOverlayDiagramInfo actualById = (new AggregateOverlayDiagramService(aggregateOverlayDiagramDao,
        mock(AppCountWidgetDao.class), mock(TargetAppCostWidgetDao.class), mock(RatingCostWidgetDao.class),
        mock(AssessmentRatingWidgetDao.class), mock(BackingEntityWidgetDao.class), mock(AppCostWidgetDao.class),
        mock(AggregatedEntitiesWidgetDao.class), mock(AppChangesWidgetDao.class),
        mock(AggregateOverlayDiagramPresetDao.class), mock(MeasurableDao.class), mock(ApplicationDao.class),
        mock(CostKindDao.class), mock(ComplexityKindDao.class), mock(ComplexityWidgetDao.class),
        mock(AttestationWidgetDao.class))).getById(1L);

    // Assert
    verify(aggregateOverlayDiagramDao).findBackingEntities(eq(1L));
    verify(aggregateOverlayDiagramDao).getById(eq(1L));
    assertTrue(actualById instanceof ImmutableAggregateOverlayDiagramInfo);
    assertTrue(actualById.backingEntities().isEmpty());
  }

  /**
   * Method under test: {@link AggregateOverlayDiagramService#getById(Long)}
   */
  @Test
  void testGetById2() {
    // Arrange
    HashSet<BackingEntity> backingEntitySet = new HashSet<>();
    backingEntitySet.add(mock(BackingEntity.class));
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.findBackingEntities(Mockito.<Long>any())).thenReturn(backingEntitySet);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any())).thenReturn(mock(AggregateOverlayDiagram.class));

    // Act
    AggregateOverlayDiagramInfo actualById = (new AggregateOverlayDiagramService(aggregateOverlayDiagramDao,
        mock(AppCountWidgetDao.class), mock(TargetAppCostWidgetDao.class), mock(RatingCostWidgetDao.class),
        mock(AssessmentRatingWidgetDao.class), mock(BackingEntityWidgetDao.class), mock(AppCostWidgetDao.class),
        mock(AggregatedEntitiesWidgetDao.class), mock(AppChangesWidgetDao.class),
        mock(AggregateOverlayDiagramPresetDao.class), mock(MeasurableDao.class), mock(ApplicationDao.class),
        mock(CostKindDao.class), mock(ComplexityKindDao.class), mock(ComplexityWidgetDao.class),
        mock(AttestationWidgetDao.class))).getById(1L);

    // Assert
    verify(aggregateOverlayDiagramDao).findBackingEntities(eq(1L));
    verify(aggregateOverlayDiagramDao).getById(eq(1L));
    assertTrue(actualById instanceof ImmutableAggregateOverlayDiagramInfo);
    assertEquals(1, actualById.backingEntities().size());
  }

  /**
   * Method under test: {@link AggregateOverlayDiagramService#getById(Long)}
   */
  @Test
  void testGetById3() {
    // Arrange
    HashSet<BackingEntity> backingEntitySet = new HashSet<>();
    backingEntitySet.add(mock(BackingEntity.class));
    backingEntitySet.add(mock(BackingEntity.class));
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.findBackingEntities(Mockito.<Long>any())).thenReturn(backingEntitySet);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any())).thenReturn(mock(AggregateOverlayDiagram.class));

    // Act
    AggregateOverlayDiagramInfo actualById = (new AggregateOverlayDiagramService(aggregateOverlayDiagramDao,
        mock(AppCountWidgetDao.class), mock(TargetAppCostWidgetDao.class), mock(RatingCostWidgetDao.class),
        mock(AssessmentRatingWidgetDao.class), mock(BackingEntityWidgetDao.class), mock(AppCostWidgetDao.class),
        mock(AggregatedEntitiesWidgetDao.class), mock(AppChangesWidgetDao.class),
        mock(AggregateOverlayDiagramPresetDao.class), mock(MeasurableDao.class), mock(ApplicationDao.class),
        mock(CostKindDao.class), mock(ComplexityKindDao.class), mock(ComplexityWidgetDao.class),
        mock(AttestationWidgetDao.class))).getById(1L);

    // Assert
    verify(aggregateOverlayDiagramDao).findBackingEntities(eq(1L));
    verify(aggregateOverlayDiagramDao).getById(eq(1L));
    assertTrue(actualById instanceof ImmutableAggregateOverlayDiagramInfo);
    assertEquals(backingEntitySet, actualById.backingEntities());
  }

  /**
   * Method under test: {@link AggregateOverlayDiagramService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    HashSet<AggregateOverlayDiagram> aggregateOverlayDiagramSet = new HashSet<>();
    when(aggregateOverlayDiagramDao.findAll()).thenReturn(aggregateOverlayDiagramSet);

    // Act
    Set<AggregateOverlayDiagram> actualFindAllResult = (new AggregateOverlayDiagramService(aggregateOverlayDiagramDao,
        mock(AppCountWidgetDao.class), mock(TargetAppCostWidgetDao.class), mock(RatingCostWidgetDao.class),
        mock(AssessmentRatingWidgetDao.class), mock(BackingEntityWidgetDao.class), mock(AppCostWidgetDao.class),
        mock(AggregatedEntitiesWidgetDao.class), mock(AppChangesWidgetDao.class),
        mock(AggregateOverlayDiagramPresetDao.class), mock(MeasurableDao.class), mock(ApplicationDao.class),
        mock(CostKindDao.class), mock(ComplexityKindDao.class), mock(ComplexityWidgetDao.class),
        mock(AttestationWidgetDao.class))).findAll();

    // Assert
    verify(aggregateOverlayDiagramDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(aggregateOverlayDiagramSet, actualFindAllResult);
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramService#findByKind(OverlayDiagramKind)}
   */
  @Test
  void testFindByKind() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    HashSet<AggregateOverlayDiagram> aggregateOverlayDiagramSet = new HashSet<>();
    when(aggregateOverlayDiagramDao.findByKind(Mockito.<OverlayDiagramKind>any()))
        .thenReturn(aggregateOverlayDiagramSet);

    // Act
    Set<AggregateOverlayDiagram> actualFindByKindResult = (new AggregateOverlayDiagramService(
        aggregateOverlayDiagramDao, mock(AppCountWidgetDao.class), mock(TargetAppCostWidgetDao.class),
        mock(RatingCostWidgetDao.class), mock(AssessmentRatingWidgetDao.class), mock(BackingEntityWidgetDao.class),
        mock(AppCostWidgetDao.class), mock(AggregatedEntitiesWidgetDao.class), mock(AppChangesWidgetDao.class),
        mock(AggregateOverlayDiagramPresetDao.class), mock(MeasurableDao.class), mock(ApplicationDao.class),
        mock(CostKindDao.class), mock(ComplexityKindDao.class), mock(ComplexityWidgetDao.class),
        mock(AttestationWidgetDao.class))).findByKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY);

    // Assert
    verify(aggregateOverlayDiagramDao).findByKind(eq(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY));
    assertTrue(actualFindByKindResult.isEmpty());
    assertSame(aggregateOverlayDiagramSet, actualFindByKindResult);
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramService#getAppCountWidgetData(Long, IdSelectionOptions, Set, AppCountWidgetParameters)}
   */
  @Test
  void testGetAppCountWidgetData() {
    // Arrange
    AggregateOverlayDiagram aggregateOverlayDiagram = mock(AggregateOverlayDiagram.class);
    when(aggregateOverlayDiagram.aggregatedEntityKind()).thenReturn(EntityKind.APPLICATION);
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any())).thenReturn(aggregateOverlayDiagram);
    AppCountWidgetDao appCountWidgetDao = mock(AppCountWidgetDao.class);
    when(appCountWidgetDao.findWidgetData(anyLong(), Mockito.<Select<Record1<Long>>>any(), Mockito.<LocalDate>any()))
        .thenReturn(new HashSet<>());
    AggregateOverlayDiagramService aggregateOverlayDiagramService = new AggregateOverlayDiagramService(
        aggregateOverlayDiagramDao, appCountWidgetDao, mock(TargetAppCostWidgetDao.class),
        mock(RatingCostWidgetDao.class), mock(AssessmentRatingWidgetDao.class), mock(BackingEntityWidgetDao.class),
        mock(AppCostWidgetDao.class), mock(AggregatedEntitiesWidgetDao.class), mock(AppChangesWidgetDao.class),
        mock(AggregateOverlayDiagramPresetDao.class), mock(MeasurableDao.class), mock(ApplicationDao.class),
        mock(CostKindDao.class), mock(ComplexityKindDao.class), mock(ComplexityWidgetDao.class),
        mock(AttestationWidgetDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions appSelectionOptions = mock(IdSelectionOptions.class);
    when(appSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(appSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(appSelectionOptions.filters()).thenReturn(selectionFilters);
    when(appSelectionOptions.entityReference()).thenReturn(entityReference);
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter.ratingIds()).thenReturn(new HashSet<>());
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter2 = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter2.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter2.ratingIds()).thenReturn(new HashSet<>());

    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();
    filterParams.add(assessmentBasedSelectionFilter2);
    filterParams.add(assessmentBasedSelectionFilter);
    AppCountWidgetParameters appCountWidgetParameters = mock(AppCountWidgetParameters.class);
    when(appCountWidgetParameters.targetDate()).thenReturn(LocalDate.of(1970, 1, 1));

    // Act
    CountWidgetData actualAppCountWidgetData = aggregateOverlayDiagramService.getAppCountWidgetData(1L,
        appSelectionOptions, filterParams, appCountWidgetParameters);

    // Assert
    verify(aggregateOverlayDiagramDao).getById(eq(1L));
    verify(appCountWidgetDao).findWidgetData(eq(1L), isA(Select.class), isA(LocalDate.class));
    verify(assessmentBasedSelectionFilter2).definitionId();
    verify(assessmentBasedSelectionFilter).definitionId();
    verify(assessmentBasedSelectionFilter2).ratingIds();
    verify(assessmentBasedSelectionFilter).ratingIds();
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(appSelectionOptions).entityLifecycleStatuses();
    verify(appSelectionOptions, atLeast(1)).entityReference();
    verify(appSelectionOptions).filters();
    verify(appSelectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    verify(aggregateOverlayDiagram).aggregatedEntityKind();
    verify(appCountWidgetParameters).targetDate();
    assertTrue(actualAppCountWidgetData instanceof ImmutableCountWidgetData);
    assertTrue(actualAppCountWidgetData.cellData().isEmpty());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramService#getAppCountWidgetData(Long, IdSelectionOptions, Set, AppCountWidgetParameters)}
   */
  @Test
  void testGetAppCountWidgetData2() {
    // Arrange
    AggregateOverlayDiagram aggregateOverlayDiagram = mock(AggregateOverlayDiagram.class);
    when(aggregateOverlayDiagram.aggregatedEntityKind()).thenReturn(EntityKind.APPLICATION);
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any())).thenReturn(aggregateOverlayDiagram);

    HashSet<CountWidgetDatum> countWidgetDatumSet = new HashSet<>();
    countWidgetDatumSet.add(mock(CountWidgetDatum.class));
    AppCountWidgetDao appCountWidgetDao = mock(AppCountWidgetDao.class);
    when(appCountWidgetDao.findWidgetData(anyLong(), Mockito.<Select<Record1<Long>>>any(), Mockito.<LocalDate>any()))
        .thenReturn(countWidgetDatumSet);
    AggregateOverlayDiagramService aggregateOverlayDiagramService = new AggregateOverlayDiagramService(
        aggregateOverlayDiagramDao, appCountWidgetDao, mock(TargetAppCostWidgetDao.class),
        mock(RatingCostWidgetDao.class), mock(AssessmentRatingWidgetDao.class), mock(BackingEntityWidgetDao.class),
        mock(AppCostWidgetDao.class), mock(AggregatedEntitiesWidgetDao.class), mock(AppChangesWidgetDao.class),
        mock(AggregateOverlayDiagramPresetDao.class), mock(MeasurableDao.class), mock(ApplicationDao.class),
        mock(CostKindDao.class), mock(ComplexityKindDao.class), mock(ComplexityWidgetDao.class),
        mock(AttestationWidgetDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions appSelectionOptions = mock(IdSelectionOptions.class);
    when(appSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(appSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(appSelectionOptions.filters()).thenReturn(selectionFilters);
    when(appSelectionOptions.entityReference()).thenReturn(entityReference);
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter.ratingIds()).thenReturn(new HashSet<>());
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter2 = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter2.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter2.ratingIds()).thenReturn(new HashSet<>());

    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();
    filterParams.add(assessmentBasedSelectionFilter2);
    filterParams.add(assessmentBasedSelectionFilter);
    AppCountWidgetParameters appCountWidgetParameters = mock(AppCountWidgetParameters.class);
    when(appCountWidgetParameters.targetDate()).thenReturn(LocalDate.of(1970, 1, 1));

    // Act
    CountWidgetData actualAppCountWidgetData = aggregateOverlayDiagramService.getAppCountWidgetData(1L,
        appSelectionOptions, filterParams, appCountWidgetParameters);

    // Assert
    verify(aggregateOverlayDiagramDao).getById(eq(1L));
    verify(appCountWidgetDao).findWidgetData(eq(1L), isA(Select.class), isA(LocalDate.class));
    verify(assessmentBasedSelectionFilter2).definitionId();
    verify(assessmentBasedSelectionFilter).definitionId();
    verify(assessmentBasedSelectionFilter2).ratingIds();
    verify(assessmentBasedSelectionFilter).ratingIds();
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(appSelectionOptions).entityLifecycleStatuses();
    verify(appSelectionOptions, atLeast(1)).entityReference();
    verify(appSelectionOptions).filters();
    verify(appSelectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    verify(aggregateOverlayDiagram).aggregatedEntityKind();
    verify(appCountWidgetParameters).targetDate();
    assertTrue(actualAppCountWidgetData instanceof ImmutableCountWidgetData);
    assertEquals(1, actualAppCountWidgetData.cellData().size());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramService#getAppCountWidgetData(Long, IdSelectionOptions, Set, AppCountWidgetParameters)}
   */
  @Test
  void testGetAppCountWidgetData3() {
    // Arrange
    AggregateOverlayDiagram aggregateOverlayDiagram = mock(AggregateOverlayDiagram.class);
    when(aggregateOverlayDiagram.aggregatedEntityKind()).thenReturn(EntityKind.APPLICATION);
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any())).thenReturn(aggregateOverlayDiagram);

    HashSet<CountWidgetDatum> countWidgetDatumSet = new HashSet<>();
    countWidgetDatumSet.add(mock(CountWidgetDatum.class));
    countWidgetDatumSet.add(mock(CountWidgetDatum.class));
    AppCountWidgetDao appCountWidgetDao = mock(AppCountWidgetDao.class);
    when(appCountWidgetDao.findWidgetData(anyLong(), Mockito.<Select<Record1<Long>>>any(), Mockito.<LocalDate>any()))
        .thenReturn(countWidgetDatumSet);
    AggregateOverlayDiagramService aggregateOverlayDiagramService = new AggregateOverlayDiagramService(
        aggregateOverlayDiagramDao, appCountWidgetDao, mock(TargetAppCostWidgetDao.class),
        mock(RatingCostWidgetDao.class), mock(AssessmentRatingWidgetDao.class), mock(BackingEntityWidgetDao.class),
        mock(AppCostWidgetDao.class), mock(AggregatedEntitiesWidgetDao.class), mock(AppChangesWidgetDao.class),
        mock(AggregateOverlayDiagramPresetDao.class), mock(MeasurableDao.class), mock(ApplicationDao.class),
        mock(CostKindDao.class), mock(ComplexityKindDao.class), mock(ComplexityWidgetDao.class),
        mock(AttestationWidgetDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions appSelectionOptions = mock(IdSelectionOptions.class);
    when(appSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(appSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(appSelectionOptions.filters()).thenReturn(selectionFilters);
    when(appSelectionOptions.entityReference()).thenReturn(entityReference);
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter.ratingIds()).thenReturn(new HashSet<>());
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter2 = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter2.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter2.ratingIds()).thenReturn(new HashSet<>());

    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();
    filterParams.add(assessmentBasedSelectionFilter2);
    filterParams.add(assessmentBasedSelectionFilter);
    AppCountWidgetParameters appCountWidgetParameters = mock(AppCountWidgetParameters.class);
    when(appCountWidgetParameters.targetDate()).thenReturn(LocalDate.of(1970, 1, 1));

    // Act
    CountWidgetData actualAppCountWidgetData = aggregateOverlayDiagramService.getAppCountWidgetData(1L,
        appSelectionOptions, filterParams, appCountWidgetParameters);

    // Assert
    verify(aggregateOverlayDiagramDao).getById(eq(1L));
    verify(appCountWidgetDao).findWidgetData(eq(1L), isA(Select.class), isA(LocalDate.class));
    verify(assessmentBasedSelectionFilter2).definitionId();
    verify(assessmentBasedSelectionFilter).definitionId();
    verify(assessmentBasedSelectionFilter2).ratingIds();
    verify(assessmentBasedSelectionFilter).ratingIds();
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(appSelectionOptions).entityLifecycleStatuses();
    verify(appSelectionOptions, atLeast(1)).entityReference();
    verify(appSelectionOptions).filters();
    verify(appSelectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    verify(aggregateOverlayDiagram).aggregatedEntityKind();
    verify(appCountWidgetParameters).targetDate();
    assertTrue(actualAppCountWidgetData instanceof ImmutableCountWidgetData);
    assertEquals(countWidgetDatumSet, actualAppCountWidgetData.cellData());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramService#getTargetAppCostWidgetData(Long, IdSelectionOptions, Set, TargetAppCostWidgetParameters)}
   */
  @Test
  void testGetTargetAppCostWidgetData() {
    // Arrange
    AggregateOverlayDiagram aggregateOverlayDiagram = mock(AggregateOverlayDiagram.class);
    when(aggregateOverlayDiagram.aggregatedEntityKind()).thenReturn(EntityKind.APPLICATION);
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any())).thenReturn(aggregateOverlayDiagram);
    TargetAppCostWidgetDao targetAppCostWidgetDao = mock(TargetAppCostWidgetDao.class);
    when(targetAppCostWidgetDao.findWidgetData(anyLong(), Mockito.<Select<Record1<Long>>>any(),
        Mockito.<LocalDate>any())).thenReturn(new HashSet<>());
    AggregateOverlayDiagramService aggregateOverlayDiagramService = new AggregateOverlayDiagramService(
        aggregateOverlayDiagramDao, mock(AppCountWidgetDao.class), targetAppCostWidgetDao,
        mock(RatingCostWidgetDao.class), mock(AssessmentRatingWidgetDao.class), mock(BackingEntityWidgetDao.class),
        mock(AppCostWidgetDao.class), mock(AggregatedEntitiesWidgetDao.class), mock(AppChangesWidgetDao.class),
        mock(AggregateOverlayDiagramPresetDao.class), mock(MeasurableDao.class), mock(ApplicationDao.class),
        mock(CostKindDao.class), mock(ComplexityKindDao.class), mock(ComplexityWidgetDao.class),
        mock(AttestationWidgetDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions appSelectionOptions = mock(IdSelectionOptions.class);
    when(appSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(appSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(appSelectionOptions.filters()).thenReturn(selectionFilters);
    when(appSelectionOptions.entityReference()).thenReturn(entityReference);
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter.ratingIds()).thenReturn(new HashSet<>());
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter2 = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter2.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter2.ratingIds()).thenReturn(new HashSet<>());

    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();
    filterParams.add(assessmentBasedSelectionFilter2);
    filterParams.add(assessmentBasedSelectionFilter);
    TargetAppCostWidgetParameters targetAppCostWidgetParameters = mock(TargetAppCostWidgetParameters.class);
    when(targetAppCostWidgetParameters.targetDate()).thenReturn(LocalDate.of(1970, 1, 1));

    // Act
    TargetCostWidgetData actualTargetAppCostWidgetData = aggregateOverlayDiagramService.getTargetAppCostWidgetData(1L,
        appSelectionOptions, filterParams, targetAppCostWidgetParameters);

    // Assert
    verify(aggregateOverlayDiagramDao).getById(eq(1L));
    verify(targetAppCostWidgetDao).findWidgetData(eq(1L), isA(Select.class), isA(LocalDate.class));
    verify(assessmentBasedSelectionFilter2).definitionId();
    verify(assessmentBasedSelectionFilter).definitionId();
    verify(assessmentBasedSelectionFilter2).ratingIds();
    verify(assessmentBasedSelectionFilter).ratingIds();
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(appSelectionOptions).entityLifecycleStatuses();
    verify(appSelectionOptions, atLeast(1)).entityReference();
    verify(appSelectionOptions).filters();
    verify(appSelectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    verify(aggregateOverlayDiagram).aggregatedEntityKind();
    verify(targetAppCostWidgetParameters).targetDate();
    assertTrue(actualTargetAppCostWidgetData instanceof ImmutableTargetCostWidgetData);
    assertTrue(actualTargetAppCostWidgetData.cellData().isEmpty());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramService#getTargetAppCostWidgetData(Long, IdSelectionOptions, Set, TargetAppCostWidgetParameters)}
   */
  @Test
  void testGetTargetAppCostWidgetData2() {
    // Arrange
    AggregateOverlayDiagram aggregateOverlayDiagram = mock(AggregateOverlayDiagram.class);
    when(aggregateOverlayDiagram.aggregatedEntityKind()).thenReturn(EntityKind.APPLICATION);
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any())).thenReturn(aggregateOverlayDiagram);

    HashSet<TargetCostWidgetDatum> targetCostWidgetDatumSet = new HashSet<>();
    targetCostWidgetDatumSet.add(mock(TargetCostWidgetDatum.class));
    TargetAppCostWidgetDao targetAppCostWidgetDao = mock(TargetAppCostWidgetDao.class);
    when(targetAppCostWidgetDao.findWidgetData(anyLong(), Mockito.<Select<Record1<Long>>>any(),
        Mockito.<LocalDate>any())).thenReturn(targetCostWidgetDatumSet);
    AggregateOverlayDiagramService aggregateOverlayDiagramService = new AggregateOverlayDiagramService(
        aggregateOverlayDiagramDao, mock(AppCountWidgetDao.class), targetAppCostWidgetDao,
        mock(RatingCostWidgetDao.class), mock(AssessmentRatingWidgetDao.class), mock(BackingEntityWidgetDao.class),
        mock(AppCostWidgetDao.class), mock(AggregatedEntitiesWidgetDao.class), mock(AppChangesWidgetDao.class),
        mock(AggregateOverlayDiagramPresetDao.class), mock(MeasurableDao.class), mock(ApplicationDao.class),
        mock(CostKindDao.class), mock(ComplexityKindDao.class), mock(ComplexityWidgetDao.class),
        mock(AttestationWidgetDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions appSelectionOptions = mock(IdSelectionOptions.class);
    when(appSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(appSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(appSelectionOptions.filters()).thenReturn(selectionFilters);
    when(appSelectionOptions.entityReference()).thenReturn(entityReference);
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter.ratingIds()).thenReturn(new HashSet<>());
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter2 = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter2.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter2.ratingIds()).thenReturn(new HashSet<>());

    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();
    filterParams.add(assessmentBasedSelectionFilter2);
    filterParams.add(assessmentBasedSelectionFilter);
    TargetAppCostWidgetParameters targetAppCostWidgetParameters = mock(TargetAppCostWidgetParameters.class);
    when(targetAppCostWidgetParameters.targetDate()).thenReturn(LocalDate.of(1970, 1, 1));

    // Act
    TargetCostWidgetData actualTargetAppCostWidgetData = aggregateOverlayDiagramService.getTargetAppCostWidgetData(1L,
        appSelectionOptions, filterParams, targetAppCostWidgetParameters);

    // Assert
    verify(aggregateOverlayDiagramDao).getById(eq(1L));
    verify(targetAppCostWidgetDao).findWidgetData(eq(1L), isA(Select.class), isA(LocalDate.class));
    verify(assessmentBasedSelectionFilter2).definitionId();
    verify(assessmentBasedSelectionFilter).definitionId();
    verify(assessmentBasedSelectionFilter2).ratingIds();
    verify(assessmentBasedSelectionFilter).ratingIds();
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(appSelectionOptions).entityLifecycleStatuses();
    verify(appSelectionOptions, atLeast(1)).entityReference();
    verify(appSelectionOptions).filters();
    verify(appSelectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    verify(aggregateOverlayDiagram).aggregatedEntityKind();
    verify(targetAppCostWidgetParameters).targetDate();
    assertTrue(actualTargetAppCostWidgetData instanceof ImmutableTargetCostWidgetData);
    assertEquals(1, actualTargetAppCostWidgetData.cellData().size());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramService#getTargetAppCostWidgetData(Long, IdSelectionOptions, Set, TargetAppCostWidgetParameters)}
   */
  @Test
  void testGetTargetAppCostWidgetData3() {
    // Arrange
    AggregateOverlayDiagram aggregateOverlayDiagram = mock(AggregateOverlayDiagram.class);
    when(aggregateOverlayDiagram.aggregatedEntityKind()).thenReturn(EntityKind.APPLICATION);
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any())).thenReturn(aggregateOverlayDiagram);

    HashSet<TargetCostWidgetDatum> targetCostWidgetDatumSet = new HashSet<>();
    targetCostWidgetDatumSet.add(mock(TargetCostWidgetDatum.class));
    targetCostWidgetDatumSet.add(mock(TargetCostWidgetDatum.class));
    TargetAppCostWidgetDao targetAppCostWidgetDao = mock(TargetAppCostWidgetDao.class);
    when(targetAppCostWidgetDao.findWidgetData(anyLong(), Mockito.<Select<Record1<Long>>>any(),
        Mockito.<LocalDate>any())).thenReturn(targetCostWidgetDatumSet);
    AggregateOverlayDiagramService aggregateOverlayDiagramService = new AggregateOverlayDiagramService(
        aggregateOverlayDiagramDao, mock(AppCountWidgetDao.class), targetAppCostWidgetDao,
        mock(RatingCostWidgetDao.class), mock(AssessmentRatingWidgetDao.class), mock(BackingEntityWidgetDao.class),
        mock(AppCostWidgetDao.class), mock(AggregatedEntitiesWidgetDao.class), mock(AppChangesWidgetDao.class),
        mock(AggregateOverlayDiagramPresetDao.class), mock(MeasurableDao.class), mock(ApplicationDao.class),
        mock(CostKindDao.class), mock(ComplexityKindDao.class), mock(ComplexityWidgetDao.class),
        mock(AttestationWidgetDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions appSelectionOptions = mock(IdSelectionOptions.class);
    when(appSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(appSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(appSelectionOptions.filters()).thenReturn(selectionFilters);
    when(appSelectionOptions.entityReference()).thenReturn(entityReference);
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter.ratingIds()).thenReturn(new HashSet<>());
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter2 = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter2.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter2.ratingIds()).thenReturn(new HashSet<>());

    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();
    filterParams.add(assessmentBasedSelectionFilter2);
    filterParams.add(assessmentBasedSelectionFilter);
    TargetAppCostWidgetParameters targetAppCostWidgetParameters = mock(TargetAppCostWidgetParameters.class);
    when(targetAppCostWidgetParameters.targetDate()).thenReturn(LocalDate.of(1970, 1, 1));

    // Act
    TargetCostWidgetData actualTargetAppCostWidgetData = aggregateOverlayDiagramService.getTargetAppCostWidgetData(1L,
        appSelectionOptions, filterParams, targetAppCostWidgetParameters);

    // Assert
    verify(aggregateOverlayDiagramDao).getById(eq(1L));
    verify(targetAppCostWidgetDao).findWidgetData(eq(1L), isA(Select.class), isA(LocalDate.class));
    verify(assessmentBasedSelectionFilter2).definitionId();
    verify(assessmentBasedSelectionFilter).definitionId();
    verify(assessmentBasedSelectionFilter2).ratingIds();
    verify(assessmentBasedSelectionFilter).ratingIds();
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(appSelectionOptions).entityLifecycleStatuses();
    verify(appSelectionOptions, atLeast(1)).entityReference();
    verify(appSelectionOptions).filters();
    verify(appSelectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    verify(aggregateOverlayDiagram).aggregatedEntityKind();
    verify(targetAppCostWidgetParameters).targetDate();
    assertTrue(actualTargetAppCostWidgetData instanceof ImmutableTargetCostWidgetData);
    assertEquals(targetCostWidgetDatumSet, actualTargetAppCostWidgetData.cellData());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramService#getAttestationWidgetData(long, Set, IdSelectionOptions, AttestationWidgetParameters)}
   */
  @Test
  void testGetAttestationWidgetData() {
    // Arrange
    AggregateOverlayDiagram aggregateOverlayDiagram = mock(AggregateOverlayDiagram.class);
    when(aggregateOverlayDiagram.aggregatedEntityKind()).thenReturn(EntityKind.APPLICATION);
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any())).thenReturn(aggregateOverlayDiagram);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(new ArrayList<>());
    AttestationWidgetDao attestationWidgetDao = mock(AttestationWidgetDao.class);
    when(attestationWidgetDao.findWidgetData(anyLong(), Mockito.<EntityKind>any(), Mockito.<Optional<Long>>any(),
        Mockito.<Select<Record1<Long>>>any())).thenReturn(new HashSet<>());
    AggregateOverlayDiagramService aggregateOverlayDiagramService = new AggregateOverlayDiagramService(
        aggregateOverlayDiagramDao, mock(AppCountWidgetDao.class), mock(TargetAppCostWidgetDao.class),
        mock(RatingCostWidgetDao.class), mock(AssessmentRatingWidgetDao.class), mock(BackingEntityWidgetDao.class),
        mock(AppCostWidgetDao.class), mock(AggregatedEntitiesWidgetDao.class), mock(AppChangesWidgetDao.class),
        mock(AggregateOverlayDiagramPresetDao.class), mock(MeasurableDao.class), applicationDao,
        mock(CostKindDao.class), mock(ComplexityKindDao.class), mock(ComplexityWidgetDao.class), attestationWidgetDao);
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter.ratingIds()).thenReturn(new HashSet<>());
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter2 = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter2.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter2.ratingIds()).thenReturn(new HashSet<>());

    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();
    filterParams.add(assessmentBasedSelectionFilter2);
    filterParams.add(assessmentBasedSelectionFilter);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions appSelectionOptions = mock(IdSelectionOptions.class);
    when(appSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(appSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(appSelectionOptions.filters()).thenReturn(selectionFilters);
    when(appSelectionOptions.entityReference()).thenReturn(entityReference);
    AttestationWidgetParameters widgetParams = mock(AttestationWidgetParameters.class);
    when(widgetParams.attestedEntityId()).thenReturn(1L);
    when(widgetParams.attestedEntityKind()).thenReturn(EntityKind.ALL);

    // Act
    AttestationWidgetData actualAttestationWidgetData = aggregateOverlayDiagramService.getAttestationWidgetData(1L,
        filterParams, appSelectionOptions, widgetParams);

    // Assert
    verify(aggregateOverlayDiagramDao).getById(eq(1L));
    verify(attestationWidgetDao).findWidgetData(eq(1L), eq(EntityKind.ALL), isA(Optional.class), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(assessmentBasedSelectionFilter2).definitionId();
    verify(assessmentBasedSelectionFilter).definitionId();
    verify(assessmentBasedSelectionFilter2).ratingIds();
    verify(assessmentBasedSelectionFilter).ratingIds();
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(appSelectionOptions).entityLifecycleStatuses();
    verify(appSelectionOptions, atLeast(1)).entityReference();
    verify(appSelectionOptions).filters();
    verify(appSelectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    verify(aggregateOverlayDiagram).aggregatedEntityKind();
    verify(widgetParams).attestedEntityId();
    verify(widgetParams).attestedEntityKind();
    assertTrue(actualAttestationWidgetData instanceof ImmutableAttestationWidgetData);
    Set<Application> applicationsResult = actualAttestationWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualAttestationWidgetData.cellData());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramService#getAppAssessmentWidgetData(Long, Set, IdSelectionOptions, AssessmentWidgetParameters)}
   */
  @Test
  void testGetAppAssessmentWidgetData() {
    // Arrange
    AggregateOverlayDiagram aggregateOverlayDiagram = mock(AggregateOverlayDiagram.class);
    when(aggregateOverlayDiagram.aggregatedEntityKind()).thenReturn(EntityKind.APPLICATION);
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any())).thenReturn(aggregateOverlayDiagram);
    AssessmentRatingWidgetDao appAssessmentWidgetDao = mock(AssessmentRatingWidgetDao.class);
    when(appAssessmentWidgetDao.findWidgetData(anyLong(), Mockito.<EntityKind>any(), Mockito.<Long>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<LocalDate>>any())).thenReturn(new HashSet<>());
    AggregateOverlayDiagramService aggregateOverlayDiagramService = new AggregateOverlayDiagramService(
        aggregateOverlayDiagramDao, mock(AppCountWidgetDao.class), mock(TargetAppCostWidgetDao.class),
        mock(RatingCostWidgetDao.class), appAssessmentWidgetDao, mock(BackingEntityWidgetDao.class),
        mock(AppCostWidgetDao.class), mock(AggregatedEntitiesWidgetDao.class), mock(AppChangesWidgetDao.class),
        mock(AggregateOverlayDiagramPresetDao.class), mock(MeasurableDao.class), mock(ApplicationDao.class),
        mock(CostKindDao.class), mock(ComplexityKindDao.class), mock(ComplexityWidgetDao.class),
        mock(AttestationWidgetDao.class));
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter.ratingIds()).thenReturn(new HashSet<>());
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter2 = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter2.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter2.ratingIds()).thenReturn(new HashSet<>());

    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();
    filterParams.add(assessmentBasedSelectionFilter2);
    filterParams.add(assessmentBasedSelectionFilter);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions appSelectionOptions = mock(IdSelectionOptions.class);
    when(appSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(appSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(appSelectionOptions.filters()).thenReturn(selectionFilters);
    when(appSelectionOptions.entityReference()).thenReturn(entityReference);
    AssessmentWidgetParameters assessmentWidgetParameters = mock(AssessmentWidgetParameters.class);
    when(assessmentWidgetParameters.assessmentDefinitionId()).thenReturn(1L);
    Optional<LocalDate> ofResult = Optional.of(LocalDate.of(1970, 1, 1));
    when(assessmentWidgetParameters.targetDate()).thenReturn(ofResult);

    // Act
    AssessmentRatingsWidgetData actualAppAssessmentWidgetData = aggregateOverlayDiagramService
        .getAppAssessmentWidgetData(1L, filterParams, appSelectionOptions, assessmentWidgetParameters);

    // Assert
    verify(aggregateOverlayDiagramDao).getById(eq(1L));
    verify(appAssessmentWidgetDao).findWidgetData(eq(1L), eq(EntityKind.APPLICATION), eq(1L), isA(Select.class),
        isA(Optional.class));
    verify(assessmentBasedSelectionFilter2).definitionId();
    verify(assessmentBasedSelectionFilter).definitionId();
    verify(assessmentBasedSelectionFilter2).ratingIds();
    verify(assessmentBasedSelectionFilter).ratingIds();
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(appSelectionOptions).entityLifecycleStatuses();
    verify(appSelectionOptions, atLeast(1)).entityReference();
    verify(appSelectionOptions).filters();
    verify(appSelectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    verify(aggregateOverlayDiagram, atLeast(1)).aggregatedEntityKind();
    verify(assessmentWidgetParameters).assessmentDefinitionId();
    verify(assessmentWidgetParameters).targetDate();
    assertTrue(actualAppAssessmentWidgetData instanceof ImmutableAssessmentRatingsWidgetData);
    assertTrue(actualAppAssessmentWidgetData.cellData().isEmpty());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramService#getAggregatedEntitiesWidgetData(Long, Set, IdSelectionOptions)}
   */
  @Test
  void testGetAggregatedEntitiesWidgetData() {
    // Arrange
    AggregateOverlayDiagram aggregateOverlayDiagram = mock(AggregateOverlayDiagram.class);
    when(aggregateOverlayDiagram.aggregatedEntityKind()).thenReturn(EntityKind.APPLICATION);
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any())).thenReturn(aggregateOverlayDiagram);
    AggregatedEntitiesWidgetDao aggregatedEntitiesWidgetDao = mock(AggregatedEntitiesWidgetDao.class);
    when(aggregatedEntitiesWidgetDao.findWidgetData(anyLong(), Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<LocalDate>>any())).thenReturn(new HashSet<>());
    AggregateOverlayDiagramService aggregateOverlayDiagramService = new AggregateOverlayDiagramService(
        aggregateOverlayDiagramDao, mock(AppCountWidgetDao.class), mock(TargetAppCostWidgetDao.class),
        mock(RatingCostWidgetDao.class), mock(AssessmentRatingWidgetDao.class), mock(BackingEntityWidgetDao.class),
        mock(AppCostWidgetDao.class), aggregatedEntitiesWidgetDao, mock(AppChangesWidgetDao.class),
        mock(AggregateOverlayDiagramPresetDao.class), mock(MeasurableDao.class), mock(ApplicationDao.class),
        mock(CostKindDao.class), mock(ComplexityKindDao.class), mock(ComplexityWidgetDao.class),
        mock(AttestationWidgetDao.class));
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.filters()).thenReturn(selectionFilters);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    AggregatedEntitiesWidgetData actualAggregatedEntitiesWidgetData = aggregateOverlayDiagramService
        .getAggregatedEntitiesWidgetData(1L, filterParams, idSelectionOptions);

    // Assert
    verify(aggregateOverlayDiagramDao).getById(eq(1L));
    verify(aggregatedEntitiesWidgetDao).findWidgetData(eq(1L), eq(EntityKind.APPLICATION), isA(Select.class),
        isA(Optional.class));
    verify(entityReference).kind();
    verify(idSelectionOptions).entityLifecycleStatuses();
    verify(idSelectionOptions).entityReference();
    verify(idSelectionOptions).filters();
    verify(selectionFilters).omitApplicationKinds();
    verify(aggregateOverlayDiagram, atLeast(1)).aggregatedEntityKind();
    assertTrue(actualAggregatedEntitiesWidgetData instanceof ImmutableAggregatedEntitiesWidgetData);
    assertTrue(actualAggregatedEntitiesWidgetData.cellData().isEmpty());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramService#getAggregatedEntitiesWidgetData(Long, Set, IdSelectionOptions)}
   */
  @Test
  void testGetAggregatedEntitiesWidgetData2() {
    // Arrange
    AggregateOverlayDiagram aggregateOverlayDiagram = mock(AggregateOverlayDiagram.class);
    when(aggregateOverlayDiagram.aggregatedEntityKind()).thenReturn(EntityKind.APPLICATION);
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any())).thenReturn(aggregateOverlayDiagram);

    HashSet<AggregatedEntitiesWidgetDatum> aggregatedEntitiesWidgetDatumSet = new HashSet<>();
    aggregatedEntitiesWidgetDatumSet.add(mock(AggregatedEntitiesWidgetDatum.class));
    AggregatedEntitiesWidgetDao aggregatedEntitiesWidgetDao = mock(AggregatedEntitiesWidgetDao.class);
    when(aggregatedEntitiesWidgetDao.findWidgetData(anyLong(), Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<LocalDate>>any()))
            .thenReturn(aggregatedEntitiesWidgetDatumSet);
    AggregateOverlayDiagramService aggregateOverlayDiagramService = new AggregateOverlayDiagramService(
        aggregateOverlayDiagramDao, mock(AppCountWidgetDao.class), mock(TargetAppCostWidgetDao.class),
        mock(RatingCostWidgetDao.class), mock(AssessmentRatingWidgetDao.class), mock(BackingEntityWidgetDao.class),
        mock(AppCostWidgetDao.class), aggregatedEntitiesWidgetDao, mock(AppChangesWidgetDao.class),
        mock(AggregateOverlayDiagramPresetDao.class), mock(MeasurableDao.class), mock(ApplicationDao.class),
        mock(CostKindDao.class), mock(ComplexityKindDao.class), mock(ComplexityWidgetDao.class),
        mock(AttestationWidgetDao.class));
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.filters()).thenReturn(selectionFilters);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    AggregatedEntitiesWidgetData actualAggregatedEntitiesWidgetData = aggregateOverlayDiagramService
        .getAggregatedEntitiesWidgetData(1L, filterParams, idSelectionOptions);

    // Assert
    verify(aggregateOverlayDiagramDao).getById(eq(1L));
    verify(aggregatedEntitiesWidgetDao).findWidgetData(eq(1L), eq(EntityKind.APPLICATION), isA(Select.class),
        isA(Optional.class));
    verify(entityReference).kind();
    verify(idSelectionOptions).entityLifecycleStatuses();
    verify(idSelectionOptions).entityReference();
    verify(idSelectionOptions).filters();
    verify(selectionFilters).omitApplicationKinds();
    verify(aggregateOverlayDiagram, atLeast(1)).aggregatedEntityKind();
    assertTrue(actualAggregatedEntitiesWidgetData instanceof ImmutableAggregatedEntitiesWidgetData);
    assertEquals(1, actualAggregatedEntitiesWidgetData.cellData().size());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramService#getAggregatedEntitiesWidgetData(Long, Set, IdSelectionOptions)}
   */
  @Test
  void testGetAggregatedEntitiesWidgetData3() {
    // Arrange
    AggregateOverlayDiagram aggregateOverlayDiagram = mock(AggregateOverlayDiagram.class);
    when(aggregateOverlayDiagram.aggregatedEntityKind()).thenReturn(EntityKind.APPLICATION);
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any())).thenReturn(aggregateOverlayDiagram);

    HashSet<AggregatedEntitiesWidgetDatum> aggregatedEntitiesWidgetDatumSet = new HashSet<>();
    aggregatedEntitiesWidgetDatumSet.add(mock(AggregatedEntitiesWidgetDatum.class));
    aggregatedEntitiesWidgetDatumSet.add(mock(AggregatedEntitiesWidgetDatum.class));
    AggregatedEntitiesWidgetDao aggregatedEntitiesWidgetDao = mock(AggregatedEntitiesWidgetDao.class);
    when(aggregatedEntitiesWidgetDao.findWidgetData(anyLong(), Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<LocalDate>>any()))
            .thenReturn(aggregatedEntitiesWidgetDatumSet);
    AggregateOverlayDiagramService aggregateOverlayDiagramService = new AggregateOverlayDiagramService(
        aggregateOverlayDiagramDao, mock(AppCountWidgetDao.class), mock(TargetAppCostWidgetDao.class),
        mock(RatingCostWidgetDao.class), mock(AssessmentRatingWidgetDao.class), mock(BackingEntityWidgetDao.class),
        mock(AppCostWidgetDao.class), aggregatedEntitiesWidgetDao, mock(AppChangesWidgetDao.class),
        mock(AggregateOverlayDiagramPresetDao.class), mock(MeasurableDao.class), mock(ApplicationDao.class),
        mock(CostKindDao.class), mock(ComplexityKindDao.class), mock(ComplexityWidgetDao.class),
        mock(AttestationWidgetDao.class));
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.filters()).thenReturn(selectionFilters);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    AggregatedEntitiesWidgetData actualAggregatedEntitiesWidgetData = aggregateOverlayDiagramService
        .getAggregatedEntitiesWidgetData(1L, filterParams, idSelectionOptions);

    // Assert
    verify(aggregateOverlayDiagramDao).getById(eq(1L));
    verify(aggregatedEntitiesWidgetDao).findWidgetData(eq(1L), eq(EntityKind.APPLICATION), isA(Select.class),
        isA(Optional.class));
    verify(entityReference).kind();
    verify(idSelectionOptions).entityLifecycleStatuses();
    verify(idSelectionOptions).entityReference();
    verify(idSelectionOptions).filters();
    verify(selectionFilters).omitApplicationKinds();
    verify(aggregateOverlayDiagram, atLeast(1)).aggregatedEntityKind();
    assertTrue(actualAggregatedEntitiesWidgetData instanceof ImmutableAggregatedEntitiesWidgetData);
    assertEquals(aggregatedEntitiesWidgetDatumSet, actualAggregatedEntitiesWidgetData.cellData());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramService#getAggregatedEntitiesWidgetData(Long, Set, IdSelectionOptions)}
   */
  @Test
  void testGetAggregatedEntitiesWidgetData4() {
    // Arrange
    AggregateOverlayDiagram aggregateOverlayDiagram = mock(AggregateOverlayDiagram.class);
    when(aggregateOverlayDiagram.aggregatedEntityKind()).thenReturn(EntityKind.APPLICATION);
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any())).thenReturn(aggregateOverlayDiagram);
    AggregatedEntitiesWidgetDao aggregatedEntitiesWidgetDao = mock(AggregatedEntitiesWidgetDao.class);
    when(aggregatedEntitiesWidgetDao.findWidgetData(anyLong(), Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<LocalDate>>any())).thenReturn(new HashSet<>());
    AggregateOverlayDiagramService aggregateOverlayDiagramService = new AggregateOverlayDiagramService(
        aggregateOverlayDiagramDao, mock(AppCountWidgetDao.class), mock(TargetAppCostWidgetDao.class),
        mock(RatingCostWidgetDao.class), mock(AssessmentRatingWidgetDao.class), mock(BackingEntityWidgetDao.class),
        mock(AppCostWidgetDao.class), aggregatedEntitiesWidgetDao, mock(AppChangesWidgetDao.class),
        mock(AggregateOverlayDiagramPresetDao.class), mock(MeasurableDao.class), mock(ApplicationDao.class),
        mock(CostKindDao.class), mock(ComplexityKindDao.class), mock(ComplexityWidgetDao.class),
        mock(AttestationWidgetDao.class));
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter.ratingIds()).thenReturn(new HashSet<>());

    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();
    filterParams.add(assessmentBasedSelectionFilter);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.filters()).thenReturn(selectionFilters);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    AggregatedEntitiesWidgetData actualAggregatedEntitiesWidgetData = aggregateOverlayDiagramService
        .getAggregatedEntitiesWidgetData(1L, filterParams, idSelectionOptions);

    // Assert
    verify(aggregateOverlayDiagramDao).getById(eq(1L));
    verify(aggregatedEntitiesWidgetDao).findWidgetData(eq(1L), eq(EntityKind.APPLICATION), isA(Select.class),
        isA(Optional.class));
    verify(assessmentBasedSelectionFilter).definitionId();
    verify(assessmentBasedSelectionFilter).ratingIds();
    verify(entityReference).kind();
    verify(idSelectionOptions).entityLifecycleStatuses();
    verify(idSelectionOptions).entityReference();
    verify(idSelectionOptions).filters();
    verify(selectionFilters).omitApplicationKinds();
    verify(aggregateOverlayDiagram, atLeast(1)).aggregatedEntityKind();
    assertTrue(actualAggregatedEntitiesWidgetData instanceof ImmutableAggregatedEntitiesWidgetData);
    assertTrue(actualAggregatedEntitiesWidgetData.cellData().isEmpty());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramService#getAggregatedEntitiesWidgetData(Long, Set, IdSelectionOptions)}
   */
  @Test
  void testGetAggregatedEntitiesWidgetData5() {
    // Arrange
    AggregateOverlayDiagram aggregateOverlayDiagram = mock(AggregateOverlayDiagram.class);
    when(aggregateOverlayDiagram.aggregatedEntityKind()).thenReturn(EntityKind.APPLICATION);
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any())).thenReturn(aggregateOverlayDiagram);
    AggregatedEntitiesWidgetDao aggregatedEntitiesWidgetDao = mock(AggregatedEntitiesWidgetDao.class);
    when(aggregatedEntitiesWidgetDao.findWidgetData(anyLong(), Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<LocalDate>>any())).thenReturn(new HashSet<>());
    AggregateOverlayDiagramService aggregateOverlayDiagramService = new AggregateOverlayDiagramService(
        aggregateOverlayDiagramDao, mock(AppCountWidgetDao.class), mock(TargetAppCostWidgetDao.class),
        mock(RatingCostWidgetDao.class), mock(AssessmentRatingWidgetDao.class), mock(BackingEntityWidgetDao.class),
        mock(AppCostWidgetDao.class), aggregatedEntitiesWidgetDao, mock(AppChangesWidgetDao.class),
        mock(AggregateOverlayDiagramPresetDao.class), mock(MeasurableDao.class), mock(ApplicationDao.class),
        mock(CostKindDao.class), mock(ComplexityKindDao.class), mock(ComplexityWidgetDao.class),
        mock(AttestationWidgetDao.class));
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter.ratingIds()).thenReturn(new HashSet<>());
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter2 = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter2.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter2.ratingIds()).thenReturn(new HashSet<>());

    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();
    filterParams.add(assessmentBasedSelectionFilter2);
    filterParams.add(assessmentBasedSelectionFilter);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.filters()).thenReturn(selectionFilters);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    AggregatedEntitiesWidgetData actualAggregatedEntitiesWidgetData = aggregateOverlayDiagramService
        .getAggregatedEntitiesWidgetData(1L, filterParams, idSelectionOptions);

    // Assert
    verify(aggregateOverlayDiagramDao).getById(eq(1L));
    verify(aggregatedEntitiesWidgetDao).findWidgetData(eq(1L), eq(EntityKind.APPLICATION), isA(Select.class),
        isA(Optional.class));
    verify(assessmentBasedSelectionFilter2).definitionId();
    verify(assessmentBasedSelectionFilter).definitionId();
    verify(assessmentBasedSelectionFilter2).ratingIds();
    verify(assessmentBasedSelectionFilter).ratingIds();
    verify(entityReference).kind();
    verify(idSelectionOptions).entityLifecycleStatuses();
    verify(idSelectionOptions).entityReference();
    verify(idSelectionOptions).filters();
    verify(selectionFilters).omitApplicationKinds();
    verify(aggregateOverlayDiagram, atLeast(1)).aggregatedEntityKind();
    assertTrue(actualAggregatedEntitiesWidgetData instanceof ImmutableAggregatedEntitiesWidgetData);
    assertTrue(actualAggregatedEntitiesWidgetData.cellData().isEmpty());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramService#getAggregatedEntitiesWidgetData(Long, Set, IdSelectionOptions)}
   */
  @Test
  void testGetAggregatedEntitiesWidgetData6() {
    // Arrange
    AggregateOverlayDiagram aggregateOverlayDiagram = mock(AggregateOverlayDiagram.class);
    when(aggregateOverlayDiagram.aggregatedEntityKind()).thenReturn(EntityKind.APPLICATION);
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any())).thenReturn(aggregateOverlayDiagram);
    AggregatedEntitiesWidgetDao aggregatedEntitiesWidgetDao = mock(AggregatedEntitiesWidgetDao.class);
    when(aggregatedEntitiesWidgetDao.findWidgetData(anyLong(), Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<LocalDate>>any())).thenReturn(new HashSet<>());
    AggregateOverlayDiagramService aggregateOverlayDiagramService = new AggregateOverlayDiagramService(
        aggregateOverlayDiagramDao, mock(AppCountWidgetDao.class), mock(TargetAppCostWidgetDao.class),
        mock(RatingCostWidgetDao.class), mock(AssessmentRatingWidgetDao.class), mock(BackingEntityWidgetDao.class),
        mock(AppCostWidgetDao.class), aggregatedEntitiesWidgetDao, mock(AppChangesWidgetDao.class),
        mock(AggregateOverlayDiagramPresetDao.class), mock(MeasurableDao.class), mock(ApplicationDao.class),
        mock(CostKindDao.class), mock(ComplexityKindDao.class), mock(ComplexityWidgetDao.class),
        mock(AttestationWidgetDao.class));
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter.ratingIds()).thenReturn(new HashSet<>());

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter2 = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter2.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter2.ratingIds()).thenReturn(resultLongSet);

    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();
    filterParams.add(assessmentBasedSelectionFilter2);
    filterParams.add(assessmentBasedSelectionFilter);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.filters()).thenReturn(selectionFilters);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    AggregatedEntitiesWidgetData actualAggregatedEntitiesWidgetData = aggregateOverlayDiagramService
        .getAggregatedEntitiesWidgetData(1L, filterParams, idSelectionOptions);

    // Assert
    verify(aggregateOverlayDiagramDao).getById(eq(1L));
    verify(aggregatedEntitiesWidgetDao).findWidgetData(eq(1L), eq(EntityKind.APPLICATION), isA(Select.class),
        isA(Optional.class));
    verify(assessmentBasedSelectionFilter2).definitionId();
    verify(assessmentBasedSelectionFilter).definitionId();
    verify(assessmentBasedSelectionFilter).ratingIds();
    verify(assessmentBasedSelectionFilter2, atLeast(1)).ratingIds();
    verify(entityReference).kind();
    verify(idSelectionOptions).entityLifecycleStatuses();
    verify(idSelectionOptions).entityReference();
    verify(idSelectionOptions).filters();
    verify(selectionFilters).omitApplicationKinds();
    verify(aggregateOverlayDiagram, atLeast(1)).aggregatedEntityKind();
    assertTrue(actualAggregatedEntitiesWidgetData instanceof ImmutableAggregatedEntitiesWidgetData);
    assertTrue(actualAggregatedEntitiesWidgetData.cellData().isEmpty());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramService#getAggregatedEntitiesWidgetData(Long, Set, IdSelectionOptions)}
   */
  @Test
  void testGetAggregatedEntitiesWidgetData7() {
    // Arrange
    AggregateOverlayDiagram aggregateOverlayDiagram = mock(AggregateOverlayDiagram.class);
    when(aggregateOverlayDiagram.aggregatedEntityKind()).thenReturn(EntityKind.APPLICATION);
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any())).thenReturn(aggregateOverlayDiagram);
    AggregatedEntitiesWidgetDao aggregatedEntitiesWidgetDao = mock(AggregatedEntitiesWidgetDao.class);
    when(aggregatedEntitiesWidgetDao.findWidgetData(anyLong(), Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<LocalDate>>any())).thenReturn(new HashSet<>());
    AggregateOverlayDiagramService aggregateOverlayDiagramService = new AggregateOverlayDiagramService(
        aggregateOverlayDiagramDao, mock(AppCountWidgetDao.class), mock(TargetAppCostWidgetDao.class),
        mock(RatingCostWidgetDao.class), mock(AssessmentRatingWidgetDao.class), mock(BackingEntityWidgetDao.class),
        mock(AppCostWidgetDao.class), aggregatedEntitiesWidgetDao, mock(AppChangesWidgetDao.class),
        mock(AggregateOverlayDiagramPresetDao.class), mock(MeasurableDao.class), mock(ApplicationDao.class),
        mock(CostKindDao.class), mock(ComplexityKindDao.class), mock(ComplexityWidgetDao.class),
        mock(AttestationWidgetDao.class));
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter.ratingIds()).thenReturn(new HashSet<>());
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter2 = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter2.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter2.ratingIds()).thenReturn(new HashSet<>());

    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();
    filterParams.add(assessmentBasedSelectionFilter2);
    filterParams.add(assessmentBasedSelectionFilter);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    HashSet<ApplicationKind> applicationKindSet = new HashSet<>();
    applicationKindSet.add(ApplicationKind.IN_HOUSE);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(applicationKindSet);
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.filters()).thenReturn(selectionFilters);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    AggregatedEntitiesWidgetData actualAggregatedEntitiesWidgetData = aggregateOverlayDiagramService
        .getAggregatedEntitiesWidgetData(1L, filterParams, idSelectionOptions);

    // Assert
    verify(aggregateOverlayDiagramDao).getById(eq(1L));
    verify(aggregatedEntitiesWidgetDao).findWidgetData(eq(1L), eq(EntityKind.APPLICATION), isA(Select.class),
        isA(Optional.class));
    verify(assessmentBasedSelectionFilter2).definitionId();
    verify(assessmentBasedSelectionFilter).definitionId();
    verify(assessmentBasedSelectionFilter2).ratingIds();
    verify(assessmentBasedSelectionFilter).ratingIds();
    verify(entityReference).kind();
    verify(idSelectionOptions).entityLifecycleStatuses();
    verify(idSelectionOptions).entityReference();
    verify(idSelectionOptions, atLeast(1)).filters();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    verify(aggregateOverlayDiagram, atLeast(1)).aggregatedEntityKind();
    assertTrue(actualAggregatedEntitiesWidgetData instanceof ImmutableAggregatedEntitiesWidgetData);
    assertTrue(actualAggregatedEntitiesWidgetData.cellData().isEmpty());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramService#getAggregatedEntitiesWidgetData(Long, Set, IdSelectionOptions)}
   */
  @Test
  void testGetAggregatedEntitiesWidgetData8() {
    // Arrange
    AggregateOverlayDiagram aggregateOverlayDiagram = mock(AggregateOverlayDiagram.class);
    when(aggregateOverlayDiagram.aggregatedEntityKind()).thenReturn(EntityKind.APPLICATION);
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any())).thenReturn(aggregateOverlayDiagram);
    AggregatedEntitiesWidgetDao aggregatedEntitiesWidgetDao = mock(AggregatedEntitiesWidgetDao.class);
    when(aggregatedEntitiesWidgetDao.findWidgetData(anyLong(), Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<LocalDate>>any())).thenReturn(new HashSet<>());
    AggregateOverlayDiagramService aggregateOverlayDiagramService = new AggregateOverlayDiagramService(
        aggregateOverlayDiagramDao, mock(AppCountWidgetDao.class), mock(TargetAppCostWidgetDao.class),
        mock(RatingCostWidgetDao.class), mock(AssessmentRatingWidgetDao.class), mock(BackingEntityWidgetDao.class),
        mock(AppCostWidgetDao.class), aggregatedEntitiesWidgetDao, mock(AppChangesWidgetDao.class),
        mock(AggregateOverlayDiagramPresetDao.class), mock(MeasurableDao.class), mock(ApplicationDao.class),
        mock(CostKindDao.class), mock(ComplexityKindDao.class), mock(ComplexityWidgetDao.class),
        mock(AttestationWidgetDao.class));
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter.ratingIds()).thenReturn(new HashSet<>());
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter2 = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter2.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter2.ratingIds()).thenReturn(new HashSet<>());

    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();
    filterParams.add(assessmentBasedSelectionFilter2);
    filterParams.add(assessmentBasedSelectionFilter);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.filters()).thenReturn(selectionFilters);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    AggregatedEntitiesWidgetData actualAggregatedEntitiesWidgetData = aggregateOverlayDiagramService
        .getAggregatedEntitiesWidgetData(1L, filterParams, idSelectionOptions);

    // Assert
    verify(aggregateOverlayDiagramDao).getById(eq(1L));
    verify(aggregatedEntitiesWidgetDao).findWidgetData(eq(1L), eq(EntityKind.APPLICATION), isA(Select.class),
        isA(Optional.class));
    verify(assessmentBasedSelectionFilter2).definitionId();
    verify(assessmentBasedSelectionFilter).definitionId();
    verify(assessmentBasedSelectionFilter2).ratingIds();
    verify(assessmentBasedSelectionFilter).ratingIds();
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(idSelectionOptions).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions).filters();
    verify(idSelectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    verify(aggregateOverlayDiagram, atLeast(1)).aggregatedEntityKind();
    assertTrue(actualAggregatedEntitiesWidgetData instanceof ImmutableAggregatedEntitiesWidgetData);
    assertTrue(actualAggregatedEntitiesWidgetData.cellData().isEmpty());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramService#getAggregatedEntitiesWidgetData(Long, Set, IdSelectionOptions)}
   */
  @Test
  void testGetAggregatedEntitiesWidgetData9() {
    // Arrange
    AggregateOverlayDiagram aggregateOverlayDiagram = mock(AggregateOverlayDiagram.class);
    when(aggregateOverlayDiagram.aggregatedEntityKind()).thenReturn(EntityKind.APPLICATION);
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any())).thenReturn(aggregateOverlayDiagram);
    AggregatedEntitiesWidgetDao aggregatedEntitiesWidgetDao = mock(AggregatedEntitiesWidgetDao.class);
    when(aggregatedEntitiesWidgetDao.findWidgetData(anyLong(), Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<LocalDate>>any())).thenReturn(new HashSet<>());
    AggregateOverlayDiagramService aggregateOverlayDiagramService = new AggregateOverlayDiagramService(
        aggregateOverlayDiagramDao, mock(AppCountWidgetDao.class), mock(TargetAppCostWidgetDao.class),
        mock(RatingCostWidgetDao.class), mock(AssessmentRatingWidgetDao.class), mock(BackingEntityWidgetDao.class),
        mock(AppCostWidgetDao.class), aggregatedEntitiesWidgetDao, mock(AppChangesWidgetDao.class),
        mock(AggregateOverlayDiagramPresetDao.class), mock(MeasurableDao.class), mock(ApplicationDao.class),
        mock(CostKindDao.class), mock(ComplexityKindDao.class), mock(ComplexityWidgetDao.class),
        mock(AttestationWidgetDao.class));
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter.ratingIds()).thenReturn(new HashSet<>());
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter2 = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter2.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter2.ratingIds()).thenReturn(new HashSet<>());

    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();
    filterParams.add(assessmentBasedSelectionFilter2);
    filterParams.add(assessmentBasedSelectionFilter);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    AggregatedEntitiesWidgetData actualAggregatedEntitiesWidgetData = aggregateOverlayDiagramService
        .getAggregatedEntitiesWidgetData(1L, filterParams, idSelectionOptions);

    // Assert
    verify(aggregateOverlayDiagramDao).getById(eq(1L));
    verify(aggregatedEntitiesWidgetDao).findWidgetData(eq(1L), eq(EntityKind.APPLICATION), isA(Select.class),
        isA(Optional.class));
    verify(assessmentBasedSelectionFilter2).definitionId();
    verify(assessmentBasedSelectionFilter).definitionId();
    verify(assessmentBasedSelectionFilter2).ratingIds();
    verify(assessmentBasedSelectionFilter).ratingIds();
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions).scope();
    verify(aggregateOverlayDiagram, atLeast(1)).aggregatedEntityKind();
    assertTrue(actualAggregatedEntitiesWidgetData instanceof ImmutableAggregatedEntitiesWidgetData);
    assertTrue(actualAggregatedEntitiesWidgetData.cellData().isEmpty());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramService#getAggregatedEntitiesWidgetData(Long, Set, IdSelectionOptions)}
   */
  @Test
  void testGetAggregatedEntitiesWidgetData10() {
    // Arrange
    AggregateOverlayDiagram aggregateOverlayDiagram = mock(AggregateOverlayDiagram.class);
    when(aggregateOverlayDiagram.aggregatedEntityKind()).thenReturn(EntityKind.APPLICATION);
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any())).thenReturn(aggregateOverlayDiagram);
    AggregatedEntitiesWidgetDao aggregatedEntitiesWidgetDao = mock(AggregatedEntitiesWidgetDao.class);
    when(aggregatedEntitiesWidgetDao.findWidgetData(anyLong(), Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<LocalDate>>any())).thenReturn(new HashSet<>());
    AggregateOverlayDiagramService aggregateOverlayDiagramService = new AggregateOverlayDiagramService(
        aggregateOverlayDiagramDao, mock(AppCountWidgetDao.class), mock(TargetAppCostWidgetDao.class),
        mock(RatingCostWidgetDao.class), mock(AssessmentRatingWidgetDao.class), mock(BackingEntityWidgetDao.class),
        mock(AppCostWidgetDao.class), aggregatedEntitiesWidgetDao, mock(AppChangesWidgetDao.class),
        mock(AggregateOverlayDiagramPresetDao.class), mock(MeasurableDao.class), mock(ApplicationDao.class),
        mock(CostKindDao.class), mock(ComplexityKindDao.class), mock(ComplexityWidgetDao.class),
        mock(AttestationWidgetDao.class));
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter.ratingIds()).thenReturn(new HashSet<>());
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter2 = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter2.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter2.ratingIds()).thenReturn(new HashSet<>());

    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();
    filterParams.add(assessmentBasedSelectionFilter2);
    filterParams.add(assessmentBasedSelectionFilter);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.filters()).thenReturn(selectionFilters);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    AggregatedEntitiesWidgetData actualAggregatedEntitiesWidgetData = aggregateOverlayDiagramService
        .getAggregatedEntitiesWidgetData(1L, filterParams, idSelectionOptions);

    // Assert
    verify(aggregateOverlayDiagramDao).getById(eq(1L));
    verify(aggregatedEntitiesWidgetDao).findWidgetData(eq(1L), eq(EntityKind.APPLICATION), isA(Select.class),
        isA(Optional.class));
    verify(assessmentBasedSelectionFilter2).definitionId();
    verify(assessmentBasedSelectionFilter).definitionId();
    verify(assessmentBasedSelectionFilter2).ratingIds();
    verify(assessmentBasedSelectionFilter).ratingIds();
    verify(entityReference, atLeast(1)).id();
    verify(entityReference).kind();
    verify(idSelectionOptions).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions).filters();
    verify(idSelectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    verify(aggregateOverlayDiagram, atLeast(1)).aggregatedEntityKind();
    assertTrue(actualAggregatedEntitiesWidgetData instanceof ImmutableAggregatedEntitiesWidgetData);
    assertTrue(actualAggregatedEntitiesWidgetData.cellData().isEmpty());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramService#getBackingEntityWidgetData(Long)}
   */
  @Test
  void testGetBackingEntityWidgetData() {
    // Arrange
    BackingEntityWidgetDao backingEntityWidgetDao = mock(BackingEntityWidgetDao.class);
    when(backingEntityWidgetDao.findWidgetData(anyLong())).thenReturn(new HashSet<>());

    // Act
    BackingEntityWidgetData actualBackingEntityWidgetData = (new AggregateOverlayDiagramService(
        mock(AggregateOverlayDiagramDao.class), mock(AppCountWidgetDao.class), mock(TargetAppCostWidgetDao.class),
        mock(RatingCostWidgetDao.class), mock(AssessmentRatingWidgetDao.class), backingEntityWidgetDao,
        mock(AppCostWidgetDao.class), mock(AggregatedEntitiesWidgetDao.class), mock(AppChangesWidgetDao.class),
        mock(AggregateOverlayDiagramPresetDao.class), mock(MeasurableDao.class), mock(ApplicationDao.class),
        mock(CostKindDao.class), mock(ComplexityKindDao.class), mock(ComplexityWidgetDao.class),
        mock(AttestationWidgetDao.class))).getBackingEntityWidgetData(1L);

    // Assert
    verify(backingEntityWidgetDao).findWidgetData(eq(1L));
    assertTrue(actualBackingEntityWidgetData instanceof ImmutableBackingEntityWidgetData);
    assertTrue(actualBackingEntityWidgetData.cellData().isEmpty());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramService#getBackingEntityWidgetData(Long)}
   */
  @Test
  void testGetBackingEntityWidgetData2() {
    // Arrange
    HashSet<BackingEntityWidgetDatum> backingEntityWidgetDatumSet = new HashSet<>();
    backingEntityWidgetDatumSet.add(mock(BackingEntityWidgetDatum.class));
    BackingEntityWidgetDao backingEntityWidgetDao = mock(BackingEntityWidgetDao.class);
    when(backingEntityWidgetDao.findWidgetData(anyLong())).thenReturn(backingEntityWidgetDatumSet);

    // Act
    BackingEntityWidgetData actualBackingEntityWidgetData = (new AggregateOverlayDiagramService(
        mock(AggregateOverlayDiagramDao.class), mock(AppCountWidgetDao.class), mock(TargetAppCostWidgetDao.class),
        mock(RatingCostWidgetDao.class), mock(AssessmentRatingWidgetDao.class), backingEntityWidgetDao,
        mock(AppCostWidgetDao.class), mock(AggregatedEntitiesWidgetDao.class), mock(AppChangesWidgetDao.class),
        mock(AggregateOverlayDiagramPresetDao.class), mock(MeasurableDao.class), mock(ApplicationDao.class),
        mock(CostKindDao.class), mock(ComplexityKindDao.class), mock(ComplexityWidgetDao.class),
        mock(AttestationWidgetDao.class))).getBackingEntityWidgetData(1L);

    // Assert
    verify(backingEntityWidgetDao).findWidgetData(eq(1L));
    assertTrue(actualBackingEntityWidgetData instanceof ImmutableBackingEntityWidgetData);
    assertEquals(1, actualBackingEntityWidgetData.cellData().size());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramService#getBackingEntityWidgetData(Long)}
   */
  @Test
  void testGetBackingEntityWidgetData3() {
    // Arrange
    HashSet<BackingEntityWidgetDatum> backingEntityWidgetDatumSet = new HashSet<>();
    backingEntityWidgetDatumSet.add(mock(BackingEntityWidgetDatum.class));
    backingEntityWidgetDatumSet.add(mock(BackingEntityWidgetDatum.class));
    BackingEntityWidgetDao backingEntityWidgetDao = mock(BackingEntityWidgetDao.class);
    when(backingEntityWidgetDao.findWidgetData(anyLong())).thenReturn(backingEntityWidgetDatumSet);

    // Act
    BackingEntityWidgetData actualBackingEntityWidgetData = (new AggregateOverlayDiagramService(
        mock(AggregateOverlayDiagramDao.class), mock(AppCountWidgetDao.class), mock(TargetAppCostWidgetDao.class),
        mock(RatingCostWidgetDao.class), mock(AssessmentRatingWidgetDao.class), backingEntityWidgetDao,
        mock(AppCostWidgetDao.class), mock(AggregatedEntitiesWidgetDao.class), mock(AppChangesWidgetDao.class),
        mock(AggregateOverlayDiagramPresetDao.class), mock(MeasurableDao.class), mock(ApplicationDao.class),
        mock(CostKindDao.class), mock(ComplexityKindDao.class), mock(ComplexityWidgetDao.class),
        mock(AttestationWidgetDao.class))).getBackingEntityWidgetData(1L);

    // Assert
    verify(backingEntityWidgetDao).findWidgetData(eq(1L));
    assertTrue(actualBackingEntityWidgetData instanceof ImmutableBackingEntityWidgetData);
    assertEquals(backingEntityWidgetDatumSet, actualBackingEntityWidgetData.cellData());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramService#findPresetsForDiagram(Long)}
   */
  @Test
  void testFindPresetsForDiagram() {
    // Arrange
    AggregateOverlayDiagramPresetDao aggregateOverlayDiagramPresetDao = mock(AggregateOverlayDiagramPresetDao.class);
    HashSet<AggregateOverlayDiagramPreset> aggregateOverlayDiagramPresetSet = new HashSet<>();
    when(aggregateOverlayDiagramPresetDao.findPresetsForDiagram(Mockito.<Long>any()))
        .thenReturn(aggregateOverlayDiagramPresetSet);

    // Act
    Set<AggregateOverlayDiagramPreset> actualFindPresetsForDiagramResult = (new AggregateOverlayDiagramService(
        mock(AggregateOverlayDiagramDao.class), mock(AppCountWidgetDao.class), mock(TargetAppCostWidgetDao.class),
        mock(RatingCostWidgetDao.class), mock(AssessmentRatingWidgetDao.class), mock(BackingEntityWidgetDao.class),
        mock(AppCostWidgetDao.class), mock(AggregatedEntitiesWidgetDao.class), mock(AppChangesWidgetDao.class),
        aggregateOverlayDiagramPresetDao, mock(MeasurableDao.class), mock(ApplicationDao.class),
        mock(CostKindDao.class), mock(ComplexityKindDao.class), mock(ComplexityWidgetDao.class),
        mock(AttestationWidgetDao.class))).findPresetsForDiagram(1L);

    // Assert
    verify(aggregateOverlayDiagramPresetDao).findPresetsForDiagram(eq(1L));
    assertTrue(actualFindPresetsForDiagramResult.isEmpty());
    assertSame(aggregateOverlayDiagramPresetSet, actualFindPresetsForDiagramResult);
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramService#createPreset(OverlayDiagramPresetCreateCommand, String)}
   */
  @Test
  void testCreatePreset() {
    // Arrange
    AggregateOverlayDiagramPresetDao aggregateOverlayDiagramPresetDao = mock(AggregateOverlayDiagramPresetDao.class);
    when(aggregateOverlayDiagramPresetDao.create(Mockito.<OverlayDiagramPresetCreateCommand>any(),
        Mockito.<String>any())).thenReturn(1);

    // Act
    int actualCreatePresetResult = (new AggregateOverlayDiagramService(mock(AggregateOverlayDiagramDao.class),
        mock(AppCountWidgetDao.class), mock(TargetAppCostWidgetDao.class), mock(RatingCostWidgetDao.class),
        mock(AssessmentRatingWidgetDao.class), mock(BackingEntityWidgetDao.class), mock(AppCostWidgetDao.class),
        mock(AggregatedEntitiesWidgetDao.class), mock(AppChangesWidgetDao.class), aggregateOverlayDiagramPresetDao,
        mock(MeasurableDao.class), mock(ApplicationDao.class), mock(CostKindDao.class), mock(ComplexityKindDao.class),
        mock(ComplexityWidgetDao.class), mock(AttestationWidgetDao.class))).createPreset(null, "janedoe");

    // Assert
    verify(aggregateOverlayDiagramPresetDao).create(isNull(), eq("janedoe"));
    assertEquals(1, actualCreatePresetResult);
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramService#getAppComplexityWidgetData(long, Set, IdSelectionOptions, AppComplexityWidgetParameters)}
   */
  @Test
  void testGetAppComplexityWidgetData() {
    // Arrange
    AggregateOverlayDiagram aggregateOverlayDiagram = mock(AggregateOverlayDiagram.class);
    when(aggregateOverlayDiagram.aggregatedEntityKind()).thenReturn(EntityKind.APPLICATION);
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any())).thenReturn(aggregateOverlayDiagram);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(new ArrayList<>());
    ComplexityKindDao complexityKindDao = mock(ComplexityKindDao.class);
    when(complexityKindDao.findAll()).thenReturn(new HashSet<>());
    ComplexityWidgetDao complexityWidgetDao = mock(ComplexityWidgetDao.class);
    when(complexityWidgetDao.findWidgetData(anyLong(), Mockito.<EntityKind>any(), Mockito.<Set<Long>>any(),
        Mockito.<Select<Record1<Long>>>any())).thenReturn(new HashSet<>());
    AggregateOverlayDiagramService aggregateOverlayDiagramService = new AggregateOverlayDiagramService(
        aggregateOverlayDiagramDao, mock(AppCountWidgetDao.class), mock(TargetAppCostWidgetDao.class),
        mock(RatingCostWidgetDao.class), mock(AssessmentRatingWidgetDao.class), mock(BackingEntityWidgetDao.class),
        mock(AppCostWidgetDao.class), mock(AggregatedEntitiesWidgetDao.class), mock(AppChangesWidgetDao.class),
        mock(AggregateOverlayDiagramPresetDao.class), mock(MeasurableDao.class), applicationDao,
        mock(CostKindDao.class), complexityKindDao, complexityWidgetDao, mock(AttestationWidgetDao.class));
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter.ratingIds()).thenReturn(new HashSet<>());
    AssessmentBasedSelectionFilter assessmentBasedSelectionFilter2 = mock(AssessmentBasedSelectionFilter.class);
    when(assessmentBasedSelectionFilter2.definitionId()).thenReturn(1L);
    when(assessmentBasedSelectionFilter2.ratingIds()).thenReturn(new HashSet<>());

    HashSet<AssessmentBasedSelectionFilter> assessmentBasedSelectionFilters = new HashSet<>();
    assessmentBasedSelectionFilters.add(assessmentBasedSelectionFilter2);
    assessmentBasedSelectionFilters.add(assessmentBasedSelectionFilter);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.filters()).thenReturn(selectionFilters);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);
    AppComplexityWidgetParameters complexityWidgetParameters = mock(AppComplexityWidgetParameters.class);
    when(complexityWidgetParameters.complexityKindIds()).thenReturn(new HashSet<>());

    // Act
    ComplexityWidgetData actualAppComplexityWidgetData = aggregateOverlayDiagramService.getAppComplexityWidgetData(1L,
        assessmentBasedSelectionFilters, idSelectionOptions, complexityWidgetParameters);

    // Assert
    verify(aggregateOverlayDiagramDao).getById(eq(1L));
    verify(complexityWidgetDao).findWidgetData(eq(1L), eq(EntityKind.APPLICATION), isA(Set.class), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(complexityKindDao).findAll();
    verify(assessmentBasedSelectionFilter2).definitionId();
    verify(assessmentBasedSelectionFilter).definitionId();
    verify(assessmentBasedSelectionFilter2).ratingIds();
    verify(assessmentBasedSelectionFilter).ratingIds();
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(idSelectionOptions).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions).filters();
    verify(idSelectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    verify(aggregateOverlayDiagram, atLeast(1)).aggregatedEntityKind();
    verify(complexityWidgetParameters).complexityKindIds();
    assertTrue(actualAppComplexityWidgetData instanceof ImmutableComplexityWidgetData);
    Set<Application> applicationsResult = actualAppComplexityWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualAppComplexityWidgetData.cellData());
    assertSame(applicationsResult, actualAppComplexityWidgetData.complexityKinds());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramService#save(OverlayDiagramSaveCommand, String)}
   */
  @Test
  void testSave() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    doNothing().when(aggregateOverlayDiagramDao)
        .updateBackingEntities(Mockito.<Long>any(), Mockito.<Set<BackingEntity>>any());
    when(aggregateOverlayDiagramDao.save(Mockito.<OverlayDiagramSaveCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
    AggregateOverlayDiagramService aggregateOverlayDiagramService = new AggregateOverlayDiagramService(
        aggregateOverlayDiagramDao, mock(AppCountWidgetDao.class), mock(TargetAppCostWidgetDao.class),
        mock(RatingCostWidgetDao.class), mock(AssessmentRatingWidgetDao.class), mock(BackingEntityWidgetDao.class),
        mock(AppCostWidgetDao.class), mock(AggregatedEntitiesWidgetDao.class), mock(AppChangesWidgetDao.class),
        mock(AggregateOverlayDiagramPresetDao.class), mock(MeasurableDao.class), mock(ApplicationDao.class),
        mock(CostKindDao.class), mock(ComplexityKindDao.class), mock(ComplexityWidgetDao.class),
        mock(AttestationWidgetDao.class));
    OverlayDiagramSaveCommand saveCmd = mock(OverlayDiagramSaveCommand.class);
    when(saveCmd.backingEntities()).thenReturn(new HashSet<>());

    // Act
    Long actualSaveResult = aggregateOverlayDiagramService.save(saveCmd, "janedoe");

    // Assert
    verify(aggregateOverlayDiagramDao).save(isA(OverlayDiagramSaveCommand.class), eq("janedoe"));
    verify(aggregateOverlayDiagramDao).updateBackingEntities(eq(1L), isA(Set.class));
    verify(saveCmd).backingEntities();
    assertEquals(1L, actualSaveResult.longValue());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramService#updateStatus(long, ReleaseLifecycleStatusChangeCommand, String)}
   */
  @Test
  void testUpdateStatus() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.updateStatus(anyLong(), Mockito.<ReleaseLifecycleStatusChangeCommand>any()))
        .thenReturn(true);

    // Act
    Boolean actualUpdateStatusResult = (new AggregateOverlayDiagramService(aggregateOverlayDiagramDao,
        mock(AppCountWidgetDao.class), mock(TargetAppCostWidgetDao.class), mock(RatingCostWidgetDao.class),
        mock(AssessmentRatingWidgetDao.class), mock(BackingEntityWidgetDao.class), mock(AppCostWidgetDao.class),
        mock(AggregatedEntitiesWidgetDao.class), mock(AppChangesWidgetDao.class),
        mock(AggregateOverlayDiagramPresetDao.class), mock(MeasurableDao.class), mock(ApplicationDao.class),
        mock(CostKindDao.class), mock(ComplexityKindDao.class), mock(ComplexityWidgetDao.class),
        mock(AttestationWidgetDao.class))).updateStatus(1L, null, "janedoe");

    // Assert
    verify(aggregateOverlayDiagramDao).updateStatus(eq(1L), isNull());
    assertTrue(actualUpdateStatusResult);
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramService#updateStatus(long, ReleaseLifecycleStatusChangeCommand, String)}
   */
  @Test
  void testUpdateStatus2() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.updateStatus(anyLong(), Mockito.<ReleaseLifecycleStatusChangeCommand>any()))
        .thenReturn(false);

    // Act
    Boolean actualUpdateStatusResult = (new AggregateOverlayDiagramService(aggregateOverlayDiagramDao,
        mock(AppCountWidgetDao.class), mock(TargetAppCostWidgetDao.class), mock(RatingCostWidgetDao.class),
        mock(AssessmentRatingWidgetDao.class), mock(BackingEntityWidgetDao.class), mock(AppCostWidgetDao.class),
        mock(AggregatedEntitiesWidgetDao.class), mock(AppChangesWidgetDao.class),
        mock(AggregateOverlayDiagramPresetDao.class), mock(MeasurableDao.class), mock(ApplicationDao.class),
        mock(CostKindDao.class), mock(ComplexityKindDao.class), mock(ComplexityWidgetDao.class),
        mock(AttestationWidgetDao.class))).updateStatus(1L, null, "janedoe");

    // Assert
    verify(aggregateOverlayDiagramDao).updateStatus(eq(1L), isNull());
    assertFalse(actualUpdateStatusResult);
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramService#getApplicationChangeWidgetData(long, IdSelectionOptions, AppChangeWidgetParameters)}
   */
  @Test
  void testGetApplicationChangeWidgetData() {
    // Arrange
    AggregateOverlayDiagram aggregateOverlayDiagram = mock(AggregateOverlayDiagram.class);
    when(aggregateOverlayDiagram.aggregatedEntityKind()).thenReturn(EntityKind.APPLICATION);
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any())).thenReturn(aggregateOverlayDiagram);
    AppChangesWidgetDao appChangesWidgetDao = mock(AppChangesWidgetDao.class);
    when(appChangesWidgetDao.findWidgetData(anyLong(), Mockito.<Select<Record1<Long>>>any(),
        Mockito.<Optional<LocalDate>>any())).thenReturn(new HashSet<>());
    AggregateOverlayDiagramService aggregateOverlayDiagramService = new AggregateOverlayDiagramService(
        aggregateOverlayDiagramDao, mock(AppCountWidgetDao.class), mock(TargetAppCostWidgetDao.class),
        mock(RatingCostWidgetDao.class), mock(AssessmentRatingWidgetDao.class), mock(BackingEntityWidgetDao.class),
        mock(AppCostWidgetDao.class), mock(AggregatedEntitiesWidgetDao.class), appChangesWidgetDao,
        mock(AggregateOverlayDiagramPresetDao.class), mock(MeasurableDao.class), mock(ApplicationDao.class),
        mock(CostKindDao.class), mock(ComplexityKindDao.class), mock(ComplexityWidgetDao.class),
        mock(AttestationWidgetDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.filters()).thenReturn(selectionFilters);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);
    AppChangeWidgetParameters overlayParameters = mock(AppChangeWidgetParameters.class);
    when(overlayParameters.targetDate()).thenReturn(LocalDate.of(1970, 1, 1));

    // Act
    ApplicationChangeWidgetData actualApplicationChangeWidgetData = aggregateOverlayDiagramService
        .getApplicationChangeWidgetData(1L, idSelectionOptions, overlayParameters);

    // Assert
    verify(aggregateOverlayDiagramDao).getById(eq(1L));
    verify(appChangesWidgetDao).findWidgetData(eq(1L), isA(Select.class), isA(Optional.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(idSelectionOptions).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions).filters();
    verify(idSelectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    verify(aggregateOverlayDiagram).aggregatedEntityKind();
    verify(overlayParameters).targetDate();
    assertTrue(actualApplicationChangeWidgetData instanceof ImmutableApplicationChangeWidgetData);
    assertTrue(actualApplicationChangeWidgetData.cellData().isEmpty());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramService#getApplicationChangeWidgetData(long, IdSelectionOptions, AppChangeWidgetParameters)}
   */
  @Test
  void testGetApplicationChangeWidgetData2() {
    // Arrange
    AggregateOverlayDiagram aggregateOverlayDiagram = mock(AggregateOverlayDiagram.class);
    when(aggregateOverlayDiagram.aggregatedEntityKind()).thenReturn(EntityKind.APPLICATION);
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any())).thenReturn(aggregateOverlayDiagram);

    HashSet<ApplicationChangeWidgetDatum> applicationChangeWidgetDatumSet = new HashSet<>();
    applicationChangeWidgetDatumSet.add(mock(ApplicationChangeWidgetDatum.class));
    AppChangesWidgetDao appChangesWidgetDao = mock(AppChangesWidgetDao.class);
    when(appChangesWidgetDao.findWidgetData(anyLong(), Mockito.<Select<Record1<Long>>>any(),
        Mockito.<Optional<LocalDate>>any())).thenReturn(applicationChangeWidgetDatumSet);
    AggregateOverlayDiagramService aggregateOverlayDiagramService = new AggregateOverlayDiagramService(
        aggregateOverlayDiagramDao, mock(AppCountWidgetDao.class), mock(TargetAppCostWidgetDao.class),
        mock(RatingCostWidgetDao.class), mock(AssessmentRatingWidgetDao.class), mock(BackingEntityWidgetDao.class),
        mock(AppCostWidgetDao.class), mock(AggregatedEntitiesWidgetDao.class), appChangesWidgetDao,
        mock(AggregateOverlayDiagramPresetDao.class), mock(MeasurableDao.class), mock(ApplicationDao.class),
        mock(CostKindDao.class), mock(ComplexityKindDao.class), mock(ComplexityWidgetDao.class),
        mock(AttestationWidgetDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.filters()).thenReturn(selectionFilters);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);
    AppChangeWidgetParameters overlayParameters = mock(AppChangeWidgetParameters.class);
    when(overlayParameters.targetDate()).thenReturn(LocalDate.of(1970, 1, 1));

    // Act
    ApplicationChangeWidgetData actualApplicationChangeWidgetData = aggregateOverlayDiagramService
        .getApplicationChangeWidgetData(1L, idSelectionOptions, overlayParameters);

    // Assert
    verify(aggregateOverlayDiagramDao).getById(eq(1L));
    verify(appChangesWidgetDao).findWidgetData(eq(1L), isA(Select.class), isA(Optional.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(idSelectionOptions).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions).filters();
    verify(idSelectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    verify(aggregateOverlayDiagram).aggregatedEntityKind();
    verify(overlayParameters).targetDate();
    assertTrue(actualApplicationChangeWidgetData instanceof ImmutableApplicationChangeWidgetData);
    assertEquals(1, actualApplicationChangeWidgetData.cellData().size());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramService#getApplicationChangeWidgetData(long, IdSelectionOptions, AppChangeWidgetParameters)}
   */
  @Test
  void testGetApplicationChangeWidgetData3() {
    // Arrange
    AggregateOverlayDiagram aggregateOverlayDiagram = mock(AggregateOverlayDiagram.class);
    when(aggregateOverlayDiagram.aggregatedEntityKind()).thenReturn(EntityKind.APPLICATION);
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any())).thenReturn(aggregateOverlayDiagram);

    HashSet<ApplicationChangeWidgetDatum> applicationChangeWidgetDatumSet = new HashSet<>();
    applicationChangeWidgetDatumSet.add(mock(ApplicationChangeWidgetDatum.class));
    applicationChangeWidgetDatumSet.add(mock(ApplicationChangeWidgetDatum.class));
    AppChangesWidgetDao appChangesWidgetDao = mock(AppChangesWidgetDao.class);
    when(appChangesWidgetDao.findWidgetData(anyLong(), Mockito.<Select<Record1<Long>>>any(),
        Mockito.<Optional<LocalDate>>any())).thenReturn(applicationChangeWidgetDatumSet);
    AggregateOverlayDiagramService aggregateOverlayDiagramService = new AggregateOverlayDiagramService(
        aggregateOverlayDiagramDao, mock(AppCountWidgetDao.class), mock(TargetAppCostWidgetDao.class),
        mock(RatingCostWidgetDao.class), mock(AssessmentRatingWidgetDao.class), mock(BackingEntityWidgetDao.class),
        mock(AppCostWidgetDao.class), mock(AggregatedEntitiesWidgetDao.class), appChangesWidgetDao,
        mock(AggregateOverlayDiagramPresetDao.class), mock(MeasurableDao.class), mock(ApplicationDao.class),
        mock(CostKindDao.class), mock(ComplexityKindDao.class), mock(ComplexityWidgetDao.class),
        mock(AttestationWidgetDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.filters()).thenReturn(selectionFilters);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);
    AppChangeWidgetParameters overlayParameters = mock(AppChangeWidgetParameters.class);
    when(overlayParameters.targetDate()).thenReturn(LocalDate.of(1970, 1, 1));

    // Act
    ApplicationChangeWidgetData actualApplicationChangeWidgetData = aggregateOverlayDiagramService
        .getApplicationChangeWidgetData(1L, idSelectionOptions, overlayParameters);

    // Assert
    verify(aggregateOverlayDiagramDao).getById(eq(1L));
    verify(appChangesWidgetDao).findWidgetData(eq(1L), isA(Select.class), isA(Optional.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(idSelectionOptions).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions).filters();
    verify(idSelectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    verify(aggregateOverlayDiagram).aggregatedEntityKind();
    verify(overlayParameters).targetDate();
    assertTrue(actualApplicationChangeWidgetData instanceof ImmutableApplicationChangeWidgetData);
    assertEquals(applicationChangeWidgetDatumSet, actualApplicationChangeWidgetData.cellData());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramService#getApplicationChangeWidgetData(long, IdSelectionOptions, AppChangeWidgetParameters)}
   */
  @Test
  void testGetApplicationChangeWidgetData4() {
    // Arrange
    AggregateOverlayDiagram aggregateOverlayDiagram = mock(AggregateOverlayDiagram.class);
    when(aggregateOverlayDiagram.aggregatedEntityKind()).thenReturn(EntityKind.APPLICATION);
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any())).thenReturn(aggregateOverlayDiagram);
    AppChangesWidgetDao appChangesWidgetDao = mock(AppChangesWidgetDao.class);
    when(appChangesWidgetDao.findWidgetData(anyLong(), Mockito.<Select<Record1<Long>>>any(),
        Mockito.<Optional<LocalDate>>any())).thenReturn(new HashSet<>());
    AggregateOverlayDiagramService aggregateOverlayDiagramService = new AggregateOverlayDiagramService(
        aggregateOverlayDiagramDao, mock(AppCountWidgetDao.class), mock(TargetAppCostWidgetDao.class),
        mock(RatingCostWidgetDao.class), mock(AssessmentRatingWidgetDao.class), mock(BackingEntityWidgetDao.class),
        mock(AppCostWidgetDao.class), mock(AggregatedEntitiesWidgetDao.class), appChangesWidgetDao,
        mock(AggregateOverlayDiagramPresetDao.class), mock(MeasurableDao.class), mock(ApplicationDao.class),
        mock(CostKindDao.class), mock(ComplexityKindDao.class), mock(ComplexityWidgetDao.class),
        mock(AttestationWidgetDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);
    AppChangeWidgetParameters overlayParameters = mock(AppChangeWidgetParameters.class);
    when(overlayParameters.targetDate()).thenReturn(LocalDate.of(1970, 1, 1));

    // Act
    ApplicationChangeWidgetData actualApplicationChangeWidgetData = aggregateOverlayDiagramService
        .getApplicationChangeWidgetData(1L, idSelectionOptions, overlayParameters);

    // Assert
    verify(aggregateOverlayDiagramDao).getById(eq(1L));
    verify(appChangesWidgetDao).findWidgetData(eq(1L), isA(Select.class), isA(Optional.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions).scope();
    verify(aggregateOverlayDiagram).aggregatedEntityKind();
    verify(overlayParameters).targetDate();
    assertTrue(actualApplicationChangeWidgetData instanceof ImmutableApplicationChangeWidgetData);
    assertTrue(actualApplicationChangeWidgetData.cellData().isEmpty());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramService#getApplicationChangeWidgetData(long, IdSelectionOptions, AppChangeWidgetParameters)}
   */
  @Test
  void testGetApplicationChangeWidgetData5() {
    // Arrange
    AggregateOverlayDiagram aggregateOverlayDiagram = mock(AggregateOverlayDiagram.class);
    when(aggregateOverlayDiagram.aggregatedEntityKind()).thenReturn(EntityKind.APPLICATION);
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any())).thenReturn(aggregateOverlayDiagram);
    AppChangesWidgetDao appChangesWidgetDao = mock(AppChangesWidgetDao.class);
    when(appChangesWidgetDao.findWidgetData(anyLong(), Mockito.<Select<Record1<Long>>>any(),
        Mockito.<Optional<LocalDate>>any())).thenReturn(new HashSet<>());
    AggregateOverlayDiagramService aggregateOverlayDiagramService = new AggregateOverlayDiagramService(
        aggregateOverlayDiagramDao, mock(AppCountWidgetDao.class), mock(TargetAppCostWidgetDao.class),
        mock(RatingCostWidgetDao.class), mock(AssessmentRatingWidgetDao.class), mock(BackingEntityWidgetDao.class),
        mock(AppCostWidgetDao.class), mock(AggregatedEntitiesWidgetDao.class), appChangesWidgetDao,
        mock(AggregateOverlayDiagramPresetDao.class), mock(MeasurableDao.class), mock(ApplicationDao.class),
        mock(CostKindDao.class), mock(ComplexityKindDao.class), mock(ComplexityWidgetDao.class),
        mock(AttestationWidgetDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.filters()).thenReturn(selectionFilters);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);
    AppChangeWidgetParameters overlayParameters = mock(AppChangeWidgetParameters.class);
    when(overlayParameters.targetDate()).thenReturn(LocalDate.of(1970, 1, 1));

    // Act
    ApplicationChangeWidgetData actualApplicationChangeWidgetData = aggregateOverlayDiagramService
        .getApplicationChangeWidgetData(1L, idSelectionOptions, overlayParameters);

    // Assert
    verify(aggregateOverlayDiagramDao).getById(eq(1L));
    verify(appChangesWidgetDao).findWidgetData(eq(1L), isA(Select.class), isA(Optional.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference).kind();
    verify(idSelectionOptions).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions).filters();
    verify(idSelectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    verify(aggregateOverlayDiagram).aggregatedEntityKind();
    verify(overlayParameters).targetDate();
    assertTrue(actualApplicationChangeWidgetData instanceof ImmutableApplicationChangeWidgetData);
    assertTrue(actualApplicationChangeWidgetData.cellData().isEmpty());
  }
}
