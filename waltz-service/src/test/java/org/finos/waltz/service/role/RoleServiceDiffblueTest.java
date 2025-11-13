package org.finos.waltz.service.role;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.data.role.RoleDao;
import org.finos.waltz.data.user.UserRoleDao;
import org.finos.waltz.model.role.ImmutableRole;
import org.finos.waltz.model.role.Role;
import org.finos.waltz.model.role.RoleView.ImmutableRoleView;
import org.finos.waltz.model.role.RoleView.RoleView;
import org.finos.waltz.model.user.ImmutableUser;
import org.finos.waltz.model.user.ImmutableUser.Builder;
import org.finos.waltz.model.user.User;
import org.finos.waltz.schema.tables.records.RoleRecord;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RoleServiceDiffblueTest {
  /**
   * Test {@link RoleService#create(String, String, String)}.
   *
   * <ul>
   *   <li>Given {@link RoleDao} {@link RoleDao#create(RoleRecord)} return one.
   *   <li>When {@code Key}.
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link RoleService#create(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test create(String, String, String); given RoleDao create(RoleRecord) return one; when 'Key'; then return longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long RoleService.create(String, String, String)"})
  void testCreate_givenRoleDaoCreateReturnOne_whenKey_thenReturnLongValueIsOne() {
    // Arrange
    RoleDao roleDao = mock(RoleDao.class);
    when(roleDao.create(Mockito.<RoleRecord>any())).thenReturn(1L);
    RoleService roleService = new RoleService(roleDao, mock(UserRoleDao.class));

    // Act
    Long actualCreateResult =
        roleService.create("Key", "Role Name", "The characteristics of someone or something");

    // Assert
    verify(roleDao).create(isA(RoleRecord.class));
    assertEquals(1L, actualCreateResult.longValue());
  }

  /**
   * Test {@link RoleService#findAllRoles()}.
   *
   * <p>Method under test: {@link RoleService#findAllRoles()}
   */
  @Test
  @DisplayName("Test findAllRoles()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set RoleService.findAllRoles()"})
  void testFindAllRoles() {
    // Arrange
    RoleDao roleDao = mock(RoleDao.class);
    when(roleDao.findAllRoles()).thenReturn(new HashSet<>());
    RoleService roleService = new RoleService(roleDao, mock(UserRoleDao.class));

    // Act
    Set<Role> actualFindAllRolesResult = roleService.findAllRoles();

    // Assert
    verify(roleDao).findAllRoles();
    assertTrue(actualFindAllRolesResult.isEmpty());
  }

  /**
   * Test {@link RoleService#getRoleView(Long)}.
   *
   * <ul>
   *   <li>Given builder addRoles {@code role}.
   *   <li>Then return users size is one.
   * </ul>
   *
   * <p>Method under test: {@link RoleService#getRoleView(Long)}
   */
  @Test
  @DisplayName(
      "Test getRoleView(Long); given builder addRoles 'role'; then return users size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RoleView RoleService.getRoleView(Long)"})
  void testGetRoleView_givenBuilderAddRolesRole_thenReturnUsersSizeIsOne() {
    // Arrange
    RoleDao roleDao = mock(RoleDao.class);
    when(roleDao.getRoleById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableRole.builder()
                .description("The characteristics of someone or something")
                .id(1L)
                .isCustom(true)
                .key("Key")
                .name("Name")
                .build());

    Builder builderResult = ImmutableUser.builder();
    builderResult.addRoles("role");
    ImmutableUser immutableUser = builderResult.userName("janedoe").build();

    HashSet<User> userSet = new HashSet<>();
    userSet.add(ImmutableUser.builder().userName("janedoe").build());
    userSet.add(immutableUser);

    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.findUsersForRole(Mockito.<Long>any())).thenReturn(userSet);

    RoleService roleService = new RoleService(roleDao, userRoleDao);

    // Act
    RoleView actualRoleView = roleService.getRoleView(1L);

    // Assert
    verify(roleDao).getRoleById(1L);
    verify(userRoleDao).findUsersForRole(1L);
    Role roleResult = actualRoleView.role();
    assertTrue(roleResult instanceof ImmutableRole);
    assertTrue(actualRoleView instanceof ImmutableRoleView);
    assertEquals("Key", roleResult.key());
    assertEquals("Name", roleResult.name());
    assertEquals("The characteristics of someone or something", roleResult.description());
    Set<String> usersResult = actualRoleView.users();
    assertEquals(1, usersResult.size());
    assertTrue(usersResult.contains("janedoe"));
    assertTrue(roleResult.isCustom());
    assertTrue(roleResult.userSelectable());
  }

  /**
   * Test {@link RoleService#getRoleView(Long)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add builder userName {@code role} build.
   *   <li>Then return users size is two.
   * </ul>
   *
   * <p>Method under test: {@link RoleService#getRoleView(Long)}
   */
  @Test
  @DisplayName(
      "Test getRoleView(Long); given HashSet() add builder userName 'role' build; then return users size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RoleView RoleService.getRoleView(Long)"})
  void testGetRoleView_givenHashSetAddBuilderUserNameRoleBuild_thenReturnUsersSizeIsTwo() {
    // Arrange
    RoleDao roleDao = mock(RoleDao.class);
    when(roleDao.getRoleById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableRole.builder()
                .description("The characteristics of someone or something")
                .id(1L)
                .isCustom(true)
                .key("Key")
                .name("Name")
                .build());

    Builder builderResult = ImmutableUser.builder();
    builderResult.addRoles("role");
    ImmutableUser immutableUser = builderResult.userName("role").build();

    HashSet<User> userSet = new HashSet<>();
    userSet.add(ImmutableUser.builder().userName("janedoe").build());
    userSet.add(immutableUser);

    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.findUsersForRole(Mockito.<Long>any())).thenReturn(userSet);

    RoleService roleService = new RoleService(roleDao, userRoleDao);

    // Act
    RoleView actualRoleView = roleService.getRoleView(1L);

    // Assert
    verify(roleDao).getRoleById(1L);
    verify(userRoleDao).findUsersForRole(1L);
    Role roleResult = actualRoleView.role();
    assertTrue(roleResult instanceof ImmutableRole);
    assertTrue(actualRoleView instanceof ImmutableRoleView);
    assertEquals("Key", roleResult.key());
    assertEquals("Name", roleResult.name());
    assertEquals("The characteristics of someone or something", roleResult.description());
    Set<String> usersResult = actualRoleView.users();
    assertEquals(2, usersResult.size());
    assertTrue(usersResult.contains("janedoe"));
    assertTrue(usersResult.contains("role"));
    assertTrue(roleResult.isCustom());
    assertTrue(roleResult.userSelectable());
  }

  /**
   * Test {@link RoleService#getRoleView(Long)}.
   *
   * <ul>
   *   <li>Then return users Empty.
   * </ul>
   *
   * <p>Method under test: {@link RoleService#getRoleView(Long)}
   */
  @Test
  @DisplayName("Test getRoleView(Long); then return users Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RoleView RoleService.getRoleView(Long)"})
  void testGetRoleView_thenReturnUsersEmpty() {
    // Arrange
    RoleDao roleDao = mock(RoleDao.class);
    when(roleDao.getRoleById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableRole.builder()
                .description("The characteristics of someone or something")
                .id(1L)
                .isCustom(true)
                .key("Key")
                .name("Name")
                .build());

    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.findUsersForRole(Mockito.<Long>any())).thenReturn(new HashSet<>());

    RoleService roleService = new RoleService(roleDao, userRoleDao);

    // Act
    RoleView actualRoleView = roleService.getRoleView(1L);

    // Assert
    verify(roleDao).getRoleById(1L);
    verify(userRoleDao).findUsersForRole(1L);
    Role roleResult = actualRoleView.role();
    assertTrue(roleResult instanceof ImmutableRole);
    assertTrue(actualRoleView instanceof ImmutableRoleView);
    assertEquals("Key", roleResult.key());
    assertEquals("Name", roleResult.name());
    assertEquals("The characteristics of someone or something", roleResult.description());
    assertTrue(actualRoleView.users().isEmpty());
    assertTrue(roleResult.isCustom());
    assertTrue(roleResult.userSelectable());
  }

  /**
   * Test {@link RoleService#getRoleView(Long)}.
   *
   * <ul>
   *   <li>Then return users size is one.
   * </ul>
   *
   * <p>Method under test: {@link RoleService#getRoleView(Long)}
   */
  @Test
  @DisplayName("Test getRoleView(Long); then return users size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RoleView RoleService.getRoleView(Long)"})
  void testGetRoleView_thenReturnUsersSizeIsOne() {
    // Arrange
    RoleDao roleDao = mock(RoleDao.class);
    when(roleDao.getRoleById(Mockito.<Long>any()))
        .thenReturn(
            ImmutableRole.builder()
                .description("The characteristics of someone or something")
                .id(1L)
                .isCustom(true)
                .key("Key")
                .name("Name")
                .build());

    HashSet<User> userSet = new HashSet<>();
    userSet.add(ImmutableUser.builder().userName("janedoe").build());

    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.findUsersForRole(Mockito.<Long>any())).thenReturn(userSet);

    RoleService roleService = new RoleService(roleDao, userRoleDao);

    // Act
    RoleView actualRoleView = roleService.getRoleView(1L);

    // Assert
    verify(roleDao).getRoleById(1L);
    verify(userRoleDao).findUsersForRole(1L);
    Role roleResult = actualRoleView.role();
    assertTrue(roleResult instanceof ImmutableRole);
    assertTrue(actualRoleView instanceof ImmutableRoleView);
    assertEquals("Key", roleResult.key());
    assertEquals("Name", roleResult.name());
    assertEquals("The characteristics of someone or something", roleResult.description());
    Set<String> usersResult = actualRoleView.users();
    assertEquals(1, usersResult.size());
    assertTrue(usersResult.contains("janedoe"));
    assertTrue(roleResult.isCustom());
    assertTrue(roleResult.userSelectable());
  }
}
