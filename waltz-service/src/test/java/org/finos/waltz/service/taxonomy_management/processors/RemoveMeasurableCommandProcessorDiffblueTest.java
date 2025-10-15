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
class RemoveMeasurableCommandProcessorDiffblueTest {
  @Mock private MeasurableService measurableService;

  @InjectMocks private RemoveMeasurableCommandProcessor removeMeasurableCommandProcessor;

  /**
   * Test {@link RemoveMeasurableCommandProcessor#supportedTypes()}.
   *
   * <p>Method under test: {@link RemoveMeasurableCommandProcessor#supportedTypes()}
   */
  @Test
  @DisplayName("Test supportedTypes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set RemoveMeasurableCommandProcessor.supportedTypes()"})
  void testSupportedTypes() {
    // Arrange and Act
    Set<TaxonomyChangeType> actualSupportedTypesResult =
        removeMeasurableCommandProcessor.supportedTypes();

    // Assert
    assertEquals(1, actualSupportedTypesResult.size());
    assertTrue(actualSupportedTypesResult.contains(TaxonomyChangeType.REMOVE));
  }

  /**
   * Test {@link RemoveMeasurableCommandProcessor#domain()}.
   *
   * <p>Method under test: {@link RemoveMeasurableCommandProcessor#domain()}
   */
  @Test
  @DisplayName("Test domain()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind RemoveMeasurableCommandProcessor.domain()"})
  void testDomain() {
    // Arrange, Act and Assert
    assertEquals(EntityKind.MEASURABLE_CATEGORY, removeMeasurableCommandProcessor.domain());
  }
}
