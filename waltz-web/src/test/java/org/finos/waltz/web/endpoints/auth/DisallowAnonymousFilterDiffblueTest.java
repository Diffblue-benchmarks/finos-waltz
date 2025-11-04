package org.finos.waltz.web.endpoints.auth;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.service.settings.SettingsService;
import org.junit.jupiter.api.Test;

class DisallowAnonymousFilterDiffblueTest {
  /**
   * Method under test:
   * {@link DisallowAnonymousFilter#DisallowAnonymousFilter(SettingsService)}
   */
  @Test
  void testNewDisallowAnonymousFilter() {
    // Arrange
    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act and Assert
    assertFalse(
        (new DisallowAnonymousFilter(new SettingsService(settingsDao, new ArrayList<>()))).getSettingValue("Name")
            .isPresent());
  }
}
