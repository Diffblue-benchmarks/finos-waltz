package org.finos.waltz.service.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.common.exception.InsufficientPrivelegeException;
import org.finos.waltz.common.exception.NotFoundException;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.change_initiative.ChangeInitiativeDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.person.PersonDao;
import org.finos.waltz.data.person.search.PersonSearchDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.rating_scheme.RatingSchemeDAO;
import org.finos.waltz.data.report_grid.ReportGridDao;
import org.finos.waltz.data.report_grid.ReportGridMemberDao;
import org.finos.waltz.data.role.RoleDao;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.data.user.UserRoleDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.report_grid.AdditionalColumnOptions;
import org.finos.waltz.model.report_grid.ReportGrid;
import org.finos.waltz.model.report_grid.ReportGridColumnDefinitionsUpdateCommand;
import org.finos.waltz.model.report_grid.ReportGridCreateCommand;
import org.finos.waltz.model.report_grid.ReportGridDefinition;
import org.finos.waltz.model.report_grid.ReportGridInfo;
import org.finos.waltz.model.report_grid.ReportGridKind;
import org.finos.waltz.model.report_grid.ReportGridMemberRole;
import org.finos.waltz.model.report_grid.ReportGridUpdateCommand;
import org.finos.waltz.model.user.SystemRole;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.rating_scheme.RatingSchemeService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.user.UserRoleService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ReportGridServiceDiffblueTest {
  /**
   * Method under test: {@link ReportGridService#findAllDefinitions()}
   */
  @Test
  void testFindAllDefinitions() {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    HashSet<ReportGridDefinition> reportGridDefinitionSet = new HashSet<>();
    when(reportGridDao.findAllDefinitions()).thenReturn(reportGridDefinitionSet);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(mock(ReportGridMemberDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    Set<ReportGridDefinition> actualFindAllDefinitionsResult = (new ReportGridService(reportGridDao, applicationDao,
        ratingSchemeService, reportGridMemberService,
        new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
            new SettingsService(settingsDao, new ArrayList<>())),
        mock(ChangeInitiativeDao.class))).findAllDefinitions();

    // Assert
    verify(reportGridDao).findAllDefinitions();
    assertTrue(actualFindAllDefinitionsResult.isEmpty());
    assertSame(reportGridDefinitionSet, actualFindAllDefinitionsResult);
  }

  /**
   * Method under test: {@link ReportGridService#findAllDefinitions()}
   */
  @Test
  void testFindAllDefinitions2() {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.findAllDefinitions()).thenThrow(new NotFoundException("Code", "An error occurred"));
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(mock(ReportGridMemberDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act and Assert
    assertThrows(NotFoundException.class,
        () -> (new ReportGridService(reportGridDao, applicationDao, ratingSchemeService, reportGridMemberService,
            new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
                new SettingsService(settingsDao, new ArrayList<>())),
            mock(ChangeInitiativeDao.class))).findAllDefinitions());
    verify(reportGridDao).findAllDefinitions();
  }

  /**
   * Method under test: {@link ReportGridService#findByExternalId(String)}
   */
  @Test
  void testFindByExternalId() {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.getGridDefinitionByExternalId(Mockito.<String>any())).thenReturn(null);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(mock(ReportGridMemberDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    Optional<ReportGridDefinition> actualFindByExternalIdResult = (new ReportGridService(reportGridDao, applicationDao,
        ratingSchemeService, reportGridMemberService,
        new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
            new SettingsService(settingsDao, new ArrayList<>())),
        mock(ChangeInitiativeDao.class))).findByExternalId("42");

    // Assert
    verify(reportGridDao).getGridDefinitionByExternalId(eq("42"));
    assertFalse(actualFindByExternalIdResult.isPresent());
  }

  /**
   * Method under test: {@link ReportGridService#findByExternalId(String)}
   */
  @Test
  void testFindByExternalId2() {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.getGridDefinitionByExternalId(Mockito.<String>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(mock(ReportGridMemberDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act and Assert
    assertThrows(NotFoundException.class,
        () -> (new ReportGridService(reportGridDao, applicationDao, ratingSchemeService, reportGridMemberService,
            new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
                new SettingsService(settingsDao, new ArrayList<>())),
            mock(ChangeInitiativeDao.class))).findByExternalId("42"));
    verify(reportGridDao).getGridDefinitionByExternalId(eq("42"));
  }

  /**
   * Method under test:
   * {@link ReportGridService#findGridDefinitionsForUser(String)}
   */
  @Test
  void testFindGridDefinitionsForUser() {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    HashSet<ReportGridDefinition> reportGridDefinitionSet = new HashSet<>();
    when(reportGridDao.findGridDefinitionsForUser(Mockito.<String>any())).thenReturn(reportGridDefinitionSet);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(mock(ReportGridMemberDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    Set<ReportGridDefinition> actualFindGridDefinitionsForUserResult = (new ReportGridService(reportGridDao,
        applicationDao, ratingSchemeService, reportGridMemberService,
        new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
            new SettingsService(settingsDao, new ArrayList<>())),
        mock(ChangeInitiativeDao.class))).findGridDefinitionsForUser("janedoe");

    // Assert
    verify(reportGridDao).findGridDefinitionsForUser(eq("janedoe"));
    assertTrue(actualFindGridDefinitionsForUserResult.isEmpty());
    assertSame(reportGridDefinitionSet, actualFindGridDefinitionsForUserResult);
  }

  /**
   * Method under test:
   * {@link ReportGridService#findGridDefinitionsForUser(String)}
   */
  @Test
  void testFindGridDefinitionsForUser2() {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.findGridDefinitionsForUser(Mockito.<String>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(mock(ReportGridMemberDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act and Assert
    assertThrows(NotFoundException.class,
        () -> (new ReportGridService(reportGridDao, applicationDao, ratingSchemeService, reportGridMemberService,
            new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
                new SettingsService(settingsDao, new ArrayList<>())),
            mock(ChangeInitiativeDao.class))).findGridDefinitionsForUser("janedoe"));
    verify(reportGridDao).findGridDefinitionsForUser(eq("janedoe"));
  }

  /**
   * Method under test: {@link ReportGridService#findGridInfoForUser(String)}
   */
  @Test
  void testFindGridInfoForUser() {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    HashSet<ReportGridInfo> reportGridInfoSet = new HashSet<>();
    when(reportGridDao.findGridInfoForUser(Mockito.<String>any())).thenReturn(reportGridInfoSet);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(mock(ReportGridMemberDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    Set<ReportGridInfo> actualFindGridInfoForUserResult = (new ReportGridService(reportGridDao, applicationDao,
        ratingSchemeService, reportGridMemberService,
        new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
            new SettingsService(settingsDao, new ArrayList<>())),
        mock(ChangeInitiativeDao.class))).findGridInfoForUser("janedoe");

    // Assert
    verify(reportGridDao).findGridInfoForUser(eq("janedoe"));
    assertTrue(actualFindGridInfoForUserResult.isEmpty());
    assertSame(reportGridInfoSet, actualFindGridInfoForUserResult);
  }

  /**
   * Method under test: {@link ReportGridService#findGridInfoForUser(String)}
   */
  @Test
  void testFindGridInfoForUser2() {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.findGridInfoForUser(Mockito.<String>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(mock(ReportGridMemberDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act and Assert
    assertThrows(NotFoundException.class,
        () -> (new ReportGridService(reportGridDao, applicationDao, ratingSchemeService, reportGridMemberService,
            new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
                new SettingsService(settingsDao, new ArrayList<>())),
            mock(ChangeInitiativeDao.class))).findGridInfoForUser("janedoe"));
    verify(reportGridDao).findGridInfoForUser(eq("janedoe"));
  }

  /**
   * Method under test:
   * {@link ReportGridService#getByIdAndSelectionOptions(long, IdSelectionOptions, String)}
   */
  @Test
  void testGetByIdAndSelectionOptions() {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.getGridDefinitionById(anyLong())).thenReturn(null);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(mock(ReportGridMemberDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    Optional<ReportGrid> actualByIdAndSelectionOptions = (new ReportGridService(reportGridDao, applicationDao,
        ratingSchemeService, reportGridMemberService,
        new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
            new SettingsService(settingsDao, new ArrayList<>())),
        mock(ChangeInitiativeDao.class))).getByIdAndSelectionOptions(1L, null, "janedoe");

    // Assert
    verify(reportGridDao).getGridDefinitionById(eq(1L));
    assertFalse(actualByIdAndSelectionOptions.isPresent());
  }

  /**
   * Method under test:
   * {@link ReportGridService#getByIdAndSelectionOptions(long, IdSelectionOptions, String)}
   */
  @Test
  void testGetByIdAndSelectionOptions2() {
    // Arrange
    ReportGridDefinition reportGridDefinition = mock(ReportGridDefinition.class);
    when(reportGridDefinition.subjectKind())
        .thenThrow(new NotFoundException("ReportGrid - getting by ID={} SelectionOptions={}", "An error occurred"));
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.getGridDefinitionById(anyLong())).thenReturn(reportGridDefinition);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(mock(ReportGridMemberDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act and Assert
    assertThrows(NotFoundException.class,
        () -> (new ReportGridService(reportGridDao, applicationDao, ratingSchemeService, reportGridMemberService,
            new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
                new SettingsService(settingsDao, new ArrayList<>())),
            mock(ChangeInitiativeDao.class))).getByIdAndSelectionOptions(1L, null, "janedoe"));
    verify(reportGridDao).getGridDefinitionById(eq(1L));
    verify(reportGridDefinition).subjectKind();
  }

  /**
   * Method under test:
   * {@link ReportGridService#updateColumnDefinitions(long, ReportGridColumnDefinitionsUpdateCommand, String)}
   */
  @Test
  void testUpdateColumnDefinitions() throws InsufficientPrivelegeException {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.getGridDefinitionById(anyLong())).thenReturn(null);
    doNothing().when(reportGridDao)
        .updateColumnDefinitions(anyLong(), Mockito.<ReportGridColumnDefinitionsUpdateCommand>any());
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(reportGridMemberDao);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    ReportGridDefinition actualUpdateColumnDefinitionsResult = (new ReportGridService(reportGridDao, applicationDao,
        ratingSchemeService, reportGridMemberService,
        new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
            new SettingsService(settingsDao, new ArrayList<>())),
        mock(ChangeInitiativeDao.class))).updateColumnDefinitions(1L, null, "janedoe");

    // Assert
    verify(reportGridDao).getGridDefinitionById(eq(1L));
    verify(reportGridDao).updateColumnDefinitions(eq(1L), isNull());
    verify(reportGridMemberDao).canUpdate(eq(1L), eq("janedoe"));
    assertNull(actualUpdateColumnDefinitionsResult);
  }

  /**
   * Method under test:
   * {@link ReportGridService#updateColumnDefinitions(long, ReportGridColumnDefinitionsUpdateCommand, String)}
   */
  @Test
  void testUpdateColumnDefinitions2() throws InsufficientPrivelegeException {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    doThrow(new NotFoundException("Code", "An error occurred")).when(reportGridDao)
        .updateColumnDefinitions(anyLong(), Mockito.<ReportGridColumnDefinitionsUpdateCommand>any());
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(reportGridMemberDao);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act and Assert
    assertThrows(NotFoundException.class,
        () -> (new ReportGridService(reportGridDao, applicationDao, ratingSchemeService, reportGridMemberService,
            new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
                new SettingsService(settingsDao, new ArrayList<>())),
            mock(ChangeInitiativeDao.class))).updateColumnDefinitions(1L, null, "janedoe"));
    verify(reportGridDao).updateColumnDefinitions(eq(1L), isNull());
    verify(reportGridMemberDao).canUpdate(eq(1L), eq("janedoe"));
  }

  /**
   * Method under test:
   * {@link ReportGridService#updateColumnDefinitions(long, ReportGridColumnDefinitionsUpdateCommand, String)}
   */
  @Test
  void testUpdateColumnDefinitions3() throws InsufficientPrivelegeException {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.getGridDefinitionById(anyLong())).thenReturn(null);
    doNothing().when(reportGridDao)
        .updateColumnDefinitions(anyLong(), Mockito.<ReportGridColumnDefinitionsUpdateCommand>any());
    ReportGridMemberService reportGridMemberService = mock(ReportGridMemberService.class);
    doNothing().when(reportGridMemberService).checkIsOwner(anyLong(), Mockito.<String>any());
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    ReportGridDefinition actualUpdateColumnDefinitionsResult = (new ReportGridService(reportGridDao, applicationDao,
        ratingSchemeService, reportGridMemberService,
        new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
            new SettingsService(settingsDao, new ArrayList<>())),
        mock(ChangeInitiativeDao.class))).updateColumnDefinitions(1L, null, "janedoe");

    // Assert
    verify(reportGridDao).getGridDefinitionById(eq(1L));
    verify(reportGridDao).updateColumnDefinitions(eq(1L), isNull());
    verify(reportGridMemberService).checkIsOwner(eq(1L), eq("janedoe"));
    assertNull(actualUpdateColumnDefinitionsResult);
  }

  /**
   * Method under test:
   * {@link ReportGridService#findCommentSupportingColumnIdsForGrid(long)}
   */
  @Test
  void testFindCommentSupportingColumnIdsForGrid() {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    HashSet<Long> resultLongSet = new HashSet<>();
    when(reportGridDao.findCommentSupportingColumnIdsForGrid(anyLong())).thenReturn(resultLongSet);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(mock(ReportGridMemberDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    Set<Long> actualFindCommentSupportingColumnIdsForGridResult = (new ReportGridService(reportGridDao, applicationDao,
        ratingSchemeService, reportGridMemberService,
        new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
            new SettingsService(settingsDao, new ArrayList<>())),
        mock(ChangeInitiativeDao.class))).findCommentSupportingColumnIdsForGrid(1L);

    // Assert
    verify(reportGridDao).findCommentSupportingColumnIdsForGrid(eq(1L));
    assertTrue(actualFindCommentSupportingColumnIdsForGridResult.isEmpty());
    assertSame(resultLongSet, actualFindCommentSupportingColumnIdsForGridResult);
  }

  /**
   * Method under test:
   * {@link ReportGridService#findCommentSupportingColumnIdsForGrid(long)}
   */
  @Test
  void testFindCommentSupportingColumnIdsForGrid2() {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.findCommentSupportingColumnIdsForGrid(anyLong()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(mock(ReportGridMemberDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act and Assert
    assertThrows(NotFoundException.class,
        () -> (new ReportGridService(reportGridDao, applicationDao, ratingSchemeService, reportGridMemberService,
            new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
                new SettingsService(settingsDao, new ArrayList<>())),
            mock(ChangeInitiativeDao.class))).findCommentSupportingColumnIdsForGrid(1L));
    verify(reportGridDao).findCommentSupportingColumnIdsForGrid(eq(1L));
  }

  /**
   * Method under test:
   * {@link ReportGridService#create(ReportGridCreateCommand, String)}
   */
  @Test
  void testCreate() {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.create(Mockito.<ReportGridCreateCommand>any(), Mockito.<String>any())).thenReturn(1L);
    when(reportGridDao.getGridInfoById(anyLong())).thenReturn(null);
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.register(anyLong(), Mockito.<String>any(), Mockito.<ReportGridMemberRole>any()))
        .thenReturn(1);
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(reportGridMemberDao);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    ReportGridInfo actualCreateResult = (new ReportGridService(reportGridDao, applicationDao, ratingSchemeService,
        reportGridMemberService,
        new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
            new SettingsService(settingsDao, new ArrayList<>())),
        mock(ChangeInitiativeDao.class))).create(null, "janedoe");

    // Assert
    verify(reportGridDao).create(isNull(), eq("janedoe"));
    verify(reportGridDao).getGridInfoById(eq(1L));
    verify(reportGridMemberDao).register(eq(1L), eq("janedoe"), eq(ReportGridMemberRole.OWNER));
    assertNull(actualCreateResult);
  }

  /**
   * Method under test:
   * {@link ReportGridService#create(ReportGridCreateCommand, String)}
   */
  @Test
  void testCreate2() {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.create(Mockito.<ReportGridCreateCommand>any(), Mockito.<String>any())).thenReturn(1L);
    when(reportGridDao.getGridInfoById(anyLong())).thenReturn(null);
    ReportGridMemberService reportGridMemberService = mock(ReportGridMemberService.class);
    when(reportGridMemberService.register(anyLong(), Mockito.<String>any(), Mockito.<ReportGridMemberRole>any()))
        .thenReturn(1);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    ReportGridInfo actualCreateResult = (new ReportGridService(reportGridDao, applicationDao, ratingSchemeService,
        reportGridMemberService,
        new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
            new SettingsService(settingsDao, new ArrayList<>())),
        mock(ChangeInitiativeDao.class))).create(null, "janedoe");

    // Assert
    verify(reportGridDao).create(isNull(), eq("janedoe"));
    verify(reportGridDao).getGridInfoById(eq(1L));
    verify(reportGridMemberService).register(eq(1L), eq("janedoe"), eq(ReportGridMemberRole.OWNER));
    assertNull(actualCreateResult);
  }

  /**
   * Method under test:
   * {@link ReportGridService#update(long, ReportGridUpdateCommand, String)}
   */
  @Test
  void testUpdate() throws InsufficientPrivelegeException {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.getGridInfoById(anyLong())).thenThrow(new NotFoundException("Code", "An error occurred"));
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(reportGridMemberDao);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act and Assert
    assertThrows(NotFoundException.class,
        () -> (new ReportGridService(reportGridDao, applicationDao, ratingSchemeService, reportGridMemberService,
            new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
                new SettingsService(settingsDao, new ArrayList<>())),
            mock(ChangeInitiativeDao.class))).update(1L, null, "janedoe"));
    verify(reportGridDao).getGridInfoById(eq(1L));
    verify(reportGridMemberDao).canUpdate(eq(1L), eq("janedoe"));
  }

  /**
   * Method under test:
   * {@link ReportGridService#update(long, ReportGridUpdateCommand, String)}
   */
  @Test
  void testUpdate2() throws InsufficientPrivelegeException {
    // Arrange
    ReportGridMemberService reportGridMemberService = mock(ReportGridMemberService.class);
    doThrow(new NotFoundException("Code", "An error occurred")).when(reportGridMemberService)
        .checkIsOwner(anyLong(), Mockito.<String>any());
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act and Assert
    assertThrows(NotFoundException.class,
        () -> (new ReportGridService(reportGridDao, applicationDao, ratingSchemeService, reportGridMemberService,
            new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
                new SettingsService(settingsDao, new ArrayList<>())),
            mock(ChangeInitiativeDao.class))).update(1L, null, "janedoe"));
    verify(reportGridMemberService).checkIsOwner(eq(1L), eq("janedoe"));
  }

  /**
   * Method under test:
   * {@link ReportGridService#update(long, ReportGridUpdateCommand, String)}
   */
  @Test
  void testUpdate3() throws InsufficientPrivelegeException {
    // Arrange
    ReportGridInfo reportGridInfo = mock(ReportGridInfo.class);
    when(reportGridInfo.visibilityKind()).thenReturn(ReportGridKind.PUBLIC);
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.update(anyLong(), Mockito.<ReportGridUpdateCommand>any(), Mockito.<String>any())).thenReturn(1L);
    when(reportGridDao.getGridInfoById(anyLong())).thenReturn(reportGridInfo);
    ReportGridMemberService reportGridMemberService = mock(ReportGridMemberService.class);
    doNothing().when(reportGridMemberService).checkIsOwner(anyLong(), Mockito.<String>any());
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    ReportGridService reportGridService = new ReportGridService(
        reportGridDao, applicationDao, ratingSchemeService, reportGridMemberService, new UserRoleService(userRoleDao,
            roleDao, personDao, changeLogService, personService, new SettingsService(settingsDao, new ArrayList<>())),
        mock(ChangeInitiativeDao.class));
    ReportGridUpdateCommand updateCommand = mock(ReportGridUpdateCommand.class);
    when(updateCommand.kind()).thenReturn(ReportGridKind.PUBLIC);

    // Act
    reportGridService.update(1L, updateCommand, "janedoe");

    // Assert
    verify(reportGridDao, atLeast(1)).getGridInfoById(eq(1L));
    verify(reportGridDao).update(eq(1L), isA(ReportGridUpdateCommand.class), eq("janedoe"));
    verify(reportGridInfo).visibilityKind();
    verify(updateCommand).kind();
    verify(reportGridMemberService).checkIsOwner(eq(1L), eq("janedoe"));
  }

  /**
   * Method under test:
   * {@link ReportGridService#update(long, ReportGridUpdateCommand, String)}
   */
  @Test
  void testUpdate4() throws InsufficientPrivelegeException {
    // Arrange
    ReportGridInfo reportGridInfo = mock(ReportGridInfo.class);
    when(reportGridInfo.visibilityKind()).thenReturn(ReportGridKind.PUBLIC);
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.update(anyLong(), Mockito.<ReportGridUpdateCommand>any(), Mockito.<String>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));
    when(reportGridDao.getGridInfoById(anyLong())).thenReturn(reportGridInfo);
    ReportGridMemberService reportGridMemberService = mock(ReportGridMemberService.class);
    doNothing().when(reportGridMemberService).checkIsOwner(anyLong(), Mockito.<String>any());
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    ReportGridService reportGridService = new ReportGridService(
        reportGridDao, applicationDao, ratingSchemeService, reportGridMemberService, new UserRoleService(userRoleDao,
            roleDao, personDao, changeLogService, personService, new SettingsService(settingsDao, new ArrayList<>())),
        mock(ChangeInitiativeDao.class));
    ReportGridUpdateCommand updateCommand = mock(ReportGridUpdateCommand.class);
    when(updateCommand.kind()).thenReturn(ReportGridKind.PUBLIC);

    // Act and Assert
    assertThrows(NotFoundException.class, () -> reportGridService.update(1L, updateCommand, "janedoe"));
    verify(reportGridDao).getGridInfoById(eq(1L));
    verify(reportGridDao).update(eq(1L), isA(ReportGridUpdateCommand.class), eq("janedoe"));
    verify(reportGridInfo).visibilityKind();
    verify(updateCommand).kind();
    verify(reportGridMemberService).checkIsOwner(eq(1L), eq("janedoe"));
  }

  /**
   * Method under test:
   * {@link ReportGridService#update(long, ReportGridUpdateCommand, String)}
   */
  @Test
  void testUpdate5() throws InsufficientPrivelegeException {
    // Arrange
    ReportGridInfo reportGridInfo = mock(ReportGridInfo.class);
    when(reportGridInfo.visibilityKind()).thenReturn(ReportGridKind.PRIVATE);
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.update(anyLong(), Mockito.<ReportGridUpdateCommand>any(), Mockito.<String>any())).thenReturn(1L);
    when(reportGridDao.getGridInfoById(anyLong())).thenReturn(reportGridInfo);
    ReportGridMemberService reportGridMemberService = mock(ReportGridMemberService.class);
    doNothing().when(reportGridMemberService).checkIsOwner(anyLong(), Mockito.<String>any());
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (SystemRole[]) any())).thenReturn(true);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ReportGridService reportGridService = new ReportGridService(reportGridDao, applicationDao,
        new RatingSchemeService(mock(RatingSchemeDAO.class)), reportGridMemberService, userRoleService,
        mock(ChangeInitiativeDao.class));
    ReportGridUpdateCommand updateCommand = mock(ReportGridUpdateCommand.class);
    when(updateCommand.kind()).thenReturn(ReportGridKind.PUBLIC);

    // Act
    reportGridService.update(1L, updateCommand, "janedoe");

    // Assert
    verify(reportGridDao, atLeast(1)).getGridInfoById(eq(1L));
    verify(reportGridDao).update(eq(1L), isA(ReportGridUpdateCommand.class), eq("janedoe"));
    verify(reportGridInfo).visibilityKind();
    verify(updateCommand).kind();
    verify(reportGridMemberService).checkIsOwner(eq(1L), eq("janedoe"));
    verify(userRoleService).hasRole(eq("janedoe"), (SystemRole[]) any());
  }

  /**
   * Method under test:
   * {@link ReportGridService#update(long, ReportGridUpdateCommand, String)}
   */
  @Test
  void testUpdate6() throws InsufficientPrivelegeException {
    // Arrange
    ReportGridInfo reportGridInfo = mock(ReportGridInfo.class);
    when(reportGridInfo.visibilityKind()).thenReturn(ReportGridKind.PRIVATE);
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.getGridInfoById(anyLong())).thenReturn(reportGridInfo);
    ReportGridMemberService reportGridMemberService = mock(ReportGridMemberService.class);
    doNothing().when(reportGridMemberService).checkIsOwner(anyLong(), Mockito.<String>any());
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (SystemRole[]) any())).thenThrow(
        new NotFoundException("You do not have permission to change the kind of a report grid", "An error occurred"));
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    ReportGridService reportGridService = new ReportGridService(reportGridDao, applicationDao,
        new RatingSchemeService(mock(RatingSchemeDAO.class)), reportGridMemberService, userRoleService,
        mock(ChangeInitiativeDao.class));
    ReportGridUpdateCommand updateCommand = mock(ReportGridUpdateCommand.class);
    when(updateCommand.kind()).thenReturn(ReportGridKind.PUBLIC);

    // Act and Assert
    assertThrows(NotFoundException.class, () -> reportGridService.update(1L, updateCommand, "janedoe"));
    verify(reportGridDao).getGridInfoById(eq(1L));
    verify(reportGridInfo).visibilityKind();
    verify(updateCommand).kind();
    verify(reportGridMemberService).checkIsOwner(eq(1L), eq("janedoe"));
    verify(userRoleService).hasRole(eq("janedoe"), (SystemRole[]) any());
  }

  /**
   * Method under test: {@link ReportGridService#findDefinitionsForOwner(String)}
   */
  @Test
  void testFindDefinitionsForOwner() {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    HashSet<ReportGridDefinition> reportGridDefinitionSet = new HashSet<>();
    when(reportGridDao.findDefinitionsForOwner(Mockito.<String>any())).thenReturn(reportGridDefinitionSet);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(mock(ReportGridMemberDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    Set<ReportGridDefinition> actualFindDefinitionsForOwnerResult = (new ReportGridService(reportGridDao,
        applicationDao, ratingSchemeService, reportGridMemberService,
        new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
            new SettingsService(settingsDao, new ArrayList<>())),
        mock(ChangeInitiativeDao.class))).findDefinitionsForOwner("janedoe");

    // Assert
    verify(reportGridDao).findDefinitionsForOwner(eq("janedoe"));
    assertTrue(actualFindDefinitionsForOwnerResult.isEmpty());
    assertSame(reportGridDefinitionSet, actualFindDefinitionsForOwnerResult);
  }

  /**
   * Method under test: {@link ReportGridService#findDefinitionsForOwner(String)}
   */
  @Test
  void testFindDefinitionsForOwner2() {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.findDefinitionsForOwner(Mockito.<String>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(mock(ReportGridMemberDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act and Assert
    assertThrows(NotFoundException.class,
        () -> (new ReportGridService(reportGridDao, applicationDao, ratingSchemeService, reportGridMemberService,
            new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
                new SettingsService(settingsDao, new ArrayList<>())),
            mock(ChangeInitiativeDao.class))).findDefinitionsForOwner("janedoe"));
    verify(reportGridDao).findDefinitionsForOwner(eq("janedoe"));
  }

  /**
   * Method under test: {@link ReportGridService#remove(long, String)}
   */
  @Test
  void testRemove() throws InsufficientPrivelegeException {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.getGridDefinitionById(anyLong())).thenReturn(null);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(mock(ReportGridMemberDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act and Assert
    assertThrows(NotFoundException.class,
        () -> (new ReportGridService(reportGridDao, applicationDao, ratingSchemeService, reportGridMemberService,
            new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
                new SettingsService(settingsDao, new ArrayList<>())),
            mock(ChangeInitiativeDao.class))).remove(1L, "janedoe"));
    verify(reportGridDao).getGridDefinitionById(eq(1L));
  }

  /**
   * Method under test: {@link ReportGridService#remove(long, String)}
   */
  @Test
  void testRemove2() throws InsufficientPrivelegeException {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.remove(anyLong())).thenReturn(true);
    when(reportGridDao.getGridDefinitionById(anyLong())).thenReturn(mock(ReportGridDefinition.class));
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(reportGridMemberDao);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    boolean actualRemoveResult = (new ReportGridService(reportGridDao, applicationDao, ratingSchemeService,
        reportGridMemberService,
        new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
            new SettingsService(settingsDao, new ArrayList<>())),
        mock(ChangeInitiativeDao.class))).remove(1L, "janedoe");

    // Assert
    verify(reportGridDao).getGridDefinitionById(eq(1L));
    verify(reportGridDao).remove(eq(1L));
    verify(reportGridMemberDao).canUpdate(eq(1L), eq("janedoe"));
    assertTrue(actualRemoveResult);
  }

  /**
   * Method under test: {@link ReportGridService#remove(long, String)}
   */
  @Test
  void testRemove3() throws InsufficientPrivelegeException {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.remove(anyLong())).thenThrow(new NotFoundException("Code", "An error occurred"));
    when(reportGridDao.getGridDefinitionById(anyLong())).thenReturn(mock(ReportGridDefinition.class));
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(reportGridMemberDao);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act and Assert
    assertThrows(NotFoundException.class,
        () -> (new ReportGridService(reportGridDao, applicationDao, ratingSchemeService, reportGridMemberService,
            new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
                new SettingsService(settingsDao, new ArrayList<>())),
            mock(ChangeInitiativeDao.class))).remove(1L, "janedoe"));
    verify(reportGridDao).getGridDefinitionById(eq(1L));
    verify(reportGridDao).remove(eq(1L));
    verify(reportGridMemberDao).canUpdate(eq(1L), eq("janedoe"));
  }

  /**
   * Method under test: {@link ReportGridService#remove(long, String)}
   */
  @Test
  void testRemove4() throws InsufficientPrivelegeException {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.remove(anyLong())).thenReturn(false);
    when(reportGridDao.getGridDefinitionById(anyLong())).thenReturn(mock(ReportGridDefinition.class));
    ReportGridMemberDao reportGridMemberDao = mock(ReportGridMemberDao.class);
    when(reportGridMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(reportGridMemberDao);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    boolean actualRemoveResult = (new ReportGridService(reportGridDao, applicationDao, ratingSchemeService,
        reportGridMemberService,
        new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
            new SettingsService(settingsDao, new ArrayList<>())),
        mock(ChangeInitiativeDao.class))).remove(1L, "janedoe");

    // Assert
    verify(reportGridDao).getGridDefinitionById(eq(1L));
    verify(reportGridDao).remove(eq(1L));
    verify(reportGridMemberDao).canUpdate(eq(1L), eq("janedoe"));
    assertFalse(actualRemoveResult);
  }

  /**
   * Method under test: {@link ReportGridService#remove(long, String)}
   */
  @Test
  void testRemove5() throws InsufficientPrivelegeException {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.remove(anyLong())).thenReturn(true);
    when(reportGridDao.getGridDefinitionById(anyLong())).thenReturn(mock(ReportGridDefinition.class));
    ReportGridMemberService reportGridMemberService = mock(ReportGridMemberService.class);
    doNothing().when(reportGridMemberService).checkIsOwner(anyLong(), Mockito.<String>any());
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    boolean actualRemoveResult = (new ReportGridService(reportGridDao, applicationDao, ratingSchemeService,
        reportGridMemberService,
        new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
            new SettingsService(settingsDao, new ArrayList<>())),
        mock(ChangeInitiativeDao.class))).remove(1L, "janedoe");

    // Assert
    verify(reportGridDao).getGridDefinitionById(eq(1L));
    verify(reportGridDao).remove(eq(1L));
    verify(reportGridMemberService).checkIsOwner(eq(1L), eq("janedoe"));
    assertTrue(actualRemoveResult);
  }

  /**
   * Method under test: {@link ReportGridService#getGridDefinitionById(long)}
   */
  @Test
  void testGetGridDefinitionById() {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.getGridDefinitionById(anyLong())).thenReturn(null);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(mock(ReportGridMemberDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    ReportGridDefinition actualGridDefinitionById = (new ReportGridService(reportGridDao, applicationDao,
        ratingSchemeService, reportGridMemberService,
        new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
            new SettingsService(settingsDao, new ArrayList<>())),
        mock(ChangeInitiativeDao.class))).getGridDefinitionById(1L);

    // Assert
    verify(reportGridDao).getGridDefinitionById(eq(1L));
    assertNull(actualGridDefinitionById);
  }

  /**
   * Method under test: {@link ReportGridService#getGridDefinitionById(long)}
   */
  @Test
  void testGetGridDefinitionById2() {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.getGridDefinitionById(anyLong())).thenThrow(new NotFoundException("Code", "An error occurred"));
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(mock(ReportGridMemberDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act and Assert
    assertThrows(NotFoundException.class,
        () -> (new ReportGridService(reportGridDao, applicationDao, ratingSchemeService, reportGridMemberService,
            new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
                new SettingsService(settingsDao, new ArrayList<>())),
            mock(ChangeInitiativeDao.class))).getGridDefinitionById(1L));
    verify(reportGridDao).getGridDefinitionById(eq(1L));
  }

  /**
   * Method under test:
   * {@link ReportGridService#findAdditionalColumnOptionsForKind(EntityKind)}
   */
  @Test
  void testFindAdditionalColumnOptionsForKind() {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(mock(ReportGridMemberDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    Set<AdditionalColumnOptions> actualFindAdditionalColumnOptionsForKindResult = (new ReportGridService(reportGridDao,
        applicationDao, ratingSchemeService, reportGridMemberService,
        new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
            new SettingsService(settingsDao, new ArrayList<>())),
        mock(ChangeInitiativeDao.class))).findAdditionalColumnOptionsForKind(EntityKind.ALL);

    // Assert
    assertEquals(1, actualFindAdditionalColumnOptionsForKindResult.size());
    assertTrue(actualFindAdditionalColumnOptionsForKindResult.contains(AdditionalColumnOptions.NONE));
  }

  /**
   * Method under test:
   * {@link ReportGridService#findAdditionalColumnOptionsForKind(EntityKind)}
   */
  @Test
  void testFindAdditionalColumnOptionsForKind2() {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = mock(RatingSchemeService.class);
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(mock(ReportGridMemberDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    Set<AdditionalColumnOptions> actualFindAdditionalColumnOptionsForKindResult = (new ReportGridService(reportGridDao,
        applicationDao, ratingSchemeService, reportGridMemberService,
        new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
            new SettingsService(settingsDao, new ArrayList<>())),
        mock(ChangeInitiativeDao.class))).findAdditionalColumnOptionsForKind(EntityKind.ALL);

    // Assert
    assertEquals(1, actualFindAdditionalColumnOptionsForKindResult.size());
    assertTrue(actualFindAdditionalColumnOptionsForKindResult.contains(AdditionalColumnOptions.NONE));
  }

  /**
   * Method under test: {@link ReportGridService#getGridDefinitionByExtId(String)}
   */
  @Test
  void testGetGridDefinitionByExtId() {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.getGridDefinitionByExternalId(Mockito.<String>any())).thenReturn(null);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(mock(ReportGridMemberDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    ReportGridDefinition actualGridDefinitionByExtId = (new ReportGridService(reportGridDao, applicationDao,
        ratingSchemeService, reportGridMemberService,
        new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
            new SettingsService(settingsDao, new ArrayList<>())),
        mock(ChangeInitiativeDao.class))).getGridDefinitionByExtId("42");

    // Assert
    verify(reportGridDao).getGridDefinitionByExternalId(eq("42"));
    assertNull(actualGridDefinitionByExtId);
  }

  /**
   * Method under test: {@link ReportGridService#getGridDefinitionByExtId(String)}
   */
  @Test
  void testGetGridDefinitionByExtId2() {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.getGridDefinitionByExternalId(Mockito.<String>any()))
        .thenThrow(new NotFoundException("Code", "An error occurred"));
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(mock(ReportGridMemberDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act and Assert
    assertThrows(NotFoundException.class,
        () -> (new ReportGridService(reportGridDao, applicationDao, ratingSchemeService, reportGridMemberService,
            new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
                new SettingsService(settingsDao, new ArrayList<>())),
            mock(ChangeInitiativeDao.class))).getGridDefinitionByExtId("42"));
    verify(reportGridDao).getGridDefinitionByExternalId(eq("42"));
  }

  /**
   * Method under test:
   * {@link ReportGridService#clone(long, ReportGridUpdateCommand, String)}
   */
  @Test
  void testClone() {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.getGridDefinitionById(anyLong())).thenReturn(null);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(mock(ReportGridMemberDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act and Assert
    assertThrows(NotFoundException.class,
        () -> (new ReportGridService(reportGridDao, applicationDao, ratingSchemeService, reportGridMemberService,
            new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
                new SettingsService(settingsDao, new ArrayList<>())),
            mock(ChangeInitiativeDao.class))).clone(1L, null, "janedoe"));
    verify(reportGridDao).getGridDefinitionById(eq(1L));
  }

  /**
   * Method under test:
   * {@link ReportGridService#clone(long, ReportGridUpdateCommand, String)}
   */
  @Test
  void testClone2() {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.getGridDefinitionById(anyLong()))
        .thenThrow(new NotFoundException("REPORT_GRID_NOT_FOUND", "An error occurred"));
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(mock(ReportGridMemberDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act and Assert
    assertThrows(NotFoundException.class,
        () -> (new ReportGridService(reportGridDao, applicationDao, ratingSchemeService, reportGridMemberService,
            new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
                new SettingsService(settingsDao, new ArrayList<>())),
            mock(ChangeInitiativeDao.class))).clone(1L, null, "janedoe"));
    verify(reportGridDao).getGridDefinitionById(eq(1L));
  }

  /**
   * Method under test:
   * {@link ReportGridService#clone(long, ReportGridUpdateCommand, String)}
   */
  @Test
  void testClone3() {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.getGridDefinitionById(anyLong())).thenReturn(mock(ReportGridDefinition.class));
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(mock(ReportGridMemberDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    ReportGridService reportGridService = new ReportGridService(
        reportGridDao, applicationDao, ratingSchemeService, reportGridMemberService, new UserRoleService(userRoleDao,
            roleDao, personDao, changeLogService, personService, new SettingsService(settingsDao, new ArrayList<>())),
        mock(ChangeInitiativeDao.class));
    ReportGridUpdateCommand updateCommand = mock(ReportGridUpdateCommand.class);
    when(updateCommand.description()).thenThrow(new NotFoundException("name", "An error occurred"));
    when(updateCommand.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(NotFoundException.class, () -> reportGridService.clone(1L, updateCommand, "janedoe"));
    verify(reportGridDao).getGridDefinitionById(eq(1L));
    verify(updateCommand).description();
    verify(updateCommand).name();
  }

  /**
   * Method under test:
   * {@link ReportGridService#clone(long, ReportGridUpdateCommand, String)}
   */
  @Test
  void testClone4() {
    // Arrange
    ReportGridDefinition reportGridDefinition = mock(ReportGridDefinition.class);
    when(reportGridDefinition.subjectKind()).thenReturn(EntityKind.ALL);
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.create(Mockito.<ReportGridCreateCommand>any(), Mockito.<String>any())).thenReturn(1L);
    when(reportGridDao.getGridDefinitionById(anyLong())).thenReturn(reportGridDefinition);
    ReportGridMemberService reportGridMemberService = mock(ReportGridMemberService.class);
    when(reportGridMemberService.register(anyLong(), Mockito.<String>any(), Mockito.<ReportGridMemberRole>any()))
        .thenThrow(new NotFoundException("name", "An error occurred"));
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    ReportGridService reportGridService = new ReportGridService(
        reportGridDao, applicationDao, ratingSchemeService, reportGridMemberService, new UserRoleService(userRoleDao,
            roleDao, personDao, changeLogService, personService, new SettingsService(settingsDao, new ArrayList<>())),
        mock(ChangeInitiativeDao.class));
    ReportGridUpdateCommand updateCommand = mock(ReportGridUpdateCommand.class);
    when(updateCommand.description()).thenReturn("The characteristics of someone or something");
    when(updateCommand.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(NotFoundException.class, () -> reportGridService.clone(1L, updateCommand, "janedoe"));
    verify(reportGridDao).create(isA(ReportGridCreateCommand.class), eq("janedoe"));
    verify(reportGridDao).getGridDefinitionById(eq(1L));
    verify(reportGridDefinition).subjectKind();
    verify(updateCommand).description();
    verify(updateCommand).name();
    verify(reportGridMemberService).register(eq(1L), eq("janedoe"), eq(ReportGridMemberRole.OWNER));
  }

  /**
   * Method under test:
   * {@link ReportGridService#clone(long, ReportGridUpdateCommand, String)}
   */
  @Test
  void testClone5() {
    // Arrange
    ReportGridDefinition reportGridDefinition = mock(ReportGridDefinition.class);
    when(reportGridDefinition.derivedColumnDefinitions()).thenReturn(new ArrayList<>());
    when(reportGridDefinition.fixedColumnDefinitions()).thenReturn(new ArrayList<>());
    when(reportGridDefinition.subjectKind()).thenReturn(EntityKind.ALL);
    ReportGridInfo reportGridInfo = mock(ReportGridInfo.class);
    when(reportGridInfo.gridId()).thenReturn(1L);
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    doNothing().when(reportGridDao)
        .updateColumnDefinitions(anyLong(), Mockito.<ReportGridColumnDefinitionsUpdateCommand>any());
    when(reportGridDao.create(Mockito.<ReportGridCreateCommand>any(), Mockito.<String>any())).thenReturn(1L);
    when(reportGridDao.getGridInfoById(anyLong())).thenReturn(reportGridInfo);
    when(reportGridDao.getGridDefinitionById(anyLong())).thenReturn(reportGridDefinition);
    ReportGridMemberService reportGridMemberService = mock(ReportGridMemberService.class);
    when(reportGridMemberService.register(anyLong(), Mockito.<String>any(), Mockito.<ReportGridMemberRole>any()))
        .thenReturn(1);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    ReportGridService reportGridService = new ReportGridService(
        reportGridDao, applicationDao, ratingSchemeService, reportGridMemberService, new UserRoleService(userRoleDao,
            roleDao, personDao, changeLogService, personService, new SettingsService(settingsDao, new ArrayList<>())),
        mock(ChangeInitiativeDao.class));
    ReportGridUpdateCommand updateCommand = mock(ReportGridUpdateCommand.class);
    when(updateCommand.description()).thenReturn("The characteristics of someone or something");
    when(updateCommand.name()).thenReturn("Name");

    // Act
    reportGridService.clone(1L, updateCommand, "janedoe");

    // Assert
    verify(reportGridDao).create(isA(ReportGridCreateCommand.class), eq("janedoe"));
    verify(reportGridDao).getGridDefinitionById(eq(1L));
    verify(reportGridDao).getGridInfoById(eq(1L));
    verify(reportGridDao).updateColumnDefinitions(eq(1L), isA(ReportGridColumnDefinitionsUpdateCommand.class));
    verify(reportGridDefinition).derivedColumnDefinitions();
    verify(reportGridDefinition).fixedColumnDefinitions();
    verify(reportGridDefinition).subjectKind();
    verify(reportGridInfo).gridId();
    verify(updateCommand).description();
    verify(updateCommand).name();
    verify(reportGridMemberService).register(eq(1L), eq("janedoe"), eq(ReportGridMemberRole.OWNER));
  }
}
