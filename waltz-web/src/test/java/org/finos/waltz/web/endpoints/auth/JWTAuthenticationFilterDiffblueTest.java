package org.finos.waltz.web.endpoints.auth;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.service.settings.SettingsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spark.Request;
import spark.Response;

class JWTAuthenticationFilterDiffblueTest {
  /**
   * Method under test: {@link JWTAuthenticationFilter#handle(Request, Response)}
   */
  @Test
  void testHandle() throws Exception {
    // Arrange
    SettingsDao settingsDao = mock(SettingsDao.class);
    JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter(
        new SettingsService(settingsDao, new ArrayList<>()));
    Request request = mock(Request.class);
    when(request.headers(Mockito.<String>any())).thenReturn(null);
    doNothing().when(request).attribute(Mockito.<String>any(), Mockito.<Object>any());

    // Act
    jwtAuthenticationFilter.handle(request, mock(Response.class));

    // Assert
    verify(request).attribute(eq("waltz-user"), isA(Object.class));
    verify(request).headers(eq("Authorization"));
  }

  /**
   * Method under test: {@link JWTAuthenticationFilter#handle(Request, Response)}
   */
  @Test
  void testHandle2() throws Exception {
    // Arrange
    SettingsDao settingsDao = mock(SettingsDao.class);
    JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter(
        new SettingsService(settingsDao, new ArrayList<>()));
    Request request = mock(Request.class);
    when(request.headers(Mockito.<String>any())).thenThrow(new IllegalStateException("Authorization"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> jwtAuthenticationFilter.handle(request, mock(Response.class)));
    verify(request).headers(eq("Authorization"));
  }

  /**
   * Method under test:
   * {@link JWTAuthenticationFilter#JWTAuthenticationFilter(SettingsService)}
   */
  @Test
  void testNewJWTAuthenticationFilter() {
    // Arrange
    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act and Assert
    assertFalse(
        (new JWTAuthenticationFilter(new SettingsService(settingsDao, new ArrayList<>()))).getSettingValue("Name")
            .isPresent());
  }
}
