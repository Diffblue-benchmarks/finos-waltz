package org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters;

import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class ImmutableAggregatedEntitiesWidgetParametersDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAggregatedEntitiesWidgetParameters.Builder#from(AggregatedEntitiesWidgetParameters)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetParameters.Builder builderResult = ImmutableAggregatedEntitiesWidgetParameters
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.from(new ImmutableAggregatedEntitiesWidgetParameters.Json()));
  }
}
