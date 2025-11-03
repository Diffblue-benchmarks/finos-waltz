package org.finos.waltz.web.endpoints.auth;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Optional;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.model.settings.Setting;
import org.finos.waltz.service.settings.SettingsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import spark.Request;
import spark.Response;

@ExtendWith(MockitoExtension.class)
class HeaderBasedAuthenticationFilterDiffblueTest {
  @Mock
  private SettingsService settingsService;

  /**
   * Test {@link HeaderBasedAuthenticationFilter#HeaderBasedAuthenticationFilter(SettingsService)}.
   * <p>
   * Method under test: {@link HeaderBasedAuthenticationFilter#HeaderBasedAuthenticationFilter(SettingsService)}
   */
  @Test
  @DisplayName("Test new HeaderBasedAuthenticationFilter(SettingsService)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HeaderBasedAuthenticationFilter.<init>(SettingsService)"})
  void testNewHeaderBasedAuthenticationFilter() {
    // Arrange
    Optional<String> ofResult = Optional.of("foo");
    when(settingsService.getValue(Mockito.<String>any())).thenReturn(ofResult);

    // Act
    new HeaderBasedAuthenticationFilter(settingsService);

    // Assert
    verify(settingsService).getValue(eq("server.authentication.filter.headerbased.param"));
  }

  /**
   * Test {@link HeaderBasedAuthenticationFilter#HeaderBasedAuthenticationFilter(SettingsService)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HeaderBasedAuthenticationFilter#HeaderBasedAuthenticationFilter(SettingsService)}
   */
  @Test
  @DisplayName("Test new HeaderBasedAuthenticationFilter(SettingsService); given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HeaderBasedAuthenticationFilter.<init>(SettingsService)"})
  void testNewHeaderBasedAuthenticationFilter_givenNull() {
    // Arrange
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any())).thenReturn(null);

    // Act
    new HeaderBasedAuthenticationFilter(new SettingsService(settingsDao, new ArrayList<>()));

    // Assert
    verify(settingsDao).getByName(eq("server.authentication.filter.headerbased.param"));
  }

  /**
   * Test {@link HeaderBasedAuthenticationFilter#HeaderBasedAuthenticationFilter(SettingsService)}.
   * <ul>
   *   <li>Given {@link SettingsService} {@link SettingsService#getValue(String)} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link HeaderBasedAuthenticationFilter#HeaderBasedAuthenticationFilter(SettingsService)}
   */
  @Test
  @DisplayName("Test new HeaderBasedAuthenticationFilter(SettingsService); given SettingsService getValue(String) return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HeaderBasedAuthenticationFilter.<init>(SettingsService)"})
  void testNewHeaderBasedAuthenticationFilter_givenSettingsServiceGetValueReturnEmpty() {
    // Arrange
    Optional<String> emptyResult = Optional.empty();
    when(settingsService.getValue(Mockito.<String>any())).thenReturn(emptyResult);

    // Act
    new HeaderBasedAuthenticationFilter(settingsService);

    // Assert
    verify(settingsService).getValue(eq("server.authentication.filter.headerbased.param"));
  }

  /**
   * Test {@link HeaderBasedAuthenticationFilter#HeaderBasedAuthenticationFilter(SettingsService)}.
   * <ul>
   *   <li>Then calls {@link Setting#value()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HeaderBasedAuthenticationFilter#HeaderBasedAuthenticationFilter(SettingsService)}
   */
  @Test
  @DisplayName("Test new HeaderBasedAuthenticationFilter(SettingsService); then calls value()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HeaderBasedAuthenticationFilter.<init>(SettingsService)"})
  void testNewHeaderBasedAuthenticationFilter_thenCallsValue() {
    // Arrange
    Setting setting = mock(Setting.class);
    Optional<String> ofResult = Optional.of("foo");
    when(setting.value()).thenReturn(ofResult);
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any())).thenReturn(setting);

    // Act
    new HeaderBasedAuthenticationFilter(new SettingsService(settingsDao, new ArrayList<>()));

    // Assert
    verify(settingsDao).getByName(eq("server.authentication.filter.headerbased.param"));
    verify(setting).value();
  }

  /**
   * Test {@link HeaderBasedAuthenticationFilter#handle(Request, Response)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link Request} {@link Request#headers(String)} return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link HeaderBasedAuthenticationFilter#handle(Request, Response)}
   */
  @Test
  @DisplayName("Test handle(Request, Response); given empty string; when Request headers(String) return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HeaderBasedAuthenticationFilter.handle(Request, Response)"})
  void testHandle_givenEmptyString_whenRequestHeadersReturnEmptyString() throws Exception {
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

  /**
   * Test {@link HeaderBasedAuthenticationFilter#handle(Request, Response)}.
   * <ul>
   *   <li>Given {@code Headers}.</li>
   *   <li>When {@link Request} {@link Request#headers(String)} return {@code Headers}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HeaderBasedAuthenticationFilter#handle(Request, Response)}
   */
  @Test
  @DisplayName("Test handle(Request, Response); given 'Headers'; when Request headers(String) return 'Headers'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HeaderBasedAuthenticationFilter.handle(Request, Response)"})
  void testHandle_givenHeaders_whenRequestHeadersReturnHeaders() throws Exception {
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
}
