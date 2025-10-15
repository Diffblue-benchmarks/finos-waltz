package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.model.role.ImmutableRole;
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
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserHelperDiffblueTest {
  @Mock private RoleService roleService;

  @InjectMocks private UserHelper userHelper;

  @Mock private UserRoleService userRoleService;

  @Mock private UserService userService;

  /**
   * Test {@link UserHelper#createRole(String)}.
   *
   * <ul>
   *   <li>Given {@link RoleService} {@link RoleService#create(String, String, String)} return one.
   *   <li>When {@code Role}.
   *   <li>Then calls {@link RoleService#create(String, String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link UserHelper#createRole(String)}
   */
  @Test
  @DisplayName(
      "Test createRole(String); given RoleService create(String, String, String) return one; when 'Role'; then calls create(String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long UserHelper.createRole(String)"})
  void testCreateRole_givenRoleServiceCreateReturnOne_whenRole_thenCallsCreate() {
    // Arrange
    when(roleService.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(1L);
    when(roleService.findAllRoles()).thenReturn(new HashSet<>());

    // Act
    Long actualCreateRoleResult = userHelper.createRole("Role");

    // Assert
    verify(roleService).create("Role", "Role name", "Role desc");
    verify(roleService).findAllRoles();
    assertEquals(1L, actualCreateRoleResult.longValue());
  }

  /**
   * Test {@link UserHelper#createRole(String)}.
   *
   * <ul>
   *   <li>Then calls {@link RoleService#create(String, String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link UserHelper#createRole(String)}
   */
  @Test
  @DisplayName("Test createRole(String); then calls create(String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long UserHelper.createRole(String)"})
  void testCreateRole_thenCallsCreate() {
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
    when(roleService.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(1L);
    when(roleService.findAllRoles()).thenReturn(roleSet);

    // Act
    Long actualCreateRoleResult = userHelper.createRole("Role");

    // Assert
    verify(roleService).create("Role", "Role name", "Role desc");
    verify(roleService).findAllRoles();
    assertEquals(1L, actualCreateRoleResult.longValue());
  }

  /**
   * Test {@link UserHelper#createRole(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link UserHelper#createRole(String)}
   */
  @Test
  @DisplayName("Test createRole(String); when 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long UserHelper.createRole(String)"})
  void testCreateRole_whenName() {
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
    when(roleService.findAllRoles()).thenReturn(roleSet);

    // Act
    Long actualCreateRoleResult = userHelper.createRole("Name");

    // Assert
    verify(roleService).findAllRoles();
    assertEquals(1L, actualCreateRoleResult.longValue());
  }

  /**
   * Test {@link UserHelper#createUser(String)}.
   *
   * <p>Method under test: {@link UserHelper#createUser(String)}
   */
  @Test
  @DisplayName("Test createUser(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link UserHelper#createUserWithRoles(String, String[])}
   */
  @Test
  @DisplayName("Test createUserWithRoles(String, String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserHelper.createUserWithRoles(String, String[])"})
  void testCreateUserWithRoles() throws IllegalArgumentException {
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
    when(roleService.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(1L);
    when(roleService.findAllRoles()).thenReturn(roleSet);
    when(userRoleService.updateRoles(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<UpdateRolesCommand>any()))
        .thenReturn(1);
    when(userService.registerNewUser(Mockito.<UserRegistrationRequest>any())).thenReturn(1);

    // Act
    userHelper.createUserWithRoles("User", "Roles");

    // Assert
    verify(roleService).create("Roles", "Roles name", "Roles desc");
    verify(roleService).findAllRoles();
    verify(userRoleService).updateRoles(eq("User"), eq("User"), isA(UpdateRolesCommand.class));
    verify(userService).registerNewUser(isA(UserRegistrationRequest.class));
  }

  /**
   * Test {@link UserHelper#createUserWithRoles(String, String[])}.
   *
   * <ul>
   *   <li>When {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link UserHelper#createUserWithRoles(String, String[])}
   */
  @Test
  @DisplayName("Test createUserWithRoles(String, String[]); when 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserHelper.createUserWithRoles(String, String[])"})
  void testCreateUserWithRoles_whenName() throws IllegalArgumentException {
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
    when(roleService.findAllRoles()).thenReturn(roleSet);
    when(userRoleService.updateRoles(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<UpdateRolesCommand>any()))
        .thenReturn(1);
    when(userService.registerNewUser(Mockito.<UserRegistrationRequest>any())).thenReturn(1);

    // Act
    userHelper.createUserWithRoles("User", "Name");

    // Assert
    verify(roleService).findAllRoles();
    verify(userRoleService).updateRoles(eq("User"), eq("User"), isA(UpdateRolesCommand.class));
    verify(userService).registerNewUser(isA(UserRegistrationRequest.class));
  }

  /**
   * Test {@link UserHelper#createUserWithRoles(String, String[])}.
   *
   * <ul>
   *   <li>When {@code name} and {@code desc}.
   *   <li>Then calls {@link RoleService#create(String, String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link UserHelper#createUserWithRoles(String, String[])}
   */
  @Test
  @DisplayName(
      "Test createUserWithRoles(String, String[]); when 'name' and 'desc'; then calls create(String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserHelper.createUserWithRoles(String, String[])"})
  void testCreateUserWithRoles_whenNameAndDesc_thenCallsCreate() throws IllegalArgumentException {
    // Arrange
    when(roleService.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(1L);
    when(roleService.findAllRoles()).thenReturn(new HashSet<>());
    when(userRoleService.updateRoles(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<UpdateRolesCommand>any()))
        .thenReturn(1);
    when(userService.registerNewUser(Mockito.<UserRegistrationRequest>any())).thenReturn(1);

    // Act
    userHelper.createUserWithRoles("User", " name", " desc");

    // Assert
    verify(roleService, atLeast(1))
        .create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());
    verify(roleService, atLeast(1)).findAllRoles();
    verify(userRoleService).updateRoles(eq("User"), eq("User"), isA(UpdateRolesCommand.class));
    verify(userService).registerNewUser(isA(UserRegistrationRequest.class));
  }

  /**
   * Test {@link UserHelper#createUserWithRoles(String, String[])}.
   *
   * <ul>
   *   <li>When {@code Roles}.
   *   <li>Then calls {@link RoleService#create(String, String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link UserHelper#createUserWithRoles(String, String[])}
   */
  @Test
  @DisplayName(
      "Test createUserWithRoles(String, String[]); when 'Roles'; then calls create(String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserHelper.createUserWithRoles(String, String[])"})
  void testCreateUserWithRoles_whenRoles_thenCallsCreate() throws IllegalArgumentException {
    // Arrange
    when(roleService.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(1L);
    when(roleService.findAllRoles()).thenReturn(new HashSet<>());
    when(userRoleService.updateRoles(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<UpdateRolesCommand>any()))
        .thenReturn(1);
    when(userService.registerNewUser(Mockito.<UserRegistrationRequest>any())).thenReturn(1);

    // Act
    userHelper.createUserWithRoles("User", "Roles");

    // Assert
    verify(roleService).create("Roles", "Roles name", "Roles desc");
    verify(roleService).findAllRoles();
    verify(userRoleService).updateRoles(eq("User"), eq("User"), isA(UpdateRolesCommand.class));
    verify(userService).registerNewUser(isA(UserRegistrationRequest.class));
  }

  /**
   * Test {@link UserHelper#createUserWithRoles(String, String[])}.
   *
   * <ul>
   *   <li>When {@code User}.
   * </ul>
   *
   * <p>Method under test: {@link UserHelper#createUserWithRoles(String, String[])}
   */
  @Test
  @DisplayName("Test createUserWithRoles(String, String[]); when 'User'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserHelper.createUserWithRoles(String, String[])"})
  void testCreateUserWithRoles_whenUser() throws IllegalArgumentException {
    // Arrange
    when(userRoleService.updateRoles(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<UpdateRolesCommand>any()))
        .thenReturn(1);
    when(userService.registerNewUser(Mockito.<UserRegistrationRequest>any())).thenReturn(1);

    // Act
    userHelper.createUserWithRoles("User");

    // Assert
    verify(userRoleService).updateRoles(eq("User"), eq("User"), isA(UpdateRolesCommand.class));
    verify(userService).registerNewUser(isA(UserRegistrationRequest.class));
  }

  /**
   * Test {@link UserHelper#createUserWithSystemRoles(String, Set)}.
   *
   * <ul>
   *   <li>Given {@code ACTOR_ADMIN}.
   *   <li>When {@link HashSet#HashSet()} add {@code ACTOR_ADMIN}.
   * </ul>
   *
   * <p>Method under test: {@link UserHelper#createUserWithSystemRoles(String, Set)}
   */
  @Test
  @DisplayName(
      "Test createUserWithSystemRoles(String, Set); given 'ACTOR_ADMIN'; when HashSet() add 'ACTOR_ADMIN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserHelper.createUserWithSystemRoles(String, Set)"})
  void testCreateUserWithSystemRoles_givenActorAdmin_whenHashSetAddActorAdmin()
      throws IllegalArgumentException {
    // Arrange
    when(userRoleService.updateRoles(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<UpdateRolesCommand>any()))
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
   *
   * <ul>
   *   <li>Given {@code ADMIN}.
   *   <li>When {@link HashSet#HashSet()} add {@code ADMIN}.
   * </ul>
   *
   * <p>Method under test: {@link UserHelper#createUserWithSystemRoles(String, Set)}
   */
  @Test
  @DisplayName(
      "Test createUserWithSystemRoles(String, Set); given 'ADMIN'; when HashSet() add 'ADMIN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserHelper.createUserWithSystemRoles(String, Set)"})
  void testCreateUserWithSystemRoles_givenAdmin_whenHashSetAddAdmin()
      throws IllegalArgumentException {
    // Arrange
    when(userRoleService.updateRoles(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<UpdateRolesCommand>any()))
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
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link UserHelper#createUserWithSystemRoles(String, Set)}
   */
  @Test
  @DisplayName("Test createUserWithSystemRoles(String, Set); when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserHelper.createUserWithSystemRoles(String, Set)"})
  void testCreateUserWithSystemRoles_whenHashSet() throws IllegalArgumentException {
    // Arrange
    when(userRoleService.updateRoles(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<UpdateRolesCommand>any()))
        .thenReturn(1);
    when(userService.registerNewUser(Mockito.<UserRegistrationRequest>any())).thenReturn(1);

    // Act
    userHelper.createUserWithSystemRoles("User", new HashSet<>());

    // Assert
    verify(userRoleService).updateRoles(eq("User"), eq("User"), isA(UpdateRolesCommand.class));
    verify(userService).registerNewUser(isA(UserRegistrationRequest.class));
  }
}
