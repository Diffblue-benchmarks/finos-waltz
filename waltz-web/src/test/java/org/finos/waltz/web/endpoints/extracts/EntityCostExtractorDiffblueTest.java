package org.finos.waltz.web.endpoints.extracts;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.service.settings.SettingsService;
import org.jooq.DSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EntityCostExtractorDiffblueTest {
  @Mock
  private DSLContext dSLContext;

  @InjectMocks
  private EntityCostExtractor entityCostExtractor;

  @Mock
  private SettingsService settingsService;

  /**
   * Test {@link EntityCostExtractor#register()}.
   * <ul>
   *   <li>Given {@link SettingsService} {@link SettingsService#getValue(String)} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityCostExtractor#register()}
   */
  @Test
  @DisplayName("Test register(); given SettingsService getValue(String) return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityCostExtractor.register()"})
  void testRegister_givenSettingsServiceGetValueReturnEmpty() {
    // Arrange
    Optional<String> emptyResult = Optional.empty();
    when(settingsService.getValue(Mockito.<String>any())).thenReturn(emptyResult);

    // Act
    entityCostExtractor.register();

    // Assert
    verify(settingsService).getValue(eq("feature.data-extractor.entity-cost.enabled"));
  }

  /**
   * Test {@link EntityCostExtractor#register()}.
   * <ul>
   *   <li>Given {@link SettingsService} {@link SettingsService#getValue(String)} return {@link Optional} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityCostExtractor#register()}
   */
  @Test
  @DisplayName("Test register(); given SettingsService getValue(String) return Optional with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityCostExtractor.register()"})
  void testRegister_givenSettingsServiceGetValueReturnOptionalWithFoo() {
    // Arrange
    Optional<String> ofResult = Optional.of("foo");
    when(settingsService.getValue(Mockito.<String>any())).thenReturn(ofResult);

    // Act
    entityCostExtractor.register();

    // Assert
    verify(settingsService).getValue(eq("feature.data-extractor.entity-cost.enabled"));
  }
}
