package org.finos.waltz.service.role;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.data.role.RoleDao;
import org.finos.waltz.data.user.UserRoleDao;
import org.finos.waltz.model.role.Role;
import org.finos.waltz.model.role.RoleView.ImmutableRoleView;
import org.finos.waltz.model.role.RoleView.RoleView;
import org.finos.waltz.model.user.User;
import org.finos.waltz.schema.tables.records.RoleRecord;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RoleServiceDiffblueTest {
  /**
   * Method under test: {@link RoleService#create(String, String, String)}
   */
  @Test
  void testCreate() {
    // Arrange
    RoleDao roleDao = mock(RoleDao.class);
    when(roleDao.create(Mockito.<RoleRecord>any())).thenReturn(1L);

    // Act
    Long actualCreateResult = (new RoleService(roleDao, mock(UserRoleDao.class))).create("Key", "Role Name",
        "The characteristics of someone or something");

    // Assert
    verify(roleDao).create(isA(RoleRecord.class));
    assertEquals(1L, actualCreateResult.longValue());
  }

  /**
   * Method under test: {@link RoleService#findAllRoles()}
   */
  @Test
  void testFindAllRoles() {
    // Arrange
    RoleDao roleDao = mock(RoleDao.class);
    HashSet<Role> roleSet = new HashSet<>();
    when(roleDao.findAllRoles()).thenReturn(roleSet);

    // Act
    Set<Role> actualFindAllRolesResult = (new RoleService(roleDao, mock(UserRoleDao.class))).findAllRoles();

    // Assert
    verify(roleDao).findAllRoles();
    assertTrue(actualFindAllRolesResult.isEmpty());
    assertSame(roleSet, actualFindAllRolesResult);
  }

  /**
   * Method under test: {@link RoleService#getRoleView(Long)}
   */
  @Test
  void testGetRoleView() {
    // Arrange
    RoleDao roleDao = mock(RoleDao.class);
    when(roleDao.getRoleById(Mockito.<Long>any())).thenReturn(mock(Role.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.findUsersForRole(Mockito.<Long>any())).thenReturn(new HashSet<>());

    // Act
    RoleView actualRoleView = (new RoleService(roleDao, userRoleDao)).getRoleView(1L);

    // Assert
    verify(roleDao).getRoleById(eq(1L));
    verify(userRoleDao).findUsersForRole(eq(1L));
    assertTrue(actualRoleView instanceof ImmutableRoleView);
    assertTrue(actualRoleView.users().isEmpty());
  }

  /**
   * Method under test: {@link RoleService#getRoleView(Long)}
   */
  @Test
  void testGetRoleView2() {
    // Arrange
    RoleDao roleDao = mock(RoleDao.class);
    when(roleDao.getRoleById(Mockito.<Long>any())).thenReturn(mock(Role.class));
    User user = mock(User.class);
    when(user.userName()).thenReturn("janedoe");

    HashSet<User> userSet = new HashSet<>();
    userSet.add(user);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.findUsersForRole(Mockito.<Long>any())).thenReturn(userSet);

    // Act
    RoleView actualRoleView = (new RoleService(roleDao, userRoleDao)).getRoleView(1L);

    // Assert
    verify(roleDao).getRoleById(eq(1L));
    verify(userRoleDao).findUsersForRole(eq(1L));
    verify(user).userName();
    assertTrue(actualRoleView instanceof ImmutableRoleView);
    Set<String> usersResult = actualRoleView.users();
    assertEquals(1, usersResult.size());
    assertTrue(usersResult.contains("janedoe"));
  }
}
