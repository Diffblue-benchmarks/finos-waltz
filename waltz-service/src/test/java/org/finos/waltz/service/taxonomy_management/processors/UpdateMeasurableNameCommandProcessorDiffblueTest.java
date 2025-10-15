package org.finos.waltz.service.taxonomy_management.processors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.taxonomy_management.TaxonomyChangeType;
import org.finos.waltz.service.measurable.MeasurableService;
import org.finos.waltz.service.measurable_rating.MeasurableRatingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UpdateMeasurableNameCommandProcessorDiffblueTest {
  @Mock private MeasurableRatingService measurableRatingService;

  @Mock private MeasurableService measurableService;

  @InjectMocks private UpdateMeasurableNameCommandProcessor updateMeasurableNameCommandProcessor;

  /**
   * Test {@link UpdateMeasurableNameCommandProcessor#supportedTypes()}.
   *
   * <p>Method under test: {@link UpdateMeasurableNameCommandProcessor#supportedTypes()}
   */
  @Test
  @DisplayName("Test supportedTypes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set UpdateMeasurableNameCommandProcessor.supportedTypes()"})
  void testSupportedTypes() {
    // Arrange and Act
    Set<TaxonomyChangeType> actualSupportedTypesResult =
        updateMeasurableNameCommandProcessor.supportedTypes();

    // Assert
    assertEquals(1, actualSupportedTypesResult.size());
    assertTrue(actualSupportedTypesResult.contains(TaxonomyChangeType.UPDATE_NAME));
  }

  /**
   * Test {@link UpdateMeasurableNameCommandProcessor#domain()}.
   *
   * <p>Method under test: {@link UpdateMeasurableNameCommandProcessor#domain()}
   */
  @Test
  @DisplayName("Test domain()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind UpdateMeasurableNameCommandProcessor.domain()"})
  void testDomain() {
    // Arrange, Act and Assert
    assertEquals(EntityKind.MEASURABLE_CATEGORY, updateMeasurableNameCommandProcessor.domain());
  }
}
