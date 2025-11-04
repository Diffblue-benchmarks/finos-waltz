package org.finos.waltz.service.data_flow_decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.application.search.ApplicationSearchDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.data_flow_decorator.LogicalFlowDecoratorSummaryDao;
import org.finos.waltz.data.data_type.DataTypeDao;
import org.finos.waltz.data.data_type.search.DataTypeSearchDao;
import org.finos.waltz.data.data_type_usage.DataTypeUsageDao;
import org.finos.waltz.data.datatype_decorator.LogicalFlowDecoratorDao;
import org.finos.waltz.data.entity_alias.EntityAliasDao;
import org.finos.waltz.data.flow_classification_rule.FlowClassificationRuleDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.logical_flow.LogicalFlowStatsDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.tag.TagDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.data_flow_decorator.DecoratorRatingSummary;
import org.finos.waltz.model.data_flow_decorator.LogicalFlowDecoratorStat;
import org.finos.waltz.service.application.ApplicationService;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.data_type.DataTypeService;
import org.finos.waltz.service.logical_flow.LogicalFlowService;
import org.finos.waltz.service.tag.TagService;
import org.finos.waltz.service.usage_info.DataTypeUsageService;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LogicalFlowDecoratorServiceDiffblueTest {
  /**
   * Method under test:
   * {@link LogicalFlowDecoratorService#addDecoratorsBatch(List, String)}
   */
  @Test
  void testAddDecoratorsBatch() {
    // Arrange
    LogicalFlowDecoratorSummaryDao logicalFlowDecoratorSummaryDao = mock(LogicalFlowDecoratorSummaryDao.class);
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    ApplicationService applicationService = new ApplicationService(appDao, new TagService(mock(TagDao.class), null),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    LogicalFlowDecoratorRatingsCalculator ratingsCalculator = new LogicalFlowDecoratorRatingsCalculator(
        applicationService, flowClassificationRuleDao, logicalFlowDao,
        new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class)));

    DataTypeUsageDao dataTypeUsageDao = mock(DataTypeUsageDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    DataTypeUsageService dataTypeUsageService = new DataTypeUsageService(dataTypeUsageDao, dataTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
    LogicalFlowService logicalFlowService = mock(LogicalFlowService.class);
    LogicalFlowStatsDao logicalFlowStatsDao = mock(LogicalFlowStatsDao.class);
    LogicalFlowDecoratorService logicalFlowDecoratorService = new LogicalFlowDecoratorService(
        logicalFlowDecoratorSummaryDao, logicalFlowDecoratorDao, ratingsCalculator, dataTypeUsageService, dataTypeDao2,
        logicalFlowDao2, logicalFlowService, logicalFlowStatsDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    // Act and Assert
    assertEquals(0, logicalFlowDecoratorService.addDecoratorsBatch(new ArrayList<>(), "janedoe").length);
  }

  /**
   * Method under test:
   * {@link LogicalFlowDecoratorService#summarizeInboundForSelector(IdSelectionOptions)}
   */
  @Test
  void testSummarizeInboundForSelector() {
    // Arrange
    LogicalFlowDecoratorSummaryDao logicalFlowDecoratorSummaryDao = mock(LogicalFlowDecoratorSummaryDao.class);
    ArrayList<DecoratorRatingSummary> decoratorRatingSummaryList = new ArrayList<>();
    when(logicalFlowDecoratorSummaryDao.summarizeInboundForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(decoratorRatingSummaryList);
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    ApplicationService applicationService = new ApplicationService(appDao, new TagService(mock(TagDao.class), null),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    LogicalFlowDecoratorRatingsCalculator ratingsCalculator = new LogicalFlowDecoratorRatingsCalculator(
        applicationService, flowClassificationRuleDao, logicalFlowDao,
        new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class)));

    DataTypeUsageDao dataTypeUsageDao = mock(DataTypeUsageDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    DataTypeUsageService dataTypeUsageService = new DataTypeUsageService(dataTypeUsageDao, dataTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
    LogicalFlowService logicalFlowService = mock(LogicalFlowService.class);
    LogicalFlowStatsDao logicalFlowStatsDao = mock(LogicalFlowStatsDao.class);
    LogicalFlowDecoratorService logicalFlowDecoratorService = new LogicalFlowDecoratorService(
        logicalFlowDecoratorSummaryDao, logicalFlowDecoratorDao, ratingsCalculator, dataTypeUsageService, dataTypeDao2,
        logicalFlowDao2, logicalFlowService, logicalFlowStatsDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<DecoratorRatingSummary> actualSummarizeInboundForSelectorResult = logicalFlowDecoratorService
        .summarizeInboundForSelector(options);

    // Assert
    verify(logicalFlowDecoratorSummaryDao).summarizeInboundForSelector(isA(Select.class));
    verify(entityReference).kind();
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualSummarizeInboundForSelectorResult.isEmpty());
    assertSame(decoratorRatingSummaryList, actualSummarizeInboundForSelectorResult);
  }

  /**
   * Method under test:
   * {@link LogicalFlowDecoratorService#summarizeInboundForSelector(IdSelectionOptions)}
   */
  @Test
  void testSummarizeInboundForSelector2() {
    // Arrange
    LogicalFlowDecoratorSummaryDao logicalFlowDecoratorSummaryDao = mock(LogicalFlowDecoratorSummaryDao.class);
    ArrayList<DecoratorRatingSummary> decoratorRatingSummaryList = new ArrayList<>();
    when(logicalFlowDecoratorSummaryDao.summarizeInboundForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(decoratorRatingSummaryList);
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    ApplicationService applicationService = new ApplicationService(appDao, new TagService(mock(TagDao.class), null),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    LogicalFlowDecoratorRatingsCalculator ratingsCalculator = new LogicalFlowDecoratorRatingsCalculator(
        applicationService, flowClassificationRuleDao, logicalFlowDao,
        new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class)));

    DataTypeUsageDao dataTypeUsageDao = mock(DataTypeUsageDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    DataTypeUsageService dataTypeUsageService = new DataTypeUsageService(dataTypeUsageDao, dataTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
    LogicalFlowService logicalFlowService = mock(LogicalFlowService.class);
    LogicalFlowStatsDao logicalFlowStatsDao = mock(LogicalFlowStatsDao.class);
    LogicalFlowDecoratorService logicalFlowDecoratorService = new LogicalFlowDecoratorService(
        logicalFlowDecoratorSummaryDao, logicalFlowDecoratorDao, ratingsCalculator, dataTypeUsageService, dataTypeDao2,
        logicalFlowDao2, logicalFlowService, logicalFlowStatsDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    HashSet<ApplicationKind> applicationKindSet = new HashSet<>();
    applicationKindSet.add(ApplicationKind.IN_HOUSE);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(applicationKindSet);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<DecoratorRatingSummary> actualSummarizeInboundForSelectorResult = logicalFlowDecoratorService
        .summarizeInboundForSelector(options);

    // Assert
    verify(logicalFlowDecoratorSummaryDao).summarizeInboundForSelector(isA(Select.class));
    verify(entityReference).kind();
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options, atLeast(1)).filters();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    assertTrue(actualSummarizeInboundForSelectorResult.isEmpty());
    assertSame(decoratorRatingSummaryList, actualSummarizeInboundForSelectorResult);
  }

  /**
   * Method under test:
   * {@link LogicalFlowDecoratorService#summarizeInboundForSelector(IdSelectionOptions)}
   */
  @Test
  void testSummarizeInboundForSelector3() {
    // Arrange
    LogicalFlowDecoratorSummaryDao logicalFlowDecoratorSummaryDao = mock(LogicalFlowDecoratorSummaryDao.class);
    ArrayList<DecoratorRatingSummary> decoratorRatingSummaryList = new ArrayList<>();
    when(logicalFlowDecoratorSummaryDao.summarizeInboundForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(decoratorRatingSummaryList);
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    ApplicationService applicationService = new ApplicationService(appDao, new TagService(mock(TagDao.class), null),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    LogicalFlowDecoratorRatingsCalculator ratingsCalculator = new LogicalFlowDecoratorRatingsCalculator(
        applicationService, flowClassificationRuleDao, logicalFlowDao,
        new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class)));

    DataTypeUsageDao dataTypeUsageDao = mock(DataTypeUsageDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    DataTypeUsageService dataTypeUsageService = new DataTypeUsageService(dataTypeUsageDao, dataTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
    LogicalFlowService logicalFlowService = mock(LogicalFlowService.class);
    LogicalFlowStatsDao logicalFlowStatsDao = mock(LogicalFlowStatsDao.class);
    LogicalFlowDecoratorService logicalFlowDecoratorService = new LogicalFlowDecoratorService(
        logicalFlowDecoratorSummaryDao, logicalFlowDecoratorDao, ratingsCalculator, dataTypeUsageService, dataTypeDao2,
        logicalFlowDao2, logicalFlowService, logicalFlowStatsDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<DecoratorRatingSummary> actualSummarizeInboundForSelectorResult = logicalFlowDecoratorService
        .summarizeInboundForSelector(options);

    // Assert
    verify(logicalFlowDecoratorSummaryDao).summarizeInboundForSelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualSummarizeInboundForSelectorResult.isEmpty());
    assertSame(decoratorRatingSummaryList, actualSummarizeInboundForSelectorResult);
  }

  /**
   * Method under test:
   * {@link LogicalFlowDecoratorService#summarizeOutboundForSelector(IdSelectionOptions)}
   */
  @Test
  void testSummarizeOutboundForSelector() {
    // Arrange
    LogicalFlowDecoratorSummaryDao logicalFlowDecoratorSummaryDao = mock(LogicalFlowDecoratorSummaryDao.class);
    ArrayList<DecoratorRatingSummary> decoratorRatingSummaryList = new ArrayList<>();
    when(logicalFlowDecoratorSummaryDao.summarizeOutboundForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(decoratorRatingSummaryList);
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    ApplicationService applicationService = new ApplicationService(appDao, new TagService(mock(TagDao.class), null),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    LogicalFlowDecoratorRatingsCalculator ratingsCalculator = new LogicalFlowDecoratorRatingsCalculator(
        applicationService, flowClassificationRuleDao, logicalFlowDao,
        new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class)));

    DataTypeUsageDao dataTypeUsageDao = mock(DataTypeUsageDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    DataTypeUsageService dataTypeUsageService = new DataTypeUsageService(dataTypeUsageDao, dataTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
    LogicalFlowService logicalFlowService = mock(LogicalFlowService.class);
    LogicalFlowStatsDao logicalFlowStatsDao = mock(LogicalFlowStatsDao.class);
    LogicalFlowDecoratorService logicalFlowDecoratorService = new LogicalFlowDecoratorService(
        logicalFlowDecoratorSummaryDao, logicalFlowDecoratorDao, ratingsCalculator, dataTypeUsageService, dataTypeDao2,
        logicalFlowDao2, logicalFlowService, logicalFlowStatsDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<DecoratorRatingSummary> actualSummarizeOutboundForSelectorResult = logicalFlowDecoratorService
        .summarizeOutboundForSelector(options);

    // Assert
    verify(logicalFlowDecoratorSummaryDao).summarizeOutboundForSelector(isA(Select.class));
    verify(entityReference).kind();
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualSummarizeOutboundForSelectorResult.isEmpty());
    assertSame(decoratorRatingSummaryList, actualSummarizeOutboundForSelectorResult);
  }

  /**
   * Method under test:
   * {@link LogicalFlowDecoratorService#summarizeOutboundForSelector(IdSelectionOptions)}
   */
  @Test
  void testSummarizeOutboundForSelector2() {
    // Arrange
    LogicalFlowDecoratorSummaryDao logicalFlowDecoratorSummaryDao = mock(LogicalFlowDecoratorSummaryDao.class);
    ArrayList<DecoratorRatingSummary> decoratorRatingSummaryList = new ArrayList<>();
    when(logicalFlowDecoratorSummaryDao.summarizeOutboundForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(decoratorRatingSummaryList);
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    ApplicationService applicationService = new ApplicationService(appDao, new TagService(mock(TagDao.class), null),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    LogicalFlowDecoratorRatingsCalculator ratingsCalculator = new LogicalFlowDecoratorRatingsCalculator(
        applicationService, flowClassificationRuleDao, logicalFlowDao,
        new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class)));

    DataTypeUsageDao dataTypeUsageDao = mock(DataTypeUsageDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    DataTypeUsageService dataTypeUsageService = new DataTypeUsageService(dataTypeUsageDao, dataTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
    LogicalFlowService logicalFlowService = mock(LogicalFlowService.class);
    LogicalFlowStatsDao logicalFlowStatsDao = mock(LogicalFlowStatsDao.class);
    LogicalFlowDecoratorService logicalFlowDecoratorService = new LogicalFlowDecoratorService(
        logicalFlowDecoratorSummaryDao, logicalFlowDecoratorDao, ratingsCalculator, dataTypeUsageService, dataTypeDao2,
        logicalFlowDao2, logicalFlowService, logicalFlowStatsDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    HashSet<ApplicationKind> applicationKindSet = new HashSet<>();
    applicationKindSet.add(ApplicationKind.IN_HOUSE);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(applicationKindSet);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<DecoratorRatingSummary> actualSummarizeOutboundForSelectorResult = logicalFlowDecoratorService
        .summarizeOutboundForSelector(options);

    // Assert
    verify(logicalFlowDecoratorSummaryDao).summarizeOutboundForSelector(isA(Select.class));
    verify(entityReference).kind();
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options, atLeast(1)).filters();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    assertTrue(actualSummarizeOutboundForSelectorResult.isEmpty());
    assertSame(decoratorRatingSummaryList, actualSummarizeOutboundForSelectorResult);
  }

  /**
   * Method under test:
   * {@link LogicalFlowDecoratorService#summarizeOutboundForSelector(IdSelectionOptions)}
   */
  @Test
  void testSummarizeOutboundForSelector3() {
    // Arrange
    LogicalFlowDecoratorSummaryDao logicalFlowDecoratorSummaryDao = mock(LogicalFlowDecoratorSummaryDao.class);
    ArrayList<DecoratorRatingSummary> decoratorRatingSummaryList = new ArrayList<>();
    when(logicalFlowDecoratorSummaryDao.summarizeOutboundForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(decoratorRatingSummaryList);
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    ApplicationService applicationService = new ApplicationService(appDao, new TagService(mock(TagDao.class), null),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    LogicalFlowDecoratorRatingsCalculator ratingsCalculator = new LogicalFlowDecoratorRatingsCalculator(
        applicationService, flowClassificationRuleDao, logicalFlowDao,
        new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class)));

    DataTypeUsageDao dataTypeUsageDao = mock(DataTypeUsageDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    DataTypeUsageService dataTypeUsageService = new DataTypeUsageService(dataTypeUsageDao, dataTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
    LogicalFlowService logicalFlowService = mock(LogicalFlowService.class);
    LogicalFlowStatsDao logicalFlowStatsDao = mock(LogicalFlowStatsDao.class);
    LogicalFlowDecoratorService logicalFlowDecoratorService = new LogicalFlowDecoratorService(
        logicalFlowDecoratorSummaryDao, logicalFlowDecoratorDao, ratingsCalculator, dataTypeUsageService, dataTypeDao2,
        logicalFlowDao2, logicalFlowService, logicalFlowStatsDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<DecoratorRatingSummary> actualSummarizeOutboundForSelectorResult = logicalFlowDecoratorService
        .summarizeOutboundForSelector(options);

    // Assert
    verify(logicalFlowDecoratorSummaryDao).summarizeOutboundForSelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualSummarizeOutboundForSelectorResult.isEmpty());
    assertSame(decoratorRatingSummaryList, actualSummarizeOutboundForSelectorResult);
  }

  /**
   * Method under test: {@link LogicalFlowDecoratorService#summarizeForAll()}
   */
  @Test
  void testSummarizeForAll() {
    // Arrange
    LogicalFlowDecoratorSummaryDao logicalFlowDecoratorSummaryDao = mock(LogicalFlowDecoratorSummaryDao.class);
    ArrayList<DecoratorRatingSummary> decoratorRatingSummaryList = new ArrayList<>();
    when(logicalFlowDecoratorSummaryDao.summarizeForAll()).thenReturn(decoratorRatingSummaryList);
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    ApplicationService applicationService = new ApplicationService(appDao, new TagService(mock(TagDao.class), null),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    LogicalFlowDecoratorRatingsCalculator ratingsCalculator = new LogicalFlowDecoratorRatingsCalculator(
        applicationService, flowClassificationRuleDao, logicalFlowDao,
        new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class)));

    DataTypeUsageDao dataTypeUsageDao = mock(DataTypeUsageDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    DataTypeUsageService dataTypeUsageService = new DataTypeUsageService(dataTypeUsageDao, dataTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
    LogicalFlowService logicalFlowService = mock(LogicalFlowService.class);
    LogicalFlowStatsDao logicalFlowStatsDao = mock(LogicalFlowStatsDao.class);

    // Act
    List<DecoratorRatingSummary> actualSummarizeForAllResult = (new LogicalFlowDecoratorService(
        logicalFlowDecoratorSummaryDao, logicalFlowDecoratorDao, ratingsCalculator, dataTypeUsageService, dataTypeDao2,
        logicalFlowDao2, logicalFlowService, logicalFlowStatsDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .summarizeForAll();

    // Assert
    verify(logicalFlowDecoratorSummaryDao).summarizeForAll();
    assertTrue(actualSummarizeForAllResult.isEmpty());
    assertSame(decoratorRatingSummaryList, actualSummarizeForAllResult);
  }

  /**
   * Method under test:
   * {@link LogicalFlowDecoratorService#findFlowsByDatatypeForEntity(IdSelectionOptions)}
   */
  @Test
  void testFindFlowsByDatatypeForEntity() {
    // Arrange
    LogicalFlowDecoratorSummaryDao logicalFlowDecoratorSummaryDao = mock(LogicalFlowDecoratorSummaryDao.class);
    when(logicalFlowDecoratorSummaryDao.logicalFlowIdsByTypeAndDirection(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashMap<>());
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    ApplicationDao appDao = mock(ApplicationDao.class);
    ApplicationService applicationService = new ApplicationService(appDao, new TagService(mock(TagDao.class), null),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    LogicalFlowDecoratorRatingsCalculator ratingsCalculator = new LogicalFlowDecoratorRatingsCalculator(
        applicationService, flowClassificationRuleDao, logicalFlowDao,
        new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class)));

    DataTypeUsageDao dataTypeUsageDao = mock(DataTypeUsageDao.class);
    DataTypeDao dataTypeDao2 = mock(DataTypeDao.class);
    DataTypeUsageService dataTypeUsageService = new DataTypeUsageService(dataTypeUsageDao, dataTypeDao2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
    LogicalFlowService logicalFlowService = mock(LogicalFlowService.class);
    LogicalFlowStatsDao logicalFlowStatsDao = mock(LogicalFlowStatsDao.class);
    LogicalFlowDecoratorService logicalFlowDecoratorService = new LogicalFlowDecoratorService(
        logicalFlowDecoratorSummaryDao, logicalFlowDecoratorDao, ratingsCalculator, dataTypeUsageService, dataTypeDao,
        logicalFlowDao2, logicalFlowService, logicalFlowStatsDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(selectionFilters);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Set<LogicalFlowDecoratorStat> actualFindFlowsByDatatypeForEntityResult = logicalFlowDecoratorService
        .findFlowsByDatatypeForEntity(selectionOptions);

    // Assert
    verify(logicalFlowDecoratorSummaryDao).logicalFlowIdsByTypeAndDirection(isA(Select.class));
    verify(dataTypeDao).findAll();
    verify(entityReference).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions).filters();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindFlowsByDatatypeForEntityResult.isEmpty());
  }
}
