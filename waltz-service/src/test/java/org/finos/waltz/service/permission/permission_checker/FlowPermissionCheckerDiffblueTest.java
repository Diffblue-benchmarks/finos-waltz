package org.finos.waltz.service.permission.permission_checker;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.logical_flow.LogicalFlow;
import org.finos.waltz.model.permission_group.Permission;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.model.physical_specification.PhysicalSpecification;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.involvement.InvolvementService;
import org.finos.waltz.service.involvement_kind.InvolvementKindService;
import org.finos.waltz.service.permission.PermissionGroupService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.user.UserRoleService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FlowPermissionCheckerDiffblueTest {
  /**
   * Method under test:
   * {@link FlowPermissionChecker#findPermissionsForDecorator(EntityReference, String)}
   */
  @Test
  void testFindPermissionsForDecorator() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
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

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    InvolvementService involvementService = new InvolvementService(changeLogService, dao, logicalFlowDao2,
        physicalFlowDao, entityReferenceNameResolver, involvementKindService, personDao,
        new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService,
            new SettingsService(settingsDao, new ArrayList<>())));

    PersonService personService2 = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao2 = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao3 = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao2 = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver2 = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService2, permissionGroupDao,
        new InvolvementService(changeLogService3, dao2, logicalFlowDao3, physicalFlowDao2, entityReferenceNameResolver2,
            new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
            mock(UserRoleService.class)));

    UserRoleDao userRoleDao2 = mock(UserRoleDao.class);
    RoleDao roleDao2 = mock(RoleDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    ChangeLogService changeLogService4 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService3 = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao2 = mock(SettingsDao.class);
    FlowPermissionChecker flowPermissionChecker = new FlowPermissionChecker(logicalFlowDao, physicalSpecificationDao,
        involvementService, permissionGroupService, new UserRoleService(userRoleDao2, roleDao2, personDao3,
            changeLogService4, personService3, new SettingsService(settingsDao2, new ArrayList<>())));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> flowPermissionChecker.findPermissionsForDecorator(entityReference, "janedoe"));
    verify(entityReference, atLeast(1)).kind();
  }

  /**
   * Method under test:
   * {@link FlowPermissionChecker#findPermissionsForDecorator(EntityReference, String)}
   */
  @Test
  void testFindPermissionsForDecorator2() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
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

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    InvolvementService involvementService = new InvolvementService(changeLogService, dao, logicalFlowDao2,
        physicalFlowDao, entityReferenceNameResolver, involvementKindService, personDao,
        new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService,
            new SettingsService(settingsDao, new ArrayList<>())));

    PersonService personService2 = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao2 = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao3 = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao2 = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver2 = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService2, permissionGroupDao,
        new InvolvementService(changeLogService3, dao2, logicalFlowDao3, physicalFlowDao2, entityReferenceNameResolver2,
            new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
            mock(UserRoleService.class)));

    UserRoleDao userRoleDao2 = mock(UserRoleDao.class);
    RoleDao roleDao2 = mock(RoleDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    ChangeLogService changeLogService4 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService3 = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao2 = mock(SettingsDao.class);
    FlowPermissionChecker flowPermissionChecker = new FlowPermissionChecker(logicalFlowDao, physicalSpecificationDao,
        involvementService, permissionGroupService, new UserRoleService(userRoleDao2, roleDao2, personDao3,
            changeLogService4, personService3, new SettingsService(settingsDao2, new ArrayList<>())));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenThrow(new UnsupportedOperationException("Entity reference cannot be null"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> flowPermissionChecker.findPermissionsForDecorator(entityReference, "janedoe"));
    verify(entityReference).kind();
  }

  /**
   * Method under test:
   * {@link FlowPermissionChecker#findPermissionsForSpec(long, String)}
   */
  @Test
  void testFindPermissionsForSpec() {
    // Arrange
    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);
    when(physicalSpecificationDao.getById(anyLong()))
        .thenThrow(new UnsupportedOperationException("flow id cannot be null"));
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
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

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    InvolvementService involvementService = new InvolvementService(changeLogService, dao, logicalFlowDao2,
        physicalFlowDao, entityReferenceNameResolver, involvementKindService, personDao,
        new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService,
            new SettingsService(settingsDao, new ArrayList<>())));

    PersonService personService2 = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao2 = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao3 = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao2 = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver2 = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService2, permissionGroupDao,
        new InvolvementService(changeLogService3, dao2, logicalFlowDao3, physicalFlowDao2, entityReferenceNameResolver2,
            new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
            mock(UserRoleService.class)));

    UserRoleDao userRoleDao2 = mock(UserRoleDao.class);
    RoleDao roleDao2 = mock(RoleDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    ChangeLogService changeLogService4 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService3 = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new FlowPermissionChecker(logicalFlowDao, physicalSpecificationDao, involvementService,
            permissionGroupService, new UserRoleService(userRoleDao2, roleDao2, personDao3, changeLogService4,
                personService3, new SettingsService(settingsDao2, new ArrayList<>())))).findPermissionsForSpec(1L,
                    "janedoe"));
    verify(physicalSpecificationDao).getById(eq(1L));
  }

  /**
   * Method under test:
   * {@link FlowPermissionChecker#findPermissionsForSpec(long, String)}
   */
  @Test
  void testFindPermissionsForSpec2() {
    // Arrange
    PhysicalSpecification physicalSpecification = mock(PhysicalSpecification.class);
    when(physicalSpecification.isReadOnly()).thenReturn(true);
    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);
    when(physicalSpecificationDao.getById(anyLong())).thenReturn(physicalSpecification);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
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

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    InvolvementService involvementService = new InvolvementService(changeLogService, dao, logicalFlowDao2,
        physicalFlowDao, entityReferenceNameResolver, involvementKindService, personDao,
        new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService,
            new SettingsService(settingsDao, new ArrayList<>())));

    PersonService personService2 = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao2 = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao3 = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao2 = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver2 = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService2, permissionGroupDao,
        new InvolvementService(changeLogService3, dao2, logicalFlowDao3, physicalFlowDao2, entityReferenceNameResolver2,
            new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
            mock(UserRoleService.class)));

    UserRoleDao userRoleDao2 = mock(UserRoleDao.class);
    RoleDao roleDao2 = mock(RoleDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    ChangeLogService changeLogService4 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService3 = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act
    Set<Operation> actualFindPermissionsForSpecResult = (new FlowPermissionChecker(logicalFlowDao,
        physicalSpecificationDao, involvementService, permissionGroupService,
        new UserRoleService(userRoleDao2, roleDao2, personDao3, changeLogService4, personService3,
            new SettingsService(settingsDao2, new ArrayList<>())))).findPermissionsForSpec(1L, "janedoe");

    // Assert
    verify(physicalSpecificationDao).getById(eq(1L));
    verify(physicalSpecification).isReadOnly();
    assertTrue(actualFindPermissionsForSpecResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link FlowPermissionChecker#findPermissionsForSpec(long, String)}
   */
  @Test
  void testFindPermissionsForSpec3() {
    // Arrange
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    PhysicalSpecification physicalSpecification = mock(PhysicalSpecification.class);
    when(physicalSpecification.owningEntity()).thenReturn(entityReference);
    when(physicalSpecification.isReadOnly()).thenReturn(false);
    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);
    HashSet<Operation> operationSet = new HashSet<>();
    when(physicalSpecificationDao.calculateAmendedSpecOperations(Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(operationSet);
    when(physicalSpecificationDao.getById(anyLong())).thenReturn(physicalSpecification);
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findExistingInvolvementKindIdsForUser(Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

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

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    InvolvementService involvementService = new InvolvementService(changeLogService, dao, logicalFlowDao,
        physicalFlowDao, entityReferenceNameResolver, involvementKindService, personDao,
        new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService,
            new SettingsService(settingsDao, new ArrayList<>())));

    PersonDao personDao3 = mock(PersonDao.class);
    when(personDao3.getByUserEmail(Mockito.<String>any())).thenReturn(null);
    PersonService personService2 = new PersonService(personDao3, mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao2 = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao2 = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver2 = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService2, permissionGroupDao,
        new InvolvementService(changeLogService3, dao2, logicalFlowDao2, physicalFlowDao2, entityReferenceNameResolver2,
            new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
            mock(UserRoleService.class)));

    LogicalFlowDao logicalFlowDao3 = mock(LogicalFlowDao.class);
    UserRoleDao userRoleDao2 = mock(UserRoleDao.class);
    RoleDao roleDao2 = mock(RoleDao.class);
    PersonDao personDao4 = mock(PersonDao.class);
    ChangeLogService changeLogService4 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService3 = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act
    Set<Operation> actualFindPermissionsForSpecResult = (new FlowPermissionChecker(logicalFlowDao3,
        physicalSpecificationDao, involvementService, permissionGroupService,
        new UserRoleService(userRoleDao2, roleDao2, personDao4, changeLogService4, personService3,
            new SettingsService(settingsDao2, new ArrayList<>())))).findPermissionsForSpec(1L, "janedoe");

    // Assert
    verify(dao).findExistingInvolvementKindIdsForUser(isA(EntityReference.class), eq("janedoe"));
    verify(personDao3).getByUserEmail(eq("janedoe"));
    verify(physicalSpecificationDao).calculateAmendedSpecOperations(isA(Set.class), eq("janedoe"));
    verify(physicalSpecificationDao).getById(eq(1L));
    verify(entityReference, atLeast(1)).kind();
    verify(physicalSpecification).isReadOnly();
    verify(physicalSpecification).owningEntity();
    assertTrue(actualFindPermissionsForSpecResult.isEmpty());
    assertSame(operationSet, actualFindPermissionsForSpecResult);
  }

  /**
   * Method under test:
   * {@link FlowPermissionChecker#findFlowPermissionsForParentEntity(EntityReference, String)}
   */
  @Test
  void testFindFlowPermissionsForParentEntity() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    HashSet<Operation> operationSet = new HashSet<>();
    when(logicalFlowDao.calculateAmendedFlowOperations(Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(operationSet);
    InvolvementService involvementService = mock(InvolvementService.class);
    when(
        involvementService.findExistingInvolvementKindIdsForUser(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(new HashSet<>());
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
    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService, permissionGroupDao,
        new InvolvementService(changeLogService, dao, logicalFlowDao2, physicalFlowDao, entityReferenceNameResolver,
            new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
            mock(UserRoleService.class)));

    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);
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
    Set<Operation> actualFindFlowPermissionsForParentEntityResult = (new FlowPermissionChecker(logicalFlowDao,
        physicalSpecificationDao, involvementService, permissionGroupService, new UserRoleService(userRoleDao, roleDao,
            personDao2, changeLogService2, personService2, new SettingsService(settingsDao, new ArrayList<>()))))
                .findFlowPermissionsForParentEntity(null, "janedoe");

    // Assert
    verify(logicalFlowDao).calculateAmendedFlowOperations(isA(Set.class), eq("janedoe"));
    verify(personDao).getByUserEmail(eq("janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    assertTrue(actualFindFlowPermissionsForParentEntityResult.isEmpty());
    assertSame(operationSet, actualFindFlowPermissionsForParentEntityResult);
  }

  /**
   * Method under test:
   * {@link FlowPermissionChecker#findFlowPermissionsForParentEntity(EntityReference, String)}
   */
  @Test
  void testFindFlowPermissionsForParentEntity2() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    HashSet<Operation> operationSet = new HashSet<>();
    when(logicalFlowDao.calculateAmendedFlowOperations(Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(operationSet);
    InvolvementService involvementService = mock(InvolvementService.class);
    when(
        involvementService.findExistingInvolvementKindIdsForUser(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(new HashSet<>());
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
    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService, permissionGroupDao,
        new InvolvementService(changeLogService, dao, logicalFlowDao2, physicalFlowDao, entityReferenceNameResolver,
            new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
            mock(UserRoleService.class)));

    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);
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
    Set<Operation> actualFindFlowPermissionsForParentEntityResult = (new FlowPermissionChecker(logicalFlowDao,
        physicalSpecificationDao, involvementService, permissionGroupService, new UserRoleService(userRoleDao, roleDao,
            personDao2, changeLogService2, personService2, new SettingsService(settingsDao, new ArrayList<>()))))
                .findFlowPermissionsForParentEntity(null, "janedoe");

    // Assert
    verify(logicalFlowDao).calculateAmendedFlowOperations(isA(Set.class), eq("janedoe"));
    verify(permissionGroupDao).findPermissionsForParentEntityReference(isNull());
    verify(personDao).getByUserEmail(eq("janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    assertTrue(actualFindFlowPermissionsForParentEntityResult.isEmpty());
    assertSame(operationSet, actualFindFlowPermissionsForParentEntityResult);
  }

  /**
   * Method under test:
   * {@link FlowPermissionChecker#findFlowPermissionsForParentEntity(EntityReference, String)}
   */
  @Test
  void testFindFlowPermissionsForParentEntity3() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    HashSet<Operation> operationSet = new HashSet<>();
    when(logicalFlowDao.calculateAmendedFlowOperations(Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(operationSet);
    InvolvementService involvementService = mock(InvolvementService.class);
    when(
        involvementService.findExistingInvolvementKindIdsForUser(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(new HashSet<>());
    PersonService personService = mock(PersonService.class);
    when(personService.getPersonByUserId(Mockito.<String>any())).thenReturn(null);
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService, permissionGroupDao,
        new InvolvementService(changeLogService, dao, logicalFlowDao2, physicalFlowDao, entityReferenceNameResolver,
            new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
            mock(UserRoleService.class)));

    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService2 = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    Set<Operation> actualFindFlowPermissionsForParentEntityResult = (new FlowPermissionChecker(logicalFlowDao,
        physicalSpecificationDao, involvementService, permissionGroupService, new UserRoleService(userRoleDao, roleDao,
            personDao, changeLogService2, personService2, new SettingsService(settingsDao, new ArrayList<>()))))
                .findFlowPermissionsForParentEntity(null, "janedoe");

    // Assert
    verify(logicalFlowDao).calculateAmendedFlowOperations(isA(Set.class), eq("janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(personService).getPersonByUserId(eq("janedoe"));
    assertTrue(actualFindFlowPermissionsForParentEntityResult.isEmpty());
    assertSame(operationSet, actualFindFlowPermissionsForParentEntityResult);
  }

  /**
   * Method under test:
   * {@link FlowPermissionChecker#findFlowPermissionsForParentEntity(EntityReference, String)}
   */
  @Test
  void testFindFlowPermissionsForParentEntity4() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    HashSet<Operation> operationSet = new HashSet<>();
    when(logicalFlowDao.calculateAmendedFlowOperations(Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(operationSet);
    InvolvementService involvementService = mock(InvolvementService.class);
    when(
        involvementService.findExistingInvolvementKindIdsForUser(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(new HashSet<>());
    PermissionGroupService permissionGroupService = mock(PermissionGroupService.class);
    when(
        permissionGroupService.findPermissionsForParentReference(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(new HashSet<>());
    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    Set<Operation> actualFindFlowPermissionsForParentEntityResult = (new FlowPermissionChecker(logicalFlowDao,
        physicalSpecificationDao, involvementService, permissionGroupService, new UserRoleService(userRoleDao, roleDao,
            personDao, changeLogService, personService, new SettingsService(settingsDao, new ArrayList<>()))))
                .findFlowPermissionsForParentEntity(null, "janedoe");

    // Assert
    verify(logicalFlowDao).calculateAmendedFlowOperations(isA(Set.class), eq("janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(permissionGroupService).findPermissionsForParentReference(isNull(), eq("janedoe"));
    assertTrue(actualFindFlowPermissionsForParentEntityResult.isEmpty());
    assertSame(operationSet, actualFindFlowPermissionsForParentEntityResult);
  }

  /**
   * Method under test:
   * {@link FlowPermissionChecker#findFlowPermissionsForParentEntity(EntityReference, String)}
   */
  @Test
  void testFindFlowPermissionsForParentEntity5() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    HashSet<Operation> operationSet = new HashSet<>();
    when(logicalFlowDao.calculateAmendedFlowOperations(Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(operationSet);
    InvolvementService involvementService = mock(InvolvementService.class);
    when(
        involvementService.findExistingInvolvementKindIdsForUser(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(new HashSet<>());
    Permission permission = mock(Permission.class);
    when(permission.subjectKind()).thenReturn(EntityKind.ALL);

    HashSet<Permission> permissionSet = new HashSet<>();
    permissionSet.add(permission);
    PermissionGroupService permissionGroupService = mock(PermissionGroupService.class);
    when(
        permissionGroupService.findPermissionsForParentReference(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(permissionSet);
    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    Set<Operation> actualFindFlowPermissionsForParentEntityResult = (new FlowPermissionChecker(logicalFlowDao,
        physicalSpecificationDao, involvementService, permissionGroupService, new UserRoleService(userRoleDao, roleDao,
            personDao, changeLogService, personService, new SettingsService(settingsDao, new ArrayList<>()))))
                .findFlowPermissionsForParentEntity(null, "janedoe");

    // Assert
    verify(logicalFlowDao).calculateAmendedFlowOperations(isA(Set.class), eq("janedoe"));
    verify(permission).subjectKind();
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(permissionGroupService).findPermissionsForParentReference(isNull(), eq("janedoe"));
    assertTrue(actualFindFlowPermissionsForParentEntityResult.isEmpty());
    assertSame(operationSet, actualFindFlowPermissionsForParentEntityResult);
  }

  /**
   * Method under test:
   * {@link FlowPermissionChecker#findFlowPermissionsForParentEntity(EntityReference, String)}
   */
  @Test
  void testFindFlowPermissionsForParentEntity6() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    HashSet<Operation> operationSet = new HashSet<>();
    when(logicalFlowDao.calculateAmendedFlowOperations(Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(operationSet);
    InvolvementService involvementService = mock(InvolvementService.class);
    when(
        involvementService.findExistingInvolvementKindIdsForUser(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(new HashSet<>());
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
    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    Set<Operation> actualFindFlowPermissionsForParentEntityResult = (new FlowPermissionChecker(logicalFlowDao,
        physicalSpecificationDao, involvementService, permissionGroupService, new UserRoleService(userRoleDao, roleDao,
            personDao, changeLogService, personService, new SettingsService(settingsDao, new ArrayList<>()))))
                .findFlowPermissionsForParentEntity(null, "janedoe");

    // Assert
    verify(logicalFlowDao).calculateAmendedFlowOperations(isA(Set.class), eq("janedoe"));
    verify(permission2).subjectKind();
    verify(permission).subjectKind();
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(permissionGroupService).findPermissionsForParentReference(isNull(), eq("janedoe"));
    assertTrue(actualFindFlowPermissionsForParentEntityResult.isEmpty());
    assertSame(operationSet, actualFindFlowPermissionsForParentEntityResult);
  }

  /**
   * Method under test:
   * {@link FlowPermissionChecker#findSpecPermissionsForParentEntity(EntityReference, String)}
   */
  @Test
  void testFindSpecPermissionsForParentEntity() {
    // Arrange
    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);
    HashSet<Operation> operationSet = new HashSet<>();
    when(physicalSpecificationDao.calculateAmendedSpecOperations(Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(operationSet);
    InvolvementService involvementService = mock(InvolvementService.class);
    when(
        involvementService.findExistingInvolvementKindIdsForUser(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(new HashSet<>());
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

    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
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
    Set<Operation> actualFindSpecPermissionsForParentEntityResult = (new FlowPermissionChecker(logicalFlowDao2,
        physicalSpecificationDao, involvementService, permissionGroupService, new UserRoleService(userRoleDao, roleDao,
            personDao2, changeLogService2, personService2, new SettingsService(settingsDao, new ArrayList<>()))))
                .findSpecPermissionsForParentEntity(null, "janedoe");

    // Assert
    verify(personDao).getByUserEmail(eq("janedoe"));
    verify(physicalSpecificationDao).calculateAmendedSpecOperations(isA(Set.class), eq("janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    assertTrue(actualFindSpecPermissionsForParentEntityResult.isEmpty());
    assertSame(operationSet, actualFindSpecPermissionsForParentEntityResult);
  }

  /**
   * Method under test:
   * {@link FlowPermissionChecker#findSpecPermissionsForParentEntity(EntityReference, String)}
   */
  @Test
  void testFindSpecPermissionsForParentEntity2() {
    // Arrange
    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);
    HashSet<Operation> operationSet = new HashSet<>();
    when(physicalSpecificationDao.calculateAmendedSpecOperations(Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(operationSet);
    InvolvementService involvementService = mock(InvolvementService.class);
    when(
        involvementService.findExistingInvolvementKindIdsForUser(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(new HashSet<>());
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

    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
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
    Set<Operation> actualFindSpecPermissionsForParentEntityResult = (new FlowPermissionChecker(logicalFlowDao2,
        physicalSpecificationDao, involvementService, permissionGroupService, new UserRoleService(userRoleDao, roleDao,
            personDao2, changeLogService2, personService2, new SettingsService(settingsDao, new ArrayList<>()))))
                .findSpecPermissionsForParentEntity(null, "janedoe");

    // Assert
    verify(permissionGroupDao).findPermissionsForParentEntityReference(isNull());
    verify(personDao).getByUserEmail(eq("janedoe"));
    verify(physicalSpecificationDao).calculateAmendedSpecOperations(isA(Set.class), eq("janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    assertTrue(actualFindSpecPermissionsForParentEntityResult.isEmpty());
    assertSame(operationSet, actualFindSpecPermissionsForParentEntityResult);
  }

  /**
   * Method under test:
   * {@link FlowPermissionChecker#findSpecPermissionsForParentEntity(EntityReference, String)}
   */
  @Test
  void testFindSpecPermissionsForParentEntity3() {
    // Arrange
    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);
    HashSet<Operation> operationSet = new HashSet<>();
    when(physicalSpecificationDao.calculateAmendedSpecOperations(Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(operationSet);
    InvolvementService involvementService = mock(InvolvementService.class);
    when(
        involvementService.findExistingInvolvementKindIdsForUser(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(new HashSet<>());
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

    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService2 = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    Set<Operation> actualFindSpecPermissionsForParentEntityResult = (new FlowPermissionChecker(logicalFlowDao2,
        physicalSpecificationDao, involvementService, permissionGroupService, new UserRoleService(userRoleDao, roleDao,
            personDao, changeLogService2, personService2, new SettingsService(settingsDao, new ArrayList<>()))))
                .findSpecPermissionsForParentEntity(null, "janedoe");

    // Assert
    verify(physicalSpecificationDao).calculateAmendedSpecOperations(isA(Set.class), eq("janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(personService).getPersonByUserId(eq("janedoe"));
    assertTrue(actualFindSpecPermissionsForParentEntityResult.isEmpty());
    assertSame(operationSet, actualFindSpecPermissionsForParentEntityResult);
  }

  /**
   * Method under test:
   * {@link FlowPermissionChecker#findSpecPermissionsForParentEntity(EntityReference, String)}
   */
  @Test
  void testFindSpecPermissionsForParentEntity4() {
    // Arrange
    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);
    HashSet<Operation> operationSet = new HashSet<>();
    when(physicalSpecificationDao.calculateAmendedSpecOperations(Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(operationSet);
    InvolvementService involvementService = mock(InvolvementService.class);
    when(
        involvementService.findExistingInvolvementKindIdsForUser(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(new HashSet<>());
    PermissionGroupService permissionGroupService = mock(PermissionGroupService.class);
    when(
        permissionGroupService.findPermissionsForParentReference(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(new HashSet<>());
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    Set<Operation> actualFindSpecPermissionsForParentEntityResult = (new FlowPermissionChecker(logicalFlowDao,
        physicalSpecificationDao, involvementService, permissionGroupService, new UserRoleService(userRoleDao, roleDao,
            personDao, changeLogService, personService, new SettingsService(settingsDao, new ArrayList<>()))))
                .findSpecPermissionsForParentEntity(null, "janedoe");

    // Assert
    verify(physicalSpecificationDao).calculateAmendedSpecOperations(isA(Set.class), eq("janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(permissionGroupService).findPermissionsForParentReference(isNull(), eq("janedoe"));
    assertTrue(actualFindSpecPermissionsForParentEntityResult.isEmpty());
    assertSame(operationSet, actualFindSpecPermissionsForParentEntityResult);
  }

  /**
   * Method under test:
   * {@link FlowPermissionChecker#findSpecPermissionsForParentEntity(EntityReference, String)}
   */
  @Test
  void testFindSpecPermissionsForParentEntity5() {
    // Arrange
    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);
    HashSet<Operation> operationSet = new HashSet<>();
    when(physicalSpecificationDao.calculateAmendedSpecOperations(Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(operationSet);
    InvolvementService involvementService = mock(InvolvementService.class);
    when(
        involvementService.findExistingInvolvementKindIdsForUser(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(new HashSet<>());
    Permission permission = mock(Permission.class);
    when(permission.subjectKind()).thenReturn(EntityKind.ALL);

    HashSet<Permission> permissionSet = new HashSet<>();
    permissionSet.add(permission);
    PermissionGroupService permissionGroupService = mock(PermissionGroupService.class);
    when(
        permissionGroupService.findPermissionsForParentReference(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(permissionSet);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    Set<Operation> actualFindSpecPermissionsForParentEntityResult = (new FlowPermissionChecker(logicalFlowDao,
        physicalSpecificationDao, involvementService, permissionGroupService, new UserRoleService(userRoleDao, roleDao,
            personDao, changeLogService, personService, new SettingsService(settingsDao, new ArrayList<>()))))
                .findSpecPermissionsForParentEntity(null, "janedoe");

    // Assert
    verify(physicalSpecificationDao).calculateAmendedSpecOperations(isA(Set.class), eq("janedoe"));
    verify(permission).subjectKind();
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(permissionGroupService).findPermissionsForParentReference(isNull(), eq("janedoe"));
    assertTrue(actualFindSpecPermissionsForParentEntityResult.isEmpty());
    assertSame(operationSet, actualFindSpecPermissionsForParentEntityResult);
  }

  /**
   * Method under test:
   * {@link FlowPermissionChecker#findSpecPermissionsForParentEntity(EntityReference, String)}
   */
  @Test
  void testFindSpecPermissionsForParentEntity6() {
    // Arrange
    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);
    HashSet<Operation> operationSet = new HashSet<>();
    when(physicalSpecificationDao.calculateAmendedSpecOperations(Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(operationSet);
    InvolvementService involvementService = mock(InvolvementService.class);
    when(
        involvementService.findExistingInvolvementKindIdsForUser(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(new HashSet<>());
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
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    Set<Operation> actualFindSpecPermissionsForParentEntityResult = (new FlowPermissionChecker(logicalFlowDao,
        physicalSpecificationDao, involvementService, permissionGroupService, new UserRoleService(userRoleDao, roleDao,
            personDao, changeLogService, personService, new SettingsService(settingsDao, new ArrayList<>()))))
                .findSpecPermissionsForParentEntity(null, "janedoe");

    // Assert
    verify(physicalSpecificationDao).calculateAmendedSpecOperations(isA(Set.class), eq("janedoe"));
    verify(permission2).subjectKind();
    verify(permission).subjectKind();
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(permissionGroupService).findPermissionsForParentReference(isNull(), eq("janedoe"));
    assertTrue(actualFindSpecPermissionsForParentEntityResult.isEmpty());
    assertSame(operationSet, actualFindSpecPermissionsForParentEntityResult);
  }

  /**
   * Method under test:
   * {@link FlowPermissionChecker#findPermissionsForFlow(Long, String)}
   */
  @Test
  void testFindPermissionsForFlow() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.getByFlowId(anyLong())).thenThrow(new UnsupportedOperationException("flow id cannot be null"));
    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
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

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    InvolvementService involvementService = new InvolvementService(changeLogService, dao, logicalFlowDao2,
        physicalFlowDao, entityReferenceNameResolver, involvementKindService, personDao,
        new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService,
            new SettingsService(settingsDao, new ArrayList<>())));

    PersonService personService2 = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao2 = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao3 = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao2 = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver2 = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService2, permissionGroupDao,
        new InvolvementService(changeLogService3, dao2, logicalFlowDao3, physicalFlowDao2, entityReferenceNameResolver2,
            new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
            mock(UserRoleService.class)));

    UserRoleDao userRoleDao2 = mock(UserRoleDao.class);
    RoleDao roleDao2 = mock(RoleDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    ChangeLogService changeLogService4 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService3 = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new FlowPermissionChecker(logicalFlowDao, physicalSpecificationDao, involvementService,
            permissionGroupService, new UserRoleService(userRoleDao2, roleDao2, personDao3, changeLogService4,
                personService3, new SettingsService(settingsDao2, new ArrayList<>())))).findPermissionsForFlow(1L,
                    "janedoe"));
    verify(logicalFlowDao).getByFlowId(eq(1L));
  }

  /**
   * Method under test:
   * {@link FlowPermissionChecker#findPermissionsForFlow(Long, String)}
   */
  @Test
  void testFindPermissionsForFlow2() {
    // Arrange
    LogicalFlow logicalFlow = mock(LogicalFlow.class);
    when(logicalFlow.isReadOnly()).thenReturn(true);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.getByFlowId(anyLong())).thenReturn(logicalFlow);
    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
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

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    InvolvementService involvementService = new InvolvementService(changeLogService, dao, logicalFlowDao2,
        physicalFlowDao, entityReferenceNameResolver, involvementKindService, personDao,
        new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService,
            new SettingsService(settingsDao, new ArrayList<>())));

    PersonService personService2 = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao2 = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao3 = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao2 = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver2 = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService2, permissionGroupDao,
        new InvolvementService(changeLogService3, dao2, logicalFlowDao3, physicalFlowDao2, entityReferenceNameResolver2,
            new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
            mock(UserRoleService.class)));

    UserRoleDao userRoleDao2 = mock(UserRoleDao.class);
    RoleDao roleDao2 = mock(RoleDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    ChangeLogService changeLogService4 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService3 = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act
    Set<Operation> actualFindPermissionsForFlowResult = (new FlowPermissionChecker(logicalFlowDao,
        physicalSpecificationDao, involvementService, permissionGroupService,
        new UserRoleService(userRoleDao2, roleDao2, personDao3, changeLogService4, personService3,
            new SettingsService(settingsDao2, new ArrayList<>())))).findPermissionsForFlow(1L, "janedoe");

    // Assert
    verify(logicalFlowDao).getByFlowId(eq(1L));
    verify(logicalFlow).isReadOnly();
    assertTrue(actualFindPermissionsForFlowResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link FlowPermissionChecker#findPermissionsForFlow(Long, String)}
   */
  @Test
  void testFindPermissionsForFlow3() {
    // Arrange
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    LogicalFlow logicalFlow = mock(LogicalFlow.class);
    when(logicalFlow.source()).thenReturn(entityReference);
    when(logicalFlow.target()).thenReturn(entityReference2);
    when(logicalFlow.isReadOnly()).thenReturn(false);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.calculateAmendedFlowOperations(Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(logicalFlowDao.getByFlowId(anyLong())).thenReturn(logicalFlow);
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findExistingInvolvementKindIdsForUser(Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
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

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    InvolvementService involvementService = new InvolvementService(changeLogService, dao, logicalFlowDao2,
        physicalFlowDao, entityReferenceNameResolver, involvementKindService, personDao,
        new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService,
            new SettingsService(settingsDao, new ArrayList<>())));

    PersonDao personDao3 = mock(PersonDao.class);
    when(personDao3.getByUserEmail(Mockito.<String>any())).thenReturn(null);
    PersonService personService2 = new PersonService(personDao3, mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao2 = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao3 = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao2 = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver2 = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService2, permissionGroupDao,
        new InvolvementService(changeLogService3, dao2, logicalFlowDao3, physicalFlowDao2, entityReferenceNameResolver2,
            new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
            mock(UserRoleService.class)));

    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);
    UserRoleDao userRoleDao2 = mock(UserRoleDao.class);
    RoleDao roleDao2 = mock(RoleDao.class);
    PersonDao personDao4 = mock(PersonDao.class);
    ChangeLogService changeLogService4 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService3 = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act
    Set<Operation> actualFindPermissionsForFlowResult = (new FlowPermissionChecker(logicalFlowDao,
        physicalSpecificationDao, involvementService, permissionGroupService,
        new UserRoleService(userRoleDao2, roleDao2, personDao4, changeLogService4, personService3,
            new SettingsService(settingsDao2, new ArrayList<>())))).findPermissionsForFlow(1L, "janedoe");

    // Assert
    verify(dao, atLeast(1)).findExistingInvolvementKindIdsForUser(Mockito.<EntityReference>any(), eq("janedoe"));
    verify(logicalFlowDao, atLeast(1)).calculateAmendedFlowOperations(isA(Set.class), eq("janedoe"));
    verify(logicalFlowDao).getByFlowId(eq(1L));
    verify(personDao3, atLeast(1)).getByUserEmail(eq("janedoe"));
    verify(entityReference, atLeast(1)).kind();
    verify(entityReference2, atLeast(1)).kind();
    verify(logicalFlow).isReadOnly();
    verify(logicalFlow).source();
    verify(logicalFlow).target();
    assertTrue(actualFindPermissionsForFlowResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link FlowPermissionChecker#findPermissionsForSourceAndTarget(EntityReference, EntityReference, String)}
   */
  @Test
  void testFindPermissionsForSourceAndTarget() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.calculateAmendedFlowOperations(Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    InvolvementService involvementService = mock(InvolvementService.class);
    when(
        involvementService.findExistingInvolvementKindIdsForUser(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(new HashSet<>());
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
    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService, permissionGroupDao,
        new InvolvementService(changeLogService, dao, logicalFlowDao2, physicalFlowDao, entityReferenceNameResolver,
            new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
            mock(UserRoleService.class)));

    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);
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
    Set<Operation> actualFindPermissionsForSourceAndTargetResult = (new FlowPermissionChecker(logicalFlowDao,
        physicalSpecificationDao, involvementService, permissionGroupService,
        new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService2,
            new SettingsService(settingsDao, new ArrayList<>())))).findPermissionsForSourceAndTarget(null, null,
                "janedoe");

    // Assert
    verify(logicalFlowDao, atLeast(1)).calculateAmendedFlowOperations(isA(Set.class), eq("janedoe"));
    verify(personDao, atLeast(1)).getByUserEmail(eq("janedoe"));
    verify(involvementService, atLeast(1)).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    assertTrue(actualFindPermissionsForSourceAndTargetResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link FlowPermissionChecker#findPermissionsForSourceAndTarget(EntityReference, EntityReference, String)}
   */
  @Test
  void testFindPermissionsForSourceAndTarget2() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.calculateAmendedFlowOperations(Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    InvolvementService involvementService = mock(InvolvementService.class);
    when(
        involvementService.findExistingInvolvementKindIdsForUser(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(new HashSet<>());
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
    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService, permissionGroupDao,
        new InvolvementService(changeLogService, dao, logicalFlowDao2, physicalFlowDao, entityReferenceNameResolver,
            new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
            mock(UserRoleService.class)));

    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);
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
    Set<Operation> actualFindPermissionsForSourceAndTargetResult = (new FlowPermissionChecker(logicalFlowDao,
        physicalSpecificationDao, involvementService, permissionGroupService,
        new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService2,
            new SettingsService(settingsDao, new ArrayList<>())))).findPermissionsForSourceAndTarget(null, null,
                "janedoe");

    // Assert
    verify(logicalFlowDao, atLeast(1)).calculateAmendedFlowOperations(isA(Set.class), eq("janedoe"));
    verify(permissionGroupDao, atLeast(1)).findPermissionsForParentEntityReference(isNull());
    verify(personDao, atLeast(1)).getByUserEmail(eq("janedoe"));
    verify(involvementService, atLeast(1)).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    assertTrue(actualFindPermissionsForSourceAndTargetResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link FlowPermissionChecker#findPermissionsForSourceAndTarget(EntityReference, EntityReference, String)}
   */
  @Test
  void testFindPermissionsForSourceAndTarget3() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.calculateAmendedFlowOperations(Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    InvolvementService involvementService = mock(InvolvementService.class);
    when(
        involvementService.findExistingInvolvementKindIdsForUser(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(new HashSet<>());
    PersonService personService = mock(PersonService.class);
    when(personService.getPersonByUserId(Mockito.<String>any())).thenReturn(null);
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService, permissionGroupDao,
        new InvolvementService(changeLogService, dao, logicalFlowDao2, physicalFlowDao, entityReferenceNameResolver,
            new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
            mock(UserRoleService.class)));

    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService2 = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    Set<Operation> actualFindPermissionsForSourceAndTargetResult = (new FlowPermissionChecker(logicalFlowDao,
        physicalSpecificationDao, involvementService, permissionGroupService,
        new UserRoleService(userRoleDao, roleDao, personDao, changeLogService2, personService2,
            new SettingsService(settingsDao, new ArrayList<>())))).findPermissionsForSourceAndTarget(null, null,
                "janedoe");

    // Assert
    verify(logicalFlowDao, atLeast(1)).calculateAmendedFlowOperations(isA(Set.class), eq("janedoe"));
    verify(involvementService, atLeast(1)).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(personService, atLeast(1)).getPersonByUserId(eq("janedoe"));
    assertTrue(actualFindPermissionsForSourceAndTargetResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link FlowPermissionChecker#findPermissionsForSourceAndTarget(EntityReference, EntityReference, String)}
   */
  @Test
  void testFindPermissionsForSourceAndTarget4() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.calculateAmendedFlowOperations(Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    InvolvementService involvementService = mock(InvolvementService.class);
    when(
        involvementService.findExistingInvolvementKindIdsForUser(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(new HashSet<>());
    PermissionGroupService permissionGroupService = mock(PermissionGroupService.class);
    when(
        permissionGroupService.findPermissionsForParentReference(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(new HashSet<>());
    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    Set<Operation> actualFindPermissionsForSourceAndTargetResult = (new FlowPermissionChecker(logicalFlowDao,
        physicalSpecificationDao, involvementService, permissionGroupService,
        new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
            new SettingsService(settingsDao, new ArrayList<>())))).findPermissionsForSourceAndTarget(null, null,
                "janedoe");

    // Assert
    verify(logicalFlowDao, atLeast(1)).calculateAmendedFlowOperations(isA(Set.class), eq("janedoe"));
    verify(involvementService, atLeast(1)).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(permissionGroupService, atLeast(1)).findPermissionsForParentReference(isNull(), eq("janedoe"));
    assertTrue(actualFindPermissionsForSourceAndTargetResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link FlowPermissionChecker#findPermissionsForSourceAndTarget(EntityReference, EntityReference, String)}
   */
  @Test
  void testFindPermissionsForSourceAndTarget5() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.calculateAmendedFlowOperations(Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    InvolvementService involvementService = mock(InvolvementService.class);
    when(
        involvementService.findExistingInvolvementKindIdsForUser(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(new HashSet<>());
    Permission permission = mock(Permission.class);
    when(permission.subjectKind()).thenReturn(EntityKind.ALL);

    HashSet<Permission> permissionSet = new HashSet<>();
    permissionSet.add(permission);
    PermissionGroupService permissionGroupService = mock(PermissionGroupService.class);
    when(
        permissionGroupService.findPermissionsForParentReference(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(permissionSet);
    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    Set<Operation> actualFindPermissionsForSourceAndTargetResult = (new FlowPermissionChecker(logicalFlowDao,
        physicalSpecificationDao, involvementService, permissionGroupService,
        new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
            new SettingsService(settingsDao, new ArrayList<>())))).findPermissionsForSourceAndTarget(null, null,
                "janedoe");

    // Assert
    verify(logicalFlowDao, atLeast(1)).calculateAmendedFlowOperations(isA(Set.class), eq("janedoe"));
    verify(permission, atLeast(1)).subjectKind();
    verify(involvementService, atLeast(1)).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(permissionGroupService, atLeast(1)).findPermissionsForParentReference(isNull(), eq("janedoe"));
    assertTrue(actualFindPermissionsForSourceAndTargetResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link FlowPermissionChecker#findPermissionsForSourceAndTarget(EntityReference, EntityReference, String)}
   */
  @Test
  void testFindPermissionsForSourceAndTarget6() {
    // Arrange
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    when(logicalFlowDao.calculateAmendedFlowOperations(Mockito.<Set<Operation>>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    InvolvementService involvementService = mock(InvolvementService.class);
    when(
        involvementService.findExistingInvolvementKindIdsForUser(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(new HashSet<>());
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
    PhysicalSpecificationDao physicalSpecificationDao = mock(PhysicalSpecificationDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    Set<Operation> actualFindPermissionsForSourceAndTargetResult = (new FlowPermissionChecker(logicalFlowDao,
        physicalSpecificationDao, involvementService, permissionGroupService,
        new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
            new SettingsService(settingsDao, new ArrayList<>())))).findPermissionsForSourceAndTarget(null, null,
                "janedoe");

    // Assert
    verify(logicalFlowDao, atLeast(1)).calculateAmendedFlowOperations(isA(Set.class), eq("janedoe"));
    verify(permission2, atLeast(1)).subjectKind();
    verify(permission, atLeast(1)).subjectKind();
    verify(involvementService, atLeast(1)).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(permissionGroupService, atLeast(1)).findPermissionsForParentReference(isNull(), eq("janedoe"));
    assertTrue(actualFindPermissionsForSourceAndTargetResult.isEmpty());
  }
}
