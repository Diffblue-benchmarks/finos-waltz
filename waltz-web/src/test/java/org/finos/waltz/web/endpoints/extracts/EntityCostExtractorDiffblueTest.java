package org.finos.waltz.web.endpoints.extracts;

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
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EntityCostExtractorDiffblueTest {
  /**
   * Test {@link EntityCostExtractor#register()}.
   *
   * <ul>
   *   <li>Given {@link SettingsService} {@link SettingsService#getValue(String)} return empty.
   *   <li>Then calls {@link SettingsService#getValue(String)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityCostExtractor#register()}
   */
  @Test
  @DisplayName(
      "Test register(); given SettingsService getValue(String) return empty; then calls getValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityCostExtractor.register()"})
  void testRegister_givenSettingsServiceGetValueReturnEmpty_thenCallsGetValue() {
    // Arrange
    SettingsService settingsService = mock(SettingsService.class);
    Optional<String> emptyResult = Optional.empty();
    when(settingsService.getValue(Mockito.<String>any())).thenReturn(emptyResult);
    EntityCostExtractor entityCostExtractor =
        new EntityCostExtractor(new DefaultDSLContext(SQLDialect.SQL99), settingsService);

    // Act
    entityCostExtractor.register();

    // Assert
    verify(settingsService).getValue("feature.data-extractor.entity-cost.enabled");
  }

  /**
   * Test {@link EntityCostExtractor#register()}.
   *
   * <ul>
   *   <li>Given {@link SettingsService} {@link SettingsService#getValue(String)} return of {@code
   *       42}.
   *   <li>Then calls {@link SettingsService#getValue(String)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityCostExtractor#register()}
   */
  @Test
  @DisplayName(
      "Test register(); given SettingsService getValue(String) return of '42'; then calls getValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityCostExtractor.register()"})
  void testRegister_givenSettingsServiceGetValueReturnOf42_thenCallsGetValue() {
    // Arrange
    SettingsService settingsService = mock(SettingsService.class);
    Optional<String> ofResult = Optional.of("42");
    when(settingsService.getValue(Mockito.<String>any())).thenReturn(ofResult);
    EntityCostExtractor entityCostExtractor =
        new EntityCostExtractor(new DefaultDSLContext(SQLDialect.SQL99), settingsService);

    // Act
    entityCostExtractor.register();

    // Assert
    verify(settingsService).getValue("feature.data-extractor.entity-cost.enabled");
  }

  /**
   * Test {@link EntityCostExtractor#register()}.
   *
   * <ul>
   *   <li>Then calls {@link SettingsDao#getByName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityCostExtractor#register()}
   */
  @Test
  @DisplayName("Test register(); then calls getByName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityCostExtractor.register()"})
  void testRegister_thenCallsGetByName() {
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
    EntityCostExtractor entityCostExtractor =
        new EntityCostExtractor(new DefaultDSLContext(SQLDialect.SQL99), settingsService);

    // Act
    entityCostExtractor.register();

    // Assert
    verify(settingsDao).getByName("feature.data-extractor.entity-cost.enabled");
  }
}
