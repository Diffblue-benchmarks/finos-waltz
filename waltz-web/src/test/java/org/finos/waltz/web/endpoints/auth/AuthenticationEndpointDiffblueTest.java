package org.finos.waltz.web.endpoints.auth;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
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
import org.finos.waltz.data.user.UserDao;
import org.finos.waltz.data.user.UserRoleDao;
import org.finos.waltz.model.authentication.ImmutableOAuthConfiguration;
import org.finos.waltz.model.settings.ImmutableSetting;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.user.PasswordService;
import org.finos.waltz.service.user.UserRoleService;
import org.finos.waltz.service.user.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AuthenticationEndpointDiffblueTest {
  /**
   * Test {@link AuthenticationEndpoint#register()}.
   *
   * <p>Method under test: {@link AuthenticationEndpoint#register()}
   */
  @Test
  @DisplayName("Test register()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AuthenticationEndpoint.register()"})
  void testRegister() {
    // Arrange
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any()))
        .thenReturn(
            ImmutableSetting.builder()
                .description("The characteristics of someone or something")
                .name("Name")
                .value("42")
                .build());
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());
    UserDao userDao = mock(UserDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    PasswordService passwordService = new PasswordService();
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    UserService userService =
        new UserService(userDao, userRoleDao, passwordService, settingsService2);
    UserRoleDao userRoleDao2 = mock(UserRoleDao.class);
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
    SettingsDao settingsDao3 = mock(SettingsDao.class);
    SettingsService settingsService3 = new SettingsService(settingsDao3, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao2, roleDao, personDao, changeLogService, personService, settingsService3);
    ImmutableOAuthConfiguration oauthConfiguration =
        ImmutableOAuthConfiguration.builder()
            .codeVerifier("Code Verifier")
            .redirectUri("Redirect Uri")
            .tokenUrl("https://example.org/example")
            .userInfoUrl("https://example.org/example")
            .build();

    AuthenticationEndpoint authenticationEndpoint =
        new AuthenticationEndpoint(
            userService, userRoleService, settingsService, oauthConfiguration);

    // Act
    authenticationEndpoint.register();

    // Assert
    verify(settingsDao).getByName("server.authentication.filter");
  }
}
