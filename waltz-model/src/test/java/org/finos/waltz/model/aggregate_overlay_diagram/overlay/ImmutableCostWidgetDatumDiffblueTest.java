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
import java.util.ArrayList;
import java.util.HashSet;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableCostWidgetDatum.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableCostWidgetDatum.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCostWidgetDatumDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllMeasurableCosts(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllMeasurableCosts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllMeasurableCosts(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllMeasurableCosts(Iterable)"})
  void testBuilderAddAllMeasurableCosts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllMeasurableCosts(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addMeasurableCosts(MeasurableCostEntry)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableMeasurableCostEntry.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addMeasurableCosts(MeasurableCostEntry)}
   */
  @Test
  @DisplayName("Test Builder addMeasurableCosts(MeasurableCostEntry) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addMeasurableCosts(MeasurableCostEntry)"})
  void testBuilderAddMeasurableCostsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addMeasurableCosts(new ImmutableMeasurableCostEntry.Json()));
  }

  /**
   * Test Builder {@link Builder#addMeasurableCosts(MeasurableCostEntry[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableMeasurableCostEntry.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addMeasurableCosts(MeasurableCostEntry[])}
   */
  @Test
  @DisplayName("Test Builder addMeasurableCosts(MeasurableCostEntry[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addMeasurableCosts(MeasurableCostEntry[])"})
  void testBuilderAddMeasurableCostsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addMeasurableCosts(new ImmutableMeasurableCostEntry.Json()));
  }

  /**
   * Test Builder {@link Builder#cellExternalId(String)}.
   * <p>
   * Method under test: {@link Builder#cellExternalId(String)}
   */
  @Test
  @DisplayName("Test Builder cellExternalId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.cellExternalId(String)"})
  void testBuilderCellExternalId() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetDatum.builder();

    // Act
    Builder actualCellExternalIdResult = builderResult.cellExternalId("42");

    // Assert
    ImmutableCostWidgetDatum buildResult = builderResult.build();
    assertEquals("42", buildResult.cellExternalId());
    assertEquals(0L, buildResult.appCount());
    assertSame(builderResult, actualCellExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#from(CellExternalIdProvider)} with {@code CellExternalIdProvider}.
   * <ul>
   *   <li>Then builder build cellExternalId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CellExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CellExternalIdProvider) with 'CellExternalIdProvider'; then builder build cellExternalId is '42'")
  @Tag("MaintainedByDiffblue")
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
    ImmutableCostWidgetDatum buildResult = builderResult.build();
    assertEquals("42", buildResult.cellExternalId());
    assertEquals(0L, buildResult.appCount());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CostWidgetDatum)} with {@code CostWidgetDatum}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link ImmutableMeasurableCostEntry.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CostWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder from(CostWidgetDatum) with 'CostWidgetDatum'; given HashSet() add Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CostWidgetDatum)"})
  void testBuilderFromWithCostWidgetDatum_givenHashSetAddJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetDatum.builder();

    HashSet<MeasurableCostEntry> measurableCostEntrySet = new HashSet<>();
    measurableCostEntrySet.add(new ImmutableMeasurableCostEntry.Json());
    CostWidgetDatum instance = mock(CostWidgetDatum.class);
    when(instance.measurableCosts()).thenReturn(measurableCostEntrySet);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellExternalId();
    verify(instance).measurableCosts();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CostWidgetDatum)} with {@code CostWidgetDatum}.
   * <ul>
   *   <li>Then return build cellExternalId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CostWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder from(CostWidgetDatum) with 'CostWidgetDatum'; then return build cellExternalId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CostWidgetDatum)"})
  void testBuilderFromWithCostWidgetDatum_thenReturnBuildCellExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetDatum.builder();
    CostWidgetDatum instance = mock(CostWidgetDatum.class);
    when(instance.measurableCosts()).thenReturn(new HashSet<>());
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellExternalId();
    verify(instance).measurableCosts();
    ImmutableCostWidgetDatum buildResult = actualFromResult.build();
    assertEquals("42", buildResult.cellExternalId());
    ImmutableCostWidgetDatum buildResult2 = builderResult.build();
    assertEquals("42", buildResult2.cellExternalId());
    assertEquals(0L, buildResult.appCount());
    assertEquals(0L, buildResult2.appCount());
    assertTrue(buildResult.measurableCosts().isEmpty());
    BigDecimal expectedTotalCostResult = new BigDecimal("0");
    assertEquals(expectedTotalCostResult, buildResult.totalCost());
  }

  /**
   * Test Builder {@link Builder#from(CostWidgetDatum)} with {@code CostWidgetDatum}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CostWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder from(CostWidgetDatum) with 'CostWidgetDatum'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CostWidgetDatum)"})
  void testBuilderFromWithCostWidgetDatum_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetDatum.builder();
    CostWidgetDatum instance = mock(CostWidgetDatum.class);
    when(instance.measurableCosts()).thenThrow(new IllegalStateException("instance"));
    when(instance.cellExternalId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).cellExternalId();
    verify(instance).measurableCosts();
  }

  /**
   * Test Builder {@link Builder#measurableCosts(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#measurableCosts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder measurableCosts(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.measurableCosts(Iterable)"})
  void testBuilderMeasurableCosts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetDatum.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurableCosts(new ArrayList<>()));
  }

  /**
   * Test Json {@link Json#appCount()}.
   * <p>
   * Method under test: {@link Json#appCount()}
   */
  @Test
  @DisplayName("Test Json appCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.appCount()"})
  void testJsonAppCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).appCount());
  }

  /**
   * Test Json {@link Json#cellExternalId()}.
   * <p>
   * Method under test: {@link Json#cellExternalId()}
   */
  @Test
  @DisplayName("Test Json cellExternalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.cellExternalId()"})
  void testJsonCellExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).cellExternalId());
  }

  /**
   * Test Json {@link Json#measurableCosts()}.
   * <p>
   * Method under test: {@link Json#measurableCosts()}
   */
  @Test
  @DisplayName("Test Json measurableCosts()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Json.measurableCosts()"})
  void testJsonMeasurableCosts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).measurableCosts());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#totalCost()}
   */
  @Test
  @DisplayName("Test Json totalCost()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BigDecimal Json.totalCost()"})
  void testJsonTotalCost() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).totalCost());
  }
}
