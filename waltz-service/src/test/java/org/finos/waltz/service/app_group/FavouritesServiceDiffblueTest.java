package org.finos.waltz.service.app_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
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
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.app_group.AppGroup;
import org.finos.waltz.model.app_group.AppGroupEntry;
import org.finos.waltz.model.app_group.AppGroupKind;
import org.finos.waltz.model.app_group.ImmutableAppGroup;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.ImmutableApplication;
import org.finos.waltz.model.application.ImmutableApplication.Builder;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.rating.RagRating;
import org.finos.waltz.service.change_initiative.ChangeInitiativeService;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.jooq.DSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FavouritesServiceDiffblueTest {
  /**
   * Test {@link FavouritesService#getFavouritesGroup(String)}.
   *
   * <p>Method under test: {@link FavouritesService#getFavouritesGroup(String)}
   */
  @Test
  @DisplayName("Test getFavouritesGroup(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppGroup FavouritesService.getFavouritesGroup(String)"})
  void testGetFavouritesGroup() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getFavouritesGroupForOwner(Mockito.<String>any()))
        .thenReturn(
            ImmutableAppGroup.builder()
                .appGroupKind(AppGroupKind.PUBLIC)
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    AppGroupDao appGroupDao2 = mock(AppGroupDao.class);
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

    ChangeInitiativeService changeInitiativeService =
        new ChangeInitiativeService(
            changeInitiativeDao, searchDao, relationshipDao, changeLogService);
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

    AppGroupService appGroupService =
        new AppGroupService(
            appGroupDao2,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);
    AppGroupMemberDao appGroupMemberDao2 = mock(AppGroupMemberDao.class);
    AppGroupEntryDao appGroupEntryDao2 = mock(AppGroupEntryDao.class);
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

    FavouritesService favouritesService =
        new FavouritesService(
            appGroupService, appGroupMemberDao2, appGroupEntryDao2, appGroupDao, changeLogService3);

    // Act
    AppGroup actualFavouritesGroup = favouritesService.getFavouritesGroup("janedoe");

    // Assert
    verify(appGroupDao).getFavouritesGroupForOwner("janedoe");
    assertTrue(actualFavouritesGroup instanceof ImmutableAppGroup);
    assertEquals("Name", actualFavouritesGroup.name());
    assertEquals(
        "The characteristics of someone or something", actualFavouritesGroup.description());
    assertEquals(EntityKind.ALL, actualFavouritesGroup.kind());
    assertEquals(AppGroupKind.PUBLIC, actualFavouritesGroup.appGroupKind());
    assertFalse(actualFavouritesGroup.isRemoved());
    assertFalse(actualFavouritesGroup.isFavouriteGroup());
  }

  /**
   * Test {@link FavouritesService#findFavouriteGroupEntries(String)}.
   *
   * <p>Method under test: {@link FavouritesService#findFavouriteGroupEntries(String)}
   */
  @Test
  @DisplayName("Test findFavouriteGroupEntries(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection FavouritesService.findFavouriteGroupEntries(String)"})
  void testFindFavouriteGroupEntries() {
    // Arrange
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(appGroupEntryList);

    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getFavouritesGroupForOwner(Mockito.<String>any()))
        .thenReturn(
            ImmutableAppGroup.builder()
                .appGroupKind(AppGroupKind.PUBLIC)
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    AppGroupDao appGroupDao2 = mock(AppGroupDao.class);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    AppGroupEntryDao appGroupEntryDao2 = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
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

    ChangeInitiativeService changeInitiativeService =
        new ChangeInitiativeService(
            changeInitiativeDao, searchDao, relationshipDao, changeLogService);
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

    AppGroupService appGroupService =
        new AppGroupService(
            appGroupDao2,
            appGroupMemberDao,
            appGroupEntryDao2,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);
    AppGroupMemberDao appGroupMemberDao2 = mock(AppGroupMemberDao.class);
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

    FavouritesService favouritesService =
        new FavouritesService(
            appGroupService, appGroupMemberDao2, appGroupEntryDao, appGroupDao, changeLogService3);

    // Act
    Collection<AppGroupEntry> actualFindFavouriteGroupEntriesResult =
        favouritesService.findFavouriteGroupEntries("janedoe");

    // Assert
    verify(appGroupDao).getFavouritesGroupForOwner("janedoe");
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    assertTrue(actualFindFavouriteGroupEntriesResult instanceof List);
    assertTrue(actualFindFavouriteGroupEntriesResult.isEmpty());
    assertSame(appGroupEntryList, actualFindFavouriteGroupEntriesResult);
  }

  /**
   * Test {@link FavouritesService#addApplication(String, long)}.
   *
   * <ul>
   *   <li>Given {@link AppGroupService} {@link AppGroupService#addApplication(String, long, long)}
   *       return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link FavouritesService#addApplication(String, long)}
   */
  @Test
  @DisplayName(
      "Test addApplication(String, long); given AppGroupService addApplication(String, long, long) return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection FavouritesService.addApplication(String, long)"})
  void testAddApplication_givenAppGroupServiceAddApplicationReturnArrayList()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupService appGroupService = mock(AppGroupService.class);
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(appGroupService.addApplication(Mockito.<String>any(), anyLong(), anyLong()))
        .thenReturn(appGroupEntryList);

    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getFavouritesGroupForOwner(Mockito.<String>any()))
        .thenReturn(
            ImmutableAppGroup.builder()
                .appGroupKind(AppGroupKind.PUBLIC)
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
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

    FavouritesService favouritesService =
        new FavouritesService(
            appGroupService, appGroupMemberDao, appGroupEntryDao, appGroupDao, changeLogService);

    // Act
    Collection<AppGroupEntry> actualAddApplicationResult =
        favouritesService.addApplication("janedoe", 1L);

    // Assert
    verify(appGroupDao).getFavouritesGroupForOwner("janedoe");
    verify(appGroupService).addApplication("janedoe", 1L, 1L);
    assertTrue(actualAddApplicationResult instanceof List);
    assertTrue(actualAddApplicationResult.isEmpty());
    assertSame(appGroupEntryList, actualAddApplicationResult);
  }

  /**
   * Test {@link FavouritesService#addApplication(String, long)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link FavouritesService#addApplication(String, long)}
   */
  @Test
  @DisplayName(
      "Test addApplication(String, long); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection FavouritesService.addApplication(String, long)"})
  void testAddApplication_givenChangeLogDaoWriteReturn19088743_thenCallsWrite()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.addApplication(anyLong(), anyLong())).thenReturn(2);
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(appGroupEntryList);

    ApplicationDao applicationDao = mock(ApplicationDao.class);

    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    when(applicationDao.getById(anyLong()))
        .thenReturn(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
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
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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

    AppGroupDao appGroupDao2 = mock(AppGroupDao.class);
    when(appGroupDao2.getFavouritesGroupForOwner(Mockito.<String>any()))
        .thenReturn(
            ImmutableAppGroup.builder()
                .appGroupKind(AppGroupKind.PUBLIC)
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    AppGroupMemberDao appGroupMemberDao2 = mock(AppGroupMemberDao.class);
    AppGroupEntryDao appGroupEntryDao2 = mock(AppGroupEntryDao.class);
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

    FavouritesService favouritesService =
        new FavouritesService(
            appGroupService,
            appGroupMemberDao2,
            appGroupEntryDao2,
            appGroupDao2,
            changeLogService3);

    // Act
    Collection<AppGroupEntry> actualAddApplicationResult =
        favouritesService.addApplication("janedoe", 1L);

    // Assert
    verify(appGroupDao2).getFavouritesGroupForOwner("janedoe");
    verify(appGroupEntryDao).addApplication(1L, 1L);
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupMemberDao).canUpdate(1L, "janedoe");
    verify(applicationDao).getById(1L);
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    assertTrue(actualAddApplicationResult instanceof List);
    assertTrue(actualAddApplicationResult.isEmpty());
    assertSame(appGroupEntryList, actualAddApplicationResult);
  }

  /**
   * Test {@link FavouritesService#addApplication(String, long)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link FavouritesService#addApplication(String, long)}
   */
  @Test
  @DisplayName(
      "Test addApplication(String, long); given ChangeLogService write(ChangeLog) return '19088743'; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection FavouritesService.addApplication(String, long)"})
  void testAddApplication_givenChangeLogServiceWriteReturn19088743_thenCallsWrite()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.addApplication(anyLong(), anyLong())).thenReturn(2);
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(appGroupEntryList);

    ApplicationDao applicationDao = mock(ApplicationDao.class);

    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    when(applicationDao.getById(anyLong()))
        .thenReturn(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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

    AppGroupDao appGroupDao2 = mock(AppGroupDao.class);
    when(appGroupDao2.getFavouritesGroupForOwner(Mockito.<String>any()))
        .thenReturn(
            ImmutableAppGroup.builder()
                .appGroupKind(AppGroupKind.PUBLIC)
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    AppGroupMemberDao appGroupMemberDao2 = mock(AppGroupMemberDao.class);
    AppGroupEntryDao appGroupEntryDao2 = mock(AppGroupEntryDao.class);
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

    FavouritesService favouritesService =
        new FavouritesService(
            appGroupService,
            appGroupMemberDao2,
            appGroupEntryDao2,
            appGroupDao2,
            changeLogService3);

    // Act
    Collection<AppGroupEntry> actualAddApplicationResult =
        favouritesService.addApplication("janedoe", 1L);

    // Assert
    verify(appGroupDao2).getFavouritesGroupForOwner("janedoe");
    verify(appGroupEntryDao).addApplication(1L, 1L);
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupMemberDao).canUpdate(1L, "janedoe");
    verify(applicationDao).getById(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualAddApplicationResult instanceof List);
    assertTrue(actualAddApplicationResult.isEmpty());
    assertSame(appGroupEntryList, actualAddApplicationResult);
  }

  /**
   * Test {@link FavouritesService#addApplication(String, long)}.
   *
   * <ul>
   *   <li>Then throw {@link InsufficientPrivelegeException}.
   * </ul>
   *
   * <p>Method under test: {@link FavouritesService#addApplication(String, long)}
   */
  @Test
  @DisplayName("Test addApplication(String, long); then throw InsufficientPrivelegeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection FavouritesService.addApplication(String, long)"})
  void testAddApplication_thenThrowInsufficientPrivelegeException()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupService appGroupService = mock(AppGroupService.class);
    when(appGroupService.addApplication(Mockito.<String>any(), anyLong(), anyLong()))
        .thenThrow(new InsufficientPrivelegeException("An error occurred"));

    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getFavouritesGroupForOwner(Mockito.<String>any()))
        .thenReturn(
            ImmutableAppGroup.builder()
                .appGroupKind(AppGroupKind.PUBLIC)
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
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

    FavouritesService favouritesService =
        new FavouritesService(
            appGroupService, appGroupMemberDao, appGroupEntryDao, appGroupDao, changeLogService);

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class,
        () -> favouritesService.addApplication("janedoe", 1L));
    verify(appGroupDao).getFavouritesGroupForOwner("janedoe");
    verify(appGroupService).addApplication("janedoe", 1L, 1L);
  }

  /**
   * Test {@link FavouritesService#removeApplication(String, long)}.
   *
   * <ul>
   *   <li>Given {@link AppGroupService} {@link AppGroupService#removeApplication(String, long,
   *       long)} return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link FavouritesService#removeApplication(String, long)}
   */
  @Test
  @DisplayName(
      "Test removeApplication(String, long); given AppGroupService removeApplication(String, long, long) return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection FavouritesService.removeApplication(String, long)"})
  void testRemoveApplication_givenAppGroupServiceRemoveApplicationReturnArrayList()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupService appGroupService = mock(AppGroupService.class);
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(appGroupService.removeApplication(Mockito.<String>any(), anyLong(), anyLong()))
        .thenReturn(appGroupEntryList);

    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getFavouritesGroupForOwner(Mockito.<String>any()))
        .thenReturn(
            ImmutableAppGroup.builder()
                .appGroupKind(AppGroupKind.PUBLIC)
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
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

    FavouritesService favouritesService =
        new FavouritesService(
            appGroupService, appGroupMemberDao, appGroupEntryDao, appGroupDao, changeLogService);

    // Act
    Collection<AppGroupEntry> actualRemoveApplicationResult =
        favouritesService.removeApplication("janedoe", 1L);

    // Assert
    verify(appGroupDao).getFavouritesGroupForOwner("janedoe");
    verify(appGroupService).removeApplication("janedoe", 1L, 1L);
    assertTrue(actualRemoveApplicationResult instanceof List);
    assertTrue(actualRemoveApplicationResult.isEmpty());
    assertSame(appGroupEntryList, actualRemoveApplicationResult);
  }

  /**
   * Test {@link FavouritesService#removeApplication(String, long)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link FavouritesService#removeApplication(String, long)}
   */
  @Test
  @DisplayName(
      "Test removeApplication(String, long); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection FavouritesService.removeApplication(String, long)"})
  void testRemoveApplication_givenChangeLogDaoWriteReturn19088743_thenCallsWrite()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.removeApplication(anyLong(), anyLong())).thenReturn(1);
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(appGroupEntryList);

    ApplicationDao applicationDao = mock(ApplicationDao.class);

    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    when(applicationDao.getById(anyLong()))
        .thenReturn(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
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
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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

    AppGroupDao appGroupDao2 = mock(AppGroupDao.class);
    when(appGroupDao2.getFavouritesGroupForOwner(Mockito.<String>any()))
        .thenReturn(
            ImmutableAppGroup.builder()
                .appGroupKind(AppGroupKind.PUBLIC)
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    AppGroupMemberDao appGroupMemberDao2 = mock(AppGroupMemberDao.class);
    AppGroupEntryDao appGroupEntryDao2 = mock(AppGroupEntryDao.class);
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

    FavouritesService favouritesService =
        new FavouritesService(
            appGroupService,
            appGroupMemberDao2,
            appGroupEntryDao2,
            appGroupDao2,
            changeLogService3);

    // Act
    Collection<AppGroupEntry> actualRemoveApplicationResult =
        favouritesService.removeApplication("janedoe", 1L);

    // Assert
    verify(appGroupDao2).getFavouritesGroupForOwner("janedoe");
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupEntryDao).removeApplication(1L, 1L);
    verify(appGroupMemberDao).canUpdate(1L, "janedoe");
    verify(applicationDao).getById(1L);
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    assertTrue(actualRemoveApplicationResult instanceof List);
    assertTrue(actualRemoveApplicationResult.isEmpty());
    assertSame(appGroupEntryList, actualRemoveApplicationResult);
  }

  /**
   * Test {@link FavouritesService#removeApplication(String, long)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link FavouritesService#removeApplication(String, long)}
   */
  @Test
  @DisplayName(
      "Test removeApplication(String, long); given ChangeLogService write(ChangeLog) return '19088743'; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection FavouritesService.removeApplication(String, long)"})
  void testRemoveApplication_givenChangeLogServiceWriteReturn19088743_thenCallsWrite()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.removeApplication(anyLong(), anyLong())).thenReturn(1);
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(appGroupEntryList);

    ApplicationDao applicationDao = mock(ApplicationDao.class);

    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    when(applicationDao.getById(anyLong()))
        .thenReturn(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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

    AppGroupDao appGroupDao2 = mock(AppGroupDao.class);
    when(appGroupDao2.getFavouritesGroupForOwner(Mockito.<String>any()))
        .thenReturn(
            ImmutableAppGroup.builder()
                .appGroupKind(AppGroupKind.PUBLIC)
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    AppGroupMemberDao appGroupMemberDao2 = mock(AppGroupMemberDao.class);
    AppGroupEntryDao appGroupEntryDao2 = mock(AppGroupEntryDao.class);
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

    FavouritesService favouritesService =
        new FavouritesService(
            appGroupService,
            appGroupMemberDao2,
            appGroupEntryDao2,
            appGroupDao2,
            changeLogService3);

    // Act
    Collection<AppGroupEntry> actualRemoveApplicationResult =
        favouritesService.removeApplication("janedoe", 1L);

    // Assert
    verify(appGroupDao2).getFavouritesGroupForOwner("janedoe");
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupEntryDao).removeApplication(1L, 1L);
    verify(appGroupMemberDao).canUpdate(1L, "janedoe");
    verify(applicationDao).getById(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualRemoveApplicationResult instanceof List);
    assertTrue(actualRemoveApplicationResult.isEmpty());
    assertSame(appGroupEntryList, actualRemoveApplicationResult);
  }

  /**
   * Test {@link FavouritesService#removeApplication(String, long)}.
   *
   * <ul>
   *   <li>Then throw {@link InsufficientPrivelegeException}.
   * </ul>
   *
   * <p>Method under test: {@link FavouritesService#removeApplication(String, long)}
   */
  @Test
  @DisplayName("Test removeApplication(String, long); then throw InsufficientPrivelegeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection FavouritesService.removeApplication(String, long)"})
  void testRemoveApplication_thenThrowInsufficientPrivelegeException()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupService appGroupService = mock(AppGroupService.class);
    when(appGroupService.removeApplication(Mockito.<String>any(), anyLong(), anyLong()))
        .thenThrow(new InsufficientPrivelegeException("An error occurred"));

    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getFavouritesGroupForOwner(Mockito.<String>any()))
        .thenReturn(
            ImmutableAppGroup.builder()
                .appGroupKind(AppGroupKind.PUBLIC)
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
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

    FavouritesService favouritesService =
        new FavouritesService(
            appGroupService, appGroupMemberDao, appGroupEntryDao, appGroupDao, changeLogService);

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class,
        () -> favouritesService.removeApplication("janedoe", 1L));
    verify(appGroupDao).getFavouritesGroupForOwner("janedoe");
    verify(appGroupService).removeApplication("janedoe", 1L, 1L);
  }
}
