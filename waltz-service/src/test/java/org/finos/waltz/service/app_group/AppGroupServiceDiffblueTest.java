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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.app_group.AppGroup;
import org.finos.waltz.model.app_group.AppGroupDetail;
import org.finos.waltz.model.app_group.AppGroupEntry;
import org.finos.waltz.model.app_group.AppGroupMember;
import org.finos.waltz.model.app_group.AppGroupMemberRole;
import org.finos.waltz.model.app_group.ImmutableAppGroupDetail;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.entity_relationship.EntityRelationship;
import org.finos.waltz.model.entity_relationship.EntityRelationshipKey;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.orgunit.OrganisationalUnit;
import org.finos.waltz.service.change_initiative.ChangeInitiativeService;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.jooq.DSLContext;
import org.jooq.lambda.tuple.Tuple2;
import org.jooq.lambda.tuple.Tuple3;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AppGroupServiceDiffblueTest {
  /**
   * Method under test: {@link AppGroupService#getGroupDetailById(long)}
   */
  @Test
  void testGetGroupDetailById() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong())).thenReturn(mock(AppGroup.class));
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(new HashSet<>());
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);

    // Act
    AppGroupDetail actualGroupDetailById = (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        changeInitiativeService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .getGroupDetailById(1L);

    // Assert
    verify(appGroupDao).getGroup(eq(1L));
    verify(appGroupEntryDao).findEntriesForGroup(eq(1L));
    verify(appGroupMemberDao).getMembers(eq(1L));
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(eq(1L));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    assertTrue(actualGroupDetailById instanceof ImmutableAppGroupDetail);
    List<AppGroupEntry> applicationsResult = actualGroupDetailById.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualGroupDetailById.changeInitiatives());
    assertSame(applicationsResult, actualGroupDetailById.members());
    assertSame(applicationsResult, actualGroupDetailById.organisationalUnits());
  }

  /**
   * Method under test: {@link AppGroupService#getGroupDetailById(long)}
   */
  @Test
  void testGetGroupDetailById2() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong())).thenReturn(mock(AppGroup.class));

    HashSet<AppGroupMember> appGroupMemberSet = new HashSet<>();
    appGroupMemberSet.add(mock(AppGroupMember.class));
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(appGroupMemberSet);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);

    // Act
    AppGroupDetail actualGroupDetailById = (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        changeInitiativeService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .getGroupDetailById(1L);

    // Assert
    verify(appGroupDao).getGroup(eq(1L));
    verify(appGroupEntryDao).findEntriesForGroup(eq(1L));
    verify(appGroupMemberDao).getMembers(eq(1L));
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(eq(1L));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    assertTrue(actualGroupDetailById instanceof ImmutableAppGroupDetail);
    assertEquals(1, actualGroupDetailById.members().size());
    List<AppGroupEntry> applicationsResult = actualGroupDetailById.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualGroupDetailById.changeInitiatives());
    assertSame(applicationsResult, actualGroupDetailById.organisationalUnits());
  }

  /**
   * Method under test: {@link AppGroupService#getGroupDetailById(long)}
   */
  @Test
  void testGetGroupDetailById3() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong())).thenReturn(mock(AppGroup.class));

    HashSet<AppGroupMember> appGroupMemberSet = new HashSet<>();
    appGroupMemberSet.add(mock(AppGroupMember.class));
    appGroupMemberSet.add(mock(AppGroupMember.class));
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(appGroupMemberSet);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);

    // Act
    AppGroupDetail actualGroupDetailById = (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        changeInitiativeService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .getGroupDetailById(1L);

    // Assert
    verify(appGroupDao).getGroup(eq(1L));
    verify(appGroupEntryDao).findEntriesForGroup(eq(1L));
    verify(appGroupMemberDao).getMembers(eq(1L));
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(eq(1L));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    assertTrue(actualGroupDetailById instanceof ImmutableAppGroupDetail);
    assertEquals(2, actualGroupDetailById.members().size());
    List<AppGroupEntry> applicationsResult = actualGroupDetailById.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualGroupDetailById.changeInitiatives());
    assertSame(applicationsResult, actualGroupDetailById.organisationalUnits());
  }

  /**
   * Method under test: {@link AppGroupService#getGroupDetailById(long)}
   */
  @Test
  void testGetGroupDetailById4() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong())).thenReturn(mock(AppGroup.class));
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(new HashSet<>());

    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    appGroupEntryList.add(mock(AppGroupEntry.class));
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(appGroupEntryList);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);

    // Act
    AppGroupDetail actualGroupDetailById = (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        changeInitiativeService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .getGroupDetailById(1L);

    // Assert
    verify(appGroupDao).getGroup(eq(1L));
    verify(appGroupEntryDao).findEntriesForGroup(eq(1L));
    verify(appGroupMemberDao).getMembers(eq(1L));
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(eq(1L));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    assertTrue(actualGroupDetailById instanceof ImmutableAppGroupDetail);
    assertEquals(1, actualGroupDetailById.applications().size());
    List<AppGroupEntry> changeInitiativesResult = actualGroupDetailById.changeInitiatives();
    assertTrue(changeInitiativesResult.isEmpty());
    assertSame(changeInitiativesResult, actualGroupDetailById.members());
    assertSame(changeInitiativesResult, actualGroupDetailById.organisationalUnits());
  }

  /**
   * Method under test: {@link AppGroupService#getGroupDetailById(long)}
   */
  @Test
  void testGetGroupDetailById5() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong())).thenReturn(mock(AppGroup.class));
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(new HashSet<>());
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    appGroupEntryList.add(mock(AppGroupEntry.class));
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(appGroupEntryList);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao applicationDao = mock(ApplicationDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);

    // Act
    AppGroupDetail actualGroupDetailById = (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        changeInitiativeService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .getGroupDetailById(1L);

    // Assert
    verify(appGroupDao).getGroup(eq(1L));
    verify(appGroupEntryDao).findEntriesForGroup(eq(1L));
    verify(appGroupMemberDao).getMembers(eq(1L));
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(eq(1L));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    assertTrue(actualGroupDetailById instanceof ImmutableAppGroupDetail);
    assertEquals(1, actualGroupDetailById.organisationalUnits().size());
    List<AppGroupEntry> applicationsResult = actualGroupDetailById.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualGroupDetailById.changeInitiatives());
    assertSame(applicationsResult, actualGroupDetailById.members());
  }

  /**
   * Method under test: {@link AppGroupService#getGroupDetailById(long)}
   */
  @Test
  void testGetGroupDetailById6() {
    // Arrange
    new IllegalArgumentException("appGroup");
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong())).thenReturn(mock(AppGroup.class));
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(new HashSet<>());
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());
    ChangeInitiativeService changeInitiativeService = mock(ChangeInitiativeService.class);
    when(changeInitiativeService.findEntriesForAppGroup(anyLong())).thenReturn(new ArrayList<>());
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);

    // Act
    AppGroupDetail actualGroupDetailById = (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        changeInitiativeService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .getGroupDetailById(1L);

    // Assert
    verify(appGroupDao).getGroup(eq(1L));
    verify(appGroupEntryDao).findEntriesForGroup(eq(1L));
    verify(appGroupMemberDao).getMembers(eq(1L));
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(eq(1L));
    verify(changeInitiativeService).findEntriesForAppGroup(eq(1L));
    assertTrue(actualGroupDetailById instanceof ImmutableAppGroupDetail);
    List<AppGroupEntry> applicationsResult = actualGroupDetailById.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualGroupDetailById.changeInitiatives());
    assertSame(applicationsResult, actualGroupDetailById.members());
    assertSame(applicationsResult, actualGroupDetailById.organisationalUnits());
  }

  /**
   * Method under test: {@link AppGroupService#getGroupDetailById(long)}
   */
  @Test
  void testGetGroupDetailById7() {
    // Arrange
    new IllegalArgumentException("appGroup");
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong())).thenReturn(mock(AppGroup.class));
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(new HashSet<>());
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    appGroupEntryList.add(mock(AppGroupEntry.class));
    ChangeInitiativeService changeInitiativeService = mock(ChangeInitiativeService.class);
    when(changeInitiativeService.findEntriesForAppGroup(anyLong())).thenReturn(appGroupEntryList);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);

    // Act
    AppGroupDetail actualGroupDetailById = (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        changeInitiativeService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .getGroupDetailById(1L);

    // Assert
    verify(appGroupDao).getGroup(eq(1L));
    verify(appGroupEntryDao).findEntriesForGroup(eq(1L));
    verify(appGroupMemberDao).getMembers(eq(1L));
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(eq(1L));
    verify(changeInitiativeService).findEntriesForAppGroup(eq(1L));
    assertTrue(actualGroupDetailById instanceof ImmutableAppGroupDetail);
    assertEquals(1, actualGroupDetailById.changeInitiatives().size());
    List<AppGroupEntry> applicationsResult = actualGroupDetailById.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualGroupDetailById.members());
    assertSame(applicationsResult, actualGroupDetailById.organisationalUnits());
  }

  /**
   * Method under test:
   * {@link AppGroupService#findGroupSubscriptionsForUser(String)}
   */
  @Test
  void testFindGroupSubscriptionsForUser() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.findGroupsForUser(Mockito.<String>any())).thenReturn(new ArrayList<>());
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.getSubscriptions(Mockito.<String>any())).thenReturn(new HashSet<>());
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

    // Act
    Set<AppGroupSubscription> actualFindGroupSubscriptionsForUserResult = (new AppGroupService(appGroupDao,
        appGroupMemberDao, appGroupEntryDao, applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao,
        entityRelationshipDao, changeInitiativeService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findGroupSubscriptionsForUser("42");

    // Assert
    verify(appGroupDao).findGroupsForUser(eq("42"));
    verify(appGroupMemberDao).getSubscriptions(eq("42"));
    assertTrue(actualFindGroupSubscriptionsForUserResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link AppGroupService#findGroupSubscriptionsForUser(String)}
   */
  @Test
  void testFindGroupSubscriptionsForUser2() {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.getSubscriptions(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException("xs cannot be null"));
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao, applicationDao,
            appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao, changeInitiativeService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .findGroupSubscriptionsForUser("42"));
    verify(appGroupMemberDao).getSubscriptions(eq("42"));
  }

  /**
   * Method under test:
   * {@link AppGroupService#findGroupSubscriptionsForUser(String)}
   */
  @Test
  void testFindGroupSubscriptionsForUser3() {
    // Arrange
    AppGroup appGroup = mock(AppGroup.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(appGroup.id()).thenReturn(ofResult);
    AppGroup appGroup2 = mock(AppGroup.class);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(appGroup2.id()).thenReturn(ofResult2);
    AppGroup appGroup3 = mock(AppGroup.class);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(appGroup3.id()).thenReturn(ofResult3);
    AppGroup appGroup4 = mock(AppGroup.class);
    Optional<Long> ofResult4 = Optional.<Long>of(1L);
    when(appGroup4.id()).thenReturn(ofResult4);
    AppGroup appGroup5 = mock(AppGroup.class);
    Optional<Long> ofResult5 = Optional.<Long>of(1L);
    when(appGroup5.id()).thenReturn(ofResult5);
    AppGroup appGroup6 = mock(AppGroup.class);
    Optional<Long> ofResult6 = Optional.<Long>of(1L);
    when(appGroup6.id()).thenReturn(ofResult6);
    AppGroup appGroup7 = mock(AppGroup.class);
    Optional<Long> ofResult7 = Optional.<Long>of(1L);
    when(appGroup7.id()).thenReturn(ofResult7);
    AppGroup appGroup8 = mock(AppGroup.class);
    Optional<Long> ofResult8 = Optional.<Long>of(1L);
    when(appGroup8.id()).thenReturn(ofResult8);
    AppGroup appGroup9 = mock(AppGroup.class);
    Optional<Long> ofResult9 = Optional.<Long>of(1L);
    when(appGroup9.id()).thenReturn(ofResult9);
    AppGroup appGroup10 = mock(AppGroup.class);
    Optional<Long> ofResult10 = Optional.<Long>of(1L);
    when(appGroup10.id()).thenReturn(ofResult10);
    AppGroup appGroup11 = mock(AppGroup.class);
    Optional<Long> ofResult11 = Optional.<Long>of(1L);
    when(appGroup11.id()).thenReturn(ofResult11);
    AppGroup appGroup12 = mock(AppGroup.class);
    Optional<Long> ofResult12 = Optional.<Long>of(1L);
    when(appGroup12.id()).thenReturn(ofResult12);
    AppGroup appGroup13 = mock(AppGroup.class);
    Optional<Long> ofResult13 = Optional.<Long>of(1L);
    when(appGroup13.id()).thenReturn(ofResult13);
    AppGroup appGroup14 = mock(AppGroup.class);
    Optional<Long> ofResult14 = Optional.<Long>of(1L);
    when(appGroup14.id()).thenReturn(ofResult14);
    AppGroup appGroup15 = mock(AppGroup.class);
    Optional<Long> ofResult15 = Optional.<Long>of(1L);
    when(appGroup15.id()).thenReturn(ofResult15);
    AppGroup appGroup16 = mock(AppGroup.class);
    Optional<Long> ofResult16 = Optional.<Long>of(1L);
    when(appGroup16.id()).thenReturn(ofResult16);
    AppGroup appGroup17 = mock(AppGroup.class);
    Optional<Long> ofResult17 = Optional.<Long>of(1L);
    when(appGroup17.id()).thenReturn(ofResult17);
    AppGroup appGroup18 = mock(AppGroup.class);
    Optional<Long> ofResult18 = Optional.<Long>of(1L);
    when(appGroup18.id()).thenReturn(ofResult18);
    AppGroup appGroup19 = mock(AppGroup.class);
    Optional<Long> ofResult19 = Optional.<Long>of(1L);
    when(appGroup19.id()).thenReturn(ofResult19);
    AppGroup appGroup20 = mock(AppGroup.class);
    Optional<Long> ofResult20 = Optional.<Long>of(1L);
    when(appGroup20.id()).thenReturn(ofResult20);
    AppGroup appGroup21 = mock(AppGroup.class);
    Optional<Long> ofResult21 = Optional.<Long>of(1L);
    when(appGroup21.id()).thenReturn(ofResult21);
    AppGroup appGroup22 = mock(AppGroup.class);
    Optional<Long> ofResult22 = Optional.<Long>of(1L);
    when(appGroup22.id()).thenReturn(ofResult22);
    AppGroup appGroup23 = mock(AppGroup.class);
    Optional<Long> ofResult23 = Optional.<Long>of(1L);
    when(appGroup23.id()).thenReturn(ofResult23);
    AppGroup appGroup24 = mock(AppGroup.class);
    Optional<Long> ofResult24 = Optional.<Long>of(1L);
    when(appGroup24.id()).thenReturn(ofResult24);
    AppGroup appGroup25 = mock(AppGroup.class);
    Optional<Long> ofResult25 = Optional.<Long>of(1L);
    when(appGroup25.id()).thenReturn(ofResult25);
    AppGroup appGroup26 = mock(AppGroup.class);
    Optional<Long> ofResult26 = Optional.<Long>of(1L);
    when(appGroup26.id()).thenReturn(ofResult26);
    AppGroup appGroup27 = mock(AppGroup.class);
    Optional<Long> ofResult27 = Optional.<Long>of(1L);
    when(appGroup27.id()).thenReturn(ofResult27);
    AppGroup appGroup28 = mock(AppGroup.class);
    Optional<Long> ofResult28 = Optional.<Long>of(1L);
    when(appGroup28.id()).thenReturn(ofResult28);
    AppGroup appGroup29 = mock(AppGroup.class);
    Optional<Long> ofResult29 = Optional.<Long>of(1L);
    when(appGroup29.id()).thenReturn(ofResult29);
    AppGroup appGroup30 = mock(AppGroup.class);
    Optional<Long> ofResult30 = Optional.<Long>of(1L);
    when(appGroup30.id()).thenReturn(ofResult30);
    AppGroup appGroup31 = mock(AppGroup.class);
    Optional<Long> ofResult31 = Optional.<Long>of(1L);
    when(appGroup31.id()).thenReturn(ofResult31);
    AppGroup appGroup32 = mock(AppGroup.class);
    Optional<Long> ofResult32 = Optional.<Long>of(1L);
    when(appGroup32.id()).thenReturn(ofResult32);
    AppGroup appGroup33 = mock(AppGroup.class);
    Optional<Long> ofResult33 = Optional.<Long>of(1L);
    when(appGroup33.id()).thenReturn(ofResult33);
    AppGroup appGroup34 = mock(AppGroup.class);
    Optional<Long> ofResult34 = Optional.<Long>of(1L);
    when(appGroup34.id()).thenReturn(ofResult34);
    AppGroup appGroup35 = mock(AppGroup.class);
    Optional<Long> ofResult35 = Optional.<Long>of(1L);
    when(appGroup35.id()).thenReturn(ofResult35);
    AppGroup appGroup36 = mock(AppGroup.class);
    Optional<Long> ofResult36 = Optional.<Long>of(1L);
    when(appGroup36.id()).thenReturn(ofResult36);
    AppGroup appGroup37 = mock(AppGroup.class);
    Optional<Long> ofResult37 = Optional.<Long>of(1L);
    when(appGroup37.id()).thenReturn(ofResult37);
    AppGroup appGroup38 = mock(AppGroup.class);
    Optional<Long> ofResult38 = Optional.<Long>of(1L);
    when(appGroup38.id()).thenReturn(ofResult38);
    AppGroup appGroup39 = mock(AppGroup.class);
    Optional<Long> ofResult39 = Optional.<Long>of(1L);
    when(appGroup39.id()).thenReturn(ofResult39);
    AppGroup appGroup40 = mock(AppGroup.class);
    Optional<Long> ofResult40 = Optional.<Long>of(1L);
    when(appGroup40.id()).thenReturn(ofResult40);
    AppGroup appGroup41 = mock(AppGroup.class);
    Optional<Long> ofResult41 = Optional.<Long>of(1L);
    when(appGroup41.id()).thenReturn(ofResult41);
    AppGroup appGroup42 = mock(AppGroup.class);
    Optional<Long> ofResult42 = Optional.<Long>of(1L);
    when(appGroup42.id()).thenReturn(ofResult42);
    AppGroup appGroup43 = mock(AppGroup.class);
    Optional<Long> ofResult43 = Optional.<Long>of(1L);
    when(appGroup43.id()).thenReturn(ofResult43);
    AppGroup appGroup44 = mock(AppGroup.class);
    Optional<Long> ofResult44 = Optional.<Long>of(1L);
    when(appGroup44.id()).thenReturn(ofResult44);
    AppGroup appGroup45 = mock(AppGroup.class);
    Optional<Long> ofResult45 = Optional.<Long>of(1L);
    when(appGroup45.id()).thenReturn(ofResult45);
    AppGroup appGroup46 = mock(AppGroup.class);
    Optional<Long> ofResult46 = Optional.<Long>of(1L);
    when(appGroup46.id()).thenReturn(ofResult46);
    AppGroup appGroup47 = mock(AppGroup.class);
    Optional<Long> ofResult47 = Optional.<Long>of(1L);
    when(appGroup47.id()).thenReturn(ofResult47);
    AppGroup appGroup48 = mock(AppGroup.class);
    Optional<Long> ofResult48 = Optional.<Long>of(1L);
    when(appGroup48.id()).thenReturn(ofResult48);
    AppGroup appGroup49 = mock(AppGroup.class);
    Optional<Long> ofResult49 = Optional.<Long>of(1L);
    when(appGroup49.id()).thenReturn(ofResult49);
    AppGroup appGroup50 = mock(AppGroup.class);
    Optional<Long> ofResult50 = Optional.<Long>of(1L);
    when(appGroup50.id()).thenReturn(ofResult50);
    AppGroup appGroup51 = mock(AppGroup.class);
    Optional<Long> ofResult51 = Optional.<Long>of(1L);
    when(appGroup51.id()).thenReturn(ofResult51);
    AppGroup appGroup52 = mock(AppGroup.class);
    Optional<Long> ofResult52 = Optional.<Long>of(1L);
    when(appGroup52.id()).thenReturn(ofResult52);
    AppGroup appGroup53 = mock(AppGroup.class);
    Optional<Long> ofResult53 = Optional.<Long>of(1L);
    when(appGroup53.id()).thenReturn(ofResult53);
    AppGroup appGroup54 = mock(AppGroup.class);
    Optional<Long> ofResult54 = Optional.<Long>of(1L);
    when(appGroup54.id()).thenReturn(ofResult54);
    AppGroup appGroup55 = mock(AppGroup.class);
    Optional<Long> ofResult55 = Optional.<Long>of(1L);
    when(appGroup55.id()).thenReturn(ofResult55);
    AppGroup appGroup56 = mock(AppGroup.class);
    Optional<Long> ofResult56 = Optional.<Long>of(1L);
    when(appGroup56.id()).thenReturn(ofResult56);
    AppGroup appGroup57 = mock(AppGroup.class);
    Optional<Long> ofResult57 = Optional.<Long>of(1L);
    when(appGroup57.id()).thenReturn(ofResult57);
    AppGroup appGroup58 = mock(AppGroup.class);
    Optional<Long> ofResult58 = Optional.<Long>of(1L);
    when(appGroup58.id()).thenReturn(ofResult58);
    AppGroup appGroup59 = mock(AppGroup.class);
    Optional<Long> ofResult59 = Optional.<Long>of(1L);
    when(appGroup59.id()).thenReturn(ofResult59);
    AppGroup appGroup60 = mock(AppGroup.class);
    Optional<Long> ofResult60 = Optional.<Long>of(1L);
    when(appGroup60.id()).thenReturn(ofResult60);
    AppGroup appGroup61 = mock(AppGroup.class);
    Optional<Long> ofResult61 = Optional.<Long>of(1L);
    when(appGroup61.id()).thenReturn(ofResult61);
    AppGroup appGroup62 = mock(AppGroup.class);
    Optional<Long> ofResult62 = Optional.<Long>of(1L);
    when(appGroup62.id()).thenReturn(ofResult62);
    AppGroup appGroup63 = mock(AppGroup.class);
    Optional<Long> ofResult63 = Optional.<Long>of(1L);
    when(appGroup63.id()).thenReturn(ofResult63);
    AppGroup appGroup64 = mock(AppGroup.class);
    Optional<Long> ofResult64 = Optional.<Long>of(1L);
    when(appGroup64.id()).thenReturn(ofResult64);
    AppGroup appGroup65 = mock(AppGroup.class);
    Optional<Long> ofResult65 = Optional.<Long>of(1L);
    when(appGroup65.id()).thenReturn(ofResult65);
    AppGroup appGroup66 = mock(AppGroup.class);
    Optional<Long> ofResult66 = Optional.<Long>of(1L);
    when(appGroup66.id()).thenReturn(ofResult66);
    AppGroup appGroup67 = mock(AppGroup.class);
    Optional<Long> ofResult67 = Optional.<Long>of(1L);
    when(appGroup67.id()).thenReturn(ofResult67);
    AppGroup appGroup68 = mock(AppGroup.class);
    Optional<Long> ofResult68 = Optional.<Long>of(1L);
    when(appGroup68.id()).thenReturn(ofResult68);
    AppGroup appGroup69 = mock(AppGroup.class);
    Optional<Long> ofResult69 = Optional.<Long>of(1L);
    when(appGroup69.id()).thenReturn(ofResult69);
    AppGroup appGroup70 = mock(AppGroup.class);
    Optional<Long> ofResult70 = Optional.<Long>of(1L);
    when(appGroup70.id()).thenReturn(ofResult70);
    AppGroup appGroup71 = mock(AppGroup.class);
    Optional<Long> ofResult71 = Optional.<Long>of(1L);
    when(appGroup71.id()).thenReturn(ofResult71);
    AppGroup appGroup72 = mock(AppGroup.class);
    when(appGroup72.id()).thenThrow(new IllegalArgumentException("xs cannot be null"));

    ArrayList<AppGroup> appGroupList = new ArrayList<>();
    appGroupList.add(appGroup72);
    appGroupList.add(appGroup71);
    appGroupList.add(appGroup70);
    appGroupList.add(appGroup69);
    appGroupList.add(appGroup68);
    appGroupList.add(appGroup67);
    appGroupList.add(appGroup66);
    appGroupList.add(appGroup65);
    appGroupList.add(appGroup64);
    appGroupList.add(appGroup63);
    appGroupList.add(appGroup62);
    appGroupList.add(appGroup61);
    appGroupList.add(appGroup60);
    appGroupList.add(appGroup59);
    appGroupList.add(appGroup58);
    appGroupList.add(appGroup57);
    appGroupList.add(appGroup56);
    appGroupList.add(appGroup55);
    appGroupList.add(appGroup54);
    appGroupList.add(appGroup53);
    appGroupList.add(appGroup52);
    appGroupList.add(appGroup51);
    appGroupList.add(appGroup50);
    appGroupList.add(appGroup49);
    appGroupList.add(appGroup48);
    appGroupList.add(appGroup47);
    appGroupList.add(appGroup46);
    appGroupList.add(appGroup45);
    appGroupList.add(appGroup44);
    appGroupList.add(appGroup43);
    appGroupList.add(appGroup42);
    appGroupList.add(appGroup41);
    appGroupList.add(appGroup40);
    appGroupList.add(appGroup39);
    appGroupList.add(appGroup38);
    appGroupList.add(appGroup37);
    appGroupList.add(appGroup36);
    appGroupList.add(appGroup35);
    appGroupList.add(appGroup34);
    appGroupList.add(appGroup33);
    appGroupList.add(appGroup32);
    appGroupList.add(appGroup31);
    appGroupList.add(appGroup30);
    appGroupList.add(appGroup29);
    appGroupList.add(appGroup28);
    appGroupList.add(appGroup27);
    appGroupList.add(appGroup26);
    appGroupList.add(appGroup25);
    appGroupList.add(appGroup24);
    appGroupList.add(appGroup23);
    appGroupList.add(appGroup22);
    appGroupList.add(appGroup21);
    appGroupList.add(appGroup20);
    appGroupList.add(appGroup19);
    appGroupList.add(appGroup18);
    appGroupList.add(appGroup17);
    appGroupList.add(appGroup16);
    appGroupList.add(appGroup15);
    appGroupList.add(appGroup14);
    appGroupList.add(appGroup13);
    appGroupList.add(appGroup12);
    appGroupList.add(appGroup11);
    appGroupList.add(appGroup10);
    appGroupList.add(appGroup9);
    appGroupList.add(appGroup8);
    appGroupList.add(appGroup7);
    appGroupList.add(appGroup6);
    appGroupList.add(appGroup5);
    appGroupList.add(appGroup4);
    appGroupList.add(appGroup3);
    appGroupList.add(appGroup2);
    appGroupList.add(appGroup);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.findGroupsForUser(Mockito.<String>any())).thenReturn(appGroupList);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.getSubscriptions(Mockito.<String>any())).thenReturn(new HashSet<>());
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

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao, applicationDao,
            appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao, changeInitiativeService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .findGroupSubscriptionsForUser("42"));
    verify(appGroupDao).findGroupsForUser(eq("42"));
    verify(appGroupMemberDao).getSubscriptions(eq("42"));
    verify(appGroup72).id();
  }

  /**
   * Method under test: {@link AppGroupService#findPublicGroups()}
   */
  @Test
  void testFindPublicGroups() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    ArrayList<AppGroup> appGroupList = new ArrayList<>();
    when(appGroupDao.findPublicGroups()).thenReturn(appGroupList);
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

    // Act
    List<AppGroup> actualFindPublicGroupsResult = (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        changeInitiativeService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findPublicGroups();

    // Assert
    verify(appGroupDao).findPublicGroups();
    assertTrue(actualFindPublicGroupsResult.isEmpty());
    assertSame(appGroupList, actualFindPublicGroupsResult);
  }

  /**
   * Method under test: {@link AppGroupService#findPublicGroups()}
   */
  @Test
  void testFindPublicGroups2() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.findPublicGroups()).thenThrow(new IllegalArgumentException("foo"));
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

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao, applicationDao,
            appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao, changeInitiativeService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .findPublicGroups());
    verify(appGroupDao).findPublicGroups();
  }

  /**
   * Method under test: {@link AppGroupService#findPrivateGroupsByOwner(String)}
   */
  @Test
  void testFindPrivateGroupsByOwner() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    ArrayList<AppGroup> appGroupList = new ArrayList<>();
    when(appGroupDao.findPrivateGroupsByOwner(Mockito.<String>any())).thenReturn(appGroupList);
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

    // Act
    List<AppGroup> actualFindPrivateGroupsByOwnerResult = (new AppGroupService(appGroupDao, appGroupMemberDao,
        appGroupEntryDao, applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        changeInitiativeService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findPrivateGroupsByOwner("42");

    // Assert
    verify(appGroupDao).findPrivateGroupsByOwner(eq("42"));
    assertTrue(actualFindPrivateGroupsByOwnerResult.isEmpty());
    assertSame(appGroupList, actualFindPrivateGroupsByOwnerResult);
  }

  /**
   * Method under test: {@link AppGroupService#findPrivateGroupsByOwner(String)}
   */
  @Test
  void testFindPrivateGroupsByOwner2() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.findPrivateGroupsByOwner(Mockito.<String>any())).thenThrow(new IllegalArgumentException("foo"));
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

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao, applicationDao,
            appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao, changeInitiativeService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .findPrivateGroupsByOwner("42"));
    verify(appGroupDao).findPrivateGroupsByOwner(eq("42"));
  }

  /**
   * Method under test:
   * {@link AppGroupService#findRelatedByEntityReference(EntityReference, String)}
   */
  @Test
  void testFindRelatedByEntityReference() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    ArrayList<AppGroup> appGroupList = new ArrayList<>();
    when(appGroupDao.findRelatedByEntityReference(Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(appGroupList);
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

    AppGroupService appGroupService = new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        changeInitiativeService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    List<AppGroup> actualFindRelatedByEntityReferenceResult = appGroupService.findRelatedByEntityReference(ref,
        "janedoe");

    // Assert
    verify(appGroupDao).findRelatedByEntityReference(isA(EntityReference.class), eq("janedoe"));
    verify(ref).kind();
    assertTrue(actualFindRelatedByEntityReferenceResult.isEmpty());
    assertSame(appGroupList, actualFindRelatedByEntityReferenceResult);
  }

  /**
   * Method under test:
   * {@link AppGroupService#findRelatedByEntityReference(EntityReference, String)}
   */
  @Test
  void testFindRelatedByEntityReference2() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.findRelatedByEntityReference(Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException("foo"));
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

    AppGroupService appGroupService = new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        changeInitiativeService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> appGroupService.findRelatedByEntityReference(ref, "janedoe"));
    verify(appGroupDao).findRelatedByEntityReference(isA(EntityReference.class), eq("janedoe"));
    verify(ref).kind();
  }

  /**
   * Method under test:
   * {@link AppGroupService#findRelatedByEntityReference(EntityReference, String)}
   */
  @Test
  void testFindRelatedByEntityReference3() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    ArrayList<AppGroup> appGroupList = new ArrayList<>();
    when(appGroupDao.findRelatedByApplicationId(anyLong(), Mockito.<String>any())).thenReturn(appGroupList);
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

    AppGroupService appGroupService = new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        changeInitiativeService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.APPLICATION);

    // Act
    List<AppGroup> actualFindRelatedByEntityReferenceResult = appGroupService.findRelatedByEntityReference(ref,
        "janedoe");

    // Assert
    verify(appGroupDao).findRelatedByApplicationId(eq(1L), eq("janedoe"));
    verify(ref).id();
    verify(ref).kind();
    assertTrue(actualFindRelatedByEntityReferenceResult.isEmpty());
    assertSame(appGroupList, actualFindRelatedByEntityReferenceResult);
  }

  /**
   * Method under test:
   * {@link AppGroupService#findRelatedByEntityReference(EntityReference, String)}
   */
  @Test
  void testFindRelatedByEntityReference4() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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

    AppGroupService appGroupService = new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        changeInitiativeService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenThrow(new IllegalArgumentException("foo"));
    when(ref.kind()).thenReturn(EntityKind.APPLICATION);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> appGroupService.findRelatedByEntityReference(ref, "janedoe"));
    verify(ref).id();
    verify(ref).kind();
  }

  /**
   * Method under test: {@link AppGroupService#search(EntitySearchOptions)}
   */
  @Test
  void testSearch() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    ArrayList<AppGroup> appGroupList = new ArrayList<>();
    when(appGroupDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(appGroupList);
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

    // Act
    List<AppGroup> actualSearchResult = (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        changeInitiativeService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))).search(null);

    // Assert
    verify(appGroupDao).search(isNull());
    assertTrue(actualSearchResult.isEmpty());
    assertSame(appGroupList, actualSearchResult);
  }

  /**
   * Method under test: {@link AppGroupService#search(EntitySearchOptions)}
   */
  @Test
  void testSearch2() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.search(Mockito.<EntitySearchOptions>any())).thenThrow(new IllegalArgumentException("foo"));
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

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao, applicationDao,
            appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao, changeInitiativeService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .search(null));
    verify(appGroupDao).search(isNull());
  }

  /**
   * Method under test: {@link AppGroupService#subscribe(String, long)}
   */
  @Test
  void testSubscribe() {
    // Arrange
    AppGroup appGroup = mock(AppGroup.class);
    when(appGroup.isFavouriteGroup()).thenReturn(true);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong())).thenReturn(appGroup);
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

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao, applicationDao,
            appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao, changeInitiativeService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .subscribe("42", 1L));
    verify(appGroupDao).getGroup(eq(1L));
    verify(appGroup).isFavouriteGroup();
  }

  /**
   * Method under test: {@link AppGroupService#subscribe(String, long)}
   */
  @Test
  void testSubscribe2() {
    // Arrange
    AppGroup appGroup = mock(AppGroup.class);
    when(appGroup.isFavouriteGroup()).thenThrow(new IllegalArgumentException("Subscribed to group "));
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong())).thenReturn(appGroup);
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

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao, applicationDao,
            appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao, changeInitiativeService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .subscribe("42", 1L));
    verify(appGroupDao).getGroup(eq(1L));
    verify(appGroup).isFavouriteGroup();
  }

  /**
   * Method under test: {@link AppGroupService#subscribe(String, long)}
   */
  @Test
  void testSubscribe3() {
    // Arrange
    AppGroup appGroup = mock(AppGroup.class);
    when(appGroup.name()).thenReturn("Name");
    when(appGroup.isFavouriteGroup()).thenReturn(false);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong())).thenReturn(appGroup);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.register(anyLong(), Mockito.<String>any())).thenReturn(1);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);

    // Act
    (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao, applicationDao,
        appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        new ChangeInitiativeService(changeInitiativeDao, searchDao, relationshipDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        changeLogService)).subscribe("42", 1L);

    // Assert
    verify(appGroupDao).getGroup(eq(1L));
    verify(appGroupMemberDao).register(eq(1L), eq("42"));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(appGroup).name();
    verify(appGroup).isFavouriteGroup();
  }

  /**
   * Method under test: {@link AppGroupService#subscribe(String, long)}
   */
  @Test
  void testSubscribe4() {
    // Arrange
    AppGroup appGroup = mock(AppGroup.class);
    when(appGroup.name()).thenReturn("Name");
    when(appGroup.isFavouriteGroup()).thenReturn(false);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong())).thenReturn(appGroup);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.register(anyLong(), Mockito.<String>any())).thenReturn(1);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);

    // Act
    (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao, applicationDao,
        appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        new ChangeInitiativeService(changeInitiativeDao, searchDao, relationshipDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        changeLogService)).subscribe("42", 1L);

    // Assert
    verify(appGroupDao).getGroup(eq(1L));
    verify(appGroupMemberDao).register(eq(1L), eq("42"));
    verify(appGroup).name();
    verify(appGroup).isFavouriteGroup();
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Method under test: {@link AppGroupService#subscribe(String, long)}
   */
  @Test
  void testSubscribe5() {
    // Arrange
    AppGroup appGroup = mock(AppGroup.class);
    when(appGroup.name()).thenReturn("Name");
    when(appGroup.isFavouriteGroup()).thenReturn(false);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong())).thenReturn(appGroup);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new IllegalArgumentException("Subscribed to group "));
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new AppGroupService(appGroupDao, appGroupMemberDao,
        appGroupEntryDao, applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        new ChangeInitiativeService(changeInitiativeDao, searchDao, relationshipDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        changeLogService)).subscribe("42", 1L));
    verify(appGroupDao).getGroup(eq(1L));
    verify(appGroup).name();
    verify(appGroup).isFavouriteGroup();
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Method under test: {@link AppGroupService#unsubscribe(String, long)}
   */
  @Test
  void testUnsubscribe() {
    // Arrange
    AppGroup appGroup = mock(AppGroup.class);
    when(appGroup.name()).thenReturn("Name");
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong())).thenReturn(appGroup);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.unregister(anyLong(), Mockito.<String>any())).thenReturn(true);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);

    // Act
    (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao, applicationDao,
        appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        new ChangeInitiativeService(changeInitiativeDao, searchDao, relationshipDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        changeLogService)).unsubscribe("42", 1L);

    // Assert
    verify(appGroupDao).getGroup(eq(1L));
    verify(appGroupMemberDao).unregister(eq(1L), eq("42"));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(appGroup).name();
  }

  /**
   * Method under test: {@link AppGroupService#unsubscribe(String, long)}
   */
  @Test
  void testUnsubscribe2() {
    // Arrange
    AppGroup appGroup = mock(AppGroup.class);
    when(appGroup.name()).thenReturn("Name");
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong())).thenReturn(appGroup);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.unregister(anyLong(), Mockito.<String>any())).thenReturn(true);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);

    // Act
    (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao, applicationDao,
        appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        new ChangeInitiativeService(changeInitiativeDao, searchDao, relationshipDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        changeLogService)).unsubscribe("42", 1L);

    // Assert
    verify(appGroupDao).getGroup(eq(1L));
    verify(appGroupMemberDao).unregister(eq(1L), eq("42"));
    verify(appGroup).name();
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Method under test: {@link AppGroupService#deleteGroup(String, long)}
   */
  @Test
  void testDeleteGroup() throws InsufficientPrivelegeException {
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
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);

    // Act
    Set<AppGroupSubscription> actualDeleteGroupResult = (new AppGroupService(appGroupDao, appGroupMemberDao,
        appGroupEntryDao, applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        new ChangeInitiativeService(changeInitiativeDao, searchDao, relationshipDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        changeLogService)).deleteGroup("42", 1L);

    // Assert
    verify(appGroupDao).deleteGroup(eq(1L));
    verify(appGroupDao).findGroupsForUser(eq("42"));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(appGroupMemberDao).getSubscriptions(eq("42"));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(entityRelationshipDao).removeAnyInvolving(isA(EntityReference.class));
    assertTrue(actualDeleteGroupResult.isEmpty());
  }

  /**
   * Method under test: {@link AppGroupService#deleteGroup(String, long)}
   */
  @Test
  void testDeleteGroup2() throws InsufficientPrivelegeException {
    // Arrange
    AppGroup appGroup = mock(AppGroup.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(appGroup.id()).thenReturn(ofResult);
    AppGroup appGroup2 = mock(AppGroup.class);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(appGroup2.id()).thenReturn(ofResult2);
    AppGroup appGroup3 = mock(AppGroup.class);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(appGroup3.id()).thenReturn(ofResult3);
    AppGroup appGroup4 = mock(AppGroup.class);
    Optional<Long> ofResult4 = Optional.<Long>of(1L);
    when(appGroup4.id()).thenReturn(ofResult4);
    AppGroup appGroup5 = mock(AppGroup.class);
    Optional<Long> ofResult5 = Optional.<Long>of(1L);
    when(appGroup5.id()).thenReturn(ofResult5);
    AppGroup appGroup6 = mock(AppGroup.class);
    Optional<Long> ofResult6 = Optional.<Long>of(1L);
    when(appGroup6.id()).thenReturn(ofResult6);
    AppGroup appGroup7 = mock(AppGroup.class);
    Optional<Long> ofResult7 = Optional.<Long>of(1L);
    when(appGroup7.id()).thenReturn(ofResult7);
    AppGroup appGroup8 = mock(AppGroup.class);
    Optional<Long> ofResult8 = Optional.<Long>of(1L);
    when(appGroup8.id()).thenReturn(ofResult8);
    AppGroup appGroup9 = mock(AppGroup.class);
    Optional<Long> ofResult9 = Optional.<Long>of(1L);
    when(appGroup9.id()).thenReturn(ofResult9);
    AppGroup appGroup10 = mock(AppGroup.class);
    Optional<Long> ofResult10 = Optional.<Long>of(1L);
    when(appGroup10.id()).thenReturn(ofResult10);
    AppGroup appGroup11 = mock(AppGroup.class);
    Optional<Long> ofResult11 = Optional.<Long>of(1L);
    when(appGroup11.id()).thenReturn(ofResult11);
    AppGroup appGroup12 = mock(AppGroup.class);
    Optional<Long> ofResult12 = Optional.<Long>of(1L);
    when(appGroup12.id()).thenReturn(ofResult12);
    AppGroup appGroup13 = mock(AppGroup.class);
    Optional<Long> ofResult13 = Optional.<Long>of(1L);
    when(appGroup13.id()).thenReturn(ofResult13);
    AppGroup appGroup14 = mock(AppGroup.class);
    Optional<Long> ofResult14 = Optional.<Long>of(1L);
    when(appGroup14.id()).thenReturn(ofResult14);
    AppGroup appGroup15 = mock(AppGroup.class);
    Optional<Long> ofResult15 = Optional.<Long>of(1L);
    when(appGroup15.id()).thenReturn(ofResult15);
    AppGroup appGroup16 = mock(AppGroup.class);
    Optional<Long> ofResult16 = Optional.<Long>of(1L);
    when(appGroup16.id()).thenReturn(ofResult16);
    AppGroup appGroup17 = mock(AppGroup.class);
    Optional<Long> ofResult17 = Optional.<Long>of(1L);
    when(appGroup17.id()).thenReturn(ofResult17);
    AppGroup appGroup18 = mock(AppGroup.class);
    Optional<Long> ofResult18 = Optional.<Long>of(1L);
    when(appGroup18.id()).thenReturn(ofResult18);
    AppGroup appGroup19 = mock(AppGroup.class);
    Optional<Long> ofResult19 = Optional.<Long>of(1L);
    when(appGroup19.id()).thenReturn(ofResult19);
    AppGroup appGroup20 = mock(AppGroup.class);
    Optional<Long> ofResult20 = Optional.<Long>of(1L);
    when(appGroup20.id()).thenReturn(ofResult20);
    AppGroup appGroup21 = mock(AppGroup.class);
    Optional<Long> ofResult21 = Optional.<Long>of(1L);
    when(appGroup21.id()).thenReturn(ofResult21);
    AppGroup appGroup22 = mock(AppGroup.class);
    Optional<Long> ofResult22 = Optional.<Long>of(1L);
    when(appGroup22.id()).thenReturn(ofResult22);
    AppGroup appGroup23 = mock(AppGroup.class);
    Optional<Long> ofResult23 = Optional.<Long>of(1L);
    when(appGroup23.id()).thenReturn(ofResult23);
    AppGroup appGroup24 = mock(AppGroup.class);
    Optional<Long> ofResult24 = Optional.<Long>of(1L);
    when(appGroup24.id()).thenReturn(ofResult24);
    AppGroup appGroup25 = mock(AppGroup.class);
    Optional<Long> ofResult25 = Optional.<Long>of(1L);
    when(appGroup25.id()).thenReturn(ofResult25);
    AppGroup appGroup26 = mock(AppGroup.class);
    Optional<Long> ofResult26 = Optional.<Long>of(1L);
    when(appGroup26.id()).thenReturn(ofResult26);
    AppGroup appGroup27 = mock(AppGroup.class);
    Optional<Long> ofResult27 = Optional.<Long>of(1L);
    when(appGroup27.id()).thenReturn(ofResult27);
    AppGroup appGroup28 = mock(AppGroup.class);
    Optional<Long> ofResult28 = Optional.<Long>of(1L);
    when(appGroup28.id()).thenReturn(ofResult28);
    AppGroup appGroup29 = mock(AppGroup.class);
    Optional<Long> ofResult29 = Optional.<Long>of(1L);
    when(appGroup29.id()).thenReturn(ofResult29);
    AppGroup appGroup30 = mock(AppGroup.class);
    Optional<Long> ofResult30 = Optional.<Long>of(1L);
    when(appGroup30.id()).thenReturn(ofResult30);
    AppGroup appGroup31 = mock(AppGroup.class);
    Optional<Long> ofResult31 = Optional.<Long>of(1L);
    when(appGroup31.id()).thenReturn(ofResult31);
    AppGroup appGroup32 = mock(AppGroup.class);
    Optional<Long> ofResult32 = Optional.<Long>of(1L);
    when(appGroup32.id()).thenReturn(ofResult32);
    AppGroup appGroup33 = mock(AppGroup.class);
    Optional<Long> ofResult33 = Optional.<Long>of(1L);
    when(appGroup33.id()).thenReturn(ofResult33);
    AppGroup appGroup34 = mock(AppGroup.class);
    Optional<Long> ofResult34 = Optional.<Long>of(1L);
    when(appGroup34.id()).thenReturn(ofResult34);
    AppGroup appGroup35 = mock(AppGroup.class);
    Optional<Long> ofResult35 = Optional.<Long>of(1L);
    when(appGroup35.id()).thenReturn(ofResult35);
    AppGroup appGroup36 = mock(AppGroup.class);
    Optional<Long> ofResult36 = Optional.<Long>of(1L);
    when(appGroup36.id()).thenReturn(ofResult36);
    AppGroup appGroup37 = mock(AppGroup.class);
    Optional<Long> ofResult37 = Optional.<Long>of(1L);
    when(appGroup37.id()).thenReturn(ofResult37);
    AppGroup appGroup38 = mock(AppGroup.class);
    Optional<Long> ofResult38 = Optional.<Long>of(1L);
    when(appGroup38.id()).thenReturn(ofResult38);
    AppGroup appGroup39 = mock(AppGroup.class);
    Optional<Long> ofResult39 = Optional.<Long>of(1L);
    when(appGroup39.id()).thenReturn(ofResult39);
    AppGroup appGroup40 = mock(AppGroup.class);
    Optional<Long> ofResult40 = Optional.<Long>of(1L);
    when(appGroup40.id()).thenReturn(ofResult40);
    AppGroup appGroup41 = mock(AppGroup.class);
    Optional<Long> ofResult41 = Optional.<Long>of(1L);
    when(appGroup41.id()).thenReturn(ofResult41);
    AppGroup appGroup42 = mock(AppGroup.class);
    Optional<Long> ofResult42 = Optional.<Long>of(1L);
    when(appGroup42.id()).thenReturn(ofResult42);
    AppGroup appGroup43 = mock(AppGroup.class);
    Optional<Long> ofResult43 = Optional.<Long>of(1L);
    when(appGroup43.id()).thenReturn(ofResult43);
    AppGroup appGroup44 = mock(AppGroup.class);
    Optional<Long> ofResult44 = Optional.<Long>of(1L);
    when(appGroup44.id()).thenReturn(ofResult44);
    AppGroup appGroup45 = mock(AppGroup.class);
    Optional<Long> ofResult45 = Optional.<Long>of(1L);
    when(appGroup45.id()).thenReturn(ofResult45);
    AppGroup appGroup46 = mock(AppGroup.class);
    Optional<Long> ofResult46 = Optional.<Long>of(1L);
    when(appGroup46.id()).thenReturn(ofResult46);
    AppGroup appGroup47 = mock(AppGroup.class);
    Optional<Long> ofResult47 = Optional.<Long>of(1L);
    when(appGroup47.id()).thenReturn(ofResult47);
    AppGroup appGroup48 = mock(AppGroup.class);
    Optional<Long> ofResult48 = Optional.<Long>of(1L);
    when(appGroup48.id()).thenReturn(ofResult48);
    AppGroup appGroup49 = mock(AppGroup.class);
    Optional<Long> ofResult49 = Optional.<Long>of(1L);
    when(appGroup49.id()).thenReturn(ofResult49);
    AppGroup appGroup50 = mock(AppGroup.class);
    Optional<Long> ofResult50 = Optional.<Long>of(1L);
    when(appGroup50.id()).thenReturn(ofResult50);
    AppGroup appGroup51 = mock(AppGroup.class);
    Optional<Long> ofResult51 = Optional.<Long>of(1L);
    when(appGroup51.id()).thenReturn(ofResult51);
    AppGroup appGroup52 = mock(AppGroup.class);
    Optional<Long> ofResult52 = Optional.<Long>of(1L);
    when(appGroup52.id()).thenReturn(ofResult52);
    AppGroup appGroup53 = mock(AppGroup.class);
    Optional<Long> ofResult53 = Optional.<Long>of(1L);
    when(appGroup53.id()).thenReturn(ofResult53);
    AppGroup appGroup54 = mock(AppGroup.class);
    Optional<Long> ofResult54 = Optional.<Long>of(1L);
    when(appGroup54.id()).thenReturn(ofResult54);
    AppGroup appGroup55 = mock(AppGroup.class);
    Optional<Long> ofResult55 = Optional.<Long>of(1L);
    when(appGroup55.id()).thenReturn(ofResult55);
    AppGroup appGroup56 = mock(AppGroup.class);
    Optional<Long> ofResult56 = Optional.<Long>of(1L);
    when(appGroup56.id()).thenReturn(ofResult56);
    AppGroup appGroup57 = mock(AppGroup.class);
    Optional<Long> ofResult57 = Optional.<Long>of(1L);
    when(appGroup57.id()).thenReturn(ofResult57);
    AppGroup appGroup58 = mock(AppGroup.class);
    Optional<Long> ofResult58 = Optional.<Long>of(1L);
    when(appGroup58.id()).thenReturn(ofResult58);
    AppGroup appGroup59 = mock(AppGroup.class);
    Optional<Long> ofResult59 = Optional.<Long>of(1L);
    when(appGroup59.id()).thenReturn(ofResult59);
    AppGroup appGroup60 = mock(AppGroup.class);
    Optional<Long> ofResult60 = Optional.<Long>of(1L);
    when(appGroup60.id()).thenReturn(ofResult60);
    AppGroup appGroup61 = mock(AppGroup.class);
    Optional<Long> ofResult61 = Optional.<Long>of(1L);
    when(appGroup61.id()).thenReturn(ofResult61);
    AppGroup appGroup62 = mock(AppGroup.class);
    Optional<Long> ofResult62 = Optional.<Long>of(1L);
    when(appGroup62.id()).thenReturn(ofResult62);
    AppGroup appGroup63 = mock(AppGroup.class);
    Optional<Long> ofResult63 = Optional.<Long>of(1L);
    when(appGroup63.id()).thenReturn(ofResult63);
    AppGroup appGroup64 = mock(AppGroup.class);
    Optional<Long> ofResult64 = Optional.<Long>of(1L);
    when(appGroup64.id()).thenReturn(ofResult64);
    AppGroup appGroup65 = mock(AppGroup.class);
    Optional<Long> ofResult65 = Optional.<Long>of(1L);
    when(appGroup65.id()).thenReturn(ofResult65);
    AppGroup appGroup66 = mock(AppGroup.class);
    Optional<Long> ofResult66 = Optional.<Long>of(1L);
    when(appGroup66.id()).thenReturn(ofResult66);
    AppGroup appGroup67 = mock(AppGroup.class);
    Optional<Long> ofResult67 = Optional.<Long>of(1L);
    when(appGroup67.id()).thenReturn(ofResult67);
    AppGroup appGroup68 = mock(AppGroup.class);
    Optional<Long> ofResult68 = Optional.<Long>of(1L);
    when(appGroup68.id()).thenReturn(ofResult68);
    AppGroup appGroup69 = mock(AppGroup.class);
    Optional<Long> ofResult69 = Optional.<Long>of(1L);
    when(appGroup69.id()).thenReturn(ofResult69);
    AppGroup appGroup70 = mock(AppGroup.class);
    Optional<Long> ofResult70 = Optional.<Long>of(1L);
    when(appGroup70.id()).thenReturn(ofResult70);
    AppGroup appGroup71 = mock(AppGroup.class);
    when(appGroup71.id()).thenThrow(new IllegalArgumentException("kind"));

    ArrayList<AppGroup> appGroupList = new ArrayList<>();
    appGroupList.add(appGroup71);
    appGroupList.add(appGroup70);
    appGroupList.add(appGroup69);
    appGroupList.add(appGroup68);
    appGroupList.add(appGroup67);
    appGroupList.add(appGroup66);
    appGroupList.add(appGroup65);
    appGroupList.add(appGroup64);
    appGroupList.add(appGroup63);
    appGroupList.add(appGroup62);
    appGroupList.add(appGroup61);
    appGroupList.add(appGroup60);
    appGroupList.add(appGroup59);
    appGroupList.add(appGroup58);
    appGroupList.add(appGroup57);
    appGroupList.add(appGroup56);
    appGroupList.add(appGroup55);
    appGroupList.add(appGroup54);
    appGroupList.add(appGroup53);
    appGroupList.add(appGroup52);
    appGroupList.add(appGroup51);
    appGroupList.add(appGroup50);
    appGroupList.add(appGroup49);
    appGroupList.add(appGroup48);
    appGroupList.add(appGroup47);
    appGroupList.add(appGroup46);
    appGroupList.add(appGroup45);
    appGroupList.add(appGroup44);
    appGroupList.add(appGroup43);
    appGroupList.add(appGroup42);
    appGroupList.add(appGroup41);
    appGroupList.add(appGroup40);
    appGroupList.add(appGroup39);
    appGroupList.add(appGroup38);
    appGroupList.add(appGroup37);
    appGroupList.add(appGroup36);
    appGroupList.add(appGroup35);
    appGroupList.add(appGroup34);
    appGroupList.add(appGroup33);
    appGroupList.add(appGroup32);
    appGroupList.add(appGroup31);
    appGroupList.add(appGroup30);
    appGroupList.add(appGroup29);
    appGroupList.add(appGroup28);
    appGroupList.add(appGroup27);
    appGroupList.add(appGroup26);
    appGroupList.add(appGroup25);
    appGroupList.add(appGroup24);
    appGroupList.add(appGroup23);
    appGroupList.add(appGroup22);
    appGroupList.add(appGroup21);
    appGroupList.add(appGroup20);
    appGroupList.add(appGroup19);
    appGroupList.add(appGroup18);
    appGroupList.add(appGroup17);
    appGroupList.add(appGroup16);
    appGroupList.add(appGroup15);
    appGroupList.add(appGroup14);
    appGroupList.add(appGroup13);
    appGroupList.add(appGroup12);
    appGroupList.add(appGroup11);
    appGroupList.add(appGroup10);
    appGroupList.add(appGroup9);
    appGroupList.add(appGroup8);
    appGroupList.add(appGroup7);
    appGroupList.add(appGroup6);
    appGroupList.add(appGroup5);
    appGroupList.add(appGroup4);
    appGroupList.add(appGroup3);
    appGroupList.add(appGroup2);
    appGroupList.add(appGroup);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.deleteGroup(anyLong())).thenReturn(1);
    when(appGroupDao.findGroupsForUser(Mockito.<String>any())).thenReturn(appGroupList);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.getSubscriptions(Mockito.<String>any())).thenReturn(new HashSet<>());
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.removeAnyInvolving(Mockito.<EntityReference>any())).thenReturn(1);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new AppGroupService(appGroupDao, appGroupMemberDao,
        appGroupEntryDao, applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        new ChangeInitiativeService(changeInitiativeDao, searchDao, relationshipDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        changeLogService)).deleteGroup("42", 1L));
    verify(appGroupDao).deleteGroup(eq(1L));
    verify(appGroupDao).findGroupsForUser(eq("42"));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(appGroupMemberDao).getSubscriptions(eq("42"));
    verify(entityRelationshipDao).removeAnyInvolving(isA(EntityReference.class));
    verify(appGroup71).id();
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Method under test: {@link AppGroupService#addApplication(String, long, long)}
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

    // Act
    List<AppGroupEntry> actualAddApplicationResult = (new AppGroupService(appGroupDao, appGroupMemberDao,
        appGroupEntryDao, applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        changeInitiativeService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .addApplication("42", 1L, 1L);

    // Assert
    verify(appGroupEntryDao).findEntriesForGroup(eq(1L));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(applicationDao).getById(eq(1L));
    assertTrue(actualAddApplicationResult.isEmpty());
    assertSame(appGroupEntryList, actualAddApplicationResult);
  }

  /**
   * Method under test: {@link AppGroupService#addApplication(String, long, long)}
   */
  @Test
  void testAddApplication2() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.getById(anyLong())).thenThrow(new IllegalArgumentException("foo"));
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
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
    assertThrows(IllegalArgumentException.class,
        () -> (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao, applicationDao,
            appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao, changeInitiativeService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .addApplication("42", 1L, 1L));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(applicationDao).getById(eq(1L));
  }

  /**
   * Method under test: {@link AppGroupService#addApplication(String, long, long)}
   */
  @Test
  void testAddApplication3() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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

    // Act and Assert
    assertThrows(InsufficientPrivelegeException.class,
        () -> (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao, applicationDao,
            appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao, changeInitiativeService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .addApplication("42", 1L, 1L));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
  }

  /**
   * Method under test: {@link AppGroupService#addApplication(String, long, long)}
   */
  @Test
  void testAddApplication4() throws InsufficientPrivelegeException {
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

    // Act
    List<AppGroupEntry> actualAddApplicationResult = (new AppGroupService(appGroupDao, appGroupMemberDao,
        appGroupEntryDao, applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        new ChangeInitiativeService(changeInitiativeDao, searchDao, relationshipDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        changeLogService)).addApplication("42", 1L, 1L);

    // Assert
    verify(appGroupEntryDao).addApplication(eq(1L), eq(1L));
    verify(appGroupEntryDao).findEntriesForGroup(eq(1L));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(applicationDao).getById(eq(1L));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(application).name();
    assertTrue(actualAddApplicationResult.isEmpty());
    assertSame(appGroupEntryList, actualAddApplicationResult);
  }

  /**
   * Method under test: {@link AppGroupService#addApplication(String, long, long)}
   */
  @Test
  void testAddApplication5() throws InsufficientPrivelegeException {
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

    // Act
    List<AppGroupEntry> actualAddApplicationResult = (new AppGroupService(appGroupDao, appGroupMemberDao,
        appGroupEntryDao, applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        new ChangeInitiativeService(changeInitiativeDao, searchDao, relationshipDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        changeLogService)).addApplication("42", 1L, 1L);

    // Assert
    verify(appGroupEntryDao).addApplication(eq(1L), eq(1L));
    verify(appGroupEntryDao).findEntriesForGroup(eq(1L));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(applicationDao).getById(eq(1L));
    verify(application).name();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualAddApplicationResult.isEmpty());
    assertSame(appGroupEntryList, actualAddApplicationResult);
  }

  /**
   * Method under test:
   * {@link AppGroupService#addApplications(String, long, Collection, Collection)}
   */
  @Test
  void testAddApplications() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.addApplications(anyLong(), Mockito.<Collection<Long>>any()))
        .thenReturn(new int[]{2, 1, 2, 1});
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(appGroupEntryList);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
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
    ArrayList<Long> applicationIds = new ArrayList<>();

    // Act
    List<AppGroupEntry> actualAddApplicationsResult = appGroupService.addApplications("42", 1L, applicationIds,
        new ArrayList<>());

    // Assert
    verify(appGroupEntryDao).addApplications(eq(1L), isA(Collection.class));
    verify(appGroupEntryDao).findEntriesForGroup(eq(1L));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(applicationDao).findByIds(isA(Collection.class));
    verify(changeLogDao).write(isA(Collection.class));
    assertTrue(actualAddApplicationsResult.isEmpty());
    assertSame(appGroupEntryList, actualAddApplicationsResult);
  }

  /**
   * Method under test:
   * {@link AppGroupService#addApplications(String, long, Collection, Collection)}
   */
  @Test
  void testAddApplications2() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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

    AppGroupService appGroupService = new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        changeInitiativeService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    ArrayList<Long> applicationIds = new ArrayList<>();

    // Act and Assert
    assertThrows(InsufficientPrivelegeException.class,
        () -> appGroupService.addApplications("42", 1L, applicationIds, new ArrayList<>()));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
  }

  /**
   * Method under test:
   * {@link AppGroupService#addApplications(String, long, Collection, Collection)}
   */
  @Test
  void testAddApplications3() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.addApplications(anyLong(), Mockito.<Collection<Long>>any()))
        .thenReturn(new int[]{2, 1, 2, 1});
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(appGroupEntryList);
    Application application = mock(Application.class);
    when(application.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(application.id()).thenReturn(ofResult);

    ArrayList<Application> applicationList = new ArrayList<>();
    applicationList.add(application);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(applicationList);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
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
    ArrayList<Long> applicationIds = new ArrayList<>();

    // Act
    List<AppGroupEntry> actualAddApplicationsResult = appGroupService.addApplications("42", 1L, applicationIds,
        new ArrayList<>());

    // Assert
    verify(appGroupEntryDao).addApplications(eq(1L), isA(Collection.class));
    verify(appGroupEntryDao).findEntriesForGroup(eq(1L));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(applicationDao).findByIds(isA(Collection.class));
    verify(changeLogDao).write(isA(Collection.class));
    verify(application).id();
    verify(application).name();
    assertTrue(actualAddApplicationsResult.isEmpty());
    assertSame(appGroupEntryList, actualAddApplicationsResult);
  }

  /**
   * Method under test:
   * {@link AppGroupService#addApplications(String, long, Collection, Collection)}
   */
  @Test
  void testAddApplications4() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.addApplications(anyLong(), Mockito.<Collection<Long>>any()))
        .thenReturn(new int[]{2, 1, 2, 1});
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(appGroupEntryList);
    Application application = mock(Application.class);
    when(application.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(application.id()).thenReturn(ofResult);
    Application application2 = mock(Application.class);
    when(application2.name()).thenReturn("Name");
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(application2.id()).thenReturn(ofResult2);

    ArrayList<Application> applicationList = new ArrayList<>();
    applicationList.add(application2);
    applicationList.add(application);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(applicationList);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
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
    ArrayList<Long> applicationIds = new ArrayList<>();

    // Act
    List<AppGroupEntry> actualAddApplicationsResult = appGroupService.addApplications("42", 1L, applicationIds,
        new ArrayList<>());

    // Assert
    verify(appGroupEntryDao).addApplications(eq(1L), isA(Collection.class));
    verify(appGroupEntryDao).findEntriesForGroup(eq(1L));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(applicationDao).findByIds(isA(Collection.class));
    verify(changeLogDao).write(isA(Collection.class));
    verify(application2).id();
    verify(application).id();
    verify(application2).name();
    verify(application).name();
    assertTrue(actualAddApplicationsResult.isEmpty());
    assertSame(appGroupEntryList, actualAddApplicationsResult);
  }

  /**
   * Method under test:
   * {@link AppGroupService#addApplications(String, long, Collection, Collection)}
   */
  @Test
  void testAddApplications5() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.addApplications(anyLong(), Mockito.<Collection<Long>>any()))
        .thenReturn(new int[]{2, 1, 2, 1});
    Application application = mock(Application.class);
    when(application.name()).thenReturn("Name");
    Application application2 = mock(Application.class);
    when(application2.name()).thenReturn("Name");
    Application application3 = mock(Application.class);
    when(application3.name()).thenThrow(new IllegalArgumentException("kind"));

    ArrayList<Application> applicationList = new ArrayList<>();
    applicationList.add(application3);
    applicationList.add(application2);
    applicationList.add(application);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(applicationList);
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
    ArrayList<Long> applicationIds = new ArrayList<>();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> appGroupService.addApplications("42", 1L, applicationIds, new ArrayList<>()));
    verify(appGroupEntryDao).addApplications(eq(1L), isA(Collection.class));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(applicationDao).findByIds(isA(Collection.class));
    verify(application3).name();
  }

  /**
   * Method under test:
   * {@link AppGroupService#addApplications(String, long, Collection, Collection)}
   */
  @Test
  void testAddApplications6() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.addApplications(anyLong(), Mockito.<Collection<Long>>any()))
        .thenReturn(new int[]{2, 1, 2, 1});
    Application application = mock(Application.class);
    when(application.name()).thenReturn("Name");
    Application application2 = mock(Application.class);
    when(application2.name()).thenReturn("Name");
    Application application3 = mock(Application.class);
    when(application3.name()).thenThrow(new IllegalArgumentException("kind"));

    ArrayList<Application> applicationList = new ArrayList<>();
    applicationList.add(application3);
    applicationList.add(application2);
    applicationList.add(application);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(applicationList);
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

    ArrayList<Long> applicationIds = new ArrayList<>();
    applicationIds.add(2L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> appGroupService.addApplications("42", 1L, applicationIds, new ArrayList<>()));
    verify(appGroupEntryDao).addApplications(eq(1L), isA(Collection.class));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(applicationDao).findByIds(isA(Collection.class));
    verify(application3).name();
  }

  /**
   * Method under test:
   * {@link AppGroupService#addApplications(String, long, Collection, Collection)}
   */
  @Test
  void testAddApplications7() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.addApplications(anyLong(), Mockito.<Collection<Long>>any()))
        .thenReturn(new int[]{2, 1, 2, 1});
    Application application = mock(Application.class);
    when(application.name()).thenReturn("Name");
    Application application2 = mock(Application.class);
    when(application2.name()).thenReturn("Name");
    Application application3 = mock(Application.class);
    when(application3.name()).thenThrow(new IllegalArgumentException("kind"));

    ArrayList<Application> applicationList = new ArrayList<>();
    applicationList.add(application3);
    applicationList.add(application2);
    applicationList.add(application);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(applicationList);
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

    ArrayList<Long> applicationIds = new ArrayList<>();
    applicationIds.add(1L);
    applicationIds.add(2L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> appGroupService.addApplications("42", 1L, applicationIds, new ArrayList<>()));
    verify(appGroupEntryDao).addApplications(eq(1L), isA(Collection.class));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(applicationDao).findByIds(isA(Collection.class));
    verify(application3).name();
  }

  /**
   * Method under test:
   * {@link AppGroupService#addApplications(String, long, Collection, Collection)}
   */
  @Test
  void testAddApplications8() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.addApplications(anyLong(), Mockito.<Collection<Long>>any()))
        .thenReturn(new int[]{2, 1, 2, 1});
    Application application = mock(Application.class);
    when(application.name()).thenReturn("Name");
    Application application2 = mock(Application.class);
    when(application2.name()).thenReturn("Name");
    Application application3 = mock(Application.class);
    when(application3.name()).thenThrow(new IllegalArgumentException("kind"));

    ArrayList<Application> applicationList = new ArrayList<>();
    applicationList.add(application3);
    applicationList.add(application2);
    applicationList.add(application);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(applicationList);
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
    ArrayList<Long> applicationIds = new ArrayList<>();

    ArrayList<String> unknownIdentifiers = new ArrayList<>();
    unknownIdentifiers.add("kind");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> appGroupService.addApplications("42", 1L, applicationIds, unknownIdentifiers));
    verify(appGroupEntryDao).addApplications(eq(1L), isA(Collection.class));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(applicationDao).findByIds(isA(Collection.class));
    verify(application3).name();
  }

  /**
   * Method under test:
   * {@link AppGroupService#addApplications(String, long, Collection, Collection)}
   */
  @Test
  void testAddApplications9() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.addApplications(anyLong(), Mockito.<Collection<Long>>any()))
        .thenReturn(new int[]{2, 1, 2, 1});
    Application application = mock(Application.class);
    when(application.name()).thenReturn("Name");
    Application application2 = mock(Application.class);
    when(application2.name()).thenReturn("Name");
    Application application3 = mock(Application.class);
    when(application3.name()).thenThrow(new IllegalArgumentException("kind"));

    ArrayList<Application> applicationList = new ArrayList<>();
    applicationList.add(application3);
    applicationList.add(application2);
    applicationList.add(application);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(applicationList);
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
    ArrayList<Long> applicationIds = new ArrayList<>();

    ArrayList<String> unknownIdentifiers = new ArrayList<>();
    unknownIdentifiers.add("entityLifecycleStatus");
    unknownIdentifiers.add("kind");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> appGroupService.addApplications("42", 1L, applicationIds, unknownIdentifiers));
    verify(appGroupEntryDao).addApplications(eq(1L), isA(Collection.class));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(applicationDao).findByIds(isA(Collection.class));
    verify(application3).name();
  }

  /**
   * Method under test:
   * {@link AppGroupService#removeApplication(String, long, long)}
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

    // Act
    List<AppGroupEntry> actualRemoveApplicationResult = (new AppGroupService(appGroupDao, appGroupMemberDao,
        appGroupEntryDao, applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        new ChangeInitiativeService(changeInitiativeDao, searchDao, relationshipDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        changeLogService)).removeApplication("42", 1L, 1L);

    // Assert
    verify(appGroupEntryDao).findEntriesForGroup(eq(1L));
    verify(appGroupEntryDao).removeApplication(eq(1L), eq(1L));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(applicationDao).getById(eq(1L));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    assertTrue(actualRemoveApplicationResult.isEmpty());
    assertSame(appGroupEntryList, actualRemoveApplicationResult);
  }

  /**
   * Method under test:
   * {@link AppGroupService#removeApplication(String, long, long)}
   */
  @Test
  void testRemoveApplication2() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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

    // Act and Assert
    assertThrows(InsufficientPrivelegeException.class,
        () -> (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao, applicationDao,
            appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao, changeInitiativeService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .removeApplication("42", 1L, 1L));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
  }

  /**
   * Method under test:
   * {@link AppGroupService#removeApplication(String, long, long)}
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

    // Act
    List<AppGroupEntry> actualRemoveApplicationResult = (new AppGroupService(appGroupDao, appGroupMemberDao,
        appGroupEntryDao, applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        new ChangeInitiativeService(changeInitiativeDao, searchDao, relationshipDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        changeLogService)).removeApplication("42", 1L, 1L);

    // Assert
    verify(appGroupEntryDao).findEntriesForGroup(eq(1L));
    verify(appGroupEntryDao).removeApplication(eq(1L), eq(1L));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(applicationDao).getById(eq(1L));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(application).name();
    assertTrue(actualRemoveApplicationResult.isEmpty());
    assertSame(appGroupEntryList, actualRemoveApplicationResult);
  }

  /**
   * Method under test:
   * {@link AppGroupService#removeApplication(String, long, long)}
   */
  @Test
  void testRemoveApplication4() throws InsufficientPrivelegeException {
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

    // Act
    List<AppGroupEntry> actualRemoveApplicationResult = (new AppGroupService(appGroupDao, appGroupMemberDao,
        appGroupEntryDao, applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        new ChangeInitiativeService(changeInitiativeDao, searchDao, relationshipDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        changeLogService)).removeApplication("42", 1L, 1L);

    // Assert
    verify(appGroupEntryDao).findEntriesForGroup(eq(1L));
    verify(appGroupEntryDao).removeApplication(eq(1L), eq(1L));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(applicationDao).getById(eq(1L));
    verify(application).name();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualRemoveApplicationResult.isEmpty());
    assertSame(appGroupEntryList, actualRemoveApplicationResult);
  }

  /**
   * Method under test:
   * {@link AppGroupService#addOrganisationalUnit(String, long, long)}
   */
  @Test
  void testAddOrganisationalUnit() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(appGroupEntryList);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    when(organisationalUnitDao.getById(anyLong())).thenReturn(null);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
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

    // Act
    List<AppGroupEntry> actualAddOrganisationalUnitResult = (new AppGroupService(appGroupDao, appGroupMemberDao,
        appGroupEntryDao, applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        changeInitiativeService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .addOrganisationalUnit("42", 1L, 1L);

    // Assert
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(eq(1L));
    verify(organisationalUnitDao).getById(eq(1L));
    assertTrue(actualAddOrganisationalUnitResult.isEmpty());
    assertSame(appGroupEntryList, actualAddOrganisationalUnitResult);
  }

  /**
   * Method under test:
   * {@link AppGroupService#addOrganisationalUnit(String, long, long)}
   */
  @Test
  void testAddOrganisationalUnit2() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    when(organisationalUnitDao.getById(anyLong())).thenThrow(new IllegalArgumentException("foo"));
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
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
    assertThrows(IllegalArgumentException.class,
        () -> (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao, applicationDao,
            appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao, changeInitiativeService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .addOrganisationalUnit("42", 1L, 1L));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(organisationalUnitDao).getById(eq(1L));
  }

  /**
   * Method under test:
   * {@link AppGroupService#addOrganisationalUnit(String, long, long)}
   */
  @Test
  void testAddOrganisationalUnit3() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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

    // Act and Assert
    assertThrows(InsufficientPrivelegeException.class,
        () -> (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao, applicationDao,
            appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao, changeInitiativeService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .addOrganisationalUnit("42", 1L, 1L));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
  }

  /**
   * Method under test:
   * {@link AppGroupService#addOrganisationalUnit(String, long, long)}
   */
  @Test
  void testAddOrganisationalUnit4() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.addOrgUnit(anyLong(), anyLong())).thenReturn(2);
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(appGroupEntryList);
    OrganisationalUnit organisationalUnit = mock(OrganisationalUnit.class);
    when(organisationalUnit.name()).thenReturn("Name");
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    when(organisationalUnitDao.getById(anyLong())).thenReturn(organisationalUnit);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);

    // Act
    List<AppGroupEntry> actualAddOrganisationalUnitResult = (new AppGroupService(appGroupDao, appGroupMemberDao,
        appGroupEntryDao, applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        new ChangeInitiativeService(changeInitiativeDao, searchDao, relationshipDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        changeLogService)).addOrganisationalUnit("42", 1L, 1L);

    // Assert
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(appGroupOrganisationalUnitDao).addOrgUnit(eq(1L), eq(1L));
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(eq(1L));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(organisationalUnitDao).getById(eq(1L));
    verify(organisationalUnit).name();
    assertTrue(actualAddOrganisationalUnitResult.isEmpty());
    assertSame(appGroupEntryList, actualAddOrganisationalUnitResult);
  }

  /**
   * Method under test:
   * {@link AppGroupService#addOrganisationalUnit(String, long, long)}
   */
  @Test
  void testAddOrganisationalUnit5() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.addOrgUnit(anyLong(), anyLong())).thenReturn(2);
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(appGroupEntryList);
    OrganisationalUnit organisationalUnit = mock(OrganisationalUnit.class);
    when(organisationalUnit.name()).thenReturn("Name");
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    when(organisationalUnitDao.getById(anyLong())).thenReturn(organisationalUnit);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);

    // Act
    List<AppGroupEntry> actualAddOrganisationalUnitResult = (new AppGroupService(appGroupDao, appGroupMemberDao,
        appGroupEntryDao, applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        new ChangeInitiativeService(changeInitiativeDao, searchDao, relationshipDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        changeLogService)).addOrganisationalUnit("42", 1L, 1L);

    // Assert
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(appGroupOrganisationalUnitDao).addOrgUnit(eq(1L), eq(1L));
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(eq(1L));
    verify(organisationalUnitDao).getById(eq(1L));
    verify(organisationalUnit).name();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualAddOrganisationalUnitResult.isEmpty());
    assertSame(appGroupEntryList, actualAddOrganisationalUnitResult);
  }

  /**
   * Method under test:
   * {@link AppGroupService#removeOrganisationalUnit(String, long, long)}
   */
  @Test
  void testRemoveOrganisationalUnit() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.removeOrgUnit(anyLong(), anyLong())).thenReturn(1);
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(appGroupEntryList);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    when(organisationalUnitDao.getById(anyLong())).thenReturn(null);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);

    // Act
    List<AppGroupEntry> actualRemoveOrganisationalUnitResult = (new AppGroupService(appGroupDao, appGroupMemberDao,
        appGroupEntryDao, applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        new ChangeInitiativeService(changeInitiativeDao, searchDao, relationshipDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        changeLogService)).removeOrganisationalUnit("42", 1L, 1L);

    // Assert
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(eq(1L));
    verify(appGroupOrganisationalUnitDao).removeOrgUnit(eq(1L), eq(1L));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(organisationalUnitDao).getById(eq(1L));
    assertTrue(actualRemoveOrganisationalUnitResult.isEmpty());
    assertSame(appGroupEntryList, actualRemoveOrganisationalUnitResult);
  }

  /**
   * Method under test:
   * {@link AppGroupService#removeOrganisationalUnit(String, long, long)}
   */
  @Test
  void testRemoveOrganisationalUnit2() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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

    // Act and Assert
    assertThrows(InsufficientPrivelegeException.class,
        () -> (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao, applicationDao,
            appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao, changeInitiativeService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .removeOrganisationalUnit("42", 1L, 1L));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
  }

  /**
   * Method under test:
   * {@link AppGroupService#removeOrganisationalUnit(String, long, long)}
   */
  @Test
  void testRemoveOrganisationalUnit3() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.removeOrgUnit(anyLong(), anyLong())).thenReturn(1);
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(appGroupEntryList);
    OrganisationalUnit organisationalUnit = mock(OrganisationalUnit.class);
    when(organisationalUnit.name()).thenReturn("Name");
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    when(organisationalUnitDao.getById(anyLong())).thenReturn(organisationalUnit);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);

    // Act
    List<AppGroupEntry> actualRemoveOrganisationalUnitResult = (new AppGroupService(appGroupDao, appGroupMemberDao,
        appGroupEntryDao, applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        new ChangeInitiativeService(changeInitiativeDao, searchDao, relationshipDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        changeLogService)).removeOrganisationalUnit("42", 1L, 1L);

    // Assert
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(eq(1L));
    verify(appGroupOrganisationalUnitDao).removeOrgUnit(eq(1L), eq(1L));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(organisationalUnitDao).getById(eq(1L));
    verify(organisationalUnit).name();
    assertTrue(actualRemoveOrganisationalUnitResult.isEmpty());
    assertSame(appGroupEntryList, actualRemoveOrganisationalUnitResult);
  }

  /**
   * Method under test:
   * {@link AppGroupService#removeOrganisationalUnit(String, long, long)}
   */
  @Test
  void testRemoveOrganisationalUnit4() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.removeOrgUnit(anyLong(), anyLong())).thenReturn(1);
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(appGroupEntryList);
    OrganisationalUnit organisationalUnit = mock(OrganisationalUnit.class);
    when(organisationalUnit.name()).thenReturn("Name");
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    when(organisationalUnitDao.getById(anyLong())).thenReturn(organisationalUnit);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);

    // Act
    List<AppGroupEntry> actualRemoveOrganisationalUnitResult = (new AppGroupService(appGroupDao, appGroupMemberDao,
        appGroupEntryDao, applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        new ChangeInitiativeService(changeInitiativeDao, searchDao, relationshipDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        changeLogService)).removeOrganisationalUnit("42", 1L, 1L);

    // Assert
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(eq(1L));
    verify(appGroupOrganisationalUnitDao).removeOrgUnit(eq(1L), eq(1L));
    verify(organisationalUnitDao).getById(eq(1L));
    verify(organisationalUnit).name();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualRemoveOrganisationalUnitResult.isEmpty());
    assertSame(appGroupEntryList, actualRemoveOrganisationalUnitResult);
  }

  /**
   * Method under test:
   * {@link AppGroupService#removeApplications(String, long, List)}
   */
  @Test
  void testRemoveApplications() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.removeApplications(anyLong(), Mockito.<List<Long>>any())).thenReturn(1);
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(appGroupEntryList);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
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

    // Act
    List<AppGroupEntry> actualRemoveApplicationsResult = appGroupService.removeApplications("42", 1L,
        new ArrayList<>());

    // Assert
    verify(appGroupEntryDao).findEntriesForGroup(eq(1L));
    verify(appGroupEntryDao).removeApplications(eq(1L), isA(List.class));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(applicationDao).findByIds(isA(Collection.class));
    verify(changeLogDao).write(isA(Collection.class));
    assertTrue(actualRemoveApplicationsResult.isEmpty());
    assertSame(appGroupEntryList, actualRemoveApplicationsResult);
  }

  /**
   * Method under test:
   * {@link AppGroupService#removeApplications(String, long, List)}
   */
  @Test
  void testRemoveApplications2() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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

    AppGroupService appGroupService = new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        changeInitiativeService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    // Act and Assert
    assertThrows(InsufficientPrivelegeException.class,
        () -> appGroupService.removeApplications("42", 1L, new ArrayList<>()));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
  }

  /**
   * Method under test:
   * {@link AppGroupService#removeApplications(String, long, List)}
   */
  @Test
  void testRemoveApplications3() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.removeApplications(anyLong(), Mockito.<List<Long>>any())).thenReturn(1);
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(appGroupEntryList);
    Application application = mock(Application.class);
    when(application.name()).thenReturn("Name");

    ArrayList<Application> applicationList = new ArrayList<>();
    applicationList.add(application);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(applicationList);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
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

    // Act
    List<AppGroupEntry> actualRemoveApplicationsResult = appGroupService.removeApplications("42", 1L,
        new ArrayList<>());

    // Assert
    verify(appGroupEntryDao).findEntriesForGroup(eq(1L));
    verify(appGroupEntryDao).removeApplications(eq(1L), isA(List.class));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(applicationDao).findByIds(isA(Collection.class));
    verify(changeLogDao).write(isA(Collection.class));
    verify(application).name();
    assertTrue(actualRemoveApplicationsResult.isEmpty());
    assertSame(appGroupEntryList, actualRemoveApplicationsResult);
  }

  /**
   * Method under test:
   * {@link AppGroupService#removeApplications(String, long, List)}
   */
  @Test
  void testRemoveApplications4() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.removeApplications(anyLong(), Mockito.<List<Long>>any())).thenReturn(1);
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(appGroupEntryList);
    Application application = mock(Application.class);
    when(application.name()).thenReturn("Name");
    Application application2 = mock(Application.class);
    when(application2.name()).thenReturn("Name");

    ArrayList<Application> applicationList = new ArrayList<>();
    applicationList.add(application2);
    applicationList.add(application);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(applicationList);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
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

    // Act
    List<AppGroupEntry> actualRemoveApplicationsResult = appGroupService.removeApplications("42", 1L,
        new ArrayList<>());

    // Assert
    verify(appGroupEntryDao).findEntriesForGroup(eq(1L));
    verify(appGroupEntryDao).removeApplications(eq(1L), isA(List.class));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(applicationDao).findByIds(isA(Collection.class));
    verify(changeLogDao).write(isA(Collection.class));
    verify(application2).name();
    verify(application).name();
    assertTrue(actualRemoveApplicationsResult.isEmpty());
    assertSame(appGroupEntryList, actualRemoveApplicationsResult);
  }

  /**
   * Method under test:
   * {@link AppGroupService#removeApplications(String, long, List)}
   */
  @Test
  void testRemoveApplications5() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.removeApplications(anyLong(), Mockito.<List<Long>>any())).thenReturn(1);
    Application application = mock(Application.class);
    when(application.name()).thenReturn("Name");
    Application application2 = mock(Application.class);
    when(application2.name()).thenReturn("Name");
    Application application3 = mock(Application.class);
    when(application3.name()).thenThrow(new IllegalArgumentException("Removed application %s from group"));

    ArrayList<Application> applicationList = new ArrayList<>();
    applicationList.add(application3);
    applicationList.add(application2);
    applicationList.add(application);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(applicationList);
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

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> appGroupService.removeApplications("42", 1L, new ArrayList<>()));
    verify(appGroupEntryDao).removeApplications(eq(1L), isA(List.class));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(applicationDao).findByIds(isA(Collection.class));
    verify(application3).name();
  }

  /**
   * Method under test:
   * {@link AppGroupService#removeApplications(String, long, List)}
   */
  @Test
  void testRemoveApplications6() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.removeApplications(anyLong(), Mockito.<List<Long>>any())).thenReturn(1);
    Application application = mock(Application.class);
    when(application.name()).thenReturn("Name");
    Application application2 = mock(Application.class);
    when(application2.name()).thenReturn("Name");
    Application application3 = mock(Application.class);
    when(application3.name()).thenThrow(new IllegalArgumentException("Removed application %s from group"));

    ArrayList<Application> applicationList = new ArrayList<>();
    applicationList.add(application3);
    applicationList.add(application2);
    applicationList.add(application);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(applicationList);
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

    ArrayList<Long> applicationIds = new ArrayList<>();
    applicationIds.add(2L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> appGroupService.removeApplications("42", 1L, applicationIds));
    verify(appGroupEntryDao).removeApplications(eq(1L), isA(List.class));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(applicationDao).findByIds(isA(Collection.class));
    verify(application3).name();
  }

  /**
   * Method under test:
   * {@link AppGroupService#removeApplications(String, long, List)}
   */
  @Test
  void testRemoveApplications7() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.removeApplications(anyLong(), Mockito.<List<Long>>any())).thenReturn(1);
    Application application = mock(Application.class);
    when(application.name()).thenReturn("Name");
    Application application2 = mock(Application.class);
    when(application2.name()).thenReturn("Name");
    Application application3 = mock(Application.class);
    when(application3.name()).thenThrow(new IllegalArgumentException("Removed application %s from group"));

    ArrayList<Application> applicationList = new ArrayList<>();
    applicationList.add(application3);
    applicationList.add(application2);
    applicationList.add(application);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(applicationList);
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

    ArrayList<Long> applicationIds = new ArrayList<>();
    applicationIds.add(1L);
    applicationIds.add(2L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> appGroupService.removeApplications("42", 1L, applicationIds));
    verify(appGroupEntryDao).removeApplications(eq(1L), isA(List.class));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(applicationDao).findByIds(isA(Collection.class));
    verify(application3).name();
  }

  /**
   * Method under test: {@link AppGroupService#addOwner(String, long, String)}
   */
  @Test
  void testAddOwner() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.register(anyLong(), Mockito.<String>any(), Mockito.<AppGroupMemberRole>any())).thenReturn(1);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);

    // Act
    int actualAddOwnerResult = (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao, applicationDao,
        appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        new ChangeInitiativeService(changeInitiativeDao, searchDao, relationshipDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        changeLogService)).addOwner("42", 1L, "42");

    // Assert
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(appGroupMemberDao).register(eq(1L), eq("42"), eq(AppGroupMemberRole.OWNER));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    assertEquals(1, actualAddOwnerResult);
  }

  /**
   * Method under test: {@link AppGroupService#addOwner(String, long, String)}
   */
  @Test
  void testAddOwner2() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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

    // Act and Assert
    assertThrows(InsufficientPrivelegeException.class,
        () -> (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao, applicationDao,
            appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao, changeInitiativeService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .addOwner("42", 1L, "42"));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
  }

  /**
   * Method under test: {@link AppGroupService#addOwner(String, long, String)}
   */
  @Test
  void testAddOwner3() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.register(anyLong(), Mockito.<String>any(), Mockito.<AppGroupMemberRole>any())).thenReturn(1);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);

    // Act
    int actualAddOwnerResult = (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao, applicationDao,
        appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        new ChangeInitiativeService(changeInitiativeDao, searchDao, relationshipDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        changeLogService)).addOwner("42", 1L, "42");

    // Assert
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(appGroupMemberDao).register(eq(1L), eq("42"), eq(AppGroupMemberRole.OWNER));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1, actualAddOwnerResult);
  }

  /**
   * Method under test: {@link AppGroupService#removeOwner(String, long, String)}
   */
  @Test
  void testRemoveOwner() throws InsufficientPrivelegeException {
    // Arrange
    AppGroup appGroup = mock(AppGroup.class);
    when(appGroup.isFavouriteGroup()).thenReturn(true);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong())).thenReturn(appGroup);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.unregister(anyLong(), Mockito.<String>any())).thenReturn(true);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
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

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao, applicationDao,
            appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao, changeInitiativeService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .removeOwner("42", 1L, "42"));
    verify(appGroupDao).getGroup(eq(1L));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(appGroupMemberDao).unregister(eq(1L), eq("42"));
    verify(appGroup).isFavouriteGroup();
  }

  /**
   * Method under test: {@link AppGroupService#removeOwner(String, long, String)}
   */
  @Test
  void testRemoveOwner2() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.unregister(anyLong(), Mockito.<String>any())).thenThrow(new IllegalArgumentException("foo"));
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao, applicationDao,
            appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao, changeInitiativeService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .removeOwner("42", 1L, "42"));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(appGroupMemberDao).unregister(eq(1L), eq("42"));
  }

  /**
   * Method under test: {@link AppGroupService#removeOwner(String, long, String)}
   */
  @Test
  void testRemoveOwner3() throws InsufficientPrivelegeException {
    // Arrange
    AppGroup appGroup = mock(AppGroup.class);
    when(appGroup.name()).thenReturn("Name");
    when(appGroup.isFavouriteGroup()).thenReturn(false);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong())).thenReturn(appGroup);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.register(anyLong(), Mockito.<String>any())).thenReturn(1);
    when(appGroupMemberDao.unregister(anyLong(), Mockito.<String>any())).thenReturn(true);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);

    // Act
    boolean actualRemoveOwnerResult = (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        new ChangeInitiativeService(changeInitiativeDao, searchDao, relationshipDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        changeLogService)).removeOwner("42", 1L, "42");

    // Assert
    verify(appGroupDao).getGroup(eq(1L));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(appGroupMemberDao).register(eq(1L), eq("42"));
    verify(appGroupMemberDao).unregister(eq(1L), eq("42"));
    verify(changeLogDao, atLeast(1)).write(isA(Optional.class), Mockito.<ChangeLog>any());
    verify(appGroup).name();
    verify(appGroup).isFavouriteGroup();
    assertTrue(actualRemoveOwnerResult);
  }

  /**
   * Method under test: {@link AppGroupService#removeOwner(String, long, String)}
   */
  @Test
  void testRemoveOwner4() throws InsufficientPrivelegeException {
    // Arrange
    AppGroup appGroup = mock(AppGroup.class);
    when(appGroup.name()).thenReturn("Name");
    when(appGroup.isFavouriteGroup()).thenReturn(false);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong())).thenReturn(appGroup);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.register(anyLong(), Mockito.<String>any())).thenReturn(1);
    when(appGroupMemberDao.unregister(anyLong(), Mockito.<String>any())).thenReturn(false);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);

    // Act
    boolean actualRemoveOwnerResult = (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        new ChangeInitiativeService(changeInitiativeDao, searchDao, relationshipDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        changeLogService)).removeOwner("42", 1L, "42");

    // Assert
    verify(appGroupDao).getGroup(eq(1L));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(appGroupMemberDao).register(eq(1L), eq("42"));
    verify(appGroupMemberDao).unregister(eq(1L), eq("42"));
    verify(changeLogDao, atLeast(1)).write(isA(Optional.class), Mockito.<ChangeLog>any());
    verify(appGroup).name();
    verify(appGroup).isFavouriteGroup();
    assertFalse(actualRemoveOwnerResult);
  }

  /**
   * Method under test: {@link AppGroupService#removeOwner(String, long, String)}
   */
  @Test
  void testRemoveOwner5() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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

    // Act and Assert
    assertThrows(InsufficientPrivelegeException.class,
        () -> (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao, applicationDao,
            appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao, changeInitiativeService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .removeOwner("42", 1L, "42"));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
  }

  /**
   * Method under test: {@link AppGroupService#removeOwner(String, long, String)}
   */
  @Test
  void testRemoveOwner6() throws InsufficientPrivelegeException {
    // Arrange
    AppGroup appGroup = mock(AppGroup.class);
    when(appGroup.name()).thenReturn("Name");
    when(appGroup.isFavouriteGroup()).thenReturn(false);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.getGroup(anyLong())).thenReturn(appGroup);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.register(anyLong(), Mockito.<String>any())).thenReturn(1);
    when(appGroupMemberDao.unregister(anyLong(), Mockito.<String>any())).thenReturn(true);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);

    // Act
    boolean actualRemoveOwnerResult = (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        new ChangeInitiativeService(changeInitiativeDao, searchDao, relationshipDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        changeLogService)).removeOwner("42", 1L, "42");

    // Assert
    verify(appGroupDao).getGroup(eq(1L));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(appGroupMemberDao).register(eq(1L), eq("42"));
    verify(appGroupMemberDao).unregister(eq(1L), eq("42"));
    verify(appGroup).name();
    verify(appGroup).isFavouriteGroup();
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    assertTrue(actualRemoveOwnerResult);
  }

  /**
   * Method under test: {@link AppGroupService#getMembers(long)}
   */
  @Test
  void testGetMembers() {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    HashSet<AppGroupMember> appGroupMemberSet = new HashSet<>();
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(appGroupMemberSet);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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

    // Act
    Set<AppGroupMember> actualMembers = (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        changeInitiativeService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .getMembers(1L);

    // Assert
    verify(appGroupMemberDao).getMembers(eq(1L));
    assertTrue(actualMembers.isEmpty());
    assertSame(appGroupMemberSet, actualMembers);
  }

  /**
   * Method under test: {@link AppGroupService#getMembers(long)}
   */
  @Test
  void testGetMembers2() {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.getMembers(anyLong())).thenThrow(new IllegalArgumentException("foo"));
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao, applicationDao,
            appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao, changeInitiativeService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .getMembers(1L));
    verify(appGroupMemberDao).getMembers(eq(1L));
  }

  /**
   * Method under test: {@link AppGroupService#updateOverview(String, AppGroup)}
   */
  @Test
  void testUpdateOverview() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.update(Mockito.<AppGroup>any())).thenReturn(1);
    when(appGroupDao.getGroup(anyLong())).thenReturn(mock(AppGroup.class));
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(new HashSet<>());
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    AppGroupService appGroupService = new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        mock(ApplicationDao.class), appGroupOrganisationalUnitDao, mock(OrganisationalUnitDao.class),
        mock(EntityRelationshipDao.class), changeInitiativeService,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    AppGroup appGroup = mock(AppGroup.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(appGroup.id()).thenReturn(ofResult);

    // Act
    AppGroupDetail actualUpdateOverviewResult = appGroupService.updateOverview("42", appGroup);

    // Assert
    verify(appGroupDao).getGroup(eq(1L));
    verify(appGroupDao).update(isA(AppGroup.class));
    verify(appGroupEntryDao).findEntriesForGroup(eq(1L));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(appGroupMemberDao).getMembers(eq(1L));
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(eq(1L));
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
   * Method under test: {@link AppGroupService#updateOverview(String, AppGroup)}
   */
  @Test
  void testUpdateOverview2() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.update(Mockito.<AppGroup>any())).thenReturn(1);
    when(appGroupDao.getGroup(anyLong())).thenReturn(mock(AppGroup.class));

    HashSet<AppGroupMember> appGroupMemberSet = new HashSet<>();
    appGroupMemberSet.add(mock(AppGroupMember.class));
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(appGroupMemberSet);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    AppGroupService appGroupService = new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        mock(ApplicationDao.class), appGroupOrganisationalUnitDao, mock(OrganisationalUnitDao.class),
        mock(EntityRelationshipDao.class), changeInitiativeService,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    AppGroup appGroup = mock(AppGroup.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(appGroup.id()).thenReturn(ofResult);

    // Act
    AppGroupDetail actualUpdateOverviewResult = appGroupService.updateOverview("42", appGroup);

    // Assert
    verify(appGroupDao).getGroup(eq(1L));
    verify(appGroupDao).update(isA(AppGroup.class));
    verify(appGroupEntryDao).findEntriesForGroup(eq(1L));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(appGroupMemberDao).getMembers(eq(1L));
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(eq(1L));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    verify(appGroup, atLeast(1)).id();
    assertTrue(actualUpdateOverviewResult instanceof ImmutableAppGroupDetail);
    assertEquals(1, actualUpdateOverviewResult.members().size());
    List<AppGroupEntry> applicationsResult = actualUpdateOverviewResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualUpdateOverviewResult.changeInitiatives());
    assertSame(applicationsResult, actualUpdateOverviewResult.organisationalUnits());
  }

  /**
   * Method under test: {@link AppGroupService#updateOverview(String, AppGroup)}
   */
  @Test
  void testUpdateOverview3() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.update(Mockito.<AppGroup>any())).thenReturn(1);
    when(appGroupDao.getGroup(anyLong())).thenReturn(mock(AppGroup.class));

    HashSet<AppGroupMember> appGroupMemberSet = new HashSet<>();
    appGroupMemberSet.add(mock(AppGroupMember.class));
    appGroupMemberSet.add(mock(AppGroupMember.class));
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(appGroupMemberSet);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    AppGroupService appGroupService = new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        mock(ApplicationDao.class), appGroupOrganisationalUnitDao, mock(OrganisationalUnitDao.class),
        mock(EntityRelationshipDao.class), changeInitiativeService,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    AppGroup appGroup = mock(AppGroup.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(appGroup.id()).thenReturn(ofResult);

    // Act
    AppGroupDetail actualUpdateOverviewResult = appGroupService.updateOverview("42", appGroup);

    // Assert
    verify(appGroupDao).getGroup(eq(1L));
    verify(appGroupDao).update(isA(AppGroup.class));
    verify(appGroupEntryDao).findEntriesForGroup(eq(1L));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(appGroupMemberDao).getMembers(eq(1L));
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(eq(1L));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    verify(appGroup, atLeast(1)).id();
    assertTrue(actualUpdateOverviewResult instanceof ImmutableAppGroupDetail);
    assertEquals(2, actualUpdateOverviewResult.members().size());
    List<AppGroupEntry> applicationsResult = actualUpdateOverviewResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualUpdateOverviewResult.changeInitiatives());
    assertSame(applicationsResult, actualUpdateOverviewResult.organisationalUnits());
  }

  /**
   * Method under test: {@link AppGroupService#updateOverview(String, AppGroup)}
   */
  @Test
  void testUpdateOverview4() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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

    // Act and Assert
    assertThrows(InsufficientPrivelegeException.class, () -> appGroupService.updateOverview("42", appGroup));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(appGroup).id();
  }

  /**
   * Method under test: {@link AppGroupService#updateOverview(String, AppGroup)}
   */
  @Test
  void testUpdateOverview5() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.update(Mockito.<AppGroup>any())).thenReturn(1);
    when(appGroupDao.getGroup(anyLong())).thenReturn(mock(AppGroup.class));
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(new HashSet<>());
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);

    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    appGroupEntryList.add(mock(AppGroupEntry.class));
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(appGroupEntryList);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    AppGroupService appGroupService = new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        mock(ApplicationDao.class), appGroupOrganisationalUnitDao, mock(OrganisationalUnitDao.class),
        mock(EntityRelationshipDao.class), changeInitiativeService,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    AppGroup appGroup = mock(AppGroup.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(appGroup.id()).thenReturn(ofResult);

    // Act
    AppGroupDetail actualUpdateOverviewResult = appGroupService.updateOverview("42", appGroup);

    // Assert
    verify(appGroupDao).getGroup(eq(1L));
    verify(appGroupDao).update(isA(AppGroup.class));
    verify(appGroupEntryDao).findEntriesForGroup(eq(1L));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(appGroupMemberDao).getMembers(eq(1L));
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(eq(1L));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    verify(appGroup, atLeast(1)).id();
    assertTrue(actualUpdateOverviewResult instanceof ImmutableAppGroupDetail);
    assertEquals(1, actualUpdateOverviewResult.applications().size());
    List<AppGroupEntry> changeInitiativesResult = actualUpdateOverviewResult.changeInitiatives();
    assertTrue(changeInitiativesResult.isEmpty());
    assertSame(changeInitiativesResult, actualUpdateOverviewResult.members());
    assertSame(changeInitiativesResult, actualUpdateOverviewResult.organisationalUnits());
  }

  /**
   * Method under test: {@link AppGroupService#updateOverview(String, AppGroup)}
   */
  @Test
  void testUpdateOverview6() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.update(Mockito.<AppGroup>any())).thenReturn(1);
    when(appGroupDao.getGroup(anyLong())).thenReturn(mock(AppGroup.class));
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(new HashSet<>());
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    appGroupEntryList.add(mock(AppGroupEntry.class));
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(appGroupEntryList);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    AppGroupService appGroupService = new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        mock(ApplicationDao.class), appGroupOrganisationalUnitDao, mock(OrganisationalUnitDao.class),
        mock(EntityRelationshipDao.class), changeInitiativeService,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    AppGroup appGroup = mock(AppGroup.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(appGroup.id()).thenReturn(ofResult);

    // Act
    AppGroupDetail actualUpdateOverviewResult = appGroupService.updateOverview("42", appGroup);

    // Assert
    verify(appGroupDao).getGroup(eq(1L));
    verify(appGroupDao).update(isA(AppGroup.class));
    verify(appGroupEntryDao).findEntriesForGroup(eq(1L));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(appGroupMemberDao).getMembers(eq(1L));
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(eq(1L));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    verify(appGroup, atLeast(1)).id();
    assertTrue(actualUpdateOverviewResult instanceof ImmutableAppGroupDetail);
    assertEquals(1, actualUpdateOverviewResult.organisationalUnits().size());
    List<AppGroupEntry> applicationsResult = actualUpdateOverviewResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualUpdateOverviewResult.changeInitiatives());
    assertSame(applicationsResult, actualUpdateOverviewResult.members());
  }

  /**
   * Method under test: {@link AppGroupService#updateOverview(String, AppGroup)}
   */
  @Test
  void testUpdateOverview7() throws InsufficientPrivelegeException {
    // Arrange
    new IllegalArgumentException("Updated group overview");
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.update(Mockito.<AppGroup>any())).thenReturn(1);
    when(appGroupDao.getGroup(anyLong())).thenReturn(mock(AppGroup.class));
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(new HashSet<>());
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());
    ChangeInitiativeService changeInitiativeService = mock(ChangeInitiativeService.class);
    when(changeInitiativeService.findEntriesForAppGroup(anyLong())).thenReturn(new ArrayList<>());
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    AppGroupService appGroupService = new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        mock(ApplicationDao.class), appGroupOrganisationalUnitDao, mock(OrganisationalUnitDao.class),
        mock(EntityRelationshipDao.class), changeInitiativeService,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    AppGroup appGroup = mock(AppGroup.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(appGroup.id()).thenReturn(ofResult);

    // Act
    AppGroupDetail actualUpdateOverviewResult = appGroupService.updateOverview("42", appGroup);

    // Assert
    verify(appGroupDao).getGroup(eq(1L));
    verify(appGroupDao).update(isA(AppGroup.class));
    verify(appGroupEntryDao).findEntriesForGroup(eq(1L));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(appGroupMemberDao).getMembers(eq(1L));
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(eq(1L));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(appGroup, atLeast(1)).id();
    verify(changeInitiativeService).findEntriesForAppGroup(eq(1L));
    assertTrue(actualUpdateOverviewResult instanceof ImmutableAppGroupDetail);
    List<AppGroupEntry> applicationsResult = actualUpdateOverviewResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualUpdateOverviewResult.changeInitiatives());
    assertSame(applicationsResult, actualUpdateOverviewResult.members());
    assertSame(applicationsResult, actualUpdateOverviewResult.organisationalUnits());
  }

  /**
   * Method under test: {@link AppGroupService#updateOverview(String, AppGroup)}
   */
  @Test
  void testUpdateOverview8() throws InsufficientPrivelegeException {
    // Arrange
    new IllegalArgumentException("Updated group overview");
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.update(Mockito.<AppGroup>any())).thenReturn(1);
    when(appGroupDao.getGroup(anyLong())).thenReturn(mock(AppGroup.class));
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(new HashSet<>());
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());

    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    appGroupEntryList.add(mock(AppGroupEntry.class));
    ChangeInitiativeService changeInitiativeService = mock(ChangeInitiativeService.class);
    when(changeInitiativeService.findEntriesForAppGroup(anyLong())).thenReturn(appGroupEntryList);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    AppGroupService appGroupService = new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        mock(ApplicationDao.class), appGroupOrganisationalUnitDao, mock(OrganisationalUnitDao.class),
        mock(EntityRelationshipDao.class), changeInitiativeService,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    AppGroup appGroup = mock(AppGroup.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(appGroup.id()).thenReturn(ofResult);

    // Act
    AppGroupDetail actualUpdateOverviewResult = appGroupService.updateOverview("42", appGroup);

    // Assert
    verify(appGroupDao).getGroup(eq(1L));
    verify(appGroupDao).update(isA(AppGroup.class));
    verify(appGroupEntryDao).findEntriesForGroup(eq(1L));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(appGroupMemberDao).getMembers(eq(1L));
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(eq(1L));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(appGroup, atLeast(1)).id();
    verify(changeInitiativeService).findEntriesForAppGroup(eq(1L));
    assertTrue(actualUpdateOverviewResult instanceof ImmutableAppGroupDetail);
    assertEquals(1, actualUpdateOverviewResult.changeInitiatives().size());
    List<AppGroupEntry> applicationsResult = actualUpdateOverviewResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualUpdateOverviewResult.members());
    assertSame(applicationsResult, actualUpdateOverviewResult.organisationalUnits());
  }

  /**
   * Method under test: {@link AppGroupService#updateOverview(String, AppGroup)}
   */
  @Test
  void testUpdateOverview9() throws InsufficientPrivelegeException {
    // Arrange
    new IllegalArgumentException("Updated group overview");
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.update(Mockito.<AppGroup>any())).thenReturn(1);
    when(appGroupDao.getGroup(anyLong())).thenReturn(mock(AppGroup.class));
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.getMembers(anyLong())).thenReturn(new HashSet<>());
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.findEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    when(appGroupOrganisationalUnitDao.getEntriesForGroup(anyLong())).thenReturn(new ArrayList<>());
    ChangeInitiativeService changeInitiativeService = mock(ChangeInitiativeService.class);
    when(changeInitiativeService.findEntriesForAppGroup(anyLong())).thenReturn(new ArrayList<>());
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    AppGroupService appGroupService = new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        mock(ApplicationDao.class), appGroupOrganisationalUnitDao, mock(OrganisationalUnitDao.class),
        mock(EntityRelationshipDao.class), changeInitiativeService, changeLogService);
    AppGroup appGroup = mock(AppGroup.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(appGroup.id()).thenReturn(ofResult);

    // Act
    AppGroupDetail actualUpdateOverviewResult = appGroupService.updateOverview("42", appGroup);

    // Assert
    verify(appGroupDao).getGroup(eq(1L));
    verify(appGroupDao).update(isA(AppGroup.class));
    verify(appGroupEntryDao).findEntriesForGroup(eq(1L));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(appGroupMemberDao).getMembers(eq(1L));
    verify(appGroupOrganisationalUnitDao).getEntriesForGroup(eq(1L));
    verify(appGroup, atLeast(1)).id();
    verify(changeInitiativeService).findEntriesForAppGroup(eq(1L));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateOverviewResult instanceof ImmutableAppGroupDetail);
    List<AppGroupEntry> applicationsResult = actualUpdateOverviewResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualUpdateOverviewResult.changeInitiatives());
    assertSame(applicationsResult, actualUpdateOverviewResult.members());
    assertSame(applicationsResult, actualUpdateOverviewResult.organisationalUnits());
  }

  /**
   * Method under test: {@link AppGroupService#createNewGroup(String)}
   */
  @Test
  void testCreateNewGroup() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.insert(Mockito.<AppGroup>any())).thenReturn(1L);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.register(anyLong(), Mockito.<String>any(), Mockito.<AppGroupMemberRole>any())).thenReturn(1);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);

    // Act
    Long actualCreateNewGroupResult = (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        new ChangeInitiativeService(changeInitiativeDao, searchDao, relationshipDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        changeLogService)).createNewGroup("42");

    // Assert
    verify(appGroupDao).insert(isA(AppGroup.class));
    verify(appGroupMemberDao).register(eq(1L), eq("42"), eq(AppGroupMemberRole.OWNER));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    assertEquals(1L, actualCreateNewGroupResult.longValue());
  }

  /**
   * Method under test: {@link AppGroupService#createNewGroup(String)}
   */
  @Test
  void testCreateNewGroup2() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.insert(Mockito.<AppGroup>any())).thenReturn(1L);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.register(anyLong(), Mockito.<String>any(), Mockito.<AppGroupMemberRole>any())).thenReturn(1);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    AppGroupOrganisationalUnitDao appGroupOrganisationalUnitDao = mock(AppGroupOrganisationalUnitDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);

    // Act
    Long actualCreateNewGroupResult = (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        new ChangeInitiativeService(changeInitiativeDao, searchDao, relationshipDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        changeLogService)).createNewGroup("42");

    // Assert
    verify(appGroupDao).insert(isA(AppGroup.class));
    verify(appGroupMemberDao).register(eq(1L), eq("42"), eq(AppGroupMemberRole.OWNER));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1L, actualCreateNewGroupResult.longValue());
  }

  /**
   * Method under test: {@link AppGroupService#findByIds(String, List)}
   */
  @Test
  void testFindByIds() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    HashSet<AppGroup> appGroupSet = new HashSet<>();
    when(appGroupDao.findByIds(Mockito.<String>any(), Mockito.<List<Long>>any())).thenReturn(appGroupSet);
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

    AppGroupService appGroupService = new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        changeInitiativeService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    // Act
    Collection<AppGroup> actualFindByIdsResult = appGroupService.findByIds("User", new ArrayList<>());

    // Assert
    verify(appGroupDao).findByIds(eq("User"), isA(List.class));
    assertTrue(actualFindByIdsResult instanceof Set);
    assertTrue(actualFindByIdsResult.isEmpty());
    assertSame(appGroupSet, actualFindByIdsResult);
  }

  /**
   * Method under test: {@link AppGroupService#findByIds(String, List)}
   */
  @Test
  void testFindByIds2() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    HashSet<AppGroup> appGroupSet = new HashSet<>();
    when(appGroupDao.findByIds(Mockito.<String>any(), Mockito.<List<Long>>any())).thenReturn(appGroupSet);
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

    AppGroupService appGroupService = new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        changeInitiativeService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

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
   * Method under test: {@link AppGroupService#findByIds(String, List)}
   */
  @Test
  void testFindByIds3() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    HashSet<AppGroup> appGroupSet = new HashSet<>();
    when(appGroupDao.findByIds(Mockito.<String>any(), Mockito.<List<Long>>any())).thenReturn(appGroupSet);
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

    AppGroupService appGroupService = new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        changeInitiativeService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(2L);
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
   * Method under test: {@link AppGroupService#findByIds(String, List)}
   */
  @Test
  void testFindByIds4() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.findByIds(Mockito.<String>any(), Mockito.<List<Long>>any()))
        .thenThrow(new IllegalArgumentException("user cannot be empty"));
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

    AppGroupService appGroupService = new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        changeInitiativeService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> appGroupService.findByIds("User", new ArrayList<>()));
    verify(appGroupDao).findByIds(eq("User"), isA(List.class));
  }

  /**
   * Method under test:
   * {@link AppGroupService#addChangeInitiative(String, long, long)}
   */
  @Test
  void testAddChangeInitiative() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.save(Mockito.<EntityRelationship>any())).thenReturn(1);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    List<AppGroupEntry> actualAddChangeInitiativeResult = (new AppGroupService(mock(AppGroupDao.class),
        appGroupMemberDao, mock(AppGroupEntryDao.class), mock(ApplicationDao.class),
        mock(AppGroupOrganisationalUnitDao.class), mock(OrganisationalUnitDao.class), entityRelationshipDao,
        changeInitiativeService,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .addChangeInitiative("janedoe", 1L, 1L);

    // Assert
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("janedoe"));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    verify(entityRelationshipDao).save(isA(EntityRelationship.class));
    assertTrue(actualAddChangeInitiativeResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link AppGroupService#addChangeInitiative(String, long, long)}
   */
  @Test
  void testAddChangeInitiative2() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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

    // Act and Assert
    assertThrows(InsufficientPrivelegeException.class,
        () -> (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao, applicationDao,
            appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao, changeInitiativeService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .addChangeInitiative("janedoe", 1L, 1L));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("janedoe"));
  }

  /**
   * Method under test:
   * {@link AppGroupService#addChangeInitiative(String, long, long)}
   */
  @Test
  void testAddChangeInitiative3() throws InsufficientPrivelegeException {
    // Arrange
    new IllegalArgumentException("kind");
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.save(Mockito.<EntityRelationship>any())).thenReturn(1);
    ChangeInitiativeService changeInitiativeService = mock(ChangeInitiativeService.class);
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(changeInitiativeService.findEntriesForAppGroup(anyLong())).thenReturn(appGroupEntryList);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    List<AppGroupEntry> actualAddChangeInitiativeResult = (new AppGroupService(mock(AppGroupDao.class),
        appGroupMemberDao, mock(AppGroupEntryDao.class), mock(ApplicationDao.class),
        mock(AppGroupOrganisationalUnitDao.class), mock(OrganisationalUnitDao.class), entityRelationshipDao,
        changeInitiativeService,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .addChangeInitiative("janedoe", 1L, 1L);

    // Assert
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("janedoe"));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(entityRelationshipDao).save(isA(EntityRelationship.class));
    verify(changeInitiativeService).findEntriesForAppGroup(eq(1L));
    assertTrue(actualAddChangeInitiativeResult.isEmpty());
    assertSame(appGroupEntryList, actualAddChangeInitiativeResult);
  }

  /**
   * Method under test:
   * {@link AppGroupService#addChangeInitiative(String, long, long)}
   */
  @Test
  void testAddChangeInitiative4() throws InsufficientPrivelegeException {
    // Arrange
    new IllegalArgumentException("kind");
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.save(Mockito.<EntityRelationship>any())).thenReturn(1);
    ChangeInitiativeService changeInitiativeService = mock(ChangeInitiativeService.class);
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(changeInitiativeService.findEntriesForAppGroup(anyLong())).thenReturn(appGroupEntryList);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    List<AppGroupEntry> actualAddChangeInitiativeResult = (new AppGroupService(mock(AppGroupDao.class),
        appGroupMemberDao, mock(AppGroupEntryDao.class), mock(ApplicationDao.class),
        mock(AppGroupOrganisationalUnitDao.class), mock(OrganisationalUnitDao.class), entityRelationshipDao,
        changeInitiativeService, changeLogService)).addChangeInitiative("janedoe", 1L, 1L);

    // Assert
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("janedoe"));
    verify(entityRelationshipDao).save(isA(EntityRelationship.class));
    verify(changeInitiativeService).findEntriesForAppGroup(eq(1L));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualAddChangeInitiativeResult.isEmpty());
    assertSame(appGroupEntryList, actualAddChangeInitiativeResult);
  }

  /**
   * Method under test:
   * {@link AppGroupService#removeChangeInitiative(String, long, long)}
   */
  @Test
  void testRemoveChangeInitiative() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.remove(Mockito.<EntityRelationshipKey>any())).thenReturn(true);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    List<AppGroupEntry> actualRemoveChangeInitiativeResult = (new AppGroupService(mock(AppGroupDao.class),
        appGroupMemberDao, mock(AppGroupEntryDao.class), mock(ApplicationDao.class),
        mock(AppGroupOrganisationalUnitDao.class), mock(OrganisationalUnitDao.class), entityRelationshipDao,
        changeInitiativeService,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .removeChangeInitiative("janedoe", 1L, 1L);

    // Assert
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("janedoe"));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    verify(entityRelationshipDao).remove(isA(EntityRelationshipKey.class));
    assertTrue(actualRemoveChangeInitiativeResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link AppGroupService#removeChangeInitiative(String, long, long)}
   */
  @Test
  void testRemoveChangeInitiative2() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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

    // Act and Assert
    assertThrows(InsufficientPrivelegeException.class,
        () -> (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao, applicationDao,
            appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao, changeInitiativeService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .removeChangeInitiative("janedoe", 1L, 1L));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("janedoe"));
  }

  /**
   * Method under test:
   * {@link AppGroupService#removeChangeInitiative(String, long, long)}
   */
  @Test
  void testRemoveChangeInitiative3() throws InsufficientPrivelegeException {
    // Arrange
    new IllegalArgumentException("kind");
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.remove(Mockito.<EntityRelationshipKey>any())).thenReturn(true);
    ChangeInitiativeService changeInitiativeService = mock(ChangeInitiativeService.class);
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(changeInitiativeService.findEntriesForAppGroup(anyLong())).thenReturn(appGroupEntryList);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    List<AppGroupEntry> actualRemoveChangeInitiativeResult = (new AppGroupService(mock(AppGroupDao.class),
        appGroupMemberDao, mock(AppGroupEntryDao.class), mock(ApplicationDao.class),
        mock(AppGroupOrganisationalUnitDao.class), mock(OrganisationalUnitDao.class), entityRelationshipDao,
        changeInitiativeService,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .removeChangeInitiative("janedoe", 1L, 1L);

    // Assert
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("janedoe"));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(entityRelationshipDao).remove(isA(EntityRelationshipKey.class));
    verify(changeInitiativeService).findEntriesForAppGroup(eq(1L));
    assertTrue(actualRemoveChangeInitiativeResult.isEmpty());
    assertSame(appGroupEntryList, actualRemoveChangeInitiativeResult);
  }

  /**
   * Method under test:
   * {@link AppGroupService#removeChangeInitiative(String, long, long)}
   */
  @Test
  void testRemoveChangeInitiative4() throws InsufficientPrivelegeException {
    // Arrange
    new IllegalArgumentException("kind");
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.remove(Mockito.<EntityRelationshipKey>any())).thenReturn(true);
    ChangeInitiativeService changeInitiativeService = mock(ChangeInitiativeService.class);
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(changeInitiativeService.findEntriesForAppGroup(anyLong())).thenReturn(appGroupEntryList);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    List<AppGroupEntry> actualRemoveChangeInitiativeResult = (new AppGroupService(mock(AppGroupDao.class),
        appGroupMemberDao, mock(AppGroupEntryDao.class), mock(ApplicationDao.class),
        mock(AppGroupOrganisationalUnitDao.class), mock(OrganisationalUnitDao.class), entityRelationshipDao,
        changeInitiativeService, changeLogService)).removeChangeInitiative("janedoe", 1L, 1L);

    // Assert
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("janedoe"));
    verify(entityRelationshipDao).remove(isA(EntityRelationshipKey.class));
    verify(changeInitiativeService).findEntriesForAppGroup(eq(1L));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualRemoveChangeInitiativeResult.isEmpty());
    assertSame(appGroupEntryList, actualRemoveChangeInitiativeResult);
  }

  /**
   * Method under test:
   * {@link AppGroupService#addChangeInitiatives(String, long, List)}
   */
  @Test
  void testAddChangeInitiatives() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.saveAll(Mockito.<String>any(), anyLong(), Mockito.<List<Long>>any()))
        .thenReturn(new int[]{1, -1, 1, -1});
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    AppGroupService appGroupService = new AppGroupService(mock(AppGroupDao.class), appGroupMemberDao,
        mock(AppGroupEntryDao.class), mock(ApplicationDao.class), mock(AppGroupOrganisationalUnitDao.class),
        mock(OrganisationalUnitDao.class), entityRelationshipDao, changeInitiativeService,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    // Act
    List<AppGroupEntry> actualAddChangeInitiativesResult = appGroupService.addChangeInitiatives("42", 1L,
        new ArrayList<>());

    // Assert
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(changeLogDao).write(isA(Collection.class));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    verify(entityRelationshipDao).saveAll(eq("42"), eq(1L), isA(List.class));
    assertTrue(actualAddChangeInitiativesResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link AppGroupService#addChangeInitiatives(String, long, List)}
   */
  @Test
  void testAddChangeInitiatives2() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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

    AppGroupService appGroupService = new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        changeInitiativeService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    // Act and Assert
    assertThrows(InsufficientPrivelegeException.class,
        () -> appGroupService.addChangeInitiatives("42", 1L, new ArrayList<>()));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
  }

  /**
   * Method under test:
   * {@link AppGroupService#addChangeInitiatives(String, long, List)}
   */
  @Test
  void testAddChangeInitiatives3() throws InsufficientPrivelegeException {
    // Arrange
    new IllegalArgumentException("kind");
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.saveAll(Mockito.<String>any(), anyLong(), Mockito.<List<Long>>any()))
        .thenReturn(new int[]{1, -1, 1, -1});
    ChangeInitiativeService changeInitiativeService = mock(ChangeInitiativeService.class);
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(changeInitiativeService.findEntriesForAppGroup(anyLong())).thenReturn(appGroupEntryList);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    AppGroupService appGroupService = new AppGroupService(mock(AppGroupDao.class), appGroupMemberDao,
        mock(AppGroupEntryDao.class), mock(ApplicationDao.class), mock(AppGroupOrganisationalUnitDao.class),
        mock(OrganisationalUnitDao.class), entityRelationshipDao, changeInitiativeService,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    // Act
    List<AppGroupEntry> actualAddChangeInitiativesResult = appGroupService.addChangeInitiatives("42", 1L,
        new ArrayList<>());

    // Assert
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(changeLogDao).write(isA(Collection.class));
    verify(entityRelationshipDao).saveAll(eq("42"), eq(1L), isA(List.class));
    verify(changeInitiativeService).findEntriesForAppGroup(eq(1L));
    assertTrue(actualAddChangeInitiativesResult.isEmpty());
    assertSame(appGroupEntryList, actualAddChangeInitiativesResult);
  }

  /**
   * Method under test:
   * {@link AppGroupService#addChangeInitiatives(String, long, List)}
   */
  @Test
  void testAddChangeInitiatives4() throws InsufficientPrivelegeException {
    // Arrange
    new IllegalArgumentException("kind");
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.saveAll(Mockito.<String>any(), anyLong(), Mockito.<List<Long>>any()))
        .thenReturn(new int[]{1, -1, 1, -1});
    ChangeInitiativeService changeInitiativeService = mock(ChangeInitiativeService.class);
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(changeInitiativeService.findEntriesForAppGroup(anyLong())).thenReturn(appGroupEntryList);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    AppGroupService appGroupService = new AppGroupService(mock(AppGroupDao.class), appGroupMemberDao,
        mock(AppGroupEntryDao.class), mock(ApplicationDao.class), mock(AppGroupOrganisationalUnitDao.class),
        mock(OrganisationalUnitDao.class), entityRelationshipDao, changeInitiativeService, changeLogService);

    // Act
    List<AppGroupEntry> actualAddChangeInitiativesResult = appGroupService.addChangeInitiatives("42", 1L,
        new ArrayList<>());

    // Assert
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(entityRelationshipDao).saveAll(eq("42"), eq(1L), isA(List.class));
    verify(changeInitiativeService).findEntriesForAppGroup(eq(1L));
    verify(changeLogService).write(isA(Collection.class));
    assertTrue(actualAddChangeInitiativesResult.isEmpty());
    assertSame(appGroupEntryList, actualAddChangeInitiativesResult);
  }

  /**
   * Method under test:
   * {@link AppGroupService#addChangeInitiatives(String, long, List)}
   */
  @Test
  void testAddChangeInitiatives5() throws InsufficientPrivelegeException {
    // Arrange
    new IllegalArgumentException("kind");
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.saveAll(Mockito.<String>any(), anyLong(), Mockito.<List<Long>>any()))
        .thenReturn(new int[]{1, -1, 1, -1});
    ChangeInitiativeService changeInitiativeService = mock(ChangeInitiativeService.class);
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(changeInitiativeService.findEntriesForAppGroup(anyLong())).thenReturn(appGroupEntryList);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    AppGroupService appGroupService = new AppGroupService(mock(AppGroupDao.class), appGroupMemberDao,
        mock(AppGroupEntryDao.class), mock(ApplicationDao.class), mock(AppGroupOrganisationalUnitDao.class),
        mock(OrganisationalUnitDao.class), entityRelationshipDao, changeInitiativeService, changeLogService);

    ArrayList<Long> changeInitiativeIds = new ArrayList<>();
    changeInitiativeIds.add(2L);

    // Act
    List<AppGroupEntry> actualAddChangeInitiativesResult = appGroupService.addChangeInitiatives("42", 1L,
        changeInitiativeIds);

    // Assert
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(entityRelationshipDao).saveAll(eq("42"), eq(1L), isA(List.class));
    verify(changeInitiativeService).findEntriesForAppGroup(eq(1L));
    verify(changeLogService).write(isA(Collection.class));
    assertTrue(actualAddChangeInitiativesResult.isEmpty());
    assertSame(appGroupEntryList, actualAddChangeInitiativesResult);
  }

  /**
   * Method under test:
   * {@link AppGroupService#addChangeInitiatives(String, long, List)}
   */
  @Test
  void testAddChangeInitiatives6() throws InsufficientPrivelegeException {
    // Arrange
    new IllegalArgumentException("kind");
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.saveAll(Mockito.<String>any(), anyLong(), Mockito.<List<Long>>any()))
        .thenReturn(new int[]{1, -1, 1, -1});
    ChangeInitiativeService changeInitiativeService = mock(ChangeInitiativeService.class);
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(changeInitiativeService.findEntriesForAppGroup(anyLong())).thenReturn(appGroupEntryList);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    AppGroupService appGroupService = new AppGroupService(mock(AppGroupDao.class), appGroupMemberDao,
        mock(AppGroupEntryDao.class), mock(ApplicationDao.class), mock(AppGroupOrganisationalUnitDao.class),
        mock(OrganisationalUnitDao.class), entityRelationshipDao, changeInitiativeService, changeLogService);

    ArrayList<Long> changeInitiativeIds = new ArrayList<>();
    changeInitiativeIds.add(1L);
    changeInitiativeIds.add(2L);

    // Act
    List<AppGroupEntry> actualAddChangeInitiativesResult = appGroupService.addChangeInitiatives("42", 1L,
        changeInitiativeIds);

    // Assert
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(entityRelationshipDao).saveAll(eq("42"), eq(1L), isA(List.class));
    verify(changeInitiativeService).findEntriesForAppGroup(eq(1L));
    verify(changeLogService).write(isA(Collection.class));
    assertTrue(actualAddChangeInitiativesResult.isEmpty());
    assertSame(appGroupEntryList, actualAddChangeInitiativesResult);
  }

  /**
   * Method under test:
   * {@link AppGroupService#removeChangeInitiatives(String, long, List)}
   */
  @Test
  void testRemoveChangeInitiatives() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.removeAll(anyLong(), Mockito.<List<Long>>any())).thenReturn(1);
    EntityRelationshipDao relationshipDao = mock(EntityRelationshipDao.class);
    when(relationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    ChangeInitiativeSearchDao searchDao = mock(ChangeInitiativeSearchDao.class);
    ChangeInitiativeService changeInitiativeService = new ChangeInitiativeService(changeInitiativeDao, searchDao,
        relationshipDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    AppGroupService appGroupService = new AppGroupService(mock(AppGroupDao.class), appGroupMemberDao,
        mock(AppGroupEntryDao.class), mock(ApplicationDao.class), mock(AppGroupOrganisationalUnitDao.class),
        mock(OrganisationalUnitDao.class), entityRelationshipDao, changeInitiativeService,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    // Act
    List<AppGroupEntry> actualRemoveChangeInitiativesResult = appGroupService.removeChangeInitiatives("42", 1L,
        new ArrayList<>());

    // Assert
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(changeLogDao).write(isA(Collection.class));
    verify(relationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    verify(entityRelationshipDao).removeAll(eq(1L), isA(List.class));
    assertTrue(actualRemoveChangeInitiativesResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link AppGroupService#removeChangeInitiatives(String, long, List)}
   */
  @Test
  void testRemoveChangeInitiatives2() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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

    AppGroupService appGroupService = new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        changeInitiativeService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    // Act and Assert
    assertThrows(InsufficientPrivelegeException.class,
        () -> appGroupService.removeChangeInitiatives("42", 1L, new ArrayList<>()));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
  }

  /**
   * Method under test:
   * {@link AppGroupService#removeChangeInitiatives(String, long, List)}
   */
  @Test
  void testRemoveChangeInitiatives3() throws InsufficientPrivelegeException {
    // Arrange
    new IllegalArgumentException("kind");
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.removeAll(anyLong(), Mockito.<List<Long>>any())).thenReturn(1);
    ChangeInitiativeService changeInitiativeService = mock(ChangeInitiativeService.class);
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(changeInitiativeService.findEntriesForAppGroup(anyLong())).thenReturn(appGroupEntryList);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    AppGroupService appGroupService = new AppGroupService(mock(AppGroupDao.class), appGroupMemberDao,
        mock(AppGroupEntryDao.class), mock(ApplicationDao.class), mock(AppGroupOrganisationalUnitDao.class),
        mock(OrganisationalUnitDao.class), entityRelationshipDao, changeInitiativeService,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    // Act
    List<AppGroupEntry> actualRemoveChangeInitiativesResult = appGroupService.removeChangeInitiatives("42", 1L,
        new ArrayList<>());

    // Assert
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(changeLogDao).write(isA(Collection.class));
    verify(entityRelationshipDao).removeAll(eq(1L), isA(List.class));
    verify(changeInitiativeService).findEntriesForAppGroup(eq(1L));
    assertTrue(actualRemoveChangeInitiativesResult.isEmpty());
    assertSame(appGroupEntryList, actualRemoveChangeInitiativesResult);
  }

  /**
   * Method under test:
   * {@link AppGroupService#removeChangeInitiatives(String, long, List)}
   */
  @Test
  void testRemoveChangeInitiatives4() throws InsufficientPrivelegeException {
    // Arrange
    new IllegalArgumentException("kind");
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.removeAll(anyLong(), Mockito.<List<Long>>any())).thenReturn(1);
    ChangeInitiativeService changeInitiativeService = mock(ChangeInitiativeService.class);
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(changeInitiativeService.findEntriesForAppGroup(anyLong())).thenReturn(appGroupEntryList);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    AppGroupService appGroupService = new AppGroupService(mock(AppGroupDao.class), appGroupMemberDao,
        mock(AppGroupEntryDao.class), mock(ApplicationDao.class), mock(AppGroupOrganisationalUnitDao.class),
        mock(OrganisationalUnitDao.class), entityRelationshipDao, changeInitiativeService, changeLogService);

    // Act
    List<AppGroupEntry> actualRemoveChangeInitiativesResult = appGroupService.removeChangeInitiatives("42", 1L,
        new ArrayList<>());

    // Assert
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(entityRelationshipDao).removeAll(eq(1L), isA(List.class));
    verify(changeInitiativeService).findEntriesForAppGroup(eq(1L));
    verify(changeLogService).write(isA(Collection.class));
    assertTrue(actualRemoveChangeInitiativesResult.isEmpty());
    assertSame(appGroupEntryList, actualRemoveChangeInitiativesResult);
  }

  /**
   * Method under test:
   * {@link AppGroupService#removeChangeInitiatives(String, long, List)}
   */
  @Test
  void testRemoveChangeInitiatives5() throws InsufficientPrivelegeException {
    // Arrange
    new IllegalArgumentException("kind");
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.removeAll(anyLong(), Mockito.<List<Long>>any())).thenReturn(1);
    ChangeInitiativeService changeInitiativeService = mock(ChangeInitiativeService.class);
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(changeInitiativeService.findEntriesForAppGroup(anyLong())).thenReturn(appGroupEntryList);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    AppGroupService appGroupService = new AppGroupService(mock(AppGroupDao.class), appGroupMemberDao,
        mock(AppGroupEntryDao.class), mock(ApplicationDao.class), mock(AppGroupOrganisationalUnitDao.class),
        mock(OrganisationalUnitDao.class), entityRelationshipDao, changeInitiativeService, changeLogService);

    ArrayList<Long> changeInitiativeIds = new ArrayList<>();
    changeInitiativeIds.add(2L);

    // Act
    List<AppGroupEntry> actualRemoveChangeInitiativesResult = appGroupService.removeChangeInitiatives("42", 1L,
        changeInitiativeIds);

    // Assert
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(entityRelationshipDao).removeAll(eq(1L), isA(List.class));
    verify(changeInitiativeService).findEntriesForAppGroup(eq(1L));
    verify(changeLogService).write(isA(Collection.class));
    assertTrue(actualRemoveChangeInitiativesResult.isEmpty());
    assertSame(appGroupEntryList, actualRemoveChangeInitiativesResult);
  }

  /**
   * Method under test:
   * {@link AppGroupService#removeChangeInitiatives(String, long, List)}
   */
  @Test
  void testRemoveChangeInitiatives6() throws InsufficientPrivelegeException {
    // Arrange
    new IllegalArgumentException("kind");
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.removeAll(anyLong(), Mockito.<List<Long>>any())).thenReturn(1);
    ChangeInitiativeService changeInitiativeService = mock(ChangeInitiativeService.class);
    ArrayList<AppGroupEntry> appGroupEntryList = new ArrayList<>();
    when(changeInitiativeService.findEntriesForAppGroup(anyLong())).thenReturn(appGroupEntryList);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    AppGroupService appGroupService = new AppGroupService(mock(AppGroupDao.class), appGroupMemberDao,
        mock(AppGroupEntryDao.class), mock(ApplicationDao.class), mock(AppGroupOrganisationalUnitDao.class),
        mock(OrganisationalUnitDao.class), entityRelationshipDao, changeInitiativeService, changeLogService);

    ArrayList<Long> changeInitiativeIds = new ArrayList<>();
    changeInitiativeIds.add(1L);
    changeInitiativeIds.add(2L);

    // Act
    List<AppGroupEntry> actualRemoveChangeInitiativesResult = appGroupService.removeChangeInitiatives("42", 1L,
        changeInitiativeIds);

    // Assert
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
    verify(entityRelationshipDao).removeAll(eq(1L), isA(List.class));
    verify(changeInitiativeService).findEntriesForAppGroup(eq(1L));
    verify(changeLogService).write(isA(Collection.class));
    assertTrue(actualRemoveChangeInitiativesResult.isEmpty());
    assertSame(appGroupEntryList, actualRemoveChangeInitiativesResult);
  }

  /**
   * Method under test: {@link AppGroupService#replaceGroupEntries(Set)}
   */
  @Test
  void testReplaceGroupEntries() {
    // Arrange
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    doNothing().when(appGroupEntryDao)
        .replaceGroupApplicationEntries(Mockito.<Set<Tuple2<Long, Set<AppGroupEntry>>>>any());
    doNothing().when(appGroupEntryDao)
        .replaceGroupChangeInitiativeEntries(Mockito.<Set<Tuple2<Long, Set<AppGroupEntry>>>>any());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
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

    AppGroupService appGroupService = new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        changeInitiativeService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    // Act
    appGroupService.replaceGroupEntries(new HashSet<>());

    // Assert
    verify(appGroupEntryDao).replaceGroupApplicationEntries(isA(Set.class));
    verify(appGroupEntryDao).replaceGroupChangeInitiativeEntries(isA(Set.class));
  }

  /**
   * Method under test: {@link AppGroupService#replaceGroupEntries(Set)}
   */
  @Test
  void testReplaceGroupEntries2() {
    // Arrange
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    doNothing().when(appGroupEntryDao)
        .replaceGroupApplicationEntries(Mockito.<Set<Tuple2<Long, Set<AppGroupEntry>>>>any());
    doNothing().when(appGroupEntryDao)
        .replaceGroupChangeInitiativeEntries(Mockito.<Set<Tuple2<Long, Set<AppGroupEntry>>>>any());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
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

    AppGroupService appGroupService = new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        changeInitiativeService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    HashSet<Tuple3<EntityKind, Long, Set<AppGroupEntry>>> entriesForGroups = new HashSet<>();
    entriesForGroups.add(new Tuple3<>(EntityKind.ALL, 1L, new HashSet<>()));

    // Act
    appGroupService.replaceGroupEntries(entriesForGroups);

    // Assert
    verify(appGroupEntryDao).replaceGroupApplicationEntries(isA(Set.class));
    verify(appGroupEntryDao).replaceGroupChangeInitiativeEntries(isA(Set.class));
  }

  /**
   * Method under test: {@link AppGroupService#replaceGroupEntries(Set)}
   */
  @Test
  void testReplaceGroupEntries3() {
    // Arrange
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    doNothing().when(appGroupEntryDao)
        .replaceGroupApplicationEntries(Mockito.<Set<Tuple2<Long, Set<AppGroupEntry>>>>any());
    doNothing().when(appGroupEntryDao)
        .replaceGroupChangeInitiativeEntries(Mockito.<Set<Tuple2<Long, Set<AppGroupEntry>>>>any());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
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

    AppGroupService appGroupService = new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        changeInitiativeService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    HashSet<Tuple3<EntityKind, Long, Set<AppGroupEntry>>> entriesForGroups = new HashSet<>();
    entriesForGroups.add(new Tuple3<>(EntityKind.ALL, 6L, new HashSet<>()));
    entriesForGroups.add(new Tuple3<>(EntityKind.ALL, 1L, new HashSet<>()));

    // Act
    appGroupService.replaceGroupEntries(entriesForGroups);

    // Assert
    verify(appGroupEntryDao).replaceGroupApplicationEntries(isA(Set.class));
    verify(appGroupEntryDao).replaceGroupChangeInitiativeEntries(isA(Set.class));
  }

  /**
   * Method under test: {@link AppGroupService#replaceGroupEntries(Set)}
   */
  @Test
  void testReplaceGroupEntries4() {
    // Arrange
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    doThrow(new IllegalArgumentException("foo")).when(appGroupEntryDao)
        .replaceGroupApplicationEntries(Mockito.<Set<Tuple2<Long, Set<AppGroupEntry>>>>any());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
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

    AppGroupService appGroupService = new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        changeInitiativeService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> appGroupService.replaceGroupEntries(new HashSet<>()));
    verify(appGroupEntryDao).replaceGroupApplicationEntries(isA(Set.class));
  }

  /**
   * Method under test: {@link AppGroupService#replaceGroupEntries(Set)}
   */
  @Test
  void testReplaceGroupEntries5() {
    // Arrange
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    doNothing().when(appGroupEntryDao)
        .replaceGroupApplicationEntries(Mockito.<Set<Tuple2<Long, Set<AppGroupEntry>>>>any());
    doNothing().when(appGroupEntryDao)
        .replaceGroupChangeInitiativeEntries(Mockito.<Set<Tuple2<Long, Set<AppGroupEntry>>>>any());
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
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

    AppGroupService appGroupService = new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao,
        applicationDao, appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao,
        changeInitiativeService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    HashSet<Tuple3<EntityKind, Long, Set<AppGroupEntry>>> entriesForGroups = new HashSet<>();
    entriesForGroups.add(new Tuple3<>(EntityKind.ALL, 6L, new HashSet<>()));
    entriesForGroups.add(new Tuple3<>(EntityKind.APPLICATION, 1L, new HashSet<>()));

    // Act
    appGroupService.replaceGroupEntries(entriesForGroups);

    // Assert
    verify(appGroupEntryDao).replaceGroupApplicationEntries(isA(Set.class));
    verify(appGroupEntryDao).replaceGroupChangeInitiativeEntries(isA(Set.class));
  }

  /**
   * Method under test: {@link AppGroupService#synchGroupEntries(Set, String)}
   */
  @Test
  void testSynchGroupEntries() {
    // Arrange
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

    // Act
    appGroupService.synchGroupEntries(new HashSet<>(), "42");

    // Assert
    verify(appGroupDao).processAdditionsAndRemovals(isA(Set.class), isA(Set.class), eq("42"));
    verify(appGroupEntryDao).fetchEntitiesForGroups(isA(Set.class));
    verify(changeLogDao).write(isA(Collection.class));
  }

  /**
   * Method under test: {@link AppGroupService#synchGroupEntries(Set, String)}
   */
  @Test
  void testSynchGroupEntries2() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.processAdditionsAndRemovals(Mockito.<Set<Tuple2<Long, EntityReference>>>any(),
        Mockito.<Set<Tuple2<Long, EntityReference>>>any(), Mockito.<String>any())).thenReturn(42);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.fetchEntitiesForGroups(Mockito.<Set<Long>>any())).thenReturn(new HashMap<>());
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
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

    // Act
    appGroupService.synchGroupEntries(new HashSet<>(), "42");

    // Assert
    verify(appGroupDao).processAdditionsAndRemovals(isA(Set.class), isA(Set.class), eq("42"));
    verify(appGroupEntryDao).fetchEntitiesForGroups(isA(Set.class));
    verify(changeLogService).write(isA(Collection.class));
  }

  /**
   * Method under test: {@link AppGroupService#synchGroupEntries(Set, String)}
   */
  @Test
  void testSynchGroupEntries3() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.processAdditionsAndRemovals(Mockito.<Set<Tuple2<Long, EntityReference>>>any(),
        Mockito.<Set<Tuple2<Long, EntityReference>>>any(), Mockito.<String>any())).thenReturn(42);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.fetchEntitiesForGroups(Mockito.<Set<Long>>any())).thenReturn(new HashMap<>());
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
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

    HashSet<Tuple3<EntityKind, Long, Set<EntityReference>>> entriesForGroups = new HashSet<>();
    entriesForGroups.add(new Tuple3<>(EntityKind.ALL, 1L, new HashSet<>()));

    // Act
    appGroupService.synchGroupEntries(entriesForGroups, "42");

    // Assert
    verify(appGroupDao).processAdditionsAndRemovals(isA(Set.class), isA(Set.class), eq("42"));
    verify(appGroupEntryDao).fetchEntitiesForGroups(isA(Set.class));
    verify(changeLogService).write(isA(Collection.class));
  }

  /**
   * Method under test: {@link AppGroupService#synchGroupEntries(Set, String)}
   */
  @Test
  void testSynchGroupEntries4() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.processAdditionsAndRemovals(Mockito.<Set<Tuple2<Long, EntityReference>>>any(),
        Mockito.<Set<Tuple2<Long, EntityReference>>>any(), Mockito.<String>any())).thenReturn(42);

    HashMap<Long, List<EntityReference>> resultLongListMap = new HashMap<>();
    resultLongListMap.put(1L, new ArrayList<>());
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.fetchEntitiesForGroups(Mockito.<Set<Long>>any())).thenReturn(resultLongListMap);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
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

    HashSet<Tuple3<EntityKind, Long, Set<EntityReference>>> entriesForGroups = new HashSet<>();
    entriesForGroups.add(new Tuple3<>(EntityKind.ALL, 1L, new HashSet<>()));

    // Act
    appGroupService.synchGroupEntries(entriesForGroups, "42");

    // Assert
    verify(appGroupDao).processAdditionsAndRemovals(isA(Set.class), isA(Set.class), eq("42"));
    verify(appGroupEntryDao).fetchEntitiesForGroups(isA(Set.class));
    verify(changeLogService).write(isA(Collection.class));
  }

  /**
   * Method under test: {@link AppGroupService#synchGroupEntries(Set, String)}
   */
  @Test
  void testSynchGroupEntries5() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.processAdditionsAndRemovals(Mockito.<Set<Tuple2<Long, EntityReference>>>any(),
        Mockito.<Set<Tuple2<Long, EntityReference>>>any(), Mockito.<String>any())).thenReturn(42);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.fetchEntitiesForGroups(Mockito.<Set<Long>>any())).thenReturn(new HashMap<>());
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
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
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(entityReference);
    Tuple3<EntityKind, Long, Set<EntityReference>> tuple3 = new Tuple3<>(EntityKind.ALL, 1L, entityReferenceSet);

    HashSet<Tuple3<EntityKind, Long, Set<EntityReference>>> entriesForGroups = new HashSet<>();
    entriesForGroups.add(tuple3);

    // Act
    appGroupService.synchGroupEntries(entriesForGroups, "42");

    // Assert
    verify(appGroupDao).processAdditionsAndRemovals(isA(Set.class), isA(Set.class), eq("42"));
    verify(appGroupEntryDao).fetchEntitiesForGroups(isA(Set.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(entityReference).name();
    verify(changeLogService).write(isA(Collection.class));
  }

  /**
   * Method under test: {@link AppGroupService#synchGroupEntries(Set, String)}
   */
  @Test
  void testSynchGroupEntries6() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.processAdditionsAndRemovals(Mockito.<Set<Tuple2<Long, EntityReference>>>any(),
        Mockito.<Set<Tuple2<Long, EntityReference>>>any(), Mockito.<String>any())).thenReturn(42);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.fetchEntitiesForGroups(Mockito.<Set<Long>>any())).thenReturn(new HashMap<>());
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
        mock(ChangeLogService.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.name()).thenThrow(new IllegalArgumentException("xs cannot be null"));
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(entityReference);
    Tuple3<EntityKind, Long, Set<EntityReference>> tuple3 = new Tuple3<>(EntityKind.ALL, 1L, entityReferenceSet);

    HashSet<Tuple3<EntityKind, Long, Set<EntityReference>>> entriesForGroups = new HashSet<>();
    entriesForGroups.add(tuple3);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> appGroupService.synchGroupEntries(entriesForGroups, "42"));
    verify(appGroupDao).processAdditionsAndRemovals(isA(Set.class), isA(Set.class), eq("42"));
    verify(appGroupEntryDao).fetchEntitiesForGroups(isA(Set.class));
    verify(entityReference).kind();
    verify(entityReference).name();
  }

  /**
   * Method under test: {@link AppGroupService#synchGroupEntries(Set, String)}
   */
  @Test
  void testSynchGroupEntries7() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.processAdditionsAndRemovals(Mockito.<Set<Tuple2<Long, EntityReference>>>any(),
        Mockito.<Set<Tuple2<Long, EntityReference>>>any(), Mockito.<String>any())).thenReturn(42);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.fetchEntitiesForGroups(Mockito.<Set<Long>>any())).thenReturn(new HashMap<>());
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
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
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(entityReference);
    Tuple3<EntityKind, Long, Set<EntityReference>> tuple3 = new Tuple3<>(EntityKind.ALL, 1L, entityReferenceSet);

    HashSet<Tuple3<EntityKind, Long, Set<EntityReference>>> entriesForGroups = new HashSet<>();
    entriesForGroups.add(new Tuple3<>(EntityKind.ALL, 1L, new HashSet<>()));
    entriesForGroups.add(tuple3);

    // Act
    appGroupService.synchGroupEntries(entriesForGroups, "42");

    // Assert
    verify(appGroupDao).processAdditionsAndRemovals(isA(Set.class), isA(Set.class), eq("42"));
    verify(appGroupEntryDao).fetchEntitiesForGroups(isA(Set.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(entityReference).name();
    verify(changeLogService).write(isA(Collection.class));
  }

  /**
   * Method under test: {@link AppGroupService#synchGroupEntries(Set, String)}
   */
  @Test
  void testSynchGroupEntries8() {
    // Arrange
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
    when(appGroupDao.processAdditionsAndRemovals(Mockito.<Set<Tuple2<Long, EntityReference>>>any(),
        Mockito.<Set<Tuple2<Long, EntityReference>>>any(), Mockito.<String>any())).thenReturn(42);
    AppGroupEntryDao appGroupEntryDao = mock(AppGroupEntryDao.class);
    when(appGroupEntryDao.fetchEntitiesForGroups(Mockito.<Set<Long>>any())).thenReturn(new HashMap<>());
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
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
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    EntityReference entityReference2 = mock(EntityReference.class);
    Optional<String> ofResult2 = Optional.of("foo");
    when(entityReference2.name()).thenReturn(ofResult2);
    when(entityReference2.id()).thenReturn(1L);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);

    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(entityReference2);
    entityReferenceSet.add(entityReference);
    Tuple3<EntityKind, Long, Set<EntityReference>> tuple3 = new Tuple3<>(EntityKind.ALL, 1L, entityReferenceSet);

    HashSet<Tuple3<EntityKind, Long, Set<EntityReference>>> entriesForGroups = new HashSet<>();
    entriesForGroups.add(tuple3);

    // Act
    appGroupService.synchGroupEntries(entriesForGroups, "42");

    // Assert
    verify(appGroupDao).processAdditionsAndRemovals(isA(Set.class), isA(Set.class), eq("42"));
    verify(appGroupEntryDao).fetchEntitiesForGroups(isA(Set.class));
    verify(entityReference2, atLeast(1)).id();
    verify(entityReference, atLeast(1)).id();
    verify(entityReference2, atLeast(1)).kind();
    verify(entityReference, atLeast(1)).kind();
    verify(entityReference2).name();
    verify(entityReference).name();
    verify(changeLogService).write(isA(Collection.class));
  }

  /**
   * Method under test:
   * {@link AppGroupService#verifyUserCanUpdateGroup(String, long)}
   */
  @Test
  void testVerifyUserCanUpdateGroup() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(true);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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

    // Act
    (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao, applicationDao,
        appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao, changeInitiativeService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .verifyUserCanUpdateGroup("42", 1L);

    // Assert
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
  }

  /**
   * Method under test:
   * {@link AppGroupService#verifyUserCanUpdateGroup(String, long)}
   */
  @Test
  void testVerifyUserCanUpdateGroup2() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any())).thenReturn(false);
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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

    // Act and Assert
    assertThrows(InsufficientPrivelegeException.class,
        () -> (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao, applicationDao,
            appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao, changeInitiativeService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .verifyUserCanUpdateGroup("42", 1L));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
  }

  /**
   * Method under test:
   * {@link AppGroupService#verifyUserCanUpdateGroup(String, long)}
   */
  @Test
  void testVerifyUserCanUpdateGroup3() throws InsufficientPrivelegeException {
    // Arrange
    AppGroupMemberDao appGroupMemberDao = mock(AppGroupMemberDao.class);
    when(appGroupMemberDao.canUpdate(anyLong(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException(" cannot update group: "));
    AppGroupDao appGroupDao = mock(AppGroupDao.class);
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

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AppGroupService(appGroupDao, appGroupMemberDao, appGroupEntryDao, applicationDao,
            appGroupOrganisationalUnitDao, organisationalUnitDao, entityRelationshipDao, changeInitiativeService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .verifyUserCanUpdateGroup("42", 1L));
    verify(appGroupMemberDao).canUpdate(eq(1L), eq("42"));
  }
}
