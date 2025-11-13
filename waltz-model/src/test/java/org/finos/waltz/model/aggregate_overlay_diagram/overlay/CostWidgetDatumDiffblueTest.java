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
   * <ul>
   *   <li>Given builder cellExternalId {@code 42} build.
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0}.
   * </ul>
   *
   * <p>Method under test: {@link CostWidgetDatum#totalCost()}
   */
  @Test
  @DisplayName(
      "Test totalCost(); given builder cellExternalId '42' build; then return BigDecimal(String) with '0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal CostWidgetDatum.totalCost()"})
  void testTotalCost_givenBuilderCellExternalId42Build_thenReturnBigDecimalWith0() {
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
   * <ul>
   *   <li>Given builder cellExternalId {@code 42} build.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CostWidgetDatum#appCount()}
   */
  @Test
  @DisplayName("Test appCount(); given builder cellExternalId '42' build; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long CostWidgetDatum.appCount()"})
  void testAppCount_givenBuilderCellExternalId42Build_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, ImmutableCostWidgetDatum.builder().cellExternalId("42").build().appCount());
  }
}
