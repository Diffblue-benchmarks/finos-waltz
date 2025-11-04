package org.finos.waltz.service.change_unit.processors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.finos.waltz.data.attribute_change.AttributeChangeDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.change_unit.ChangeAction;
import org.finos.waltz.model.change_unit.ChangeUnit;
import org.finos.waltz.model.change_unit.ExecutionStatus;
import org.finos.waltz.model.change_unit.UpdateExecutionStatusCommand;
import org.finos.waltz.model.command.FieldChange;
import org.finos.waltz.service.attribute_change.AttributeChangeService;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.data_type.DataTypeDecoratorService;
import org.finos.waltz.service.external_identifier.ExternalIdentifierService;
import org.finos.waltz.service.logical_flow.LogicalFlowService;
import org.finos.waltz.service.permission.permission_checker.FlowPermissionChecker;
import org.finos.waltz.service.physical_flow.PhysicalFlowService;
import org.finos.waltz.service.physical_specification.PhysicalSpecificationService;
import org.junit.jupiter.api.Test;

class ModifyCommandProcessorDiffblueTest {
  /**
   * Method under test: {@link ModifyCommandProcessor#supportedAction()}
   */
  @Test
  void testSupportedAction() {
    // Arrange
    AttributeChangeService attributeChangeService = new AttributeChangeService(mock(AttributeChangeDao.class));
    PhysicalFlowService physicalFlowService = mock(PhysicalFlowService.class);

    // Act and Assert
    assertEquals(ChangeAction.MODIFY,
        (new ModifyCommandProcessor(attributeChangeService, physicalFlowService, new ArrayList<>())).supportedAction());
  }

  /**
   * Method under test:
   * {@link ModifyCommandProcessor#apply(UpdateExecutionStatusCommand, ChangeUnit, String)}
   */
  @Test
  void testApply() {
    // Arrange
    AttributeChangeService attributeChangeService = new AttributeChangeService(mock(AttributeChangeDao.class));
    PhysicalFlowService physicalFlowService = new PhysicalFlowService(mock(ChangeLogService.class),
        mock(LogicalFlowService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationService.class),
        mock(ExternalIdentifierService.class), mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class));

    ModifyCommandProcessor modifyCommandProcessor = new ModifyCommandProcessor(attributeChangeService,
        physicalFlowService, new ArrayList<>());
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
    assertThrows(IllegalArgumentException.class, () -> modifyCommandProcessor.apply(command, changeUnit, "janedoe"));
    verify(entityReference, atLeast(1)).kind();
    verify(changeUnit).executionStatus();
    verify(changeUnit, atLeast(1)).subjectEntity();
    verify(command).executionStatus();
    verify(fieldChange).oldVal();
  }
}
