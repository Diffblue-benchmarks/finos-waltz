package org.finos.waltz.service.permission.permission_checker;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.involvement.InvolvementDao;
import org.finos.waltz.data.involvement_kind.InvolvementKindDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.permission.PermissionGroupDao;
import org.finos.waltz.data.person.PersonDao;
import org.finos.waltz.data.person.search.PersonSearchDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.permission_group.Permission;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.involvement.InvolvementService;
import org.finos.waltz.service.involvement_kind.InvolvementKindService;
import org.finos.waltz.service.permission.PermissionGroupService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.user.UserRoleService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AllocationPermissionCheckerDiffblueTest {
  /**
   * Method under test:
   * {@link AllocationPermissionChecker#findAllocationPermissions(EntityReference, long, String)}
   */
  @Test
  void testFindAllocationPermissions() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    HashSet<Operation> operationSet = new HashSet<>();
    when(measurableRatingDao.calculateAmendedAllocationOperations(Mockito.<Set<Operation>>any(), anyLong(),
        Mockito.<String>any())).thenReturn(operationSet);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getByUserEmail(Mockito.<String>any())).thenReturn(null);
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService, permissionGroupDao,
        new InvolvementService(changeLogService, dao, logicalFlowDao, physicalFlowDao, entityReferenceNameResolver,
            new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
            mock(UserRoleService.class)));

    InvolvementService involvementService = mock(InvolvementService.class);
    when(
        involvementService.findExistingInvolvementKindIdsForUser(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(new HashSet<>());

    // Act
    Set<Operation> actualFindAllocationPermissionsResult = (new AllocationPermissionChecker(measurableRatingDao,
        permissionGroupService, involvementService)).findAllocationPermissions(null, 1L, "janedoe");

    // Assert
    verify(measurableRatingDao).calculateAmendedAllocationOperations(isA(Set.class), eq(1L), eq("janedoe"));
    verify(personDao).getByUserEmail(eq("janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    assertTrue(actualFindAllocationPermissionsResult.isEmpty());
    assertSame(operationSet, actualFindAllocationPermissionsResult);
  }

  /**
   * Method under test:
   * {@link AllocationPermissionChecker#findAllocationPermissions(EntityReference, long, String)}
   */
  @Test
  void testFindAllocationPermissions2() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    HashSet<Operation> operationSet = new HashSet<>();
    when(measurableRatingDao.calculateAmendedAllocationOperations(Mockito.<Set<Operation>>any(), anyLong(),
        Mockito.<String>any())).thenReturn(operationSet);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getByUserEmail(Mockito.<String>any())).thenReturn(mock(Person.class));
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    when(permissionGroupDao.findPermissionsForParentEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService, permissionGroupDao,
        new InvolvementService(changeLogService, dao, logicalFlowDao, physicalFlowDao, entityReferenceNameResolver,
            new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
            mock(UserRoleService.class)));

    InvolvementService involvementService = mock(InvolvementService.class);
    when(
        involvementService.findExistingInvolvementKindIdsForUser(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(new HashSet<>());

    // Act
    Set<Operation> actualFindAllocationPermissionsResult = (new AllocationPermissionChecker(measurableRatingDao,
        permissionGroupService, involvementService)).findAllocationPermissions(null, 1L, "janedoe");

    // Assert
    verify(measurableRatingDao).calculateAmendedAllocationOperations(isA(Set.class), eq(1L), eq("janedoe"));
    verify(permissionGroupDao).findPermissionsForParentEntityReference(isNull());
    verify(personDao).getByUserEmail(eq("janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    assertTrue(actualFindAllocationPermissionsResult.isEmpty());
    assertSame(operationSet, actualFindAllocationPermissionsResult);
  }

  /**
   * Method under test:
   * {@link AllocationPermissionChecker#findAllocationPermissions(EntityReference, long, String)}
   */
  @Test
  void testFindAllocationPermissions3() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    HashSet<Operation> operationSet = new HashSet<>();
    when(measurableRatingDao.calculateAmendedAllocationOperations(Mockito.<Set<Operation>>any(), anyLong(),
        Mockito.<String>any())).thenReturn(operationSet);
    PersonService personService = mock(PersonService.class);
    when(personService.getPersonByUserId(Mockito.<String>any())).thenReturn(null);
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService, permissionGroupDao,
        new InvolvementService(changeLogService, dao, logicalFlowDao, physicalFlowDao, entityReferenceNameResolver,
            new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
            mock(UserRoleService.class)));

    InvolvementService involvementService = mock(InvolvementService.class);
    when(
        involvementService.findExistingInvolvementKindIdsForUser(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(new HashSet<>());

    // Act
    Set<Operation> actualFindAllocationPermissionsResult = (new AllocationPermissionChecker(measurableRatingDao,
        permissionGroupService, involvementService)).findAllocationPermissions(null, 1L, "janedoe");

    // Assert
    verify(measurableRatingDao).calculateAmendedAllocationOperations(isA(Set.class), eq(1L), eq("janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(personService).getPersonByUserId(eq("janedoe"));
    assertTrue(actualFindAllocationPermissionsResult.isEmpty());
    assertSame(operationSet, actualFindAllocationPermissionsResult);
  }

  /**
   * Method under test:
   * {@link AllocationPermissionChecker#findAllocationPermissions(EntityReference, long, String)}
   */
  @Test
  void testFindAllocationPermissions4() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    HashSet<Operation> operationSet = new HashSet<>();
    when(measurableRatingDao.calculateAmendedAllocationOperations(Mockito.<Set<Operation>>any(), anyLong(),
        Mockito.<String>any())).thenReturn(operationSet);
    PermissionGroupService permissionGroupService = mock(PermissionGroupService.class);
    when(
        permissionGroupService.findPermissionsForParentReference(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(new HashSet<>());
    InvolvementService involvementService = mock(InvolvementService.class);
    when(
        involvementService.findExistingInvolvementKindIdsForUser(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(new HashSet<>());

    // Act
    Set<Operation> actualFindAllocationPermissionsResult = (new AllocationPermissionChecker(measurableRatingDao,
        permissionGroupService, involvementService)).findAllocationPermissions(null, 1L, "janedoe");

    // Assert
    verify(measurableRatingDao).calculateAmendedAllocationOperations(isA(Set.class), eq(1L), eq("janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(permissionGroupService).findPermissionsForParentReference(isNull(), eq("janedoe"));
    assertTrue(actualFindAllocationPermissionsResult.isEmpty());
    assertSame(operationSet, actualFindAllocationPermissionsResult);
  }

  /**
   * Method under test:
   * {@link AllocationPermissionChecker#findAllocationPermissions(EntityReference, long, String)}
   */
  @Test
  void testFindAllocationPermissions5() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    HashSet<Operation> operationSet = new HashSet<>();
    when(measurableRatingDao.calculateAmendedAllocationOperations(Mockito.<Set<Operation>>any(), anyLong(),
        Mockito.<String>any())).thenReturn(operationSet);
    Permission permission = mock(Permission.class);
    when(permission.subjectKind()).thenReturn(EntityKind.ALL);

    HashSet<Permission> permissionSet = new HashSet<>();
    permissionSet.add(permission);
    PermissionGroupService permissionGroupService = mock(PermissionGroupService.class);
    when(
        permissionGroupService.findPermissionsForParentReference(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(permissionSet);
    InvolvementService involvementService = mock(InvolvementService.class);
    when(
        involvementService.findExistingInvolvementKindIdsForUser(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(new HashSet<>());

    // Act
    Set<Operation> actualFindAllocationPermissionsResult = (new AllocationPermissionChecker(measurableRatingDao,
        permissionGroupService, involvementService)).findAllocationPermissions(null, 1L, "janedoe");

    // Assert
    verify(measurableRatingDao).calculateAmendedAllocationOperations(isA(Set.class), eq(1L), eq("janedoe"));
    verify(permission).subjectKind();
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(permissionGroupService).findPermissionsForParentReference(isNull(), eq("janedoe"));
    assertTrue(actualFindAllocationPermissionsResult.isEmpty());
    assertSame(operationSet, actualFindAllocationPermissionsResult);
  }

  /**
   * Method under test:
   * {@link AllocationPermissionChecker#findAllocationPermissions(EntityReference, long, String)}
   */
  @Test
  void testFindAllocationPermissions6() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    HashSet<Operation> operationSet = new HashSet<>();
    when(measurableRatingDao.calculateAmendedAllocationOperations(Mockito.<Set<Operation>>any(), anyLong(),
        Mockito.<String>any())).thenReturn(operationSet);
    Permission permission = mock(Permission.class);
    when(permission.subjectKind()).thenReturn(EntityKind.ALL);
    Permission permission2 = mock(Permission.class);
    when(permission2.subjectKind()).thenReturn(EntityKind.ALL);

    HashSet<Permission> permissionSet = new HashSet<>();
    permissionSet.add(permission2);
    permissionSet.add(permission);
    PermissionGroupService permissionGroupService = mock(PermissionGroupService.class);
    when(
        permissionGroupService.findPermissionsForParentReference(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(permissionSet);
    InvolvementService involvementService = mock(InvolvementService.class);
    when(
        involvementService.findExistingInvolvementKindIdsForUser(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(new HashSet<>());

    // Act
    Set<Operation> actualFindAllocationPermissionsResult = (new AllocationPermissionChecker(measurableRatingDao,
        permissionGroupService, involvementService)).findAllocationPermissions(null, 1L, "janedoe");

    // Assert
    verify(measurableRatingDao).calculateAmendedAllocationOperations(isA(Set.class), eq(1L), eq("janedoe"));
    verify(permission2).subjectKind();
    verify(permission).subjectKind();
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(permissionGroupService).findPermissionsForParentReference(isNull(), eq("janedoe"));
    assertTrue(actualFindAllocationPermissionsResult.isEmpty());
    assertSame(operationSet, actualFindAllocationPermissionsResult);
  }
}
