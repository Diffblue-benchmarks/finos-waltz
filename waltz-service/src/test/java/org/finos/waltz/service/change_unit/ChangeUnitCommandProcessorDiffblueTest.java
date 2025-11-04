package org.finos.waltz.service.change_unit;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.change_unit.ChangeUnit;
import org.finos.waltz.model.change_unit.ExecutionStatus;
import org.finos.waltz.model.change_unit.UpdateExecutionStatusCommand;
import org.finos.waltz.model.command.FieldChange;
import org.finos.waltz.service.change_unit.processors.RetireCommandProcessor;
import org.finos.waltz.service.physical_flow.PhysicalFlowService;
import org.junit.jupiter.api.Test;

class ChangeUnitCommandProcessorDiffblueTest {
  /**
   * Method under test:
   * {@link ChangeUnitCommandProcessor#doBasicValidation(UpdateExecutionStatusCommand, ChangeUnit, String)}
   */
  @Test
  void testDoBasicValidation() {
    // Arrange
    RetireCommandProcessor retireCommandProcessor = new RetireCommandProcessor(mock(PhysicalFlowService.class));
    FieldChange<ExecutionStatus> fieldChange = mock(FieldChange.class);
    when(fieldChange.oldVal()).thenReturn(ExecutionStatus.PENDING);
    UpdateExecutionStatusCommand command = mock(UpdateExecutionStatusCommand.class);
    when(command.executionStatus()).thenReturn(fieldChange);
    ChangeUnit changeUnit = mock(ChangeUnit.class);
    when(changeUnit.executionStatus()).thenReturn(ExecutionStatus.PENDING);

    // Act
    retireCommandProcessor.doBasicValidation(command, changeUnit, "janedoe");

    // Assert that nothing has changed
    verify(changeUnit).executionStatus();
    verify(command).executionStatus();
    verify(fieldChange).oldVal();
  }
}
