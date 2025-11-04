package org.finos.waltz.service.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.finos.waltz.model.bulk_upload.BulkUploadMode;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.model.settings.Setting;
import org.finos.waltz.model.user.BulkUserOperationRowPreview;
import org.finos.waltz.model.user.ImmutableBulkUserOperationRowPreview;
import org.finos.waltz.model.user.ImmutableUser;
import org.finos.waltz.model.user.SystemRole;
import org.finos.waltz.model.user.UpdateRolesCommand;
import org.finos.waltz.model.user.User;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.settings.SettingsService;
import org.jooq.DSLContext;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class UserRoleServiceDiffblueTest {
  /**
   * Method under test: {@link UserRoleService#hasRole(String, Set)}
   */
  @Test
  void testHasRole() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    // Act
    boolean actualHasRoleResult = userRoleService.hasRole("janedoe", new HashSet<>());

    // Assert
    verify(userRoleDao).getUserRoles(eq("janedoe"));
    assertTrue(actualHasRoleResult);
  }

  /**
   * Method under test: {@link UserRoleService#hasRole(String, Set)}
   */
  @Test
  void testHasRole2() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    HashSet<String> requiredRoles = new HashSet<>();
    requiredRoles.add("foo");

    // Act
    boolean actualHasRoleResult = userRoleService.hasRole("janedoe", requiredRoles);

    // Assert
    verify(userRoleDao).getUserRoles(eq("janedoe"));
    assertFalse(actualHasRoleResult);
  }

  /**
   * Method under test: {@link UserRoleService#hasRole(String, Set)}
   */
  @Test
  void testHasRole3() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    HashSet<String> requiredRoles = new HashSet<>();
    requiredRoles.add("42");
    requiredRoles.add("foo");

    // Act
    boolean actualHasRoleResult = userRoleService.hasRole("janedoe", requiredRoles);

    // Assert
    verify(userRoleDao).getUserRoles(eq("janedoe"));
    assertFalse(actualHasRoleResult);
  }

  /**
   * Method under test: {@link UserRoleService#hasRole(String, Set)}
   */
  @Test
  void testHasRole4() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenThrow(new IllegalArgumentException("foo"));
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> userRoleService.hasRole("janedoe", new HashSet<>()));
    verify(userRoleDao).getUserRoles(eq("janedoe"));
  }

  /**
   * Method under test: {@link UserRoleService#hasRole(String, String[])}
   */
  @Test
  void testHasRole5() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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
    boolean actualHasRoleResult = (new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
        new SettingsService(settingsDao, new ArrayList<>()))).hasRole("janedoe", "Required Roles");

    // Assert
    verify(userRoleDao).getUserRoles(eq("janedoe"));
    assertFalse(actualHasRoleResult);
  }

  /**
   * Method under test: {@link UserRoleService#hasRole(String, String[])}
   */
  @Test
  void testHasRole6() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenThrow(new IllegalArgumentException("foo"));
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
            new SettingsService(settingsDao, new ArrayList<>()))).hasRole("janedoe", "Required Roles"));
    verify(userRoleDao).getUserRoles(eq("janedoe"));
  }

  /**
   * Method under test: {@link UserRoleService#hasRole(String, SystemRole[])}
   */
  @Test
  void testHasRole7() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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
    boolean actualHasRoleResult = (new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
        new SettingsService(settingsDao, new ArrayList<>()))).hasRole("janedoe", SystemRole.ACTOR_ADMIN);

    // Assert
    verify(userRoleDao).getUserRoles(eq("janedoe"));
    assertFalse(actualHasRoleResult);
  }

  /**
   * Method under test: {@link UserRoleService#hasRole(String, SystemRole[])}
   */
  @Test
  void testHasRole8() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenThrow(new IllegalArgumentException("foo"));
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
            new SettingsService(settingsDao, new ArrayList<>()))).hasRole("janedoe", SystemRole.ACTOR_ADMIN));
    verify(userRoleDao).getUserRoles(eq("janedoe"));
  }

  /**
   * Method under test: {@link UserRoleService#hasAnyRole(String, Set)}
   */
  @Test
  void testHasAnyRole() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    // Act
    boolean actualHasAnyRoleResult = userRoleService.hasAnyRole("janedoe", new HashSet<>());

    // Assert
    verify(userRoleDao).getUserRoles(eq("janedoe"));
    assertFalse(actualHasAnyRoleResult);
  }

  /**
   * Method under test: {@link UserRoleService#hasAnyRole(String, Set)}
   */
  @Test
  void testHasAnyRole2() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    HashSet<String> requiredRoles = new HashSet<>();
    requiredRoles.add("xs cannot be null");

    // Act
    boolean actualHasAnyRoleResult = userRoleService.hasAnyRole("janedoe", requiredRoles);

    // Assert
    verify(userRoleDao).getUserRoles(eq("janedoe"));
    assertFalse(actualHasAnyRoleResult);
  }

  /**
   * Method under test: {@link UserRoleService#hasAnyRole(String, Set)}
   */
  @Test
  void testHasAnyRole3() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    HashSet<String> requiredRoles = new HashSet<>();
    requiredRoles.add("ys cannot be null");
    requiredRoles.add("xs cannot be null");

    // Act
    boolean actualHasAnyRoleResult = userRoleService.hasAnyRole("janedoe", requiredRoles);

    // Assert
    verify(userRoleDao).getUserRoles(eq("janedoe"));
    assertFalse(actualHasAnyRoleResult);
  }

  /**
   * Method under test: {@link UserRoleService#hasAnyRole(String, Set)}
   */
  @Test
  void testHasAnyRole4() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenThrow(new IllegalArgumentException("xs cannot be null"));
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> userRoleService.hasAnyRole("janedoe", new HashSet<>()));
    verify(userRoleDao).getUserRoles(eq("janedoe"));
  }

  /**
   * Method under test: {@link UserRoleService#hasAnyRole(String, SystemRole[])}
   */
  @Test
  void testHasAnyRole5() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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
    boolean actualHasAnyRoleResult = (new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()))).hasAnyRole("janedoe",
            SystemRole.ACTOR_ADMIN);

    // Assert
    verify(userRoleDao).getUserRoles(eq("janedoe"));
    assertFalse(actualHasAnyRoleResult);
  }

  /**
   * Method under test: {@link UserRoleService#hasAnyRole(String, SystemRole[])}
   */
  @Test
  void testHasAnyRole6() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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
    boolean actualHasAnyRoleResult = (new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()))).hasAnyRole("janedoe");

    // Assert
    verify(userRoleDao).getUserRoles(eq("janedoe"));
    assertFalse(actualHasAnyRoleResult);
  }

  /**
   * Method under test: {@link UserRoleService#hasAnyRole(String, SystemRole[])}
   */
  @Test
  void testHasAnyRole7() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenThrow(new IllegalArgumentException("xs cannot be null"));
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
            new SettingsService(settingsDao, new ArrayList<>()))).hasAnyRole("janedoe", SystemRole.ACTOR_ADMIN));
    verify(userRoleDao).getUserRoles(eq("janedoe"));
  }

  /**
   * Method under test: {@link UserRoleService#findAllUsers()}
   */
  @Test
  void testFindAllUsers() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    HashSet<User> userSet = new HashSet<>();
    when(userRoleDao.findAllUsers()).thenReturn(userSet);
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
    Set<User> actualFindAllUsersResult = (new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()))).findAllUsers();

    // Assert
    verify(userRoleDao).findAllUsers();
    assertTrue(actualFindAllUsersResult.isEmpty());
    assertSame(userSet, actualFindAllUsersResult);
  }

  /**
   * Method under test: {@link UserRoleService#findAllUsers()}
   */
  @Test
  void testFindAllUsers2() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.findAllUsers()).thenThrow(new IllegalArgumentException("foo"));
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new UserRoleService(userRoleDao, roleDao, personDao,
        changeLogService, personService, new SettingsService(settingsDao, new ArrayList<>()))).findAllUsers());
    verify(userRoleDao).findAllUsers();
  }

  /**
   * Method under test: {@link UserRoleService#findUsersForRole(Long)}
   */
  @Test
  void testFindUsersForRole() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    HashSet<User> userSet = new HashSet<>();
    when(userRoleDao.findUsersForRole(Mockito.<Long>any())).thenReturn(userSet);
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
    Set<User> actualFindUsersForRoleResult = (new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()))).findUsersForRole(1L);

    // Assert
    verify(userRoleDao).findUsersForRole(eq(1L));
    assertTrue(actualFindUsersForRoleResult.isEmpty());
    assertSame(userSet, actualFindUsersForRoleResult);
  }

  /**
   * Method under test: {@link UserRoleService#findUsersForRole(Long)}
   */
  @Test
  void testFindUsersForRole2() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.findUsersForRole(Mockito.<Long>any())).thenThrow(new IllegalArgumentException("foo"));
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new UserRoleService(userRoleDao, roleDao, personDao,
        changeLogService, personService, new SettingsService(settingsDao, new ArrayList<>()))).findUsersForRole(1L));
    verify(userRoleDao).findUsersForRole(eq(1L));
  }

  /**
   * Method under test: {@link UserRoleService#getByUserId(String)}
   */
  @Test
  void testGetByUserId() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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
    User actualByUserId = (new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
        new SettingsService(settingsDao, new ArrayList<>()))).getByUserId("42");

    // Assert
    verify(userRoleDao).getUserRoles(eq("42"));
    assertTrue(actualByUserId instanceof ImmutableUser);
    assertEquals("42", actualByUserId.userName());
    assertTrue(actualByUserId.roles().isEmpty());
  }

  /**
   * Method under test: {@link UserRoleService#getByUserId(String)}
   */
  @Test
  void testGetByUserId2() {
    // Arrange
    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("userName");
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(stringSet);
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
    User actualByUserId = (new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
        new SettingsService(settingsDao, new ArrayList<>()))).getByUserId("42");

    // Assert
    verify(userRoleDao).getUserRoles(eq("42"));
    assertTrue(actualByUserId instanceof ImmutableUser);
    assertEquals("42", actualByUserId.userName());
    Set<String> rolesResult = actualByUserId.roles();
    assertEquals(1, rolesResult.size());
    assertTrue(rolesResult.contains("userName"));
  }

  /**
   * Method under test: {@link UserRoleService#getByUserId(String)}
   */
  @Test
  void testGetByUserId3() {
    // Arrange
    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("roles element");
    stringSet.add("userName");
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(stringSet);
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
    User actualByUserId = (new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
        new SettingsService(settingsDao, new ArrayList<>()))).getByUserId("42");

    // Assert
    verify(userRoleDao).getUserRoles(eq("42"));
    assertTrue(actualByUserId instanceof ImmutableUser);
    assertEquals("42", actualByUserId.userName());
    assertEquals(stringSet, actualByUserId.roles());
  }

  /**
   * Method under test: {@link UserRoleService#getByUserId(String)}
   */
  @Test
  void testGetByUserId4() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenThrow(new IllegalArgumentException("userName"));
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new UserRoleService(userRoleDao, roleDao, personDao,
        changeLogService, personService, new SettingsService(settingsDao, new ArrayList<>()))).getByUserId("42"));
    verify(userRoleDao).getUserRoles(eq("42"));
  }

  /**
   * Method under test:
   * {@link UserRoleService#updateRoles(String, String, UpdateRolesCommand)}
   */
  @Test
  void testUpdateRoles() throws IllegalArgumentException {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.updateRoles(Mockito.<String>any(), Mockito.<Set<String>>any())).thenReturn(1);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getByUserEmail(Mockito.<String>any())).thenReturn(null);
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));
    UpdateRolesCommand command = mock(UpdateRolesCommand.class);
    when(command.roles()).thenReturn(new HashSet<>());

    // Act
    int actualUpdateRolesResult = userRoleService.updateRoles("janedoe", "janedoe", command);

    // Assert
    verify(personDao).getByUserEmail(eq("janedoe"));
    verify(userRoleDao).updateRoles(eq("janedoe"), isA(Set.class));
    verify(command, atLeast(1)).roles();
    assertEquals(1, actualUpdateRolesResult);
  }

  /**
   * Method under test:
   * {@link UserRoleService#updateRoles(String, String, UpdateRolesCommand)}
   */
  @Test
  void testUpdateRoles2() throws IllegalArgumentException {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.updateRoles(Mockito.<String>any(), Mockito.<Set<String>>any())).thenReturn(1);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getByUserEmail(Mockito.<String>any())).thenReturn(person);
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any())).thenReturn(null);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, mock(RoleDao.class), mock(PersonDao.class),
        changeLogService, personService, new SettingsService(settingsDao, new ArrayList<>()));
    UpdateRolesCommand command = mock(UpdateRolesCommand.class);
    when(command.comment()).thenReturn("Comment");
    when(command.roles()).thenReturn(new HashSet<>());

    // Act
    int actualUpdateRolesResult = userRoleService.updateRoles("janedoe", "janedoe", command);

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(personDao).getByUserEmail(eq("janedoe"));
    verify(settingsDao).getByName(eq("feature.user-roles.disable-self-role-mgmt"));
    verify(userRoleDao).updateRoles(eq("janedoe"), isA(Set.class));
    verify(person).id();
    verify(command).comment();
    verify(command, atLeast(1)).roles();
    assertEquals(1, actualUpdateRolesResult);
  }

  /**
   * Method under test:
   * {@link UserRoleService#updateRoles(String, String, UpdateRolesCommand)}
   */
  @Test
  void testUpdateRoles3() throws IllegalArgumentException {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getByUserEmail(Mockito.<String>any())).thenReturn(person);
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any())).thenReturn(null);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        personService, settingsService);
    UpdateRolesCommand command = mock(UpdateRolesCommand.class);
    when(command.comment()).thenThrow(new IllegalArgumentException("Updating roles for userName: {}, new roles: {}"));
    when(command.roles()).thenReturn(new HashSet<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> userRoleService.updateRoles("janedoe", "janedoe", command));
    verify(personDao).getByUserEmail(eq("janedoe"));
    verify(settingsDao).getByName(eq("feature.user-roles.disable-self-role-mgmt"));
    verify(person).id();
    verify(command).comment();
    verify(command, atLeast(1)).roles();
  }

  /**
   * Method under test:
   * {@link UserRoleService#updateRoles(String, String, UpdateRolesCommand)}
   */
  @Test
  void testUpdateRoles4() throws IllegalArgumentException {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.updateRoles(Mockito.<String>any(), Mockito.<Set<String>>any())).thenReturn(1);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getByUserEmail(Mockito.<String>any())).thenReturn(person);
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any())).thenReturn(null);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, mock(RoleDao.class), mock(PersonDao.class),
        changeLogService, personService, new SettingsService(settingsDao, new ArrayList<>()));
    UpdateRolesCommand command = mock(UpdateRolesCommand.class);
    when(command.comment()).thenReturn("Comment");
    when(command.roles()).thenReturn(new HashSet<>());

    // Act
    int actualUpdateRolesResult = userRoleService.updateRoles("janedoe", "janedoe", command);

    // Assert
    verify(personDao).getByUserEmail(eq("janedoe"));
    verify(settingsDao).getByName(eq("feature.user-roles.disable-self-role-mgmt"));
    verify(userRoleDao).updateRoles(eq("janedoe"), isA(Set.class));
    verify(person).id();
    verify(command).comment();
    verify(command, atLeast(1)).roles();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1, actualUpdateRolesResult);
  }

  /**
   * Method under test:
   * {@link UserRoleService#updateRoles(String, String, UpdateRolesCommand)}
   */
  @Test
  void testUpdateRoles5() throws IllegalArgumentException {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.updateRoles(Mockito.<String>any(), Mockito.<Set<String>>any())).thenReturn(1);
    PersonService personService = mock(PersonService.class);
    when(personService.getPersonByUserId(Mockito.<String>any())).thenReturn(null);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));
    UpdateRolesCommand command = mock(UpdateRolesCommand.class);
    when(command.roles()).thenReturn(new HashSet<>());

    // Act
    int actualUpdateRolesResult = userRoleService.updateRoles("janedoe", "janedoe", command);

    // Assert
    verify(userRoleDao).updateRoles(eq("janedoe"), isA(Set.class));
    verify(command, atLeast(1)).roles();
    verify(personService).getPersonByUserId(eq("janedoe"));
    assertEquals(1, actualUpdateRolesResult);
  }

  /**
   * Method under test:
   * {@link UserRoleService#updateRoles(String, String, UpdateRolesCommand)}
   */
  @Test
  void testUpdateRoles6() throws IllegalArgumentException {
    // Arrange
    Person person = mock(Person.class);
    when(person.id()).thenThrow(new IllegalArgumentException("Updating roles for userName: {}, new roles: {}"));
    PersonService personService = mock(PersonService.class);
    when(personService.getPersonByUserId(Mockito.<String>any())).thenReturn(person);
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any())).thenReturn(null);
    UserRoleService userRoleService = new UserRoleService(mock(UserRoleDao.class), mock(RoleDao.class),
        mock(PersonDao.class), mock(ChangeLogService.class), personService,
        new SettingsService(settingsDao, new ArrayList<>()));
    UpdateRolesCommand command = mock(UpdateRolesCommand.class);
    when(command.roles()).thenReturn(new HashSet<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> userRoleService.updateRoles("janedoe", "janedoe", command));
    verify(settingsDao).getByName(eq("feature.user-roles.disable-self-role-mgmt"));
    verify(person).id();
    verify(command).roles();
    verify(personService).getPersonByUserId(eq("janedoe"));
  }

  /**
   * Method under test:
   * {@link UserRoleService#updateRoles(String, String, UpdateRolesCommand)}
   */
  @Test
  void testUpdateRoles7() throws IllegalArgumentException {
    // Arrange
    Person person = mock(Person.class);
    when(person.id()).thenThrow(new IllegalArgumentException("Updating roles for userName: {}, new roles: {}"));
    PersonService personService = mock(PersonService.class);
    when(personService.getPersonByUserId(Mockito.<String>any())).thenReturn(person);
    Setting setting = mock(Setting.class);
    Optional<String> ofResult = Optional.of("foo");
    when(setting.value()).thenReturn(ofResult);
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any())).thenReturn(setting);
    UserRoleService userRoleService = new UserRoleService(mock(UserRoleDao.class), mock(RoleDao.class),
        mock(PersonDao.class), mock(ChangeLogService.class), personService,
        new SettingsService(settingsDao, new ArrayList<>()));
    UpdateRolesCommand command = mock(UpdateRolesCommand.class);
    when(command.roles()).thenReturn(new HashSet<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> userRoleService.updateRoles("janedoe", "janedoe", command));
    verify(settingsDao).getByName(eq("feature.user-roles.disable-self-role-mgmt"));
    verify(person).id();
    verify(setting).value();
    verify(command).roles();
    verify(personService).getPersonByUserId(eq("janedoe"));
  }

  /**
   * Method under test:
   * {@link UserRoleService#updateRoles(String, String, UpdateRolesCommand)}
   */
  @Test
  void testUpdateRoles8() throws IllegalArgumentException {
    // Arrange
    Person person = mock(Person.class);
    when(person.id()).thenThrow(new IllegalArgumentException("Updating roles for userName: {}, new roles: {}"));
    PersonService personService = mock(PersonService.class);
    when(personService.getPersonByUserId(Mockito.<String>any())).thenReturn(person);
    SettingsService settingsService = mock(SettingsService.class);
    Optional<String> ofResult = Optional.of("foo");
    when(settingsService.getValue(Mockito.<String>any())).thenReturn(ofResult);
    UserRoleService userRoleService = new UserRoleService(mock(UserRoleDao.class), mock(RoleDao.class),
        mock(PersonDao.class), mock(ChangeLogService.class), personService, settingsService);
    UpdateRolesCommand command = mock(UpdateRolesCommand.class);
    when(command.roles()).thenReturn(new HashSet<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> userRoleService.updateRoles("janedoe", "janedoe", command));
    verify(person).id();
    verify(command).roles();
    verify(personService).getPersonByUserId(eq("janedoe"));
    verify(settingsService).getValue(eq("feature.user-roles.disable-self-role-mgmt"));
  }

  /**
   * Method under test:
   * {@link UserRoleService#updateRoles(String, String, UpdateRolesCommand)}
   */
  @Test
  void testUpdateRoles9() throws IllegalArgumentException {
    // Arrange
    Person person = mock(Person.class);
    when(person.id()).thenThrow(new IllegalArgumentException("Updating roles for userName: {}, new roles: {}"));
    PersonService personService = mock(PersonService.class);
    when(personService.getPersonByUserId(Mockito.<String>any())).thenReturn(person);
    SettingsService settingsService = mock(SettingsService.class);
    Optional<String> ofResult = Optional.of("foo");
    when(settingsService.getValue(Mockito.<String>any())).thenReturn(ofResult);
    UserRoleService userRoleService = new UserRoleService(mock(UserRoleDao.class), mock(RoleDao.class),
        mock(PersonDao.class), mock(ChangeLogService.class), personService, settingsService);
    UpdateRolesCommand command = mock(UpdateRolesCommand.class);
    when(command.roles()).thenReturn(new HashSet<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> userRoleService.updateRoles(null, "janedoe", command));
    verify(person).id();
    verify(command).roles();
    verify(personService).getPersonByUserId(eq("janedoe"));
    verify(settingsService).getValue(eq("feature.user-roles.disable-self-role-mgmt"));
  }

  /**
   * Method under test:
   * {@link UserRoleService#updateRoles(String, String, UpdateRolesCommand)}
   */
  @Test
  void testUpdateRoles10() throws IllegalArgumentException {
    // Arrange
    Person person = mock(Person.class);
    when(person.id()).thenThrow(new IllegalArgumentException("Updating roles for userName: {}, new roles: {}"));
    PersonService personService = mock(PersonService.class);
    when(personService.getPersonByUserId(Mockito.<String>any())).thenReturn(person);
    SettingsService settingsService = mock(SettingsService.class);
    Optional<String> ofResult = Optional.of("foo");
    when(settingsService.getValue(Mockito.<String>any())).thenReturn(ofResult);
    UserRoleService userRoleService = new UserRoleService(mock(UserRoleDao.class), mock(RoleDao.class),
        mock(PersonDao.class), mock(ChangeLogService.class), personService, settingsService);
    UpdateRolesCommand command = mock(UpdateRolesCommand.class);
    when(command.roles()).thenReturn(new HashSet<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> userRoleService.updateRoles("janedoe", null, command));
    verify(person).id();
    verify(command).roles();
    verify(personService).getPersonByUserId(isNull());
    verify(settingsService).getValue(eq("feature.user-roles.disable-self-role-mgmt"));
  }

  /**
   * Method under test:
   * {@link UserRoleService#updateRoles(String, String, UpdateRolesCommand)}
   */
  @Test
  void testUpdateRoles11() throws IllegalArgumentException {
    // Arrange
    Person person = mock(Person.class);
    when(person.id()).thenThrow(new IllegalArgumentException("Updating roles for userName: {}, new roles: {}"));
    PersonService personService = mock(PersonService.class);
    when(personService.getPersonByUserId(Mockito.<String>any())).thenReturn(person);
    SettingsService settingsService = mock(SettingsService.class);
    Optional<String> ofResult = Optional.of("foo");
    when(settingsService.getValue(Mockito.<String>any())).thenReturn(ofResult);
    UserRoleService userRoleService = new UserRoleService(mock(UserRoleDao.class), mock(RoleDao.class),
        mock(PersonDao.class), mock(ChangeLogService.class), personService, settingsService);
    UpdateRolesCommand command = mock(UpdateRolesCommand.class);
    when(command.roles()).thenReturn(new HashSet<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> userRoleService.updateRoles(null, null, command));
    verify(person).id();
    verify(command).roles();
    verify(personService).getPersonByUserId(isNull());
    verify(settingsService).getValue(eq("feature.user-roles.disable-self-role-mgmt"));
  }

  /**
   * Method under test: {@link UserRoleService#getUserRoles(String)}
   */
  @Test
  void testGetUserRoles() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    HashSet<String> stringSet = new HashSet<>();
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(stringSet);
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
    Set<String> actualUserRoles = (new UserRoleService(userRoleDao, roleDao, personDao, changeLogService, personService,
        new SettingsService(settingsDao, new ArrayList<>()))).getUserRoles("janedoe");

    // Assert
    verify(userRoleDao).getUserRoles(eq("janedoe"));
    assertTrue(actualUserRoles.isEmpty());
    assertSame(stringSet, actualUserRoles);
  }

  /**
   * Method under test: {@link UserRoleService#getUserRoles(String)}
   */
  @Test
  void testGetUserRoles2() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenThrow(new IllegalArgumentException("foo"));
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new UserRoleService(userRoleDao, roleDao, personDao,
        changeLogService, personService, new SettingsService(settingsDao, new ArrayList<>()))).getUserRoles("janedoe"));
    verify(userRoleDao).getUserRoles(eq("janedoe"));
  }

  /**
   * Method under test:
   * {@link UserRoleService#bulkUploadPreview(BulkUploadMode, List, String)}
   */
  @Test
  void testBulkUploadPreview() {
    // Arrange
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
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    // Act and Assert
    assertTrue(userRoleService.bulkUploadPreview(BulkUploadMode.ADD_ONLY, new ArrayList<>(), "janedoe").isEmpty());
  }

  /**
   * Method under test:
   * {@link UserRoleService#bulkUploadPreview(BulkUploadMode, List, String)}
   */
  @Test
  void testBulkUploadPreview2() {
    // Arrange
    RoleDao roleDao = mock(RoleDao.class);
    when(roleDao.findAllRoles()).thenReturn(new HashSet<>());
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findAllEmails()).thenReturn(new ArrayList<>());
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any())).thenReturn(null);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class)), settingsService);

    ArrayList<String> lines = new ArrayList<>();
    lines.add("foo");

    // Act
    List<BulkUserOperationRowPreview> actualBulkUploadPreviewResult = userRoleService
        .bulkUploadPreview(BulkUploadMode.ADD_ONLY, lines, "janedoe");

    // Assert
    verify(personDao).findAllEmails();
    verify(roleDao).findAllRoles();
    verify(settingsDao).getByName(eq("feature.user-roles.disable-self-role-mgmt"));
    assertEquals(1, actualBulkUploadPreviewResult.size());
    BulkUserOperationRowPreview getResult = actualBulkUploadPreviewResult.get(0);
    assertTrue(getResult instanceof ImmutableBulkUserOperationRowPreview);
    assertEquals("foo", getResult.givenUser());
    assertNull(getResult.givenComment());
    assertNull(getResult.givenRole());
    assertNull(getResult.resolvedComment());
    assertNull(getResult.resolvedRole());
    assertNull(getResult.resolvedUser());
    assertEquals(BulkUserOperationRowPreview.ResolutionStatus.ERROR, getResult.status());
  }

  /**
   * Method under test:
   * {@link UserRoleService#bulkUpload(BulkUploadMode, List, String)}
   */
  @Test
  void testBulkUpload() {
    // Arrange
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
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    // Act and Assert
    assertEquals(0, userRoleService.bulkUpload(BulkUploadMode.ADD_ONLY, new ArrayList<>(), "janedoe"));
  }

  /**
   * Method under test:
   * {@link UserRoleService#bulkUpload(BulkUploadMode, List, String)}
   */
  @Test
  void testBulkUpload2() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.addRoles(Mockito.<Set<Tuple2<String, String>>>any())).thenReturn(2);
    RoleDao roleDao = mock(RoleDao.class);
    when(roleDao.findAllRoles()).thenReturn(new HashSet<>());
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findAllEmails()).thenReturn(new ArrayList<>());
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any())).thenReturn(null);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class)), settingsService);

    ArrayList<String> lines = new ArrayList<>();
    lines.add("foo");

    // Act
    int actualBulkUploadResult = userRoleService.bulkUpload(BulkUploadMode.ADD_ONLY, lines, "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
    verify(personDao).findAllEmails();
    verify(roleDao).findAllRoles();
    verify(settingsDao).getByName(eq("feature.user-roles.disable-self-role-mgmt"));
    verify(userRoleDao).addRoles(isA(Set.class));
    assertEquals(2, actualBulkUploadResult);
  }
}
