package org.finos.waltz.web.endpoints.auth;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
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

class WaltzFilterDiffblueTest {
  /**
   * Method under test: {@link WaltzFilter#getSettingValue(String)}
   */
  @Test
  void testGetSettingValue() {
    // Arrange
    Setting setting = mock(Setting.class);
    Optional<String> ofResult = Optional.of("foo");
    when(setting.value()).thenReturn(ofResult);
    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.getByName(Mockito.<String>any())).thenReturn(setting);

    // Act
    Optional<String> actualSettingValue = (new DisallowAnonymousFilter(
        new SettingsService(settingsDao, new ArrayList<>()))).getSettingValue("Name");

    // Assert
    verify(settingsDao).getByName(eq("Name"));
    verify(setting).value();
    assertSame(ofResult, actualSettingValue);
  }
}
