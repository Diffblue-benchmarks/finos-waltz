package org.finos.waltz.web.endpoints.auth;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.service.settings.SettingsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spark.Request;
import spark.Response;

class JWTAuthenticationFilterDiffblueTest {
  /**
   * Test {@link JWTAuthenticationFilter#JWTAuthenticationFilter(SettingsService)}.
   * <ul>
   *   <li>Then return not SettingValue is {@code Name} Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link JWTAuthenticationFilter#JWTAuthenticationFilter(SettingsService)}
   */
  @Test
  @DisplayName("Test new JWTAuthenticationFilter(SettingsService); then return not SettingValue is 'Name' Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JWTAuthenticationFilter.<init>(SettingsService)"})
  void testNewJWTAuthenticationFilter_thenReturnNotSettingValueIsNamePresent() {
    // Arrange
    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act and Assert
    assertFalse(
        (new JWTAuthenticationFilter(new SettingsService(settingsDao, new ArrayList<>()))).getSettingValue("Name")
            .isPresent());
  }

  /**
   * Test {@link JWTAuthenticationFilter#handle(Request, Response)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Request} {@link Request#headers(String)} return {@code null}.</li>
   *   <li>Then calls {@link Request#attribute(String, Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JWTAuthenticationFilter#handle(Request, Response)}
   */
  @Test
  @DisplayName("Test handle(Request, Response); given 'null'; when Request headers(String) return 'null'; then calls attribute(String, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JWTAuthenticationFilter.handle(Request, Response)"})
  void testHandle_givenNull_whenRequestHeadersReturnNull_thenCallsAttribute() throws Exception {
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
   * Test {@link JWTAuthenticationFilter#handle(Request, Response)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JWTAuthenticationFilter#handle(Request, Response)}
   */
  @Test
  @DisplayName("Test handle(Request, Response); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JWTAuthenticationFilter.handle(Request, Response)"})
  void testHandle_thenThrowIllegalStateException() throws Exception {
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
}
