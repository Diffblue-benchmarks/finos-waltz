package org.finos.waltz.service.logical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.DBExecutorPoolInterface;
import org.finos.waltz.data.datatype_decorator.LogicalFlowDecoratorDao;
import org.finos.waltz.data.datatype_decorator.PhysicalSpecDecoratorDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.logical_flow.LogicalFlowStatsDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.FlowDirection;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.datatype.DataType;
import org.finos.waltz.model.logical_flow.AddLogicalFlowCommand;
import org.finos.waltz.model.logical_flow.FlowInfo;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlowGraphSummary;
import org.finos.waltz.model.logical_flow.LogicalFlow;
import org.finos.waltz.model.logical_flow.LogicalFlowGraphSummary;
import org.finos.waltz.service.assessment_definition.AssessmentDefinitionService;
import org.finos.waltz.service.assessment_rating.AssessmentRatingService;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.data_type.DataTypeService;
import org.finos.waltz.service.permission.permission_checker.FlowPermissionChecker;
import org.finos.waltz.service.rating_scheme.RatingSchemeService;
import org.finos.waltz.service.usage_info.DataTypeUsageService;
import org.jooq.Record1;
import org.jooq.Select;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LogicalFlowServiceDiffblueTest {
  /**
   * Method under test:
   * {@link LogicalFlowService#findByEntityReference(EntityReference)}
   */
  @Test
  void testFindByEntityReference() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    ArrayList<LogicalFlow> logicalFlowList = new ArrayList<>();
    when(logicalFlowDao.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(logicalFlowList);

    // Act
    List<LogicalFlow> actualFindByEntityReferenceResult = (new LogicalFlowService(mock(ChangeLogService.class),
        mock(DataTypeService.class), mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class),
        logicalFlowDao, mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class),
        mock(FlowPermissionChecker.class), mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class))).findByEntityReference(null);

    // Assert
    verify(logicalFlowDao).findByEntityReference(isNull());
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
    assertSame(logicalFlowList, actualFindByEntityReferenceResult);
  }

  /**
   * Method under test:
   * {@link LogicalFlowService#findByEntityReference(EntityReference)}
   */
  @Test
  void testFindByEntityReference2() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new LogicalFlowService(mock(ChangeLogService.class), mock(DataTypeService.class),
            mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class), logicalFlowDao,
            mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class), mock(FlowPermissionChecker.class),
            mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
            mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
            mock(RatingSchemeService.class))).findByEntityReference(null));
    verify(logicalFlowDao).findByEntityReference(isNull());
  }

  /**
   * Method under test:
   * {@link LogicalFlowService#findBySourceAndTargetEntityReferences(List)}
   */
  @Test
  void testFindBySourceAndTargetEntityReferences() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    ArrayList<LogicalFlow> logicalFlowList = new ArrayList<>();
    when(logicalFlowDao.findBySourcesAndTargets(Mockito.<List<Tuple2<EntityReference, EntityReference>>>any()))
        .thenReturn(logicalFlowList);
    LogicalFlowService logicalFlowService = new LogicalFlowService(mock(ChangeLogService.class),
        mock(DataTypeService.class), mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class),
        logicalFlowDao, mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class),
        mock(FlowPermissionChecker.class), mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class));

    // Act
    List<LogicalFlow> actualFindBySourceAndTargetEntityReferencesResult = logicalFlowService
        .findBySourceAndTargetEntityReferences(new ArrayList<>());

    // Assert
    verify(logicalFlowDao).findBySourcesAndTargets(isA(List.class));
    assertTrue(actualFindBySourceAndTargetEntityReferencesResult.isEmpty());
    assertSame(logicalFlowList, actualFindBySourceAndTargetEntityReferencesResult);
  }

  /**
   * Method under test:
   * {@link LogicalFlowService#findBySourceAndTargetEntityReferences(List)}
   */
  @Test
  void testFindBySourceAndTargetEntityReferences2() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    ArrayList<LogicalFlow> logicalFlowList = new ArrayList<>();
    when(logicalFlowDao.findBySourcesAndTargets(Mockito.<List<Tuple2<EntityReference, EntityReference>>>any()))
        .thenReturn(logicalFlowList);
    LogicalFlowService logicalFlowService = new LogicalFlowService(mock(ChangeLogService.class),
        mock(DataTypeService.class), mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class),
        logicalFlowDao, mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class),
        mock(FlowPermissionChecker.class), mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class));

    ArrayList<Tuple2<EntityReference, EntityReference>> sourceAndTargets = new ArrayList<>();
    sourceAndTargets.add(new Tuple2<>(null, null));

    // Act
    List<LogicalFlow> actualFindBySourceAndTargetEntityReferencesResult = logicalFlowService
        .findBySourceAndTargetEntityReferences(sourceAndTargets);

    // Assert
    verify(logicalFlowDao).findBySourcesAndTargets(isA(List.class));
    assertTrue(actualFindBySourceAndTargetEntityReferencesResult.isEmpty());
    assertSame(logicalFlowList, actualFindBySourceAndTargetEntityReferencesResult);
  }

  /**
   * Method under test:
   * {@link LogicalFlowService#findBySourceAndTargetEntityReferences(List)}
   */
  @Test
  void testFindBySourceAndTargetEntityReferences3() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    ArrayList<LogicalFlow> logicalFlowList = new ArrayList<>();
    when(logicalFlowDao.findBySourcesAndTargets(Mockito.<List<Tuple2<EntityReference, EntityReference>>>any()))
        .thenReturn(logicalFlowList);
    LogicalFlowService logicalFlowService = new LogicalFlowService(mock(ChangeLogService.class),
        mock(DataTypeService.class), mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class),
        logicalFlowDao, mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class),
        mock(FlowPermissionChecker.class), mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class));

    ArrayList<Tuple2<EntityReference, EntityReference>> sourceAndTargets = new ArrayList<>();
    sourceAndTargets.add(new Tuple2<>(null, null));
    sourceAndTargets.add(new Tuple2<>(null, null));

    // Act
    List<LogicalFlow> actualFindBySourceAndTargetEntityReferencesResult = logicalFlowService
        .findBySourceAndTargetEntityReferences(sourceAndTargets);

    // Assert
    verify(logicalFlowDao).findBySourcesAndTargets(isA(List.class));
    assertTrue(actualFindBySourceAndTargetEntityReferencesResult.isEmpty());
    assertSame(logicalFlowList, actualFindBySourceAndTargetEntityReferencesResult);
  }

  /**
   * Method under test:
   * {@link LogicalFlowService#findBySourceAndTargetEntityReferences(List)}
   */
  @Test
  void testFindBySourceAndTargetEntityReferences4() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.findBySourcesAndTargets(Mockito.<List<Tuple2<EntityReference, EntityReference>>>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    LogicalFlowService logicalFlowService = new LogicalFlowService(mock(ChangeLogService.class),
        mock(DataTypeService.class), mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class),
        logicalFlowDao, mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class),
        mock(FlowPermissionChecker.class), mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> logicalFlowService.findBySourceAndTargetEntityReferences(new ArrayList<>()));
    verify(logicalFlowDao).findBySourcesAndTargets(isA(List.class));
  }

  /**
   * Method under test: {@link LogicalFlowService#findActiveByFlowIds(Collection)}
   */
  @Test
  void testFindActiveByFlowIds() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    ArrayList<LogicalFlow> logicalFlowList = new ArrayList<>();
    when(logicalFlowDao.findActiveByFlowIds(Mockito.<Collection<Long>>any())).thenReturn(logicalFlowList);
    LogicalFlowService logicalFlowService = new LogicalFlowService(mock(ChangeLogService.class),
        mock(DataTypeService.class), mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class),
        logicalFlowDao, mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class),
        mock(FlowPermissionChecker.class), mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class));

    // Act
    Collection<LogicalFlow> actualFindActiveByFlowIdsResult = logicalFlowService.findActiveByFlowIds(new ArrayList<>());

    // Assert
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    assertTrue(actualFindActiveByFlowIdsResult instanceof List);
    assertTrue(actualFindActiveByFlowIdsResult.isEmpty());
    assertSame(logicalFlowList, actualFindActiveByFlowIdsResult);
  }

  /**
   * Method under test: {@link LogicalFlowService#findActiveByFlowIds(Collection)}
   */
  @Test
  void testFindActiveByFlowIds2() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    ArrayList<LogicalFlow> logicalFlowList = new ArrayList<>();
    when(logicalFlowDao.findActiveByFlowIds(Mockito.<Collection<Long>>any())).thenReturn(logicalFlowList);
    LogicalFlowService logicalFlowService = new LogicalFlowService(mock(ChangeLogService.class),
        mock(DataTypeService.class), mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class),
        logicalFlowDao, mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class),
        mock(FlowPermissionChecker.class), mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class));

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act
    Collection<LogicalFlow> actualFindActiveByFlowIdsResult = logicalFlowService.findActiveByFlowIds(ids);

    // Assert
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    assertTrue(actualFindActiveByFlowIdsResult instanceof List);
    assertTrue(actualFindActiveByFlowIdsResult.isEmpty());
    assertSame(logicalFlowList, actualFindActiveByFlowIdsResult);
  }

  /**
   * Method under test: {@link LogicalFlowService#findActiveByFlowIds(Collection)}
   */
  @Test
  void testFindActiveByFlowIds3() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    ArrayList<LogicalFlow> logicalFlowList = new ArrayList<>();
    when(logicalFlowDao.findActiveByFlowIds(Mockito.<Collection<Long>>any())).thenReturn(logicalFlowList);
    LogicalFlowService logicalFlowService = new LogicalFlowService(mock(ChangeLogService.class),
        mock(DataTypeService.class), mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class),
        logicalFlowDao, mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class),
        mock(FlowPermissionChecker.class), mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class));

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(0L);
    ids.add(1L);

    // Act
    Collection<LogicalFlow> actualFindActiveByFlowIdsResult = logicalFlowService.findActiveByFlowIds(ids);

    // Assert
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
    assertTrue(actualFindActiveByFlowIdsResult instanceof List);
    assertTrue(actualFindActiveByFlowIdsResult.isEmpty());
    assertSame(logicalFlowList, actualFindActiveByFlowIdsResult);
  }

  /**
   * Method under test: {@link LogicalFlowService#findActiveByFlowIds(Collection)}
   */
  @Test
  void testFindActiveByFlowIds4() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.findActiveByFlowIds(Mockito.<Collection<Long>>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    LogicalFlowService logicalFlowService = new LogicalFlowService(mock(ChangeLogService.class),
        mock(DataTypeService.class), mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class),
        logicalFlowDao, mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class),
        mock(FlowPermissionChecker.class), mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> logicalFlowService.findActiveByFlowIds(new ArrayList<>()));
    verify(logicalFlowDao).findActiveByFlowIds(isA(Collection.class));
  }

  /**
   * Method under test: {@link LogicalFlowService#findAllByFlowIds(Collection)}
   */
  @Test
  void testFindAllByFlowIds() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    ArrayList<LogicalFlow> logicalFlowList = new ArrayList<>();
    when(logicalFlowDao.findAllByFlowIds(Mockito.<Collection<Long>>any())).thenReturn(logicalFlowList);
    LogicalFlowService logicalFlowService = new LogicalFlowService(mock(ChangeLogService.class),
        mock(DataTypeService.class), mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class),
        logicalFlowDao, mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class),
        mock(FlowPermissionChecker.class), mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class));

    // Act
    Collection<LogicalFlow> actualFindAllByFlowIdsResult = logicalFlowService.findAllByFlowIds(new ArrayList<>());

    // Assert
    verify(logicalFlowDao).findAllByFlowIds(isA(Collection.class));
    assertTrue(actualFindAllByFlowIdsResult instanceof List);
    assertTrue(actualFindAllByFlowIdsResult.isEmpty());
    assertSame(logicalFlowList, actualFindAllByFlowIdsResult);
  }

  /**
   * Method under test: {@link LogicalFlowService#findAllByFlowIds(Collection)}
   */
  @Test
  void testFindAllByFlowIds2() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    ArrayList<LogicalFlow> logicalFlowList = new ArrayList<>();
    when(logicalFlowDao.findAllByFlowIds(Mockito.<Collection<Long>>any())).thenReturn(logicalFlowList);
    LogicalFlowService logicalFlowService = new LogicalFlowService(mock(ChangeLogService.class),
        mock(DataTypeService.class), mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class),
        logicalFlowDao, mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class),
        mock(FlowPermissionChecker.class), mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class));

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act
    Collection<LogicalFlow> actualFindAllByFlowIdsResult = logicalFlowService.findAllByFlowIds(ids);

    // Assert
    verify(logicalFlowDao).findAllByFlowIds(isA(Collection.class));
    assertTrue(actualFindAllByFlowIdsResult instanceof List);
    assertTrue(actualFindAllByFlowIdsResult.isEmpty());
    assertSame(logicalFlowList, actualFindAllByFlowIdsResult);
  }

  /**
   * Method under test: {@link LogicalFlowService#findAllByFlowIds(Collection)}
   */
  @Test
  void testFindAllByFlowIds3() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    ArrayList<LogicalFlow> logicalFlowList = new ArrayList<>();
    when(logicalFlowDao.findAllByFlowIds(Mockito.<Collection<Long>>any())).thenReturn(logicalFlowList);
    LogicalFlowService logicalFlowService = new LogicalFlowService(mock(ChangeLogService.class),
        mock(DataTypeService.class), mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class),
        logicalFlowDao, mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class),
        mock(FlowPermissionChecker.class), mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class));

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(0L);
    ids.add(1L);

    // Act
    Collection<LogicalFlow> actualFindAllByFlowIdsResult = logicalFlowService.findAllByFlowIds(ids);

    // Assert
    verify(logicalFlowDao).findAllByFlowIds(isA(Collection.class));
    assertTrue(actualFindAllByFlowIdsResult instanceof List);
    assertTrue(actualFindAllByFlowIdsResult.isEmpty());
    assertSame(logicalFlowList, actualFindAllByFlowIdsResult);
  }

  /**
   * Method under test: {@link LogicalFlowService#findAllByFlowIds(Collection)}
   */
  @Test
  void testFindAllByFlowIds4() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.findAllByFlowIds(Mockito.<Collection<Long>>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    LogicalFlowService logicalFlowService = new LogicalFlowService(mock(ChangeLogService.class),
        mock(DataTypeService.class), mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class),
        logicalFlowDao, mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class),
        mock(FlowPermissionChecker.class), mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> logicalFlowService.findAllByFlowIds(new ArrayList<>()));
    verify(logicalFlowDao).findAllByFlowIds(isA(Collection.class));
  }

  /**
   * Method under test: {@link LogicalFlowService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.getByFlowId(anyLong())).thenReturn(null);

    // Act
    LogicalFlow actualById = (new LogicalFlowService(mock(ChangeLogService.class), mock(DataTypeService.class),
        mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class), logicalFlowDao,
        mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class), mock(FlowPermissionChecker.class),
        mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class))).getById(1L);

    // Assert
    verify(logicalFlowDao).getByFlowId(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test: {@link LogicalFlowService#getById(long)}
   */
  @Test
  void testGetById2() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.getByFlowId(anyLong())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new LogicalFlowService(mock(ChangeLogService.class), mock(DataTypeService.class),
            mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class), logicalFlowDao,
            mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class), mock(FlowPermissionChecker.class),
            mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
            mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
            mock(RatingSchemeService.class))).getById(1L));
    verify(logicalFlowDao).getByFlowId(eq(1L));
  }

  /**
   * Method under test: {@link LogicalFlowService#getByExternalId(String)}
   */
  @Test
  void testGetByExternalId() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.getByFlowExternalId(Mockito.<String>any())).thenReturn(null);

    // Act
    LogicalFlow actualByExternalId = (new LogicalFlowService(mock(ChangeLogService.class), mock(DataTypeService.class),
        mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class), logicalFlowDao,
        mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class), mock(FlowPermissionChecker.class),
        mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class))).getByExternalId("42");

    // Assert
    verify(logicalFlowDao).getByFlowExternalId(eq("42"));
    assertNull(actualByExternalId);
  }

  /**
   * Method under test: {@link LogicalFlowService#getByExternalId(String)}
   */
  @Test
  void testGetByExternalId2() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.getByFlowExternalId(Mockito.<String>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new LogicalFlowService(mock(ChangeLogService.class), mock(DataTypeService.class),
            mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class), logicalFlowDao,
            mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class), mock(FlowPermissionChecker.class),
            mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
            mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
            mock(RatingSchemeService.class))).getByExternalId("42"));
    verify(logicalFlowDao).getByFlowExternalId(eq("42"));
  }

  /**
   * Method under test:
   * {@link LogicalFlowService#findBySelector(IdSelectionOptions)}
   */
  @Test
  void testFindBySelector() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    ArrayList<LogicalFlow> logicalFlowList = new ArrayList<>();
    when(logicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(logicalFlowList);
    LogicalFlowService logicalFlowService = new LogicalFlowService(mock(ChangeLogService.class),
        mock(DataTypeService.class), mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class),
        logicalFlowDao, mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class),
        mock(FlowPermissionChecker.class), mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<LogicalFlow> actualFindBySelectorResult = logicalFlowService.findBySelector(options);

    // Assert
    verify(logicalFlowDao).findBySelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(logicalFlowList, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link LogicalFlowService#findBySelector(IdSelectionOptions)}
   */
  @Test
  void testFindBySelector2() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    ArrayList<LogicalFlow> logicalFlowList = new ArrayList<>();
    when(logicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(logicalFlowList);
    LogicalFlowService logicalFlowService = new LogicalFlowService(mock(ChangeLogService.class),
        mock(DataTypeService.class), mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class),
        logicalFlowDao, mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class),
        mock(FlowPermissionChecker.class), mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<LogicalFlow> actualFindBySelectorResult = logicalFlowService.findBySelector(options);

    // Assert
    verify(logicalFlowDao).findBySelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(logicalFlowList, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link LogicalFlowService#addFlow(AddLogicalFlowCommand, String)}
   */
  @Test
  void testAddFlow() {
    // Arrange
    LogicalFlowService logicalFlowService = new LogicalFlowService(mock(ChangeLogService.class),
        mock(DataTypeService.class), mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class),
        mock(LogicalFlowDao.class), mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class),
        mock(FlowPermissionChecker.class), mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenReturn(1L);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    AddLogicalFlowCommand addCmd = mock(AddLogicalFlowCommand.class);
    when(addCmd.target()).thenReturn(entityReference2);
    when(addCmd.source()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> logicalFlowService.addFlow(addCmd, "janedoe"));
    verify(entityReference2).id();
    verify(entityReference).id();
    verify(entityReference2).kind();
    verify(entityReference).kind();
    verify(addCmd, atLeast(1)).source();
    verify(addCmd, atLeast(1)).target();
  }

  /**
   * Method under test:
   * {@link LogicalFlowService#addFlow(AddLogicalFlowCommand, String)}
   */
  @Test
  void testAddFlow2() {
    // Arrange
    LogicalFlowService logicalFlowService = new LogicalFlowService(mock(ChangeLogService.class),
        mock(DataTypeService.class), mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class),
        mock(LogicalFlowDao.class), mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class),
        mock(FlowPermissionChecker.class), mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenThrow(new IllegalArgumentException("source"));
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenReturn(1L);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    AddLogicalFlowCommand addCmd = mock(AddLogicalFlowCommand.class);
    when(addCmd.target()).thenReturn(entityReference2);
    when(addCmd.source()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> logicalFlowService.addFlow(addCmd, "janedoe"));
    verify(entityReference).id();
    verify(entityReference2).kind();
    verify(entityReference).kind();
    verify(addCmd, atLeast(1)).source();
    verify(addCmd).target();
  }

  /**
   * Method under test:
   * {@link LogicalFlowService#addFlow(AddLogicalFlowCommand, String)}
   */
  @Test
  void testAddFlow3() {
    // Arrange
    DataTypeService dataTypeService = mock(DataTypeService.class);
    when(dataTypeService.getUnknownDataType()).thenThrow(new IllegalArgumentException("source"));
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.addFlow(Mockito.<LogicalFlow>any())).thenReturn(null);
    LogicalFlowService logicalFlowService = new LogicalFlowService(mock(ChangeLogService.class), dataTypeService,
        mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class), logicalFlowDao,
        mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class), mock(FlowPermissionChecker.class),
        mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenReturn(0L);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    AddLogicalFlowCommand addCmd = mock(AddLogicalFlowCommand.class);
    when(addCmd.target()).thenReturn(entityReference2);
    when(addCmd.source()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> logicalFlowService.addFlow(addCmd, "janedoe"));
    verify(logicalFlowDao).addFlow(isA(LogicalFlow.class));
    verify(entityReference2).id();
    verify(entityReference).id();
    verify(entityReference2).kind();
    verify(entityReference).kind();
    verify(addCmd, atLeast(1)).source();
    verify(addCmd, atLeast(1)).target();
    verify(dataTypeService).getUnknownDataType();
  }

  /**
   * Method under test:
   * {@link LogicalFlowService#addFlow(AddLogicalFlowCommand, String)}
   */
  @Test
  void testAddFlow4() {
    // Arrange
    DataTypeService dataTypeService = mock(DataTypeService.class);
    when(dataTypeService.getUnknownDataType()).thenThrow(new IllegalArgumentException("source"));
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.addFlow(Mockito.<LogicalFlow>any())).thenReturn(null);
    LogicalFlowService logicalFlowService = new LogicalFlowService(mock(ChangeLogService.class), dataTypeService,
        mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class), logicalFlowDao,
        mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class), mock(FlowPermissionChecker.class),
        mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenReturn(1L);
    when(entityReference2.kind()).thenReturn(EntityKind.ACTOR);
    AddLogicalFlowCommand addCmd = mock(AddLogicalFlowCommand.class);
    when(addCmd.target()).thenReturn(entityReference2);
    when(addCmd.source()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> logicalFlowService.addFlow(addCmd, "janedoe"));
    verify(logicalFlowDao).addFlow(isA(LogicalFlow.class));
    verify(entityReference2).id();
    verify(entityReference).id();
    verify(entityReference2).kind();
    verify(entityReference).kind();
    verify(addCmd, atLeast(1)).source();
    verify(addCmd, atLeast(1)).target();
    verify(dataTypeService).getUnknownDataType();
  }

  /**
   * Method under test: {@link LogicalFlowService#addFlows(Collection, String)}
   */
  @Test
  void testAddFlows() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    HashSet<LogicalFlow> logicalFlowSet = new HashSet<>();
    when(logicalFlowDao.addFlows(Mockito.<Set<LogicalFlow>>any(), Mockito.<String>any())).thenReturn(logicalFlowSet);
    LogicalFlowService logicalFlowService = new LogicalFlowService(changeLogService, mock(DataTypeService.class),
        mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class), logicalFlowDao,
        mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class), mock(FlowPermissionChecker.class),
        mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class));

    // Act
    Set<LogicalFlow> actualAddFlowsResult = logicalFlowService.addFlows(new ArrayList<>(), "janedoe");

    // Assert
    verify(logicalFlowDao).addFlows(isA(Set.class), eq("janedoe"));
    verify(changeLogService).write(isA(Collection.class));
    assertTrue(actualAddFlowsResult.isEmpty());
    assertSame(logicalFlowSet, actualAddFlowsResult);
  }

  /**
   * Method under test: {@link LogicalFlowService#addFlows(Collection, String)}
   */
  @Test
  void testAddFlows2() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.addFlows(Mockito.<Set<LogicalFlow>>any(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    LogicalFlowService logicalFlowService = new LogicalFlowService(changeLogService, mock(DataTypeService.class),
        mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class), logicalFlowDao,
        mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class), mock(FlowPermissionChecker.class),
        mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> logicalFlowService.addFlows(new ArrayList<>(), "janedoe"));
    verify(logicalFlowDao).addFlows(isA(Set.class), eq("janedoe"));
    verify(changeLogService).write(isA(Collection.class));
  }

  /**
   * Method under test: {@link LogicalFlowService#addFlows(Collection, String)}
   */
  @Test
  void testAddFlows3() {
    // Arrange
    LogicalFlowService logicalFlowService = new LogicalFlowService(mock(ChangeLogService.class),
        mock(DataTypeService.class), mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class),
        mock(LogicalFlowDao.class), mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class),
        mock(FlowPermissionChecker.class), mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class));
    AddLogicalFlowCommand addLogicalFlowCommand = mock(AddLogicalFlowCommand.class);
    when(addLogicalFlowCommand.source()).thenReturn(null);
    AddLogicalFlowCommand addLogicalFlowCommand2 = mock(AddLogicalFlowCommand.class);
    when(addLogicalFlowCommand2.source()).thenReturn(null);
    AddLogicalFlowCommand addLogicalFlowCommand3 = mock(AddLogicalFlowCommand.class);
    when(addLogicalFlowCommand3.source()).thenThrow(new IllegalArgumentException("foo"));

    ArrayList<AddLogicalFlowCommand> addCmds = new ArrayList<>();
    addCmds.add(addLogicalFlowCommand3);
    addCmds.add(addLogicalFlowCommand2);
    addCmds.add(addLogicalFlowCommand);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> logicalFlowService.addFlows(addCmds, "janedoe"));
    verify(addLogicalFlowCommand3).source();
  }

  /**
   * Method under test:
   * {@link LogicalFlowService#updateReadOnly(long, boolean, String)}
   */
  @Test
  void testUpdateReadOnly() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.getByFlowId(anyLong())).thenReturn(null);

    // Act
    LogicalFlow actualUpdateReadOnlyResult = (new LogicalFlowService(mock(ChangeLogService.class),
        mock(DataTypeService.class), mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class),
        logicalFlowDao, mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class),
        mock(FlowPermissionChecker.class), mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class))).updateReadOnly(1L, true, "User");

    // Assert
    verify(logicalFlowDao).getByFlowId(eq(1L));
    assertNull(actualUpdateReadOnlyResult);
  }

  /**
   * Method under test:
   * {@link LogicalFlowService#updateReadOnly(long, boolean, String)}
   */
  @Test
  void testUpdateReadOnly2() {
    // Arrange
    LogicalFlow logicalFlow = mock(LogicalFlow.class);
    when(logicalFlow.isReadOnly()).thenReturn(true);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.getByFlowId(anyLong())).thenReturn(logicalFlow);

    // Act
    (new LogicalFlowService(mock(ChangeLogService.class), mock(DataTypeService.class), mock(DataTypeUsageService.class),
        mock(DBExecutorPoolInterface.class), logicalFlowDao, mock(LogicalFlowStatsDao.class),
        mock(LogicalFlowDecoratorDao.class), mock(FlowPermissionChecker.class), mock(PhysicalSpecDecoratorDao.class),
        mock(AssessmentRatingService.class), mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class),
        mock(PhysicalSpecificationDao.class), mock(RatingSchemeService.class))).updateReadOnly(1L, true, "User");

    // Assert
    verify(logicalFlowDao).getByFlowId(eq(1L));
    verify(logicalFlow).isReadOnly();
  }

  /**
   * Method under test:
   * {@link LogicalFlowService#updateReadOnly(long, boolean, String)}
   */
  @Test
  void testUpdateReadOnly3() {
    // Arrange
    LogicalFlow logicalFlow = mock(LogicalFlow.class);
    when(logicalFlow.isReadOnly()).thenThrow(new UnsupportedOperationException("foo"));
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.getByFlowId(anyLong())).thenReturn(logicalFlow);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new LogicalFlowService(mock(ChangeLogService.class), mock(DataTypeService.class),
            mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class), logicalFlowDao,
            mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class), mock(FlowPermissionChecker.class),
            mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
            mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
            mock(RatingSchemeService.class))).updateReadOnly(1L, true, "User"));
    verify(logicalFlowDao).getByFlowId(eq(1L));
    verify(logicalFlow).isReadOnly();
  }

  /**
   * Method under test:
   * {@link LogicalFlowService#updateReadOnly(long, boolean, String)}
   */
  @Test
  void testUpdateReadOnly4() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    LogicalFlow logicalFlow = mock(LogicalFlow.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(logicalFlow.id()).thenReturn(ofResult);
    when(logicalFlow.isReadOnly()).thenReturn(false);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.updateReadOnly(anyLong(), anyBoolean(), Mockito.<String>any())).thenReturn(1L);
    when(logicalFlowDao.getByFlowId(anyLong())).thenReturn(logicalFlow);

    // Act
    (new LogicalFlowService(changeLogService, mock(DataTypeService.class), mock(DataTypeUsageService.class),
        mock(DBExecutorPoolInterface.class), logicalFlowDao, mock(LogicalFlowStatsDao.class),
        mock(LogicalFlowDecoratorDao.class), mock(FlowPermissionChecker.class), mock(PhysicalSpecDecoratorDao.class),
        mock(AssessmentRatingService.class), mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class),
        mock(PhysicalSpecificationDao.class), mock(RatingSchemeService.class))).updateReadOnly(1L, true, "User");

    // Assert
    verify(logicalFlowDao, atLeast(1)).getByFlowId(eq(1L));
    verify(logicalFlowDao).updateReadOnly(eq(1L), eq(true), eq("User"));
    verify(logicalFlow, atLeast(1)).id();
    verify(logicalFlow).isReadOnly();
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Method under test:
   * {@link LogicalFlowService#updateReadOnly(long, boolean, String)}
   */
  @Test
  void testUpdateReadOnly5() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenThrow(new IllegalArgumentException("kind"));
    LogicalFlow logicalFlow = mock(LogicalFlow.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(logicalFlow.id()).thenReturn(ofResult);
    when(logicalFlow.isReadOnly()).thenReturn(false);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.updateReadOnly(anyLong(), anyBoolean(), Mockito.<String>any())).thenReturn(1L);
    when(logicalFlowDao.getByFlowId(anyLong())).thenReturn(logicalFlow);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new LogicalFlowService(changeLogService, mock(DataTypeService.class), mock(DataTypeUsageService.class),
            mock(DBExecutorPoolInterface.class), logicalFlowDao, mock(LogicalFlowStatsDao.class),
            mock(LogicalFlowDecoratorDao.class), mock(FlowPermissionChecker.class),
            mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
            mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
            mock(RatingSchemeService.class))).updateReadOnly(1L, true, "User"));
    verify(logicalFlowDao, atLeast(1)).getByFlowId(eq(1L));
    verify(logicalFlowDao).updateReadOnly(eq(1L), eq(true), eq("User"));
    verify(logicalFlow, atLeast(1)).id();
    verify(logicalFlow).isReadOnly();
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Method under test: {@link LogicalFlowService#removeFlow(Long, String)}
   */
  @Test
  void testRemoveFlow() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.getByFlowId(anyLong())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new LogicalFlowService(mock(ChangeLogService.class), mock(DataTypeService.class),
            mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class), logicalFlowDao,
            mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class), mock(FlowPermissionChecker.class),
            mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
            mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
            mock(RatingSchemeService.class))).removeFlow(1L, "janedoe"));
    verify(logicalFlowDao).getByFlowId(eq(1L));
  }

  /**
   * Method under test: {@link LogicalFlowService#removeFlow(Long, String)}
   */
  @Test
  void testRemoveFlow2() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    doNothing().when(changeLogService)
        .writeChangeLogEntries(Mockito.<LogicalFlow>any(), Mockito.<String>any(), Mockito.<String>any(),
            Mockito.<Operation>any());
    DataTypeService dataTypeService = mock(DataTypeService.class);
    when(dataTypeService.findByIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(new ArrayList<>());
    DataTypeUsageService dataTypeUsageService = mock(DataTypeUsageService.class);
    when(dataTypeUsageService.recalculateForApplications(Mockito.<Collection<EntityReference>>any())).thenReturn(true);
    LogicalFlow logicalFlow = mock(LogicalFlow.class);
    when(logicalFlow.source()).thenReturn(null);
    when(logicalFlow.target()).thenReturn(null);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.removeFlow(Mockito.<Long>any(), Mockito.<String>any())).thenReturn(1);
    when(logicalFlowDao.getByFlowId(anyLong())).thenReturn(logicalFlow);

    // Act
    int actualRemoveFlowResult = (new LogicalFlowService(changeLogService, dataTypeService, dataTypeUsageService,
        mock(DBExecutorPoolInterface.class), logicalFlowDao, mock(LogicalFlowStatsDao.class),
        mock(LogicalFlowDecoratorDao.class), mock(FlowPermissionChecker.class), mock(PhysicalSpecDecoratorDao.class),
        mock(AssessmentRatingService.class), mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class),
        mock(PhysicalSpecificationDao.class), mock(RatingSchemeService.class))).removeFlow(1L, "janedoe");

    // Assert
    verify(logicalFlowDao).getByFlowId(eq(1L));
    verify(logicalFlowDao).removeFlow(eq(1L), eq("janedoe"));
    verify(logicalFlow).source();
    verify(logicalFlow).target();
    verify(changeLogService).writeChangeLogEntries(isA(LogicalFlow.class), eq("janedoe"), eq("Removed : datatypes []"),
        eq(Operation.REMOVE));
    verify(dataTypeService).findByIdSelector(isA(Select.class));
    verify(dataTypeUsageService).recalculateForApplications(isA(Collection.class));
    assertEquals(1, actualRemoveFlowResult);
  }

  /**
   * Method under test: {@link LogicalFlowService#removeFlow(Long, String)}
   */
  @Test
  void testRemoveFlow3() {
    // Arrange
    LogicalFlow logicalFlow = mock(LogicalFlow.class);
    when(logicalFlow.source()).thenThrow(new UnsupportedOperationException("Removed : datatypes ["));
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.removeFlow(Mockito.<Long>any(), Mockito.<String>any())).thenReturn(1);
    when(logicalFlowDao.getByFlowId(anyLong())).thenReturn(logicalFlow);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new LogicalFlowService(mock(ChangeLogService.class), mock(DataTypeService.class),
            mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class), logicalFlowDao,
            mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class), mock(FlowPermissionChecker.class),
            mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
            mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
            mock(RatingSchemeService.class))).removeFlow(1L, "janedoe"));
    verify(logicalFlowDao).getByFlowId(eq(1L));
    verify(logicalFlowDao).removeFlow(eq(1L), eq("janedoe"));
    verify(logicalFlow).source();
  }

  /**
   * Method under test:
   * {@link LogicalFlowService#calculateStats(IdSelectionOptions)}
   */
  @Test
  void testCalculateStats() {
    // Arrange
    LogicalFlowService logicalFlowService = new LogicalFlowService(mock(ChangeLogService.class),
        mock(DataTypeService.class), mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class),
        mock(LogicalFlowDao.class), mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class),
        mock(FlowPermissionChecker.class), mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> logicalFlowService.calculateStats(options));
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
  }

  /**
   * Method under test: {@link LogicalFlowService#restoreFlow(long, String)}
   */
  @Test
  void testRestoreFlow() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    doNothing().when(changeLogService)
        .writeChangeLogEntries(Mockito.<EntityReference>any(), Mockito.<String>any(), Mockito.<String>any(),
            Mockito.<Operation>any());
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.restoreFlow(anyLong(), Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualRestoreFlowResult = (new LogicalFlowService(changeLogService, mock(DataTypeService.class),
        mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class), logicalFlowDao,
        mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class), mock(FlowPermissionChecker.class),
        mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class))).restoreFlow(1L, "janedoe");

    // Assert
    verify(logicalFlowDao).restoreFlow(eq(1L), eq("janedoe"));
    verify(changeLogService).writeChangeLogEntries(isA(EntityReference.class), eq("janedoe"), eq("Restored"),
        eq(Operation.ADD));
    assertTrue(actualRestoreFlowResult);
  }

  /**
   * Method under test: {@link LogicalFlowService#restoreFlow(long, String)}
   */
  @Test
  void testRestoreFlow2() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    doThrow(new IllegalArgumentException("kind")).when(changeLogService)
        .writeChangeLogEntries(Mockito.<EntityReference>any(), Mockito.<String>any(), Mockito.<String>any(),
            Mockito.<Operation>any());
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.restoreFlow(anyLong(), Mockito.<String>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new LogicalFlowService(changeLogService, mock(DataTypeService.class), mock(DataTypeUsageService.class),
            mock(DBExecutorPoolInterface.class), logicalFlowDao, mock(LogicalFlowStatsDao.class),
            mock(LogicalFlowDecoratorDao.class), mock(FlowPermissionChecker.class),
            mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
            mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
            mock(RatingSchemeService.class))).restoreFlow(1L, "janedoe"));
    verify(logicalFlowDao).restoreFlow(eq(1L), eq("janedoe"));
    verify(changeLogService).writeChangeLogEntries(isA(EntityReference.class), eq("janedoe"), eq("Restored"),
        eq(Operation.ADD));
  }

  /**
   * Method under test: {@link LogicalFlowService#restoreFlow(long, String)}
   */
  @Test
  void testRestoreFlow3() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.restoreFlow(anyLong(), Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualRestoreFlowResult = (new LogicalFlowService(mock(ChangeLogService.class), mock(DataTypeService.class),
        mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class), logicalFlowDao,
        mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class), mock(FlowPermissionChecker.class),
        mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class))).restoreFlow(1L, "janedoe");

    // Assert
    verify(logicalFlowDao).restoreFlow(eq(1L), eq("janedoe"));
    assertFalse(actualRestoreFlowResult);
  }

  /**
   * Method under test: {@link LogicalFlowService#cleanupOrphans()}
   */
  @Test
  void testCleanupOrphans() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.cleanupOrphans()).thenReturn(1);

    // Act
    Integer actualCleanupOrphansResult = (new LogicalFlowService(mock(ChangeLogService.class),
        mock(DataTypeService.class), mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class),
        logicalFlowDao, mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class),
        mock(FlowPermissionChecker.class), mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class))).cleanupOrphans();

    // Assert
    verify(logicalFlowDao).cleanupOrphans();
    assertEquals(1, actualCleanupOrphansResult.intValue());
  }

  /**
   * Method under test: {@link LogicalFlowService#cleanupOrphans()}
   */
  @Test
  void testCleanupOrphans2() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.cleanupOrphans()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new LogicalFlowService(mock(ChangeLogService.class), mock(DataTypeService.class),
            mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class), logicalFlowDao,
            mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class), mock(FlowPermissionChecker.class),
            mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
            mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
            mock(RatingSchemeService.class))).cleanupOrphans());
    verify(logicalFlowDao).cleanupOrphans();
  }

  /**
   * Method under test: {@link LogicalFlowService#cleanupSelfReferencingFlows()}
   */
  @Test
  void testCleanupSelfReferencingFlows() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.cleanupSelfReferencingFlows()).thenReturn(1);

    // Act
    int actualCleanupSelfReferencingFlowsResult = (new LogicalFlowService(mock(ChangeLogService.class),
        mock(DataTypeService.class), mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class),
        logicalFlowDao, mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class),
        mock(FlowPermissionChecker.class), mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class))).cleanupSelfReferencingFlows();

    // Assert
    verify(logicalFlowDao).cleanupSelfReferencingFlows();
    assertEquals(1, actualCleanupSelfReferencingFlowsResult);
  }

  /**
   * Method under test: {@link LogicalFlowService#cleanupSelfReferencingFlows()}
   */
  @Test
  void testCleanupSelfReferencingFlows2() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.cleanupSelfReferencingFlows()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new LogicalFlowService(mock(ChangeLogService.class), mock(DataTypeService.class),
            mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class), logicalFlowDao,
            mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class), mock(FlowPermissionChecker.class),
            mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
            mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
            mock(RatingSchemeService.class))).cleanupSelfReferencingFlows());
    verify(logicalFlowDao).cleanupSelfReferencingFlows();
  }

  /**
   * Method under test:
   * {@link LogicalFlowService#findUpstreamFlowsForEntityReferences(List)}
   */
  @Test
  void testFindUpstreamFlowsForEntityReferences() {
    // Arrange
    LogicalFlowService logicalFlowService = new LogicalFlowService(mock(ChangeLogService.class),
        mock(DataTypeService.class), mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class),
        mock(LogicalFlowDao.class), mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class),
        mock(FlowPermissionChecker.class), mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class));

    // Act
    Collection<LogicalFlow> actualFindUpstreamFlowsForEntityReferencesResult = logicalFlowService
        .findUpstreamFlowsForEntityReferences(new ArrayList<>());

    // Assert
    assertTrue(actualFindUpstreamFlowsForEntityReferencesResult instanceof List);
    assertTrue(actualFindUpstreamFlowsForEntityReferencesResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link LogicalFlowService#findUpstreamFlowsForEntityReferences(List)}
   */
  @Test
  void testFindUpstreamFlowsForEntityReferences2() {
    // Arrange and Act
    Collection<LogicalFlow> actualFindUpstreamFlowsForEntityReferencesResult = (new LogicalFlowService(
        mock(ChangeLogService.class), mock(DataTypeService.class), mock(DataTypeUsageService.class),
        mock(DBExecutorPoolInterface.class), mock(LogicalFlowDao.class), mock(LogicalFlowStatsDao.class),
        mock(LogicalFlowDecoratorDao.class), mock(FlowPermissionChecker.class), mock(PhysicalSpecDecoratorDao.class),
        mock(AssessmentRatingService.class), mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class),
        mock(PhysicalSpecificationDao.class), mock(RatingSchemeService.class)))
            .findUpstreamFlowsForEntityReferences(null);

    // Assert
    assertTrue(actualFindUpstreamFlowsForEntityReferencesResult instanceof List);
    assertTrue(actualFindUpstreamFlowsForEntityReferencesResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link LogicalFlowService#findUpstreamFlowsForEntityReferences(List)}
   */
  @Test
  void testFindUpstreamFlowsForEntityReferences3() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    ArrayList<LogicalFlow> logicalFlowList = new ArrayList<>();
    when(logicalFlowDao.findUpstreamFlowsForEntityReferences(Mockito.<List<EntityReference>>any()))
        .thenReturn(logicalFlowList);
    LogicalFlowService logicalFlowService = new LogicalFlowService(mock(ChangeLogService.class),
        mock(DataTypeService.class), mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class),
        logicalFlowDao, mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class),
        mock(FlowPermissionChecker.class), mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class));

    ArrayList<EntityReference> references = new ArrayList<>();
    references.add(mock(EntityReference.class));

    // Act
    Collection<LogicalFlow> actualFindUpstreamFlowsForEntityReferencesResult = logicalFlowService
        .findUpstreamFlowsForEntityReferences(references);

    // Assert
    verify(logicalFlowDao).findUpstreamFlowsForEntityReferences(isA(List.class));
    assertTrue(actualFindUpstreamFlowsForEntityReferencesResult instanceof List);
    assertTrue(actualFindUpstreamFlowsForEntityReferencesResult.isEmpty());
    assertSame(logicalFlowList, actualFindUpstreamFlowsForEntityReferencesResult);
  }

  /**
   * Method under test:
   * {@link LogicalFlowService#findUpstreamFlowsForEntityReferences(List)}
   */
  @Test
  void testFindUpstreamFlowsForEntityReferences4() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    ArrayList<LogicalFlow> logicalFlowList = new ArrayList<>();
    when(logicalFlowDao.findUpstreamFlowsForEntityReferences(Mockito.<List<EntityReference>>any()))
        .thenReturn(logicalFlowList);
    LogicalFlowService logicalFlowService = new LogicalFlowService(mock(ChangeLogService.class),
        mock(DataTypeService.class), mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class),
        logicalFlowDao, mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class),
        mock(FlowPermissionChecker.class), mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class));

    ArrayList<EntityReference> references = new ArrayList<>();
    references.add(mock(EntityReference.class));
    references.add(mock(EntityReference.class));

    // Act
    Collection<LogicalFlow> actualFindUpstreamFlowsForEntityReferencesResult = logicalFlowService
        .findUpstreamFlowsForEntityReferences(references);

    // Assert
    verify(logicalFlowDao).findUpstreamFlowsForEntityReferences(isA(List.class));
    assertTrue(actualFindUpstreamFlowsForEntityReferencesResult instanceof List);
    assertTrue(actualFindUpstreamFlowsForEntityReferencesResult.isEmpty());
    assertSame(logicalFlowList, actualFindUpstreamFlowsForEntityReferencesResult);
  }

  /**
   * Method under test:
   * {@link LogicalFlowService#findUpstreamFlowsForEntityReferences(List)}
   */
  @Test
  void testFindUpstreamFlowsForEntityReferences5() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.findUpstreamFlowsForEntityReferences(Mockito.<List<EntityReference>>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    LogicalFlowService logicalFlowService = new LogicalFlowService(mock(ChangeLogService.class),
        mock(DataTypeService.class), mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class),
        logicalFlowDao, mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class),
        mock(FlowPermissionChecker.class), mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class));

    ArrayList<EntityReference> references = new ArrayList<>();
    references.add(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> logicalFlowService.findUpstreamFlowsForEntityReferences(references));
    verify(logicalFlowDao).findUpstreamFlowsForEntityReferences(isA(List.class));
  }

  /**
   * Method under test:
   * {@link LogicalFlowService#findEditableFlowIdsForParentReference(EntityReference, String)}
   */
  @Test
  void testFindEditableFlowIdsForParentReference() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
    FlowPermissionChecker flowPermissionChecker = mock(FlowPermissionChecker.class);
    when(
        flowPermissionChecker.findFlowPermissionsForParentEntity(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(new HashSet<>());

    // Act
    Set<Long> actualFindEditableFlowIdsForParentReferenceResult = (new LogicalFlowService(mock(ChangeLogService.class),
        mock(DataTypeService.class), mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class),
        logicalFlowDao, mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class), flowPermissionChecker,
        mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class))).findEditableFlowIdsForParentReference(null, "janedoe");

    // Assert
    verify(logicalFlowDao).findByEntityReference(isNull());
    verify(flowPermissionChecker).findFlowPermissionsForParentEntity(isNull(), eq("janedoe"));
    assertTrue(actualFindEditableFlowIdsForParentReferenceResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link LogicalFlowService#findEditableFlowIdsForParentReference(EntityReference, String)}
   */
  @Test
  void testFindEditableFlowIdsForParentReference2() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
    FlowPermissionChecker flowPermissionChecker = mock(FlowPermissionChecker.class);
    when(
        flowPermissionChecker.findFlowPermissionsForParentEntity(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenThrow(new IllegalArgumentException("xs cannot be null"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new LogicalFlowService(mock(ChangeLogService.class), mock(DataTypeService.class),
            mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class), logicalFlowDao,
            mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class), flowPermissionChecker,
            mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
            mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
            mock(RatingSchemeService.class))).findEditableFlowIdsForParentReference(null, "janedoe"));
    verify(logicalFlowDao).findByEntityReference(isNull());
    verify(flowPermissionChecker).findFlowPermissionsForParentEntity(isNull(), eq("janedoe"));
  }

  /**
   * Method under test:
   * {@link LogicalFlowService#findEditableFlowIdsForParentReference(EntityReference, String)}
   */
  @Test
  void testFindEditableFlowIdsForParentReference3() {
    // Arrange
    LogicalFlow logicalFlow = mock(LogicalFlow.class);
    when(logicalFlow.source()).thenReturn(null);
    when(logicalFlow.target()).thenReturn(null);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(logicalFlow.id()).thenReturn(ofResult);

    ArrayList<LogicalFlow> logicalFlowList = new ArrayList<>();
    logicalFlowList.add(logicalFlow);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(logicalFlowList);
    FlowPermissionChecker flowPermissionChecker = mock(FlowPermissionChecker.class);
    when(
        flowPermissionChecker.findFlowPermissionsForParentEntity(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(new HashSet<>());

    // Act
    Set<Long> actualFindEditableFlowIdsForParentReferenceResult = (new LogicalFlowService(mock(ChangeLogService.class),
        mock(DataTypeService.class), mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class),
        logicalFlowDao, mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class), flowPermissionChecker,
        mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class))).findEditableFlowIdsForParentReference(null, "janedoe");

    // Assert
    verify(logicalFlowDao).findByEntityReference(isNull());
    verify(logicalFlow, atLeast(1)).id();
    verify(logicalFlow).source();
    verify(logicalFlow).target();
    verify(flowPermissionChecker, atLeast(1)).findFlowPermissionsForParentEntity(isNull(), eq("janedoe"));
    assertTrue(actualFindEditableFlowIdsForParentReferenceResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link LogicalFlowService#findEditableFlowIdsForParentReference(EntityReference, String)}
   */
  @Test
  void testFindEditableFlowIdsForParentReference4() {
    // Arrange
    LogicalFlow logicalFlow = mock(LogicalFlow.class);
    when(logicalFlow.source()).thenThrow(new UnsupportedOperationException("xs cannot be null"));
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(logicalFlow.id()).thenReturn(ofResult);

    ArrayList<LogicalFlow> logicalFlowList = new ArrayList<>();
    logicalFlowList.add(logicalFlow);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(logicalFlowList);
    FlowPermissionChecker flowPermissionChecker = mock(FlowPermissionChecker.class);
    when(
        flowPermissionChecker.findFlowPermissionsForParentEntity(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(new HashSet<>());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new LogicalFlowService(mock(ChangeLogService.class), mock(DataTypeService.class),
            mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class), logicalFlowDao,
            mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class), flowPermissionChecker,
            mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
            mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
            mock(RatingSchemeService.class))).findEditableFlowIdsForParentReference(null, "janedoe"));
    verify(logicalFlowDao).findByEntityReference(isNull());
    verify(logicalFlow).id();
    verify(logicalFlow).source();
    verify(flowPermissionChecker).findFlowPermissionsForParentEntity(isNull(), eq("janedoe"));
  }

  /**
   * Method under test:
   * {@link LogicalFlowService#findEditableFlowIdsForParentReference(EntityReference, String)}
   */
  @Test
  void testFindEditableFlowIdsForParentReference5() {
    // Arrange
    LogicalFlow logicalFlow = mock(LogicalFlow.class);
    when(logicalFlow.source()).thenReturn(null);
    when(logicalFlow.target()).thenReturn(null);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(logicalFlow.id()).thenReturn(ofResult);
    LogicalFlow logicalFlow2 = mock(LogicalFlow.class);
    when(logicalFlow2.source()).thenReturn(null);
    when(logicalFlow2.target()).thenReturn(null);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(logicalFlow2.id()).thenReturn(ofResult2);

    ArrayList<LogicalFlow> logicalFlowList = new ArrayList<>();
    logicalFlowList.add(logicalFlow2);
    logicalFlowList.add(logicalFlow);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(logicalFlowList);
    FlowPermissionChecker flowPermissionChecker = mock(FlowPermissionChecker.class);
    when(
        flowPermissionChecker.findFlowPermissionsForParentEntity(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(new HashSet<>());

    // Act
    Set<Long> actualFindEditableFlowIdsForParentReferenceResult = (new LogicalFlowService(mock(ChangeLogService.class),
        mock(DataTypeService.class), mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class),
        logicalFlowDao, mock(LogicalFlowStatsDao.class), mock(LogicalFlowDecoratorDao.class), flowPermissionChecker,
        mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class))).findEditableFlowIdsForParentReference(null, "janedoe");

    // Assert
    verify(logicalFlowDao).findByEntityReference(isNull());
    verify(logicalFlow2, atLeast(1)).id();
    verify(logicalFlow, atLeast(1)).id();
    verify(logicalFlow2).source();
    verify(logicalFlow).source();
    verify(logicalFlow2).target();
    verify(logicalFlow).target();
    verify(flowPermissionChecker, atLeast(1)).findFlowPermissionsForParentEntity(isNull(), eq("janedoe"));
    assertTrue(actualFindEditableFlowIdsForParentReferenceResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link LogicalFlowService#getFlowInfoByDirection(EntityReference, Long)}
   */
  @Test
  void testGetFlowInfoByDirection() {
    // Arrange
    LogicalFlowStatsDao logicalFlowStatsDao = mock(LogicalFlowStatsDao.class);
    when(logicalFlowStatsDao.getFlowInfoByDirection(Mockito.<EntityReference>any(), Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new LogicalFlowService(mock(ChangeLogService.class), mock(DataTypeService.class),
            mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class), mock(LogicalFlowDao.class),
            logicalFlowStatsDao, mock(LogicalFlowDecoratorDao.class), mock(FlowPermissionChecker.class),
            mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
            mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
            mock(RatingSchemeService.class))).getFlowInfoByDirection(null, 1L));
    verify(logicalFlowStatsDao).getFlowInfoByDirection(isNull(), eq(1L));
  }

  /**
   * Method under test:
   * {@link LogicalFlowService#getFlowInfoByDirection(EntityReference, Long)}
   */
  @Test
  void testGetFlowInfoByDirection2() {
    // Arrange
    DataType dataType = mock(DataType.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(dataType.parentId()).thenReturn(ofResult);
    DataTypeService dataTypeService = mock(DataTypeService.class);
    when(dataTypeService.getDataTypeById(anyLong())).thenReturn(dataType);
    LogicalFlowStatsDao logicalFlowStatsDao = mock(LogicalFlowStatsDao.class);
    when(logicalFlowStatsDao.getFlowInfoByDirection(Mockito.<EntityReference>any(), Mockito.<Long>any()))
        .thenReturn(new HashMap<>());

    // Act
    LogicalFlowGraphSummary actualFlowInfoByDirection = (new LogicalFlowService(mock(ChangeLogService.class),
        dataTypeService, mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class),
        mock(LogicalFlowDao.class), logicalFlowStatsDao, mock(LogicalFlowDecoratorDao.class),
        mock(FlowPermissionChecker.class), mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class))).getFlowInfoByDirection(null, 1L);

    // Assert
    verify(logicalFlowStatsDao).getFlowInfoByDirection(isNull(), eq(1L));
    verify(dataType).parentId();
    verify(dataTypeService, atLeast(1)).getDataTypeById(eq(1L));
    assertTrue(actualFlowInfoByDirection instanceof ImmutableLogicalFlowGraphSummary);
    assertTrue(actualFlowInfoByDirection.flowInfoByDirection().isEmpty());
  }

  /**
   * Method under test:
   * {@link LogicalFlowService#getFlowInfoByDirection(EntityReference, Long)}
   */
  @Test
  void testGetFlowInfoByDirection3() {
    // Arrange
    DataType dataType = mock(DataType.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(dataType.parentId()).thenReturn(ofResult);
    DataTypeService dataTypeService = mock(DataTypeService.class);
    when(dataTypeService.getDataTypeById(anyLong())).thenReturn(dataType);

    HashMap<FlowDirection, Set<FlowInfo>> flowDirectionSetMap = new HashMap<>();
    flowDirectionSetMap.put(FlowDirection.OUTBOUND, new HashSet<>());
    LogicalFlowStatsDao logicalFlowStatsDao = mock(LogicalFlowStatsDao.class);
    when(logicalFlowStatsDao.getFlowInfoByDirection(Mockito.<EntityReference>any(), Mockito.<Long>any()))
        .thenReturn(flowDirectionSetMap);

    // Act
    LogicalFlowGraphSummary actualFlowInfoByDirection = (new LogicalFlowService(mock(ChangeLogService.class),
        dataTypeService, mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class),
        mock(LogicalFlowDao.class), logicalFlowStatsDao, mock(LogicalFlowDecoratorDao.class),
        mock(FlowPermissionChecker.class), mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class))).getFlowInfoByDirection(null, 1L);

    // Assert
    verify(logicalFlowStatsDao).getFlowInfoByDirection(isNull(), eq(1L));
    verify(dataType).parentId();
    verify(dataTypeService, atLeast(1)).getDataTypeById(eq(1L));
    assertTrue(actualFlowInfoByDirection instanceof ImmutableLogicalFlowGraphSummary);
    assertEquals(flowDirectionSetMap, actualFlowInfoByDirection.flowInfoByDirection());
  }

  /**
   * Method under test:
   * {@link LogicalFlowService#getFlowInfoByDirection(EntityReference, Long)}
   */
  @Test
  void testGetFlowInfoByDirection4() {
    // Arrange
    LogicalFlowStatsDao logicalFlowStatsDao = mock(LogicalFlowStatsDao.class);
    when(logicalFlowStatsDao.getFlowInfoByDirection(Mockito.<EntityReference>any(), Mockito.<Long>any()))
        .thenReturn(new HashMap<>());

    // Act
    LogicalFlowGraphSummary actualFlowInfoByDirection = (new LogicalFlowService(mock(ChangeLogService.class),
        mock(DataTypeService.class), mock(DataTypeUsageService.class), mock(DBExecutorPoolInterface.class),
        mock(LogicalFlowDao.class), logicalFlowStatsDao, mock(LogicalFlowDecoratorDao.class),
        mock(FlowPermissionChecker.class), mock(PhysicalSpecDecoratorDao.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(RatingSchemeService.class))).getFlowInfoByDirection(null, null);

    // Assert
    verify(logicalFlowStatsDao).getFlowInfoByDirection(isNull(), isNull());
    assertTrue(actualFlowInfoByDirection instanceof ImmutableLogicalFlowGraphSummary);
    assertNull(actualFlowInfoByDirection.parentDataType());
    assertNull(actualFlowInfoByDirection.startingDataType());
    assertTrue(actualFlowInfoByDirection.flowInfoByDirection().isEmpty());
  }
}
