package org.finos.waltz.service.change_initiative;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.change_initiative.ChangeInitiativeDao;
import org.finos.waltz.data.change_initiative.search.ChangeInitiativeSearchDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.entity_relationship.EntityRelationshipDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.app_group.AppGroupEntry;
import org.finos.waltz.model.change_initiative.ChangeInitiative;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.entity_relationship.EntityRelationship;
import org.finos.waltz.model.entity_relationship.EntityRelationshipChangeCommand;
import org.finos.waltz.model.entity_relationship.EntityRelationshipKey;
import org.finos.waltz.model.entity_relationship.RelationshipKind;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ChangeInitiativeServiceDiffblueTest {
  /**
   * Method under test: {@link ChangeInitiativeService#getById(Long)}
   */
  @Test
  void testGetById() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    when(changeInitiativeDao.getById(Mockito.<Long>any())).thenReturn(null);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);

    // Act
    ChangeInitiative actualById = (new ChangeInitiativeService(changeInitiativeDao, searchDao, relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))).getById(1L);

    // Assert
    verify(changeInitiativeDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test: {@link ChangeInitiativeService#getById(Long)}
   */
  @Test
  void testGetById2() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    when(changeInitiativeDao.getById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException("foo"));
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new ChangeInitiativeService(changeInitiativeDao, searchDao, relationshipDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .getById(1L));
    verify(changeInitiativeDao).getById(eq(1L));
  }

  /**
   * Method under test:
   * {@link ChangeInitiativeService#findForSelector(IdSelectionOptions)}
   */
  @Test
  void testFindForSelector() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();
    when(changeInitiativeDao.findForSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(changeInitiativeList);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Collection<ChangeInitiative> actualFindForSelectorResult = changeInitiativeService
        .findForSelector(selectionOptions);

    // Assert
    verify(changeInitiativeDao).findForSelector(isA(Select.class));
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    assertTrue(actualFindForSelectorResult instanceof List);
    assertTrue(actualFindForSelectorResult.isEmpty());
    assertSame(changeInitiativeList, actualFindForSelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeInitiativeService#findForSelector(IdSelectionOptions)}
   */
  @Test
  void testFindForSelector2() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    when(changeInitiativeDao.findForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> changeInitiativeService.findForSelector(selectionOptions));
    verify(changeInitiativeDao).findForSelector(isA(Select.class));
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
  }

  /**
   * Method under test:
   * {@link ChangeInitiativeService#findForSelector(IdSelectionOptions)}
   */
  @Test
  void testFindForSelector3() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();
    when(changeInitiativeDao.findForSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(changeInitiativeList);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Collection<ChangeInitiative> actualFindForSelectorResult = changeInitiativeService
        .findForSelector(selectionOptions);

    // Assert
    verify(changeInitiativeDao).findForSelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    assertTrue(actualFindForSelectorResult instanceof List);
    assertTrue(actualFindForSelectorResult.isEmpty());
    assertSame(changeInitiativeList, actualFindForSelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeInitiativeService#findForSelector(IdSelectionOptions)}
   */
  @Test
  void testFindForSelector4() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();
    when(changeInitiativeDao.findForSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(changeInitiativeList);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
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
    Collection<ChangeInitiative> actualFindForSelectorResult = changeInitiativeService
        .findForSelector(selectionOptions);

    // Assert
    verify(changeInitiativeDao).findForSelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindForSelectorResult instanceof List);
    assertTrue(actualFindForSelectorResult.isEmpty());
    assertSame(changeInitiativeList, actualFindForSelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeInitiativeService#findForSelector(IdSelectionOptions)}
   */
  @Test
  void testFindForSelector5() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();
    when(changeInitiativeDao.findForSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(changeInitiativeList);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
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
    Collection<ChangeInitiative> actualFindForSelectorResult = changeInitiativeService
        .findForSelector(selectionOptions);

    // Assert
    verify(changeInitiativeDao).findForSelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindForSelectorResult instanceof List);
    assertTrue(actualFindForSelectorResult.isEmpty());
    assertSame(changeInitiativeList, actualFindForSelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeInitiativeService#findForSelector(IdSelectionOptions)}
   */
  @Test
  void testFindForSelector6() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();
    when(changeInitiativeDao.findForSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(changeInitiativeList);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.CHANGE_INITIATIVE);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.CHILDREN);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Collection<ChangeInitiative> actualFindForSelectorResult = changeInitiativeService
        .findForSelector(selectionOptions);

    // Assert
    verify(changeInitiativeDao).findForSelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindForSelectorResult instanceof List);
    assertTrue(actualFindForSelectorResult.isEmpty());
    assertSame(changeInitiativeList, actualFindForSelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeInitiativeService#findForSelector(IdSelectionOptions)}
   */
  @Test
  void testFindForSelector7() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();
    when(changeInitiativeDao.findForSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(changeInitiativeList);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(selectionOptions.joiningEntityKind()).thenReturn(ofResult);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(mock(SelectionFilters.class));
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Collection<ChangeInitiative> actualFindForSelectorResult = changeInitiativeService
        .findForSelector(selectionOptions);

    // Assert
    verify(changeInitiativeDao).findForSelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    assertTrue(actualFindForSelectorResult instanceof List);
    assertTrue(actualFindForSelectorResult.isEmpty());
    assertSame(changeInitiativeList, actualFindForSelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeInitiativeService#findForSelector(IdSelectionOptions)}
   */
  @Test
  void testFindForSelector8() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();
    when(changeInitiativeDao.findForSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(changeInitiativeList);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(selectionOptions.joiningEntityKind()).thenReturn(ofResult);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(mock(SelectionFilters.class));
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.CHILDREN);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Collection<ChangeInitiative> actualFindForSelectorResult = changeInitiativeService
        .findForSelector(selectionOptions);

    // Assert
    verify(changeInitiativeDao).findForSelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    assertTrue(actualFindForSelectorResult instanceof List);
    assertTrue(actualFindForSelectorResult.isEmpty());
    assertSame(changeInitiativeList, actualFindForSelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeInitiativeService#findHierarchyForSelector(IdSelectionOptions)}
   */
  @Test
  void testFindHierarchyForSelector() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();
    when(changeInitiativeDao.findHierarchyForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(changeInitiativeList);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Collection<ChangeInitiative> actualFindHierarchyForSelectorResult = changeInitiativeService
        .findHierarchyForSelector(selectionOptions);

    // Assert
    verify(changeInitiativeDao).findHierarchyForSelector(isA(Select.class));
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    assertTrue(actualFindHierarchyForSelectorResult instanceof List);
    assertTrue(actualFindHierarchyForSelectorResult.isEmpty());
    assertSame(changeInitiativeList, actualFindHierarchyForSelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeInitiativeService#findHierarchyForSelector(IdSelectionOptions)}
   */
  @Test
  void testFindHierarchyForSelector2() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    when(changeInitiativeDao.findHierarchyForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> changeInitiativeService.findHierarchyForSelector(selectionOptions));
    verify(changeInitiativeDao).findHierarchyForSelector(isA(Select.class));
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
  }

  /**
   * Method under test:
   * {@link ChangeInitiativeService#findHierarchyForSelector(IdSelectionOptions)}
   */
  @Test
  void testFindHierarchyForSelector3() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();
    when(changeInitiativeDao.findHierarchyForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(changeInitiativeList);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Collection<ChangeInitiative> actualFindHierarchyForSelectorResult = changeInitiativeService
        .findHierarchyForSelector(selectionOptions);

    // Assert
    verify(changeInitiativeDao).findHierarchyForSelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    assertTrue(actualFindHierarchyForSelectorResult instanceof List);
    assertTrue(actualFindHierarchyForSelectorResult.isEmpty());
    assertSame(changeInitiativeList, actualFindHierarchyForSelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeInitiativeService#findHierarchyForSelector(IdSelectionOptions)}
   */
  @Test
  void testFindHierarchyForSelector4() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();
    when(changeInitiativeDao.findHierarchyForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(changeInitiativeList);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
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
    Collection<ChangeInitiative> actualFindHierarchyForSelectorResult = changeInitiativeService
        .findHierarchyForSelector(selectionOptions);

    // Assert
    verify(changeInitiativeDao).findHierarchyForSelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindHierarchyForSelectorResult instanceof List);
    assertTrue(actualFindHierarchyForSelectorResult.isEmpty());
    assertSame(changeInitiativeList, actualFindHierarchyForSelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeInitiativeService#findHierarchyForSelector(IdSelectionOptions)}
   */
  @Test
  void testFindHierarchyForSelector5() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();
    when(changeInitiativeDao.findHierarchyForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(changeInitiativeList);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
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
    Collection<ChangeInitiative> actualFindHierarchyForSelectorResult = changeInitiativeService
        .findHierarchyForSelector(selectionOptions);

    // Assert
    verify(changeInitiativeDao).findHierarchyForSelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindHierarchyForSelectorResult instanceof List);
    assertTrue(actualFindHierarchyForSelectorResult.isEmpty());
    assertSame(changeInitiativeList, actualFindHierarchyForSelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeInitiativeService#findHierarchyForSelector(IdSelectionOptions)}
   */
  @Test
  void testFindHierarchyForSelector6() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();
    when(changeInitiativeDao.findHierarchyForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(changeInitiativeList);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.CHANGE_INITIATIVE);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.CHILDREN);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Collection<ChangeInitiative> actualFindHierarchyForSelectorResult = changeInitiativeService
        .findHierarchyForSelector(selectionOptions);

    // Assert
    verify(changeInitiativeDao).findHierarchyForSelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindHierarchyForSelectorResult instanceof List);
    assertTrue(actualFindHierarchyForSelectorResult.isEmpty());
    assertSame(changeInitiativeList, actualFindHierarchyForSelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeInitiativeService#findHierarchyForSelector(IdSelectionOptions)}
   */
  @Test
  void testFindHierarchyForSelector7() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();
    when(changeInitiativeDao.findHierarchyForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(changeInitiativeList);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(selectionOptions.joiningEntityKind()).thenReturn(ofResult);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(mock(SelectionFilters.class));
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Collection<ChangeInitiative> actualFindHierarchyForSelectorResult = changeInitiativeService
        .findHierarchyForSelector(selectionOptions);

    // Assert
    verify(changeInitiativeDao).findHierarchyForSelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    assertTrue(actualFindHierarchyForSelectorResult instanceof List);
    assertTrue(actualFindHierarchyForSelectorResult.isEmpty());
    assertSame(changeInitiativeList, actualFindHierarchyForSelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeInitiativeService#findHierarchyForSelector(IdSelectionOptions)}
   */
  @Test
  void testFindHierarchyForSelector8() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();
    when(changeInitiativeDao.findHierarchyForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(changeInitiativeList);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(selectionOptions.joiningEntityKind()).thenReturn(ofResult);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(mock(SelectionFilters.class));
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.CHILDREN);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Collection<ChangeInitiative> actualFindHierarchyForSelectorResult = changeInitiativeService
        .findHierarchyForSelector(selectionOptions);

    // Assert
    verify(changeInitiativeDao).findHierarchyForSelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions).scope();
    assertTrue(actualFindHierarchyForSelectorResult instanceof List);
    assertTrue(actualFindHierarchyForSelectorResult.isEmpty());
    assertSame(changeInitiativeList, actualFindHierarchyForSelectorResult);
  }

  /**
   * Method under test: {@link ChangeInitiativeService#search(String)}
   */
  @Test
  void testSearch() {
    // Arrange
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();
    when(searchDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(changeInitiativeList);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);

    // Act
    Collection<ChangeInitiative> actualSearchResult = (new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .search("Query");

    // Assert
    verify(searchDao).search(isA(EntitySearchOptions.class));
    assertTrue(actualSearchResult instanceof List);
    assertTrue(actualSearchResult.isEmpty());
    assertSame(changeInitiativeList, actualSearchResult);
  }

  /**
   * Method under test: {@link ChangeInitiativeService#search(String)}
   */
  @Test
  void testSearch2() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);

    // Act
    Collection<ChangeInitiative> actualSearchResult = (new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))).search("");

    // Assert
    assertTrue(actualSearchResult instanceof List);
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Method under test: {@link ChangeInitiativeService#search(String)}
   */
  @Test
  void testSearch3() {
    // Arrange
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    when(searchDao.search(Mockito.<EntitySearchOptions>any())).thenThrow(new IllegalArgumentException("Query"));
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new ChangeInitiativeService(changeInitiativeDao, searchDao, relationshipDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .search("Query"));
    verify(searchDao).search(isA(EntitySearchOptions.class));
  }

  /**
   * Method under test:
   * {@link ChangeInitiativeService#search(EntitySearchOptions)}
   */
  @Test
  void testSearch4() {
    // Arrange
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();
    when(searchDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(changeInitiativeList);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);

    // Act
    Collection<ChangeInitiative> actualSearchResult = (new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .search((EntitySearchOptions) null);

    // Assert
    verify(searchDao).search(isNull());
    assertTrue(actualSearchResult instanceof List);
    assertTrue(actualSearchResult.isEmpty());
    assertSame(changeInitiativeList, actualSearchResult);
  }

  /**
   * Method under test:
   * {@link ChangeInitiativeService#search(EntitySearchOptions)}
   */
  @Test
  void testSearch5() {
    // Arrange
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    when(searchDao.search(Mockito.<EntitySearchOptions>any())).thenThrow(new IllegalArgumentException("foo"));
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new ChangeInitiativeService(changeInitiativeDao, searchDao, relationshipDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .search((EntitySearchOptions) null));
    verify(searchDao).search(isNull());
  }

  /**
   * Method under test:
   * {@link ChangeInitiativeService#getRelatedEntitiesForId(long)}
   */
  @Test
  void testGetRelatedEntitiesForId() {
    // Arrange
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any())).thenReturn(entityRelationshipList);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);

    // Act
    Collection<EntityRelationship> actualRelatedEntitiesForId = (new ChangeInitiativeService(changeInitiativeDao,
        searchDao, relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .getRelatedEntitiesForId(1L);

    // Assert
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    assertTrue(actualRelatedEntitiesForId instanceof List);
    assertTrue(actualRelatedEntitiesForId.isEmpty());
    assertSame(entityRelationshipList, actualRelatedEntitiesForId);
  }

  /**
   * Method under test:
   * {@link ChangeInitiativeService#getRelatedEntitiesForId(long)}
   */
  @Test
  void testGetRelatedEntitiesForId2() {
    // Arrange
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenThrow(new IllegalArgumentException("kind"));
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new ChangeInitiativeService(changeInitiativeDao, searchDao, relationshipDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .getRelatedEntitiesForId(1L));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
  }

  /**
   * Method under test:
   * {@link ChangeInitiativeService#addEntityRelationship(long, EntityRelationshipChangeCommand, String)}
   */
  @Test
  void testAddEntityRelationship() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    EntityRelationshipChangeCommand command = mock(EntityRelationshipChangeCommand.class);
    when(command.entityReference()).thenReturn(entityReference);
    when(command.relationship()).thenReturn(RelationshipKind.HAS);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> changeInitiativeService.addEntityRelationship(1L, command, "janedoe"));
    verify(entityReference, atLeast(1)).kind();
    verify(command).entityReference();
    verify(command).relationship();
  }

  /**
   * Method under test:
   * {@link ChangeInitiativeService#removeEntityRelationship(long, EntityRelationshipChangeCommand, String)}
   */
  @Test
  void testRemoveEntityRelationship() {
    // Arrange
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.remove(Mockito.<EntityRelationshipKey>any())).thenReturn(true);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(mock(ChangeInitiativeDao.class),
        mock(ChangeInitiativeSearchDao.class), relationshipDao,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    EntityRelationshipChangeCommand command = mock(EntityRelationshipChangeCommand.class);
    when(command.entityReference()).thenReturn(entityReference);
    when(command.relationship()).thenReturn(RelationshipKind.HAS);

    // Act
    boolean actualRemoveEntityRelationshipResult = changeInitiativeService.removeEntityRelationship(1L, command,
        "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(relationshipDao).remove(isA(EntityRelationshipKey.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(entityReference).name();
    verify(command, atLeast(1)).entityReference();
    verify(command).relationship();
    assertTrue(actualRemoveEntityRelationshipResult);
  }

  /**
   * Method under test:
   * {@link ChangeInitiativeService#removeEntityRelationship(long, EntityRelationshipChangeCommand, String)}
   */
  @Test
  void testRemoveEntityRelationship2() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenThrow(new IllegalArgumentException("command cannot be null"));
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    EntityRelationshipChangeCommand command = mock(EntityRelationshipChangeCommand.class);
    when(command.entityReference()).thenReturn(entityReference);
    when(command.relationship()).thenReturn(RelationshipKind.HAS);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> changeInitiativeService.removeEntityRelationship(1L, command, "janedoe"));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(entityReference).name();
    verify(command, atLeast(1)).entityReference();
    verify(command).relationship();
  }

  /**
   * Method under test:
   * {@link ChangeInitiativeService#removeEntityRelationship(long, EntityRelationshipChangeCommand, String)}
   */
  @Test
  void testRemoveEntityRelationship3() {
    // Arrange
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.remove(Mockito.<EntityRelationshipKey>any())).thenReturn(false);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(mock(ChangeInitiativeDao.class),
        mock(ChangeInitiativeSearchDao.class), relationshipDao,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    EntityRelationshipChangeCommand command = mock(EntityRelationshipChangeCommand.class);
    when(command.entityReference()).thenReturn(entityReference);
    when(command.relationship()).thenReturn(RelationshipKind.HAS);

    // Act
    boolean actualRemoveEntityRelationshipResult = changeInitiativeService.removeEntityRelationship(1L, command,
        "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(relationshipDao).remove(isA(EntityRelationshipKey.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(entityReference).name();
    verify(command, atLeast(1)).entityReference();
    verify(command).relationship();
    assertFalse(actualRemoveEntityRelationshipResult);
  }

  /**
   * Method under test:
   * {@link ChangeInitiativeService#removeEntityRelationship(long, EntityRelationshipChangeCommand, String)}
   */
  @Test
  void testRemoveEntityRelationship4() {
    // Arrange
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.remove(Mockito.<EntityRelationshipKey>any())).thenReturn(true);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(mock(ChangeInitiativeDao.class),
        mock(ChangeInitiativeSearchDao.class), relationshipDao, changeLogService);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    EntityRelationshipChangeCommand command = mock(EntityRelationshipChangeCommand.class);
    when(command.entityReference()).thenReturn(entityReference);
    when(command.relationship()).thenReturn(RelationshipKind.HAS);

    // Act
    boolean actualRemoveEntityRelationshipResult = changeInitiativeService.removeEntityRelationship(1L, command,
        "janedoe");

    // Assert
    verify(relationshipDao).remove(isA(EntityRelationshipKey.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(entityReference).name();
    verify(command, atLeast(1)).entityReference();
    verify(command).relationship();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualRemoveEntityRelationshipResult);
  }

  /**
   * Method under test:
   * {@link ChangeInitiativeService#removeEntityRelationship(long, EntityRelationshipChangeCommand, String)}
   */
  @Test
  void testRemoveEntityRelationship5() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new IllegalArgumentException("command cannot be null"));
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(mock(ChangeInitiativeDao.class),
        mock(ChangeInitiativeSearchDao.class), mock(EntityRelationshipDao.class), changeLogService);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    EntityRelationshipChangeCommand command = mock(EntityRelationshipChangeCommand.class);
    when(command.entityReference()).thenReturn(entityReference);
    when(command.relationship()).thenReturn(RelationshipKind.HAS);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> changeInitiativeService.removeEntityRelationship(1L, command, "janedoe"));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(entityReference).name();
    verify(command, atLeast(1)).entityReference();
    verify(command).relationship();
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Method under test: {@link ChangeInitiativeService#findByExternalId(String)}
   */
  @Test
  void testFindByExternalId() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();
    when(changeInitiativeDao.findByExternalId(Mockito.<String>any())).thenReturn(changeInitiativeList);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);

    // Act
    Collection<ChangeInitiative> actualFindByExternalIdResult = (new ChangeInitiativeService(changeInitiativeDao,
        searchDao, relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findByExternalId("42");

    // Assert
    verify(changeInitiativeDao).findByExternalId(eq("42"));
    assertTrue(actualFindByExternalIdResult instanceof List);
    assertTrue(actualFindByExternalIdResult.isEmpty());
    assertSame(changeInitiativeList, actualFindByExternalIdResult);
  }

  /**
   * Method under test: {@link ChangeInitiativeService#findByExternalId(String)}
   */
  @Test
  void testFindByExternalId2() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    when(changeInitiativeDao.findByExternalId(Mockito.<String>any())).thenThrow(new IllegalArgumentException("foo"));
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new ChangeInitiativeService(changeInitiativeDao, searchDao, relationshipDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .findByExternalId("42"));
    verify(changeInitiativeDao).findByExternalId(eq("42"));
  }

  /**
   * Method under test: {@link ChangeInitiativeService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ArrayList<ChangeInitiative> changeInitiativeList = new ArrayList<>();
    when(changeInitiativeDao.findAll()).thenReturn(changeInitiativeList);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);

    // Act
    Collection<ChangeInitiative> actualFindAllResult = (new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))).findAll();

    // Assert
    verify(changeInitiativeDao).findAll();
    assertTrue(actualFindAllResult instanceof List);
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(changeInitiativeList, actualFindAllResult);
  }

  /**
   * Method under test: {@link ChangeInitiativeService#findAll()}
   */
  @Test
  void testFindAll2() {
    // Arrange
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    when(changeInitiativeDao.findAll()).thenThrow(new IllegalArgumentException("foo"));
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new ChangeInitiativeService(changeInitiativeDao, searchDao, relationshipDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .findAll());
    verify(changeInitiativeDao).findAll();
  }

  /**
   * Method under test:
   * {@link ChangeInitiativeService#findEntriesForAppGroup(long)}
   */
  @Test
  void testFindEntriesForAppGroup() {
    // Arrange
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);

    // Act
    List<AppGroupEntry> actualFindEntriesForAppGroupResult = (new ChangeInitiativeService(changeInitiativeDao,
        searchDao, relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findEntriesForAppGroup(1L);

    // Assert
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    assertTrue(actualFindEntriesForAppGroupResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ChangeInitiativeService#findEntriesForAppGroup(long)}
   */
  @Test
  void testFindEntriesForAppGroup2() {
    // Arrange
    EntityRelationship entityRelationship = mock(EntityRelationship.class);
    when(entityRelationship.a()).thenReturn(null);
    EntityRelationship entityRelationship2 = mock(EntityRelationship.class);
    when(entityRelationship2.a()).thenThrow(new IllegalArgumentException("kind"));

    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();
    entityRelationshipList.add(entityRelationship2);
    entityRelationshipList.add(entityRelationship);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any())).thenReturn(entityRelationshipList);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new ChangeInitiativeService(changeInitiativeDao, searchDao, relationshipDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .findEntriesForAppGroup(1L));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    verify(entityRelationship2).a();
  }
}
