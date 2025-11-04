package org.finos.waltz.service.change_unit.processors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.change_unit.ChangeAction;
import org.finos.waltz.model.change_unit.ChangeUnit;
import org.finos.waltz.model.change_unit.ExecutionStatus;
import org.finos.waltz.model.change_unit.UpdateExecutionStatusCommand;
import org.finos.waltz.model.command.FieldChange;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.physical_flow.PhysicalFlowService;
import org.junit.jupiter.api.Test;

class ActivateCommandProcessorDiffblueTest {
  /**
   * Method under test: {@link ActivateCommandProcessor#supportedAction()}
   */
  @Test
  void testSupportedAction() {
    // Arrange, Act and Assert
    assertEquals(ChangeAction.ACTIVATE,
        (new ActivateCommandProcessor(
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
            mock(PhysicalFlowService.class))).supportedAction());
  }

  /**
   * Method under test:
   * {@link ActivateCommandProcessor#apply(UpdateExecutionStatusCommand, ChangeUnit, String)}
   */
  @Test
  void testApply() {
    // Arrange
    ActivateCommandProcessor activateCommandProcessor = new ActivateCommandProcessor(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(PhysicalFlowService.class));
    FieldChange<ExecutionStatus> fieldChange = mock(FieldChange.class);
    when(fieldChange.oldVal()).thenReturn(ExecutionStatus.PENDING);
    UpdateExecutionStatusCommand command = mock(UpdateExecutionStatusCommand.class);
    when(command.executionStatus()).thenReturn(fieldChange);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    ChangeUnit changeUnit = mock(ChangeUnit.class);
    when(changeUnit.subjectEntity()).thenReturn(entityReference);
    when(changeUnit.executionStatus()).thenReturn(ExecutionStatus.PENDING);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> activateCommandProcessor.apply(command, changeUnit, "janedoe"));
    verify(entityReference, atLeast(1)).kind();
    verify(changeUnit).executionStatus();
    verify(changeUnit, atLeast(1)).subjectEntity();
    verify(command).executionStatus();
    verify(fieldChange).oldVal();
  }
}
