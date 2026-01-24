package org.finos.waltz.service.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.data.user.UserDao;
import org.finos.waltz.data.user.UserRoleDao;
import org.finos.waltz.model.settings.ImmutableSetting;
import org.finos.waltz.model.user.ImmutableLoginRequest;
import org.finos.waltz.model.user.ImmutablePasswordResetRequest;
import org.finos.waltz.model.user.ImmutableUserRegistrationRequest;
import org.finos.waltz.model.user.LoginRequest;
import org.finos.waltz.model.user.PasswordResetRequest;
import org.finos.waltz.model.user.UserRegistrationRequest;
import org.finos.waltz.service.settings.SettingsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceDiffblueTest {
  @Mock private PasswordService passwordService;

  @Mock private SettingsService settingsService;

  @Mock private UserDao userDao;

  @Mock private UserRoleDao userRoleDao;

  @InjectMocks private UserService userService;

  /**
   * Test {@link UserService#registerNewUser(UserRegistrationRequest)}.
   *
   * <p>Method under test: {@link UserService#registerNewUser(UserRegistrationRequest)}
   */
  @Test
  @DisplayName("Test registerNewUser(UserRegistrationRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserService.registerNewUser(UserRegistrationRequest)"})
  void testRegisterNewUser() {
    // Arrange
    when(userDao.create(Mockito.<String>any(), Mockito.<String>any())).thenReturn(1);
    when(userRoleDao.updateRoles(Mockito.<String>any(), Mockito.<Set<String>>any())).thenReturn(1);
    when(passwordService.hashPassword(Mockito.<String>any())).thenReturn("iloveyou");
    when(settingsService.getByName(Mockito.<String>any()))
        .thenReturn(
            ImmutableSetting.builder()
                .description("The characteristics of someone or something")
                .name("Name")
                .value("42")
                .build());

    // Act
    int actualRegisterNewUserResult =
        userService.registerNewUser(
            ImmutableUserRegistrationRequest.builder()
                .password("iloveyou")
                .userName("janedoe")
                .build());

    // Assert
    verify(userDao).create("janedoe", "iloveyou");
    verify(userRoleDao).updateRoles(eq("janedoe"), isA(Set.class));
    verify(settingsService).getByName("server.authentication.roles.default");
    verify(passwordService).hashPassword("iloveyou");
    assertEquals(1, actualRegisterNewUserResult);
  }

  /**
   * Test {@link UserService#registerNewUser(UserRegistrationRequest)}.
   *
   * <p>Method under test: {@link UserService#registerNewUser(UserRegistrationRequest)}
   */
  @Test
  @DisplayName("Test registerNewUser(UserRegistrationRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserService.registerNewUser(UserRegistrationRequest)"})
  void testRegisterNewUser2() {
    // Arrange
    when(userDao.create(Mockito.<String>any(), Mockito.<String>any())).thenReturn(1);
    when(userRoleDao.updateRoles(Mockito.<String>any(), Mockito.<Set<String>>any())).thenReturn(1);
    when(passwordService.hashPassword(Mockito.<String>any())).thenReturn("iloveyou");
    when(settingsService.getByName(Mockito.<String>any()))
        .thenReturn(
            ImmutableSetting.builder()
                .description("The characteristics of someone or something")
                .name("Name")
                .value(",")
                .build());

    // Act
    int actualRegisterNewUserResult =
        userService.registerNewUser(
            ImmutableUserRegistrationRequest.builder()
                .password("iloveyou")
                .userName("janedoe")
                .build());

    // Assert
    verify(userDao).create("janedoe", "iloveyou");
    verify(userRoleDao).updateRoles(eq("janedoe"), isA(Set.class));
    verify(settingsService).getByName("server.authentication.roles.default");
    verify(passwordService).hashPassword("iloveyou");
    assertEquals(1, actualRegisterNewUserResult);
  }

  /**
   * Test {@link UserService#registerNewUser(UserRegistrationRequest)}.
   *
   * <p>Method under test: {@link UserService#registerNewUser(UserRegistrationRequest)}
   */
  @Test
  @DisplayName("Test registerNewUser(UserRegistrationRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserService.registerNewUser(UserRegistrationRequest)"})
  void testRegisterNewUser3() {
    // Arrange
    when(userDao.create(Mockito.<String>any(), Mockito.<String>any())).thenReturn(1);
    when(userRoleDao.updateRoles(Mockito.<String>any(), Mockito.<Set<String>>any())).thenReturn(1);
    when(passwordService.hashPassword(Mockito.<String>any())).thenReturn("iloveyou");
    when(settingsService.getByName(Mockito.<String>any()))
        .thenReturn(
            ImmutableSetting.builder()
                .description("The characteristics of someone or something")
                .name("Name")
                .value("")
                .build());

    // Act
    int actualRegisterNewUserResult =
        userService.registerNewUser(
            ImmutableUserRegistrationRequest.builder()
                .password("iloveyou")
                .userName("janedoe")
                .build());

    // Assert
    verify(userDao).create("janedoe", "iloveyou");
    verify(userRoleDao).updateRoles(eq("janedoe"), isA(Set.class));
    verify(settingsService).getByName("server.authentication.roles.default");
    verify(passwordService).hashPassword("iloveyou");
    assertEquals(1, actualRegisterNewUserResult);
  }

  /**
   * Test {@link UserService#authenticate(LoginRequest)}.
   *
   * <ul>
   *   <li>Given {@code iloveyou}.
   *   <li>Then calls {@link LoginRequest#password()}.
   * </ul>
   *
   * <p>Method under test: {@link UserService#authenticate(LoginRequest)}
   */
  @Test
  @DisplayName("Test authenticate(LoginRequest); given 'iloveyou'; then calls password()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserService.authenticate(LoginRequest)"})
  void testAuthenticate_givenIloveyou_thenCallsPassword() {
    // Arrange
    when(userDao.getPassword(Mockito.<String>any())).thenReturn("iloveyou");
    when(passwordService.verifyPassword(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(true);

    LoginRequest request = mock(LoginRequest.class);
    when(request.password()).thenReturn("iloveyou");
    when(request.userName()).thenReturn("janedoe");

    // Act
    boolean actualAuthenticateResult = userService.authenticate(request);

    // Assert
    verify(userDao).getPassword("janedoe");
    verify(request).password();
    verify(request).userName();
    verify(passwordService).verifyPassword("iloveyou", "iloveyou");
    assertTrue(actualAuthenticateResult);
  }

  /**
   * Test {@link UserService#authenticate(LoginRequest)}.
   *
   * <ul>
   *   <li>Given {@link PasswordService} {@link PasswordService#verifyPassword(String, String)}
   *       return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UserService#authenticate(LoginRequest)}
   */
  @Test
  @DisplayName(
      "Test authenticate(LoginRequest); given PasswordService verifyPassword(String, String) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserService.authenticate(LoginRequest)"})
  void testAuthenticate_givenPasswordServiceVerifyPasswordReturnFalse_thenReturnFalse() {
    // Arrange
    UserDao userDao = mock(UserDao.class);
    when(userDao.getPassword(Mockito.<String>any())).thenReturn("iloveyou");

    PasswordService passwordService = mock(PasswordService.class);
    when(passwordService.verifyPassword(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(false);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserService userService =
        new UserService(userDao, userRoleDao, passwordService, settingsService);

    // Act
    boolean actualAuthenticateResult =
        userService.authenticate(
            ImmutableLoginRequest.builder().password("iloveyou").userName("janedoe").build());

    // Assert
    verify(userDao).getPassword("janedoe");
    verify(passwordService).verifyPassword("iloveyou", "iloveyou");
    assertFalse(actualAuthenticateResult);
  }

  /**
   * Test {@link UserService#authenticate(LoginRequest)}.
   *
   * <ul>
   *   <li>Given {@link UserDao} {@link UserDao#getPassword(String)} return {@code iloveyou}.
   * </ul>
   *
   * <p>Method under test: {@link UserService#authenticate(LoginRequest)}
   */
  @Test
  @DisplayName(
      "Test authenticate(LoginRequest); given UserDao getPassword(String) return 'iloveyou'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserService.authenticate(LoginRequest)"})
  void testAuthenticate_givenUserDaoGetPasswordReturnIloveyou() {
    // Arrange
    UserDao userDao = mock(UserDao.class);
    when(userDao.getPassword(Mockito.<String>any())).thenReturn("iloveyou");

    PasswordService passwordService = mock(PasswordService.class);
    when(passwordService.verifyPassword(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(true);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserService userService =
        new UserService(userDao, userRoleDao, passwordService, settingsService);

    // Act
    boolean actualAuthenticateResult =
        userService.authenticate(
            ImmutableLoginRequest.builder().password("iloveyou").userName("janedoe").build());

    // Assert
    verify(userDao).getPassword("janedoe");
    verify(passwordService).verifyPassword("iloveyou", "iloveyou");
    assertTrue(actualAuthenticateResult);
  }

  /**
   * Test {@link UserService#authenticate(LoginRequest)}.
   *
   * <ul>
   *   <li>Given {@link UserDao} {@link UserDao#getPassword(String)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UserService#authenticate(LoginRequest)}
   */
  @Test
  @DisplayName("Test authenticate(LoginRequest); given UserDao getPassword(String) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserService.authenticate(LoginRequest)"})
  void testAuthenticate_givenUserDaoGetPasswordReturnNull() {
    // Arrange
    UserDao userDao = mock(UserDao.class);
    when(userDao.getPassword(Mockito.<String>any())).thenReturn(null);

    PasswordService passwordService = mock(PasswordService.class);
    when(passwordService.verifyPassword(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(true);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserService userService =
        new UserService(userDao, userRoleDao, passwordService, settingsService);

    // Act
    boolean actualAuthenticateResult =
        userService.authenticate(
            ImmutableLoginRequest.builder().password("iloveyou").userName("janedoe").build());

    // Assert
    verify(userDao).getPassword("janedoe");
    verify(passwordService).verifyPassword("iloveyou", null);
    assertTrue(actualAuthenticateResult);
  }

  /**
   * Test {@link UserService#authenticate(LoginRequest)}.
   *
   * <ul>
   *   <li>Given {@link UserDao} {@link UserDao#getPassword(String)} return {@code null}.
   *   <li>Then calls {@link LoginRequest#password()}.
   * </ul>
   *
   * <p>Method under test: {@link UserService#authenticate(LoginRequest)}
   */
  @Test
  @DisplayName(
      "Test authenticate(LoginRequest); given UserDao getPassword(String) return 'null'; then calls password()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserService.authenticate(LoginRequest)"})
  void testAuthenticate_givenUserDaoGetPasswordReturnNull_thenCallsPassword() {
    // Arrange
    when(userDao.getPassword(Mockito.<String>any())).thenReturn(null);
    when(passwordService.verifyPassword(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(true);

    LoginRequest request = mock(LoginRequest.class);
    when(request.password()).thenReturn("iloveyou");
    when(request.userName()).thenReturn("janedoe");

    // Act
    boolean actualAuthenticateResult = userService.authenticate(request);

    // Assert
    verify(userDao).getPassword("janedoe");
    verify(request).password();
    verify(request, atLeast(1)).userName();
    verify(passwordService).verifyPassword("iloveyou", null);
    assertTrue(actualAuthenticateResult);
  }

  /**
   * Test {@link UserService#deleteUser(String)}.
   *
   * <p>Method under test: {@link UserService#deleteUser(String)}
   */
  @Test
  @DisplayName("Test deleteUser(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserService.deleteUser(String)"})
  void testDeleteUser() {
    // Arrange
    UserDao userDao = mock(UserDao.class);
    when(userDao.deleteUser(Mockito.<String>any())).thenReturn(1);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    PasswordService passwordService = new PasswordService();
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserService userService =
        new UserService(userDao, userRoleDao, passwordService, settingsService);

    // Act
    boolean actualDeleteUserResult = userService.deleteUser("janedoe");

    // Assert
    verify(userDao).deleteUser("janedoe");
    assertTrue(actualDeleteUserResult);
  }

  /**
   * Test {@link UserService#findAllUserNames()}.
   *
   * <p>Method under test: {@link UserService#findAllUserNames()}
   */
  @Test
  @DisplayName("Test findAllUserNames()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserService.findAllUserNames()"})
  void testFindAllUserNames() {
    // Arrange
    UserDao userDao = mock(UserDao.class);
    when(userDao.findAllUserNames()).thenReturn(new ArrayList<>());
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    PasswordService passwordService = new PasswordService();
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserService userService =
        new UserService(userDao, userRoleDao, passwordService, settingsService);

    // Act
    List<String> actualFindAllUserNamesResult = userService.findAllUserNames();

    // Assert
    verify(userDao).findAllUserNames();
    assertTrue(actualFindAllUserNamesResult.isEmpty());
  }

  /**
   * Test {@link UserService#resetPassword(PasswordResetRequest, boolean)}.
   *
   * <ul>
   *   <li>Given {@link PasswordService} {@link PasswordService#verifyPassword(String, String)}
   *       return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UserService#resetPassword(PasswordResetRequest, boolean)}
   */
  @Test
  @DisplayName(
      "Test resetPassword(PasswordResetRequest, boolean); given PasswordService verifyPassword(String, String) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserService.resetPassword(PasswordResetRequest, boolean)"})
  void testResetPassword_givenPasswordServiceVerifyPasswordReturnFalse_thenReturnFalse() {
    // Arrange
    when(userDao.getPassword(Mockito.<String>any())).thenReturn("iloveyou");
    when(passwordService.verifyPassword(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(false);

    // Act
    boolean actualResetPasswordResult =
        userService.resetPassword(
            ImmutablePasswordResetRequest.builder()
                .currentPassword("iloveyou")
                .newPassword("iloveyou")
                .userName("janedoe")
                .build(),
            true);

    // Assert
    verify(userDao).getPassword("janedoe");
    verify(passwordService).verifyPassword("iloveyou", "iloveyou");
    assertFalse(actualResetPasswordResult);
  }

  /**
   * Test {@link UserService#resetPassword(PasswordResetRequest, boolean)}.
   *
   * <ul>
   *   <li>Given {@link UserDao} {@link UserDao#getPassword(String)} return {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link UserService#resetPassword(PasswordResetRequest, boolean)}
   */
  @Test
  @DisplayName(
      "Test resetPassword(PasswordResetRequest, boolean); given UserDao getPassword(String) return 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserService.resetPassword(PasswordResetRequest, boolean)"})
  void testResetPassword_givenUserDaoGetPasswordReturnNull_thenReturnTrue() {
    // Arrange
    when(userDao.resetPassword(Mockito.<String>any(), Mockito.<String>any())).thenReturn(1);
    when(userDao.getPassword(Mockito.<String>any())).thenReturn(null);
    when(passwordService.hashPassword(Mockito.<String>any())).thenReturn("iloveyou");
    when(passwordService.verifyPassword(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act
    boolean actualResetPasswordResult =
        userService.resetPassword(
            ImmutablePasswordResetRequest.builder()
                .currentPassword("iloveyou")
                .newPassword("iloveyou")
                .userName("janedoe")
                .build(),
            true);

    // Assert
    verify(userDao).getPassword("janedoe");
    verify(userDao).resetPassword("janedoe", "iloveyou");
    verify(passwordService).hashPassword("iloveyou");
    verify(passwordService).verifyPassword("iloveyou", null);
    assertTrue(actualResetPasswordResult);
  }

  /**
   * Test {@link UserService#resetPassword(PasswordResetRequest, boolean)}.
   *
   * <ul>
   *   <li>Given {@link UserDao} {@link UserDao#resetPassword(String, String)} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link UserService#resetPassword(PasswordResetRequest, boolean)}
   */
  @Test
  @DisplayName(
      "Test resetPassword(PasswordResetRequest, boolean); given UserDao resetPassword(String, String) return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserService.resetPassword(PasswordResetRequest, boolean)"})
  void testResetPassword_givenUserDaoResetPasswordReturnOne_thenReturnTrue() {
    // Arrange
    when(userDao.resetPassword(Mockito.<String>any(), Mockito.<String>any())).thenReturn(1);
    when(userDao.getPassword(Mockito.<String>any())).thenReturn("iloveyou");
    when(passwordService.hashPassword(Mockito.<String>any())).thenReturn("iloveyou");
    when(passwordService.verifyPassword(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act
    boolean actualResetPasswordResult =
        userService.resetPassword(
            ImmutablePasswordResetRequest.builder()
                .currentPassword("iloveyou")
                .newPassword("iloveyou")
                .userName("janedoe")
                .build(),
            true);

    // Assert
    verify(userDao).getPassword("janedoe");
    verify(userDao).resetPassword("janedoe", "iloveyou");
    verify(passwordService).hashPassword("iloveyou");
    verify(passwordService).verifyPassword("iloveyou", "iloveyou");
    assertTrue(actualResetPasswordResult);
  }

  /**
   * Test {@link UserService#resetPassword(PasswordResetRequest, boolean)}.
   *
   * <ul>
   *   <li>Given {@link UserDao} {@link UserDao#resetPassword(String, String)} return one.
   *   <li>When {@code false}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link UserService#resetPassword(PasswordResetRequest, boolean)}
   */
  @Test
  @DisplayName(
      "Test resetPassword(PasswordResetRequest, boolean); given UserDao resetPassword(String, String) return one; when 'false'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserService.resetPassword(PasswordResetRequest, boolean)"})
  void testResetPassword_givenUserDaoResetPasswordReturnOne_whenFalse_thenReturnTrue() {
    // Arrange
    when(userDao.resetPassword(Mockito.<String>any(), Mockito.<String>any())).thenReturn(1);
    when(passwordService.hashPassword(Mockito.<String>any())).thenReturn("iloveyou");

    // Act
    boolean actualResetPasswordResult =
        userService.resetPassword(
            ImmutablePasswordResetRequest.builder()
                .currentPassword("iloveyou")
                .newPassword("iloveyou")
                .userName("janedoe")
                .build(),
            false);

    // Assert
    verify(userDao).resetPassword("janedoe", "iloveyou");
    verify(passwordService).hashPassword("iloveyou");
    assertTrue(actualResetPasswordResult);
  }

  /**
   * Test {@link UserService#resetPassword(PasswordResetRequest, boolean)}.
   *
   * <ul>
   *   <li>Given {@link UserDao} {@link UserDao#resetPassword(String, String)} return three.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UserService#resetPassword(PasswordResetRequest, boolean)}
   */
  @Test
  @DisplayName(
      "Test resetPassword(PasswordResetRequest, boolean); given UserDao resetPassword(String, String) return three; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserService.resetPassword(PasswordResetRequest, boolean)"})
  void testResetPassword_givenUserDaoResetPasswordReturnThree_thenReturnFalse() {
    // Arrange
    when(userDao.resetPassword(Mockito.<String>any(), Mockito.<String>any())).thenReturn(3);
    when(userDao.getPassword(Mockito.<String>any())).thenReturn("iloveyou");
    when(passwordService.hashPassword(Mockito.<String>any())).thenReturn("iloveyou");
    when(passwordService.verifyPassword(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act
    boolean actualResetPasswordResult =
        userService.resetPassword(
            ImmutablePasswordResetRequest.builder()
                .currentPassword("iloveyou")
                .newPassword("iloveyou")
                .userName("janedoe")
                .build(),
            true);

    // Assert
    verify(userDao).getPassword("janedoe");
    verify(userDao).resetPassword("janedoe", "iloveyou");
    verify(passwordService).hashPassword("iloveyou");
    verify(passwordService).verifyPassword("iloveyou", "iloveyou");
    assertFalse(actualResetPasswordResult);
  }

  /**
   * Test {@link UserService#ensureExists(String)}.
   *
   * <p>Method under test: {@link UserService#ensureExists(String)}
   */
  @Test
  @DisplayName("Test ensureExists(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserService.ensureExists(String)"})
  void testEnsureExists() {
    // Arrange
    when(userDao.create(Mockito.<String>any(), Mockito.<String>any())).thenReturn(1);
    when(userRoleDao.updateRoles(Mockito.<String>any(), Mockito.<Set<String>>any())).thenReturn(1);
    when(passwordService.hashPassword(Mockito.<String>any())).thenReturn("iloveyou");
    when(settingsService.getByName(Mockito.<String>any()))
        .thenReturn(
            ImmutableSetting.builder()
                .description("The characteristics of someone or something")
                .name("Name")
                .value("42")
                .build());

    // Act
    boolean actualEnsureExistsResult = userService.ensureExists("janedoe");

    // Assert
    verify(userDao).create("janedoe", "iloveyou");
    verify(userRoleDao).updateRoles(eq("janedoe"), isA(Set.class));
    verify(settingsService).getByName("server.authentication.roles.default");
    verify(passwordService).hashPassword("temp4321");
    assertTrue(actualEnsureExistsResult);
  }

  /**
   * Test {@link UserService#ensureExists(String)}.
   *
   * <p>Method under test: {@link UserService#ensureExists(String)}
   */
  @Test
  @DisplayName("Test ensureExists(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserService.ensureExists(String)"})
  void testEnsureExists2() {
    // Arrange
    when(userDao.create(Mockito.<String>any(), Mockito.<String>any())).thenReturn(1);
    when(userRoleDao.updateRoles(Mockito.<String>any(), Mockito.<Set<String>>any())).thenReturn(1);
    when(passwordService.hashPassword(Mockito.<String>any())).thenReturn("iloveyou");
    when(settingsService.getByName(Mockito.<String>any()))
        .thenReturn(
            ImmutableSetting.builder()
                .description("The characteristics of someone or something")
                .name("Name")
                .value("")
                .build());

    // Act
    boolean actualEnsureExistsResult = userService.ensureExists("janedoe");

    // Assert
    verify(userDao).create("janedoe", "iloveyou");
    verify(userRoleDao).updateRoles(eq("janedoe"), isA(Set.class));
    verify(settingsService).getByName("server.authentication.roles.default");
    verify(passwordService).hashPassword("temp4321");
    assertTrue(actualEnsureExistsResult);
  }

  /**
   * Test {@link UserService#ensureExists(String)}.
   *
   * <p>Method under test: {@link UserService#ensureExists(String)}
   */
  @Test
  @DisplayName("Test ensureExists(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserService.ensureExists(String)"})
  void testEnsureExists3() {
    // Arrange
    when(userDao.create(Mockito.<String>any(), Mockito.<String>any())).thenReturn(1);
    when(userRoleDao.updateRoles(Mockito.<String>any(), Mockito.<Set<String>>any())).thenReturn(1);
    when(passwordService.hashPassword(Mockito.<String>any())).thenReturn("iloveyou");
    when(settingsService.getByName(Mockito.<String>any()))
        .thenReturn(
            ImmutableSetting.builder()
                .description("The characteristics of someone or something")
                .name("Name")
                .value(",")
                .build());

    // Act
    boolean actualEnsureExistsResult = userService.ensureExists("janedoe");

    // Assert
    verify(userDao).create("janedoe", "iloveyou");
    verify(userRoleDao).updateRoles(eq("janedoe"), isA(Set.class));
    verify(settingsService).getByName("server.authentication.roles.default");
    verify(passwordService).hashPassword("temp4321");
    assertTrue(actualEnsureExistsResult);
  }

  /**
   * Test {@link UserService#ensureExists(String)}.
   *
   * <ul>
   *   <li>Given {@link UserDao} {@link UserDao#create(String, String)} return four.
   *   <li>When {@code janedoe}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UserService#ensureExists(String)}
   */
  @Test
  @DisplayName(
      "Test ensureExists(String); given UserDao create(String, String) return four; when 'janedoe'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserService.ensureExists(String)"})
  void testEnsureExists_givenUserDaoCreateReturnFour_whenJanedoe_thenReturnFalse() {
    // Arrange
    when(userDao.create(Mockito.<String>any(), Mockito.<String>any())).thenReturn(4);
    when(passwordService.hashPassword(Mockito.<String>any())).thenReturn("iloveyou");

    // Act
    boolean actualEnsureExistsResult = userService.ensureExists("janedoe");

    // Assert
    verify(userDao).create("janedoe", "iloveyou");
    verify(passwordService).hashPassword("temp4321");
    assertFalse(actualEnsureExistsResult);
  }
}
