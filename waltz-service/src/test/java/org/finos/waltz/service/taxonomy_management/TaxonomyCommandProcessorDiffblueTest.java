package org.finos.waltz.service.taxonomy_management;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.service.measurable.MeasurableService;
import org.finos.waltz.service.taxonomy_management.processors.AddMeasurableCommandProcessor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TaxonomyCommandProcessorDiffblueTest {
  @Mock private MeasurableService measurableService;

  /**
   * Test {@link TaxonomyCommandProcessor#hasNoChange(Object, Object, String)}.
   *
   * <ul>
   *   <li>When {@code Current Value}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyCommandProcessor#hasNoChange(Object, Object, String)}
   */
  @Test
  @DisplayName(
      "Test hasNoChange(Object, Object, String); when 'Current Value'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TaxonomyCommandProcessor.hasNoChange(Object, Object, String)"})
  void testHasNoChange_whenCurrentValue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new AddMeasurableCommandProcessor(measurableService)
            .hasNoChange("Current Value", "New Value", "Field Name"));
  }

  /**
   * Test {@link TaxonomyCommandProcessor#hasNoChange(Object, Object, String)}.
   *
   * <ul>
   *   <li>When {@code Field Name}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TaxonomyCommandProcessor#hasNoChange(Object, Object, String)}
   */
  @Test
  @DisplayName("Test hasNoChange(Object, Object, String); when 'Field Name'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TaxonomyCommandProcessor.hasNoChange(Object, Object, String)"})
  void testHasNoChange_whenFieldName_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new AddMeasurableCommandProcessor(measurableService)
            .hasNoChange("New Value", "New Value", "Field Name"));
  }
}
