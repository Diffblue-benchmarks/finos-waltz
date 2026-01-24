package org.finos.waltz.service.app_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
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
import java.util.List;
import java.util.Optional;
import java.util.Set;
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
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.app_group.AppGroup;
import org.finos.waltz.model.app_group.AppGroupDetail;
import org.finos.waltz.model.app_group.AppGroupEntry;
import org.finos.waltz.model.app_group.AppGroupKind;
import org.finos.waltz.model.app_group.AppGroupMember;
import org.finos.waltz.model.app_group.AppGroupMemberRole;
import org.finos.waltz.model.app_group.ImmutableAppGroup;
import org.finos.waltz.model.app_group.ImmutableAppGroupDetail;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.app_group.ImmutableAppGroupMember;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.ImmutableApplication;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.entity_relationship.EntityRelationship;
import org.finos.waltz.model.entity_relationship.EntityRelationshipKey;
import org.finos.waltz.model.entity_relationship.ImmutableEntityRelationship;
import org.finos.waltz.model.entity_relationship.ImmutableEntityRelationship.Builder;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.orgunit.ImmutableOrganisationalUnit;
import org.finos.waltz.model.rating.RagRating;
import org.finos.waltz.service.change_initiative.ChangeInitiativeService;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.jooq.DSLContext;
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
class AppGroupServiceDiffblueTest {
  @Mock private AppGroupDao appGroupDao;

  @Mock private AppGroupEntryDao appGroupEntryDao;

  @Mock private AppGroupMemberDao appGroupMemberDao;

  @Mock private AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao;

  @InjectMocks private AppGroupService appGroupService;

  @Mock private ApplicationDao applicationDao;

  @Mock private ChangeInitiativeService changeInitiativeService;

  @Mock private ChangeLogService changeLogService;

  @Mock private EntityRelationshipDao entityRelationshipDao;

  @Mock private OrganisationalUnitDao organisationalUnitDao;

  /**
   * Test {@link AppGroupService#getGroupDetailById(long)}.
   *
   * <p>Method under test: {@link AppGroupService#getGroupDetailById(long)}
   */
  @Test
  @DisplayName("Test getGroupDetailById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppGroupDetail AppGroupService.getGroupDetailById(long)"})
  void testGetGroupDetailById() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong()))
        .thenReturn(
            ImmutableAppGroup.builder()
                .appGroupKind(AppGroupKind.PUBLIC)
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenThrow(new IllegalArgumentException());
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> appGroupService.getGroupDetailById(1L));
    verify(appGroupDao).getGroup(1L);
    verify(appGroupEntryDao).findEntriesForGroup(1L);
  }

  /**
   * Test {@link AppGroupService#getGroupDetailById(long)}.
   *
   * <p>Method under test: {@link AppGroupService#getGroupDetailById(long)}
   */
  @Test
  @DisplayName("Test getGroupDetailById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppGroupDetail AppGroupService.getGroupDetailById(long)"})
  void testGetGroupDetailById2() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong()))
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
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(new HashSet<>());

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong()))
        .thenThrow(new IllegalArgumentException());
    ApplicationDao applicationDao = mock(ApplicationDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> appGroupService.getGroupDetailById(1L));
    verify(appGroupDao).getGroup(1L);
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupMemberDao).getMembers(1L);
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(1L);
  }

  /**
   * Test {@link AppGroupService#getGroupDetailById(long)}.
   *
   * <p>Method under test: {@link AppGroupService#getGroupDetailById(long)}
   */
  @Test
  @DisplayName("Test getGroupDetailById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppGroupDetail AppGroupService.getGroupDetailById(long)"})
  void testGetGroupDetailById3() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong()))
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
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(new HashSet<>());

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();

    Builder builderResult = ImmutableEntityRelationship.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    entityRelationshipList.add(
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .relationship("127.0.0.1")
            .build());

    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(entityRelationshipList);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
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
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act
    AppGroupDetail actualGroupDetailById = appGroupService.getGroupDetailById(1L);

    // Assert
    verify(appGroupDao).getGroup(1L);
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupMemberDao).getMembers(1L);
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(1L);
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    assertTrue(actualGroupDetailById instanceof ImmutableAppGroupDetail);
    List<AppGroupEntry> applicationsResult = actualGroupDetailById.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualGroupDetailById.changeInitiatives());
    assertSame(applicationsResult, actualGroupDetailById.members());
    assertSame(applicationsResult, actualGroupDetailById.organisationalUnits());
  }

  /**
   * Test {@link AppGroupService#getGroupDetailById(long)}.
   *
   * <p>Method under test: {@link AppGroupService#getGroupDetailById(long)}
   */
  @Test
  @DisplayName("Test getGroupDetailById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppGroupDetail AppGroupService.getGroupDetailById(long)"})
  void testGetGroupDetailById4() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong()))
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
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(new HashSet<>());

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();

    Builder builderResult = ImmutableEntityRelationship.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    entityRelationshipList.add(
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .relationship("127.0.0.1")
            .build());

    Builder builderResult2 = ImmutableEntityRelationship.builder();

    Builder aResult2 =
        builderResult2.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    entityRelationshipList.add(
        aResult2
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .relationship("127.0.0.1")
            .build());

    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(entityRelationshipList);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
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
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act
    AppGroupDetail actualGroupDetailById = appGroupService.getGroupDetailById(1L);

    // Assert
    verify(appGroupDao).getGroup(1L);
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupMemberDao).getMembers(1L);
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(1L);
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    assertTrue(actualGroupDetailById instanceof ImmutableAppGroupDetail);
    List<AppGroupEntry> applicationsResult = actualGroupDetailById.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualGroupDetailById.changeInitiatives());
    assertSame(applicationsResult, actualGroupDetailById.members());
    assertSame(applicationsResult, actualGroupDetailById.organisationalUnits());
  }

  /**
   * Test {@link AppGroupService#getGroupDetailById(long)}.
   *
   * <p>Method under test: {@link AppGroupService#getGroupDetailById(long)}
   */
  @Test
  @DisplayName("Test getGroupDetailById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppGroupDetail AppGroupService.getGroupDetailById(long)"})
  void testGetGroupDetailById5() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong()))
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
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(new HashSet<>());

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    ChangeInitiativeService changeInitiativeService = mock(ChangeInitiativeService.class);
    when(changeInitiativeService.findEntriesForAppGroup(anyLong())).thenReturn(new ArrayList<>());
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
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

    // Act
    AppGroupDetail actualGroupDetailById = appGroupService.getGroupDetailById(1L);

    // Assert
    verify(appGroupDao).getGroup(1L);
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupMemberDao).getMembers(1L);
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(1L);
    verify(changeInitiativeService).findEntriesForAppGroup(1L);
    assertTrue(actualGroupDetailById instanceof ImmutableAppGroupDetail);
    List<AppGroupEntry> applicationsResult = actualGroupDetailById.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualGroupDetailById.changeInitiatives());
    assertSame(applicationsResult, actualGroupDetailById.members());
    assertSame(applicationsResult, actualGroupDetailById.organisationalUnits());
  }

  /**
   * Test {@link AppGroupService#getGroupDetailById(long)}.
   *
   * <ul>
   *   <li>Given {@link AppGroupDao} {@link AppGroupDao#getGroup(long)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#getGroupDetailById(long)}
   */
  @Test
  @DisplayName(
      "Test getGroupDetailById(long); given AppGroupDao getGroup(long) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppGroupDetail AppGroupService.getGroupDetailById(long)"})
  void testGetGroupDetailById_givenAppGroupDaoGetGroupThrowIllegalArgumentException() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong())).thenThrow(new IllegalArgumentException());
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> appGroupService.getGroupDetailById(1L));
    verify(appGroupDao).getGroup(1L);
  }

  /**
   * Test {@link AppGroupService#getGroupDetailById(long)}.
   *
   * <ul>
   *   <li>Given {@link ApplicationDao}.
   *   <li>Then calls {@link ChangeInitiativeService#findEntriesForAppGroup(long)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#getGroupDetailById(long)}
   */
  @Test
  @DisplayName(
      "Test getGroupDetailById(long); given ApplicationDao; then calls findEntriesForAppGroup(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppGroupDetail AppGroupService.getGroupDetailById(long)"})
  void testGetGroupDetailById_givenApplicationDao_thenCallsFindEntriesForAppGroup() {
    // Arrange
    when(appGroupDao.getGroup(anyLong()))
        .thenReturn(
            ImmutableAppGroup.builder()
                .appGroupKind(AppGroupKind.PUBLIC)
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(new HashSet<>());
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());
    when(changeInitiativeService.findEntriesForAppGroup(anyLong()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> appGroupService.getGroupDetailById(1L));
    verify(appGroupDao).getGroup(1L);
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupMemberDao).getMembers(1L);
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(1L);
    verify(changeInitiativeService).findEntriesForAppGroup(1L);
  }

  /**
   * Test {@link AppGroupService#getGroupDetailById(long)}.
   *
   * <ul>
   *   <li>Then return applications Empty.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#getGroupDetailById(long)}
   */
  @Test
  @DisplayName("Test getGroupDetailById(long); then return applications Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppGroupDetail AppGroupService.getGroupDetailById(long)"})
  void testGetGroupDetailById_thenReturnApplicationsEmpty() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong()))
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
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(new HashSet<>());

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
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
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act
    AppGroupDetail actualGroupDetailById = appGroupService.getGroupDetailById(1L);

    // Assert
    verify(appGroupDao).getGroup(1L);
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupMemberDao).getMembers(1L);
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(1L);
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    assertTrue(actualGroupDetailById instanceof ImmutableAppGroupDetail);
    List<AppGroupEntry> applicationsResult = actualGroupDetailById.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualGroupDetailById.changeInitiatives());
    assertSame(applicationsResult, actualGroupDetailById.members());
    assertSame(applicationsResult, actualGroupDetailById.organisationalUnits());
  }

  /**
   * Test {@link AppGroupService#getGroupDetailById(long)}.
   *
   * <ul>
   *   <li>Then return changeInitiatives Empty.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#getGroupDetailById(long)}
   */
  @Test
  @DisplayName("Test getGroupDetailById(long); then return changeInitiatives Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppGroupDetail AppGroupService.getGroupDetailById(long)"})
  void testGetGroupDetailById_thenReturnChangeInitiativesEmpty() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong()))
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
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(new HashSet<>());

    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    appGroupEntryList.add(
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build());

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(appGroupEntryList);

    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
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
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act
    AppGroupDetail actualGroupDetailById = appGroupService.getGroupDetailById(1L);

    // Assert
    verify(appGroupDao).getGroup(1L);
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupMemberDao).getMembers(1L);
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(1L);
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    assertTrue(actualGroupDetailById instanceof ImmutableAppGroupDetail);
    List<AppGroupEntry> changeInitiativesResult = actualGroupDetailById.changeInitiatives();
    assertTrue(changeInitiativesResult.isEmpty());
    assertEquals(appGroupEntryList, actualGroupDetailById.applications());
    assertSame(changeInitiativesResult, actualGroupDetailById.members());
    assertSame(changeInitiativesResult, actualGroupDetailById.organisationalUnits());
  }

  /**
   * Test {@link AppGroupService#getGroupDetailById(long)}.
   *
   * <ul>
   *   <li>Then return changeInitiatives Empty.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#getGroupDetailById(long)}
   */
  @Test
  @DisplayName("Test getGroupDetailById(long); then return changeInitiatives Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppGroupDetail AppGroupService.getGroupDetailById(long)"})
  void testGetGroupDetailById_thenReturnChangeInitiativesEmpty2() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong()))
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
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(new HashSet<>());

    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    appGroupEntryList.add(
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build());
    appGroupEntryList.add(
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build());

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(appGroupEntryList);

    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
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
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act
    AppGroupDetail actualGroupDetailById = appGroupService.getGroupDetailById(1L);

    // Assert
    verify(appGroupDao).getGroup(1L);
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupMemberDao).getMembers(1L);
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(1L);
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    assertTrue(actualGroupDetailById instanceof ImmutableAppGroupDetail);
    List<AppGroupEntry> changeInitiativesResult = actualGroupDetailById.changeInitiatives();
    assertTrue(changeInitiativesResult.isEmpty());
    assertEquals(appGroupEntryList, actualGroupDetailById.applications());
    assertSame(changeInitiativesResult, actualGroupDetailById.members());
    assertSame(changeInitiativesResult, actualGroupDetailById.organisationalUnits());
  }

  /**
   * Test {@link AppGroupService#getGroupDetailById(long)}.
   *
   * <ul>
   *   <li>Then return changeInitiatives is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#getGroupDetailById(long)}
   */
  @Test
  @DisplayName("Test getGroupDetailById(long); then return changeInitiatives is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppGroupDetail AppGroupService.getGroupDetailById(long)"})
  void testGetGroupDetailById_thenReturnChangeInitiativesIsArrayList() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong()))
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
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(new HashSet<>());

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    appGroupEntryList.add(
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build());

    ChangeInitiativeService changeInitiativeService = mock(ChangeInitiativeService.class);
    when(changeInitiativeService.findEntriesForAppGroup(anyLong())).thenReturn(appGroupEntryList);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
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

    // Act
    AppGroupDetail actualGroupDetailById = appGroupService.getGroupDetailById(1L);

    // Assert
    verify(appGroupDao).getGroup(1L);
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupMemberDao).getMembers(1L);
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(1L);
    verify(changeInitiativeService).findEntriesForAppGroup(1L);
    assertTrue(actualGroupDetailById instanceof ImmutableAppGroupDetail);
    assertEquals(appGroupEntryList, actualGroupDetailById.changeInitiatives());
  }

  /**
   * Test {@link AppGroupService#getGroupDetailById(long)}.
   *
   * <ul>
   *   <li>Then return members size is one.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#getGroupDetailById(long)}
   */
  @Test
  @DisplayName("Test getGroupDetailById(long); then return members size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppGroupDetail AppGroupService.getGroupDetailById(long)"})
  void testGetGroupDetailById_thenReturnMembersSizeIsOne() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong()))
        .thenReturn(
            ImmutableAppGroup.builder()
                .appGroupKind(AppGroupKind.PUBLIC)
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    HashSet<AppGroupMember> appGroupMemberSet = new HashSet<>();
    appGroupMemberSet.add(
        ImmutableAppGroupMember.builder()
            .groupId(1L)
            .role(AppGroupMemberRole.VIEWER)
            .userId("42")
            .build());

    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(appGroupMemberSet);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
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
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act
    AppGroupDetail actualGroupDetailById = appGroupService.getGroupDetailById(1L);

    // Assert
    verify(appGroupDao).getGroup(1L);
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupMemberDao).getMembers(1L);
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(1L);
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    assertTrue(actualGroupDetailById instanceof ImmutableAppGroupDetail);
    List<AppGroupMember> membersResult = actualGroupDetailById.members();
    assertEquals(1, membersResult.size());
    AppGroupMember getResult = membersResult.get(0);
    assertTrue(getResult instanceof ImmutableAppGroupMember);
    assertEquals("42", getResult.userId());
    assertEquals(1L, getResult.groupId());
    assertEquals(AppGroupMemberRole.VIEWER, getResult.role());
  }

  /**
   * Test {@link AppGroupService#getGroupDetailById(long)}.
   *
   * <ul>
   *   <li>Then return organisationalUnits is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#getGroupDetailById(long)}
   */
  @Test
  @DisplayName("Test getGroupDetailById(long); then return organisationalUnits is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppGroupDetail AppGroupService.getGroupDetailById(long)"})
  void testGetGroupDetailById_thenReturnOrganisationalUnitsIsArrayList() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong()))
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
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(new HashSet<>());

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    appGroupEntryList.add(
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build());

    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(appGroupEntryList);

    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
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
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act
    AppGroupDetail actualGroupDetailById = appGroupService.getGroupDetailById(1L);

    // Assert
    verify(appGroupDao).getGroup(1L);
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupMemberDao).getMembers(1L);
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(1L);
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    assertTrue(actualGroupDetailById instanceof ImmutableAppGroupDetail);
    assertEquals(appGroupEntryList, actualGroupDetailById.organisationalUnits());
  }

  /**
   * Test {@link AppGroupService#findGroupSubscriptionsForUser(String)}.
   *
   * <p>Method under test: {@link AppGroupService#findGroupSubscriptionsForUser(String)}
   */
  @Test
  @DisplayName("Test findGroupSubscriptionsForUser(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AppGroupService.findGroupSubscriptionsForUser(String)"})
  void testFindGroupSubscriptionsForUser() {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.getSubscriptions(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> appGroupService.findGroupSubscriptionsForUser("42"));
    verify(appGroupMemberDao).getSubscriptions("42");
  }

  /**
   * Test {@link AppGroupService#findGroupSubscriptionsForUser(String)}.
   *
   * <p>Method under test: {@link AppGroupService#findGroupSubscriptionsForUser(String)}
   */
  @Test
  @DisplayName("Test findGroupSubscriptionsForUser(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AppGroupService.findGroupSubscriptionsForUser(String)"})
  void testFindGroupSubscriptionsForUser2() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.findGroupsForUser(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.getSubscriptions(Mockito.<String>any())).thenReturn(new HashSet<>());
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> appGroupService.findGroupSubscriptionsForUser("42"));
    verify(appGroupDao).findGroupsForUser("42");
    verify(appGroupMemberDao).getSubscriptions("42");
  }

  /**
   * Test {@link AppGroupService#findGroupSubscriptionsForUser(String)}.
   *
   * <p>Method under test: {@link AppGroupService#findGroupSubscriptionsForUser(String)}
   */
  @Test
  @DisplayName("Test findGroupSubscriptionsForUser(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AppGroupService.findGroupSubscriptionsForUser(String)"})
  void testFindGroupSubscriptionsForUser3() {
    // Arrange
    ArrayList<AppGroup> appGroupList = new ArrayList<>();
    appGroupList.add(
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    when(appGroupDao.findGroupsForUser(Mockito.<String>any())).thenReturn(appGroupList);

    HashSet<AppGroupMember> appGroupMemberSet = new HashSet<>();
    appGroupMemberSet.add(
        ImmutableAppGroupMember.builder()
            .groupId(1L)
            .role(AppGroupMemberRole.VIEWER)
            .userId("42")
            .build());
    appGroupMemberSet.add(
        ImmutableAppGroupMember.builder()
            .groupId(2L)
            .role(AppGroupMemberRole.VIEWER)
            .userId("42")
            .build());
    when(appGroupMemberDao.getSubscriptions(Mockito.<String>any())).thenReturn(appGroupMemberSet);

    // Act
    Set<AppGroupSubscription> actualFindGroupSubscriptionsForUserResult =
        appGroupService.findGroupSubscriptionsForUser("42");

    // Assert
    verify(appGroupDao).findGroupsForUser("42");
    verify(appGroupMemberDao).getSubscriptions("42");
    assertEquals(1, actualFindGroupSubscriptionsForUserResult.size());
  }

  /**
   * Test {@link AppGroupService#findGroupSubscriptionsForUser(String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#findGroupSubscriptionsForUser(String)}
   */
  @Test
  @DisplayName("Test findGroupSubscriptionsForUser(String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AppGroupService.findGroupSubscriptionsForUser(String)"})
  void testFindGroupSubscriptionsForUser_thenReturnEmpty() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.findGroupsForUser(Mockito.<String>any())).thenReturn(new ArrayList<>());

    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.getSubscriptions(Mockito.<String>any())).thenReturn(new HashSet<>());
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act
    Set<AppGroupSubscription> actualFindGroupSubscriptionsForUserResult =
        appGroupService.findGroupSubscriptionsForUser("42");

    // Assert
    verify(appGroupDao).findGroupsForUser("42");
    verify(appGroupMemberDao).getSubscriptions("42");
    assertTrue(actualFindGroupSubscriptionsForUserResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#findGroupSubscriptionsForUser(String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#findGroupSubscriptionsForUser(String)}
   */
  @Test
  @DisplayName("Test findGroupSubscriptionsForUser(String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AppGroupService.findGroupSubscriptionsForUser(String)"})
  void testFindGroupSubscriptionsForUser_thenReturnEmpty2() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.findGroupsForUser(Mockito.<String>any())).thenReturn(new ArrayList<>());

    HashSet<AppGroupMember> appGroupMemberSet = new HashSet<>();
    appGroupMemberSet.add(
        ImmutableAppGroupMember.builder()
            .groupId(1L)
            .role(AppGroupMemberRole.VIEWER)
            .userId("42")
            .build());

    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.getSubscriptions(Mockito.<String>any())).thenReturn(appGroupMemberSet);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act
    Set<AppGroupSubscription> actualFindGroupSubscriptionsForUserResult =
        appGroupService.findGroupSubscriptionsForUser("42");

    // Assert
    verify(appGroupDao).findGroupsForUser("42");
    verify(appGroupMemberDao).getSubscriptions("42");
    assertTrue(actualFindGroupSubscriptionsForUserResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#findGroupSubscriptionsForUser(String)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#findGroupSubscriptionsForUser(String)}
   */
  @Test
  @DisplayName("Test findGroupSubscriptionsForUser(String); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AppGroupService.findGroupSubscriptionsForUser(String)"})
  void testFindGroupSubscriptionsForUser_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<AppGroup> appGroupList = new ArrayList<>();
    appGroupList.add(
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.findGroupsForUser(Mockito.<String>any())).thenReturn(appGroupList);

    HashSet<AppGroupMember> appGroupMemberSet = new HashSet<>();
    appGroupMemberSet.add(
        ImmutableAppGroupMember.builder()
            .groupId(1L)
            .role(AppGroupMemberRole.VIEWER)
            .userId("42")
            .build());

    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.getSubscriptions(Mockito.<String>any())).thenReturn(appGroupMemberSet);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act
    Set<AppGroupSubscription> actualFindGroupSubscriptionsForUserResult =
        appGroupService.findGroupSubscriptionsForUser("42");

    // Assert
    verify(appGroupDao).findGroupsForUser("42");
    verify(appGroupMemberDao).getSubscriptions("42");
    assertEquals(1, actualFindGroupSubscriptionsForUserResult.size());
  }

  /**
   * Test {@link AppGroupService#findGroupSubscriptionsForUser(String)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#findGroupSubscriptionsForUser(String)}
   */
  @Test
  @DisplayName("Test findGroupSubscriptionsForUser(String); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AppGroupService.findGroupSubscriptionsForUser(String)"})
  void testFindGroupSubscriptionsForUser_thenReturnSizeIsOne2() {
    // Arrange
    ArrayList<AppGroup> appGroupList = new ArrayList<>();
    appGroupList.add(
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    appGroupList.add(
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.findGroupsForUser(Mockito.<String>any())).thenReturn(appGroupList);

    HashSet<AppGroupMember> appGroupMemberSet = new HashSet<>();
    appGroupMemberSet.add(
        ImmutableAppGroupMember.builder()
            .groupId(1L)
            .role(AppGroupMemberRole.VIEWER)
            .userId("42")
            .build());

    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.getSubscriptions(Mockito.<String>any())).thenReturn(appGroupMemberSet);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act
    Set<AppGroupSubscription> actualFindGroupSubscriptionsForUserResult =
        appGroupService.findGroupSubscriptionsForUser("42");

    // Assert
    verify(appGroupDao).findGroupsForUser("42");
    verify(appGroupMemberDao).getSubscriptions("42");
    assertEquals(1, actualFindGroupSubscriptionsForUserResult.size());
  }

  /**
   * Test {@link AppGroupService#findPublicGroups()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#findPublicGroups()}
   */
  @Test
  @DisplayName("Test findPublicGroups(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.findPublicGroups()"})
  void testFindPublicGroups_thenReturnEmpty() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.findPublicGroups()).thenReturn(new ArrayList<>());
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act
    List<AppGroup> actualFindPublicGroupsResult = appGroupService.findPublicGroups();

    // Assert
    verify(appGroupDao).findPublicGroups();
    assertTrue(actualFindPublicGroupsResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#findPublicGroups()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#findPublicGroups()}
   */
  @Test
  @DisplayName("Test findPublicGroups(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.findPublicGroups()"})
  void testFindPublicGroups_thenThrowIllegalArgumentException() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.findPublicGroups()).thenThrow(new IllegalArgumentException());
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> appGroupService.findPublicGroups());
    verify(appGroupDao).findPublicGroups();
  }

  /**
   * Test {@link AppGroupService#findPrivateGroupsByOwner(String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#findPrivateGroupsByOwner(String)}
   */
  @Test
  @DisplayName("Test findPrivateGroupsByOwner(String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.findPrivateGroupsByOwner(String)"})
  void testFindPrivateGroupsByOwner_thenReturnEmpty() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.findPrivateGroupsByOwner(Mockito.<String>any())).thenReturn(new ArrayList<>());
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act
    List<AppGroup> actualFindPrivateGroupsByOwnerResult =
        appGroupService.findPrivateGroupsByOwner("42");

    // Assert
    verify(appGroupDao).findPrivateGroupsByOwner("42");
    assertTrue(actualFindPrivateGroupsByOwnerResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#findPrivateGroupsByOwner(String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#findPrivateGroupsByOwner(String)}
   */
  @Test
  @DisplayName("Test findPrivateGroupsByOwner(String); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.findPrivateGroupsByOwner(String)"})
  void testFindPrivateGroupsByOwner_thenThrowIllegalArgumentException() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.findPrivateGroupsByOwner(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> appGroupService.findPrivateGroupsByOwner("42"));
    verify(appGroupDao).findPrivateGroupsByOwner("42");
  }

  /**
   * Test {@link AppGroupService#findRelatedByEntityReference(EntityReference, String)}.
   *
   * <p>Method under test: {@link AppGroupService#findRelatedByEntityReference(EntityReference,
   * String)}
   */
  @Test
  @DisplayName("Test findRelatedByEntityReference(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.findRelatedByEntityReference(EntityReference, String)"})
  void testFindRelatedByEntityReference() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.findRelatedByEntityReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act
    List<AppGroup> actualFindRelatedByEntityReferenceResult =
        appGroupService.findRelatedByEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(appGroupDao).findRelatedByEntityReference(isA(EntityReference.class), eq("janedoe"));
    assertTrue(actualFindRelatedByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#findRelatedByEntityReference(EntityReference, String)}.
   *
   * <p>Method under test: {@link AppGroupService#findRelatedByEntityReference(EntityReference,
   * String)}
   */
  @Test
  @DisplayName("Test findRelatedByEntityReference(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.findRelatedByEntityReference(EntityReference, String)"})
  void testFindRelatedByEntityReference2() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.findRelatedByEntityReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            appGroupService.findRelatedByEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                "janedoe"));
    verify(appGroupDao).findRelatedByEntityReference(isA(EntityReference.class), eq("janedoe"));
  }

  /**
   * Test {@link AppGroupService#findRelatedByEntityReference(EntityReference, String)}.
   *
   * <p>Method under test: {@link AppGroupService#findRelatedByEntityReference(EntityReference,
   * String)}
   */
  @Test
  @DisplayName("Test findRelatedByEntityReference(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.findRelatedByEntityReference(EntityReference, String)"})
  void testFindRelatedByEntityReference3() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.findRelatedByApplicationId(anyLong(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act
    List<AppGroup> actualFindRelatedByEntityReferenceResult =
        appGroupService.findRelatedByEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APPLICATION)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(appGroupDao).findRelatedByApplicationId(1L, "janedoe");
    assertTrue(actualFindRelatedByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#findRelatedByEntityReference(EntityReference, String)}.
   *
   * <p>Method under test: {@link AppGroupService#findRelatedByEntityReference(EntityReference,
   * String)}
   */
  @Test
  @DisplayName("Test findRelatedByEntityReference(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.findRelatedByEntityReference(EntityReference, String)"})
  void testFindRelatedByEntityReference4() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.findRelatedByApplicationId(anyLong(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            appGroupService.findRelatedByEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.APPLICATION)
                    .name("Name")
                    .build(),
                "janedoe"));
    verify(appGroupDao).findRelatedByApplicationId(1L, "janedoe");
  }

  /**
   * Test {@link AppGroupService#findRelatedByEntityReference(EntityReference, String)}.
   *
   * <p>Method under test: {@link AppGroupService#findRelatedByEntityReference(EntityReference,
   * String)}
   */
  @Test
  @DisplayName("Test findRelatedByEntityReference(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.findRelatedByEntityReference(EntityReference, String)"})
  void testFindRelatedByEntityReference5() {
    // Arrange
    when(appGroupDao.findRelatedByEntityReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<AppGroup> actualFindRelatedByEntityReferenceResult =
        appGroupService.findRelatedByEntityReference(
            ImmutableAppGroupEntry.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .provenance("Provenance")
                .build(),
            "janedoe");

    // Assert
    verify(appGroupDao).findRelatedByEntityReference(isA(EntityReference.class), eq("janedoe"));
    assertTrue(actualFindRelatedByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#findRelatedByEntityReference(EntityReference, String)}.
   *
   * <p>Method under test: {@link AppGroupService#findRelatedByEntityReference(EntityReference,
   * String)}
   */
  @Test
  @DisplayName("Test findRelatedByEntityReference(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.findRelatedByEntityReference(EntityReference, String)"})
  void testFindRelatedByEntityReference6() {
    // Arrange
    when(appGroupDao.findRelatedByApplicationId(anyLong(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<AppGroup> actualFindRelatedByEntityReferenceResult =
        appGroupService.findRelatedByEntityReference(
            ImmutableAppGroupEntry.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APPLICATION)
                .name("Name")
                .provenance("Provenance")
                .build(),
            "janedoe");

    // Assert
    verify(appGroupDao).findRelatedByApplicationId(1L, "janedoe");
    assertTrue(actualFindRelatedByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Given {@link AppGroupDao} {@link AppGroupDao#search(EntitySearchOptions)} return {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName(
      "Test search(EntitySearchOptions); given AppGroupDao search(EntitySearchOptions) return ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.search(EntitySearchOptions)"})
  void testSearch_givenAppGroupDaoSearchReturnArrayList_thenReturnEmpty() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(new ArrayList<>());
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act
    List<AppGroup> actualSearchResult = appGroupService.search(null);

    // Assert
    verify(appGroupDao).search(isNull());
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.search(EntitySearchOptions)"})
  void testSearch_thenThrowIllegalArgumentException() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.search(Mockito.<EntitySearchOptions>any()))
        .thenThrow(new IllegalArgumentException());
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> appGroupService.search(null));
    verify(appGroupDao).search(isNull());
  }

  /**
   * Test {@link AppGroupService#subscribe(String, long)}.
   *
   * <ul>
   *   <li>Given {@link AppGroupDao} {@link AppGroupDao#getGroup(long)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#subscribe(String, long)}
   */
  @Test
  @DisplayName(
      "Test subscribe(String, long); given AppGroupDao getGroup(long) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupService.subscribe(String, long)"})
  void testSubscribe_givenAppGroupDaoGetGroupThrowIllegalArgumentException() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong())).thenThrow(new IllegalArgumentException());
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> appGroupService.subscribe("42", 1L));
    verify(appGroupDao).getGroup(1L);
  }

  /**
   * Test {@link AppGroupService#subscribe(String, long)}.
   *
   * <ul>
   *   <li>Given {@link AppGroupEntryDao}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#subscribe(String, long)}
   */
  @Test
  @DisplayName("Test subscribe(String, long); given AppGroupEntryDao; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupService.subscribe(String, long)"})
  void testSubscribe_givenAppGroupEntryDao_thenCallsWrite() {
    // Arrange
    when(appGroupDao.getGroup(anyLong()))
        .thenReturn(
            ImmutableAppGroup.builder()
                .appGroupKind(AppGroupKind.PUBLIC)
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> appGroupService.subscribe("42", 1L));
    verify(appGroupDao).getGroup(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link AppGroupService#subscribe(String, long)}.
   *
   * <ul>
   *   <li>Given {@link AppGroupMemberDao} {@link AppGroupMemberDao#register(long, String)} return
   *       one.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#subscribe(String, long)}
   */
  @Test
  @DisplayName(
      "Test subscribe(String, long); given AppGroupMemberDao register(long, String) return one; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupService.subscribe(String, long)"})
  void testSubscribe_givenAppGroupMemberDaoRegisterReturnOne_thenCallsWrite() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong()))
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
    when(appGroupMemberDao.register(anyLong(), Mockito.<String>any())).thenReturn(1);

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

    // Act
    appGroupService.subscribe("42", 1L);

    // Assert
    verify(appGroupDao).getGroup(1L);
    verify(appGroupMemberDao).register(1L, "42");
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
  }

  /**
   * Test {@link AppGroupService#subscribe(String, long)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#subscribe(String, long)}
   */
  @Test
  @DisplayName(
      "Test subscribe(String, long); given ChangeLogService write(ChangeLog) return '19088743'; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupService.subscribe(String, long)"})
  void testSubscribe_givenChangeLogServiceWriteReturn19088743_thenCallsWrite() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong()))
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
    when(appGroupMemberDao.register(anyLong(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
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

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> appGroupService.subscribe("42", 1L));
    verify(appGroupDao).getGroup(1L);
    verify(appGroupMemberDao).register(1L, "42");
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link AppGroupService#subscribe(String, long)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#subscribe(String, long)}
   */
  @Test
  @DisplayName("Test subscribe(String, long); then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupService.subscribe(String, long)"})
  void testSubscribe_thenCallsWrite() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong()))
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
    when(appGroupMemberDao.register(anyLong(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

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

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> appGroupService.subscribe("42", 1L));
    verify(appGroupDao).getGroup(1L);
    verify(appGroupMemberDao).register(1L, "42");
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
  }

  /**
   * Test {@link AppGroupService#unsubscribe(String, long)}.
   *
   * <ul>
   *   <li>Given {@link AppGroupDao} {@link AppGroupDao#getGroup(long)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#unsubscribe(String, long)}
   */
  @Test
  @DisplayName(
      "Test unsubscribe(String, long); given AppGroupDao getGroup(long) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupService.unsubscribe(String, long)"})
  void testUnsubscribe_givenAppGroupDaoGetGroupThrowIllegalArgumentException() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong())).thenThrow(new IllegalArgumentException());
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> appGroupService.unsubscribe("42", 1L));
    verify(appGroupDao).getGroup(1L);
  }

  /**
   * Test {@link AppGroupService#unsubscribe(String, long)}.
   *
   * <ul>
   *   <li>Given {@link AppGroupEntryDao}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#unsubscribe(String, long)}
   */
  @Test
  @DisplayName(
      "Test unsubscribe(String, long); given AppGroupEntryDao; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupService.unsubscribe(String, long)"})
  void testUnsubscribe_givenAppGroupEntryDao_thenCallsWrite() {
    // Arrange
    when(appGroupDao.getGroup(anyLong()))
        .thenReturn(
            ImmutableAppGroup.builder()
                .appGroupKind(AppGroupKind.PUBLIC)
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> appGroupService.unsubscribe("42", 1L));
    verify(appGroupDao).getGroup(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link AppGroupService#unsubscribe(String, long)}.
   *
   * <ul>
   *   <li>Given {@link AppGroupMemberDao} {@link AppGroupMemberDao#unregister(long, String)} return
   *       {@code true}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#unsubscribe(String, long)}
   */
  @Test
  @DisplayName(
      "Test unsubscribe(String, long); given AppGroupMemberDao unregister(long, String) return 'true'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupService.unsubscribe(String, long)"})
  void testUnsubscribe_givenAppGroupMemberDaoUnregisterReturnTrue_thenCallsWrite() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong()))
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
    when(appGroupMemberDao.unregister(anyLong(), Mockito.<String>any())).thenReturn(true);

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

    // Act
    appGroupService.unsubscribe("42", 1L);

    // Assert
    verify(appGroupDao).getGroup(1L);
    verify(appGroupMemberDao).unregister(1L, "42");
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
  }

  /**
   * Test {@link AppGroupService#unsubscribe(String, long)}.
   *
   * <ul>
   *   <li>Given {@link AppGroupMemberDao} {@link AppGroupMemberDao#unregister(long, String)} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#unsubscribe(String, long)}
   */
  @Test
  @DisplayName(
      "Test unsubscribe(String, long); given AppGroupMemberDao unregister(long, String) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupService.unsubscribe(String, long)"})
  void testUnsubscribe_givenAppGroupMemberDaoUnregisterThrowIllegalArgumentException() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong()))
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
    when(appGroupMemberDao.unregister(anyLong(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
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

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> appGroupService.unsubscribe("42", 1L));
    verify(appGroupDao).getGroup(1L);
    verify(appGroupMemberDao).unregister(1L, "42");
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link AppGroupService#deleteGroup(String, long)}.
   *
   * <p>Method under test: {@link AppGroupService#deleteGroup(String, long)}
   */
  @Test
  @DisplayName("Test deleteGroup(String, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AppGroupService.deleteGroup(String, long)"})
  void testDeleteGroup() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.deleteGroup(anyLong())).thenReturn(1);

    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.removeAnyInvolving(Mockito.<EntityReference>any()))
        .thenThrow(new IllegalArgumentException());
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> appGroupService.deleteGroup("42", 1L));
    verify(appGroupDao).deleteGroup(1L);
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(entityRelationshipDao).removeAnyInvolving(isA(EntityReference.class));
  }

  /**
   * Test {@link AppGroupService#deleteGroup(String, long)}.
   *
   * <ul>
   *   <li>Given {@link AppGroupDao} {@link AppGroupDao#deleteGroup(long)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#deleteGroup(String, long)}
   */
  @Test
  @DisplayName(
      "Test deleteGroup(String, long); given AppGroupDao deleteGroup(long) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AppGroupService.deleteGroup(String, long)"})
  void testDeleteGroup_givenAppGroupDaoDeleteGroupThrowIllegalArgumentException()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.deleteGroup(anyLong())).thenThrow(new IllegalArgumentException());

    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> appGroupService.deleteGroup("42", 1L));
    verify(appGroupDao).deleteGroup(1L);
    verify(appGroupMemberDao).canUpdate(1L, "42");
  }

  /**
   * Test {@link AppGroupService#deleteGroup(String, long)}.
   *
   * <ul>
   *   <li>Given {@link AppGroupMemberDao} {@link AppGroupMemberDao#canUpdate(long, String)} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#deleteGroup(String, long)}
   */
  @Test
  @DisplayName(
      "Test deleteGroup(String, long); given AppGroupMemberDao canUpdate(long, String) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AppGroupService.deleteGroup(String, long)"})
  void testDeleteGroup_givenAppGroupMemberDaoCanUpdateThrowIllegalArgumentException()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> appGroupService.deleteGroup("42", 1L));
    verify(appGroupMemberDao).canUpdate(1L, "42");
  }

  /**
   * Test {@link AppGroupService#deleteGroup(String, long)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#deleteGroup(String, long)}
   */
  @Test
  @DisplayName(
      "Test deleteGroup(String, long); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AppGroupService.deleteGroup(String, long)"})
  void testDeleteGroup_givenChangeLogDaoWriteReturn19088743_thenCallsWrite()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.deleteGroup(anyLong())).thenReturn(1);
    when(appGroupDao.findGroupsForUser(Mockito.<String>any())).thenReturn(new ArrayList<>());

    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.getSubscriptions(Mockito.<String>any())).thenReturn(new HashSet<>());
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.removeAnyInvolving(Mockito.<EntityReference>any())).thenReturn(1);

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
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
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

    // Act
    Set<AppGroupSubscription> actualDeleteGroupResult = appGroupService.deleteGroup("42", 1L);

    // Assert
    verify(appGroupDao).deleteGroup(1L);
    verify(appGroupDao).findGroupsForUser("42");
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(appGroupMemberDao).getSubscriptions("42");
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(entityRelationshipDao).removeAnyInvolving(isA(EntityReference.class));
    assertTrue(actualDeleteGroupResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#deleteGroup(String, long)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#deleteGroup(String, long)}
   */
  @Test
  @DisplayName(
      "Test deleteGroup(String, long); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AppGroupService.deleteGroup(String, long)"})
  void testDeleteGroup_givenChangeLogDaoWriteReturn19088743_thenCallsWrite2()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.deleteGroup(anyLong())).thenReturn(1);
    when(appGroupDao.findGroupsForUser(Mockito.<String>any())).thenReturn(new ArrayList<>());

    HashSet<AppGroupMember> appGroupMemberSet = new HashSet<>();
    appGroupMemberSet.add(
        ImmutableAppGroupMember.builder()
            .groupId(1L)
            .role(AppGroupMemberRole.VIEWER)
            .userId("42")
            .build());

    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.getSubscriptions(Mockito.<String>any())).thenReturn(appGroupMemberSet);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.removeAnyInvolving(Mockito.<EntityReference>any())).thenReturn(1);

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
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
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

    // Act
    Set<AppGroupSubscription> actualDeleteGroupResult = appGroupService.deleteGroup("42", 1L);

    // Assert
    verify(appGroupDao).deleteGroup(1L);
    verify(appGroupDao).findGroupsForUser("42");
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(appGroupMemberDao).getSubscriptions("42");
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(entityRelationshipDao).removeAnyInvolving(isA(EntityReference.class));
    assertTrue(actualDeleteGroupResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#deleteGroup(String, long)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#deleteGroup(String, long)}
   */
  @Test
  @DisplayName(
      "Test deleteGroup(String, long); given ChangeLogService write(ChangeLog) return '19088743'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AppGroupService.deleteGroup(String, long)"})
  void testDeleteGroup_givenChangeLogServiceWriteReturn19088743_thenReturnEmpty()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.deleteGroup(anyLong())).thenReturn(1);
    when(appGroupDao.findGroupsForUser(Mockito.<String>any())).thenReturn(new ArrayList<>());

    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.getSubscriptions(Mockito.<String>any())).thenReturn(new HashSet<>());
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.removeAnyInvolving(Mockito.<EntityReference>any())).thenReturn(1);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
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

    // Act
    Set<AppGroupSubscription> actualDeleteGroupResult = appGroupService.deleteGroup("42", 1L);

    // Assert
    verify(appGroupDao).deleteGroup(1L);
    verify(appGroupDao).findGroupsForUser("42");
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(appGroupMemberDao).getSubscriptions("42");
    verify(entityRelationshipDao).removeAnyInvolving(isA(EntityReference.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualDeleteGroupResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#deleteGroup(String, long)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#deleteGroup(String, long)}
   */
  @Test
  @DisplayName(
      "Test deleteGroup(String, long); given ChangeLogService write(ChangeLog) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AppGroupService.deleteGroup(String, long)"})
  void testDeleteGroup_givenChangeLogServiceWriteThrowIllegalArgumentException()
      throws InsufficientPrivelegeException {
    // Arrange
    when(appGroupDao.deleteGroup(anyLong())).thenReturn(1);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    when(entityRelationshipDao.removeAnyInvolving(Mockito.<EntityReference>any())).thenReturn(1);
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> appGroupService.deleteGroup("42", 1L));
    verify(appGroupDao).deleteGroup(1L);
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(entityRelationshipDao).removeAnyInvolving(isA(EntityReference.class));
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link AppGroupService#deleteGroup(String, long)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#deleteGroup(String, long)}
   */
  @Test
  @DisplayName("Test deleteGroup(String, long); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AppGroupService.deleteGroup(String, long)"})
  void testDeleteGroup_thenReturnSizeIsOne() throws InsufficientPrivelegeException {
    // Arrange
    ArrayList<AppGroup> appGroupList = new ArrayList<>();
    appGroupList.add(
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.deleteGroup(anyLong())).thenReturn(1);
    when(appGroupDao.findGroupsForUser(Mockito.<String>any())).thenReturn(appGroupList);

    HashSet<AppGroupMember> appGroupMemberSet = new HashSet<>();
    appGroupMemberSet.add(
        ImmutableAppGroupMember.builder()
            .groupId(1L)
            .role(AppGroupMemberRole.VIEWER)
            .userId("42")
            .build());

    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.getSubscriptions(Mockito.<String>any())).thenReturn(appGroupMemberSet);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.removeAnyInvolving(Mockito.<EntityReference>any())).thenReturn(1);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
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

    // Act
    Set<AppGroupSubscription> actualDeleteGroupResult = appGroupService.deleteGroup("42", 1L);

    // Assert
    verify(appGroupDao).deleteGroup(1L);
    verify(appGroupDao).findGroupsForUser("42");
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(appGroupMemberDao).getSubscriptions("42");
    verify(entityRelationshipDao).removeAnyInvolving(isA(EntityReference.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1, actualDeleteGroupResult.size());
  }

  /**
   * Test {@link AppGroupService#deleteGroup(String, long)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#deleteGroup(String, long)}
   */
  @Test
  @DisplayName("Test deleteGroup(String, long); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AppGroupService.deleteGroup(String, long)"})
  void testDeleteGroup_thenReturnSizeIsOne2() throws InsufficientPrivelegeException {
    // Arrange
    ArrayList<AppGroup> appGroupList = new ArrayList<>();
    appGroupList.add(
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    appGroupList.add(
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.deleteGroup(anyLong())).thenReturn(1);
    when(appGroupDao.findGroupsForUser(Mockito.<String>any())).thenReturn(appGroupList);

    HashSet<AppGroupMember> appGroupMemberSet = new HashSet<>();
    appGroupMemberSet.add(
        ImmutableAppGroupMember.builder()
            .groupId(1L)
            .role(AppGroupMemberRole.VIEWER)
            .userId("42")
            .build());

    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.getSubscriptions(Mockito.<String>any())).thenReturn(appGroupMemberSet);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.removeAnyInvolving(Mockito.<EntityReference>any())).thenReturn(1);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
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

    // Act
    Set<AppGroupSubscription> actualDeleteGroupResult = appGroupService.deleteGroup("42", 1L);

    // Assert
    verify(appGroupDao).deleteGroup(1L);
    verify(appGroupDao).findGroupsForUser("42");
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(appGroupMemberDao).getSubscriptions("42");
    verify(entityRelationshipDao).removeAnyInvolving(isA(EntityReference.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1, actualDeleteGroupResult.size());
  }

  /**
   * Test {@link AppGroupService#deleteGroup(String, long)}.
   *
   * <ul>
   *   <li>Then throw {@link InsufficientPrivelegeException}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#deleteGroup(String, long)}
   */
  @Test
  @DisplayName("Test deleteGroup(String, long); then throw InsufficientPrivelegeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AppGroupService.deleteGroup(String, long)"})
  void testDeleteGroup_thenThrowInsufficientPrivelegeException()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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
            mock(ChangeLogService.class));

    // Act and Assert
    assertThrows(InsufficientPrivelegeException.class, () -> appGroupService.deleteGroup("42", 1L));
    verify(appGroupMemberDao).canUpdate(1L, "42");
  }

  /**
   * Test {@link AppGroupService#addApplication(String, long, long)}.
   *
   * <p>Method under test: {@link AppGroupService#addApplication(String, long, long)}
   */
  @Test
  @DisplayName("Test addApplication(String, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addApplication(String, long, long)"})
  void testAddApplication() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.addApplication(anyLong(), anyLong()))
        .thenThrow(new IllegalArgumentException());

    ApplicationDao applicationDao = mock(ApplicationDao.class);

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
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
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> appGroupService.addApplication("42", 1L, 1L));
    verify(appGroupEntryDao).addApplication(1L, 1L);
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(applicationDao).getById(1L);
  }

  /**
   * Test {@link AppGroupService#addApplication(String, long, long)}.
   *
   * <ul>
   *   <li>Given {@link AppGroupMemberDao} {@link AppGroupMemberDao#canUpdate(long, String)} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#addApplication(String, long, long)}
   */
  @Test
  @DisplayName(
      "Test addApplication(String, long, long); given AppGroupMemberDao canUpdate(long, String) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addApplication(String, long, long)"})
  void testAddApplication_givenAppGroupMemberDaoCanUpdateThrowIllegalArgumentException()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> appGroupService.addApplication("42", 1L, 1L));
    verify(appGroupMemberDao).canUpdate(1L, "42");
  }

  /**
   * Test {@link AppGroupService#addApplication(String, long, long)}.
   *
   * <ul>
   *   <li>Given {@link ApplicationDao} {@link ApplicationDao#getById(long)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#addApplication(String, long, long)}
   */
  @Test
  @DisplayName(
      "Test addApplication(String, long, long); given ApplicationDao getById(long) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addApplication(String, long, long)"})
  void testAddApplication_givenApplicationDaoGetByIdThrowIllegalArgumentException()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.getById(anyLong())).thenThrow(new IllegalArgumentException());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> appGroupService.addApplication("42", 1L, 1L));
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(applicationDao).getById(1L);
  }

  /**
   * Test {@link AppGroupService#addApplication(String, long, long)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>When {@code 42}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#addApplication(String, long, long)}
   */
  @Test
  @DisplayName(
      "Test addApplication(String, long, long); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; when '42'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addApplication(String, long, long)"})
  void testAddApplication_givenChangeLogDaoWriteReturn19088743_when42_thenCallsWrite()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.addApplication(anyLong(), anyLong())).thenReturn(2);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    ApplicationDao applicationDao = mock(ApplicationDao.class);

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
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

    // Act
    List<AppGroupEntry> actualAddApplicationResult = appGroupService.addApplication("42", 1L, 1L);

    // Assert
    verify(appGroupEntryDao).addApplication(1L, 1L);
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(applicationDao).getById(1L);
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    assertTrue(actualAddApplicationResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#addApplication(String, long, long)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#addApplication(String, long, long)}
   */
  @Test
  @DisplayName(
      "Test addApplication(String, long, long); given ChangeLogService write(ChangeLog) return '19088743'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addApplication(String, long, long)"})
  void testAddApplication_givenChangeLogServiceWriteReturn19088743_thenReturnEmpty()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.addApplication(anyLong(), anyLong())).thenReturn(2);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    ApplicationDao applicationDao = mock(ApplicationDao.class);

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
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

    // Act
    List<AppGroupEntry> actualAddApplicationResult = appGroupService.addApplication("42", 1L, 1L);

    // Assert
    verify(appGroupEntryDao).addApplication(1L, 1L);
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(applicationDao).getById(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualAddApplicationResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#addApplication(String, long, long)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#addApplication(String, long, long)}
   */
  @Test
  @DisplayName(
      "Test addApplication(String, long, long); given ChangeLogService write(ChangeLog) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addApplication(String, long, long)"})
  void testAddApplication_givenChangeLogServiceWriteThrowIllegalArgumentException()
      throws InsufficientPrivelegeException {
    // Arrange
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    when(appGroupEntryDao.addApplication(anyLong(), anyLong())).thenReturn(2);

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
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
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> appGroupService.addApplication("42", 1L, 1L));
    verify(appGroupEntryDao).addApplication(1L, 1L);
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(applicationDao).getById(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link AppGroupService#addApplication(String, long, long)}.
   *
   * <ul>
   *   <li>Then throw {@link InsufficientPrivelegeException}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#addApplication(String, long, long)}
   */
  @Test
  @DisplayName("Test addApplication(String, long, long); then throw InsufficientPrivelegeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addApplication(String, long, long)"})
  void testAddApplication_thenThrowInsufficientPrivelegeException()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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
            mock(ChangeLogService.class));

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class, () -> appGroupService.addApplication("42", 1L, 1L));
    verify(appGroupMemberDao).canUpdate(1L, "42");
  }

  /**
   * Test {@link AppGroupService#addApplications(String, long, Collection, Collection)}.
   *
   * <p>Method under test: {@link AppGroupService#addApplications(String, long, Collection,
   * Collection)}
   */
  @Test
  @DisplayName("Test addApplications(String, long, Collection, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addApplications(String, long, Collection, Collection)"})
  void testAddApplications() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.addApplications(anyLong(), Mockito.<Collection<Long>>any()))
        .thenThrow(new IllegalArgumentException());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);
    ArrayList<Long> applicationIds = new ArrayList<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> appGroupService.addApplications("42", 1L, applicationIds, new ArrayList<>()));
    verify(appGroupEntryDao).addApplications(eq(1L), isA(Collection.class));
    verify(appGroupMemberDao).canUpdate(1L, "42");
  }

  /**
   * Test {@link AppGroupService#addApplications(String, long, Collection, Collection)}.
   *
   * <p>Method under test: {@link AppGroupService#addApplications(String, long, Collection,
   * Collection)}
   */
  @Test
  @DisplayName("Test addApplications(String, long, Collection, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addApplications(String, long, Collection, Collection)"})
  void testAddApplications2() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.addApplications(anyLong(), Mockito.<Collection<Long>>any()))
        .thenReturn(new int[] {2, 1, 2, 1});
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    ArrayList<Application> applicationList = new ArrayList<>();

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
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
    applicationList.add(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(applicationList);

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
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
    ArrayList<Long> applicationIds = new ArrayList<>();

    // Act
    List<AppGroupEntry> actualAddApplicationsResult =
        appGroupService.addApplications("42", 1L, applicationIds, new ArrayList<>());

    // Assert
    verify(appGroupEntryDao).addApplications(eq(1L), isA(Collection.class));
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(applicationDao).findByIds(isA(Collection.class));
    verify(changeLogDao).write(isA(Collection.class));
    assertTrue(actualAddApplicationsResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#addApplications(String, long, Collection, Collection)}.
   *
   * <p>Method under test: {@link AppGroupService#addApplications(String, long, Collection,
   * Collection)}
   */
  @Test
  @DisplayName("Test addApplications(String, long, Collection, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addApplications(String, long, Collection, Collection)"})
  void testAddApplications3() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.addApplications(anyLong(), Mockito.<Collection<Long>>any()))
        .thenReturn(new int[] {2, 1, 2, 1});
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    ArrayList<Application> applicationList = new ArrayList<>();

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
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
    applicationList.add(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());

    ImmutableApplication.Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
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
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));
    applicationList.add(
        overallRatingResult2
            .parentAssetCode(parentAssetCode2)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(applicationList);

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
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
    ArrayList<Long> applicationIds = new ArrayList<>();

    // Act
    List<AppGroupEntry> actualAddApplicationsResult =
        appGroupService.addApplications("42", 1L, applicationIds, new ArrayList<>());

    // Assert
    verify(appGroupEntryDao).addApplications(eq(1L), isA(Collection.class));
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(applicationDao).findByIds(isA(Collection.class));
    verify(changeLogDao).write(isA(Collection.class));
    assertTrue(actualAddApplicationsResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#addApplications(String, long, Collection, Collection)}.
   *
   * <ul>
   *   <li>Given {@link AppGroupDao}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#addApplications(String, long, Collection,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test addApplications(String, long, Collection, Collection); given AppGroupDao; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addApplications(String, long, Collection, Collection)"})
  void testAddApplications_givenAppGroupDao_thenThrowIllegalArgumentException()
      throws InsufficientPrivelegeException {
    // Arrange
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    when(appGroupEntryDao.addApplications(anyLong(), Mockito.<Collection<Long>>any()))
        .thenReturn(new int[] {2, 1, 2, 1});
    when(applicationDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenThrow(new IllegalArgumentException());
    ArrayList<Long> applicationIds = new ArrayList<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> appGroupService.addApplications("42", 1L, applicationIds, new ArrayList<>()));
    verify(appGroupEntryDao).addApplications(eq(1L), isA(Collection.class));
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(applicationDao).findByIds(isA(Collection.class));
    verify(changeLogService).write(isA(Collection.class));
  }

  /**
   * Test {@link AppGroupService#addApplications(String, long, Collection, Collection)}.
   *
   * <ul>
   *   <li>Given {@link AppGroupMemberDao} {@link AppGroupMemberDao#canUpdate(long, String)} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#addApplications(String, long, Collection,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test addApplications(String, long, Collection, Collection); given AppGroupMemberDao canUpdate(long, String) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addApplications(String, long, Collection, Collection)"})
  void testAddApplications_givenAppGroupMemberDaoCanUpdateThrowIllegalArgumentException()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);
    ArrayList<Long> applicationIds = new ArrayList<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> appGroupService.addApplications("42", 1L, applicationIds, new ArrayList<>()));
    verify(appGroupMemberDao).canUpdate(1L, "42");
  }

  /**
   * Test {@link AppGroupService#addApplications(String, long, Collection, Collection)}.
   *
   * <ul>
   *   <li>Given {@link ApplicationDao} {@link ApplicationDao#findByIds(Collection)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#addApplications(String, long, Collection,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test addApplications(String, long, Collection, Collection); given ApplicationDao findByIds(Collection) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addApplications(String, long, Collection, Collection)"})
  void testAddApplications_givenApplicationDaoFindByIdsThrowIllegalArgumentException()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.addApplications(anyLong(), Mockito.<Collection<Long>>any()))
        .thenReturn(new int[] {2, 1, 2, 1});

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByIds(Mockito.<Collection<Long>>any()))
        .thenThrow(new IllegalArgumentException());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);
    ArrayList<Long> applicationIds = new ArrayList<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> appGroupService.addApplications("42", 1L, applicationIds, new ArrayList<>()));
    verify(appGroupEntryDao).addApplications(eq(1L), isA(Collection.class));
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(applicationDao).findByIds(isA(Collection.class));
  }

  /**
   * Test {@link AppGroupService#addApplications(String, long, Collection, Collection)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(Collection)} return array of
   *       {@code int} with {@code 19088743} and one.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#addApplications(String, long, Collection,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test addApplications(String, long, Collection, Collection); given ChangeLogService write(Collection) return array of int with '19088743' and one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addApplications(String, long, Collection, Collection)"})
  void testAddApplications_givenChangeLogServiceWriteReturnArrayOfIntWith19088743AndOne()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.addApplications(anyLong(), Mockito.<Collection<Long>>any()))
        .thenReturn(new int[] {2, 1, 2, 1});
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
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
    ArrayList<Long> applicationIds = new ArrayList<>();

    // Act
    List<AppGroupEntry> actualAddApplicationsResult =
        appGroupService.addApplications("42", 1L, applicationIds, new ArrayList<>());

    // Assert
    verify(appGroupEntryDao).addApplications(eq(1L), isA(Collection.class));
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(applicationDao).findByIds(isA(Collection.class));
    verify(changeLogService).write(isA(Collection.class));
    assertTrue(actualAddApplicationsResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#addApplications(String, long, Collection, Collection)}.
   *
   * <ul>
   *   <li>Given {@code entityLifecycleStatus}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#addApplications(String, long, Collection,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test addApplications(String, long, Collection, Collection); given 'entityLifecycleStatus'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addApplications(String, long, Collection, Collection)"})
  void testAddApplications_givenEntityLifecycleStatus() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.addApplications(anyLong(), Mockito.<Collection<Long>>any()))
        .thenReturn(new int[] {2, 1, 2, 1});
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
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
    ArrayList<Long> applicationIds = new ArrayList<>();

    ArrayList<String> unknownIdentifiers = new ArrayList<>();
    unknownIdentifiers.add("entityLifecycleStatus");
    unknownIdentifiers.add("kind");

    // Act
    List<AppGroupEntry> actualAddApplicationsResult =
        appGroupService.addApplications("42", 1L, applicationIds, unknownIdentifiers);

    // Assert
    verify(appGroupEntryDao).addApplications(eq(1L), isA(Collection.class));
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(applicationDao).findByIds(isA(Collection.class));
    verify(changeLogDao).write(isA(Collection.class));
    assertTrue(actualAddApplicationsResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#addApplications(String, long, Collection, Collection)}.
   *
   * <ul>
   *   <li>Given {@code kind}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code kind}.
   *   <li>Then calls {@link ChangeLogDao#write(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#addApplications(String, long, Collection,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test addApplications(String, long, Collection, Collection); given 'kind'; when ArrayList() add 'kind'; then calls write(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addApplications(String, long, Collection, Collection)"})
  void testAddApplications_givenKind_whenArrayListAddKind_thenCallsWrite()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.addApplications(anyLong(), Mockito.<Collection<Long>>any()))
        .thenReturn(new int[] {2, 1, 2, 1});
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
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
    ArrayList<Long> applicationIds = new ArrayList<>();

    ArrayList<String> unknownIdentifiers = new ArrayList<>();
    unknownIdentifiers.add("kind");

    // Act
    List<AppGroupEntry> actualAddApplicationsResult =
        appGroupService.addApplications("42", 1L, applicationIds, unknownIdentifiers);

    // Assert
    verify(appGroupEntryDao).addApplications(eq(1L), isA(Collection.class));
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(applicationDao).findByIds(isA(Collection.class));
    verify(changeLogDao).write(isA(Collection.class));
    assertTrue(actualAddApplicationsResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#addApplications(String, long, Collection, Collection)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   *   <li>Then calls {@link ChangeLogService#write(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#addApplications(String, long, Collection,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test addApplications(String, long, Collection, Collection); given one; when ArrayList() add one; then calls write(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addApplications(String, long, Collection, Collection)"})
  void testAddApplications_givenOne_whenArrayListAddOne_thenCallsWrite()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.addApplications(anyLong(), Mockito.<Collection<Long>>any()))
        .thenReturn(new int[] {2, 1, 2, 1});
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
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

    ArrayList<Long> applicationIds = new ArrayList<>();
    applicationIds.add(1L);

    // Act
    List<AppGroupEntry> actualAddApplicationsResult =
        appGroupService.addApplications("42", 1L, applicationIds, new ArrayList<>());

    // Assert
    verify(appGroupEntryDao).addApplications(eq(1L), isA(Collection.class));
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(applicationDao).findByIds(isA(Collection.class));
    verify(changeLogService).write(isA(Collection.class));
    assertTrue(actualAddApplicationsResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#addApplications(String, long, Collection, Collection)}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>When {@link ArrayList#ArrayList()} add three.
   *   <li>Then calls {@link ChangeLogService#write(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#addApplications(String, long, Collection,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test addApplications(String, long, Collection, Collection); given three; when ArrayList() add three; then calls write(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addApplications(String, long, Collection, Collection)"})
  void testAddApplications_givenThree_whenArrayListAddThree_thenCallsWrite()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.addApplications(anyLong(), Mockito.<Collection<Long>>any()))
        .thenReturn(new int[] {2, 1, 2, 1});
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
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

    ArrayList<Long> applicationIds = new ArrayList<>();
    applicationIds.add(3L);
    applicationIds.add(1L);

    // Act
    List<AppGroupEntry> actualAddApplicationsResult =
        appGroupService.addApplications("42", 1L, applicationIds, new ArrayList<>());

    // Assert
    verify(appGroupEntryDao).addApplications(eq(1L), isA(Collection.class));
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(applicationDao).findByIds(isA(Collection.class));
    verify(changeLogService).write(isA(Collection.class));
    assertTrue(actualAddApplicationsResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#addApplications(String, long, Collection, Collection)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogDao#write(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#addApplications(String, long, Collection,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test addApplications(String, long, Collection, Collection); then calls write(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addApplications(String, long, Collection, Collection)"})
  void testAddApplications_thenCallsWrite() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.addApplications(anyLong(), Mockito.<Collection<Long>>any()))
        .thenReturn(new int[] {2, 1, 2, 1});
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
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
    ArrayList<Long> applicationIds = new ArrayList<>();

    // Act
    List<AppGroupEntry> actualAddApplicationsResult =
        appGroupService.addApplications("42", 1L, applicationIds, new ArrayList<>());

    // Assert
    verify(appGroupEntryDao).addApplications(eq(1L), isA(Collection.class));
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(applicationDao).findByIds(isA(Collection.class));
    verify(changeLogDao).write(isA(Collection.class));
    assertTrue(actualAddApplicationsResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#addApplications(String, long, Collection, Collection)}.
   *
   * <ul>
   *   <li>Then throw {@link InsufficientPrivelegeException}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#addApplications(String, long, Collection,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test addApplications(String, long, Collection, Collection); then throw InsufficientPrivelegeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addApplications(String, long, Collection, Collection)"})
  void testAddApplications_thenThrowInsufficientPrivelegeException()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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
            mock(ChangeLogService.class));
    ArrayList<Long> applicationIds = new ArrayList<>();

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class,
        () -> appGroupService.addApplications("42", 1L, applicationIds, new ArrayList<>()));
    verify(appGroupMemberDao).canUpdate(1L, "42");
  }

  /**
   * Test {@link AppGroupService#removeApplication(String, long, long)}.
   *
   * <p>Method under test: {@link AppGroupService#removeApplication(String, long, long)}
   */
  @Test
  @DisplayName("Test removeApplication(String, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeApplication(String, long, long)"})
  void testRemoveApplication() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> appGroupService.removeApplication("42", 1L, 1L));
    verify(appGroupMemberDao).canUpdate(1L, "42");
  }

  /**
   * Test {@link AppGroupService#removeApplication(String, long, long)}.
   *
   * <p>Method under test: {@link AppGroupService#removeApplication(String, long, long)}
   */
  @Test
  @DisplayName("Test removeApplication(String, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeApplication(String, long, long)"})
  void testRemoveApplication2() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.removeApplication(anyLong(), anyLong()))
        .thenThrow(new IllegalArgumentException());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> appGroupService.removeApplication("42", 1L, 1L));
    verify(appGroupEntryDao).removeApplication(1L, 1L);
    verify(appGroupMemberDao).canUpdate(1L, "42");
  }

  /**
   * Test {@link AppGroupService#removeApplication(String, long, long)}.
   *
   * <ul>
   *   <li>Given {@link ApplicationDao} {@link ApplicationDao#getById(long)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#removeApplication(String, long, long)}
   */
  @Test
  @DisplayName(
      "Test removeApplication(String, long, long); given ApplicationDao getById(long) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeApplication(String, long, long)"})
  void testRemoveApplication_givenApplicationDaoGetByIdThrowIllegalArgumentException()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.removeApplication(anyLong(), anyLong())).thenReturn(1);

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.getById(anyLong())).thenThrow(new IllegalArgumentException());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> appGroupService.removeApplication("42", 1L, 1L));
    verify(appGroupEntryDao).removeApplication(1L, 1L);
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(applicationDao).getById(1L);
  }

  /**
   * Test {@link AppGroupService#removeApplication(String, long, long)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>When {@code 42}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#removeApplication(String, long, long)}
   */
  @Test
  @DisplayName(
      "Test removeApplication(String, long, long); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; when '42'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeApplication(String, long, long)"})
  void testRemoveApplication_givenChangeLogDaoWriteReturn19088743_when42_thenCallsWrite()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.removeApplication(anyLong(), anyLong())).thenReturn(1);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    ApplicationDao applicationDao = mock(ApplicationDao.class);

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
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

    // Act
    List<AppGroupEntry> actualRemoveApplicationResult =
        appGroupService.removeApplication("42", 1L, 1L);

    // Assert
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupEntryDao).removeApplication(1L, 1L);
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(applicationDao).getById(1L);
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    assertTrue(actualRemoveApplicationResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#removeApplication(String, long, long)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#removeApplication(String, long, long)}
   */
  @Test
  @DisplayName(
      "Test removeApplication(String, long, long); given ChangeLogService write(ChangeLog) return '19088743'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeApplication(String, long, long)"})
  void testRemoveApplication_givenChangeLogServiceWriteReturn19088743_thenReturnEmpty()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.removeApplication(anyLong(), anyLong())).thenReturn(1);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    ApplicationDao applicationDao = mock(ApplicationDao.class);

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
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

    // Act
    List<AppGroupEntry> actualRemoveApplicationResult =
        appGroupService.removeApplication("42", 1L, 1L);

    // Assert
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupEntryDao).removeApplication(1L, 1L);
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(applicationDao).getById(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualRemoveApplicationResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#removeApplication(String, long, long)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#removeApplication(String, long, long)}
   */
  @Test
  @DisplayName(
      "Test removeApplication(String, long, long); given ChangeLogService write(ChangeLog) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeApplication(String, long, long)"})
  void testRemoveApplication_givenChangeLogServiceWriteThrowIllegalArgumentException()
      throws InsufficientPrivelegeException {
    // Arrange
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    when(appGroupEntryDao.removeApplication(anyLong(), anyLong())).thenReturn(1);

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
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
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> appGroupService.removeApplication("42", 1L, 1L));
    verify(appGroupEntryDao).removeApplication(1L, 1L);
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(applicationDao).getById(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link AppGroupService#removeApplication(String, long, long)}.
   *
   * <ul>
   *   <li>Then throw {@link InsufficientPrivelegeException}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#removeApplication(String, long, long)}
   */
  @Test
  @DisplayName(
      "Test removeApplication(String, long, long); then throw InsufficientPrivelegeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeApplication(String, long, long)"})
  void testRemoveApplication_thenThrowInsufficientPrivelegeException()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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
            mock(ChangeLogService.class));

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class,
        () -> appGroupService.removeApplication("42", 1L, 1L));
    verify(appGroupMemberDao).canUpdate(1L, "42");
  }

  /**
   * Test {@link AppGroupService#addOrganisationalUnit(String, long, long)}.
   *
   * <p>Method under test: {@link AppGroupService#addOrganisationalUnit(String, long, long)}
   */
  @Test
  @DisplayName("Test addOrganisationalUnit(String, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addOrganisationalUnit(String, long, long)"})
  void testAddOrganisationalUnit() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> appGroupService.addOrganisationalUnit("42", 1L, 1L));
    verify(appGroupMemberDao).canUpdate(1L, "42");
  }

  /**
   * Test {@link AppGroupService#addOrganisationalUnit(String, long, long)}.
   *
   * <p>Method under test: {@link AppGroupService#addOrganisationalUnit(String, long, long)}
   */
  @Test
  @DisplayName("Test addOrganisationalUnit(String, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addOrganisationalUnit(String, long, long)"})
  void testAddOrganisationalUnit2() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    when(organisationalUnitDao.getById(anyLong())).thenThrow(new IllegalArgumentException());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> appGroupService.addOrganisationalUnit("42", 1L, 1L));
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(organisationalUnitDao).getById(1L);
  }

  /**
   * Test {@link AppGroupService#addOrganisationalUnit(String, long, long)}.
   *
   * <p>Method under test: {@link AppGroupService#addOrganisationalUnit(String, long, long)}
   */
  @Test
  @DisplayName("Test addOrganisationalUnit(String, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addOrganisationalUnit(String, long, long)"})
  void testAddOrganisationalUnit3() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.addOrgUnit(anyLong(), anyLong()))
        .thenThrow(new IllegalArgumentException());

    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    when(organisationalUnitDao.getById(anyLong()))
        .thenReturn(
            ImmutableOrganisationalUnit.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> appGroupService.addOrganisationalUnit("42", 1L, 1L));
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(appGroupOrganisationalUnitDao).addOrgUnit(1L, 1L);
    verify(organisationalUnitDao).getById(1L);
  }

  /**
   * Test {@link AppGroupService#addOrganisationalUnit(String, long, long)}.
   *
   * <p>Method under test: {@link AppGroupService#addOrganisationalUnit(String, long, long)}
   */
  @Test
  @DisplayName("Test addOrganisationalUnit(String, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addOrganisationalUnit(String, long, long)"})
  void testAddOrganisationalUnit4() throws InsufficientPrivelegeException {
    // Arrange
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    when(appGroupOrganisationalUnitDao.addOrgUnit(anyLong(), anyLong())).thenReturn(2);
    when(organisationalUnitDao.getById(anyLong()))
        .thenReturn(
            ImmutableOrganisationalUnit.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> appGroupService.addOrganisationalUnit("42", 1L, 1L));
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(appGroupOrganisationalUnitDao).addOrgUnit(1L, 1L);
    verify(organisationalUnitDao).getById(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link AppGroupService#addOrganisationalUnit(String, long, long)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#addOrganisationalUnit(String, long, long)}
   */
  @Test
  @DisplayName(
      "Test addOrganisationalUnit(String, long, long); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addOrganisationalUnit(String, long, long)"})
  void testAddOrganisationalUnit_givenChangeLogDaoWriteReturn19088743_thenCallsWrite()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.addOrgUnit(anyLong(), anyLong())).thenReturn(2);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    when(organisationalUnitDao.getById(anyLong()))
        .thenReturn(
            ImmutableOrganisationalUnit.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
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
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
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

    // Act
    List<AppGroupEntry> actualAddOrganisationalUnitResult =
        appGroupService.addOrganisationalUnit("42", 1L, 1L);

    // Assert
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(appGroupOrganisationalUnitDao).addOrgUnit(1L, 1L);
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(1L);
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(organisationalUnitDao).getById(1L);
    assertTrue(actualAddOrganisationalUnitResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#addOrganisationalUnit(String, long, long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#addOrganisationalUnit(String, long, long)}
   */
  @Test
  @DisplayName("Test addOrganisationalUnit(String, long, long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addOrganisationalUnit(String, long, long)"})
  void testAddOrganisationalUnit_thenReturnEmpty() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.addOrgUnit(anyLong(), anyLong())).thenReturn(2);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    when(organisationalUnitDao.getById(anyLong()))
        .thenReturn(
            ImmutableOrganisationalUnit.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
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

    // Act
    List<AppGroupEntry> actualAddOrganisationalUnitResult =
        appGroupService.addOrganisationalUnit("42", 1L, 1L);

    // Assert
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(appGroupOrganisationalUnitDao).addOrgUnit(1L, 1L);
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(1L);
    verify(organisationalUnitDao).getById(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualAddOrganisationalUnitResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#addOrganisationalUnit(String, long, long)}.
   *
   * <ul>
   *   <li>Then throw {@link InsufficientPrivelegeException}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#addOrganisationalUnit(String, long, long)}
   */
  @Test
  @DisplayName(
      "Test addOrganisationalUnit(String, long, long); then throw InsufficientPrivelegeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addOrganisationalUnit(String, long, long)"})
  void testAddOrganisationalUnit_thenThrowInsufficientPrivelegeException()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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
            mock(ChangeLogService.class));

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class,
        () -> appGroupService.addOrganisationalUnit("42", 1L, 1L));
    verify(appGroupMemberDao).canUpdate(1L, "42");
  }

  /**
   * Test {@link AppGroupService#removeOrganisationalUnit(String, long, long)}.
   *
   * <p>Method under test: {@link AppGroupService#removeOrganisationalUnit(String, long, long)}
   */
  @Test
  @DisplayName("Test removeOrganisationalUnit(String, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeOrganisationalUnit(String, long, long)"})
  void testRemoveOrganisationalUnit() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> appGroupService.removeOrganisationalUnit("42", 1L, 1L));
    verify(appGroupMemberDao).canUpdate(1L, "42");
  }

  /**
   * Test {@link AppGroupService#removeOrganisationalUnit(String, long, long)}.
   *
   * <p>Method under test: {@link AppGroupService#removeOrganisationalUnit(String, long, long)}
   */
  @Test
  @DisplayName("Test removeOrganisationalUnit(String, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeOrganisationalUnit(String, long, long)"})
  void testRemoveOrganisationalUnit2() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.removeOrgUnit(anyLong(), anyLong()))
        .thenThrow(new IllegalArgumentException());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> appGroupService.removeOrganisationalUnit("42", 1L, 1L));
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(appGroupOrganisationalUnitDao).removeOrgUnit(1L, 1L);
  }

  /**
   * Test {@link AppGroupService#removeOrganisationalUnit(String, long, long)}.
   *
   * <p>Method under test: {@link AppGroupService#removeOrganisationalUnit(String, long, long)}
   */
  @Test
  @DisplayName("Test removeOrganisationalUnit(String, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeOrganisationalUnit(String, long, long)"})
  void testRemoveOrganisationalUnit3() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.removeOrgUnit(anyLong(), anyLong())).thenReturn(1);

    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    when(organisationalUnitDao.getById(anyLong())).thenThrow(new IllegalArgumentException());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> appGroupService.removeOrganisationalUnit("42", 1L, 1L));
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(appGroupOrganisationalUnitDao).removeOrgUnit(1L, 1L);
    verify(organisationalUnitDao).getById(1L);
  }

  /**
   * Test {@link AppGroupService#removeOrganisationalUnit(String, long, long)}.
   *
   * <p>Method under test: {@link AppGroupService#removeOrganisationalUnit(String, long, long)}
   */
  @Test
  @DisplayName("Test removeOrganisationalUnit(String, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeOrganisationalUnit(String, long, long)"})
  void testRemoveOrganisationalUnit4() throws InsufficientPrivelegeException {
    // Arrange
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    when(appGroupOrganisationalUnitDao.removeOrgUnit(anyLong(), anyLong())).thenReturn(1);
    when(organisationalUnitDao.getById(anyLong()))
        .thenReturn(
            ImmutableOrganisationalUnit.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> appGroupService.removeOrganisationalUnit("42", 1L, 1L));
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(appGroupOrganisationalUnitDao).removeOrgUnit(1L, 1L);
    verify(organisationalUnitDao).getById(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link AppGroupService#removeOrganisationalUnit(String, long, long)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#removeOrganisationalUnit(String, long, long)}
   */
  @Test
  @DisplayName(
      "Test removeOrganisationalUnit(String, long, long); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeOrganisationalUnit(String, long, long)"})
  void testRemoveOrganisationalUnit_givenChangeLogDaoWriteReturn19088743_thenCallsWrite()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.removeOrgUnit(anyLong(), anyLong())).thenReturn(1);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    when(organisationalUnitDao.getById(anyLong()))
        .thenReturn(
            ImmutableOrganisationalUnit.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
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
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
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

    // Act
    List<AppGroupEntry> actualRemoveOrganisationalUnitResult =
        appGroupService.removeOrganisationalUnit("42", 1L, 1L);

    // Assert
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(1L);
    verify(appGroupOrganisationalUnitDao).removeOrgUnit(1L, 1L);
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(organisationalUnitDao).getById(1L);
    assertTrue(actualRemoveOrganisationalUnitResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#removeOrganisationalUnit(String, long, long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#removeOrganisationalUnit(String, long, long)}
   */
  @Test
  @DisplayName("Test removeOrganisationalUnit(String, long, long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeOrganisationalUnit(String, long, long)"})
  void testRemoveOrganisationalUnit_thenReturnEmpty() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.removeOrgUnit(anyLong(), anyLong())).thenReturn(1);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    when(organisationalUnitDao.getById(anyLong()))
        .thenReturn(
            ImmutableOrganisationalUnit.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
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

    // Act
    List<AppGroupEntry> actualRemoveOrganisationalUnitResult =
        appGroupService.removeOrganisationalUnit("42", 1L, 1L);

    // Assert
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(1L);
    verify(appGroupOrganisationalUnitDao).removeOrgUnit(1L, 1L);
    verify(organisationalUnitDao).getById(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualRemoveOrganisationalUnitResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#removeOrganisationalUnit(String, long, long)}.
   *
   * <ul>
   *   <li>Then throw {@link InsufficientPrivelegeException}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#removeOrganisationalUnit(String, long, long)}
   */
  @Test
  @DisplayName(
      "Test removeOrganisationalUnit(String, long, long); then throw InsufficientPrivelegeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeOrganisationalUnit(String, long, long)"})
  void testRemoveOrganisationalUnit_thenThrowInsufficientPrivelegeException()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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
            mock(ChangeLogService.class));

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class,
        () -> appGroupService.removeOrganisationalUnit("42", 1L, 1L));
    verify(appGroupMemberDao).canUpdate(1L, "42");
  }

  /**
   * Test {@link AppGroupService#removeApplications(String, long, List)}.
   *
   * <p>Method under test: {@link AppGroupService#removeApplications(String, long, List)}
   */
  @Test
  @DisplayName("Test removeApplications(String, long, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeApplications(String, long, List)"})
  void testRemoveApplications() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> appGroupService.removeApplications("42", 1L, new ArrayList<>()));
    verify(appGroupMemberDao).canUpdate(1L, "42");
  }

  /**
   * Test {@link AppGroupService#removeApplications(String, long, List)}.
   *
   * <p>Method under test: {@link AppGroupService#removeApplications(String, long, List)}
   */
  @Test
  @DisplayName("Test removeApplications(String, long, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeApplications(String, long, List)"})
  void testRemoveApplications2() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.removeApplications(anyLong(), Mockito.<List<Long>>any()))
        .thenThrow(new IllegalArgumentException());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> appGroupService.removeApplications("42", 1L, new ArrayList<>()));
    verify(appGroupEntryDao).removeApplications(eq(1L), isA(List.class));
    verify(appGroupMemberDao).canUpdate(1L, "42");
  }

  /**
   * Test {@link AppGroupService#removeApplications(String, long, List)}.
   *
   * <p>Method under test: {@link AppGroupService#removeApplications(String, long, List)}
   */
  @Test
  @DisplayName("Test removeApplications(String, long, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeApplications(String, long, List)"})
  void testRemoveApplications3() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.removeApplications(anyLong(), Mockito.<List<Long>>any())).thenReturn(1);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    ArrayList<Application> applicationList = new ArrayList<>();

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
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
    applicationList.add(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(applicationList);

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
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

    // Act
    List<AppGroupEntry> actualRemoveApplicationsResult =
        appGroupService.removeApplications("42", 1L, new ArrayList<>());

    // Assert
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupEntryDao).removeApplications(eq(1L), isA(List.class));
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(applicationDao).findByIds(isA(Collection.class));
    verify(changeLogDao).write(isA(Collection.class));
    assertTrue(actualRemoveApplicationsResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#removeApplications(String, long, List)}.
   *
   * <p>Method under test: {@link AppGroupService#removeApplications(String, long, List)}
   */
  @Test
  @DisplayName("Test removeApplications(String, long, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeApplications(String, long, List)"})
  void testRemoveApplications4() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.removeApplications(anyLong(), Mockito.<List<Long>>any())).thenReturn(1);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    ArrayList<Application> applicationList = new ArrayList<>();

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
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
    applicationList.add(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());

    ImmutableApplication.Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
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
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));
    applicationList.add(
        overallRatingResult2
            .parentAssetCode(parentAssetCode2)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(applicationList);

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
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

    // Act
    List<AppGroupEntry> actualRemoveApplicationsResult =
        appGroupService.removeApplications("42", 1L, new ArrayList<>());

    // Assert
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupEntryDao).removeApplications(eq(1L), isA(List.class));
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(applicationDao).findByIds(isA(Collection.class));
    verify(changeLogDao).write(isA(Collection.class));
    assertTrue(actualRemoveApplicationsResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#removeApplications(String, long, List)}.
   *
   * <p>Method under test: {@link AppGroupService#removeApplications(String, long, List)}
   */
  @Test
  @DisplayName("Test removeApplications(String, long, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeApplications(String, long, List)"})
  void testRemoveApplications5() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.removeApplications(anyLong(), Mockito.<List<Long>>any())).thenReturn(1);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
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

    // Act
    List<AppGroupEntry> actualRemoveApplicationsResult =
        appGroupService.removeApplications("42", 1L, new ArrayList<>());

    // Assert
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupEntryDao).removeApplications(eq(1L), isA(List.class));
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(applicationDao).findByIds(isA(Collection.class));
    verify(changeLogService).write(isA(Collection.class));
    assertTrue(actualRemoveApplicationsResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#removeApplications(String, long, List)}.
   *
   * <ul>
   *   <li>Given {@link AppGroupDao}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#removeApplications(String, long, List)}
   */
  @Test
  @DisplayName(
      "Test removeApplications(String, long, List); given AppGroupDao; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeApplications(String, long, List)"})
  void testRemoveApplications_givenAppGroupDao_thenThrowIllegalArgumentException()
      throws InsufficientPrivelegeException {
    // Arrange
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    when(appGroupEntryDao.removeApplications(anyLong(), Mockito.<List<Long>>any())).thenReturn(1);
    when(applicationDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> appGroupService.removeApplications("42", 1L, new ArrayList<>()));
    verify(appGroupEntryDao).removeApplications(eq(1L), isA(List.class));
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(applicationDao).findByIds(isA(Collection.class));
    verify(changeLogService).write(isA(Collection.class));
  }

  /**
   * Test {@link AppGroupService#removeApplications(String, long, List)}.
   *
   * <ul>
   *   <li>Given {@link ApplicationDao} {@link ApplicationDao#findByIds(Collection)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#removeApplications(String, long, List)}
   */
  @Test
  @DisplayName(
      "Test removeApplications(String, long, List); given ApplicationDao findByIds(Collection) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeApplications(String, long, List)"})
  void testRemoveApplications_givenApplicationDaoFindByIdsThrowIllegalArgumentException()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.removeApplications(anyLong(), Mockito.<List<Long>>any())).thenReturn(1);

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByIds(Mockito.<Collection<Long>>any()))
        .thenThrow(new IllegalArgumentException());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> appGroupService.removeApplications("42", 1L, new ArrayList<>()));
    verify(appGroupEntryDao).removeApplications(eq(1L), isA(List.class));
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(applicationDao).findByIds(isA(Collection.class));
  }

  /**
   * Test {@link AppGroupService#removeApplications(String, long, List)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   *   <li>Then calls {@link ChangeLogService#write(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#removeApplications(String, long, List)}
   */
  @Test
  @DisplayName(
      "Test removeApplications(String, long, List); given one; when ArrayList() add one; then calls write(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeApplications(String, long, List)"})
  void testRemoveApplications_givenOne_whenArrayListAddOne_thenCallsWrite()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.removeApplications(anyLong(), Mockito.<List<Long>>any())).thenReturn(1);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
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

    ArrayList<Long> applicationIds = new ArrayList<>();
    applicationIds.add(1L);

    // Act
    List<AppGroupEntry> actualRemoveApplicationsResult =
        appGroupService.removeApplications("42", 1L, applicationIds);

    // Assert
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupEntryDao).removeApplications(eq(1L), isA(List.class));
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(applicationDao).findByIds(isA(Collection.class));
    verify(changeLogService).write(isA(Collection.class));
    assertTrue(actualRemoveApplicationsResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#removeApplications(String, long, List)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   *   <li>Then calls {@link ChangeLogService#write(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#removeApplications(String, long, List)}
   */
  @Test
  @DisplayName(
      "Test removeApplications(String, long, List); given zero; when ArrayList() add zero; then calls write(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeApplications(String, long, List)"})
  void testRemoveApplications_givenZero_whenArrayListAddZero_thenCallsWrite()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.removeApplications(anyLong(), Mockito.<List<Long>>any())).thenReturn(1);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
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

    ArrayList<Long> applicationIds = new ArrayList<>();
    applicationIds.add(0L);
    applicationIds.add(1L);

    // Act
    List<AppGroupEntry> actualRemoveApplicationsResult =
        appGroupService.removeApplications("42", 1L, applicationIds);

    // Assert
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupEntryDao).removeApplications(eq(1L), isA(List.class));
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(applicationDao).findByIds(isA(Collection.class));
    verify(changeLogService).write(isA(Collection.class));
    assertTrue(actualRemoveApplicationsResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#removeApplications(String, long, List)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogDao#write(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#removeApplications(String, long, List)}
   */
  @Test
  @DisplayName("Test removeApplications(String, long, List); then calls write(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeApplications(String, long, List)"})
  void testRemoveApplications_thenCallsWrite() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.removeApplications(anyLong(), Mockito.<List<Long>>any())).thenReturn(1);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
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

    // Act
    List<AppGroupEntry> actualRemoveApplicationsResult =
        appGroupService.removeApplications("42", 1L, new ArrayList<>());

    // Assert
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupEntryDao).removeApplications(eq(1L), isA(List.class));
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(applicationDao).findByIds(isA(Collection.class));
    verify(changeLogDao).write(isA(Collection.class));
    assertTrue(actualRemoveApplicationsResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#removeApplications(String, long, List)}.
   *
   * <ul>
   *   <li>Then throw {@link InsufficientPrivelegeException}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#removeApplications(String, long, List)}
   */
  @Test
  @DisplayName(
      "Test removeApplications(String, long, List); then throw InsufficientPrivelegeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeApplications(String, long, List)"})
  void testRemoveApplications_thenThrowInsufficientPrivelegeException()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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
            mock(ChangeLogService.class));

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class,
        () -> appGroupService.removeApplications("42", 1L, new ArrayList<>()));
    verify(appGroupMemberDao).canUpdate(1L, "42");
  }

  /**
   * Test {@link AppGroupService#addOwner(String, long, String)}.
   *
   * <ul>
   *   <li>Given {@link AppGroupDao}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#addOwner(String, long, String)}
   */
  @Test
  @DisplayName(
      "Test addOwner(String, long, String); given AppGroupDao; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupService.addOwner(String, long, String)"})
  void testAddOwner_givenAppGroupDao_thenCallsWrite() throws InsufficientPrivelegeException {
    // Arrange
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> appGroupService.addOwner("42", 1L, "42"));
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link AppGroupService#addOwner(String, long, String)}.
   *
   * <ul>
   *   <li>Given {@link AppGroupMemberDao} {@link AppGroupMemberDao#canUpdate(long, String)} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#addOwner(String, long, String)}
   */
  @Test
  @DisplayName(
      "Test addOwner(String, long, String); given AppGroupMemberDao canUpdate(long, String) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupService.addOwner(String, long, String)"})
  void testAddOwner_givenAppGroupMemberDaoCanUpdateThrowIllegalArgumentException()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> appGroupService.addOwner("42", 1L, "42"));
    verify(appGroupMemberDao).canUpdate(1L, "42");
  }

  /**
   * Test {@link AppGroupService#addOwner(String, long, String)}.
   *
   * <ul>
   *   <li>Given {@link AppGroupMemberDao} {@link AppGroupMemberDao#register(long, String,
   *       AppGroupMemberRole)} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#addOwner(String, long, String)}
   */
  @Test
  @DisplayName(
      "Test addOwner(String, long, String); given AppGroupMemberDao register(long, String, AppGroupMemberRole) return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupService.addOwner(String, long, String)"})
  void testAddOwner_givenAppGroupMemberDaoRegisterReturnOne_thenReturnOne()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.register(
            anyLong(), Mockito.<String>any(), Mockito.<AppGroupMemberRole>any()))
        .thenReturn(1);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

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

    // Act
    int actualAddOwnerResult = appGroupService.addOwner("42", 1L, "42");

    // Assert
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(appGroupMemberDao).register(1L, "42", AppGroupMemberRole.OWNER);
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    assertEquals(1, actualAddOwnerResult);
  }

  /**
   * Test {@link AppGroupService#addOwner(String, long, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#addOwner(String, long, String)}
   */
  @Test
  @DisplayName(
      "Test addOwner(String, long, String); given ChangeLogService write(ChangeLog) return '19088743'; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupService.addOwner(String, long, String)"})
  void testAddOwner_givenChangeLogServiceWriteReturn19088743_thenCallsWrite()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.register(
            anyLong(), Mockito.<String>any(), Mockito.<AppGroupMemberRole>any()))
        .thenThrow(new IllegalArgumentException());
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> appGroupService.addOwner("42", 1L, "42"));
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(appGroupMemberDao).register(1L, "42", AppGroupMemberRole.OWNER);
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link AppGroupService#addOwner(String, long, String)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#addOwner(String, long, String)}
   */
  @Test
  @DisplayName("Test addOwner(String, long, String); then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupService.addOwner(String, long, String)"})
  void testAddOwner_thenCallsWrite() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.register(
            anyLong(), Mockito.<String>any(), Mockito.<AppGroupMemberRole>any()))
        .thenThrow(new IllegalArgumentException());
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

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

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> appGroupService.addOwner("42", 1L, "42"));
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(appGroupMemberDao).register(1L, "42", AppGroupMemberRole.OWNER);
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
  }

  /**
   * Test {@link AppGroupService#addOwner(String, long, String)}.
   *
   * <ul>
   *   <li>Then throw {@link InsufficientPrivelegeException}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#addOwner(String, long, String)}
   */
  @Test
  @DisplayName("Test addOwner(String, long, String); then throw InsufficientPrivelegeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupService.addOwner(String, long, String)"})
  void testAddOwner_thenThrowInsufficientPrivelegeException()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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
            mock(ChangeLogService.class));

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class, () -> appGroupService.addOwner("42", 1L, "42"));
    verify(appGroupMemberDao).canUpdate(1L, "42");
  }

  /**
   * Test {@link AppGroupService#removeOwner(String, long, String)}.
   *
   * <ul>
   *   <li>Given {@link AppGroupEntryDao}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#removeOwner(String, long, String)}
   */
  @Test
  @DisplayName(
      "Test removeOwner(String, long, String); given AppGroupEntryDao; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AppGroupService.removeOwner(String, long, String)"})
  void testRemoveOwner_givenAppGroupEntryDao_thenThrowIllegalArgumentException()
      throws InsufficientPrivelegeException {
    // Arrange
    when(appGroupDao.getGroup(anyLong()))
        .thenReturn(
            ImmutableAppGroup.builder()
                .appGroupKind(AppGroupKind.PUBLIC)
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(appGroupMemberDao.unregister(anyLong(), Mockito.<String>any())).thenReturn(true);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> appGroupService.removeOwner("42", 1L, "42"));
    verify(appGroupDao).getGroup(1L);
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(appGroupMemberDao).unregister(1L, "42");
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link AppGroupService#removeOwner(String, long, String)}.
   *
   * <ul>
   *   <li>Given {@link AppGroupMemberDao} {@link AppGroupMemberDao#canUpdate(long, String)} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#removeOwner(String, long, String)}
   */
  @Test
  @DisplayName(
      "Test removeOwner(String, long, String); given AppGroupMemberDao canUpdate(long, String) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AppGroupService.removeOwner(String, long, String)"})
  void testRemoveOwner_givenAppGroupMemberDaoCanUpdateThrowIllegalArgumentException()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> appGroupService.removeOwner("42", 1L, "42"));
    verify(appGroupMemberDao).canUpdate(1L, "42");
  }

  /**
   * Test {@link AppGroupService#removeOwner(String, long, String)}.
   *
   * <ul>
   *   <li>Given {@link AppGroupMemberDao} {@link AppGroupMemberDao#unregister(long, String)} return
   *       {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#removeOwner(String, long, String)}
   */
  @Test
  @DisplayName(
      "Test removeOwner(String, long, String); given AppGroupMemberDao unregister(long, String) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AppGroupService.removeOwner(String, long, String)"})
  void testRemoveOwner_givenAppGroupMemberDaoUnregisterReturnFalse_thenReturnFalse()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong()))
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
    when(appGroupMemberDao.unregister(anyLong(), Mockito.<String>any())).thenReturn(false);
    when(appGroupMemberDao.register(anyLong(), Mockito.<String>any())).thenReturn(1);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
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

    // Act
    boolean actualRemoveOwnerResult = appGroupService.removeOwner("42", 1L, "42");

    // Assert
    verify(appGroupDao).getGroup(1L);
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(appGroupMemberDao).register(1L, "42");
    verify(appGroupMemberDao).unregister(1L, "42");
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    assertFalse(actualRemoveOwnerResult);
  }

  /**
   * Test {@link AppGroupService#removeOwner(String, long, String)}.
   *
   * <ul>
   *   <li>Given {@link AppGroupMemberDao} {@link AppGroupMemberDao#unregister(long, String)} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#removeOwner(String, long, String)}
   */
  @Test
  @DisplayName(
      "Test removeOwner(String, long, String); given AppGroupMemberDao unregister(long, String) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AppGroupService.removeOwner(String, long, String)"})
  void testRemoveOwner_givenAppGroupMemberDaoUnregisterThrowIllegalArgumentException()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.unregister(anyLong(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> appGroupService.removeOwner("42", 1L, "42"));
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(appGroupMemberDao).unregister(1L, "42");
  }

  /**
   * Test {@link AppGroupService#removeOwner(String, long, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#removeOwner(String, long, String)}
   */
  @Test
  @DisplayName(
      "Test removeOwner(String, long, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AppGroupService.removeOwner(String, long, String)"})
  void testRemoveOwner_givenChangeLogDaoWriteReturn19088743_thenCallsWrite()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong()))
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
    when(appGroupMemberDao.unregister(anyLong(), Mockito.<String>any())).thenReturn(true);
    when(appGroupMemberDao.register(anyLong(), Mockito.<String>any())).thenReturn(1);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

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

    // Act
    boolean actualRemoveOwnerResult = appGroupService.removeOwner("42", 1L, "42");

    // Assert
    verify(appGroupDao).getGroup(1L);
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(appGroupMemberDao).register(1L, "42");
    verify(appGroupMemberDao).unregister(1L, "42");
    verify(changeLogDao, atLeast(1)).write(isA(Optional.class), Mockito.<ChangeLog>any());
    assertTrue(actualRemoveOwnerResult);
  }

  /**
   * Test {@link AppGroupService#removeOwner(String, long, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#removeOwner(String, long, String)}
   */
  @Test
  @DisplayName(
      "Test removeOwner(String, long, String); given ChangeLogService write(ChangeLog) return '19088743'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AppGroupService.removeOwner(String, long, String)"})
  void testRemoveOwner_givenChangeLogServiceWriteReturn19088743_thenReturnTrue()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong()))
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
    when(appGroupMemberDao.unregister(anyLong(), Mockito.<String>any())).thenReturn(true);
    when(appGroupMemberDao.register(anyLong(), Mockito.<String>any())).thenReturn(1);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
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

    // Act
    boolean actualRemoveOwnerResult = appGroupService.removeOwner("42", 1L, "42");

    // Assert
    verify(appGroupDao).getGroup(1L);
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(appGroupMemberDao).register(1L, "42");
    verify(appGroupMemberDao).unregister(1L, "42");
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    assertTrue(actualRemoveOwnerResult);
  }

  /**
   * Test {@link AppGroupService#removeOwner(String, long, String)}.
   *
   * <ul>
   *   <li>Then throw {@link InsufficientPrivelegeException}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#removeOwner(String, long, String)}
   */
  @Test
  @DisplayName("Test removeOwner(String, long, String); then throw InsufficientPrivelegeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AppGroupService.removeOwner(String, long, String)"})
  void testRemoveOwner_thenThrowInsufficientPrivelegeException()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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
            mock(ChangeLogService.class));

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class, () -> appGroupService.removeOwner("42", 1L, "42"));
    verify(appGroupMemberDao).canUpdate(1L, "42");
  }

  /**
   * Test {@link AppGroupService#getMembers(long)}.
   *
   * <ul>
   *   <li>Given {@link AppGroupMemberDao} {@link AppGroupMemberDao#getMembers(long)} return {@link
   *       HashSet#HashSet()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#getMembers(long)}
   */
  @Test
  @DisplayName(
      "Test getMembers(long); given AppGroupMemberDao getMembers(long) return HashSet(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AppGroupService.getMembers(long)"})
  void testGetMembers_givenAppGroupMemberDaoGetMembersReturnHashSet_thenReturnEmpty() {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(new HashSet<>());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act
    Set<AppGroupMember> actualMembers = appGroupService.getMembers(1L);

    // Assert
    verify(appGroupMemberDao).getMembers(1L);
    assertTrue(actualMembers.isEmpty());
  }

  /**
   * Test {@link AppGroupService#getMembers(long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#getMembers(long)}
   */
  @Test
  @DisplayName("Test getMembers(long); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AppGroupService.getMembers(long)"})
  void testGetMembers_thenThrowIllegalArgumentException() {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.getMembers(anyLong())).thenThrow(new IllegalArgumentException());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> appGroupService.getMembers(1L));
    verify(appGroupMemberDao).getMembers(1L);
  }

  /**
   * Test {@link AppGroupService#updateOverview(String, AppGroup)}.
   *
   * <p>Method under test: {@link AppGroupService#updateOverview(String, AppGroup)}
   */
  @Test
  @DisplayName("Test updateOverview(String, AppGroup)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppGroupDetail AppGroupService.updateOverview(String, AppGroup)"})
  void testUpdateOverview() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.update(Mockito.<AppGroup>any())).thenReturn(1);
    when(appGroupDao.getGroup(anyLong()))
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
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(new HashSet<>());
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();

    Builder builderResult = ImmutableEntityRelationship.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    entityRelationshipList.add(
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .relationship("127.0.0.1")
            .build());

    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(entityRelationshipList);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
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

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
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

    AppGroupService appGroupService =
        new AppGroupService(
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            mock(ApplicationDao.class),
            appGroupOrganisationalUnitDao,
            mock(OrganisationalUnitDao.class),
            mock(EntityRelationshipDao.class),
            changeInitiativeService,
            changeLogService2);

    AppGroup appGroup = mock(AppGroup.class);
    Optional<Long> ofResult = Optional.of(1L);
    when(appGroup.id()).thenReturn(ofResult);

    // Act
    AppGroupDetail actualUpdateOverviewResult = appGroupService.updateOverview("42", appGroup);

    // Assert
    verify(appGroupDao).getGroup(1L);
    verify(appGroupDao).update(isA(AppGroup.class));
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(appGroupMemberDao).getMembers(1L);
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(1L);
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    verify(appGroup, atLeast(1)).id();
    assertTrue(actualUpdateOverviewResult instanceof ImmutableAppGroupDetail);
    List<AppGroupEntry> applicationsResult = actualUpdateOverviewResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualUpdateOverviewResult.changeInitiatives());
    assertSame(applicationsResult, actualUpdateOverviewResult.members());
    assertSame(applicationsResult, actualUpdateOverviewResult.organisationalUnits());
  }

  /**
   * Test {@link AppGroupService#updateOverview(String, AppGroup)}.
   *
   * <p>Method under test: {@link AppGroupService#updateOverview(String, AppGroup)}
   */
  @Test
  @DisplayName("Test updateOverview(String, AppGroup)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppGroupDetail AppGroupService.updateOverview(String, AppGroup)"})
  void testUpdateOverview2() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.update(Mockito.<AppGroup>any())).thenReturn(1);
    when(appGroupDao.getGroup(anyLong()))
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
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(new HashSet<>());
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();

    Builder builderResult = ImmutableEntityRelationship.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    entityRelationshipList.add(
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .relationship("127.0.0.1")
            .build());

    Builder builderResult2 = ImmutableEntityRelationship.builder();

    Builder aResult2 =
        builderResult2.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    entityRelationshipList.add(
        aResult2
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .relationship("127.0.0.1")
            .build());

    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(entityRelationshipList);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
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

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
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

    AppGroupService appGroupService =
        new AppGroupService(
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            mock(ApplicationDao.class),
            appGroupOrganisationalUnitDao,
            mock(OrganisationalUnitDao.class),
            mock(EntityRelationshipDao.class),
            changeInitiativeService,
            changeLogService2);

    AppGroup appGroup = mock(AppGroup.class);
    Optional<Long> ofResult = Optional.of(1L);
    when(appGroup.id()).thenReturn(ofResult);

    // Act
    AppGroupDetail actualUpdateOverviewResult = appGroupService.updateOverview("42", appGroup);

    // Assert
    verify(appGroupDao).getGroup(1L);
    verify(appGroupDao).update(isA(AppGroup.class));
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(appGroupMemberDao).getMembers(1L);
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(1L);
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    verify(appGroup, atLeast(1)).id();
    assertTrue(actualUpdateOverviewResult instanceof ImmutableAppGroupDetail);
    List<AppGroupEntry> applicationsResult = actualUpdateOverviewResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualUpdateOverviewResult.changeInitiatives());
    assertSame(applicationsResult, actualUpdateOverviewResult.members());
    assertSame(applicationsResult, actualUpdateOverviewResult.organisationalUnits());
  }

  /**
   * Test {@link AppGroupService#updateOverview(String, AppGroup)}.
   *
   * <p>Method under test: {@link AppGroupService#updateOverview(String, AppGroup)}
   */
  @Test
  @DisplayName("Test updateOverview(String, AppGroup)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppGroupDetail AppGroupService.updateOverview(String, AppGroup)"})
  void testUpdateOverview3() throws InsufficientPrivelegeException {
    // Arrange
    when(appGroupDao.update(Mockito.<AppGroup>any())).thenReturn(1);
    when(appGroupDao.getGroup(anyLong()))
        .thenReturn(
            ImmutableAppGroup.builder()
                .appGroupKind(AppGroupKind.PUBLIC)
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(new HashSet<>());
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());
    when(changeInitiativeService.findEntriesForAppGroup(anyLong()))
        .thenThrow(new IllegalArgumentException());
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    AppGroup appGroup = mock(AppGroup.class);
    Optional<Long> ofResult = Optional.of(1L);
    when(appGroup.id()).thenReturn(ofResult);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> appGroupService.updateOverview("42", appGroup));
    verify(appGroupDao).getGroup(1L);
    verify(appGroupDao).update(isA(AppGroup.class));
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(appGroupMemberDao).getMembers(1L);
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(1L);
    verify(appGroup, atLeast(1)).id();
    verify(changeInitiativeService).findEntriesForAppGroup(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link AppGroupService#updateOverview(String, AppGroup)}.
   *
   * <ul>
   *   <li>Given {@link AppGroupDao} {@link AppGroupDao#update(AppGroup)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#updateOverview(String, AppGroup)}
   */
  @Test
  @DisplayName(
      "Test updateOverview(String, AppGroup); given AppGroupDao update(AppGroup) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppGroupDetail AppGroupService.updateOverview(String, AppGroup)"})
  void testUpdateOverview_givenAppGroupDaoUpdateThrowIllegalArgumentException()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.update(Mockito.<AppGroup>any())).thenThrow(new IllegalArgumentException());

    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    AppGroup appGroup = mock(AppGroup.class);
    Optional<Long> ofResult = Optional.of(1L);
    when(appGroup.id()).thenReturn(ofResult);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> appGroupService.updateOverview("42", appGroup));
    verify(appGroupDao).update(isA(AppGroup.class));
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(appGroup).id();
  }

  /**
   * Test {@link AppGroupService#updateOverview(String, AppGroup)}.
   *
   * <ul>
   *   <li>Given {@link AppGroupEntryDao}.
   *   <li>When {@code 42}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#updateOverview(String, AppGroup)}
   */
  @Test
  @DisplayName(
      "Test updateOverview(String, AppGroup); given AppGroupEntryDao; when '42'; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppGroupDetail AppGroupService.updateOverview(String, AppGroup)"})
  void testUpdateOverview_givenAppGroupEntryDao_when42_thenCallsWrite()
      throws InsufficientPrivelegeException {
    // Arrange
    when(appGroupDao.update(Mockito.<AppGroup>any())).thenReturn(1);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new IllegalArgumentException());

    AppGroup appGroup = mock(AppGroup.class);
    Optional<Long> ofResult = Optional.of(1L);
    when(appGroup.id()).thenReturn(ofResult);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> appGroupService.updateOverview("42", appGroup));
    verify(appGroupDao).update(isA(AppGroup.class));
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(appGroup, atLeast(1)).id();
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link AppGroupService#updateOverview(String, AppGroup)}.
   *
   * <ul>
   *   <li>Given {@link AppGroupMemberDao} {@link AppGroupMemberDao#canUpdate(long, String)} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#updateOverview(String, AppGroup)}
   */
  @Test
  @DisplayName(
      "Test updateOverview(String, AppGroup); given AppGroupMemberDao canUpdate(long, String) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppGroupDetail AppGroupService.updateOverview(String, AppGroup)"})
  void testUpdateOverview_givenAppGroupMemberDaoCanUpdateThrowIllegalArgumentException()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    AppGroup appGroup = mock(AppGroup.class);
    Optional<Long> ofResult = Optional.of(1L);
    when(appGroup.id()).thenReturn(ofResult);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> appGroupService.updateOverview("42", appGroup));
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(appGroup).id();
  }

  /**
   * Test {@link AppGroupService#updateOverview(String, AppGroup)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#updateOverview(String, AppGroup)}
   */
  @Test
  @DisplayName("Test updateOverview(String, AppGroup); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppGroupDetail AppGroupService.updateOverview(String, AppGroup)"})
  void testUpdateOverview_givenIllegalArgumentException() throws InsufficientPrivelegeException {
    // Arrange
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    AppGroup appGroup = mock(AppGroup.class);
    when(appGroup.id()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> appGroupService.updateOverview("42", appGroup));
    verify(appGroup).id();
  }

  /**
   * Test {@link AppGroupService#updateOverview(String, AppGroup)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeInitiativeService#findEntriesForAppGroup(long)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#updateOverview(String, AppGroup)}
   */
  @Test
  @DisplayName("Test updateOverview(String, AppGroup); then calls findEntriesForAppGroup(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppGroupDetail AppGroupService.updateOverview(String, AppGroup)"})
  void testUpdateOverview_thenCallsFindEntriesForAppGroup() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.update(Mockito.<AppGroup>any())).thenReturn(1);
    when(appGroupDao.getGroup(anyLong()))
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
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(new HashSet<>());
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    ChangeInitiativeService changeInitiativeService = mock(ChangeInitiativeService.class);
    when(changeInitiativeService.findEntriesForAppGroup(anyLong())).thenReturn(new ArrayList<>());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    AppGroupService appGroupService =
        new AppGroupService(
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            mock(ApplicationDao.class),
            appGroupOrganisationalUnitDao,
            mock(OrganisationalUnitDao.class),
            mock(EntityRelationshipDao.class),
            changeInitiativeService,
            changeLogService);

    AppGroup appGroup = mock(AppGroup.class);
    Optional<Long> ofResult = Optional.of(1L);
    when(appGroup.id()).thenReturn(ofResult);

    // Act
    AppGroupDetail actualUpdateOverviewResult = appGroupService.updateOverview("42", appGroup);

    // Assert
    verify(appGroupDao).getGroup(1L);
    verify(appGroupDao).update(isA(AppGroup.class));
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(appGroupMemberDao).getMembers(1L);
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(1L);
    verify(appGroup, atLeast(1)).id();
    verify(changeInitiativeService).findEntriesForAppGroup(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateOverviewResult instanceof ImmutableAppGroupDetail);
    List<AppGroupEntry> applicationsResult = actualUpdateOverviewResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualUpdateOverviewResult.changeInitiatives());
    assertSame(applicationsResult, actualUpdateOverviewResult.members());
    assertSame(applicationsResult, actualUpdateOverviewResult.organisationalUnits());
  }

  /**
   * Test {@link AppGroupService#updateOverview(String, AppGroup)}.
   *
   * <ul>
   *   <li>Then return applications Empty.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#updateOverview(String, AppGroup)}
   */
  @Test
  @DisplayName("Test updateOverview(String, AppGroup); then return applications Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppGroupDetail AppGroupService.updateOverview(String, AppGroup)"})
  void testUpdateOverview_thenReturnApplicationsEmpty() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.update(Mockito.<AppGroup>any())).thenReturn(1);
    when(appGroupDao.getGroup(anyLong()))
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
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(new HashSet<>());
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
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

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
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

    AppGroupService appGroupService =
        new AppGroupService(
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            mock(ApplicationDao.class),
            appGroupOrganisationalUnitDao,
            mock(OrganisationalUnitDao.class),
            mock(EntityRelationshipDao.class),
            changeInitiativeService,
            changeLogService2);

    AppGroup appGroup = mock(AppGroup.class);
    Optional<Long> ofResult = Optional.of(1L);
    when(appGroup.id()).thenReturn(ofResult);

    // Act
    AppGroupDetail actualUpdateOverviewResult = appGroupService.updateOverview("42", appGroup);

    // Assert
    verify(appGroupDao).getGroup(1L);
    verify(appGroupDao).update(isA(AppGroup.class));
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(appGroupMemberDao).getMembers(1L);
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(1L);
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    verify(appGroup, atLeast(1)).id();
    assertTrue(actualUpdateOverviewResult instanceof ImmutableAppGroupDetail);
    List<AppGroupEntry> applicationsResult = actualUpdateOverviewResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualUpdateOverviewResult.changeInitiatives());
    assertSame(applicationsResult, actualUpdateOverviewResult.members());
    assertSame(applicationsResult, actualUpdateOverviewResult.organisationalUnits());
  }

  /**
   * Test {@link AppGroupService#updateOverview(String, AppGroup)}.
   *
   * <ul>
   *   <li>Then return changeInitiatives Empty.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#updateOverview(String, AppGroup)}
   */
  @Test
  @DisplayName("Test updateOverview(String, AppGroup); then return changeInitiatives Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppGroupDetail AppGroupService.updateOverview(String, AppGroup)"})
  void testUpdateOverview_thenReturnChangeInitiativesEmpty() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.update(Mockito.<AppGroup>any())).thenReturn(1);
    when(appGroupDao.getGroup(anyLong()))
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
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(new HashSet<>());
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    appGroupEntryList.add(
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build());

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(appGroupEntryList);

    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
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

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
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

    AppGroupService appGroupService =
        new AppGroupService(
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            mock(ApplicationDao.class),
            appGroupOrganisationalUnitDao,
            mock(OrganisationalUnitDao.class),
            mock(EntityRelationshipDao.class),
            changeInitiativeService,
            changeLogService2);

    AppGroup appGroup = mock(AppGroup.class);
    Optional<Long> ofResult = Optional.of(1L);
    when(appGroup.id()).thenReturn(ofResult);

    // Act
    AppGroupDetail actualUpdateOverviewResult = appGroupService.updateOverview("42", appGroup);

    // Assert
    verify(appGroupDao).getGroup(1L);
    verify(appGroupDao).update(isA(AppGroup.class));
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(appGroupMemberDao).getMembers(1L);
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(1L);
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    verify(appGroup, atLeast(1)).id();
    assertTrue(actualUpdateOverviewResult instanceof ImmutableAppGroupDetail);
    List<AppGroupEntry> changeInitiativesResult = actualUpdateOverviewResult.changeInitiatives();
    assertTrue(changeInitiativesResult.isEmpty());
    assertEquals(appGroupEntryList, actualUpdateOverviewResult.applications());
    assertSame(changeInitiativesResult, actualUpdateOverviewResult.members());
    assertSame(changeInitiativesResult, actualUpdateOverviewResult.organisationalUnits());
  }

  /**
   * Test {@link AppGroupService#updateOverview(String, AppGroup)}.
   *
   * <ul>
   *   <li>Then return changeInitiatives Empty.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#updateOverview(String, AppGroup)}
   */
  @Test
  @DisplayName("Test updateOverview(String, AppGroup); then return changeInitiatives Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppGroupDetail AppGroupService.updateOverview(String, AppGroup)"})
  void testUpdateOverview_thenReturnChangeInitiativesEmpty2()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.update(Mockito.<AppGroup>any())).thenReturn(1);
    when(appGroupDao.getGroup(anyLong()))
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
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(new HashSet<>());
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    appGroupEntryList.add(
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build());
    appGroupEntryList.add(
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build());

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(appGroupEntryList);

    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
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

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
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

    AppGroupService appGroupService =
        new AppGroupService(
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            mock(ApplicationDao.class),
            appGroupOrganisationalUnitDao,
            mock(OrganisationalUnitDao.class),
            mock(EntityRelationshipDao.class),
            changeInitiativeService,
            changeLogService2);

    AppGroup appGroup = mock(AppGroup.class);
    Optional<Long> ofResult = Optional.of(1L);
    when(appGroup.id()).thenReturn(ofResult);

    // Act
    AppGroupDetail actualUpdateOverviewResult = appGroupService.updateOverview("42", appGroup);

    // Assert
    verify(appGroupDao).getGroup(1L);
    verify(appGroupDao).update(isA(AppGroup.class));
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(appGroupMemberDao).getMembers(1L);
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(1L);
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    verify(appGroup, atLeast(1)).id();
    assertTrue(actualUpdateOverviewResult instanceof ImmutableAppGroupDetail);
    List<AppGroupEntry> changeInitiativesResult = actualUpdateOverviewResult.changeInitiatives();
    assertTrue(changeInitiativesResult.isEmpty());
    assertEquals(appGroupEntryList, actualUpdateOverviewResult.applications());
    assertSame(changeInitiativesResult, actualUpdateOverviewResult.members());
    assertSame(changeInitiativesResult, actualUpdateOverviewResult.organisationalUnits());
  }

  /**
   * Test {@link AppGroupService#updateOverview(String, AppGroup)}.
   *
   * <ul>
   *   <li>Then return changeInitiatives is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#updateOverview(String, AppGroup)}
   */
  @Test
  @DisplayName(
      "Test updateOverview(String, AppGroup); then return changeInitiatives is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppGroupDetail AppGroupService.updateOverview(String, AppGroup)"})
  void testUpdateOverview_thenReturnChangeInitiativesIsArrayList()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.update(Mockito.<AppGroup>any())).thenReturn(1);
    when(appGroupDao.getGroup(anyLong()))
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
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(new HashSet<>());
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    appGroupEntryList.add(
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build());

    ChangeInitiativeService changeInitiativeService = mock(ChangeInitiativeService.class);
    when(changeInitiativeService.findEntriesForAppGroup(anyLong())).thenReturn(appGroupEntryList);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    AppGroupService appGroupService =
        new AppGroupService(
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            mock(ApplicationDao.class),
            appGroupOrganisationalUnitDao,
            mock(OrganisationalUnitDao.class),
            mock(EntityRelationshipDao.class),
            changeInitiativeService,
            changeLogService);

    AppGroup appGroup = mock(AppGroup.class);
    Optional<Long> ofResult = Optional.of(1L);
    when(appGroup.id()).thenReturn(ofResult);

    // Act
    AppGroupDetail actualUpdateOverviewResult = appGroupService.updateOverview("42", appGroup);

    // Assert
    verify(appGroupDao).getGroup(1L);
    verify(appGroupDao).update(isA(AppGroup.class));
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(appGroupMemberDao).getMembers(1L);
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(1L);
    verify(appGroup, atLeast(1)).id();
    verify(changeInitiativeService).findEntriesForAppGroup(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateOverviewResult instanceof ImmutableAppGroupDetail);
    assertEquals(appGroupEntryList, actualUpdateOverviewResult.changeInitiatives());
  }

  /**
   * Test {@link AppGroupService#updateOverview(String, AppGroup)}.
   *
   * <ul>
   *   <li>Then return members size is one.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#updateOverview(String, AppGroup)}
   */
  @Test
  @DisplayName("Test updateOverview(String, AppGroup); then return members size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppGroupDetail AppGroupService.updateOverview(String, AppGroup)"})
  void testUpdateOverview_thenReturnMembersSizeIsOne() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.update(Mockito.<AppGroup>any())).thenReturn(1);
    when(appGroupDao.getGroup(anyLong()))
        .thenReturn(
            ImmutableAppGroup.builder()
                .appGroupKind(AppGroupKind.PUBLIC)
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    HashSet<AppGroupMember> appGroupMemberSet = new HashSet<>();
    appGroupMemberSet.add(
        ImmutableAppGroupMember.builder()
            .groupId(1L)
            .role(AppGroupMemberRole.VIEWER)
            .userId("42")
            .build());

    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(appGroupMemberSet);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
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

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
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

    AppGroupService appGroupService =
        new AppGroupService(
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            mock(ApplicationDao.class),
            appGroupOrganisationalUnitDao,
            mock(OrganisationalUnitDao.class),
            mock(EntityRelationshipDao.class),
            changeInitiativeService,
            changeLogService2);

    AppGroup appGroup = mock(AppGroup.class);
    Optional<Long> ofResult = Optional.of(1L);
    when(appGroup.id()).thenReturn(ofResult);

    // Act
    AppGroupDetail actualUpdateOverviewResult = appGroupService.updateOverview("42", appGroup);

    // Assert
    verify(appGroupDao).getGroup(1L);
    verify(appGroupDao).update(isA(AppGroup.class));
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(appGroupMemberDao).getMembers(1L);
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(1L);
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    verify(appGroup, atLeast(1)).id();
    assertTrue(actualUpdateOverviewResult instanceof ImmutableAppGroupDetail);
    List<AppGroupMember> membersResult = actualUpdateOverviewResult.members();
    assertEquals(1, membersResult.size());
    AppGroupMember getResult = membersResult.get(0);
    assertTrue(getResult instanceof ImmutableAppGroupMember);
    assertEquals("42", getResult.userId());
    assertEquals(1L, getResult.groupId());
    assertEquals(AppGroupMemberRole.VIEWER, getResult.role());
  }

  /**
   * Test {@link AppGroupService#updateOverview(String, AppGroup)}.
   *
   * <ul>
   *   <li>Then return organisationalUnits is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#updateOverview(String, AppGroup)}
   */
  @Test
  @DisplayName(
      "Test updateOverview(String, AppGroup); then return organisationalUnits is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppGroupDetail AppGroupService.updateOverview(String, AppGroup)"})
  void testUpdateOverview_thenReturnOrganisationalUnitsIsArrayList()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.update(Mockito.<AppGroup>any())).thenReturn(1);
    when(appGroupDao.getGroup(anyLong()))
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
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(new HashSet<>());
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    appGroupEntryList.add(
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build());

    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(appGroupEntryList);

    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
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

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
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

    AppGroupService appGroupService =
        new AppGroupService(
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            mock(ApplicationDao.class),
            appGroupOrganisationalUnitDao,
            mock(OrganisationalUnitDao.class),
            mock(EntityRelationshipDao.class),
            changeInitiativeService,
            changeLogService2);

    AppGroup appGroup = mock(AppGroup.class);
    Optional<Long> ofResult = Optional.of(1L);
    when(appGroup.id()).thenReturn(ofResult);

    // Act
    AppGroupDetail actualUpdateOverviewResult = appGroupService.updateOverview("42", appGroup);

    // Assert
    verify(appGroupDao).getGroup(1L);
    verify(appGroupDao).update(isA(AppGroup.class));
    verify(appGroupEntryDao).findEntriesForGroup(1L);
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(appGroupMemberDao).getMembers(1L);
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(1L);
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    verify(appGroup, atLeast(1)).id();
    assertTrue(actualUpdateOverviewResult instanceof ImmutableAppGroupDetail);
    assertEquals(appGroupEntryList, actualUpdateOverviewResult.organisationalUnits());
  }

  /**
   * Test {@link AppGroupService#updateOverview(String, AppGroup)}.
   *
   * <ul>
   *   <li>Then throw {@link InsufficientPrivelegeException}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#updateOverview(String, AppGroup)}
   */
  @Test
  @DisplayName("Test updateOverview(String, AppGroup); then throw InsufficientPrivelegeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppGroupDetail AppGroupService.updateOverview(String, AppGroup)"})
  void testUpdateOverview_thenThrowInsufficientPrivelegeException()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);
    AppGroupService appGroupService =
        new AppGroupService(
            mock(AppGroupDao.class),
            appGroupMemberDao,
            mock(AppGroupEntryDao.class),
            mock(ApplicationDao.class),
            mock(AppGroupOrganisationalUnitDao.class),
            mock(OrganisationalUnitDao.class),
            mock(EntityRelationshipDao.class),
            mock(ChangeInitiativeService.class),
            mock(ChangeLogService.class));

    AppGroup appGroup = mock(AppGroup.class);
    Optional<Long> ofResult = Optional.of(1L);
    when(appGroup.id()).thenReturn(ofResult);

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class, () -> appGroupService.updateOverview("42", appGroup));
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(appGroup).id();
  }

  /**
   * Test {@link AppGroupService#createNewGroup(String)}.
   *
   * <ul>
   *   <li>Given {@link AppGroupDao} {@link AppGroupDao#insert(AppGroup)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#createNewGroup(String)}
   */
  @Test
  @DisplayName(
      "Test createNewGroup(String); given AppGroupDao insert(AppGroup) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AppGroupService.createNewGroup(String)"})
  void testCreateNewGroup_givenAppGroupDaoInsertThrowIllegalArgumentException() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.insert(Mockito.<AppGroup>any())).thenThrow(new IllegalArgumentException());
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> appGroupService.createNewGroup("42"));
    verify(appGroupDao).insert(isA(AppGroup.class));
  }

  /**
   * Test {@link AppGroupService#createNewGroup(String)}.
   *
   * <ul>
   *   <li>Given {@link AppGroupEntryDao}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#createNewGroup(String)}
   */
  @Test
  @DisplayName("Test createNewGroup(String); given AppGroupEntryDao; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AppGroupService.createNewGroup(String)"})
  void testCreateNewGroup_givenAppGroupEntryDao_thenCallsWrite() {
    // Arrange
    when(appGroupDao.insert(Mockito.<AppGroup>any())).thenReturn(1L);
    when(appGroupMemberDao.register(
            anyLong(), Mockito.<String>any(), Mockito.<AppGroupMemberRole>any()))
        .thenReturn(1);
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> appGroupService.createNewGroup("42"));
    verify(appGroupDao).insert(isA(AppGroup.class));
    verify(appGroupMemberDao).register(1L, "42", AppGroupMemberRole.OWNER);
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link AppGroupService#createNewGroup(String)}.
   *
   * <ul>
   *   <li>Given {@link AppGroupMemberDao} {@link AppGroupMemberDao#register(long, String,
   *       AppGroupMemberRole)} throw {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#createNewGroup(String)}
   */
  @Test
  @DisplayName(
      "Test createNewGroup(String); given AppGroupMemberDao register(long, String, AppGroupMemberRole) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AppGroupService.createNewGroup(String)"})
  void testCreateNewGroup_givenAppGroupMemberDaoRegisterThrowIllegalArgumentException() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.insert(Mockito.<AppGroup>any())).thenReturn(1L);

    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.register(
            anyLong(), Mockito.<String>any(), Mockito.<AppGroupMemberRole>any()))
        .thenThrow(new IllegalArgumentException());
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> appGroupService.createNewGroup("42"));
    verify(appGroupDao).insert(isA(AppGroup.class));
    verify(appGroupMemberDao).register(1L, "42", AppGroupMemberRole.OWNER);
  }

  /**
   * Test {@link AppGroupService#createNewGroup(String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#createNewGroup(String)}
   */
  @Test
  @DisplayName(
      "Test createNewGroup(String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AppGroupService.createNewGroup(String)"})
  void testCreateNewGroup_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.insert(Mockito.<AppGroup>any())).thenReturn(1L);

    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.register(
            anyLong(), Mockito.<String>any(), Mockito.<AppGroupMemberRole>any()))
        .thenReturn(1);

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

    // Act
    Long actualCreateNewGroupResult = appGroupService.createNewGroup("42");

    // Assert
    verify(appGroupDao).insert(isA(AppGroup.class));
    verify(appGroupMemberDao).register(1L, "42", AppGroupMemberRole.OWNER);
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    assertEquals(1L, actualCreateNewGroupResult.longValue());
  }

  /**
   * Test {@link AppGroupService#createNewGroup(String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#createNewGroup(String)}
   */
  @Test
  @DisplayName(
      "Test createNewGroup(String); given ChangeLogService write(ChangeLog) return '19088743'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AppGroupService.createNewGroup(String)"})
  void testCreateNewGroup_givenChangeLogServiceWriteReturn19088743() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.insert(Mockito.<AppGroup>any())).thenReturn(1L);

    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.register(
            anyLong(), Mockito.<String>any(), Mockito.<AppGroupMemberRole>any()))
        .thenReturn(1);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
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

    // Act
    Long actualCreateNewGroupResult = appGroupService.createNewGroup("42");

    // Assert
    verify(appGroupDao).insert(isA(AppGroup.class));
    verify(appGroupMemberDao).register(1L, "42", AppGroupMemberRole.OWNER);
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1L, actualCreateNewGroupResult.longValue());
  }

  /**
   * Test {@link AppGroupService#findByIds(String, List)}.
   *
   * <ul>
   *   <li>Given {@link AppGroupDao} {@link AppGroupDao#findByIds(String, List)} return {@link
   *       HashSet#HashSet()}.
   *   <li>When {@code User}.
   *   <li>Then return {@link Set}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#findByIds(String, List)}
   */
  @Test
  @DisplayName(
      "Test findByIds(String, List); given AppGroupDao findByIds(String, List) return HashSet(); when 'User'; then return Set")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection AppGroupService.findByIds(String, List)"})
  void testFindByIds_givenAppGroupDaoFindByIdsReturnHashSet_whenUser_thenReturnSet() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    HashSet<AppGroup> appGroupSet = new HashSet<>();
    when(appGroupDao.findByIds(Mockito.<String>any(), Mockito.<List<Long>>any()))
        .thenReturn(appGroupSet);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act
    Collection<AppGroup> actualFindByIdsResult =
        appGroupService.findByIds("User", new ArrayList<>());

    // Assert
    verify(appGroupDao).findByIds(eq("User"), isA(List.class));
    assertTrue(actualFindByIdsResult instanceof Set);
    assertTrue(actualFindByIdsResult.isEmpty());
    assertSame(appGroupSet, actualFindByIdsResult);
  }

  /**
   * Test {@link AppGroupService#findByIds(String, List)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   *   <li>Then return {@link Set}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#findByIds(String, List)}
   */
  @Test
  @DisplayName("Test findByIds(String, List); given one; when ArrayList() add one; then return Set")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection AppGroupService.findByIds(String, List)"})
  void testFindByIds_givenOne_whenArrayListAddOne_thenReturnSet() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    HashSet<AppGroup> appGroupSet = new HashSet<>();
    when(appGroupDao.findByIds(Mockito.<String>any(), Mockito.<List<Long>>any()))
        .thenReturn(appGroupSet);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act
    Collection<AppGroup> actualFindByIdsResult = appGroupService.findByIds("User", ids);

    // Assert
    verify(appGroupDao).findByIds(eq("User"), isA(List.class));
    assertTrue(actualFindByIdsResult instanceof Set);
    assertTrue(actualFindByIdsResult.isEmpty());
    assertSame(appGroupSet, actualFindByIdsResult);
  }

  /**
   * Test {@link AppGroupService#findByIds(String, List)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   *   <li>Then return {@link Set}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#findByIds(String, List)}
   */
  @Test
  @DisplayName(
      "Test findByIds(String, List); given zero; when ArrayList() add zero; then return Set")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection AppGroupService.findByIds(String, List)"})
  void testFindByIds_givenZero_whenArrayListAddZero_thenReturnSet() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    HashSet<AppGroup> appGroupSet = new HashSet<>();
    when(appGroupDao.findByIds(Mockito.<String>any(), Mockito.<List<Long>>any()))
        .thenReturn(appGroupSet);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(0L);
    ids.add(1L);

    // Act
    Collection<AppGroup> actualFindByIdsResult = appGroupService.findByIds("User", ids);

    // Assert
    verify(appGroupDao).findByIds(eq("User"), isA(List.class));
    assertTrue(actualFindByIdsResult instanceof Set);
    assertTrue(actualFindByIdsResult.isEmpty());
    assertSame(appGroupSet, actualFindByIdsResult);
  }

  /**
   * Test {@link AppGroupService#findByIds(String, List)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#findByIds(String, List)}
   */
  @Test
  @DisplayName("Test findByIds(String, List); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection AppGroupService.findByIds(String, List)"})
  void testFindByIds_thenThrowIllegalArgumentException() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.findByIds(Mockito.<String>any(), Mockito.<List<Long>>any()))
        .thenThrow(new IllegalArgumentException());
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> appGroupService.findByIds("User", new ArrayList<>()));
    verify(appGroupDao).findByIds(eq("User"), isA(List.class));
  }

  /**
   * Test {@link AppGroupService#addChangeInitiative(String, long, long)}.
   *
   * <p>Method under test: {@link AppGroupService#addChangeInitiative(String, long, long)}
   */
  @Test
  @DisplayName("Test addChangeInitiative(String, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addChangeInitiative(String, long, long)"})
  void testAddChangeInitiative() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> appGroupService.addChangeInitiative("janedoe", 1L, 1L));
    verify(appGroupMemberDao).canUpdate(1L, "janedoe");
  }

  /**
   * Test {@link AppGroupService#addChangeInitiative(String, long, long)}.
   *
   * <p>Method under test: {@link AppGroupService#addChangeInitiative(String, long, long)}
   */
  @Test
  @DisplayName("Test addChangeInitiative(String, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addChangeInitiative(String, long, long)"})
  void testAddChangeInitiative2() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.save(Mockito.<EntityRelationship>any()))
        .thenThrow(new IllegalArgumentException());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> appGroupService.addChangeInitiative("janedoe", 1L, 1L));
    verify(appGroupMemberDao).canUpdate(1L, "janedoe");
    verify(entityRelationshipDao).save(isA(EntityRelationship.class));
  }

  /**
   * Test {@link AppGroupService#addChangeInitiative(String, long, long)}.
   *
   * <p>Method under test: {@link AppGroupService#addChangeInitiative(String, long, long)}
   */
  @Test
  @DisplayName("Test addChangeInitiative(String, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addChangeInitiative(String, long, long)"})
  void testAddChangeInitiative3() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.save(Mockito.<EntityRelationship>any())).thenReturn(1);

    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();

    Builder builderResult = ImmutableEntityRelationship.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    entityRelationshipList.add(
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .relationship("127.0.0.1")
            .build());

    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(entityRelationshipList);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
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

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
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

    AppGroupService appGroupService =
        new AppGroupService(
            mock(AppGroupDao.class),
            appGroupMemberDao,
            mock(AppGroupEntryDao.class),
            mock(ApplicationDao.class),
            mock(AppGroupOrganisationalUnitDao.class),
            mock(OrganisationalUnitDao.class),
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act
    List<AppGroupEntry> actualAddChangeInitiativeResult =
        appGroupService.addChangeInitiative("janedoe", 1L, 1L);

    // Assert
    verify(appGroupMemberDao).canUpdate(1L, "janedoe");
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    verify(entityRelationshipDao).save(isA(EntityRelationship.class));
    assertTrue(actualAddChangeInitiativeResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#addChangeInitiative(String, long, long)}.
   *
   * <p>Method under test: {@link AppGroupService#addChangeInitiative(String, long, long)}
   */
  @Test
  @DisplayName("Test addChangeInitiative(String, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addChangeInitiative(String, long, long)"})
  void testAddChangeInitiative4() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.save(Mockito.<EntityRelationship>any())).thenReturn(1);

    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();

    Builder builderResult = ImmutableEntityRelationship.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    entityRelationshipList.add(
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .relationship("127.0.0.1")
            .build());

    Builder builderResult2 = ImmutableEntityRelationship.builder();

    Builder aResult2 =
        builderResult2.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    entityRelationshipList.add(
        aResult2
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .relationship("127.0.0.1")
            .build());

    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(entityRelationshipList);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
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

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
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

    AppGroupService appGroupService =
        new AppGroupService(
            mock(AppGroupDao.class),
            appGroupMemberDao,
            mock(AppGroupEntryDao.class),
            mock(ApplicationDao.class),
            mock(AppGroupOrganisationalUnitDao.class),
            mock(OrganisationalUnitDao.class),
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act
    List<AppGroupEntry> actualAddChangeInitiativeResult =
        appGroupService.addChangeInitiative("janedoe", 1L, 1L);

    // Assert
    verify(appGroupMemberDao).canUpdate(1L, "janedoe");
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    verify(entityRelationshipDao).save(isA(EntityRelationship.class));
    assertTrue(actualAddChangeInitiativeResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#addChangeInitiative(String, long, long)}.
   *
   * <p>Method under test: {@link AppGroupService#addChangeInitiative(String, long, long)}
   */
  @Test
  @DisplayName("Test addChangeInitiative(String, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addChangeInitiative(String, long, long)"})
  void testAddChangeInitiative5() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.save(Mockito.<EntityRelationship>any())).thenReturn(1);

    ChangeInitiativeService changeInitiativeService = mock(ChangeInitiativeService.class);
    when(changeInitiativeService.findEntriesForAppGroup(anyLong())).thenReturn(new ArrayList<>());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    AppGroupService appGroupService =
        new AppGroupService(
            mock(AppGroupDao.class),
            appGroupMemberDao,
            mock(AppGroupEntryDao.class),
            mock(ApplicationDao.class),
            mock(AppGroupOrganisationalUnitDao.class),
            mock(OrganisationalUnitDao.class),
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService);

    // Act
    List<AppGroupEntry> actualAddChangeInitiativeResult =
        appGroupService.addChangeInitiative("janedoe", 1L, 1L);

    // Assert
    verify(appGroupMemberDao).canUpdate(1L, "janedoe");
    verify(entityRelationshipDao).save(isA(EntityRelationship.class));
    verify(changeInitiativeService).findEntriesForAppGroup(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualAddChangeInitiativeResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#addChangeInitiative(String, long, long)}.
   *
   * <p>Method under test: {@link AppGroupService#addChangeInitiative(String, long, long)}
   */
  @Test
  @DisplayName("Test addChangeInitiative(String, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addChangeInitiative(String, long, long)"})
  void testAddChangeInitiative6() throws InsufficientPrivelegeException {
    // Arrange
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    when(entityRelationshipDao.save(Mockito.<EntityRelationship>any())).thenReturn(1);
    when(changeInitiativeService.findEntriesForAppGroup(anyLong()))
        .thenThrow(new IllegalArgumentException());
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> appGroupService.addChangeInitiative("janedoe", 1L, 1L));
    verify(appGroupMemberDao).canUpdate(1L, "janedoe");
    verify(entityRelationshipDao).save(isA(EntityRelationship.class));
    verify(changeInitiativeService).findEntriesForAppGroup(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link AppGroupService#addChangeInitiative(String, long, long)}.
   *
   * <ul>
   *   <li>Given {@link ChangeInitiativeService}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#addChangeInitiative(String, long, long)}
   */
  @Test
  @DisplayName(
      "Test addChangeInitiative(String, long, long); given ChangeInitiativeService; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addChangeInitiative(String, long, long)"})
  void testAddChangeInitiative_givenChangeInitiativeService_thenCallsWrite()
      throws InsufficientPrivelegeException {
    // Arrange
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    when(entityRelationshipDao.save(Mockito.<EntityRelationship>any())).thenReturn(1);
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> appGroupService.addChangeInitiative("janedoe", 1L, 1L));
    verify(appGroupMemberDao).canUpdate(1L, "janedoe");
    verify(entityRelationshipDao).save(isA(EntityRelationship.class));
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link AppGroupService#addChangeInitiative(String, long, long)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#addChangeInitiative(String, long, long)}
   */
  @Test
  @DisplayName(
      "Test addChangeInitiative(String, long, long); then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addChangeInitiative(String, long, long)"})
  void testAddChangeInitiative_thenCallsWrite() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.save(Mockito.<EntityRelationship>any())).thenReturn(1);

    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
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

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
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

    AppGroupService appGroupService =
        new AppGroupService(
            mock(AppGroupDao.class),
            appGroupMemberDao,
            mock(AppGroupEntryDao.class),
            mock(ApplicationDao.class),
            mock(AppGroupOrganisationalUnitDao.class),
            mock(OrganisationalUnitDao.class),
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act
    List<AppGroupEntry> actualAddChangeInitiativeResult =
        appGroupService.addChangeInitiative("janedoe", 1L, 1L);

    // Assert
    verify(appGroupMemberDao).canUpdate(1L, "janedoe");
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    verify(entityRelationshipDao).save(isA(EntityRelationship.class));
    assertTrue(actualAddChangeInitiativeResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#addChangeInitiative(String, long, long)}.
   *
   * <ul>
   *   <li>Then throw {@link InsufficientPrivelegeException}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#addChangeInitiative(String, long, long)}
   */
  @Test
  @DisplayName(
      "Test addChangeInitiative(String, long, long); then throw InsufficientPrivelegeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addChangeInitiative(String, long, long)"})
  void testAddChangeInitiative_thenThrowInsufficientPrivelegeException()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);
    AppGroupService appGroupService =
        new AppGroupService(
            mock(AppGroupDao.class),
            appGroupMemberDao,
            mock(AppGroupEntryDao.class),
            mock(ApplicationDao.class),
            mock(AppGroupOrganisationalUnitDao.class),
            mock(OrganisationalUnitDao.class),
            mock(EntityRelationshipDao.class),
            mock(ChangeInitiativeService.class),
            mock(ChangeLogService.class));

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class,
        () -> appGroupService.addChangeInitiative("janedoe", 1L, 1L));
    verify(appGroupMemberDao).canUpdate(1L, "janedoe");
  }

  /**
   * Test {@link AppGroupService#removeChangeInitiative(String, long, long)}.
   *
   * <p>Method under test: {@link AppGroupService#removeChangeInitiative(String, long, long)}
   */
  @Test
  @DisplayName("Test removeChangeInitiative(String, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeChangeInitiative(String, long, long)"})
  void testRemoveChangeInitiative() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> appGroupService.removeChangeInitiative("janedoe", 1L, 1L));
    verify(appGroupMemberDao).canUpdate(1L, "janedoe");
  }

  /**
   * Test {@link AppGroupService#removeChangeInitiative(String, long, long)}.
   *
   * <p>Method under test: {@link AppGroupService#removeChangeInitiative(String, long, long)}
   */
  @Test
  @DisplayName("Test removeChangeInitiative(String, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeChangeInitiative(String, long, long)"})
  void testRemoveChangeInitiative2() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.remove(Mockito.<EntityRelationshipKey>any()))
        .thenThrow(new IllegalArgumentException());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> appGroupService.removeChangeInitiative("janedoe", 1L, 1L));
    verify(appGroupMemberDao).canUpdate(1L, "janedoe");
    verify(entityRelationshipDao).remove(isA(EntityRelationshipKey.class));
  }

  /**
   * Test {@link AppGroupService#removeChangeInitiative(String, long, long)}.
   *
   * <p>Method under test: {@link AppGroupService#removeChangeInitiative(String, long, long)}
   */
  @Test
  @DisplayName("Test removeChangeInitiative(String, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeChangeInitiative(String, long, long)"})
  void testRemoveChangeInitiative3() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.remove(Mockito.<EntityRelationshipKey>any())).thenReturn(true);

    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();

    Builder builderResult = ImmutableEntityRelationship.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    entityRelationshipList.add(
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .relationship("127.0.0.1")
            .build());

    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(entityRelationshipList);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
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

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
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

    AppGroupService appGroupService =
        new AppGroupService(
            mock(AppGroupDao.class),
            appGroupMemberDao,
            mock(AppGroupEntryDao.class),
            mock(ApplicationDao.class),
            mock(AppGroupOrganisationalUnitDao.class),
            mock(OrganisationalUnitDao.class),
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act
    List<AppGroupEntry> actualRemoveChangeInitiativeResult =
        appGroupService.removeChangeInitiative("janedoe", 1L, 1L);

    // Assert
    verify(appGroupMemberDao).canUpdate(1L, "janedoe");
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    verify(entityRelationshipDao).remove(isA(EntityRelationshipKey.class));
    assertTrue(actualRemoveChangeInitiativeResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#removeChangeInitiative(String, long, long)}.
   *
   * <p>Method under test: {@link AppGroupService#removeChangeInitiative(String, long, long)}
   */
  @Test
  @DisplayName("Test removeChangeInitiative(String, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeChangeInitiative(String, long, long)"})
  void testRemoveChangeInitiative4() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.remove(Mockito.<EntityRelationshipKey>any())).thenReturn(true);

    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();

    Builder builderResult = ImmutableEntityRelationship.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    entityRelationshipList.add(
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .relationship("127.0.0.1")
            .build());

    Builder builderResult2 = ImmutableEntityRelationship.builder();

    Builder aResult2 =
        builderResult2.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    entityRelationshipList.add(
        aResult2
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .relationship("127.0.0.1")
            .build());

    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(entityRelationshipList);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
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

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
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

    AppGroupService appGroupService =
        new AppGroupService(
            mock(AppGroupDao.class),
            appGroupMemberDao,
            mock(AppGroupEntryDao.class),
            mock(ApplicationDao.class),
            mock(AppGroupOrganisationalUnitDao.class),
            mock(OrganisationalUnitDao.class),
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act
    List<AppGroupEntry> actualRemoveChangeInitiativeResult =
        appGroupService.removeChangeInitiative("janedoe", 1L, 1L);

    // Assert
    verify(appGroupMemberDao).canUpdate(1L, "janedoe");
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    verify(entityRelationshipDao).remove(isA(EntityRelationshipKey.class));
    assertTrue(actualRemoveChangeInitiativeResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#removeChangeInitiative(String, long, long)}.
   *
   * <p>Method under test: {@link AppGroupService#removeChangeInitiative(String, long, long)}
   */
  @Test
  @DisplayName("Test removeChangeInitiative(String, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeChangeInitiative(String, long, long)"})
  void testRemoveChangeInitiative5() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.remove(Mockito.<EntityRelationshipKey>any())).thenReturn(true);

    ChangeInitiativeService changeInitiativeService = mock(ChangeInitiativeService.class);
    when(changeInitiativeService.findEntriesForAppGroup(anyLong())).thenReturn(new ArrayList<>());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    AppGroupService appGroupService =
        new AppGroupService(
            mock(AppGroupDao.class),
            appGroupMemberDao,
            mock(AppGroupEntryDao.class),
            mock(ApplicationDao.class),
            mock(AppGroupOrganisationalUnitDao.class),
            mock(OrganisationalUnitDao.class),
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService);

    // Act
    List<AppGroupEntry> actualRemoveChangeInitiativeResult =
        appGroupService.removeChangeInitiative("janedoe", 1L, 1L);

    // Assert
    verify(appGroupMemberDao).canUpdate(1L, "janedoe");
    verify(entityRelationshipDao).remove(isA(EntityRelationshipKey.class));
    verify(changeInitiativeService).findEntriesForAppGroup(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualRemoveChangeInitiativeResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#removeChangeInitiative(String, long, long)}.
   *
   * <p>Method under test: {@link AppGroupService#removeChangeInitiative(String, long, long)}
   */
  @Test
  @DisplayName("Test removeChangeInitiative(String, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeChangeInitiative(String, long, long)"})
  void testRemoveChangeInitiative6() throws InsufficientPrivelegeException {
    // Arrange
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    when(entityRelationshipDao.remove(Mockito.<EntityRelationshipKey>any())).thenReturn(true);
    when(changeInitiativeService.findEntriesForAppGroup(anyLong()))
        .thenThrow(new IllegalArgumentException());
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> appGroupService.removeChangeInitiative("janedoe", 1L, 1L));
    verify(appGroupMemberDao).canUpdate(1L, "janedoe");
    verify(entityRelationshipDao).remove(isA(EntityRelationshipKey.class));
    verify(changeInitiativeService).findEntriesForAppGroup(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link AppGroupService#removeChangeInitiative(String, long, long)}.
   *
   * <ul>
   *   <li>Given {@link ChangeInitiativeService}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#removeChangeInitiative(String, long, long)}
   */
  @Test
  @DisplayName(
      "Test removeChangeInitiative(String, long, long); given ChangeInitiativeService; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeChangeInitiative(String, long, long)"})
  void testRemoveChangeInitiative_givenChangeInitiativeService_thenCallsWrite()
      throws InsufficientPrivelegeException {
    // Arrange
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    when(entityRelationshipDao.remove(Mockito.<EntityRelationshipKey>any())).thenReturn(true);
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> appGroupService.removeChangeInitiative("janedoe", 1L, 1L));
    verify(appGroupMemberDao).canUpdate(1L, "janedoe");
    verify(entityRelationshipDao).remove(isA(EntityRelationshipKey.class));
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link AppGroupService#removeChangeInitiative(String, long, long)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#removeChangeInitiative(String, long, long)}
   */
  @Test
  @DisplayName(
      "Test removeChangeInitiative(String, long, long); then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeChangeInitiative(String, long, long)"})
  void testRemoveChangeInitiative_thenCallsWrite() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.remove(Mockito.<EntityRelationshipKey>any())).thenReturn(true);

    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
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

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
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

    AppGroupService appGroupService =
        new AppGroupService(
            mock(AppGroupDao.class),
            appGroupMemberDao,
            mock(AppGroupEntryDao.class),
            mock(ApplicationDao.class),
            mock(AppGroupOrganisationalUnitDao.class),
            mock(OrganisationalUnitDao.class),
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act
    List<AppGroupEntry> actualRemoveChangeInitiativeResult =
        appGroupService.removeChangeInitiative("janedoe", 1L, 1L);

    // Assert
    verify(appGroupMemberDao).canUpdate(1L, "janedoe");
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    verify(entityRelationshipDao).remove(isA(EntityRelationshipKey.class));
    assertTrue(actualRemoveChangeInitiativeResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#removeChangeInitiative(String, long, long)}.
   *
   * <ul>
   *   <li>Then throw {@link InsufficientPrivelegeException}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#removeChangeInitiative(String, long, long)}
   */
  @Test
  @DisplayName(
      "Test removeChangeInitiative(String, long, long); then throw InsufficientPrivelegeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeChangeInitiative(String, long, long)"})
  void testRemoveChangeInitiative_thenThrowInsufficientPrivelegeException()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);
    AppGroupService appGroupService =
        new AppGroupService(
            mock(AppGroupDao.class),
            appGroupMemberDao,
            mock(AppGroupEntryDao.class),
            mock(ApplicationDao.class),
            mock(AppGroupOrganisationalUnitDao.class),
            mock(OrganisationalUnitDao.class),
            mock(EntityRelationshipDao.class),
            mock(ChangeInitiativeService.class),
            mock(ChangeLogService.class));

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class,
        () -> appGroupService.removeChangeInitiative("janedoe", 1L, 1L));
    verify(appGroupMemberDao).canUpdate(1L, "janedoe");
  }

  /**
   * Test {@link AppGroupService#addChangeInitiatives(String, long, List)}.
   *
   * <p>Method under test: {@link AppGroupService#addChangeInitiatives(String, long, List)}
   */
  @Test
  @DisplayName("Test addChangeInitiatives(String, long, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addChangeInitiatives(String, long, List)"})
  void testAddChangeInitiatives() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> appGroupService.addChangeInitiatives("42", 1L, new ArrayList<>()));
    verify(appGroupMemberDao).canUpdate(1L, "42");
  }

  /**
   * Test {@link AppGroupService#addChangeInitiatives(String, long, List)}.
   *
   * <p>Method under test: {@link AppGroupService#addChangeInitiatives(String, long, List)}
   */
  @Test
  @DisplayName("Test addChangeInitiatives(String, long, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addChangeInitiatives(String, long, List)"})
  void testAddChangeInitiatives2() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.saveAll(Mockito.<String>any(), anyLong(), Mockito.<List<Long>>any()))
        .thenThrow(new IllegalArgumentException());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> appGroupService.addChangeInitiatives("42", 1L, new ArrayList<>()));
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(entityRelationshipDao).saveAll(eq("42"), eq(1L), isA(List.class));
  }

  /**
   * Test {@link AppGroupService#addChangeInitiatives(String, long, List)}.
   *
   * <p>Method under test: {@link AppGroupService#addChangeInitiatives(String, long, List)}
   */
  @Test
  @DisplayName("Test addChangeInitiatives(String, long, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addChangeInitiatives(String, long, List)"})
  void testAddChangeInitiatives3() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.saveAll(Mockito.<String>any(), anyLong(), Mockito.<List<Long>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();

    Builder builderResult = ImmutableEntityRelationship.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    entityRelationshipList.add(
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .relationship("127.0.0.1")
            .build());

    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(entityRelationshipList);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
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

    AppGroupService appGroupService =
        new AppGroupService(
            mock(AppGroupDao.class),
            appGroupMemberDao,
            mock(AppGroupEntryDao.class),
            mock(ApplicationDao.class),
            mock(AppGroupOrganisationalUnitDao.class),
            mock(OrganisationalUnitDao.class),
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act
    List<AppGroupEntry> actualAddChangeInitiativesResult =
        appGroupService.addChangeInitiatives("42", 1L, new ArrayList<>());

    // Assert
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(changeLogDao).write(isA(Collection.class));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    verify(entityRelationshipDao).saveAll(eq("42"), eq(1L), isA(List.class));
    assertTrue(actualAddChangeInitiativesResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#addChangeInitiatives(String, long, List)}.
   *
   * <p>Method under test: {@link AppGroupService#addChangeInitiatives(String, long, List)}
   */
  @Test
  @DisplayName("Test addChangeInitiatives(String, long, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addChangeInitiatives(String, long, List)"})
  void testAddChangeInitiatives4() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.saveAll(Mockito.<String>any(), anyLong(), Mockito.<List<Long>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();

    Builder builderResult = ImmutableEntityRelationship.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    entityRelationshipList.add(
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .relationship("127.0.0.1")
            .build());

    Builder builderResult2 = ImmutableEntityRelationship.builder();

    Builder aResult2 =
        builderResult2.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    entityRelationshipList.add(
        aResult2
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .relationship("127.0.0.1")
            .build());

    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(entityRelationshipList);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
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

    AppGroupService appGroupService =
        new AppGroupService(
            mock(AppGroupDao.class),
            appGroupMemberDao,
            mock(AppGroupEntryDao.class),
            mock(ApplicationDao.class),
            mock(AppGroupOrganisationalUnitDao.class),
            mock(OrganisationalUnitDao.class),
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act
    List<AppGroupEntry> actualAddChangeInitiativesResult =
        appGroupService.addChangeInitiatives("42", 1L, new ArrayList<>());

    // Assert
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(changeLogDao).write(isA(Collection.class));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    verify(entityRelationshipDao).saveAll(eq("42"), eq(1L), isA(List.class));
    assertTrue(actualAddChangeInitiativesResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#addChangeInitiatives(String, long, List)}.
   *
   * <p>Method under test: {@link AppGroupService#addChangeInitiatives(String, long, List)}
   */
  @Test
  @DisplayName("Test addChangeInitiatives(String, long, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addChangeInitiatives(String, long, List)"})
  void testAddChangeInitiatives5() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.saveAll(Mockito.<String>any(), anyLong(), Mockito.<List<Long>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    ChangeInitiativeService changeInitiativeService = mock(ChangeInitiativeService.class);
    when(changeInitiativeService.findEntriesForAppGroup(anyLong())).thenReturn(new ArrayList<>());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    AppGroupService appGroupService =
        new AppGroupService(
            mock(AppGroupDao.class),
            appGroupMemberDao,
            mock(AppGroupEntryDao.class),
            mock(ApplicationDao.class),
            mock(AppGroupOrganisationalUnitDao.class),
            mock(OrganisationalUnitDao.class),
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService);

    // Act
    List<AppGroupEntry> actualAddChangeInitiativesResult =
        appGroupService.addChangeInitiatives("42", 1L, new ArrayList<>());

    // Assert
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(entityRelationshipDao).saveAll(eq("42"), eq(1L), isA(List.class));
    verify(changeInitiativeService).findEntriesForAppGroup(1L);
    verify(changeLogService).write(isA(Collection.class));
    assertTrue(actualAddChangeInitiativesResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#addChangeInitiatives(String, long, List)}.
   *
   * <p>Method under test: {@link AppGroupService#addChangeInitiatives(String, long, List)}
   */
  @Test
  @DisplayName("Test addChangeInitiatives(String, long, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addChangeInitiatives(String, long, List)"})
  void testAddChangeInitiatives6() throws InsufficientPrivelegeException {
    // Arrange
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    when(entityRelationshipDao.saveAll(Mockito.<String>any(), anyLong(), Mockito.<List<Long>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(changeInitiativeService.findEntriesForAppGroup(anyLong()))
        .thenThrow(new IllegalArgumentException());
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> appGroupService.addChangeInitiatives("42", 1L, new ArrayList<>()));
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(entityRelationshipDao).saveAll(eq("42"), eq(1L), isA(List.class));
    verify(changeInitiativeService).findEntriesForAppGroup(1L);
    verify(changeLogService).write(isA(Collection.class));
  }

  /**
   * Test {@link AppGroupService#addChangeInitiatives(String, long, List)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(Collection)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#addChangeInitiatives(String, long, List)}
   */
  @Test
  @DisplayName(
      "Test addChangeInitiatives(String, long, List); given ChangeLogService write(Collection) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addChangeInitiatives(String, long, List)"})
  void testAddChangeInitiatives_givenChangeLogServiceWriteThrowIllegalArgumentException()
      throws InsufficientPrivelegeException {
    // Arrange
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    when(entityRelationshipDao.saveAll(Mockito.<String>any(), anyLong(), Mockito.<List<Long>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> appGroupService.addChangeInitiatives("42", 1L, new ArrayList<>()));
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(entityRelationshipDao).saveAll(eq("42"), eq(1L), isA(List.class));
    verify(changeLogService).write(isA(Collection.class));
  }

  /**
   * Test {@link AppGroupService#addChangeInitiatives(String, long, List)}.
   *
   * <ul>
   *   <li>Given fifteen.
   *   <li>When {@link ArrayList#ArrayList()} add fifteen.
   *   <li>Then calls {@link ChangeLogDao#write(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#addChangeInitiatives(String, long, List)}
   */
  @Test
  @DisplayName(
      "Test addChangeInitiatives(String, long, List); given fifteen; when ArrayList() add fifteen; then calls write(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addChangeInitiatives(String, long, List)"})
  void testAddChangeInitiatives_givenFifteen_whenArrayListAddFifteen_thenCallsWrite()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.saveAll(Mockito.<String>any(), anyLong(), Mockito.<List<Long>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
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

    AppGroupService appGroupService =
        new AppGroupService(
            mock(AppGroupDao.class),
            appGroupMemberDao,
            mock(AppGroupEntryDao.class),
            mock(ApplicationDao.class),
            mock(AppGroupOrganisationalUnitDao.class),
            mock(OrganisationalUnitDao.class),
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    ArrayList<Long> changeInitiativeIds = new ArrayList<>();
    changeInitiativeIds.add(15L);
    changeInitiativeIds.add(1L);

    // Act
    List<AppGroupEntry> actualAddChangeInitiativesResult =
        appGroupService.addChangeInitiatives("42", 1L, changeInitiativeIds);

    // Assert
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(changeLogDao).write(isA(Collection.class));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    verify(entityRelationshipDao).saveAll(eq("42"), eq(1L), isA(List.class));
    assertTrue(actualAddChangeInitiativesResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#addChangeInitiatives(String, long, List)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   *   <li>Then calls {@link ChangeLogDao#write(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#addChangeInitiatives(String, long, List)}
   */
  @Test
  @DisplayName(
      "Test addChangeInitiatives(String, long, List); given one; when ArrayList() add one; then calls write(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addChangeInitiatives(String, long, List)"})
  void testAddChangeInitiatives_givenOne_whenArrayListAddOne_thenCallsWrite()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.saveAll(Mockito.<String>any(), anyLong(), Mockito.<List<Long>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
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

    AppGroupService appGroupService =
        new AppGroupService(
            mock(AppGroupDao.class),
            appGroupMemberDao,
            mock(AppGroupEntryDao.class),
            mock(ApplicationDao.class),
            mock(AppGroupOrganisationalUnitDao.class),
            mock(OrganisationalUnitDao.class),
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    ArrayList<Long> changeInitiativeIds = new ArrayList<>();
    changeInitiativeIds.add(1L);

    // Act
    List<AppGroupEntry> actualAddChangeInitiativesResult =
        appGroupService.addChangeInitiatives("42", 1L, changeInitiativeIds);

    // Assert
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(changeLogDao).write(isA(Collection.class));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    verify(entityRelationshipDao).saveAll(eq("42"), eq(1L), isA(List.class));
    assertTrue(actualAddChangeInitiativesResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#addChangeInitiatives(String, long, List)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogDao#write(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#addChangeInitiatives(String, long, List)}
   */
  @Test
  @DisplayName("Test addChangeInitiatives(String, long, List); then calls write(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addChangeInitiatives(String, long, List)"})
  void testAddChangeInitiatives_thenCallsWrite() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.saveAll(Mockito.<String>any(), anyLong(), Mockito.<List<Long>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
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

    AppGroupService appGroupService =
        new AppGroupService(
            mock(AppGroupDao.class),
            appGroupMemberDao,
            mock(AppGroupEntryDao.class),
            mock(ApplicationDao.class),
            mock(AppGroupOrganisationalUnitDao.class),
            mock(OrganisationalUnitDao.class),
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act
    List<AppGroupEntry> actualAddChangeInitiativesResult =
        appGroupService.addChangeInitiatives("42", 1L, new ArrayList<>());

    // Assert
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(changeLogDao).write(isA(Collection.class));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    verify(entityRelationshipDao).saveAll(eq("42"), eq(1L), isA(List.class));
    assertTrue(actualAddChangeInitiativesResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#addChangeInitiatives(String, long, List)}.
   *
   * <ul>
   *   <li>Then throw {@link InsufficientPrivelegeException}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#addChangeInitiatives(String, long, List)}
   */
  @Test
  @DisplayName(
      "Test addChangeInitiatives(String, long, List); then throw InsufficientPrivelegeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.addChangeInitiatives(String, long, List)"})
  void testAddChangeInitiatives_thenThrowInsufficientPrivelegeException()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);
    AppGroupService appGroupService =
        new AppGroupService(
            mock(AppGroupDao.class),
            appGroupMemberDao,
            mock(AppGroupEntryDao.class),
            mock(ApplicationDao.class),
            mock(AppGroupOrganisationalUnitDao.class),
            mock(OrganisationalUnitDao.class),
            mock(EntityRelationshipDao.class),
            mock(ChangeInitiativeService.class),
            mock(ChangeLogService.class));

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class,
        () -> appGroupService.addChangeInitiatives("42", 1L, new ArrayList<>()));
    verify(appGroupMemberDao).canUpdate(1L, "42");
  }

  /**
   * Test {@link AppGroupService#removeChangeInitiatives(String, long, List)}.
   *
   * <p>Method under test: {@link AppGroupService#removeChangeInitiatives(String, long, List)}
   */
  @Test
  @DisplayName("Test removeChangeInitiatives(String, long, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeChangeInitiatives(String, long, List)"})
  void testRemoveChangeInitiatives() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> appGroupService.removeChangeInitiatives("42", 1L, new ArrayList<>()));
    verify(appGroupMemberDao).canUpdate(1L, "42");
  }

  /**
   * Test {@link AppGroupService#removeChangeInitiatives(String, long, List)}.
   *
   * <p>Method under test: {@link AppGroupService#removeChangeInitiatives(String, long, List)}
   */
  @Test
  @DisplayName("Test removeChangeInitiatives(String, long, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeChangeInitiatives(String, long, List)"})
  void testRemoveChangeInitiatives2() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.removeAll(anyLong(), Mockito.<List<Long>>any()))
        .thenThrow(new IllegalArgumentException());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao =
        mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> appGroupService.removeChangeInitiatives("42", 1L, new ArrayList<>()));
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(entityRelationshipDao).removeAll(eq(1L), isA(List.class));
  }

  /**
   * Test {@link AppGroupService#removeChangeInitiatives(String, long, List)}.
   *
   * <p>Method under test: {@link AppGroupService#removeChangeInitiatives(String, long, List)}
   */
  @Test
  @DisplayName("Test removeChangeInitiatives(String, long, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeChangeInitiatives(String, long, List)"})
  void testRemoveChangeInitiatives3() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.removeAll(anyLong(), Mockito.<List<Long>>any())).thenReturn(1);

    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();

    Builder builderResult = ImmutableEntityRelationship.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    entityRelationshipList.add(
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .relationship("127.0.0.1")
            .build());

    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(entityRelationshipList);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
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

    AppGroupService appGroupService =
        new AppGroupService(
            mock(AppGroupDao.class),
            appGroupMemberDao,
            mock(AppGroupEntryDao.class),
            mock(ApplicationDao.class),
            mock(AppGroupOrganisationalUnitDao.class),
            mock(OrganisationalUnitDao.class),
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act
    List<AppGroupEntry> actualRemoveChangeInitiativesResult =
        appGroupService.removeChangeInitiatives("42", 1L, new ArrayList<>());

    // Assert
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(changeLogDao).write(isA(Collection.class));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    verify(entityRelationshipDao).removeAll(eq(1L), isA(List.class));
    assertTrue(actualRemoveChangeInitiativesResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#removeChangeInitiatives(String, long, List)}.
   *
   * <p>Method under test: {@link AppGroupService#removeChangeInitiatives(String, long, List)}
   */
  @Test
  @DisplayName("Test removeChangeInitiatives(String, long, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeChangeInitiatives(String, long, List)"})
  void testRemoveChangeInitiatives4() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.removeAll(anyLong(), Mockito.<List<Long>>any())).thenReturn(1);

    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();

    Builder builderResult = ImmutableEntityRelationship.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    entityRelationshipList.add(
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .relationship("127.0.0.1")
            .build());

    Builder builderResult2 = ImmutableEntityRelationship.builder();

    Builder aResult2 =
        builderResult2.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    entityRelationshipList.add(
        aResult2
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .relationship("127.0.0.1")
            .build());

    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(entityRelationshipList);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
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

    AppGroupService appGroupService =
        new AppGroupService(
            mock(AppGroupDao.class),
            appGroupMemberDao,
            mock(AppGroupEntryDao.class),
            mock(ApplicationDao.class),
            mock(AppGroupOrganisationalUnitDao.class),
            mock(OrganisationalUnitDao.class),
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act
    List<AppGroupEntry> actualRemoveChangeInitiativesResult =
        appGroupService.removeChangeInitiatives("42", 1L, new ArrayList<>());

    // Assert
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(changeLogDao).write(isA(Collection.class));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    verify(entityRelationshipDao).removeAll(eq(1L), isA(List.class));
    assertTrue(actualRemoveChangeInitiativesResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#removeChangeInitiatives(String, long, List)}.
   *
   * <p>Method under test: {@link AppGroupService#removeChangeInitiatives(String, long, List)}
   */
  @Test
  @DisplayName("Test removeChangeInitiatives(String, long, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeChangeInitiatives(String, long, List)"})
  void testRemoveChangeInitiatives5() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.removeAll(anyLong(), Mockito.<List<Long>>any())).thenReturn(1);

    ChangeInitiativeService changeInitiativeService = mock(ChangeInitiativeService.class);
    when(changeInitiativeService.findEntriesForAppGroup(anyLong())).thenReturn(new ArrayList<>());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    AppGroupService appGroupService =
        new AppGroupService(
            mock(AppGroupDao.class),
            appGroupMemberDao,
            mock(AppGroupEntryDao.class),
            mock(ApplicationDao.class),
            mock(AppGroupOrganisationalUnitDao.class),
            mock(OrganisationalUnitDao.class),
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService);

    // Act
    List<AppGroupEntry> actualRemoveChangeInitiativesResult =
        appGroupService.removeChangeInitiatives("42", 1L, new ArrayList<>());

    // Assert
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(entityRelationshipDao).removeAll(eq(1L), isA(List.class));
    verify(changeInitiativeService).findEntriesForAppGroup(1L);
    verify(changeLogService).write(isA(Collection.class));
    assertTrue(actualRemoveChangeInitiativesResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#removeChangeInitiatives(String, long, List)}.
   *
   * <p>Method under test: {@link AppGroupService#removeChangeInitiatives(String, long, List)}
   */
  @Test
  @DisplayName("Test removeChangeInitiatives(String, long, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeChangeInitiatives(String, long, List)"})
  void testRemoveChangeInitiatives6() throws InsufficientPrivelegeException {
    // Arrange
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    when(entityRelationshipDao.removeAll(anyLong(), Mockito.<List<Long>>any())).thenReturn(1);
    when(changeInitiativeService.findEntriesForAppGroup(anyLong()))
        .thenThrow(new IllegalArgumentException());
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> appGroupService.removeChangeInitiatives("42", 1L, new ArrayList<>()));
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(entityRelationshipDao).removeAll(eq(1L), isA(List.class));
    verify(changeInitiativeService).findEntriesForAppGroup(1L);
    verify(changeLogService).write(isA(Collection.class));
  }

  /**
   * Test {@link AppGroupService#removeChangeInitiatives(String, long, List)}.
   *
   * <ul>
   *   <li>Given {@link ChangeInitiativeService}.
   *   <li>Then calls {@link ChangeLogService#write(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#removeChangeInitiatives(String, long, List)}
   */
  @Test
  @DisplayName(
      "Test removeChangeInitiatives(String, long, List); given ChangeInitiativeService; then calls write(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeChangeInitiatives(String, long, List)"})
  void testRemoveChangeInitiatives_givenChangeInitiativeService_thenCallsWrite()
      throws InsufficientPrivelegeException {
    // Arrange
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    when(entityRelationshipDao.removeAll(anyLong(), Mockito.<List<Long>>any())).thenReturn(1);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> appGroupService.removeChangeInitiatives("42", 1L, new ArrayList<>()));
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(entityRelationshipDao).removeAll(eq(1L), isA(List.class));
    verify(changeLogService).write(isA(Collection.class));
  }

  /**
   * Test {@link AppGroupService#removeChangeInitiatives(String, long, List)}.
   *
   * <ul>
   *   <li>Given fifteen.
   *   <li>When {@link ArrayList#ArrayList()} add fifteen.
   *   <li>Then calls {@link ChangeLogDao#write(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#removeChangeInitiatives(String, long, List)}
   */
  @Test
  @DisplayName(
      "Test removeChangeInitiatives(String, long, List); given fifteen; when ArrayList() add fifteen; then calls write(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeChangeInitiatives(String, long, List)"})
  void testRemoveChangeInitiatives_givenFifteen_whenArrayListAddFifteen_thenCallsWrite()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.removeAll(anyLong(), Mockito.<List<Long>>any())).thenReturn(1);

    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
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

    AppGroupService appGroupService =
        new AppGroupService(
            mock(AppGroupDao.class),
            appGroupMemberDao,
            mock(AppGroupEntryDao.class),
            mock(ApplicationDao.class),
            mock(AppGroupOrganisationalUnitDao.class),
            mock(OrganisationalUnitDao.class),
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    ArrayList<Long> changeInitiativeIds = new ArrayList<>();
    changeInitiativeIds.add(15L);
    changeInitiativeIds.add(1L);

    // Act
    List<AppGroupEntry> actualRemoveChangeInitiativesResult =
        appGroupService.removeChangeInitiatives("42", 1L, changeInitiativeIds);

    // Assert
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(changeLogDao).write(isA(Collection.class));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    verify(entityRelationshipDao).removeAll(eq(1L), isA(List.class));
    assertTrue(actualRemoveChangeInitiativesResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#removeChangeInitiatives(String, long, List)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   *   <li>Then calls {@link ChangeLogDao#write(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#removeChangeInitiatives(String, long, List)}
   */
  @Test
  @DisplayName(
      "Test removeChangeInitiatives(String, long, List); given one; when ArrayList() add one; then calls write(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeChangeInitiatives(String, long, List)"})
  void testRemoveChangeInitiatives_givenOne_whenArrayListAddOne_thenCallsWrite()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.removeAll(anyLong(), Mockito.<List<Long>>any())).thenReturn(1);

    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
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

    AppGroupService appGroupService =
        new AppGroupService(
            mock(AppGroupDao.class),
            appGroupMemberDao,
            mock(AppGroupEntryDao.class),
            mock(ApplicationDao.class),
            mock(AppGroupOrganisationalUnitDao.class),
            mock(OrganisationalUnitDao.class),
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    ArrayList<Long> changeInitiativeIds = new ArrayList<>();
    changeInitiativeIds.add(1L);

    // Act
    List<AppGroupEntry> actualRemoveChangeInitiativesResult =
        appGroupService.removeChangeInitiatives("42", 1L, changeInitiativeIds);

    // Assert
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(changeLogDao).write(isA(Collection.class));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    verify(entityRelationshipDao).removeAll(eq(1L), isA(List.class));
    assertTrue(actualRemoveChangeInitiativesResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#removeChangeInitiatives(String, long, List)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogDao#write(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#removeChangeInitiatives(String, long, List)}
   */
  @Test
  @DisplayName("Test removeChangeInitiatives(String, long, List); then calls write(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeChangeInitiatives(String, long, List)"})
  void testRemoveChangeInitiatives_thenCallsWrite() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.removeAll(anyLong(), Mockito.<List<Long>>any())).thenReturn(1);

    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
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

    AppGroupService appGroupService =
        new AppGroupService(
            mock(AppGroupDao.class),
            appGroupMemberDao,
            mock(AppGroupEntryDao.class),
            mock(ApplicationDao.class),
            mock(AppGroupOrganisationalUnitDao.class),
            mock(OrganisationalUnitDao.class),
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act
    List<AppGroupEntry> actualRemoveChangeInitiativesResult =
        appGroupService.removeChangeInitiatives("42", 1L, new ArrayList<>());

    // Assert
    verify(appGroupMemberDao).canUpdate(1L, "42");
    verify(changeLogDao).write(isA(Collection.class));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    verify(entityRelationshipDao).removeAll(eq(1L), isA(List.class));
    assertTrue(actualRemoveChangeInitiativesResult.isEmpty());
  }

  /**
   * Test {@link AppGroupService#removeChangeInitiatives(String, long, List)}.
   *
   * <ul>
   *   <li>Then throw {@link InsufficientPrivelegeException}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#removeChangeInitiatives(String, long, List)}
   */
  @Test
  @DisplayName(
      "Test removeChangeInitiatives(String, long, List); then throw InsufficientPrivelegeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupService.removeChangeInitiatives(String, long, List)"})
  void testRemoveChangeInitiatives_thenThrowInsufficientPrivelegeException()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);
    AppGroupService appGroupService =
        new AppGroupService(
            mock(AppGroupDao.class),
            appGroupMemberDao,
            mock(AppGroupEntryDao.class),
            mock(ApplicationDao.class),
            mock(AppGroupOrganisationalUnitDao.class),
            mock(OrganisationalUnitDao.class),
            mock(EntityRelationshipDao.class),
            mock(ChangeInitiativeService.class),
            mock(ChangeLogService.class));

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class,
        () -> appGroupService.removeChangeInitiatives("42", 1L, new ArrayList<>()));
    verify(appGroupMemberDao).canUpdate(1L, "42");
  }

  /**
   * Test {@link AppGroupService#replaceGroupEntries(Set)}.
   *
   * <p>Method under test: {@link AppGroupService#replaceGroupEntries(Set)}
   */
  @Test
  @DisplayName("Test replaceGroupEntries(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupService.replaceGroupEntries(Set)"})
  void testReplaceGroupEntries() {
    // Arrange
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    doNothing()
        .when(appGroupEntryDao)
        .replaceGroupApplicationEntries(Mockito.<Set<Tuple2<Long, Set<AppGroupEntry>>>>any());
    doNothing()
        .when(appGroupEntryDao)
        .replaceGroupChangeInitiativeEntries(Mockito.<Set<Tuple2<Long, Set<AppGroupEntry>>>>any());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    HashSet<AppGroupEntry> appGroupEntrySet = new HashSet<>();
    appGroupEntrySet.add(
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build());
    Tuple3<EntityKind, Long, Set<AppGroupEntry>> tuple3 =
        new Tuple3<>(EntityKind.APPLICATION, 1L, appGroupEntrySet);

    HashSet<Tuple3<EntityKind, Long, Set<AppGroupEntry>>> entriesForGroups = new HashSet<>();
    Tuple3<EntityKind, Long, Set<AppGroupEntry>> tuple32 =
        new Tuple3<>(EntityKind.ALL, 6L, new HashSet<>());
    entriesForGroups.add(tuple32);
    entriesForGroups.add(tuple3);

    // Act
    appGroupService.replaceGroupEntries(entriesForGroups);

    // Assert
    verify(appGroupEntryDao).replaceGroupApplicationEntries(isA(Set.class));
    verify(appGroupEntryDao).replaceGroupChangeInitiativeEntries(isA(Set.class));
  }

  /**
   * Test {@link AppGroupService#replaceGroupEntries(Set)}.
   *
   * <ul>
   *   <li>Given {@link Tuple3#Tuple3(Object, Object, Object)} with v1 is {@code ALL} and v2 is one
   *       and v3 is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#replaceGroupEntries(Set)}
   */
  @Test
  @DisplayName(
      "Test replaceGroupEntries(Set); given Tuple3(Object, Object, Object) with v1 is 'ALL' and v2 is one and v3 is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupService.replaceGroupEntries(Set)"})
  void testReplaceGroupEntries_givenTuple3WithV1IsAllAndV2IsOneAndV3IsHashSet() {
    // Arrange
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    doNothing()
        .when(appGroupEntryDao)
        .replaceGroupApplicationEntries(Mockito.<Set<Tuple2<Long, Set<AppGroupEntry>>>>any());
    doNothing()
        .when(appGroupEntryDao)
        .replaceGroupChangeInitiativeEntries(Mockito.<Set<Tuple2<Long, Set<AppGroupEntry>>>>any());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    HashSet<Tuple3<EntityKind, Long, Set<AppGroupEntry>>> entriesForGroups = new HashSet<>();
    Tuple3<EntityKind, Long, Set<AppGroupEntry>> tuple3 =
        new Tuple3<>(EntityKind.ALL, 1L, new HashSet<>());
    entriesForGroups.add(tuple3);

    // Act
    appGroupService.replaceGroupEntries(entriesForGroups);

    // Assert
    verify(appGroupEntryDao).replaceGroupApplicationEntries(isA(Set.class));
    verify(appGroupEntryDao).replaceGroupChangeInitiativeEntries(isA(Set.class));
  }

  /**
   * Test {@link AppGroupService#replaceGroupEntries(Set)}.
   *
   * <ul>
   *   <li>Given {@link Tuple3#Tuple3(Object, Object, Object)} with v1 is {@code ALL} and v2 is one
   *       and v3 is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#replaceGroupEntries(Set)}
   */
  @Test
  @DisplayName(
      "Test replaceGroupEntries(Set); given Tuple3(Object, Object, Object) with v1 is 'ALL' and v2 is one and v3 is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupService.replaceGroupEntries(Set)"})
  void testReplaceGroupEntries_givenTuple3WithV1IsAllAndV2IsOneAndV3IsHashSet2() {
    // Arrange
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    doNothing()
        .when(appGroupEntryDao)
        .replaceGroupApplicationEntries(Mockito.<Set<Tuple2<Long, Set<AppGroupEntry>>>>any());
    doNothing()
        .when(appGroupEntryDao)
        .replaceGroupChangeInitiativeEntries(Mockito.<Set<Tuple2<Long, Set<AppGroupEntry>>>>any());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    HashSet<Tuple3<EntityKind, Long, Set<AppGroupEntry>>> entriesForGroups = new HashSet<>();
    Tuple3<EntityKind, Long, Set<AppGroupEntry>> tuple3 =
        new Tuple3<>(EntityKind.ALL, 6L, new HashSet<>());
    entriesForGroups.add(tuple3);
    Tuple3<EntityKind, Long, Set<AppGroupEntry>> tuple32 =
        new Tuple3<>(EntityKind.ALL, 1L, new HashSet<>());
    entriesForGroups.add(tuple32);

    // Act
    appGroupService.replaceGroupEntries(entriesForGroups);

    // Assert
    verify(appGroupEntryDao).replaceGroupApplicationEntries(isA(Set.class));
    verify(appGroupEntryDao).replaceGroupChangeInitiativeEntries(isA(Set.class));
  }

  /**
   * Test {@link AppGroupService#replaceGroupEntries(Set)}.
   *
   * <ul>
   *   <li>Given {@link Tuple3#Tuple3(Object, Object, Object)} with v1 is {@code APPLICATION} and v2
   *       is one and v3 is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#replaceGroupEntries(Set)}
   */
  @Test
  @DisplayName(
      "Test replaceGroupEntries(Set); given Tuple3(Object, Object, Object) with v1 is 'APPLICATION' and v2 is one and v3 is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupService.replaceGroupEntries(Set)"})
  void testReplaceGroupEntries_givenTuple3WithV1IsApplicationAndV2IsOneAndV3IsHashSet() {
    // Arrange
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    doNothing()
        .when(appGroupEntryDao)
        .replaceGroupApplicationEntries(Mockito.<Set<Tuple2<Long, Set<AppGroupEntry>>>>any());
    doNothing()
        .when(appGroupEntryDao)
        .replaceGroupChangeInitiativeEntries(Mockito.<Set<Tuple2<Long, Set<AppGroupEntry>>>>any());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    HashSet<Tuple3<EntityKind, Long, Set<AppGroupEntry>>> entriesForGroups = new HashSet<>();
    Tuple3<EntityKind, Long, Set<AppGroupEntry>> tuple3 =
        new Tuple3<>(EntityKind.ALL, 6L, new HashSet<>());
    entriesForGroups.add(tuple3);
    Tuple3<EntityKind, Long, Set<AppGroupEntry>> tuple32 =
        new Tuple3<>(EntityKind.APPLICATION, 1L, new HashSet<>());
    entriesForGroups.add(tuple32);

    // Act
    appGroupService.replaceGroupEntries(entriesForGroups);

    // Assert
    verify(appGroupEntryDao).replaceGroupApplicationEntries(isA(Set.class));
    verify(appGroupEntryDao).replaceGroupChangeInitiativeEntries(isA(Set.class));
  }

  /**
   * Test {@link AppGroupService#replaceGroupEntries(Set)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#replaceGroupEntries(Set)}
   */
  @Test
  @DisplayName("Test replaceGroupEntries(Set); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupService.replaceGroupEntries(Set)"})
  void testReplaceGroupEntries_thenThrowIllegalArgumentException() {
    // Arrange
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    doThrow(new IllegalArgumentException())
        .when(appGroupEntryDao)
        .replaceGroupApplicationEntries(Mockito.<Set<Tuple2<Long, Set<AppGroupEntry>>>>any());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> appGroupService.replaceGroupEntries(new HashSet<>()));
    verify(appGroupEntryDao).replaceGroupApplicationEntries(isA(Set.class));
  }

  /**
   * Test {@link AppGroupService#replaceGroupEntries(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then calls {@link AppGroupEntryDao#replaceGroupChangeInitiativeEntries(Set)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#replaceGroupEntries(Set)}
   */
  @Test
  @DisplayName(
      "Test replaceGroupEntries(Set); when HashSet(); then calls replaceGroupChangeInitiativeEntries(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupService.replaceGroupEntries(Set)"})
  void testReplaceGroupEntries_whenHashSet_thenCallsReplaceGroupChangeInitiativeEntries() {
    // Arrange
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    doNothing()
        .when(appGroupEntryDao)
        .replaceGroupApplicationEntries(Mockito.<Set<Tuple2<Long, Set<AppGroupEntry>>>>any());
    doNothing()
        .when(appGroupEntryDao)
        .replaceGroupChangeInitiativeEntries(Mockito.<Set<Tuple2<Long, Set<AppGroupEntry>>>>any());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act
    appGroupService.replaceGroupEntries(new HashSet<>());

    // Assert
    verify(appGroupEntryDao).replaceGroupApplicationEntries(isA(Set.class));
    verify(appGroupEntryDao).replaceGroupChangeInitiativeEntries(isA(Set.class));
  }

  /**
   * Test {@link AppGroupService#synchGroupEntries(Set, String)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogDao#write(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#synchGroupEntries(Set, String)}
   */
  @Test
  @DisplayName("Test synchGroupEntries(Set, String); then calls write(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupService.synchGroupEntries(Set, String)"})
  void testSynchGroupEntries_thenCallsWrite() {
    // Arrange
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

    // Act
    appGroupService.synchGroupEntries(new HashSet<>(), "42");

    // Assert
    verify(appGroupDao).processAdditionsAndRemovals(isA(Set.class), isA(Set.class), eq("42"));
    verify(appGroupEntryDao).fetchEntitiesForGroups(isA(Set.class));
    verify(changeLogDao).write(isA(Collection.class));
  }

  /**
   * Test {@link AppGroupService#synchGroupEntries(Set, String)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogDao#write(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#synchGroupEntries(Set, String)}
   */
  @Test
  @DisplayName("Test synchGroupEntries(Set, String); then calls write(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupService.synchGroupEntries(Set, String)"})
  void testSynchGroupEntries_thenCallsWrite2() {
    // Arrange
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

    HashSet<Tuple3<EntityKind, Long, Set<EntityReference>>> entriesForGroups = new HashSet<>();
    Tuple3<EntityKind, Long, Set<EntityReference>> tuple3 =
        new Tuple3<>(EntityKind.ALL, 1L, new HashSet<>());
    entriesForGroups.add(tuple3);

    // Act
    appGroupService.synchGroupEntries(entriesForGroups, "42");

    // Assert
    verify(appGroupDao).processAdditionsAndRemovals(isA(Set.class), isA(Set.class), eq("42"));
    verify(appGroupEntryDao).fetchEntitiesForGroups(isA(Set.class));
    verify(changeLogDao).write(isA(Collection.class));
  }

  /**
   * Test {@link AppGroupService#synchGroupEntries(Set, String)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogService#write(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#synchGroupEntries(Set, String)}
   */
  @Test
  @DisplayName("Test synchGroupEntries(Set, String); then calls write(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupService.synchGroupEntries(Set, String)"})
  void testSynchGroupEntries_thenCallsWrite3() {
    // Arrange
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

    // Act
    appGroupService.synchGroupEntries(new HashSet<>(), "42");

    // Assert
    verify(appGroupDao).processAdditionsAndRemovals(isA(Set.class), isA(Set.class), eq("42"));
    verify(appGroupEntryDao).fetchEntitiesForGroups(isA(Set.class));
    verify(changeLogService).write(isA(Collection.class));
  }

  /**
   * Test {@link AppGroupService#synchGroupEntries(Set, String)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogService#write(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#synchGroupEntries(Set, String)}
   */
  @Test
  @DisplayName("Test synchGroupEntries(Set, String); then calls write(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupService.synchGroupEntries(Set, String)"})
  void testSynchGroupEntries_thenCallsWrite4() {
    // Arrange
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

    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    Tuple3<EntityKind, Long, Set<EntityReference>> tuple3 =
        new Tuple3<>(EntityKind.ALL, 1L, entityReferenceSet);

    HashSet<Tuple3<EntityKind, Long, Set<EntityReference>>> entriesForGroups = new HashSet<>();
    entriesForGroups.add(tuple3);

    // Act
    appGroupService.synchGroupEntries(entriesForGroups, "42");

    // Assert
    verify(appGroupDao).processAdditionsAndRemovals(isA(Set.class), isA(Set.class), eq("42"));
    verify(appGroupEntryDao).fetchEntitiesForGroups(isA(Set.class));
    verify(changeLogService).write(isA(Collection.class));
  }

  /**
   * Test {@link AppGroupService#synchGroupEntries(Set, String)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogService#write(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#synchGroupEntries(Set, String)}
   */
  @Test
  @DisplayName("Test synchGroupEntries(Set, String); then calls write(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupService.synchGroupEntries(Set, String)"})
  void testSynchGroupEntries_thenCallsWrite5() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.processAdditionsAndRemovals(
            Mockito.<Set<Tuple2<Long, EntityReference>>>any(),
            Mockito.<Set<Tuple2<Long, EntityReference>>>any(),
            Mockito.<String>any()))
        .thenReturn(42);

    HashMap<Long, List<EntityReference>> resultLongListMap = new HashMap<>();
    resultLongListMap.put(1L, new ArrayList<>());

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.fetchEntitiesForGroups(Mockito.<Set<Long>>any()))
        .thenReturn(resultLongListMap);

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

    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    Tuple3<EntityKind, Long, Set<EntityReference>> tuple3 =
        new Tuple3<>(EntityKind.ALL, 1L, entityReferenceSet);

    HashSet<Tuple3<EntityKind, Long, Set<EntityReference>>> entriesForGroups = new HashSet<>();
    entriesForGroups.add(tuple3);

    // Act
    appGroupService.synchGroupEntries(entriesForGroups, "42");

    // Assert
    verify(appGroupDao).processAdditionsAndRemovals(isA(Set.class), isA(Set.class), eq("42"));
    verify(appGroupEntryDao).fetchEntitiesForGroups(isA(Set.class));
    verify(changeLogService).write(isA(Collection.class));
  }

  /**
   * Test {@link AppGroupService#synchGroupEntries(Set, String)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogService#write(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#synchGroupEntries(Set, String)}
   */
  @Test
  @DisplayName("Test synchGroupEntries(Set, String); then calls write(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupService.synchGroupEntries(Set, String)"})
  void testSynchGroupEntries_thenCallsWrite6() {
    // Arrange
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

    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    Tuple3<EntityKind, Long, Set<EntityReference>> tuple3 =
        new Tuple3<>(EntityKind.ALL, 1L, entityReferenceSet);

    HashSet<Tuple3<EntityKind, Long, Set<EntityReference>>> entriesForGroups = new HashSet<>();
    Tuple3<EntityKind, Long, Set<EntityReference>> tuple32 =
        new Tuple3<>(EntityKind.ALL, 1L, new HashSet<>());
    entriesForGroups.add(tuple32);
    entriesForGroups.add(tuple3);

    // Act
    appGroupService.synchGroupEntries(entriesForGroups, "42");

    // Assert
    verify(appGroupDao).processAdditionsAndRemovals(isA(Set.class), isA(Set.class), eq("42"));
    verify(appGroupEntryDao).fetchEntitiesForGroups(isA(Set.class));
    verify(changeLogService).write(isA(Collection.class));
  }

  /**
   * Test {@link AppGroupService#synchGroupEntries(Set, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#synchGroupEntries(Set, String)}
   */
  @Test
  @DisplayName("Test synchGroupEntries(Set, String); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupService.synchGroupEntries(Set, String)"})
  void testSynchGroupEntries_thenThrowIllegalArgumentException() {
    // Arrange
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.fetchEntitiesForGroups(Mockito.<Set<Long>>any()))
        .thenThrow(new IllegalArgumentException());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> appGroupService.synchGroupEntries(new HashSet<>(), "42"));
    verify(appGroupEntryDao).fetchEntitiesForGroups(isA(Set.class));
  }

  /**
   * Test {@link AppGroupService#verifyUserCanUpdateGroup(String, long)}.
   *
   * <ul>
   *   <li>Given {@link AppGroupMemberDao} {@link AppGroupMemberDao#canUpdate(long, String)} return
   *       {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#verifyUserCanUpdateGroup(String, long)}
   */
  @Test
  @DisplayName(
      "Test verifyUserCanUpdateGroup(String, long); given AppGroupMemberDao canUpdate(long, String) return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupService.verifyUserCanUpdateGroup(String, long)"})
  void testVerifyUserCanUpdateGroup_givenAppGroupMemberDaoCanUpdateReturnTrue()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act
    appGroupService.verifyUserCanUpdateGroup("42", 1L);

    // Assert
    verify(appGroupMemberDao).canUpdate(1L, "42");
  }

  /**
   * Test {@link AppGroupService#verifyUserCanUpdateGroup(String, long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#verifyUserCanUpdateGroup(String, long)}
   */
  @Test
  @DisplayName("Test verifyUserCanUpdateGroup(String, long); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupService.verifyUserCanUpdateGroup(String, long)"})
  void testVerifyUserCanUpdateGroup_thenThrowIllegalArgumentException()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> appGroupService.verifyUserCanUpdateGroup("42", 1L));
    verify(appGroupMemberDao).canUpdate(1L, "42");
  }

  /**
   * Test {@link AppGroupService#verifyUserCanUpdateGroup(String, long)}.
   *
   * <ul>
   *   <li>Then throw {@link InsufficientPrivelegeException}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupService#verifyUserCanUpdateGroup(String, long)}
   */
  @Test
  @DisplayName(
      "Test verifyUserCanUpdateGroup(String, long); then throw InsufficientPrivelegeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupService.verifyUserCanUpdateGroup(String, long)"})
  void testVerifyUserCanUpdateGroup_thenThrowInsufficientPrivelegeException()
      throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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
            appGroupDao,
            appGroupMemberDao,
            appGroupEntryDao,
            applicationDao,
            appGroupOrganisationalUnitDao,
            organisationalUnitDao,
            entityRelationshipDao,
            changeInitiativeService,
            changeLogService2);

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class,
        () -> appGroupService.verifyUserCanUpdateGroup("42", 1L));
    verify(appGroupMemberDao).canUpdate(1L, "42");
  }
}
