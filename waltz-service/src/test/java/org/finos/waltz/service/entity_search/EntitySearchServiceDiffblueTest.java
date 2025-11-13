package org.finos.waltz.service.entity_search;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.DBExecutorPoolInterface;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.actor.ActorDao;
import org.finos.waltz.data.actor.ActorSearchDao;
import org.finos.waltz.data.app_group.AppGroupDao;
import org.finos.waltz.data.app_group.AppGroupEntryDao;
import org.finos.waltz.data.app_group.AppGroupMemberDao;
import org.finos.waltz.data.app_group.AppGroupOrganisationalUnitDao;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.application.search.ApplicationSearchDao;
import org.finos.waltz.data.change_initiative.ChangeInitiativeDao;
import org.finos.waltz.data.change_initiative.search.ChangeInitiativeSearchDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.data_type.DataTypeDao;
import org.finos.waltz.data.data_type.search.DataTypeSearchDao;
import org.finos.waltz.data.database_information.DatabaseInformationDao;
import org.finos.waltz.data.end_user_app.EndUserAppDao;
import org.finos.waltz.data.end_user_app.search.EndUserAppSearchDao;
import org.finos.waltz.data.entity_alias.EntityAliasDao;
import org.finos.waltz.data.entity_relationship.EntityRelationshipDao;
import org.finos.waltz.data.flow_diagram.FlowDiagramAnnotationDao;
import org.finos.waltz.data.flow_diagram.FlowDiagramDao;
import org.finos.waltz.data.flow_diagram.FlowDiagramEntityDao;
import org.finos.waltz.data.flow_diagram.FlowDiagramOverlayGroupDao;
import org.finos.waltz.data.involvement.InvolvementDao;
import org.finos.waltz.data.legal_entity.LegalEntityDao;
import org.finos.waltz.data.legal_entity.search.LegalEntitySearchDao;
import org.finos.waltz.data.licence.LicenceDao;
import org.finos.waltz.data.licence.search.LicenceSearchDao;
import org.finos.waltz.data.logical_data_element.LogicalDataElementDao;
import org.finos.waltz.data.logical_data_element.search.LogicalDataElementSearchDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable.MeasurableDao;
import org.finos.waltz.data.measurable.search.MeasurableSearchDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.orgunit.OrganisationalUnitDao;
import org.finos.waltz.data.orgunit.search.OrganisationalUnitSearchDao;
import org.finos.waltz.data.person.PersonDao;
import org.finos.waltz.data.person.search.PersonSearchDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.physical_specification.search.PhysicalSpecificationSearchDao;
import org.finos.waltz.data.roadmap.RoadmapDao;
import org.finos.waltz.data.roadmap.RoadmapSearchDao;
import org.finos.waltz.data.scenario.ScenarioDao;
import org.finos.waltz.data.server_information.ServerInformationDao;
import org.finos.waltz.data.server_information.search.ServerInformationSearchDao;
import org.finos.waltz.data.software_catalog.SoftwarePackageDao;
import org.finos.waltz.data.software_catalog.SoftwareUsageDao;
import org.finos.waltz.data.software_catalog.SoftwareVersionDao;
import org.finos.waltz.data.tag.TagDao;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.entity_search.ImmutableEntitySearchOptions;
import org.finos.waltz.model.entity_search.ImmutableEntitySearchOptions.Builder;
import org.finos.waltz.service.actor.ActorService;
import org.finos.waltz.service.app_group.AppGroupService;
import org.finos.waltz.service.application.ApplicationService;
import org.finos.waltz.service.change_initiative.ChangeInitiativeService;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.data_type.DataTypeService;
import org.finos.waltz.service.database_information.DatabaseInformationService;
import org.finos.waltz.service.end_user_app.EndUserAppService;
import org.finos.waltz.service.flow_diagram.FlowDiagramOverlayGroupService;
import org.finos.waltz.service.flow_diagram.FlowDiagramService;
import org.finos.waltz.service.legal_entity.LegalEntityService;
import org.finos.waltz.service.licence.LicenceService;
import org.finos.waltz.service.logical_data_element.LogicalDataElementService;
import org.finos.waltz.service.measurable.MeasurableService;
import org.finos.waltz.service.orgunit.OrganisationalUnitService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.physical_specification.PhysicalSpecificationService;
import org.finos.waltz.service.roadmap.RoadmapService;
import org.finos.waltz.service.server_information.ServerInformationService;
import org.finos.waltz.service.software_catalog.SoftwareCatalogService;
import org.finos.waltz.service.tag.TagService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntitySearchServiceDiffblueTest {
  /**
   * Test {@link EntitySearchService#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link EntitySearchService#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntitySearchService.search(EntitySearchOptions)"})
  void testSearch() {
    // Arrange
    DBExecutorPoolInterface dbExecutorPool = mock(DBExecutorPoolInterface.class);
    ActorService actorService = new ActorService(mock(ActorDao.class), mock(ActorSearchDao.class));
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
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

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
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
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService3);
    ChangeInitiativeDao changeInitiativeDao2 = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao2 = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao2 = mock(EntityRelationshipDao.class);
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

    ChangeInitiativeService changeInitiativeService2 =
        new ChangeInitiativeService(
            changeInitiativeDao2, searchDao2, relationshipDao2, changeLogService4);
    LogicalDataElementService logicalDataElementService =
        new LogicalDataElementService(
            mock(LogicalDataElementDao.class), mock(LogicalDataElementSearchDao.class));
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    EndUserAppService endUserAppService =
        new EndUserAppService(
            mock(EndUserAppDao.class),
            mock(ApplicationDao.class),
            mock(ChangeLogDao.class),
            mock(InvolvementDao.class),
            mock(EndUserAppSearchDao.class));
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService5 =
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService5);
    OrganisationalUnitService organisationalUnitService =
        new OrganisationalUnitService(
            mock(OrganisationalUnitDao.class), mock(OrganisationalUnitSearchDao.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    ChangeLogService changeLogService6 =
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
            changeLogService6,
            mock(PhysicalSpecificationDao.class),
            mock(PhysicalSpecificationSearchDao.class));
    RoadmapDao roadmapDao = mock(RoadmapDao.class);
    RoadmapSearchDao roadmapSearchDao = mock(RoadmapSearchDao.class);
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    ChangeLogService changeLogService7 =
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

    RoadmapService roadmapService =
        new RoadmapService(
            roadmapDao,
            roadmapSearchDao,
            scenarioDao,
            changeLogService7,
            mock(EntityRelationshipDao.class));
    ServerInformationService serverInformationService =
        new ServerInformationService(
            mock(ServerInformationDao.class), mock(ServerInformationSearchDao.class));
    SoftwareCatalogService softwareCatalogService =
        new SoftwareCatalogService(
            mock(SoftwarePackageDao.class),
            mock(SoftwareUsageDao.class),
            mock(SoftwareVersionDao.class));
    ChangeLogService changeLogService8 =
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
    DataTypeService dataTypeService2 =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService8,
            dataTypeService2,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));
    LegalEntityService legalEntityService =
        new LegalEntityService(mock(LegalEntityDao.class), mock(LegalEntitySearchDao.class));
    DatabaseInformationService databaseInformationService =
        new DatabaseInformationService(mock(DatabaseInformationDao.class));
    LicenceService licenceService =
        new LicenceService(mock(LicenceDao.class), mock(LicenceSearchDao.class));

    EntitySearchService entitySearchService =
        new EntitySearchService(
            dbExecutorPool,
            actorService,
            applicationService,
            appGroupService,
            changeInitiativeService2,
            logicalDataElementService,
            dataTypeService,
            endUserAppService,
            measurableService,
            organisationalUnitService,
            personService,
            physicalSpecificationService,
            roadmapService,
            serverInformationService,
            softwareCatalogService,
            flowDiagramService,
            legalEntityService,
            databaseInformationService,
            licenceService);

    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    List<EntityReference> actualSearchResult =
        entitySearchService.search(
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("Search Query")
                .userId("42")
                .build());

    // Assert
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link EntitySearchService#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link EntitySearchOptions} {@link EntitySearchOptions#entityKinds()} return {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link EntitySearchService#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName(
      "Test search(EntitySearchOptions); given ArrayList(); when EntitySearchOptions entityKinds() return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntitySearchService.search(EntitySearchOptions)"})
  void testSearch_givenArrayList_whenEntitySearchOptionsEntityKindsReturnArrayList() {
    // Arrange
    DBExecutorPoolInterface dbExecutorPool = mock(DBExecutorPoolInterface.class);
    ActorService actorService = new ActorService(mock(ActorDao.class), mock(ActorSearchDao.class));
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
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

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
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
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService3);
    ChangeInitiativeDao changeInitiativeDao2 = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao2 = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao2 = mock(EntityRelationshipDao.class);
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

    ChangeInitiativeService changeInitiativeService2 =
        new ChangeInitiativeService(
            changeInitiativeDao2, searchDao2, relationshipDao2, changeLogService4);
    LogicalDataElementService logicalDataElementService =
        new LogicalDataElementService(
            mock(LogicalDataElementDao.class), mock(LogicalDataElementSearchDao.class));
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    EndUserAppService endUserAppService =
        new EndUserAppService(
            mock(EndUserAppDao.class),
            mock(ApplicationDao.class),
            mock(ChangeLogDao.class),
            mock(InvolvementDao.class),
            mock(EndUserAppSearchDao.class));
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService5 =
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService5);
    OrganisationalUnitService organisationalUnitService =
        new OrganisationalUnitService(
            mock(OrganisationalUnitDao.class), mock(OrganisationalUnitSearchDao.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    ChangeLogService changeLogService6 =
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
            changeLogService6,
            mock(PhysicalSpecificationDao.class),
            mock(PhysicalSpecificationSearchDao.class));
    RoadmapDao roadmapDao = mock(RoadmapDao.class);
    RoadmapSearchDao roadmapSearchDao = mock(RoadmapSearchDao.class);
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    ChangeLogService changeLogService7 =
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

    RoadmapService roadmapService =
        new RoadmapService(
            roadmapDao,
            roadmapSearchDao,
            scenarioDao,
            changeLogService7,
            mock(EntityRelationshipDao.class));
    ServerInformationService serverInformationService =
        new ServerInformationService(
            mock(ServerInformationDao.class), mock(ServerInformationSearchDao.class));
    SoftwareCatalogService softwareCatalogService =
        new SoftwareCatalogService(
            mock(SoftwarePackageDao.class),
            mock(SoftwareUsageDao.class),
            mock(SoftwareVersionDao.class));
    ChangeLogService changeLogService8 =
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
    DataTypeService dataTypeService2 =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService8,
            dataTypeService2,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));
    LegalEntityService legalEntityService =
        new LegalEntityService(mock(LegalEntityDao.class), mock(LegalEntitySearchDao.class));
    DatabaseInformationService databaseInformationService =
        new DatabaseInformationService(mock(DatabaseInformationDao.class));
    LicenceService licenceService =
        new LicenceService(mock(LicenceDao.class), mock(LicenceSearchDao.class));

    EntitySearchService entitySearchService =
        new EntitySearchService(
            dbExecutorPool,
            actorService,
            applicationService,
            appGroupService,
            changeInitiativeService2,
            logicalDataElementService,
            dataTypeService,
            endUserAppService,
            measurableService,
            organisationalUnitService,
            personService,
            physicalSpecificationService,
            roadmapService,
            serverInformationService,
            softwareCatalogService,
            flowDiagramService,
            legalEntityService,
            databaseInformationService,
            licenceService);

    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.entityKinds()).thenReturn(new ArrayList<>());
    when(options.searchQuery()).thenReturn("Search Query");

    // Act
    List<EntityReference> actualSearchResult = entitySearchService.search(options);

    // Assert
    verify(options).entityKinds();
    verify(options, atLeast(1)).searchQuery();
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link EntitySearchService#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link EntitySearchOptions} {@link EntitySearchOptions#searchQuery()} return empty
   *       string.
   * </ul>
   *
   * <p>Method under test: {@link EntitySearchService#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName(
      "Test search(EntitySearchOptions); given empty string; when EntitySearchOptions searchQuery() return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntitySearchService.search(EntitySearchOptions)"})
  void testSearch_givenEmptyString_whenEntitySearchOptionsSearchQueryReturnEmptyString() {
    // Arrange
    DBExecutorPoolInterface dbExecutorPool = mock(DBExecutorPoolInterface.class);
    ActorService actorService = new ActorService(mock(ActorDao.class), mock(ActorSearchDao.class));
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
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

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
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
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService3);
    ChangeInitiativeDao changeInitiativeDao2 = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao2 = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao2 = mock(EntityRelationshipDao.class);
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

    ChangeInitiativeService changeInitiativeService2 =
        new ChangeInitiativeService(
            changeInitiativeDao2, searchDao2, relationshipDao2, changeLogService4);
    LogicalDataElementService logicalDataElementService =
        new LogicalDataElementService(
            mock(LogicalDataElementDao.class), mock(LogicalDataElementSearchDao.class));
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    EndUserAppService endUserAppService =
        new EndUserAppService(
            mock(EndUserAppDao.class),
            mock(ApplicationDao.class),
            mock(ChangeLogDao.class),
            mock(InvolvementDao.class),
            mock(EndUserAppSearchDao.class));
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService5 =
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService5);
    OrganisationalUnitService organisationalUnitService =
        new OrganisationalUnitService(
            mock(OrganisationalUnitDao.class), mock(OrganisationalUnitSearchDao.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    ChangeLogService changeLogService6 =
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
            changeLogService6,
            mock(PhysicalSpecificationDao.class),
            mock(PhysicalSpecificationSearchDao.class));
    RoadmapDao roadmapDao = mock(RoadmapDao.class);
    RoadmapSearchDao roadmapSearchDao = mock(RoadmapSearchDao.class);
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    ChangeLogService changeLogService7 =
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

    RoadmapService roadmapService =
        new RoadmapService(
            roadmapDao,
            roadmapSearchDao,
            scenarioDao,
            changeLogService7,
            mock(EntityRelationshipDao.class));
    ServerInformationService serverInformationService =
        new ServerInformationService(
            mock(ServerInformationDao.class), mock(ServerInformationSearchDao.class));
    SoftwareCatalogService softwareCatalogService =
        new SoftwareCatalogService(
            mock(SoftwarePackageDao.class),
            mock(SoftwareUsageDao.class),
            mock(SoftwareVersionDao.class));
    ChangeLogService changeLogService8 =
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
    DataTypeService dataTypeService2 =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService8,
            dataTypeService2,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));
    LegalEntityService legalEntityService =
        new LegalEntityService(mock(LegalEntityDao.class), mock(LegalEntitySearchDao.class));
    DatabaseInformationService databaseInformationService =
        new DatabaseInformationService(mock(DatabaseInformationDao.class));
    LicenceService licenceService =
        new LicenceService(mock(LicenceDao.class), mock(LicenceSearchDao.class));

    EntitySearchService entitySearchService =
        new EntitySearchService(
            dbExecutorPool,
            actorService,
            applicationService,
            appGroupService,
            changeInitiativeService2,
            logicalDataElementService,
            dataTypeService,
            endUserAppService,
            measurableService,
            organisationalUnitService,
            personService,
            physicalSpecificationService,
            roadmapService,
            serverInformationService,
            softwareCatalogService,
            flowDiagramService,
            legalEntityService,
            databaseInformationService,
            licenceService);

    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.searchQuery()).thenReturn("");

    // Act
    List<EntityReference> actualSearchResult = entitySearchService.search(options);

    // Assert
    verify(options).searchQuery();
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link EntitySearchService#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link EntitySearchService#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntitySearchService.search(EntitySearchOptions)"})
  void testSearch_thenThrowUnsupportedOperationException() {
    // Arrange
    DBExecutorPoolInterface dbExecutorPool = mock(DBExecutorPoolInterface.class);
    ActorService actorService = new ActorService(mock(ActorDao.class), mock(ActorSearchDao.class));
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
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

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
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
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService3);
    ChangeInitiativeDao changeInitiativeDao2 = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao2 = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao2 = mock(EntityRelationshipDao.class);
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

    ChangeInitiativeService changeInitiativeService2 =
        new ChangeInitiativeService(
            changeInitiativeDao2, searchDao2, relationshipDao2, changeLogService4);
    LogicalDataElementService logicalDataElementService =
        new LogicalDataElementService(
            mock(LogicalDataElementDao.class), mock(LogicalDataElementSearchDao.class));
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    EndUserAppService endUserAppService =
        new EndUserAppService(
            mock(EndUserAppDao.class),
            mock(ApplicationDao.class),
            mock(ChangeLogDao.class),
            mock(InvolvementDao.class),
            mock(EndUserAppSearchDao.class));
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService5 =
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService5);
    OrganisationalUnitService organisationalUnitService =
        new OrganisationalUnitService(
            mock(OrganisationalUnitDao.class), mock(OrganisationalUnitSearchDao.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    ChangeLogService changeLogService6 =
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
            changeLogService6,
            mock(PhysicalSpecificationDao.class),
            mock(PhysicalSpecificationSearchDao.class));
    RoadmapDao roadmapDao = mock(RoadmapDao.class);
    RoadmapSearchDao roadmapSearchDao = mock(RoadmapSearchDao.class);
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    ChangeLogService changeLogService7 =
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

    RoadmapService roadmapService =
        new RoadmapService(
            roadmapDao,
            roadmapSearchDao,
            scenarioDao,
            changeLogService7,
            mock(EntityRelationshipDao.class));
    ServerInformationService serverInformationService =
        new ServerInformationService(
            mock(ServerInformationDao.class), mock(ServerInformationSearchDao.class));
    SoftwareCatalogService softwareCatalogService =
        new SoftwareCatalogService(
            mock(SoftwarePackageDao.class),
            mock(SoftwareUsageDao.class),
            mock(SoftwareVersionDao.class));
    ChangeLogService changeLogService8 =
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
    DataTypeService dataTypeService2 =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService8,
            dataTypeService2,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));
    LegalEntityService legalEntityService =
        new LegalEntityService(mock(LegalEntityDao.class), mock(LegalEntitySearchDao.class));
    DatabaseInformationService databaseInformationService =
        new DatabaseInformationService(mock(DatabaseInformationDao.class));
    LicenceService licenceService =
        new LicenceService(mock(LicenceDao.class), mock(LicenceSearchDao.class));

    EntitySearchService entitySearchService =
        new EntitySearchService(
            dbExecutorPool,
            actorService,
            applicationService,
            appGroupService,
            changeInitiativeService2,
            logicalDataElementService,
            dataTypeService,
            endUserAppService,
            measurableService,
            organisationalUnitService,
            personService,
            physicalSpecificationService,
            roadmapService,
            serverInformationService,
            softwareCatalogService,
            flowDiagramService,
            legalEntityService,
            databaseInformationService,
            licenceService);

    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.entityKinds()).thenThrow(new UnsupportedOperationException());
    when(options.searchQuery()).thenReturn("Search Query");

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> entitySearchService.search(options));
    verify(options).entityKinds();
    verify(options, atLeast(1)).searchQuery();
  }
}
