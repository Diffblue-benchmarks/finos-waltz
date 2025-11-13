package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableCostWidgetDatum.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableCostWidgetDatum.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCostWidgetDatumDiffblueTest {
  /**
   * Test {@link ImmutableCostWidgetDatum#appCount()}.
   *
   * <p>Method under test: {@link ImmutableCostWidgetDatum#appCount()}
   */
  @Test
  @DisplayName("Test appCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long ImmutableCostWidgetDatum.appCount()"})
  void testAppCount() {
    // Arrange, Act and Assert
    assertEquals(0L, ImmutableCostWidgetDatum.builder().cellExternalId("42").build().appCount());
  }

  /**
   * Test Builder {@link Builder#addAllMeasurableCosts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllMeasurableCosts(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllMeasurableCosts(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllMeasurableCosts(Iterable)"})
  void testBuilderAddAllMeasurableCosts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetDatum.builder();

    // Act
    Builder actualAddAllMeasurableCostsResult =
        builderResult.addAllMeasurableCosts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllMeasurableCostsResult);
  }

  /**
   * Test Builder {@link Builder#addMeasurableCosts(MeasurableCostEntry)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableMeasurableCostEntry.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addMeasurableCosts(MeasurableCostEntry)}
   */
  @Test
  @DisplayName(
      "Test Builder addMeasurableCosts(MeasurableCostEntry) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addMeasurableCosts(MeasurableCostEntry)"})
  void testBuilderAddMeasurableCostsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetDatum.builder();

    // Act
    Builder actualAddMeasurableCostsResult =
        builderResult.addMeasurableCosts(new ImmutableMeasurableCostEntry.Json());

    // Assert
    assertSame(builderResult, actualAddMeasurableCostsResult);
  }

  /**
   * Test Builder {@link Builder#addMeasurableCosts(MeasurableCostEntry[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableMeasurableCostEntry.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addMeasurableCosts(MeasurableCostEntry[])}
   */
  @Test
  @DisplayName(
      "Test Builder addMeasurableCosts(MeasurableCostEntry[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addMeasurableCosts(MeasurableCostEntry[])"})
  void testBuilderAddMeasurableCostsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetDatum.builder();

    // Act
    Builder actualAddMeasurableCostsResult =
        builderResult.addMeasurableCosts(new ImmutableMeasurableCostEntry.Json());

    // Assert
    assertSame(builderResult, actualAddMeasurableCostsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCostWidgetDatum Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableCostWidgetDatum actualImmutableCostWidgetDatum =
        ImmutableCostWidgetDatum.builder().cellExternalId("42").build();

    // Assert
    assertEquals("42", actualImmutableCostWidgetDatum.cellExternalId());
    assertEquals(0L, actualImmutableCostWidgetDatum.appCount());
    assertTrue(actualImmutableCostWidgetDatum.measurableCosts().isEmpty());
    BigDecimal expectedTotalCostResult = new BigDecimal("0");
    assertEquals(expectedTotalCostResult, actualImmutableCostWidgetDatum.totalCost());
  }

  /**
   * Test Builder {@link Builder#cellExternalId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then builder build cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#cellExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test Builder cellExternalId(String); when '42'; then builder build cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.cellExternalId(String)"})
  void testBuilderCellExternalId_when42_thenBuilderBuildCellExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetDatum.builder();

    // Act
    Builder actualCellExternalIdResult = builderResult.cellExternalId("42");

    // Assert
    ImmutableCostWidgetDatum immutableCostWidgetDatum = builderResult.build();
    assertEquals("42", immutableCostWidgetDatum.cellExternalId());
    assertEquals(0L, immutableCostWidgetDatum.appCount());
    assertSame(builderResult, actualCellExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#from(CellExternalIdProvider)} with {@code CellExternalIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(CellExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CellExternalIdProvider) with 'CellExternalIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CellExternalIdProvider)"})
  void testBuilderFromWithCellExternalIdProvider() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetDatum.builder();
    ImmutableCostWidgetDatum instance =
        ImmutableCostWidgetDatum.builder().cellExternalId("42").build();

    // Act
    Builder actualFromResult = builderResult.from((CellExternalIdProvider) instance);

    // Assert
    ImmutableCostWidgetDatum actualImmutableCostWidgetDatum = builderResult.build();
    assertEquals(instance, actualImmutableCostWidgetDatum);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CellExternalIdProvider)} with {@code CellExternalIdProvider}.
   *
   * <ul>
   *   <li>Then builder build cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CellExternalIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CellExternalIdProvider) with 'CellExternalIdProvider'; then builder build cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CellExternalIdProvider)"})
  void testBuilderFromWithCellExternalIdProvider_thenBuilderBuildCellExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetDatum.builder();

    CellExternalIdProvider instance = mock(CellExternalIdProvider.class);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellExternalId();
    ImmutableCostWidgetDatum immutableCostWidgetDatum = builderResult.build();
    assertEquals("42", immutableCostWidgetDatum.cellExternalId());
    assertEquals(0L, immutableCostWidgetDatum.appCount());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CostWidgetDatum)} with {@code CostWidgetDatum}.
   *
   * <p>Method under test: {@link Builder#from(CostWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder from(CostWidgetDatum) with 'CostWidgetDatum'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CostWidgetDatum)"})
  void testBuilderFromWithCostWidgetDatum() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetDatum.builder();

    Builder builderResult2 = ImmutableCostWidgetDatum.builder();

    ImmutableMeasurableCostEntry.Builder builderResult3 = ImmutableMeasurableCostEntry.builder();

    ImmutableMeasurableCostEntry.Builder measurableRatingIdResult =
        builderResult3
            .allocatedCost(new BigDecimal("2.3"))
            .allocationDerivation(AllocationDerivation.DERIVED)
            .allocationPercentage(1)
            .appId(1L)
            .costKindId(1L)
            .measurableId(1L)
            .measurableRatingId(1L);
    builderResult2.addMeasurableCosts(
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(1).build());
    ImmutableCostWidgetDatum instance = builderResult2.cellExternalId("42").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableCostWidgetDatum actualImmutableCostWidgetDatum = builderResult.build();
    assertEquals(instance, actualImmutableCostWidgetDatum);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CostWidgetDatum)} with {@code CostWidgetDatum}.
   *
   * <ul>
   *   <li>Then return build is builder cellExternalId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CostWidgetDatum)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CostWidgetDatum) with 'CostWidgetDatum'; then return build is builder cellExternalId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CostWidgetDatum)"})
  void testBuilderFromWithCostWidgetDatum_thenReturnBuildIsBuilderCellExternalId42Build() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetDatum.builder();
    ImmutableCostWidgetDatum instance =
        ImmutableCostWidgetDatum.builder().cellExternalId("42").build();

    // Act and Assert
    ImmutableCostWidgetDatum actualImmutableCostWidgetDatum = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableCostWidgetDatum);
  }

  /**
   * Test Builder {@link Builder#measurableCosts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#measurableCosts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder measurableCosts(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.measurableCosts(Iterable)"})
  void testBuilderMeasurableCosts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetDatum.builder();

    // Act
    Builder actualMeasurableCostsResult = builderResult.measurableCosts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualMeasurableCostsResult);
  }

  /**
   * Test {@link ImmutableCostWidgetDatum#copyOf(CostWidgetDatum)}.
   *
   * <ul>
   *   <li>When builder cellExternalId {@code 42} build.
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCostWidgetDatum#copyOf(CostWidgetDatum)}
   */
  @Test
  @DisplayName(
      "Test copyOf(CostWidgetDatum); when builder cellExternalId '42' build; then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCostWidgetDatum ImmutableCostWidgetDatum.copyOf(CostWidgetDatum)"})
  void testCopyOf_whenBuilderCellExternalId42Build_thenReturnCellExternalIdIs42() {
    // Arrange
    ImmutableCostWidgetDatum instance =
        ImmutableCostWidgetDatum.builder().cellExternalId("42").build();

    // Act
    ImmutableCostWidgetDatum actualCopyOfResult = ImmutableCostWidgetDatum.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.cellExternalId());
    assertEquals(0L, actualCopyOfResult.appCount());
    assertTrue(actualCopyOfResult.measurableCosts().isEmpty());
    BigDecimal expectedTotalCostResult = new BigDecimal("0");
    assertEquals(expectedTotalCostResult, actualCopyOfResult.totalCost());
  }

  /**
   * Test {@link ImmutableCostWidgetDatum#equals(Object)}, and {@link
   * ImmutableCostWidgetDatum#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCostWidgetDatum#equals(Object)}
   *   <li>{@link ImmutableCostWidgetDatum#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCostWidgetDatum.equals(Object)",
    "int ImmutableCostWidgetDatum.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableCostWidgetDatum immutableCostWidgetDatum =
        ImmutableCostWidgetDatum.builder().cellExternalId("42").build();
    ImmutableCostWidgetDatum immutableCostWidgetDatum2 =
        ImmutableCostWidgetDatum.builder().cellExternalId("42").build();

    // Act and Assert
    assertEquals(immutableCostWidgetDatum, immutableCostWidgetDatum2);
    assertEquals(immutableCostWidgetDatum.hashCode(), immutableCostWidgetDatum2.hashCode());
  }

  /**
   * Test {@link ImmutableCostWidgetDatum#equals(Object)}, and {@link
   * ImmutableCostWidgetDatum#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCostWidgetDatum#equals(Object)}
   *   <li>{@link ImmutableCostWidgetDatum#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCostWidgetDatum.equals(Object)",
    "int ImmutableCostWidgetDatum.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableCostWidgetDatum immutableCostWidgetDatum =
        ImmutableCostWidgetDatum.builder().cellExternalId("42").build();

    // Act and Assert
    assertEquals(immutableCostWidgetDatum, immutableCostWidgetDatum);
    int expectedHashCodeResult = immutableCostWidgetDatum.hashCode();
    assertEquals(expectedHashCodeResult, immutableCostWidgetDatum.hashCode());
  }

  /**
   * Test {@link ImmutableCostWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCostWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCostWidgetDatum.equals(Object)",
    "int ImmutableCostWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetDatum.builder();

    ImmutableMeasurableCostEntry.Builder builderResult2 = ImmutableMeasurableCostEntry.builder();

    ImmutableMeasurableCostEntry.Builder measurableRatingIdResult =
        builderResult2
            .allocatedCost(new BigDecimal("2.3"))
            .allocationDerivation(AllocationDerivation.DERIVED)
            .allocationPercentage(1)
            .appId(1L)
            .costKindId(1L)
            .measurableId(1L)
            .measurableRatingId(1L);
    builderResult.addMeasurableCosts(
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(1).build());
    ImmutableCostWidgetDatum immutableCostWidgetDatum = builderResult.cellExternalId("42").build();

    // Act and Assert
    assertNotEquals(
        immutableCostWidgetDatum, ImmutableCostWidgetDatum.builder().cellExternalId("42").build());
  }

  /**
   * Test {@link ImmutableCostWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCostWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCostWidgetDatum.equals(Object)",
    "int ImmutableCostWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableCostWidgetDatum immutableCostWidgetDatum =
        ImmutableCostWidgetDatum.builder().cellExternalId("Cell External Id").build();

    // Act and Assert
    assertNotEquals(
        immutableCostWidgetDatum, ImmutableCostWidgetDatum.builder().cellExternalId("42").build());
  }

  /**
   * Test {@link ImmutableCostWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCostWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCostWidgetDatum.equals(Object)",
    "int ImmutableCostWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetDatum.builder();

    ImmutableMeasurableCostEntry.Builder builderResult2 = ImmutableMeasurableCostEntry.builder();

    ImmutableMeasurableCostEntry.Builder measurableRatingIdResult =
        builderResult2
            .allocatedCost(new BigDecimal("2.3"))
            .allocationDerivation(AllocationDerivation.DERIVED)
            .allocationPercentage(1)
            .appId(1L)
            .costKindId(1L)
            .measurableId(1L)
            .measurableRatingId(1L);
    builderResult.addMeasurableCosts(
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(1).build());
    ImmutableCostWidgetDatum immutableCostWidgetDatum = builderResult.cellExternalId("42").build();

    Builder builderResult3 = ImmutableCostWidgetDatum.builder();

    ImmutableMeasurableCostEntry.Builder builderResult4 = ImmutableMeasurableCostEntry.builder();

    ImmutableMeasurableCostEntry.Builder measurableRatingIdResult2 =
        builderResult4
            .allocatedCost(new BigDecimal("2.3"))
            .allocationDerivation(AllocationDerivation.EXPLICIT)
            .allocationPercentage(1)
            .appId(1L)
            .costKindId(1L)
            .measurableId(1L)
            .measurableRatingId(1L);
    builderResult3.addMeasurableCosts(
        measurableRatingIdResult2.overallCost(new BigDecimal("2.3")).year(1).build());

    // Act and Assert
    assertNotEquals(immutableCostWidgetDatum, builderResult3.cellExternalId("42").build());
  }

  /**
   * Test {@link ImmutableCostWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCostWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCostWidgetDatum.equals(Object)",
    "int ImmutableCostWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableCostWidgetDatum.builder().cellExternalId("42").build(), null);
  }

  /**
   * Test {@link ImmutableCostWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCostWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCostWidgetDatum.equals(Object)",
    "int ImmutableCostWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableCostWidgetDatum.builder().cellExternalId("42").build(),
        "Different type to ImmutableCostWidgetDatum");
  }

  /**
   * Test {@link ImmutableCostWidgetDatum#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) MeasurableCosts is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCostWidgetDatum#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) MeasurableCosts is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCostWidgetDatum ImmutableCostWidgetDatum.fromJson(Json)"})
  void testFromJson_givenHashSet_whenJsonMeasurableCostsIsHashSet() {
    // Arrange
    Json json = new Json();
    json.setCellExternalId("Json");
    json.setMeasurableCosts(new HashSet<>());

    // Act
    ImmutableCostWidgetDatum actualFromJsonResult = ImmutableCostWidgetDatum.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    assertEquals(0L, actualFromJsonResult.appCount());
    assertTrue(actualFromJsonResult.measurableCosts().isEmpty());
    BigDecimal expectedTotalCostResult = new BigDecimal("0");
    assertEquals(expectedTotalCostResult, actualFromJsonResult.totalCost());
  }

  /**
   * Test {@link ImmutableCostWidgetDatum#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return measurableCosts size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCostWidgetDatum#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return measurableCosts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCostWidgetDatum ImmutableCostWidgetDatum.fromJson(Json)"})
  void testFromJson_thenReturnMeasurableCostsSizeIsOne() {
    // Arrange
    LinkedHashSet<MeasurableCostEntry> measurableCosts = new LinkedHashSet<>();

    ImmutableMeasurableCostEntry.Builder builderResult = ImmutableMeasurableCostEntry.builder();

    ImmutableMeasurableCostEntry.Builder measurableRatingIdResult =
        builderResult
            .allocatedCost(new BigDecimal("2.3"))
            .allocationDerivation(AllocationDerivation.DERIVED)
            .allocationPercentage(1)
            .appId(1L)
            .costKindId(1L)
            .measurableId(1L)
            .measurableRatingId(1L);
    measurableCosts.add(
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(1).build());

    Json json = new Json();
    json.setCellExternalId("Json");
    json.setMeasurableCosts(measurableCosts);

    // Act
    ImmutableCostWidgetDatum actualFromJsonResult = ImmutableCostWidgetDatum.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.measurableCosts().size());
    assertEquals(1L, actualFromJsonResult.appCount());
    BigDecimal expectedTotalCostResult = new BigDecimal("2.3");
    assertEquals(expectedTotalCostResult, actualFromJsonResult.totalCost());
  }

  /**
   * Test {@link ImmutableCostWidgetDatum#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return totalCost is {@link BigDecimal#BigDecimal(String)} with {@code 6.8}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCostWidgetDatum#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return totalCost is BigDecimal(String) with '6.8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCostWidgetDatum ImmutableCostWidgetDatum.fromJson(Json)"})
  void testFromJson_thenReturnTotalCostIsBigDecimalWith68() {
    // Arrange
    LinkedHashSet<MeasurableCostEntry> measurableCosts = new LinkedHashSet<>();

    ImmutableMeasurableCostEntry.Builder builderResult = ImmutableMeasurableCostEntry.builder();

    ImmutableMeasurableCostEntry.Builder measurableRatingIdResult =
        builderResult
            .allocatedCost(new BigDecimal("4.5"))
            .allocationDerivation(AllocationDerivation.DERIVED)
            .allocationPercentage(1)
            .appId(1L)
            .costKindId(1L)
            .measurableId(1L)
            .measurableRatingId(1L);
    measurableCosts.add(
        measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(1).build());

    ImmutableMeasurableCostEntry.Builder builderResult2 = ImmutableMeasurableCostEntry.builder();

    ImmutableMeasurableCostEntry.Builder measurableRatingIdResult2 =
        builderResult2
            .allocatedCost(new BigDecimal("2.3"))
            .allocationDerivation(AllocationDerivation.DERIVED)
            .allocationPercentage(1)
            .appId(1L)
            .costKindId(1L)
            .measurableId(1L)
            .measurableRatingId(1L);
    measurableCosts.add(
        measurableRatingIdResult2.overallCost(new BigDecimal("2.3")).year(1).build());

    Json json = new Json();
    json.setCellExternalId("Json");
    json.setMeasurableCosts(measurableCosts);

    // Act
    ImmutableCostWidgetDatum actualFromJsonResult = ImmutableCostWidgetDatum.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.appCount());
    BigDecimal expectedTotalCostResult = new BigDecimal("6.8");
    assertEquals(expectedTotalCostResult, actualFromJsonResult.totalCost());
    assertEquals(measurableCosts, actualFromJsonResult.measurableCosts());
  }

  /**
   * Test {@link ImmutableCostWidgetDatum#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) MeasurableCosts is {@code null}.
   *   <li>Then return cellExternalId is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCostWidgetDatum#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) MeasurableCosts is 'null'; then return cellExternalId is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCostWidgetDatum ImmutableCostWidgetDatum.fromJson(Json)"})
  void testFromJson_whenJsonMeasurableCostsIsNull_thenReturnCellExternalIdIsJson() {
    // Arrange
    Json json = new Json();
    json.setCellExternalId("Json");
    json.setMeasurableCosts(null);

    // Act
    ImmutableCostWidgetDatum actualFromJsonResult = ImmutableCostWidgetDatum.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    assertEquals(0L, actualFromJsonResult.appCount());
    assertTrue(actualFromJsonResult.measurableCosts().isEmpty());
    BigDecimal expectedTotalCostResult = new BigDecimal("0");
    assertEquals(expectedTotalCostResult, actualFromJsonResult.totalCost());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCostWidgetDatum#toString()}
   *   <li>{@link ImmutableCostWidgetDatum#cellExternalId()}
   *   <li>{@link ImmutableCostWidgetDatum#measurableCosts()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableCostWidgetDatum.cellExternalId()",
    "java.util.Set ImmutableCostWidgetDatum.measurableCosts()",
    "String ImmutableCostWidgetDatum.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableCostWidgetDatum immutableCostWidgetDatum =
        ImmutableCostWidgetDatum.builder().cellExternalId("42").build();

    // Act
    String actualToStringResult = immutableCostWidgetDatum.toString();
    String actualCellExternalIdResult = immutableCostWidgetDatum.cellExternalId();

    // Assert
    assertEquals("42", actualCellExternalIdResult);
    assertEquals(
        "CostWidgetDatum{cellExternalId=42, totalCost=0, appCount=0, measurableCosts=[]}",
        actualToStringResult);
    assertTrue(immutableCostWidgetDatum.measurableCosts().isEmpty());
  }

  /**
   * Test Json {@link Json#appCount()}.
   *
   * <p>Method under test: {@link Json#appCount()}
   */
  @Test
  @DisplayName("Test Json appCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.appCount()"})
  void testJsonAppCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().appCount());
  }

  /**
   * Test Json {@link Json#cellExternalId()}.
   *
   * <p>Method under test: {@link Json#cellExternalId()}
   */
  @Test
  @DisplayName("Test Json cellExternalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.cellExternalId()"})
  void testJsonCellExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().cellExternalId());
  }

  /**
   * Test Json {@link Json#measurableCosts()}.
   *
   * <p>Method under test: {@link Json#measurableCosts()}
   */
  @Test
  @DisplayName("Test Json measurableCosts()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set Json.measurableCosts()"})
  void testJsonMeasurableCosts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().measurableCosts());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.cellExternalId);
    assertTrue(actualJson.measurableCosts.isEmpty());
  }

  /**
   * Test Json {@link Json#totalCost()}.
   *
   * <p>Method under test: {@link Json#totalCost()}
   */
  @Test
  @DisplayName("Test Json totalCost()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal Json.totalCost()"})
  void testJsonTotalCost() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().totalCost());
  }

  /**
   * Test {@link ImmutableCostWidgetDatum#totalCost()}.
   *
   * <p>Method under test: {@link ImmutableCostWidgetDatum#totalCost()}
   */
  @Test
  @DisplayName("Test totalCost()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal ImmutableCostWidgetDatum.totalCost()"})
  void testTotalCost() {
    // Arrange and Act
    BigDecimal actualTotalCostResult =
        ImmutableCostWidgetDatum.builder().cellExternalId("42").build().totalCost();

    // Assert
    assertEquals(new BigDecimal("0"), actualTotalCostResult);
  }

  /**
   * Test {@link ImmutableCostWidgetDatum#withCellExternalId(String)}.
   *
   * <ul>
   *   <li>Then return builder cellExternalId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCostWidgetDatum#withCellExternalId(String)}
   */
  @Test
  @DisplayName("Test withCellExternalId(String); then return builder cellExternalId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCostWidgetDatum ImmutableCostWidgetDatum.withCellExternalId(String)"
  })
  void testWithCellExternalId_thenReturnBuilderCellExternalId42Build() {
    // Arrange
    ImmutableCostWidgetDatum immutableCostWidgetDatum =
        ImmutableCostWidgetDatum.builder().cellExternalId("42").build();

    // Act
    ImmutableCostWidgetDatum actualWithCellExternalIdResult =
        immutableCostWidgetDatum.withCellExternalId("42");

    // Assert
    assertSame(immutableCostWidgetDatum, actualWithCellExternalIdResult);
  }

  /**
   * Test {@link ImmutableCostWidgetDatum#withCellExternalId(String)}.
   *
   * <ul>
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCostWidgetDatum#withCellExternalId(String)}
   */
  @Test
  @DisplayName("Test withCellExternalId(String); then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCostWidgetDatum ImmutableCostWidgetDatum.withCellExternalId(String)"
  })
  void testWithCellExternalId_thenReturnCellExternalIdIs42() {
    // Arrange and Act
    ImmutableCostWidgetDatum actualWithCellExternalIdResult =
        ImmutableCostWidgetDatum.builder()
            .cellExternalId("cellExternalId")
            .build()
            .withCellExternalId("42");

    // Assert
    assertEquals("42", actualWithCellExternalIdResult.cellExternalId());
    assertEquals(0L, actualWithCellExternalIdResult.appCount());
    assertTrue(actualWithCellExternalIdResult.measurableCosts().isEmpty());
    BigDecimal expectedTotalCostResult = new BigDecimal("0");
    assertEquals(expectedTotalCostResult, actualWithCellExternalIdResult.totalCost());
  }

  /**
   * Test {@link ImmutableCostWidgetDatum#withMeasurableCosts(MeasurableCostEntry[])} with {@code
   * MeasurableCostEntry[]}.
   *
   * <ul>
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableCostWidgetDatum#withMeasurableCosts(MeasurableCostEntry[])}
   */
  @Test
  @DisplayName(
      "Test withMeasurableCosts(MeasurableCostEntry[]) with 'MeasurableCostEntry[]'; then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCostWidgetDatum ImmutableCostWidgetDatum.withMeasurableCosts(MeasurableCostEntry[])"
  })
  void testWithMeasurableCostsWithMeasurableCostEntry_thenReturnCellExternalIdIs42() {
    // Arrange
    ImmutableCostWidgetDatum immutableCostWidgetDatum =
        ImmutableCostWidgetDatum.builder().cellExternalId("42").build();

    ImmutableMeasurableCostEntry.Builder builderResult = ImmutableMeasurableCostEntry.builder();

    ImmutableMeasurableCostEntry.Builder measurableRatingIdResult =
        builderResult
            .allocatedCost(new BigDecimal("2.3"))
            .allocationDerivation(AllocationDerivation.DERIVED)
            .allocationPercentage(1)
            .appId(1L)
            .costKindId(1L)
            .measurableId(1L)
            .measurableRatingId(1L);

    // Act
    ImmutableCostWidgetDatum actualWithMeasurableCostsResult =
        immutableCostWidgetDatum.withMeasurableCosts(
            measurableRatingIdResult.overallCost(new BigDecimal("2.3")).year(1).build());

    // Assert
    assertEquals("42", actualWithMeasurableCostsResult.cellExternalId());
    assertEquals(1, actualWithMeasurableCostsResult.measurableCosts().size());
    assertEquals(1L, actualWithMeasurableCostsResult.appCount());
    BigDecimal expectedTotalCostResult = new BigDecimal("2.3");
    assertEquals(expectedTotalCostResult, actualWithMeasurableCostsResult.totalCost());
  }
}
