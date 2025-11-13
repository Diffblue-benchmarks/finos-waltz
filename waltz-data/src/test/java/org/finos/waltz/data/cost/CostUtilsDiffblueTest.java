package org.finos.waltz.data.cost;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.AllocationDerivation;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableMeasurableCostEntry;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableMeasurableCostEntry.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.MeasurableCostEntry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CostUtilsDiffblueTest {
  /**
   * Test {@link CostUtils#calculateAllocatedCosts(Collection, Map)}.
   *
   * <p>Method under test: {@link CostUtils#calculateAllocatedCosts(Collection, Map)}
   */
  @Test
  @DisplayName("Test calculateAllocatedCosts(Collection, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CostUtils.calculateAllocatedCosts(Collection, Map)"})
  void testCalculateAllocatedCosts() {
    // Arrange
    ArrayList<MeasurableCostEntry> costsForMeasurable = new ArrayList<>();

    Builder builderResult = ImmutableMeasurableCostEntry.builder();
    costsForMeasurable.add(
        builderResult
            .allocatedCost(new BigDecimal("2.3"))
            .allocationDerivation(AllocationDerivation.DERIVED)
            .allocationPercentage(1)
            .appId(1L)
            .costKindId(1L)
            .measurableId(1L)
            .measurableRatingId(1L)
            .overallCost(null)
            .year(1)
            .build());

    // Act
    Set<MeasurableCostEntry> actualCalculateAllocatedCostsResult =
        CostUtils.calculateAllocatedCosts(costsForMeasurable, new HashMap<>());

    // Assert
    assertTrue(actualCalculateAllocatedCostsResult.isEmpty());
  }

  /**
   * Test {@link CostUtils#calculateAllocatedCosts(Collection, Map)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link CostUtils#calculateAllocatedCosts(Collection, Map)}
   */
  @Test
  @DisplayName("Test calculateAllocatedCosts(Collection, Map); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CostUtils.calculateAllocatedCosts(Collection, Map)"})
  void testCalculateAllocatedCosts_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<MeasurableCostEntry> costsForMeasurable = new ArrayList<>();

    Builder builderResult = ImmutableMeasurableCostEntry.builder();

    Builder measurableRatingIdResult =
        builderResult
            .allocatedCost(new BigDecimal("2.3"))
            .allocationDerivation(AllocationDerivation.DERIVED)
            .allocationPercentage(1)
            .appId(1L)
            .costKindId(1L)
            .measurableId(1L)
            .measurableRatingId(1L);
    costsForMeasurable.add(
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(1).build());

    // Act
    Set<MeasurableCostEntry> actualCalculateAllocatedCostsResult =
        CostUtils.calculateAllocatedCosts(costsForMeasurable, new HashMap<>());

    // Assert
    assertEquals(1, actualCalculateAllocatedCostsResult.size());
  }

  /**
   * Test {@link CostUtils#calculateAllocatedCosts(Collection, Map)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link CostUtils#calculateAllocatedCosts(Collection, Map)}
   */
  @Test
  @DisplayName("Test calculateAllocatedCosts(Collection, Map); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CostUtils.calculateAllocatedCosts(Collection, Map)"})
  void testCalculateAllocatedCosts_thenReturnSizeIsOne2() {
    // Arrange
    ArrayList<MeasurableCostEntry> costsForMeasurable = new ArrayList<>();

    Builder builderResult = ImmutableMeasurableCostEntry.builder();

    Builder measurableRatingIdResult =
        builderResult
            .allocatedCost(new BigDecimal("2.3"))
            .allocationDerivation(AllocationDerivation.DERIVED)
            .allocationPercentage(1)
            .appId(1L)
            .costKindId(1L)
            .measurableId(1L)
            .measurableRatingId(1L);
    costsForMeasurable.add(
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(1).build());

    Builder builderResult2 = ImmutableMeasurableCostEntry.builder();

    Builder measurableRatingIdResult2 =
        builderResult2
            .allocatedCost(new BigDecimal("2.3"))
            .allocationDerivation(AllocationDerivation.DERIVED)
            .allocationPercentage(1)
            .appId(1L)
            .costKindId(1L)
            .measurableId(1L)
            .measurableRatingId(1L);
    costsForMeasurable.add(
        measurableRatingIdResult2.overallCost(new BigDecimal("2.3")).year(1).build());

    // Act
    Set<MeasurableCostEntry> actualCalculateAllocatedCostsResult =
        CostUtils.calculateAllocatedCosts(costsForMeasurable, new HashMap<>());

    // Assert
    assertEquals(1, actualCalculateAllocatedCostsResult.size());
  }

  /**
   * Test {@link CostUtils#calculateAllocatedCosts(Collection, Map)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CostUtils#calculateAllocatedCosts(Collection, Map)}
   */
  @Test
  @DisplayName("Test calculateAllocatedCosts(Collection, Map); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CostUtils.calculateAllocatedCosts(Collection, Map)"})
  void testCalculateAllocatedCosts_whenArrayList_thenReturnEmpty() {
    // Arrange
    ArrayList<MeasurableCostEntry> costsForMeasurable = new ArrayList<>();

    // Act
    Set<MeasurableCostEntry> actualCalculateAllocatedCostsResult =
        CostUtils.calculateAllocatedCosts(costsForMeasurable, new HashMap<>());

    // Assert
    assertTrue(actualCalculateAllocatedCostsResult.isEmpty());
  }
}
