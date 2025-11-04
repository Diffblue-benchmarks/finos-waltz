package org.finos.waltz.service.change_unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
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
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.change_unit.ChangeUnitDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
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
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.change_unit.ChangeUnit;
import org.finos.waltz.model.change_unit.ExecutionStatus;
import org.finos.waltz.model.change_unit.UpdateExecutionStatusCommand;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.command.CommandOutcome;
import org.finos.waltz.model.command.CommandResponse;
import org.finos.waltz.model.command.FieldChange;
import org.finos.waltz.model.command.ImmutableCommandResponse;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ChangeUnitServiceDiffblueTest {
  /**
   * Method under test: {@link ChangeUnitService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
    ChangeUnitDao changeUnitDao = mock(ChangeUnitDao.class);
    when(changeUnitDao.getById(anyLong())).thenReturn(null);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    // Act
    ChangeUnit actualById = (new ChangeUnitService(changeLogService, changeUnitDao, new ArrayList<>())).getById(1L);

    // Assert
    verify(changeUnitDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test:
   * {@link ChangeUnitService#findBySubjectRef(EntityReference)}
   */
  @Test
  void testFindBySubjectRef() {
    // Arrange
    ChangeUnitDao changeUnitDao = mock(ChangeUnitDao.class);
    ArrayList<ChangeUnit> changeUnitList = new ArrayList<>();
    when(changeUnitDao.findBySubjectRef(Mockito.<EntityReference>any())).thenReturn(changeUnitList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    // Act
    List<ChangeUnit> actualFindBySubjectRefResult = (new ChangeUnitService(changeLogService, changeUnitDao,
        new ArrayList<>())).findBySubjectRef(null);

    // Assert
    verify(changeUnitDao).findBySubjectRef(isNull());
    assertTrue(actualFindBySubjectRefResult.isEmpty());
    assertSame(changeUnitList, actualFindBySubjectRefResult);
  }

  /**
   * Method under test: {@link ChangeUnitService#findByChangeSetId(long)}
   */
  @Test
  void testFindByChangeSetId() {
    // Arrange
    ChangeUnitDao changeUnitDao = mock(ChangeUnitDao.class);
    ArrayList<ChangeUnit> changeUnitList = new ArrayList<>();
    when(changeUnitDao.findByChangeSetId(anyLong())).thenReturn(changeUnitList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    // Act
    List<ChangeUnit> actualFindByChangeSetIdResult = (new ChangeUnitService(changeLogService, changeUnitDao,
        new ArrayList<>())).findByChangeSetId(1L);

    // Assert
    verify(changeUnitDao).findByChangeSetId(eq(1L));
    assertTrue(actualFindByChangeSetIdResult.isEmpty());
    assertSame(changeUnitList, actualFindByChangeSetIdResult);
  }

  /**
   * Method under test:
   * {@link ChangeUnitService#findBySelector(IdSelectionOptions)}
   */
  @Test
  void testFindBySelector() {
    // Arrange
    ChangeUnitDao changeUnitDao = mock(ChangeUnitDao.class);
    ArrayList<ChangeUnit> changeUnitList = new ArrayList<>();
    when(changeUnitDao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(changeUnitList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    ChangeUnitService changeUnitService = new ChangeUnitService(changeLogService, changeUnitDao, new ArrayList<>());
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<ChangeUnit> actualFindBySelectorResult = changeUnitService.findBySelector(options);

    // Assert
    verify(changeUnitDao).findBySelector(isA(Select.class));
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(changeUnitList, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeUnitService#findBySelector(IdSelectionOptions)}
   */
  @Test
  void testFindBySelector2() {
    // Arrange
    ChangeUnitDao changeUnitDao = mock(ChangeUnitDao.class);
    ArrayList<ChangeUnit> changeUnitList = new ArrayList<>();
    when(changeUnitDao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(changeUnitList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    ChangeUnitService changeUnitService = new ChangeUnitService(changeLogService, changeUnitDao, new ArrayList<>());
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
    List<ChangeUnit> actualFindBySelectorResult = changeUnitService.findBySelector(options);

    // Assert
    verify(changeUnitDao).findBySelector(isA(Select.class));
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(changeUnitList, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeUnitService#findBySelector(IdSelectionOptions)}
   */
  @Test
  void testFindBySelector3() {
    // Arrange
    ChangeUnitDao changeUnitDao = mock(ChangeUnitDao.class);
    ArrayList<ChangeUnit> changeUnitList = new ArrayList<>();
    when(changeUnitDao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(changeUnitList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    ChangeUnitService changeUnitService = new ChangeUnitService(changeLogService, changeUnitDao, new ArrayList<>());
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<ChangeUnit> actualFindBySelectorResult = changeUnitService.findBySelector(options);

    // Assert
    verify(changeUnitDao).findBySelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(changeUnitList, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeUnitService#findBySelector(IdSelectionOptions)}
   */
  @Test
  void testFindBySelector4() {
    // Arrange
    ChangeUnitDao changeUnitDao = mock(ChangeUnitDao.class);
    ArrayList<ChangeUnit> changeUnitList = new ArrayList<>();
    when(changeUnitDao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(changeUnitList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    ChangeUnitService changeUnitService = new ChangeUnitService(changeLogService, changeUnitDao, new ArrayList<>());
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.CHANGE_SET);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<ChangeUnit> actualFindBySelectorResult = changeUnitService.findBySelector(options);

    // Assert
    verify(changeUnitDao).findBySelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(changeUnitList, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link ChangeUnitService#updateExecutionStatus(UpdateExecutionStatusCommand, String)}
   */
  @Test
  void testUpdateExecutionStatus() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    ChangeUnitDao changeUnitDao = mock(ChangeUnitDao.class);
    when(changeUnitDao.updateExecutionStatus(Mockito.<UpdateExecutionStatusCommand>any())).thenReturn(true);
    ChangeUnitService changeUnitService = new ChangeUnitService(changeLogService, changeUnitDao, new ArrayList<>());
    FieldChange<ExecutionStatus> fieldChange = mock(FieldChange.class);
    when(fieldChange.newVal()).thenReturn(ExecutionStatus.PENDING);
    UpdateExecutionStatusCommand command = mock(UpdateExecutionStatusCommand.class);
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(command.lastUpdate()).thenReturn(ofResult);
    when(command.id()).thenReturn(1L);
    when(command.executionStatus()).thenReturn(fieldChange);

    // Act
    CommandResponse<UpdateExecutionStatusCommand> actualUpdateExecutionStatusResult = changeUnitService
        .updateExecutionStatus(command, "janedoe");

    // Assert
    verify(changeUnitDao).updateExecutionStatus(isA(UpdateExecutionStatusCommand.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(command, atLeast(1)).executionStatus();
    verify(command, atLeast(1)).id();
    verify(command).lastUpdate();
    verify(fieldChange).newVal();
    EntityReference entityReferenceResult = actualUpdateExecutionStatusResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualUpdateExecutionStatusResult instanceof ImmutableCommandResponse);
    assertNull(entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.CHANGE_UNIT, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(CommandOutcome.SUCCESS, actualUpdateExecutionStatusResult.outcome());
    assertSame(command, actualUpdateExecutionStatusResult.originalCommand());
  }

  /**
   * Method under test:
   * {@link ChangeUnitService#updateExecutionStatus(UpdateExecutionStatusCommand, String)}
   */
  @Test
  void testUpdateExecutionStatus2() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeUnitDao changeUnitDao = mock(ChangeUnitDao.class);
    when(changeUnitDao.updateExecutionStatus(Mockito.<UpdateExecutionStatusCommand>any())).thenReturn(true);
    ChangeUnitService changeUnitService = new ChangeUnitService(changeLogService, changeUnitDao, new ArrayList<>());
    FieldChange<ExecutionStatus> fieldChange = mock(FieldChange.class);
    when(fieldChange.newVal()).thenReturn(ExecutionStatus.PENDING);
    UpdateExecutionStatusCommand command = mock(UpdateExecutionStatusCommand.class);
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(command.lastUpdate()).thenReturn(ofResult);
    when(command.id()).thenReturn(1L);
    when(command.executionStatus()).thenReturn(fieldChange);

    // Act
    CommandResponse<UpdateExecutionStatusCommand> actualUpdateExecutionStatusResult = changeUnitService
        .updateExecutionStatus(command, "janedoe");

    // Assert
    verify(changeUnitDao).updateExecutionStatus(isA(UpdateExecutionStatusCommand.class));
    verify(command, atLeast(1)).executionStatus();
    verify(command, atLeast(1)).id();
    verify(command).lastUpdate();
    verify(fieldChange).newVal();
    verify(changeLogService).write(isA(ChangeLog.class));
    EntityReference entityReferenceResult = actualUpdateExecutionStatusResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualUpdateExecutionStatusResult instanceof ImmutableCommandResponse);
    assertNull(entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.CHANGE_UNIT, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(CommandOutcome.SUCCESS, actualUpdateExecutionStatusResult.outcome());
    assertSame(command, actualUpdateExecutionStatusResult.originalCommand());
  }

  /**
   * Method under test:
   * {@link ChangeUnitService#updateExecutionStatus(UpdateExecutionStatusCommand, String)}
   */
  @Test
  void testUpdateExecutionStatus3() {
    // Arrange
    ChangeUnitDao changeUnitDao = mock(ChangeUnitDao.class);
    when(changeUnitDao.updateExecutionStatus(Mockito.<UpdateExecutionStatusCommand>any())).thenReturn(false);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    ChangeUnitService changeUnitService = new ChangeUnitService(changeLogService, changeUnitDao, new ArrayList<>());
    FieldChange<ExecutionStatus> fieldChange = mock(FieldChange.class);
    when(fieldChange.newVal()).thenReturn(ExecutionStatus.PENDING);
    UpdateExecutionStatusCommand command = mock(UpdateExecutionStatusCommand.class);
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(command.lastUpdate()).thenReturn(ofResult);
    when(command.id()).thenReturn(1L);
    when(command.executionStatus()).thenReturn(fieldChange);

    // Act
    CommandResponse<UpdateExecutionStatusCommand> actualUpdateExecutionStatusResult = changeUnitService
        .updateExecutionStatus(command, "janedoe");

    // Assert
    verify(changeUnitDao).updateExecutionStatus(isA(UpdateExecutionStatusCommand.class));
    verify(command, atLeast(1)).executionStatus();
    verify(command, atLeast(1)).id();
    verify(command).lastUpdate();
    verify(fieldChange).newVal();
    EntityReference entityReferenceResult = actualUpdateExecutionStatusResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualUpdateExecutionStatusResult instanceof ImmutableCommandResponse);
    assertNull(entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.CHANGE_UNIT, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(CommandOutcome.FAILURE, actualUpdateExecutionStatusResult.outcome());
    assertSame(command, actualUpdateExecutionStatusResult.originalCommand());
  }
}
