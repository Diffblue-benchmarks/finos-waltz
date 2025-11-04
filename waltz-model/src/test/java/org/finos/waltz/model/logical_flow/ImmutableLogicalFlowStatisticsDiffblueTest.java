package org.finos.waltz.model.logical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.finos.waltz.model.tally.TallyPack;
import org.junit.jupiter.api.Test;

class ImmutableLogicalFlowStatisticsDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableLogicalFlowStatistics.Builder#addAllDataTypeCounts(Iterable)}
   */
  @Test
  void testBuilderAddAllDataTypeCounts() {
    // Arrange
    ImmutableLogicalFlowStatistics.Builder builderResult = ImmutableLogicalFlowStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDataTypeCounts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowStatistics.Builder#addDataTypeCounts(TallyPack)}
   */
  @Test
  void testBuilderAddDataTypeCounts() {
    // Arrange
    ImmutableLogicalFlowStatistics.Builder builderResult = ImmutableLogicalFlowStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDataTypeCounts(mock(TallyPack.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowStatistics.Builder#addDataTypeCounts(TallyPack[])}
   */
  @Test
  void testBuilderAddDataTypeCounts2() {
    // Arrange
    ImmutableLogicalFlowStatistics.Builder builderResult = ImmutableLogicalFlowStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDataTypeCounts(mock(TallyPack.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowStatistics.Builder#appCounts(LogicalFlowMeasures)}
   */
  @Test
  void testBuilderAppCounts() {
    // Arrange
    ImmutableLogicalFlowStatistics.Builder builderResult = ImmutableLogicalFlowStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.appCounts(new ImmutableLogicalFlowMeasures.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowStatistics.Builder#appCounts(LogicalFlowMeasures)}
   */
  @Test
  void testBuilderAppCounts2() {
    // Arrange
    ImmutableLogicalFlowStatistics.Builder builderResult = ImmutableLogicalFlowStatistics.builder();
    builderResult.addDataTypeCounts(mock(TallyPack.class));

    // Act and Assert
    assertSame(builderResult, builderResult.appCounts(new ImmutableLogicalFlowMeasures.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowStatistics.Builder#dataTypeCounts(Iterable)}
   */
  @Test
  void testBuilderDataTypeCounts() {
    // Arrange
    ImmutableLogicalFlowStatistics.Builder builderResult = ImmutableLogicalFlowStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dataTypeCounts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowStatistics.Builder#flowCounts(LogicalFlowMeasures)}
   */
  @Test
  void testBuilderFlowCounts() {
    // Arrange
    ImmutableLogicalFlowStatistics.Builder builderResult = ImmutableLogicalFlowStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.flowCounts(new ImmutableLogicalFlowMeasures.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowStatistics.Builder#flowCounts(LogicalFlowMeasures)}
   */
  @Test
  void testBuilderFlowCounts2() {
    // Arrange
    ImmutableLogicalFlowStatistics.Builder builderResult = ImmutableLogicalFlowStatistics.builder();
    builderResult.addDataTypeCounts(mock(TallyPack.class));

    // Act and Assert
    assertSame(builderResult, builderResult.flowCounts(new ImmutableLogicalFlowMeasures.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowStatistics.Builder#from(LogicalFlowStatistics)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableLogicalFlowStatistics.Builder builderResult = ImmutableLogicalFlowStatistics.builder();
    LogicalFlowStatistics instance = mock(LogicalFlowStatistics.class);
    when(instance.dataTypeCounts()).thenReturn(new ArrayList<>());
    ImmutableLogicalFlowMeasures.Json json = new ImmutableLogicalFlowMeasures.Json();
    when(instance.flowCounts()).thenReturn(json);
    ImmutableLogicalFlowMeasures.Json json2 = new ImmutableLogicalFlowMeasures.Json();
    when(instance.appCounts()).thenReturn(json2);

    // Act
    ImmutableLogicalFlowStatistics.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableLogicalFlowStatistics.Builder#from(LogicalFlowStatistics)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableLogicalFlowStatistics.Builder builderResult = ImmutableLogicalFlowStatistics.builder();
    LogicalFlowStatistics instance = mock(LogicalFlowStatistics.class);
    when(instance.dataTypeCounts()).thenThrow(new IllegalStateException("instance"));
    when(instance.flowCounts()).thenReturn(new ImmutableLogicalFlowMeasures.Json());
    when(instance.appCounts()).thenReturn(new ImmutableLogicalFlowMeasures.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).appCounts();
    verify(instance).dataTypeCounts();
    verify(instance).flowCounts();
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowStatistics.Builder#from(LogicalFlowStatistics)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableLogicalFlowStatistics.Builder builderResult = ImmutableLogicalFlowStatistics.builder();

    ArrayList<TallyPack<String>> tallyPackList = new ArrayList<>();
    tallyPackList.add(mock(TallyPack.class));
    LogicalFlowStatistics instance = mock(LogicalFlowStatistics.class);
    when(instance.dataTypeCounts()).thenReturn(tallyPackList);
    ImmutableLogicalFlowMeasures.Json json = new ImmutableLogicalFlowMeasures.Json();
    when(instance.flowCounts()).thenReturn(json);
    ImmutableLogicalFlowMeasures.Json json2 = new ImmutableLogicalFlowMeasures.Json();
    when(instance.appCounts()).thenReturn(json2);

    // Act
    ImmutableLogicalFlowStatistics.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).appCounts();
    verify(instance).dataTypeCounts();
    verify(instance).flowCounts();
    ImmutableLogicalFlowStatistics buildResult = builderResult.build();
    assertEquals(1, buildResult.dataTypeCounts().size());
    assertSame(json2, buildResult.appCounts());
    assertSame(json, buildResult.flowCounts());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowStatistics#copyOf(LogicalFlowStatistics)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    LogicalFlowStatistics instance = mock(LogicalFlowStatistics.class);
    when(instance.dataTypeCounts()).thenReturn(new ArrayList<>());
    ImmutableLogicalFlowMeasures.Json json = new ImmutableLogicalFlowMeasures.Json();
    when(instance.flowCounts()).thenReturn(json);
    ImmutableLogicalFlowMeasures.Json json2 = new ImmutableLogicalFlowMeasures.Json();
    when(instance.appCounts()).thenReturn(json2);

    // Act
    ImmutableLogicalFlowStatistics actualCopyOfResult = ImmutableLogicalFlowStatistics.copyOf(instance);

    // Assert
    verify(instance).appCounts();
    verify(instance).dataTypeCounts();
    verify(instance).flowCounts();
    assertTrue(actualCopyOfResult.dataTypeCounts().isEmpty());
    assertSame(json2, actualCopyOfResult.appCounts());
    assertSame(json, actualCopyOfResult.flowCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowStatistics#copyOf(LogicalFlowStatistics)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<TallyPack<String>> tallyPackList = new ArrayList<>();
    tallyPackList.add(mock(TallyPack.class));
    LogicalFlowStatistics instance = mock(LogicalFlowStatistics.class);
    when(instance.dataTypeCounts()).thenReturn(tallyPackList);
    ImmutableLogicalFlowMeasures.Json json = new ImmutableLogicalFlowMeasures.Json();
    when(instance.flowCounts()).thenReturn(json);
    ImmutableLogicalFlowMeasures.Json json2 = new ImmutableLogicalFlowMeasures.Json();
    when(instance.appCounts()).thenReturn(json2);

    // Act
    ImmutableLogicalFlowStatistics actualCopyOfResult = ImmutableLogicalFlowStatistics.copyOf(instance);

    // Assert
    verify(instance).appCounts();
    verify(instance).dataTypeCounts();
    verify(instance).flowCounts();
    assertEquals(1, actualCopyOfResult.dataTypeCounts().size());
    assertSame(json2, actualCopyOfResult.appCounts());
    assertSame(json, actualCopyOfResult.flowCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowStatistics#copyOf(LogicalFlowStatistics)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<TallyPack<String>> tallyPackList = new ArrayList<>();
    tallyPackList.add(mock(TallyPack.class));
    tallyPackList.add(mock(TallyPack.class));
    LogicalFlowStatistics instance = mock(LogicalFlowStatistics.class);
    when(instance.dataTypeCounts()).thenReturn(tallyPackList);
    ImmutableLogicalFlowMeasures.Json json = new ImmutableLogicalFlowMeasures.Json();
    when(instance.flowCounts()).thenReturn(json);
    ImmutableLogicalFlowMeasures.Json json2 = new ImmutableLogicalFlowMeasures.Json();
    when(instance.appCounts()).thenReturn(json2);

    // Act
    ImmutableLogicalFlowStatistics actualCopyOfResult = ImmutableLogicalFlowStatistics.copyOf(instance);

    // Assert
    verify(instance).appCounts();
    verify(instance).dataTypeCounts();
    verify(instance).flowCounts();
    assertEquals(tallyPackList, actualCopyOfResult.dataTypeCounts());
    assertSame(json2, actualCopyOfResult.appCounts());
    assertSame(json, actualCopyOfResult.flowCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowStatistics#fromJson(ImmutableLogicalFlowStatistics.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableLogicalFlowStatistics.Json json = new ImmutableLogicalFlowStatistics.Json();
    ImmutableLogicalFlowMeasures.Json appCounts = new ImmutableLogicalFlowMeasures.Json();
    json.setAppCounts(appCounts);
    ImmutableLogicalFlowMeasures.Json flowCounts = new ImmutableLogicalFlowMeasures.Json();
    json.setFlowCounts(flowCounts);
    json.setDataTypeCounts(null);

    // Act
    ImmutableLogicalFlowStatistics actualFromJsonResult = ImmutableLogicalFlowStatistics.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.dataTypeCounts().isEmpty());
    assertSame(appCounts, actualFromJsonResult.appCounts());
    assertSame(flowCounts, actualFromJsonResult.flowCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowStatistics#fromJson(ImmutableLogicalFlowStatistics.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ArrayList<TallyPack<String>> dataTypeCounts = new ArrayList<>();
    dataTypeCounts.add(mock(TallyPack.class));

    ImmutableLogicalFlowStatistics.Json json = new ImmutableLogicalFlowStatistics.Json();
    ImmutableLogicalFlowMeasures.Json appCounts = new ImmutableLogicalFlowMeasures.Json();
    json.setAppCounts(appCounts);
    ImmutableLogicalFlowMeasures.Json flowCounts = new ImmutableLogicalFlowMeasures.Json();
    json.setFlowCounts(flowCounts);
    json.setDataTypeCounts(dataTypeCounts);

    // Act
    ImmutableLogicalFlowStatistics actualFromJsonResult = ImmutableLogicalFlowStatistics.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.dataTypeCounts().size());
    assertSame(appCounts, actualFromJsonResult.appCounts());
    assertSame(flowCounts, actualFromJsonResult.flowCounts());
  }

  /**
   * Method under test: {@link ImmutableLogicalFlowStatistics.Json#appCounts()}
   */
  @Test
  void testJsonAppCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLogicalFlowStatistics.Json()).appCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowStatistics.Json#dataTypeCounts()}
   */
  @Test
  void testJsonDataTypeCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLogicalFlowStatistics.Json()).dataTypeCounts());
  }

  /**
   * Method under test: {@link ImmutableLogicalFlowStatistics.Json#flowCounts()}
   */
  @Test
  void testJsonFlowCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLogicalFlowStatistics.Json()).flowCounts());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableLogicalFlowStatistics.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableLogicalFlowStatistics.Json actualJson = new ImmutableLogicalFlowStatistics.Json();

    // Assert
    assertNull(actualJson.appCounts);
    assertNull(actualJson.flowCounts);
    assertTrue(actualJson.dataTypeCounts.isEmpty());
  }
}
