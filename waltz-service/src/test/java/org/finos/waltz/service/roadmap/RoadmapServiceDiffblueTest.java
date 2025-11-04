package org.finos.waltz.service.roadmap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.entity_relationship.EntityRelationshipDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.roadmap.RoadmapDao;
import org.finos.waltz.data.roadmap.RoadmapSearchDao;
import org.finos.waltz.data.scenario.ScenarioDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.entity_relationship.EntityRelationship;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.roadmap.Roadmap;
import org.finos.waltz.model.roadmap.RoadmapAndScenarioOverview;
import org.finos.waltz.model.roadmap.RoadmapCreateCommand;
import org.finos.waltz.model.scenario.Scenario;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RoadmapServiceDiffblueTest {
  /**
   * Method under test: {@link RoadmapService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
    RoadmapDao roadmapDao = mock(RoadmapDao.class);
    when(roadmapDao.getById(anyLong())).thenReturn(null);
    RoadmapSearchDao roadmapSearchDao = mock(RoadmapSearchDao.class);
    ScenarioDao scenarioDao = mock(ScenarioDao.class);

    // Act
    Roadmap actualById = (new RoadmapService(roadmapDao, roadmapSearchDao, scenarioDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(EntityRelationshipDao.class))).getById(1L);

    // Assert
    verify(roadmapDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test:
   * {@link RoadmapService#createRoadmap(RoadmapCreateCommand, String)}
   */
  @Test
  void testCreateRoadmap() {
    // Arrange
    RoadmapDao roadmapDao = mock(RoadmapDao.class);
    when(roadmapDao.createRoadmap(Mockito.<String>any(), anyLong(), Mockito.<EntityReference>any(),
        Mockito.<EntityReference>any(), Mockito.<String>any())).thenReturn(1L);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.create(Mockito.<EntityRelationship>any())).thenReturn(true);
    RoadmapService roadmapService = new RoadmapService(roadmapDao, mock(RoadmapSearchDao.class),
        mock(ScenarioDao.class), changeLogService, entityRelationshipDao);
    RoadmapCreateCommand command = mock(RoadmapCreateCommand.class);
    when(command.name()).thenReturn("Name");
    when(command.ratingSchemeId()).thenReturn(1L);
    when(command.columnType()).thenReturn(null);
    when(command.linkedEntity()).thenReturn(mock(EntityReference.class));
    when(command.rowType()).thenReturn(null);

    // Act
    Long actualCreateRoadmapResult = roadmapService.createRoadmap(command, "42");

    // Assert
    verify(entityRelationshipDao).create(isA(EntityRelationship.class));
    verify(roadmapDao).createRoadmap(eq("Name"), eq(1L), isNull(), isNull(), eq("42"));
    verify(command, atLeast(1)).name();
    verify(command).columnType();
    verify(command).linkedEntity();
    verify(command).ratingSchemeId();
    verify(command).rowType();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1L, actualCreateRoadmapResult.longValue());
  }

  /**
   * Method under test:
   * {@link RoadmapService#findRoadmapsBySelector(IdSelectionOptions)}
   */
  @Test
  void testFindRoadmapsBySelector() {
    // Arrange
    RoadmapDao roadmapDao = mock(RoadmapDao.class);
    ArrayList<Roadmap> roadmapList = new ArrayList<>();
    when(roadmapDao.findRoadmapsBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(roadmapList);
    RoadmapSearchDao roadmapSearchDao = mock(RoadmapSearchDao.class);
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    RoadmapService roadmapService = new RoadmapService(roadmapDao, roadmapSearchDao, scenarioDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(EntityRelationshipDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Collection<Roadmap> actualFindRoadmapsBySelectorResult = roadmapService.findRoadmapsBySelector(selectionOptions);

    // Assert
    verify(roadmapDao).findRoadmapsBySelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    assertTrue(actualFindRoadmapsBySelectorResult instanceof List);
    assertTrue(actualFindRoadmapsBySelectorResult.isEmpty());
    assertSame(roadmapList, actualFindRoadmapsBySelectorResult);
  }

  /**
   * Method under test:
   * {@link RoadmapService#updateDescription(long, String, String)}
   */
  @Test
  void testUpdateDescription() {
    // Arrange
    RoadmapDao roadmapDao = mock(RoadmapDao.class);
    when(roadmapDao.updateDescription(anyLong(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(true);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Boolean actualUpdateDescriptionResult = (new RoadmapService(roadmapDao, mock(RoadmapSearchDao.class),
        mock(ScenarioDao.class),
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(EntityRelationshipDao.class))).updateDescription(1L, "New Description", "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(roadmapDao).updateDescription(eq(1L), eq("New Description"), eq("42"));
    assertTrue(actualUpdateDescriptionResult);
  }

  /**
   * Method under test:
   * {@link RoadmapService#updateDescription(long, String, String)}
   */
  @Test
  void testUpdateDescription2() {
    // Arrange
    RoadmapDao roadmapDao = mock(RoadmapDao.class);
    when(roadmapDao.updateDescription(anyLong(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(false);
    RoadmapSearchDao roadmapSearchDao = mock(RoadmapSearchDao.class);
    ScenarioDao scenarioDao = mock(ScenarioDao.class);

    // Act
    Boolean actualUpdateDescriptionResult = (new RoadmapService(roadmapDao, roadmapSearchDao, scenarioDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(EntityRelationshipDao.class))).updateDescription(1L, "New Description", "42");

    // Assert
    verify(roadmapDao).updateDescription(eq(1L), eq("New Description"), eq("42"));
    assertFalse(actualUpdateDescriptionResult);
  }

  /**
   * Method under test:
   * {@link RoadmapService#updateDescription(long, String, String)}
   */
  @Test
  void testUpdateDescription3() {
    // Arrange
    RoadmapDao roadmapDao = mock(RoadmapDao.class);
    when(roadmapDao.updateDescription(anyLong(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(true);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Boolean actualUpdateDescriptionResult = (new RoadmapService(roadmapDao, mock(RoadmapSearchDao.class),
        mock(ScenarioDao.class), changeLogService, mock(EntityRelationshipDao.class))).updateDescription(1L,
            "New Description", "42");

    // Assert
    verify(roadmapDao).updateDescription(eq(1L), eq("New Description"), eq("42"));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateDescriptionResult);
  }

  /**
   * Method under test: {@link RoadmapService#updateName(long, String, String)}
   */
  @Test
  void testUpdateName() {
    // Arrange
    RoadmapDao roadmapDao = mock(RoadmapDao.class);
    when(roadmapDao.updateName(anyLong(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(true);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Boolean actualUpdateNameResult = (new RoadmapService(roadmapDao, mock(RoadmapSearchDao.class),
        mock(ScenarioDao.class),
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(EntityRelationshipDao.class))).updateName(1L, "New Name", "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(roadmapDao).updateName(eq(1L), eq("New Name"), eq("42"));
    assertTrue(actualUpdateNameResult);
  }

  /**
   * Method under test: {@link RoadmapService#updateName(long, String, String)}
   */
  @Test
  void testUpdateName2() {
    // Arrange
    RoadmapDao roadmapDao = mock(RoadmapDao.class);
    when(roadmapDao.updateName(anyLong(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(false);
    RoadmapSearchDao roadmapSearchDao = mock(RoadmapSearchDao.class);
    ScenarioDao scenarioDao = mock(ScenarioDao.class);

    // Act
    Boolean actualUpdateNameResult = (new RoadmapService(roadmapDao, roadmapSearchDao, scenarioDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(EntityRelationshipDao.class))).updateName(1L, "New Name", "42");

    // Assert
    verify(roadmapDao).updateName(eq(1L), eq("New Name"), eq("42"));
    assertFalse(actualUpdateNameResult);
  }

  /**
   * Method under test: {@link RoadmapService#updateName(long, String, String)}
   */
  @Test
  void testUpdateName3() {
    // Arrange
    RoadmapDao roadmapDao = mock(RoadmapDao.class);
    when(roadmapDao.updateName(anyLong(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(true);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Boolean actualUpdateNameResult = (new RoadmapService(roadmapDao, mock(RoadmapSearchDao.class),
        mock(ScenarioDao.class), changeLogService, mock(EntityRelationshipDao.class))).updateName(1L, "New Name", "42");

    // Assert
    verify(roadmapDao).updateName(eq(1L), eq("New Name"), eq("42"));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateNameResult);
  }

  /**
   * Method under test:
   * {@link RoadmapService#updateLifecycleStatus(long, EntityLifecycleStatus, String)}
   */
  @Test
  void testUpdateLifecycleStatus() {
    // Arrange
    RoadmapDao roadmapDao = mock(RoadmapDao.class);
    when(roadmapDao.updateLifecycleStatus(anyLong(), Mockito.<EntityLifecycleStatus>any(), Mockito.<String>any()))
        .thenReturn(true);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Boolean actualUpdateLifecycleStatusResult = (new RoadmapService(roadmapDao, mock(RoadmapSearchDao.class),
        mock(ScenarioDao.class),
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(EntityRelationshipDao.class))).updateLifecycleStatus(1L, EntityLifecycleStatus.ACTIVE, "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(roadmapDao).updateLifecycleStatus(eq(1L), eq(EntityLifecycleStatus.ACTIVE), eq("42"));
    assertTrue(actualUpdateLifecycleStatusResult);
  }

  /**
   * Method under test:
   * {@link RoadmapService#updateLifecycleStatus(long, EntityLifecycleStatus, String)}
   */
  @Test
  void testUpdateLifecycleStatus2() {
    // Arrange
    RoadmapDao roadmapDao = mock(RoadmapDao.class);
    when(roadmapDao.updateLifecycleStatus(anyLong(), Mockito.<EntityLifecycleStatus>any(), Mockito.<String>any()))
        .thenReturn(false);
    RoadmapSearchDao roadmapSearchDao = mock(RoadmapSearchDao.class);
    ScenarioDao scenarioDao = mock(ScenarioDao.class);

    // Act
    Boolean actualUpdateLifecycleStatusResult = (new RoadmapService(roadmapDao, roadmapSearchDao, scenarioDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(EntityRelationshipDao.class))).updateLifecycleStatus(1L, EntityLifecycleStatus.ACTIVE, "42");

    // Assert
    verify(roadmapDao).updateLifecycleStatus(eq(1L), eq(EntityLifecycleStatus.ACTIVE), eq("42"));
    assertFalse(actualUpdateLifecycleStatusResult);
  }

  /**
   * Method under test:
   * {@link RoadmapService#updateLifecycleStatus(long, EntityLifecycleStatus, String)}
   */
  @Test
  void testUpdateLifecycleStatus3() {
    // Arrange
    RoadmapDao roadmapDao = mock(RoadmapDao.class);
    when(roadmapDao.updateLifecycleStatus(anyLong(), Mockito.<EntityLifecycleStatus>any(), Mockito.<String>any()))
        .thenReturn(true);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Boolean actualUpdateLifecycleStatusResult = (new RoadmapService(roadmapDao, mock(RoadmapSearchDao.class),
        mock(ScenarioDao.class), changeLogService, mock(EntityRelationshipDao.class))).updateLifecycleStatus(1L,
            EntityLifecycleStatus.ACTIVE, "42");

    // Assert
    verify(roadmapDao).updateLifecycleStatus(eq(1L), eq(EntityLifecycleStatus.ACTIVE), eq("42"));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateLifecycleStatusResult);
  }

  /**
   * Method under test: {@link RoadmapService#addScenario(long, String, String)}
   */
  @Test
  void testAddScenario() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.add(anyLong(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(null);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Scenario actualAddScenarioResult = (new RoadmapService(mock(RoadmapDao.class), mock(RoadmapSearchDao.class),
        scenarioDao,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(EntityRelationshipDao.class))).addScenario(1L, "Name", "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(scenarioDao).add(eq(1L), eq("Name"), eq("42"));
    assertNull(actualAddScenarioResult);
  }

  /**
   * Method under test: {@link RoadmapService#addScenario(long, String, String)}
   */
  @Test
  void testAddScenario2() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.add(anyLong(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(null);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Scenario actualAddScenarioResult = (new RoadmapService(mock(RoadmapDao.class), mock(RoadmapSearchDao.class),
        scenarioDao, changeLogService, mock(EntityRelationshipDao.class))).addScenario(1L, "Name", "42");

    // Assert
    verify(scenarioDao).add(eq(1L), eq("Name"), eq("42"));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertNull(actualAddScenarioResult);
  }

  /**
   * Method under test: {@link RoadmapService#findAllRoadmapsAndScenarios()}
   */
  @Test
  void testFindAllRoadmapsAndScenarios() {
    // Arrange
    RoadmapDao roadmapDao = mock(RoadmapDao.class);
    ArrayList<RoadmapAndScenarioOverview> roadmapAndScenarioOverviewList = new ArrayList<>();
    when(roadmapDao.findAllRoadmapsAndScenarios()).thenReturn(roadmapAndScenarioOverviewList);
    RoadmapSearchDao roadmapSearchDao = mock(RoadmapSearchDao.class);
    ScenarioDao scenarioDao = mock(ScenarioDao.class);

    // Act
    Collection<RoadmapAndScenarioOverview> actualFindAllRoadmapsAndScenariosResult = (new RoadmapService(roadmapDao,
        roadmapSearchDao, scenarioDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(EntityRelationshipDao.class))).findAllRoadmapsAndScenarios();

    // Assert
    verify(roadmapDao).findAllRoadmapsAndScenarios();
    assertTrue(actualFindAllRoadmapsAndScenariosResult instanceof List);
    assertTrue(actualFindAllRoadmapsAndScenariosResult.isEmpty());
    assertSame(roadmapAndScenarioOverviewList, actualFindAllRoadmapsAndScenariosResult);
  }

  /**
   * Method under test:
   * {@link RoadmapService#findRoadmapsAndScenariosByRatedEntity(EntityReference)}
   */
  @Test
  void testFindRoadmapsAndScenariosByRatedEntity() {
    // Arrange
    RoadmapDao roadmapDao = mock(RoadmapDao.class);
    ArrayList<RoadmapAndScenarioOverview> roadmapAndScenarioOverviewList = new ArrayList<>();
    when(roadmapDao.findRoadmapsAndScenariosByRatedEntity(Mockito.<EntityReference>any()))
        .thenReturn(roadmapAndScenarioOverviewList);
    RoadmapSearchDao roadmapSearchDao = mock(RoadmapSearchDao.class);
    ScenarioDao scenarioDao = mock(ScenarioDao.class);

    // Act
    Collection<RoadmapAndScenarioOverview> actualFindRoadmapsAndScenariosByRatedEntityResult = (new RoadmapService(
        roadmapDao, roadmapSearchDao, scenarioDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(EntityRelationshipDao.class))).findRoadmapsAndScenariosByRatedEntity(null);

    // Assert
    verify(roadmapDao).findRoadmapsAndScenariosByRatedEntity(isNull());
    assertTrue(actualFindRoadmapsAndScenariosByRatedEntityResult instanceof List);
    assertTrue(actualFindRoadmapsAndScenariosByRatedEntityResult.isEmpty());
    assertSame(roadmapAndScenarioOverviewList, actualFindRoadmapsAndScenariosByRatedEntityResult);
  }

  /**
   * Method under test:
   * {@link RoadmapService#findRoadmapsAndScenariosByFormalRelationship(EntityReference)}
   */
  @Test
  void testFindRoadmapsAndScenariosByFormalRelationship() {
    // Arrange
    RoadmapDao roadmapDao = mock(RoadmapDao.class);
    ArrayList<RoadmapAndScenarioOverview> roadmapAndScenarioOverviewList = new ArrayList<>();
    when(roadmapDao.findRoadmapsAndScenariosByFormalRelationship(Mockito.<EntityReference>any()))
        .thenReturn(roadmapAndScenarioOverviewList);
    RoadmapSearchDao roadmapSearchDao = mock(RoadmapSearchDao.class);
    ScenarioDao scenarioDao = mock(ScenarioDao.class);

    // Act
    Collection<RoadmapAndScenarioOverview> actualFindRoadmapsAndScenariosByFormalRelationshipResult = (new RoadmapService(
        roadmapDao, roadmapSearchDao, scenarioDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(EntityRelationshipDao.class))).findRoadmapsAndScenariosByFormalRelationship(null);

    // Assert
    verify(roadmapDao).findRoadmapsAndScenariosByFormalRelationship(isNull());
    assertTrue(actualFindRoadmapsAndScenariosByFormalRelationshipResult instanceof List);
    assertTrue(actualFindRoadmapsAndScenariosByFormalRelationshipResult.isEmpty());
    assertSame(roadmapAndScenarioOverviewList, actualFindRoadmapsAndScenariosByFormalRelationshipResult);
  }

  /**
   * Method under test: {@link RoadmapService#search(String)}
   */
  @Test
  void testSearch() {
    // Arrange
    RoadmapSearchDao roadmapSearchDao = mock(RoadmapSearchDao.class);
    when(roadmapSearchDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(new ArrayList<>());
    RoadmapDao roadmapDao = mock(RoadmapDao.class);
    ScenarioDao scenarioDao = mock(ScenarioDao.class);

    // Act
    List<EntityReference> actualSearchResult = (new RoadmapService(roadmapDao, roadmapSearchDao, scenarioDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(EntityRelationshipDao.class))).search("Query");

    // Assert
    verify(roadmapSearchDao).search(isA(EntitySearchOptions.class));
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Method under test: {@link RoadmapService#search(EntitySearchOptions)}
   */
  @Test
  void testSearch2() {
    // Arrange
    RoadmapSearchDao roadmapSearchDao = mock(RoadmapSearchDao.class);
    ArrayList<Roadmap> roadmapList = new ArrayList<>();
    when(roadmapSearchDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(roadmapList);
    RoadmapDao roadmapDao = mock(RoadmapDao.class);
    ScenarioDao scenarioDao = mock(ScenarioDao.class);

    // Act
    List<Roadmap> actualSearchResult = (new RoadmapService(roadmapDao, roadmapSearchDao, scenarioDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(EntityRelationshipDao.class))).search((EntitySearchOptions) null);

    // Assert
    verify(roadmapSearchDao).search(isNull());
    assertTrue(actualSearchResult.isEmpty());
    assertSame(roadmapList, actualSearchResult);
  }
}
