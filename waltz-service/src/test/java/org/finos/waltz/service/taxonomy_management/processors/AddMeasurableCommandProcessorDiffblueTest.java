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
class AddMeasurableCommandProcessorDiffblueTest {
  @InjectMocks private AddMeasurableCommandProcessor addMeasurableCommandProcessor;

  @Mock private MeasurableService measurableService;

  /**
   * Test {@link AddMeasurableCommandProcessor#supportedTypes()}.
   *
   * <p>Method under test: {@link AddMeasurableCommandProcessor#supportedTypes()}
   */
  @Test
  @DisplayName("Test supportedTypes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AddMeasurableCommandProcessor.supportedTypes()"})
  void testSupportedTypes() {
    // Arrange and Act
    Set<TaxonomyChangeType> actualSupportedTypesResult =
        addMeasurableCommandProcessor.supportedTypes();

    // Assert
    assertEquals(2, actualSupportedTypesResult.size());
    assertTrue(actualSupportedTypesResult.contains(TaxonomyChangeType.ADD_CHILD));
    assertTrue(actualSupportedTypesResult.contains(TaxonomyChangeType.ADD_PEER));
  }

  /**
   * Test {@link AddMeasurableCommandProcessor#domain()}.
   *
   * <p>Method under test: {@link AddMeasurableCommandProcessor#domain()}
   */
  @Test
  @DisplayName("Test domain()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind AddMeasurableCommandProcessor.domain()"})
  void testDomain() {
    // Arrange, Act and Assert
    assertEquals(EntityKind.MEASURABLE_CATEGORY, addMeasurableCommandProcessor.domain());
  }
}
