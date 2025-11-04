package org.finos.waltz.service.change_unit.processors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.change_unit.ChangeAction;
import org.finos.waltz.model.change_unit.ChangeUnit;
import org.finos.waltz.model.change_unit.ExecutionStatus;
import org.finos.waltz.model.change_unit.UpdateExecutionStatusCommand;
import org.finos.waltz.model.command.FieldChange;
import org.finos.waltz.service.physical_flow.PhysicalFlowService;
import org.junit.jupiter.api.Test;

class RetireCommandProcessorDiffblueTest {
  /**
   * Method under test: {@link RetireCommandProcessor#supportedAction()}
   */
  @Test
  void testSupportedAction() {
    // Arrange, Act and Assert
    assertEquals(ChangeAction.RETIRE, (new RetireCommandProcessor(mock(PhysicalFlowService.class))).supportedAction());
  }

  /**
   * Method under test:
   * {@link RetireCommandProcessor#apply(UpdateExecutionStatusCommand, ChangeUnit, String)}
   */
  @Test
  void testApply() {
    // Arrange
    RetireCommandProcessor retireCommandProcessor = new RetireCommandProcessor(mock(PhysicalFlowService.class));
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
    assertThrows(IllegalArgumentException.class, () -> retireCommandProcessor.apply(command, changeUnit, "janedoe"));
    verify(entityReference, atLeast(1)).kind();
    verify(changeUnit).executionStatus();
    verify(changeUnit, atLeast(1)).subjectEntity();
    verify(command).executionStatus();
    verify(fieldChange).oldVal();
  }
}
