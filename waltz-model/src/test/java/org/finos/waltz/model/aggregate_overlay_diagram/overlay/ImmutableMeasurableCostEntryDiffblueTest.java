package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableCostEntryDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableMeasurableCostEntry#builder()}
   *   <li>{@link ImmutableMeasurableCostEntry#allocatedCost(BigDecimal)}
   *   <li>{@link ImmutableMeasurableCostEntry#allocationPercentage(Integer)}
   *   <li>{@link ImmutableMeasurableCostEntry#costKindId(Long)}
   *   <li>{@link ImmutableMeasurableCostEntry#overallCost(BigDecimal)}
   *   <li>{@link ImmutableMeasurableCostEntry#year(Integer)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableMeasurableCostEntry.Builder actualBuilderResult = ImmutableMeasurableCostEntry.builder();
    ImmutableMeasurableCostEntry.Builder actualCostKindIdResult = actualBuilderResult
        .allocatedCost(new BigDecimal("2.3"))
        .allocationPercentage(1)
        .costKindId(1L);
    ImmutableMeasurableCostEntry.Builder actualOverallCostResult = actualCostKindIdResult
        .overallCost(new BigDecimal("2.3"));

    // Assert
    assertSame(actualOverallCostResult, actualOverallCostResult.year(1));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCostEntry.Builder#allocationDerivation(AllocationDerivation)}
   */
  @Test
  void testBuilderAllocationDerivation() {
    // Arrange
    ImmutableMeasurableCostEntry.Builder builderResult = ImmutableMeasurableCostEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.allocationDerivation(AllocationDerivation.DERIVED));
  }

  /**
   * Method under test: {@link ImmutableMeasurableCostEntry.Builder#appId(long)}
   */
  @Test
  void testBuilderAppId() {
    // Arrange
    ImmutableMeasurableCostEntry.Builder builderResult = ImmutableMeasurableCostEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.appId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCostEntry.Builder#from(MeasurableCostEntry)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableMeasurableCostEntry.Builder builderResult = ImmutableMeasurableCostEntry.builder();
    MeasurableCostEntry instance = mock(MeasurableCostEntry.class);
    when(instance.allocationPercentage()).thenReturn(1);
    when(instance.year()).thenReturn(1);
    when(instance.costKindId()).thenReturn(1L);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.allocatedCost()).thenReturn(bigDecimal);
    BigDecimal bigDecimal2 = new BigDecimal("2.3");
    when(instance.overallCost()).thenReturn(bigDecimal2);
    when(instance.appId()).thenReturn(1L);
    when(instance.measurableId()).thenReturn(1L);
    when(instance.measurableRatingId()).thenReturn(1L);
    when(instance.allocationDerivation()).thenReturn(AllocationDerivation.DERIVED);

    // Act
    ImmutableMeasurableCostEntry.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocatedCost();
    verify(instance).allocationDerivation();
    verify(instance).allocationPercentage();
    verify(instance).appId();
    verify(instance).costKindId();
    verify(instance).measurableId();
    verify(instance).measurableRatingId();
    verify(instance).overallCost();
    verify(instance).year();
    ImmutableMeasurableCostEntry buildResult = builderResult.build();
    assertEquals(1, buildResult.allocationPercentage().intValue());
    assertEquals(1, buildResult.year().intValue());
    assertEquals(1L, buildResult.costKindId().longValue());
    assertEquals(1L, buildResult.appId());
    assertEquals(1L, buildResult.measurableId());
    assertEquals(1L, buildResult.measurableRatingId());
    assertEquals(AllocationDerivation.DERIVED, buildResult.allocationDerivation());
    assertSame(bigDecimal, buildResult.allocatedCost());
    assertSame(bigDecimal2, buildResult.overallCost());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCostEntry.Builder#from(MeasurableCostEntry)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableMeasurableCostEntry.Builder builderResult = ImmutableMeasurableCostEntry.builder();
    MeasurableCostEntry instance = mock(MeasurableCostEntry.class);
    when(instance.allocationPercentage()).thenReturn(null);
    when(instance.year()).thenReturn(1);
    when(instance.costKindId()).thenReturn(1L);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.allocatedCost()).thenReturn(bigDecimal);
    BigDecimal bigDecimal2 = new BigDecimal("2.3");
    when(instance.overallCost()).thenReturn(bigDecimal2);
    when(instance.appId()).thenReturn(1L);
    when(instance.measurableId()).thenReturn(1L);
    when(instance.measurableRatingId()).thenReturn(1L);
    when(instance.allocationDerivation()).thenReturn(AllocationDerivation.DERIVED);

    // Act
    ImmutableMeasurableCostEntry.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocatedCost();
    verify(instance).allocationDerivation();
    verify(instance).allocationPercentage();
    verify(instance).appId();
    verify(instance).costKindId();
    verify(instance).measurableId();
    verify(instance).measurableRatingId();
    verify(instance).overallCost();
    verify(instance).year();
    ImmutableMeasurableCostEntry buildResult = builderResult.build();
    assertNull(buildResult.allocationPercentage());
    assertEquals(1, buildResult.year().intValue());
    assertEquals(1L, buildResult.costKindId().longValue());
    assertEquals(1L, buildResult.appId());
    assertEquals(1L, buildResult.measurableId());
    assertEquals(1L, buildResult.measurableRatingId());
    assertEquals(AllocationDerivation.DERIVED, buildResult.allocationDerivation());
    assertSame(bigDecimal, buildResult.allocatedCost());
    assertSame(bigDecimal2, buildResult.overallCost());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCostEntry.Builder#from(MeasurableCostEntry)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableMeasurableCostEntry.Builder builderResult = ImmutableMeasurableCostEntry.builder();
    MeasurableCostEntry instance = mock(MeasurableCostEntry.class);
    when(instance.allocationPercentage()).thenReturn(1);
    when(instance.year()).thenReturn(null);
    when(instance.costKindId()).thenReturn(1L);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.allocatedCost()).thenReturn(bigDecimal);
    BigDecimal bigDecimal2 = new BigDecimal("2.3");
    when(instance.overallCost()).thenReturn(bigDecimal2);
    when(instance.appId()).thenReturn(1L);
    when(instance.measurableId()).thenReturn(1L);
    when(instance.measurableRatingId()).thenReturn(1L);
    when(instance.allocationDerivation()).thenReturn(AllocationDerivation.DERIVED);

    // Act
    ImmutableMeasurableCostEntry.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocatedCost();
    verify(instance).allocationDerivation();
    verify(instance).allocationPercentage();
    verify(instance).appId();
    verify(instance).costKindId();
    verify(instance).measurableId();
    verify(instance).measurableRatingId();
    verify(instance).overallCost();
    verify(instance).year();
    ImmutableMeasurableCostEntry buildResult = builderResult.build();
    assertNull(buildResult.year());
    assertEquals(1, buildResult.allocationPercentage().intValue());
    assertEquals(1L, buildResult.costKindId().longValue());
    assertEquals(1L, buildResult.appId());
    assertEquals(1L, buildResult.measurableId());
    assertEquals(1L, buildResult.measurableRatingId());
    assertEquals(AllocationDerivation.DERIVED, buildResult.allocationDerivation());
    assertSame(bigDecimal, buildResult.allocatedCost());
    assertSame(bigDecimal2, buildResult.overallCost());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCostEntry.Builder#from(MeasurableCostEntry)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableMeasurableCostEntry.Builder builderResult = ImmutableMeasurableCostEntry.builder();
    MeasurableCostEntry instance = mock(MeasurableCostEntry.class);
    when(instance.allocationPercentage()).thenReturn(1);
    when(instance.year()).thenReturn(1);
    when(instance.costKindId()).thenReturn(null);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.allocatedCost()).thenReturn(bigDecimal);
    BigDecimal bigDecimal2 = new BigDecimal("2.3");
    when(instance.overallCost()).thenReturn(bigDecimal2);
    when(instance.appId()).thenReturn(1L);
    when(instance.measurableId()).thenReturn(1L);
    when(instance.measurableRatingId()).thenReturn(1L);
    when(instance.allocationDerivation()).thenReturn(AllocationDerivation.DERIVED);

    // Act
    ImmutableMeasurableCostEntry.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocatedCost();
    verify(instance).allocationDerivation();
    verify(instance).allocationPercentage();
    verify(instance).appId();
    verify(instance).costKindId();
    verify(instance).measurableId();
    verify(instance).measurableRatingId();
    verify(instance).overallCost();
    verify(instance).year();
    ImmutableMeasurableCostEntry buildResult = builderResult.build();
    assertNull(buildResult.costKindId());
    assertEquals(1, buildResult.allocationPercentage().intValue());
    assertEquals(1, buildResult.year().intValue());
    assertEquals(1L, buildResult.appId());
    assertEquals(1L, buildResult.measurableId());
    assertEquals(1L, buildResult.measurableRatingId());
    assertEquals(AllocationDerivation.DERIVED, buildResult.allocationDerivation());
    assertSame(bigDecimal, buildResult.allocatedCost());
    assertSame(bigDecimal2, buildResult.overallCost());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCostEntry.Builder#from(MeasurableCostEntry)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableMeasurableCostEntry.Builder builderResult = ImmutableMeasurableCostEntry.builder();
    MeasurableCostEntry instance = mock(MeasurableCostEntry.class);
    when(instance.allocationPercentage()).thenReturn(1);
    when(instance.year()).thenReturn(1);
    when(instance.costKindId()).thenReturn(1L);
    when(instance.allocatedCost()).thenReturn(null);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.overallCost()).thenReturn(bigDecimal);
    when(instance.appId()).thenReturn(1L);
    when(instance.measurableId()).thenReturn(1L);
    when(instance.measurableRatingId()).thenReturn(1L);
    when(instance.allocationDerivation()).thenReturn(AllocationDerivation.DERIVED);

    // Act
    ImmutableMeasurableCostEntry.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocatedCost();
    verify(instance).allocationDerivation();
    verify(instance).allocationPercentage();
    verify(instance).appId();
    verify(instance).costKindId();
    verify(instance).measurableId();
    verify(instance).measurableRatingId();
    verify(instance).overallCost();
    verify(instance).year();
    ImmutableMeasurableCostEntry buildResult = builderResult.build();
    assertNull(buildResult.allocatedCost());
    assertEquals(1, buildResult.allocationPercentage().intValue());
    assertEquals(1, buildResult.year().intValue());
    assertEquals(1L, buildResult.costKindId().longValue());
    assertEquals(1L, buildResult.appId());
    assertEquals(1L, buildResult.measurableId());
    assertEquals(1L, buildResult.measurableRatingId());
    assertEquals(AllocationDerivation.DERIVED, buildResult.allocationDerivation());
    assertSame(bigDecimal, buildResult.overallCost());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCostEntry.Builder#from(MeasurableCostEntry)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableMeasurableCostEntry.Builder builderResult = ImmutableMeasurableCostEntry.builder();
    MeasurableCostEntry instance = mock(MeasurableCostEntry.class);
    when(instance.allocationPercentage()).thenReturn(1);
    when(instance.year()).thenReturn(1);
    when(instance.costKindId()).thenReturn(1L);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.allocatedCost()).thenReturn(bigDecimal);
    when(instance.overallCost()).thenReturn(null);
    when(instance.appId()).thenReturn(1L);
    when(instance.measurableId()).thenReturn(1L);
    when(instance.measurableRatingId()).thenReturn(1L);
    when(instance.allocationDerivation()).thenReturn(AllocationDerivation.DERIVED);

    // Act
    ImmutableMeasurableCostEntry.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocatedCost();
    verify(instance).allocationDerivation();
    verify(instance).allocationPercentage();
    verify(instance).appId();
    verify(instance).costKindId();
    verify(instance).measurableId();
    verify(instance).measurableRatingId();
    verify(instance).overallCost();
    verify(instance).year();
    ImmutableMeasurableCostEntry buildResult = builderResult.build();
    assertNull(buildResult.overallCost());
    assertEquals(1, buildResult.allocationPercentage().intValue());
    assertEquals(1, buildResult.year().intValue());
    assertEquals(1L, buildResult.costKindId().longValue());
    assertEquals(1L, buildResult.appId());
    assertEquals(1L, buildResult.measurableId());
    assertEquals(1L, buildResult.measurableRatingId());
    assertEquals(AllocationDerivation.DERIVED, buildResult.allocationDerivation());
    assertSame(bigDecimal, buildResult.allocatedCost());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCostEntry.Builder#measurableId(long)}
   */
  @Test
  void testBuilderMeasurableId() {
    // Arrange
    ImmutableMeasurableCostEntry.Builder builderResult = ImmutableMeasurableCostEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurableId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCostEntry.Builder#measurableRatingId(long)}
   */
  @Test
  void testBuilderMeasurableRatingId() {
    // Arrange
    ImmutableMeasurableCostEntry.Builder builderResult = ImmutableMeasurableCostEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurableRatingId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCostEntry#copyOf(MeasurableCostEntry)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    MeasurableCostEntry instance = mock(MeasurableCostEntry.class);
    when(instance.allocationPercentage()).thenReturn(1);
    when(instance.year()).thenReturn(1);
    when(instance.costKindId()).thenReturn(1L);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.allocatedCost()).thenReturn(bigDecimal);
    BigDecimal bigDecimal2 = new BigDecimal("2.3");
    when(instance.overallCost()).thenReturn(bigDecimal2);
    when(instance.appId()).thenReturn(1L);
    when(instance.measurableId()).thenReturn(1L);
    when(instance.measurableRatingId()).thenReturn(1L);
    when(instance.allocationDerivation()).thenReturn(AllocationDerivation.DERIVED);

    // Act
    ImmutableMeasurableCostEntry actualCopyOfResult = ImmutableMeasurableCostEntry.copyOf(instance);

    // Assert
    verify(instance).allocatedCost();
    verify(instance).allocationDerivation();
    verify(instance).allocationPercentage();
    verify(instance).appId();
    verify(instance).costKindId();
    verify(instance).measurableId();
    verify(instance).measurableRatingId();
    verify(instance).overallCost();
    verify(instance).year();
    assertEquals(1, actualCopyOfResult.allocationPercentage().intValue());
    assertEquals(1, actualCopyOfResult.year().intValue());
    assertEquals(1L, actualCopyOfResult.costKindId().longValue());
    assertEquals(1L, actualCopyOfResult.appId());
    assertEquals(1L, actualCopyOfResult.measurableId());
    assertEquals(1L, actualCopyOfResult.measurableRatingId());
    assertEquals(AllocationDerivation.DERIVED, actualCopyOfResult.allocationDerivation());
    BigDecimal expectedAllocatedCostResult = new BigDecimal("2.3");
    BigDecimal allocatedCostResult = actualCopyOfResult.allocatedCost();
    assertEquals(expectedAllocatedCostResult, allocatedCostResult);
    BigDecimal expectedOverallCostResult = new BigDecimal("2.3");
    BigDecimal overallCostResult = actualCopyOfResult.overallCost();
    assertEquals(expectedOverallCostResult, overallCostResult);
    assertSame(bigDecimal, allocatedCostResult);
    assertSame(bigDecimal2, overallCostResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCostEntry#copyOf(MeasurableCostEntry)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    MeasurableCostEntry instance = mock(MeasurableCostEntry.class);
    when(instance.allocationPercentage()).thenReturn(1);
    when(instance.year()).thenReturn(1);
    when(instance.costKindId()).thenReturn(1L);
    when(instance.allocatedCost()).thenReturn(null);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.overallCost()).thenReturn(bigDecimal);
    when(instance.appId()).thenReturn(1L);
    when(instance.measurableId()).thenReturn(1L);
    when(instance.measurableRatingId()).thenReturn(1L);
    when(instance.allocationDerivation()).thenReturn(AllocationDerivation.DERIVED);

    // Act
    ImmutableMeasurableCostEntry actualCopyOfResult = ImmutableMeasurableCostEntry.copyOf(instance);

    // Assert
    verify(instance).allocatedCost();
    verify(instance).allocationDerivation();
    verify(instance).allocationPercentage();
    verify(instance).appId();
    verify(instance).costKindId();
    verify(instance).measurableId();
    verify(instance).measurableRatingId();
    verify(instance).overallCost();
    verify(instance).year();
    assertNull(actualCopyOfResult.allocatedCost());
    assertEquals(1, actualCopyOfResult.allocationPercentage().intValue());
    assertEquals(1, actualCopyOfResult.year().intValue());
    assertEquals(1L, actualCopyOfResult.costKindId().longValue());
    assertEquals(1L, actualCopyOfResult.appId());
    assertEquals(1L, actualCopyOfResult.measurableId());
    assertEquals(1L, actualCopyOfResult.measurableRatingId());
    assertEquals(AllocationDerivation.DERIVED, actualCopyOfResult.allocationDerivation());
    BigDecimal expectedOverallCostResult = new BigDecimal("2.3");
    BigDecimal overallCostResult = actualCopyOfResult.overallCost();
    assertEquals(expectedOverallCostResult, overallCostResult);
    assertSame(bigDecimal, overallCostResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCostEntry#copyOf(MeasurableCostEntry)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    MeasurableCostEntry instance = mock(MeasurableCostEntry.class);
    when(instance.allocationPercentage()).thenReturn(1);
    when(instance.year()).thenReturn(1);
    when(instance.costKindId()).thenReturn(1L);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.allocatedCost()).thenReturn(bigDecimal);
    when(instance.overallCost()).thenReturn(null);
    when(instance.appId()).thenReturn(1L);
    when(instance.measurableId()).thenReturn(1L);
    when(instance.measurableRatingId()).thenReturn(1L);
    when(instance.allocationDerivation()).thenReturn(AllocationDerivation.DERIVED);

    // Act
    ImmutableMeasurableCostEntry actualCopyOfResult = ImmutableMeasurableCostEntry.copyOf(instance);

    // Assert
    verify(instance).allocatedCost();
    verify(instance).allocationDerivation();
    verify(instance).allocationPercentage();
    verify(instance).appId();
    verify(instance).costKindId();
    verify(instance).measurableId();
    verify(instance).measurableRatingId();
    verify(instance).overallCost();
    verify(instance).year();
    assertNull(actualCopyOfResult.overallCost());
    assertEquals(1, actualCopyOfResult.allocationPercentage().intValue());
    assertEquals(1, actualCopyOfResult.year().intValue());
    assertEquals(1L, actualCopyOfResult.costKindId().longValue());
    assertEquals(1L, actualCopyOfResult.appId());
    assertEquals(1L, actualCopyOfResult.measurableId());
    assertEquals(1L, actualCopyOfResult.measurableRatingId());
    assertEquals(AllocationDerivation.DERIVED, actualCopyOfResult.allocationDerivation());
    BigDecimal expectedAllocatedCostResult = new BigDecimal("2.3");
    BigDecimal allocatedCostResult = actualCopyOfResult.allocatedCost();
    assertEquals(expectedAllocatedCostResult, allocatedCostResult);
    assertSame(bigDecimal, allocatedCostResult);
  }

  /**
   * Method under test: {@link ImmutableMeasurableCostEntry.Json#allocatedCost()}
   */
  @Test
  void testJsonAllocatedCost() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableCostEntry.Json()).allocatedCost());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCostEntry.Json#allocationDerivation()}
   */
  @Test
  void testJsonAllocationDerivation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableCostEntry.Json()).allocationDerivation());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCostEntry.Json#allocationPercentage()}
   */
  @Test
  void testJsonAllocationPercentage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableCostEntry.Json()).allocationPercentage());
  }

  /**
   * Method under test: {@link ImmutableMeasurableCostEntry.Json#appId()}
   */
  @Test
  void testJsonAppId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableCostEntry.Json()).appId());
  }

  /**
   * Method under test: {@link ImmutableMeasurableCostEntry.Json#costKindId()}
   */
  @Test
  void testJsonCostKindId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableCostEntry.Json()).costKindId());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableMeasurableCostEntry.Json}
   *   <li>{@link ImmutableMeasurableCostEntry.Json#setAllocatedCost(BigDecimal)}
   *   <li>
   * {@link ImmutableMeasurableCostEntry.Json#setAllocationDerivation(AllocationDerivation)}
   *   <li>
   * {@link ImmutableMeasurableCostEntry.Json#setAllocationPercentage(Integer)}
   *   <li>{@link ImmutableMeasurableCostEntry.Json#setCostKindId(Long)}
   *   <li>{@link ImmutableMeasurableCostEntry.Json#setOverallCost(BigDecimal)}
   *   <li>{@link ImmutableMeasurableCostEntry.Json#setYear(Integer)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableMeasurableCostEntry.Json actualJson = new ImmutableMeasurableCostEntry.Json();
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
   * Method under test: {@link ImmutableMeasurableCostEntry.Json#measurableId()}
   */
  @Test
  void testJsonMeasurableId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableCostEntry.Json()).measurableId());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCostEntry.Json#measurableRatingId()}
   */
  @Test
  void testJsonMeasurableRatingId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableCostEntry.Json()).measurableRatingId());
  }

  /**
   * Method under test: {@link ImmutableMeasurableCostEntry.Json#overallCost()}
   */
  @Test
  void testJsonOverallCost() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableCostEntry.Json()).overallCost());
  }

  /**
   * Method under test: {@link ImmutableMeasurableCostEntry.Json#setAppId(long)}
   */
  @Test
  void testJsonSetAppId() {
    // Arrange
    ImmutableMeasurableCostEntry.Json json = new ImmutableMeasurableCostEntry.Json();

    // Act
    json.setAppId(1L);

    // Assert
    assertEquals(1L, json.appId);
    assertTrue(json.appIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCostEntry.Json#setMeasurableId(long)}
   */
  @Test
  void testJsonSetMeasurableId() {
    // Arrange
    ImmutableMeasurableCostEntry.Json json = new ImmutableMeasurableCostEntry.Json();

    // Act
    json.setMeasurableId(1L);

    // Assert
    assertEquals(1L, json.measurableId);
    assertTrue(json.measurableIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCostEntry.Json#setMeasurableRatingId(long)}
   */
  @Test
  void testJsonSetMeasurableRatingId() {
    // Arrange
    ImmutableMeasurableCostEntry.Json json = new ImmutableMeasurableCostEntry.Json();

    // Act
    json.setMeasurableRatingId(1L);

    // Assert
    assertEquals(1L, json.measurableRatingId);
    assertTrue(json.measurableRatingIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableMeasurableCostEntry.Json#year()}
   */
  @Test
  void testJsonYear() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableCostEntry.Json()).year());
  }
}
