package org.finos.waltz.service.aggregate_overlay_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
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
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableAssessmentBasedSelectionFilter;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.ReleaseLifecycleStatusChangeCommand;
import org.finos.waltz.model.aggregate_overlay_diagram.AggregateOverlayDiagram;
import org.finos.waltz.model.aggregate_overlay_diagram.AggregateOverlayDiagramInfo;
import org.finos.waltz.model.aggregate_overlay_diagram.AggregateOverlayDiagramPreset;
import org.finos.waltz.model.aggregate_overlay_diagram.BackingEntity;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagram;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagramInfo;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableBackingEntity;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableOverlayDiagramSaveCommand;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramKind;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramPresetCreateCommand;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramSaveCommand;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.AllocationDerivation;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ApplicationChangeWidgetData;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ApplicationChangeWidgetDatum;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.AttestationWidgetData;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.AttestationWidgetDatum;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.BackingEntityWidgetData;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.BackingEntityWidgetDatum;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ComplexityWidgetData;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ComplexityWidgetDatum;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.CostWidgetData;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.CostWidgetDatum;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableApplicationChangeWidgetData;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableApplicationChangeWidgetDatum;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableAttestationWidgetData;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableAttestationWidgetDatum;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableBackingEntityWidgetData;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableBackingEntityWidgetDatum;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableComplexityWidgetData;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableComplexityWidgetDatum;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableCostWidgetData;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableCostWidgetDatum;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableMeasurableCostEntry;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableTargetCostWidgetData;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableTargetCostWidgetDatum;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.TargetCostWidgetData;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.TargetCostWidgetDatum;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.AppChangeWidgetParameters;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.AppComplexityWidgetParameters;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.AppCostWidgetParameters;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.AttestationWidgetParameters;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableAppChangeWidgetParameters;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableAppComplexityWidgetParameters;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableAppCostWidgetParameters;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableAttestationWidgetParameters;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableRatingCostWidgetParameters;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableTargetAppCostWidgetParameters;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.RatingCostWidgetParameters;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.TargetAppCostWidgetParameters;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.ImmutableApplication;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.complexity.ComplexityKind;
import org.finos.waltz.model.complexity.ImmutableComplexityKind;
import org.finos.waltz.model.cost.CostKindWithYears;
import org.finos.waltz.model.cost.ImmutableCostKindWithYears;
import org.finos.waltz.model.cost.ImmutableEntityCostKind;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.measurable.ImmutableMeasurable;
import org.finos.waltz.model.measurable.Measurable;
import org.finos.waltz.model.rating.RagRating;
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
class AggregateOverlayDiagramServiceDiffblueTest {
  @Mock private AggregateOverlayDiagramDao aggregateOverlayDiagramDao;

  @InjectMocks private AggregateOverlayDiagramService aggregateOverlayDiagramService;

  @Mock private AppChangesWidgetDao appChangesWidgetDao;

  @Mock private AppCostWidgetDao appCostWidgetDao;

  @Mock private ApplicationDao applicationDao;

  @Mock private CostKindDao costKindDao;

  @Mock private MeasurableDao measurableDao;

  @Mock private RatingCostWidgetDao ratingCostWidgetDao;

  /**
   * Test {@link AggregateOverlayDiagramService#getById(Long)}.
   *
   * <ul>
   *   <li>Then return backingEntities Empty.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getById(Long)}
   */
  @Test
  @DisplayName("Test getById(Long); then return backingEntities Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AggregateOverlayDiagramInfo AggregateOverlayDiagramService.getById(Long)"})
  void testGetById_thenReturnBackingEntitiesEmpty() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.findBackingEntities(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.ALL)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());
    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            mock(ApplicationDao.class),
            mock(CostKindDao.class),
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));

    // Act
    AggregateOverlayDiagramInfo actualById = aggregateOverlayDiagramService.getById(1L);

    // Assert
    verify(aggregateOverlayDiagramDao).findBackingEntities(1L);
    verify(aggregateOverlayDiagramDao).getById(1L);
    AggregateOverlayDiagram diagramResult = actualById.diagram();
    assertTrue(diagramResult instanceof ImmutableAggregateOverlayDiagram);
    assertTrue(actualById instanceof ImmutableAggregateOverlayDiagramInfo);
    assertEquals("2020-03-01", diagramResult.lastUpdatedBy());
    assertEquals("Layout Data", diagramResult.layoutData());
    assertEquals("Name", diagramResult.name());
    assertEquals("Provenance", diagramResult.provenance());
    assertEquals("The characteristics of someone or something", diagramResult.description());
    assertEquals(EntityKind.ALL, diagramResult.aggregatedEntityKind());
    assertEquals(EntityKind.ALL, diagramResult.kind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, diagramResult.status());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, diagramResult.diagramKind());
    assertTrue(actualById.backingEntities().isEmpty());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getById(Long)}.
   *
   * <ul>
   *   <li>Then return backingEntities size is one.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getById(Long)}
   */
  @Test
  @DisplayName("Test getById(Long); then return backingEntities size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AggregateOverlayDiagramInfo AggregateOverlayDiagramService.getById(Long)"})
  void testGetById_thenReturnBackingEntitiesSizeIsOne() {
    // Arrange
    HashSet<BackingEntity> backingEntitySet = new HashSet<>();

    ImmutableBackingEntity.Builder cellIdResult = ImmutableBackingEntity.builder().cellId("42");
    backingEntitySet.add(
        cellIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.findBackingEntities(Mockito.<Long>any()))
        .thenReturn(backingEntitySet);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.ALL)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());
    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            mock(ApplicationDao.class),
            mock(CostKindDao.class),
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));

    // Act
    AggregateOverlayDiagramInfo actualById = aggregateOverlayDiagramService.getById(1L);

    // Assert
    verify(aggregateOverlayDiagramDao).findBackingEntities(1L);
    verify(aggregateOverlayDiagramDao).getById(1L);
    AggregateOverlayDiagram diagramResult = actualById.diagram();
    assertTrue(diagramResult instanceof ImmutableAggregateOverlayDiagram);
    assertTrue(actualById instanceof ImmutableAggregateOverlayDiagramInfo);
    assertEquals("2020-03-01", diagramResult.lastUpdatedBy());
    assertEquals("Layout Data", diagramResult.layoutData());
    assertEquals("Name", diagramResult.name());
    assertEquals("Provenance", diagramResult.provenance());
    assertEquals("The characteristics of someone or something", diagramResult.description());
    assertEquals(1, actualById.backingEntities().size());
    assertEquals(EntityKind.ALL, diagramResult.aggregatedEntityKind());
    assertEquals(EntityKind.ALL, diagramResult.kind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, diagramResult.status());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, diagramResult.diagramKind());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#findAll()}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AggregateOverlayDiagramService.findAll()"})
  void testFindAll() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.findAll()).thenReturn(new HashSet<>());
    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            mock(ApplicationDao.class),
            mock(CostKindDao.class),
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));

    // Act
    Set<AggregateOverlayDiagram> actualFindAllResult = aggregateOverlayDiagramService.findAll();

    // Assert
    verify(aggregateOverlayDiagramDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#findByKind(OverlayDiagramKind)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#findByKind(OverlayDiagramKind)}
   */
  @Test
  @DisplayName("Test findByKind(OverlayDiagramKind); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AggregateOverlayDiagramService.findByKind(OverlayDiagramKind)"})
  void testFindByKind_thenReturnEmpty() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.findByKind(Mockito.<OverlayDiagramKind>any()))
        .thenReturn(new HashSet<>());
    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            mock(ApplicationDao.class),
            mock(CostKindDao.class),
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));

    // Act
    Set<AggregateOverlayDiagram> actualFindByKindResult =
        aggregateOverlayDiagramService.findByKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY);

    // Assert
    verify(aggregateOverlayDiagramDao).findByKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY);
    assertTrue(actualFindByKindResult.isEmpty());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getTargetAppCostWidgetData(Long, IdSelectionOptions,
   * Set, TargetAppCostWidgetParameters)}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getTargetAppCostWidgetData(Long,
   * IdSelectionOptions, Set, TargetAppCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getTargetAppCostWidgetData(Long, IdSelectionOptions, Set, TargetAppCostWidgetParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TargetCostWidgetData AggregateOverlayDiagramService.getTargetAppCostWidgetData(Long, IdSelectionOptions, Set, TargetAppCostWidgetParameters)"
  })
  void testGetTargetAppCostWidgetData() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    TargetAppCostWidgetDao targetAppCostWidgetDao = mock(TargetAppCostWidgetDao.class);
    when(targetAppCostWidgetDao.findWidgetData(
            anyLong(), Mockito.<Select<Record1<Long>>>any(), Mockito.<LocalDate>any()))
        .thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            targetAppCostWidgetDao,
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            mock(ApplicationDao.class),
            mock(CostKindDao.class),
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));

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
    ImmutableIdSelectionOptions appSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

    // Act
    TargetCostWidgetData actualTargetAppCostWidgetData =
        aggregateOverlayDiagramService.getTargetAppCostWidgetData(
            1L,
            appSelectionOptions,
            filterParams,
            ImmutableTargetAppCostWidgetParameters.builder()
                .targetDate(LocalDate.of(1970, 1, 1))
                .build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(targetAppCostWidgetDao).findWidgetData(eq(1L), isA(Select.class), isA(LocalDate.class));
    assertTrue(actualTargetAppCostWidgetData instanceof ImmutableTargetCostWidgetData);
    assertTrue(actualTargetAppCostWidgetData.cellData().isEmpty());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getTargetAppCostWidgetData(Long, IdSelectionOptions,
   * Set, TargetAppCostWidgetParameters)}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getTargetAppCostWidgetData(Long,
   * IdSelectionOptions, Set, TargetAppCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getTargetAppCostWidgetData(Long, IdSelectionOptions, Set, TargetAppCostWidgetParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TargetCostWidgetData AggregateOverlayDiagramService.getTargetAppCostWidgetData(Long, IdSelectionOptions, Set, TargetAppCostWidgetParameters)"
  })
  void testGetTargetAppCostWidgetData2() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    TargetAppCostWidgetDao targetAppCostWidgetDao = mock(TargetAppCostWidgetDao.class);
    when(targetAppCostWidgetDao.findWidgetData(
            anyLong(), Mockito.<Select<Record1<Long>>>any(), Mockito.<LocalDate>any()))
        .thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            targetAppCostWidgetDao,
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            mock(ApplicationDao.class),
            mock(CostKindDao.class),
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));

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
    ImmutableIdSelectionOptions appSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

    // Act
    TargetCostWidgetData actualTargetAppCostWidgetData =
        aggregateOverlayDiagramService.getTargetAppCostWidgetData(
            1L,
            appSelectionOptions,
            filterParams,
            ImmutableTargetAppCostWidgetParameters.builder()
                .targetDate(LocalDate.of(1970, 1, 1))
                .build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(targetAppCostWidgetDao).findWidgetData(eq(1L), isA(Select.class), isA(LocalDate.class));
    assertTrue(actualTargetAppCostWidgetData instanceof ImmutableTargetCostWidgetData);
    assertTrue(actualTargetAppCostWidgetData.cellData().isEmpty());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getTargetAppCostWidgetData(Long, IdSelectionOptions,
   * Set, TargetAppCostWidgetParameters)}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getTargetAppCostWidgetData(Long,
   * IdSelectionOptions, Set, TargetAppCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getTargetAppCostWidgetData(Long, IdSelectionOptions, Set, TargetAppCostWidgetParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TargetCostWidgetData AggregateOverlayDiagramService.getTargetAppCostWidgetData(Long, IdSelectionOptions, Set, TargetAppCostWidgetParameters)"
  })
  void testGetTargetAppCostWidgetData3() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    TargetAppCostWidgetDao targetAppCostWidgetDao = mock(TargetAppCostWidgetDao.class);
    when(targetAppCostWidgetDao.findWidgetData(
            anyLong(), Mockito.<Select<Record1<Long>>>any(), Mockito.<LocalDate>any()))
        .thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            targetAppCostWidgetDao,
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            mock(ApplicationDao.class),
            mock(CostKindDao.class),
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));

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
    ImmutableIdSelectionOptions appSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

    // Act
    TargetCostWidgetData actualTargetAppCostWidgetData =
        aggregateOverlayDiagramService.getTargetAppCostWidgetData(
            1L,
            appSelectionOptions,
            filterParams,
            ImmutableTargetAppCostWidgetParameters.builder()
                .targetDate(LocalDate.of(1970, 1, 1))
                .build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(targetAppCostWidgetDao).findWidgetData(eq(1L), isA(Select.class), isA(LocalDate.class));
    assertTrue(actualTargetAppCostWidgetData instanceof ImmutableTargetCostWidgetData);
    assertTrue(actualTargetAppCostWidgetData.cellData().isEmpty());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getTargetAppCostWidgetData(Long, IdSelectionOptions,
   * Set, TargetAppCostWidgetParameters)}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getTargetAppCostWidgetData(Long,
   * IdSelectionOptions, Set, TargetAppCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getTargetAppCostWidgetData(Long, IdSelectionOptions, Set, TargetAppCostWidgetParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TargetCostWidgetData AggregateOverlayDiagramService.getTargetAppCostWidgetData(Long, IdSelectionOptions, Set, TargetAppCostWidgetParameters)"
  })
  void testGetTargetAppCostWidgetData4() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    TargetAppCostWidgetDao targetAppCostWidgetDao = mock(TargetAppCostWidgetDao.class);
    when(targetAppCostWidgetDao.findWidgetData(
            anyLong(), Mockito.<Select<Record1<Long>>>any(), Mockito.<LocalDate>any()))
        .thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            targetAppCostWidgetDao,
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            mock(ApplicationDao.class),
            mock(CostKindDao.class),
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));

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
    ImmutableIdSelectionOptions appSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

    // Act
    TargetCostWidgetData actualTargetAppCostWidgetData =
        aggregateOverlayDiagramService.getTargetAppCostWidgetData(
            1L,
            appSelectionOptions,
            filterParams,
            ImmutableTargetAppCostWidgetParameters.builder()
                .targetDate(LocalDate.of(1970, 1, 1))
                .build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(targetAppCostWidgetDao).findWidgetData(eq(1L), isA(Select.class), isA(LocalDate.class));
    assertTrue(actualTargetAppCostWidgetData instanceof ImmutableTargetCostWidgetData);
    assertTrue(actualTargetAppCostWidgetData.cellData().isEmpty());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getTargetAppCostWidgetData(Long, IdSelectionOptions,
   * Set, TargetAppCostWidgetParameters)}.
   *
   * <ul>
   *   <li>Given builder definitionId one build.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getTargetAppCostWidgetData(Long,
   * IdSelectionOptions, Set, TargetAppCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getTargetAppCostWidgetData(Long, IdSelectionOptions, Set, TargetAppCostWidgetParameters); given builder definitionId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TargetCostWidgetData AggregateOverlayDiagramService.getTargetAppCostWidgetData(Long, IdSelectionOptions, Set, TargetAppCostWidgetParameters)"
  })
  void testGetTargetAppCostWidgetData_givenBuilderDefinitionIdOneBuild() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    TargetAppCostWidgetDao targetAppCostWidgetDao = mock(TargetAppCostWidgetDao.class);
    when(targetAppCostWidgetDao.findWidgetData(
            anyLong(), Mockito.<Select<Record1<Long>>>any(), Mockito.<LocalDate>any()))
        .thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            targetAppCostWidgetDao,
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            mock(ApplicationDao.class),
            mock(CostKindDao.class),
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));

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
    ImmutableIdSelectionOptions appSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();
    filterParams.add(ImmutableAssessmentBasedSelectionFilter.builder().definitionId(1L).build());

    // Act
    TargetCostWidgetData actualTargetAppCostWidgetData =
        aggregateOverlayDiagramService.getTargetAppCostWidgetData(
            1L,
            appSelectionOptions,
            filterParams,
            ImmutableTargetAppCostWidgetParameters.builder()
                .targetDate(LocalDate.of(1970, 1, 1))
                .build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(targetAppCostWidgetDao).findWidgetData(eq(1L), isA(Select.class), isA(LocalDate.class));
    assertTrue(actualTargetAppCostWidgetData instanceof ImmutableTargetCostWidgetData);
    assertTrue(actualTargetAppCostWidgetData.cellData().isEmpty());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getTargetAppCostWidgetData(Long, IdSelectionOptions,
   * Set, TargetAppCostWidgetParameters)}.
   *
   * <ul>
   *   <li>Given {@code EXTERNALLY_HOSTED}.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getTargetAppCostWidgetData(Long,
   * IdSelectionOptions, Set, TargetAppCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getTargetAppCostWidgetData(Long, IdSelectionOptions, Set, TargetAppCostWidgetParameters); given 'EXTERNALLY_HOSTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TargetCostWidgetData AggregateOverlayDiagramService.getTargetAppCostWidgetData(Long, IdSelectionOptions, Set, TargetAppCostWidgetParameters)"
  })
  void testGetTargetAppCostWidgetData_givenExternallyHosted() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    TargetAppCostWidgetDao targetAppCostWidgetDao = mock(TargetAppCostWidgetDao.class);
    when(targetAppCostWidgetDao.findWidgetData(
            anyLong(), Mockito.<Select<Record1<Long>>>any(), Mockito.<LocalDate>any()))
        .thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            targetAppCostWidgetDao,
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            mock(ApplicationDao.class),
            mock(CostKindDao.class),
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.EXTERNALLY_HOSTED);
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
    ImmutableIdSelectionOptions appSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

    // Act
    TargetCostWidgetData actualTargetAppCostWidgetData =
        aggregateOverlayDiagramService.getTargetAppCostWidgetData(
            1L,
            appSelectionOptions,
            filterParams,
            ImmutableTargetAppCostWidgetParameters.builder()
                .targetDate(LocalDate.of(1970, 1, 1))
                .build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(targetAppCostWidgetDao).findWidgetData(eq(1L), isA(Select.class), isA(LocalDate.class));
    assertTrue(actualTargetAppCostWidgetData instanceof ImmutableTargetCostWidgetData);
    assertTrue(actualTargetAppCostWidgetData.cellData().isEmpty());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getTargetAppCostWidgetData(Long, IdSelectionOptions,
   * Set, TargetAppCostWidgetParameters)}.
   *
   * <ul>
   *   <li>Given {@code REMOVED}.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getTargetAppCostWidgetData(Long,
   * IdSelectionOptions, Set, TargetAppCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getTargetAppCostWidgetData(Long, IdSelectionOptions, Set, TargetAppCostWidgetParameters); given 'REMOVED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TargetCostWidgetData AggregateOverlayDiagramService.getTargetAppCostWidgetData(Long, IdSelectionOptions, Set, TargetAppCostWidgetParameters)"
  })
  void testGetTargetAppCostWidgetData_givenRemoved() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    TargetAppCostWidgetDao targetAppCostWidgetDao = mock(TargetAppCostWidgetDao.class);
    when(targetAppCostWidgetDao.findWidgetData(
            anyLong(), Mockito.<Select<Record1<Long>>>any(), Mockito.<LocalDate>any()))
        .thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            targetAppCostWidgetDao,
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            mock(ApplicationDao.class),
            mock(CostKindDao.class),
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));

    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.REMOVED);

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
    ImmutableIdSelectionOptions appSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

    // Act
    TargetCostWidgetData actualTargetAppCostWidgetData =
        aggregateOverlayDiagramService.getTargetAppCostWidgetData(
            1L,
            appSelectionOptions,
            filterParams,
            ImmutableTargetAppCostWidgetParameters.builder()
                .targetDate(LocalDate.of(1970, 1, 1))
                .build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(targetAppCostWidgetDao).findWidgetData(eq(1L), isA(Select.class), isA(LocalDate.class));
    assertTrue(actualTargetAppCostWidgetData instanceof ImmutableTargetCostWidgetData);
    assertTrue(actualTargetAppCostWidgetData.cellData().isEmpty());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getTargetAppCostWidgetData(Long, IdSelectionOptions,
   * Set, TargetAppCostWidgetParameters)}.
   *
   * <ul>
   *   <li>Then return cellData size is one.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getTargetAppCostWidgetData(Long,
   * IdSelectionOptions, Set, TargetAppCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getTargetAppCostWidgetData(Long, IdSelectionOptions, Set, TargetAppCostWidgetParameters); then return cellData size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TargetCostWidgetData AggregateOverlayDiagramService.getTargetAppCostWidgetData(Long, IdSelectionOptions, Set, TargetAppCostWidgetParameters)"
  })
  void testGetTargetAppCostWidgetData_thenReturnCellDataSizeIsOne() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    HashSet<TargetCostWidgetDatum> targetCostWidgetDatumSet = new HashSet<>();

    ImmutableTargetCostWidgetDatum.Builder cellExternalIdResult =
        ImmutableTargetCostWidgetDatum.builder().cellExternalId("42");

    ImmutableTargetCostWidgetDatum.Builder currentStateCostResult =
        cellExternalIdResult.currentStateCost(new BigDecimal("2.3"));
    targetCostWidgetDatumSet.add(
        currentStateCostResult.targetStateCost(new BigDecimal("2.3")).build());

    TargetAppCostWidgetDao targetAppCostWidgetDao = mock(TargetAppCostWidgetDao.class);
    when(targetAppCostWidgetDao.findWidgetData(
            anyLong(), Mockito.<Select<Record1<Long>>>any(), Mockito.<LocalDate>any()))
        .thenReturn(targetCostWidgetDatumSet);

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            targetAppCostWidgetDao,
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            mock(ApplicationDao.class),
            mock(CostKindDao.class),
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));

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
    ImmutableIdSelectionOptions appSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

    // Act
    TargetCostWidgetData actualTargetAppCostWidgetData =
        aggregateOverlayDiagramService.getTargetAppCostWidgetData(
            1L,
            appSelectionOptions,
            filterParams,
            ImmutableTargetAppCostWidgetParameters.builder()
                .targetDate(LocalDate.of(1970, 1, 1))
                .build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(targetAppCostWidgetDao).findWidgetData(eq(1L), isA(Select.class), isA(LocalDate.class));
    assertTrue(actualTargetAppCostWidgetData instanceof ImmutableTargetCostWidgetData);
    assertEquals(1, actualTargetAppCostWidgetData.cellData().size());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getAttestationWidgetData(long, Set,
   * IdSelectionOptions, AttestationWidgetParameters)}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getAttestationWidgetData(long, Set,
   * IdSelectionOptions, AttestationWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getAttestationWidgetData(long, Set, IdSelectionOptions, AttestationWidgetParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AttestationWidgetData AggregateOverlayDiagramService.getAttestationWidgetData(long, Set, IdSelectionOptions, AttestationWidgetParameters)"
  })
  void testGetAttestationWidgetData() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    AttestationWidgetDao attestationWidgetDao = mock(AttestationWidgetDao.class);
    when(attestationWidgetDao.findWidgetData(
            anyLong(),
            Mockito.<EntityKind>any(),
            Mockito.<Optional<Long>>any(),
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            applicationDao,
            mock(CostKindDao.class),
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            attestationWidgetDao);
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

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
    ImmutableIdSelectionOptions appSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    AttestationWidgetData actualAttestationWidgetData =
        aggregateOverlayDiagramService.getAttestationWidgetData(
            1L,
            filterParams,
            appSelectionOptions,
            ImmutableAttestationWidgetParameters.builder()
                .attestedEntityId(1L)
                .attestedEntityKind(EntityKind.ALL)
                .build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(attestationWidgetDao)
        .findWidgetData(eq(1L), eq(EntityKind.ALL), isA(Optional.class), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    assertTrue(actualAttestationWidgetData instanceof ImmutableAttestationWidgetData);
    Set<Application> applicationsResult = actualAttestationWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualAttestationWidgetData.cellData());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getAttestationWidgetData(long, Set,
   * IdSelectionOptions, AttestationWidgetParameters)}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getAttestationWidgetData(long, Set,
   * IdSelectionOptions, AttestationWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getAttestationWidgetData(long, Set, IdSelectionOptions, AttestationWidgetParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AttestationWidgetData AggregateOverlayDiagramService.getAttestationWidgetData(long, Set, IdSelectionOptions, AttestationWidgetParameters)"
  })
  void testGetAttestationWidgetData2() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    AttestationWidgetDao attestationWidgetDao = mock(AttestationWidgetDao.class);
    when(attestationWidgetDao.findWidgetData(
            anyLong(),
            Mockito.<EntityKind>any(),
            Mockito.<Optional<Long>>any(),
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            applicationDao,
            mock(CostKindDao.class),
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            attestationWidgetDao);
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

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
    ImmutableIdSelectionOptions appSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    AttestationWidgetData actualAttestationWidgetData =
        aggregateOverlayDiagramService.getAttestationWidgetData(
            1L,
            filterParams,
            appSelectionOptions,
            ImmutableAttestationWidgetParameters.builder()
                .attestedEntityId(1L)
                .attestedEntityKind(EntityKind.ALL)
                .build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(attestationWidgetDao)
        .findWidgetData(eq(1L), eq(EntityKind.ALL), isA(Optional.class), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    assertTrue(actualAttestationWidgetData instanceof ImmutableAttestationWidgetData);
    Set<Application> applicationsResult = actualAttestationWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualAttestationWidgetData.cellData());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getAttestationWidgetData(long, Set,
   * IdSelectionOptions, AttestationWidgetParameters)}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getAttestationWidgetData(long, Set,
   * IdSelectionOptions, AttestationWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getAttestationWidgetData(long, Set, IdSelectionOptions, AttestationWidgetParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AttestationWidgetData AggregateOverlayDiagramService.getAttestationWidgetData(long, Set, IdSelectionOptions, AttestationWidgetParameters)"
  })
  void testGetAttestationWidgetData3() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    AttestationWidgetDao attestationWidgetDao = mock(AttestationWidgetDao.class);
    when(attestationWidgetDao.findWidgetData(
            anyLong(),
            Mockito.<EntityKind>any(),
            Mockito.<Optional<Long>>any(),
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            applicationDao,
            mock(CostKindDao.class),
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            attestationWidgetDao);
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

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
    ImmutableIdSelectionOptions appSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    AttestationWidgetData actualAttestationWidgetData =
        aggregateOverlayDiagramService.getAttestationWidgetData(
            1L,
            filterParams,
            appSelectionOptions,
            ImmutableAttestationWidgetParameters.builder()
                .attestedEntityId(1L)
                .attestedEntityKind(EntityKind.ALL)
                .build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(attestationWidgetDao)
        .findWidgetData(eq(1L), eq(EntityKind.ALL), isA(Optional.class), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    assertTrue(actualAttestationWidgetData instanceof ImmutableAttestationWidgetData);
    Set<Application> applicationsResult = actualAttestationWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualAttestationWidgetData.cellData());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getAttestationWidgetData(long, Set,
   * IdSelectionOptions, AttestationWidgetParameters)}.
   *
   * <ul>
   *   <li>Given builder definitionId one build.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getAttestationWidgetData(long, Set,
   * IdSelectionOptions, AttestationWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getAttestationWidgetData(long, Set, IdSelectionOptions, AttestationWidgetParameters); given builder definitionId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AttestationWidgetData AggregateOverlayDiagramService.getAttestationWidgetData(long, Set, IdSelectionOptions, AttestationWidgetParameters)"
  })
  void testGetAttestationWidgetData_givenBuilderDefinitionIdOneBuild() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    AttestationWidgetDao attestationWidgetDao = mock(AttestationWidgetDao.class);
    when(attestationWidgetDao.findWidgetData(
            anyLong(),
            Mockito.<EntityKind>any(),
            Mockito.<Optional<Long>>any(),
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            applicationDao,
            mock(CostKindDao.class),
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            attestationWidgetDao);

    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();
    filterParams.add(ImmutableAssessmentBasedSelectionFilter.builder().definitionId(1L).build());

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
    ImmutableIdSelectionOptions appSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    AttestationWidgetData actualAttestationWidgetData =
        aggregateOverlayDiagramService.getAttestationWidgetData(
            1L,
            filterParams,
            appSelectionOptions,
            ImmutableAttestationWidgetParameters.builder()
                .attestedEntityId(1L)
                .attestedEntityKind(EntityKind.ALL)
                .build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(attestationWidgetDao)
        .findWidgetData(eq(1L), eq(EntityKind.ALL), isA(Optional.class), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    assertTrue(actualAttestationWidgetData instanceof ImmutableAttestationWidgetData);
    Set<Application> applicationsResult = actualAttestationWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualAttestationWidgetData.cellData());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getAttestationWidgetData(long, Set,
   * IdSelectionOptions, AttestationWidgetParameters)}.
   *
   * <ul>
   *   <li>Given {@code INTERNALLY_HOSTED}.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getAttestationWidgetData(long, Set,
   * IdSelectionOptions, AttestationWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getAttestationWidgetData(long, Set, IdSelectionOptions, AttestationWidgetParameters); given 'INTERNALLY_HOSTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AttestationWidgetData AggregateOverlayDiagramService.getAttestationWidgetData(long, Set, IdSelectionOptions, AttestationWidgetParameters)"
  })
  void testGetAttestationWidgetData_givenInternallyHosted() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    AttestationWidgetDao attestationWidgetDao = mock(AttestationWidgetDao.class);
    when(attestationWidgetDao.findWidgetData(
            anyLong(),
            Mockito.<EntityKind>any(),
            Mockito.<Optional<Long>>any(),
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            applicationDao,
            mock(CostKindDao.class),
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            attestationWidgetDao);
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.INTERNALLY_HOSTED);
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
    ImmutableIdSelectionOptions appSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    AttestationWidgetData actualAttestationWidgetData =
        aggregateOverlayDiagramService.getAttestationWidgetData(
            1L,
            filterParams,
            appSelectionOptions,
            ImmutableAttestationWidgetParameters.builder()
                .attestedEntityId(1L)
                .attestedEntityKind(EntityKind.ALL)
                .build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(attestationWidgetDao)
        .findWidgetData(eq(1L), eq(EntityKind.ALL), isA(Optional.class), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    assertTrue(actualAttestationWidgetData instanceof ImmutableAttestationWidgetData);
    Set<Application> applicationsResult = actualAttestationWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualAttestationWidgetData.cellData());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getAttestationWidgetData(long, Set,
   * IdSelectionOptions, AttestationWidgetParameters)}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getAttestationWidgetData(long, Set,
   * IdSelectionOptions, AttestationWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getAttestationWidgetData(long, Set, IdSelectionOptions, AttestationWidgetParameters); given 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AttestationWidgetData AggregateOverlayDiagramService.getAttestationWidgetData(long, Set, IdSelectionOptions, AttestationWidgetParameters)"
  })
  void testGetAttestationWidgetData_givenPending() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    AttestationWidgetDao attestationWidgetDao = mock(AttestationWidgetDao.class);
    when(attestationWidgetDao.findWidgetData(
            anyLong(),
            Mockito.<EntityKind>any(),
            Mockito.<Optional<Long>>any(),
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            applicationDao,
            mock(CostKindDao.class),
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            attestationWidgetDao);
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

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
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions appSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    AttestationWidgetData actualAttestationWidgetData =
        aggregateOverlayDiagramService.getAttestationWidgetData(
            1L,
            filterParams,
            appSelectionOptions,
            ImmutableAttestationWidgetParameters.builder()
                .attestedEntityId(1L)
                .attestedEntityKind(EntityKind.ALL)
                .build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(attestationWidgetDao)
        .findWidgetData(eq(1L), eq(EntityKind.ALL), isA(Optional.class), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    assertTrue(actualAttestationWidgetData instanceof ImmutableAttestationWidgetData);
    Set<Application> applicationsResult = actualAttestationWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualAttestationWidgetData.cellData());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getAttestationWidgetData(long, Set,
   * IdSelectionOptions, AttestationWidgetParameters)}.
   *
   * <ul>
   *   <li>Then return applications size is one.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getAttestationWidgetData(long, Set,
   * IdSelectionOptions, AttestationWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getAttestationWidgetData(long, Set, IdSelectionOptions, AttestationWidgetParameters); then return applications size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AttestationWidgetData AggregateOverlayDiagramService.getAttestationWidgetData(long, Set, IdSelectionOptions, AttestationWidgetParameters)"
  })
  void testGetAttestationWidgetData_thenReturnApplicationsSizeIsOne() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

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

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(applicationList);

    AttestationWidgetDao attestationWidgetDao = mock(AttestationWidgetDao.class);
    when(attestationWidgetDao.findWidgetData(
            anyLong(),
            Mockito.<EntityKind>any(),
            Mockito.<Optional<Long>>any(),
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            applicationDao,
            mock(CostKindDao.class),
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            attestationWidgetDao);
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

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
    ImmutableIdSelectionOptions appSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    AttestationWidgetData actualAttestationWidgetData =
        aggregateOverlayDiagramService.getAttestationWidgetData(
            1L,
            filterParams,
            appSelectionOptions,
            ImmutableAttestationWidgetParameters.builder()
                .attestedEntityId(1L)
                .attestedEntityKind(EntityKind.ALL)
                .build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(attestationWidgetDao)
        .findWidgetData(eq(1L), eq(EntityKind.ALL), isA(Optional.class), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    assertTrue(actualAttestationWidgetData instanceof ImmutableAttestationWidgetData);
    assertEquals(1, actualAttestationWidgetData.applications().size());
    assertTrue(actualAttestationWidgetData.cellData().isEmpty());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getAttestationWidgetData(long, Set,
   * IdSelectionOptions, AttestationWidgetParameters)}.
   *
   * <ul>
   *   <li>Then return applications size is one.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getAttestationWidgetData(long, Set,
   * IdSelectionOptions, AttestationWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getAttestationWidgetData(long, Set, IdSelectionOptions, AttestationWidgetParameters); then return applications size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AttestationWidgetData AggregateOverlayDiagramService.getAttestationWidgetData(long, Set, IdSelectionOptions, AttestationWidgetParameters)"
  })
  void testGetAttestationWidgetData_thenReturnApplicationsSizeIsOne2() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

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

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(applicationList);

    AttestationWidgetDao attestationWidgetDao = mock(AttestationWidgetDao.class);
    when(attestationWidgetDao.findWidgetData(
            anyLong(),
            Mockito.<EntityKind>any(),
            Mockito.<Optional<Long>>any(),
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            applicationDao,
            mock(CostKindDao.class),
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            attestationWidgetDao);
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

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
    ImmutableIdSelectionOptions appSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    AttestationWidgetData actualAttestationWidgetData =
        aggregateOverlayDiagramService.getAttestationWidgetData(
            1L,
            filterParams,
            appSelectionOptions,
            ImmutableAttestationWidgetParameters.builder()
                .attestedEntityId(1L)
                .attestedEntityKind(EntityKind.ALL)
                .build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(attestationWidgetDao)
        .findWidgetData(eq(1L), eq(EntityKind.ALL), isA(Optional.class), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    assertTrue(actualAttestationWidgetData instanceof ImmutableAttestationWidgetData);
    assertEquals(1, actualAttestationWidgetData.applications().size());
    assertTrue(actualAttestationWidgetData.cellData().isEmpty());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getAttestationWidgetData(long, Set,
   * IdSelectionOptions, AttestationWidgetParameters)}.
   *
   * <ul>
   *   <li>Then return cellData is applications.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getAttestationWidgetData(long, Set,
   * IdSelectionOptions, AttestationWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getAttestationWidgetData(long, Set, IdSelectionOptions, AttestationWidgetParameters); then return cellData is applications")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AttestationWidgetData AggregateOverlayDiagramService.getAttestationWidgetData(long, Set, IdSelectionOptions, AttestationWidgetParameters)"
  })
  void testGetAttestationWidgetData_thenReturnCellDataIsApplications() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    AttestationWidgetDao attestationWidgetDao = mock(AttestationWidgetDao.class);
    when(attestationWidgetDao.findWidgetData(
            anyLong(),
            Mockito.<EntityKind>any(),
            Mockito.<Optional<Long>>any(),
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            applicationDao,
            mock(CostKindDao.class),
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            attestationWidgetDao);
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

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
    ImmutableIdSelectionOptions appSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    AttestationWidgetData actualAttestationWidgetData =
        aggregateOverlayDiagramService.getAttestationWidgetData(
            1L,
            filterParams,
            appSelectionOptions,
            ImmutableAttestationWidgetParameters.builder()
                .attestedEntityId(1L)
                .attestedEntityKind(EntityKind.ALL)
                .build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(attestationWidgetDao)
        .findWidgetData(eq(1L), eq(EntityKind.ALL), isA(Optional.class), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    assertTrue(actualAttestationWidgetData instanceof ImmutableAttestationWidgetData);
    Set<Application> applicationsResult = actualAttestationWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualAttestationWidgetData.cellData());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getAttestationWidgetData(long, Set,
   * IdSelectionOptions, AttestationWidgetParameters)}.
   *
   * <ul>
   *   <li>Then return cellData size is one.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getAttestationWidgetData(long, Set,
   * IdSelectionOptions, AttestationWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getAttestationWidgetData(long, Set, IdSelectionOptions, AttestationWidgetParameters); then return cellData size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AttestationWidgetData AggregateOverlayDiagramService.getAttestationWidgetData(long, Set, IdSelectionOptions, AttestationWidgetParameters)"
  })
  void testGetAttestationWidgetData_thenReturnCellDataSizeIsOne() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    HashSet<AttestationWidgetDatum> attestationWidgetDatumSet = new HashSet<>();
    attestationWidgetDatumSet.add(
        ImmutableAttestationWidgetDatum.builder().cellExternalId("42").build());

    AttestationWidgetDao attestationWidgetDao = mock(AttestationWidgetDao.class);
    when(attestationWidgetDao.findWidgetData(
            anyLong(),
            Mockito.<EntityKind>any(),
            Mockito.<Optional<Long>>any(),
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(attestationWidgetDatumSet);

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            applicationDao,
            mock(CostKindDao.class),
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            attestationWidgetDao);
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

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
    ImmutableIdSelectionOptions appSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    AttestationWidgetData actualAttestationWidgetData =
        aggregateOverlayDiagramService.getAttestationWidgetData(
            1L,
            filterParams,
            appSelectionOptions,
            ImmutableAttestationWidgetParameters.builder()
                .attestedEntityId(1L)
                .attestedEntityKind(EntityKind.ALL)
                .build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(attestationWidgetDao)
        .findWidgetData(eq(1L), eq(EntityKind.ALL), isA(Optional.class), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    assertTrue(actualAttestationWidgetData instanceof ImmutableAttestationWidgetData);
    assertEquals(1, actualAttestationWidgetData.cellData().size());
    assertTrue(actualAttestationWidgetData.applications().isEmpty());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getAppCostWidgetData(Long, Set, IdSelectionOptions,
   * AppCostWidgetParameters)}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getAppCostWidgetData(Long, Set,
   * IdSelectionOptions, AppCostWidgetParameters)}
   */
  @Test
  @DisplayName("Test getAppCostWidgetData(Long, Set, IdSelectionOptions, AppCostWidgetParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CostWidgetData AggregateOverlayDiagramService.getAppCostWidgetData(Long, Set, IdSelectionOptions, AppCostWidgetParameters)"
  })
  void testGetAppCostWidgetData() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    AppCostWidgetDao appCostWidgetDao = mock(AppCostWidgetDao.class);
    when(appCostWidgetDao.findWidgetData(
            anyLong(), Mockito.<Set<Long>>any(), anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findAll()).thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            appCostWidgetDao,
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            measurableDao,
            applicationDao,
            costKindDao,
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

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
    ImmutableIdSelectionOptions appSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    CostWidgetData actualAppCostWidgetData =
        aggregateOverlayDiagramService.getAppCostWidgetData(
            1L,
            filterParams,
            appSelectionOptions,
            ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(appCostWidgetDao).findWidgetData(eq(1L), isA(Set.class), eq(1L), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(costKindDao).findAll();
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    assertTrue(actualAppCostWidgetData instanceof ImmutableCostWidgetData);
    Set<Application> applicationsResult = actualAppCostWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualAppCostWidgetData.cellData());
    assertSame(applicationsResult, actualAppCostWidgetData.costKinds());
    assertSame(applicationsResult, actualAppCostWidgetData.measurables());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getAppCostWidgetData(Long, Set, IdSelectionOptions,
   * AppCostWidgetParameters)}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getAppCostWidgetData(Long, Set,
   * IdSelectionOptions, AppCostWidgetParameters)}
   */
  @Test
  @DisplayName("Test getAppCostWidgetData(Long, Set, IdSelectionOptions, AppCostWidgetParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CostWidgetData AggregateOverlayDiagramService.getAppCostWidgetData(Long, Set, IdSelectionOptions, AppCostWidgetParameters)"
  })
  void testGetAppCostWidgetData2() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    AppCostWidgetDao appCostWidgetDao = mock(AppCostWidgetDao.class);
    when(appCostWidgetDao.findWidgetData(
            anyLong(), Mockito.<Set<Long>>any(), anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findAll()).thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            appCostWidgetDao,
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            measurableDao,
            applicationDao,
            costKindDao,
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

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
    ImmutableIdSelectionOptions appSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    CostWidgetData actualAppCostWidgetData =
        aggregateOverlayDiagramService.getAppCostWidgetData(
            1L,
            filterParams,
            appSelectionOptions,
            ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(appCostWidgetDao).findWidgetData(eq(1L), isA(Set.class), eq(1L), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(costKindDao).findAll();
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    assertTrue(actualAppCostWidgetData instanceof ImmutableCostWidgetData);
    Set<Application> applicationsResult = actualAppCostWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualAppCostWidgetData.cellData());
    assertSame(applicationsResult, actualAppCostWidgetData.costKinds());
    assertSame(applicationsResult, actualAppCostWidgetData.measurables());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getAppCostWidgetData(Long, Set, IdSelectionOptions,
   * AppCostWidgetParameters)}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getAppCostWidgetData(Long, Set,
   * IdSelectionOptions, AppCostWidgetParameters)}
   */
  @Test
  @DisplayName("Test getAppCostWidgetData(Long, Set, IdSelectionOptions, AppCostWidgetParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CostWidgetData AggregateOverlayDiagramService.getAppCostWidgetData(Long, Set, IdSelectionOptions, AppCostWidgetParameters)"
  })
  void testGetAppCostWidgetData3() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    AppCostWidgetDao appCostWidgetDao = mock(AppCostWidgetDao.class);
    when(appCostWidgetDao.findWidgetData(
            anyLong(), Mockito.<Set<Long>>any(), anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findAll()).thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            appCostWidgetDao,
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            measurableDao,
            applicationDao,
            costKindDao,
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

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
    ImmutableIdSelectionOptions appSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    CostWidgetData actualAppCostWidgetData =
        aggregateOverlayDiagramService.getAppCostWidgetData(
            1L,
            filterParams,
            appSelectionOptions,
            ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(appCostWidgetDao).findWidgetData(eq(1L), isA(Set.class), eq(1L), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(costKindDao).findAll();
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    assertTrue(actualAppCostWidgetData instanceof ImmutableCostWidgetData);
    Set<Application> applicationsResult = actualAppCostWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualAppCostWidgetData.cellData());
    assertSame(applicationsResult, actualAppCostWidgetData.costKinds());
    assertSame(applicationsResult, actualAppCostWidgetData.measurables());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getAppCostWidgetData(Long, Set, IdSelectionOptions,
   * AppCostWidgetParameters)}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getAppCostWidgetData(Long, Set,
   * IdSelectionOptions, AppCostWidgetParameters)}
   */
  @Test
  @DisplayName("Test getAppCostWidgetData(Long, Set, IdSelectionOptions, AppCostWidgetParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CostWidgetData AggregateOverlayDiagramService.getAppCostWidgetData(Long, Set, IdSelectionOptions, AppCostWidgetParameters)"
  })
  void testGetAppCostWidgetData4() {
    // Arrange
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    ImmutableCostWidgetDatum.Builder builderResult = ImmutableCostWidgetDatum.builder();

    ImmutableMeasurableCostEntry.Builder builderResult2 = ImmutableMeasurableCostEntry.builder();

    ImmutableMeasurableCostEntry.Builder measurableRatingIdResult =
        builderResult2
            .allocatedCost(new BigDecimal("2.3"))
            .allocationDerivation(AllocationDerivation.DERIVED)
            .allocationPercentage(1)
            .appId(1L)
            .costKindId(1L)
            .measurableId(1L)
            .measurableRatingId(1L);
    builderResult.addMeasurableCosts(
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(1).build());
    ImmutableCostWidgetDatum immutableCostWidgetDatum = builderResult.cellExternalId("42").build();

    HashSet<CostWidgetDatum> costWidgetDatumSet = new HashSet<>();
    costWidgetDatumSet.add(immutableCostWidgetDatum);
    when(appCostWidgetDao.findWidgetData(
            anyLong(), Mockito.<Set<Long>>any(), anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(costWidgetDatumSet);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(costKindDao.findAll()).thenReturn(new HashSet<>());
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

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
    ImmutableIdSelectionOptions appSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    CostWidgetData actualAppCostWidgetData =
        aggregateOverlayDiagramService.getAppCostWidgetData(
            1L,
            filterParams,
            appSelectionOptions,
            ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(appCostWidgetDao).findWidgetData(eq(1L), isA(Set.class), eq(1L), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(costKindDao).findAll();
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    assertTrue(actualAppCostWidgetData instanceof ImmutableCostWidgetData);
    assertEquals(1, actualAppCostWidgetData.cellData().size());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getAppCostWidgetData(Long, Set, IdSelectionOptions,
   * AppCostWidgetParameters)}.
   *
   * <ul>
   *   <li>Given builder definitionId one build.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getAppCostWidgetData(Long, Set,
   * IdSelectionOptions, AppCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getAppCostWidgetData(Long, Set, IdSelectionOptions, AppCostWidgetParameters); given builder definitionId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CostWidgetData AggregateOverlayDiagramService.getAppCostWidgetData(Long, Set, IdSelectionOptions, AppCostWidgetParameters)"
  })
  void testGetAppCostWidgetData_givenBuilderDefinitionIdOneBuild() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    AppCostWidgetDao appCostWidgetDao = mock(AppCostWidgetDao.class);
    when(appCostWidgetDao.findWidgetData(
            anyLong(), Mockito.<Set<Long>>any(), anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findAll()).thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            appCostWidgetDao,
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            measurableDao,
            applicationDao,
            costKindDao,
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));

    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();
    filterParams.add(ImmutableAssessmentBasedSelectionFilter.builder().definitionId(1L).build());

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
    ImmutableIdSelectionOptions appSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    CostWidgetData actualAppCostWidgetData =
        aggregateOverlayDiagramService.getAppCostWidgetData(
            1L,
            filterParams,
            appSelectionOptions,
            ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(appCostWidgetDao).findWidgetData(eq(1L), isA(Set.class), eq(1L), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(costKindDao).findAll();
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    assertTrue(actualAppCostWidgetData instanceof ImmutableCostWidgetData);
    Set<Application> applicationsResult = actualAppCostWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualAppCostWidgetData.cellData());
    assertSame(applicationsResult, actualAppCostWidgetData.costKinds());
    assertSame(applicationsResult, actualAppCostWidgetData.measurables());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getAppCostWidgetData(Long, Set, IdSelectionOptions,
   * AppCostWidgetParameters)}.
   *
   * <ul>
   *   <li>Given {@code INTERNALLY_HOSTED}.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getAppCostWidgetData(Long, Set,
   * IdSelectionOptions, AppCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getAppCostWidgetData(Long, Set, IdSelectionOptions, AppCostWidgetParameters); given 'INTERNALLY_HOSTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CostWidgetData AggregateOverlayDiagramService.getAppCostWidgetData(Long, Set, IdSelectionOptions, AppCostWidgetParameters)"
  })
  void testGetAppCostWidgetData_givenInternallyHosted() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    AppCostWidgetDao appCostWidgetDao = mock(AppCostWidgetDao.class);
    when(appCostWidgetDao.findWidgetData(
            anyLong(), Mockito.<Set<Long>>any(), anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findAll()).thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            appCostWidgetDao,
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            measurableDao,
            applicationDao,
            costKindDao,
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.INTERNALLY_HOSTED);
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
    ImmutableIdSelectionOptions appSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    CostWidgetData actualAppCostWidgetData =
        aggregateOverlayDiagramService.getAppCostWidgetData(
            1L,
            filterParams,
            appSelectionOptions,
            ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(appCostWidgetDao).findWidgetData(eq(1L), isA(Set.class), eq(1L), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(costKindDao).findAll();
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    assertTrue(actualAppCostWidgetData instanceof ImmutableCostWidgetData);
    Set<Application> applicationsResult = actualAppCostWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualAppCostWidgetData.cellData());
    assertSame(applicationsResult, actualAppCostWidgetData.costKinds());
    assertSame(applicationsResult, actualAppCostWidgetData.measurables());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getAppCostWidgetData(Long, Set, IdSelectionOptions,
   * AppCostWidgetParameters)}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getAppCostWidgetData(Long, Set,
   * IdSelectionOptions, AppCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getAppCostWidgetData(Long, Set, IdSelectionOptions, AppCostWidgetParameters); given 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CostWidgetData AggregateOverlayDiagramService.getAppCostWidgetData(Long, Set, IdSelectionOptions, AppCostWidgetParameters)"
  })
  void testGetAppCostWidgetData_givenPending() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    AppCostWidgetDao appCostWidgetDao = mock(AppCostWidgetDao.class);
    when(appCostWidgetDao.findWidgetData(
            anyLong(), Mockito.<Set<Long>>any(), anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findAll()).thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            appCostWidgetDao,
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            measurableDao,
            applicationDao,
            costKindDao,
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

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
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions appSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    CostWidgetData actualAppCostWidgetData =
        aggregateOverlayDiagramService.getAppCostWidgetData(
            1L,
            filterParams,
            appSelectionOptions,
            ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(appCostWidgetDao).findWidgetData(eq(1L), isA(Set.class), eq(1L), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(costKindDao).findAll();
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    assertTrue(actualAppCostWidgetData instanceof ImmutableCostWidgetData);
    Set<Application> applicationsResult = actualAppCostWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualAppCostWidgetData.cellData());
    assertSame(applicationsResult, actualAppCostWidgetData.costKinds());
    assertSame(applicationsResult, actualAppCostWidgetData.measurables());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getAppCostWidgetData(Long, Set, IdSelectionOptions,
   * AppCostWidgetParameters)}.
   *
   * <ul>
   *   <li>Then return applications size is one.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getAppCostWidgetData(Long, Set,
   * IdSelectionOptions, AppCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getAppCostWidgetData(Long, Set, IdSelectionOptions, AppCostWidgetParameters); then return applications size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CostWidgetData AggregateOverlayDiagramService.getAppCostWidgetData(Long, Set, IdSelectionOptions, AppCostWidgetParameters)"
  })
  void testGetAppCostWidgetData_thenReturnApplicationsSizeIsOne() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    AppCostWidgetDao appCostWidgetDao = mock(AppCostWidgetDao.class);
    when(appCostWidgetDao.findWidgetData(
            anyLong(), Mockito.<Set<Long>>any(), anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(applicationList);

    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findAll()).thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            appCostWidgetDao,
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            measurableDao,
            applicationDao,
            costKindDao,
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

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
    ImmutableIdSelectionOptions appSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    CostWidgetData actualAppCostWidgetData =
        aggregateOverlayDiagramService.getAppCostWidgetData(
            1L,
            filterParams,
            appSelectionOptions,
            ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(appCostWidgetDao).findWidgetData(eq(1L), isA(Set.class), eq(1L), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(costKindDao).findAll();
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    assertTrue(actualAppCostWidgetData instanceof ImmutableCostWidgetData);
    assertEquals(1, actualAppCostWidgetData.applications().size());
    Set<CostWidgetDatum> cellDataResult = actualAppCostWidgetData.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualAppCostWidgetData.costKinds());
    assertSame(cellDataResult, actualAppCostWidgetData.measurables());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getAppCostWidgetData(Long, Set, IdSelectionOptions,
   * AppCostWidgetParameters)}.
   *
   * <ul>
   *   <li>Then return applications size is one.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getAppCostWidgetData(Long, Set,
   * IdSelectionOptions, AppCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getAppCostWidgetData(Long, Set, IdSelectionOptions, AppCostWidgetParameters); then return applications size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CostWidgetData AggregateOverlayDiagramService.getAppCostWidgetData(Long, Set, IdSelectionOptions, AppCostWidgetParameters)"
  })
  void testGetAppCostWidgetData_thenReturnApplicationsSizeIsOne2() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    AppCostWidgetDao appCostWidgetDao = mock(AppCostWidgetDao.class);
    when(appCostWidgetDao.findWidgetData(
            anyLong(), Mockito.<Set<Long>>any(), anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(applicationList);

    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findAll()).thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            appCostWidgetDao,
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            measurableDao,
            applicationDao,
            costKindDao,
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

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
    ImmutableIdSelectionOptions appSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    CostWidgetData actualAppCostWidgetData =
        aggregateOverlayDiagramService.getAppCostWidgetData(
            1L,
            filterParams,
            appSelectionOptions,
            ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(appCostWidgetDao).findWidgetData(eq(1L), isA(Set.class), eq(1L), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(costKindDao).findAll();
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    assertTrue(actualAppCostWidgetData instanceof ImmutableCostWidgetData);
    assertEquals(1, actualAppCostWidgetData.applications().size());
    Set<CostWidgetDatum> cellDataResult = actualAppCostWidgetData.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualAppCostWidgetData.costKinds());
    assertSame(cellDataResult, actualAppCostWidgetData.measurables());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getAppCostWidgetData(Long, Set, IdSelectionOptions,
   * AppCostWidgetParameters)}.
   *
   * <ul>
   *   <li>Then return cellData size is one.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getAppCostWidgetData(Long, Set,
   * IdSelectionOptions, AppCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getAppCostWidgetData(Long, Set, IdSelectionOptions, AppCostWidgetParameters); then return cellData size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CostWidgetData AggregateOverlayDiagramService.getAppCostWidgetData(Long, Set, IdSelectionOptions, AppCostWidgetParameters)"
  })
  void testGetAppCostWidgetData_thenReturnCellDataSizeIsOne() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    HashSet<CostWidgetDatum> costWidgetDatumSet = new HashSet<>();
    costWidgetDatumSet.add(ImmutableCostWidgetDatum.builder().cellExternalId("42").build());

    AppCostWidgetDao appCostWidgetDao = mock(AppCostWidgetDao.class);
    when(appCostWidgetDao.findWidgetData(
            anyLong(), Mockito.<Set<Long>>any(), anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(costWidgetDatumSet);

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findAll()).thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            appCostWidgetDao,
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            measurableDao,
            applicationDao,
            costKindDao,
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

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
    ImmutableIdSelectionOptions appSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    CostWidgetData actualAppCostWidgetData =
        aggregateOverlayDiagramService.getAppCostWidgetData(
            1L,
            filterParams,
            appSelectionOptions,
            ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(appCostWidgetDao).findWidgetData(eq(1L), isA(Set.class), eq(1L), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(costKindDao).findAll();
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    assertTrue(actualAppCostWidgetData instanceof ImmutableCostWidgetData);
    assertEquals(1, actualAppCostWidgetData.cellData().size());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getAppCostWidgetData(Long, Set, IdSelectionOptions,
   * AppCostWidgetParameters)}.
   *
   * <ul>
   *   <li>Then return costKinds size is one.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getAppCostWidgetData(Long, Set,
   * IdSelectionOptions, AppCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getAppCostWidgetData(Long, Set, IdSelectionOptions, AppCostWidgetParameters); then return costKinds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CostWidgetData AggregateOverlayDiagramService.getAppCostWidgetData(Long, Set, IdSelectionOptions, AppCostWidgetParameters)"
  })
  void testGetAppCostWidgetData_thenReturnCostKindsSizeIsOne() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    AppCostWidgetDao appCostWidgetDao = mock(AppCostWidgetDao.class);
    when(appCostWidgetDao.findWidgetData(
            anyLong(), Mockito.<Set<Long>>any(), anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    HashSet<CostKindWithYears> costKindWithYearsSet = new HashSet<>();

    ImmutableCostKindWithYears.Builder builderResult = ImmutableCostKindWithYears.builder();
    costKindWithYearsSet.add(
        builderResult
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .build());

    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findAll()).thenReturn(costKindWithYearsSet);

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            appCostWidgetDao,
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            measurableDao,
            applicationDao,
            costKindDao,
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

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
    ImmutableIdSelectionOptions appSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    CostWidgetData actualAppCostWidgetData =
        aggregateOverlayDiagramService.getAppCostWidgetData(
            1L,
            filterParams,
            appSelectionOptions,
            ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(appCostWidgetDao).findWidgetData(eq(1L), isA(Set.class), eq(1L), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(costKindDao).findAll();
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    assertTrue(actualAppCostWidgetData instanceof ImmutableCostWidgetData);
    assertEquals(1, actualAppCostWidgetData.costKinds().size());
    Set<Application> applicationsResult = actualAppCostWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualAppCostWidgetData.cellData());
    assertSame(applicationsResult, actualAppCostWidgetData.measurables());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getAppCostWidgetData(Long, Set, IdSelectionOptions,
   * AppCostWidgetParameters)}.
   *
   * <ul>
   *   <li>Then return measurables is applications.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getAppCostWidgetData(Long, Set,
   * IdSelectionOptions, AppCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getAppCostWidgetData(Long, Set, IdSelectionOptions, AppCostWidgetParameters); then return measurables is applications")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CostWidgetData AggregateOverlayDiagramService.getAppCostWidgetData(Long, Set, IdSelectionOptions, AppCostWidgetParameters)"
  })
  void testGetAppCostWidgetData_thenReturnMeasurablesIsApplications() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    AppCostWidgetDao appCostWidgetDao = mock(AppCostWidgetDao.class);
    when(appCostWidgetDao.findWidgetData(
            anyLong(), Mockito.<Set<Long>>any(), anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findAll()).thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            appCostWidgetDao,
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            measurableDao,
            applicationDao,
            costKindDao,
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

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
    ImmutableIdSelectionOptions appSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    CostWidgetData actualAppCostWidgetData =
        aggregateOverlayDiagramService.getAppCostWidgetData(
            1L,
            filterParams,
            appSelectionOptions,
            ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(appCostWidgetDao).findWidgetData(eq(1L), isA(Set.class), eq(1L), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(costKindDao).findAll();
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    assertTrue(actualAppCostWidgetData instanceof ImmutableCostWidgetData);
    Set<Application> applicationsResult = actualAppCostWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualAppCostWidgetData.cellData());
    assertSame(applicationsResult, actualAppCostWidgetData.costKinds());
    assertSame(applicationsResult, actualAppCostWidgetData.measurables());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getAppCostWidgetData(Long, Set, IdSelectionOptions,
   * AppCostWidgetParameters)}.
   *
   * <ul>
   *   <li>Then return measurables size is one.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getAppCostWidgetData(Long, Set,
   * IdSelectionOptions, AppCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getAppCostWidgetData(Long, Set, IdSelectionOptions, AppCostWidgetParameters); then return measurables size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CostWidgetData AggregateOverlayDiagramService.getAppCostWidgetData(Long, Set, IdSelectionOptions, AppCostWidgetParameters)"
  })
  void testGetAppCostWidgetData_thenReturnMeasurablesSizeIsOne() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    AppCostWidgetDao appCostWidgetDao = mock(AppCostWidgetDao.class);
    when(appCostWidgetDao.findWidgetData(
            anyLong(), Mockito.<Set<Long>>any(), anyLong(), Mockito.<Select<Record1<Long>>>any()))
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

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(measurableList);

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findAll()).thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            appCostWidgetDao,
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            measurableDao,
            applicationDao,
            costKindDao,
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

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
    ImmutableIdSelectionOptions appSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    CostWidgetData actualAppCostWidgetData =
        aggregateOverlayDiagramService.getAppCostWidgetData(
            1L,
            filterParams,
            appSelectionOptions,
            ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(appCostWidgetDao).findWidgetData(eq(1L), isA(Set.class), eq(1L), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(costKindDao).findAll();
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    assertTrue(actualAppCostWidgetData instanceof ImmutableCostWidgetData);
    assertEquals(1, actualAppCostWidgetData.measurables().size());
    Set<Application> applicationsResult = actualAppCostWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualAppCostWidgetData.cellData());
    assertSame(applicationsResult, actualAppCostWidgetData.costKinds());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getAppCostWidgetData(Long, Set, IdSelectionOptions,
   * AppCostWidgetParameters)}.
   *
   * <ul>
   *   <li>Then return measurables size is one.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getAppCostWidgetData(Long, Set,
   * IdSelectionOptions, AppCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getAppCostWidgetData(Long, Set, IdSelectionOptions, AppCostWidgetParameters); then return measurables size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CostWidgetData AggregateOverlayDiagramService.getAppCostWidgetData(Long, Set, IdSelectionOptions, AppCostWidgetParameters)"
  })
  void testGetAppCostWidgetData_thenReturnMeasurablesSizeIsOne2() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    AppCostWidgetDao appCostWidgetDao = mock(AppCostWidgetDao.class);
    when(appCostWidgetDao.findWidgetData(
            anyLong(), Mockito.<Set<Long>>any(), anyLong(), Mockito.<Select<Record1<Long>>>any()))
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

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(measurableList);

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findAll()).thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            appCostWidgetDao,
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            measurableDao,
            applicationDao,
            costKindDao,
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

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
    ImmutableIdSelectionOptions appSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    CostWidgetData actualAppCostWidgetData =
        aggregateOverlayDiagramService.getAppCostWidgetData(
            1L,
            filterParams,
            appSelectionOptions,
            ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(appCostWidgetDao).findWidgetData(eq(1L), isA(Set.class), eq(1L), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(costKindDao).findAll();
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    assertTrue(actualAppCostWidgetData instanceof ImmutableCostWidgetData);
    assertEquals(1, actualAppCostWidgetData.measurables().size());
    Set<Application> applicationsResult = actualAppCostWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualAppCostWidgetData.cellData());
    assertSame(applicationsResult, actualAppCostWidgetData.costKinds());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getRatingCostWidgetData(Long, Set,
   * IdSelectionOptions, RatingCostWidgetParameters)}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getRatingCostWidgetData(Long, Set,
   * IdSelectionOptions, RatingCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getRatingCostWidgetData(Long, Set, IdSelectionOptions, RatingCostWidgetParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CostWidgetData AggregateOverlayDiagramService.getRatingCostWidgetData(Long, Set, IdSelectionOptions, RatingCostWidgetParameters)"
  })
  void testGetRatingCostWidgetData() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    RatingCostWidgetDao ratingCostWidgetDao = mock(RatingCostWidgetDao.class);
    when(ratingCostWidgetDao.findWidgetData(
            anyLong(), Mockito.<Set<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findCostKindsBySubjectKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            ratingCostWidgetDao,
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            measurableDao,
            applicationDao,
            costKindDao,
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

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
    CostWidgetData actualRatingCostWidgetData =
        aggregateOverlayDiagramService.getRatingCostWidgetData(
            1L,
            filterParams,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            ImmutableRatingCostWidgetParameters.builder().build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(ratingCostWidgetDao).findWidgetData(eq(1L), isA(Set.class), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(costKindDao).findCostKindsBySubjectKind(EntityKind.MEASURABLE_RATING);
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    assertTrue(actualRatingCostWidgetData instanceof ImmutableCostWidgetData);
    Set<Application> applicationsResult = actualRatingCostWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualRatingCostWidgetData.cellData());
    assertSame(applicationsResult, actualRatingCostWidgetData.costKinds());
    assertSame(applicationsResult, actualRatingCostWidgetData.measurables());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getRatingCostWidgetData(Long, Set,
   * IdSelectionOptions, RatingCostWidgetParameters)}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getRatingCostWidgetData(Long, Set,
   * IdSelectionOptions, RatingCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getRatingCostWidgetData(Long, Set, IdSelectionOptions, RatingCostWidgetParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CostWidgetData AggregateOverlayDiagramService.getRatingCostWidgetData(Long, Set, IdSelectionOptions, RatingCostWidgetParameters)"
  })
  void testGetRatingCostWidgetData2() {
    // Arrange
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());
    when(ratingCostWidgetDao.findWidgetData(
            anyLong(), Mockito.<Set<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(costKindDao.findCostKindsBySubjectKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

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
    CostWidgetData actualRatingCostWidgetData =
        aggregateOverlayDiagramService.getRatingCostWidgetData(
            1L,
            filterParams,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            ImmutableRatingCostWidgetParameters.builder().build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(ratingCostWidgetDao).findWidgetData(eq(1L), isA(Set.class), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(costKindDao).findCostKindsBySubjectKind(EntityKind.MEASURABLE_RATING);
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    assertTrue(actualRatingCostWidgetData instanceof ImmutableCostWidgetData);
    Set<Application> applicationsResult = actualRatingCostWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualRatingCostWidgetData.cellData());
    assertSame(applicationsResult, actualRatingCostWidgetData.costKinds());
    assertSame(applicationsResult, actualRatingCostWidgetData.measurables());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getRatingCostWidgetData(Long, Set,
   * IdSelectionOptions, RatingCostWidgetParameters)}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getRatingCostWidgetData(Long, Set,
   * IdSelectionOptions, RatingCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getRatingCostWidgetData(Long, Set, IdSelectionOptions, RatingCostWidgetParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CostWidgetData AggregateOverlayDiagramService.getRatingCostWidgetData(Long, Set, IdSelectionOptions, RatingCostWidgetParameters)"
  })
  void testGetRatingCostWidgetData3() {
    // Arrange
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());
    when(ratingCostWidgetDao.findWidgetData(
            anyLong(), Mockito.<Set<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(costKindDao.findCostKindsBySubjectKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

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
    CostWidgetData actualRatingCostWidgetData =
        aggregateOverlayDiagramService.getRatingCostWidgetData(
            1L,
            filterParams,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            ImmutableRatingCostWidgetParameters.builder().build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(ratingCostWidgetDao).findWidgetData(eq(1L), isA(Set.class), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(costKindDao).findCostKindsBySubjectKind(EntityKind.MEASURABLE_RATING);
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    assertTrue(actualRatingCostWidgetData instanceof ImmutableCostWidgetData);
    Set<Application> applicationsResult = actualRatingCostWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualRatingCostWidgetData.cellData());
    assertSame(applicationsResult, actualRatingCostWidgetData.costKinds());
    assertSame(applicationsResult, actualRatingCostWidgetData.measurables());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getRatingCostWidgetData(Long, Set,
   * IdSelectionOptions, RatingCostWidgetParameters)}.
   *
   * <ul>
   *   <li>Given builder definitionId one build.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getRatingCostWidgetData(Long, Set,
   * IdSelectionOptions, RatingCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getRatingCostWidgetData(Long, Set, IdSelectionOptions, RatingCostWidgetParameters); given builder definitionId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CostWidgetData AggregateOverlayDiagramService.getRatingCostWidgetData(Long, Set, IdSelectionOptions, RatingCostWidgetParameters)"
  })
  void testGetRatingCostWidgetData_givenBuilderDefinitionIdOneBuild() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    RatingCostWidgetDao ratingCostWidgetDao = mock(RatingCostWidgetDao.class);
    when(ratingCostWidgetDao.findWidgetData(
            anyLong(), Mockito.<Set<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findCostKindsBySubjectKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            ratingCostWidgetDao,
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            measurableDao,
            applicationDao,
            costKindDao,
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));

    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();
    filterParams.add(ImmutableAssessmentBasedSelectionFilter.builder().definitionId(1L).build());

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
    CostWidgetData actualRatingCostWidgetData =
        aggregateOverlayDiagramService.getRatingCostWidgetData(
            1L,
            filterParams,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            ImmutableRatingCostWidgetParameters.builder().build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(ratingCostWidgetDao).findWidgetData(eq(1L), isA(Set.class), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(costKindDao).findCostKindsBySubjectKind(EntityKind.MEASURABLE_RATING);
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    assertTrue(actualRatingCostWidgetData instanceof ImmutableCostWidgetData);
    Set<Application> applicationsResult = actualRatingCostWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualRatingCostWidgetData.cellData());
    assertSame(applicationsResult, actualRatingCostWidgetData.costKinds());
    assertSame(applicationsResult, actualRatingCostWidgetData.measurables());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getRatingCostWidgetData(Long, Set,
   * IdSelectionOptions, RatingCostWidgetParameters)}.
   *
   * <ul>
   *   <li>Given {@code INTERNALLY_HOSTED}.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getRatingCostWidgetData(Long, Set,
   * IdSelectionOptions, RatingCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getRatingCostWidgetData(Long, Set, IdSelectionOptions, RatingCostWidgetParameters); given 'INTERNALLY_HOSTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CostWidgetData AggregateOverlayDiagramService.getRatingCostWidgetData(Long, Set, IdSelectionOptions, RatingCostWidgetParameters)"
  })
  void testGetRatingCostWidgetData_givenInternallyHosted() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    RatingCostWidgetDao ratingCostWidgetDao = mock(RatingCostWidgetDao.class);
    when(ratingCostWidgetDao.findWidgetData(
            anyLong(), Mockito.<Set<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findCostKindsBySubjectKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            ratingCostWidgetDao,
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            measurableDao,
            applicationDao,
            costKindDao,
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.INTERNALLY_HOSTED);
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
    CostWidgetData actualRatingCostWidgetData =
        aggregateOverlayDiagramService.getRatingCostWidgetData(
            1L,
            filterParams,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            ImmutableRatingCostWidgetParameters.builder().build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(ratingCostWidgetDao).findWidgetData(eq(1L), isA(Set.class), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(costKindDao).findCostKindsBySubjectKind(EntityKind.MEASURABLE_RATING);
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    assertTrue(actualRatingCostWidgetData instanceof ImmutableCostWidgetData);
    Set<Application> applicationsResult = actualRatingCostWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualRatingCostWidgetData.cellData());
    assertSame(applicationsResult, actualRatingCostWidgetData.costKinds());
    assertSame(applicationsResult, actualRatingCostWidgetData.measurables());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getRatingCostWidgetData(Long, Set,
   * IdSelectionOptions, RatingCostWidgetParameters)}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getRatingCostWidgetData(Long, Set,
   * IdSelectionOptions, RatingCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getRatingCostWidgetData(Long, Set, IdSelectionOptions, RatingCostWidgetParameters); given 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CostWidgetData AggregateOverlayDiagramService.getRatingCostWidgetData(Long, Set, IdSelectionOptions, RatingCostWidgetParameters)"
  })
  void testGetRatingCostWidgetData_givenPending() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    RatingCostWidgetDao ratingCostWidgetDao = mock(RatingCostWidgetDao.class);
    when(ratingCostWidgetDao.findWidgetData(
            anyLong(), Mockito.<Set<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findCostKindsBySubjectKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            ratingCostWidgetDao,
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            measurableDao,
            applicationDao,
            costKindDao,
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

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
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    CostWidgetData actualRatingCostWidgetData =
        aggregateOverlayDiagramService.getRatingCostWidgetData(
            1L,
            filterParams,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            ImmutableRatingCostWidgetParameters.builder().build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(ratingCostWidgetDao).findWidgetData(eq(1L), isA(Set.class), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(costKindDao).findCostKindsBySubjectKind(EntityKind.MEASURABLE_RATING);
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    assertTrue(actualRatingCostWidgetData instanceof ImmutableCostWidgetData);
    Set<Application> applicationsResult = actualRatingCostWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualRatingCostWidgetData.cellData());
    assertSame(applicationsResult, actualRatingCostWidgetData.costKinds());
    assertSame(applicationsResult, actualRatingCostWidgetData.measurables());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getRatingCostWidgetData(Long, Set,
   * IdSelectionOptions, RatingCostWidgetParameters)}.
   *
   * <ul>
   *   <li>Then return applications size is one.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getRatingCostWidgetData(Long, Set,
   * IdSelectionOptions, RatingCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getRatingCostWidgetData(Long, Set, IdSelectionOptions, RatingCostWidgetParameters); then return applications size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CostWidgetData AggregateOverlayDiagramService.getRatingCostWidgetData(Long, Set, IdSelectionOptions, RatingCostWidgetParameters)"
  })
  void testGetRatingCostWidgetData_thenReturnApplicationsSizeIsOne() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    RatingCostWidgetDao ratingCostWidgetDao = mock(RatingCostWidgetDao.class);
    when(ratingCostWidgetDao.findWidgetData(
            anyLong(), Mockito.<Set<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(applicationList);

    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findCostKindsBySubjectKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            ratingCostWidgetDao,
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            measurableDao,
            applicationDao,
            costKindDao,
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

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
    CostWidgetData actualRatingCostWidgetData =
        aggregateOverlayDiagramService.getRatingCostWidgetData(
            1L,
            filterParams,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            ImmutableRatingCostWidgetParameters.builder().build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(ratingCostWidgetDao).findWidgetData(eq(1L), isA(Set.class), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(costKindDao).findCostKindsBySubjectKind(EntityKind.MEASURABLE_RATING);
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    assertTrue(actualRatingCostWidgetData instanceof ImmutableCostWidgetData);
    assertEquals(1, actualRatingCostWidgetData.applications().size());
    Set<CostWidgetDatum> cellDataResult = actualRatingCostWidgetData.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualRatingCostWidgetData.costKinds());
    assertSame(cellDataResult, actualRatingCostWidgetData.measurables());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getRatingCostWidgetData(Long, Set,
   * IdSelectionOptions, RatingCostWidgetParameters)}.
   *
   * <ul>
   *   <li>Then return applications size is one.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getRatingCostWidgetData(Long, Set,
   * IdSelectionOptions, RatingCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getRatingCostWidgetData(Long, Set, IdSelectionOptions, RatingCostWidgetParameters); then return applications size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CostWidgetData AggregateOverlayDiagramService.getRatingCostWidgetData(Long, Set, IdSelectionOptions, RatingCostWidgetParameters)"
  })
  void testGetRatingCostWidgetData_thenReturnApplicationsSizeIsOne2() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    RatingCostWidgetDao ratingCostWidgetDao = mock(RatingCostWidgetDao.class);
    when(ratingCostWidgetDao.findWidgetData(
            anyLong(), Mockito.<Set<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(applicationList);

    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findCostKindsBySubjectKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            ratingCostWidgetDao,
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            measurableDao,
            applicationDao,
            costKindDao,
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

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
    CostWidgetData actualRatingCostWidgetData =
        aggregateOverlayDiagramService.getRatingCostWidgetData(
            1L,
            filterParams,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            ImmutableRatingCostWidgetParameters.builder().build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(ratingCostWidgetDao).findWidgetData(eq(1L), isA(Set.class), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(costKindDao).findCostKindsBySubjectKind(EntityKind.MEASURABLE_RATING);
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    assertTrue(actualRatingCostWidgetData instanceof ImmutableCostWidgetData);
    assertEquals(1, actualRatingCostWidgetData.applications().size());
    Set<CostWidgetDatum> cellDataResult = actualRatingCostWidgetData.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualRatingCostWidgetData.costKinds());
    assertSame(cellDataResult, actualRatingCostWidgetData.measurables());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getRatingCostWidgetData(Long, Set,
   * IdSelectionOptions, RatingCostWidgetParameters)}.
   *
   * <ul>
   *   <li>Then return cellData size is one.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getRatingCostWidgetData(Long, Set,
   * IdSelectionOptions, RatingCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getRatingCostWidgetData(Long, Set, IdSelectionOptions, RatingCostWidgetParameters); then return cellData size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CostWidgetData AggregateOverlayDiagramService.getRatingCostWidgetData(Long, Set, IdSelectionOptions, RatingCostWidgetParameters)"
  })
  void testGetRatingCostWidgetData_thenReturnCellDataSizeIsOne() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    HashSet<CostWidgetDatum> costWidgetDatumSet = new HashSet<>();
    costWidgetDatumSet.add(ImmutableCostWidgetDatum.builder().cellExternalId("42").build());

    RatingCostWidgetDao ratingCostWidgetDao = mock(RatingCostWidgetDao.class);
    when(ratingCostWidgetDao.findWidgetData(
            anyLong(), Mockito.<Set<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(costWidgetDatumSet);

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findCostKindsBySubjectKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            ratingCostWidgetDao,
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            measurableDao,
            applicationDao,
            costKindDao,
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

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
    CostWidgetData actualRatingCostWidgetData =
        aggregateOverlayDiagramService.getRatingCostWidgetData(
            1L,
            filterParams,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            ImmutableRatingCostWidgetParameters.builder().build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(ratingCostWidgetDao).findWidgetData(eq(1L), isA(Set.class), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(costKindDao).findCostKindsBySubjectKind(EntityKind.MEASURABLE_RATING);
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    assertTrue(actualRatingCostWidgetData instanceof ImmutableCostWidgetData);
    assertEquals(1, actualRatingCostWidgetData.cellData().size());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getRatingCostWidgetData(Long, Set,
   * IdSelectionOptions, RatingCostWidgetParameters)}.
   *
   * <ul>
   *   <li>Then return costKinds size is one.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getRatingCostWidgetData(Long, Set,
   * IdSelectionOptions, RatingCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getRatingCostWidgetData(Long, Set, IdSelectionOptions, RatingCostWidgetParameters); then return costKinds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CostWidgetData AggregateOverlayDiagramService.getRatingCostWidgetData(Long, Set, IdSelectionOptions, RatingCostWidgetParameters)"
  })
  void testGetRatingCostWidgetData_thenReturnCostKindsSizeIsOne() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    RatingCostWidgetDao ratingCostWidgetDao = mock(RatingCostWidgetDao.class);
    when(ratingCostWidgetDao.findWidgetData(
            anyLong(), Mockito.<Set<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    HashSet<CostKindWithYears> costKindWithYearsSet = new HashSet<>();

    ImmutableCostKindWithYears.Builder builderResult = ImmutableCostKindWithYears.builder();
    costKindWithYearsSet.add(
        builderResult
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .build());

    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findCostKindsBySubjectKind(Mockito.<EntityKind>any()))
        .thenReturn(costKindWithYearsSet);

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            ratingCostWidgetDao,
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            measurableDao,
            applicationDao,
            costKindDao,
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

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
    CostWidgetData actualRatingCostWidgetData =
        aggregateOverlayDiagramService.getRatingCostWidgetData(
            1L,
            filterParams,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            ImmutableRatingCostWidgetParameters.builder().build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(ratingCostWidgetDao).findWidgetData(eq(1L), isA(Set.class), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(costKindDao).findCostKindsBySubjectKind(EntityKind.MEASURABLE_RATING);
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    assertTrue(actualRatingCostWidgetData instanceof ImmutableCostWidgetData);
    assertEquals(1, actualRatingCostWidgetData.costKinds().size());
    Set<Application> applicationsResult = actualRatingCostWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualRatingCostWidgetData.cellData());
    assertSame(applicationsResult, actualRatingCostWidgetData.measurables());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getRatingCostWidgetData(Long, Set,
   * IdSelectionOptions, RatingCostWidgetParameters)}.
   *
   * <ul>
   *   <li>Then return measurables is applications.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getRatingCostWidgetData(Long, Set,
   * IdSelectionOptions, RatingCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getRatingCostWidgetData(Long, Set, IdSelectionOptions, RatingCostWidgetParameters); then return measurables is applications")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CostWidgetData AggregateOverlayDiagramService.getRatingCostWidgetData(Long, Set, IdSelectionOptions, RatingCostWidgetParameters)"
  })
  void testGetRatingCostWidgetData_thenReturnMeasurablesIsApplications() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    RatingCostWidgetDao ratingCostWidgetDao = mock(RatingCostWidgetDao.class);
    when(ratingCostWidgetDao.findWidgetData(
            anyLong(), Mockito.<Set<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findCostKindsBySubjectKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            ratingCostWidgetDao,
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            measurableDao,
            applicationDao,
            costKindDao,
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

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
    CostWidgetData actualRatingCostWidgetData =
        aggregateOverlayDiagramService.getRatingCostWidgetData(
            1L,
            filterParams,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            ImmutableRatingCostWidgetParameters.builder().build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(ratingCostWidgetDao).findWidgetData(eq(1L), isA(Set.class), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(costKindDao).findCostKindsBySubjectKind(EntityKind.MEASURABLE_RATING);
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    assertTrue(actualRatingCostWidgetData instanceof ImmutableCostWidgetData);
    Set<Application> applicationsResult = actualRatingCostWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualRatingCostWidgetData.cellData());
    assertSame(applicationsResult, actualRatingCostWidgetData.costKinds());
    assertSame(applicationsResult, actualRatingCostWidgetData.measurables());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getRatingCostWidgetData(Long, Set,
   * IdSelectionOptions, RatingCostWidgetParameters)}.
   *
   * <ul>
   *   <li>Then return measurables size is one.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getRatingCostWidgetData(Long, Set,
   * IdSelectionOptions, RatingCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getRatingCostWidgetData(Long, Set, IdSelectionOptions, RatingCostWidgetParameters); then return measurables size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CostWidgetData AggregateOverlayDiagramService.getRatingCostWidgetData(Long, Set, IdSelectionOptions, RatingCostWidgetParameters)"
  })
  void testGetRatingCostWidgetData_thenReturnMeasurablesSizeIsOne() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    RatingCostWidgetDao ratingCostWidgetDao = mock(RatingCostWidgetDao.class);
    when(ratingCostWidgetDao.findWidgetData(
            anyLong(), Mockito.<Set<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
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

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(measurableList);

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findCostKindsBySubjectKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            ratingCostWidgetDao,
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            measurableDao,
            applicationDao,
            costKindDao,
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

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
    CostWidgetData actualRatingCostWidgetData =
        aggregateOverlayDiagramService.getRatingCostWidgetData(
            1L,
            filterParams,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            ImmutableRatingCostWidgetParameters.builder().build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(ratingCostWidgetDao).findWidgetData(eq(1L), isA(Set.class), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(costKindDao).findCostKindsBySubjectKind(EntityKind.MEASURABLE_RATING);
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    assertTrue(actualRatingCostWidgetData instanceof ImmutableCostWidgetData);
    assertEquals(1, actualRatingCostWidgetData.measurables().size());
    Set<Application> applicationsResult = actualRatingCostWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualRatingCostWidgetData.cellData());
    assertSame(applicationsResult, actualRatingCostWidgetData.costKinds());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getRatingCostWidgetData(Long, Set,
   * IdSelectionOptions, RatingCostWidgetParameters)}.
   *
   * <ul>
   *   <li>Then return measurables size is one.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getRatingCostWidgetData(Long, Set,
   * IdSelectionOptions, RatingCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getRatingCostWidgetData(Long, Set, IdSelectionOptions, RatingCostWidgetParameters); then return measurables size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CostWidgetData AggregateOverlayDiagramService.getRatingCostWidgetData(Long, Set, IdSelectionOptions, RatingCostWidgetParameters)"
  })
  void testGetRatingCostWidgetData_thenReturnMeasurablesSizeIsOne2() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    RatingCostWidgetDao ratingCostWidgetDao = mock(RatingCostWidgetDao.class);
    when(ratingCostWidgetDao.findWidgetData(
            anyLong(), Mockito.<Set<Long>>any(), Mockito.<Select<Record1<Long>>>any()))
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

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(measurableList);

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    CostKindDao costKindDao = mock(CostKindDao.class);
    when(costKindDao.findCostKindsBySubjectKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            ratingCostWidgetDao,
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            measurableDao,
            applicationDao,
            costKindDao,
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));
    HashSet<AssessmentBasedSelectionFilter> filterParams = new HashSet<>();

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
    CostWidgetData actualRatingCostWidgetData =
        aggregateOverlayDiagramService.getRatingCostWidgetData(
            1L,
            filterParams,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            ImmutableRatingCostWidgetParameters.builder().build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(ratingCostWidgetDao).findWidgetData(eq(1L), isA(Set.class), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(costKindDao).findCostKindsBySubjectKind(EntityKind.MEASURABLE_RATING);
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    assertTrue(actualRatingCostWidgetData instanceof ImmutableCostWidgetData);
    assertEquals(1, actualRatingCostWidgetData.measurables().size());
    Set<Application> applicationsResult = actualRatingCostWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualRatingCostWidgetData.cellData());
    assertSame(applicationsResult, actualRatingCostWidgetData.costKinds());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getBackingEntityWidgetData(Long)}.
   *
   * <ul>
   *   <li>Then return cellData.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getBackingEntityWidgetData(Long)}
   */
  @Test
  @DisplayName("Test getBackingEntityWidgetData(Long); then return cellData")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BackingEntityWidgetData AggregateOverlayDiagramService.getBackingEntityWidgetData(Long)"
  })
  void testGetBackingEntityWidgetData_thenReturnCellData() {
    // Arrange
    BackingEntityWidgetDao backingEntityWidgetDao = mock(BackingEntityWidgetDao.class);
    when(backingEntityWidgetDao.findWidgetData(anyLong())).thenReturn(new HashSet<>());
    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            mock(AggregateOverlayDiagramDao.class),
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            backingEntityWidgetDao,
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            mock(ApplicationDao.class),
            mock(CostKindDao.class),
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));

    // Act
    BackingEntityWidgetData actualBackingEntityWidgetData =
        aggregateOverlayDiagramService.getBackingEntityWidgetData(1L);
    Set<BackingEntityWidgetDatum> actualCellDataResult = actualBackingEntityWidgetData.cellData();

    // Assert
    verify(backingEntityWidgetDao).findWidgetData(1L);
    assertTrue(actualBackingEntityWidgetData instanceof ImmutableBackingEntityWidgetData);
    Set<BackingEntityWidgetDatum> cellDataResult = actualBackingEntityWidgetData.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertTrue(aggregateOverlayDiagramService.findAll().isEmpty());
    assertSame(cellDataResult, actualCellDataResult);
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getBackingEntityWidgetData(Long)}.
   *
   * <ul>
   *   <li>Then return cellData Empty.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getBackingEntityWidgetData(Long)}
   */
  @Test
  @DisplayName("Test getBackingEntityWidgetData(Long); then return cellData Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BackingEntityWidgetData AggregateOverlayDiagramService.getBackingEntityWidgetData(Long)"
  })
  void testGetBackingEntityWidgetData_thenReturnCellDataEmpty() {
    // Arrange
    BackingEntityWidgetDao backingEntityWidgetDao = mock(BackingEntityWidgetDao.class);
    when(backingEntityWidgetDao.findWidgetData(anyLong())).thenReturn(new HashSet<>());
    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            mock(AggregateOverlayDiagramDao.class),
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            backingEntityWidgetDao,
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            mock(ApplicationDao.class),
            mock(CostKindDao.class),
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));

    // Act
    BackingEntityWidgetData actualBackingEntityWidgetData =
        aggregateOverlayDiagramService.getBackingEntityWidgetData(1L);

    // Assert
    verify(backingEntityWidgetDao).findWidgetData(1L);
    assertTrue(actualBackingEntityWidgetData instanceof ImmutableBackingEntityWidgetData);
    assertTrue(actualBackingEntityWidgetData.cellData().isEmpty());
    assertTrue(aggregateOverlayDiagramService.findAll().isEmpty());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getBackingEntityWidgetData(Long)}.
   *
   * <ul>
   *   <li>Then return cellData is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getBackingEntityWidgetData(Long)}
   */
  @Test
  @DisplayName("Test getBackingEntityWidgetData(Long); then return cellData is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BackingEntityWidgetData AggregateOverlayDiagramService.getBackingEntityWidgetData(Long)"
  })
  void testGetBackingEntityWidgetData_thenReturnCellDataIsHashSet() {
    // Arrange
    ImmutableBackingEntityWidgetDatum.Builder builderResult =
        ImmutableBackingEntityWidgetDatum.builder();
    builderResult.addBackingEntityReferences(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    ImmutableBackingEntityWidgetDatum immutableBackingEntityWidgetDatum =
        builderResult.cellExternalId("42").build();

    HashSet<BackingEntityWidgetDatum> backingEntityWidgetDatumSet = new HashSet<>();
    backingEntityWidgetDatumSet.add(
        ImmutableBackingEntityWidgetDatum.builder().cellExternalId("42").build());
    backingEntityWidgetDatumSet.add(immutableBackingEntityWidgetDatum);

    BackingEntityWidgetDao backingEntityWidgetDao = mock(BackingEntityWidgetDao.class);
    when(backingEntityWidgetDao.findWidgetData(anyLong())).thenReturn(backingEntityWidgetDatumSet);
    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            mock(AggregateOverlayDiagramDao.class),
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            backingEntityWidgetDao,
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            mock(ApplicationDao.class),
            mock(CostKindDao.class),
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));

    // Act
    BackingEntityWidgetData actualBackingEntityWidgetData =
        aggregateOverlayDiagramService.getBackingEntityWidgetData(1L);

    // Assert
    verify(backingEntityWidgetDao).findWidgetData(1L);
    assertTrue(actualBackingEntityWidgetData instanceof ImmutableBackingEntityWidgetData);
    assertTrue(aggregateOverlayDiagramService.findAll().isEmpty());
    assertEquals(backingEntityWidgetDatumSet, actualBackingEntityWidgetData.cellData());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getBackingEntityWidgetData(Long)}.
   *
   * <ul>
   *   <li>Then return cellData size is one.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getBackingEntityWidgetData(Long)}
   */
  @Test
  @DisplayName("Test getBackingEntityWidgetData(Long); then return cellData size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BackingEntityWidgetData AggregateOverlayDiagramService.getBackingEntityWidgetData(Long)"
  })
  void testGetBackingEntityWidgetData_thenReturnCellDataSizeIsOne() {
    // Arrange
    HashSet<BackingEntityWidgetDatum> backingEntityWidgetDatumSet = new HashSet<>();
    backingEntityWidgetDatumSet.add(
        ImmutableBackingEntityWidgetDatum.builder().cellExternalId("42").build());

    BackingEntityWidgetDao backingEntityWidgetDao = mock(BackingEntityWidgetDao.class);
    when(backingEntityWidgetDao.findWidgetData(anyLong())).thenReturn(backingEntityWidgetDatumSet);
    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            mock(AggregateOverlayDiagramDao.class),
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            backingEntityWidgetDao,
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            mock(ApplicationDao.class),
            mock(CostKindDao.class),
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));

    // Act
    BackingEntityWidgetData actualBackingEntityWidgetData =
        aggregateOverlayDiagramService.getBackingEntityWidgetData(1L);

    // Assert
    verify(backingEntityWidgetDao).findWidgetData(1L);
    assertTrue(actualBackingEntityWidgetData instanceof ImmutableBackingEntityWidgetData);
    assertEquals(1, actualBackingEntityWidgetData.cellData().size());
    assertTrue(aggregateOverlayDiagramService.findAll().isEmpty());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#findPresetsForDiagram(Long)}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#findPresetsForDiagram(Long)}
   */
  @Test
  @DisplayName("Test findPresetsForDiagram(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AggregateOverlayDiagramService.findPresetsForDiagram(Long)"})
  void testFindPresetsForDiagram() {
    // Arrange
    AggregateOverlayDiagramPresetDao aggregateOverlayDiagramPresetDao =
        mock(AggregateOverlayDiagramPresetDao.class);
    when(aggregateOverlayDiagramPresetDao.findPresetsForDiagram(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());
    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            mock(AggregateOverlayDiagramDao.class),
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            aggregateOverlayDiagramPresetDao,
            mock(MeasurableDao.class),
            mock(ApplicationDao.class),
            mock(CostKindDao.class),
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));

    // Act
    Set<AggregateOverlayDiagramPreset> actualFindPresetsForDiagramResult =
        aggregateOverlayDiagramService.findPresetsForDiagram(1L);

    // Assert
    verify(aggregateOverlayDiagramPresetDao).findPresetsForDiagram(1L);
    assertTrue(actualFindPresetsForDiagramResult.isEmpty());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#createPreset(OverlayDiagramPresetCreateCommand,
   * String)}.
   *
   * <p>Method under test: {@link
   * AggregateOverlayDiagramService#createPreset(OverlayDiagramPresetCreateCommand, String)}
   */
  @Test
  @DisplayName("Test createPreset(OverlayDiagramPresetCreateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int AggregateOverlayDiagramService.createPreset(OverlayDiagramPresetCreateCommand, String)"
  })
  void testCreatePreset() {
    // Arrange
    AggregateOverlayDiagramPresetDao aggregateOverlayDiagramPresetDao =
        mock(AggregateOverlayDiagramPresetDao.class);
    when(aggregateOverlayDiagramPresetDao.create(
            Mockito.<OverlayDiagramPresetCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1);
    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            mock(AggregateOverlayDiagramDao.class),
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            aggregateOverlayDiagramPresetDao,
            mock(MeasurableDao.class),
            mock(ApplicationDao.class),
            mock(CostKindDao.class),
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));

    // Act
    int actualCreatePresetResult = aggregateOverlayDiagramService.createPreset(null, "janedoe");

    // Assert
    verify(aggregateOverlayDiagramPresetDao).create(isNull(), eq("janedoe"));
    assertEquals(1, actualCreatePresetResult);
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getAppComplexityWidgetData(long, Set,
   * IdSelectionOptions, AppComplexityWidgetParameters)}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getAppComplexityWidgetData(long,
   * Set, IdSelectionOptions, AppComplexityWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getAppComplexityWidgetData(long, Set, IdSelectionOptions, AppComplexityWidgetParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ComplexityWidgetData AggregateOverlayDiagramService.getAppComplexityWidgetData(long, Set, IdSelectionOptions, AppComplexityWidgetParameters)"
  })
  void testGetAppComplexityWidgetData() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ComplexityKindDao complexityKindDao = mock(ComplexityKindDao.class);
    when(complexityKindDao.findAll()).thenReturn(new HashSet<>());

    ComplexityWidgetDao complexityWidgetDao = mock(ComplexityWidgetDao.class);
    when(complexityWidgetDao.findWidgetData(
            anyLong(),
            Mockito.<EntityKind>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            applicationDao,
            mock(CostKindDao.class),
            complexityKindDao,
            complexityWidgetDao,
            mock(AttestationWidgetDao.class));
    HashSet<AssessmentBasedSelectionFilter> assessmentBasedSelectionFilters = new HashSet<>();

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
    ComplexityWidgetData actualAppComplexityWidgetData =
        aggregateOverlayDiagramService.getAppComplexityWidgetData(
            1L,
            assessmentBasedSelectionFilters,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            ImmutableAppComplexityWidgetParameters.builder().build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(complexityWidgetDao)
        .findWidgetData(eq(1L), eq(EntityKind.APPLICATION), isA(Set.class), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(complexityKindDao).findAll();
    assertTrue(actualAppComplexityWidgetData instanceof ImmutableComplexityWidgetData);
    Set<Application> applicationsResult = actualAppComplexityWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualAppComplexityWidgetData.cellData());
    assertSame(applicationsResult, actualAppComplexityWidgetData.complexityKinds());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getAppComplexityWidgetData(long, Set,
   * IdSelectionOptions, AppComplexityWidgetParameters)}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getAppComplexityWidgetData(long,
   * Set, IdSelectionOptions, AppComplexityWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getAppComplexityWidgetData(long, Set, IdSelectionOptions, AppComplexityWidgetParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ComplexityWidgetData AggregateOverlayDiagramService.getAppComplexityWidgetData(long, Set, IdSelectionOptions, AppComplexityWidgetParameters)"
  })
  void testGetAppComplexityWidgetData2() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ComplexityKindDao complexityKindDao = mock(ComplexityKindDao.class);
    when(complexityKindDao.findAll()).thenReturn(new HashSet<>());

    ComplexityWidgetDao complexityWidgetDao = mock(ComplexityWidgetDao.class);
    when(complexityWidgetDao.findWidgetData(
            anyLong(),
            Mockito.<EntityKind>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            applicationDao,
            mock(CostKindDao.class),
            complexityKindDao,
            complexityWidgetDao,
            mock(AttestationWidgetDao.class));
    HashSet<AssessmentBasedSelectionFilter> assessmentBasedSelectionFilters = new HashSet<>();

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
    ComplexityWidgetData actualAppComplexityWidgetData =
        aggregateOverlayDiagramService.getAppComplexityWidgetData(
            1L,
            assessmentBasedSelectionFilters,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            ImmutableAppComplexityWidgetParameters.builder().build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(complexityWidgetDao)
        .findWidgetData(eq(1L), eq(EntityKind.APPLICATION), isA(Set.class), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(complexityKindDao).findAll();
    assertTrue(actualAppComplexityWidgetData instanceof ImmutableComplexityWidgetData);
    Set<Application> applicationsResult = actualAppComplexityWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualAppComplexityWidgetData.cellData());
    assertSame(applicationsResult, actualAppComplexityWidgetData.complexityKinds());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getAppComplexityWidgetData(long, Set,
   * IdSelectionOptions, AppComplexityWidgetParameters)}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getAppComplexityWidgetData(long,
   * Set, IdSelectionOptions, AppComplexityWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getAppComplexityWidgetData(long, Set, IdSelectionOptions, AppComplexityWidgetParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ComplexityWidgetData AggregateOverlayDiagramService.getAppComplexityWidgetData(long, Set, IdSelectionOptions, AppComplexityWidgetParameters)"
  })
  void testGetAppComplexityWidgetData3() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ComplexityKindDao complexityKindDao = mock(ComplexityKindDao.class);
    when(complexityKindDao.findAll()).thenReturn(new HashSet<>());

    ComplexityWidgetDao complexityWidgetDao = mock(ComplexityWidgetDao.class);
    when(complexityWidgetDao.findWidgetData(
            anyLong(),
            Mockito.<EntityKind>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            applicationDao,
            mock(CostKindDao.class),
            complexityKindDao,
            complexityWidgetDao,
            mock(AttestationWidgetDao.class));
    HashSet<AssessmentBasedSelectionFilter> assessmentBasedSelectionFilters = new HashSet<>();

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
    ComplexityWidgetData actualAppComplexityWidgetData =
        aggregateOverlayDiagramService.getAppComplexityWidgetData(
            1L,
            assessmentBasedSelectionFilters,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            ImmutableAppComplexityWidgetParameters.builder().build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(complexityWidgetDao)
        .findWidgetData(eq(1L), eq(EntityKind.APPLICATION), isA(Set.class), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(complexityKindDao).findAll();
    assertTrue(actualAppComplexityWidgetData instanceof ImmutableComplexityWidgetData);
    Set<Application> applicationsResult = actualAppComplexityWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualAppComplexityWidgetData.cellData());
    assertSame(applicationsResult, actualAppComplexityWidgetData.complexityKinds());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getAppComplexityWidgetData(long, Set,
   * IdSelectionOptions, AppComplexityWidgetParameters)}.
   *
   * <ul>
   *   <li>Given builder definitionId one build.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getAppComplexityWidgetData(long,
   * Set, IdSelectionOptions, AppComplexityWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getAppComplexityWidgetData(long, Set, IdSelectionOptions, AppComplexityWidgetParameters); given builder definitionId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ComplexityWidgetData AggregateOverlayDiagramService.getAppComplexityWidgetData(long, Set, IdSelectionOptions, AppComplexityWidgetParameters)"
  })
  void testGetAppComplexityWidgetData_givenBuilderDefinitionIdOneBuild() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ComplexityKindDao complexityKindDao = mock(ComplexityKindDao.class);
    when(complexityKindDao.findAll()).thenReturn(new HashSet<>());

    ComplexityWidgetDao complexityWidgetDao = mock(ComplexityWidgetDao.class);
    when(complexityWidgetDao.findWidgetData(
            anyLong(),
            Mockito.<EntityKind>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            applicationDao,
            mock(CostKindDao.class),
            complexityKindDao,
            complexityWidgetDao,
            mock(AttestationWidgetDao.class));

    HashSet<AssessmentBasedSelectionFilter> assessmentBasedSelectionFilters = new HashSet<>();
    assessmentBasedSelectionFilters.add(
        ImmutableAssessmentBasedSelectionFilter.builder().definitionId(1L).build());

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
    ComplexityWidgetData actualAppComplexityWidgetData =
        aggregateOverlayDiagramService.getAppComplexityWidgetData(
            1L,
            assessmentBasedSelectionFilters,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            ImmutableAppComplexityWidgetParameters.builder().build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(complexityWidgetDao)
        .findWidgetData(eq(1L), eq(EntityKind.APPLICATION), isA(Set.class), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(complexityKindDao).findAll();
    assertTrue(actualAppComplexityWidgetData instanceof ImmutableComplexityWidgetData);
    Set<Application> applicationsResult = actualAppComplexityWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualAppComplexityWidgetData.cellData());
    assertSame(applicationsResult, actualAppComplexityWidgetData.complexityKinds());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getAppComplexityWidgetData(long, Set,
   * IdSelectionOptions, AppComplexityWidgetParameters)}.
   *
   * <ul>
   *   <li>Given {@code INTERNALLY_HOSTED}.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getAppComplexityWidgetData(long,
   * Set, IdSelectionOptions, AppComplexityWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getAppComplexityWidgetData(long, Set, IdSelectionOptions, AppComplexityWidgetParameters); given 'INTERNALLY_HOSTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ComplexityWidgetData AggregateOverlayDiagramService.getAppComplexityWidgetData(long, Set, IdSelectionOptions, AppComplexityWidgetParameters)"
  })
  void testGetAppComplexityWidgetData_givenInternallyHosted() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ComplexityKindDao complexityKindDao = mock(ComplexityKindDao.class);
    when(complexityKindDao.findAll()).thenReturn(new HashSet<>());

    ComplexityWidgetDao complexityWidgetDao = mock(ComplexityWidgetDao.class);
    when(complexityWidgetDao.findWidgetData(
            anyLong(),
            Mockito.<EntityKind>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            applicationDao,
            mock(CostKindDao.class),
            complexityKindDao,
            complexityWidgetDao,
            mock(AttestationWidgetDao.class));
    HashSet<AssessmentBasedSelectionFilter> assessmentBasedSelectionFilters = new HashSet<>();

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.INTERNALLY_HOSTED);
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
    ComplexityWidgetData actualAppComplexityWidgetData =
        aggregateOverlayDiagramService.getAppComplexityWidgetData(
            1L,
            assessmentBasedSelectionFilters,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            ImmutableAppComplexityWidgetParameters.builder().build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(complexityWidgetDao)
        .findWidgetData(eq(1L), eq(EntityKind.APPLICATION), isA(Set.class), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(complexityKindDao).findAll();
    assertTrue(actualAppComplexityWidgetData instanceof ImmutableComplexityWidgetData);
    Set<Application> applicationsResult = actualAppComplexityWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualAppComplexityWidgetData.cellData());
    assertSame(applicationsResult, actualAppComplexityWidgetData.complexityKinds());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getAppComplexityWidgetData(long, Set,
   * IdSelectionOptions, AppComplexityWidgetParameters)}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getAppComplexityWidgetData(long,
   * Set, IdSelectionOptions, AppComplexityWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getAppComplexityWidgetData(long, Set, IdSelectionOptions, AppComplexityWidgetParameters); given 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ComplexityWidgetData AggregateOverlayDiagramService.getAppComplexityWidgetData(long, Set, IdSelectionOptions, AppComplexityWidgetParameters)"
  })
  void testGetAppComplexityWidgetData_givenPending() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ComplexityKindDao complexityKindDao = mock(ComplexityKindDao.class);
    when(complexityKindDao.findAll()).thenReturn(new HashSet<>());

    ComplexityWidgetDao complexityWidgetDao = mock(ComplexityWidgetDao.class);
    when(complexityWidgetDao.findWidgetData(
            anyLong(),
            Mockito.<EntityKind>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            applicationDao,
            mock(CostKindDao.class),
            complexityKindDao,
            complexityWidgetDao,
            mock(AttestationWidgetDao.class));
    HashSet<AssessmentBasedSelectionFilter> assessmentBasedSelectionFilters = new HashSet<>();

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
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    ComplexityWidgetData actualAppComplexityWidgetData =
        aggregateOverlayDiagramService.getAppComplexityWidgetData(
            1L,
            assessmentBasedSelectionFilters,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            ImmutableAppComplexityWidgetParameters.builder().build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(complexityWidgetDao)
        .findWidgetData(eq(1L), eq(EntityKind.APPLICATION), isA(Set.class), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(complexityKindDao).findAll();
    assertTrue(actualAppComplexityWidgetData instanceof ImmutableComplexityWidgetData);
    Set<Application> applicationsResult = actualAppComplexityWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualAppComplexityWidgetData.cellData());
    assertSame(applicationsResult, actualAppComplexityWidgetData.complexityKinds());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getAppComplexityWidgetData(long, Set,
   * IdSelectionOptions, AppComplexityWidgetParameters)}.
   *
   * <ul>
   *   <li>Then return applications size is one.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getAppComplexityWidgetData(long,
   * Set, IdSelectionOptions, AppComplexityWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getAppComplexityWidgetData(long, Set, IdSelectionOptions, AppComplexityWidgetParameters); then return applications size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ComplexityWidgetData AggregateOverlayDiagramService.getAppComplexityWidgetData(long, Set, IdSelectionOptions, AppComplexityWidgetParameters)"
  })
  void testGetAppComplexityWidgetData_thenReturnApplicationsSizeIsOne() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

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

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(applicationList);

    ComplexityKindDao complexityKindDao = mock(ComplexityKindDao.class);
    when(complexityKindDao.findAll()).thenReturn(new HashSet<>());

    ComplexityWidgetDao complexityWidgetDao = mock(ComplexityWidgetDao.class);
    when(complexityWidgetDao.findWidgetData(
            anyLong(),
            Mockito.<EntityKind>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            applicationDao,
            mock(CostKindDao.class),
            complexityKindDao,
            complexityWidgetDao,
            mock(AttestationWidgetDao.class));
    HashSet<AssessmentBasedSelectionFilter> assessmentBasedSelectionFilters = new HashSet<>();

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
    ComplexityWidgetData actualAppComplexityWidgetData =
        aggregateOverlayDiagramService.getAppComplexityWidgetData(
            1L,
            assessmentBasedSelectionFilters,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            ImmutableAppComplexityWidgetParameters.builder().build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(complexityWidgetDao)
        .findWidgetData(eq(1L), eq(EntityKind.APPLICATION), isA(Set.class), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(complexityKindDao).findAll();
    assertTrue(actualAppComplexityWidgetData instanceof ImmutableComplexityWidgetData);
    assertEquals(1, actualAppComplexityWidgetData.applications().size());
    Set<ComplexityWidgetDatum> cellDataResult = actualAppComplexityWidgetData.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualAppComplexityWidgetData.complexityKinds());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getAppComplexityWidgetData(long, Set,
   * IdSelectionOptions, AppComplexityWidgetParameters)}.
   *
   * <ul>
   *   <li>Then return applications size is one.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getAppComplexityWidgetData(long,
   * Set, IdSelectionOptions, AppComplexityWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getAppComplexityWidgetData(long, Set, IdSelectionOptions, AppComplexityWidgetParameters); then return applications size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ComplexityWidgetData AggregateOverlayDiagramService.getAppComplexityWidgetData(long, Set, IdSelectionOptions, AppComplexityWidgetParameters)"
  })
  void testGetAppComplexityWidgetData_thenReturnApplicationsSizeIsOne2() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

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

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(applicationList);

    ComplexityKindDao complexityKindDao = mock(ComplexityKindDao.class);
    when(complexityKindDao.findAll()).thenReturn(new HashSet<>());

    ComplexityWidgetDao complexityWidgetDao = mock(ComplexityWidgetDao.class);
    when(complexityWidgetDao.findWidgetData(
            anyLong(),
            Mockito.<EntityKind>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            applicationDao,
            mock(CostKindDao.class),
            complexityKindDao,
            complexityWidgetDao,
            mock(AttestationWidgetDao.class));
    HashSet<AssessmentBasedSelectionFilter> assessmentBasedSelectionFilters = new HashSet<>();

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
    ComplexityWidgetData actualAppComplexityWidgetData =
        aggregateOverlayDiagramService.getAppComplexityWidgetData(
            1L,
            assessmentBasedSelectionFilters,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            ImmutableAppComplexityWidgetParameters.builder().build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(complexityWidgetDao)
        .findWidgetData(eq(1L), eq(EntityKind.APPLICATION), isA(Set.class), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(complexityKindDao).findAll();
    assertTrue(actualAppComplexityWidgetData instanceof ImmutableComplexityWidgetData);
    assertEquals(1, actualAppComplexityWidgetData.applications().size());
    Set<ComplexityWidgetDatum> cellDataResult = actualAppComplexityWidgetData.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualAppComplexityWidgetData.complexityKinds());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getAppComplexityWidgetData(long, Set,
   * IdSelectionOptions, AppComplexityWidgetParameters)}.
   *
   * <ul>
   *   <li>Then return cellData is applications.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getAppComplexityWidgetData(long,
   * Set, IdSelectionOptions, AppComplexityWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getAppComplexityWidgetData(long, Set, IdSelectionOptions, AppComplexityWidgetParameters); then return cellData is applications")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ComplexityWidgetData AggregateOverlayDiagramService.getAppComplexityWidgetData(long, Set, IdSelectionOptions, AppComplexityWidgetParameters)"
  })
  void testGetAppComplexityWidgetData_thenReturnCellDataIsApplications() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ComplexityKindDao complexityKindDao = mock(ComplexityKindDao.class);
    when(complexityKindDao.findAll()).thenReturn(new HashSet<>());

    ComplexityWidgetDao complexityWidgetDao = mock(ComplexityWidgetDao.class);
    when(complexityWidgetDao.findWidgetData(
            anyLong(),
            Mockito.<EntityKind>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            applicationDao,
            mock(CostKindDao.class),
            complexityKindDao,
            complexityWidgetDao,
            mock(AttestationWidgetDao.class));
    HashSet<AssessmentBasedSelectionFilter> assessmentBasedSelectionFilters = new HashSet<>();

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
    ComplexityWidgetData actualAppComplexityWidgetData =
        aggregateOverlayDiagramService.getAppComplexityWidgetData(
            1L,
            assessmentBasedSelectionFilters,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            ImmutableAppComplexityWidgetParameters.builder().build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(complexityWidgetDao)
        .findWidgetData(eq(1L), eq(EntityKind.APPLICATION), isA(Set.class), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(complexityKindDao).findAll();
    assertTrue(actualAppComplexityWidgetData instanceof ImmutableComplexityWidgetData);
    Set<Application> applicationsResult = actualAppComplexityWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualAppComplexityWidgetData.cellData());
    assertSame(applicationsResult, actualAppComplexityWidgetData.complexityKinds());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getAppComplexityWidgetData(long, Set,
   * IdSelectionOptions, AppComplexityWidgetParameters)}.
   *
   * <ul>
   *   <li>Then return cellData size is one.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getAppComplexityWidgetData(long,
   * Set, IdSelectionOptions, AppComplexityWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getAppComplexityWidgetData(long, Set, IdSelectionOptions, AppComplexityWidgetParameters); then return cellData size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ComplexityWidgetData AggregateOverlayDiagramService.getAppComplexityWidgetData(long, Set, IdSelectionOptions, AppComplexityWidgetParameters)"
  })
  void testGetAppComplexityWidgetData_thenReturnCellDataSizeIsOne() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ComplexityKindDao complexityKindDao = mock(ComplexityKindDao.class);
    when(complexityKindDao.findAll()).thenReturn(new HashSet<>());

    HashSet<ComplexityWidgetDatum> complexityWidgetDatumSet = new HashSet<>();
    complexityWidgetDatumSet.add(
        ImmutableComplexityWidgetDatum.builder().cellExternalId("42").build());

    ComplexityWidgetDao complexityWidgetDao = mock(ComplexityWidgetDao.class);
    when(complexityWidgetDao.findWidgetData(
            anyLong(),
            Mockito.<EntityKind>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(complexityWidgetDatumSet);

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            applicationDao,
            mock(CostKindDao.class),
            complexityKindDao,
            complexityWidgetDao,
            mock(AttestationWidgetDao.class));
    HashSet<AssessmentBasedSelectionFilter> assessmentBasedSelectionFilters = new HashSet<>();

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
    ComplexityWidgetData actualAppComplexityWidgetData =
        aggregateOverlayDiagramService.getAppComplexityWidgetData(
            1L,
            assessmentBasedSelectionFilters,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            ImmutableAppComplexityWidgetParameters.builder().build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(complexityWidgetDao)
        .findWidgetData(eq(1L), eq(EntityKind.APPLICATION), isA(Set.class), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(complexityKindDao).findAll();
    assertTrue(actualAppComplexityWidgetData instanceof ImmutableComplexityWidgetData);
    assertEquals(1, actualAppComplexityWidgetData.cellData().size());
    Set<Application> applicationsResult = actualAppComplexityWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualAppComplexityWidgetData.complexityKinds());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getAppComplexityWidgetData(long, Set,
   * IdSelectionOptions, AppComplexityWidgetParameters)}.
   *
   * <ul>
   *   <li>Then return complexityKinds size is one.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#getAppComplexityWidgetData(long,
   * Set, IdSelectionOptions, AppComplexityWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getAppComplexityWidgetData(long, Set, IdSelectionOptions, AppComplexityWidgetParameters); then return complexityKinds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ComplexityWidgetData AggregateOverlayDiagramService.getAppComplexityWidgetData(long, Set, IdSelectionOptions, AppComplexityWidgetParameters)"
  })
  void testGetAppComplexityWidgetData_thenReturnComplexityKindsSizeIsOne() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    HashSet<ComplexityKind> complexityKindSet = new HashSet<>();
    complexityKindSet.add(
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    ComplexityKindDao complexityKindDao = mock(ComplexityKindDao.class);
    when(complexityKindDao.findAll()).thenReturn(complexityKindSet);

    ComplexityWidgetDao complexityWidgetDao = mock(ComplexityWidgetDao.class);
    when(complexityWidgetDao.findWidgetData(
            anyLong(),
            Mockito.<EntityKind>any(),
            Mockito.<Set<Long>>any(),
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            applicationDao,
            mock(CostKindDao.class),
            complexityKindDao,
            complexityWidgetDao,
            mock(AttestationWidgetDao.class));
    HashSet<AssessmentBasedSelectionFilter> assessmentBasedSelectionFilters = new HashSet<>();

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
    ComplexityWidgetData actualAppComplexityWidgetData =
        aggregateOverlayDiagramService.getAppComplexityWidgetData(
            1L,
            assessmentBasedSelectionFilters,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build(),
            ImmutableAppComplexityWidgetParameters.builder().build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(complexityWidgetDao)
        .findWidgetData(eq(1L), eq(EntityKind.APPLICATION), isA(Set.class), isA(Select.class));
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(complexityKindDao).findAll();
    assertTrue(actualAppComplexityWidgetData instanceof ImmutableComplexityWidgetData);
    assertEquals(1, actualAppComplexityWidgetData.complexityKinds().size());
    Set<Application> applicationsResult = actualAppComplexityWidgetData.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualAppComplexityWidgetData.cellData());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#save(OverlayDiagramSaveCommand, String)}.
   *
   * <ul>
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#save(OverlayDiagramSaveCommand,
   * String)}
   */
  @Test
  @DisplayName("Test save(OverlayDiagramSaveCommand, String); then return longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AggregateOverlayDiagramService.save(OverlayDiagramSaveCommand, String)"})
  void testSave_thenReturnLongValueIsOne() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.save(
            Mockito.<OverlayDiagramSaveCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
    doNothing()
        .when(aggregateOverlayDiagramDao)
        .updateBackingEntities(Mockito.<Long>any(), Mockito.<Set<BackingEntity>>any());
    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            mock(ApplicationDao.class),
            mock(CostKindDao.class),
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));

    // Act
    Long actualSaveResult =
        aggregateOverlayDiagramService.save(
            ImmutableOverlayDiagramSaveCommand.builder()
                .aggregatedEntityKind(EntityKind.ALL)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .layoutData("Layout Data")
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(aggregateOverlayDiagramDao).save(isA(OverlayDiagramSaveCommand.class), eq("janedoe"));
    verify(aggregateOverlayDiagramDao).updateBackingEntities(eq(1L), isA(Set.class));
    assertEquals(1L, actualSaveResult.longValue());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#updateStatus(long,
   * ReleaseLifecycleStatusChangeCommand, String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#updateStatus(long,
   * ReleaseLifecycleStatusChangeCommand, String)}
   */
  @Test
  @DisplayName(
      "Test updateStatus(long, ReleaseLifecycleStatusChangeCommand, String); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean AggregateOverlayDiagramService.updateStatus(long, ReleaseLifecycleStatusChangeCommand, String)"
  })
  void testUpdateStatus_thenReturnFalse() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.updateStatus(
            anyLong(), Mockito.<ReleaseLifecycleStatusChangeCommand>any()))
        .thenReturn(false);
    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            mock(ApplicationDao.class),
            mock(CostKindDao.class),
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));

    // Act
    Boolean actualUpdateStatusResult =
        aggregateOverlayDiagramService.updateStatus(1L, null, "janedoe");

    // Assert
    verify(aggregateOverlayDiagramDao).updateStatus(eq(1L), isNull());
    assertFalse(actualUpdateStatusResult);
  }

  /**
   * Test {@link AggregateOverlayDiagramService#updateStatus(long,
   * ReleaseLifecycleStatusChangeCommand, String)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagramService#updateStatus(long,
   * ReleaseLifecycleStatusChangeCommand, String)}
   */
  @Test
  @DisplayName(
      "Test updateStatus(long, ReleaseLifecycleStatusChangeCommand, String); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean AggregateOverlayDiagramService.updateStatus(long, ReleaseLifecycleStatusChangeCommand, String)"
  })
  void testUpdateStatus_thenReturnTrue() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.updateStatus(
            anyLong(), Mockito.<ReleaseLifecycleStatusChangeCommand>any()))
        .thenReturn(true);
    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            mock(AppChangesWidgetDao.class),
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            mock(ApplicationDao.class),
            mock(CostKindDao.class),
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));

    // Act
    Boolean actualUpdateStatusResult =
        aggregateOverlayDiagramService.updateStatus(1L, null, "janedoe");

    // Assert
    verify(aggregateOverlayDiagramDao).updateStatus(eq(1L), isNull());
    assertTrue(actualUpdateStatusResult);
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getApplicationChangeWidgetData(long,
   * IdSelectionOptions, AppChangeWidgetParameters)}.
   *
   * <p>Method under test: {@link
   * AggregateOverlayDiagramService#getApplicationChangeWidgetData(long, IdSelectionOptions,
   * AppChangeWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getApplicationChangeWidgetData(long, IdSelectionOptions, AppChangeWidgetParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationChangeWidgetData AggregateOverlayDiagramService.getApplicationChangeWidgetData(long, IdSelectionOptions, AppChangeWidgetParameters)"
  })
  void testGetApplicationChangeWidgetData() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    AppChangesWidgetDao appChangesWidgetDao = mock(AppChangesWidgetDao.class);
    when(appChangesWidgetDao.findWidgetData(
            anyLong(), Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<LocalDate>>any()))
        .thenReturn(new HashSet<>());

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            appChangesWidgetDao,
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            mock(ApplicationDao.class),
            mock(CostKindDao.class),
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));

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
    ImmutableIdSelectionOptions idSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    ApplicationChangeWidgetData actualApplicationChangeWidgetData =
        aggregateOverlayDiagramService.getApplicationChangeWidgetData(
            1L,
            idSelectionOptions,
            ImmutableAppChangeWidgetParameters.builder()
                .targetDate(LocalDate.of(1970, 1, 1))
                .build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(appChangesWidgetDao).findWidgetData(eq(1L), isA(Select.class), isA(Optional.class));
    assertTrue(actualApplicationChangeWidgetData instanceof ImmutableApplicationChangeWidgetData);
    assertTrue(actualApplicationChangeWidgetData.cellData().isEmpty());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getApplicationChangeWidgetData(long,
   * IdSelectionOptions, AppChangeWidgetParameters)}.
   *
   * <p>Method under test: {@link
   * AggregateOverlayDiagramService#getApplicationChangeWidgetData(long, IdSelectionOptions,
   * AppChangeWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getApplicationChangeWidgetData(long, IdSelectionOptions, AppChangeWidgetParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationChangeWidgetData AggregateOverlayDiagramService.getApplicationChangeWidgetData(long, IdSelectionOptions, AppChangeWidgetParameters)"
  })
  void testGetApplicationChangeWidgetData2() {
    // Arrange
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());
    when(appChangesWidgetDao.findWidgetData(
            anyLong(), Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<LocalDate>>any()))
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
    ImmutableIdSelectionOptions idSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    ApplicationChangeWidgetData actualApplicationChangeWidgetData =
        aggregateOverlayDiagramService.getApplicationChangeWidgetData(
            1L,
            idSelectionOptions,
            ImmutableAppChangeWidgetParameters.builder()
                .targetDate(LocalDate.of(1970, 1, 1))
                .build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(appChangesWidgetDao).findWidgetData(eq(1L), isA(Select.class), isA(Optional.class));
    assertTrue(actualApplicationChangeWidgetData instanceof ImmutableApplicationChangeWidgetData);
    assertTrue(actualApplicationChangeWidgetData.cellData().isEmpty());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getApplicationChangeWidgetData(long,
   * IdSelectionOptions, AppChangeWidgetParameters)}.
   *
   * <p>Method under test: {@link
   * AggregateOverlayDiagramService#getApplicationChangeWidgetData(long, IdSelectionOptions,
   * AppChangeWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getApplicationChangeWidgetData(long, IdSelectionOptions, AppChangeWidgetParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationChangeWidgetData AggregateOverlayDiagramService.getApplicationChangeWidgetData(long, IdSelectionOptions, AppChangeWidgetParameters)"
  })
  void testGetApplicationChangeWidgetData3() {
    // Arrange
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());
    when(appChangesWidgetDao.findWidgetData(
            anyLong(), Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<LocalDate>>any()))
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
    ImmutableIdSelectionOptions idSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    ApplicationChangeWidgetData actualApplicationChangeWidgetData =
        aggregateOverlayDiagramService.getApplicationChangeWidgetData(
            1L,
            idSelectionOptions,
            ImmutableAppChangeWidgetParameters.builder()
                .targetDate(LocalDate.of(1970, 1, 1))
                .build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(appChangesWidgetDao).findWidgetData(eq(1L), isA(Select.class), isA(Optional.class));
    assertTrue(actualApplicationChangeWidgetData instanceof ImmutableApplicationChangeWidgetData);
    assertTrue(actualApplicationChangeWidgetData.cellData().isEmpty());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getApplicationChangeWidgetData(long,
   * IdSelectionOptions, AppChangeWidgetParameters)}.
   *
   * <p>Method under test: {@link
   * AggregateOverlayDiagramService#getApplicationChangeWidgetData(long, IdSelectionOptions,
   * AppChangeWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getApplicationChangeWidgetData(long, IdSelectionOptions, AppChangeWidgetParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationChangeWidgetData AggregateOverlayDiagramService.getApplicationChangeWidgetData(long, IdSelectionOptions, AppChangeWidgetParameters)"
  })
  void testGetApplicationChangeWidgetData4() {
    // Arrange
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());
    when(appChangesWidgetDao.findWidgetData(
            anyLong(), Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<LocalDate>>any()))
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
    ImmutableIdSelectionOptions idSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    ApplicationChangeWidgetData actualApplicationChangeWidgetData =
        aggregateOverlayDiagramService.getApplicationChangeWidgetData(
            1L,
            idSelectionOptions,
            ImmutableAppChangeWidgetParameters.builder()
                .targetDate(LocalDate.of(1970, 1, 1))
                .build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(appChangesWidgetDao).findWidgetData(eq(1L), isA(Select.class), isA(Optional.class));
    assertTrue(actualApplicationChangeWidgetData instanceof ImmutableApplicationChangeWidgetData);
    assertTrue(actualApplicationChangeWidgetData.cellData().isEmpty());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getApplicationChangeWidgetData(long,
   * IdSelectionOptions, AppChangeWidgetParameters)}.
   *
   * <ul>
   *   <li>Given {@code EXTERNALLY_HOSTED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AggregateOverlayDiagramService#getApplicationChangeWidgetData(long, IdSelectionOptions,
   * AppChangeWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getApplicationChangeWidgetData(long, IdSelectionOptions, AppChangeWidgetParameters); given 'EXTERNALLY_HOSTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationChangeWidgetData AggregateOverlayDiagramService.getApplicationChangeWidgetData(long, IdSelectionOptions, AppChangeWidgetParameters)"
  })
  void testGetApplicationChangeWidgetData_givenExternallyHosted() {
    // Arrange
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());
    when(appChangesWidgetDao.findWidgetData(
            anyLong(), Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<LocalDate>>any()))
        .thenReturn(new HashSet<>());

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.EXTERNALLY_HOSTED);
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
    ImmutableIdSelectionOptions idSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    ApplicationChangeWidgetData actualApplicationChangeWidgetData =
        aggregateOverlayDiagramService.getApplicationChangeWidgetData(
            1L,
            idSelectionOptions,
            ImmutableAppChangeWidgetParameters.builder()
                .targetDate(LocalDate.of(1970, 1, 1))
                .build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(appChangesWidgetDao).findWidgetData(eq(1L), isA(Select.class), isA(Optional.class));
    assertTrue(actualApplicationChangeWidgetData instanceof ImmutableApplicationChangeWidgetData);
    assertTrue(actualApplicationChangeWidgetData.cellData().isEmpty());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getApplicationChangeWidgetData(long,
   * IdSelectionOptions, AppChangeWidgetParameters)}.
   *
   * <ul>
   *   <li>Given {@code REMOVED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AggregateOverlayDiagramService#getApplicationChangeWidgetData(long, IdSelectionOptions,
   * AppChangeWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getApplicationChangeWidgetData(long, IdSelectionOptions, AppChangeWidgetParameters); given 'REMOVED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationChangeWidgetData AggregateOverlayDiagramService.getApplicationChangeWidgetData(long, IdSelectionOptions, AppChangeWidgetParameters)"
  })
  void testGetApplicationChangeWidgetData_givenRemoved() {
    // Arrange
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());
    when(appChangesWidgetDao.findWidgetData(
            anyLong(), Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<LocalDate>>any()))
        .thenReturn(new HashSet<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.REMOVED);

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
    ImmutableIdSelectionOptions idSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    ApplicationChangeWidgetData actualApplicationChangeWidgetData =
        aggregateOverlayDiagramService.getApplicationChangeWidgetData(
            1L,
            idSelectionOptions,
            ImmutableAppChangeWidgetParameters.builder()
                .targetDate(LocalDate.of(1970, 1, 1))
                .build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(appChangesWidgetDao).findWidgetData(eq(1L), isA(Select.class), isA(Optional.class));
    assertTrue(actualApplicationChangeWidgetData instanceof ImmutableApplicationChangeWidgetData);
    assertTrue(actualApplicationChangeWidgetData.cellData().isEmpty());
  }

  /**
   * Test {@link AggregateOverlayDiagramService#getApplicationChangeWidgetData(long,
   * IdSelectionOptions, AppChangeWidgetParameters)}.
   *
   * <ul>
   *   <li>Then return cellData size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * AggregateOverlayDiagramService#getApplicationChangeWidgetData(long, IdSelectionOptions,
   * AppChangeWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test getApplicationChangeWidgetData(long, IdSelectionOptions, AppChangeWidgetParameters); then return cellData size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplicationChangeWidgetData AggregateOverlayDiagramService.getApplicationChangeWidgetData(long, IdSelectionOptions, AppChangeWidgetParameters)"
  })
  void testGetApplicationChangeWidgetData_thenReturnCellDataSizeIsOne() {
    // Arrange
    AggregateOverlayDiagramDao aggregateOverlayDiagramDao = mock(AggregateOverlayDiagramDao.class);
    when(aggregateOverlayDiagramDao.getById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableAggregateOverlayDiagram.builder()
                .aggregatedEntityKind(EntityKind.APPLICATION)
                .description("The characteristics of someone or something")
                .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .provenance("Provenance")
                .status(ReleaseLifecycleStatus.DRAFT)
                .build());

    HashSet<ApplicationChangeWidgetDatum> applicationChangeWidgetDatumSet = new HashSet<>();
    applicationChangeWidgetDatumSet.add(
        ImmutableApplicationChangeWidgetDatum.builder().cellExternalId("42").build());

    AppChangesWidgetDao appChangesWidgetDao = mock(AppChangesWidgetDao.class);
    when(appChangesWidgetDao.findWidgetData(
            anyLong(), Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<LocalDate>>any()))
        .thenReturn(applicationChangeWidgetDatumSet);

    AggregateOverlayDiagramService aggregateOverlayDiagramService =
        new AggregateOverlayDiagramService(
            aggregateOverlayDiagramDao,
            mock(AppCountWidgetDao.class),
            mock(TargetAppCostWidgetDao.class),
            mock(RatingCostWidgetDao.class),
            mock(AssessmentRatingWidgetDao.class),
            mock(BackingEntityWidgetDao.class),
            mock(AppCostWidgetDao.class),
            mock(AggregatedEntitiesWidgetDao.class),
            appChangesWidgetDao,
            mock(AggregateOverlayDiagramPresetDao.class),
            mock(MeasurableDao.class),
            mock(ApplicationDao.class),
            mock(CostKindDao.class),
            mock(ComplexityKindDao.class),
            mock(ComplexityWidgetDao.class),
            mock(AttestationWidgetDao.class));

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
    ImmutableIdSelectionOptions idSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    ApplicationChangeWidgetData actualApplicationChangeWidgetData =
        aggregateOverlayDiagramService.getApplicationChangeWidgetData(
            1L,
            idSelectionOptions,
            ImmutableAppChangeWidgetParameters.builder()
                .targetDate(LocalDate.of(1970, 1, 1))
                .build());

    // Assert
    verify(aggregateOverlayDiagramDao).getById(1L);
    verify(appChangesWidgetDao).findWidgetData(eq(1L), isA(Select.class), isA(Optional.class));
    assertTrue(actualApplicationChangeWidgetData instanceof ImmutableApplicationChangeWidgetData);
    assertEquals(1, actualApplicationChangeWidgetData.cellData().size());
  }
}
