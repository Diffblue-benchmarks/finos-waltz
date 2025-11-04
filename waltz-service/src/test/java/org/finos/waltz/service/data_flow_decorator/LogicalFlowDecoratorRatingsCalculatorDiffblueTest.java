package org.finos.waltz.service.data_flow_decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.application.search.ApplicationSearchDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.data_type.DataTypeDao;
import org.finos.waltz.data.data_type.search.DataTypeSearchDao;
import org.finos.waltz.data.entity_alias.EntityAliasDao;
import org.finos.waltz.data.flow_classification_rule.FlowClassificationRuleDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.tag.TagDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.FlowDirection;
import org.finos.waltz.model.MessageSeverity;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.datatype.DataType;
import org.finos.waltz.model.datatype.DataTypeDecorator;
import org.finos.waltz.model.datatype.DataTypeDecoratorRatingCharacteristics;
import org.finos.waltz.model.flow_classification_rule.FlowClassificationRuleVantagePoint;
import org.finos.waltz.service.application.ApplicationService;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.data_type.DataTypeService;
import org.finos.waltz.service.tag.TagService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LogicalFlowDecoratorRatingsCalculatorDiffblueTest {
  /**
   * Method under test:
   * {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)}
   */
  @Test
  void testCalculate() {
    // Arrange
    ApplicationDao appDao = mock(ApplicationDao.class);
    when(appDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(Mockito.<FlowDirection>any(),
        Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any())).thenReturn(new ArrayList<>());
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.findActiveByFlowIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    LogicalFlowDecoratorRatingsCalculator logicalFlowDecoratorRatingsCalculator = new LogicalFlowDecoratorRatingsCalculator(
        applicationService, flowClassificationRuleDao, logicalFlowDao,
        new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class)));

    // Act
    Collection<DataTypeDecorator> actualCalculateResult = logicalFlowDecoratorRatingsCalculator
        .calculate(new ArrayList<>());

    // Assert
    verify(appDao, atLeast(1)).findByIds(isA(Collection.class));
    verify(flowClassificationRuleDao, atLeast(1)).findExpandedFlowClassificationRuleVantagePoints(
        Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    assertTrue(actualCalculateResult instanceof Set);
    assertTrue(actualCalculateResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)}
   */
  @Test
  void testCalculate2() {
    // Arrange
    Application application = mock(Application.class);
    when(application.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(application.id()).thenReturn(ofResult);

    ArrayList<Application> applicationList = new ArrayList<>();
    applicationList.add(application);
    ApplicationDao appDao = mock(ApplicationDao.class);
    when(appDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(applicationList);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(Mockito.<FlowDirection>any(),
        Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any())).thenReturn(new ArrayList<>());
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.findActiveByFlowIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    LogicalFlowDecoratorRatingsCalculator logicalFlowDecoratorRatingsCalculator = new LogicalFlowDecoratorRatingsCalculator(
        applicationService, flowClassificationRuleDao, logicalFlowDao,
        new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class)));

    // Act
    Collection<DataTypeDecorator> actualCalculateResult = logicalFlowDecoratorRatingsCalculator
        .calculate(new ArrayList<>());

    // Assert
    verify(appDao, atLeast(1)).findByIds(isA(Collection.class));
    verify(flowClassificationRuleDao, atLeast(1)).findExpandedFlowClassificationRuleVantagePoints(
        Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    verify(application, atLeast(1)).id();
    verify(application, atLeast(1)).organisationalUnitId();
    assertTrue(actualCalculateResult instanceof Set);
    assertTrue(actualCalculateResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link LogicalFlowDecoratorRatingsCalculator#calculate(Collection)}
   */
  @Test
  void testCalculate3() {
    // Arrange
    Application application = mock(Application.class);
    when(application.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(application.id()).thenReturn(ofResult);
    Application application2 = mock(Application.class);
    when(application2.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(application2.id()).thenReturn(ofResult2);

    ArrayList<Application> applicationList = new ArrayList<>();
    applicationList.add(application2);
    applicationList.add(application);
    ApplicationDao appDao = mock(ApplicationDao.class);
    when(appDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(applicationList);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(Mockito.<FlowDirection>any(),
        Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any())).thenReturn(new ArrayList<>());
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.findActiveByFlowIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    LogicalFlowDecoratorRatingsCalculator logicalFlowDecoratorRatingsCalculator = new LogicalFlowDecoratorRatingsCalculator(
        applicationService, flowClassificationRuleDao, logicalFlowDao,
        new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class)));

    // Act
    Collection<DataTypeDecorator> actualCalculateResult = logicalFlowDecoratorRatingsCalculator
        .calculate(new ArrayList<>());

    // Assert
    verify(appDao, atLeast(1)).findByIds(isA(Collection.class));
    verify(flowClassificationRuleDao, atLeast(1)).findExpandedFlowClassificationRuleVantagePoints(
        Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    verify(application2, atLeast(1)).id();
    verify(application, atLeast(1)).id();
    verify(application2, atLeast(1)).organisationalUnitId();
    verify(application, atLeast(1)).organisationalUnitId();
    assertTrue(actualCalculateResult instanceof Set);
    assertTrue(actualCalculateResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link LogicalFlowDecoratorRatingsCalculator#calculate(EntityReference, EntityReference, Optional)}
   */
  @Test
  void testCalculate4() {
    // Arrange
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(Mockito.<FlowDirection>any(),
        Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any())).thenReturn(new ArrayList<>());
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    LogicalFlowDecoratorRatingsCalculator logicalFlowDecoratorRatingsCalculator = new LogicalFlowDecoratorRatingsCalculator(
        applicationService, flowClassificationRuleDao, logicalFlowDao,
        new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class)));
    EntityReference source = mock(EntityReference.class);
    when(source.kind()).thenReturn(EntityKind.ALL);
    EntityReference target = mock(EntityReference.class);
    when(target.kind()).thenReturn(EntityKind.ALL);
    Optional<Collection<Long>> dataTypeIds = Optional.of(new ArrayList<>());

    // Act
    Set<DataTypeDecoratorRatingCharacteristics> actualCalculateResult = logicalFlowDecoratorRatingsCalculator
        .calculate(source, target, dataTypeIds);

    // Assert
    verify(flowClassificationRuleDao, atLeast(1)).findExpandedFlowClassificationRuleVantagePoints(
        Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(source, atLeast(1)).kind();
    verify(target, atLeast(1)).kind();
    assertTrue(actualCalculateResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link LogicalFlowDecoratorRatingsCalculator#calculate(EntityReference, EntityReference, Optional)}
   */
  @Test
  void testCalculate5() {
    // Arrange
    FlowClassificationRuleVantagePoint flowClassificationRuleVantagePoint = mock(
        FlowClassificationRuleVantagePoint.class);
    when(flowClassificationRuleVantagePoint.dataTypeId()).thenReturn(1L);
    when(flowClassificationRuleVantagePoint.subjectReference()).thenReturn(null);
    when(flowClassificationRuleVantagePoint.vantagePoint()).thenReturn(null);

    ArrayList<FlowClassificationRuleVantagePoint> flowClassificationRuleVantagePointList = new ArrayList<>();
    flowClassificationRuleVantagePointList.add(flowClassificationRuleVantagePoint);
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(Mockito.<FlowDirection>any(),
        Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
            .thenReturn(flowClassificationRuleVantagePointList);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    LogicalFlowDecoratorRatingsCalculator logicalFlowDecoratorRatingsCalculator = new LogicalFlowDecoratorRatingsCalculator(
        applicationService, flowClassificationRuleDao, logicalFlowDao,
        new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class)));
    EntityReference source = mock(EntityReference.class);
    when(source.kind()).thenReturn(EntityKind.ALL);
    EntityReference target = mock(EntityReference.class);
    when(target.kind()).thenReturn(EntityKind.ALL);
    Optional<Collection<Long>> dataTypeIds = Optional.of(new ArrayList<>());

    // Act
    Set<DataTypeDecoratorRatingCharacteristics> actualCalculateResult = logicalFlowDecoratorRatingsCalculator
        .calculate(source, target, dataTypeIds);

    // Assert
    verify(flowClassificationRuleDao, atLeast(1)).findExpandedFlowClassificationRuleVantagePoints(
        Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(source, atLeast(1)).kind();
    verify(target, atLeast(1)).kind();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).dataTypeId();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).subjectReference();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).vantagePoint();
    assertTrue(actualCalculateResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link LogicalFlowDecoratorRatingsCalculator#calculate(EntityReference, EntityReference, Optional)}
   */
  @Test
  void testCalculate6() {
    // Arrange
    FlowClassificationRuleVantagePoint flowClassificationRuleVantagePoint = mock(
        FlowClassificationRuleVantagePoint.class);
    when(flowClassificationRuleVantagePoint.vantagePoint()).thenReturn(null);

    ArrayList<FlowClassificationRuleVantagePoint> flowClassificationRuleVantagePointList = new ArrayList<>();
    flowClassificationRuleVantagePointList.add(mock(FlowClassificationRuleVantagePoint.class));
    flowClassificationRuleVantagePointList.add(flowClassificationRuleVantagePoint);
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(Mockito.<FlowDirection>any(),
        Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
            .thenReturn(flowClassificationRuleVantagePointList);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    LogicalFlowDecoratorRatingsCalculator logicalFlowDecoratorRatingsCalculator = new LogicalFlowDecoratorRatingsCalculator(
        applicationService, flowClassificationRuleDao, logicalFlowDao,
        new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class)));
    EntityReference source = mock(EntityReference.class);
    when(source.kind()).thenReturn(EntityKind.ALL);
    EntityReference target = mock(EntityReference.class);
    when(target.kind()).thenReturn(EntityKind.ALL);
    Optional<Collection<Long>> dataTypeIds = Optional.of(new ArrayList<>());

    // Act
    Set<DataTypeDecoratorRatingCharacteristics> actualCalculateResult = logicalFlowDecoratorRatingsCalculator
        .calculate(source, target, dataTypeIds);

    // Assert
    verify(flowClassificationRuleDao, atLeast(1)).findExpandedFlowClassificationRuleVantagePoints(
        Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(source, atLeast(1)).kind();
    verify(target, atLeast(1)).kind();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).vantagePoint();
    assertTrue(actualCalculateResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link LogicalFlowDecoratorRatingsCalculator#calculate(EntityReference, EntityReference, Optional)}
   */
  @Test
  void testCalculate7() {
    // Arrange
    FlowClassificationRuleVantagePoint flowClassificationRuleVantagePoint = mock(
        FlowClassificationRuleVantagePoint.class);
    when(flowClassificationRuleVantagePoint.dataTypeId()).thenReturn(1L);
    when(flowClassificationRuleVantagePoint.subjectReference()).thenReturn(null);
    when(flowClassificationRuleVantagePoint.vantagePoint()).thenReturn(null);

    ArrayList<FlowClassificationRuleVantagePoint> flowClassificationRuleVantagePointList = new ArrayList<>();
    flowClassificationRuleVantagePointList.add(flowClassificationRuleVantagePoint);
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(Mockito.<FlowDirection>any(),
        Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
            .thenReturn(flowClassificationRuleVantagePointList);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    LogicalFlowDecoratorRatingsCalculator logicalFlowDecoratorRatingsCalculator = new LogicalFlowDecoratorRatingsCalculator(
        applicationService, flowClassificationRuleDao, logicalFlowDao,
        new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class)));
    EntityReference source = mock(EntityReference.class);
    when(source.id()).thenReturn(1L);
    when(source.kind()).thenReturn(EntityKind.ACTOR);
    EntityReference target = mock(EntityReference.class);
    when(target.kind()).thenReturn(EntityKind.ALL);
    Optional<Collection<Long>> dataTypeIds = Optional.of(new ArrayList<>());

    // Act
    Set<DataTypeDecoratorRatingCharacteristics> actualCalculateResult = logicalFlowDecoratorRatingsCalculator
        .calculate(source, target, dataTypeIds);

    // Assert
    verify(flowClassificationRuleDao, atLeast(1)).findExpandedFlowClassificationRuleVantagePoints(
        Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), Mockito.<Set<Long>>any());
    verify(source).id();
    verify(source, atLeast(1)).kind();
    verify(target, atLeast(1)).kind();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).dataTypeId();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).subjectReference();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).vantagePoint();
    assertTrue(actualCalculateResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link LogicalFlowDecoratorRatingsCalculator#calculate(EntityReference, EntityReference, Optional)}
   */
  @Test
  void testCalculate8() {
    // Arrange
    FlowClassificationRuleVantagePoint flowClassificationRuleVantagePoint = mock(
        FlowClassificationRuleVantagePoint.class);
    when(flowClassificationRuleVantagePoint.dataTypeId()).thenReturn(1L);
    when(flowClassificationRuleVantagePoint.subjectReference()).thenReturn(null);
    when(flowClassificationRuleVantagePoint.vantagePoint()).thenReturn(null);

    ArrayList<FlowClassificationRuleVantagePoint> flowClassificationRuleVantagePointList = new ArrayList<>();
    flowClassificationRuleVantagePointList.add(flowClassificationRuleVantagePoint);
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(Mockito.<FlowDirection>any(),
        Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
            .thenReturn(flowClassificationRuleVantagePointList);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    LogicalFlowDecoratorRatingsCalculator logicalFlowDecoratorRatingsCalculator = new LogicalFlowDecoratorRatingsCalculator(
        applicationService, flowClassificationRuleDao, logicalFlowDao,
        new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class)));
    EntityReference source = mock(EntityReference.class);
    when(source.id()).thenReturn(1L);
    when(source.kind()).thenReturn(EntityKind.ACTOR);
    EntityReference target = mock(EntityReference.class);
    when(target.kind()).thenReturn(EntityKind.ALL);

    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(4L);
    Optional<Collection<Long>> dataTypeIds = Optional.of(resultLongList);

    // Act
    Set<DataTypeDecoratorRatingCharacteristics> actualCalculateResult = logicalFlowDecoratorRatingsCalculator
        .calculate(source, target, dataTypeIds);

    // Assert
    verify(flowClassificationRuleDao, atLeast(1)).findExpandedFlowClassificationRuleVantagePoints(
        Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), Mockito.<Set<Long>>any());
    verify(source).id();
    verify(source, atLeast(1)).kind();
    verify(target, atLeast(1)).kind();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).dataTypeId();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).subjectReference();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).vantagePoint();
    assertEquals(1, actualCalculateResult.size());
  }

  /**
   * Method under test:
   * {@link LogicalFlowDecoratorRatingsCalculator#calculate(EntityReference, EntityReference, Optional)}
   */
  @Test
  void testCalculate9() {
    // Arrange
    FlowClassificationRuleVantagePoint flowClassificationRuleVantagePoint = mock(
        FlowClassificationRuleVantagePoint.class);
    when(flowClassificationRuleVantagePoint.dataTypeId()).thenReturn(1L);
    when(flowClassificationRuleVantagePoint.subjectReference()).thenReturn(null);
    when(flowClassificationRuleVantagePoint.vantagePoint()).thenReturn(null);

    ArrayList<FlowClassificationRuleVantagePoint> flowClassificationRuleVantagePointList = new ArrayList<>();
    flowClassificationRuleVantagePointList.add(flowClassificationRuleVantagePoint);
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(Mockito.<FlowDirection>any(),
        Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
            .thenReturn(flowClassificationRuleVantagePointList);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());
    DataTypeService dataTypeService = new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    LogicalFlowDecoratorRatingsCalculator logicalFlowDecoratorRatingsCalculator = new LogicalFlowDecoratorRatingsCalculator(
        new ApplicationService(appDao,
            new TagService(tagDao, new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
            mock(EntityAliasDao.class), mock(ApplicationSearchDao.class)),
        flowClassificationRuleDao, mock(LogicalFlowDao.class), dataTypeService);
    EntityReference source = mock(EntityReference.class);
    when(source.id()).thenReturn(1L);
    when(source.kind()).thenReturn(EntityKind.ACTOR);
    EntityReference target = mock(EntityReference.class);
    when(target.kind()).thenReturn(EntityKind.ALL);
    Optional<Collection<Long>> dataTypeIds = Optional.empty();

    // Act
    Set<DataTypeDecoratorRatingCharacteristics> actualCalculateResult = logicalFlowDecoratorRatingsCalculator
        .calculate(source, target, dataTypeIds);

    // Assert
    verify(dataTypeDao).findAll();
    verify(flowClassificationRuleDao, atLeast(1)).findExpandedFlowClassificationRuleVantagePoints(
        Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), Mockito.<Set<Long>>any());
    verify(source).id();
    verify(source, atLeast(1)).kind();
    verify(target, atLeast(1)).kind();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).dataTypeId();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).subjectReference();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).vantagePoint();
    assertTrue(actualCalculateResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link LogicalFlowDecoratorRatingsCalculator#calculate(EntityReference, EntityReference, Optional)}
   */
  @Test
  void testCalculate10() {
    // Arrange
    FlowClassificationRuleVantagePoint flowClassificationRuleVantagePoint = mock(
        FlowClassificationRuleVantagePoint.class);
    when(flowClassificationRuleVantagePoint.message()).thenReturn("Not all who wander are lost");
    when(flowClassificationRuleVantagePoint.messageSeverity()).thenReturn(MessageSeverity.NONE);
    when(flowClassificationRuleVantagePoint.dataTypeId()).thenReturn(1L);
    when(flowClassificationRuleVantagePoint.subjectReference()).thenReturn(null);
    when(flowClassificationRuleVantagePoint.vantagePoint()).thenReturn(null);

    ArrayList<FlowClassificationRuleVantagePoint> flowClassificationRuleVantagePointList = new ArrayList<>();
    flowClassificationRuleVantagePointList.add(flowClassificationRuleVantagePoint);
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(Mockito.<FlowDirection>any(),
        Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
            .thenReturn(flowClassificationRuleVantagePointList);
    DataType dataType = mock(DataType.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(dataType.id()).thenReturn(ofResult);

    ArrayList<DataType> dataTypeList = new ArrayList<>();
    dataTypeList.add(dataType);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findAll()).thenReturn(dataTypeList);
    DataTypeService dataTypeService = new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    LogicalFlowDecoratorRatingsCalculator logicalFlowDecoratorRatingsCalculator = new LogicalFlowDecoratorRatingsCalculator(
        new ApplicationService(appDao,
            new TagService(tagDao, new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
            mock(EntityAliasDao.class), mock(ApplicationSearchDao.class)),
        flowClassificationRuleDao, mock(LogicalFlowDao.class), dataTypeService);
    EntityReference source = mock(EntityReference.class);
    when(source.id()).thenReturn(1L);
    when(source.kind()).thenReturn(EntityKind.ACTOR);
    EntityReference target = mock(EntityReference.class);
    when(target.kind()).thenReturn(EntityKind.ALL);
    Optional<Collection<Long>> dataTypeIds = Optional.empty();

    // Act
    Set<DataTypeDecoratorRatingCharacteristics> actualCalculateResult = logicalFlowDecoratorRatingsCalculator
        .calculate(source, target, dataTypeIds);

    // Assert
    verify(dataTypeDao).findAll();
    verify(flowClassificationRuleDao, atLeast(1)).findExpandedFlowClassificationRuleVantagePoints(
        Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), Mockito.<Set<Long>>any());
    verify(source).id();
    verify(source, atLeast(1)).kind();
    verify(target, atLeast(1)).kind();
    verify(dataType).id();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).dataTypeId();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).message();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).messageSeverity();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).subjectReference();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).vantagePoint();
    assertEquals(1, actualCalculateResult.size());
  }

  /**
   * Method under test:
   * {@link LogicalFlowDecoratorRatingsCalculator#calculate(EntityReference, EntityReference, Optional)}
   */
  @Test
  void testCalculate11() {
    // Arrange
    FlowClassificationRuleVantagePoint flowClassificationRuleVantagePoint = mock(
        FlowClassificationRuleVantagePoint.class);
    when(flowClassificationRuleVantagePoint.vantagePoint()).thenReturn(null);

    ArrayList<FlowClassificationRuleVantagePoint> flowClassificationRuleVantagePointList = new ArrayList<>();
    flowClassificationRuleVantagePointList.add(mock(FlowClassificationRuleVantagePoint.class));
    flowClassificationRuleVantagePointList.add(flowClassificationRuleVantagePoint);
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(Mockito.<FlowDirection>any(),
        Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
            .thenReturn(flowClassificationRuleVantagePointList);
    DataType dataType = mock(DataType.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(dataType.id()).thenReturn(ofResult);

    ArrayList<DataType> dataTypeList = new ArrayList<>();
    dataTypeList.add(dataType);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findAll()).thenReturn(dataTypeList);
    DataTypeService dataTypeService = new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    LogicalFlowDecoratorRatingsCalculator logicalFlowDecoratorRatingsCalculator = new LogicalFlowDecoratorRatingsCalculator(
        new ApplicationService(appDao,
            new TagService(tagDao, new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
            mock(EntityAliasDao.class), mock(ApplicationSearchDao.class)),
        flowClassificationRuleDao, mock(LogicalFlowDao.class), dataTypeService);
    EntityReference source = mock(EntityReference.class);
    when(source.id()).thenReturn(1L);
    when(source.kind()).thenReturn(EntityKind.ACTOR);
    EntityReference target = mock(EntityReference.class);
    when(target.kind()).thenReturn(EntityKind.ALL);
    Optional<Collection<Long>> dataTypeIds = Optional.empty();

    // Act
    Set<DataTypeDecoratorRatingCharacteristics> actualCalculateResult = logicalFlowDecoratorRatingsCalculator
        .calculate(source, target, dataTypeIds);

    // Assert
    verify(dataTypeDao).findAll();
    verify(flowClassificationRuleDao, atLeast(1)).findExpandedFlowClassificationRuleVantagePoints(
        Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), Mockito.<Set<Long>>any());
    verify(source).id();
    verify(source, atLeast(1)).kind();
    verify(target, atLeast(1)).kind();
    verify(dataType).id();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).vantagePoint();
    assertTrue(actualCalculateResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link LogicalFlowDecoratorRatingsCalculator#calculate(EntityReference, EntityReference, Optional)}
   */
  @Test
  void testCalculate12() {
    // Arrange
    FlowClassificationRuleVantagePoint flowClassificationRuleVantagePoint = mock(
        FlowClassificationRuleVantagePoint.class);
    when(flowClassificationRuleVantagePoint.dataTypeId()).thenReturn(1L);
    when(flowClassificationRuleVantagePoint.subjectReference()).thenReturn(null);
    when(flowClassificationRuleVantagePoint.vantagePoint()).thenReturn(mock(EntityReference.class));

    ArrayList<FlowClassificationRuleVantagePoint> flowClassificationRuleVantagePointList = new ArrayList<>();
    flowClassificationRuleVantagePointList.add(flowClassificationRuleVantagePoint);
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(Mockito.<FlowDirection>any(),
        Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
            .thenReturn(flowClassificationRuleVantagePointList);
    DataType dataType = mock(DataType.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(dataType.id()).thenReturn(ofResult);

    ArrayList<DataType> dataTypeList = new ArrayList<>();
    dataTypeList.add(dataType);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findAll()).thenReturn(dataTypeList);
    DataTypeService dataTypeService = new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    LogicalFlowDecoratorRatingsCalculator logicalFlowDecoratorRatingsCalculator = new LogicalFlowDecoratorRatingsCalculator(
        new ApplicationService(appDao,
            new TagService(tagDao, new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
            mock(EntityAliasDao.class), mock(ApplicationSearchDao.class)),
        flowClassificationRuleDao, mock(LogicalFlowDao.class), dataTypeService);
    EntityReference source = mock(EntityReference.class);
    when(source.id()).thenReturn(1L);
    when(source.kind()).thenReturn(EntityKind.ACTOR);
    EntityReference target = mock(EntityReference.class);
    when(target.kind()).thenReturn(EntityKind.ALL);
    Optional<Collection<Long>> dataTypeIds = Optional.empty();

    // Act
    Set<DataTypeDecoratorRatingCharacteristics> actualCalculateResult = logicalFlowDecoratorRatingsCalculator
        .calculate(source, target, dataTypeIds);

    // Assert
    verify(dataTypeDao).findAll();
    verify(flowClassificationRuleDao, atLeast(1)).findExpandedFlowClassificationRuleVantagePoints(
        Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), Mockito.<Set<Long>>any());
    verify(source).id();
    verify(source, atLeast(1)).kind();
    verify(target, atLeast(1)).kind();
    verify(dataType).id();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).dataTypeId();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).subjectReference();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).vantagePoint();
    assertEquals(1, actualCalculateResult.size());
  }

  /**
   * Method under test:
   * {@link LogicalFlowDecoratorRatingsCalculator#calculate(EntityReference, EntityReference, Optional)}
   */
  @Test
  void testCalculate13() {
    // Arrange
    FlowClassificationRuleVantagePoint flowClassificationRuleVantagePoint = mock(
        FlowClassificationRuleVantagePoint.class);
    when(flowClassificationRuleVantagePoint.message()).thenReturn("Not all who wander are lost");
    when(flowClassificationRuleVantagePoint.messageSeverity()).thenReturn(MessageSeverity.NONE);
    when(flowClassificationRuleVantagePoint.dataTypeId()).thenReturn(1L);
    when(flowClassificationRuleVantagePoint.subjectReference()).thenReturn(null);
    when(flowClassificationRuleVantagePoint.vantagePoint()).thenReturn(null);

    ArrayList<FlowClassificationRuleVantagePoint> flowClassificationRuleVantagePointList = new ArrayList<>();
    flowClassificationRuleVantagePointList.add(flowClassificationRuleVantagePoint);
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(Mockito.<FlowDirection>any(),
        Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
            .thenReturn(flowClassificationRuleVantagePointList);
    DataType dataType = mock(DataType.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(dataType.id()).thenReturn(ofResult);
    DataType dataType2 = mock(DataType.class);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(dataType2.id()).thenReturn(ofResult2);

    ArrayList<DataType> dataTypeList = new ArrayList<>();
    dataTypeList.add(dataType2);
    dataTypeList.add(dataType);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findAll()).thenReturn(dataTypeList);
    DataTypeService dataTypeService = new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    LogicalFlowDecoratorRatingsCalculator logicalFlowDecoratorRatingsCalculator = new LogicalFlowDecoratorRatingsCalculator(
        new ApplicationService(appDao,
            new TagService(tagDao, new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
            mock(EntityAliasDao.class), mock(ApplicationSearchDao.class)),
        flowClassificationRuleDao, mock(LogicalFlowDao.class), dataTypeService);
    EntityReference source = mock(EntityReference.class);
    when(source.id()).thenReturn(1L);
    when(source.kind()).thenReturn(EntityKind.ACTOR);
    EntityReference target = mock(EntityReference.class);
    when(target.kind()).thenReturn(EntityKind.ALL);
    Optional<Collection<Long>> dataTypeIds = Optional.empty();

    // Act
    Set<DataTypeDecoratorRatingCharacteristics> actualCalculateResult = logicalFlowDecoratorRatingsCalculator
        .calculate(source, target, dataTypeIds);

    // Assert
    verify(dataTypeDao).findAll();
    verify(flowClassificationRuleDao, atLeast(1)).findExpandedFlowClassificationRuleVantagePoints(
        Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), Mockito.<Set<Long>>any());
    verify(source).id();
    verify(source, atLeast(1)).kind();
    verify(target, atLeast(1)).kind();
    verify(dataType2).id();
    verify(dataType).id();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).dataTypeId();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).message();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).messageSeverity();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).subjectReference();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).vantagePoint();
    assertEquals(1, actualCalculateResult.size());
  }

  /**
   * Method under test:
   * {@link LogicalFlowDecoratorRatingsCalculator#calculate(EntityReference, EntityReference, Optional)}
   */
  @Test
  void testCalculate14() {
    // Arrange
    FlowClassificationRuleVantagePoint flowClassificationRuleVantagePoint = mock(
        FlowClassificationRuleVantagePoint.class);
    when(flowClassificationRuleVantagePoint.message()).thenReturn("Not all who wander are lost");
    when(flowClassificationRuleVantagePoint.messageSeverity()).thenReturn(MessageSeverity.NONE);
    when(flowClassificationRuleVantagePoint.dataTypeId()).thenReturn(1L);
    when(flowClassificationRuleVantagePoint.subjectReference()).thenReturn(null);
    when(flowClassificationRuleVantagePoint.vantagePoint()).thenReturn(null);

    ArrayList<FlowClassificationRuleVantagePoint> flowClassificationRuleVantagePointList = new ArrayList<>();
    flowClassificationRuleVantagePointList.add(flowClassificationRuleVantagePoint);
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(Mockito.<FlowDirection>any(),
        Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
            .thenReturn(flowClassificationRuleVantagePointList);
    DataType dataType = mock(DataType.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(dataType.id()).thenReturn(ofResult);
    DataType dataType2 = mock(DataType.class);
    Optional<Long> ofResult2 = Optional.<Long>of(5L);
    when(dataType2.id()).thenReturn(ofResult2);

    ArrayList<DataType> dataTypeList = new ArrayList<>();
    dataTypeList.add(dataType2);
    dataTypeList.add(dataType);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findAll()).thenReturn(dataTypeList);
    DataTypeService dataTypeService = new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    LogicalFlowDecoratorRatingsCalculator logicalFlowDecoratorRatingsCalculator = new LogicalFlowDecoratorRatingsCalculator(
        new ApplicationService(appDao,
            new TagService(tagDao, new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
            mock(EntityAliasDao.class), mock(ApplicationSearchDao.class)),
        flowClassificationRuleDao, mock(LogicalFlowDao.class), dataTypeService);
    EntityReference source = mock(EntityReference.class);
    when(source.id()).thenReturn(1L);
    when(source.kind()).thenReturn(EntityKind.ACTOR);
    EntityReference target = mock(EntityReference.class);
    when(target.kind()).thenReturn(EntityKind.ALL);
    Optional<Collection<Long>> dataTypeIds = Optional.empty();

    // Act
    Set<DataTypeDecoratorRatingCharacteristics> actualCalculateResult = logicalFlowDecoratorRatingsCalculator
        .calculate(source, target, dataTypeIds);

    // Assert
    verify(dataTypeDao).findAll();
    verify(flowClassificationRuleDao, atLeast(1)).findExpandedFlowClassificationRuleVantagePoints(
        Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), Mockito.<Set<Long>>any());
    verify(source).id();
    verify(source, atLeast(1)).kind();
    verify(target, atLeast(1)).kind();
    verify(dataType2).id();
    verify(dataType).id();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).dataTypeId();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).message();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).messageSeverity();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).subjectReference();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).vantagePoint();
    assertEquals(2, actualCalculateResult.size());
  }

  /**
   * Method under test:
   * {@link LogicalFlowDecoratorRatingsCalculator#calculate(EntityReference, EntityReference, Optional)}
   */
  @Test
  void testCalculate15() {
    // Arrange
    ApplicationDao appDao = mock(ApplicationDao.class);
    when(appDao.getById(anyLong())).thenReturn(null);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    FlowClassificationRuleVantagePoint flowClassificationRuleVantagePoint = mock(
        FlowClassificationRuleVantagePoint.class);
    when(flowClassificationRuleVantagePoint.dataTypeId()).thenReturn(1L);
    when(flowClassificationRuleVantagePoint.subjectReference()).thenReturn(null);
    when(flowClassificationRuleVantagePoint.vantagePoint()).thenReturn(null);

    ArrayList<FlowClassificationRuleVantagePoint> flowClassificationRuleVantagePointList = new ArrayList<>();
    flowClassificationRuleVantagePointList.add(flowClassificationRuleVantagePoint);
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(Mockito.<FlowDirection>any(),
        Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
            .thenReturn(flowClassificationRuleVantagePointList);
    DataType dataType = mock(DataType.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(dataType.id()).thenReturn(ofResult);
    DataType dataType2 = mock(DataType.class);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(dataType2.id()).thenReturn(ofResult2);

    ArrayList<DataType> dataTypeList = new ArrayList<>();
    dataTypeList.add(dataType2);
    dataTypeList.add(dataType);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findAll()).thenReturn(dataTypeList);
    LogicalFlowDecoratorRatingsCalculator logicalFlowDecoratorRatingsCalculator = new LogicalFlowDecoratorRatingsCalculator(
        applicationService, flowClassificationRuleDao, mock(LogicalFlowDao.class),
        new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class)));
    EntityReference source = mock(EntityReference.class);
    when(source.id()).thenReturn(1L);
    when(source.kind()).thenReturn(EntityKind.APPLICATION);
    EntityReference target = mock(EntityReference.class);
    when(target.kind()).thenReturn(EntityKind.ALL);
    Optional<Collection<Long>> dataTypeIds = Optional.empty();

    // Act
    Set<DataTypeDecoratorRatingCharacteristics> actualCalculateResult = logicalFlowDecoratorRatingsCalculator
        .calculate(source, target, dataTypeIds);

    // Assert
    verify(appDao).getById(eq(1L));
    verify(dataTypeDao).findAll();
    verify(flowClassificationRuleDao, atLeast(1)).findExpandedFlowClassificationRuleVantagePoints(
        Mockito.<FlowDirection>any(), isA(Set.class), Mockito.<Set<Long>>any(), isA(Set.class));
    verify(source, atLeast(1)).id();
    verify(source, atLeast(1)).kind();
    verify(target, atLeast(1)).kind();
    verify(dataType2).id();
    verify(dataType).id();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).dataTypeId();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).subjectReference();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).vantagePoint();
    assertTrue(actualCalculateResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link LogicalFlowDecoratorRatingsCalculator#calculate(EntityReference, EntityReference, Optional)}
   */
  @Test
  void testCalculate16() {
    // Arrange
    ApplicationService applicationService = mock(ApplicationService.class);
    when(applicationService.getById(anyLong())).thenReturn(null);
    FlowClassificationRuleVantagePoint flowClassificationRuleVantagePoint = mock(
        FlowClassificationRuleVantagePoint.class);
    when(flowClassificationRuleVantagePoint.dataTypeId()).thenReturn(1L);
    when(flowClassificationRuleVantagePoint.subjectReference()).thenReturn(null);
    when(flowClassificationRuleVantagePoint.vantagePoint()).thenReturn(null);

    ArrayList<FlowClassificationRuleVantagePoint> flowClassificationRuleVantagePointList = new ArrayList<>();
    flowClassificationRuleVantagePointList.add(flowClassificationRuleVantagePoint);
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(Mockito.<FlowDirection>any(),
        Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
            .thenReturn(flowClassificationRuleVantagePointList);
    DataType dataType = mock(DataType.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(dataType.id()).thenReturn(ofResult);
    DataType dataType2 = mock(DataType.class);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(dataType2.id()).thenReturn(ofResult2);

    ArrayList<DataType> dataTypeList = new ArrayList<>();
    dataTypeList.add(dataType2);
    dataTypeList.add(dataType);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findAll()).thenReturn(dataTypeList);
    LogicalFlowDecoratorRatingsCalculator logicalFlowDecoratorRatingsCalculator = new LogicalFlowDecoratorRatingsCalculator(
        applicationService, flowClassificationRuleDao, mock(LogicalFlowDao.class),
        new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class)));
    EntityReference source = mock(EntityReference.class);
    when(source.id()).thenReturn(1L);
    when(source.kind()).thenReturn(EntityKind.APPLICATION);
    EntityReference target = mock(EntityReference.class);
    when(target.kind()).thenReturn(EntityKind.ALL);
    Optional<Collection<Long>> dataTypeIds = Optional.empty();

    // Act
    Set<DataTypeDecoratorRatingCharacteristics> actualCalculateResult = logicalFlowDecoratorRatingsCalculator
        .calculate(source, target, dataTypeIds);

    // Assert
    verify(dataTypeDao).findAll();
    verify(flowClassificationRuleDao, atLeast(1)).findExpandedFlowClassificationRuleVantagePoints(
        Mockito.<FlowDirection>any(), isA(Set.class), Mockito.<Set<Long>>any(), isA(Set.class));
    verify(source, atLeast(1)).id();
    verify(source, atLeast(1)).kind();
    verify(target, atLeast(1)).kind();
    verify(dataType2).id();
    verify(dataType).id();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).dataTypeId();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).subjectReference();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).vantagePoint();
    verify(applicationService).getById(eq(1L));
    assertTrue(actualCalculateResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link LogicalFlowDecoratorRatingsCalculator#calculate(EntityReference, EntityReference, Optional)}
   */
  @Test
  void testCalculate17() {
    // Arrange
    Application application = mock(Application.class);
    when(application.organisationalUnitId()).thenReturn(1L);
    ApplicationService applicationService = mock(ApplicationService.class);
    when(applicationService.getById(anyLong())).thenReturn(application);
    FlowClassificationRuleVantagePoint flowClassificationRuleVantagePoint = mock(
        FlowClassificationRuleVantagePoint.class);
    when(flowClassificationRuleVantagePoint.message()).thenReturn("Not all who wander are lost");
    when(flowClassificationRuleVantagePoint.messageSeverity()).thenReturn(MessageSeverity.NONE);
    when(flowClassificationRuleVantagePoint.dataTypeId()).thenReturn(1L);
    when(flowClassificationRuleVantagePoint.subjectReference()).thenReturn(null);
    when(flowClassificationRuleVantagePoint.vantagePoint()).thenReturn(null);

    ArrayList<FlowClassificationRuleVantagePoint> flowClassificationRuleVantagePointList = new ArrayList<>();
    flowClassificationRuleVantagePointList.add(flowClassificationRuleVantagePoint);
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(Mockito.<FlowDirection>any(),
        Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
            .thenReturn(flowClassificationRuleVantagePointList);
    DataType dataType = mock(DataType.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(dataType.id()).thenReturn(ofResult);
    DataType dataType2 = mock(DataType.class);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(dataType2.id()).thenReturn(ofResult2);

    ArrayList<DataType> dataTypeList = new ArrayList<>();
    dataTypeList.add(dataType2);
    dataTypeList.add(dataType);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findAll()).thenReturn(dataTypeList);
    LogicalFlowDecoratorRatingsCalculator logicalFlowDecoratorRatingsCalculator = new LogicalFlowDecoratorRatingsCalculator(
        applicationService, flowClassificationRuleDao, mock(LogicalFlowDao.class),
        new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class)));
    EntityReference source = mock(EntityReference.class);
    when(source.id()).thenReturn(1L);
    when(source.kind()).thenReturn(EntityKind.APPLICATION);
    EntityReference target = mock(EntityReference.class);
    when(target.kind()).thenReturn(EntityKind.ALL);
    Optional<Collection<Long>> dataTypeIds = Optional.empty();

    // Act
    Set<DataTypeDecoratorRatingCharacteristics> actualCalculateResult = logicalFlowDecoratorRatingsCalculator
        .calculate(source, target, dataTypeIds);

    // Assert
    verify(dataTypeDao).findAll();
    verify(flowClassificationRuleDao, atLeast(1)).findExpandedFlowClassificationRuleVantagePoints(
        Mockito.<FlowDirection>any(), Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any(), isA(Set.class));
    verify(source, atLeast(1)).id();
    verify(source, atLeast(1)).kind();
    verify(target, atLeast(1)).kind();
    verify(dataType2).id();
    verify(dataType).id();
    verify(application, atLeast(1)).organisationalUnitId();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).dataTypeId();
    verify(flowClassificationRuleVantagePoint).message();
    verify(flowClassificationRuleVantagePoint).messageSeverity();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).subjectReference();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).vantagePoint();
    verify(applicationService).getById(eq(1L));
    assertEquals(1, actualCalculateResult.size());
  }

  /**
   * Method under test:
   * {@link LogicalFlowDecoratorRatingsCalculator#calculate(EntityReference, EntityReference, Optional)}
   */
  @Test
  void testCalculate18() {
    // Arrange
    Application application = mock(Application.class);
    when(application.organisationalUnitId()).thenReturn(1L);
    ApplicationService applicationService = mock(ApplicationService.class);
    when(applicationService.getById(anyLong())).thenReturn(application);
    FlowClassificationRuleVantagePoint flowClassificationRuleVantagePoint = mock(
        FlowClassificationRuleVantagePoint.class);
    when(flowClassificationRuleVantagePoint.dataTypeId()).thenReturn(1L);
    when(flowClassificationRuleVantagePoint.subjectReference()).thenReturn(null);
    when(flowClassificationRuleVantagePoint.vantagePoint()).thenReturn(null);

    ArrayList<FlowClassificationRuleVantagePoint> flowClassificationRuleVantagePointList = new ArrayList<>();
    flowClassificationRuleVantagePointList.add(flowClassificationRuleVantagePoint);
    FlowClassificationRuleDao flowClassificationRuleDao = mock(FlowClassificationRuleDao.class);
    when(flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(Mockito.<FlowDirection>any(),
        Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any(), Mockito.<Set<Long>>any()))
            .thenReturn(flowClassificationRuleVantagePointList);
    DataType dataType = mock(DataType.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(dataType.id()).thenReturn(ofResult);
    DataType dataType2 = mock(DataType.class);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(dataType2.id()).thenReturn(ofResult2);

    ArrayList<DataType> dataTypeList = new ArrayList<>();
    dataTypeList.add(dataType2);
    dataTypeList.add(dataType);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findAll()).thenReturn(dataTypeList);
    LogicalFlowDecoratorRatingsCalculator logicalFlowDecoratorRatingsCalculator = new LogicalFlowDecoratorRatingsCalculator(
        applicationService, flowClassificationRuleDao, mock(LogicalFlowDao.class),
        new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class)));
    EntityReference source = mock(EntityReference.class);
    when(source.id()).thenReturn(1L);
    when(source.kind()).thenReturn(EntityKind.APPLICATION);
    EntityReference target = mock(EntityReference.class);
    when(target.id()).thenReturn(1L);
    when(target.kind()).thenReturn(EntityKind.APPLICATION);
    Optional<Collection<Long>> dataTypeIds = Optional.empty();

    // Act
    Set<DataTypeDecoratorRatingCharacteristics> actualCalculateResult = logicalFlowDecoratorRatingsCalculator
        .calculate(source, target, dataTypeIds);

    // Assert
    verify(dataTypeDao).findAll();
    verify(flowClassificationRuleDao, atLeast(1)).findExpandedFlowClassificationRuleVantagePoints(
        Mockito.<FlowDirection>any(), isA(Set.class), isA(Set.class), isA(Set.class));
    verify(source, atLeast(1)).id();
    verify(target, atLeast(1)).id();
    verify(source, atLeast(1)).kind();
    verify(target, atLeast(1)).kind();
    verify(dataType2).id();
    verify(dataType).id();
    verify(application, atLeast(1)).organisationalUnitId();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).dataTypeId();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).subjectReference();
    verify(flowClassificationRuleVantagePoint, atLeast(1)).vantagePoint();
    verify(applicationService, atLeast(1)).getById(eq(1L));
    assertEquals(1, actualCalculateResult.size());
  }
}
