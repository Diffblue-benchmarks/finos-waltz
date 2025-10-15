package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableMeasurableCostEntry.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableMeasurableCostEntry.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableCostEntryDiffblueTest {
  /**
   * Test Builder {@link Builder#allocationDerivation(AllocationDerivation)}.
   *
   * <p>Method under test: {@link Builder#allocationDerivation(AllocationDerivation)}
   */
  @Test
  @DisplayName("Test Builder allocationDerivation(AllocationDerivation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.allocationDerivation(AllocationDerivation)"})
  void testBuilderAllocationDerivation() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCostEntry.builder();

    // Act
    Builder actualAllocationDerivationResult =
        builderResult.allocationDerivation(AllocationDerivation.DERIVED);

    // Assert
    assertSame(builderResult, actualAllocationDerivationResult);
  }

  /**
   * Test Builder {@link Builder#appId(long)}.
   *
   * <p>Method under test: {@link Builder#appId(long)}
   */
  @Test
  @DisplayName("Test Builder appId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.appId(long)"})
  void testBuilderAppId() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCostEntry.builder();

    // Act
    Builder actualAppIdResult = builderResult.appId(1L);

    // Assert
    assertSame(builderResult, actualAppIdResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#allocatedCost(BigDecimal)}
   *   <li>{@link Builder#allocationPercentage(Integer)}
   *   <li>{@link Builder#costKindId(Long)}
   *   <li>{@link Builder#overallCost(BigDecimal)}
   *   <li>{@link Builder#year(Integer)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Builder Builder.allocatedCost(BigDecimal)",
    "Builder Builder.allocationPercentage(Integer)",
    "ImmutableMeasurableCostEntry Builder.build()",
    "Builder Builder.costKindId(Long)",
    "Builder Builder.overallCost(BigDecimal)",
    "Builder Builder.year(Integer)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableMeasurableCostEntry.builder();
    BigDecimal allocatedCost = new BigDecimal("2.3");
    Builder actualMeasurableRatingIdResult =
        actualBuilderResult
            .allocatedCost(allocatedCost)
            .allocationDerivation(AllocationDerivation.DERIVED)
            .allocationPercentage(1)
            .appId(1L)
            .costKindId(1L)
            .measurableId(1L)
            .measurableRatingId(1L);
    BigDecimal overallCost = new BigDecimal("2.3");
    ImmutableMeasurableCostEntry actualImmutableMeasurableCostEntry =
        actualMeasurableRatingIdResult.overallCost(overallCost).year(1).build();

    // Assert
    assertEquals(1, actualImmutableMeasurableCostEntry.allocationPercentage().intValue());
    assertEquals(1, actualImmutableMeasurableCostEntry.year().intValue());
    assertEquals(1L, actualImmutableMeasurableCostEntry.costKindId().longValue());
    assertEquals(1L, actualImmutableMeasurableCostEntry.appId());
    assertEquals(1L, actualImmutableMeasurableCostEntry.measurableId());
    assertEquals(1L, actualImmutableMeasurableCostEntry.measurableRatingId());
    assertEquals(
        AllocationDerivation.DERIVED, actualImmutableMeasurableCostEntry.allocationDerivation());
    BigDecimal expectedAllocatedCostResult = new BigDecimal("2.3");
    BigDecimal allocatedCostResult = actualImmutableMeasurableCostEntry.allocatedCost();
    assertEquals(expectedAllocatedCostResult, allocatedCostResult);
    BigDecimal expectedOverallCostResult = new BigDecimal("2.3");
    BigDecimal overallCostResult = actualImmutableMeasurableCostEntry.overallCost();
    assertEquals(expectedOverallCostResult, overallCostResult);
    assertSame(allocatedCost, allocatedCostResult);
    assertSame(overallCost, overallCostResult);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableCostEntry)}.
   *
   * <p>Method under test: {@link Builder#from(MeasurableCostEntry)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableCostEntry)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurableCostEntry)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCostEntry.builder();

    Builder builderResult2 = ImmutableMeasurableCostEntry.builder();

    Builder measurableRatingIdResult =
        builderResult2
            .allocatedCost(new BigDecimal("2.3"))
            .allocationDerivation(AllocationDerivation.DERIVED)
            .allocationPercentage(1)
            .appId(1L)
            .costKindId(1L)
            .measurableId(1L)
            .measurableRatingId(1L);
    ImmutableMeasurableCostEntry instance =
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(1).build();

    // Act and Assert
    ImmutableMeasurableCostEntry actualImmutableMeasurableCostEntry =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableMeasurableCostEntry);
    ImmutableMeasurableCostEntry actualImmutableMeasurableCostEntry2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurableCostEntry2);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableCostEntry)}.
   *
   * <p>Method under test: {@link Builder#from(MeasurableCostEntry)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableCostEntry)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurableCostEntry)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCostEntry.builder();

    Builder measurableRatingIdResult =
        ImmutableMeasurableCostEntry.builder()
            .allocatedCost(null)
            .allocationDerivation(AllocationDerivation.DERIVED)
            .allocationPercentage(1)
            .appId(1L)
            .costKindId(1L)
            .measurableId(1L)
            .measurableRatingId(1L);
    ImmutableMeasurableCostEntry instance =
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(1).build();

    // Act and Assert
    ImmutableMeasurableCostEntry actualImmutableMeasurableCostEntry =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableMeasurableCostEntry);
    ImmutableMeasurableCostEntry actualImmutableMeasurableCostEntry2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurableCostEntry2);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableCostEntry)}.
   *
   * <p>Method under test: {@link Builder#from(MeasurableCostEntry)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableCostEntry)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurableCostEntry)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCostEntry.builder();

    Builder builderResult2 = ImmutableMeasurableCostEntry.builder();

    Builder measurableRatingIdResult =
        builderResult2
            .allocatedCost(new BigDecimal("2.3"))
            .allocationDerivation(AllocationDerivation.DERIVED)
            .allocationPercentage(null)
            .appId(1L)
            .costKindId(1L)
            .measurableId(1L)
            .measurableRatingId(1L);
    ImmutableMeasurableCostEntry instance =
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(1).build();

    // Act and Assert
    ImmutableMeasurableCostEntry actualImmutableMeasurableCostEntry =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableMeasurableCostEntry);
    ImmutableMeasurableCostEntry actualImmutableMeasurableCostEntry2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurableCostEntry2);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableCostEntry)}.
   *
   * <p>Method under test: {@link Builder#from(MeasurableCostEntry)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableCostEntry)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurableCostEntry)"})
  void testBuilderFrom4() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCostEntry.builder();

    Builder builderResult2 = ImmutableMeasurableCostEntry.builder();

    Builder measurableRatingIdResult =
        builderResult2
            .allocatedCost(new BigDecimal("2.3"))
            .allocationDerivation(AllocationDerivation.DERIVED)
            .allocationPercentage(1)
            .appId(1L)
            .costKindId(null)
            .measurableId(1L)
            .measurableRatingId(1L);
    ImmutableMeasurableCostEntry instance =
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(1).build();

    // Act and Assert
    ImmutableMeasurableCostEntry actualImmutableMeasurableCostEntry =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableMeasurableCostEntry);
    ImmutableMeasurableCostEntry actualImmutableMeasurableCostEntry2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurableCostEntry2);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableCostEntry)}.
   *
   * <p>Method under test: {@link Builder#from(MeasurableCostEntry)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableCostEntry)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurableCostEntry)"})
  void testBuilderFrom5() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCostEntry.builder();

    Builder builderResult2 = ImmutableMeasurableCostEntry.builder();
    ImmutableMeasurableCostEntry instance =
        builderResult2
            .allocatedCost(new BigDecimal("2.3"))
            .allocationDerivation(AllocationDerivation.DERIVED)
            .allocationPercentage(1)
            .appId(1L)
            .costKindId(1L)
            .measurableId(1L)
            .measurableRatingId(1L)
            .overallCost(null)
            .year(1)
            .build();

    // Act and Assert
    ImmutableMeasurableCostEntry actualImmutableMeasurableCostEntry =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableMeasurableCostEntry);
    ImmutableMeasurableCostEntry actualImmutableMeasurableCostEntry2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurableCostEntry2);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableCostEntry)}.
   *
   * <p>Method under test: {@link Builder#from(MeasurableCostEntry)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableCostEntry)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurableCostEntry)"})
  void testBuilderFrom6() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCostEntry.builder();

    Builder builderResult2 = ImmutableMeasurableCostEntry.builder();

    Builder measurableRatingIdResult =
        builderResult2
            .allocatedCost(new BigDecimal("2.3"))
            .allocationDerivation(AllocationDerivation.DERIVED)
            .allocationPercentage(1)
            .appId(1L)
            .costKindId(1L)
            .measurableId(1L)
            .measurableRatingId(1L);
    ImmutableMeasurableCostEntry instance =
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(null).build();

    // Act and Assert
    ImmutableMeasurableCostEntry actualImmutableMeasurableCostEntry =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableMeasurableCostEntry);
    ImmutableMeasurableCostEntry actualImmutableMeasurableCostEntry2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurableCostEntry2);
  }

  /**
   * Test Builder {@link Builder#measurableId(long)}.
   *
   * <p>Method under test: {@link Builder#measurableId(long)}
   */
  @Test
  @DisplayName("Test Builder measurableId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.measurableId(long)"})
  void testBuilderMeasurableId() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCostEntry.builder();

    // Act
    Builder actualMeasurableIdResult = builderResult.measurableId(1L);

    // Assert
    assertSame(builderResult, actualMeasurableIdResult);
  }

  /**
   * Test Builder {@link Builder#measurableRatingId(long)}.
   *
   * <p>Method under test: {@link Builder#measurableRatingId(long)}
   */
  @Test
  @DisplayName("Test Builder measurableRatingId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.measurableRatingId(long)"})
  void testBuilderMeasurableRatingId() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCostEntry.builder();

    // Act
    Builder actualMeasurableRatingIdResult = builderResult.measurableRatingId(1L);

    // Assert
    assertSame(builderResult, actualMeasurableRatingIdResult);
  }

  /**
   * Test {@link ImmutableMeasurableCostEntry#copyOf(MeasurableCostEntry)}.
   *
   * <ul>
   *   <li>Then return allocationPercentage intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCostEntry#copyOf(MeasurableCostEntry)}
   */
  @Test
  @DisplayName("Test copyOf(MeasurableCostEntry); then return allocationPercentage intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCostEntry ImmutableMeasurableCostEntry.copyOf(MeasurableCostEntry)"
  })
  void testCopyOf_thenReturnAllocationPercentageIntValueIsOne() {
    // Arrange
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
    ImmutableMeasurableCostEntry instance =
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(1).build();

    // Act
    ImmutableMeasurableCostEntry actualCopyOfResult = ImmutableMeasurableCostEntry.copyOf(instance);

    // Assert
    assertEquals(1, actualCopyOfResult.allocationPercentage().intValue());
    assertEquals(1, actualCopyOfResult.year().intValue());
    assertEquals(1L, actualCopyOfResult.costKindId().longValue());
    assertEquals(1L, actualCopyOfResult.appId());
    assertEquals(1L, actualCopyOfResult.measurableId());
    assertEquals(1L, actualCopyOfResult.measurableRatingId());
    assertEquals(AllocationDerivation.DERIVED, actualCopyOfResult.allocationDerivation());
    BigDecimal expectedAllocatedCostResult = new BigDecimal("2.3");
    assertEquals(expectedAllocatedCostResult, actualCopyOfResult.allocatedCost());
    BigDecimal expectedOverallCostResult = new BigDecimal("2.3");
    assertEquals(expectedOverallCostResult, actualCopyOfResult.overallCost());
  }

  /**
   * Test {@link ImmutableMeasurableCostEntry#equals(Object)}, and {@link
   * ImmutableMeasurableCostEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableCostEntry#equals(Object)}
   *   <li>{@link ImmutableMeasurableCostEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCostEntry.equals(Object)",
    "int ImmutableMeasurableCostEntry.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
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
    ImmutableMeasurableCostEntry immutableMeasurableCostEntry =
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(1).build();

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
    ImmutableMeasurableCostEntry immutableMeasurableCostEntry2 =
        measurableRatingIdResult2.overallCost(new BigDecimal("2.3")).year(1).build();

    // Act and Assert
    assertEquals(immutableMeasurableCostEntry, immutableMeasurableCostEntry2);
    assertEquals(immutableMeasurableCostEntry.hashCode(), immutableMeasurableCostEntry2.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableCostEntry#equals(Object)}, and {@link
   * ImmutableMeasurableCostEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableCostEntry#equals(Object)}
   *   <li>{@link ImmutableMeasurableCostEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCostEntry.equals(Object)",
    "int ImmutableMeasurableCostEntry.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
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
    ImmutableMeasurableCostEntry immutableMeasurableCostEntry =
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(1).build();

    // Act and Assert
    assertEquals(immutableMeasurableCostEntry, immutableMeasurableCostEntry);
    int expectedHashCodeResult = immutableMeasurableCostEntry.hashCode();
    assertEquals(expectedHashCodeResult, immutableMeasurableCostEntry.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableCostEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCostEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCostEntry.equals(Object)",
    "int ImmutableMeasurableCostEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCostEntry.builder();

    Builder measurableRatingIdResult =
        builderResult
            .allocatedCost(new BigDecimal("4.5"))
            .allocationDerivation(AllocationDerivation.DERIVED)
            .allocationPercentage(1)
            .appId(1L)
            .costKindId(1L)
            .measurableId(1L)
            .measurableRatingId(1L);
    ImmutableMeasurableCostEntry immutableMeasurableCostEntry =
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(1).build();

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

    // Act and Assert
    assertNotEquals(
        immutableMeasurableCostEntry,
        measurableRatingIdResult2.overallCost(new BigDecimal("2.3")).year(1).build());
  }

  /**
   * Test {@link ImmutableMeasurableCostEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCostEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCostEntry.equals(Object)",
    "int ImmutableMeasurableCostEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCostEntry.builder();

    Builder measurableRatingIdResult =
        builderResult
            .allocatedCost(new BigDecimal("2.3"))
            .allocationDerivation(AllocationDerivation.EXPLICIT)
            .allocationPercentage(1)
            .appId(1L)
            .costKindId(1L)
            .measurableId(1L)
            .measurableRatingId(1L);
    ImmutableMeasurableCostEntry immutableMeasurableCostEntry =
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(1).build();

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

    // Act and Assert
    assertNotEquals(
        immutableMeasurableCostEntry,
        measurableRatingIdResult2.overallCost(new BigDecimal("2.3")).year(1).build());
  }

  /**
   * Test {@link ImmutableMeasurableCostEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCostEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCostEntry.equals(Object)",
    "int ImmutableMeasurableCostEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCostEntry.builder();

    Builder measurableRatingIdResult =
        builderResult
            .allocatedCost(new BigDecimal("2.3"))
            .allocationDerivation(AllocationDerivation.DERIVED)
            .allocationPercentage(0)
            .appId(1L)
            .costKindId(1L)
            .measurableId(1L)
            .measurableRatingId(1L);
    ImmutableMeasurableCostEntry immutableMeasurableCostEntry =
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(1).build();

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

    // Act and Assert
    assertNotEquals(
        immutableMeasurableCostEntry,
        measurableRatingIdResult2.overallCost(new BigDecimal("2.3")).year(1).build());
  }

  /**
   * Test {@link ImmutableMeasurableCostEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCostEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCostEntry.equals(Object)",
    "int ImmutableMeasurableCostEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCostEntry.builder();

    Builder measurableRatingIdResult =
        builderResult
            .allocatedCost(new BigDecimal("2.3"))
            .allocationDerivation(AllocationDerivation.DERIVED)
            .allocationPercentage(1)
            .appId(2L)
            .costKindId(1L)
            .measurableId(1L)
            .measurableRatingId(1L);
    ImmutableMeasurableCostEntry immutableMeasurableCostEntry =
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(1).build();

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

    // Act and Assert
    assertNotEquals(
        immutableMeasurableCostEntry,
        measurableRatingIdResult2.overallCost(new BigDecimal("2.3")).year(1).build());
  }

  /**
   * Test {@link ImmutableMeasurableCostEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCostEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCostEntry.equals(Object)",
    "int ImmutableMeasurableCostEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCostEntry.builder();

    Builder measurableRatingIdResult =
        builderResult
            .allocatedCost(new BigDecimal("2.3"))
            .allocationDerivation(AllocationDerivation.DERIVED)
            .allocationPercentage(1)
            .appId(1L)
            .costKindId(2L)
            .measurableId(1L)
            .measurableRatingId(1L);
    ImmutableMeasurableCostEntry immutableMeasurableCostEntry =
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(1).build();

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

    // Act and Assert
    assertNotEquals(
        immutableMeasurableCostEntry,
        measurableRatingIdResult2.overallCost(new BigDecimal("2.3")).year(1).build());
  }

  /**
   * Test {@link ImmutableMeasurableCostEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCostEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCostEntry.equals(Object)",
    "int ImmutableMeasurableCostEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCostEntry.builder();

    Builder measurableRatingIdResult =
        builderResult
            .allocatedCost(new BigDecimal("2.3"))
            .allocationDerivation(AllocationDerivation.DERIVED)
            .allocationPercentage(1)
            .appId(1L)
            .costKindId(1L)
            .measurableId(2L)
            .measurableRatingId(1L);
    ImmutableMeasurableCostEntry immutableMeasurableCostEntry =
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(1).build();

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

    // Act and Assert
    assertNotEquals(
        immutableMeasurableCostEntry,
        measurableRatingIdResult2.overallCost(new BigDecimal("2.3")).year(1).build());
  }

  /**
   * Test {@link ImmutableMeasurableCostEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCostEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCostEntry.equals(Object)",
    "int ImmutableMeasurableCostEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCostEntry.builder();

    Builder measurableRatingIdResult =
        builderResult
            .allocatedCost(new BigDecimal("2.3"))
            .allocationDerivation(AllocationDerivation.DERIVED)
            .allocationPercentage(1)
            .appId(1L)
            .costKindId(1L)
            .measurableId(1L)
            .measurableRatingId(2L);
    ImmutableMeasurableCostEntry immutableMeasurableCostEntry =
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(1).build();

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

    // Act and Assert
    assertNotEquals(
        immutableMeasurableCostEntry,
        measurableRatingIdResult2.overallCost(new BigDecimal("2.3")).year(1).build());
  }

  /**
   * Test {@link ImmutableMeasurableCostEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCostEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCostEntry.equals(Object)",
    "int ImmutableMeasurableCostEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
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
    ImmutableMeasurableCostEntry immutableMeasurableCostEntry =
        measurableRatingIdResult.overallCost(new BigDecimal("4.5")).year(1).build();

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

    // Act and Assert
    assertNotEquals(
        immutableMeasurableCostEntry,
        measurableRatingIdResult2.overallCost(new BigDecimal("2.3")).year(1).build());
  }

  /**
   * Test {@link ImmutableMeasurableCostEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCostEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCostEntry.equals(Object)",
    "int ImmutableMeasurableCostEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
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
    ImmutableMeasurableCostEntry immutableMeasurableCostEntry =
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(0).build();

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

    // Act and Assert
    assertNotEquals(
        immutableMeasurableCostEntry,
        measurableRatingIdResult2.overallCost(new BigDecimal("2.3")).year(1).build());
  }

  /**
   * Test {@link ImmutableMeasurableCostEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCostEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCostEntry.equals(Object)",
    "int ImmutableMeasurableCostEntry.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
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

    // Act and Assert
    assertNotEquals(
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(1).build(), null);
  }

  /**
   * Test {@link ImmutableMeasurableCostEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCostEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCostEntry.equals(Object)",
    "int ImmutableMeasurableCostEntry.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
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

    // Act and Assert
    assertNotEquals(
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(1).build(),
        "Different type to ImmutableMeasurableCostEntry");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableCostEntry#toString()}
   *   <li>{@link ImmutableMeasurableCostEntry#allocatedCost()}
   *   <li>{@link ImmutableMeasurableCostEntry#allocationDerivation()}
   *   <li>{@link ImmutableMeasurableCostEntry#allocationPercentage()}
   *   <li>{@link ImmutableMeasurableCostEntry#appId()}
   *   <li>{@link ImmutableMeasurableCostEntry#costKindId()}
   *   <li>{@link ImmutableMeasurableCostEntry#measurableId()}
   *   <li>{@link ImmutableMeasurableCostEntry#measurableRatingId()}
   *   <li>{@link ImmutableMeasurableCostEntry#overallCost()}
   *   <li>{@link ImmutableMeasurableCostEntry#year()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal ImmutableMeasurableCostEntry.allocatedCost()",
    "AllocationDerivation ImmutableMeasurableCostEntry.allocationDerivation()",
    "Integer ImmutableMeasurableCostEntry.allocationPercentage()",
    "long ImmutableMeasurableCostEntry.appId()",
    "Long ImmutableMeasurableCostEntry.costKindId()",
    "long ImmutableMeasurableCostEntry.measurableId()",
    "long ImmutableMeasurableCostEntry.measurableRatingId()",
    "BigDecimal ImmutableMeasurableCostEntry.overallCost()",
    "String ImmutableMeasurableCostEntry.toString()",
    "Integer ImmutableMeasurableCostEntry.year()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCostEntry.builder();
    BigDecimal allocatedCost = new BigDecimal("2.3");

    Builder measurableRatingIdResult =
        builderResult
            .allocatedCost(allocatedCost)
            .allocationDerivation(AllocationDerivation.DERIVED)
            .allocationPercentage(1)
            .appId(1L)
            .costKindId(1L)
            .measurableId(1L)
            .measurableRatingId(1L);
    BigDecimal overallCost = new BigDecimal("2.3");
    ImmutableMeasurableCostEntry immutableMeasurableCostEntry =
        measurableRatingIdResult.overallCost(overallCost).year(1).build();

    // Act
    String actualToStringResult = immutableMeasurableCostEntry.toString();
    BigDecimal actualAllocatedCostResult = immutableMeasurableCostEntry.allocatedCost();
    AllocationDerivation actualAllocationDerivationResult =
        immutableMeasurableCostEntry.allocationDerivation();
    Integer actualAllocationPercentageResult = immutableMeasurableCostEntry.allocationPercentage();
    long actualAppIdResult = immutableMeasurableCostEntry.appId();
    Long actualCostKindIdResult = immutableMeasurableCostEntry.costKindId();
    long actualMeasurableIdResult = immutableMeasurableCostEntry.measurableId();
    long actualMeasurableRatingIdResult = immutableMeasurableCostEntry.measurableRatingId();
    BigDecimal actualOverallCostResult = immutableMeasurableCostEntry.overallCost();
    Integer actualYearResult = immutableMeasurableCostEntry.year();

    // Assert
    assertEquals(
        "MeasurableCostEntry{appId=1, measurableId=1, measurableRatingId=1, costKindId=1, year=1, allocationPercentage"
            + "=1, overallCost=2.3, allocatedCost=2.3, allocationDerivation=DERIVED}",
        actualToStringResult);
    assertEquals(1, actualAllocationPercentageResult.intValue());
    assertEquals(1, actualYearResult.intValue());
    assertEquals(1L, actualCostKindIdResult.longValue());
    assertEquals(1L, actualAppIdResult);
    assertEquals(1L, actualMeasurableIdResult);
    assertEquals(1L, actualMeasurableRatingIdResult);
    assertEquals(AllocationDerivation.DERIVED, actualAllocationDerivationResult);
    assertEquals(new BigDecimal("2.3"), actualAllocatedCostResult);
    assertEquals(new BigDecimal("2.3"), actualOverallCostResult);
    assertSame(allocatedCost, actualAllocatedCostResult);
    assertSame(overallCost, actualOverallCostResult);
  }

  /**
   * Test Json {@link Json#allocatedCost()}.
   *
   * <p>Method under test: {@link Json#allocatedCost()}
   */
  @Test
  @DisplayName("Test Json allocatedCost()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal Json.allocatedCost()"})
  void testJsonAllocatedCost() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().allocatedCost());
  }

  /**
   * Test Json {@link Json#allocationDerivation()}.
   *
   * <p>Method under test: {@link Json#allocationDerivation()}
   */
  @Test
  @DisplayName("Test Json allocationDerivation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AllocationDerivation Json.allocationDerivation()"})
  void testJsonAllocationDerivation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().allocationDerivation());
  }

  /**
   * Test Json {@link Json#allocationPercentage()}.
   *
   * <p>Method under test: {@link Json#allocationPercentage()}
   */
  @Test
  @DisplayName("Test Json allocationPercentage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer Json.allocationPercentage()"})
  void testJsonAllocationPercentage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().allocationPercentage());
  }

  /**
   * Test Json {@link Json#appId()}.
   *
   * <p>Method under test: {@link Json#appId()}
   */
  @Test
  @DisplayName("Test Json appId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.appId()"})
  void testJsonAppId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().appId());
  }

  /**
   * Test Json {@link Json#costKindId()}.
   *
   * <p>Method under test: {@link Json#costKindId()}
   */
  @Test
  @DisplayName("Test Json costKindId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.costKindId()"})
  void testJsonCostKindId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().costKindId());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setAllocatedCost(BigDecimal)}
   *   <li>{@link Json#setAllocationDerivation(AllocationDerivation)}
   *   <li>{@link Json#setAllocationPercentage(Integer)}
   *   <li>{@link Json#setCostKindId(Long)}
   *   <li>{@link Json#setOverallCost(BigDecimal)}
   *   <li>{@link Json#setYear(Integer)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setAllocatedCost(BigDecimal)",
    "void Json.setAllocationDerivation(AllocationDerivation)",
    "void Json.setAllocationPercentage(Integer)",
    "void Json.setCostKindId(Long)",
    "void Json.setOverallCost(BigDecimal)",
    "void Json.setYear(Integer)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setAllocatedCost(new BigDecimal("2.3"));
    actualJson.setAllocationDerivation(AllocationDerivation.DERIVED);
    actualJson.setAllocationPercentage(1);
    actualJson.setCostKindId(1L);
    actualJson.setOverallCost(new BigDecimal("2.3"));
    actualJson.setYear(1);

    // Assert
    assertEquals(1, actualJson.allocationPercentage.intValue());
    assertEquals(1, actualJson.year.intValue());
    assertEquals(1L, actualJson.costKindId.longValue());
  }

  /**
   * Test Json {@link Json#measurableId()}.
   *
   * <p>Method under test: {@link Json#measurableId()}
   */
  @Test
  @DisplayName("Test Json measurableId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.measurableId()"})
  void testJsonMeasurableId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().measurableId());
  }

  /**
   * Test Json {@link Json#measurableRatingId()}.
   *
   * <p>Method under test: {@link Json#measurableRatingId()}
   */
  @Test
  @DisplayName("Test Json measurableRatingId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.measurableRatingId()"})
  void testJsonMeasurableRatingId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().measurableRatingId());
  }

  /**
   * Test Json {@link Json#overallCost()}.
   *
   * <p>Method under test: {@link Json#overallCost()}
   */
  @Test
  @DisplayName("Test Json overallCost()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal Json.overallCost()"})
  void testJsonOverallCost() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().overallCost());
  }

  /**
   * Test Json {@link Json#setAppId(long)}.
   *
   * <p>Method under test: {@link Json#setAppId(long)}
   */
  @Test
  @DisplayName("Test Json setAppId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setAppId(long)"})
  void testJsonSetAppId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setAppId(1L);

    // Assert
    assertEquals(1L, json.appId);
    assertTrue(json.appIdIsSet);
  }

  /**
   * Test Json {@link Json#setMeasurableId(long)}.
   *
   * <p>Method under test: {@link Json#setMeasurableId(long)}
   */
  @Test
  @DisplayName("Test Json setMeasurableId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setMeasurableId(long)"})
  void testJsonSetMeasurableId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setMeasurableId(1L);

    // Assert
    assertEquals(1L, json.measurableId);
    assertTrue(json.measurableIdIsSet);
  }

  /**
   * Test Json {@link Json#setMeasurableRatingId(long)}.
   *
   * <p>Method under test: {@link Json#setMeasurableRatingId(long)}
   */
  @Test
  @DisplayName("Test Json setMeasurableRatingId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setMeasurableRatingId(long)"})
  void testJsonSetMeasurableRatingId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setMeasurableRatingId(1L);

    // Assert
    assertEquals(1L, json.measurableRatingId);
    assertTrue(json.measurableRatingIdIsSet);
  }

  /**
   * Test Json {@link Json#year()}.
   *
   * <p>Method under test: {@link Json#year()}
   */
  @Test
  @DisplayName("Test Json year()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer Json.year()"})
  void testJsonYear() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().year());
  }

  /**
   * Test {@link ImmutableMeasurableCostEntry#withAllocatedCost(BigDecimal)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableCostEntry#withAllocatedCost(BigDecimal)}
   */
  @Test
  @DisplayName("Test withAllocatedCost(BigDecimal)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCostEntry ImmutableMeasurableCostEntry.withAllocatedCost(BigDecimal)"
  })
  void testWithAllocatedCost() {
    // Arrange
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
    ImmutableMeasurableCostEntry immutableMeasurableCostEntry =
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(1).build();

    // Act
    ImmutableMeasurableCostEntry actualWithAllocatedCostResult =
        immutableMeasurableCostEntry.withAllocatedCost(new BigDecimal("2.3"));

    // Assert
    assertSame(immutableMeasurableCostEntry, actualWithAllocatedCostResult);
  }

  /**
   * Test {@link ImmutableMeasurableCostEntry#withAllocatedCost(BigDecimal)}.
   *
   * <ul>
   *   <li>Then return allocationPercentage intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCostEntry#withAllocatedCost(BigDecimal)}
   */
  @Test
  @DisplayName(
      "Test withAllocatedCost(BigDecimal); then return allocationPercentage intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCostEntry ImmutableMeasurableCostEntry.withAllocatedCost(BigDecimal)"
  })
  void testWithAllocatedCost_thenReturnAllocationPercentageIntValueIsOne() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCostEntry.builder();

    Builder measurableRatingIdResult =
        builderResult
            .allocatedCost(new BigDecimal("4.5"))
            .allocationDerivation(AllocationDerivation.DERIVED)
            .allocationPercentage(1)
            .appId(1L)
            .costKindId(1L)
            .measurableId(1L)
            .measurableRatingId(1L);
    ImmutableMeasurableCostEntry immutableMeasurableCostEntry =
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(1).build();

    // Act
    ImmutableMeasurableCostEntry actualWithAllocatedCostResult =
        immutableMeasurableCostEntry.withAllocatedCost(new BigDecimal("2.3"));

    // Assert
    assertEquals(1, actualWithAllocatedCostResult.allocationPercentage().intValue());
    assertEquals(1, actualWithAllocatedCostResult.year().intValue());
    assertEquals(1L, actualWithAllocatedCostResult.costKindId().longValue());
    assertEquals(1L, actualWithAllocatedCostResult.appId());
    assertEquals(1L, actualWithAllocatedCostResult.measurableId());
    assertEquals(1L, actualWithAllocatedCostResult.measurableRatingId());
    assertEquals(
        AllocationDerivation.DERIVED, actualWithAllocatedCostResult.allocationDerivation());
    BigDecimal expectedAllocatedCostResult = new BigDecimal("2.3");
    assertEquals(expectedAllocatedCostResult, actualWithAllocatedCostResult.allocatedCost());
    BigDecimal expectedOverallCostResult = new BigDecimal("2.3");
    assertEquals(expectedOverallCostResult, actualWithAllocatedCostResult.overallCost());
  }

  /**
   * Test {@link ImmutableMeasurableCostEntry#withAllocationDerivation(AllocationDerivation)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableCostEntry#withAllocationDerivation(AllocationDerivation)}
   */
  @Test
  @DisplayName("Test withAllocationDerivation(AllocationDerivation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCostEntry ImmutableMeasurableCostEntry.withAllocationDerivation(AllocationDerivation)"
  })
  void testWithAllocationDerivation() {
    // Arrange
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
    ImmutableMeasurableCostEntry immutableMeasurableCostEntry =
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(1).build();

    // Act
    ImmutableMeasurableCostEntry actualWithAllocationDerivationResult =
        immutableMeasurableCostEntry.withAllocationDerivation(AllocationDerivation.DERIVED);

    // Assert
    assertSame(immutableMeasurableCostEntry, actualWithAllocationDerivationResult);
  }

  /**
   * Test {@link ImmutableMeasurableCostEntry#withAllocationDerivation(AllocationDerivation)}.
   *
   * <ul>
   *   <li>Then return allocationPercentage intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableCostEntry#withAllocationDerivation(AllocationDerivation)}
   */
  @Test
  @DisplayName(
      "Test withAllocationDerivation(AllocationDerivation); then return allocationPercentage intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCostEntry ImmutableMeasurableCostEntry.withAllocationDerivation(AllocationDerivation)"
  })
  void testWithAllocationDerivation_thenReturnAllocationPercentageIntValueIsOne() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCostEntry.builder();

    Builder measurableRatingIdResult =
        builderResult
            .allocatedCost(new BigDecimal("2.3"))
            .allocationDerivation(AllocationDerivation.EXPLICIT)
            .allocationPercentage(1)
            .appId(1L)
            .costKindId(1L)
            .measurableId(1L)
            .measurableRatingId(1L);

    // Act
    ImmutableMeasurableCostEntry actualWithAllocationDerivationResult =
        measurableRatingIdResult
            .overallCost(new BigDecimal("2.3"))
            .year(1)
            .build()
            .withAllocationDerivation(AllocationDerivation.DERIVED);

    // Assert
    assertEquals(1, actualWithAllocationDerivationResult.allocationPercentage().intValue());
    assertEquals(1, actualWithAllocationDerivationResult.year().intValue());
    assertEquals(1L, actualWithAllocationDerivationResult.costKindId().longValue());
    assertEquals(1L, actualWithAllocationDerivationResult.appId());
    assertEquals(1L, actualWithAllocationDerivationResult.measurableId());
    assertEquals(1L, actualWithAllocationDerivationResult.measurableRatingId());
    assertEquals(
        AllocationDerivation.DERIVED, actualWithAllocationDerivationResult.allocationDerivation());
    BigDecimal expectedAllocatedCostResult = new BigDecimal("2.3");
    assertEquals(expectedAllocatedCostResult, actualWithAllocationDerivationResult.allocatedCost());
    BigDecimal expectedOverallCostResult = new BigDecimal("2.3");
    assertEquals(expectedOverallCostResult, actualWithAllocationDerivationResult.overallCost());
  }

  /**
   * Test {@link ImmutableMeasurableCostEntry#withAllocationPercentage(Integer)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableCostEntry#withAllocationPercentage(Integer)}
   */
  @Test
  @DisplayName("Test withAllocationPercentage(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCostEntry ImmutableMeasurableCostEntry.withAllocationPercentage(Integer)"
  })
  void testWithAllocationPercentage() {
    // Arrange
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
    ImmutableMeasurableCostEntry immutableMeasurableCostEntry =
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(1).build();

    // Act
    ImmutableMeasurableCostEntry actualWithAllocationPercentageResult =
        immutableMeasurableCostEntry.withAllocationPercentage(1);

    // Assert
    assertSame(immutableMeasurableCostEntry, actualWithAllocationPercentageResult);
  }

  /**
   * Test {@link ImmutableMeasurableCostEntry#withAllocationPercentage(Integer)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return year intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCostEntry#withAllocationPercentage(Integer)}
   */
  @Test
  @DisplayName(
      "Test withAllocationPercentage(Integer); when forty-two; then return year intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCostEntry ImmutableMeasurableCostEntry.withAllocationPercentage(Integer)"
  })
  void testWithAllocationPercentage_whenFortyTwo_thenReturnYearIntValueIsOne() {
    // Arrange
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

    // Act
    ImmutableMeasurableCostEntry actualWithAllocationPercentageResult =
        measurableRatingIdResult
            .overallCost(new BigDecimal("2.3"))
            .year(1)
            .build()
            .withAllocationPercentage(42);

    // Assert
    assertEquals(1, actualWithAllocationPercentageResult.year().intValue());
    assertEquals(1L, actualWithAllocationPercentageResult.costKindId().longValue());
    assertEquals(1L, actualWithAllocationPercentageResult.appId());
    assertEquals(1L, actualWithAllocationPercentageResult.measurableId());
    assertEquals(1L, actualWithAllocationPercentageResult.measurableRatingId());
    assertEquals(42, actualWithAllocationPercentageResult.allocationPercentage().intValue());
    assertEquals(
        AllocationDerivation.DERIVED, actualWithAllocationPercentageResult.allocationDerivation());
    BigDecimal expectedAllocatedCostResult = new BigDecimal("2.3");
    assertEquals(expectedAllocatedCostResult, actualWithAllocationPercentageResult.allocatedCost());
    BigDecimal expectedOverallCostResult = new BigDecimal("2.3");
    assertEquals(expectedOverallCostResult, actualWithAllocationPercentageResult.overallCost());
  }

  /**
   * Test {@link ImmutableMeasurableCostEntry#withAppId(long)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableCostEntry#withAppId(long)}
   */
  @Test
  @DisplayName("Test withAppId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableCostEntry ImmutableMeasurableCostEntry.withAppId(long)"})
  void testWithAppId() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCostEntry.builder();

    Builder measurableRatingIdResult =
        builderResult
            .allocatedCost(new BigDecimal("2.3"))
            .allocationDerivation(AllocationDerivation.DERIVED)
            .allocationPercentage(1)
            .appId(42L)
            .costKindId(1L)
            .measurableId(1L)
            .measurableRatingId(1L);
    ImmutableMeasurableCostEntry immutableMeasurableCostEntry =
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(1).build();

    // Act
    ImmutableMeasurableCostEntry actualWithAppIdResult =
        immutableMeasurableCostEntry.withAppId(42L);

    // Assert
    assertSame(immutableMeasurableCostEntry, actualWithAppIdResult);
  }

  /**
   * Test {@link ImmutableMeasurableCostEntry#withAppId(long)}.
   *
   * <ul>
   *   <li>Then return allocationPercentage intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCostEntry#withAppId(long)}
   */
  @Test
  @DisplayName("Test withAppId(long); then return allocationPercentage intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableCostEntry ImmutableMeasurableCostEntry.withAppId(long)"})
  void testWithAppId_thenReturnAllocationPercentageIntValueIsOne() {
    // Arrange
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

    // Act
    ImmutableMeasurableCostEntry actualWithAppIdResult =
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(1).build().withAppId(42L);

    // Assert
    assertEquals(1, actualWithAppIdResult.allocationPercentage().intValue());
    assertEquals(1, actualWithAppIdResult.year().intValue());
    assertEquals(1L, actualWithAppIdResult.costKindId().longValue());
    assertEquals(1L, actualWithAppIdResult.measurableId());
    assertEquals(1L, actualWithAppIdResult.measurableRatingId());
    assertEquals(42L, actualWithAppIdResult.appId());
    assertEquals(AllocationDerivation.DERIVED, actualWithAppIdResult.allocationDerivation());
    BigDecimal expectedAllocatedCostResult = new BigDecimal("2.3");
    assertEquals(expectedAllocatedCostResult, actualWithAppIdResult.allocatedCost());
    BigDecimal expectedOverallCostResult = new BigDecimal("2.3");
    assertEquals(expectedOverallCostResult, actualWithAppIdResult.overallCost());
  }

  /**
   * Test {@link ImmutableMeasurableCostEntry#withCostKindId(Long)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableCostEntry#withCostKindId(Long)}
   */
  @Test
  @DisplayName("Test withCostKindId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCostEntry ImmutableMeasurableCostEntry.withCostKindId(Long)"
  })
  void testWithCostKindId() {
    // Arrange
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
    ImmutableMeasurableCostEntry immutableMeasurableCostEntry =
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(1).build();

    // Act
    ImmutableMeasurableCostEntry actualWithCostKindIdResult =
        immutableMeasurableCostEntry.withCostKindId(1L);

    // Assert
    assertSame(immutableMeasurableCostEntry, actualWithCostKindIdResult);
  }

  /**
   * Test {@link ImmutableMeasurableCostEntry#withCostKindId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return allocationPercentage intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCostEntry#withCostKindId(Long)}
   */
  @Test
  @DisplayName(
      "Test withCostKindId(Long); when forty-two; then return allocationPercentage intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCostEntry ImmutableMeasurableCostEntry.withCostKindId(Long)"
  })
  void testWithCostKindId_whenFortyTwo_thenReturnAllocationPercentageIntValueIsOne() {
    // Arrange
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

    // Act
    ImmutableMeasurableCostEntry actualWithCostKindIdResult =
        measurableRatingIdResult
            .overallCost(new BigDecimal("2.3"))
            .year(1)
            .build()
            .withCostKindId(42L);

    // Assert
    assertEquals(1, actualWithCostKindIdResult.allocationPercentage().intValue());
    assertEquals(1, actualWithCostKindIdResult.year().intValue());
    assertEquals(1L, actualWithCostKindIdResult.appId());
    assertEquals(1L, actualWithCostKindIdResult.measurableId());
    assertEquals(1L, actualWithCostKindIdResult.measurableRatingId());
    assertEquals(42L, actualWithCostKindIdResult.costKindId().longValue());
    assertEquals(AllocationDerivation.DERIVED, actualWithCostKindIdResult.allocationDerivation());
    BigDecimal expectedAllocatedCostResult = new BigDecimal("2.3");
    assertEquals(expectedAllocatedCostResult, actualWithCostKindIdResult.allocatedCost());
    BigDecimal expectedOverallCostResult = new BigDecimal("2.3");
    assertEquals(expectedOverallCostResult, actualWithCostKindIdResult.overallCost());
  }

  /**
   * Test {@link ImmutableMeasurableCostEntry#withMeasurableId(long)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableCostEntry#withMeasurableId(long)}
   */
  @Test
  @DisplayName("Test withMeasurableId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCostEntry ImmutableMeasurableCostEntry.withMeasurableId(long)"
  })
  void testWithMeasurableId() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCostEntry.builder();

    Builder measurableRatingIdResult =
        builderResult
            .allocatedCost(new BigDecimal("2.3"))
            .allocationDerivation(AllocationDerivation.DERIVED)
            .allocationPercentage(1)
            .appId(1L)
            .costKindId(1L)
            .measurableId(42L)
            .measurableRatingId(1L);
    ImmutableMeasurableCostEntry immutableMeasurableCostEntry =
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(1).build();

    // Act
    ImmutableMeasurableCostEntry actualWithMeasurableIdResult =
        immutableMeasurableCostEntry.withMeasurableId(42L);

    // Assert
    assertSame(immutableMeasurableCostEntry, actualWithMeasurableIdResult);
  }

  /**
   * Test {@link ImmutableMeasurableCostEntry#withMeasurableId(long)}.
   *
   * <ul>
   *   <li>Then return allocationPercentage intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCostEntry#withMeasurableId(long)}
   */
  @Test
  @DisplayName("Test withMeasurableId(long); then return allocationPercentage intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCostEntry ImmutableMeasurableCostEntry.withMeasurableId(long)"
  })
  void testWithMeasurableId_thenReturnAllocationPercentageIntValueIsOne() {
    // Arrange
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

    // Act
    ImmutableMeasurableCostEntry actualWithMeasurableIdResult =
        measurableRatingIdResult
            .overallCost(new BigDecimal("2.3"))
            .year(1)
            .build()
            .withMeasurableId(42L);

    // Assert
    assertEquals(1, actualWithMeasurableIdResult.allocationPercentage().intValue());
    assertEquals(1, actualWithMeasurableIdResult.year().intValue());
    assertEquals(1L, actualWithMeasurableIdResult.costKindId().longValue());
    assertEquals(1L, actualWithMeasurableIdResult.appId());
    assertEquals(1L, actualWithMeasurableIdResult.measurableRatingId());
    assertEquals(42L, actualWithMeasurableIdResult.measurableId());
    assertEquals(AllocationDerivation.DERIVED, actualWithMeasurableIdResult.allocationDerivation());
    BigDecimal expectedAllocatedCostResult = new BigDecimal("2.3");
    assertEquals(expectedAllocatedCostResult, actualWithMeasurableIdResult.allocatedCost());
    BigDecimal expectedOverallCostResult = new BigDecimal("2.3");
    assertEquals(expectedOverallCostResult, actualWithMeasurableIdResult.overallCost());
  }

  /**
   * Test {@link ImmutableMeasurableCostEntry#withMeasurableRatingId(long)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableCostEntry#withMeasurableRatingId(long)}
   */
  @Test
  @DisplayName("Test withMeasurableRatingId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCostEntry ImmutableMeasurableCostEntry.withMeasurableRatingId(long)"
  })
  void testWithMeasurableRatingId() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCostEntry.builder();

    Builder measurableRatingIdResult =
        builderResult
            .allocatedCost(new BigDecimal("2.3"))
            .allocationDerivation(AllocationDerivation.DERIVED)
            .allocationPercentage(1)
            .appId(1L)
            .costKindId(1L)
            .measurableId(1L)
            .measurableRatingId(42L);
    ImmutableMeasurableCostEntry immutableMeasurableCostEntry =
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(1).build();

    // Act
    ImmutableMeasurableCostEntry actualWithMeasurableRatingIdResult =
        immutableMeasurableCostEntry.withMeasurableRatingId(42L);

    // Assert
    assertSame(immutableMeasurableCostEntry, actualWithMeasurableRatingIdResult);
  }

  /**
   * Test {@link ImmutableMeasurableCostEntry#withMeasurableRatingId(long)}.
   *
   * <ul>
   *   <li>Then return allocationPercentage intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCostEntry#withMeasurableRatingId(long)}
   */
  @Test
  @DisplayName(
      "Test withMeasurableRatingId(long); then return allocationPercentage intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCostEntry ImmutableMeasurableCostEntry.withMeasurableRatingId(long)"
  })
  void testWithMeasurableRatingId_thenReturnAllocationPercentageIntValueIsOne() {
    // Arrange
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

    // Act
    ImmutableMeasurableCostEntry actualWithMeasurableRatingIdResult =
        measurableRatingIdResult
            .overallCost(new BigDecimal("2.3"))
            .year(1)
            .build()
            .withMeasurableRatingId(42L);

    // Assert
    assertEquals(1, actualWithMeasurableRatingIdResult.allocationPercentage().intValue());
    assertEquals(1, actualWithMeasurableRatingIdResult.year().intValue());
    assertEquals(1L, actualWithMeasurableRatingIdResult.costKindId().longValue());
    assertEquals(1L, actualWithMeasurableRatingIdResult.appId());
    assertEquals(1L, actualWithMeasurableRatingIdResult.measurableId());
    assertEquals(42L, actualWithMeasurableRatingIdResult.measurableRatingId());
    assertEquals(
        AllocationDerivation.DERIVED, actualWithMeasurableRatingIdResult.allocationDerivation());
    BigDecimal expectedAllocatedCostResult = new BigDecimal("2.3");
    assertEquals(expectedAllocatedCostResult, actualWithMeasurableRatingIdResult.allocatedCost());
    BigDecimal expectedOverallCostResult = new BigDecimal("2.3");
    assertEquals(expectedOverallCostResult, actualWithMeasurableRatingIdResult.overallCost());
  }

  /**
   * Test {@link ImmutableMeasurableCostEntry#withOverallCost(BigDecimal)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableCostEntry#withOverallCost(BigDecimal)}
   */
  @Test
  @DisplayName("Test withOverallCost(BigDecimal)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCostEntry ImmutableMeasurableCostEntry.withOverallCost(BigDecimal)"
  })
  void testWithOverallCost() {
    // Arrange
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
    ImmutableMeasurableCostEntry immutableMeasurableCostEntry =
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(1).build();

    // Act
    ImmutableMeasurableCostEntry actualWithOverallCostResult =
        immutableMeasurableCostEntry.withOverallCost(new BigDecimal("2.3"));

    // Assert
    assertSame(immutableMeasurableCostEntry, actualWithOverallCostResult);
  }

  /**
   * Test {@link ImmutableMeasurableCostEntry#withOverallCost(BigDecimal)}.
   *
   * <ul>
   *   <li>Then return allocationPercentage intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCostEntry#withOverallCost(BigDecimal)}
   */
  @Test
  @DisplayName("Test withOverallCost(BigDecimal); then return allocationPercentage intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCostEntry ImmutableMeasurableCostEntry.withOverallCost(BigDecimal)"
  })
  void testWithOverallCost_thenReturnAllocationPercentageIntValueIsOne() {
    // Arrange
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
    ImmutableMeasurableCostEntry immutableMeasurableCostEntry =
        measurableRatingIdResult.overallCost(new BigDecimal("4.5")).year(1).build();

    // Act
    ImmutableMeasurableCostEntry actualWithOverallCostResult =
        immutableMeasurableCostEntry.withOverallCost(new BigDecimal("2.3"));

    // Assert
    assertEquals(1, actualWithOverallCostResult.allocationPercentage().intValue());
    assertEquals(1, actualWithOverallCostResult.year().intValue());
    assertEquals(1L, actualWithOverallCostResult.costKindId().longValue());
    assertEquals(1L, actualWithOverallCostResult.appId());
    assertEquals(1L, actualWithOverallCostResult.measurableId());
    assertEquals(1L, actualWithOverallCostResult.measurableRatingId());
    assertEquals(AllocationDerivation.DERIVED, actualWithOverallCostResult.allocationDerivation());
    BigDecimal expectedAllocatedCostResult = new BigDecimal("2.3");
    assertEquals(expectedAllocatedCostResult, actualWithOverallCostResult.allocatedCost());
    BigDecimal expectedOverallCostResult = new BigDecimal("2.3");
    assertEquals(expectedOverallCostResult, actualWithOverallCostResult.overallCost());
  }

  /**
   * Test {@link ImmutableMeasurableCostEntry#withYear(Integer)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableCostEntry#withYear(Integer)}
   */
  @Test
  @DisplayName("Test withYear(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableCostEntry ImmutableMeasurableCostEntry.withYear(Integer)"})
  void testWithYear() {
    // Arrange
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
    ImmutableMeasurableCostEntry immutableMeasurableCostEntry =
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(1).build();

    // Act
    ImmutableMeasurableCostEntry actualWithYearResult = immutableMeasurableCostEntry.withYear(1);

    // Assert
    assertSame(immutableMeasurableCostEntry, actualWithYearResult);
  }

  /**
   * Test {@link ImmutableMeasurableCostEntry#withYear(Integer)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return allocationPercentage intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCostEntry#withYear(Integer)}
   */
  @Test
  @DisplayName(
      "Test withYear(Integer); when forty-two; then return allocationPercentage intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableCostEntry ImmutableMeasurableCostEntry.withYear(Integer)"})
  void testWithYear_whenFortyTwo_thenReturnAllocationPercentageIntValueIsOne() {
    // Arrange
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

    // Act
    ImmutableMeasurableCostEntry actualWithYearResult =
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(1).build().withYear(42);

    // Assert
    assertEquals(1, actualWithYearResult.allocationPercentage().intValue());
    assertEquals(1L, actualWithYearResult.costKindId().longValue());
    assertEquals(1L, actualWithYearResult.appId());
    assertEquals(1L, actualWithYearResult.measurableId());
    assertEquals(1L, actualWithYearResult.measurableRatingId());
    assertEquals(42, actualWithYearResult.year().intValue());
    assertEquals(AllocationDerivation.DERIVED, actualWithYearResult.allocationDerivation());
    BigDecimal expectedAllocatedCostResult = new BigDecimal("2.3");
    assertEquals(expectedAllocatedCostResult, actualWithYearResult.allocatedCost());
    BigDecimal expectedOverallCostResult = new BigDecimal("2.3");
    assertEquals(expectedOverallCostResult, actualWithYearResult.overallCost());
  }
}
