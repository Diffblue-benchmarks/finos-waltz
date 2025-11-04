package org.finos.waltz.service.measurable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable.MeasurableDao;
import org.finos.waltz.data.measurable.search.MeasurableSearchDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.measurable.Measurable;
import org.finos.waltz.model.measurable.MeasurableHierarchy;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MeasurableServiceDiffblueTest {
  /**
   * Method under test: {@link MeasurableService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    ArrayList<Measurable> measurableList = new ArrayList<>();
    when(measurableDao.findAll()).thenReturn(measurableList);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);

    // Act
    List<Measurable> actualFindAllResult = (new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))).findAll();

    // Assert
    verify(measurableDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(measurableList, actualFindAllResult);
  }

  /**
   * Method under test:
   * {@link MeasurableService#findByMeasurableIdSelector(IdSelectionOptions)}
   */
  @Test
  void testFindByMeasurableIdSelector() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    ArrayList<Measurable> measurableList = new ArrayList<>();
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(measurableList);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<Measurable> actualFindByMeasurableIdSelectorResult = measurableService.findByMeasurableIdSelector(options);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindByMeasurableIdSelectorResult.isEmpty());
    assertSame(measurableList, actualFindByMeasurableIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableService#findByMeasurableIdSelector(IdSelectionOptions)}
   */
  @Test
  void testFindByMeasurableIdSelector2() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    ArrayList<Measurable> measurableList = new ArrayList<>();
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(measurableList);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<Measurable> actualFindByMeasurableIdSelectorResult = measurableService.findByMeasurableIdSelector(options);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindByMeasurableIdSelectorResult.isEmpty());
    assertSame(measurableList, actualFindByMeasurableIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableService#findByMeasurableIdSelector(IdSelectionOptions)}
   */
  @Test
  void testFindByMeasurableIdSelector3() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    ArrayList<Measurable> measurableList = new ArrayList<>();
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(measurableList);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.AGGREGATE_OVERLAY_DIAGRAM);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<Measurable> actualFindByMeasurableIdSelectorResult = measurableService.findByMeasurableIdSelector(options);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isNull());
    verify(entityReference).kind();
    verify(options).entityReference();
    assertTrue(actualFindByMeasurableIdSelectorResult.isEmpty());
    assertSame(measurableList, actualFindByMeasurableIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableService#findByMeasurableIdSelector(IdSelectionOptions)}
   */
  @Test
  void testFindByMeasurableIdSelector4() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    ArrayList<Measurable> measurableList = new ArrayList<>();
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(measurableList);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(options.joiningEntityKind()).thenReturn(ofResult);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<Measurable> actualFindByMeasurableIdSelectorResult = measurableService.findByMeasurableIdSelector(options);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).joiningEntityKind();
    verify(options, atLeast(1)).scope();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    assertTrue(actualFindByMeasurableIdSelectorResult.isEmpty());
    assertSame(measurableList, actualFindByMeasurableIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableService#findByMeasurableIdSelector(IdSelectionOptions)}
   */
  @Test
  void testFindByMeasurableIdSelector5() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    ArrayList<Measurable> measurableList = new ArrayList<>();
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(measurableList);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.CHANGE_INITIATIVE);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<Measurable> actualFindByMeasurableIdSelectorResult = measurableService.findByMeasurableIdSelector(options);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindByMeasurableIdSelectorResult.isEmpty());
    assertSame(measurableList, actualFindByMeasurableIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableService#findByMeasurableIdSelector(IdSelectionOptions)}
   */
  @Test
  void testFindByMeasurableIdSelector6() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    ArrayList<Measurable> measurableList = new ArrayList<>();
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(measurableList);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.CHANGE_INITIATIVE);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.PARENTS);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<Measurable> actualFindByMeasurableIdSelectorResult = measurableService.findByMeasurableIdSelector(options);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindByMeasurableIdSelectorResult.isEmpty());
    assertSame(measurableList, actualFindByMeasurableIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableService#findByRatingIdSelector(IdSelectionOptions)}
   */
  @Test
  void testFindByRatingIdSelector() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    HashSet<Measurable> measurableSet = new HashSet<>();
    when(measurableDao.findByRatingIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(measurableSet);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    Set<Measurable> actualFindByRatingIdSelectorResult = measurableService.findByRatingIdSelector(options);

    // Assert
    verify(measurableDao).findByRatingIdSelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindByRatingIdSelectorResult.isEmpty());
    assertSame(measurableSet, actualFindByRatingIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableService#findByRatingIdSelector(IdSelectionOptions)}
   */
  @Test
  void testFindByRatingIdSelector2() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    HashSet<Measurable> measurableSet = new HashSet<>();
    when(measurableDao.findByRatingIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(measurableSet);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(options.joiningEntityKind()).thenReturn(ofResult);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    Set<Measurable> actualFindByRatingIdSelectorResult = measurableService.findByRatingIdSelector(options);

    // Assert
    verify(measurableDao).findByRatingIdSelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).joiningEntityKind();
    verify(options, atLeast(1)).scope();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    assertTrue(actualFindByRatingIdSelectorResult.isEmpty());
    assertSame(measurableSet, actualFindByRatingIdSelectorResult);
  }

  /**
   * Method under test: {@link MeasurableService#findByCategoryId(Long)}
   */
  @Test
  void testFindByCategoryId() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    ArrayList<Measurable> measurableList = new ArrayList<>();
    when(measurableDao.findByCategoryId(Mockito.<Long>any())).thenReturn(measurableList);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);

    // Act
    List<Measurable> actualFindByCategoryIdResult = (new MeasurableService(measurableDao, measurableSearchDao,
        nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findByCategoryId(1L);

    // Assert
    verify(measurableDao).findByCategoryId(eq(1L));
    assertTrue(actualFindByCategoryIdResult.isEmpty());
    assertSame(measurableList, actualFindByCategoryIdResult);
  }

  /**
   * Method under test: {@link MeasurableService#findByCategoryId(Long, Set)}
   */
  @Test
  void testFindByCategoryId2() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    ArrayList<Measurable> measurableList = new ArrayList<>();
    when(measurableDao.findByCategoryId(Mockito.<Long>any(), Mockito.<Set<EntityLifecycleStatus>>any()))
        .thenReturn(measurableList);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    // Act
    List<Measurable> actualFindByCategoryIdResult = measurableService.findByCategoryId(1L, new HashSet<>());

    // Assert
    verify(measurableDao).findByCategoryId(eq(1L), isA(Set.class));
    assertTrue(actualFindByCategoryIdResult.isEmpty());
    assertSame(measurableList, actualFindByCategoryIdResult);
  }

  /**
   * Method under test: {@link MeasurableService#findByCategoryId(Long, Set)}
   */
  @Test
  void testFindByCategoryId3() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    ArrayList<Measurable> measurableList = new ArrayList<>();
    when(measurableDao.findByCategoryId(Mockito.<Long>any(), Mockito.<Set<EntityLifecycleStatus>>any()))
        .thenReturn(measurableList);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    HashSet<EntityLifecycleStatus> statuses = new HashSet<>();
    statuses.add(EntityLifecycleStatus.ACTIVE);

    // Act
    List<Measurable> actualFindByCategoryIdResult = measurableService.findByCategoryId(1L, statuses);

    // Assert
    verify(measurableDao).findByCategoryId(eq(1L), isA(Set.class));
    assertTrue(actualFindByCategoryIdResult.isEmpty());
    assertSame(measurableList, actualFindByCategoryIdResult);
  }

  /**
   * Method under test: {@link MeasurableService#findByCategoryId(Long, Set)}
   */
  @Test
  void testFindByCategoryId4() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    ArrayList<Measurable> measurableList = new ArrayList<>();
    when(measurableDao.findByCategoryId(Mockito.<Long>any(), Mockito.<Set<EntityLifecycleStatus>>any()))
        .thenReturn(measurableList);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    HashSet<EntityLifecycleStatus> statuses = new HashSet<>();
    statuses.add(EntityLifecycleStatus.PENDING);
    statuses.add(EntityLifecycleStatus.ACTIVE);

    // Act
    List<Measurable> actualFindByCategoryIdResult = measurableService.findByCategoryId(1L, statuses);

    // Assert
    verify(measurableDao).findByCategoryId(eq(1L), isA(Set.class));
    assertTrue(actualFindByCategoryIdResult.isEmpty());
    assertSame(measurableList, actualFindByCategoryIdResult);
  }

  /**
   * Method under test: {@link MeasurableService#findByParentId(Long)}
   */
  @Test
  void testFindByParentId() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    ArrayList<Measurable> measurableList = new ArrayList<>();
    when(measurableDao.findByParentId(Mockito.<Long>any())).thenReturn(measurableList);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);

    // Act
    List<Measurable> actualFindByParentIdResult = (new MeasurableService(measurableDao, measurableSearchDao,
        nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findByParentId(1L);

    // Assert
    verify(measurableDao).findByParentId(eq(1L));
    assertTrue(actualFindByParentIdResult.isEmpty());
    assertSame(measurableList, actualFindByParentIdResult);
  }

  /**
   * Method under test:
   * {@link MeasurableService#findExternalIdToIdMapByCategoryId(Long)}
   */
  @Test
  void testFindExternalIdToIdMapByCategoryId() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    HashMap<String, Long> stringResultLongMap = new HashMap<>();
    when(measurableDao.findExternalIdToIdMapByCategoryId(Mockito.<Long>any())).thenReturn(stringResultLongMap);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);

    // Act
    Map<String, Long> actualFindExternalIdToIdMapByCategoryIdResult = (new MeasurableService(measurableDao,
        measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findExternalIdToIdMapByCategoryId(1L);

    // Assert
    verify(measurableDao).findExternalIdToIdMapByCategoryId(eq(1L));
    assertTrue(actualFindExternalIdToIdMapByCategoryIdResult.isEmpty());
    assertSame(stringResultLongMap, actualFindExternalIdToIdMapByCategoryIdResult);
  }

  /**
   * Method under test: {@link MeasurableService#search(String)}
   */
  @Test
  void testSearch() {
    // Arrange
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    ArrayList<Measurable> measurableList = new ArrayList<>();
    when(measurableSearchDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(measurableList);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);

    // Act
    Collection<Measurable> actualSearchResult = (new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .search("Query");

    // Assert
    verify(measurableSearchDao).search(isA(EntitySearchOptions.class));
    assertTrue(actualSearchResult instanceof List);
    assertTrue(actualSearchResult.isEmpty());
    assertSame(measurableList, actualSearchResult);
  }

  /**
   * Method under test: {@link MeasurableService#search(String)}
   */
  @Test
  void testSearch2() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);

    // Act
    Collection<Measurable> actualSearchResult = (new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))).search("");

    // Assert
    assertTrue(actualSearchResult instanceof List);
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Method under test: {@link MeasurableService#search(EntitySearchOptions)}
   */
  @Test
  void testSearch3() {
    // Arrange
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    ArrayList<Measurable> measurableList = new ArrayList<>();
    when(measurableSearchDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(measurableList);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);

    // Act
    Collection<Measurable> actualSearchResult = (new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .search((EntitySearchOptions) null);

    // Assert
    verify(measurableSearchDao).search(isNull());
    assertTrue(actualSearchResult instanceof List);
    assertTrue(actualSearchResult.isEmpty());
    assertSame(measurableList, actualSearchResult);
  }

  /**
   * Method under test: {@link MeasurableService#findByExternalId(String)}
   */
  @Test
  void testFindByExternalId() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    ArrayList<Measurable> measurableList = new ArrayList<>();
    when(measurableDao.findByExternalId(Mockito.<String>any())).thenReturn(measurableList);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);

    // Act
    Collection<Measurable> actualFindByExternalIdResult = (new MeasurableService(measurableDao, measurableSearchDao,
        nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findByExternalId("42");

    // Assert
    verify(measurableDao).findByExternalId(eq("42"));
    assertTrue(actualFindByExternalIdResult instanceof List);
    assertTrue(actualFindByExternalIdResult.isEmpty());
    assertSame(measurableList, actualFindByExternalIdResult);
  }

  /**
   * Method under test: {@link MeasurableService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.getById(anyLong())).thenReturn(null);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);

    // Act
    Measurable actualById = (new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))).getById(1L);

    // Assert
    verify(measurableDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test: {@link MeasurableService#findByOrgUnitId(Long)}
   */
  @Test
  void testFindByOrgUnitId() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    ArrayList<Measurable> measurableList = new ArrayList<>();
    when(measurableDao.findByOrgUnitId(Mockito.<Long>any())).thenReturn(measurableList);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);

    // Act
    Collection<Measurable> actualFindByOrgUnitIdResult = (new MeasurableService(measurableDao, measurableSearchDao,
        nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findByOrgUnitId(1L);

    // Assert
    verify(measurableDao).findByOrgUnitId(eq(1L));
    assertTrue(actualFindByOrgUnitIdResult instanceof List);
    assertTrue(actualFindByOrgUnitIdResult.isEmpty());
    assertSame(measurableList, actualFindByOrgUnitIdResult);
  }

  /**
   * Method under test:
   * {@link MeasurableService#updateConcreteFlag(Long, boolean, String)}
   */
  @Test
  void testUpdateConcreteFlag() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateConcreteFlag(Mockito.<Long>any(), anyBoolean(), Mockito.<String>any())).thenReturn(true);
    when(measurableDao.getById(anyLong())).thenReturn(null);
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(entityReference);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult2);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    boolean actualUpdateConcreteFlagResult = (new MeasurableService(measurableDao, mock(MeasurableSearchDao.class),
        nameResolver,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .updateConcreteFlag(1L, true, "42");

    // Assert
    verify(nameResolver).resolve(isA(EntityReference.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(measurableDao).getById(eq(1L));
    verify(measurableDao).updateConcreteFlag(eq(1L), eq(true), eq("42"));
    verify(entityReference).name();
    assertTrue(actualUpdateConcreteFlagResult);
  }

  /**
   * Method under test:
   * {@link MeasurableService#updateConcreteFlag(Long, boolean, String)}
   */
  @Test
  void testUpdateConcreteFlag2() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateConcreteFlag(Mockito.<Long>any(), anyBoolean(), Mockito.<String>any())).thenReturn(false);
    when(measurableDao.getById(anyLong())).thenReturn(null);
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(entityReference);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult2);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    boolean actualUpdateConcreteFlagResult = (new MeasurableService(measurableDao, mock(MeasurableSearchDao.class),
        nameResolver,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .updateConcreteFlag(1L, true, "42");

    // Assert
    verify(nameResolver).resolve(isA(EntityReference.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(measurableDao).getById(eq(1L));
    verify(measurableDao).updateConcreteFlag(eq(1L), eq(true), eq("42"));
    verify(entityReference).name();
    assertFalse(actualUpdateConcreteFlagResult);
  }

  /**
   * Method under test:
   * {@link MeasurableService#updateConcreteFlag(Long, boolean, String)}
   */
  @Test
  void testUpdateConcreteFlag3() {
    // Arrange
    Measurable measurable = mock(Measurable.class);
    when(measurable.concrete()).thenReturn(true);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateConcreteFlag(Mockito.<Long>any(), anyBoolean(), Mockito.<String>any())).thenReturn(true);
    when(measurableDao.getById(anyLong())).thenReturn(measurable);
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(entityReference);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult2);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    boolean actualUpdateConcreteFlagResult = (new MeasurableService(measurableDao, mock(MeasurableSearchDao.class),
        nameResolver,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .updateConcreteFlag(1L, true, "42");

    // Assert
    verify(nameResolver).resolve(isA(EntityReference.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(measurableDao).getById(eq(1L));
    verify(measurableDao).updateConcreteFlag(eq(1L), eq(true), eq("42"));
    verify(entityReference).name();
    verify(measurable).concrete();
    assertTrue(actualUpdateConcreteFlagResult);
  }

  /**
   * Method under test:
   * {@link MeasurableService#updateConcreteFlag(Long, boolean, String)}
   */
  @Test
  void testUpdateConcreteFlag4() {
    // Arrange
    Measurable measurable = mock(Measurable.class);
    when(measurable.concrete()).thenReturn(true);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateConcreteFlag(Mockito.<Long>any(), anyBoolean(), Mockito.<String>any())).thenReturn(true);
    when(measurableDao.getById(anyLong())).thenReturn(measurable);
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(entityReference);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult2);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    boolean actualUpdateConcreteFlagResult = (new MeasurableService(measurableDao, mock(MeasurableSearchDao.class),
        nameResolver, changeLogService)).updateConcreteFlag(1L, true, "42");

    // Assert
    verify(nameResolver).resolve(isA(EntityReference.class));
    verify(measurableDao).getById(eq(1L));
    verify(measurableDao).updateConcreteFlag(eq(1L), eq(true), eq("42"));
    verify(entityReference).name();
    verify(measurable).concrete();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateConcreteFlagResult);
  }

  /**
   * Method under test: {@link MeasurableService#updateName(long, String, String)}
   */
  @Test
  void testUpdateName() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateName(anyLong(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(true);
    when(measurableDao.getById(anyLong())).thenReturn(null);
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(entityReference);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult2);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    boolean actualUpdateNameResult = (new MeasurableService(measurableDao, mock(MeasurableSearchDao.class),
        nameResolver,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .updateName(1L, "42", "42");

    // Assert
    verify(nameResolver).resolve(isA(EntityReference.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(measurableDao).getById(eq(1L));
    verify(measurableDao).updateName(eq(1L), eq("42"), eq("42"));
    verify(entityReference).name();
    assertTrue(actualUpdateNameResult);
  }

  /**
   * Method under test: {@link MeasurableService#updateName(long, String, String)}
   */
  @Test
  void testUpdateName2() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateName(anyLong(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(false);
    when(measurableDao.getById(anyLong())).thenReturn(null);
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(entityReference);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult2);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    boolean actualUpdateNameResult = (new MeasurableService(measurableDao, mock(MeasurableSearchDao.class),
        nameResolver,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .updateName(1L, "42", "42");

    // Assert
    verify(nameResolver).resolve(isA(EntityReference.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(measurableDao).getById(eq(1L));
    verify(measurableDao).updateName(eq(1L), eq("42"), eq("42"));
    verify(entityReference).name();
    assertFalse(actualUpdateNameResult);
  }

  /**
   * Method under test: {@link MeasurableService#updateName(long, String, String)}
   */
  @Test
  void testUpdateName3() {
    // Arrange
    Measurable measurable = mock(Measurable.class);
    when(measurable.name()).thenReturn("Name");
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateName(anyLong(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(true);
    when(measurableDao.getById(anyLong())).thenReturn(measurable);
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(entityReference);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult2);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    boolean actualUpdateNameResult = (new MeasurableService(measurableDao, mock(MeasurableSearchDao.class),
        nameResolver,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .updateName(1L, "42", "42");

    // Assert
    verify(nameResolver).resolve(isA(EntityReference.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(measurableDao).getById(eq(1L));
    verify(measurableDao).updateName(eq(1L), eq("42"), eq("42"));
    verify(entityReference).name();
    verify(measurable).name();
    assertTrue(actualUpdateNameResult);
  }

  /**
   * Method under test: {@link MeasurableService#updateName(long, String, String)}
   */
  @Test
  void testUpdateName4() {
    // Arrange
    Measurable measurable = mock(Measurable.class);
    when(measurable.name()).thenReturn("Name");
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateName(anyLong(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(true);
    when(measurableDao.getById(anyLong())).thenReturn(measurable);
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(entityReference);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult2);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    boolean actualUpdateNameResult = (new MeasurableService(measurableDao, mock(MeasurableSearchDao.class),
        nameResolver, changeLogService)).updateName(1L, "42", "42");

    // Assert
    verify(nameResolver).resolve(isA(EntityReference.class));
    verify(measurableDao).getById(eq(1L));
    verify(measurableDao).updateName(eq(1L), eq("42"), eq("42"));
    verify(entityReference).name();
    verify(measurable).name();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateNameResult);
  }

  /**
   * Method under test:
   * {@link MeasurableService#updateDescription(long, String, String)}
   */
  @Test
  void testUpdateDescription() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateDescription(anyLong(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(true);
    when(measurableDao.getById(anyLong())).thenReturn(null);
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(entityReference);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult2);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    boolean actualUpdateDescriptionResult = (new MeasurableService(measurableDao, mock(MeasurableSearchDao.class),
        nameResolver,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .updateDescription(1L, "42", "42");

    // Assert
    verify(nameResolver).resolve(isA(EntityReference.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(measurableDao).getById(eq(1L));
    verify(measurableDao).updateDescription(eq(1L), eq("42"), eq("42"));
    verify(entityReference).name();
    assertTrue(actualUpdateDescriptionResult);
  }

  /**
   * Method under test:
   * {@link MeasurableService#updateDescription(long, String, String)}
   */
  @Test
  void testUpdateDescription2() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateDescription(anyLong(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(false);
    when(measurableDao.getById(anyLong())).thenReturn(null);
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(entityReference);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult2);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    boolean actualUpdateDescriptionResult = (new MeasurableService(measurableDao, mock(MeasurableSearchDao.class),
        nameResolver,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .updateDescription(1L, "42", "42");

    // Assert
    verify(nameResolver).resolve(isA(EntityReference.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(measurableDao).getById(eq(1L));
    verify(measurableDao).updateDescription(eq(1L), eq("42"), eq("42"));
    verify(entityReference).name();
    assertFalse(actualUpdateDescriptionResult);
  }

  /**
   * Method under test:
   * {@link MeasurableService#updateDescription(long, String, String)}
   */
  @Test
  void testUpdateDescription3() {
    // Arrange
    Measurable measurable = mock(Measurable.class);
    when(measurable.description()).thenReturn("The characteristics of someone or something");
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateDescription(anyLong(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(true);
    when(measurableDao.getById(anyLong())).thenReturn(measurable);
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(entityReference);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult2);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    boolean actualUpdateDescriptionResult = (new MeasurableService(measurableDao, mock(MeasurableSearchDao.class),
        nameResolver,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .updateDescription(1L, "42", "42");

    // Assert
    verify(nameResolver).resolve(isA(EntityReference.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(measurableDao).getById(eq(1L));
    verify(measurableDao).updateDescription(eq(1L), eq("42"), eq("42"));
    verify(measurable).description();
    verify(entityReference).name();
    assertTrue(actualUpdateDescriptionResult);
  }

  /**
   * Method under test:
   * {@link MeasurableService#updateDescription(long, String, String)}
   */
  @Test
  void testUpdateDescription4() {
    // Arrange
    Measurable measurable = mock(Measurable.class);
    when(measurable.description()).thenReturn("The characteristics of someone or something");
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateDescription(anyLong(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(true);
    when(measurableDao.getById(anyLong())).thenReturn(measurable);
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(entityReference);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult2);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    boolean actualUpdateDescriptionResult = (new MeasurableService(measurableDao, mock(MeasurableSearchDao.class),
        nameResolver, changeLogService)).updateDescription(1L, "42", "42");

    // Assert
    verify(nameResolver).resolve(isA(EntityReference.class));
    verify(measurableDao).getById(eq(1L));
    verify(measurableDao).updateDescription(eq(1L), eq("42"), eq("42"));
    verify(measurable).description();
    verify(entityReference).name();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateDescriptionResult);
  }

  /**
   * Method under test:
   * {@link MeasurableService#updateExternalId(long, String, String)}
   */
  @Test
  void testUpdateExternalId() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateExternalId(anyLong(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(true);
    when(measurableDao.getById(anyLong())).thenReturn(null);
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(entityReference);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult2);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    boolean actualUpdateExternalIdResult = (new MeasurableService(measurableDao, mock(MeasurableSearchDao.class),
        nameResolver,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .updateExternalId(1L, "42", "42");

    // Assert
    verify(nameResolver).resolve(isA(EntityReference.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(measurableDao).getById(eq(1L));
    verify(measurableDao).updateExternalId(eq(1L), eq("42"), eq("42"));
    verify(entityReference).name();
    assertTrue(actualUpdateExternalIdResult);
  }

  /**
   * Method under test:
   * {@link MeasurableService#updateExternalId(long, String, String)}
   */
  @Test
  void testUpdateExternalId2() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateExternalId(anyLong(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(false);
    when(measurableDao.getById(anyLong())).thenReturn(null);
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(entityReference);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult2);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    boolean actualUpdateExternalIdResult = (new MeasurableService(measurableDao, mock(MeasurableSearchDao.class),
        nameResolver,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .updateExternalId(1L, "42", "42");

    // Assert
    verify(nameResolver).resolve(isA(EntityReference.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(measurableDao).getById(eq(1L));
    verify(measurableDao).updateExternalId(eq(1L), eq("42"), eq("42"));
    verify(entityReference).name();
    assertFalse(actualUpdateExternalIdResult);
  }

  /**
   * Method under test:
   * {@link MeasurableService#updateExternalId(long, String, String)}
   */
  @Test
  void testUpdateExternalId3() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateExternalId(anyLong(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(true);
    when(measurableDao.getById(anyLong())).thenReturn(null);
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(entityReference);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult2);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    boolean actualUpdateExternalIdResult = (new MeasurableService(measurableDao, mock(MeasurableSearchDao.class),
        nameResolver, changeLogService)).updateExternalId(1L, "42", "42");

    // Assert
    verify(nameResolver).resolve(isA(EntityReference.class));
    verify(measurableDao).getById(eq(1L));
    verify(measurableDao).updateExternalId(eq(1L), eq("42"), eq("42"));
    verify(entityReference).name();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateExternalIdResult);
  }

  /**
   * Method under test: {@link MeasurableService#create(Measurable, String)}
   */
  @Test
  void testCreate() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.create(Mockito.<Measurable>any())).thenReturn(1L);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    MeasurableService measurableService = new MeasurableService(measurableDao, mock(MeasurableSearchDao.class),
        mock(EntityReferenceNameResolver.class),
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    Measurable measurable = mock(Measurable.class);
    when(measurable.name()).thenReturn("Name");

    // Act
    boolean actualCreateResult = measurableService.create(measurable, "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(measurableDao).create(isA(Measurable.class));
    verify(measurable).name();
    assertFalse(actualCreateResult);
  }

  /**
   * Method under test: {@link MeasurableService#create(Measurable, String)}
   */
  @Test
  void testCreate2() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.create(Mockito.<Measurable>any())).thenReturn(15L);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    MeasurableService measurableService = new MeasurableService(measurableDao, mock(MeasurableSearchDao.class),
        mock(EntityReferenceNameResolver.class),
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    Measurable measurable = mock(Measurable.class);
    when(measurable.name()).thenReturn("Name");

    // Act
    boolean actualCreateResult = measurableService.create(measurable, "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(measurableDao).create(isA(Measurable.class));
    verify(measurable).name();
    assertTrue(actualCreateResult);
  }

  /**
   * Method under test: {@link MeasurableService#create(Measurable, String)}
   */
  @Test
  void testCreate3() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.create(Mockito.<Measurable>any())).thenReturn(1L);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    MeasurableService measurableService = new MeasurableService(measurableDao, mock(MeasurableSearchDao.class),
        mock(EntityReferenceNameResolver.class), changeLogService);
    Measurable measurable = mock(Measurable.class);
    when(measurable.name()).thenReturn("Name");

    // Act
    boolean actualCreateResult = measurableService.create(measurable, "42");

    // Assert
    verify(measurableDao).create(isA(Measurable.class));
    verify(measurable).name();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertFalse(actualCreateResult);
  }

  /**
   * Method under test:
   * {@link MeasurableService#deleteByIdSelector(IdSelectionOptions)}
   */
  @Test
  void testDeleteByIdSelector() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.deleteByIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(1);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    int actualDeleteByIdSelectorResult = measurableService.deleteByIdSelector(selectionOptions);

    // Assert
    verify(measurableDao).deleteByIdSelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertEquals(1, actualDeleteByIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableService#deleteByIdSelector(IdSelectionOptions)}
   */
  @Test
  void testDeleteByIdSelector2() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.deleteByIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(1);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    int actualDeleteByIdSelectorResult = measurableService.deleteByIdSelector(selectionOptions);

    // Assert
    verify(measurableDao).deleteByIdSelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertEquals(1, actualDeleteByIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableService#deleteByIdSelector(IdSelectionOptions)}
   */
  @Test
  void testDeleteByIdSelector3() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.deleteByIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(1);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.AGGREGATE_OVERLAY_DIAGRAM);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    int actualDeleteByIdSelectorResult = measurableService.deleteByIdSelector(selectionOptions);

    // Assert
    verify(measurableDao).deleteByIdSelector(isNull());
    verify(entityReference).kind();
    verify(selectionOptions).entityReference();
    assertEquals(1, actualDeleteByIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableService#deleteByIdSelector(IdSelectionOptions)}
   */
  @Test
  void testDeleteByIdSelector4() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.deleteByIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(1);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(selectionOptions.joiningEntityKind()).thenReturn(ofResult);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(selectionFilters);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    int actualDeleteByIdSelectorResult = measurableService.deleteByIdSelector(selectionOptions);

    // Assert
    verify(measurableDao).deleteByIdSelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions, atLeast(1)).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions, atLeast(1)).scope();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    assertEquals(1, actualDeleteByIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableService#deleteByIdSelector(IdSelectionOptions)}
   */
  @Test
  void testDeleteByIdSelector5() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.deleteByIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(1);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.CHANGE_INITIATIVE);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    int actualDeleteByIdSelectorResult = measurableService.deleteByIdSelector(selectionOptions);

    // Assert
    verify(measurableDao).deleteByIdSelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertEquals(1, actualDeleteByIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableService#deleteByIdSelector(IdSelectionOptions)}
   */
  @Test
  void testDeleteByIdSelector6() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.deleteByIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(1);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.CHANGE_INITIATIVE);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.PARENTS);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    int actualDeleteByIdSelectorResult = measurableService.deleteByIdSelector(selectionOptions);

    // Assert
    verify(measurableDao).deleteByIdSelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertEquals(1, actualDeleteByIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableService#updateParentId(Long, Long, String)}
   */
  @Test
  void testUpdateParentId() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateParentId(Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any()))
        .thenReturn(true);
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(entityReference);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult2);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    boolean actualUpdateParentIdResult = (new MeasurableService(measurableDao, mock(MeasurableSearchDao.class),
        nameResolver,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .updateParentId(1L, 1L, "42");

    // Assert
    verify(nameResolver, atLeast(1)).resolve(isA(EntityReference.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(measurableDao).updateParentId(eq(1L), eq(1L), eq("42"));
    verify(entityReference, atLeast(1)).name();
    assertTrue(actualUpdateParentIdResult);
  }

  /**
   * Method under test:
   * {@link MeasurableService#updateParentId(Long, Long, String)}
   */
  @Test
  void testUpdateParentId2() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateParentId(Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any()))
        .thenReturn(false);
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(entityReference);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult2);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    boolean actualUpdateParentIdResult = (new MeasurableService(measurableDao, mock(MeasurableSearchDao.class),
        nameResolver,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .updateParentId(1L, 1L, "42");

    // Assert
    verify(nameResolver, atLeast(1)).resolve(isA(EntityReference.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(measurableDao).updateParentId(eq(1L), eq(1L), eq("42"));
    verify(entityReference, atLeast(1)).name();
    assertFalse(actualUpdateParentIdResult);
  }

  /**
   * Method under test:
   * {@link MeasurableService#updateParentId(Long, Long, String)}
   */
  @Test
  void testUpdateParentId3() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateParentId(Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any()))
        .thenReturn(true);
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(entityReference);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult2);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    boolean actualUpdateParentIdResult = (new MeasurableService(measurableDao, mock(MeasurableSearchDao.class),
        nameResolver, changeLogService)).updateParentId(1L, 1L, "42");

    // Assert
    verify(nameResolver, atLeast(1)).resolve(isA(EntityReference.class));
    verify(measurableDao).updateParentId(eq(1L), eq(1L), eq("42"));
    verify(entityReference, atLeast(1)).name();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateParentIdResult);
  }

  /**
   * Method under test:
   * {@link MeasurableService#updateParentId(Long, Long, String)}
   */
  @Test
  void testUpdateParentId4() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateParentId(Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any()))
        .thenReturn(true);
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(entityReference);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult2);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    boolean actualUpdateParentIdResult = (new MeasurableService(measurableDao, mock(MeasurableSearchDao.class),
        nameResolver, changeLogService)).updateParentId(1L, null, "42");

    // Assert
    verify(nameResolver).resolve(isA(EntityReference.class));
    verify(measurableDao).updateParentId(eq(1L), isNull(), eq("42"));
    verify(entityReference).name();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateParentIdResult);
  }

  /**
   * Method under test: {@link MeasurableService#reorder(long, List, String)}
   */
  @Test
  void testReorder() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    // Act and Assert
    assertTrue(measurableService.reorder(1L, new ArrayList<>(), "42"));
  }

  /**
   * Method under test: {@link MeasurableService#reorder(long, List, String)}
   */
  @Test
  void testReorder2() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.reorder(anyLong(), Mockito.<List<Long>>any(), Mockito.<String>any())).thenReturn(1);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    MeasurableService measurableService = new MeasurableService(measurableDao, mock(MeasurableSearchDao.class),
        mock(EntityReferenceNameResolver.class),
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act
    boolean actualReorderResult = measurableService.reorder(1L, ids, "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(measurableDao).reorder(eq(1L), isA(List.class), eq("42"));
    assertTrue(actualReorderResult);
  }

  /**
   * Method under test: {@link MeasurableService#reorder(long, List, String)}
   */
  @Test
  void testReorder3() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.reorder(anyLong(), Mockito.<List<Long>>any(), Mockito.<String>any())).thenReturn(1);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    MeasurableService measurableService = new MeasurableService(measurableDao, mock(MeasurableSearchDao.class),
        mock(EntityReferenceNameResolver.class), changeLogService);

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act
    boolean actualReorderResult = measurableService.reorder(1L, ids, "42");

    // Assert
    verify(measurableDao).reorder(eq(1L), isA(List.class), eq("42"));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualReorderResult);
  }

  /**
   * Method under test: {@link MeasurableService#reorder(long, List, String)}
   */
  @Test
  void testReorder4() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.reorder(anyLong(), Mockito.<List<Long>>any(), Mockito.<String>any())).thenReturn(1);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    MeasurableService measurableService = new MeasurableService(measurableDao, mock(MeasurableSearchDao.class),
        mock(EntityReferenceNameResolver.class), changeLogService);

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);
    ids.add(1L);

    // Act
    boolean actualReorderResult = measurableService.reorder(1L, ids, "42");

    // Assert
    verify(measurableDao).reorder(eq(1L), isA(List.class), eq("42"));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualReorderResult);
  }

  /**
   * Method under test:
   * {@link MeasurableService#writeAuditMessage(Long, String, String)}
   */
  @Test
  void testWriteAuditMessage() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    (new MeasurableService(mock(MeasurableDao.class), mock(MeasurableSearchDao.class),
        mock(EntityReferenceNameResolver.class),
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .writeAuditMessage(1L, "42", "Msg");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
  }

  /**
   * Method under test:
   * {@link MeasurableService#writeAuditMessage(Long, String, String)}
   */
  @Test
  void testWriteAuditMessage2() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    (new MeasurableService(mock(MeasurableDao.class), mock(MeasurableSearchDao.class),
        mock(EntityReferenceNameResolver.class), changeLogService)).writeAuditMessage(1L, "42", "Msg");

    // Assert
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Method under test: {@link MeasurableService#moveChildren(Long, Long, String)}
   */
  @Test
  void testMoveChildren() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.moveChildren(Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any())).thenReturn(true);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);

    // Act
    boolean actualMoveChildrenResult = (new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .moveChildren(1L, 1L, "42");

    // Assert
    verify(measurableDao).moveChildren(eq(1L), eq(1L), eq("42"));
    assertTrue(actualMoveChildrenResult);
  }

  /**
   * Method under test: {@link MeasurableService#moveChildren(Long, Long, String)}
   */
  @Test
  void testMoveChildren2() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.moveChildren(Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any())).thenReturn(false);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);

    // Act
    boolean actualMoveChildrenResult = (new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .moveChildren(1L, 1L, "42");

    // Assert
    verify(measurableDao).moveChildren(eq(1L), eq(1L), eq("42"));
    assertFalse(actualMoveChildrenResult);
  }

  /**
   * Method under test: {@link MeasurableService#findHierarchyForCategory(long)}
   */
  @Test
  void testFindHierarchyForCategory() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    HashSet<MeasurableHierarchy> measurableHierarchySet = new HashSet<>();
    when(measurableDao.findHierarchyForCategory(anyLong())).thenReturn(measurableHierarchySet);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);

    // Act
    Set<MeasurableHierarchy> actualFindHierarchyForCategoryResult = (new MeasurableService(measurableDao,
        measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findHierarchyForCategory(1L);

    // Assert
    verify(measurableDao).findHierarchyForCategory(eq(1L));
    assertTrue(actualFindHierarchyForCategoryResult.isEmpty());
    assertSame(measurableHierarchySet, actualFindHierarchyForCategoryResult);
  }
}
