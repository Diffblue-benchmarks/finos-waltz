package org.finos.waltz.service.physical_specification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.physical_specification.search.PhysicalSpecificationSearchDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.SetAttributeCommand;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.command.CommandOutcome;
import org.finos.waltz.model.command.CommandResponse;
import org.finos.waltz.model.command.ImmutableCommandResponse;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.physical_specification.ImmutablePhysicalSpecification;
import org.finos.waltz.model.physical_specification.PhysicalSpecification;
import org.finos.waltz.model.physical_specification.PhysicalSpecificationDeleteCommand;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PhysicalSpecificationServiceDiffblueTest {
  /**
   * Method under test:
   * {@link PhysicalSpecificationService#findByEntityReference(EntityReference)}
   */
  @Test
  void testFindByEntityReference() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    HashSet<PhysicalSpecification> physicalSpecificationSet = new HashSet<>();
    when(specificationDao.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(physicalSpecificationSet);

    // Act
    Set<PhysicalSpecification> actualFindByEntityReferenceResult = (new PhysicalSpecificationService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        specificationDao, mock(PhysicalSpecificationSearchDao.class)))
            .findByEntityReference(mock(EntityReference.class));

    // Assert
    verify(specificationDao).findByEntityReference(isA(EntityReference.class));
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
    assertSame(physicalSpecificationSet, actualFindByEntityReferenceResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationService#findByEntityReference(EntityReference)}
   */
  @Test
  void testFindByEntityReference2() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenThrow(new UnsupportedOperationException("Entity reference cannot be null"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PhysicalSpecificationService(
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
            specificationDao, mock(PhysicalSpecificationSearchDao.class)))
                .findByEntityReference(mock(EntityReference.class)));
    verify(specificationDao).findByEntityReference(isA(EntityReference.class));
  }

  /**
   * Method under test: {@link PhysicalSpecificationService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.getById(anyLong())).thenReturn(null);

    // Act
    PhysicalSpecification actualById = (new PhysicalSpecificationService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        specificationDao, mock(PhysicalSpecificationSearchDao.class))).getById(1L);

    // Assert
    verify(specificationDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test: {@link PhysicalSpecificationService#getById(long)}
   */
  @Test
  void testGetById2() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.getById(anyLong())).thenThrow(new UnsupportedOperationException("foo"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PhysicalSpecificationService(
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
            specificationDao, mock(PhysicalSpecificationSearchDao.class))).getById(1L));
    verify(specificationDao).getById(eq(1L));
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationService#findBySelector(IdSelectionOptions)}
   */
  @Test
  void testFindBySelector() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    HashSet<PhysicalSpecification> physicalSpecificationSet = new HashSet<>();
    when(specificationDao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(physicalSpecificationSet);
    PhysicalSpecificationService physicalSpecificationService = new PhysicalSpecificationService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        specificationDao, mock(PhysicalSpecificationSearchDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    Collection<PhysicalSpecification> actualFindBySelectorResult = physicalSpecificationService.findBySelector(options);

    // Assert
    verify(specificationDao).findBySelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindBySelectorResult instanceof Set);
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(physicalSpecificationSet, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationService#findBySelector(IdSelectionOptions)}
   */
  @Test
  void testFindBySelector2() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    HashSet<PhysicalSpecification> physicalSpecificationSet = new HashSet<>();
    when(specificationDao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(physicalSpecificationSet);
    PhysicalSpecificationService physicalSpecificationService = new PhysicalSpecificationService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        specificationDao, mock(PhysicalSpecificationSearchDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    Collection<PhysicalSpecification> actualFindBySelectorResult = physicalSpecificationService.findBySelector(options);

    // Assert
    verify(specificationDao).findBySelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindBySelectorResult instanceof Set);
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(physicalSpecificationSet, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationService#findBySelector(IdSelectionOptions)}
   */
  @Test
  void testFindBySelector3() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    HashSet<PhysicalSpecification> physicalSpecificationSet = new HashSet<>();
    when(specificationDao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(physicalSpecificationSet);
    PhysicalSpecificationService physicalSpecificationService = new PhysicalSpecificationService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        specificationDao, mock(PhysicalSpecificationSearchDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);

    HashSet<ApplicationKind> applicationKindSet = new HashSet<>();
    applicationKindSet.add(ApplicationKind.IN_HOUSE);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(applicationKindSet);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    Collection<PhysicalSpecification> actualFindBySelectorResult = physicalSpecificationService.findBySelector(options);

    // Assert
    verify(specificationDao).findBySelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).scope();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    assertTrue(actualFindBySelectorResult instanceof Set);
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(physicalSpecificationSet, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationService#findBySelector(IdSelectionOptions)}
   */
  @Test
  void testFindBySelector4() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    HashSet<PhysicalSpecification> physicalSpecificationSet = new HashSet<>();
    when(specificationDao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(physicalSpecificationSet);
    PhysicalSpecificationService physicalSpecificationService = new PhysicalSpecificationService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        specificationDao, mock(PhysicalSpecificationSearchDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.REMOVED);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    Collection<PhysicalSpecification> actualFindBySelectorResult = physicalSpecificationService.findBySelector(options);

    // Assert
    verify(specificationDao).findBySelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindBySelectorResult instanceof Set);
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(physicalSpecificationSet, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationService#findBySelector(IdSelectionOptions)}
   */
  @Test
  void testFindBySelector5() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    HashSet<PhysicalSpecification> physicalSpecificationSet = new HashSet<>();
    when(specificationDao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(physicalSpecificationSet);
    PhysicalSpecificationService physicalSpecificationService = new PhysicalSpecificationService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        specificationDao, mock(PhysicalSpecificationSearchDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.REMOVED);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    Collection<PhysicalSpecification> actualFindBySelectorResult = physicalSpecificationService.findBySelector(options);

    // Assert
    verify(specificationDao).findBySelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindBySelectorResult instanceof Set);
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(physicalSpecificationSet, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationService#markRemovedIfUnused(PhysicalSpecificationDeleteCommand, String)}
   */
  @Test
  void testMarkRemovedIfUnused() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.getById(anyLong())).thenReturn(null);
    PhysicalSpecificationService physicalSpecificationService = new PhysicalSpecificationService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        specificationDao, mock(PhysicalSpecificationSearchDao.class));
    PhysicalSpecificationDeleteCommand command = mock(PhysicalSpecificationDeleteCommand.class);
    when(command.specificationId()).thenReturn(1L);

    // Act
    CommandResponse<PhysicalSpecificationDeleteCommand> actualMarkRemovedIfUnusedResult = physicalSpecificationService
        .markRemovedIfUnused(command, "janedoe");

    // Assert
    verify(specificationDao).getById(eq(1L));
    verify(command, atLeast(1)).specificationId();
    EntityReference entityReferenceResult = actualMarkRemovedIfUnusedResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualMarkRemovedIfUnusedResult instanceof ImmutableCommandResponse);
    assertNull(entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.PHYSICAL_SPECIFICATION, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(CommandOutcome.FAILURE, actualMarkRemovedIfUnusedResult.outcome());
    assertSame(command, actualMarkRemovedIfUnusedResult.originalCommand());
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationService#markRemovedIfUnused(PhysicalSpecificationDeleteCommand, String)}
   */
  @Test
  void testMarkRemovedIfUnused2() {
    // Arrange
    PhysicalSpecificationService physicalSpecificationService = new PhysicalSpecificationService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(PhysicalSpecificationDao.class), mock(PhysicalSpecificationSearchDao.class));
    PhysicalSpecificationDeleteCommand command = mock(PhysicalSpecificationDeleteCommand.class);
    when(command.specificationId()).thenThrow(new UnsupportedOperationException("command cannot be null"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> physicalSpecificationService.markRemovedIfUnused(command, "janedoe"));
    verify(command).specificationId();
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationService#markRemovedIfUnused(PhysicalSpecificationDeleteCommand, String)}
   */
  @Test
  void testMarkRemovedIfUnused3() {
    // Arrange
    PhysicalSpecification physicalSpecification = mock(PhysicalSpecification.class);
    when(physicalSpecification.owningEntity()).thenThrow(new UnsupportedOperationException("command cannot be null"));
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.markRemovedIfUnused(anyLong())).thenReturn(1);
    when(specificationDao.getById(anyLong())).thenReturn(physicalSpecification);
    PhysicalSpecificationService physicalSpecificationService = new PhysicalSpecificationService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        specificationDao, mock(PhysicalSpecificationSearchDao.class));
    PhysicalSpecificationDeleteCommand command = mock(PhysicalSpecificationDeleteCommand.class);
    when(command.specificationId()).thenReturn(1L);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> physicalSpecificationService.markRemovedIfUnused(command, "janedoe"));
    verify(specificationDao).getById(eq(1L));
    verify(specificationDao).markRemovedIfUnused(eq(1L));
    verify(physicalSpecification).owningEntity();
    verify(command, atLeast(1)).specificationId();
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationService#markRemovedIfUnused(PhysicalSpecificationDeleteCommand, String)}
   */
  @Test
  void testMarkRemovedIfUnused4() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.markRemovedIfUnused(anyLong())).thenReturn(0);
    when(specificationDao.getById(anyLong())).thenReturn(mock(PhysicalSpecification.class));
    PhysicalSpecificationService physicalSpecificationService = new PhysicalSpecificationService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        specificationDao, mock(PhysicalSpecificationSearchDao.class));
    PhysicalSpecificationDeleteCommand command = mock(PhysicalSpecificationDeleteCommand.class);
    when(command.specificationId()).thenReturn(1L);

    // Act
    CommandResponse<PhysicalSpecificationDeleteCommand> actualMarkRemovedIfUnusedResult = physicalSpecificationService
        .markRemovedIfUnused(command, "janedoe");

    // Assert
    verify(specificationDao).getById(eq(1L));
    verify(specificationDao).markRemovedIfUnused(eq(1L));
    verify(command, atLeast(1)).specificationId();
    EntityReference entityReferenceResult = actualMarkRemovedIfUnusedResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualMarkRemovedIfUnusedResult instanceof ImmutableCommandResponse);
    assertNull(entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.PHYSICAL_SPECIFICATION, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(CommandOutcome.FAILURE, actualMarkRemovedIfUnusedResult.outcome());
    assertSame(command, actualMarkRemovedIfUnusedResult.originalCommand());
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationService#markRemovedIfUnused(PhysicalSpecificationDeleteCommand, String)}
   */
  @Test
  void testMarkRemovedIfUnused5() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    PhysicalSpecification physicalSpecification = mock(PhysicalSpecification.class);
    when(physicalSpecification.name()).thenReturn("Name");
    when(physicalSpecification.owningEntity()).thenReturn(mock(EntityReference.class));
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.markRemovedIfUnused(anyLong())).thenReturn(1);
    when(specificationDao.getById(anyLong())).thenReturn(physicalSpecification);
    PhysicalSpecificationService physicalSpecificationService = new PhysicalSpecificationService(changeLogService,
        specificationDao, mock(PhysicalSpecificationSearchDao.class));
    PhysicalSpecificationDeleteCommand command = mock(PhysicalSpecificationDeleteCommand.class);
    when(command.specificationId()).thenReturn(1L);

    // Act
    CommandResponse<PhysicalSpecificationDeleteCommand> actualMarkRemovedIfUnusedResult = physicalSpecificationService
        .markRemovedIfUnused(command, "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(specificationDao).getById(eq(1L));
    verify(specificationDao).markRemovedIfUnused(eq(1L));
    verify(physicalSpecification).name();
    verify(physicalSpecification).owningEntity();
    verify(command, atLeast(1)).specificationId();
    EntityReference entityReferenceResult = actualMarkRemovedIfUnusedResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualMarkRemovedIfUnusedResult instanceof ImmutableCommandResponse);
    assertNull(entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.PHYSICAL_SPECIFICATION, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(CommandOutcome.SUCCESS, actualMarkRemovedIfUnusedResult.outcome());
    assertSame(command, actualMarkRemovedIfUnusedResult.originalCommand());
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationService#markRemovedIfUnused(PhysicalSpecificationDeleteCommand, String)}
   */
  @Test
  void testMarkRemovedIfUnused6() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    PhysicalSpecification physicalSpecification = mock(PhysicalSpecification.class);
    when(physicalSpecification.name()).thenReturn("Name");
    when(physicalSpecification.owningEntity()).thenReturn(mock(EntityReference.class));
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.markRemovedIfUnused(anyLong())).thenReturn(1);
    when(specificationDao.getById(anyLong())).thenReturn(physicalSpecification);
    PhysicalSpecificationService physicalSpecificationService = new PhysicalSpecificationService(changeLogService,
        specificationDao, mock(PhysicalSpecificationSearchDao.class));
    PhysicalSpecificationDeleteCommand command = mock(PhysicalSpecificationDeleteCommand.class);
    when(command.specificationId()).thenReturn(1L);

    // Act
    CommandResponse<PhysicalSpecificationDeleteCommand> actualMarkRemovedIfUnusedResult = physicalSpecificationService
        .markRemovedIfUnused(command, "janedoe");

    // Assert
    verify(specificationDao).getById(eq(1L));
    verify(specificationDao).markRemovedIfUnused(eq(1L));
    verify(physicalSpecification).name();
    verify(physicalSpecification).owningEntity();
    verify(command, atLeast(1)).specificationId();
    verify(changeLogService).write(isA(ChangeLog.class));
    EntityReference entityReferenceResult = actualMarkRemovedIfUnusedResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualMarkRemovedIfUnusedResult instanceof ImmutableCommandResponse);
    assertNull(entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.PHYSICAL_SPECIFICATION, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(CommandOutcome.SUCCESS, actualMarkRemovedIfUnusedResult.outcome());
    assertSame(command, actualMarkRemovedIfUnusedResult.originalCommand());
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationService#markRemovedIfUnused(PhysicalSpecificationDeleteCommand, String)}
   */
  @Test
  void testMarkRemovedIfUnused7() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new UnsupportedOperationException("command cannot be null"));
    PhysicalSpecification physicalSpecification = mock(PhysicalSpecification.class);
    when(physicalSpecification.name()).thenReturn("Name");
    when(physicalSpecification.owningEntity()).thenReturn(mock(EntityReference.class));
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.markRemovedIfUnused(anyLong())).thenReturn(1);
    when(specificationDao.getById(anyLong())).thenReturn(physicalSpecification);
    PhysicalSpecificationService physicalSpecificationService = new PhysicalSpecificationService(changeLogService,
        specificationDao, mock(PhysicalSpecificationSearchDao.class));
    PhysicalSpecificationDeleteCommand command = mock(PhysicalSpecificationDeleteCommand.class);
    when(command.specificationId()).thenReturn(1L);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> physicalSpecificationService.markRemovedIfUnused(command, "janedoe"));
    verify(specificationDao).getById(eq(1L));
    verify(specificationDao).markRemovedIfUnused(eq(1L));
    verify(physicalSpecification).name();
    verify(physicalSpecification).owningEntity();
    verify(command, atLeast(1)).specificationId();
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationService#search(EntitySearchOptions)}
   */
  @Test
  void testSearch() {
    // Arrange
    PhysicalSpecificationSearchDao specificationSearchDao = mock(PhysicalSpecificationSearchDao.class);
    ArrayList<PhysicalSpecification> physicalSpecificationList = new ArrayList<>();
    when(specificationSearchDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(physicalSpecificationList);

    // Act
    List<PhysicalSpecification> actualSearchResult = (new PhysicalSpecificationService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(PhysicalSpecificationDao.class), specificationSearchDao)).search(mock(EntitySearchOptions.class));

    // Assert
    verify(specificationSearchDao).search(isA(EntitySearchOptions.class));
    assertTrue(actualSearchResult.isEmpty());
    assertSame(physicalSpecificationList, actualSearchResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationService#search(EntitySearchOptions)}
   */
  @Test
  void testSearch2() {
    // Arrange
    PhysicalSpecificationSearchDao specificationSearchDao = mock(PhysicalSpecificationSearchDao.class);
    when(specificationSearchDao.search(Mockito.<EntitySearchOptions>any()))
        .thenThrow(new UnsupportedOperationException("Search options cannot be null"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PhysicalSpecificationService(
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
            mock(PhysicalSpecificationDao.class), specificationSearchDao)).search(mock(EntitySearchOptions.class)));
    verify(specificationSearchDao).search(isA(EntitySearchOptions.class));
  }

  /**
   * Method under test: {@link PhysicalSpecificationService#findByIds(Collection)}
   */
  @Test
  void testFindByIds() {
    // Arrange
    PhysicalSpecificationService physicalSpecificationService = new PhysicalSpecificationService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(PhysicalSpecificationDao.class), mock(PhysicalSpecificationSearchDao.class));

    // Act
    Collection<PhysicalSpecification> actualFindByIdsResult = physicalSpecificationService.findByIds(new ArrayList<>());

    // Assert
    assertTrue(actualFindByIdsResult instanceof List);
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Method under test: {@link PhysicalSpecificationService#findByIds(Collection)}
   */
  @Test
  void testFindByIds2() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    ArrayList<PhysicalSpecification> physicalSpecificationList = new ArrayList<>();
    when(specificationDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(physicalSpecificationList);
    PhysicalSpecificationService physicalSpecificationService = new PhysicalSpecificationService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        specificationDao, mock(PhysicalSpecificationSearchDao.class));

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act
    Collection<PhysicalSpecification> actualFindByIdsResult = physicalSpecificationService.findByIds(ids);

    // Assert
    verify(specificationDao).findByIds(isA(Collection.class));
    assertTrue(actualFindByIdsResult instanceof List);
    assertTrue(actualFindByIdsResult.isEmpty());
    assertSame(physicalSpecificationList, actualFindByIdsResult);
  }

  /**
   * Method under test: {@link PhysicalSpecificationService#findByIds(Collection)}
   */
  @Test
  void testFindByIds3() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    ArrayList<PhysicalSpecification> physicalSpecificationList = new ArrayList<>();
    when(specificationDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(physicalSpecificationList);
    PhysicalSpecificationService physicalSpecificationService = new PhysicalSpecificationService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        specificationDao, mock(PhysicalSpecificationSearchDao.class));

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(0L);
    ids.add(1L);

    // Act
    Collection<PhysicalSpecification> actualFindByIdsResult = physicalSpecificationService.findByIds(ids);

    // Assert
    verify(specificationDao).findByIds(isA(Collection.class));
    assertTrue(actualFindByIdsResult instanceof List);
    assertTrue(actualFindByIdsResult.isEmpty());
    assertSame(physicalSpecificationList, actualFindByIdsResult);
  }

  /**
   * Method under test: {@link PhysicalSpecificationService#findByIds(Collection)}
   */
  @Test
  void testFindByIds4() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.findByIds(Mockito.<Collection<Long>>any()))
        .thenThrow(new UnsupportedOperationException("foo"));
    PhysicalSpecificationService physicalSpecificationService = new PhysicalSpecificationService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        specificationDao, mock(PhysicalSpecificationSearchDao.class));

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> physicalSpecificationService.findByIds(ids));
    verify(specificationDao).findByIds(isA(Collection.class));
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationService#findByExternalId(String)}
   */
  @Test
  void testFindByExternalId() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    ArrayList<PhysicalSpecification> physicalSpecificationList = new ArrayList<>();
    when(specificationDao.findByExternalId(Mockito.<String>any())).thenReturn(physicalSpecificationList);

    // Act
    Collection<PhysicalSpecification> actualFindByExternalIdResult = (new PhysicalSpecificationService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        specificationDao, mock(PhysicalSpecificationSearchDao.class))).findByExternalId("42");

    // Assert
    verify(specificationDao).findByExternalId(eq("42"));
    assertTrue(actualFindByExternalIdResult instanceof List);
    assertTrue(actualFindByExternalIdResult.isEmpty());
    assertSame(physicalSpecificationList, actualFindByExternalIdResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationService#findByExternalId(String)}
   */
  @Test
  void testFindByExternalId2() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.findByExternalId(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException("External id cannot be null"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PhysicalSpecificationService(
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
            specificationDao, mock(PhysicalSpecificationSearchDao.class))).findByExternalId("42"));
    verify(specificationDao).findByExternalId(eq("42"));
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationService#updateExternalId(Long, String)}
   */
  @Test
  void testUpdateExternalId() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.updateExternalId(anyLong(), Mockito.<String>any())).thenReturn(1);

    // Act
    int actualUpdateExternalIdResult = (new PhysicalSpecificationService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        specificationDao, mock(PhysicalSpecificationSearchDao.class))).updateExternalId(1L, "42");

    // Assert
    verify(specificationDao).updateExternalId(eq(1L), eq("42"));
    assertEquals(1, actualUpdateExternalIdResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationService#updateExternalId(Long, String)}
   */
  @Test
  void testUpdateExternalId2() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.updateExternalId(anyLong(), Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException("Specification id cannot be null"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PhysicalSpecificationService(
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
            specificationDao, mock(PhysicalSpecificationSearchDao.class))).updateExternalId(1L, "42"));
    verify(specificationDao).updateExternalId(eq(1L), eq("42"));
  }

  /**
   * Method under test: {@link PhysicalSpecificationService#isUsed(Long)}
   */
  @Test
  void testIsUsed() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.isUsed(anyLong())).thenReturn(true);

    // Act
    boolean actualIsUsedResult = (new PhysicalSpecificationService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        specificationDao, mock(PhysicalSpecificationSearchDao.class))).isUsed(1L);

    // Assert
    verify(specificationDao).isUsed(eq(1L));
    assertTrue(actualIsUsedResult);
  }

  /**
   * Method under test: {@link PhysicalSpecificationService#isUsed(Long)}
   */
  @Test
  void testIsUsed2() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.isUsed(anyLong())).thenReturn(false);

    // Act
    boolean actualIsUsedResult = (new PhysicalSpecificationService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        specificationDao, mock(PhysicalSpecificationSearchDao.class))).isUsed(1L);

    // Assert
    verify(specificationDao).isUsed(eq(1L));
    assertFalse(actualIsUsedResult);
  }

  /**
   * Method under test: {@link PhysicalSpecificationService#isUsed(Long)}
   */
  @Test
  void testIsUsed3() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.isUsed(anyLong()))
        .thenThrow(new UnsupportedOperationException("Specification id cannot be null"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PhysicalSpecificationService(
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
            specificationDao, mock(PhysicalSpecificationSearchDao.class))).isUsed(1L));
    verify(specificationDao).isUsed(eq(1L));
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationService#create(ImmutablePhysicalSpecification)}
   */
  @Test
  void testCreate() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.create(Mockito.<PhysicalSpecification>any())).thenReturn(1L);

    // Act
    Long actualCreateResult = (new PhysicalSpecificationService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        specificationDao, mock(PhysicalSpecificationSearchDao.class))).create(null);

    // Assert
    verify(specificationDao).create(isNull());
    assertEquals(1L, actualCreateResult.longValue());
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationService#create(ImmutablePhysicalSpecification)}
   */
  @Test
  void testCreate2() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.create(Mockito.<PhysicalSpecification>any()))
        .thenThrow(new UnsupportedOperationException("foo"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PhysicalSpecificationService(
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
            specificationDao, mock(PhysicalSpecificationSearchDao.class))).create(null));
    verify(specificationDao).create(isNull());
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationService#makeActive(Long, String)}
   */
  @Test
  void testMakeActive() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.makeActive(Mockito.<Long>any())).thenReturn(1);

    // Act
    int actualMakeActiveResult = (new PhysicalSpecificationService(changeLogService, specificationDao,
        mock(PhysicalSpecificationSearchDao.class))).makeActive(1L, "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(specificationDao).makeActive(eq(1L));
    assertEquals(1, actualMakeActiveResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationService#makeActive(Long, String)}
   */
  @Test
  void testMakeActive2() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.makeActive(Mockito.<Long>any())).thenReturn(1);

    // Act
    int actualMakeActiveResult = (new PhysicalSpecificationService(changeLogService, specificationDao,
        mock(PhysicalSpecificationSearchDao.class))).makeActive(1L, "janedoe");

    // Assert
    verify(specificationDao).makeActive(eq(1L));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1, actualMakeActiveResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationService#makeActive(Long, String)}
   */
  @Test
  void testMakeActive3() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.makeActive(Mockito.<Long>any())).thenReturn(-2);

    // Act
    int actualMakeActiveResult = (new PhysicalSpecificationService(mock(ChangeLogService.class), specificationDao,
        mock(PhysicalSpecificationSearchDao.class))).makeActive(1L, "janedoe");

    // Assert
    verify(specificationDao).makeActive(eq(1L));
    assertEquals(-2, actualMakeActiveResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationService#propagateDataTypesToLogicalFlows(String, long)}
   */
  @Test
  void testPropagateDataTypesToLogicalFlows() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.propagateDataTypesToLogicalFlows(Mockito.<String>any(), anyLong())).thenReturn(1);

    // Act
    int actualPropagateDataTypesToLogicalFlowsResult = (new PhysicalSpecificationService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        specificationDao, mock(PhysicalSpecificationSearchDao.class))).propagateDataTypesToLogicalFlows("janedoe", 1L);

    // Assert
    verify(specificationDao).propagateDataTypesToLogicalFlows(eq("janedoe"), eq(1L));
    assertEquals(1, actualPropagateDataTypesToLogicalFlowsResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationService#propagateDataTypesToLogicalFlows(String, long)}
   */
  @Test
  void testPropagateDataTypesToLogicalFlows2() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.propagateDataTypesToLogicalFlows(Mockito.<String>any(), anyLong()))
        .thenThrow(new UnsupportedOperationException("Username cannot be null"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PhysicalSpecificationService(
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
            specificationDao, mock(PhysicalSpecificationSearchDao.class))).propagateDataTypesToLogicalFlows("janedoe",
                1L));
    verify(specificationDao).propagateDataTypesToLogicalFlows(eq("janedoe"), eq(1L));
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationService#updateAttribute(String, SetAttributeCommand)}
   */
  @Test
  void testUpdateAttribute() {
    // Arrange
    PhysicalSpecificationService physicalSpecificationService = new PhysicalSpecificationService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(PhysicalSpecificationDao.class), mock(PhysicalSpecificationSearchDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    SetAttributeCommand command = mock(SetAttributeCommand.class);
    when(command.name()).thenReturn("Name");
    when(command.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> physicalSpecificationService.updateAttribute("janedoe", command));
    verify(entityReference).id();
    verify(command, atLeast(1)).name();
    verify(command).entityReference();
  }

  /**
   * Method under test:
   * {@link PhysicalSpecificationService#updateAttribute(String, SetAttributeCommand)}
   */
  @Test
  void testUpdateAttribute2() {
    // Arrange
    PhysicalSpecificationService physicalSpecificationService = new PhysicalSpecificationService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(PhysicalSpecificationDao.class), mock(PhysicalSpecificationSearchDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    SetAttributeCommand command = mock(SetAttributeCommand.class);
    when(command.name()).thenThrow(new UnsupportedOperationException("foo"));
    when(command.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> physicalSpecificationService.updateAttribute("janedoe", command));
    verify(entityReference).id();
    verify(command).name();
    verify(command).entityReference();
  }
}
