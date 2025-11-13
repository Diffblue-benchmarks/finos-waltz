package org.finos.waltz.service.change_unit;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.change_unit.ChangeUnit;
import org.finos.waltz.model.change_unit.ExecutionStatus;
import org.finos.waltz.model.change_unit.UpdateExecutionStatusCommand;
import org.finos.waltz.model.command.ImmutableFieldChange;
import org.finos.waltz.model.command.ImmutableFieldChange.Builder;
import org.finos.waltz.service.change_unit.processors.RetireCommandProcessor;
import org.finos.waltz.service.physical_flow.PhysicalFlowService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ChangeUnitCommandProcessorDiffblueTest {
  @Mock private PhysicalFlowService physicalFlowService;

  /**
   * Test {@link ChangeUnitCommandProcessor#doBasicValidation(UpdateExecutionStatusCommand,
   * ChangeUnit, String)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeUnit#executionStatus()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeUnitCommandProcessor#doBasicValidation(UpdateExecutionStatusCommand, ChangeUnit, String)}
   */
  @Test
  @DisplayName(
      "Test doBasicValidation(UpdateExecutionStatusCommand, ChangeUnit, String); then calls executionStatus()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChangeUnitCommandProcessor.doBasicValidation(UpdateExecutionStatusCommand, ChangeUnit, String)"
  })
  void testDoBasicValidation_thenCallsExecutionStatus() {
    // Arrange
    RetireCommandProcessor retireCommandProcessor = new RetireCommandProcessor(physicalFlowService);

    UpdateExecutionStatusCommand command = mock(UpdateExecutionStatusCommand.class);

    Builder<ExecutionStatus> builderResult = ImmutableFieldChange.builder();
    when(command.executionStatus())
        .thenReturn(
            builderResult
                .description("The characteristics of someone or something")
                .newVal(ExecutionStatus.PENDING)
                .oldVal(ExecutionStatus.PENDING)
                .build());

    ChangeUnit changeUnit = mock(ChangeUnit.class);
    when(changeUnit.executionStatus()).thenReturn(ExecutionStatus.PENDING);

    // Act
    retireCommandProcessor.doBasicValidation(command, changeUnit, "janedoe");

    // Assert
    verify(changeUnit).executionStatus();
    verify(command).executionStatus();
  }
}
