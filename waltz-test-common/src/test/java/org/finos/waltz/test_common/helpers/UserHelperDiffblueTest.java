package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.model.role.Role;
import org.finos.waltz.model.user.SystemRole;
import org.finos.waltz.model.user.UpdateRolesCommand;
import org.finos.waltz.model.user.UserRegistrationRequest;
import org.finos.waltz.service.role.RoleService;
import org.finos.waltz.service.user.UserRoleService;
import org.finos.waltz.service.user.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class UserHelperDiffblueTest {
  @Mock
  private RoleService roleService;

  @InjectMocks
  private UserHelper userHelper;

  @Mock
  private UserService userService;

  @Mock
  private UserRoleService userRoleService;

  /**
   * Test {@link UserHelper#createRole(String)}.
   * <p>
   * Method under test: {@link UserHelper#createRole(String)}
   */
  @Test
  @DisplayName("Test createRole(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long UserHelper.createRole(String)"})
  void testCreateRole() {
    // Arrange
    when(roleService.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(1L);
    when(roleService.findAllRoles()).thenReturn(new HashSet<>());

    // Act
    Long actualCreateRoleResult = userHelper.createRole("Role");

    // Assert
    verify(roleService).create(eq("Role"), eq("Role name"), eq("Role desc"));
    verify(roleService).findAllRoles();
    assertEquals(1L, actualCreateRoleResult.longValue());
  }

  /**
   * Test {@link UserHelper#createRole(String)}.
   * <ul>
   *   <li>Given {@link Role} {@link Role#name()} return {@code Name}.</li>
   *   <li>Then calls {@link Role#name()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserHelper#createRole(String)}
   */
  @Test
  @DisplayName("Test createRole(String); given Role name() return 'Name'; then calls name()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long UserHelper.createRole(String)"})
  void testCreateRole_givenRoleNameReturnName_thenCallsName() {
    // Arrange
    Role role = mock(Role.class);
    when(role.name()).thenReturn("Name");

    HashSet<Role> roleSet = new HashSet<>();
    roleSet.add(role);
    when(roleService.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(1L);
    when(roleService.findAllRoles()).thenReturn(roleSet);

    // Act
    Long actualCreateRoleResult = userHelper.createRole("Role");

    // Assert
    verify(role).name();
    verify(roleService).create(eq("Role"), eq("Role name"), eq("Role desc"));
    verify(roleService).findAllRoles();
    assertEquals(1L, actualCreateRoleResult.longValue());
  }

  /**
   * Test {@link UserHelper#createRole(String)}.
   * <ul>
   *   <li>Given {@link Role} {@link Role#name()} return {@code Name}.</li>
   *   <li>Then calls {@link Role#name()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserHelper#createRole(String)}
   */
  @Test
  @DisplayName("Test createRole(String); given Role name() return 'Name'; then calls name()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long UserHelper.createRole(String)"})
  void testCreateRole_givenRoleNameReturnName_thenCallsName2() {
    // Arrange
    Role role = mock(Role.class);
    when(role.name()).thenReturn("Name");
    Role role2 = mock(Role.class);
    when(role2.name()).thenReturn("Name");

    HashSet<Role> roleSet = new HashSet<>();
    roleSet.add(role2);
    roleSet.add(role);
    when(roleService.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(1L);
    when(roleService.findAllRoles()).thenReturn(roleSet);

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
   * Test {@link UserHelper#createUser(String)}.
   * <p>
   * Method under test: {@link UserHelper#createUser(String)}
   */
  @Test
  @DisplayName("Test createUser(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserHelper.createUser(String)"})
  void testCreateUser() {
    // Arrange
    when(userService.registerNewUser(Mockito.<UserRegistrationRequest>any())).thenReturn(1);

    // Act
    userHelper.createUser("User");

    // Assert
    verify(userService).registerNewUser(isA(UserRegistrationRequest.class));
  }

  /**
   * Test {@link UserHelper#createUserWithRoles(String, String[])}.
   * <p>
   * Method under test: {@link UserHelper#createUserWithRoles(String, String[])}
   */
  @Test
  @DisplayName("Test createUserWithRoles(String, String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserHelper.createUserWithRoles(String, String[])"})
  void testCreateUserWithRoles() throws IllegalArgumentException {
    // Arrange
    when(roleService.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(1L);
    when(roleService.findAllRoles()).thenReturn(new HashSet<>());
    when(userRoleService.updateRoles(Mockito.<String>any(), Mockito.<String>any(), Mockito.<UpdateRolesCommand>any()))
        .thenReturn(1);
    when(userService.registerNewUser(Mockito.<UserRegistrationRequest>any())).thenReturn(1);

    // Act
    userHelper.createUserWithRoles("User", "Roles");

    // Assert
    verify(roleService).create(eq("Roles"), eq("Roles name"), eq("Roles desc"));
    verify(roleService).findAllRoles();
    verify(userRoleService).updateRoles(eq("User"), eq("User"), isA(UpdateRolesCommand.class));
    verify(userService).registerNewUser(isA(UserRegistrationRequest.class));
  }

  /**
   * Test {@link UserHelper#createUserWithRoles(String, String[])}.
   * <ul>
   *   <li>Given {@link Role} {@link Role#name()} return {@code Name}.</li>
   *   <li>Then calls {@link Role#name()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserHelper#createUserWithRoles(String, String[])}
   */
  @Test
  @DisplayName("Test createUserWithRoles(String, String[]); given Role name() return 'Name'; then calls name()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserHelper.createUserWithRoles(String, String[])"})
  void testCreateUserWithRoles_givenRoleNameReturnName_thenCallsName() throws IllegalArgumentException {
    // Arrange
    Role role = mock(Role.class);
    when(role.name()).thenReturn("Name");

    HashSet<Role> roleSet = new HashSet<>();
    roleSet.add(role);
    when(roleService.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(1L);
    when(roleService.findAllRoles()).thenReturn(roleSet);
    when(userRoleService.updateRoles(Mockito.<String>any(), Mockito.<String>any(), Mockito.<UpdateRolesCommand>any()))
        .thenReturn(1);
    when(userService.registerNewUser(Mockito.<UserRegistrationRequest>any())).thenReturn(1);

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
   * Test {@link UserHelper#createUserWithRoles(String, String[])}.
   * <ul>
   *   <li>Given {@link Role} {@link Role#name()} return {@code Name}.</li>
   *   <li>Then calls {@link Role#name()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserHelper#createUserWithRoles(String, String[])}
   */
  @Test
  @DisplayName("Test createUserWithRoles(String, String[]); given Role name() return 'Name'; then calls name()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserHelper.createUserWithRoles(String, String[])"})
  void testCreateUserWithRoles_givenRoleNameReturnName_thenCallsName2() throws IllegalArgumentException {
    // Arrange
    Role role = mock(Role.class);
    when(role.name()).thenReturn("Name");
    Role role2 = mock(Role.class);
    when(role2.name()).thenReturn("Name");

    HashSet<Role> roleSet = new HashSet<>();
    roleSet.add(role2);
    roleSet.add(role);
    when(roleService.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(1L);
    when(roleService.findAllRoles()).thenReturn(roleSet);
    when(userRoleService.updateRoles(Mockito.<String>any(), Mockito.<String>any(), Mockito.<UpdateRolesCommand>any()))
        .thenReturn(1);
    when(userService.registerNewUser(Mockito.<UserRegistrationRequest>any())).thenReturn(1);

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
   * Test {@link UserHelper#createUserWithSystemRoles(String, Set)}.
   * <ul>
   *   <li>Given {@code ACTOR_ADMIN}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code ACTOR_ADMIN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserHelper#createUserWithSystemRoles(String, Set)}
   */
  @Test
  @DisplayName("Test createUserWithSystemRoles(String, Set); given 'ACTOR_ADMIN'; when HashSet() add 'ACTOR_ADMIN'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserHelper.createUserWithSystemRoles(String, Set)"})
  void testCreateUserWithSystemRoles_givenActorAdmin_whenHashSetAddActorAdmin() throws IllegalArgumentException {
    // Arrange
    when(userRoleService.updateRoles(Mockito.<String>any(), Mockito.<String>any(), Mockito.<UpdateRolesCommand>any()))
        .thenReturn(1);
    when(userService.registerNewUser(Mockito.<UserRegistrationRequest>any())).thenReturn(1);

    HashSet<SystemRole> roles = new HashSet<>();
    roles.add(SystemRole.ACTOR_ADMIN);

    // Act
    userHelper.createUserWithSystemRoles("User", roles);

    // Assert
    verify(userRoleService).updateRoles(eq("User"), eq("User"), isA(UpdateRolesCommand.class));
    verify(userService).registerNewUser(isA(UserRegistrationRequest.class));
  }

  /**
   * Test {@link UserHelper#createUserWithSystemRoles(String, Set)}.
   * <ul>
   *   <li>Given {@code ADMIN}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code ADMIN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserHelper#createUserWithSystemRoles(String, Set)}
   */
  @Test
  @DisplayName("Test createUserWithSystemRoles(String, Set); given 'ADMIN'; when HashSet() add 'ADMIN'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserHelper.createUserWithSystemRoles(String, Set)"})
  void testCreateUserWithSystemRoles_givenAdmin_whenHashSetAddAdmin() throws IllegalArgumentException {
    // Arrange
    when(userRoleService.updateRoles(Mockito.<String>any(), Mockito.<String>any(), Mockito.<UpdateRolesCommand>any()))
        .thenReturn(1);
    when(userService.registerNewUser(Mockito.<UserRegistrationRequest>any())).thenReturn(1);

    HashSet<SystemRole> roles = new HashSet<>();
    roles.add(SystemRole.ADMIN);
    roles.add(SystemRole.ACTOR_ADMIN);

    // Act
    userHelper.createUserWithSystemRoles("User", roles);

    // Assert
    verify(userRoleService).updateRoles(eq("User"), eq("User"), isA(UpdateRolesCommand.class));
    verify(userService).registerNewUser(isA(UserRegistrationRequest.class));
  }

  /**
   * Test {@link UserHelper#createUserWithSystemRoles(String, Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserHelper#createUserWithSystemRoles(String, Set)}
   */
  @Test
  @DisplayName("Test createUserWithSystemRoles(String, Set); when HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserHelper.createUserWithSystemRoles(String, Set)"})
  void testCreateUserWithSystemRoles_whenHashSet() throws IllegalArgumentException {
    // Arrange
    when(userRoleService.updateRoles(Mockito.<String>any(), Mockito.<String>any(), Mockito.<UpdateRolesCommand>any()))
        .thenReturn(1);
    when(userService.registerNewUser(Mockito.<UserRegistrationRequest>any())).thenReturn(1);

    // Act
    userHelper.createUserWithSystemRoles("User", new HashSet<>());

    // Assert
    verify(userRoleService).updateRoles(eq("User"), eq("User"), isA(UpdateRolesCommand.class));
    verify(userService).registerNewUser(isA(UserRegistrationRequest.class));
  }
}
