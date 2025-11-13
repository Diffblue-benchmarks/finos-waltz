package org.finos.waltz.web.endpoints.auth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Optional;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.model.settings.ImmutableSetting;
import org.finos.waltz.service.settings.SettingsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class WaltzFilterDiffblueTest {
  /**
   * Test {@link WaltzFilter#getSettingValue(String)}.
   *
   * <p>Method under test: {@link WaltzFilter#getSettingValue(String)}
   */
  @Test
  @DisplayName("Test getSettingValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional WaltzFilter.getSettingValue(String)"})
  void testGetSettingValue() {
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

    // Act
    Optional<String> actualSettingValue =
        new DisallowAnonymousFilter(settingsService).getSettingValue("Name");

    // Assert
    verify(settingsDao).getByName("Name");
    assertEquals("42", actualSettingValue.get());
    assertTrue(actualSettingValue.isPresent());
  }
}
