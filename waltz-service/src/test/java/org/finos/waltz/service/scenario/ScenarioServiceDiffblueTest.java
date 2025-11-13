package org.finos.waltz.service.scenario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
import org.finos.waltz.data.scenario.ScenarioAxisItemDao;
import org.finos.waltz.data.scenario.ScenarioDao;
import org.finos.waltz.data.scenario.ScenarioRatingItemDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.scenario.CloneScenarioCommand;
import org.finos.waltz.model.scenario.ImmutableCloneScenarioCommand;
import org.finos.waltz.model.scenario.ImmutableScenario;
import org.finos.waltz.model.scenario.Scenario;
import org.finos.waltz.model.scenario.ScenarioType;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ScenarioServiceDiffblueTest {
  /**
   * Test {@link ScenarioService#getById(long)}.
   *
   * <p>Method under test: {@link ScenarioService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Scenario ScenarioService.getById(long)"})
  void testGetById() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    LocalDate effectiveDate = LocalDate.of(1970, 1, 1);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(scenarioDao.getById(anyLong()))
        .thenReturn(
            ImmutableScenario.builder()
                .description("The characteristics of someone or something")
                .effectiveDate(effectiveDate)
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .id(1L)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .releaseStatus(ReleaseLifecycleStatus.DRAFT)
                .roadmapId(1L)
                .scenarioType(ScenarioType.TARGET)
                .build());
    ScenarioAxisItemDao scenarioAxisItemDao = mock(ScenarioAxisItemDao.class);
    ScenarioRatingItemDao scenarioRatingItemDao = mock(ScenarioRatingItemDao.class);
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

    ScenarioService scenarioService =
        new ScenarioService(
            scenarioDao, scenarioAxisItemDao, scenarioRatingItemDao, changeLogService);

    // Act
    Scenario actualById = scenarioService.getById(1L);

    // Assert
    verify(scenarioDao).getById(1L);
    assertTrue(actualById instanceof ImmutableScenario);
    LocalDate effectiveDateResult = actualById.effectiveDate();
    assertEquals("1970-01-01", effectiveDateResult.toString());
    assertEquals("2020-03-01", actualById.lastUpdatedBy());
    assertEquals("Name", actualById.name());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(0, actualById.position());
    assertEquals(1L, actualById.roadmapId());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualById.entityLifecycleStatus());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualById.releaseStatus());
    assertEquals(ScenarioType.TARGET, actualById.scenarioType());
    assertSame(ofResult, actualById.lastUpdatedAt().toLocalDate());
    assertSame(effectiveDate, effectiveDateResult);
  }

  /**
   * Test {@link ScenarioService#findForRoadmapId(long)}.
   *
   * <p>Method under test: {@link ScenarioService#findForRoadmapId(long)}
   */
  @Test
  @DisplayName("Test findForRoadmapId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection ScenarioService.findForRoadmapId(long)"})
  void testFindForRoadmapId() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    ArrayList<Scenario> scenarioList = new ArrayList<>();
    when(scenarioDao.findForRoadmapId(anyLong())).thenReturn(scenarioList);
    ScenarioAxisItemDao scenarioAxisItemDao = mock(ScenarioAxisItemDao.class);
    ScenarioRatingItemDao scenarioRatingItemDao = mock(ScenarioRatingItemDao.class);
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

    ScenarioService scenarioService =
        new ScenarioService(
            scenarioDao, scenarioAxisItemDao, scenarioRatingItemDao, changeLogService);

    // Act
    Collection<Scenario> actualFindForRoadmapIdResult = scenarioService.findForRoadmapId(1L);

    // Assert
    verify(scenarioDao).findForRoadmapId(1L);
    assertTrue(actualFindForRoadmapIdResult instanceof List);
    assertTrue(actualFindForRoadmapIdResult.isEmpty());
    assertSame(scenarioList, actualFindForRoadmapIdResult);
  }

  /**
   * Test {@link ScenarioService#findScenariosByRoadmapSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ScenarioService#findScenariosByRoadmapSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findScenariosByRoadmapSelector(IdSelectionOptions); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection ScenarioService.findScenariosByRoadmapSelector(IdSelectionOptions)"
  })
  void testFindScenariosByRoadmapSelector_thenReturnList() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    ArrayList<Scenario> scenarioList = new ArrayList<>();
    when(scenarioDao.findByRoadmapSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(scenarioList);
    ScenarioAxisItemDao scenarioAxisItemDao = mock(ScenarioAxisItemDao.class);
    ScenarioRatingItemDao scenarioRatingItemDao = mock(ScenarioRatingItemDao.class);
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

    ScenarioService scenarioService =
        new ScenarioService(
            scenarioDao, scenarioAxisItemDao, scenarioRatingItemDao, changeLogService);

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.APP_GROUP)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Collection<Scenario> actualFindScenariosByRoadmapSelectorResult =
        scenarioService.findScenariosByRoadmapSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(scenarioDao).findByRoadmapSelector(isA(Select.class));
    assertTrue(actualFindScenariosByRoadmapSelectorResult instanceof List);
    assertTrue(actualFindScenariosByRoadmapSelectorResult.isEmpty());
    assertSame(scenarioList, actualFindScenariosByRoadmapSelectorResult);
  }

  /**
   * Test {@link ScenarioService#cloneScenario(CloneScenarioCommand)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioService#cloneScenario(CloneScenarioCommand)}
   */
  @Test
  @DisplayName(
      "Test cloneScenario(CloneScenarioCommand); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Scenario ScenarioService.cloneScenario(CloneScenarioCommand)"})
  void testCloneScenario_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    LocalDate effectiveDate = LocalDate.of(1970, 1, 1);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(scenarioDao.cloneScenario(Mockito.<CloneScenarioCommand>any()))
        .thenReturn(
            ImmutableScenario.builder()
                .description("The characteristics of someone or something")
                .effectiveDate(effectiveDate)
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .id(1L)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .releaseStatus(ReleaseLifecycleStatus.DRAFT)
                .roadmapId(1L)
                .scenarioType(ScenarioType.TARGET)
                .build());

    ScenarioAxisItemDao scenarioAxisItemDao = mock(ScenarioAxisItemDao.class);
    when(scenarioAxisItemDao.cloneItems(Mockito.<CloneScenarioCommand>any(), Mockito.<Long>any()))
        .thenReturn(1000);

    ScenarioRatingItemDao scenarioRatingItemDao = mock(ScenarioRatingItemDao.class);
    when(scenarioRatingItemDao.cloneItems(Mockito.<CloneScenarioCommand>any(), Mockito.<Long>any()))
        .thenReturn(1000);

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

    ScenarioService scenarioService =
        new ScenarioService(
            scenarioDao, scenarioAxisItemDao, scenarioRatingItemDao, changeLogService);

    // Act
    Scenario actualCloneScenarioResult =
        scenarioService.cloneScenario(
            ImmutableCloneScenarioCommand.builder()
                .newName("New Name")
                .scenarioId(1L)
                .userId("42")
                .build());

    // Assert
    verify(changeLogDao, atLeast(1)).write(isA(Optional.class), Mockito.<ChangeLog>any());
    verify(scenarioAxisItemDao).cloneItems(isA(CloneScenarioCommand.class), eq(1L));
    verify(scenarioDao).cloneScenario(isA(CloneScenarioCommand.class));
    verify(scenarioRatingItemDao).cloneItems(isA(CloneScenarioCommand.class), eq(1L));
    assertTrue(actualCloneScenarioResult instanceof ImmutableScenario);
    LocalDate effectiveDateResult = actualCloneScenarioResult.effectiveDate();
    assertEquals("1970-01-01", effectiveDateResult.toString());
    assertEquals("2020-03-01", actualCloneScenarioResult.lastUpdatedBy());
    assertEquals("Name", actualCloneScenarioResult.name());
    assertEquals(
        "The characteristics of someone or something", actualCloneScenarioResult.description());
    assertEquals(0, actualCloneScenarioResult.position());
    assertEquals(1L, actualCloneScenarioResult.roadmapId());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCloneScenarioResult.entityLifecycleStatus());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualCloneScenarioResult.releaseStatus());
    assertEquals(ScenarioType.TARGET, actualCloneScenarioResult.scenarioType());
    assertSame(ofResult, actualCloneScenarioResult.lastUpdatedAt().toLocalDate());
    assertSame(effectiveDate, effectiveDateResult);
  }

  /**
   * Test {@link ScenarioService#cloneScenario(CloneScenarioCommand)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioService#cloneScenario(CloneScenarioCommand)}
   */
  @Test
  @DisplayName(
      "Test cloneScenario(CloneScenarioCommand); given ChangeLogService write(ChangeLog) return '19088743'; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Scenario ScenarioService.cloneScenario(CloneScenarioCommand)"})
  void testCloneScenario_givenChangeLogServiceWriteReturn19088743_thenCallsWrite() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    LocalDate effectiveDate = LocalDate.of(1970, 1, 1);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(scenarioDao.cloneScenario(Mockito.<CloneScenarioCommand>any()))
        .thenReturn(
            ImmutableScenario.builder()
                .description("The characteristics of someone or something")
                .effectiveDate(effectiveDate)
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .id(1L)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .releaseStatus(ReleaseLifecycleStatus.DRAFT)
                .roadmapId(1L)
                .scenarioType(ScenarioType.TARGET)
                .build());

    ScenarioAxisItemDao scenarioAxisItemDao = mock(ScenarioAxisItemDao.class);
    when(scenarioAxisItemDao.cloneItems(Mockito.<CloneScenarioCommand>any(), Mockito.<Long>any()))
        .thenReturn(1000);

    ScenarioRatingItemDao scenarioRatingItemDao = mock(ScenarioRatingItemDao.class);
    when(scenarioRatingItemDao.cloneItems(Mockito.<CloneScenarioCommand>any(), Mockito.<Long>any()))
        .thenReturn(1000);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    ScenarioService scenarioService =
        new ScenarioService(
            scenarioDao, scenarioAxisItemDao, scenarioRatingItemDao, changeLogService);

    // Act
    Scenario actualCloneScenarioResult =
        scenarioService.cloneScenario(
            ImmutableCloneScenarioCommand.builder()
                .newName("New Name")
                .scenarioId(1L)
                .userId("42")
                .build());

    // Assert
    verify(scenarioAxisItemDao).cloneItems(isA(CloneScenarioCommand.class), eq(1L));
    verify(scenarioDao).cloneScenario(isA(CloneScenarioCommand.class));
    verify(scenarioRatingItemDao).cloneItems(isA(CloneScenarioCommand.class), eq(1L));
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    assertTrue(actualCloneScenarioResult instanceof ImmutableScenario);
    LocalDate effectiveDateResult = actualCloneScenarioResult.effectiveDate();
    assertEquals("1970-01-01", effectiveDateResult.toString());
    assertEquals("2020-03-01", actualCloneScenarioResult.lastUpdatedBy());
    assertEquals("Name", actualCloneScenarioResult.name());
    assertEquals(
        "The characteristics of someone or something", actualCloneScenarioResult.description());
    assertEquals(0, actualCloneScenarioResult.position());
    assertEquals(1L, actualCloneScenarioResult.roadmapId());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCloneScenarioResult.entityLifecycleStatus());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualCloneScenarioResult.releaseStatus());
    assertEquals(ScenarioType.TARGET, actualCloneScenarioResult.scenarioType());
    assertSame(ofResult, actualCloneScenarioResult.lastUpdatedAt().toLocalDate());
    assertSame(effectiveDate, effectiveDateResult);
  }

  /**
   * Test {@link ScenarioService#updateName(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioService#updateName(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateName(long, String, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ScenarioService.updateName(long, String, String)"})
  void testUpdateName_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.updateName(anyLong(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(true);

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

    ScenarioService scenarioService =
        new ScenarioService(
            scenarioDao,
            mock(ScenarioAxisItemDao.class),
            mock(ScenarioRatingItemDao.class),
            changeLogService);

    // Act
    Boolean actualUpdateNameResult = scenarioService.updateName(1L, "42", "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(scenarioDao).updateName(1L, "42", "42");
    assertTrue(actualUpdateNameResult);
  }

  /**
   * Test {@link ScenarioService#updateName(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link ScenarioDao} {@link ScenarioDao#updateName(long, String, String)} return
   *       {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioService#updateName(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateName(long, String, String); given ScenarioDao updateName(long, String, String) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ScenarioService.updateName(long, String, String)"})
  void testUpdateName_givenScenarioDaoUpdateNameReturnFalse_thenReturnFalse() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.updateName(anyLong(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(false);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    ScenarioService scenarioService =
        new ScenarioService(
            scenarioDao,
            mock(ScenarioAxisItemDao.class),
            mock(ScenarioRatingItemDao.class),
            changeLogService);

    // Act
    Boolean actualUpdateNameResult = scenarioService.updateName(1L, "42", "42");

    // Assert
    verify(scenarioDao).updateName(1L, "42", "42");
    verify(changeLogService).write(isA(ChangeLog.class));
    assertFalse(actualUpdateNameResult);
  }

  /**
   * Test {@link ScenarioService#updateName(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link ScenarioDao} {@link ScenarioDao#updateName(long, String, String)} return
   *       {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioService#updateName(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateName(long, String, String); given ScenarioDao updateName(long, String, String) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ScenarioService.updateName(long, String, String)"})
  void testUpdateName_givenScenarioDaoUpdateNameReturnTrue_thenReturnTrue() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.updateName(anyLong(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(true);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    ScenarioService scenarioService =
        new ScenarioService(
            scenarioDao,
            mock(ScenarioAxisItemDao.class),
            mock(ScenarioRatingItemDao.class),
            changeLogService);

    // Act
    Boolean actualUpdateNameResult = scenarioService.updateName(1L, "42", "42");

    // Assert
    verify(scenarioDao).updateName(1L, "42", "42");
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateNameResult);
  }

  /**
   * Test {@link ScenarioService#updateDescription(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioService#updateDescription(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateDescription(long, String, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ScenarioService.updateDescription(long, String, String)"})
  void testUpdateDescription_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.updateDescription(anyLong(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(true);

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

    ScenarioService scenarioService =
        new ScenarioService(
            scenarioDao,
            mock(ScenarioAxisItemDao.class),
            mock(ScenarioRatingItemDao.class),
            changeLogService);

    // Act
    Boolean actualUpdateDescriptionResult = scenarioService.updateDescription(1L, "42", "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(scenarioDao).updateDescription(1L, "42", "42");
    assertTrue(actualUpdateDescriptionResult);
  }

  /**
   * Test {@link ScenarioService#updateDescription(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link ScenarioDao} {@link ScenarioDao#updateDescription(long, String, String)}
   *       return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioService#updateDescription(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateDescription(long, String, String); given ScenarioDao updateDescription(long, String, String) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ScenarioService.updateDescription(long, String, String)"})
  void testUpdateDescription_givenScenarioDaoUpdateDescriptionReturnTrue_thenReturnTrue() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.updateDescription(anyLong(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(true);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    ScenarioService scenarioService =
        new ScenarioService(
            scenarioDao,
            mock(ScenarioAxisItemDao.class),
            mock(ScenarioRatingItemDao.class),
            changeLogService);

    // Act
    Boolean actualUpdateDescriptionResult = scenarioService.updateDescription(1L, "42", "42");

    // Assert
    verify(scenarioDao).updateDescription(1L, "42", "42");
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateDescriptionResult);
  }

  /**
   * Test {@link ScenarioService#updateDescription(long, String, String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioService#updateDescription(long, String, String)}
   */
  @Test
  @DisplayName("Test updateDescription(long, String, String); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ScenarioService.updateDescription(long, String, String)"})
  void testUpdateDescription_thenReturnFalse() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.updateDescription(anyLong(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(false);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    ScenarioService scenarioService =
        new ScenarioService(
            scenarioDao,
            mock(ScenarioAxisItemDao.class),
            mock(ScenarioRatingItemDao.class),
            changeLogService);

    // Act
    Boolean actualUpdateDescriptionResult = scenarioService.updateDescription(1L, "42", "42");

    // Assert
    verify(scenarioDao).updateDescription(1L, "42", "42");
    verify(changeLogService).write(isA(ChangeLog.class));
    assertFalse(actualUpdateDescriptionResult);
  }

  /**
   * Test {@link ScenarioService#updateEffectiveDate(long, LocalDate, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioService#updateEffectiveDate(long, LocalDate, String)}
   */
  @Test
  @DisplayName(
      "Test updateEffectiveDate(long, LocalDate, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ScenarioService.updateEffectiveDate(long, LocalDate, String)"})
  void testUpdateEffectiveDate_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.updateEffectiveDate(
            anyLong(), Mockito.<LocalDate>any(), Mockito.<String>any()))
        .thenReturn(true);

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

    ScenarioService scenarioService =
        new ScenarioService(
            scenarioDao,
            mock(ScenarioAxisItemDao.class),
            mock(ScenarioRatingItemDao.class),
            changeLogService);

    // Act
    Boolean actualUpdateEffectiveDateResult =
        scenarioService.updateEffectiveDate(1L, LocalDate.of(1970, 1, 1), "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(scenarioDao).updateEffectiveDate(eq(1L), isA(LocalDate.class), eq("42"));
    assertTrue(actualUpdateEffectiveDateResult);
  }

  /**
   * Test {@link ScenarioService#updateEffectiveDate(long, LocalDate, String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioService#updateEffectiveDate(long, LocalDate, String)}
   */
  @Test
  @DisplayName("Test updateEffectiveDate(long, LocalDate, String); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ScenarioService.updateEffectiveDate(long, LocalDate, String)"})
  void testUpdateEffectiveDate_thenReturnFalse() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.updateEffectiveDate(
            anyLong(), Mockito.<LocalDate>any(), Mockito.<String>any()))
        .thenReturn(false);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    ScenarioService scenarioService =
        new ScenarioService(
            scenarioDao,
            mock(ScenarioAxisItemDao.class),
            mock(ScenarioRatingItemDao.class),
            changeLogService);

    // Act
    Boolean actualUpdateEffectiveDateResult =
        scenarioService.updateEffectiveDate(1L, LocalDate.of(1970, 1, 1), "42");

    // Assert
    verify(scenarioDao).updateEffectiveDate(eq(1L), isA(LocalDate.class), eq("42"));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertFalse(actualUpdateEffectiveDateResult);
  }

  /**
   * Test {@link ScenarioService#updateEffectiveDate(long, LocalDate, String)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioService#updateEffectiveDate(long, LocalDate, String)}
   */
  @Test
  @DisplayName("Test updateEffectiveDate(long, LocalDate, String); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ScenarioService.updateEffectiveDate(long, LocalDate, String)"})
  void testUpdateEffectiveDate_thenReturnTrue() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.updateEffectiveDate(
            anyLong(), Mockito.<LocalDate>any(), Mockito.<String>any()))
        .thenReturn(true);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    ScenarioService scenarioService =
        new ScenarioService(
            scenarioDao,
            mock(ScenarioAxisItemDao.class),
            mock(ScenarioRatingItemDao.class),
            changeLogService);

    // Act
    Boolean actualUpdateEffectiveDateResult =
        scenarioService.updateEffectiveDate(1L, LocalDate.of(1970, 1, 1), "42");

    // Assert
    verify(scenarioDao).updateEffectiveDate(eq(1L), isA(LocalDate.class), eq("42"));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateEffectiveDateResult);
  }

  /**
   * Test {@link ScenarioService#updateScenarioType(long, ScenarioType, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioService#updateScenarioType(long, ScenarioType, String)}
   */
  @Test
  @DisplayName(
      "Test updateScenarioType(long, ScenarioType, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ScenarioService.updateScenarioType(long, ScenarioType, String)"})
  void testUpdateScenarioType_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.updateScenarioType(
            anyLong(), Mockito.<ScenarioType>any(), Mockito.<String>any()))
        .thenReturn(true);

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

    ScenarioService scenarioService =
        new ScenarioService(
            scenarioDao,
            mock(ScenarioAxisItemDao.class),
            mock(ScenarioRatingItemDao.class),
            changeLogService);

    // Act
    Boolean actualUpdateScenarioTypeResult =
        scenarioService.updateScenarioType(1L, ScenarioType.TARGET, "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(scenarioDao).updateScenarioType(1L, ScenarioType.TARGET, "42");
    assertTrue(actualUpdateScenarioTypeResult);
  }

  /**
   * Test {@link ScenarioService#updateScenarioType(long, ScenarioType, String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioService#updateScenarioType(long, ScenarioType, String)}
   */
  @Test
  @DisplayName("Test updateScenarioType(long, ScenarioType, String); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ScenarioService.updateScenarioType(long, ScenarioType, String)"})
  void testUpdateScenarioType_thenReturnFalse() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.updateScenarioType(
            anyLong(), Mockito.<ScenarioType>any(), Mockito.<String>any()))
        .thenReturn(false);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    ScenarioService scenarioService =
        new ScenarioService(
            scenarioDao,
            mock(ScenarioAxisItemDao.class),
            mock(ScenarioRatingItemDao.class),
            changeLogService);

    // Act
    Boolean actualUpdateScenarioTypeResult =
        scenarioService.updateScenarioType(1L, ScenarioType.TARGET, "42");

    // Assert
    verify(scenarioDao).updateScenarioType(1L, ScenarioType.TARGET, "42");
    verify(changeLogService).write(isA(ChangeLog.class));
    assertFalse(actualUpdateScenarioTypeResult);
  }

  /**
   * Test {@link ScenarioService#updateScenarioType(long, ScenarioType, String)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioService#updateScenarioType(long, ScenarioType, String)}
   */
  @Test
  @DisplayName("Test updateScenarioType(long, ScenarioType, String); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ScenarioService.updateScenarioType(long, ScenarioType, String)"})
  void testUpdateScenarioType_thenReturnTrue() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.updateScenarioType(
            anyLong(), Mockito.<ScenarioType>any(), Mockito.<String>any()))
        .thenReturn(true);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    ScenarioService scenarioService =
        new ScenarioService(
            scenarioDao,
            mock(ScenarioAxisItemDao.class),
            mock(ScenarioRatingItemDao.class),
            changeLogService);

    // Act
    Boolean actualUpdateScenarioTypeResult =
        scenarioService.updateScenarioType(1L, ScenarioType.TARGET, "42");

    // Assert
    verify(scenarioDao).updateScenarioType(1L, ScenarioType.TARGET, "42");
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateScenarioTypeResult);
  }

  /**
   * Test {@link ScenarioService#updateReleaseStatus(long, ReleaseLifecycleStatus, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioService#updateReleaseStatus(long, ReleaseLifecycleStatus,
   * String)}
   */
  @Test
  @DisplayName(
      "Test updateReleaseStatus(long, ReleaseLifecycleStatus, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean ScenarioService.updateReleaseStatus(long, ReleaseLifecycleStatus, String)"
  })
  void testUpdateReleaseStatus_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.updateReleaseStatus(
            anyLong(), Mockito.<ReleaseLifecycleStatus>any(), Mockito.<String>any()))
        .thenReturn(true);

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

    ScenarioService scenarioService =
        new ScenarioService(
            scenarioDao,
            mock(ScenarioAxisItemDao.class),
            mock(ScenarioRatingItemDao.class),
            changeLogService);

    // Act
    Boolean actualUpdateReleaseStatusResult =
        scenarioService.updateReleaseStatus(1L, ReleaseLifecycleStatus.DRAFT, "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(scenarioDao).updateReleaseStatus(1L, ReleaseLifecycleStatus.DRAFT, "42");
    assertTrue(actualUpdateReleaseStatusResult);
  }

  /**
   * Test {@link ScenarioService#updateReleaseStatus(long, ReleaseLifecycleStatus, String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioService#updateReleaseStatus(long, ReleaseLifecycleStatus,
   * String)}
   */
  @Test
  @DisplayName(
      "Test updateReleaseStatus(long, ReleaseLifecycleStatus, String); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean ScenarioService.updateReleaseStatus(long, ReleaseLifecycleStatus, String)"
  })
  void testUpdateReleaseStatus_thenReturnFalse() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.updateReleaseStatus(
            anyLong(), Mockito.<ReleaseLifecycleStatus>any(), Mockito.<String>any()))
        .thenReturn(false);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    ScenarioService scenarioService =
        new ScenarioService(
            scenarioDao,
            mock(ScenarioAxisItemDao.class),
            mock(ScenarioRatingItemDao.class),
            changeLogService);

    // Act
    Boolean actualUpdateReleaseStatusResult =
        scenarioService.updateReleaseStatus(1L, ReleaseLifecycleStatus.DRAFT, "42");

    // Assert
    verify(scenarioDao).updateReleaseStatus(1L, ReleaseLifecycleStatus.DRAFT, "42");
    verify(changeLogService).write(isA(ChangeLog.class));
    assertFalse(actualUpdateReleaseStatusResult);
  }

  /**
   * Test {@link ScenarioService#updateReleaseStatus(long, ReleaseLifecycleStatus, String)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioService#updateReleaseStatus(long, ReleaseLifecycleStatus,
   * String)}
   */
  @Test
  @DisplayName("Test updateReleaseStatus(long, ReleaseLifecycleStatus, String); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean ScenarioService.updateReleaseStatus(long, ReleaseLifecycleStatus, String)"
  })
  void testUpdateReleaseStatus_thenReturnTrue() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.updateReleaseStatus(
            anyLong(), Mockito.<ReleaseLifecycleStatus>any(), Mockito.<String>any()))
        .thenReturn(true);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    ScenarioService scenarioService =
        new ScenarioService(
            scenarioDao,
            mock(ScenarioAxisItemDao.class),
            mock(ScenarioRatingItemDao.class),
            changeLogService);

    // Act
    Boolean actualUpdateReleaseStatusResult =
        scenarioService.updateReleaseStatus(1L, ReleaseLifecycleStatus.DRAFT, "42");

    // Assert
    verify(scenarioDao).updateReleaseStatus(1L, ReleaseLifecycleStatus.DRAFT, "42");
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateReleaseStatusResult);
  }

  /**
   * Test {@link ScenarioService#updateEntityLifecycleStatus(long, EntityLifecycleStatus, String)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioService#updateEntityLifecycleStatus(long,
   * EntityLifecycleStatus, String)}
   */
  @Test
  @DisplayName(
      "Test updateEntityLifecycleStatus(long, EntityLifecycleStatus, String); then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean ScenarioService.updateEntityLifecycleStatus(long, EntityLifecycleStatus, String)"
  })
  void testUpdateEntityLifecycleStatus_thenCallsWrite() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.updateEntityLifecycleStatus(
            anyLong(), Mockito.<EntityLifecycleStatus>any(), Mockito.<String>any()))
        .thenReturn(true);

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

    ScenarioService scenarioService =
        new ScenarioService(
            scenarioDao,
            mock(ScenarioAxisItemDao.class),
            mock(ScenarioRatingItemDao.class),
            changeLogService);

    // Act
    Boolean actualUpdateEntityLifecycleStatusResult =
        scenarioService.updateEntityLifecycleStatus(1L, EntityLifecycleStatus.ACTIVE, "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(scenarioDao).updateEntityLifecycleStatus(1L, EntityLifecycleStatus.ACTIVE, "42");
    assertTrue(actualUpdateEntityLifecycleStatusResult);
  }

  /**
   * Test {@link ScenarioService#updateEntityLifecycleStatus(long, EntityLifecycleStatus, String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioService#updateEntityLifecycleStatus(long,
   * EntityLifecycleStatus, String)}
   */
  @Test
  @DisplayName(
      "Test updateEntityLifecycleStatus(long, EntityLifecycleStatus, String); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean ScenarioService.updateEntityLifecycleStatus(long, EntityLifecycleStatus, String)"
  })
  void testUpdateEntityLifecycleStatus_thenReturnFalse() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.updateEntityLifecycleStatus(
            anyLong(), Mockito.<EntityLifecycleStatus>any(), Mockito.<String>any()))
        .thenReturn(false);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    ScenarioService scenarioService =
        new ScenarioService(
            scenarioDao,
            mock(ScenarioAxisItemDao.class),
            mock(ScenarioRatingItemDao.class),
            changeLogService);

    // Act
    Boolean actualUpdateEntityLifecycleStatusResult =
        scenarioService.updateEntityLifecycleStatus(1L, EntityLifecycleStatus.ACTIVE, "42");

    // Assert
    verify(scenarioDao).updateEntityLifecycleStatus(1L, EntityLifecycleStatus.ACTIVE, "42");
    verify(changeLogService).write(isA(ChangeLog.class));
    assertFalse(actualUpdateEntityLifecycleStatusResult);
  }

  /**
   * Test {@link ScenarioService#updateEntityLifecycleStatus(long, EntityLifecycleStatus, String)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioService#updateEntityLifecycleStatus(long,
   * EntityLifecycleStatus, String)}
   */
  @Test
  @DisplayName(
      "Test updateEntityLifecycleStatus(long, EntityLifecycleStatus, String); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean ScenarioService.updateEntityLifecycleStatus(long, EntityLifecycleStatus, String)"
  })
  void testUpdateEntityLifecycleStatus_thenReturnTrue() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.updateEntityLifecycleStatus(
            anyLong(), Mockito.<EntityLifecycleStatus>any(), Mockito.<String>any()))
        .thenReturn(true);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    ScenarioService scenarioService =
        new ScenarioService(
            scenarioDao,
            mock(ScenarioAxisItemDao.class),
            mock(ScenarioRatingItemDao.class),
            changeLogService);

    // Act
    Boolean actualUpdateEntityLifecycleStatusResult =
        scenarioService.updateEntityLifecycleStatus(1L, EntityLifecycleStatus.ACTIVE, "42");

    // Assert
    verify(scenarioDao).updateEntityLifecycleStatus(1L, EntityLifecycleStatus.ACTIVE, "42");
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateEntityLifecycleStatusResult);
  }

  /**
   * Test {@link ScenarioService#removeScenario(long, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioService#removeScenario(long, String)}
   */
  @Test
  @DisplayName(
      "Test removeScenario(long, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ScenarioService.removeScenario(long, String)"})
  void testRemoveScenario_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.removeScenario(anyLong(), Mockito.<String>any())).thenReturn(true);
    when(scenarioDao.getById(anyLong()))
        .thenReturn(
            ImmutableScenario.builder()
                .description("The characteristics of someone or something")
                .effectiveDate(LocalDate.of(1970, 1, 1))
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .releaseStatus(ReleaseLifecycleStatus.DRAFT)
                .roadmapId(1L)
                .scenarioType(ScenarioType.TARGET)
                .build());

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

    ScenarioService scenarioService =
        new ScenarioService(
            scenarioDao,
            mock(ScenarioAxisItemDao.class),
            mock(ScenarioRatingItemDao.class),
            changeLogService);

    // Act
    Boolean actualRemoveScenarioResult = scenarioService.removeScenario(1L, "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(scenarioDao).getById(1L);
    verify(scenarioDao).removeScenario(1L, "42");
    assertTrue(actualRemoveScenarioResult);
  }

  /**
   * Test {@link ScenarioService#removeScenario(long, String)}.
   *
   * <ul>
   *   <li>Given {@link ScenarioDao} {@link ScenarioDao#removeScenario(long, String)} return {@code
   *       false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioService#removeScenario(long, String)}
   */
  @Test
  @DisplayName(
      "Test removeScenario(long, String); given ScenarioDao removeScenario(long, String) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ScenarioService.removeScenario(long, String)"})
  void testRemoveScenario_givenScenarioDaoRemoveScenarioReturnFalse_thenReturnFalse() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.removeScenario(anyLong(), Mockito.<String>any())).thenReturn(false);
    when(scenarioDao.getById(anyLong()))
        .thenReturn(
            ImmutableScenario.builder()
                .description("The characteristics of someone or something")
                .effectiveDate(LocalDate.of(1970, 1, 1))
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .releaseStatus(ReleaseLifecycleStatus.DRAFT)
                .roadmapId(1L)
                .scenarioType(ScenarioType.TARGET)
                .build());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    ScenarioService scenarioService =
        new ScenarioService(
            scenarioDao,
            mock(ScenarioAxisItemDao.class),
            mock(ScenarioRatingItemDao.class),
            changeLogService);

    // Act
    Boolean actualRemoveScenarioResult = scenarioService.removeScenario(1L, "42");

    // Assert
    verify(scenarioDao).getById(1L);
    verify(scenarioDao).removeScenario(1L, "42");
    verify(changeLogService).write(isA(ChangeLog.class));
    assertFalse(actualRemoveScenarioResult);
  }

  /**
   * Test {@link ScenarioService#removeScenario(long, String)}.
   *
   * <ul>
   *   <li>Given {@link ScenarioDao} {@link ScenarioDao#removeScenario(long, String)} return {@code
   *       true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioService#removeScenario(long, String)}
   */
  @Test
  @DisplayName(
      "Test removeScenario(long, String); given ScenarioDao removeScenario(long, String) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ScenarioService.removeScenario(long, String)"})
  void testRemoveScenario_givenScenarioDaoRemoveScenarioReturnTrue_thenReturnTrue() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.removeScenario(anyLong(), Mockito.<String>any())).thenReturn(true);
    when(scenarioDao.getById(anyLong()))
        .thenReturn(
            ImmutableScenario.builder()
                .description("The characteristics of someone or something")
                .effectiveDate(LocalDate.of(1970, 1, 1))
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .releaseStatus(ReleaseLifecycleStatus.DRAFT)
                .roadmapId(1L)
                .scenarioType(ScenarioType.TARGET)
                .build());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    ScenarioService scenarioService =
        new ScenarioService(
            scenarioDao,
            mock(ScenarioAxisItemDao.class),
            mock(ScenarioRatingItemDao.class),
            changeLogService);

    // Act
    Boolean actualRemoveScenarioResult = scenarioService.removeScenario(1L, "42");

    // Assert
    verify(scenarioDao).getById(1L);
    verify(scenarioDao).removeScenario(1L, "42");
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualRemoveScenarioResult);
  }
}
