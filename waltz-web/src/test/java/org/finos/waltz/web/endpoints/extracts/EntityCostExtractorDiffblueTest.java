package org.finos.waltz.web.endpoints.extracts;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.service.settings.SettingsService;
import org.jooq.DSLContext;
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
   * Method under test: {@link EntityCostExtractor#register()}
   */
  @Test
  void testRegister() {
    // Arrange
    Optional<String> ofResult = Optional.of("foo");
    when(settingsService.getValue(Mockito.<String>any())).thenReturn(ofResult);

    // Act
    entityCostExtractor.register();

    // Assert
    verify(settingsService).getValue(eq("feature.data-extractor.entity-cost.enabled"));
  }

  /**
   * Method under test: {@link EntityCostExtractor#register()}
   */
  @Test
  void testRegister2() {
    // Arrange
    Optional<String> emptyResult = Optional.empty();
    when(settingsService.getValue(Mockito.<String>any())).thenReturn(emptyResult);

    // Act
    entityCostExtractor.register();

    // Assert
    verify(settingsService).getValue(eq("feature.data-extractor.entity-cost.enabled"));
  }
}
