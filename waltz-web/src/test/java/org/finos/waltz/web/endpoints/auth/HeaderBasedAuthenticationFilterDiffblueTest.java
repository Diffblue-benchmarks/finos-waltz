package org.finos.waltz.web.endpoints.auth;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Optional;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.model.settings.Setting;
import org.finos.waltz.service.settings.SettingsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spark.Request;
import spark.Response;

class HeaderBasedAuthenticationFilterDiffblueTest {
  /**
   * Method under test:
   * {@link HeaderBasedAuthenticationFilter#handle(Request, Response)}
   */
  @Test
  void testHandle() throws Exception {
    // Arrange
    Setting setting = mock(Setting.class);
    Optional<String> ofResult = Optional.of("foo");
    when(setting.value()).thenReturn(ofResult);
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any())).thenReturn(setting);
    HeaderBasedAuthenticationFilter headerBasedAuthenticationFilter = new HeaderBasedAuthenticationFilter(
        new SettingsService(settingsDao, new ArrayList<>()));
    Request request = mock(Request.class);
    when(request.headers(Mockito.<String>any())).thenReturn("Headers");
    doNothing().when(request).attribute(Mockito.<String>any(), Mockito.<Object>any());

    // Act
    headerBasedAuthenticationFilter.handle(request, mock(Response.class));

    // Assert
    verify(settingsDao).getByName(eq("server.authentication.filter.headerbased.param"));
    verify(setting).value();
    verify(request).attribute(eq("waltz-user"), isA(Object.class));
    verify(request).headers(eq("foo"));
  }

  /**
   * Method under test:
   * {@link HeaderBasedAuthenticationFilter#handle(Request, Response)}
   */
  @Test
  void testHandle2() throws Exception {
    // Arrange
    Setting setting = mock(Setting.class);
    Optional<String> ofResult = Optional.of("foo");
    when(setting.value()).thenReturn(ofResult);
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any())).thenReturn(setting);
    HeaderBasedAuthenticationFilter headerBasedAuthenticationFilter = new HeaderBasedAuthenticationFilter(
        new SettingsService(settingsDao, new ArrayList<>()));
    Request request = mock(Request.class);
    when(request.headers(Mockito.<String>any())).thenReturn("");
    doNothing().when(request).attribute(Mockito.<String>any(), Mockito.<Object>any());

    // Act
    headerBasedAuthenticationFilter.handle(request, mock(Response.class));

    // Assert
    verify(settingsDao).getByName(eq("server.authentication.filter.headerbased.param"));
    verify(setting).value();
    verify(request).attribute(eq("waltz-user"), isA(Object.class));
    verify(request).headers(eq("foo"));
  }
}
