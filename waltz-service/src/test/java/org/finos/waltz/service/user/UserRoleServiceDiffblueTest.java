package org.finos.waltz.service.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.person.PersonDao;
import org.finos.waltz.data.person.search.PersonSearchDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.role.RoleDao;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.data.user.UserRoleDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.bulk_upload.BulkUploadMode;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.person.ImmutablePerson;
import org.finos.waltz.model.person.PersonKind;
import org.finos.waltz.model.role.ImmutableRole;
import org.finos.waltz.model.role.Role;
import org.finos.waltz.model.settings.ImmutableSetting;
import org.finos.waltz.model.user.BulkUserOperationRowPreview;
import org.finos.waltz.model.user.BulkUserOperationRowPreview.ResolutionStatus;
import org.finos.waltz.model.user.ImmutableBulkUserOperationRowPreview;
import org.finos.waltz.model.user.ImmutableUpdateRolesCommand;
import org.finos.waltz.model.user.ImmutableUser;
import org.finos.waltz.model.user.SystemRole;
import org.finos.waltz.model.user.UpdateRolesCommand;
import org.finos.waltz.model.user.User;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.settings.SettingsService;
import org.jooq.DSLContext;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserRoleServiceDiffblueTest {
  @Mock private ChangeLogService changeLogService;

  @Mock private PersonDao personDao;

  @Mock private PersonService personService;

  @Mock private RoleDao roleDao;

  @Mock private SettingsService settingsService;

  @Mock private UserRoleDao userRoleDao;

  @InjectMocks private UserRoleService userRoleService;

  /**
   * Test {@link UserRoleService#hasRole(String, Set)} with {@code String}, {@code Set}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#hasRole(String, Set)}
   */
  @Test
  @DisplayName(
      "Test hasRole(String, Set) with 'String', 'Set'; given '42'; when HashSet() add '42'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserRoleService.hasRole(String, Set)"})
  void testHasRoleWithStringSet_given42_whenHashSetAdd42_thenReturnFalse() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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

    HashSet<String> requiredRoles = new HashSet<>();
    requiredRoles.add("42");
    requiredRoles.add("foo");

    // Act
    boolean actualHasRoleResult = userRoleService.hasRole("janedoe", requiredRoles);

    // Assert
    verify(userRoleDao).getUserRoles("janedoe");
    assertFalse(actualHasRoleResult);
  }

  /**
   * Test {@link UserRoleService#hasRole(String, Set)} with {@code String}, {@code Set}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#hasRole(String, Set)}
   */
  @Test
  @DisplayName(
      "Test hasRole(String, Set) with 'String', 'Set'; given 'foo'; when HashSet() add 'foo'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserRoleService.hasRole(String, Set)"})
  void testHasRoleWithStringSet_givenFoo_whenHashSetAddFoo_thenReturnFalse() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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

    HashSet<String> requiredRoles = new HashSet<>();
    requiredRoles.add("foo");

    // Act
    boolean actualHasRoleResult = userRoleService.hasRole("janedoe", requiredRoles);

    // Assert
    verify(userRoleDao).getUserRoles("janedoe");
    assertFalse(actualHasRoleResult);
  }

  /**
   * Test {@link UserRoleService#hasRole(String, Set)} with {@code String}, {@code Set}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#hasRole(String, Set)}
   */
  @Test
  @DisplayName(
      "Test hasRole(String, Set) with 'String', 'Set'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserRoleService.hasRole(String, Set)"})
  void testHasRoleWithStringSet_thenThrowIllegalArgumentException() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
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

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> userRoleService.hasRole("janedoe", new HashSet<>()));
    verify(userRoleDao).getUserRoles("janedoe");
  }

  /**
   * Test {@link UserRoleService#hasRole(String, Set)} with {@code String}, {@code Set}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#hasRole(String, Set)}
   */
  @Test
  @DisplayName("Test hasRole(String, Set) with 'String', 'Set'; when HashSet(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserRoleService.hasRole(String, Set)"})
  void testHasRoleWithStringSet_whenHashSet_thenReturnTrue() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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

    // Act
    boolean actualHasRoleResult = userRoleService.hasRole("janedoe", new HashSet<>());

    // Assert
    verify(userRoleDao).getUserRoles("janedoe");
    assertTrue(actualHasRoleResult);
  }

  /**
   * Test {@link UserRoleService#hasRole(String, String[])} with {@code String}, {@code String[]}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#hasRole(String, String[])}
   */
  @Test
  @DisplayName("Test hasRole(String, String[]) with 'String', 'String[]'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserRoleService.hasRole(String, String[])"})
  void testHasRoleWithStringString_thenReturnTrue() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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

    // Act
    boolean actualHasRoleResult = userRoleService.hasRole("janedoe", new String[] {});

    // Assert
    verify(userRoleDao).getUserRoles("janedoe");
    assertTrue(actualHasRoleResult);
  }

  /**
   * Test {@link UserRoleService#hasRole(String, String[])} with {@code String}, {@code String[]}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#hasRole(String, String[])}
   */
  @Test
  @DisplayName(
      "Test hasRole(String, String[]) with 'String', 'String[]'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserRoleService.hasRole(String, String[])"})
  void testHasRoleWithStringString_thenThrowIllegalArgumentException() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
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

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> userRoleService.hasRole("janedoe", "Required Roles"));
    verify(userRoleDao).getUserRoles("janedoe");
  }

  /**
   * Test {@link UserRoleService#hasRole(String, String[])} with {@code String}, {@code String[]}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#hasRole(String, String[])}
   */
  @Test
  @DisplayName(
      "Test hasRole(String, String[]) with 'String', 'String[]'; when 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserRoleService.hasRole(String, String[])"})
  void testHasRoleWithStringString_whenNull_thenReturnTrue() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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

    // Act
    boolean actualHasRoleResult = userRoleService.hasRole("janedoe", (String[]) null);

    // Assert
    verify(userRoleDao).getUserRoles("janedoe");
    assertTrue(actualHasRoleResult);
  }

  /**
   * Test {@link UserRoleService#hasRole(String, String[])} with {@code String}, {@code String[]}.
   *
   * <ul>
   *   <li>When {@code Required Roles}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#hasRole(String, String[])}
   */
  @Test
  @DisplayName(
      "Test hasRole(String, String[]) with 'String', 'String[]'; when 'Required Roles'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserRoleService.hasRole(String, String[])"})
  void testHasRoleWithStringString_whenRequiredRoles_thenReturnFalse() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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

    // Act
    boolean actualHasRoleResult = userRoleService.hasRole("janedoe", "Required Roles");

    // Assert
    verify(userRoleDao).getUserRoles("janedoe");
    assertFalse(actualHasRoleResult);
  }

  /**
   * Test {@link UserRoleService#hasRole(String, SystemRole[])} with {@code String}, {@code
   * SystemRole[]}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#hasRole(String, SystemRole[])}
   */
  @Test
  @DisplayName(
      "Test hasRole(String, SystemRole[]) with 'String', 'SystemRole[]'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserRoleService.hasRole(String, SystemRole[])"})
  void testHasRoleWithStringSystemRole_thenReturnTrue() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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

    // Act
    boolean actualHasRoleResult = userRoleService.hasRole("janedoe", new SystemRole[] {});

    // Assert
    verify(userRoleDao).getUserRoles("janedoe");
    assertTrue(actualHasRoleResult);
  }

  /**
   * Test {@link UserRoleService#hasRole(String, SystemRole[])} with {@code String}, {@code
   * SystemRole[]}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#hasRole(String, SystemRole[])}
   */
  @Test
  @DisplayName(
      "Test hasRole(String, SystemRole[]) with 'String', 'SystemRole[]'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserRoleService.hasRole(String, SystemRole[])"})
  void testHasRoleWithStringSystemRole_thenThrowIllegalArgumentException() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
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

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> userRoleService.hasRole("janedoe", SystemRole.ACTOR_ADMIN));
    verify(userRoleDao).getUserRoles("janedoe");
  }

  /**
   * Test {@link UserRoleService#hasRole(String, SystemRole[])} with {@code String}, {@code
   * SystemRole[]}.
   *
   * <ul>
   *   <li>When {@code ACTOR_ADMIN}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#hasRole(String, SystemRole[])}
   */
  @Test
  @DisplayName(
      "Test hasRole(String, SystemRole[]) with 'String', 'SystemRole[]'; when 'ACTOR_ADMIN'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserRoleService.hasRole(String, SystemRole[])"})
  void testHasRoleWithStringSystemRole_whenActorAdmin_thenReturnFalse() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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

    // Act
    boolean actualHasRoleResult = userRoleService.hasRole("janedoe", SystemRole.ACTOR_ADMIN);

    // Assert
    verify(userRoleDao).getUserRoles("janedoe");
    assertFalse(actualHasRoleResult);
  }

  /**
   * Test {@link UserRoleService#hasRole(String, SystemRole[])} with {@code String}, {@code
   * SystemRole[]}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#hasRole(String, SystemRole[])}
   */
  @Test
  @DisplayName(
      "Test hasRole(String, SystemRole[]) with 'String', 'SystemRole[]'; when 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserRoleService.hasRole(String, SystemRole[])"})
  void testHasRoleWithStringSystemRole_whenNull_thenReturnTrue() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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

    // Act
    boolean actualHasRoleResult = userRoleService.hasRole("janedoe", (SystemRole[]) null);

    // Assert
    verify(userRoleDao).getUserRoles("janedoe");
    assertTrue(actualHasRoleResult);
  }

  /**
   * Test {@link UserRoleService#hasAnyRole(String, Set)} with {@code String}, {@code Set}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code foo}.
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#hasAnyRole(String, Set)}
   */
  @Test
  @DisplayName(
      "Test hasAnyRole(String, Set) with 'String', 'Set'; given HashSet() add 'foo'; when HashSet() add 'foo'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserRoleService.hasAnyRole(String, Set)"})
  void testHasAnyRoleWithStringSet_givenHashSetAddFoo_whenHashSetAddFoo_thenReturnTrue() {
    // Arrange
    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");

    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(stringSet);
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

    HashSet<String> requiredRoles = new HashSet<>();
    requiredRoles.add("foo");
    requiredRoles.add("ys cannot be null");
    requiredRoles.add("xs cannot be null");

    // Act
    boolean actualHasAnyRoleResult = userRoleService.hasAnyRole("janedoe", requiredRoles);

    // Assert
    verify(userRoleDao).getUserRoles("janedoe");
    assertTrue(actualHasAnyRoleResult);
  }

  /**
   * Test {@link UserRoleService#hasAnyRole(String, Set)} with {@code String}, {@code Set}.
   *
   * <ul>
   *   <li>Given {@code xs cannot be null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#hasAnyRole(String, Set)}
   */
  @Test
  @DisplayName(
      "Test hasAnyRole(String, Set) with 'String', 'Set'; given 'xs cannot be null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserRoleService.hasAnyRole(String, Set)"})
  void testHasAnyRoleWithStringSet_givenXsCannotBeNull_thenReturnFalse() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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

    HashSet<String> requiredRoles = new HashSet<>();
    requiredRoles.add("xs cannot be null");

    // Act
    boolean actualHasAnyRoleResult = userRoleService.hasAnyRole("janedoe", requiredRoles);

    // Assert
    verify(userRoleDao).getUserRoles("janedoe");
    assertFalse(actualHasAnyRoleResult);
  }

  /**
   * Test {@link UserRoleService#hasAnyRole(String, Set)} with {@code String}, {@code Set}.
   *
   * <ul>
   *   <li>Given {@code ys cannot be null}.
   *   <li>When {@link HashSet#HashSet()} add {@code ys cannot be null}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#hasAnyRole(String, Set)}
   */
  @Test
  @DisplayName(
      "Test hasAnyRole(String, Set) with 'String', 'Set'; given 'ys cannot be null'; when HashSet() add 'ys cannot be null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserRoleService.hasAnyRole(String, Set)"})
  void testHasAnyRoleWithStringSet_givenYsCannotBeNull_whenHashSetAddYsCannotBeNull() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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

    HashSet<String> requiredRoles = new HashSet<>();
    requiredRoles.add("ys cannot be null");
    requiredRoles.add("xs cannot be null");

    // Act
    boolean actualHasAnyRoleResult = userRoleService.hasAnyRole("janedoe", requiredRoles);

    // Assert
    verify(userRoleDao).getUserRoles("janedoe");
    assertFalse(actualHasAnyRoleResult);
  }

  /**
   * Test {@link UserRoleService#hasAnyRole(String, Set)} with {@code String}, {@code Set}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#hasAnyRole(String, Set)}
   */
  @Test
  @DisplayName(
      "Test hasAnyRole(String, Set) with 'String', 'Set'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserRoleService.hasAnyRole(String, Set)"})
  void testHasAnyRoleWithStringSet_thenThrowIllegalArgumentException() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
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

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> userRoleService.hasAnyRole("janedoe", new HashSet<>()));
    verify(userRoleDao).getUserRoles("janedoe");
  }

  /**
   * Test {@link UserRoleService#hasAnyRole(String, Set)} with {@code String}, {@code Set}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#hasAnyRole(String, Set)}
   */
  @Test
  @DisplayName(
      "Test hasAnyRole(String, Set) with 'String', 'Set'; when HashSet(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserRoleService.hasAnyRole(String, Set)"})
  void testHasAnyRoleWithStringSet_whenHashSet_thenReturnFalse() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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

    // Act
    boolean actualHasAnyRoleResult = userRoleService.hasAnyRole("janedoe", new HashSet<>());

    // Assert
    verify(userRoleDao).getUserRoles("janedoe");
    assertFalse(actualHasAnyRoleResult);
  }

  /**
   * Test {@link UserRoleService#hasAnyRole(String, SystemRole[])} with {@code String}, {@code
   * SystemRole[]}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#hasAnyRole(String, SystemRole[])}
   */
  @Test
  @DisplayName(
      "Test hasAnyRole(String, SystemRole[]) with 'String', 'SystemRole[]'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserRoleService.hasAnyRole(String, SystemRole[])"})
  void testHasAnyRoleWithStringSystemRole_thenReturnFalse() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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

    // Act
    boolean actualHasAnyRoleResult = userRoleService.hasAnyRole("janedoe");

    // Assert
    verify(userRoleDao).getUserRoles("janedoe");
    assertFalse(actualHasAnyRoleResult);
  }

  /**
   * Test {@link UserRoleService#hasAnyRole(String, SystemRole[])} with {@code String}, {@code
   * SystemRole[]}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#hasAnyRole(String, SystemRole[])}
   */
  @Test
  @DisplayName(
      "Test hasAnyRole(String, SystemRole[]) with 'String', 'SystemRole[]'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserRoleService.hasAnyRole(String, SystemRole[])"})
  void testHasAnyRoleWithStringSystemRole_thenThrowIllegalArgumentException() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
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

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> userRoleService.hasAnyRole("janedoe", SystemRole.ACTOR_ADMIN));
    verify(userRoleDao).getUserRoles("janedoe");
  }

  /**
   * Test {@link UserRoleService#hasAnyRole(String, SystemRole[])} with {@code String}, {@code
   * SystemRole[]}.
   *
   * <ul>
   *   <li>When {@code ACTOR_ADMIN}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#hasAnyRole(String, SystemRole[])}
   */
  @Test
  @DisplayName(
      "Test hasAnyRole(String, SystemRole[]) with 'String', 'SystemRole[]'; when 'ACTOR_ADMIN'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserRoleService.hasAnyRole(String, SystemRole[])"})
  void testHasAnyRoleWithStringSystemRole_whenActorAdmin_thenReturnFalse() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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

    // Act
    boolean actualHasAnyRoleResult = userRoleService.hasAnyRole("janedoe", SystemRole.ACTOR_ADMIN);

    // Assert
    verify(userRoleDao).getUserRoles("janedoe");
    assertFalse(actualHasAnyRoleResult);
  }

  /**
   * Test {@link UserRoleService#hasAnyRole(String, SystemRole[])} with {@code String}, {@code
   * SystemRole[]}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#hasAnyRole(String, SystemRole[])}
   */
  @Test
  @DisplayName(
      "Test hasAnyRole(String, SystemRole[]) with 'String', 'SystemRole[]'; when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserRoleService.hasAnyRole(String, SystemRole[])"})
  void testHasAnyRoleWithStringSystemRole_whenNull_thenReturnFalse() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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

    // Act
    boolean actualHasAnyRoleResult = userRoleService.hasAnyRole("janedoe", (SystemRole[]) null);

    // Assert
    verify(userRoleDao).getUserRoles("janedoe");
    assertFalse(actualHasAnyRoleResult);
  }

  /**
   * Test {@link UserRoleService#findAllUsers()}.
   *
   * <ul>
   *   <li>Given {@link UserRoleDao} {@link UserRoleDao#findAllUsers()} return {@link
   *       HashSet#HashSet()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#findAllUsers()}
   */
  @Test
  @DisplayName(
      "Test findAllUsers(); given UserRoleDao findAllUsers() return HashSet(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set UserRoleService.findAllUsers()"})
  void testFindAllUsers_givenUserRoleDaoFindAllUsersReturnHashSet_thenReturnEmpty() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.findAllUsers()).thenReturn(new HashSet<>());
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

    // Act
    Set<User> actualFindAllUsersResult = userRoleService.findAllUsers();

    // Assert
    verify(userRoleDao).findAllUsers();
    assertTrue(actualFindAllUsersResult.isEmpty());
  }

  /**
   * Test {@link UserRoleService#findAllUsers()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#findAllUsers()}
   */
  @Test
  @DisplayName("Test findAllUsers(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set UserRoleService.findAllUsers()"})
  void testFindAllUsers_thenThrowIllegalArgumentException() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.findAllUsers()).thenThrow(new IllegalArgumentException());
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

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> userRoleService.findAllUsers());
    verify(userRoleDao).findAllUsers();
  }

  /**
   * Test {@link UserRoleService#findUsersForRole(Long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#findUsersForRole(Long)}
   */
  @Test
  @DisplayName("Test findUsersForRole(Long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set UserRoleService.findUsersForRole(Long)"})
  void testFindUsersForRole_thenReturnEmpty() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.findUsersForRole(Mockito.<Long>any())).thenReturn(new HashSet<>());
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

    // Act
    Set<User> actualFindUsersForRoleResult = userRoleService.findUsersForRole(1L);

    // Assert
    verify(userRoleDao).findUsersForRole(1L);
    assertTrue(actualFindUsersForRoleResult.isEmpty());
  }

  /**
   * Test {@link UserRoleService#findUsersForRole(Long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#findUsersForRole(Long)}
   */
  @Test
  @DisplayName("Test findUsersForRole(Long); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set UserRoleService.findUsersForRole(Long)"})
  void testFindUsersForRole_thenThrowIllegalArgumentException() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.findUsersForRole(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());
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

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> userRoleService.findUsersForRole(1L));
    verify(userRoleDao).findUsersForRole(1L);
  }

  /**
   * Test {@link UserRoleService#getByUserId(String)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code roles element}.
   *   <li>Then return roles is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#getByUserId(String)}
   */
  @Test
  @DisplayName(
      "Test getByUserId(String); given HashSet() add 'roles element'; then return roles is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"User UserRoleService.getByUserId(String)"})
  void testGetByUserId_givenHashSetAddRolesElement_thenReturnRolesIsHashSet() {
    // Arrange
    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("roles element");
    stringSet.add("userName");

    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(stringSet);
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

    // Act
    User actualByUserId = userRoleService.getByUserId("42");

    // Assert
    verify(userRoleDao).getUserRoles("42");
    assertTrue(actualByUserId instanceof ImmutableUser);
    assertEquals(stringSet, actualByUserId.roles());
  }

  /**
   * Test {@link UserRoleService#getByUserId(String)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code userName}.
   *   <li>Then return roles size is one.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#getByUserId(String)}
   */
  @Test
  @DisplayName(
      "Test getByUserId(String); given HashSet() add 'userName'; then return roles size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"User UserRoleService.getByUserId(String)"})
  void testGetByUserId_givenHashSetAddUserName_thenReturnRolesSizeIsOne() {
    // Arrange
    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("userName");

    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(stringSet);
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

    // Act
    User actualByUserId = userRoleService.getByUserId("42");

    // Assert
    verify(userRoleDao).getUserRoles("42");
    assertTrue(actualByUserId instanceof ImmutableUser);
    assertEquals("42", actualByUserId.userName());
    Set<String> rolesResult = actualByUserId.roles();
    assertEquals(1, rolesResult.size());
    assertTrue(rolesResult.contains("userName"));
  }

  /**
   * Test {@link UserRoleService#getByUserId(String)}.
   *
   * <ul>
   *   <li>Given {@link UserRoleDao} {@link UserRoleDao#getUserRoles(String)} return {@link
   *       HashSet#HashSet()}.
   *   <li>Then return roles Empty.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#getByUserId(String)}
   */
  @Test
  @DisplayName(
      "Test getByUserId(String); given UserRoleDao getUserRoles(String) return HashSet(); then return roles Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"User UserRoleService.getByUserId(String)"})
  void testGetByUserId_givenUserRoleDaoGetUserRolesReturnHashSet_thenReturnRolesEmpty() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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

    // Act
    User actualByUserId = userRoleService.getByUserId("42");

    // Assert
    verify(userRoleDao).getUserRoles("42");
    assertTrue(actualByUserId instanceof ImmutableUser);
    assertEquals("42", actualByUserId.userName());
    assertTrue(actualByUserId.roles().isEmpty());
  }

  /**
   * Test {@link UserRoleService#getByUserId(String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#getByUserId(String)}
   */
  @Test
  @DisplayName("Test getByUserId(String); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"User UserRoleService.getByUserId(String)"})
  void testGetByUserId_thenThrowIllegalArgumentException() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
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

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> userRoleService.getByUserId("42"));
    verify(userRoleDao).getUserRoles("42");
  }

  /**
   * Test {@link UserRoleService#updateRoles(String, String, UpdateRolesCommand)}.
   *
   * <p>Method under test: {@link UserRoleService#updateRoles(String, String, UpdateRolesCommand)}
   */
  @Test
  @DisplayName("Test updateRoles(String, String, UpdateRolesCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleService.updateRoles(String, String, UpdateRolesCommand)"})
  void testUpdateRoles() throws IllegalArgumentException {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.updateRoles(Mockito.<String>any(), Mockito.<Set<String>>any())).thenReturn(1);

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

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

    SettingsService settingsService = mock(SettingsService.class);
    Optional<String> ofResult = Optional.of("42");
    when(settingsService.getValue(Mockito.<String>any())).thenReturn(ofResult);

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao,
            mock(RoleDao.class),
            mock(PersonDao.class),
            changeLogService,
            personService,
            settingsService);

    // Act
    int actualUpdateRolesResult =
        userRoleService.updateRoles(
            "janedoe", "janedoe", ImmutableUpdateRolesCommand.builder().comment("Comment").build());

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(userRoleDao).updateRoles(eq("janedoe"), isA(Set.class));
    verify(personService).getPersonByUserId("janedoe");
    verify(settingsService).getValue("feature.user-roles.disable-self-role-mgmt");
    assertEquals(1, actualUpdateRolesResult);
  }

  /**
   * Test {@link UserRoleService#updateRoles(String, String, UpdateRolesCommand)}.
   *
   * <p>Method under test: {@link UserRoleService#updateRoles(String, String, UpdateRolesCommand)}
   */
  @Test
  @DisplayName("Test updateRoles(String, String, UpdateRolesCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleService.updateRoles(String, String, UpdateRolesCommand)"})
  void testUpdateRoles2() throws IllegalArgumentException {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.updateRoles(Mockito.<String>any(), Mockito.<Set<String>>any())).thenReturn(1);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

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

    SettingsService settingsService = mock(SettingsService.class);
    Optional<String> ofResult = Optional.of("42");
    when(settingsService.getValue(Mockito.<String>any())).thenReturn(ofResult);

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao,
            mock(RoleDao.class),
            mock(PersonDao.class),
            changeLogService,
            personService,
            settingsService);

    // Act
    int actualUpdateRolesResult =
        userRoleService.updateRoles(
            "janedoe", "janedoe", ImmutableUpdateRolesCommand.builder().comment("Comment").build());

    // Assert
    verify(userRoleDao).updateRoles(eq("janedoe"), isA(Set.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(personService).getPersonByUserId("janedoe");
    verify(settingsService).getValue("feature.user-roles.disable-self-role-mgmt");
    assertEquals(1, actualUpdateRolesResult);
  }

  /**
   * Test {@link UserRoleService#updateRoles(String, String, UpdateRolesCommand)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#updateRoles(String, String, UpdateRolesCommand)}
   */
  @Test
  @DisplayName(
      "Test updateRoles(String, String, UpdateRolesCommand); given ChangeLogService write(ChangeLog) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleService.updateRoles(String, String, UpdateRolesCommand)"})
  void testUpdateRoles_givenChangeLogServiceWriteThrowIllegalArgumentException()
      throws IllegalArgumentException {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new IllegalArgumentException());
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
    Optional<String> ofResult = Optional.of("42");
    when(settingsService.getValue(Mockito.<String>any())).thenReturn(ofResult);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            userRoleService.updateRoles(
                "janedoe",
                "janedoe",
                ImmutableUpdateRolesCommand.builder().comment("Comment").build()));
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(personService).getPersonByUserId("janedoe");
    verify(settingsService).getValue("feature.user-roles.disable-self-role-mgmt");
  }

  /**
   * Test {@link UserRoleService#updateRoles(String, String, UpdateRolesCommand)}.
   *
   * <ul>
   *   <li>Given {@link PersonService} {@link PersonService#getPersonByUserId(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#updateRoles(String, String, UpdateRolesCommand)}
   */
  @Test
  @DisplayName(
      "Test updateRoles(String, String, UpdateRolesCommand); given PersonService getPersonByUserId(String) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleService.updateRoles(String, String, UpdateRolesCommand)"})
  void testUpdateRoles_givenPersonServiceGetPersonByUserIdThrowIllegalArgumentException()
      throws IllegalArgumentException {
    // Arrange
    when(personService.getPersonByUserId(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            userRoleService.updateRoles(
                "janedoe",
                "janedoe",
                ImmutableUpdateRolesCommand.builder().comment("Comment").build()));
    verify(personService).getPersonByUserId("janedoe");
  }

  /**
   * Test {@link UserRoleService#updateRoles(String, String, UpdateRolesCommand)}.
   *
   * <ul>
   *   <li>Given {@link SettingsService} {@link SettingsService#getValue(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#updateRoles(String, String, UpdateRolesCommand)}
   */
  @Test
  @DisplayName(
      "Test updateRoles(String, String, UpdateRolesCommand); given SettingsService getValue(String) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleService.updateRoles(String, String, UpdateRolesCommand)"})
  void testUpdateRoles_givenSettingsServiceGetValueThrowIllegalArgumentException()
      throws IllegalArgumentException {
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
    when(settingsService.getValue(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            userRoleService.updateRoles(
                "janedoe",
                "janedoe",
                ImmutableUpdateRolesCommand.builder().comment("Comment").build()));
    verify(personService).getPersonByUserId("janedoe");
    verify(settingsService).getValue("feature.user-roles.disable-self-role-mgmt");
  }

  /**
   * Test {@link UserRoleService#updateRoles(String, String, UpdateRolesCommand)}.
   *
   * <ul>
   *   <li>Then calls {@link PersonDao#getByUserEmail(String)}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#updateRoles(String, String, UpdateRolesCommand)}
   */
  @Test
  @DisplayName(
      "Test updateRoles(String, String, UpdateRolesCommand); then calls getByUserEmail(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleService.updateRoles(String, String, UpdateRolesCommand)"})
  void testUpdateRoles_thenCallsGetByUserEmail() throws IllegalArgumentException {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.updateRoles(Mockito.<String>any(), Mockito.<Set<String>>any())).thenReturn(1);

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

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

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any()))
        .thenReturn(
            ImmutableSetting.builder()
                .description("The characteristics of someone or something")
                .name("Name")
                .value("42")
                .build());
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao,
            mock(RoleDao.class),
            mock(PersonDao.class),
            changeLogService,
            personService,
            settingsService);

    // Act
    int actualUpdateRolesResult =
        userRoleService.updateRoles(
            "janedoe", "janedoe", ImmutableUpdateRolesCommand.builder().comment("Comment").build());

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(personDao).getByUserEmail("janedoe");
    verify(settingsDao).getByName("feature.user-roles.disable-self-role-mgmt");
    verify(userRoleDao).updateRoles(eq("janedoe"), isA(Set.class));
    assertEquals(1, actualUpdateRolesResult);
  }

  /**
   * Test {@link UserRoleService#updateRoles(String, String, UpdateRolesCommand)}.
   *
   * <ul>
   *   <li>When builder comment empty string build.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#updateRoles(String, String, UpdateRolesCommand)}
   */
  @Test
  @DisplayName(
      "Test updateRoles(String, String, UpdateRolesCommand); when builder comment empty string build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleService.updateRoles(String, String, UpdateRolesCommand)"})
  void testUpdateRoles_whenBuilderCommentEmptyStringBuild() throws IllegalArgumentException {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.updateRoles(Mockito.<String>any(), Mockito.<Set<String>>any())).thenReturn(1);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

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

    SettingsService settingsService = mock(SettingsService.class);
    Optional<String> ofResult = Optional.of("42");
    when(settingsService.getValue(Mockito.<String>any())).thenReturn(ofResult);

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao,
            mock(RoleDao.class),
            mock(PersonDao.class),
            changeLogService,
            personService,
            settingsService);

    // Act
    int actualUpdateRolesResult =
        userRoleService.updateRoles(
            "janedoe", "janedoe", ImmutableUpdateRolesCommand.builder().comment("").build());

    // Assert
    verify(userRoleDao).updateRoles(eq("janedoe"), isA(Set.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(personService).getPersonByUserId("janedoe");
    verify(settingsService).getValue("feature.user-roles.disable-self-role-mgmt");
    assertEquals(1, actualUpdateRolesResult);
  }

  /**
   * Test {@link UserRoleService#updateRoles(String, String, UpdateRolesCommand)}.
   *
   * <ul>
   *   <li>When builder comment {@code null} build.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#updateRoles(String, String, UpdateRolesCommand)}
   */
  @Test
  @DisplayName(
      "Test updateRoles(String, String, UpdateRolesCommand); when builder comment 'null' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleService.updateRoles(String, String, UpdateRolesCommand)"})
  void testUpdateRoles_whenBuilderCommentNullBuild() throws IllegalArgumentException {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.updateRoles(Mockito.<String>any(), Mockito.<Set<String>>any())).thenReturn(1);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

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

    SettingsService settingsService = mock(SettingsService.class);
    Optional<String> ofResult = Optional.of("42");
    when(settingsService.getValue(Mockito.<String>any())).thenReturn(ofResult);

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao,
            mock(RoleDao.class),
            mock(PersonDao.class),
            changeLogService,
            personService,
            settingsService);

    // Act
    int actualUpdateRolesResult =
        userRoleService.updateRoles(
            "janedoe", "janedoe", ImmutableUpdateRolesCommand.builder().comment(null).build());

    // Assert
    verify(userRoleDao).updateRoles(eq("janedoe"), isA(Set.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(personService).getPersonByUserId("janedoe");
    verify(settingsService).getValue("feature.user-roles.disable-self-role-mgmt");
    assertEquals(1, actualUpdateRolesResult);
  }

  /**
   * Test {@link UserRoleService#updateRoles(String, String, UpdateRolesCommand)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#updateRoles(String, String, UpdateRolesCommand)}
   */
  @Test
  @DisplayName("Test updateRoles(String, String, UpdateRolesCommand); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleService.updateRoles(String, String, UpdateRolesCommand)"})
  void testUpdateRoles_whenNull() throws IllegalArgumentException {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.updateRoles(Mockito.<String>any(), Mockito.<Set<String>>any())).thenReturn(1);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

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

    SettingsService settingsService = mock(SettingsService.class);
    Optional<String> ofResult = Optional.of("42");
    when(settingsService.getValue(Mockito.<String>any())).thenReturn(ofResult);

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao,
            mock(RoleDao.class),
            mock(PersonDao.class),
            changeLogService,
            personService,
            settingsService);

    // Act
    int actualUpdateRolesResult =
        userRoleService.updateRoles(
            "janedoe", null, ImmutableUpdateRolesCommand.builder().comment("Comment").build());

    // Assert
    verify(userRoleDao).updateRoles(isNull(), isA(Set.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(personService).getPersonByUserId(null);
    verify(settingsService).getValue("feature.user-roles.disable-self-role-mgmt");
    assertEquals(1, actualUpdateRolesResult);
  }

  /**
   * Test {@link UserRoleService#getUserRoles(String)}.
   *
   * <ul>
   *   <li>Given {@link UserRoleDao} {@link UserRoleDao#getUserRoles(String)} return {@link
   *       HashSet#HashSet()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#getUserRoles(String)}
   */
  @Test
  @DisplayName(
      "Test getUserRoles(String); given UserRoleDao getUserRoles(String) return HashSet(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set UserRoleService.getUserRoles(String)"})
  void testGetUserRoles_givenUserRoleDaoGetUserRolesReturnHashSet_thenReturnEmpty() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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

    // Act
    Set<String> actualUserRoles = userRoleService.getUserRoles("janedoe");

    // Assert
    verify(userRoleDao).getUserRoles("janedoe");
    assertTrue(actualUserRoles.isEmpty());
  }

  /**
   * Test {@link UserRoleService#getUserRoles(String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#getUserRoles(String)}
   */
  @Test
  @DisplayName("Test getUserRoles(String); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set UserRoleService.getUserRoles(String)"})
  void testGetUserRoles_thenThrowIllegalArgumentException() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
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

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> userRoleService.getUserRoles("janedoe"));
    verify(userRoleDao).getUserRoles("janedoe");
  }

  /**
   * Test {@link UserRoleService#bulkUploadPreview(BulkUploadMode, List, String)}.
   *
   * <p>Method under test: {@link UserRoleService#bulkUploadPreview(BulkUploadMode, List, String)}
   */
  @Test
  @DisplayName("Test bulkUploadPreview(BulkUploadMode, List, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserRoleService.bulkUploadPreview(BulkUploadMode, List, String)"})
  void testBulkUploadPreview() {
    // Arrange
    HashSet<Role> roleSet = new HashSet<>();
    roleSet.add(
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("Name")
            .build());

    RoleDao roleDao = mock(RoleDao.class);
    when(roleDao.findAllRoles()).thenReturn(roleSet);

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findAllEmails()).thenReturn(new ArrayList<>());

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any()))
        .thenReturn(
            ImmutableSetting.builder()
                .description("The characteristics of someone or something")
                .name("Name")
                .value("42")
                .build());
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
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

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    ArrayList<String> lines = new ArrayList<>();
    lines.add("foo");

    // Act
    List<BulkUserOperationRowPreview> actualBulkUploadPreviewResult =
        userRoleService.bulkUploadPreview(BulkUploadMode.ADD_ONLY, lines, "janedoe");

    // Assert
    verify(personDao).findAllEmails();
    verify(roleDao).findAllRoles();
    verify(settingsDao).getByName("feature.user-roles.disable-self-role-mgmt");
    assertEquals(1, actualBulkUploadPreviewResult.size());
    BulkUserOperationRowPreview getResult = actualBulkUploadPreviewResult.get(0);
    assertTrue(getResult instanceof ImmutableBulkUserOperationRowPreview);
    assertEquals("foo", getResult.givenUser());
    assertNull(getResult.givenRole());
    assertNull(getResult.resolvedUser());
  }

  /**
   * Test {@link UserRoleService#bulkUploadPreview(BulkUploadMode, List, String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return first resolvedUser is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#bulkUploadPreview(BulkUploadMode, List, String)}
   */
  @Test
  @DisplayName(
      "Test bulkUploadPreview(BulkUploadMode, List, String); given ArrayList() add 'foo'; then return first resolvedUser is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserRoleService.bulkUploadPreview(BulkUploadMode, List, String)"})
  void testBulkUploadPreview_givenArrayListAddFoo_thenReturnFirstResolvedUserIsFoo() {
    // Arrange
    RoleDao roleDao = mock(RoleDao.class);
    when(roleDao.findAllRoles()).thenReturn(new HashSet<>());

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    stringList.addAll(new ArrayList<>());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findAllEmails()).thenReturn(stringList);

    SettingsService settingsService = mock(SettingsService.class);
    Optional<String> ofResult = Optional.of("42");
    when(settingsService.getValue(Mockito.<String>any())).thenReturn(ofResult);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
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

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    ArrayList<String> lines = new ArrayList<>();
    lines.add("foo");

    // Act
    List<BulkUserOperationRowPreview> actualBulkUploadPreviewResult =
        userRoleService.bulkUploadPreview(BulkUploadMode.ADD_ONLY, lines, "janedoe");

    // Assert
    verify(personDao).findAllEmails();
    verify(roleDao).findAllRoles();
    verify(settingsService).getValue("feature.user-roles.disable-self-role-mgmt");
    assertEquals(1, actualBulkUploadPreviewResult.size());
    BulkUserOperationRowPreview getResult = actualBulkUploadPreviewResult.get(0);
    assertTrue(getResult instanceof ImmutableBulkUserOperationRowPreview);
    assertEquals("foo", getResult.givenUser());
    assertEquals("foo", getResult.resolvedUser());
    assertNull(getResult.givenRole());
  }

  /**
   * Test {@link UserRoleService#bulkUploadPreview(BulkUploadMode, List, String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code (,|\t)}.
   *   <li>Then return first givenUser is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#bulkUploadPreview(BulkUploadMode, List, String)}
   */
  @Test
  @DisplayName(
      "Test bulkUploadPreview(BulkUploadMode, List, String); given ArrayList() add '(,|\\t)'; then return first givenUser is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserRoleService.bulkUploadPreview(BulkUploadMode, List, String)"})
  void testBulkUploadPreview_givenArrayListAddT_thenReturnFirstGivenUserIsFoo() {
    // Arrange
    RoleDao roleDao = mock(RoleDao.class);
    when(roleDao.findAllRoles()).thenReturn(new HashSet<>());

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("(,|\\t)");

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findAllEmails()).thenReturn(stringList);

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any()))
        .thenReturn(
            ImmutableSetting.builder()
                .description("The characteristics of someone or something")
                .name("Name")
                .value("42")
                .build());
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
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

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    ArrayList<String> lines = new ArrayList<>();
    lines.add("foo");

    // Act
    List<BulkUserOperationRowPreview> actualBulkUploadPreviewResult =
        userRoleService.bulkUploadPreview(BulkUploadMode.ADD_ONLY, lines, "janedoe");

    // Assert
    verify(personDao).findAllEmails();
    verify(roleDao).findAllRoles();
    verify(settingsDao).getByName("feature.user-roles.disable-self-role-mgmt");
    assertEquals(1, actualBulkUploadPreviewResult.size());
    BulkUserOperationRowPreview getResult = actualBulkUploadPreviewResult.get(0);
    assertTrue(getResult instanceof ImmutableBulkUserOperationRowPreview);
    assertEquals("foo", getResult.givenUser());
    assertNull(getResult.givenRole());
    assertNull(getResult.resolvedUser());
  }

  /**
   * Test {@link UserRoleService#bulkUploadPreview(BulkUploadMode, List, String)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link ArrayList#ArrayList()} add empty string.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#bulkUploadPreview(BulkUploadMode, List, String)}
   */
  @Test
  @DisplayName(
      "Test bulkUploadPreview(BulkUploadMode, List, String); given empty string; when ArrayList() add empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserRoleService.bulkUploadPreview(BulkUploadMode, List, String)"})
  void testBulkUploadPreview_givenEmptyString_whenArrayListAddEmptyString() {
    // Arrange
    RoleDao roleDao = mock(RoleDao.class);
    when(roleDao.findAllRoles()).thenReturn(new HashSet<>());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findAllEmails()).thenReturn(new ArrayList<>());

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any()))
        .thenReturn(
            ImmutableSetting.builder()
                .description("The characteristics of someone or something")
                .name("Name")
                .value("42")
                .build());
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
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

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    ArrayList<String> lines = new ArrayList<>();
    lines.add("");

    // Act
    List<BulkUserOperationRowPreview> actualBulkUploadPreviewResult =
        userRoleService.bulkUploadPreview(BulkUploadMode.ADD_ONLY, lines, "janedoe");

    // Assert
    verify(personDao).findAllEmails();
    verify(roleDao).findAllRoles();
    verify(settingsDao).getByName("feature.user-roles.disable-self-role-mgmt");
    assertTrue(actualBulkUploadPreviewResult.isEmpty());
  }

  /**
   * Test {@link UserRoleService#bulkUploadPreview(BulkUploadMode, List, String)}.
   *
   * <ul>
   *   <li>Given {@link PersonDao} {@link PersonDao#findAllEmails()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#bulkUploadPreview(BulkUploadMode, List, String)}
   */
  @Test
  @DisplayName(
      "Test bulkUploadPreview(BulkUploadMode, List, String); given PersonDao findAllEmails() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserRoleService.bulkUploadPreview(BulkUploadMode, List, String)"})
  void testBulkUploadPreview_givenPersonDaoFindAllEmailsThrowIllegalArgumentException() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findAllEmails()).thenThrow(new IllegalArgumentException());

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any()))
        .thenReturn(
            ImmutableSetting.builder()
                .description("The characteristics of someone or something")
                .name("Name")
                .value("42")
                .build());
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
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

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    ArrayList<String> lines = new ArrayList<>();
    lines.add("foo");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> userRoleService.bulkUploadPreview(BulkUploadMode.ADD_ONLY, lines, "janedoe"));
    verify(personDao).findAllEmails();
    verify(settingsDao).getByName("feature.user-roles.disable-self-role-mgmt");
  }

  /**
   * Test {@link UserRoleService#bulkUploadPreview(BulkUploadMode, List, String)}.
   *
   * <ul>
   *   <li>Given {@link SettingsService} {@link SettingsService#getValue(String)} return of {@code
   *       42}.
   *   <li>Then calls {@link SettingsService#getValue(String)}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#bulkUploadPreview(BulkUploadMode, List, String)}
   */
  @Test
  @DisplayName(
      "Test bulkUploadPreview(BulkUploadMode, List, String); given SettingsService getValue(String) return of '42'; then calls getValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserRoleService.bulkUploadPreview(BulkUploadMode, List, String)"})
  void testBulkUploadPreview_givenSettingsServiceGetValueReturnOf42_thenCallsGetValue() {
    // Arrange
    RoleDao roleDao = mock(RoleDao.class);
    when(roleDao.findAllRoles()).thenReturn(new HashSet<>());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findAllEmails()).thenReturn(new ArrayList<>());

    SettingsService settingsService = mock(SettingsService.class);
    Optional<String> ofResult = Optional.of("42");
    when(settingsService.getValue(Mockito.<String>any())).thenReturn(ofResult);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
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

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    ArrayList<String> lines = new ArrayList<>();
    lines.add("foo");

    // Act
    List<BulkUserOperationRowPreview> actualBulkUploadPreviewResult =
        userRoleService.bulkUploadPreview(BulkUploadMode.ADD_ONLY, lines, "janedoe");

    // Assert
    verify(personDao).findAllEmails();
    verify(roleDao).findAllRoles();
    verify(settingsService).getValue("feature.user-roles.disable-self-role-mgmt");
    assertEquals(1, actualBulkUploadPreviewResult.size());
    BulkUserOperationRowPreview getResult = actualBulkUploadPreviewResult.get(0);
    assertTrue(getResult instanceof ImmutableBulkUserOperationRowPreview);
    assertEquals("foo", getResult.givenUser());
    assertNull(getResult.givenRole());
    assertNull(getResult.resolvedUser());
  }

  /**
   * Test {@link UserRoleService#bulkUploadPreview(BulkUploadMode, List, String)}.
   *
   * <ul>
   *   <li>Given {@code (,|\t)}.
   *   <li>Then return first givenUser is {@code (}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#bulkUploadPreview(BulkUploadMode, List, String)}
   */
  @Test
  @DisplayName(
      "Test bulkUploadPreview(BulkUploadMode, List, String); given '(,|\\t)'; then return first givenUser is '('")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserRoleService.bulkUploadPreview(BulkUploadMode, List, String)"})
  void testBulkUploadPreview_givenT_thenReturnFirstGivenUserIsLeftParenthesis() {
    // Arrange
    RoleDao roleDao = mock(RoleDao.class);
    when(roleDao.findAllRoles()).thenReturn(new HashSet<>());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findAllEmails()).thenReturn(new ArrayList<>());

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any()))
        .thenReturn(
            ImmutableSetting.builder()
                .description("The characteristics of someone or something")
                .name("Name")
                .value("42")
                .build());
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
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

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    ArrayList<String> lines = new ArrayList<>();
    lines.add("(,|\\t)");

    // Act
    List<BulkUserOperationRowPreview> actualBulkUploadPreviewResult =
        userRoleService.bulkUploadPreview(BulkUploadMode.ADD_ONLY, lines, "janedoe");

    // Assert
    verify(personDao).findAllEmails();
    verify(roleDao).findAllRoles();
    verify(settingsDao).getByName("feature.user-roles.disable-self-role-mgmt");
    assertEquals(1, actualBulkUploadPreviewResult.size());
    BulkUserOperationRowPreview getResult = actualBulkUploadPreviewResult.get(0);
    assertTrue(getResult instanceof ImmutableBulkUserOperationRowPreview);
    assertEquals("(", getResult.givenUser());
    assertEquals("|\\t)", getResult.givenRole());
    assertNull(getResult.resolvedUser());
  }

  /**
   * Test {@link UserRoleService#bulkUploadPreview(BulkUploadMode, List, String)}.
   *
   * <ul>
   *   <li>Given {@link UserRoleDao}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#bulkUploadPreview(BulkUploadMode, List, String)}
   */
  @Test
  @DisplayName(
      "Test bulkUploadPreview(BulkUploadMode, List, String); given UserRoleDao; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserRoleService.bulkUploadPreview(BulkUploadMode, List, String)"})
  void testBulkUploadPreview_givenUserRoleDao_thenThrowIllegalArgumentException() {
    // Arrange
    when(settingsService.getValue(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    ArrayList<String> lines = new ArrayList<>();
    lines.add("foo");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> userRoleService.bulkUploadPreview(BulkUploadMode.ADD_ONLY, lines, "janedoe"));
    verify(settingsService).getValue("feature.user-roles.disable-self-role-mgmt");
  }

  /**
   * Test {@link UserRoleService#bulkUploadPreview(BulkUploadMode, List, String)}.
   *
   * <ul>
   *   <li>Given {@code username}.
   *   <li>Then return first givenUser is {@code username}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#bulkUploadPreview(BulkUploadMode, List, String)}
   */
  @Test
  @DisplayName(
      "Test bulkUploadPreview(BulkUploadMode, List, String); given 'username'; then return first givenUser is 'username'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserRoleService.bulkUploadPreview(BulkUploadMode, List, String)"})
  void testBulkUploadPreview_givenUsername_thenReturnFirstGivenUserIsUsername() {
    // Arrange
    RoleDao roleDao = mock(RoleDao.class);
    when(roleDao.findAllRoles()).thenReturn(new HashSet<>());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findAllEmails()).thenReturn(new ArrayList<>());

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any()))
        .thenReturn(
            ImmutableSetting.builder()
                .description("The characteristics of someone or something")
                .name("Name")
                .value("42")
                .build());
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
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

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    ArrayList<String> lines = new ArrayList<>();
    lines.add("username");

    // Act
    List<BulkUserOperationRowPreview> actualBulkUploadPreviewResult =
        userRoleService.bulkUploadPreview(BulkUploadMode.ADD_ONLY, lines, "janedoe");

    // Assert
    verify(personDao).findAllEmails();
    verify(roleDao).findAllRoles();
    verify(settingsDao).getByName("feature.user-roles.disable-self-role-mgmt");
    assertEquals(1, actualBulkUploadPreviewResult.size());
    BulkUserOperationRowPreview getResult = actualBulkUploadPreviewResult.get(0);
    assertTrue(getResult instanceof ImmutableBulkUserOperationRowPreview);
    assertEquals("username", getResult.givenUser());
    assertNull(getResult.givenRole());
    assertNull(getResult.resolvedUser());
  }

  /**
   * Test {@link UserRoleService#bulkUploadPreview(BulkUploadMode, List, String)}.
   *
   * <ul>
   *   <li>Given {@code value cannot be null}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#bulkUploadPreview(BulkUploadMode, List, String)}
   */
  @Test
  @DisplayName(
      "Test bulkUploadPreview(BulkUploadMode, List, String); given 'value cannot be null'; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserRoleService.bulkUploadPreview(BulkUploadMode, List, String)"})
  void testBulkUploadPreview_givenValueCannotBeNull_thenReturnSizeIsTwo() {
    // Arrange
    RoleDao roleDao = mock(RoleDao.class);
    when(roleDao.findAllRoles()).thenReturn(new HashSet<>());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findAllEmails()).thenReturn(new ArrayList<>());

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any()))
        .thenReturn(
            ImmutableSetting.builder()
                .description("The characteristics of someone or something")
                .name("Name")
                .value("42")
                .build());
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
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

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    ArrayList<String> lines = new ArrayList<>();
    lines.add("value cannot be null");
    lines.add("foo");

    // Act
    List<BulkUserOperationRowPreview> actualBulkUploadPreviewResult =
        userRoleService.bulkUploadPreview(BulkUploadMode.ADD_ONLY, lines, "janedoe");

    // Assert
    verify(personDao).findAllEmails();
    verify(roleDao).findAllRoles();
    verify(settingsDao).getByName("feature.user-roles.disable-self-role-mgmt");
    assertEquals(2, actualBulkUploadPreviewResult.size());
    BulkUserOperationRowPreview getResult = actualBulkUploadPreviewResult.get(0);
    assertTrue(getResult instanceof ImmutableBulkUserOperationRowPreview);
    BulkUserOperationRowPreview getResult2 = actualBulkUploadPreviewResult.get(1);
    assertTrue(getResult2 instanceof ImmutableBulkUserOperationRowPreview);
    assertEquals("foo", getResult2.givenUser());
    assertEquals("value cannot be null", getResult.givenUser());
    assertNull(getResult2.givenComment());
    assertNull(getResult2.givenRole());
    assertNull(getResult2.resolvedComment());
    assertNull(getResult2.resolvedRole());
    assertNull(getResult2.resolvedUser());
    assertEquals(ResolutionStatus.ERROR, getResult2.status());
  }

  /**
   * Test {@link UserRoleService#bulkUploadPreview(BulkUploadMode, List, String)}.
   *
   * <ul>
   *   <li>Then return first givenUser is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#bulkUploadPreview(BulkUploadMode, List, String)}
   */
  @Test
  @DisplayName(
      "Test bulkUploadPreview(BulkUploadMode, List, String); then return first givenUser is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserRoleService.bulkUploadPreview(BulkUploadMode, List, String)"})
  void testBulkUploadPreview_thenReturnFirstGivenUserIsFoo() {
    // Arrange
    RoleDao roleDao = mock(RoleDao.class);
    when(roleDao.findAllRoles()).thenReturn(new HashSet<>());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findAllEmails()).thenReturn(new ArrayList<>());

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any()))
        .thenReturn(
            ImmutableSetting.builder()
                .description("The characteristics of someone or something")
                .name("Name")
                .value("42")
                .build());
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
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

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    ArrayList<String> lines = new ArrayList<>();
    lines.add("foo");

    // Act
    List<BulkUserOperationRowPreview> actualBulkUploadPreviewResult =
        userRoleService.bulkUploadPreview(BulkUploadMode.ADD_ONLY, lines, "janedoe");

    // Assert
    verify(personDao).findAllEmails();
    verify(roleDao).findAllRoles();
    verify(settingsDao).getByName("feature.user-roles.disable-self-role-mgmt");
    assertEquals(1, actualBulkUploadPreviewResult.size());
    BulkUserOperationRowPreview getResult = actualBulkUploadPreviewResult.get(0);
    assertTrue(getResult instanceof ImmutableBulkUserOperationRowPreview);
    assertEquals("foo", getResult.givenUser());
    assertNull(getResult.givenRole());
    assertNull(getResult.resolvedUser());
  }

  /**
   * Test {@link UserRoleService#bulkUploadPreview(BulkUploadMode, List, String)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#bulkUploadPreview(BulkUploadMode, List, String)}
   */
  @Test
  @DisplayName(
      "Test bulkUploadPreview(BulkUploadMode, List, String); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserRoleService.bulkUploadPreview(BulkUploadMode, List, String)"})
  void testBulkUploadPreview_whenArrayList_thenReturnEmpty() {
    // Arrange
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

    // Act and Assert
    assertTrue(
        userRoleService
            .bulkUploadPreview(BulkUploadMode.ADD_ONLY, new ArrayList<>(), "janedoe")
            .isEmpty());
  }

  /**
   * Test {@link UserRoleService#bulkUploadPreview(BulkUploadMode, List, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#bulkUploadPreview(BulkUploadMode, List, String)}
   */
  @Test
  @DisplayName(
      "Test bulkUploadPreview(BulkUploadMode, List, String); when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserRoleService.bulkUploadPreview(BulkUploadMode, List, String)"})
  void testBulkUploadPreview_whenNull_thenReturnEmpty() {
    // Arrange
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

    // Act and Assert
    assertTrue(
        userRoleService.bulkUploadPreview(BulkUploadMode.ADD_ONLY, null, "janedoe").isEmpty());
  }

  /**
   * Test {@link UserRoleService#bulkUpload(BulkUploadMode, List, String)}.
   *
   * <p>Method under test: {@link UserRoleService#bulkUpload(BulkUploadMode, List, String)}
   */
  @Test
  @DisplayName("Test bulkUpload(BulkUploadMode, List, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleService.bulkUpload(BulkUploadMode, List, String)"})
  void testBulkUpload() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.addRoles(Mockito.<Set<Tuple2<String, String>>>any())).thenReturn(2);

    HashSet<Role> roleSet = new HashSet<>();
    roleSet.add(
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("Name")
            .build());

    RoleDao roleDao = mock(RoleDao.class);
    when(roleDao.findAllRoles()).thenReturn(roleSet);

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findAllEmails()).thenReturn(new ArrayList<>());

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any()))
        .thenReturn(
            ImmutableSetting.builder()
                .description("The characteristics of someone or something")
                .name("Name")
                .value("42")
                .build());
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    ArrayList<String> lines = new ArrayList<>();
    lines.add("foo");

    // Act
    int actualBulkUploadResult =
        userRoleService.bulkUpload(BulkUploadMode.ADD_ONLY, lines, "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
    verify(personDao).findAllEmails();
    verify(roleDao).findAllRoles();
    verify(settingsDao).getByName("feature.user-roles.disable-self-role-mgmt");
    verify(userRoleDao).addRoles(isA(Set.class));
    assertEquals(2, actualBulkUploadResult);
  }

  /**
   * Test {@link UserRoleService#bulkUpload(BulkUploadMode, List, String)}.
   *
   * <p>Method under test: {@link UserRoleService#bulkUpload(BulkUploadMode, List, String)}
   */
  @Test
  @DisplayName("Test bulkUpload(BulkUploadMode, List, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleService.bulkUpload(BulkUploadMode, List, String)"})
  void testBulkUpload2() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.addRoles(Mockito.<Set<Tuple2<String, String>>>any())).thenReturn(2);

    RoleDao roleDao = mock(RoleDao.class);
    when(roleDao.findAllRoles()).thenReturn(new HashSet<>());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findAllEmails()).thenReturn(new ArrayList<>());

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    SettingsService settingsService = mock(SettingsService.class);
    Optional<String> ofResult = Optional.of("42");
    when(settingsService.getValue(Mockito.<String>any())).thenReturn(ofResult);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    ArrayList<String> lines = new ArrayList<>();
    lines.add("foo");

    // Act
    int actualBulkUploadResult =
        userRoleService.bulkUpload(BulkUploadMode.ADD_ONLY, lines, "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
    verify(personDao).findAllEmails();
    verify(roleDao).findAllRoles();
    verify(userRoleDao).addRoles(isA(Set.class));
    verify(settingsService).getValue("feature.user-roles.disable-self-role-mgmt");
    assertEquals(2, actualBulkUploadResult);
  }

  /**
   * Test {@link UserRoleService#bulkUpload(BulkUploadMode, List, String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>When {@code REMOVE_ONLY}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#bulkUpload(BulkUploadMode, List, String)}
   */
  @Test
  @DisplayName(
      "Test bulkUpload(BulkUploadMode, List, String); given ArrayList() add 'foo'; when 'REMOVE_ONLY'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleService.bulkUpload(BulkUploadMode, List, String)"})
  void testBulkUpload_givenArrayListAddFoo_whenRemoveOnly_thenReturnOne() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.removeRoles(Mockito.<Set<Tuple2<String, String>>>any())).thenReturn(1);

    RoleDao roleDao = mock(RoleDao.class);
    when(roleDao.findAllRoles()).thenReturn(new HashSet<>());

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    stringList.add("(,|\\t)");

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findAllEmails()).thenReturn(stringList);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    SettingsService settingsService = mock(SettingsService.class);
    Optional<String> ofResult = Optional.of("42");
    when(settingsService.getValue(Mockito.<String>any())).thenReturn(ofResult);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    ArrayList<String> lines = new ArrayList<>();
    lines.add("foo");

    // Act
    int actualBulkUploadResult =
        userRoleService.bulkUpload(BulkUploadMode.REMOVE_ONLY, lines, "janedoe");

    // Assert
    verify(personDao).findAllEmails();
    verify(roleDao).findAllRoles();
    verify(userRoleDao).removeRoles(isA(Set.class));
    verify(changeLogService).write(isA(Collection.class));
    verify(settingsService).getValue("feature.user-roles.disable-self-role-mgmt");
    assertEquals(1, actualBulkUploadResult);
  }

  /**
   * Test {@link UserRoleService#bulkUpload(BulkUploadMode, List, String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code (,|\t)}.
   *   <li>When {@code ADD_ONLY}.
   *   <li>Then calls {@link SettingsDao#getByName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#bulkUpload(BulkUploadMode, List, String)}
   */
  @Test
  @DisplayName(
      "Test bulkUpload(BulkUploadMode, List, String); given ArrayList() add '(,|\\t)'; when 'ADD_ONLY'; then calls getByName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleService.bulkUpload(BulkUploadMode, List, String)"})
  void testBulkUpload_givenArrayListAddT_whenAddOnly_thenCallsGetByName() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.addRoles(Mockito.<Set<Tuple2<String, String>>>any())).thenReturn(2);

    RoleDao roleDao = mock(RoleDao.class);
    when(roleDao.findAllRoles()).thenReturn(new HashSet<>());

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("(,|\\t)");

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findAllEmails()).thenReturn(stringList);

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any()))
        .thenReturn(
            ImmutableSetting.builder()
                .description("The characteristics of someone or something")
                .name("Name")
                .value("42")
                .build());
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    ArrayList<String> lines = new ArrayList<>();
    lines.add("foo");

    // Act
    int actualBulkUploadResult =
        userRoleService.bulkUpload(BulkUploadMode.ADD_ONLY, lines, "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
    verify(personDao).findAllEmails();
    verify(roleDao).findAllRoles();
    verify(settingsDao).getByName("feature.user-roles.disable-self-role-mgmt");
    verify(userRoleDao).addRoles(isA(Set.class));
    assertEquals(2, actualBulkUploadResult);
  }

  /**
   * Test {@link UserRoleService#bulkUpload(BulkUploadMode, List, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(Collection)} return array of
   *       {@code int} with {@code 19088743} and one.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#bulkUpload(BulkUploadMode, List, String)}
   */
  @Test
  @DisplayName(
      "Test bulkUpload(BulkUploadMode, List, String); given ChangeLogService write(Collection) return array of int with '19088743' and one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleService.bulkUpload(BulkUploadMode, List, String)"})
  void testBulkUpload_givenChangeLogServiceWriteReturnArrayOfIntWith19088743AndOne() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.addRoles(Mockito.<Set<Tuple2<String, String>>>any())).thenReturn(2);

    RoleDao roleDao = mock(RoleDao.class);
    when(roleDao.findAllRoles()).thenReturn(new HashSet<>());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findAllEmails()).thenReturn(new ArrayList<>());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    SettingsService settingsService = mock(SettingsService.class);
    Optional<String> ofResult = Optional.of("42");
    when(settingsService.getValue(Mockito.<String>any())).thenReturn(ofResult);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    ArrayList<String> lines = new ArrayList<>();
    lines.add("foo");

    // Act
    int actualBulkUploadResult =
        userRoleService.bulkUpload(BulkUploadMode.ADD_ONLY, lines, "janedoe");

    // Assert
    verify(personDao).findAllEmails();
    verify(roleDao).findAllRoles();
    verify(userRoleDao).addRoles(isA(Set.class));
    verify(changeLogService).write(isA(Collection.class));
    verify(settingsService).getValue("feature.user-roles.disable-self-role-mgmt");
    assertEquals(2, actualBulkUploadResult);
  }

  /**
   * Test {@link UserRoleService#bulkUpload(BulkUploadMode, List, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(Collection)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#bulkUpload(BulkUploadMode, List, String)}
   */
  @Test
  @DisplayName(
      "Test bulkUpload(BulkUploadMode, List, String); given ChangeLogService write(Collection) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleService.bulkUpload(BulkUploadMode, List, String)"})
  void testBulkUpload_givenChangeLogServiceWriteThrowIllegalArgumentException() {
    // Arrange
    when(roleDao.findAllRoles()).thenReturn(new HashSet<>());
    when(personDao.findAllEmails()).thenReturn(new ArrayList<>());
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenThrow(new IllegalArgumentException());
    Optional<String> ofResult = Optional.of("42");
    when(settingsService.getValue(Mockito.<String>any())).thenReturn(ofResult);

    ArrayList<String> lines = new ArrayList<>();
    lines.add("foo");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> userRoleService.bulkUpload(BulkUploadMode.ADD_ONLY, lines, "janedoe"));
    verify(personDao).findAllEmails();
    verify(roleDao).findAllRoles();
    verify(changeLogService).write(isA(Collection.class));
    verify(settingsService).getValue("feature.user-roles.disable-self-role-mgmt");
  }

  /**
   * Test {@link UserRoleService#bulkUpload(BulkUploadMode, List, String)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link ArrayList#ArrayList()} add empty string.
   *   <li>Then calls {@link SettingsDao#getByName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#bulkUpload(BulkUploadMode, List, String)}
   */
  @Test
  @DisplayName(
      "Test bulkUpload(BulkUploadMode, List, String); given empty string; when ArrayList() add empty string; then calls getByName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleService.bulkUpload(BulkUploadMode, List, String)"})
  void testBulkUpload_givenEmptyString_whenArrayListAddEmptyString_thenCallsGetByName() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.addRoles(Mockito.<Set<Tuple2<String, String>>>any())).thenReturn(2);

    RoleDao roleDao = mock(RoleDao.class);
    when(roleDao.findAllRoles()).thenReturn(new HashSet<>());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findAllEmails()).thenReturn(new ArrayList<>());

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any()))
        .thenReturn(
            ImmutableSetting.builder()
                .description("The characteristics of someone or something")
                .name("Name")
                .value("42")
                .build());
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    ArrayList<String> lines = new ArrayList<>();
    lines.add("");

    // Act
    int actualBulkUploadResult =
        userRoleService.bulkUpload(BulkUploadMode.ADD_ONLY, lines, "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
    verify(personDao).findAllEmails();
    verify(roleDao).findAllRoles();
    verify(settingsDao).getByName("feature.user-roles.disable-self-role-mgmt");
    verify(userRoleDao).addRoles(isA(Set.class));
    assertEquals(2, actualBulkUploadResult);
  }

  /**
   * Test {@link UserRoleService#bulkUpload(BulkUploadMode, List, String)}.
   *
   * <ul>
   *   <li>Given {@link RoleDao}.
   *   <li>When {@code ADD_ONLY}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#bulkUpload(BulkUploadMode, List, String)}
   */
  @Test
  @DisplayName(
      "Test bulkUpload(BulkUploadMode, List, String); given RoleDao; when 'ADD_ONLY'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleService.bulkUpload(BulkUploadMode, List, String)"})
  void testBulkUpload_givenRoleDao_whenAddOnly_thenThrowIllegalArgumentException() {
    // Arrange
    when(settingsService.getValue(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    ArrayList<String> lines = new ArrayList<>();
    lines.add("foo");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> userRoleService.bulkUpload(BulkUploadMode.ADD_ONLY, lines, "janedoe"));
    verify(settingsService).getValue("feature.user-roles.disable-self-role-mgmt");
  }

  /**
   * Test {@link UserRoleService#bulkUpload(BulkUploadMode, List, String)}.
   *
   * <ul>
   *   <li>Given {@code (,|\t)}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code (,|\t)}.
   *   <li>Then calls {@link SettingsDao#getByName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#bulkUpload(BulkUploadMode, List, String)}
   */
  @Test
  @DisplayName(
      "Test bulkUpload(BulkUploadMode, List, String); given '(,|\\t)'; when ArrayList() add '(,|\\t)'; then calls getByName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleService.bulkUpload(BulkUploadMode, List, String)"})
  void testBulkUpload_givenT_whenArrayListAddT_thenCallsGetByName() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.addRoles(Mockito.<Set<Tuple2<String, String>>>any())).thenReturn(2);

    RoleDao roleDao = mock(RoleDao.class);
    when(roleDao.findAllRoles()).thenReturn(new HashSet<>());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findAllEmails()).thenReturn(new ArrayList<>());

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any()))
        .thenReturn(
            ImmutableSetting.builder()
                .description("The characteristics of someone or something")
                .name("Name")
                .value("42")
                .build());
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    ArrayList<String> lines = new ArrayList<>();
    lines.add("(,|\\t)");

    // Act
    int actualBulkUploadResult =
        userRoleService.bulkUpload(BulkUploadMode.ADD_ONLY, lines, "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
    verify(personDao).findAllEmails();
    verify(roleDao).findAllRoles();
    verify(settingsDao).getByName("feature.user-roles.disable-self-role-mgmt");
    verify(userRoleDao).addRoles(isA(Set.class));
    assertEquals(2, actualBulkUploadResult);
  }

  /**
   * Test {@link UserRoleService#bulkUpload(BulkUploadMode, List, String)}.
   *
   * <ul>
   *   <li>Given {@link UserRoleDao} {@link UserRoleDao#removeRoles(Set)} return one.
   *   <li>When {@code REMOVE_ONLY}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#bulkUpload(BulkUploadMode, List, String)}
   */
  @Test
  @DisplayName(
      "Test bulkUpload(BulkUploadMode, List, String); given UserRoleDao removeRoles(Set) return one; when 'REMOVE_ONLY'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleService.bulkUpload(BulkUploadMode, List, String)"})
  void testBulkUpload_givenUserRoleDaoRemoveRolesReturnOne_whenRemoveOnly_thenReturnOne() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.removeRoles(Mockito.<Set<Tuple2<String, String>>>any())).thenReturn(1);

    RoleDao roleDao = mock(RoleDao.class);
    when(roleDao.findAllRoles()).thenReturn(new HashSet<>());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findAllEmails()).thenReturn(new ArrayList<>());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    SettingsService settingsService = mock(SettingsService.class);
    Optional<String> ofResult = Optional.of("42");
    when(settingsService.getValue(Mockito.<String>any())).thenReturn(ofResult);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    ArrayList<String> lines = new ArrayList<>();
    lines.add("foo");

    // Act
    int actualBulkUploadResult =
        userRoleService.bulkUpload(BulkUploadMode.REMOVE_ONLY, lines, "janedoe");

    // Assert
    verify(personDao).findAllEmails();
    verify(roleDao).findAllRoles();
    verify(userRoleDao).removeRoles(isA(Set.class));
    verify(changeLogService).write(isA(Collection.class));
    verify(settingsService).getValue("feature.user-roles.disable-self-role-mgmt");
    assertEquals(1, actualBulkUploadResult);
  }

  /**
   * Test {@link UserRoleService#bulkUpload(BulkUploadMode, List, String)}.
   *
   * <ul>
   *   <li>Given {@link UserRoleDao} {@link UserRoleDao#removeRoles(Set)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#bulkUpload(BulkUploadMode, List, String)}
   */
  @Test
  @DisplayName(
      "Test bulkUpload(BulkUploadMode, List, String); given UserRoleDao removeRoles(Set) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleService.bulkUpload(BulkUploadMode, List, String)"})
  void testBulkUpload_givenUserRoleDaoRemoveRolesThrowIllegalArgumentException() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.removeRoles(Mockito.<Set<Tuple2<String, String>>>any()))
        .thenThrow(new IllegalArgumentException());

    RoleDao roleDao = mock(RoleDao.class);
    when(roleDao.findAllRoles()).thenReturn(new HashSet<>());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findAllEmails()).thenReturn(new ArrayList<>());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    SettingsService settingsService = mock(SettingsService.class);
    Optional<String> ofResult = Optional.of("42");
    when(settingsService.getValue(Mockito.<String>any())).thenReturn(ofResult);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    ArrayList<String> lines = new ArrayList<>();
    lines.add("foo");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> userRoleService.bulkUpload(BulkUploadMode.REMOVE_ONLY, lines, "janedoe"));
    verify(personDao).findAllEmails();
    verify(roleDao).findAllRoles();
    verify(userRoleDao).removeRoles(isA(Set.class));
    verify(changeLogService).write(isA(Collection.class));
    verify(settingsService).getValue("feature.user-roles.disable-self-role-mgmt");
  }

  /**
   * Test {@link UserRoleService#bulkUpload(BulkUploadMode, List, String)}.
   *
   * <ul>
   *   <li>Given {@link UserRoleDao} {@link UserRoleDao#replaceRoles(Set)} return one.
   *   <li>Then calls {@link UserRoleDao#replaceRoles(Set)}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#bulkUpload(BulkUploadMode, List, String)}
   */
  @Test
  @DisplayName(
      "Test bulkUpload(BulkUploadMode, List, String); given UserRoleDao replaceRoles(Set) return one; then calls replaceRoles(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleService.bulkUpload(BulkUploadMode, List, String)"})
  void testBulkUpload_givenUserRoleDaoReplaceRolesReturnOne_thenCallsReplaceRoles() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.replaceRoles(Mockito.<Set<Tuple2<String, String>>>any())).thenReturn(1);

    RoleDao roleDao = mock(RoleDao.class);
    when(roleDao.findAllRoles()).thenReturn(new HashSet<>());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findAllEmails()).thenReturn(new ArrayList<>());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    SettingsService settingsService = mock(SettingsService.class);
    Optional<String> ofResult = Optional.of("42");
    when(settingsService.getValue(Mockito.<String>any())).thenReturn(ofResult);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    ArrayList<String> lines = new ArrayList<>();
    lines.add("foo");

    // Act
    int actualBulkUploadResult =
        userRoleService.bulkUpload(BulkUploadMode.REPLACE, lines, "janedoe");

    // Assert
    verify(personDao).findAllEmails();
    verify(roleDao).findAllRoles();
    verify(userRoleDao).replaceRoles(isA(Set.class));
    verify(changeLogService).write(isA(Collection.class));
    verify(settingsService).getValue("feature.user-roles.disable-self-role-mgmt");
    assertEquals(1, actualBulkUploadResult);
  }

  /**
   * Test {@link UserRoleService#bulkUpload(BulkUploadMode, List, String)}.
   *
   * <ul>
   *   <li>Given {@link UserRoleDao} {@link UserRoleDao#replaceRoles(Set)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#bulkUpload(BulkUploadMode, List, String)}
   */
  @Test
  @DisplayName(
      "Test bulkUpload(BulkUploadMode, List, String); given UserRoleDao replaceRoles(Set) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleService.bulkUpload(BulkUploadMode, List, String)"})
  void testBulkUpload_givenUserRoleDaoReplaceRolesThrowIllegalArgumentException() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.replaceRoles(Mockito.<Set<Tuple2<String, String>>>any()))
        .thenThrow(new IllegalArgumentException());

    RoleDao roleDao = mock(RoleDao.class);
    when(roleDao.findAllRoles()).thenReturn(new HashSet<>());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findAllEmails()).thenReturn(new ArrayList<>());

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    SettingsService settingsService = mock(SettingsService.class);
    Optional<String> ofResult = Optional.of("42");
    when(settingsService.getValue(Mockito.<String>any())).thenReturn(ofResult);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    ArrayList<String> lines = new ArrayList<>();
    lines.add("foo");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> userRoleService.bulkUpload(BulkUploadMode.REPLACE, lines, "janedoe"));
    verify(personDao).findAllEmails();
    verify(roleDao).findAllRoles();
    verify(userRoleDao).replaceRoles(isA(Set.class));
    verify(changeLogService).write(isA(Collection.class));
    verify(settingsService).getValue("feature.user-roles.disable-self-role-mgmt");
  }

  /**
   * Test {@link UserRoleService#bulkUpload(BulkUploadMode, List, String)}.
   *
   * <ul>
   *   <li>Given {@code username}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code username}.
   *   <li>Then calls {@link SettingsDao#getByName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#bulkUpload(BulkUploadMode, List, String)}
   */
  @Test
  @DisplayName(
      "Test bulkUpload(BulkUploadMode, List, String); given 'username'; when ArrayList() add 'username'; then calls getByName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleService.bulkUpload(BulkUploadMode, List, String)"})
  void testBulkUpload_givenUsername_whenArrayListAddUsername_thenCallsGetByName() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.addRoles(Mockito.<Set<Tuple2<String, String>>>any())).thenReturn(2);

    RoleDao roleDao = mock(RoleDao.class);
    when(roleDao.findAllRoles()).thenReturn(new HashSet<>());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findAllEmails()).thenReturn(new ArrayList<>());

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any()))
        .thenReturn(
            ImmutableSetting.builder()
                .description("The characteristics of someone or something")
                .name("Name")
                .value("42")
                .build());
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    ArrayList<String> lines = new ArrayList<>();
    lines.add("username");

    // Act
    int actualBulkUploadResult =
        userRoleService.bulkUpload(BulkUploadMode.ADD_ONLY, lines, "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
    verify(personDao).findAllEmails();
    verify(roleDao).findAllRoles();
    verify(settingsDao).getByName("feature.user-roles.disable-self-role-mgmt");
    verify(userRoleDao).addRoles(isA(Set.class));
    assertEquals(2, actualBulkUploadResult);
  }

  /**
   * Test {@link UserRoleService#bulkUpload(BulkUploadMode, List, String)}.
   *
   * <ul>
   *   <li>Given {@code value cannot be null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code value cannot be null}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#bulkUpload(BulkUploadMode, List, String)}
   */
  @Test
  @DisplayName(
      "Test bulkUpload(BulkUploadMode, List, String); given 'value cannot be null'; when ArrayList() add 'value cannot be null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleService.bulkUpload(BulkUploadMode, List, String)"})
  void testBulkUpload_givenValueCannotBeNull_whenArrayListAddValueCannotBeNull() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.addRoles(Mockito.<Set<Tuple2<String, String>>>any())).thenReturn(2);

    RoleDao roleDao = mock(RoleDao.class);
    when(roleDao.findAllRoles()).thenReturn(new HashSet<>());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findAllEmails()).thenReturn(new ArrayList<>());

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any()))
        .thenReturn(
            ImmutableSetting.builder()
                .description("The characteristics of someone or something")
                .name("Name")
                .value("42")
                .build());
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    ArrayList<String> lines = new ArrayList<>();
    lines.add("value cannot be null");
    lines.add("foo");

    // Act
    int actualBulkUploadResult =
        userRoleService.bulkUpload(BulkUploadMode.ADD_ONLY, lines, "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
    verify(personDao).findAllEmails();
    verify(roleDao).findAllRoles();
    verify(settingsDao).getByName("feature.user-roles.disable-self-role-mgmt");
    verify(userRoleDao).addRoles(isA(Set.class));
    assertEquals(2, actualBulkUploadResult);
  }

  /**
   * Test {@link UserRoleService#bulkUpload(BulkUploadMode, List, String)}.
   *
   * <ul>
   *   <li>Then calls {@link SettingsDao#getByName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#bulkUpload(BulkUploadMode, List, String)}
   */
  @Test
  @DisplayName("Test bulkUpload(BulkUploadMode, List, String); then calls getByName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleService.bulkUpload(BulkUploadMode, List, String)"})
  void testBulkUpload_thenCallsGetByName() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.addRoles(Mockito.<Set<Tuple2<String, String>>>any())).thenReturn(2);

    RoleDao roleDao = mock(RoleDao.class);
    when(roleDao.findAllRoles()).thenReturn(new HashSet<>());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findAllEmails()).thenReturn(new ArrayList<>());

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any()))
        .thenReturn(
            ImmutableSetting.builder()
                .description("The characteristics of someone or something")
                .name("Name")
                .value("42")
                .build());
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    ArrayList<String> lines = new ArrayList<>();
    lines.add("foo");

    // Act
    int actualBulkUploadResult =
        userRoleService.bulkUpload(BulkUploadMode.ADD_ONLY, lines, "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
    verify(personDao).findAllEmails();
    verify(roleDao).findAllRoles();
    verify(settingsDao).getByName("feature.user-roles.disable-self-role-mgmt");
    verify(userRoleDao).addRoles(isA(Set.class));
    assertEquals(2, actualBulkUploadResult);
  }

  /**
   * Test {@link UserRoleService#bulkUpload(BulkUploadMode, List, String)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link UserRoleService#bulkUpload(BulkUploadMode, List, String)}
   */
  @Test
  @DisplayName("Test bulkUpload(BulkUploadMode, List, String); when ArrayList(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserRoleService.bulkUpload(BulkUploadMode, List, String)"})
  void testBulkUpload_whenArrayList_thenReturnZero() {
    // Arrange
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

    // Act and Assert
    assertEquals(
        0, userRoleService.bulkUpload(BulkUploadMode.ADD_ONLY, new ArrayList<>(), "janedoe"));
  }
}
