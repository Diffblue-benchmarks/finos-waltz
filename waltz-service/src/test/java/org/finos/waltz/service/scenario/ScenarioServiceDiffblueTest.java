package org.finos.waltz.service.scenario;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.scenario.CloneScenarioCommand;
import org.finos.waltz.model.scenario.Scenario;
import org.finos.waltz.model.scenario.ScenarioType;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ScenarioServiceDiffblueTest {
  /**
   * Method under test: {@link ScenarioService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.getById(anyLong())).thenReturn(null);
    ScenarioAxisItemDao scenarioAxisItemDao = mock(ScenarioAxisItemDao.class);
    ScenarioRatingItemDao scenarioRatingItemDao = mock(ScenarioRatingItemDao.class);

    // Act
    Scenario actualById = (new ScenarioService(scenarioDao, scenarioAxisItemDao, scenarioRatingItemDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))).getById(1L);

    // Assert
    verify(scenarioDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test: {@link ScenarioService#findForRoadmapId(long)}
   */
  @Test
  void testFindForRoadmapId() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    ArrayList<Scenario> scenarioList = new ArrayList<>();
    when(scenarioDao.findForRoadmapId(anyLong())).thenReturn(scenarioList);
    ScenarioAxisItemDao scenarioAxisItemDao = mock(ScenarioAxisItemDao.class);
    ScenarioRatingItemDao scenarioRatingItemDao = mock(ScenarioRatingItemDao.class);

    // Act
    Collection<Scenario> actualFindForRoadmapIdResult = (new ScenarioService(scenarioDao, scenarioAxisItemDao,
        scenarioRatingItemDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findForRoadmapId(1L);

    // Assert
    verify(scenarioDao).findForRoadmapId(eq(1L));
    assertTrue(actualFindForRoadmapIdResult instanceof List);
    assertTrue(actualFindForRoadmapIdResult.isEmpty());
    assertSame(scenarioList, actualFindForRoadmapIdResult);
  }

  /**
   * Method under test:
   * {@link ScenarioService#findScenariosByRoadmapSelector(IdSelectionOptions)}
   */
  @Test
  void testFindScenariosByRoadmapSelector() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    ArrayList<Scenario> scenarioList = new ArrayList<>();
    when(scenarioDao.findByRoadmapSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(scenarioList);
    ScenarioAxisItemDao scenarioAxisItemDao = mock(ScenarioAxisItemDao.class);
    ScenarioRatingItemDao scenarioRatingItemDao = mock(ScenarioRatingItemDao.class);
    ScenarioService scenarioService = new ScenarioService(scenarioDao, scenarioAxisItemDao, scenarioRatingItemDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Collection<Scenario> actualFindScenariosByRoadmapSelectorResult = scenarioService
        .findScenariosByRoadmapSelector(selectionOptions);

    // Assert
    verify(scenarioDao).findByRoadmapSelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    assertTrue(actualFindScenariosByRoadmapSelectorResult instanceof List);
    assertTrue(actualFindScenariosByRoadmapSelectorResult.isEmpty());
    assertSame(scenarioList, actualFindScenariosByRoadmapSelectorResult);
  }

  /**
   * Method under test:
   * {@link ScenarioService#cloneScenario(CloneScenarioCommand)}
   */
  @Test
  void testCloneScenario() {
    // Arrange
    Scenario scenario = mock(Scenario.class);
    when(scenario.roadmapId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(scenario.id()).thenReturn(ofResult);
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.cloneScenario(Mockito.<CloneScenarioCommand>any())).thenReturn(scenario);
    ScenarioAxisItemDao scenarioAxisItemDao = mock(ScenarioAxisItemDao.class);
    when(scenarioAxisItemDao.cloneItems(Mockito.<CloneScenarioCommand>any(), Mockito.<Long>any())).thenReturn(1000);
    ScenarioRatingItemDao scenarioRatingItemDao = mock(ScenarioRatingItemDao.class);
    when(scenarioRatingItemDao.cloneItems(Mockito.<CloneScenarioCommand>any(), Mockito.<Long>any())).thenReturn(1000);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ScenarioService scenarioService = new ScenarioService(scenarioDao, scenarioAxisItemDao, scenarioRatingItemDao,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    CloneScenarioCommand command = mock(CloneScenarioCommand.class);
    when(command.newName()).thenReturn("New Name");
    when(command.userId()).thenReturn("42");
    when(command.scenarioId()).thenReturn(1L);

    // Act
    scenarioService.cloneScenario(command);

    // Assert
    verify(changeLogDao, atLeast(1)).write(isA(Optional.class), Mockito.<ChangeLog>any());
    verify(scenarioAxisItemDao).cloneItems(isA(CloneScenarioCommand.class), eq(1L));
    verify(scenarioDao).cloneScenario(isA(CloneScenarioCommand.class));
    verify(scenarioRatingItemDao).cloneItems(isA(CloneScenarioCommand.class), eq(1L));
    verify(scenario, atLeast(1)).id();
    verify(command).newName();
    verify(command).scenarioId();
    verify(command).userId();
    verify(scenario).roadmapId();
  }

  /**
   * Method under test:
   * {@link ScenarioService#cloneScenario(CloneScenarioCommand)}
   */
  @Test
  void testCloneScenario2() {
    // Arrange
    Scenario scenario = mock(Scenario.class);
    when(scenario.roadmapId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(scenario.id()).thenReturn(ofResult);
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.cloneScenario(Mockito.<CloneScenarioCommand>any())).thenReturn(scenario);
    ScenarioAxisItemDao scenarioAxisItemDao = mock(ScenarioAxisItemDao.class);
    when(scenarioAxisItemDao.cloneItems(Mockito.<CloneScenarioCommand>any(), Mockito.<Long>any())).thenReturn(1000);
    ScenarioRatingItemDao scenarioRatingItemDao = mock(ScenarioRatingItemDao.class);
    when(scenarioRatingItemDao.cloneItems(Mockito.<CloneScenarioCommand>any(), Mockito.<Long>any())).thenReturn(1000);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    ScenarioService scenarioService = new ScenarioService(scenarioDao, scenarioAxisItemDao, scenarioRatingItemDao,
        changeLogService);
    CloneScenarioCommand command = mock(CloneScenarioCommand.class);
    when(command.newName()).thenReturn("New Name");
    when(command.userId()).thenReturn("42");
    when(command.scenarioId()).thenReturn(1L);

    // Act
    scenarioService.cloneScenario(command);

    // Assert
    verify(scenarioAxisItemDao).cloneItems(isA(CloneScenarioCommand.class), eq(1L));
    verify(scenarioDao).cloneScenario(isA(CloneScenarioCommand.class));
    verify(scenarioRatingItemDao).cloneItems(isA(CloneScenarioCommand.class), eq(1L));
    verify(scenario, atLeast(1)).id();
    verify(command).newName();
    verify(command).scenarioId();
    verify(command).userId();
    verify(scenario).roadmapId();
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
  }

  /**
   * Method under test: {@link ScenarioService#updateName(long, String, String)}
   */
  @Test
  void testUpdateName() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.updateName(anyLong(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(true);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Boolean actualUpdateNameResult = (new ScenarioService(scenarioDao, mock(ScenarioAxisItemDao.class),
        mock(ScenarioRatingItemDao.class),
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .updateName(1L, "42", "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(scenarioDao).updateName(eq(1L), eq("42"), eq("42"));
    assertTrue(actualUpdateNameResult);
  }

  /**
   * Method under test: {@link ScenarioService#updateName(long, String, String)}
   */
  @Test
  void testUpdateName2() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.updateName(anyLong(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(false);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Boolean actualUpdateNameResult = (new ScenarioService(scenarioDao, mock(ScenarioAxisItemDao.class),
        mock(ScenarioRatingItemDao.class),
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .updateName(1L, "42", "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(scenarioDao).updateName(eq(1L), eq("42"), eq("42"));
    assertFalse(actualUpdateNameResult);
  }

  /**
   * Method under test: {@link ScenarioService#updateName(long, String, String)}
   */
  @Test
  void testUpdateName3() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.updateName(anyLong(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(true);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Boolean actualUpdateNameResult = (new ScenarioService(scenarioDao, mock(ScenarioAxisItemDao.class),
        mock(ScenarioRatingItemDao.class), changeLogService)).updateName(1L, "42", "42");

    // Assert
    verify(scenarioDao).updateName(eq(1L), eq("42"), eq("42"));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateNameResult);
  }

  /**
   * Method under test:
   * {@link ScenarioService#updateDescription(long, String, String)}
   */
  @Test
  void testUpdateDescription() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.updateDescription(anyLong(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(true);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Boolean actualUpdateDescriptionResult = (new ScenarioService(scenarioDao, mock(ScenarioAxisItemDao.class),
        mock(ScenarioRatingItemDao.class),
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .updateDescription(1L, "42", "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(scenarioDao).updateDescription(eq(1L), eq("42"), eq("42"));
    assertTrue(actualUpdateDescriptionResult);
  }

  /**
   * Method under test:
   * {@link ScenarioService#updateDescription(long, String, String)}
   */
  @Test
  void testUpdateDescription2() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.updateDescription(anyLong(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(false);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Boolean actualUpdateDescriptionResult = (new ScenarioService(scenarioDao, mock(ScenarioAxisItemDao.class),
        mock(ScenarioRatingItemDao.class),
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .updateDescription(1L, "42", "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(scenarioDao).updateDescription(eq(1L), eq("42"), eq("42"));
    assertFalse(actualUpdateDescriptionResult);
  }

  /**
   * Method under test:
   * {@link ScenarioService#updateDescription(long, String, String)}
   */
  @Test
  void testUpdateDescription3() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.updateDescription(anyLong(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(true);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Boolean actualUpdateDescriptionResult = (new ScenarioService(scenarioDao, mock(ScenarioAxisItemDao.class),
        mock(ScenarioRatingItemDao.class), changeLogService)).updateDescription(1L, "42", "42");

    // Assert
    verify(scenarioDao).updateDescription(eq(1L), eq("42"), eq("42"));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateDescriptionResult);
  }

  /**
   * Method under test:
   * {@link ScenarioService#updateEffectiveDate(long, LocalDate, String)}
   */
  @Test
  void testUpdateEffectiveDate() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.updateEffectiveDate(anyLong(), Mockito.<LocalDate>any(), Mockito.<String>any())).thenReturn(true);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ScenarioService scenarioService = new ScenarioService(scenarioDao, mock(ScenarioAxisItemDao.class),
        mock(ScenarioRatingItemDao.class),
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    // Act
    Boolean actualUpdateEffectiveDateResult = scenarioService.updateEffectiveDate(1L, LocalDate.of(1970, 1, 1), "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(scenarioDao).updateEffectiveDate(eq(1L), isA(LocalDate.class), eq("42"));
    assertTrue(actualUpdateEffectiveDateResult);
  }

  /**
   * Method under test:
   * {@link ScenarioService#updateEffectiveDate(long, LocalDate, String)}
   */
  @Test
  void testUpdateEffectiveDate2() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.updateEffectiveDate(anyLong(), Mockito.<LocalDate>any(), Mockito.<String>any())).thenReturn(false);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ScenarioService scenarioService = new ScenarioService(scenarioDao, mock(ScenarioAxisItemDao.class),
        mock(ScenarioRatingItemDao.class),
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    // Act
    Boolean actualUpdateEffectiveDateResult = scenarioService.updateEffectiveDate(1L, LocalDate.of(1970, 1, 1), "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(scenarioDao).updateEffectiveDate(eq(1L), isA(LocalDate.class), eq("42"));
    assertFalse(actualUpdateEffectiveDateResult);
  }

  /**
   * Method under test:
   * {@link ScenarioService#updateEffectiveDate(long, LocalDate, String)}
   */
  @Test
  void testUpdateEffectiveDate3() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.updateEffectiveDate(anyLong(), Mockito.<LocalDate>any(), Mockito.<String>any())).thenReturn(true);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    ScenarioService scenarioService = new ScenarioService(scenarioDao, mock(ScenarioAxisItemDao.class),
        mock(ScenarioRatingItemDao.class), changeLogService);

    // Act
    Boolean actualUpdateEffectiveDateResult = scenarioService.updateEffectiveDate(1L, LocalDate.of(1970, 1, 1), "42");

    // Assert
    verify(scenarioDao).updateEffectiveDate(eq(1L), isA(LocalDate.class), eq("42"));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateEffectiveDateResult);
  }

  /**
   * Method under test:
   * {@link ScenarioService#updateScenarioType(long, ScenarioType, String)}
   */
  @Test
  void testUpdateScenarioType() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.updateScenarioType(anyLong(), Mockito.<ScenarioType>any(), Mockito.<String>any()))
        .thenReturn(true);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Boolean actualUpdateScenarioTypeResult = (new ScenarioService(scenarioDao, mock(ScenarioAxisItemDao.class),
        mock(ScenarioRatingItemDao.class),
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .updateScenarioType(1L, ScenarioType.TARGET, "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(scenarioDao).updateScenarioType(eq(1L), eq(ScenarioType.TARGET), eq("42"));
    assertTrue(actualUpdateScenarioTypeResult);
  }

  /**
   * Method under test:
   * {@link ScenarioService#updateScenarioType(long, ScenarioType, String)}
   */
  @Test
  void testUpdateScenarioType2() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.updateScenarioType(anyLong(), Mockito.<ScenarioType>any(), Mockito.<String>any()))
        .thenReturn(false);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Boolean actualUpdateScenarioTypeResult = (new ScenarioService(scenarioDao, mock(ScenarioAxisItemDao.class),
        mock(ScenarioRatingItemDao.class),
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .updateScenarioType(1L, ScenarioType.TARGET, "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(scenarioDao).updateScenarioType(eq(1L), eq(ScenarioType.TARGET), eq("42"));
    assertFalse(actualUpdateScenarioTypeResult);
  }

  /**
   * Method under test:
   * {@link ScenarioService#updateScenarioType(long, ScenarioType, String)}
   */
  @Test
  void testUpdateScenarioType3() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.updateScenarioType(anyLong(), Mockito.<ScenarioType>any(), Mockito.<String>any()))
        .thenReturn(true);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Boolean actualUpdateScenarioTypeResult = (new ScenarioService(scenarioDao, mock(ScenarioAxisItemDao.class),
        mock(ScenarioRatingItemDao.class), changeLogService)).updateScenarioType(1L, ScenarioType.TARGET, "42");

    // Assert
    verify(scenarioDao).updateScenarioType(eq(1L), eq(ScenarioType.TARGET), eq("42"));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateScenarioTypeResult);
  }

  /**
   * Method under test:
   * {@link ScenarioService#updateReleaseStatus(long, ReleaseLifecycleStatus, String)}
   */
  @Test
  void testUpdateReleaseStatus() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.updateReleaseStatus(anyLong(), Mockito.<ReleaseLifecycleStatus>any(), Mockito.<String>any()))
        .thenReturn(true);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Boolean actualUpdateReleaseStatusResult = (new ScenarioService(scenarioDao, mock(ScenarioAxisItemDao.class),
        mock(ScenarioRatingItemDao.class),
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .updateReleaseStatus(1L, ReleaseLifecycleStatus.DRAFT, "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(scenarioDao).updateReleaseStatus(eq(1L), eq(ReleaseLifecycleStatus.DRAFT), eq("42"));
    assertTrue(actualUpdateReleaseStatusResult);
  }

  /**
   * Method under test:
   * {@link ScenarioService#updateReleaseStatus(long, ReleaseLifecycleStatus, String)}
   */
  @Test
  void testUpdateReleaseStatus2() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.updateReleaseStatus(anyLong(), Mockito.<ReleaseLifecycleStatus>any(), Mockito.<String>any()))
        .thenReturn(false);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Boolean actualUpdateReleaseStatusResult = (new ScenarioService(scenarioDao, mock(ScenarioAxisItemDao.class),
        mock(ScenarioRatingItemDao.class),
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .updateReleaseStatus(1L, ReleaseLifecycleStatus.DRAFT, "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(scenarioDao).updateReleaseStatus(eq(1L), eq(ReleaseLifecycleStatus.DRAFT), eq("42"));
    assertFalse(actualUpdateReleaseStatusResult);
  }

  /**
   * Method under test:
   * {@link ScenarioService#updateReleaseStatus(long, ReleaseLifecycleStatus, String)}
   */
  @Test
  void testUpdateReleaseStatus3() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.updateReleaseStatus(anyLong(), Mockito.<ReleaseLifecycleStatus>any(), Mockito.<String>any()))
        .thenReturn(true);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Boolean actualUpdateReleaseStatusResult = (new ScenarioService(scenarioDao, mock(ScenarioAxisItemDao.class),
        mock(ScenarioRatingItemDao.class), changeLogService)).updateReleaseStatus(1L, ReleaseLifecycleStatus.DRAFT,
            "42");

    // Assert
    verify(scenarioDao).updateReleaseStatus(eq(1L), eq(ReleaseLifecycleStatus.DRAFT), eq("42"));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateReleaseStatusResult);
  }

  /**
   * Method under test:
   * {@link ScenarioService#updateEntityLifecycleStatus(long, EntityLifecycleStatus, String)}
   */
  @Test
  void testUpdateEntityLifecycleStatus() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(
        scenarioDao.updateEntityLifecycleStatus(anyLong(), Mockito.<EntityLifecycleStatus>any(), Mockito.<String>any()))
            .thenReturn(true);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Boolean actualUpdateEntityLifecycleStatusResult = (new ScenarioService(scenarioDao, mock(ScenarioAxisItemDao.class),
        mock(ScenarioRatingItemDao.class),
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .updateEntityLifecycleStatus(1L, EntityLifecycleStatus.ACTIVE, "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(scenarioDao).updateEntityLifecycleStatus(eq(1L), eq(EntityLifecycleStatus.ACTIVE), eq("42"));
    assertTrue(actualUpdateEntityLifecycleStatusResult);
  }

  /**
   * Method under test:
   * {@link ScenarioService#updateEntityLifecycleStatus(long, EntityLifecycleStatus, String)}
   */
  @Test
  void testUpdateEntityLifecycleStatus2() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(
        scenarioDao.updateEntityLifecycleStatus(anyLong(), Mockito.<EntityLifecycleStatus>any(), Mockito.<String>any()))
            .thenReturn(false);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Boolean actualUpdateEntityLifecycleStatusResult = (new ScenarioService(scenarioDao, mock(ScenarioAxisItemDao.class),
        mock(ScenarioRatingItemDao.class),
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .updateEntityLifecycleStatus(1L, EntityLifecycleStatus.ACTIVE, "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(scenarioDao).updateEntityLifecycleStatus(eq(1L), eq(EntityLifecycleStatus.ACTIVE), eq("42"));
    assertFalse(actualUpdateEntityLifecycleStatusResult);
  }

  /**
   * Method under test:
   * {@link ScenarioService#updateEntityLifecycleStatus(long, EntityLifecycleStatus, String)}
   */
  @Test
  void testUpdateEntityLifecycleStatus3() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(
        scenarioDao.updateEntityLifecycleStatus(anyLong(), Mockito.<EntityLifecycleStatus>any(), Mockito.<String>any()))
            .thenReturn(true);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Boolean actualUpdateEntityLifecycleStatusResult = (new ScenarioService(scenarioDao, mock(ScenarioAxisItemDao.class),
        mock(ScenarioRatingItemDao.class), changeLogService)).updateEntityLifecycleStatus(1L,
            EntityLifecycleStatus.ACTIVE, "42");

    // Assert
    verify(scenarioDao).updateEntityLifecycleStatus(eq(1L), eq(EntityLifecycleStatus.ACTIVE), eq("42"));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateEntityLifecycleStatusResult);
  }

  /**
   * Method under test: {@link ScenarioService#removeScenario(long, String)}
   */
  @Test
  void testRemoveScenario() {
    // Arrange
    Scenario scenario = mock(Scenario.class);
    when(scenario.name()).thenReturn("Name");
    when(scenario.roadmapId()).thenReturn(1L);
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.removeScenario(anyLong(), Mockito.<String>any())).thenReturn(true);
    when(scenarioDao.getById(anyLong())).thenReturn(scenario);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Boolean actualRemoveScenarioResult = (new ScenarioService(scenarioDao, mock(ScenarioAxisItemDao.class),
        mock(ScenarioRatingItemDao.class),
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .removeScenario(1L, "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(scenarioDao).getById(eq(1L));
    verify(scenarioDao).removeScenario(eq(1L), eq("42"));
    verify(scenario).name();
    verify(scenario).roadmapId();
    assertTrue(actualRemoveScenarioResult);
  }

  /**
   * Method under test: {@link ScenarioService#removeScenario(long, String)}
   */
  @Test
  void testRemoveScenario2() {
    // Arrange
    Scenario scenario = mock(Scenario.class);
    when(scenario.name()).thenReturn("Name");
    when(scenario.roadmapId()).thenReturn(1L);
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.removeScenario(anyLong(), Mockito.<String>any())).thenReturn(false);
    when(scenarioDao.getById(anyLong())).thenReturn(scenario);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Boolean actualRemoveScenarioResult = (new ScenarioService(scenarioDao, mock(ScenarioAxisItemDao.class),
        mock(ScenarioRatingItemDao.class),
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .removeScenario(1L, "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(scenarioDao).getById(eq(1L));
    verify(scenarioDao).removeScenario(eq(1L), eq("42"));
    verify(scenario).name();
    verify(scenario).roadmapId();
    assertFalse(actualRemoveScenarioResult);
  }

  /**
   * Method under test: {@link ScenarioService#removeScenario(long, String)}
   */
  @Test
  void testRemoveScenario3() {
    // Arrange
    Scenario scenario = mock(Scenario.class);
    when(scenario.name()).thenReturn("Name");
    when(scenario.roadmapId()).thenReturn(1L);
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.removeScenario(anyLong(), Mockito.<String>any())).thenReturn(true);
    when(scenarioDao.getById(anyLong())).thenReturn(scenario);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Boolean actualRemoveScenarioResult = (new ScenarioService(scenarioDao, mock(ScenarioAxisItemDao.class),
        mock(ScenarioRatingItemDao.class), changeLogService)).removeScenario(1L, "42");

    // Assert
    verify(scenarioDao).getById(eq(1L));
    verify(scenarioDao).removeScenario(eq(1L), eq("42"));
    verify(scenario).name();
    verify(scenario).roadmapId();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualRemoveScenarioResult);
  }
}
