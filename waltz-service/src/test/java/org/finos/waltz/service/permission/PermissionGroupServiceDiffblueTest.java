package org.finos.waltz.service.permission;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.attestation.UserAttestationPermission;
import org.finos.waltz.model.permission_group.CheckPermissionCommand;
import org.finos.waltz.model.permission_group.ImmutableCheckPermissionCommand;
import org.finos.waltz.model.permission_group.ImmutableRequiredInvolvementsResult;
import org.finos.waltz.model.permission_group.ImmutableRequiredInvolvementsResult.Builder;
import org.finos.waltz.model.permission_group.Permission;
import org.finos.waltz.model.person.ImmutablePerson;
import org.finos.waltz.model.person.PersonKind;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.involvement.InvolvementService;
import org.finos.waltz.service.involvement_kind.InvolvementKindService;
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
class PermissionGroupServiceDiffblueTest {
  @Mock private InvolvementService involvementService;

  @Mock private PermissionGroupDao permissionGroupDao;

  @InjectMocks private PermissionGroupService permissionGroupService;

  @Mock private PersonService personService;

  /**
   * Test {@link PermissionGroupService#findPermissionsForParentReference(EntityReference, String)}.
   *
   * <ul>
   *   <li>Then calls {@link PersonDao#getByUserEmail(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PermissionGroupService#findPermissionsForParentReference(EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test findPermissionsForParentReference(EntityReference, String); then calls getByUserEmail(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PermissionGroupService.findPermissionsForParentReference(EntityReference, String)"
  })
  void testFindPermissionsForParentReference_thenCallsGetByUserEmail() {
    // Arrange
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
    PersonDao personDao2 = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao3 = mock(PersonDao.class);
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
            userRoleDao, roleDao, personDao3, changeLogService2, personService2, settingsService);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            personDao2,
            userRoleService);

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);

    // Act
    Set<Permission> actualFindPermissionsForParentReferenceResult =
        permissionGroupService.findPermissionsForParentReference(null, "janedoe");

    // Assert
    verify(permissionGroupDao).findPermissionsForParentEntityReference(isNull());
    verify(personDao).getByUserEmail("janedoe");
    assertTrue(actualFindPermissionsForParentReferenceResult.isEmpty());
  }

  /**
   * Test {@link PermissionGroupService#findPermissionsForParentReference(EntityReference, String)}.
   *
   * <ul>
   *   <li>Then calls {@link PersonService#getPersonByUserId(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PermissionGroupService#findPermissionsForParentReference(EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test findPermissionsForParentReference(EntityReference, String); then calls getPersonByUserId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PermissionGroupService.findPermissionsForParentReference(EntityReference, String)"
  })
  void testFindPermissionsForParentReference_thenCallsGetPersonByUserId() {
    // Arrange
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
    when(permissionGroupDao.findPermissionsForParentEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<Permission> actualFindPermissionsForParentReferenceResult =
        permissionGroupService.findPermissionsForParentReference(null, "janedoe");

    // Assert
    verify(permissionGroupDao).findPermissionsForParentEntityReference(isNull());
    verify(personService).getPersonByUserId("janedoe");
    assertTrue(actualFindPermissionsForParentReferenceResult.isEmpty());
  }

  /**
   * Test {@link PermissionGroupService#hasPermission(CheckPermissionCommand)}.
   *
   * <p>Method under test: {@link PermissionGroupService#hasPermission(CheckPermissionCommand)}
   */
  @Test
  @DisplayName("Test hasPermission(CheckPermissionCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PermissionGroupService.hasPermission(CheckPermissionCommand)"})
  void testHasPermission() {
    // Arrange
    when(permissionGroupDao.getRequiredInvolvements(Mockito.<CheckPermissionCommand>any()))
        .thenReturn(ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build());

    // Act
    boolean actualHasPermissionResult = permissionGroupService.hasPermission(null);

    // Assert
    verify(permissionGroupDao).getRequiredInvolvements(isNull());
    assertTrue(actualHasPermissionResult);
  }

  /**
   * Test {@link PermissionGroupService#hasPermission(CheckPermissionCommand)}.
   *
   * <ul>
   *   <li>Given builder addRequiredInvolvementKindIds one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionGroupService#hasPermission(CheckPermissionCommand)}
   */
  @Test
  @DisplayName(
      "Test hasPermission(CheckPermissionCommand); given builder addRequiredInvolvementKindIds one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PermissionGroupService.hasPermission(CheckPermissionCommand)"})
  void testHasPermission_givenBuilderAddRequiredInvolvementKindIdsOne_thenReturnTrue() {
    // Arrange
    Builder builderResult = ImmutableRequiredInvolvementsResult.builder();
    builderResult.addRequiredInvolvementKindIds(1L);
    when(permissionGroupDao.getRequiredInvolvements(Mockito.<CheckPermissionCommand>any()))
        .thenReturn(builderResult.areAllUsersAllowed(false).build());

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(resultLongSet);

    ImmutableCheckPermissionCommand.Builder operationResult =
        ImmutableCheckPermissionCommand.builder().operation(Operation.ADD);

    // Act
    boolean actualHasPermissionResult =
        permissionGroupService.hasPermission(
            operationResult
                .parentEntityRef(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .qualifierId(1L)
                .qualifierKind(EntityKind.ALL)
                .subjectKind(EntityKind.ALL)
                .user("User")
                .build());

    // Assert
    verify(permissionGroupDao).getRequiredInvolvements(isA(CheckPermissionCommand.class));
    verify(involvementService)
        .findExistingInvolvementKindIdsForUser(isA(EntityReference.class), eq("User"));
    assertTrue(actualHasPermissionResult);
  }

  /**
   * Test {@link PermissionGroupService#hasPermission(CheckPermissionCommand)}.
   *
   * <ul>
   *   <li>Given builder addRequiredInvolvementKindIds three.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionGroupService#hasPermission(CheckPermissionCommand)}
   */
  @Test
  @DisplayName(
      "Test hasPermission(CheckPermissionCommand); given builder addRequiredInvolvementKindIds three; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PermissionGroupService.hasPermission(CheckPermissionCommand)"})
  void testHasPermission_givenBuilderAddRequiredInvolvementKindIdsThree_thenReturnFalse() {
    // Arrange
    Builder builderResult = ImmutableRequiredInvolvementsResult.builder();
    builderResult.addRequiredInvolvementKindIds(3L);
    when(permissionGroupDao.getRequiredInvolvements(Mockito.<CheckPermissionCommand>any()))
        .thenReturn(builderResult.areAllUsersAllowed(false).build());
    when(involvementService.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    ImmutableCheckPermissionCommand.Builder operationResult =
        ImmutableCheckPermissionCommand.builder().operation(Operation.ADD);

    // Act
    boolean actualHasPermissionResult =
        permissionGroupService.hasPermission(
            operationResult
                .parentEntityRef(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .qualifierId(1L)
                .qualifierKind(EntityKind.ALL)
                .subjectKind(EntityKind.ALL)
                .user("User")
                .build());

    // Assert
    verify(permissionGroupDao).getRequiredInvolvements(isA(CheckPermissionCommand.class));
    verify(involvementService)
        .findExistingInvolvementKindIdsForUser(isA(EntityReference.class), eq("User"));
    assertFalse(actualHasPermissionResult);
  }

  /**
   * Test {@link PermissionGroupService#hasPermission(CheckPermissionCommand)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionGroupService#hasPermission(CheckPermissionCommand)}
   */
  @Test
  @DisplayName("Test hasPermission(CheckPermissionCommand); when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PermissionGroupService.hasPermission(CheckPermissionCommand)"})
  void testHasPermission_whenNull_thenReturnFalse() {
    // Arrange
    when(permissionGroupDao.getRequiredInvolvements(Mockito.<CheckPermissionCommand>any()))
        .thenReturn(
            ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(false).build());

    // Act
    boolean actualHasPermissionResult = permissionGroupService.hasPermission(null);

    // Assert
    verify(permissionGroupDao).getRequiredInvolvements(isNull());
    assertFalse(actualHasPermissionResult);
  }

  /**
   * Test {@link PermissionGroupService#findSupportedMeasurableCategoryAttestations(EntityReference,
   * String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * PermissionGroupService#findSupportedMeasurableCategoryAttestations(EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test findSupportedMeasurableCategoryAttestations(EntityReference, String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set PermissionGroupService.findSupportedMeasurableCategoryAttestations(EntityReference, String)"
  })
  void testFindSupportedMeasurableCategoryAttestations_thenReturnEmpty() {
    // Arrange
    when(permissionGroupDao.findSupportedMeasurableCategoryAttestations(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<UserAttestationPermission> actualFindSupportedMeasurableCategoryAttestationsResult =
        permissionGroupService.findSupportedMeasurableCategoryAttestations(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "42");

    // Assert
    verify(permissionGroupDao)
        .findSupportedMeasurableCategoryAttestations(isA(EntityReference.class), eq("42"));
    assertTrue(actualFindSupportedMeasurableCategoryAttestationsResult.isEmpty());
  }
}
