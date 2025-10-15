package org.finos.waltz.service.taxonomy_management.processors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.taxonomy_management.TaxonomyChangeType;
import org.finos.waltz.service.measurable.MeasurableService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MoveMeasurableCommandProcessorDiffblueTest {
  @Mock private MeasurableService measurableService;

  @InjectMocks private MoveMeasurableCommandProcessor moveMeasurableCommandProcessor;

  /**
   * Test {@link MoveMeasurableCommandProcessor#supportedTypes()}.
   *
   * <p>Method under test: {@link MoveMeasurableCommandProcessor#supportedTypes()}
   */
  @Test
  @DisplayName("Test supportedTypes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MoveMeasurableCommandProcessor.supportedTypes()"})
  void testSupportedTypes() {
    // Arrange and Act
    Set<TaxonomyChangeType> actualSupportedTypesResult =
        moveMeasurableCommandProcessor.supportedTypes();

    // Assert
    assertEquals(1, actualSupportedTypesResult.size());
    assertTrue(actualSupportedTypesResult.contains(TaxonomyChangeType.MOVE));
  }

  /**
   * Test {@link MoveMeasurableCommandProcessor#domain()}.
   *
   * <p>Method under test: {@link MoveMeasurableCommandProcessor#domain()}
   */
  @Test
  @DisplayName("Test domain()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind MoveMeasurableCommandProcessor.domain()"})
  void testDomain() {
    // Arrange, Act and Assert
    assertEquals(EntityKind.MEASURABLE_CATEGORY, moveMeasurableCommandProcessor.domain());
  }
}
