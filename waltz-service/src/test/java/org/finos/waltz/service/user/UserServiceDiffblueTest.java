package org.finos.waltz.service.user;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.data.user.UserDao;
import org.finos.waltz.data.user.UserRoleDao;
import org.finos.waltz.model.user.LoginRequest;
import org.finos.waltz.model.user.PasswordResetRequest;
import org.finos.waltz.service.settings.SettingsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class UserServiceDiffblueTest {
  /**
   * Method under test: {@link UserService#authenticate(LoginRequest)}
   */
  @Test
  void testAuthenticate() {
    // Arrange
    UserDao userDao = mock(UserDao.class);
    when(userDao.getPassword(Mockito.<String>any())).thenReturn("iloveyou");
    PasswordService passwordService = mock(PasswordService.class);
    when(passwordService.verifyPassword(Mockito.<String>any(), Mockito.<String>any())).thenReturn(true);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    UserService userService = new UserService(userDao, userRoleDao, passwordService,
        new SettingsService(settingsDao, new ArrayList<>()));
    LoginRequest request = mock(LoginRequest.class);
    when(request.password()).thenReturn("iloveyou");
    when(request.userName()).thenReturn("janedoe");

    // Act
    boolean actualAuthenticateResult = userService.authenticate(request);

    // Assert
    verify(userDao).getPassword(eq("janedoe"));
    verify(request).password();
    verify(request).userName();
    verify(passwordService).verifyPassword(eq("iloveyou"), eq("iloveyou"));
    assertTrue(actualAuthenticateResult);
  }

  /**
   * Method under test: {@link UserService#authenticate(LoginRequest)}
   */
  @Test
  void testAuthenticate2() {
    // Arrange
    UserDao userDao = mock(UserDao.class);
    when(userDao.getPassword(Mockito.<String>any())).thenReturn("iloveyou");
    PasswordService passwordService = mock(PasswordService.class);
    when(passwordService.verifyPassword(Mockito.<String>any(), Mockito.<String>any())).thenReturn(false);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    UserService userService = new UserService(userDao, userRoleDao, passwordService,
        new SettingsService(settingsDao, new ArrayList<>()));
    LoginRequest request = mock(LoginRequest.class);
    when(request.password()).thenReturn("iloveyou");
    when(request.userName()).thenReturn("janedoe");

    // Act
    boolean actualAuthenticateResult = userService.authenticate(request);

    // Assert
    verify(userDao).getPassword(eq("janedoe"));
    verify(request).password();
    verify(request).userName();
    verify(passwordService).verifyPassword(eq("iloveyou"), eq("iloveyou"));
    assertFalse(actualAuthenticateResult);
  }

  /**
   * Method under test: {@link UserService#deleteUser(String)}
   */
  @Test
  void testDeleteUser() {
    // Arrange
    UserDao userDao = mock(UserDao.class);
    when(userDao.deleteUser(Mockito.<String>any())).thenReturn(1);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    PasswordService passwordService = new PasswordService();
    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    boolean actualDeleteUserResult = (new UserService(userDao, userRoleDao, passwordService,
        new SettingsService(settingsDao, new ArrayList<>()))).deleteUser("janedoe");

    // Assert
    verify(userDao).deleteUser(eq("janedoe"));
    assertTrue(actualDeleteUserResult);
  }

  /**
   * Method under test: {@link UserService#findAllUserNames()}
   */
  @Test
  void testFindAllUserNames() {
    // Arrange
    UserDao userDao = mock(UserDao.class);
    ArrayList<String> stringList = new ArrayList<>();
    when(userDao.findAllUserNames()).thenReturn(stringList);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    PasswordService passwordService = new PasswordService();
    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    List<String> actualFindAllUserNamesResult = (new UserService(userDao, userRoleDao, passwordService,
        new SettingsService(settingsDao, new ArrayList<>()))).findAllUserNames();

    // Assert
    verify(userDao).findAllUserNames();
    assertTrue(actualFindAllUserNamesResult.isEmpty());
    assertSame(stringList, actualFindAllUserNamesResult);
  }

  /**
   * Method under test:
   * {@link UserService#resetPassword(PasswordResetRequest, boolean)}
   */
  @Test
  void testResetPassword() {
    // Arrange
    UserDao userDao = mock(UserDao.class);
    when(userDao.resetPassword(Mockito.<String>any(), Mockito.<String>any())).thenReturn(1);
    when(userDao.getPassword(Mockito.<String>any())).thenReturn("iloveyou");
    PasswordService passwordService = mock(PasswordService.class);
    when(passwordService.hashPassword(Mockito.<String>any())).thenReturn("iloveyou");
    when(passwordService.verifyPassword(Mockito.<String>any(), Mockito.<String>any())).thenReturn(true);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    UserService userService = new UserService(userDao, userRoleDao, passwordService,
        new SettingsService(settingsDao, new ArrayList<>()));
    PasswordResetRequest resetRequest = mock(PasswordResetRequest.class);
    when(resetRequest.newPassword()).thenReturn("iloveyou");
    when(resetRequest.currentPassword()).thenReturn("iloveyou");
    when(resetRequest.userName()).thenReturn("janedoe");

    // Act
    boolean actualResetPasswordResult = userService.resetPassword(resetRequest, true);

    // Assert
    verify(userDao).getPassword(eq("janedoe"));
    verify(userDao).resetPassword(eq("janedoe"), eq("iloveyou"));
    verify(resetRequest).currentPassword();
    verify(resetRequest).newPassword();
    verify(resetRequest, atLeast(1)).userName();
    verify(passwordService).hashPassword(eq("iloveyou"));
    verify(passwordService).verifyPassword(eq("iloveyou"), eq("iloveyou"));
    assertTrue(actualResetPasswordResult);
  }

  /**
   * Method under test:
   * {@link UserService#resetPassword(PasswordResetRequest, boolean)}
   */
  @Test
  void testResetPassword2() {
    // Arrange
    UserDao userDao = mock(UserDao.class);
    when(userDao.resetPassword(Mockito.<String>any(), Mockito.<String>any())).thenReturn(3);
    when(userDao.getPassword(Mockito.<String>any())).thenReturn("iloveyou");
    PasswordService passwordService = mock(PasswordService.class);
    when(passwordService.hashPassword(Mockito.<String>any())).thenReturn("iloveyou");
    when(passwordService.verifyPassword(Mockito.<String>any(), Mockito.<String>any())).thenReturn(true);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    UserService userService = new UserService(userDao, userRoleDao, passwordService,
        new SettingsService(settingsDao, new ArrayList<>()));
    PasswordResetRequest resetRequest = mock(PasswordResetRequest.class);
    when(resetRequest.newPassword()).thenReturn("iloveyou");
    when(resetRequest.currentPassword()).thenReturn("iloveyou");
    when(resetRequest.userName()).thenReturn("janedoe");

    // Act
    boolean actualResetPasswordResult = userService.resetPassword(resetRequest, true);

    // Assert
    verify(userDao).getPassword(eq("janedoe"));
    verify(userDao).resetPassword(eq("janedoe"), eq("iloveyou"));
    verify(resetRequest).currentPassword();
    verify(resetRequest).newPassword();
    verify(resetRequest, atLeast(1)).userName();
    verify(passwordService).hashPassword(eq("iloveyou"));
    verify(passwordService).verifyPassword(eq("iloveyou"), eq("iloveyou"));
    assertFalse(actualResetPasswordResult);
  }

  /**
   * Method under test:
   * {@link UserService#resetPassword(PasswordResetRequest, boolean)}
   */
  @Test
  void testResetPassword3() {
    // Arrange
    UserDao userDao = mock(UserDao.class);
    when(userDao.getPassword(Mockito.<String>any())).thenReturn("iloveyou");
    PasswordService passwordService = mock(PasswordService.class);
    when(passwordService.verifyPassword(Mockito.<String>any(), Mockito.<String>any())).thenReturn(false);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    UserService userService = new UserService(userDao, userRoleDao, passwordService,
        new SettingsService(settingsDao, new ArrayList<>()));
    PasswordResetRequest resetRequest = mock(PasswordResetRequest.class);
    when(resetRequest.currentPassword()).thenReturn("iloveyou");
    when(resetRequest.userName()).thenReturn("janedoe");

    // Act
    boolean actualResetPasswordResult = userService.resetPassword(resetRequest, true);

    // Assert
    verify(userDao).getPassword(eq("janedoe"));
    verify(resetRequest).currentPassword();
    verify(resetRequest, atLeast(1)).userName();
    verify(passwordService).verifyPassword(eq("iloveyou"), eq("iloveyou"));
    assertFalse(actualResetPasswordResult);
  }

  /**
   * Method under test:
   * {@link UserService#resetPassword(PasswordResetRequest, boolean)}
   */
  @Test
  void testResetPassword4() {
    // Arrange
    UserDao userDao = mock(UserDao.class);
    when(userDao.resetPassword(Mockito.<String>any(), Mockito.<String>any())).thenReturn(1);
    PasswordService passwordService = mock(PasswordService.class);
    when(passwordService.hashPassword(Mockito.<String>any())).thenReturn("iloveyou");
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    UserService userService = new UserService(userDao, userRoleDao, passwordService,
        new SettingsService(settingsDao, new ArrayList<>()));
    PasswordResetRequest resetRequest = mock(PasswordResetRequest.class);
    when(resetRequest.newPassword()).thenReturn("iloveyou");
    when(resetRequest.userName()).thenReturn("janedoe");

    // Act
    boolean actualResetPasswordResult = userService.resetPassword(resetRequest, false);

    // Assert
    verify(userDao).resetPassword(eq("janedoe"), eq("iloveyou"));
    verify(resetRequest).newPassword();
    verify(resetRequest, atLeast(1)).userName();
    verify(passwordService).hashPassword(eq("iloveyou"));
    assertTrue(actualResetPasswordResult);
  }
}
