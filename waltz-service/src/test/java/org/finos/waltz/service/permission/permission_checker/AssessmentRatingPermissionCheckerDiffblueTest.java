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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
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
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.assessment_rating.AssessmentDefinitionRatingOperations;
import org.finos.waltz.model.assessment_rating.AssessmentRatingOperations;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentDefinitionRatingOperations;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentRatingOperations;
import org.finos.waltz.model.permission_group.ImmutablePermission;
import org.finos.waltz.model.permission_group.ImmutablePermission.Builder;
import org.finos.waltz.model.permission_group.ImmutableRequiredInvolvementsResult;
import org.finos.waltz.model.permission_group.Permission;
import org.finos.waltz.model.person.ImmutablePerson;
import org.finos.waltz.model.person.PersonKind;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.involvement.InvolvementService;
import org.finos.waltz.service.involvement_kind.InvolvementKindService;
import org.finos.waltz.service.permission.PermissionGroupService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.user.UserRoleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AssessmentRatingPermissionCheckerDiffblueTest {
  @Mock private AssessmentRatingDao assessmentRatingDao;

  @InjectMocks private AssessmentRatingPermissionChecker assessmentRatingPermissionChecker;

  @Mock private InvolvementService involvementService;

  @Mock private PermissionGroupService permissionGroupService;

  @Mock private UserRoleService userRoleService;

  /**
   * Test {@link AssessmentRatingPermissionChecker#getRatingPermissions(EntityReference, long,
   * String)}.
   *
   * <p>Method under test: {@link
   * AssessmentRatingPermissionChecker#getRatingPermissions(EntityReference, long, String)}
   */
  @Test
  @DisplayName("Test getRatingPermissions(EntityReference, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentDefinitionRatingOperations AssessmentRatingPermissionChecker.getRatingPermissions(EntityReference, long, String)"
  })
  void testGetRatingPermissions() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.calculateAmendedRatingOperations(
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityReference>any(),
            anyLong(),
            Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    HashSet<Permission> permissionSet = new HashSet<>();

    Builder parentKindResult =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);

    Builder qualifierReferenceResult = parentKindResult.qualifierReference(qualifierReference);
    permissionSet.add(
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build());

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    when(permissionGroupDao.findPermissionsForParentEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(permissionSet);
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
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService2 =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService2);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
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
    PersonService personService2 =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService2, settingsService);

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        new AssessmentRatingPermissionChecker(
            assessmentRatingDao, involvementService, permissionGroupService, userRoleService);

    // Act
    AssessmentDefinitionRatingOperations actualRatingPermissions =
        assessmentRatingPermissionChecker.getRatingPermissions(null, 1L, "janedoe");

    // Assert
    verify(assessmentRatingDao)
        .calculateAmendedRatingOperations(isA(Set.class), isNull(), eq(1L), eq("janedoe"));
    verify(permissionGroupDao).findPermissionsForParentEntityReference(isNull());
    verify(personDao).getByUserEmail("janedoe");
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    assertTrue(actualRatingPermissions instanceof ImmutableAssessmentDefinitionRatingOperations);
    assertTrue(actualRatingPermissions.ratingOperations().isEmpty());
  }

  /**
   * Test {@link AssessmentRatingPermissionChecker#getRatingPermissions(EntityReference, long,
   * String)}.
   *
   * <p>Method under test: {@link
   * AssessmentRatingPermissionChecker#getRatingPermissions(EntityReference, long, String)}
   */
  @Test
  @DisplayName("Test getRatingPermissions(EntityReference, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentDefinitionRatingOperations AssessmentRatingPermissionChecker.getRatingPermissions(EntityReference, long, String)"
  })
  void testGetRatingPermissions2() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.calculateAmendedRatingOperations(
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityReference>any(),
            anyLong(),
            Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    PermissionGroupService permissionGroupService = mock(PermissionGroupService.class);
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        new AssessmentRatingPermissionChecker(
            assessmentRatingDao, involvementService, permissionGroupService, userRoleService);

    // Act
    AssessmentDefinitionRatingOperations actualRatingPermissions =
        assessmentRatingPermissionChecker.getRatingPermissions(null, 1L, "janedoe");

    // Assert
    verify(assessmentRatingDao)
        .calculateAmendedRatingOperations(isA(Set.class), isNull(), eq(1L), eq("janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(permissionGroupService).findPermissionsForParentReference(isNull(), eq("janedoe"));
    assertTrue(actualRatingPermissions instanceof ImmutableAssessmentDefinitionRatingOperations);
    assertTrue(actualRatingPermissions.ratingOperations().isEmpty());
  }

  /**
   * Test {@link AssessmentRatingPermissionChecker#getRatingPermissions(EntityReference, long,
   * String)}.
   *
   * <p>Method under test: {@link
   * AssessmentRatingPermissionChecker#getRatingPermissions(EntityReference, long, String)}
   */
  @Test
  @DisplayName("Test getRatingPermissions(EntityReference, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentDefinitionRatingOperations AssessmentRatingPermissionChecker.getRatingPermissions(EntityReference, long, String)"
  })
  void testGetRatingPermissions3() {
    // Arrange
    when(assessmentRatingDao.calculateAmendedRatingOperations(
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityReference>any(),
            anyLong(),
            Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    HashSet<Permission> permissionSet = new HashSet<>();

    Builder parentKindResult =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);

    Builder qualifierReferenceResult = parentKindResult.qualifierReference(qualifierReference);
    permissionSet.add(
        qualifierReferenceResult
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build());

    Builder parentKindResult2 =
        ImmutablePermission.builder().operation(Operation.ADD).parentKind(EntityKind.ALL);
    Optional<? extends EntityReference> qualifierReference2 = Optional.empty();

    Builder qualifierReferenceResult2 = parentKindResult2.qualifierReference(qualifierReference2);
    permissionSet.add(
        qualifierReferenceResult2
            .requiredInvolvementsResult(
                ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build())
            .subjectKind(EntityKind.ALL)
            .build());
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(permissionSet);

    // Act
    AssessmentDefinitionRatingOperations actualRatingPermissions =
        assessmentRatingPermissionChecker.getRatingPermissions(null, 1L, "janedoe");

    // Assert
    verify(assessmentRatingDao)
        .calculateAmendedRatingOperations(isA(Set.class), isNull(), eq(1L), eq("janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(permissionGroupService).findPermissionsForParentReference(isNull(), eq("janedoe"));
    assertTrue(actualRatingPermissions instanceof ImmutableAssessmentDefinitionRatingOperations);
    assertTrue(actualRatingPermissions.ratingOperations().isEmpty());
  }

  /**
   * Test {@link AssessmentRatingPermissionChecker#getRatingPermissions(EntityReference, long,
   * String)}.
   *
   * <ul>
   *   <li>Then calls {@link PersonDao#getByUserEmail(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingPermissionChecker#getRatingPermissions(EntityReference, long, String)}
   */
  @Test
  @DisplayName(
      "Test getRatingPermissions(EntityReference, long, String); then calls getByUserEmail(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentDefinitionRatingOperations AssessmentRatingPermissionChecker.getRatingPermissions(EntityReference, long, String)"
  })
  void testGetRatingPermissions_thenCallsGetByUserEmail() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.calculateAmendedRatingOperations(
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityReference>any(),
            anyLong(),
            Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    when(permissionGroupDao.findPermissionsForParentEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());
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
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService2 =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService2);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
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
    PersonService personService2 =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService2, settingsService);

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        new AssessmentRatingPermissionChecker(
            assessmentRatingDao, involvementService, permissionGroupService, userRoleService);

    // Act
    AssessmentDefinitionRatingOperations actualRatingPermissions =
        assessmentRatingPermissionChecker.getRatingPermissions(null, 1L, "janedoe");

    // Assert
    verify(assessmentRatingDao)
        .calculateAmendedRatingOperations(isA(Set.class), isNull(), eq(1L), eq("janedoe"));
    verify(permissionGroupDao).findPermissionsForParentEntityReference(isNull());
    verify(personDao).getByUserEmail("janedoe");
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    assertTrue(actualRatingPermissions instanceof ImmutableAssessmentDefinitionRatingOperations);
    assertTrue(actualRatingPermissions.ratingOperations().isEmpty());
  }

  /**
   * Test {@link AssessmentRatingPermissionChecker#getRatingPermissions(EntityReference, long,
   * String)}.
   *
   * <ul>
   *   <li>Then calls {@link PersonService#getPersonByUserId(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingPermissionChecker#getRatingPermissions(EntityReference, long, String)}
   */
  @Test
  @DisplayName(
      "Test getRatingPermissions(EntityReference, long, String); then calls getPersonByUserId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentDefinitionRatingOperations AssessmentRatingPermissionChecker.getRatingPermissions(EntityReference, long, String)"
  })
  void testGetRatingPermissions_thenCallsGetPersonByUserId() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.calculateAmendedRatingOperations(
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityReference>any(),
            anyLong(),
            Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    PersonService personService = mock(PersonService.class);
    when(personService.getPersonByUserId(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    when(permissionGroupDao.findPermissionsForParentEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());
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
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService2 =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService2);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
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
    PersonService personService2 =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService2, personService2, settingsService);

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        new AssessmentRatingPermissionChecker(
            assessmentRatingDao, involvementService, permissionGroupService, userRoleService);

    // Act
    AssessmentDefinitionRatingOperations actualRatingPermissions =
        assessmentRatingPermissionChecker.getRatingPermissions(null, 1L, "janedoe");

    // Assert
    verify(assessmentRatingDao)
        .calculateAmendedRatingOperations(isA(Set.class), isNull(), eq(1L), eq("janedoe"));
    verify(permissionGroupDao).findPermissionsForParentEntityReference(isNull());
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(personService).getPersonByUserId("janedoe");
    assertTrue(actualRatingPermissions instanceof ImmutableAssessmentDefinitionRatingOperations);
    assertTrue(actualRatingPermissions.ratingOperations().isEmpty());
  }

  /**
   * Test {@link AssessmentRatingPermissionChecker#getRatingPermissions(EntityReference, long,
   * String)}.
   *
   * <ul>
   *   <li>Then return ratingOperations is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingPermissionChecker#getRatingPermissions(EntityReference, long, String)}
   */
  @Test
  @DisplayName(
      "Test getRatingPermissions(EntityReference, long, String); then return ratingOperations is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentDefinitionRatingOperations AssessmentRatingPermissionChecker.getRatingPermissions(EntityReference, long, String)"
  })
  void testGetRatingPermissions_thenReturnRatingOperationsIsHashSet() {
    // Arrange
    ImmutableAssessmentRatingOperations.Builder builderResult =
        ImmutableAssessmentRatingOperations.builder();
    builderResult.addOperations(Operation.ADD);
    ImmutableAssessmentRatingOperations immutableAssessmentRatingOperations =
        builderResult.ratingId(1L).build();

    HashSet<AssessmentRatingOperations> assessmentRatingOperationsSet = new HashSet<>();
    assessmentRatingOperationsSet.add(
        ImmutableAssessmentRatingOperations.builder().ratingId(1L).build());
    assessmentRatingOperationsSet.add(immutableAssessmentRatingOperations);
    when(assessmentRatingDao.calculateAmendedRatingOperations(
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityReference>any(),
            anyLong(),
            Mockito.<String>any()))
        .thenReturn(assessmentRatingOperationsSet);
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    AssessmentDefinitionRatingOperations actualRatingPermissions =
        assessmentRatingPermissionChecker.getRatingPermissions(null, 1L, "janedoe");

    // Assert
    verify(assessmentRatingDao)
        .calculateAmendedRatingOperations(isA(Set.class), isNull(), eq(1L), eq("janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(permissionGroupService).findPermissionsForParentReference(isNull(), eq("janedoe"));
    assertTrue(actualRatingPermissions instanceof ImmutableAssessmentDefinitionRatingOperations);
    assertEquals(assessmentRatingOperationsSet, actualRatingPermissions.ratingOperations());
  }

  /**
   * Test {@link AssessmentRatingPermissionChecker#getRatingPermissions(EntityReference, long,
   * String)}.
   *
   * <ul>
   *   <li>Then return ratingOperations size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingPermissionChecker#getRatingPermissions(EntityReference, long, String)}
   */
  @Test
  @DisplayName(
      "Test getRatingPermissions(EntityReference, long, String); then return ratingOperations size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentDefinitionRatingOperations AssessmentRatingPermissionChecker.getRatingPermissions(EntityReference, long, String)"
  })
  void testGetRatingPermissions_thenReturnRatingOperationsSizeIsOne() {
    // Arrange
    HashSet<AssessmentRatingOperations> assessmentRatingOperationsSet = new HashSet<>();
    assessmentRatingOperationsSet.add(
        ImmutableAssessmentRatingOperations.builder().ratingId(1L).build());

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.calculateAmendedRatingOperations(
            Mockito.<Set<Operation>>any(),
            Mockito.<EntityReference>any(),
            anyLong(),
            Mockito.<String>any()))
        .thenReturn(assessmentRatingOperationsSet);

    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    when(permissionGroupDao.findPermissionsForParentEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());
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
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService2 =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService2);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
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
    PersonService personService2 =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService2, settingsService);

    AssessmentRatingPermissionChecker assessmentRatingPermissionChecker =
        new AssessmentRatingPermissionChecker(
            assessmentRatingDao, involvementService, permissionGroupService, userRoleService);

    // Act
    AssessmentDefinitionRatingOperations actualRatingPermissions =
        assessmentRatingPermissionChecker.getRatingPermissions(null, 1L, "janedoe");

    // Assert
    verify(assessmentRatingDao)
        .calculateAmendedRatingOperations(isA(Set.class), isNull(), eq(1L), eq("janedoe"));
    verify(permissionGroupDao).findPermissionsForParentEntityReference(isNull());
    verify(personDao).getByUserEmail("janedoe");
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    assertTrue(actualRatingPermissions instanceof ImmutableAssessmentDefinitionRatingOperations);
    assertEquals(1, actualRatingPermissions.ratingOperations().size());
  }
}
