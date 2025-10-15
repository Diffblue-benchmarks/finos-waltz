package org.finos.waltz.web.endpoints.auth;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.service.settings.SettingsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

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
}
