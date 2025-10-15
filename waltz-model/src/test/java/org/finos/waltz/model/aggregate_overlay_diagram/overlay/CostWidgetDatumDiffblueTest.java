package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CostWidgetDatumDiffblueTest {
  /**
   * Test {@link CostWidgetDatum#totalCost()}.
   *
   * <p>Method under test: {@link CostWidgetDatum#totalCost()}
   */
  @Test
  @DisplayName("Test totalCost()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal CostWidgetDatum.totalCost()"})
  void testTotalCost() {
    // Arrange
    ImmutableCostWidgetDatum immutableCostWidgetDatum =
        ImmutableCostWidgetDatum.builder().cellExternalId("42").build();

    // Act
    BigDecimal actualTotalCostResult = immutableCostWidgetDatum.totalCost();

    // Assert
    assertEquals(new BigDecimal("0"), actualTotalCostResult);
    assertSame(BigDecimal.ZERO, immutableCostWidgetDatum.totalCost());
  }

  /**
   * Test {@link CostWidgetDatum#appCount()}.
   *
   * <p>Method under test: {@link CostWidgetDatum#appCount()}
   */
  @Test
  @DisplayName("Test appCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CostWidgetDatum.appCount()"})
  void testAppCount() {
    // Arrange, Act and Assert
    assertEquals(0L, ImmutableCostWidgetDatum.builder().cellExternalId("42").build().appCount());
  }
}
