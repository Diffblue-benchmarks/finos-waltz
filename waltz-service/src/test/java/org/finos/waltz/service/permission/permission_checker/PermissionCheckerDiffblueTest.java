package org.finos.waltz.service.permission.permission_checker;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.common.exception.InsufficientPrivelegeException;
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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.Operation;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.involvement.InvolvementService;
import org.finos.waltz.service.involvement_kind.InvolvementKindService;
import org.finos.waltz.service.permission.PermissionGroupService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.user.UserRoleService;
import org.junit.jupiter.api.Test;

class PermissionCheckerDiffblueTest {
  /**
   * Method under test:
   * {@link PermissionChecker#verifyAnyPerms(Set, Set, EntityKind, String)}
   */
  @Test
  void testVerifyAnyPerms() throws InsufficientPrivelegeException {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

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

    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao2 = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao2 = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver2 = mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService = new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService2 = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    AllocationPermissionChecker allocationPermissionChecker = new AllocationPermissionChecker(measurableRatingDao,
        permissionGroupService,
        new InvolvementService(changeLogService2, dao2, logicalFlowDao2, physicalFlowDao2, entityReferenceNameResolver2,
            involvementKindService, personDao, new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService3,
                personService2, new SettingsService(settingsDao, new ArrayList<>()))));
    HashSet<Operation> possiblePerms = new HashSet<>();

    // Act and Assert
    assertThrows(InsufficientPrivelegeException.class,
        () -> allocationPermissionChecker.verifyAnyPerms(possiblePerms, new HashSet<>(), EntityKind.ALL, "janedoe"));
  }

  /**
   * Method under test:
   * {@link PermissionChecker#verifyEditPerms(Set, EntityKind, String)}
   */
  @Test
  void testVerifyEditPerms() throws InsufficientPrivelegeException {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

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

    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao2 = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao2 = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver2 = mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService = new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService2 = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    AllocationPermissionChecker allocationPermissionChecker = new AllocationPermissionChecker(measurableRatingDao,
        permissionGroupService,
        new InvolvementService(changeLogService2, dao2, logicalFlowDao2, physicalFlowDao2, entityReferenceNameResolver2,
            involvementKindService, personDao, new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService3,
                personService2, new SettingsService(settingsDao, new ArrayList<>()))));

    // Act and Assert
    assertThrows(InsufficientPrivelegeException.class,
        () -> allocationPermissionChecker.verifyEditPerms(new HashSet<>(), EntityKind.ALL, "janedoe"));
  }
}
