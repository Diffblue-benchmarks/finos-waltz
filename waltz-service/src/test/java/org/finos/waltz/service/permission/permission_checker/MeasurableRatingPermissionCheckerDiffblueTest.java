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
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.permission_group.Permission;
import org.finos.waltz.service.involvement.InvolvementService;
import org.finos.waltz.service.measurable.MeasurableService;
import org.finos.waltz.service.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionService;
import org.finos.waltz.service.permission.PermissionGroupService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MeasurableRatingPermissionCheckerDiffblueTest {
  /**
   * Method under test:
   * {@link MeasurableRatingPermissionChecker#findMeasurableRatingPermissions(EntityReference, long, String)}
   */
  @Test
  void testFindMeasurableRatingPermissions() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    HashSet<Operation> operationSet = new HashSet<>();
    when(measurableRatingDao.calculateAmendedRatingOperations(Mockito.<Set<Operation>>any(),
        Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any())).thenReturn(operationSet);
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.getById(anyLong())).thenReturn(null);
    PermissionGroupService permissionGroupService = mock(PermissionGroupService.class);
    when(
        permissionGroupService.findPermissionsForParentReference(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(new HashSet<>());
    InvolvementService involvementService = mock(InvolvementService.class);
    when(
        involvementService.findExistingInvolvementKindIdsForUser(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(new HashSet<>());

    // Act
    Set<Operation> actualFindMeasurableRatingPermissionsResult = (new MeasurableRatingPermissionChecker(
        measurableRatingDao, measurableService, mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(MeasurableRatingPlannedDecommissionService.class), mock(MeasurableRatingReplacementDao.class),
        permissionGroupService, involvementService)).findMeasurableRatingPermissions(null, 1L, "janedoe");

    // Assert
    verify(measurableRatingDao).calculateAmendedRatingOperations(isA(Set.class), isNull(), eq(1L), eq("janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(measurableService).getById(eq(1L));
    verify(permissionGroupService).findPermissionsForParentReference(isNull(), eq("janedoe"));
    assertTrue(actualFindMeasurableRatingPermissionsResult.isEmpty());
    assertSame(operationSet, actualFindMeasurableRatingPermissionsResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingPermissionChecker#findMeasurableRatingPermissions(EntityReference, long, String)}
   */
  @Test
  void testFindMeasurableRatingPermissions2() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    HashSet<Operation> operationSet = new HashSet<>();
    when(measurableRatingDao.calculateAmendedRatingOperations(Mockito.<Set<Operation>>any(),
        Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any())).thenReturn(operationSet);
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.getById(anyLong())).thenReturn(null);
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
    Set<Operation> actualFindMeasurableRatingPermissionsResult = (new MeasurableRatingPermissionChecker(
        measurableRatingDao, measurableService, mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(MeasurableRatingPlannedDecommissionService.class), mock(MeasurableRatingReplacementDao.class),
        permissionGroupService, involvementService)).findMeasurableRatingPermissions(null, 1L, "janedoe");

    // Assert
    verify(measurableRatingDao).calculateAmendedRatingOperations(isA(Set.class), isNull(), eq(1L), eq("janedoe"));
    verify(permission).subjectKind();
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(measurableService).getById(eq(1L));
    verify(permissionGroupService).findPermissionsForParentReference(isNull(), eq("janedoe"));
    assertTrue(actualFindMeasurableRatingPermissionsResult.isEmpty());
    assertSame(operationSet, actualFindMeasurableRatingPermissionsResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingPermissionChecker#findMeasurableRatingPermissions(EntityReference, long, String)}
   */
  @Test
  void testFindMeasurableRatingPermissions3() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    HashSet<Operation> operationSet = new HashSet<>();
    when(measurableRatingDao.calculateAmendedRatingOperations(Mockito.<Set<Operation>>any(),
        Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any())).thenReturn(operationSet);
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.getById(anyLong())).thenReturn(null);
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
    Set<Operation> actualFindMeasurableRatingPermissionsResult = (new MeasurableRatingPermissionChecker(
        measurableRatingDao, measurableService, mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(MeasurableRatingPlannedDecommissionService.class), mock(MeasurableRatingReplacementDao.class),
        permissionGroupService, involvementService)).findMeasurableRatingPermissions(null, 1L, "janedoe");

    // Assert
    verify(measurableRatingDao).calculateAmendedRatingOperations(isA(Set.class), isNull(), eq(1L), eq("janedoe"));
    verify(permission2).subjectKind();
    verify(permission).subjectKind();
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(measurableService).getById(eq(1L));
    verify(permissionGroupService).findPermissionsForParentReference(isNull(), eq("janedoe"));
    assertTrue(actualFindMeasurableRatingPermissionsResult.isEmpty());
    assertSame(operationSet, actualFindMeasurableRatingPermissionsResult);
  }
}
