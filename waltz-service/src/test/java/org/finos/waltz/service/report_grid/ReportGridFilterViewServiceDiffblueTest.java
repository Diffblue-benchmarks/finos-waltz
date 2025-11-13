package org.finos.waltz.service.report_grid;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.entity_named_note.EntityNamedNote;
import org.finos.waltz.model.entity_named_note.ImmutableEntityNamedNote;
import org.finos.waltz.model.entity_named_note.ImmutableEntityNamedNote.Builder;
import org.finos.waltz.model.report_grid.ImmutableReportGridDefinition;
import org.finos.waltz.model.report_grid.ReportGridDefinition;
import org.finos.waltz.model.report_grid.ReportGridKind;
import org.finos.waltz.service.app_group.AppGroupService;
import org.finos.waltz.service.change_initiative.ChangeInitiativeService;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.entity_named_note.EntityNamedNoteService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.rating_scheme.RatingSchemeService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.user.UserRoleService;
import org.jooq.lambda.tuple.Tuple2;
import org.jooq.lambda.tuple.Tuple3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ReportGridFilterViewServiceDiffblueTest {
  @Mock private AppGroupService appGroupService;

  @Mock private EntityNamedNoteService entityNamedNoteService;

  @Mock private ReportGridDao reportGridDao;

  @InjectMocks private ReportGridFilterViewService reportGridFilterViewService;

  /**
   * Test {@link ReportGridFilterViewService#recalculateAppGroupFromNoteText(Long, String)}.
   *
   * <p>Method under test: {@link ReportGridFilterViewService#recalculateAppGroupFromNoteText(Long,
   * String)}
   */
  @Test
  @DisplayName("Test recalculateAppGroupFromNoteText(Long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ReportGridFilterViewService.recalculateAppGroupFromNoteText(Long, String)"
  })
  void testRecalculateAppGroupFromNoteText() {
    // Arrange
    EntityNamedNoteDao entityNamedNoteDao = mock(EntityNamedNoteDao.class);
    when(entityNamedNoteDao.findByNoteTypeExtIdAndEntityReference(
            Mockito.<String>any(), Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());
    EntityNamedNoteTypeDao entityNamedNodeTypeDao = mock(EntityNamedNoteTypeDao.class);
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

    EntityNamedNoteService entityNamedNoteService =
        new EntityNamedNoteService(entityNamedNoteDao, entityNamedNodeTypeDao, changeLogService);
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    ReportGridDao reportGridDao2 = mock(ReportGridDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService =
        new ReportGridMemberService(mock(ReportGridMemberDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 =
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService2, personService, settingsService);

    ReportGridService reportGridService =
        new ReportGridService(
            reportGridDao2,
            applicationDao,
            ratingSchemeService,
            reportGridMemberService,
            userRoleService,
            mock(ChangeInitiativeDao.class));
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao2 = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    ChangeLogService changeLogService3 =
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

    ChangeInitiativeService changeInitiativeService =
        new ChangeInitiativeService(
            changeInitiativeDao, searchDao, relationshipDao, changeLogService3);
    ChangeLogService changeLogService4 =
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

    AppGroupService appGroupService =
        new AppGroupService(
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao2,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService4);

    ReportGridFilterViewService reportGridFilterViewService =
        new ReportGridFilterViewService(
            reportGridDao, reportGridService, entityNamedNoteService, appGroupService);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> reportGridFilterViewService.recalculateAppGroupFromNoteText(1L, "42"));
    verify(entityNamedNoteDao)
        .findByNoteTypeExtIdAndEntityReference(
            eq("WALTZ_REPORT_GRID_FILTER_PRESET"), isA(EntityReference.class));
  }

  /**
   * Test {@link ReportGridFilterViewService#recalculateAppGroupFromNoteText(Long, String)}.
   *
   * <p>Method under test: {@link ReportGridFilterViewService#recalculateAppGroupFromNoteText(Long,
   * String)}
   */
  @Test
  @DisplayName("Test recalculateAppGroupFromNoteText(Long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ReportGridFilterViewService.recalculateAppGroupFromNoteText(Long, String)"
  })
  void testRecalculateAppGroupFromNoteText2() {
    // Arrange
    HashSet<EntityNamedNote> entityNamedNoteSet = new HashSet<>();

    Builder builderResult = ImmutableEntityNamedNote.builder();
    entityNamedNoteSet.add(
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .namedNoteTypeId(1L)
            .noteText("Note Text")
            .provenance("Provenance")
            .build());

    EntityNamedNoteDao entityNamedNoteDao = mock(EntityNamedNoteDao.class);
    when(entityNamedNoteDao.findByNoteTypeExtIdAndEntityReference(
            Mockito.<String>any(), Mockito.<EntityReference>any()))
        .thenReturn(entityNamedNoteSet);
    EntityNamedNoteTypeDao entityNamedNodeTypeDao = mock(EntityNamedNoteTypeDao.class);
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

    EntityNamedNoteService entityNamedNoteService =
        new EntityNamedNoteService(entityNamedNoteDao, entityNamedNodeTypeDao, changeLogService);
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    ReportGridDao reportGridDao2 = mock(ReportGridDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService =
        new ReportGridMemberService(mock(ReportGridMemberDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 =
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService2, personService, settingsService);

    ReportGridService reportGridService =
        new ReportGridService(
            reportGridDao2,
            applicationDao,
            ratingSchemeService,
            reportGridMemberService,
            userRoleService,
            mock(ChangeInitiativeDao.class));
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao2 = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    ChangeLogService changeLogService3 =
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

    ChangeInitiativeService changeInitiativeService =
        new ChangeInitiativeService(
            changeInitiativeDao, searchDao, relationshipDao, changeLogService3);
    ChangeLogService changeLogService4 =
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

    AppGroupService appGroupService =
        new AppGroupService(
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao2,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService4);

    ReportGridFilterViewService reportGridFilterViewService =
        new ReportGridFilterViewService(
            reportGridDao, reportGridService, entityNamedNoteService, appGroupService);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> reportGridFilterViewService.recalculateAppGroupFromNoteText(1L, "42"));
    verify(entityNamedNoteDao)
        .findByNoteTypeExtIdAndEntityReference(
            eq("WALTZ_REPORT_GRID_FILTER_PRESET"), isA(EntityReference.class));
  }

  /**
   * Test {@link ReportGridFilterViewService#recalculateAppGroupFromNoteText(Long, String)}.
   *
   * <p>Method under test: {@link ReportGridFilterViewService#recalculateAppGroupFromNoteText(Long,
   * String)}
   */
  @Test
  @DisplayName("Test recalculateAppGroupFromNoteText(Long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ReportGridFilterViewService.recalculateAppGroupFromNoteText(Long, String)"
  })
  void testRecalculateAppGroupFromNoteText3() {
    // Arrange
    EntityNamedNoteService entityNamedNoteService = mock(EntityNamedNoteService.class);
    when(entityNamedNoteService.findByNoteTypeExtIdAndEntityReference(
            Mockito.<String>any(), Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    ReportGridDao reportGridDao2 = mock(ReportGridDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService =
        new ReportGridMemberService(mock(ReportGridMemberDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    ReportGridService reportGridService =
        new ReportGridService(
            reportGridDao2,
            applicationDao,
            ratingSchemeService,
            reportGridMemberService,
            userRoleService,
            mock(ChangeInitiativeDao.class));
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao2 = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    ChangeLogService changeLogService2 =
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

    ChangeInitiativeService changeInitiativeService =
        new ChangeInitiativeService(
            changeInitiativeDao, searchDao, relationshipDao, changeLogService2);
    ChangeLogService changeLogService3 =
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

    AppGroupService appGroupService =
        new AppGroupService(
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao2,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService3);

    ReportGridFilterViewService reportGridFilterViewService =
        new ReportGridFilterViewService(
            reportGridDao, reportGridService, entityNamedNoteService, appGroupService);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> reportGridFilterViewService.recalculateAppGroupFromNoteText(1L, "42"));
    verify(entityNamedNoteService)
        .findByNoteTypeExtIdAndEntityReference(
            eq("WALTZ_REPORT_GRID_FILTER_PRESET"), isA(EntityReference.class));
  }

  /**
   * Test {@link ReportGridFilterViewService#recalculateAppGroupFromNoteText(Long, String)}.
   *
   * <p>Method under test: {@link ReportGridFilterViewService#recalculateAppGroupFromNoteText(Long,
   * String)}
   */
  @Test
  @DisplayName("Test recalculateAppGroupFromNoteText(Long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ReportGridFilterViewService.recalculateAppGroupFromNoteText(Long, String)"
  })
  void testRecalculateAppGroupFromNoteText4() {
    // Arrange
    when(entityNamedNoteService.findByNoteTypeExtIdAndEntityReference(
            Mockito.<String>any(), Mockito.<EntityReference>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> reportGridFilterViewService.recalculateAppGroupFromNoteText(1L, "42"));
    verify(entityNamedNoteService)
        .findByNoteTypeExtIdAndEntityReference(
            eq("WALTZ_REPORT_GRID_FILTER_PRESET"), isA(EntityReference.class));
  }

  /**
   * Test {@link ReportGridFilterViewService#recalculateAppGroupFromNoteText(Long, String)}.
   *
   * <p>Method under test: {@link ReportGridFilterViewService#recalculateAppGroupFromNoteText(Long,
   * String)}
   */
  @Test
  @DisplayName("Test recalculateAppGroupFromNoteText(Long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ReportGridFilterViewService.recalculateAppGroupFromNoteText(Long, String)"
  })
  void testRecalculateAppGroupFromNoteText5() {
    // Arrange
    HashSet<EntityNamedNote> entityNamedNoteSet = new HashSet<>();

    Builder builderResult = ImmutableEntityNamedNote.builder();
    entityNamedNoteSet.add(
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .namedNoteTypeId(1L)
            .noteText("Note Text")
            .provenance("Provenance")
            .build());

    Builder builderResult2 = ImmutableEntityNamedNote.builder();
    entityNamedNoteSet.add(
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .namedNoteTypeId(1L)
            .noteText("Note Text")
            .provenance("Provenance")
            .build());
    when(entityNamedNoteService.findByNoteTypeExtIdAndEntityReference(
            Mockito.<String>any(), Mockito.<EntityReference>any()))
        .thenReturn(entityNamedNoteSet);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> reportGridFilterViewService.recalculateAppGroupFromNoteText(1L, "42"));
    verify(entityNamedNoteService)
        .findByNoteTypeExtIdAndEntityReference(
            eq("WALTZ_REPORT_GRID_FILTER_PRESET"), isA(EntityReference.class));
  }

  /**
   * Test {@link ReportGridFilterViewService#generateAppGroupsFromFilter()}.
   *
   * <p>Method under test: {@link ReportGridFilterViewService#generateAppGroupsFromFilter()}
   */
  @Test
  @DisplayName("Test generateAppGroupsFromFilter()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReportGridFilterViewService.generateAppGroupsFromFilter()"})
  void testGenerateAppGroupsFromFilter() {
    // Arrange
    HashSet<ReportGridDefinition> reportGridDefinitionSet = new HashSet<>();
    reportGridDefinitionSet.add(
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build());

    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.findAllDefinitions()).thenReturn(reportGridDefinitionSet);

    EntityNamedNoteDao entityNamedNoteDao = mock(EntityNamedNoteDao.class);
    when(entityNamedNoteDao.findByNoteTypeExtId(Mockito.<String>any())).thenReturn(new HashSet<>());
    EntityNamedNoteTypeDao entityNamedNodeTypeDao = mock(EntityNamedNoteTypeDao.class);
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

    EntityNamedNoteService entityNamedNoteService =
        new EntityNamedNoteService(entityNamedNoteDao, entityNamedNodeTypeDao, changeLogService);

    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.processAdditionsAndRemovals(
            Mockito.<Set<Tuple2<Long, EntityReference>>>any(),
            Mockito.<Set<Tuple2<Long, EntityReference>>>any(),
            Mockito.<String>any()))
        .thenReturn(42);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.fetchEntitiesForGroups(Mockito.<Set<Long>>any()))
        .thenReturn(new HashMap<>());

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    ChangeLogService changeLogService2 =
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
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    ChangeLogService changeLogService3 =
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

    ChangeInitiativeService changeInitiativeService =
        new ChangeInitiativeService(
            changeInitiativeDao, searchDao, relationshipDao, changeLogService3);

    AppGroupService appGroupService =
        new AppGroupService(
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);
    ReportGridDao reportGridDao2 = mock(ReportGridDao.class);
    ApplicationDao applicationDao2 = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService =
        new ReportGridMemberService(mock(ReportGridMemberDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService4 =
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService4, personService, settingsService);

    ReportGridService reportGridService =
        new ReportGridService(
            reportGridDao2,
            applicationDao2,
            ratingSchemeService,
            reportGridMemberService,
            userRoleService,
            mock(ChangeInitiativeDao.class));

    ReportGridFilterViewService reportGridFilterViewService =
        new ReportGridFilterViewService(
            reportGridDao, reportGridService, entityNamedNoteService, appGroupService);

    // Act
    reportGridFilterViewService.generateAppGroupsFromFilter();

    // Assert
    verify(appGroupDao).processAdditionsAndRemovals(isA(Set.class), isA(Set.class), eq("admin"));
    verify(appGroupEntryDao).fetchEntitiesForGroups(isA(Set.class));
    verify(changeLogDao).write(isA(Collection.class));
    verify(entityNamedNoteDao).findByNoteTypeExtId("WALTZ_REPORT_GRID_FILTER_PRESET");
    verify(reportGridDao).findAllDefinitions();
  }

  /**
   * Test {@link ReportGridFilterViewService#generateAppGroupsFromFilter()}.
   *
   * <p>Method under test: {@link ReportGridFilterViewService#generateAppGroupsFromFilter()}
   */
  @Test
  @DisplayName("Test generateAppGroupsFromFilter()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReportGridFilterViewService.generateAppGroupsFromFilter()"})
  void testGenerateAppGroupsFromFilter2() {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.findAllDefinitions()).thenReturn(new HashSet<>());

    HashSet<EntityNamedNote> entityNamedNoteSet = new HashSet<>();

    Builder builderResult = ImmutableEntityNamedNote.builder();
    entityNamedNoteSet.add(
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .namedNoteTypeId(1L)
            .noteText("Note Text")
            .provenance("Provenance")
            .build());

    EntityNamedNoteDao entityNamedNoteDao = mock(EntityNamedNoteDao.class);
    when(entityNamedNoteDao.findByNoteTypeExtId(Mockito.<String>any()))
        .thenReturn(entityNamedNoteSet);
    EntityNamedNoteTypeDao entityNamedNodeTypeDao = mock(EntityNamedNoteTypeDao.class);
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

    EntityNamedNoteService entityNamedNoteService =
        new EntityNamedNoteService(entityNamedNoteDao, entityNamedNodeTypeDao, changeLogService);

    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.processAdditionsAndRemovals(
            Mockito.<Set<Tuple2<Long, EntityReference>>>any(),
            Mockito.<Set<Tuple2<Long, EntityReference>>>any(),
            Mockito.<String>any()))
        .thenReturn(42);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.fetchEntitiesForGroups(Mockito.<Set<Long>>any()))
        .thenReturn(new HashMap<>());

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    ChangeLogService changeLogService2 =
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
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    ChangeLogService changeLogService3 =
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

    ChangeInitiativeService changeInitiativeService =
        new ChangeInitiativeService(
            changeInitiativeDao, searchDao, relationshipDao, changeLogService3);

    AppGroupService appGroupService =
        new AppGroupService(
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);
    ReportGridDao reportGridDao2 = mock(ReportGridDao.class);
    ApplicationDao applicationDao2 = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService =
        new ReportGridMemberService(mock(ReportGridMemberDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService4 =
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService4, personService, settingsService);

    ReportGridService reportGridService =
        new ReportGridService(
            reportGridDao2,
            applicationDao2,
            ratingSchemeService,
            reportGridMemberService,
            userRoleService,
            mock(ChangeInitiativeDao.class));

    ReportGridFilterViewService reportGridFilterViewService =
        new ReportGridFilterViewService(
            reportGridDao, reportGridService, entityNamedNoteService, appGroupService);

    // Act
    reportGridFilterViewService.generateAppGroupsFromFilter();

    // Assert
    verify(appGroupDao).processAdditionsAndRemovals(isA(Set.class), isA(Set.class), eq("admin"));
    verify(appGroupEntryDao).fetchEntitiesForGroups(isA(Set.class));
    verify(changeLogDao).write(isA(Collection.class));
    verify(entityNamedNoteDao).findByNoteTypeExtId("WALTZ_REPORT_GRID_FILTER_PRESET");
    verify(reportGridDao).findAllDefinitions();
  }

  /**
   * Test {@link ReportGridFilterViewService#generateAppGroupsFromFilter()}.
   *
   * <p>Method under test: {@link ReportGridFilterViewService#generateAppGroupsFromFilter()}
   */
  @Test
  @DisplayName("Test generateAppGroupsFromFilter()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReportGridFilterViewService.generateAppGroupsFromFilter()"})
  void testGenerateAppGroupsFromFilter3() {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.findAllDefinitions()).thenReturn(new HashSet<>());

    EntityNamedNoteService entityNamedNoteService = mock(EntityNamedNoteService.class);
    when(entityNamedNoteService.findByNoteTypeExtId(Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    AppGroupService appGroupService = mock(AppGroupService.class);
    doNothing()
        .when(appGroupService)
        .synchGroupEntries(
            Mockito.<Set<Tuple3<EntityKind, Long, Set<EntityReference>>>>any(),
            Mockito.<String>any());
    ReportGridDao reportGridDao2 = mock(ReportGridDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService =
        new ReportGridMemberService(mock(ReportGridMemberDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    ReportGridService reportGridService =
        new ReportGridService(
            reportGridDao2,
            applicationDao,
            ratingSchemeService,
            reportGridMemberService,
            userRoleService,
            mock(ChangeInitiativeDao.class));

    ReportGridFilterViewService reportGridFilterViewService =
        new ReportGridFilterViewService(
            reportGridDao, reportGridService, entityNamedNoteService, appGroupService);

    // Act
    reportGridFilterViewService.generateAppGroupsFromFilter();

    // Assert
    verify(reportGridDao).findAllDefinitions();
    verify(appGroupService).synchGroupEntries(isA(Set.class), eq("admin"));
    verify(entityNamedNoteService).findByNoteTypeExtId("WALTZ_REPORT_GRID_FILTER_PRESET");
  }

  /**
   * Test {@link ReportGridFilterViewService#generateAppGroupsFromFilter()}.
   *
   * <p>Method under test: {@link ReportGridFilterViewService#generateAppGroupsFromFilter()}
   */
  @Test
  @DisplayName("Test generateAppGroupsFromFilter()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReportGridFilterViewService.generateAppGroupsFromFilter()"})
  void testGenerateAppGroupsFromFilter4() {
    // Arrange
    when(reportGridDao.findAllDefinitions()).thenReturn(new HashSet<>());
    when(entityNamedNoteService.findByNoteTypeExtId(Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    doThrow(new IllegalArgumentException())
        .when(appGroupService)
        .synchGroupEntries(
            Mockito.<Set<Tuple3<EntityKind, Long, Set<EntityReference>>>>any(),
            Mockito.<String>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> reportGridFilterViewService.generateAppGroupsFromFilter());
    verify(reportGridDao).findAllDefinitions();
    verify(appGroupService).synchGroupEntries(isA(Set.class), eq("admin"));
    verify(entityNamedNoteService).findByNoteTypeExtId("WALTZ_REPORT_GRID_FILTER_PRESET");
  }

  /**
   * Test {@link ReportGridFilterViewService#generateAppGroupsFromFilter()}.
   *
   * <p>Method under test: {@link ReportGridFilterViewService#generateAppGroupsFromFilter()}
   */
  @Test
  @DisplayName("Test generateAppGroupsFromFilter()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReportGridFilterViewService.generateAppGroupsFromFilter()"})
  void testGenerateAppGroupsFromFilter5() {
    // Arrange
    HashSet<ReportGridDefinition> reportGridDefinitionSet = new HashSet<>();
    reportGridDefinitionSet.add(
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build());
    reportGridDefinitionSet.add(
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("External Id")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build());
    when(reportGridDao.findAllDefinitions()).thenReturn(reportGridDefinitionSet);
    when(entityNamedNoteService.findByNoteTypeExtId(Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    doNothing()
        .when(appGroupService)
        .synchGroupEntries(
            Mockito.<Set<Tuple3<EntityKind, Long, Set<EntityReference>>>>any(),
            Mockito.<String>any());

    // Act
    reportGridFilterViewService.generateAppGroupsFromFilter();

    // Assert
    verify(reportGridDao).findAllDefinitions();
    verify(appGroupService).synchGroupEntries(isA(Set.class), eq("admin"));
    verify(entityNamedNoteService).findByNoteTypeExtId("WALTZ_REPORT_GRID_FILTER_PRESET");
  }

  /**
   * Test {@link ReportGridFilterViewService#generateAppGroupsFromFilter()}.
   *
   * <p>Method under test: {@link ReportGridFilterViewService#generateAppGroupsFromFilter()}
   */
  @Test
  @DisplayName("Test generateAppGroupsFromFilter()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReportGridFilterViewService.generateAppGroupsFromFilter()"})
  void testGenerateAppGroupsFromFilter6() {
    // Arrange
    when(reportGridDao.findAllDefinitions()).thenReturn(new HashSet<>());

    HashSet<EntityNamedNote> entityNamedNoteSet = new HashSet<>();

    Builder builderResult = ImmutableEntityNamedNote.builder();
    entityNamedNoteSet.add(
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .namedNoteTypeId(1L)
            .noteText("Note Text")
            .provenance("Provenance")
            .build());

    Builder builderResult2 = ImmutableEntityNamedNote.builder();
    entityNamedNoteSet.add(
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .namedNoteTypeId(1L)
            .noteText("Note Text")
            .provenance("Provenance")
            .build());
    when(entityNamedNoteService.findByNoteTypeExtId(Mockito.<String>any()))
        .thenReturn(entityNamedNoteSet);
    doNothing()
        .when(appGroupService)
        .synchGroupEntries(
            Mockito.<Set<Tuple3<EntityKind, Long, Set<EntityReference>>>>any(),
            Mockito.<String>any());

    // Act
    reportGridFilterViewService.generateAppGroupsFromFilter();

    // Assert
    verify(reportGridDao).findAllDefinitions();
    verify(appGroupService).synchGroupEntries(isA(Set.class), eq("admin"));
    verify(entityNamedNoteService).findByNoteTypeExtId("WALTZ_REPORT_GRID_FILTER_PRESET");
  }

  /**
   * Test {@link ReportGridFilterViewService#generateAppGroupsFromFilter()}.
   *
   * <ul>
   *   <li>Given {@link ReportGridDao}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridFilterViewService#generateAppGroupsFromFilter()}
   */
  @Test
  @DisplayName("Test generateAppGroupsFromFilter(); given ReportGridDao")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReportGridFilterViewService.generateAppGroupsFromFilter()"})
  void testGenerateAppGroupsFromFilter_givenReportGridDao() {
    // Arrange
    when(entityNamedNoteService.findByNoteTypeExtId(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> reportGridFilterViewService.generateAppGroupsFromFilter());
    verify(entityNamedNoteService).findByNoteTypeExtId("WALTZ_REPORT_GRID_FILTER_PRESET");
  }

  /**
   * Test {@link ReportGridFilterViewService#generateAppGroupsFromFilter()}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogDao#write(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridFilterViewService#generateAppGroupsFromFilter()}
   */
  @Test
  @DisplayName("Test generateAppGroupsFromFilter(); then calls write(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReportGridFilterViewService.generateAppGroupsFromFilter()"})
  void testGenerateAppGroupsFromFilter_thenCallsWrite() {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.findAllDefinitions()).thenReturn(new HashSet<>());

    EntityNamedNoteDao entityNamedNoteDao = mock(EntityNamedNoteDao.class);
    when(entityNamedNoteDao.findByNoteTypeExtId(Mockito.<String>any())).thenReturn(new HashSet<>());
    EntityNamedNoteTypeDao entityNamedNodeTypeDao = mock(EntityNamedNoteTypeDao.class);
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

    EntityNamedNoteService entityNamedNoteService =
        new EntityNamedNoteService(entityNamedNoteDao, entityNamedNodeTypeDao, changeLogService);

    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.processAdditionsAndRemovals(
            Mockito.<Set<Tuple2<Long, EntityReference>>>any(),
            Mockito.<Set<Tuple2<Long, EntityReference>>>any(),
            Mockito.<String>any()))
        .thenReturn(42);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.fetchEntitiesForGroups(Mockito.<Set<Long>>any()))
        .thenReturn(new HashMap<>());

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    ChangeLogService changeLogService2 =
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
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    ChangeLogService changeLogService3 =
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

    ChangeInitiativeService changeInitiativeService =
        new ChangeInitiativeService(
            changeInitiativeDao, searchDao, relationshipDao, changeLogService3);

    AppGroupService appGroupService =
        new AppGroupService(
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);
    ReportGridDao reportGridDao2 = mock(ReportGridDao.class);
    ApplicationDao applicationDao2 = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService =
        new ReportGridMemberService(mock(ReportGridMemberDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService4 =
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService4, personService, settingsService);

    ReportGridService reportGridService =
        new ReportGridService(
            reportGridDao2,
            applicationDao2,
            ratingSchemeService,
            reportGridMemberService,
            userRoleService,
            mock(ChangeInitiativeDao.class));

    ReportGridFilterViewService reportGridFilterViewService =
        new ReportGridFilterViewService(
            reportGridDao, reportGridService, entityNamedNoteService, appGroupService);

    // Act
    reportGridFilterViewService.generateAppGroupsFromFilter();

    // Assert
    verify(appGroupDao).processAdditionsAndRemovals(isA(Set.class), isA(Set.class), eq("admin"));
    verify(appGroupEntryDao).fetchEntitiesForGroups(isA(Set.class));
    verify(changeLogDao).write(isA(Collection.class));
    verify(entityNamedNoteDao).findByNoteTypeExtId("WALTZ_REPORT_GRID_FILTER_PRESET");
    verify(reportGridDao).findAllDefinitions();
  }

  /**
   * Test {@link ReportGridFilterViewService#generateAppGroupsFromFilter()}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogService#write(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridFilterViewService#generateAppGroupsFromFilter()}
   */
  @Test
  @DisplayName("Test generateAppGroupsFromFilter(); then calls write(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReportGridFilterViewService.generateAppGroupsFromFilter()"})
  void testGenerateAppGroupsFromFilter_thenCallsWrite2() {
    // Arrange
    ReportGridDao reportGridDao = mock(ReportGridDao.class);
    when(reportGridDao.findAllDefinitions()).thenReturn(new HashSet<>());

    EntityNamedNoteService entityNamedNoteService = mock(EntityNamedNoteService.class);
    when(entityNamedNoteService.findByNoteTypeExtId(Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.processAdditionsAndRemovals(
            Mockito.<Set<Tuple2<Long, EntityReference>>>any(),
            Mockito.<Set<Tuple2<Long, EntityReference>>>any(),
            Mockito.<String>any()))
        .thenReturn(42);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.fetchEntitiesForGroups(Mockito.<Set<Long>>any()))
        .thenReturn(new HashMap<>());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    ChangeLogService changeLogService2 =
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

    ChangeInitiativeService changeInitiativeService =
        new ChangeInitiativeService(
            changeInitiativeDao, searchDao, relationshipDao, changeLogService2);

    AppGroupService appGroupService =
        new AppGroupService(
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService);
    ReportGridDao reportGridDao2 = mock(ReportGridDao.class);
    ApplicationDao applicationDao2 = mock(ApplicationDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    ReportGridMemberService reportGridMemberService =
        new ReportGridMemberService(mock(ReportGridMemberDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService3 =
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService3, personService, settingsService);

    ReportGridService reportGridService =
        new ReportGridService(
            reportGridDao2,
            applicationDao2,
            ratingSchemeService,
            reportGridMemberService,
            userRoleService,
            mock(ChangeInitiativeDao.class));

    ReportGridFilterViewService reportGridFilterViewService =
        new ReportGridFilterViewService(
            reportGridDao, reportGridService, entityNamedNoteService, appGroupService);

    // Act
    reportGridFilterViewService.generateAppGroupsFromFilter();

    // Assert
    verify(appGroupDao).processAdditionsAndRemovals(isA(Set.class), isA(Set.class), eq("admin"));
    verify(appGroupEntryDao).fetchEntitiesForGroups(isA(Set.class));
    verify(reportGridDao).findAllDefinitions();
    verify(changeLogService).write(isA(Collection.class));
    verify(entityNamedNoteService).findByNoteTypeExtId("WALTZ_REPORT_GRID_FILTER_PRESET");
  }
}
