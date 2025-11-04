package org.finos.waltz.service.app_group;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.common.exception.InsufficientPrivelegeException;
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
import org.finos.waltz.data.entity_relationship.EntityRelationshipDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.orgunit.OrganisationalUnitDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.model.app_group.AppGroup;
import org.finos.waltz.model.app_group.AppGroupEntry;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.service.change_initiative.ChangeInitiativeService;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.jooq.DSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FavouritesServiceDiffblueTest {
  /**
   * Method under test: {@link FavouritesService#getFavouritesGroup(String)}
   */
  @Test
  void testGetFavouritesGroup() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getFavouritesGroupForOwner(Mockito.<String>any())).thenReturn(mock(AppGroup.class));
    AppGroupDao appGroupDao2 = mock(AppGroupDao.class);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
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

    AppGroupService appGroupService = new AppGroupService(appGroupDao2, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        changeInitiativeService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    AppGroupMemberDao appGroupMemberDao2 = mock(AppGroupMemberDao.class);
    AppGroupEntryDao appGroupEntryDao2 = mock(AppGroupEntryDao.class);

    // Act
    (new FavouritesService(appGroupService, appGroupMemberDao2, appGroupEntryDao2, appGroupDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .getFavouritesGroup("janedoe");

    // Assert
    verify(appGroupDao).getFavouritesGroupForOwner(eq("janedoe"));
  }

  /**
   * Method under test:
   * {@link FavouritesService#findFavouriteGroupEntries(String)}
   */
  @Test
  void testFindFavouriteGroupEntries() {
    // Arrange
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(appGroupEntryList);
    AppGroup appGroup = mock(AppGroup.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(appGroup.id()).thenReturn(ofResult);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getFavouritesGroupForOwner(Mockito.<String>any())).thenReturn(appGroup);
    AppGroupDao appGroupDao2 = mock(AppGroupDao.class);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    AppGroupEntryDao appGroupEntryDao2 = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
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

    AppGroupService appGroupService = new AppGroupService(appGroupDao2, appGroupMemberDao, appGroupEntryDao2,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        changeInitiativeService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    AppGroupMemberDao appGroupMemberDao2 = mock(AppGroupMemberDao.class);

    // Act
    Collection<AppGroupEntry> actualFindFavouriteGroupEntriesResult = (new FavouritesService(appGroupService,
        appGroupMemberDao2, appGroupEntryDao, appGroupDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findFavouriteGroupEntries("janedoe");

    // Assert
    verify(appGroupDao).getFavouritesGroupForOwner(eq("janedoe"));
    verify(appGroupEntryDao).findEntriesForGroup(eq(1L));
    verify(appGroup).id();
    assertTrue(actualFindFavouriteGroupEntriesResult instanceof List);
    assertTrue(actualFindFavouriteGroupEntriesResult.isEmpty());
    assertSame(appGroupEntryList, actualFindFavouriteGroupEntriesResult);
  }

  /**
   * Method under test: {@link FavouritesService#addApplication(String, long)}
   */
  @Test
  void testAddApplication() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(appGroupEntryList);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.getById(anyLong())).thenReturn(null);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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

    AppGroupService appGroupService = new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        changeInitiativeService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    AppGroup appGroup = mock(AppGroup.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(appGroup.id()).thenReturn(ofResult);
    AppGroupDao appGroupDao2 = mock(AppGroupDao.class);
    when(appGroupDao2.getFavouritesGroupForOwner(Mockito.<String>any())).thenReturn(appGroup);
    AppGroupMemberDao appGroupMemberDao2 = mock(AppGroupMemberDao.class);
    AppGroupEntryDao appGroupEntryDao2 = mock(AppGroupEntryDao.class);

    // Act
    Collection<AppGroupEntry> actualAddApplicationResult = (new FavouritesService(appGroupService, appGroupMemberDao2,
        appGroupEntryDao2, appGroupDao2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .addApplication("janedoe", 1L);

    // Assert
    verify(appGroupDao2).getFavouritesGroupForOwner(eq("janedoe"));
    verify(appGroupEntryDao).findEntriesForGroup(eq(1L));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("janedoe"));
    verify(applicationDao).getById(eq(1L));
    verify(appGroup).id();
    assertTrue(actualAddApplicationResult instanceof List);
    assertTrue(actualAddApplicationResult.isEmpty());
    assertSame(appGroupEntryList, actualAddApplicationResult);
  }

  /**
   * Method under test: {@link FavouritesService#addApplication(String, long)}
   */
  @Test
  void testAddApplication2() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.addApplication(anyLong(), anyLong())).thenReturn(2);
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(appGroupEntryList);
    Application application = mock(Application.class);
    when(application.name()).thenReturn("Name");
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.getById(anyLong())).thenReturn(application);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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

    AppGroup appGroup = mock(AppGroup.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(appGroup.id()).thenReturn(ofResult);
    AppGroupDao appGroupDao2 = mock(AppGroupDao.class);
    when(appGroupDao2.getFavouritesGroupForOwner(Mockito.<String>any())).thenReturn(appGroup);
    AppGroupMemberDao appGroupMemberDao2 = mock(AppGroupMemberDao.class);
    AppGroupEntryDao appGroupEntryDao2 = mock(AppGroupEntryDao.class);

    // Act
    Collection<AppGroupEntry> actualAddApplicationResult = (new FavouritesService(appGroupService, appGroupMemberDao2,
        appGroupEntryDao2, appGroupDao2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .addApplication("janedoe", 1L);

    // Assert
    verify(appGroupDao2).getFavouritesGroupForOwner(eq("janedoe"));
    verify(appGroupEntryDao).addApplication(eq(1L), eq(1L));
    verify(appGroupEntryDao).findEntriesForGroup(eq(1L));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("janedoe"));
    verify(applicationDao).getById(eq(1L));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(appGroup).id();
    verify(application).name();
    assertTrue(actualAddApplicationResult instanceof List);
    assertTrue(actualAddApplicationResult.isEmpty());
    assertSame(appGroupEntryList, actualAddApplicationResult);
  }

  /**
   * Method under test: {@link FavouritesService#addApplication(String, long)}
   */
  @Test
  void testAddApplication3() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.addApplication(anyLong(), anyLong())).thenReturn(2);
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(appGroupEntryList);
    Application application = mock(Application.class);
    when(application.name()).thenReturn("Name");
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.getById(anyLong())).thenReturn(application);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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

    AppGroup appGroup = mock(AppGroup.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(appGroup.id()).thenReturn(ofResult);
    AppGroupDao appGroupDao2 = mock(AppGroupDao.class);
    when(appGroupDao2.getFavouritesGroupForOwner(Mockito.<String>any())).thenReturn(appGroup);
    AppGroupMemberDao appGroupMemberDao2 = mock(AppGroupMemberDao.class);
    AppGroupEntryDao appGroupEntryDao2 = mock(AppGroupEntryDao.class);

    // Act
    Collection<AppGroupEntry> actualAddApplicationResult = (new FavouritesService(appGroupService, appGroupMemberDao2,
        appGroupEntryDao2, appGroupDao2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .addApplication("janedoe", 1L);

    // Assert
    verify(appGroupDao2).getFavouritesGroupForOwner(eq("janedoe"));
    verify(appGroupEntryDao).addApplication(eq(1L), eq(1L));
    verify(appGroupEntryDao).findEntriesForGroup(eq(1L));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("janedoe"));
    verify(applicationDao).getById(eq(1L));
    verify(appGroup).id();
    verify(application).name();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualAddApplicationResult instanceof List);
    assertTrue(actualAddApplicationResult.isEmpty());
    assertSame(appGroupEntryList, actualAddApplicationResult);
  }

  /**
   * Method under test: {@link FavouritesService#addApplication(String, long)}
   */
  @Test
  void testAddApplication4() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupService appGroupService = mock(AppGroupService.class);
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(appGroupService.addApplication(Mockito.<String>any(), anyLong(), anyLong())).thenReturn(appGroupEntryList);
    AppGroup appGroup = mock(AppGroup.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(appGroup.id()).thenReturn(ofResult);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getFavouritesGroupForOwner(Mockito.<String>any())).thenReturn(appGroup);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);

    // Act
    Collection<AppGroupEntry> actualAddApplicationResult = (new FavouritesService(appGroupService, appGroupMemberDao,
        appGroupEntryDao, appGroupDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .addApplication("janedoe", 1L);

    // Assert
    verify(appGroupDao).getFavouritesGroupForOwner(eq("janedoe"));
    verify(appGroup).id();
    verify(appGroupService).addApplication(eq("janedoe"), eq(1L), eq(1L));
    assertTrue(actualAddApplicationResult instanceof List);
    assertTrue(actualAddApplicationResult.isEmpty());
    assertSame(appGroupEntryList, actualAddApplicationResult);
  }

  /**
   * Method under test: {@link FavouritesService#removeApplication(String, long)}
   */
  @Test
  void testRemoveApplication() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.removeApplication(anyLong(), anyLong())).thenReturn(1);
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(appGroupEntryList);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.getById(anyLong())).thenReturn(null);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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

    AppGroup appGroup = mock(AppGroup.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(appGroup.id()).thenReturn(ofResult);
    AppGroupDao appGroupDao2 = mock(AppGroupDao.class);
    when(appGroupDao2.getFavouritesGroupForOwner(Mockito.<String>any())).thenReturn(appGroup);
    AppGroupMemberDao appGroupMemberDao2 = mock(AppGroupMemberDao.class);
    AppGroupEntryDao appGroupEntryDao2 = mock(AppGroupEntryDao.class);

    // Act
    Collection<AppGroupEntry> actualRemoveApplicationResult = (new FavouritesService(appGroupService,
        appGroupMemberDao2, appGroupEntryDao2, appGroupDao2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .removeApplication("janedoe", 1L);

    // Assert
    verify(appGroupDao2).getFavouritesGroupForOwner(eq("janedoe"));
    verify(appGroupEntryDao).findEntriesForGroup(eq(1L));
    verify(appGroupEntryDao).removeApplication(eq(1L), eq(1L));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("janedoe"));
    verify(applicationDao).getById(eq(1L));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(appGroup).id();
    assertTrue(actualRemoveApplicationResult instanceof List);
    assertTrue(actualRemoveApplicationResult.isEmpty());
    assertSame(appGroupEntryList, actualRemoveApplicationResult);
  }

  /**
   * Method under test: {@link FavouritesService#removeApplication(String, long)}
   */
  @Test
  void testRemoveApplication2() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.removeApplication(anyLong(), anyLong())).thenReturn(1);
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(appGroupEntryList);
    Application application = mock(Application.class);
    when(application.name()).thenReturn("Name");
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.getById(anyLong())).thenReturn(application);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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

    AppGroup appGroup = mock(AppGroup.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(appGroup.id()).thenReturn(ofResult);
    AppGroupDao appGroupDao2 = mock(AppGroupDao.class);
    when(appGroupDao2.getFavouritesGroupForOwner(Mockito.<String>any())).thenReturn(appGroup);
    AppGroupMemberDao appGroupMemberDao2 = mock(AppGroupMemberDao.class);
    AppGroupEntryDao appGroupEntryDao2 = mock(AppGroupEntryDao.class);

    // Act
    Collection<AppGroupEntry> actualRemoveApplicationResult = (new FavouritesService(appGroupService,
        appGroupMemberDao2, appGroupEntryDao2, appGroupDao2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .removeApplication("janedoe", 1L);

    // Assert
    verify(appGroupDao2).getFavouritesGroupForOwner(eq("janedoe"));
    verify(appGroupEntryDao).findEntriesForGroup(eq(1L));
    verify(appGroupEntryDao).removeApplication(eq(1L), eq(1L));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("janedoe"));
    verify(applicationDao).getById(eq(1L));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(appGroup).id();
    verify(application).name();
    assertTrue(actualRemoveApplicationResult instanceof List);
    assertTrue(actualRemoveApplicationResult.isEmpty());
    assertSame(appGroupEntryList, actualRemoveApplicationResult);
  }

  /**
   * Method under test: {@link FavouritesService#removeApplication(String, long)}
   */
  @Test
  void testRemoveApplication3() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.removeApplication(anyLong(), anyLong())).thenReturn(1);
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(appGroupEntryList);
    Application application = mock(Application.class);
    when(application.name()).thenReturn("Name");
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.getById(anyLong())).thenReturn(application);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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

    AppGroup appGroup = mock(AppGroup.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(appGroup.id()).thenReturn(ofResult);
    AppGroupDao appGroupDao2 = mock(AppGroupDao.class);
    when(appGroupDao2.getFavouritesGroupForOwner(Mockito.<String>any())).thenReturn(appGroup);
    AppGroupMemberDao appGroupMemberDao2 = mock(AppGroupMemberDao.class);
    AppGroupEntryDao appGroupEntryDao2 = mock(AppGroupEntryDao.class);

    // Act
    Collection<AppGroupEntry> actualRemoveApplicationResult = (new FavouritesService(appGroupService,
        appGroupMemberDao2, appGroupEntryDao2, appGroupDao2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .removeApplication("janedoe", 1L);

    // Assert
    verify(appGroupDao2).getFavouritesGroupForOwner(eq("janedoe"));
    verify(appGroupEntryDao).findEntriesForGroup(eq(1L));
    verify(appGroupEntryDao).removeApplication(eq(1L), eq(1L));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("janedoe"));
    verify(applicationDao).getById(eq(1L));
    verify(appGroup).id();
    verify(application).name();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualRemoveApplicationResult instanceof List);
    assertTrue(actualRemoveApplicationResult.isEmpty());
    assertSame(appGroupEntryList, actualRemoveApplicationResult);
  }

  /**
   * Method under test: {@link FavouritesService#removeApplication(String, long)}
   */
  @Test
  void testRemoveApplication4() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupService appGroupService = mock(AppGroupService.class);
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(appGroupService.removeApplication(Mockito.<String>any(), anyLong(), anyLong())).thenReturn(appGroupEntryList);
    AppGroup appGroup = mock(AppGroup.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(appGroup.id()).thenReturn(ofResult);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getFavouritesGroupForOwner(Mockito.<String>any())).thenReturn(appGroup);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);

    // Act
    Collection<AppGroupEntry> actualRemoveApplicationResult = (new FavouritesService(appGroupService, appGroupMemberDao,
        appGroupEntryDao, appGroupDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .removeApplication("janedoe", 1L);

    // Assert
    verify(appGroupDao).getFavouritesGroupForOwner(eq("janedoe"));
    verify(appGroup).id();
    verify(appGroupService).removeApplication(eq("janedoe"), eq(1L), eq(1L));
    assertTrue(actualRemoveApplicationResult instanceof List);
    assertTrue(actualRemoveApplicationResult.isEmpty());
    assertSame(appGroupEntryList, actualRemoveApplicationResult);
  }
}
