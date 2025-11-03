package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableMeasurableCostEntry.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableMeasurableCostEntry.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableCostEntryDiffblueTest {
  /**
   * Test {@link ImmutableMeasurableCostEntry#builder()}.
   * <p>
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
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.allocatedCost(BigDecimal)", "Builder Builder.allocationPercentage(Integer)",
      "ImmutableMeasurableCostEntry Builder.build()", "Builder Builder.costKindId(Long)",
      "Builder Builder.overallCost(BigDecimal)", "Builder Builder.year(Integer)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableMeasurableCostEntry.builder();
    Builder actualCostKindIdResult = actualBuilderResult.allocatedCost(new BigDecimal("2.3"))
        .allocationPercentage(1)
        .costKindId(1L);
    Builder actualOverallCostResult = actualCostKindIdResult.overallCost(new BigDecimal("2.3"));

    // Assert
    assertSame(actualOverallCostResult, actualOverallCostResult.year(1));
  }

  /**
   * Test Builder {@link Builder#allocationDerivation(AllocationDerivation)}.
   * <p>
   * Method under test: {@link Builder#allocationDerivation(AllocationDerivation)}
   */
  @Test
  @DisplayName("Test Builder allocationDerivation(AllocationDerivation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.allocationDerivation(AllocationDerivation)"})
  void testBuilderAllocationDerivation() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCostEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.allocationDerivation(AllocationDerivation.DERIVED));
  }

  /**
   * Test Builder {@link Builder#appId(long)}.
   * <p>
   * Method under test: {@link Builder#appId(long)}
   */
  @Test
  @DisplayName("Test Builder appId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.appId(long)"})
  void testBuilderAppId() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCostEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.appId(1L));
  }

  /**
   * Test Builder {@link Builder#from(MeasurableCostEntry)}.
   * <ul>
   *   <li>Given {@code DERIVED}.</li>
   *   <li>Then return build allocationPercentage intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableCostEntry)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableCostEntry); given 'DERIVED'; then return build allocationPercentage intValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableCostEntry)"})
  void testBuilderFrom_givenDerived_thenReturnBuildAllocationPercentageIntValueIsOne() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCostEntry.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
    ImmutableMeasurableCostEntry buildResult = actualFromResult.build();
    assertEquals(1, buildResult.allocationPercentage().intValue());
    ImmutableMeasurableCostEntry buildResult2 = builderResult.build();
    assertEquals(1, buildResult2.allocationPercentage().intValue());
    assertEquals(1, buildResult.year().intValue());
    assertEquals(1, buildResult2.year().intValue());
    assertEquals(1L, buildResult.costKindId().longValue());
    assertEquals(1L, buildResult2.costKindId().longValue());
    BigDecimal expectedAllocatedCostResult = new BigDecimal("2.3");
    assertEquals(expectedAllocatedCostResult, buildResult.allocatedCost());
    BigDecimal expectedOverallCostResult = new BigDecimal("2.3");
    assertEquals(expectedOverallCostResult, buildResult.overallCost());
    assertSame(bigDecimal, buildResult2.allocatedCost());
    assertSame(bigDecimal2, buildResult2.overallCost());
  }

  /**
   * Test Builder {@link Builder#from(MeasurableCostEntry)}.
   * <ul>
   *   <li>Then return build allocatedCost is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableCostEntry)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableCostEntry); then return build allocatedCost is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableCostEntry)"})
  void testBuilderFrom_thenReturnBuildAllocatedCostIsNull() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCostEntry.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
    ImmutableMeasurableCostEntry buildResult = actualFromResult.build();
    assertNull(buildResult.allocatedCost());
    ImmutableMeasurableCostEntry buildResult2 = builderResult.build();
    assertNull(buildResult2.allocatedCost());
    assertEquals(1, buildResult.allocationPercentage().intValue());
    assertEquals(1, buildResult2.allocationPercentage().intValue());
    assertEquals(1, buildResult.year().intValue());
    assertEquals(1, buildResult2.year().intValue());
    assertEquals(1L, buildResult.costKindId().longValue());
    assertEquals(1L, buildResult2.costKindId().longValue());
    BigDecimal expectedOverallCostResult = new BigDecimal("2.3");
    assertEquals(expectedOverallCostResult, buildResult.overallCost());
    assertSame(bigDecimal, buildResult2.overallCost());
  }

  /**
   * Test Builder {@link Builder#from(MeasurableCostEntry)}.
   * <ul>
   *   <li>Then return build allocationPercentage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableCostEntry)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableCostEntry); then return build allocationPercentage is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableCostEntry)"})
  void testBuilderFrom_thenReturnBuildAllocationPercentageIsNull() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCostEntry.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
    ImmutableMeasurableCostEntry buildResult = actualFromResult.build();
    assertNull(buildResult.allocationPercentage());
    ImmutableMeasurableCostEntry buildResult2 = builderResult.build();
    assertNull(buildResult2.allocationPercentage());
    assertEquals(1, buildResult.year().intValue());
    assertEquals(1, buildResult2.year().intValue());
    assertEquals(1L, buildResult.costKindId().longValue());
    assertEquals(1L, buildResult2.costKindId().longValue());
    BigDecimal expectedAllocatedCostResult = new BigDecimal("2.3");
    assertEquals(expectedAllocatedCostResult, buildResult.allocatedCost());
    BigDecimal expectedOverallCostResult = new BigDecimal("2.3");
    assertEquals(expectedOverallCostResult, buildResult.overallCost());
    assertSame(bigDecimal, buildResult2.allocatedCost());
    assertSame(bigDecimal2, buildResult2.overallCost());
  }

  /**
   * Test Builder {@link Builder#from(MeasurableCostEntry)}.
   * <ul>
   *   <li>Then return build costKindId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableCostEntry)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableCostEntry); then return build costKindId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableCostEntry)"})
  void testBuilderFrom_thenReturnBuildCostKindIdIsNull() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCostEntry.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
    ImmutableMeasurableCostEntry buildResult = actualFromResult.build();
    assertNull(buildResult.costKindId());
    ImmutableMeasurableCostEntry buildResult2 = builderResult.build();
    assertNull(buildResult2.costKindId());
    assertEquals(1, buildResult.allocationPercentage().intValue());
    assertEquals(1, buildResult2.allocationPercentage().intValue());
    assertEquals(1, buildResult.year().intValue());
    assertEquals(1, buildResult2.year().intValue());
    BigDecimal expectedAllocatedCostResult = new BigDecimal("2.3");
    assertEquals(expectedAllocatedCostResult, buildResult.allocatedCost());
    BigDecimal expectedOverallCostResult = new BigDecimal("2.3");
    assertEquals(expectedOverallCostResult, buildResult.overallCost());
    assertSame(bigDecimal, buildResult2.allocatedCost());
    assertSame(bigDecimal2, buildResult2.overallCost());
  }

  /**
   * Test Builder {@link Builder#from(MeasurableCostEntry)}.
   * <ul>
   *   <li>Then return build overallCost is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableCostEntry)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableCostEntry); then return build overallCost is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableCostEntry)"})
  void testBuilderFrom_thenReturnBuildOverallCostIsNull() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCostEntry.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
    ImmutableMeasurableCostEntry buildResult = actualFromResult.build();
    assertNull(buildResult.overallCost());
    ImmutableMeasurableCostEntry buildResult2 = builderResult.build();
    assertNull(buildResult2.overallCost());
    assertEquals(1, buildResult.allocationPercentage().intValue());
    assertEquals(1, buildResult2.allocationPercentage().intValue());
    assertEquals(1, buildResult.year().intValue());
    assertEquals(1, buildResult2.year().intValue());
    assertEquals(1L, buildResult.costKindId().longValue());
    assertEquals(1L, buildResult2.costKindId().longValue());
    BigDecimal expectedAllocatedCostResult = new BigDecimal("2.3");
    assertEquals(expectedAllocatedCostResult, buildResult.allocatedCost());
    assertSame(bigDecimal, buildResult2.allocatedCost());
  }

  /**
   * Test Builder {@link Builder#from(MeasurableCostEntry)}.
   * <ul>
   *   <li>When {@link MeasurableCostEntry} {@link MeasurableCostEntry#year()} return {@code null}.</li>
   *   <li>Then return build year is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableCostEntry)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableCostEntry); when MeasurableCostEntry year() return 'null'; then return build year is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableCostEntry)"})
  void testBuilderFrom_whenMeasurableCostEntryYearReturnNull_thenReturnBuildYearIsNull() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCostEntry.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
    ImmutableMeasurableCostEntry buildResult = actualFromResult.build();
    assertNull(buildResult.year());
    ImmutableMeasurableCostEntry buildResult2 = builderResult.build();
    assertNull(buildResult2.year());
    assertEquals(1, buildResult.allocationPercentage().intValue());
    assertEquals(1, buildResult2.allocationPercentage().intValue());
    assertEquals(1L, buildResult.costKindId().longValue());
    assertEquals(1L, buildResult2.costKindId().longValue());
    BigDecimal expectedAllocatedCostResult = new BigDecimal("2.3");
    assertEquals(expectedAllocatedCostResult, buildResult.allocatedCost());
    BigDecimal expectedOverallCostResult = new BigDecimal("2.3");
    assertEquals(expectedOverallCostResult, buildResult.overallCost());
    assertSame(bigDecimal, buildResult2.allocatedCost());
    assertSame(bigDecimal2, buildResult2.overallCost());
  }

  /**
   * Test Builder {@link Builder#measurableId(long)}.
   * <p>
   * Method under test: {@link Builder#measurableId(long)}
   */
  @Test
  @DisplayName("Test Builder measurableId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.measurableId(long)"})
  void testBuilderMeasurableId() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCostEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurableId(1L));
  }

  /**
   * Test Builder {@link Builder#measurableRatingId(long)}.
   * <p>
   * Method under test: {@link Builder#measurableRatingId(long)}
   */
  @Test
  @DisplayName("Test Builder measurableRatingId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.measurableRatingId(long)"})
  void testBuilderMeasurableRatingId() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCostEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurableRatingId(1L));
  }

  /**
   * Test Json {@link Json#allocatedCost()}.
   * <p>
   * Method under test: {@link Json#allocatedCost()}
   */
  @Test
  @DisplayName("Test Json allocatedCost()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BigDecimal Json.allocatedCost()"})
  void testJsonAllocatedCost() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).allocatedCost());
  }

  /**
   * Test Json {@link Json#allocationDerivation()}.
   * <p>
   * Method under test: {@link Json#allocationDerivation()}
   */
  @Test
  @DisplayName("Test Json allocationDerivation()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AllocationDerivation Json.allocationDerivation()"})
  void testJsonAllocationDerivation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).allocationDerivation());
  }

  /**
   * Test Json {@link Json#allocationPercentage()}.
   * <p>
   * Method under test: {@link Json#allocationPercentage()}
   */
  @Test
  @DisplayName("Test Json allocationPercentage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer Json.allocationPercentage()"})
  void testJsonAllocationPercentage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).allocationPercentage());
  }

  /**
   * Test Json {@link Json#appId()}.
   * <p>
   * Method under test: {@link Json#appId()}
   */
  @Test
  @DisplayName("Test Json appId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.appId()"})
  void testJsonAppId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).appId());
  }

  /**
   * Test Json {@link Json#costKindId()}.
   * <p>
   * Method under test: {@link Json#costKindId()}
   */
  @Test
  @DisplayName("Test Json costKindId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.costKindId()"})
  void testJsonCostKindId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).costKindId());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setAllocatedCost(BigDecimal)",
      "void Json.setAllocationDerivation(AllocationDerivation)", "void Json.setAllocationPercentage(Integer)",
      "void Json.setCostKindId(Long)", "void Json.setOverallCost(BigDecimal)", "void Json.setYear(Integer)"})
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
   * <p>
   * Method under test: {@link Json#measurableId()}
   */
  @Test
  @DisplayName("Test Json measurableId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.measurableId()"})
  void testJsonMeasurableId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).measurableId());
  }

  /**
   * Test Json {@link Json#measurableRatingId()}.
   * <p>
   * Method under test: {@link Json#measurableRatingId()}
   */
  @Test
  @DisplayName("Test Json measurableRatingId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.measurableRatingId()"})
  void testJsonMeasurableRatingId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).measurableRatingId());
  }

  /**
   * Test Json {@link Json#overallCost()}.
   * <p>
   * Method under test: {@link Json#overallCost()}
   */
  @Test
  @DisplayName("Test Json overallCost()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BigDecimal Json.overallCost()"})
  void testJsonOverallCost() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).overallCost());
  }

  /**
   * Test Json {@link Json#setAppId(long)}.
   * <p>
   * Method under test: {@link Json#setAppId(long)}
   */
  @Test
  @DisplayName("Test Json setAppId(long)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#setMeasurableId(long)}
   */
  @Test
  @DisplayName("Test Json setMeasurableId(long)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#setMeasurableRatingId(long)}
   */
  @Test
  @DisplayName("Test Json setMeasurableRatingId(long)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#year()}
   */
  @Test
  @DisplayName("Test Json year()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer Json.year()"})
  void testJsonYear() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).year());
  }
}
