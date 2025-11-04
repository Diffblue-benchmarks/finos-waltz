package org.finos.waltz.service.scenario;

import static org.junit.jupiter.api.Assertions.assertFalse;
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
import org.finos.waltz.data.application.search.ApplicationSearchDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.entity_alias.EntityAliasDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.rating_scheme.RatingSchemeDAO;
import org.finos.waltz.data.scenario.ScenarioAxisItemDao;
import org.finos.waltz.data.scenario.ScenarioDao;
import org.finos.waltz.data.scenario.ScenarioRatingItemDao;
import org.finos.waltz.data.tag.TagDao;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.scenario.ChangeScenarioCommand;
import org.finos.waltz.model.scenario.Scenario;
import org.finos.waltz.model.scenario.ScenarioRatingItem;
import org.finos.waltz.service.application.ApplicationService;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.rating_scheme.RatingSchemeService;
import org.finos.waltz.service.tag.TagService;
import org.jooq.DSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ScenarioRatingItemServiceDiffblueTest {
  /**
   * Method under test: {@link ScenarioRatingItemService#findForScenarioId(long)}
   */
  @Test
  void testFindForScenarioId() {
    // Arrange
    ScenarioRatingItemDao scenarioRatingItemDao = mock(ScenarioRatingItemDao.class);
    ArrayList<ScenarioRatingItem> scenarioRatingItemList = new ArrayList<>();
    when(scenarioRatingItemDao.findForScenarioId(anyLong())).thenReturn(scenarioRatingItemList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    ScenarioAxisItemDao scenarioAxisItemDao = mock(ScenarioAxisItemDao.class);
    ScenarioRatingItemDao scenarioRatingItemDao2 = mock(ScenarioRatingItemDao.class);

    // Act
    Collection<ScenarioRatingItem> actualFindForScenarioIdResult = (new ScenarioRatingItemService(scenarioRatingItemDao,
        changeLogService, applicationService, ratingSchemeService,
        new ScenarioService(scenarioDao, scenarioAxisItemDao, scenarioRatingItemDao2,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))))
                    .findForScenarioId(1L);

    // Assert
    verify(scenarioRatingItemDao).findForScenarioId(eq(1L));
    assertTrue(actualFindForScenarioIdResult instanceof List);
    assertTrue(actualFindForScenarioIdResult.isEmpty());
    assertSame(scenarioRatingItemList, actualFindForScenarioIdResult);
  }

  /**
   * Method under test:
   * {@link ScenarioRatingItemService#remove(ChangeScenarioCommand, String)}
   */
  @Test
  void testRemove() {
    // Arrange
    ScenarioRatingItemDao scenarioRatingItemDao = mock(ScenarioRatingItemDao.class);
    when(scenarioRatingItemDao.remove(Mockito.<ChangeScenarioCommand>any(), Mockito.<String>any())).thenReturn(false);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    ScenarioAxisItemDao scenarioAxisItemDao = mock(ScenarioAxisItemDao.class);
    ScenarioRatingItemDao scenarioRatingItemDao2 = mock(ScenarioRatingItemDao.class);

    // Act
    boolean actualRemoveResult = (new ScenarioRatingItemService(scenarioRatingItemDao, changeLogService,
        applicationService, ratingSchemeService,
        new ScenarioService(scenarioDao, scenarioAxisItemDao, scenarioRatingItemDao2,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))))
                    .remove(null, "42");

    // Assert
    verify(scenarioRatingItemDao).remove(isNull(), eq("42"));
    assertFalse(actualRemoveResult);
  }

  /**
   * Method under test:
   * {@link ScenarioRatingItemService#remove(ChangeScenarioCommand, String)}
   */
  @Test
  void testRemove2() {
    // Arrange
    ScenarioRatingItemDao scenarioRatingItemDao = mock(ScenarioRatingItemDao.class);
    when(scenarioRatingItemDao.remove(Mockito.<ChangeScenarioCommand>any(), Mockito.<String>any())).thenReturn(true);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    Application application = mock(Application.class);
    when(application.name()).thenReturn("Name");
    Optional<ExternalIdValue> ofResult = Optional.of(ExternalIdValue.of("42"));
    when(application.assetCode()).thenReturn(ofResult);
    ApplicationService applicationService = mock(ApplicationService.class);
    when(applicationService.getById(anyLong())).thenReturn(application);
    Scenario scenario = mock(Scenario.class);
    when(scenario.name()).thenReturn("Name");
    ScenarioService scenarioService = mock(ScenarioService.class);
    when(scenarioService.getById(anyLong())).thenReturn(scenario);
    ScenarioRatingItemService scenarioRatingItemService = new ScenarioRatingItemService(scenarioRatingItemDao,
        changeLogService, applicationService, new RatingSchemeService(mock(RatingSchemeDAO.class)), scenarioService);
    ChangeScenarioCommand command = mock(ChangeScenarioCommand.class);
    when(command.appId()).thenReturn(1L);
    when(command.scenarioId()).thenReturn(1L);

    // Act
    boolean actualRemoveResult = scenarioRatingItemService.remove(command, "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(scenarioRatingItemDao).remove(isA(ChangeScenarioCommand.class), eq("42"));
    verify(application).name();
    verify(scenario).name();
    verify(application).assetCode();
    verify(command).appId();
    verify(command, atLeast(1)).scenarioId();
    verify(applicationService).getById(eq(1L));
    verify(scenarioService).getById(eq(1L));
    assertTrue(actualRemoveResult);
  }

  /**
   * Method under test:
   * {@link ScenarioRatingItemService#remove(ChangeScenarioCommand, String)}
   */
  @Test
  void testRemove3() {
    // Arrange
    ScenarioRatingItemDao scenarioRatingItemDao = mock(ScenarioRatingItemDao.class);
    when(scenarioRatingItemDao.remove(Mockito.<ChangeScenarioCommand>any(), Mockito.<String>any())).thenReturn(true);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    Application application = mock(Application.class);
    when(application.name()).thenReturn("Name");
    Optional<ExternalIdValue> ofResult = Optional.of(ExternalIdValue.of("42"));
    when(application.assetCode()).thenReturn(ofResult);
    ApplicationService applicationService = mock(ApplicationService.class);
    when(applicationService.getById(anyLong())).thenReturn(application);
    Scenario scenario = mock(Scenario.class);
    when(scenario.name()).thenReturn("Name");
    ScenarioService scenarioService = mock(ScenarioService.class);
    when(scenarioService.getById(anyLong())).thenReturn(scenario);
    ScenarioRatingItemService scenarioRatingItemService = new ScenarioRatingItemService(scenarioRatingItemDao,
        changeLogService, applicationService, new RatingSchemeService(mock(RatingSchemeDAO.class)), scenarioService);
    ChangeScenarioCommand command = mock(ChangeScenarioCommand.class);
    when(command.appId()).thenReturn(1L);
    when(command.scenarioId()).thenReturn(1L);

    // Act
    boolean actualRemoveResult = scenarioRatingItemService.remove(command, "42");

    // Assert
    verify(scenarioRatingItemDao).remove(isA(ChangeScenarioCommand.class), eq("42"));
    verify(application).name();
    verify(scenario).name();
    verify(application).assetCode();
    verify(command).appId();
    verify(command, atLeast(1)).scenarioId();
    verify(applicationService).getById(eq(1L));
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(scenarioService).getById(eq(1L));
    assertTrue(actualRemoveResult);
  }

  /**
   * Method under test:
   * {@link ScenarioRatingItemService#add(ChangeScenarioCommand, String)}
   */
  @Test
  void testAdd() {
    // Arrange
    ScenarioRatingItemDao scenarioRatingItemDao = mock(ScenarioRatingItemDao.class);
    when(scenarioRatingItemDao.add(Mockito.<ChangeScenarioCommand>any(), Mockito.<String>any())).thenReturn(false);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    ScenarioAxisItemDao scenarioAxisItemDao = mock(ScenarioAxisItemDao.class);
    ScenarioRatingItemDao scenarioRatingItemDao2 = mock(ScenarioRatingItemDao.class);

    // Act
    boolean actualAddResult = (new ScenarioRatingItemService(scenarioRatingItemDao, changeLogService,
        applicationService, ratingSchemeService,
        new ScenarioService(scenarioDao, scenarioAxisItemDao, scenarioRatingItemDao2,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))))
                    .add(null, "42");

    // Assert
    verify(scenarioRatingItemDao).add(isNull(), eq("42"));
    assertFalse(actualAddResult);
  }

  /**
   * Method under test:
   * {@link ScenarioRatingItemService#add(ChangeScenarioCommand, String)}
   */
  @Test
  void testAdd2() {
    // Arrange
    ScenarioRatingItemDao scenarioRatingItemDao = mock(ScenarioRatingItemDao.class);
    when(scenarioRatingItemDao.add(Mockito.<ChangeScenarioCommand>any(), Mockito.<String>any())).thenReturn(true);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    Application application = mock(Application.class);
    when(application.name()).thenReturn("Name");
    Optional<ExternalIdValue> ofResult = Optional.of(ExternalIdValue.of("42"));
    when(application.assetCode()).thenReturn(ofResult);
    ApplicationService applicationService = mock(ApplicationService.class);
    when(applicationService.getById(anyLong())).thenReturn(application);
    Scenario scenario = mock(Scenario.class);
    when(scenario.name()).thenReturn("Name");
    ScenarioService scenarioService = mock(ScenarioService.class);
    when(scenarioService.getById(anyLong())).thenReturn(scenario);
    ScenarioRatingItemService scenarioRatingItemService = new ScenarioRatingItemService(scenarioRatingItemDao,
        changeLogService, applicationService, new RatingSchemeService(mock(RatingSchemeDAO.class)), scenarioService);
    ChangeScenarioCommand command = mock(ChangeScenarioCommand.class);
    when(command.appId()).thenReturn(1L);
    when(command.scenarioId()).thenReturn(1L);

    // Act
    boolean actualAddResult = scenarioRatingItemService.add(command, "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(scenarioRatingItemDao).add(isA(ChangeScenarioCommand.class), eq("42"));
    verify(application).name();
    verify(scenario).name();
    verify(application).assetCode();
    verify(command).appId();
    verify(command, atLeast(1)).scenarioId();
    verify(applicationService).getById(eq(1L));
    verify(scenarioService).getById(eq(1L));
    assertTrue(actualAddResult);
  }

  /**
   * Method under test:
   * {@link ScenarioRatingItemService#add(ChangeScenarioCommand, String)}
   */
  @Test
  void testAdd3() {
    // Arrange
    ScenarioRatingItemDao scenarioRatingItemDao = mock(ScenarioRatingItemDao.class);
    when(scenarioRatingItemDao.add(Mockito.<ChangeScenarioCommand>any(), Mockito.<String>any())).thenReturn(true);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    Application application = mock(Application.class);
    when(application.name()).thenReturn("Name");
    Optional<ExternalIdValue> ofResult = Optional.of(ExternalIdValue.of("42"));
    when(application.assetCode()).thenReturn(ofResult);
    ApplicationService applicationService = mock(ApplicationService.class);
    when(applicationService.getById(anyLong())).thenReturn(application);
    Scenario scenario = mock(Scenario.class);
    when(scenario.name()).thenReturn("Name");
    ScenarioService scenarioService = mock(ScenarioService.class);
    when(scenarioService.getById(anyLong())).thenReturn(scenario);
    ScenarioRatingItemService scenarioRatingItemService = new ScenarioRatingItemService(scenarioRatingItemDao,
        changeLogService, applicationService, new RatingSchemeService(mock(RatingSchemeDAO.class)), scenarioService);
    ChangeScenarioCommand command = mock(ChangeScenarioCommand.class);
    when(command.appId()).thenReturn(1L);
    when(command.scenarioId()).thenReturn(1L);

    // Act
    boolean actualAddResult = scenarioRatingItemService.add(command, "42");

    // Assert
    verify(scenarioRatingItemDao).add(isA(ChangeScenarioCommand.class), eq("42"));
    verify(application).name();
    verify(scenario).name();
    verify(application).assetCode();
    verify(command).appId();
    verify(command, atLeast(1)).scenarioId();
    verify(applicationService).getById(eq(1L));
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(scenarioService).getById(eq(1L));
    assertTrue(actualAddResult);
  }

  /**
   * Method under test:
   * {@link ScenarioRatingItemService#updateRating(ChangeScenarioCommand, String)}
   */
  @Test
  void testUpdateRating() {
    // Arrange
    ScenarioRatingItemDao scenarioRatingItemDao = mock(ScenarioRatingItemDao.class);
    when(scenarioRatingItemDao.updateRating(Mockito.<ChangeScenarioCommand>any(), Mockito.<String>any()))
        .thenReturn(false);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    ScenarioAxisItemDao scenarioAxisItemDao = mock(ScenarioAxisItemDao.class);
    ScenarioRatingItemDao scenarioRatingItemDao2 = mock(ScenarioRatingItemDao.class);

    // Act
    boolean actualUpdateRatingResult = (new ScenarioRatingItemService(scenarioRatingItemDao, changeLogService,
        applicationService, ratingSchemeService,
        new ScenarioService(scenarioDao, scenarioAxisItemDao, scenarioRatingItemDao2,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))))
                    .updateRating(null, "42");

    // Assert
    verify(scenarioRatingItemDao).updateRating(isNull(), eq("42"));
    assertFalse(actualUpdateRatingResult);
  }
}
