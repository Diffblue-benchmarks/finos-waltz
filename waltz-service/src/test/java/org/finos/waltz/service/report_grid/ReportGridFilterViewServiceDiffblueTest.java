package org.finos.waltz.service.report_grid;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.app_group.AppGroupDao;
import org.finos.waltz.data.app_group.AppGroupEntryDao;
import org.finos.waltz.data.app_group.AppGroupMemberDao;
import org.finos.waltz.data.app_group.AppGroupOrganisationalUnitDao;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.change_initiative.ChangeInitiativeDao;
import org.finos.waltz.data.change_initiative.search.ChangeInitiativeSearchDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.entity_named_note.EntityNamedNoteDao;
import org.finos.waltz.data.entity_named_note.EntityNamedNoteTypeDao;
import org.finos.waltz.data.entity_relationship.EntityRelationshipDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.orgunit.OrganisationalUnitDao;
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
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.entity_named_note.EntityNamedNote;
import org.finos.waltz.model.report_grid.ReportGridDefinition;
import org.finos.waltz.service.app_group.AppGroupService;
import org.finos.waltz.service.change_initiative.ChangeInitiativeService;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.entity_named_note.EntityNamedNoteService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.rating_scheme.RatingSchemeService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.user.UserRoleService;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ReportGridFilterViewServiceDiffblueTest {
  /**
   * Method under test:
   * {@link ReportGridFilterViewService#recalculateAppGroupFromNoteText(Long, String)}
   */
  @Test
  void testRecalculateAppGroupFromNoteText() {
    // Arrange
    EntityNamedNoteDao entityNamedNoteDao = mock(EntityNamedNoteDao.class);
    when(
        entityNamedNoteDao.findByNoteTypeExtIdAndEntityReference(Mockito.<String>any(), Mockito.<EntityReference>any()))
            .thenReturn(new HashSet<>());
    EntityNamedNoteTypeDao entityNamedNodeTypeDao = mock(EntityNamedNoteTypeDao.class);
    EntityNamedNoteService entityNamedNoteService = new EntityNamedNoteService(entityNamedNoteDao,
        entityNamedNodeTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    ReportGridDao reportGridDao2 = mock(ReportGridDao.class);
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
        reportGridDao2, applicationDao, ratingSchemeService, reportGridMemberService, new UserRoleService(userRoleDao,
            roleDao, personDao, changeLogService, personService, new SettingsService(settingsDao, new ArrayList<>())),
        mock(ChangeInitiativeDao.class));

    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao2 = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new ReportGridFilterViewService(reportGridDao,
        reportGridService, entityNamedNoteService,
        new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao, applicationDao2,
            appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao, changeInitiativeService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))))
                    .recalculateAppGroupFromNoteText(1L, "42"));
    verify(entityNamedNoteDao).findByNoteTypeExtIdAndEntityReference(eq("WALTZ_REPORT_GRID_FILTER_PRESET"),
        isA(EntityReference.class));
  }

  /**
   * Method under test:
   * {@link ReportGridFilterViewService#recalculateAppGroupFromNoteText(Long, String)}
   */
  @Test
  void testRecalculateAppGroupFromNoteText2() {
    // Arrange
    EntityNamedNote entityNamedNote = mock(EntityNamedNote.class);
    when(entityNamedNote.noteText()).thenReturn("Note Text");

    HashSet<EntityNamedNote> entityNamedNoteSet = new HashSet<>();
    entityNamedNoteSet.add(entityNamedNote);
    EntityNamedNoteDao entityNamedNoteDao = mock(EntityNamedNoteDao.class);
    when(
        entityNamedNoteDao.findByNoteTypeExtIdAndEntityReference(Mockito.<String>any(), Mockito.<EntityReference>any()))
            .thenReturn(entityNamedNoteSet);
    EntityNamedNoteTypeDao entityNamedNodeTypeDao = mock(EntityNamedNoteTypeDao.class);
    EntityNamedNoteService entityNamedNoteService = new EntityNamedNoteService(entityNamedNoteDao,
        entityNamedNodeTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    ReportGridDao reportGridDao2 = mock(ReportGridDao.class);
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
        reportGridDao2, applicationDao, ratingSchemeService, reportGridMemberService, new UserRoleService(userRoleDao,
            roleDao, personDao, changeLogService, personService, new SettingsService(settingsDao, new ArrayList<>())),
        mock(ChangeInitiativeDao.class));

    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao2 = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new ReportGridFilterViewService(reportGridDao,
        reportGridService, entityNamedNoteService,
        new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao, applicationDao2,
            appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao, changeInitiativeService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))))
                    .recalculateAppGroupFromNoteText(1L, "42"));
    verify(entityNamedNoteDao).findByNoteTypeExtIdAndEntityReference(eq("WALTZ_REPORT_GRID_FILTER_PRESET"),
        isA(EntityReference.class));
    verify(entityNamedNote).noteText();
  }

  /**
   * Method under test:
   * {@link ReportGridFilterViewService#recalculateAppGroupFromNoteText(Long, String)}
   */
  @Test
  void testRecalculateAppGroupFromNoteText3() {
    // Arrange
    HashSet<EntityNamedNote> entityNamedNoteSet = new HashSet<>();
    entityNamedNoteSet.add(mock(EntityNamedNote.class));
    entityNamedNoteSet.add(mock(EntityNamedNote.class));
    EntityNamedNoteDao entityNamedNoteDao = mock(EntityNamedNoteDao.class);
    when(
        entityNamedNoteDao.findByNoteTypeExtIdAndEntityReference(Mockito.<String>any(), Mockito.<EntityReference>any()))
            .thenReturn(entityNamedNoteSet);
    EntityNamedNoteTypeDao entityNamedNodeTypeDao = mock(EntityNamedNoteTypeDao.class);
    EntityNamedNoteService entityNamedNoteService = new EntityNamedNoteService(entityNamedNoteDao,
        entityNamedNodeTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    ReportGridDao reportGridDao2 = mock(ReportGridDao.class);
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
        reportGridDao2, applicationDao, ratingSchemeService, reportGridMemberService, new UserRoleService(userRoleDao,
            roleDao, personDao, changeLogService, personService, new SettingsService(settingsDao, new ArrayList<>())),
        mock(ChangeInitiativeDao.class));

    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao2 = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new ReportGridFilterViewService(reportGridDao,
        reportGridService, entityNamedNoteService,
        new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao, applicationDao2,
            appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao, changeInitiativeService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))))
                    .recalculateAppGroupFromNoteText(1L, "42"));
    verify(entityNamedNoteDao).findByNoteTypeExtIdAndEntityReference(eq("WALTZ_REPORT_GRID_FILTER_PRESET"),
        isA(EntityReference.class));
  }

  /**
   * Method under test:
   * {@link ReportGridFilterViewService#recalculateAppGroupFromNoteText(Long, String)}
   */
  @Test
  void testRecalculateAppGroupFromNoteText4() {
    // Arrange
    EntityNamedNote entityNamedNote = mock(EntityNamedNote.class);
    when(entityNamedNote.noteText()).thenReturn(" ");

    HashSet<EntityNamedNote> entityNamedNoteSet = new HashSet<>();
    entityNamedNoteSet.add(entityNamedNote);
    EntityNamedNoteDao entityNamedNoteDao = mock(EntityNamedNoteDao.class);
    when(
        entityNamedNoteDao.findByNoteTypeExtIdAndEntityReference(Mockito.<String>any(), Mockito.<EntityReference>any()))
            .thenReturn(entityNamedNoteSet);
    EntityNamedNoteTypeDao entityNamedNodeTypeDao = mock(EntityNamedNoteTypeDao.class);
    EntityNamedNoteService entityNamedNoteService = new EntityNamedNoteService(entityNamedNoteDao,
        entityNamedNodeTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    ReportGridDao reportGridDao2 = mock(ReportGridDao.class);
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
        reportGridDao2, applicationDao, ratingSchemeService, reportGridMemberService, new UserRoleService(userRoleDao,
            roleDao, personDao, changeLogService, personService, new SettingsService(settingsDao, new ArrayList<>())),
        mock(ChangeInitiativeDao.class));

    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao2 = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new ReportGridFilterViewService(reportGridDao,
        reportGridService, entityNamedNoteService,
        new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao, applicationDao2,
            appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao, changeInitiativeService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))))
                    .recalculateAppGroupFromNoteText(1L, "42"));
    verify(entityNamedNoteDao).findByNoteTypeExtIdAndEntityReference(eq("WALTZ_REPORT_GRID_FILTER_PRESET"),
        isA(EntityReference.class));
    verify(entityNamedNote).noteText();
  }

  /**
   * Method under test:
   * {@link ReportGridFilterViewService#recalculateAppGroupFromNoteText(Long, String)}
   */
  @Test
  void testRecalculateAppGroupFromNoteText5() {
    // Arrange
    EntityNamedNote entityNamedNote = mock(EntityNamedNote.class);
    when(entityNamedNote.noteText()).thenReturn(null);

    HashSet<EntityNamedNote> entityNamedNoteSet = new HashSet<>();
    entityNamedNoteSet.add(entityNamedNote);
    EntityNamedNoteDao entityNamedNoteDao = mock(EntityNamedNoteDao.class);
    when(
        entityNamedNoteDao.findByNoteTypeExtIdAndEntityReference(Mockito.<String>any(), Mockito.<EntityReference>any()))
            .thenReturn(entityNamedNoteSet);
    EntityNamedNoteTypeDao entityNamedNodeTypeDao = mock(EntityNamedNoteTypeDao.class);
    EntityNamedNoteService entityNamedNoteService = new EntityNamedNoteService(entityNamedNoteDao,
        entityNamedNodeTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    ReportGridDao reportGridDao2 = mock(ReportGridDao.class);
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
        reportGridDao2, applicationDao, ratingSchemeService, reportGridMemberService, new UserRoleService(userRoleDao,
            roleDao, personDao, changeLogService, personService, new SettingsService(settingsDao, new ArrayList<>())),
        mock(ChangeInitiativeDao.class));

    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao2 = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new ReportGridFilterViewService(reportGridDao,
        reportGridService, entityNamedNoteService,
        new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao, applicationDao2,
            appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao, changeInitiativeService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))))
                    .recalculateAppGroupFromNoteText(1L, "42"));
    verify(entityNamedNoteDao).findByNoteTypeExtIdAndEntityReference(eq("WALTZ_REPORT_GRID_FILTER_PRESET"),
        isA(EntityReference.class));
    verify(entityNamedNote).noteText();
  }

  /**
   * Method under test:
   * {@link ReportGridFilterViewService#recalculateAppGroupFromNoteText(Long, String)}
   */
  @Test
  void testRecalculateAppGroupFromNoteText6() {
    // Arrange
    EntityNamedNoteService entityNamedNoteService = mock(EntityNamedNoteService.class);
    when(entityNamedNoteService.findByNoteTypeExtIdAndEntityReference(Mockito.<String>any(),
        Mockito.<EntityReference>any())).thenReturn(new HashSet<>());
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    ReportGridDao reportGridDao2 = mock(ReportGridDao.class);
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
        reportGridDao2, applicationDao, ratingSchemeService, reportGridMemberService, new UserRoleService(userRoleDao,
            roleDao, personDao, changeLogService, personService, new SettingsService(settingsDao, new ArrayList<>())),
        mock(ChangeInitiativeDao.class));

    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao2 = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new ReportGridFilterViewService(reportGridDao,
        reportGridService, entityNamedNoteService,
        new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao, applicationDao2,
            appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao, changeInitiativeService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))))
                    .recalculateAppGroupFromNoteText(1L, "42"));
    verify(entityNamedNoteService).findByNoteTypeExtIdAndEntityReference(eq("WALTZ_REPORT_GRID_FILTER_PRESET"),
        isA(EntityReference.class));
  }

  /**
   * Method under test:
   * {@link ReportGridFilterViewService#recalculateAppGroupFromNoteText(Long, String)}
   */
  @Test
  void testRecalculateAppGroupFromNoteText7() {
    // Arrange
    EntityNamedNote entityNamedNote = mock(EntityNamedNote.class);
    when(entityNamedNote.noteText()).thenThrow(new IllegalArgumentException("WALTZ_REPORT_GRID_FILTER_PRESET"));

    HashSet<EntityNamedNote> entityNamedNoteSet = new HashSet<>();
    entityNamedNoteSet.add(entityNamedNote);
    EntityNamedNoteService entityNamedNoteService = mock(EntityNamedNoteService.class);
    when(entityNamedNoteService.findByNoteTypeExtIdAndEntityReference(Mockito.<String>any(),
        Mockito.<EntityReference>any())).thenReturn(entityNamedNoteSet);
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    ReportGridDao reportGridDao2 = mock(ReportGridDao.class);
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
        reportGridDao2, applicationDao, ratingSchemeService, reportGridMemberService, new UserRoleService(userRoleDao,
            roleDao, personDao, changeLogService, personService, new SettingsService(settingsDao, new ArrayList<>())),
        mock(ChangeInitiativeDao.class));

    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao2 = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new ReportGridFilterViewService(reportGridDao,
        reportGridService, entityNamedNoteService,
        new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao, applicationDao2,
            appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao, changeInitiativeService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))))
                    .recalculateAppGroupFromNoteText(1L, "42"));
    verify(entityNamedNote).noteText();
    verify(entityNamedNoteService).findByNoteTypeExtIdAndEntityReference(eq("WALTZ_REPORT_GRID_FILTER_PRESET"),
        isA(EntityReference.class));
  }

  /**
   * Method under test:
   * {@link ReportGridFilterViewService#generateAppGroupsFromFilter()}
   */
  @Test
  void testGenerateAppGroupsFromFilter() {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.findAllDefinitions()).thenReturn(new HashSet<>());
    EntityNamedNoteDao entityNamedNoteDao = mock(EntityNamedNoteDao.class);
    when(entityNamedNoteDao.findByNoteTypeExtId(Mockito.<String>any())).thenReturn(new HashSet<>());
    EntityNamedNoteTypeDao entityNamedNodeTypeDao = mock(EntityNamedNoteTypeDao.class);
    EntityNamedNoteService entityNamedNoteService = new EntityNamedNoteService(entityNamedNoteDao,
        entityNamedNodeTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.processAdditionsAndRemovals(Mockito.<Set<Tuple2<Long, EntityReference>>>any(),
        Mockito.<Set<Tuple2<Long, EntityReference>>>any(), Mockito.<String>any())).thenReturn(42);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.fetchEntitiesForGroups(Mockito.<Set<Long>>any())).thenReturn(new HashMap<>());
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    AppGroupService appGroupService = new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        new ChangeInitiativeService(changeInitiativeDao, searchDao, relationshipDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        changeLogService);

    ReportGridDao reportGridDao2 = mock(ReportGridDao.class);
    ApplicationDao applicationDao2 = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(mock(ReportGridMemberDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    (new ReportGridFilterViewService(reportGridDao,
        new ReportGridService(reportGridDao2, applicationDao2, ratingSchemeService, reportGridMemberService,
            new UserRoleService(userRoleDao, roleDao, personDao, changeLogService2, personService,
                new SettingsService(settingsDao, new ArrayList<>())),
            mock(ChangeInitiativeDao.class)),
        entityNamedNoteService, appGroupService)).generateAppGroupsFromFilter();

    // Assert
    verify(appGroupDao).processAdditionsAndRemovals(isA(Set.class), isA(Set.class), eq("admin"));
    verify(appGroupEntryDao).fetchEntitiesForGroups(isA(Set.class));
    verify(changeLogDao).write(isA(Collection.class));
    verify(entityNamedNoteDao).findByNoteTypeExtId(eq("WALTZ_REPORT_GRID_FILTER_PRESET"));
    verify(reportGridDao).findAllDefinitions();
  }

  /**
   * Method under test:
   * {@link ReportGridFilterViewService#generateAppGroupsFromFilter()}
   */
  @Test
  void testGenerateAppGroupsFromFilter2() {
    // Arrange
    ReportGridDefinition reportGridDefinition = mock(ReportGridDefinition.class);
    Optional<String> ofResult = Optional.of("foo");
    when(reportGridDefinition.externalId()).thenReturn(ofResult);

    HashSet<ReportGridDefinition> reportGridDefinitionSet = new HashSet<>();
    reportGridDefinitionSet.add(reportGridDefinition);
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.findAllDefinitions()).thenReturn(reportGridDefinitionSet);
    EntityNamedNoteDao entityNamedNoteDao = mock(EntityNamedNoteDao.class);
    when(entityNamedNoteDao.findByNoteTypeExtId(Mockito.<String>any())).thenReturn(new HashSet<>());
    EntityNamedNoteTypeDao entityNamedNodeTypeDao = mock(EntityNamedNoteTypeDao.class);
    EntityNamedNoteService entityNamedNoteService = new EntityNamedNoteService(entityNamedNoteDao,
        entityNamedNodeTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.processAdditionsAndRemovals(Mockito.<Set<Tuple2<Long, EntityReference>>>any(),
        Mockito.<Set<Tuple2<Long, EntityReference>>>any(), Mockito.<String>any())).thenReturn(42);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.fetchEntitiesForGroups(Mockito.<Set<Long>>any())).thenReturn(new HashMap<>());
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    AppGroupService appGroupService = new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        new ChangeInitiativeService(changeInitiativeDao, searchDao, relationshipDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        changeLogService);

    ReportGridDao reportGridDao2 = mock(ReportGridDao.class);
    ApplicationDao applicationDao2 = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(mock(ReportGridMemberDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    (new ReportGridFilterViewService(reportGridDao,
        new ReportGridService(reportGridDao2, applicationDao2, ratingSchemeService, reportGridMemberService,
            new UserRoleService(userRoleDao, roleDao, personDao, changeLogService2, personService,
                new SettingsService(settingsDao, new ArrayList<>())),
            mock(ChangeInitiativeDao.class)),
        entityNamedNoteService, appGroupService)).generateAppGroupsFromFilter();

    // Assert
    verify(appGroupDao).processAdditionsAndRemovals(isA(Set.class), isA(Set.class), eq("admin"));
    verify(appGroupEntryDao).fetchEntitiesForGroups(isA(Set.class));
    verify(changeLogDao).write(isA(Collection.class));
    verify(entityNamedNoteDao).findByNoteTypeExtId(eq("WALTZ_REPORT_GRID_FILTER_PRESET"));
    verify(reportGridDao).findAllDefinitions();
    verify(reportGridDefinition).externalId();
  }

  /**
   * Method under test:
   * {@link ReportGridFilterViewService#generateAppGroupsFromFilter()}
   */
  @Test
  void testGenerateAppGroupsFromFilter3() {
    // Arrange
    ReportGridDefinition reportGridDefinition = mock(ReportGridDefinition.class);
    Optional<String> ofResult = Optional.of("foo");
    when(reportGridDefinition.externalId()).thenReturn(ofResult);
    ReportGridDefinition reportGridDefinition2 = mock(ReportGridDefinition.class);
    Optional<String> ofResult2 = Optional.of("foo");
    when(reportGridDefinition2.externalId()).thenReturn(ofResult2);

    HashSet<ReportGridDefinition> reportGridDefinitionSet = new HashSet<>();
    reportGridDefinitionSet.add(reportGridDefinition2);
    reportGridDefinitionSet.add(reportGridDefinition);
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.findAllDefinitions()).thenReturn(reportGridDefinitionSet);
    EntityNamedNoteDao entityNamedNoteDao = mock(EntityNamedNoteDao.class);
    when(entityNamedNoteDao.findByNoteTypeExtId(Mockito.<String>any())).thenReturn(new HashSet<>());
    EntityNamedNoteTypeDao entityNamedNodeTypeDao = mock(EntityNamedNoteTypeDao.class);
    EntityNamedNoteService entityNamedNoteService = new EntityNamedNoteService(entityNamedNoteDao,
        entityNamedNodeTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.processAdditionsAndRemovals(Mockito.<Set<Tuple2<Long, EntityReference>>>any(),
        Mockito.<Set<Tuple2<Long, EntityReference>>>any(), Mockito.<String>any())).thenReturn(42);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.fetchEntitiesForGroups(Mockito.<Set<Long>>any())).thenReturn(new HashMap<>());
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    AppGroupService appGroupService = new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        new ChangeInitiativeService(changeInitiativeDao, searchDao, relationshipDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        changeLogService);

    ReportGridDao reportGridDao2 = mock(ReportGridDao.class);
    ApplicationDao applicationDao2 = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(mock(ReportGridMemberDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    (new ReportGridFilterViewService(reportGridDao,
        new ReportGridService(reportGridDao2, applicationDao2, ratingSchemeService, reportGridMemberService,
            new UserRoleService(userRoleDao, roleDao, personDao, changeLogService2, personService,
                new SettingsService(settingsDao, new ArrayList<>())),
            mock(ChangeInitiativeDao.class)),
        entityNamedNoteService, appGroupService)).generateAppGroupsFromFilter();

    // Assert
    verify(appGroupDao).processAdditionsAndRemovals(isA(Set.class), isA(Set.class), eq("admin"));
    verify(appGroupEntryDao).fetchEntitiesForGroups(isA(Set.class));
    verify(changeLogDao).write(isA(Collection.class));
    verify(entityNamedNoteDao).findByNoteTypeExtId(eq("WALTZ_REPORT_GRID_FILTER_PRESET"));
    verify(reportGridDao).findAllDefinitions();
    verify(reportGridDefinition2).externalId();
    verify(reportGridDefinition).externalId();
  }

  /**
   * Method under test:
   * {@link ReportGridFilterViewService#generateAppGroupsFromFilter()}
   */
  @Test
  void testGenerateAppGroupsFromFilter4() {
    // Arrange
    ReportGridDefinition reportGridDefinition = mock(ReportGridDefinition.class);
    Optional<String> ofResult = Optional.of("foo");
    when(reportGridDefinition.externalId()).thenReturn(ofResult);
    ReportGridDefinition reportGridDefinition2 = mock(ReportGridDefinition.class);
    Optional<String> ofResult2 = Optional.of("foo");
    when(reportGridDefinition2.externalId()).thenReturn(ofResult2);
    ReportGridDefinition reportGridDefinition3 = mock(ReportGridDefinition.class);
    Optional<String> ofResult3 = Optional.of("foo");
    when(reportGridDefinition3.externalId()).thenReturn(ofResult3);
    ReportGridDefinition reportGridDefinition4 = mock(ReportGridDefinition.class);
    Optional<String> ofResult4 = Optional.of("foo");
    when(reportGridDefinition4.externalId()).thenReturn(ofResult4);
    ReportGridDefinition reportGridDefinition5 = mock(ReportGridDefinition.class);
    Optional<String> ofResult5 = Optional.of("foo");
    when(reportGridDefinition5.externalId()).thenReturn(ofResult5);
    ReportGridDefinition reportGridDefinition6 = mock(ReportGridDefinition.class);
    Optional<String> ofResult6 = Optional.of("foo");
    when(reportGridDefinition6.externalId()).thenReturn(ofResult6);
    ReportGridDefinition reportGridDefinition7 = mock(ReportGridDefinition.class);
    Optional<String> ofResult7 = Optional.of("foo");
    when(reportGridDefinition7.externalId()).thenReturn(ofResult7);
    ReportGridDefinition reportGridDefinition8 = mock(ReportGridDefinition.class);
    Optional<String> ofResult8 = Optional.of("foo");
    when(reportGridDefinition8.externalId()).thenReturn(ofResult8);
    ReportGridDefinition reportGridDefinition9 = mock(ReportGridDefinition.class);
    Optional<String> ofResult9 = Optional.of("foo");
    when(reportGridDefinition9.externalId()).thenReturn(ofResult9);
    ReportGridDefinition reportGridDefinition10 = mock(ReportGridDefinition.class);
    Optional<String> ofResult10 = Optional.of("foo");
    when(reportGridDefinition10.externalId()).thenReturn(ofResult10);
    ReportGridDefinition reportGridDefinition11 = mock(ReportGridDefinition.class);
    Optional<String> ofResult11 = Optional.of("foo");
    when(reportGridDefinition11.externalId()).thenReturn(ofResult11);
    ReportGridDefinition reportGridDefinition12 = mock(ReportGridDefinition.class);
    Optional<String> ofResult12 = Optional.of("foo");
    when(reportGridDefinition12.externalId()).thenReturn(ofResult12);
    ReportGridDefinition reportGridDefinition13 = mock(ReportGridDefinition.class);
    Optional<String> ofResult13 = Optional.of("foo");
    when(reportGridDefinition13.externalId()).thenReturn(ofResult13);
    ReportGridDefinition reportGridDefinition14 = mock(ReportGridDefinition.class);
    Optional<String> ofResult14 = Optional.of("foo");
    when(reportGridDefinition14.externalId()).thenReturn(ofResult14);
    ReportGridDefinition reportGridDefinition15 = mock(ReportGridDefinition.class);
    Optional<String> ofResult15 = Optional.of("foo");
    when(reportGridDefinition15.externalId()).thenReturn(ofResult15);
    ReportGridDefinition reportGridDefinition16 = mock(ReportGridDefinition.class);
    Optional<String> ofResult16 = Optional.of("foo");
    when(reportGridDefinition16.externalId()).thenReturn(ofResult16);
    ReportGridDefinition reportGridDefinition17 = mock(ReportGridDefinition.class);
    Optional<String> ofResult17 = Optional.of("foo");
    when(reportGridDefinition17.externalId()).thenReturn(ofResult17);
    ReportGridDefinition reportGridDefinition18 = mock(ReportGridDefinition.class);
    Optional<String> ofResult18 = Optional.of("foo");
    when(reportGridDefinition18.externalId()).thenReturn(ofResult18);
    ReportGridDefinition reportGridDefinition19 = mock(ReportGridDefinition.class);
    Optional<String> ofResult19 = Optional.of("foo");
    when(reportGridDefinition19.externalId()).thenReturn(ofResult19);
    ReportGridDefinition reportGridDefinition20 = mock(ReportGridDefinition.class);
    Optional<String> ofResult20 = Optional.of("foo");
    when(reportGridDefinition20.externalId()).thenReturn(ofResult20);
    ReportGridDefinition reportGridDefinition21 = mock(ReportGridDefinition.class);
    Optional<String> ofResult21 = Optional.of("foo");
    when(reportGridDefinition21.externalId()).thenReturn(ofResult21);
    ReportGridDefinition reportGridDefinition22 = mock(ReportGridDefinition.class);
    Optional<String> ofResult22 = Optional.of("foo");
    when(reportGridDefinition22.externalId()).thenReturn(ofResult22);
    ReportGridDefinition reportGridDefinition23 = mock(ReportGridDefinition.class);
    Optional<String> ofResult23 = Optional.of("foo");
    when(reportGridDefinition23.externalId()).thenReturn(ofResult23);
    ReportGridDefinition reportGridDefinition24 = mock(ReportGridDefinition.class);
    Optional<String> ofResult24 = Optional.of("foo");
    when(reportGridDefinition24.externalId()).thenReturn(ofResult24);
    ReportGridDefinition reportGridDefinition25 = mock(ReportGridDefinition.class);
    Optional<String> ofResult25 = Optional.of("foo");
    when(reportGridDefinition25.externalId()).thenReturn(ofResult25);
    ReportGridDefinition reportGridDefinition26 = mock(ReportGridDefinition.class);
    Optional<String> ofResult26 = Optional.of("foo");
    when(reportGridDefinition26.externalId()).thenReturn(ofResult26);
    ReportGridDefinition reportGridDefinition27 = mock(ReportGridDefinition.class);
    Optional<String> ofResult27 = Optional.of("foo");
    when(reportGridDefinition27.externalId()).thenReturn(ofResult27);
    ReportGridDefinition reportGridDefinition28 = mock(ReportGridDefinition.class);
    Optional<String> ofResult28 = Optional.of("foo");
    when(reportGridDefinition28.externalId()).thenReturn(ofResult28);
    ReportGridDefinition reportGridDefinition29 = mock(ReportGridDefinition.class);
    Optional<String> ofResult29 = Optional.of("foo");
    when(reportGridDefinition29.externalId()).thenReturn(ofResult29);
    ReportGridDefinition reportGridDefinition30 = mock(ReportGridDefinition.class);
    Optional<String> ofResult30 = Optional.of("foo");
    when(reportGridDefinition30.externalId()).thenReturn(ofResult30);
    ReportGridDefinition reportGridDefinition31 = mock(ReportGridDefinition.class);
    Optional<String> ofResult31 = Optional.of("foo");
    when(reportGridDefinition31.externalId()).thenReturn(ofResult31);
    ReportGridDefinition reportGridDefinition32 = mock(ReportGridDefinition.class);
    Optional<String> ofResult32 = Optional.of("foo");
    when(reportGridDefinition32.externalId()).thenReturn(ofResult32);
    ReportGridDefinition reportGridDefinition33 = mock(ReportGridDefinition.class);
    Optional<String> ofResult33 = Optional.of("foo");
    when(reportGridDefinition33.externalId()).thenReturn(ofResult33);
    ReportGridDefinition reportGridDefinition34 = mock(ReportGridDefinition.class);
    Optional<String> ofResult34 = Optional.of("foo");
    when(reportGridDefinition34.externalId()).thenReturn(ofResult34);
    ReportGridDefinition reportGridDefinition35 = mock(ReportGridDefinition.class);
    Optional<String> ofResult35 = Optional.of("foo");
    when(reportGridDefinition35.externalId()).thenReturn(ofResult35);
    ReportGridDefinition reportGridDefinition36 = mock(ReportGridDefinition.class);
    Optional<String> ofResult36 = Optional.of("foo");
    when(reportGridDefinition36.externalId()).thenReturn(ofResult36);
    ReportGridDefinition reportGridDefinition37 = mock(ReportGridDefinition.class);
    Optional<String> ofResult37 = Optional.of("foo");
    when(reportGridDefinition37.externalId()).thenReturn(ofResult37);
    ReportGridDefinition reportGridDefinition38 = mock(ReportGridDefinition.class);
    Optional<String> ofResult38 = Optional.of("foo");
    when(reportGridDefinition38.externalId()).thenReturn(ofResult38);
    ReportGridDefinition reportGridDefinition39 = mock(ReportGridDefinition.class);
    Optional<String> ofResult39 = Optional.of("foo");
    when(reportGridDefinition39.externalId()).thenReturn(ofResult39);
    ReportGridDefinition reportGridDefinition40 = mock(ReportGridDefinition.class);
    Optional<String> ofResult40 = Optional.of("foo");
    when(reportGridDefinition40.externalId()).thenReturn(ofResult40);
    ReportGridDefinition reportGridDefinition41 = mock(ReportGridDefinition.class);
    Optional<String> ofResult41 = Optional.of("foo");
    when(reportGridDefinition41.externalId()).thenReturn(ofResult41);
    ReportGridDefinition reportGridDefinition42 = mock(ReportGridDefinition.class);
    Optional<String> ofResult42 = Optional.of("foo");
    when(reportGridDefinition42.externalId()).thenReturn(ofResult42);
    ReportGridDefinition reportGridDefinition43 = mock(ReportGridDefinition.class);
    Optional<String> ofResult43 = Optional.of("foo");
    when(reportGridDefinition43.externalId()).thenReturn(ofResult43);
    ReportGridDefinition reportGridDefinition44 = mock(ReportGridDefinition.class);
    Optional<String> ofResult44 = Optional.of("foo");
    when(reportGridDefinition44.externalId()).thenReturn(ofResult44);
    ReportGridDefinition reportGridDefinition45 = mock(ReportGridDefinition.class);
    Optional<String> ofResult45 = Optional.of("foo");
    when(reportGridDefinition45.externalId()).thenReturn(ofResult45);
    ReportGridDefinition reportGridDefinition46 = mock(ReportGridDefinition.class);
    Optional<String> ofResult46 = Optional.of("foo");
    when(reportGridDefinition46.externalId()).thenReturn(ofResult46);
    ReportGridDefinition reportGridDefinition47 = mock(ReportGridDefinition.class);
    Optional<String> ofResult47 = Optional.of("foo");
    when(reportGridDefinition47.externalId()).thenReturn(ofResult47);
    ReportGridDefinition reportGridDefinition48 = mock(ReportGridDefinition.class);
    Optional<String> ofResult48 = Optional.of("foo");
    when(reportGridDefinition48.externalId()).thenReturn(ofResult48);
    ReportGridDefinition reportGridDefinition49 = mock(ReportGridDefinition.class);
    Optional<String> ofResult49 = Optional.of("foo");
    when(reportGridDefinition49.externalId()).thenReturn(ofResult49);
    ReportGridDefinition reportGridDefinition50 = mock(ReportGridDefinition.class);
    Optional<String> ofResult50 = Optional.of("foo");
    when(reportGridDefinition50.externalId()).thenReturn(ofResult50);
    ReportGridDefinition reportGridDefinition51 = mock(ReportGridDefinition.class);
    Optional<String> ofResult51 = Optional.of("foo");
    when(reportGridDefinition51.externalId()).thenReturn(ofResult51);
    ReportGridDefinition reportGridDefinition52 = mock(ReportGridDefinition.class);
    Optional<String> ofResult52 = Optional.of("foo");
    when(reportGridDefinition52.externalId()).thenReturn(ofResult52);
    ReportGridDefinition reportGridDefinition53 = mock(ReportGridDefinition.class);
    Optional<String> ofResult53 = Optional.of("foo");
    when(reportGridDefinition53.externalId()).thenReturn(ofResult53);
    ReportGridDefinition reportGridDefinition54 = mock(ReportGridDefinition.class);
    Optional<String> ofResult54 = Optional.of("foo");
    when(reportGridDefinition54.externalId()).thenReturn(ofResult54);
    ReportGridDefinition reportGridDefinition55 = mock(ReportGridDefinition.class);
    Optional<String> ofResult55 = Optional.of("foo");
    when(reportGridDefinition55.externalId()).thenReturn(ofResult55);
    ReportGridDefinition reportGridDefinition56 = mock(ReportGridDefinition.class);
    Optional<String> ofResult56 = Optional.of("foo");
    when(reportGridDefinition56.externalId()).thenReturn(ofResult56);
    ReportGridDefinition reportGridDefinition57 = mock(ReportGridDefinition.class);
    Optional<String> ofResult57 = Optional.of("foo");
    when(reportGridDefinition57.externalId()).thenReturn(ofResult57);
    ReportGridDefinition reportGridDefinition58 = mock(ReportGridDefinition.class);
    Optional<String> ofResult58 = Optional.of("foo");
    when(reportGridDefinition58.externalId()).thenReturn(ofResult58);
    ReportGridDefinition reportGridDefinition59 = mock(ReportGridDefinition.class);
    Optional<String> ofResult59 = Optional.of("foo");
    when(reportGridDefinition59.externalId()).thenReturn(ofResult59);
    ReportGridDefinition reportGridDefinition60 = mock(ReportGridDefinition.class);
    Optional<String> ofResult60 = Optional.of("foo");
    when(reportGridDefinition60.externalId()).thenReturn(ofResult60);
    ReportGridDefinition reportGridDefinition61 = mock(ReportGridDefinition.class);
    Optional<String> ofResult61 = Optional.of("foo");
    when(reportGridDefinition61.externalId()).thenReturn(ofResult61);

    HashSet<ReportGridDefinition> reportGridDefinitionSet = new HashSet<>();
    reportGridDefinitionSet.add(reportGridDefinition61);
    reportGridDefinitionSet.add(reportGridDefinition60);
    reportGridDefinitionSet.add(reportGridDefinition59);
    reportGridDefinitionSet.add(reportGridDefinition58);
    reportGridDefinitionSet.add(reportGridDefinition57);
    reportGridDefinitionSet.add(reportGridDefinition56);
    reportGridDefinitionSet.add(reportGridDefinition55);
    reportGridDefinitionSet.add(reportGridDefinition54);
    reportGridDefinitionSet.add(reportGridDefinition53);
    reportGridDefinitionSet.add(reportGridDefinition52);
    reportGridDefinitionSet.add(reportGridDefinition51);
    reportGridDefinitionSet.add(reportGridDefinition50);
    reportGridDefinitionSet.add(reportGridDefinition49);
    reportGridDefinitionSet.add(reportGridDefinition48);
    reportGridDefinitionSet.add(reportGridDefinition47);
    reportGridDefinitionSet.add(reportGridDefinition46);
    reportGridDefinitionSet.add(reportGridDefinition45);
    reportGridDefinitionSet.add(reportGridDefinition44);
    reportGridDefinitionSet.add(reportGridDefinition43);
    reportGridDefinitionSet.add(reportGridDefinition42);
    reportGridDefinitionSet.add(reportGridDefinition41);
    reportGridDefinitionSet.add(reportGridDefinition40);
    reportGridDefinitionSet.add(reportGridDefinition39);
    reportGridDefinitionSet.add(reportGridDefinition38);
    reportGridDefinitionSet.add(reportGridDefinition37);
    reportGridDefinitionSet.add(reportGridDefinition36);
    reportGridDefinitionSet.add(reportGridDefinition35);
    reportGridDefinitionSet.add(reportGridDefinition34);
    reportGridDefinitionSet.add(reportGridDefinition33);
    reportGridDefinitionSet.add(reportGridDefinition32);
    reportGridDefinitionSet.add(reportGridDefinition31);
    reportGridDefinitionSet.add(reportGridDefinition30);
    reportGridDefinitionSet.add(reportGridDefinition29);
    reportGridDefinitionSet.add(reportGridDefinition28);
    reportGridDefinitionSet.add(reportGridDefinition27);
    reportGridDefinitionSet.add(reportGridDefinition26);
    reportGridDefinitionSet.add(reportGridDefinition25);
    reportGridDefinitionSet.add(reportGridDefinition24);
    reportGridDefinitionSet.add(reportGridDefinition23);
    reportGridDefinitionSet.add(reportGridDefinition22);
    reportGridDefinitionSet.add(reportGridDefinition21);
    reportGridDefinitionSet.add(reportGridDefinition20);
    reportGridDefinitionSet.add(reportGridDefinition19);
    reportGridDefinitionSet.add(reportGridDefinition18);
    reportGridDefinitionSet.add(reportGridDefinition17);
    reportGridDefinitionSet.add(reportGridDefinition16);
    reportGridDefinitionSet.add(reportGridDefinition15);
    reportGridDefinitionSet.add(reportGridDefinition14);
    reportGridDefinitionSet.add(reportGridDefinition13);
    reportGridDefinitionSet.add(reportGridDefinition12);
    reportGridDefinitionSet.add(reportGridDefinition11);
    reportGridDefinitionSet.add(reportGridDefinition10);
    reportGridDefinitionSet.add(reportGridDefinition9);
    reportGridDefinitionSet.add(reportGridDefinition8);
    reportGridDefinitionSet.add(reportGridDefinition7);
    reportGridDefinitionSet.add(reportGridDefinition6);
    reportGridDefinitionSet.add(reportGridDefinition5);
    reportGridDefinitionSet.add(reportGridDefinition4);
    reportGridDefinitionSet.add(reportGridDefinition3);
    reportGridDefinitionSet.add(reportGridDefinition2);
    reportGridDefinitionSet.add(reportGridDefinition);
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.findAllDefinitions()).thenReturn(reportGridDefinitionSet);
    EntityNamedNoteService entityNamedNoteService = mock(EntityNamedNoteService.class);
    when(entityNamedNoteService.findByNoteTypeExtId(Mockito.<String>any())).thenReturn(new HashSet<>());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.processAdditionsAndRemovals(Mockito.<Set<Tuple2<Long, EntityReference>>>any(),
        Mockito.<Set<Tuple2<Long, EntityReference>>>any(), Mockito.<String>any())).thenReturn(42);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.fetchEntitiesForGroups(Mockito.<Set<Long>>any())).thenReturn(new HashMap<>());
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    AppGroupService appGroupService = new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        new ChangeInitiativeService(changeInitiativeDao, searchDao, relationshipDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        changeLogService);

    ReportGridDao reportGridDao2 = mock(ReportGridDao.class);
    ApplicationDao applicationDao2 = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService = new ReportGridMemberService(mock(ReportGridMemberDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    (new ReportGridFilterViewService(reportGridDao,
        new ReportGridService(reportGridDao2, applicationDao2, ratingSchemeService, reportGridMemberService,
            new UserRoleService(userRoleDao, roleDao, personDao, changeLogService2, personService,
                new SettingsService(settingsDao, new ArrayList<>())),
            mock(ChangeInitiativeDao.class)),
        entityNamedNoteService, appGroupService)).generateAppGroupsFromFilter();

    // Assert
    verify(appGroupDao).processAdditionsAndRemovals(isA(Set.class), isA(Set.class), eq("admin"));
    verify(appGroupEntryDao).fetchEntitiesForGroups(isA(Set.class));
    verify(changeLogDao).write(isA(Collection.class));
    verify(reportGridDao).findAllDefinitions();
    verify(reportGridDefinition61).externalId();
    verify(reportGridDefinition60).externalId();
    verify(reportGridDefinition59).externalId();
    verify(reportGridDefinition58).externalId();
    verify(reportGridDefinition57).externalId();
    verify(reportGridDefinition56).externalId();
    verify(reportGridDefinition55).externalId();
    verify(reportGridDefinition54).externalId();
    verify(reportGridDefinition53).externalId();
    verify(reportGridDefinition52).externalId();
    verify(reportGridDefinition51).externalId();
    verify(reportGridDefinition50).externalId();
    verify(reportGridDefinition49).externalId();
    verify(reportGridDefinition48).externalId();
    verify(reportGridDefinition47).externalId();
    verify(reportGridDefinition46).externalId();
    verify(reportGridDefinition45).externalId();
    verify(reportGridDefinition44).externalId();
    verify(reportGridDefinition43).externalId();
    verify(reportGridDefinition42).externalId();
    verify(reportGridDefinition41).externalId();
    verify(reportGridDefinition40).externalId();
    verify(reportGridDefinition39).externalId();
    verify(reportGridDefinition38).externalId();
    verify(reportGridDefinition37).externalId();
    verify(reportGridDefinition36).externalId();
    verify(reportGridDefinition35).externalId();
    verify(reportGridDefinition34).externalId();
    verify(reportGridDefinition33).externalId();
    verify(reportGridDefinition32).externalId();
    verify(reportGridDefinition31).externalId();
    verify(reportGridDefinition30).externalId();
    verify(reportGridDefinition29).externalId();
    verify(reportGridDefinition28).externalId();
    verify(reportGridDefinition27).externalId();
    verify(reportGridDefinition26).externalId();
    verify(reportGridDefinition25).externalId();
    verify(reportGridDefinition24).externalId();
    verify(reportGridDefinition23).externalId();
    verify(reportGridDefinition22).externalId();
    verify(reportGridDefinition21).externalId();
    verify(reportGridDefinition20).externalId();
    verify(reportGridDefinition19).externalId();
    verify(reportGridDefinition18).externalId();
    verify(reportGridDefinition17).externalId();
    verify(reportGridDefinition16).externalId();
    verify(reportGridDefinition15).externalId();
    verify(reportGridDefinition14).externalId();
    verify(reportGridDefinition13).externalId();
    verify(reportGridDefinition12).externalId();
    verify(reportGridDefinition11).externalId();
    verify(reportGridDefinition10).externalId();
    verify(reportGridDefinition9).externalId();
    verify(reportGridDefinition8).externalId();
    verify(reportGridDefinition7).externalId();
    verify(reportGridDefinition6).externalId();
    verify(reportGridDefinition5).externalId();
    verify(reportGridDefinition4).externalId();
    verify(reportGridDefinition3).externalId();
    verify(reportGridDefinition2).externalId();
    verify(reportGridDefinition).externalId();
    verify(entityNamedNoteService).findByNoteTypeExtId(eq("WALTZ_REPORT_GRID_FILTER_PRESET"));
  }
}
