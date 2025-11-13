package org.finos.waltz.service.permission.permission_checker;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PermissionCheckerDiffblueTest {
  @Mock private InvolvementService involvementService;

  @Mock private PermissionGroupService permissionGroupService;

  /**
   * Test {@link PermissionChecker#verifyAnyPerms(Set, Set, EntityKind, String)}.
   *
   * <ul>
   *   <li>Given {@code ADD}.
   *   <li>Then throw {@link InsufficientPrivelegeException}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionChecker#verifyAnyPerms(Set, Set, EntityKind, String)}
   */
  @Test
  @DisplayName(
      "Test verifyAnyPerms(Set, Set, EntityKind, String); given 'ADD'; then throw InsufficientPrivelegeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PermissionChecker.verifyAnyPerms(Set, Set, EntityKind, String)"})
  void testVerifyAnyPerms_givenAdd_thenThrowInsufficientPrivelegeException()
      throws InsufficientPrivelegeException {
    // Arrange
    AllocationPermissionChecker allocationPermissionChecker =
        new AllocationPermissionChecker(
            mock(MeasurableRatingDao.class), permissionGroupService, involvementService);

    HashSet<Operation> possiblePerms = new HashSet<>();
    possiblePerms.add(Operation.ADD);

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class,
        () ->
            allocationPermissionChecker.verifyAnyPerms(
                possiblePerms, new HashSet<>(), EntityKind.ALL, "janedoe"));
  }

  /**
   * Test {@link PermissionChecker#verifyAnyPerms(Set, Set, EntityKind, String)}.
   *
   * <ul>
   *   <li>Given {@code ADD}.
   *   <li>Then throw {@link InsufficientPrivelegeException}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionChecker#verifyAnyPerms(Set, Set, EntityKind, String)}
   */
  @Test
  @DisplayName(
      "Test verifyAnyPerms(Set, Set, EntityKind, String); given 'ADD'; then throw InsufficientPrivelegeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PermissionChecker.verifyAnyPerms(Set, Set, EntityKind, String)"})
  void testVerifyAnyPerms_givenAdd_thenThrowInsufficientPrivelegeException2()
      throws InsufficientPrivelegeException {
    // Arrange
    AllocationPermissionChecker allocationPermissionChecker =
        new AllocationPermissionChecker(
            mock(MeasurableRatingDao.class), permissionGroupService, involvementService);
    HashSet<Operation> possiblePerms = new HashSet<>();

    HashSet<Operation> userPerms = new HashSet<>();
    userPerms.add(Operation.ADD);

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class,
        () ->
            allocationPermissionChecker.verifyAnyPerms(
                possiblePerms, userPerms, EntityKind.ALL, "janedoe"));
  }

  /**
   * Test {@link PermissionChecker#verifyAnyPerms(Set, Set, EntityKind, String)}.
   *
   * <ul>
   *   <li>Given {@code ADD}.
   *   <li>When {@link HashSet#HashSet()} add {@code ADD}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PermissionChecker#verifyAnyPerms(Set, Set, EntityKind, String)}
   */
  @Test
  @DisplayName(
      "Test verifyAnyPerms(Set, Set, EntityKind, String); given 'ADD'; when HashSet() add 'ADD'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PermissionChecker.verifyAnyPerms(Set, Set, EntityKind, String)"})
  void testVerifyAnyPerms_givenAdd_whenHashSetAddAdd_thenDoesNotThrow()
      throws InsufficientPrivelegeException {
    // Arrange
    AllocationPermissionChecker allocationPermissionChecker =
        new AllocationPermissionChecker(
            mock(MeasurableRatingDao.class), permissionGroupService, involvementService);

    HashSet<Operation> possiblePerms = new HashSet<>();
    possiblePerms.add(Operation.ADD);

    HashSet<Operation> userPerms = new HashSet<>();
    userPerms.add(Operation.ADD);

    // Act and Assert
    assertDoesNotThrow(
        () ->
            allocationPermissionChecker.verifyAnyPerms(
                possiblePerms, userPerms, EntityKind.ALL, "janedoe"));
  }

  /**
   * Test {@link PermissionChecker#verifyAnyPerms(Set, Set, EntityKind, String)}.
   *
   * <ul>
   *   <li>Given {@code ATTEST}.
   *   <li>When {@link HashSet#HashSet()} add {@code ATTEST}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionChecker#verifyAnyPerms(Set, Set, EntityKind, String)}
   */
  @Test
  @DisplayName(
      "Test verifyAnyPerms(Set, Set, EntityKind, String); given 'ATTEST'; when HashSet() add 'ATTEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PermissionChecker.verifyAnyPerms(Set, Set, EntityKind, String)"})
  void testVerifyAnyPerms_givenAttest_whenHashSetAddAttest() throws InsufficientPrivelegeException {
    // Arrange
    AllocationPermissionChecker allocationPermissionChecker =
        new AllocationPermissionChecker(
            mock(MeasurableRatingDao.class), permissionGroupService, involvementService);

    HashSet<Operation> possiblePerms = new HashSet<>();
    possiblePerms.add(Operation.ATTEST);
    possiblePerms.add(Operation.ADD);

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class,
        () ->
            allocationPermissionChecker.verifyAnyPerms(
                possiblePerms, new HashSet<>(), EntityKind.ALL, "janedoe"));
  }

  /**
   * Test {@link PermissionChecker#verifyAnyPerms(Set, Set, EntityKind, String)}.
   *
   * <ul>
   *   <li>Given {@code ATTEST}.
   *   <li>When {@link HashSet#HashSet()} add {@code ATTEST}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionChecker#verifyAnyPerms(Set, Set, EntityKind, String)}
   */
  @Test
  @DisplayName(
      "Test verifyAnyPerms(Set, Set, EntityKind, String); given 'ATTEST'; when HashSet() add 'ATTEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PermissionChecker.verifyAnyPerms(Set, Set, EntityKind, String)"})
  void testVerifyAnyPerms_givenAttest_whenHashSetAddAttest2()
      throws InsufficientPrivelegeException {
    // Arrange
    AllocationPermissionChecker allocationPermissionChecker =
        new AllocationPermissionChecker(
            mock(MeasurableRatingDao.class), permissionGroupService, involvementService);
    HashSet<Operation> possiblePerms = new HashSet<>();

    HashSet<Operation> userPerms = new HashSet<>();
    userPerms.add(Operation.ATTEST);
    userPerms.add(Operation.ADD);

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class,
        () ->
            allocationPermissionChecker.verifyAnyPerms(
                possiblePerms, userPerms, EntityKind.ALL, "janedoe"));
  }

  /**
   * Test {@link PermissionChecker#verifyAnyPerms(Set, Set, EntityKind, String)}.
   *
   * <ul>
   *   <li>Given {@link PersonService#PersonService(PersonDao, PersonSearchDao)} with {@link
   *       PersonDao} and {@link PersonSearchDao}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionChecker#verifyAnyPerms(Set, Set, EntityKind, String)}
   */
  @Test
  @DisplayName(
      "Test verifyAnyPerms(Set, Set, EntityKind, String); given PersonService(PersonDao, PersonSearchDao) with PersonDao and PersonSearchDao")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PermissionChecker.verifyAnyPerms(Set, Set, EntityKind, String)"})
  void testVerifyAnyPerms_givenPersonServiceWithPersonDaoAndPersonSearchDao()
      throws InsufficientPrivelegeException {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
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
    InvolvementDao dao2 = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao2 = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService2 =
        new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
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
            userRoleDao, roleDao, personDao2, changeLogService3, personService2, settingsService);

    InvolvementService involvementService2 =
        new InvolvementService(
            changeLogService2,
            dao2,
            logicalFlowDao2,
            physicalFlowDao2,
            entityReferenceNameResolver2,
            involvementKindService2,
            personDao,
            userRoleService);

    AllocationPermissionChecker allocationPermissionChecker =
        new AllocationPermissionChecker(
            measurableRatingDao, permissionGroupService, involvementService2);
    HashSet<Operation> possiblePerms = new HashSet<>();

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class,
        () ->
            allocationPermissionChecker.verifyAnyPerms(
                possiblePerms, new HashSet<>(), EntityKind.ALL, "janedoe"));
  }

  /**
   * Test {@link PermissionChecker#verifyEditPerms(Set, EntityKind, String)}.
   *
   * <ul>
   *   <li>Given {@code ADD}.
   *   <li>When {@link HashSet#HashSet()} add {@code ADD}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PermissionChecker#verifyEditPerms(Set, EntityKind, String)}
   */
  @Test
  @DisplayName(
      "Test verifyEditPerms(Set, EntityKind, String); given 'ADD'; when HashSet() add 'ADD'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PermissionChecker.verifyEditPerms(Set, EntityKind, String)"})
  void testVerifyEditPerms_givenAdd_whenHashSetAddAdd_thenDoesNotThrow()
      throws InsufficientPrivelegeException {
    // Arrange
    AllocationPermissionChecker allocationPermissionChecker =
        new AllocationPermissionChecker(
            mock(MeasurableRatingDao.class), permissionGroupService, involvementService);

    HashSet<Operation> userPerms = new HashSet<>();
    userPerms.add(Operation.ADD);

    // Act and Assert
    assertDoesNotThrow(
        () -> allocationPermissionChecker.verifyEditPerms(userPerms, EntityKind.ALL, "janedoe"));
  }

  /**
   * Test {@link PermissionChecker#verifyEditPerms(Set, EntityKind, String)}.
   *
   * <ul>
   *   <li>Given {@code ATTEST}.
   *   <li>When {@link HashSet#HashSet()} add {@code ATTEST}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PermissionChecker#verifyEditPerms(Set, EntityKind, String)}
   */
  @Test
  @DisplayName(
      "Test verifyEditPerms(Set, EntityKind, String); given 'ATTEST'; when HashSet() add 'ATTEST'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PermissionChecker.verifyEditPerms(Set, EntityKind, String)"})
  void testVerifyEditPerms_givenAttest_whenHashSetAddAttest_thenDoesNotThrow()
      throws InsufficientPrivelegeException {
    // Arrange
    AllocationPermissionChecker allocationPermissionChecker =
        new AllocationPermissionChecker(
            mock(MeasurableRatingDao.class), permissionGroupService, involvementService);

    HashSet<Operation> userPerms = new HashSet<>();
    userPerms.add(Operation.ATTEST);
    userPerms.add(Operation.ADD);

    // Act and Assert
    assertDoesNotThrow(
        () -> allocationPermissionChecker.verifyEditPerms(userPerms, EntityKind.ALL, "janedoe"));
  }

  /**
   * Test {@link PermissionChecker#verifyEditPerms(Set, EntityKind, String)}.
   *
   * <ul>
   *   <li>Then throw {@link InsufficientPrivelegeException}.
   * </ul>
   *
   * <p>Method under test: {@link PermissionChecker#verifyEditPerms(Set, EntityKind, String)}
   */
  @Test
  @DisplayName(
      "Test verifyEditPerms(Set, EntityKind, String); then throw InsufficientPrivelegeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PermissionChecker.verifyEditPerms(Set, EntityKind, String)"})
  void testVerifyEditPerms_thenThrowInsufficientPrivelegeException()
      throws InsufficientPrivelegeException {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
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
    InvolvementDao dao2 = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao2 = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao2 = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService2 =
        new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
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
            userRoleDao, roleDao, personDao2, changeLogService3, personService2, settingsService);

    InvolvementService involvementService2 =
        new InvolvementService(
            changeLogService2,
            dao2,
            logicalFlowDao2,
            physicalFlowDao2,
            entityReferenceNameResolver2,
            involvementKindService2,
            personDao,
            userRoleService);

    AllocationPermissionChecker allocationPermissionChecker =
        new AllocationPermissionChecker(
            measurableRatingDao, permissionGroupService, involvementService2);

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class,
        () ->
            allocationPermissionChecker.verifyEditPerms(
                new HashSet<>(), EntityKind.ALL, "janedoe"));
  }
}
