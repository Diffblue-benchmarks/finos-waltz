package org.finos.waltz.service.permission.permission_checker;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Set;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.involvement.InvolvementDao;
import org.finos.waltz.data.involvement_kind.InvolvementKindDao;
import org.finos.waltz.data.legal_entity.LegalEntityRelationshipKindDao;
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
import org.finos.waltz.model.legal_entity.LegalEntityRelationshipKind;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.involvement.InvolvementService;
import org.finos.waltz.service.involvement_kind.InvolvementKindService;
import org.finos.waltz.service.legal_entity.LegalEntityRelationshipKindService;
import org.finos.waltz.service.permission.PermissionGroupService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.user.UserRoleService;
import org.junit.jupiter.api.Test;

class LegalEntityRelationshipPermissionCheckerDiffblueTest {
  /**
   * Method under test:
   * {@link LegalEntityRelationshipPermissionChecker#findLegalEntityRelationshipPermissionsForRelationshipKind(long, String)}
   */
  @Test
  void testFindLegalEntityRelationshipPermissionsForRelationshipKind() {
    // Arrange
    LegalEntityRelationshipKind legalEntityRelationshipKind = mock(LegalEntityRelationshipKind.class);
    when(legalEntityRelationshipKind.targetKind()).thenReturn(EntityKind.ALL);
    LegalEntityRelationshipKindService legalEntityRelationshipKindService = mock(
        LegalEntityRelationshipKindService.class);
    when(legalEntityRelationshipKindService.getById(anyLong())).thenReturn(legalEntityRelationshipKind);
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

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    InvolvementService involvementService = new InvolvementService(changeLogService, dao, logicalFlowDao,
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
    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao2 = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver2 = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService2, permissionGroupDao,
        new InvolvementService(changeLogService3, dao2, logicalFlowDao2, physicalFlowDao2, entityReferenceNameResolver2,
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
    Set<Operation> actualFindLegalEntityRelationshipPermissionsForRelationshipKindResult = (new LegalEntityRelationshipPermissionChecker(
        legalEntityRelationshipKindService, involvementService, permissionGroupService,
        new UserRoleService(userRoleDao2, roleDao2, personDao3, changeLogService4, personService3,
            new SettingsService(settingsDao2, new ArrayList<>()))))
                .findLegalEntityRelationshipPermissionsForRelationshipKind(1L, "janedoe");

    // Assert
    verify(legalEntityRelationshipKind).targetKind();
    verify(legalEntityRelationshipKindService).getById(eq(1L));
    assertTrue(actualFindLegalEntityRelationshipPermissionsForRelationshipKindResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link LegalEntityRelationshipPermissionChecker#findLegalEntityRelationshipPermissionsForTargetKind(EntityKind, String)}
   */
  @Test
  void testFindLegalEntityRelationshipPermissionsForTargetKind() {
    // Arrange
    LegalEntityRelationshipKindService legalEntityRelationshipKindService = new LegalEntityRelationshipKindService(
        mock(LegalEntityRelationshipKindDao.class));
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

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    InvolvementService involvementService = new InvolvementService(changeLogService, dao, logicalFlowDao,
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
    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao2 = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver2 = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService2, permissionGroupDao,
        new InvolvementService(changeLogService3, dao2, logicalFlowDao2, physicalFlowDao2, entityReferenceNameResolver2,
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
    assertTrue((new LegalEntityRelationshipPermissionChecker(legalEntityRelationshipKindService, involvementService,
        permissionGroupService,
        new UserRoleService(userRoleDao2, roleDao2, personDao3, changeLogService4, personService3,
            new SettingsService(settingsDao2, new ArrayList<>()))))
                .findLegalEntityRelationshipPermissionsForTargetKind(EntityKind.ALL, "janedoe")
                .isEmpty());
  }
}
