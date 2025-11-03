package org.finos.waltz.data.cost;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.AllocationDerivation;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.MeasurableCostEntry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CostUtilsDiffblueTest {
  /**
   * Test {@link CostUtils#calculateAllocatedCosts(Collection, Map)}.
   * <ul>
   *   <li>Given {@link MeasurableCostEntry} {@link MeasurableCostEntry#allocatedCost()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CostUtils#calculateAllocatedCosts(Collection, Map)}
   */
  @Test
  @DisplayName("Test calculateAllocatedCosts(Collection, Map); given MeasurableCostEntry allocatedCost() return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set CostUtils.calculateAllocatedCosts(Collection, Map)"})
  void testCalculateAllocatedCosts_givenMeasurableCostEntryAllocatedCostReturnNull() {
    // Arrange
    MeasurableCostEntry measurableCostEntry = mock(MeasurableCostEntry.class);
    when(measurableCostEntry.allocationPercentage()).thenReturn(1);
    when(measurableCostEntry.year()).thenReturn(1);
    when(measurableCostEntry.costKindId()).thenReturn(1L);
    when(measurableCostEntry.allocatedCost()).thenReturn(null);
    when(measurableCostEntry.appId()).thenReturn(1L);
    when(measurableCostEntry.measurableId()).thenReturn(1L);
    when(measurableCostEntry.measurableRatingId()).thenReturn(1L);
    when(measurableCostEntry.allocationDerivation()).thenReturn(AllocationDerivation.DERIVED);
    when(measurableCostEntry.overallCost()).thenReturn(new BigDecimal("2.3"));

    LinkedHashSet<MeasurableCostEntry> costsForMeasurable = new LinkedHashSet<>();
    costsForMeasurable.add(measurableCostEntry);

    // Act
    Set<MeasurableCostEntry> actualCalculateAllocatedCostsResult = CostUtils.calculateAllocatedCosts(costsForMeasurable,
        new HashMap<>());

    // Assert
    verify(measurableCostEntry).allocatedCost();
    verify(measurableCostEntry).allocationDerivation();
    verify(measurableCostEntry, atLeast(1)).allocationPercentage();
    verify(measurableCostEntry).appId();
    verify(measurableCostEntry).costKindId();
    verify(measurableCostEntry).measurableId();
    verify(measurableCostEntry).measurableRatingId();
    verify(measurableCostEntry, atLeast(1)).overallCost();
    verify(measurableCostEntry).year();
    assertEquals(1, actualCalculateAllocatedCostsResult.size());
  }

  /**
   * Test {@link CostUtils#calculateAllocatedCosts(Collection, Map)}.
   * <ul>
   *   <li>Given {@link MeasurableCostEntry} {@link MeasurableCostEntry#costKindId()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CostUtils#calculateAllocatedCosts(Collection, Map)}
   */
  @Test
  @DisplayName("Test calculateAllocatedCosts(Collection, Map); given MeasurableCostEntry costKindId() return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set CostUtils.calculateAllocatedCosts(Collection, Map)"})
  void testCalculateAllocatedCosts_givenMeasurableCostEntryCostKindIdReturnNull() {
    // Arrange
    MeasurableCostEntry measurableCostEntry = mock(MeasurableCostEntry.class);
    when(measurableCostEntry.allocationPercentage()).thenReturn(1);
    when(measurableCostEntry.year()).thenReturn(1);
    when(measurableCostEntry.costKindId()).thenReturn(null);
    when(measurableCostEntry.allocatedCost()).thenReturn(new BigDecimal("2.3"));
    when(measurableCostEntry.appId()).thenReturn(1L);
    when(measurableCostEntry.measurableId()).thenReturn(1L);
    when(measurableCostEntry.measurableRatingId()).thenReturn(1L);
    when(measurableCostEntry.allocationDerivation()).thenReturn(AllocationDerivation.DERIVED);
    when(measurableCostEntry.overallCost()).thenReturn(new BigDecimal("2.3"));

    LinkedHashSet<MeasurableCostEntry> costsForMeasurable = new LinkedHashSet<>();
    costsForMeasurable.add(measurableCostEntry);

    // Act
    Set<MeasurableCostEntry> actualCalculateAllocatedCostsResult = CostUtils.calculateAllocatedCosts(costsForMeasurable,
        new HashMap<>());

    // Assert
    verify(measurableCostEntry).allocatedCost();
    verify(measurableCostEntry).allocationDerivation();
    verify(measurableCostEntry, atLeast(1)).allocationPercentage();
    verify(measurableCostEntry).appId();
    verify(measurableCostEntry).costKindId();
    verify(measurableCostEntry).measurableId();
    verify(measurableCostEntry).measurableRatingId();
    verify(measurableCostEntry, atLeast(1)).overallCost();
    verify(measurableCostEntry).year();
    assertEquals(1, actualCalculateAllocatedCostsResult.size());
  }

  /**
   * Test {@link CostUtils#calculateAllocatedCosts(Collection, Map)}.
   * <ul>
   *   <li>Given {@link MeasurableCostEntry} {@link MeasurableCostEntry#overallCost()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CostUtils#calculateAllocatedCosts(Collection, Map)}
   */
  @Test
  @DisplayName("Test calculateAllocatedCosts(Collection, Map); given MeasurableCostEntry overallCost() return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set CostUtils.calculateAllocatedCosts(Collection, Map)"})
  void testCalculateAllocatedCosts_givenMeasurableCostEntryOverallCostReturnNull() {
    // Arrange
    MeasurableCostEntry measurableCostEntry = mock(MeasurableCostEntry.class);
    when(measurableCostEntry.overallCost()).thenReturn(null);

    LinkedHashSet<MeasurableCostEntry> costsForMeasurable = new LinkedHashSet<>();
    costsForMeasurable.add(measurableCostEntry);

    // Act
    Set<MeasurableCostEntry> actualCalculateAllocatedCostsResult = CostUtils.calculateAllocatedCosts(costsForMeasurable,
        new HashMap<>());

    // Assert
    verify(measurableCostEntry).overallCost();
    assertTrue(actualCalculateAllocatedCostsResult.isEmpty());
  }

  /**
   * Test {@link CostUtils#calculateAllocatedCosts(Collection, Map)}.
   * <ul>
   *   <li>Given {@link MeasurableCostEntry} {@link MeasurableCostEntry#year()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CostUtils#calculateAllocatedCosts(Collection, Map)}
   */
  @Test
  @DisplayName("Test calculateAllocatedCosts(Collection, Map); given MeasurableCostEntry year() return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set CostUtils.calculateAllocatedCosts(Collection, Map)"})
  void testCalculateAllocatedCosts_givenMeasurableCostEntryYearReturnNull() {
    // Arrange
    MeasurableCostEntry measurableCostEntry = mock(MeasurableCostEntry.class);
    when(measurableCostEntry.allocationPercentage()).thenReturn(1);
    when(measurableCostEntry.year()).thenReturn(null);
    when(measurableCostEntry.costKindId()).thenReturn(1L);
    when(measurableCostEntry.allocatedCost()).thenReturn(new BigDecimal("2.3"));
    when(measurableCostEntry.appId()).thenReturn(1L);
    when(measurableCostEntry.measurableId()).thenReturn(1L);
    when(measurableCostEntry.measurableRatingId()).thenReturn(1L);
    when(measurableCostEntry.allocationDerivation()).thenReturn(AllocationDerivation.DERIVED);
    when(measurableCostEntry.overallCost()).thenReturn(new BigDecimal("2.3"));

    LinkedHashSet<MeasurableCostEntry> costsForMeasurable = new LinkedHashSet<>();
    costsForMeasurable.add(measurableCostEntry);

    // Act
    Set<MeasurableCostEntry> actualCalculateAllocatedCostsResult = CostUtils.calculateAllocatedCosts(costsForMeasurable,
        new HashMap<>());

    // Assert
    verify(measurableCostEntry).allocatedCost();
    verify(measurableCostEntry).allocationDerivation();
    verify(measurableCostEntry, atLeast(1)).allocationPercentage();
    verify(measurableCostEntry).appId();
    verify(measurableCostEntry).costKindId();
    verify(measurableCostEntry).measurableId();
    verify(measurableCostEntry).measurableRatingId();
    verify(measurableCostEntry, atLeast(1)).overallCost();
    verify(measurableCostEntry).year();
    assertEquals(1, actualCalculateAllocatedCostsResult.size());
  }

  /**
   * Test {@link CostUtils#calculateAllocatedCosts(Collection, Map)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CostUtils#calculateAllocatedCosts(Collection, Map)}
   */
  @Test
  @DisplayName("Test calculateAllocatedCosts(Collection, Map); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set CostUtils.calculateAllocatedCosts(Collection, Map)"})
  void testCalculateAllocatedCosts_thenReturnSizeIsOne() {
    // Arrange
    MeasurableCostEntry measurableCostEntry = mock(MeasurableCostEntry.class);
    when(measurableCostEntry.allocationPercentage()).thenReturn(1);
    when(measurableCostEntry.year()).thenReturn(1);
    when(measurableCostEntry.costKindId()).thenReturn(1L);
    when(measurableCostEntry.allocatedCost()).thenReturn(new BigDecimal("2.3"));
    when(measurableCostEntry.appId()).thenReturn(1L);
    when(measurableCostEntry.measurableId()).thenReturn(1L);
    when(measurableCostEntry.measurableRatingId()).thenReturn(1L);
    when(measurableCostEntry.allocationDerivation()).thenReturn(AllocationDerivation.DERIVED);
    when(measurableCostEntry.overallCost()).thenReturn(new BigDecimal("2.3"));

    LinkedHashSet<MeasurableCostEntry> costsForMeasurable = new LinkedHashSet<>();
    costsForMeasurable.add(measurableCostEntry);

    // Act
    Set<MeasurableCostEntry> actualCalculateAllocatedCostsResult = CostUtils.calculateAllocatedCosts(costsForMeasurable,
        new HashMap<>());

    // Assert
    verify(measurableCostEntry).allocatedCost();
    verify(measurableCostEntry).allocationDerivation();
    verify(measurableCostEntry, atLeast(1)).allocationPercentage();
    verify(measurableCostEntry).appId();
    verify(measurableCostEntry).costKindId();
    verify(measurableCostEntry).measurableId();
    verify(measurableCostEntry).measurableRatingId();
    verify(measurableCostEntry, atLeast(1)).overallCost();
    verify(measurableCostEntry).year();
    assertEquals(1, actualCalculateAllocatedCostsResult.size());
  }

  /**
   * Test {@link CostUtils#calculateAllocatedCosts(Collection, Map)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CostUtils#calculateAllocatedCosts(Collection, Map)}
   */
  @Test
  @DisplayName("Test calculateAllocatedCosts(Collection, Map); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set CostUtils.calculateAllocatedCosts(Collection, Map)"})
  void testCalculateAllocatedCosts_whenArrayList_thenReturnEmpty() {
    // Arrange
    ArrayList<MeasurableCostEntry> costsForMeasurable = new ArrayList<>();

    // Act
    Set<MeasurableCostEntry> actualCalculateAllocatedCostsResult = CostUtils.calculateAllocatedCosts(costsForMeasurable,
        new HashMap<>());

    // Assert
    assertTrue(actualCalculateAllocatedCostsResult.isEmpty());
  }
}
