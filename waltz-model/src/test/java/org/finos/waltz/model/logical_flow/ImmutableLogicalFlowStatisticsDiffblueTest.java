package org.finos.waltz.model.logical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlowMeasures.Json;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlowStatistics.Builder;
import org.finos.waltz.model.tally.TallyPack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableLogicalFlowStatisticsDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllDataTypeCounts(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllDataTypeCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllDataTypeCounts(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllDataTypeCounts(Iterable)"})
  void testBuilderAddAllDataTypeCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDataTypeCounts(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addDataTypeCounts(TallyPack)} with {@code element}.
   * <ul>
   *   <li>When {@link TallyPack}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addDataTypeCounts(TallyPack)}
   */
  @Test
  @DisplayName("Test Builder addDataTypeCounts(TallyPack) with 'element'; when TallyPack; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addDataTypeCounts(TallyPack)"})
  void testBuilderAddDataTypeCountsWithElement_whenTallyPack_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDataTypeCounts(mock(TallyPack.class)));
  }

  /**
   * Test Builder {@link Builder#addDataTypeCounts(TallyPack[])} with {@code elements}.
   * <ul>
   *   <li>When {@link TallyPack}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addDataTypeCounts(TallyPack[])}
   */
  @Test
  @DisplayName("Test Builder addDataTypeCounts(TallyPack[]) with 'elements'; when TallyPack; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addDataTypeCounts(TallyPack[])"})
  void testBuilderAddDataTypeCountsWithElements_whenTallyPack_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDataTypeCounts(mock(TallyPack.class)));
  }

  /**
   * Test Builder {@link Builder#appCounts(LogicalFlowMeasures)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#appCounts(LogicalFlowMeasures)}
   */
  @Test
  @DisplayName("Test Builder appCounts(LogicalFlowMeasures); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.appCounts(LogicalFlowMeasures)"})
  void testBuilderAppCounts_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.appCounts(new Json()));
  }

  /**
   * Test Builder {@link Builder#dataTypeCounts(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#dataTypeCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder dataTypeCounts(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.dataTypeCounts(Iterable)"})
  void testBuilderDataTypeCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dataTypeCounts(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#flowCounts(LogicalFlowMeasures)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#flowCounts(LogicalFlowMeasures)}
   */
  @Test
  @DisplayName("Test Builder flowCounts(LogicalFlowMeasures); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.flowCounts(LogicalFlowMeasures)"})
  void testBuilderFlowCounts_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.flowCounts(new Json()));
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlowStatistics)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then builder build appCounts is {@link Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LogicalFlowStatistics)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlowStatistics); given ArrayList(); then builder build appCounts is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LogicalFlowStatistics)"})
  void testBuilderFrom_givenArrayList_thenBuilderBuildAppCountsIsJson() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowStatistics.builder();
    LogicalFlowStatistics instance = mock(LogicalFlowStatistics.class);
    when(instance.dataTypeCounts()).thenReturn(new ArrayList<>());
    Json json = new Json();
    when(instance.flowCounts()).thenReturn(json);
    Json json2 = new Json();
    when(instance.appCounts()).thenReturn(json2);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appCounts();
    verify(instance).dataTypeCounts();
    verify(instance).flowCounts();
    ImmutableLogicalFlowStatistics buildResult = builderResult.build();
    assertSame(json2, buildResult.appCounts());
    assertSame(json, buildResult.flowCounts());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlowStatistics)}.
   * <ul>
   *   <li>Then return build dataTypeCounts size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LogicalFlowStatistics)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlowStatistics); then return build dataTypeCounts size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LogicalFlowStatistics)"})
  void testBuilderFrom_thenReturnBuildDataTypeCountsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowStatistics.builder();

    ArrayList<TallyPack<String>> tallyPackList = new ArrayList<>();
    tallyPackList.add(mock(TallyPack.class));
    LogicalFlowStatistics instance = mock(LogicalFlowStatistics.class);
    when(instance.dataTypeCounts()).thenReturn(tallyPackList);
    when(instance.flowCounts()).thenReturn(new Json());
    when(instance.appCounts()).thenReturn(new Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appCounts();
    verify(instance).dataTypeCounts();
    verify(instance).flowCounts();
    assertEquals(1, actualFromResult.build().dataTypeCounts().size());
    assertEquals(1, builderResult.build().dataTypeCounts().size());
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlowStatistics)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LogicalFlowStatistics)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlowStatistics); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LogicalFlowStatistics)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowStatistics.builder();
    LogicalFlowStatistics instance = mock(LogicalFlowStatistics.class);
    when(instance.dataTypeCounts()).thenThrow(new IllegalStateException("instance"));
    when(instance.flowCounts()).thenReturn(new Json());
    when(instance.appCounts()).thenReturn(new Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).appCounts();
    verify(instance).dataTypeCounts();
    verify(instance).flowCounts();
  }

  /**
   * Test Json {@link ImmutableLogicalFlowStatistics.Json#appCounts()}.
   * <p>
   * Method under test: {@link ImmutableLogicalFlowStatistics.Json#appCounts()}
   */
  @Test
  @DisplayName("Test Json appCounts()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LogicalFlowMeasures ImmutableLogicalFlowStatistics.Json.appCounts()"})
  void testJsonAppCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLogicalFlowStatistics.Json()).appCounts());
  }

  /**
   * Test Json {@link ImmutableLogicalFlowStatistics.Json#dataTypeCounts()}.
   * <p>
   * Method under test: {@link ImmutableLogicalFlowStatistics.Json#dataTypeCounts()}
   */
  @Test
  @DisplayName("Test Json dataTypeCounts()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List ImmutableLogicalFlowStatistics.Json.dataTypeCounts()"})
  void testJsonDataTypeCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLogicalFlowStatistics.Json()).dataTypeCounts());
  }

  /**
   * Test Json {@link ImmutableLogicalFlowStatistics.Json#flowCounts()}.
   * <p>
   * Method under test: {@link ImmutableLogicalFlowStatistics.Json#flowCounts()}
   */
  @Test
  @DisplayName("Test Json flowCounts()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LogicalFlowMeasures ImmutableLogicalFlowStatistics.Json.flowCounts()"})
  void testJsonFlowCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLogicalFlowStatistics.Json()).flowCounts());
  }

  /**
   * Test Json new {@link ImmutableLogicalFlowStatistics.Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ImmutableLogicalFlowStatistics.Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ImmutableLogicalFlowStatistics.Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableLogicalFlowStatistics.Json actualJson = new ImmutableLogicalFlowStatistics.Json();

    // Assert
    assertNull(actualJson.appCounts);
    assertNull(actualJson.flowCounts);
    assertTrue(actualJson.dataTypeCounts.isEmpty());
  }
}
