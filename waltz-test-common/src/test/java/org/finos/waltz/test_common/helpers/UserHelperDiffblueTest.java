package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.model.role.Role;
import org.finos.waltz.model.user.SystemRole;
import org.finos.waltz.model.user.UpdateRolesCommand;
import org.finos.waltz.model.user.UserRegistrationRequest;
import org.finos.waltz.service.role.RoleService;
import org.finos.waltz.service.user.UserRoleService;
import org.finos.waltz.service.user.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

class UserHelperDiffblueTest {
  /**
   * Method under test: {@link UserHelper#createRole(String)}
   */
  @Test
  void testCreateRole() {
    // Arrange
    UserHelper userHelper = new UserHelper();
    ReflectionTestUtils.setField(userHelper, "userService", mock(UserService.class));
    ReflectionTestUtils.setField(userHelper, "userRoleService", mock(UserRoleService.class));
    RoleService roleService = mock(RoleService.class);
    when(roleService.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(1L);
    when(roleService.findAllRoles()).thenReturn(new HashSet<>());
    ReflectionTestUtils.setField(userHelper, "roleService", roleService);

    // Act
    Long actualCreateRoleResult = userHelper.createRole("Role");

    // Assert
    verify(roleService).create(eq("Role"), eq("Role name"), eq("Role desc"));
    verify(roleService).findAllRoles();
    assertEquals(1L, actualCreateRoleResult.longValue());
  }

  /**
   * Method under test: {@link UserHelper#createRole(String)}
   */
  @Test
  void testCreateRole2() {
    // Arrange
    UserHelper userHelper = new UserHelper();
    ReflectionTestUtils.setField(userHelper, "userService", mock(UserService.class));
    ReflectionTestUtils.setField(userHelper, "userRoleService", mock(UserRoleService.class));
    Role role = mock(Role.class);
    when(role.name()).thenReturn("Name");

    HashSet<Role> roleSet = new HashSet<>();
    roleSet.add(role);
    RoleService roleService = mock(RoleService.class);
    when(roleService.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(1L);
    when(roleService.findAllRoles()).thenReturn(roleSet);
    ReflectionTestUtils.setField(userHelper, "roleService", roleService);

    // Act
    Long actualCreateRoleResult = userHelper.createRole("Role");

    // Assert
    verify(role).name();
    verify(roleService).create(eq("Role"), eq("Role name"), eq("Role desc"));
    verify(roleService).findAllRoles();
    assertEquals(1L, actualCreateRoleResult.longValue());
  }

  /**
   * Method under test: {@link UserHelper#createRole(String)}
   */
  @Test
  void testCreateRole3() {
    // Arrange
    UserHelper userHelper = new UserHelper();
    ReflectionTestUtils.setField(userHelper, "userService", mock(UserService.class));
    ReflectionTestUtils.setField(userHelper, "userRoleService", mock(UserRoleService.class));
    Role role = mock(Role.class);
    when(role.name()).thenReturn("Name");
    Role role2 = mock(Role.class);
    when(role2.name()).thenReturn("Name");

    HashSet<Role> roleSet = new HashSet<>();
    roleSet.add(role2);
    roleSet.add(role);
    RoleService roleService = mock(RoleService.class);
    when(roleService.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(1L);
    when(roleService.findAllRoles()).thenReturn(roleSet);
    ReflectionTestUtils.setField(userHelper, "roleService", roleService);

    // Act
    Long actualCreateRoleResult = userHelper.createRole("Role");

    // Assert
    verify(role2).name();
    verify(role).name();
    verify(roleService).create(eq("Role"), eq("Role name"), eq("Role desc"));
    verify(roleService).findAllRoles();
    assertEquals(1L, actualCreateRoleResult.longValue());
  }

  /**
   * Method under test: {@link UserHelper#createUser(String)}
   */
  @Test
  void testCreateUser() {
    // Arrange
    UserService userService = mock(UserService.class);
    when(userService.registerNewUser(Mockito.<UserRegistrationRequest>any())).thenReturn(1);
    UserHelper userHelper = new UserHelper();
    ReflectionTestUtils.setField(userHelper, "userService", userService);
    ReflectionTestUtils.setField(userHelper, "userRoleService", mock(UserRoleService.class));
    ReflectionTestUtils.setField(userHelper, "roleService", mock(RoleService.class));

    // Act
    userHelper.createUser("User");

    // Assert
    verify(userService).registerNewUser(isA(UserRegistrationRequest.class));
  }

  /**
   * Method under test: {@link UserHelper#createUserWithRoles(String, String[])}
   */
  @Test
  void testCreateUserWithRoles() throws IllegalArgumentException {
    // Arrange
    UserService userService = mock(UserService.class);
    when(userService.registerNewUser(Mockito.<UserRegistrationRequest>any())).thenReturn(1);
    UserHelper userHelper = new UserHelper();
    ReflectionTestUtils.setField(userHelper, "userService", userService);
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.updateRoles(Mockito.<String>any(), Mockito.<String>any(), Mockito.<UpdateRolesCommand>any()))
        .thenReturn(1);
    ReflectionTestUtils.setField(userHelper, "userRoleService", userRoleService);
    RoleService roleService = mock(RoleService.class);
    when(roleService.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(1L);
    when(roleService.findAllRoles()).thenReturn(new HashSet<>());
    ReflectionTestUtils.setField(userHelper, "roleService", roleService);

    // Act
    userHelper.createUserWithRoles("User", "Roles");

    // Assert
    verify(roleService).create(eq("Roles"), eq("Roles name"), eq("Roles desc"));
    verify(roleService).findAllRoles();
    verify(userRoleService).updateRoles(eq("User"), eq("User"), isA(UpdateRolesCommand.class));
    verify(userService).registerNewUser(isA(UserRegistrationRequest.class));
  }

  /**
   * Method under test: {@link UserHelper#createUserWithRoles(String, String[])}
   */
  @Test
  void testCreateUserWithRoles2() throws IllegalArgumentException {
    // Arrange
    UserService userService = mock(UserService.class);
    when(userService.registerNewUser(Mockito.<UserRegistrationRequest>any())).thenReturn(1);
    UserHelper userHelper = new UserHelper();
    ReflectionTestUtils.setField(userHelper, "userService", userService);
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.updateRoles(Mockito.<String>any(), Mockito.<String>any(), Mockito.<UpdateRolesCommand>any()))
        .thenReturn(1);
    ReflectionTestUtils.setField(userHelper, "userRoleService", userRoleService);
    Role role = mock(Role.class);
    when(role.name()).thenReturn("Name");

    HashSet<Role> roleSet = new HashSet<>();
    roleSet.add(role);
    RoleService roleService = mock(RoleService.class);
    when(roleService.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(1L);
    when(roleService.findAllRoles()).thenReturn(roleSet);
    ReflectionTestUtils.setField(userHelper, "roleService", roleService);

    // Act
    userHelper.createUserWithRoles("User", "Roles");

    // Assert
    verify(role).name();
    verify(roleService).create(eq("Roles"), eq("Roles name"), eq("Roles desc"));
    verify(roleService).findAllRoles();
    verify(userRoleService).updateRoles(eq("User"), eq("User"), isA(UpdateRolesCommand.class));
    verify(userService).registerNewUser(isA(UserRegistrationRequest.class));
  }

  /**
   * Method under test: {@link UserHelper#createUserWithRoles(String, String[])}
   */
  @Test
  void testCreateUserWithRoles3() throws IllegalArgumentException {
    // Arrange
    UserService userService = mock(UserService.class);
    when(userService.registerNewUser(Mockito.<UserRegistrationRequest>any())).thenReturn(1);
    UserHelper userHelper = new UserHelper();
    ReflectionTestUtils.setField(userHelper, "userService", userService);
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.updateRoles(Mockito.<String>any(), Mockito.<String>any(), Mockito.<UpdateRolesCommand>any()))
        .thenReturn(1);
    ReflectionTestUtils.setField(userHelper, "userRoleService", userRoleService);
    Role role = mock(Role.class);
    when(role.name()).thenReturn("Name");
    Role role2 = mock(Role.class);
    when(role2.name()).thenReturn("Name");

    HashSet<Role> roleSet = new HashSet<>();
    roleSet.add(role2);
    roleSet.add(role);
    RoleService roleService = mock(RoleService.class);
    when(roleService.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(1L);
    when(roleService.findAllRoles()).thenReturn(roleSet);
    ReflectionTestUtils.setField(userHelper, "roleService", roleService);

    // Act
    userHelper.createUserWithRoles("User", "Roles");

    // Assert
    verify(role2).name();
    verify(role).name();
    verify(roleService).create(eq("Roles"), eq("Roles name"), eq("Roles desc"));
    verify(roleService).findAllRoles();
    verify(userRoleService).updateRoles(eq("User"), eq("User"), isA(UpdateRolesCommand.class));
    verify(userService).registerNewUser(isA(UserRegistrationRequest.class));
  }

  /**
   * Method under test: {@link UserHelper#createUserWithSystemRoles(String, Set)}
   */
  @Test
  void testCreateUserWithSystemRoles() throws IllegalArgumentException {
    // Arrange
    UserService userService = mock(UserService.class);
    when(userService.registerNewUser(Mockito.<UserRegistrationRequest>any())).thenReturn(1);
    UserHelper userHelper = new UserHelper();
    ReflectionTestUtils.setField(userHelper, "userService", userService);
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.updateRoles(Mockito.<String>any(), Mockito.<String>any(), Mockito.<UpdateRolesCommand>any()))
        .thenReturn(1);
    ReflectionTestUtils.setField(userHelper, "userRoleService", userRoleService);
    ReflectionTestUtils.setField(userHelper, "roleService", mock(RoleService.class));

    // Act
    userHelper.createUserWithSystemRoles("User", new HashSet<>());

    // Assert
    verify(userRoleService).updateRoles(eq("User"), eq("User"), isA(UpdateRolesCommand.class));
    verify(userService).registerNewUser(isA(UserRegistrationRequest.class));
  }

  /**
   * Method under test: {@link UserHelper#createUserWithSystemRoles(String, Set)}
   */
  @Test
  void testCreateUserWithSystemRoles2() throws IllegalArgumentException {
    // Arrange
    UserService userService = mock(UserService.class);
    when(userService.registerNewUser(Mockito.<UserRegistrationRequest>any())).thenReturn(1);
    UserHelper userHelper = new UserHelper();
    ReflectionTestUtils.setField(userHelper, "userService", userService);
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.updateRoles(Mockito.<String>any(), Mockito.<String>any(), Mockito.<UpdateRolesCommand>any()))
        .thenReturn(1);
    ReflectionTestUtils.setField(userHelper, "userRoleService", userRoleService);
    ReflectionTestUtils.setField(userHelper, "roleService", mock(RoleService.class));

    HashSet<SystemRole> roles = new HashSet<>();
    roles.add(SystemRole.ACTOR_ADMIN);

    // Act
    userHelper.createUserWithSystemRoles("User", roles);

    // Assert
    verify(userRoleService).updateRoles(eq("User"), eq("User"), isA(UpdateRolesCommand.class));
    verify(userService).registerNewUser(isA(UserRegistrationRequest.class));
  }

  /**
   * Method under test: {@link UserHelper#createUserWithSystemRoles(String, Set)}
   */
  @Test
  void testCreateUserWithSystemRoles3() throws IllegalArgumentException {
    // Arrange
    UserService userService = mock(UserService.class);
    when(userService.registerNewUser(Mockito.<UserRegistrationRequest>any())).thenReturn(1);
    UserHelper userHelper = new UserHelper();
    ReflectionTestUtils.setField(userHelper, "userService", userService);
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.updateRoles(Mockito.<String>any(), Mockito.<String>any(), Mockito.<UpdateRolesCommand>any()))
        .thenReturn(1);
    ReflectionTestUtils.setField(userHelper, "userRoleService", userRoleService);
    ReflectionTestUtils.setField(userHelper, "roleService", mock(RoleService.class));

    HashSet<SystemRole> roles = new HashSet<>();
    roles.add(SystemRole.ADMIN);
    roles.add(SystemRole.ACTOR_ADMIN);

    // Act
    userHelper.createUserWithSystemRoles("User", roles);

    // Assert
    verify(userRoleService).updateRoles(eq("User"), eq("User"), isA(UpdateRolesCommand.class));
    verify(userService).registerNewUser(isA(UserRegistrationRequest.class));
  }
}
