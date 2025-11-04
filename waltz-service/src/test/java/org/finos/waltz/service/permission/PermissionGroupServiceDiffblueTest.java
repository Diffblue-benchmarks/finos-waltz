package org.finos.waltz.service.permission;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
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
import org.finos.waltz.data.role.RoleDao;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.data.user.UserRoleDao;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.attestation.UserAttestationPermission;
import org.finos.waltz.model.permission_group.CheckPermissionCommand;
import org.finos.waltz.model.permission_group.Permission;
import org.finos.waltz.model.permission_group.RequiredInvolvementsResult;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.involvement.InvolvementService;
import org.finos.waltz.service.involvement_kind.InvolvementKindService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.user.UserRoleService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PermissionGroupServiceDiffblueTest {
  /**
   * Method under test:
   * {@link PermissionGroupService#findPermissionsForParentReference(EntityReference, String)}
   */
  @Test
  void testFindPermissionsForParentReference() {
    // Arrange
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
    InvolvementKindService involvementKindService = new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonDao personDao2 = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService2 = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    Set<Permission> actualFindPermissionsForParentReferenceResult = (new PermissionGroupService(personService,
        permissionGroupDao,
        new InvolvementService(changeLogService, dao, logicalFlowDao, physicalFlowDao, entityReferenceNameResolver,
            involvementKindService, personDao2,
            new UserRoleService(userRoleDao, roleDao, personDao3, changeLogService2, personService2,
                new SettingsService(settingsDao, new ArrayList<>()))))).findPermissionsForParentReference(null,
                    "janedoe");

    // Assert
    verify(personDao).getByUserEmail(eq("janedoe"));
    assertTrue(actualFindPermissionsForParentReferenceResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link PermissionGroupService#findPermissionsForParentReference(EntityReference, String)}
   */
  @Test
  void testFindPermissionsForParentReference2() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getByUserEmail(Mockito.<String>any())).thenReturn(mock(Person.class));
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    HashSet<Permission> permissionSet = new HashSet<>();
    when(permissionGroupDao.findPermissionsForParentEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(permissionSet);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService = new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonDao personDao2 = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService2 = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    Set<Permission> actualFindPermissionsForParentReferenceResult = (new PermissionGroupService(personService,
        permissionGroupDao,
        new InvolvementService(changeLogService, dao, logicalFlowDao, physicalFlowDao, entityReferenceNameResolver,
            involvementKindService, personDao2,
            new UserRoleService(userRoleDao, roleDao, personDao3, changeLogService2, personService2,
                new SettingsService(settingsDao, new ArrayList<>()))))).findPermissionsForParentReference(null,
                    "janedoe");

    // Assert
    verify(permissionGroupDao).findPermissionsForParentEntityReference(isNull());
    verify(personDao).getByUserEmail(eq("janedoe"));
    assertTrue(actualFindPermissionsForParentReferenceResult.isEmpty());
    assertSame(permissionSet, actualFindPermissionsForParentReferenceResult);
  }

  /**
   * Method under test:
   * {@link PermissionGroupService#findPermissionsForParentReference(EntityReference, String)}
   */
  @Test
  void testFindPermissionsForParentReference3() {
    // Arrange
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
    InvolvementKindService involvementKindService = new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService2 = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    Set<Permission> actualFindPermissionsForParentReferenceResult = (new PermissionGroupService(personService,
        permissionGroupDao,
        new InvolvementService(changeLogService, dao, logicalFlowDao, physicalFlowDao, entityReferenceNameResolver,
            involvementKindService, personDao,
            new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService2,
                new SettingsService(settingsDao, new ArrayList<>()))))).findPermissionsForParentReference(null,
                    "janedoe");

    // Assert
    verify(personService).getPersonByUserId(eq("janedoe"));
    assertTrue(actualFindPermissionsForParentReferenceResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link PermissionGroupService#hasPermission(CheckPermissionCommand)}
   */
  @Test
  void testHasPermission() {
    // Arrange
    RequiredInvolvementsResult requiredInvolvementsResult = mock(RequiredInvolvementsResult.class);
    when(requiredInvolvementsResult.areAllUsersAllowed()).thenReturn(true);
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    when(permissionGroupDao.getRequiredInvolvements(Mockito.<CheckPermissionCommand>any()))
        .thenReturn(requiredInvolvementsResult);
    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService = new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService2 = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    boolean actualHasPermissionResult = (new PermissionGroupService(personService, permissionGroupDao,
        new InvolvementService(changeLogService, dao, logicalFlowDao, physicalFlowDao, entityReferenceNameResolver,
            involvementKindService, personDao, new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2,
                personService2, new SettingsService(settingsDao, new ArrayList<>()))))).hasPermission(null);

    // Assert
    verify(permissionGroupDao).getRequiredInvolvements(isNull());
    verify(requiredInvolvementsResult).areAllUsersAllowed();
    assertTrue(actualHasPermissionResult);
  }

  /**
   * Method under test:
   * {@link PermissionGroupService#hasPermission(CheckPermissionCommand)}
   */
  @Test
  void testHasPermission2() {
    // Arrange
    RequiredInvolvementsResult requiredInvolvementsResult = mock(RequiredInvolvementsResult.class);
    when(requiredInvolvementsResult.areAllUsersAllowed()).thenReturn(false);
    when(requiredInvolvementsResult.requiredInvolvementKindIds()).thenReturn(new HashSet<>());
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    when(permissionGroupDao.getRequiredInvolvements(Mockito.<CheckPermissionCommand>any()))
        .thenReturn(requiredInvolvementsResult);
    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService = new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService2 = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    boolean actualHasPermissionResult = (new PermissionGroupService(personService, permissionGroupDao,
        new InvolvementService(changeLogService, dao, logicalFlowDao, physicalFlowDao, entityReferenceNameResolver,
            involvementKindService, personDao, new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2,
                personService2, new SettingsService(settingsDao, new ArrayList<>()))))).hasPermission(null);

    // Assert
    verify(permissionGroupDao).getRequiredInvolvements(isNull());
    verify(requiredInvolvementsResult).areAllUsersAllowed();
    verify(requiredInvolvementsResult).requiredInvolvementKindIds();
    assertFalse(actualHasPermissionResult);
  }

  /**
   * Method under test:
   * {@link PermissionGroupService#findSupportedMeasurableCategoryAttestations(EntityReference, String)}
   */
  @Test
  void testFindSupportedMeasurableCategoryAttestations() {
    // Arrange
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    HashSet<UserAttestationPermission> userAttestationPermissionSet = new HashSet<>();
    when(permissionGroupDao.findSupportedMeasurableCategoryAttestations(Mockito.<EntityReference>any(),
        Mockito.<String>any())).thenReturn(userAttestationPermissionSet);
    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService = new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService2 = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    Set<UserAttestationPermission> actualFindSupportedMeasurableCategoryAttestationsResult = (new PermissionGroupService(
        personService, permissionGroupDao,
        new InvolvementService(changeLogService, dao, logicalFlowDao, physicalFlowDao, entityReferenceNameResolver,
            involvementKindService, personDao,
            new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService2,
                new SettingsService(settingsDao, new ArrayList<>())))))
                    .findSupportedMeasurableCategoryAttestations(mock(EntityReference.class), "42");

    // Assert
    verify(permissionGroupDao).findSupportedMeasurableCategoryAttestations(isA(EntityReference.class), eq("42"));
    assertTrue(actualFindSupportedMeasurableCategoryAttestationsResult.isEmpty());
    assertSame(userAttestationPermissionSet, actualFindSupportedMeasurableCategoryAttestationsResult);
  }
}
