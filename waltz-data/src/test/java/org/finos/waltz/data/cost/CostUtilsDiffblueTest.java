package org.finos.waltz.data.cost;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.AllocationDerivation;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.MeasurableCostEntry;
import org.junit.jupiter.api.Test;

class CostUtilsDiffblueTest {
  /**
   * Method under test: {@link CostUtils#calculateAllocatedCosts(Collection, Map)}
   */
  @Test
  void testCalculateAllocatedCosts() {
    // Arrange
    ArrayList<MeasurableCostEntry> costsForMeasurable = new ArrayList<>();

    // Act
    Set<MeasurableCostEntry> actualCalculateAllocatedCostsResult = CostUtils.calculateAllocatedCosts(costsForMeasurable,
        new HashMap<>());

    // Assert
    assertTrue(actualCalculateAllocatedCostsResult.isEmpty());
  }

  /**
   * Method under test: {@link CostUtils#calculateAllocatedCosts(Collection, Map)}
   */
  @Test
  void testCalculateAllocatedCosts2() {
    // Arrange
    ArrayList<MeasurableCostEntry> costsForMeasurable = new ArrayList<>();

    HashMap<Long, Collection<MeasurableCostEntry>> costDataByAppId = new HashMap<>();
    costDataByAppId.computeIfPresent(2L, mock(BiFunction.class));

    // Act
    Set<MeasurableCostEntry> actualCalculateAllocatedCostsResult = CostUtils.calculateAllocatedCosts(costsForMeasurable,
        costDataByAppId);

    // Assert
    assertTrue(actualCalculateAllocatedCostsResult.isEmpty());
  }

  /**
   * Method under test: {@link CostUtils#calculateAllocatedCosts(Collection, Map)}
   */
  @Test
  void testCalculateAllocatedCosts3() {
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
   * Method under test: {@link CostUtils#calculateAllocatedCosts(Collection, Map)}
   */
  @Test
  void testCalculateAllocatedCosts4() {
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
   * Method under test: {@link CostUtils#calculateAllocatedCosts(Collection, Map)}
   */
  @Test
  void testCalculateAllocatedCosts5() {
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
   * Method under test: {@link CostUtils#calculateAllocatedCosts(Collection, Map)}
   */
  @Test
  void testCalculateAllocatedCosts6() {
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
   * Method under test: {@link CostUtils#calculateAllocatedCosts(Collection, Map)}
   */
  @Test
  void testCalculateAllocatedCosts7() {
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
}
