package org.finos.waltz.service.permission.permission_checker;

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
class AllocationPermissionCheckerDiffblueTest {
  @InjectMocks private AllocationPermissionChecker allocationPermissionChecker;

  @Mock private InvolvementService involvementService;

  @Mock private MeasurableRatingDao measurableRatingDao;

  @Mock private PermissionGroupService permissionGroupService;

  /**
   * Test {@link AllocationPermissionChecker#findAllocationPermissions(EntityReference, long,
   * String)}.
   *
   * <p>Method under test: {@link
   * AllocationPermissionChecker#findAllocationPermissions(EntityReference, long, String)}
   */
  @Test
  @DisplayName("Test findAllocationPermissions(EntityReference, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AllocationPermissionChecker.findAllocationPermissions(EntityReference, long, String)"
  })
  void testFindAllocationPermissions() {
    // Arrange
    when(measurableRatingDao.calculateAmendedAllocationOperations(
            Mockito.<Set<Operation>>any(), anyLong(), Mockito.<String>any()))
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
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(permissionSet);
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<Operation> actualFindAllocationPermissionsResult =
        allocationPermissionChecker.findAllocationPermissions(null, 1L, "janedoe");

    // Assert
    verify(measurableRatingDao)
        .calculateAmendedAllocationOperations(isA(Set.class), eq(1L), eq("janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(permissionGroupService).findPermissionsForParentReference(isNull(), eq("janedoe"));
    assertTrue(actualFindAllocationPermissionsResult.isEmpty());
  }

  /**
   * Test {@link AllocationPermissionChecker#findAllocationPermissions(EntityReference, long,
   * String)}.
   *
   * <p>Method under test: {@link
   * AllocationPermissionChecker#findAllocationPermissions(EntityReference, long, String)}
   */
  @Test
  @DisplayName("Test findAllocationPermissions(EntityReference, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AllocationPermissionChecker.findAllocationPermissions(EntityReference, long, String)"
  })
  void testFindAllocationPermissions2() {
    // Arrange
    when(measurableRatingDao.calculateAmendedAllocationOperations(
            Mockito.<Set<Operation>>any(), anyLong(), Mockito.<String>any()))
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
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<Operation> actualFindAllocationPermissionsResult =
        allocationPermissionChecker.findAllocationPermissions(null, 1L, "janedoe");

    // Assert
    verify(measurableRatingDao)
        .calculateAmendedAllocationOperations(isA(Set.class), eq(1L), eq("janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(permissionGroupService).findPermissionsForParentReference(isNull(), eq("janedoe"));
    assertTrue(actualFindAllocationPermissionsResult.isEmpty());
  }

  /**
   * Test {@link AllocationPermissionChecker#findAllocationPermissions(EntityReference, long,
   * String)}.
   *
   * <ul>
   *   <li>Then calls {@link InvolvementDao#findExistingInvolvementKindIdsForUser(EntityReference,
   *       String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AllocationPermissionChecker#findAllocationPermissions(EntityReference, long, String)}
   */
  @Test
  @DisplayName(
      "Test findAllocationPermissions(EntityReference, long, String); then calls findExistingInvolvementKindIdsForUser(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AllocationPermissionChecker.findAllocationPermissions(EntityReference, long, String)"
  })
  void testFindAllocationPermissions_thenCallsFindExistingInvolvementKindIdsForUser() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    when(measurableRatingDao.calculateAmendedAllocationOperations(
            Mockito.<Set<Operation>>any(), anyLong(), Mockito.<String>any()))
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

    InvolvementService involvementService =
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
        new PermissionGroupService(personService, permissionGroupDao, involvementService);

    InvolvementDao dao2 = mock(InvolvementDao.class);
    when(dao2.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
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
    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao2 = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService2 =
        new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonDao personDao2 = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
    ChangeLogService changeLogService3 =
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
            userRoleDao, roleDao, personDao3, changeLogService3, personService2, settingsService);

    InvolvementService involvementService2 =
        new InvolvementService(
            changeLogService2,
            dao2,
            logicalFlowDao2,
            physicalFlowDao2,
            entityReferenceNameResolver2,
            involvementKindService2,
            personDao2,
            userRoleService);

    AllocationPermissionChecker allocationPermissionChecker =
        new AllocationPermissionChecker(
            measurableRatingDao, permissionGroupService, involvementService2);

    // Act
    Set<Operation> actualFindAllocationPermissionsResult =
        allocationPermissionChecker.findAllocationPermissions(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            1L,
            "janedoe");

    // Assert
    verify(dao2).findExistingInvolvementKindIdsForUser(isA(EntityReference.class), eq("janedoe"));
    verify(measurableRatingDao)
        .calculateAmendedAllocationOperations(isA(Set.class), eq(1L), eq("janedoe"));
    verify(permissionGroupDao).findPermissionsForParentEntityReference(isA(EntityReference.class));
    verify(personDao).getByUserEmail("janedoe");
    assertTrue(actualFindAllocationPermissionsResult.isEmpty());
  }

  /**
   * Test {@link AllocationPermissionChecker#findAllocationPermissions(EntityReference, long,
   * String)}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       PermissionGroupService#findPermissionsForParentReference(EntityReference, String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AllocationPermissionChecker#findAllocationPermissions(EntityReference, long, String)}
   */
  @Test
  @DisplayName(
      "Test findAllocationPermissions(EntityReference, long, String); then calls findPermissionsForParentReference(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AllocationPermissionChecker.findAllocationPermissions(EntityReference, long, String)"
  })
  void testFindAllocationPermissions_thenCallsFindPermissionsForParentReference() {
    // Arrange
    when(measurableRatingDao.calculateAmendedAllocationOperations(
            Mockito.<Set<Operation>>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(permissionGroupService.findPermissionsForParentReference(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<Operation> actualFindAllocationPermissionsResult =
        allocationPermissionChecker.findAllocationPermissions(null, 1L, "janedoe");

    // Assert
    verify(measurableRatingDao)
        .calculateAmendedAllocationOperations(isA(Set.class), eq(1L), eq("janedoe"));
    verify(involvementService).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(permissionGroupService).findPermissionsForParentReference(isNull(), eq("janedoe"));
    assertTrue(actualFindAllocationPermissionsResult.isEmpty());
  }

  /**
   * Test {@link AllocationPermissionChecker#findAllocationPermissions(EntityReference, long,
   * String)}.
   *
   * <ul>
   *   <li>Then calls {@link PersonDao#getByUserEmail(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AllocationPermissionChecker#findAllocationPermissions(EntityReference, long, String)}
   */
  @Test
  @DisplayName(
      "Test findAllocationPermissions(EntityReference, long, String); then calls getByUserEmail(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AllocationPermissionChecker.findAllocationPermissions(EntityReference, long, String)"
  })
  void testFindAllocationPermissions_thenCallsGetByUserEmail() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    when(measurableRatingDao.calculateAmendedAllocationOperations(
            Mockito.<Set<Operation>>any(), anyLong(), Mockito.<String>any()))
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

    InvolvementService involvementService =
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
        new PermissionGroupService(personService, permissionGroupDao, involvementService);

    InvolvementService involvementService2 = mock(InvolvementService.class);
    when(involvementService2.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    AllocationPermissionChecker allocationPermissionChecker =
        new AllocationPermissionChecker(
            measurableRatingDao, permissionGroupService, involvementService2);

    // Act
    Set<Operation> actualFindAllocationPermissionsResult =
        allocationPermissionChecker.findAllocationPermissions(null, 1L, "janedoe");

    // Assert
    verify(measurableRatingDao)
        .calculateAmendedAllocationOperations(isA(Set.class), eq(1L), eq("janedoe"));
    verify(permissionGroupDao).findPermissionsForParentEntityReference(isNull());
    verify(personDao).getByUserEmail("janedoe");
    verify(involvementService2).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    assertTrue(actualFindAllocationPermissionsResult.isEmpty());
  }

  /**
   * Test {@link AllocationPermissionChecker#findAllocationPermissions(EntityReference, long,
   * String)}.
   *
   * <ul>
   *   <li>Then calls {@link PersonService#getPersonByUserId(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AllocationPermissionChecker#findAllocationPermissions(EntityReference, long, String)}
   */
  @Test
  @DisplayName(
      "Test findAllocationPermissions(EntityReference, long, String); then calls getPersonByUserId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AllocationPermissionChecker.findAllocationPermissions(EntityReference, long, String)"
  })
  void testFindAllocationPermissions_thenCallsGetPersonByUserId() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    when(measurableRatingDao.calculateAmendedAllocationOperations(
            Mockito.<Set<Operation>>any(), anyLong(), Mockito.<String>any()))
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

    InvolvementService involvementService =
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
        new PermissionGroupService(personService, permissionGroupDao, involvementService);

    InvolvementService involvementService2 = mock(InvolvementService.class);
    when(involvementService2.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    AllocationPermissionChecker allocationPermissionChecker =
        new AllocationPermissionChecker(
            measurableRatingDao, permissionGroupService, involvementService2);

    // Act
    Set<Operation> actualFindAllocationPermissionsResult =
        allocationPermissionChecker.findAllocationPermissions(null, 1L, "janedoe");

    // Assert
    verify(measurableRatingDao)
        .calculateAmendedAllocationOperations(isA(Set.class), eq(1L), eq("janedoe"));
    verify(permissionGroupDao).findPermissionsForParentEntityReference(isNull());
    verify(involvementService2).findExistingInvolvementKindIdsForUser(isNull(), eq("janedoe"));
    verify(personService).getPersonByUserId("janedoe");
    assertTrue(actualFindAllocationPermissionsResult.isEmpty());
  }
}
