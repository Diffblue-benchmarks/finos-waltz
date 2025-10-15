package org.finos.waltz.service.change_unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
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
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.ImmutableUserTimestamp;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.change_unit.ChangeAction;
import org.finos.waltz.model.change_unit.ChangeUnit;
import org.finos.waltz.model.change_unit.ExecutionStatus;
import org.finos.waltz.model.change_unit.ImmutableChangeUnit;
import org.finos.waltz.model.change_unit.ImmutableUpdateExecutionStatusCommand;
import org.finos.waltz.model.change_unit.UpdateExecutionStatusCommand;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.command.CommandOutcome;
import org.finos.waltz.model.command.CommandResponse;
import org.finos.waltz.model.command.ImmutableCommandResponse;
import org.finos.waltz.model.command.ImmutableFieldChange;
import org.finos.waltz.model.command.ImmutableFieldChange.Builder;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ChangeUnitServiceDiffblueTest {
  @Mock private ChangeLogService changeLogService;

  @Mock private ChangeUnitDao changeUnitDao;

  @InjectMocks private ChangeUnitService changeUnitService;

  @Mock private List<ChangeUnitCommandProcessor> list;

  /**
   * Test {@link ChangeUnitService#getById(long)}.
   *
   * <p>Method under test: {@link ChangeUnitService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChangeUnit ChangeUnitService.getById(long)"})
  void testGetById() {
    // Arrange
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
    when(changeUnitDao.getById(anyLong()))
        .thenReturn(
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
                .build());

    // Act
    ChangeUnit actualById = changeUnitService.getById(1L);

    // Assert
    verify(changeUnitDao).getById(1L);
    assertTrue(actualById.subjectEntity() instanceof ImmutableEntityReference);
    assertTrue(actualById instanceof ImmutableChangeUnit);
    assertEquals("2020-03-01", actualById.lastUpdatedBy());
    assertEquals("Name", actualById.name());
    assertEquals("Provenance", actualById.provenance());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(EntityKind.ALL, actualById.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualById.subjectInitialStatus());
    assertEquals(ChangeAction.ACTIVATE, actualById.action());
    assertEquals(ExecutionStatus.PENDING, actualById.executionStatus());
  }

  /**
   * Test {@link ChangeUnitService#findBySubjectRef(EntityReference)}.
   *
   * <p>Method under test: {@link ChangeUnitService#findBySubjectRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findBySubjectRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChangeUnitService.findBySubjectRef(EntityReference)"})
  void testFindBySubjectRef() {
    // Arrange
    when(changeUnitDao.findBySubjectRef(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<ChangeUnit> actualFindBySubjectRefResult = changeUnitService.findBySubjectRef(null);

    // Assert
    verify(changeUnitDao).findBySubjectRef(isNull());
    assertTrue(actualFindBySubjectRefResult.isEmpty());
  }

  /**
   * Test {@link ChangeUnitService#findByChangeSetId(long)}.
   *
   * <p>Method under test: {@link ChangeUnitService#findByChangeSetId(long)}
   */
  @Test
  @DisplayName("Test findByChangeSetId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChangeUnitService.findByChangeSetId(long)"})
  void testFindByChangeSetId() {
    // Arrange
    when(changeUnitDao.findByChangeSetId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    List<ChangeUnit> actualFindByChangeSetIdResult = changeUnitService.findByChangeSetId(1L);

    // Assert
    verify(changeUnitDao).findByChangeSetId(1L);
    assertTrue(actualFindByChangeSetIdResult.isEmpty());
  }

  /**
   * Test {@link ChangeUnitService#findBySelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ChangeUnitService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChangeUnitService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector() {
    // Arrange
    when(changeUnitDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    List<ChangeUnit> actualFindBySelectorResult = changeUnitService.findBySelector(options);

    // Assert
    verify(changeUnitDao).findBySelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ChangeUnitService#findBySelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ChangeUnitService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChangeUnitService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector2() {
    // Arrange
    when(changeUnitDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Act
    List<ChangeUnit> actualFindBySelectorResult = changeUnitService.findBySelector(options);

    // Assert
    verify(changeUnitDao).findBySelector(isA(Select.class));
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ChangeUnitService#findBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given builder addOmitApplicationKinds {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeUnitService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(IdSelectionOptions); given builder addOmitApplicationKinds 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChangeUnitService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector_givenBuilderAddOmitApplicationKindsInHouse() {
    // Arrange
    when(changeUnitDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
    ImmutableSelectionFilters immutableSelectionFilters = builderResult.build();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(immutableSelectionFilters);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    List<ChangeUnit> actualFindBySelectorResult = changeUnitService.findBySelector(options);

    // Assert
    verify(changeUnitDao).findBySelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ChangeUnitService#findBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HierarchyQueryScope#EXACT}.
   *   <li>Then calls {@link IdSelectionOptions#scope()}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeUnitService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions); given EXACT; then calls scope()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChangeUnitService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector_givenExact_thenCallsScope() {
    // Arrange
    when(changeUnitDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act
    List<ChangeUnit> actualFindBySelectorResult = changeUnitService.findBySelector(options);

    // Assert
    verify(changeUnitDao).findBySelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ChangeUnitService#findBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code EXACT}.
   *   <li>When {@link IdSelectionOptions} {@link IdSelectionOptions#scope()} return {@code EXACT}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeUnitService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(IdSelectionOptions); given 'EXACT'; when IdSelectionOptions scope() return 'EXACT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChangeUnitService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector_givenExact_whenIdSelectionOptionsScopeReturnExact() {
    // Arrange
    when(changeUnitDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act
    List<ChangeUnit> actualFindBySelectorResult = changeUnitService.findBySelector(options);

    // Assert
    verify(changeUnitDao).findBySelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ChangeUnitService#findBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeUnitService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions); given HashSet() add 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChangeUnitService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector_givenHashSetAddActive() {
    // Arrange
    when(changeUnitDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    List<ChangeUnit> actualFindBySelectorResult = changeUnitService.findBySelector(options);

    // Assert
    verify(changeUnitDao).findBySelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ChangeUnitService#findBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeUnitService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions); given HashSet() add 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChangeUnitService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector_givenHashSetAddPending() {
    // Arrange
    when(changeUnitDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.PENDING);
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    List<ChangeUnit> actualFindBySelectorResult = changeUnitService.findBySelector(options);

    // Assert
    verify(changeUnitDao).findBySelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    assertTrue(actualFindBySelectorResult.isEmpty());
  }

  /**
   * Test {@link ChangeUnitService#updateExecutionStatus(UpdateExecutionStatusCommand, String)}.
   *
   * <p>Method under test: {@link
   * ChangeUnitService#updateExecutionStatus(UpdateExecutionStatusCommand, String)}
   */
  @Test
  @DisplayName("Test updateExecutionStatus(UpdateExecutionStatusCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommandResponse ChangeUnitService.updateExecutionStatus(UpdateExecutionStatusCommand, String)"
  })
  void testUpdateExecutionStatus() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(changeUnitDao.updateExecutionStatus(Mockito.<UpdateExecutionStatusCommand>any()))
        .thenReturn(true);

    ImmutableUpdateExecutionStatusCommand.Builder builderResult =
        ImmutableUpdateExecutionStatusCommand.builder();

    Builder<ExecutionStatus> builderResult2 = ImmutableFieldChange.builder();

    ImmutableUpdateExecutionStatusCommand.Builder idResult =
        builderResult
            .executionStatus(
                builderResult2
                    .description("The characteristics of someone or something")
                    .newVal(ExecutionStatus.PENDING)
                    .oldVal(ExecutionStatus.PENDING)
                    .build())
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdate = Optional.of(immutableUserTimestamp);
    ImmutableUpdateExecutionStatusCommand command = idResult.lastUpdate(lastUpdate).build();

    // Act
    CommandResponse<UpdateExecutionStatusCommand> actualUpdateExecutionStatusResult =
        changeUnitService.updateExecutionStatus(command, "janedoe");

    // Assert
    verify(changeUnitDao).updateExecutionStatus(isA(UpdateExecutionStatusCommand.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateExecutionStatusResult instanceof ImmutableCommandResponse);
    assertSame(command, actualUpdateExecutionStatusResult.originalCommand());
  }

  /**
   * Test {@link ChangeUnitService#updateExecutionStatus(UpdateExecutionStatusCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeUnitService#updateExecutionStatus(UpdateExecutionStatusCommand, String)}
   */
  @Test
  @DisplayName(
      "Test updateExecutionStatus(UpdateExecutionStatusCommand, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommandResponse ChangeUnitService.updateExecutionStatus(UpdateExecutionStatusCommand, String)"
  })
  void testUpdateExecutionStatus_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    ChangeUnitDao changeUnitDao = mock(ChangeUnitDao.class);
    when(changeUnitDao.updateExecutionStatus(Mockito.<UpdateExecutionStatusCommand>any()))
        .thenReturn(true);

    ChangeUnitService changeUnitService =
        new ChangeUnitService(changeLogService, changeUnitDao, new ArrayList<>());

    UpdateExecutionStatusCommand command = mock(UpdateExecutionStatusCommand.class);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<UserTimestamp> ofResult = Optional.of(immutableUserTimestamp);
    when(command.lastUpdate()).thenReturn(ofResult);
    when(command.id()).thenReturn(1L);

    Builder<ExecutionStatus> builderResult = ImmutableFieldChange.builder();
    when(command.executionStatus())
        .thenReturn(
            builderResult
                .description("The characteristics of someone or something")
                .newVal(ExecutionStatus.PENDING)
                .oldVal(ExecutionStatus.PENDING)
                .build());

    // Act
    CommandResponse<UpdateExecutionStatusCommand> actualUpdateExecutionStatusResult =
        changeUnitService.updateExecutionStatus(command, "janedoe");

    // Assert
    verify(changeUnitDao).updateExecutionStatus(isA(UpdateExecutionStatusCommand.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(command, atLeast(1)).executionStatus();
    verify(command, atLeast(1)).id();
    verify(command).lastUpdate();
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
   * Test {@link ChangeUnitService#updateExecutionStatus(UpdateExecutionStatusCommand, String)}.
   *
   * <ul>
   *   <li>Given empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeUnitService#updateExecutionStatus(UpdateExecutionStatusCommand, String)}
   */
  @Test
  @DisplayName("Test updateExecutionStatus(UpdateExecutionStatusCommand, String); given empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommandResponse ChangeUnitService.updateExecutionStatus(UpdateExecutionStatusCommand, String)"
  })
  void testUpdateExecutionStatus_givenEmpty() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(changeUnitDao.updateExecutionStatus(Mockito.<UpdateExecutionStatusCommand>any()))
        .thenReturn(true);

    UpdateExecutionStatusCommand command = mock(UpdateExecutionStatusCommand.class);
    Optional<UserTimestamp> emptyResult = Optional.empty();
    when(command.lastUpdate()).thenReturn(emptyResult);
    when(command.id()).thenReturn(1L);

    Builder<ExecutionStatus> builderResult = ImmutableFieldChange.builder();
    when(command.executionStatus())
        .thenReturn(
            builderResult
                .description("The characteristics of someone or something")
                .newVal(ExecutionStatus.PENDING)
                .oldVal(ExecutionStatus.PENDING)
                .build());

    // Act
    CommandResponse<UpdateExecutionStatusCommand> actualUpdateExecutionStatusResult =
        changeUnitService.updateExecutionStatus(command, "janedoe");

    // Assert
    verify(changeUnitDao).updateExecutionStatus(isA(UpdateExecutionStatusCommand.class));
    verify(command, atLeast(1)).executionStatus();
    verify(command, atLeast(1)).id();
    verify(command).lastUpdate();
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
   * Test {@link ChangeUnitService#updateExecutionStatus(UpdateExecutionStatusCommand, String)}.
   *
   * <ul>
   *   <li>Then return outcome is {@code FAILURE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeUnitService#updateExecutionStatus(UpdateExecutionStatusCommand, String)}
   */
  @Test
  @DisplayName(
      "Test updateExecutionStatus(UpdateExecutionStatusCommand, String); then return outcome is 'FAILURE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommandResponse ChangeUnitService.updateExecutionStatus(UpdateExecutionStatusCommand, String)"
  })
  void testUpdateExecutionStatus_thenReturnOutcomeIsFailure() {
    // Arrange
    when(changeUnitDao.updateExecutionStatus(Mockito.<UpdateExecutionStatusCommand>any()))
        .thenReturn(false);

    UpdateExecutionStatusCommand command = mock(UpdateExecutionStatusCommand.class);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<UserTimestamp> ofResult = Optional.of(immutableUserTimestamp);
    when(command.lastUpdate()).thenReturn(ofResult);
    when(command.id()).thenReturn(1L);

    Builder<ExecutionStatus> builderResult = ImmutableFieldChange.builder();
    when(command.executionStatus())
        .thenReturn(
            builderResult
                .description("The characteristics of someone or something")
                .newVal(ExecutionStatus.PENDING)
                .oldVal(ExecutionStatus.PENDING)
                .build());

    // Act
    CommandResponse<UpdateExecutionStatusCommand> actualUpdateExecutionStatusResult =
        changeUnitService.updateExecutionStatus(command, "janedoe");

    // Assert
    verify(changeUnitDao).updateExecutionStatus(isA(UpdateExecutionStatusCommand.class));
    verify(command, atLeast(1)).executionStatus();
    verify(command, atLeast(1)).id();
    verify(command).lastUpdate();
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

  /**
   * Test {@link ChangeUnitService#updateExecutionStatus(UpdateExecutionStatusCommand, String)}.
   *
   * <ul>
   *   <li>Then return outcome is {@code SUCCESS}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChangeUnitService#updateExecutionStatus(UpdateExecutionStatusCommand, String)}
   */
  @Test
  @DisplayName(
      "Test updateExecutionStatus(UpdateExecutionStatusCommand, String); then return outcome is 'SUCCESS'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommandResponse ChangeUnitService.updateExecutionStatus(UpdateExecutionStatusCommand, String)"
  })
  void testUpdateExecutionStatus_thenReturnOutcomeIsSuccess() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(changeUnitDao.updateExecutionStatus(Mockito.<UpdateExecutionStatusCommand>any()))
        .thenReturn(true);

    UpdateExecutionStatusCommand command = mock(UpdateExecutionStatusCommand.class);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<UserTimestamp> ofResult = Optional.of(immutableUserTimestamp);
    when(command.lastUpdate()).thenReturn(ofResult);
    when(command.id()).thenReturn(1L);

    Builder<ExecutionStatus> builderResult = ImmutableFieldChange.builder();
    when(command.executionStatus())
        .thenReturn(
            builderResult
                .description("The characteristics of someone or something")
                .newVal(ExecutionStatus.PENDING)
                .oldVal(ExecutionStatus.PENDING)
                .build());

    // Act
    CommandResponse<UpdateExecutionStatusCommand> actualUpdateExecutionStatusResult =
        changeUnitService.updateExecutionStatus(command, "janedoe");

    // Assert
    verify(changeUnitDao).updateExecutionStatus(isA(UpdateExecutionStatusCommand.class));
    verify(command, atLeast(1)).executionStatus();
    verify(command, atLeast(1)).id();
    verify(command).lastUpdate();
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
}
