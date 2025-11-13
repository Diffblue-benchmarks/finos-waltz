package org.finos.waltz.web.endpoints.auth;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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

class DisallowAnonymousFilterDiffblueTest {
  /**
   * Test {@link DisallowAnonymousFilter#DisallowAnonymousFilter(SettingsService)}.
   *
   * <ul>
   *   <li>Then return not SettingValue is {@code Name} Present.
   * </ul>
   *
   * <p>Method under test: {@link DisallowAnonymousFilter#DisallowAnonymousFilter(SettingsService)}
   */
  @Test
  @DisplayName(
      "Test new DisallowAnonymousFilter(SettingsService); then return not SettingValue is 'Name' Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DisallowAnonymousFilter.<init>(SettingsService)"})
  void testNewDisallowAnonymousFilter_thenReturnNotSettingValueIsNamePresent() {
    // Arrange
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    // Act and Assert
    assertFalse(new DisallowAnonymousFilter(settingsService).getSettingValue("Name").isPresent());
  }

  /**
   * Test {@link DisallowAnonymousFilter#handle(Request, Response)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link DisallowAnonymousFilter#handle(Request, Response)}
   */
  @Test
  @DisplayName("Test handle(Request, Response); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DisallowAnonymousFilter.handle(Request, Response)"})
  void testHandle_thenThrowUnsupportedOperationException() throws Exception {
    // Arrange
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());
    DisallowAnonymousFilter disallowAnonymousFilter = new DisallowAnonymousFilter(settingsService);

    Request request = mock(Request.class);
    when(request.headers(Mockito.<String>any())).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> disallowAnonymousFilter.handle(request, mock(Response.class)));
    verify(request).headers("Authorization");
  }
}
