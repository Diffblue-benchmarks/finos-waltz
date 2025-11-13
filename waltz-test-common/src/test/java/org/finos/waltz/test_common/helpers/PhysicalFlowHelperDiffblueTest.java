package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
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
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableUserTimestamp;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.command.CommandOutcome;
import org.finos.waltz.model.physical_flow.CriticalityValue;
import org.finos.waltz.model.physical_flow.FrequencyKindValue;
import org.finos.waltz.model.physical_flow.ImmutableFlowAttributes;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowCreateCommand;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowCreateCommandResponse;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowDeleteCommand;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowDeleteCommandResponse;
import org.finos.waltz.model.physical_flow.PhysicalFlowCreateCommand;
import org.finos.waltz.model.physical_flow.PhysicalFlowCreateCommandResponse;
import org.finos.waltz.model.physical_flow.PhysicalFlowDeleteCommand;
import org.finos.waltz.model.physical_flow.PhysicalFlowDeleteCommandResponse;
import org.finos.waltz.model.physical_flow.TransportKindValue;
import org.finos.waltz.model.physical_specification.DataFormatKindValue;
import org.finos.waltz.model.physical_specification.ImmutablePhysicalSpecification;
import org.finos.waltz.model.physical_specification.ImmutablePhysicalSpecification.Builder;
import org.finos.waltz.schema.tables.records.PhysicalFlowRecord;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.physical_flow.PhysicalFlowService;
import org.finos.waltz.service.physical_specification.PhysicalSpecificationService;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PhysicalFlowHelperDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private PhysicalFlowHelper physicalFlowHelper;

  /**
   * Test {@link PhysicalFlowHelper#createPhysicalFlow(Long, Long, String)}.
   *
   * <p>Method under test: {@link PhysicalFlowHelper#createPhysicalFlow(Long, Long, String)}
   */
  @Test
  @DisplayName("Test createPhysicalFlow(Long, Long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PhysicalFlowCreateCommandResponse PhysicalFlowHelper.createPhysicalFlow(Long, Long, String)"
  })
  void testCreatePhysicalFlow() {
    // Arrange
    PhysicalFlowService physicalFlowService = mock(PhysicalFlowService.class);

    ImmutablePhysicalFlowCreateCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowCreateCommandResponse.builder();

    ImmutablePhysicalFlowCreateCommandResponse.Builder messageResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .message("Not all who wander are lost");

    ImmutablePhysicalFlowCreateCommand.Builder builderResult2 =
        ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    ImmutablePhysicalFlowCreateCommand.Builder logicalFlowIdResult =
        builderResult2
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    ImmutablePhysicalFlowCreateCommand.Builder addAllDataTypeIdsResult =
        logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    Builder builderResult3 = ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder externalIdResult2 =
        builderResult3
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    when(physicalFlowService.create(
            Mockito.<PhysicalFlowCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(
            messageResult
                .originalCommand(
                    addAllDataTypeIdsResult
                        .specification(
                            nameResult2
                                .owningEntity(
                                    ImmutableEntityReference.builder()
                                        .description("The characteristics of someone or something")
                                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                        .externalId("42")
                                        .id(1L)
                                        .kind(EntityKind.ALL)
                                        .name("Name")
                                        .build())
                                .provenance("Provenance")
                                .build())
                        .build())
                .outcome(CommandOutcome.SUCCESS)
                .build());

    PhysicalSpecificationService physicalSpecificationService =
        mock(PhysicalSpecificationService.class);

    Builder builderResult4 = ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    Builder externalIdResult3 =
        builderResult4
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult3 =
        externalIdResult3
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    when(physicalSpecificationService.getById(anyLong()))
        .thenReturn(
            nameResult3
                .owningEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .provenance("Provenance")
                .build());

    PhysicalFlowHelper physicalFlowHelper =
        new PhysicalFlowHelper(
            physicalFlowService,
            physicalSpecificationService,
            new DefaultDSLContext(SQLDialect.SQL99));

    // Act
    PhysicalFlowCreateCommandResponse actualCreatePhysicalFlowResult =
        physicalFlowHelper.createPhysicalFlow(1L, 1L, "Name");

    // Assert
    verify(physicalFlowService)
        .create(
            isA(PhysicalFlowCreateCommand.class), eq("Name_c5906efb-19d0-4eeb-8c6e-2152fe7f72e3"));
    verify(physicalSpecificationService).getById(1L);
    EntityReference entityReferenceResult = actualCreatePhysicalFlowResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    PhysicalFlowCreateCommand originalCommandResult =
        actualCreatePhysicalFlowResult.originalCommand();
    assertTrue(originalCommandResult.flowAttributes() instanceof ImmutableFlowAttributes);
    assertTrue(originalCommandResult instanceof ImmutablePhysicalFlowCreateCommand);
    assertTrue(
        actualCreatePhysicalFlowResult instanceof ImmutablePhysicalFlowCreateCommandResponse);
    assertTrue(originalCommandResult.specification() instanceof ImmutablePhysicalSpecification);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, originalCommandResult.logicalFlowId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(CommandOutcome.SUCCESS, actualCreatePhysicalFlowResult.outcome());
    assertTrue(originalCommandResult.dataTypeIds().isEmpty());
  }

  /**
   * Test {@link PhysicalFlowHelper#deletePhysicalFlow(Long)}.
   *
   * <p>Method under test: {@link PhysicalFlowHelper#deletePhysicalFlow(Long)}
   */
  @Test
  @DisplayName("Test deletePhysicalFlow(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PhysicalFlowDeleteCommandResponse PhysicalFlowHelper.deletePhysicalFlow(Long)"
  })
  void testDeletePhysicalFlow() {
    // Arrange
    PhysicalFlowService physicalFlowService = mock(PhysicalFlowService.class);

    ImmutablePhysicalFlowDeleteCommandResponse.Builder builderResult =
        ImmutablePhysicalFlowDeleteCommandResponse.builder();

    ImmutablePhysicalFlowDeleteCommandResponse.Builder messageResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isLastPhysicalFlow(true)
            .isSpecificationUnused(true)
            .message("Not all who wander are lost");
    when(physicalFlowService.delete(
            Mockito.<PhysicalFlowDeleteCommand>any(), Mockito.<String>any()))
        .thenReturn(
            messageResult
                .originalCommand(ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build())
                .outcome(CommandOutcome.SUCCESS)
                .build());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService,
            mock(PhysicalSpecificationDao.class),
            mock(PhysicalSpecificationSearchDao.class));

    PhysicalFlowHelper physicalFlowHelper =
        new PhysicalFlowHelper(
            physicalFlowService,
            physicalSpecificationService,
            new DefaultDSLContext(SQLDialect.SQL99));

    // Act
    PhysicalFlowDeleteCommandResponse actualDeletePhysicalFlowResult =
        physicalFlowHelper.deletePhysicalFlow(1L);

    // Assert
    verify(physicalFlowService)
        .delete(
            isA(PhysicalFlowDeleteCommand.class),
            eq("deletingFlow_7c2184f0-4c0a-4369-83af-277f00b3256d"));
    EntityReference entityReferenceResult = actualDeletePhysicalFlowResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    PhysicalFlowDeleteCommand originalCommandResult =
        actualDeletePhysicalFlowResult.originalCommand();
    assertTrue(originalCommandResult instanceof ImmutablePhysicalFlowDeleteCommand);
    assertTrue(
        actualDeletePhysicalFlowResult instanceof ImmutablePhysicalFlowDeleteCommandResponse);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, originalCommandResult.flowId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(CommandOutcome.SUCCESS, actualDeletePhysicalFlowResult.outcome());
    assertTrue(actualDeletePhysicalFlowResult.isLastPhysicalFlow());
    assertTrue(actualDeletePhysicalFlowResult.isSpecificationUnused());
  }

  /**
   * Test {@link PhysicalFlowHelper#markFlowAsReadOnly(long)}.
   *
   * <p>Method under test: {@link PhysicalFlowHelper#markFlowAsReadOnly(long)}
   */
  @Test
  @DisplayName("Test markFlowAsReadOnly(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhysicalFlowHelper.markFlowAsReadOnly(long)"})
  void testMarkFlowAsReadOnly() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<PhysicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<PhysicalFlowRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    physicalFlowHelper.markFlowAsReadOnly(1L);

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Test {@link PhysicalFlowHelper#updateExternalIdOnFlowDirectly(long, String)}.
   *
   * <p>Method under test: {@link PhysicalFlowHelper#updateExternalIdOnFlowDirectly(long, String)}
   */
  @Test
  @DisplayName("Test updateExternalIdOnFlowDirectly(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhysicalFlowHelper.updateExternalIdOnFlowDirectly(long, String)"})
  void testUpdateExternalIdOnFlowDirectly() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<PhysicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<PhysicalFlowRecord>>any()))
        .thenReturn(updateSetFirstStep);

    // Act
    physicalFlowHelper.updateExternalIdOnFlowDirectly(1L, "42");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }
}
