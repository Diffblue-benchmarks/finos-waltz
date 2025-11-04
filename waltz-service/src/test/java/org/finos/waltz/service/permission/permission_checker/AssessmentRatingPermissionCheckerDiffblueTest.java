package org.finos.waltz.service.permission.permission_checker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.assessment_rating.AssessmentRatingDao;
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
import org.finos.waltz.model.assessment_rating.AssessmentDefinitionRatingOperations;
import org.finos.waltz.model.assessment_rating.AssessmentRatingOperations;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentDefinitionRatingOperations;
import org.finos.waltz.model.permission_group.Permission;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.involvement.InvolvementService;
import org.finos.waltz.service.involvement_kind.InvolvementKindService;
import org.finos.waltz.service.permission.PermissionGroupService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.user.UserRoleService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AssessmentRatingPermissionCheckerDiffblueTest {
  /**
   * Method under test:
   * {@link AssessmentRatingPermissionChecker#getRatingPermissions(EntityReference, long, String)}
   */
  @Test
  void testGetRatingPermissions() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.calculateAmendedRatingOperations(Mockito.<Set<Operation>>any(),
        Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any())).thenReturn(new HashSet<>());
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
    AssessmentDefinitionRatingOperations actualRatingPermissions = (new AssessmentRatingPermissionChecker(
        assessmentRatingDao, involvementService, permissionGroupService, new UserRoleService(userRoleDao, roleDao,
            personDao2, changeLogService2, personService2, new SettingsService(settingsDao, new ArrayList<>()))))
                .getRatingPermissions(null, 1L, "janedoe");

    // Assert
    verify(assessmentRatingDao).calculateAmendedRatingOperations(isA(Set.class), isNull(), eq(1L), eq("janedoe"));
    verify(personDao).getByUserEmail(eq("janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    assertTrue(actualRatingPermissions instanceof ImmutableAssessmentDefinitionRatingOperations);
    assertTrue(actualRatingPermissions.ratingOperations().isEmpty());
  }

  /**
   * Method under test:
   * {@link AssessmentRatingPermissionChecker#getRatingPermissions(EntityReference, long, String)}
   */
  @Test
  void testGetRatingPermissions2() {
    // Arrange
    HashSet<AssessmentRatingOperations> assessmentRatingOperationsSet = new HashSet<>();
    assessmentRatingOperationsSet.add(mock(AssessmentRatingOperations.class));
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.calculateAmendedRatingOperations(Mockito.<Set<Operation>>any(),
        Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any())).thenReturn(assessmentRatingOperationsSet);
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
    AssessmentDefinitionRatingOperations actualRatingPermissions = (new AssessmentRatingPermissionChecker(
        assessmentRatingDao, involvementService, permissionGroupService, new UserRoleService(userRoleDao, roleDao,
            personDao2, changeLogService2, personService2, new SettingsService(settingsDao, new ArrayList<>()))))
                .getRatingPermissions(null, 1L, "janedoe");

    // Assert
    verify(assessmentRatingDao).calculateAmendedRatingOperations(isA(Set.class), isNull(), eq(1L), eq("janedoe"));
    verify(personDao).getByUserEmail(eq("janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    assertTrue(actualRatingPermissions instanceof ImmutableAssessmentDefinitionRatingOperations);
    assertEquals(1, actualRatingPermissions.ratingOperations().size());
  }

  /**
   * Method under test:
   * {@link AssessmentRatingPermissionChecker#getRatingPermissions(EntityReference, long, String)}
   */
  @Test
  void testGetRatingPermissions3() {
    // Arrange
    HashSet<AssessmentRatingOperations> assessmentRatingOperationsSet = new HashSet<>();
    assessmentRatingOperationsSet.add(mock(AssessmentRatingOperations.class));
    assessmentRatingOperationsSet.add(mock(AssessmentRatingOperations.class));
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.calculateAmendedRatingOperations(Mockito.<Set<Operation>>any(),
        Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any())).thenReturn(assessmentRatingOperationsSet);
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
    AssessmentDefinitionRatingOperations actualRatingPermissions = (new AssessmentRatingPermissionChecker(
        assessmentRatingDao, involvementService, permissionGroupService, new UserRoleService(userRoleDao, roleDao,
            personDao2, changeLogService2, personService2, new SettingsService(settingsDao, new ArrayList<>()))))
                .getRatingPermissions(null, 1L, "janedoe");

    // Assert
    verify(assessmentRatingDao).calculateAmendedRatingOperations(isA(Set.class), isNull(), eq(1L), eq("janedoe"));
    verify(personDao).getByUserEmail(eq("janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    assertTrue(actualRatingPermissions instanceof ImmutableAssessmentDefinitionRatingOperations);
    assertEquals(assessmentRatingOperationsSet, actualRatingPermissions.ratingOperations());
  }

  /**
   * Method under test:
   * {@link AssessmentRatingPermissionChecker#getRatingPermissions(EntityReference, long, String)}
   */
  @Test
  void testGetRatingPermissions4() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.calculateAmendedRatingOperations(Mockito.<Set<Operation>>any(),
        Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any())).thenReturn(new HashSet<>());
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
    AssessmentDefinitionRatingOperations actualRatingPermissions = (new AssessmentRatingPermissionChecker(
        assessmentRatingDao, involvementService, permissionGroupService, new UserRoleService(userRoleDao, roleDao,
            personDao2, changeLogService2, personService2, new SettingsService(settingsDao, new ArrayList<>()))))
                .getRatingPermissions(null, 1L, "janedoe");

    // Assert
    verify(assessmentRatingDao).calculateAmendedRatingOperations(isA(Set.class), isNull(), eq(1L), eq("janedoe"));
    verify(permissionGroupDao).findPermissionsForParentEntityReference(isNull());
    verify(personDao).getByUserEmail(eq("janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    assertTrue(actualRatingPermissions instanceof ImmutableAssessmentDefinitionRatingOperations);
    assertTrue(actualRatingPermissions.ratingOperations().isEmpty());
  }

  /**
   * Method under test:
   * {@link AssessmentRatingPermissionChecker#getRatingPermissions(EntityReference, long, String)}
   */
  @Test
  void testGetRatingPermissions5() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.calculateAmendedRatingOperations(Mockito.<Set<Operation>>any(),
        Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any())).thenReturn(new HashSet<>());
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
    AssessmentDefinitionRatingOperations actualRatingPermissions = (new AssessmentRatingPermissionChecker(
        assessmentRatingDao, involvementService, permissionGroupService, new UserRoleService(userRoleDao, roleDao,
            personDao, changeLogService2, personService2, new SettingsService(settingsDao, new ArrayList<>()))))
                .getRatingPermissions(null, 1L, "janedoe");

    // Assert
    verify(assessmentRatingDao).calculateAmendedRatingOperations(isA(Set.class), isNull(), eq(1L), eq("janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(personService).getPersonByUserId(eq("janedoe"));
    assertTrue(actualRatingPermissions instanceof ImmutableAssessmentDefinitionRatingOperations);
    assertTrue(actualRatingPermissions.ratingOperations().isEmpty());
  }

  /**
   * Method under test:
   * {@link AssessmentRatingPermissionChecker#getRatingPermissions(EntityReference, long, String)}
   */
  @Test
  void testGetRatingPermissions6() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.calculateAmendedRatingOperations(Mockito.<Set<Operation>>any(),
        Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any())).thenReturn(new HashSet<>());
    InvolvementService involvementService = mock(InvolvementService.class);
    when(
        involvementService.findExistingInvolvementKindIdsForUser(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(new HashSet<>());
    PermissionGroupService permissionGroupService = mock(PermissionGroupService.class);
    when(
        permissionGroupService.findPermissionsForParentReference(Mockito.<EntityReference>any(), Mockito.<String>any()))
            .thenReturn(new HashSet<>());
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
    AssessmentDefinitionRatingOperations actualRatingPermissions = (new AssessmentRatingPermissionChecker(
        assessmentRatingDao, involvementService, permissionGroupService, new UserRoleService(userRoleDao, roleDao,
            personDao, changeLogService, personService, new SettingsService(settingsDao, new ArrayList<>()))))
                .getRatingPermissions(null, 1L, "janedoe");

    // Assert
    verify(assessmentRatingDao).calculateAmendedRatingOperations(isA(Set.class), isNull(), eq(1L), eq("janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(permissionGroupService).findPermissionsForParentReference(isNull(), eq("janedoe"));
    assertTrue(actualRatingPermissions instanceof ImmutableAssessmentDefinitionRatingOperations);
    assertTrue(actualRatingPermissions.ratingOperations().isEmpty());
  }

  /**
   * Method under test:
   * {@link AssessmentRatingPermissionChecker#getRatingPermissions(EntityReference, long, String)}
   */
  @Test
  void testGetRatingPermissions7() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.calculateAmendedRatingOperations(Mockito.<Set<Operation>>any(),
        Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any())).thenReturn(new HashSet<>());
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
    AssessmentDefinitionRatingOperations actualRatingPermissions = (new AssessmentRatingPermissionChecker(
        assessmentRatingDao, involvementService, permissionGroupService, new UserRoleService(userRoleDao, roleDao,
            personDao, changeLogService, personService, new SettingsService(settingsDao, new ArrayList<>()))))
                .getRatingPermissions(null, 1L, "janedoe");

    // Assert
    verify(assessmentRatingDao).calculateAmendedRatingOperations(isA(Set.class), isNull(), eq(1L), eq("janedoe"));
    verify(permission).subjectKind();
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(permissionGroupService).findPermissionsForParentReference(isNull(), eq("janedoe"));
    assertTrue(actualRatingPermissions instanceof ImmutableAssessmentDefinitionRatingOperations);
    assertTrue(actualRatingPermissions.ratingOperations().isEmpty());
  }

  /**
   * Method under test:
   * {@link AssessmentRatingPermissionChecker#getRatingPermissions(EntityReference, long, String)}
   */
  @Test
  void testGetRatingPermissions8() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.calculateAmendedRatingOperations(Mockito.<Set<Operation>>any(),
        Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any())).thenReturn(new HashSet<>());
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
    AssessmentDefinitionRatingOperations actualRatingPermissions = (new AssessmentRatingPermissionChecker(
        assessmentRatingDao, involvementService, permissionGroupService, new UserRoleService(userRoleDao, roleDao,
            personDao, changeLogService, personService, new SettingsService(settingsDao, new ArrayList<>()))))
                .getRatingPermissions(null, 1L, "janedoe");

    // Assert
    verify(assessmentRatingDao).calculateAmendedRatingOperations(isA(Set.class), isNull(), eq(1L), eq("janedoe"));
    verify(permission2).subjectKind();
    verify(permission).subjectKind();
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(permissionGroupService).findPermissionsForParentReference(isNull(), eq("janedoe"));
    assertTrue(actualRatingPermissions instanceof ImmutableAssessmentDefinitionRatingOperations);
    assertTrue(actualRatingPermissions.ratingOperations().isEmpty());
  }
}
