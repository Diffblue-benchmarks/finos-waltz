package org.finos.waltz.service.change_unit.processors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.change_unit.ChangeAction;
import org.finos.waltz.model.change_unit.ChangeUnit;
import org.finos.waltz.model.change_unit.ExecutionStatus;
import org.finos.waltz.model.change_unit.ImmutableChangeUnit;
import org.finos.waltz.model.change_unit.UpdateExecutionStatusCommand;
import org.finos.waltz.model.command.ImmutableFieldChange;
import org.finos.waltz.model.command.ImmutableFieldChange.Builder;
import org.finos.waltz.service.physical_flow.PhysicalFlowService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RetireCommandProcessorDiffblueTest {
  @Mock private PhysicalFlowService physicalFlowService;

  @InjectMocks private RetireCommandProcessor retireCommandProcessor;

  /**
   * Test {@link RetireCommandProcessor#supportedAction()}.
   *
   * <p>Method under test: {@link RetireCommandProcessor#supportedAction()}
   */
  @Test
  @DisplayName("Test supportedAction()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChangeAction RetireCommandProcessor.supportedAction()"})
  void testSupportedAction() {
    // Arrange, Act and Assert
    assertEquals(
        ChangeAction.RETIRE,
        new RetireCommandProcessor(mock(PhysicalFlowService.class)).supportedAction());
  }

  /**
   * Test {@link RetireCommandProcessor#apply(UpdateExecutionStatusCommand, ChangeUnit, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link RetireCommandProcessor#apply(UpdateExecutionStatusCommand,
   * ChangeUnit, String)}
   */
  @Test
  @DisplayName(
      "Test apply(UpdateExecutionStatusCommand, ChangeUnit, String); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.command.CommandResponse RetireCommandProcessor.apply(UpdateExecutionStatusCommand, ChangeUnit, String)"
  })
  void testApply_thenThrowIllegalArgumentException() {
    // Arrange
    UpdateExecutionStatusCommand command = mock(UpdateExecutionStatusCommand.class);

    Builder<ExecutionStatus> builderResult = ImmutableFieldChange.builder();
    when(command.executionStatus())
        .thenReturn(
            builderResult
                .description("The characteristics of someone or something")
                .newVal(ExecutionStatus.PENDING)
                .oldVal(ExecutionStatus.PENDING)
                .build());

    ImmutableChangeUnit.Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            retireCommandProcessor.apply(
                command,
                provenanceResult
                    .subjectEntity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
                    .build(),
                "janedoe"));
    verify(command).executionStatus();
  }
}
