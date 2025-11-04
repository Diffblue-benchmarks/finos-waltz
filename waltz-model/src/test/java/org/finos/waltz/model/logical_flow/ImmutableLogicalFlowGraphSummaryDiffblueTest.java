package org.finos.waltz.model.logical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import org.finos.waltz.model.FlowDirection;
import org.finos.waltz.model.datatype.DataType;
import org.junit.jupiter.api.Test;

class ImmutableLogicalFlowGraphSummaryDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableLogicalFlowGraphSummary.Builder#build()}
   *   <li>{@link ImmutableLogicalFlowGraphSummary.Builder#parentDataType(DataType)}
   *   <li>
   * {@link ImmutableLogicalFlowGraphSummary.Builder#startingDataType(DataType)}
   * </ul>
   */
  @Test
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableLogicalFlowGraphSummary actualBuildResult = ImmutableLogicalFlowGraphSummary.builder()
        .parentDataType(null)
        .startingDataType(null)
        .build();

    // Assert
    assertNull(actualBuildResult.parentDataType());
    assertNull(actualBuildResult.startingDataType());
    assertTrue(actualBuildResult.flowInfoByDirection().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowGraphSummary.Builder#flowInfoByDirection(Map)}
   */
  @Test
  void testBuilderFlowInfoByDirection() {
    // Arrange
    ImmutableLogicalFlowGraphSummary.Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.flowInfoByDirection(new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowGraphSummary.Builder#flowInfoByDirection(Map)}
   */
  @Test
  void testBuilderFlowInfoByDirection2() {
    // Arrange
    ImmutableLogicalFlowGraphSummary.Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();

    HashMap<FlowDirection, Set<FlowInfo>> entries = new HashMap<>();
    HashSet<FlowInfo> flowInfoSet = new HashSet<>();
    entries.put(FlowDirection.INBOUND, flowInfoSet);

    // Act
    ImmutableLogicalFlowGraphSummary.Builder actualFlowInfoByDirectionResult = builderResult
        .flowInfoByDirection(entries);

    // Assert
    Map<FlowDirection, Set<FlowInfo>> flowInfoByDirectionResult = builderResult.build().flowInfoByDirection();
    assertEquals(1, flowInfoByDirectionResult.size());
    assertSame(flowInfoSet, flowInfoByDirectionResult.get(FlowDirection.INBOUND));
    assertSame(builderResult, actualFlowInfoByDirectionResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowGraphSummary.Builder#flowInfoByDirection(Map)}
   */
  @Test
  void testBuilderFlowInfoByDirection3() {
    // Arrange
    ImmutableLogicalFlowGraphSummary.Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();

    HashMap<FlowDirection, Set<FlowInfo>> entries = new HashMap<>();
    entries.computeIfPresent(FlowDirection.INBOUND, mock(BiFunction.class));
    HashSet<FlowInfo> flowInfoSet = new HashSet<>();
    entries.put(FlowDirection.INBOUND, flowInfoSet);

    // Act
    ImmutableLogicalFlowGraphSummary.Builder actualFlowInfoByDirectionResult = builderResult
        .flowInfoByDirection(entries);

    // Assert
    Map<FlowDirection, Set<FlowInfo>> flowInfoByDirectionResult = builderResult.build().flowInfoByDirection();
    assertEquals(1, flowInfoByDirectionResult.size());
    assertSame(flowInfoSet, flowInfoByDirectionResult.get(FlowDirection.INBOUND));
    assertSame(builderResult, actualFlowInfoByDirectionResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowGraphSummary.Builder#from(LogicalFlowGraphSummary)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableLogicalFlowGraphSummary.Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();
    LogicalFlowGraphSummary instance = mock(LogicalFlowGraphSummary.class);
    when(instance.flowInfoByDirection()).thenReturn(new HashMap<>());
    when(instance.parentDataType()).thenReturn(null);
    when(instance.startingDataType()).thenReturn(null);

    // Act
    ImmutableLogicalFlowGraphSummary.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).flowInfoByDirection();
    verify(instance).parentDataType();
    verify(instance).startingDataType();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowGraphSummary.Builder#from(LogicalFlowGraphSummary)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableLogicalFlowGraphSummary.Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();

    HashMap<FlowDirection, Set<FlowInfo>> flowDirectionSetMap = new HashMap<>();
    HashSet<FlowInfo> flowInfoSet = new HashSet<>();
    flowDirectionSetMap.put(FlowDirection.INBOUND, flowInfoSet);
    LogicalFlowGraphSummary instance = mock(LogicalFlowGraphSummary.class);
    when(instance.flowInfoByDirection()).thenReturn(flowDirectionSetMap);
    when(instance.parentDataType()).thenReturn(null);
    when(instance.startingDataType()).thenReturn(null);

    // Act
    ImmutableLogicalFlowGraphSummary.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).flowInfoByDirection();
    verify(instance).parentDataType();
    verify(instance).startingDataType();
    Map<FlowDirection, Set<FlowInfo>> flowInfoByDirectionResult = builderResult.build().flowInfoByDirection();
    assertEquals(1, flowInfoByDirectionResult.size());
    assertSame(flowInfoSet, flowInfoByDirectionResult.get(FlowDirection.INBOUND));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowGraphSummary.Builder#from(LogicalFlowGraphSummary)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableLogicalFlowGraphSummary.Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();
    LogicalFlowGraphSummary instance = mock(LogicalFlowGraphSummary.class);
    when(instance.flowInfoByDirection()).thenReturn(new HashMap<>());
    when(instance.parentDataType()).thenReturn(mock(DataType.class));
    when(instance.startingDataType()).thenReturn(null);

    // Act
    ImmutableLogicalFlowGraphSummary.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).flowInfoByDirection();
    verify(instance).parentDataType();
    verify(instance).startingDataType();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowGraphSummary.Builder#from(LogicalFlowGraphSummary)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableLogicalFlowGraphSummary.Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();
    LogicalFlowGraphSummary instance = mock(LogicalFlowGraphSummary.class);
    when(instance.flowInfoByDirection()).thenReturn(new HashMap<>());
    when(instance.parentDataType()).thenReturn(null);
    when(instance.startingDataType()).thenReturn(mock(DataType.class));

    // Act
    ImmutableLogicalFlowGraphSummary.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).flowInfoByDirection();
    verify(instance).parentDataType();
    verify(instance).startingDataType();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowGraphSummary.Builder#putAllFlowInfoByDirection(Map)}
   */
  @Test
  void testBuilderPutAllFlowInfoByDirection() {
    // Arrange
    ImmutableLogicalFlowGraphSummary.Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.putAllFlowInfoByDirection(new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowGraphSummary.Builder#putAllFlowInfoByDirection(Map)}
   */
  @Test
  void testBuilderPutAllFlowInfoByDirection2() {
    // Arrange
    ImmutableLogicalFlowGraphSummary.Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();

    HashMap<FlowDirection, Set<FlowInfo>> entries = new HashMap<>();
    HashSet<FlowInfo> flowInfoSet = new HashSet<>();
    entries.put(FlowDirection.INBOUND, flowInfoSet);

    // Act
    ImmutableLogicalFlowGraphSummary.Builder actualPutAllFlowInfoByDirectionResult = builderResult
        .putAllFlowInfoByDirection(entries);

    // Assert
    Map<FlowDirection, Set<FlowInfo>> flowInfoByDirectionResult = builderResult.build().flowInfoByDirection();
    assertEquals(1, flowInfoByDirectionResult.size());
    assertSame(flowInfoSet, flowInfoByDirectionResult.get(FlowDirection.INBOUND));
    assertSame(builderResult, actualPutAllFlowInfoByDirectionResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowGraphSummary.Builder#putAllFlowInfoByDirection(Map)}
   */
  @Test
  void testBuilderPutAllFlowInfoByDirection3() {
    // Arrange
    ImmutableLogicalFlowGraphSummary.Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();

    HashMap<FlowDirection, Set<FlowInfo>> entries = new HashMap<>();
    entries.computeIfPresent(FlowDirection.INBOUND, mock(BiFunction.class));
    HashSet<FlowInfo> flowInfoSet = new HashSet<>();
    entries.put(FlowDirection.INBOUND, flowInfoSet);

    // Act
    ImmutableLogicalFlowGraphSummary.Builder actualPutAllFlowInfoByDirectionResult = builderResult
        .putAllFlowInfoByDirection(entries);

    // Assert
    Map<FlowDirection, Set<FlowInfo>> flowInfoByDirectionResult = builderResult.build().flowInfoByDirection();
    assertEquals(1, flowInfoByDirectionResult.size());
    assertSame(flowInfoSet, flowInfoByDirectionResult.get(FlowDirection.INBOUND));
    assertSame(builderResult, actualPutAllFlowInfoByDirectionResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowGraphSummary.Builder#putFlowInfoByDirection(Map.Entry)}
   */
  @Test
  void testBuilderPutFlowInfoByDirection() {
    // Arrange
    ImmutableLogicalFlowGraphSummary.Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();
    HashSet<FlowInfo> flowInfoSet = new HashSet<>();

    // Act
    ImmutableLogicalFlowGraphSummary.Builder actualPutFlowInfoByDirectionResult = builderResult
        .putFlowInfoByDirection(new AbstractMap.SimpleEntry<>(FlowDirection.INBOUND, flowInfoSet));

    // Assert
    Map<FlowDirection, Set<FlowInfo>> flowInfoByDirectionResult = builderResult.build().flowInfoByDirection();
    assertEquals(1, flowInfoByDirectionResult.size());
    assertSame(flowInfoSet, flowInfoByDirectionResult.get(FlowDirection.INBOUND));
    assertSame(builderResult, actualPutFlowInfoByDirectionResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowGraphSummary.Builder#putFlowInfoByDirection(Map.Entry)}
   */
  @Test
  void testBuilderPutFlowInfoByDirection2() {
    // Arrange
    ImmutableLogicalFlowGraphSummary.Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();
    builderResult.startingDataType(mock(DataType.class));
    HashSet<FlowInfo> flowInfoSet = new HashSet<>();

    // Act
    ImmutableLogicalFlowGraphSummary.Builder actualPutFlowInfoByDirectionResult = builderResult
        .putFlowInfoByDirection(new AbstractMap.SimpleEntry<>(FlowDirection.INBOUND, flowInfoSet));

    // Assert
    Map<FlowDirection, Set<FlowInfo>> flowInfoByDirectionResult = builderResult.build().flowInfoByDirection();
    assertEquals(1, flowInfoByDirectionResult.size());
    assertSame(flowInfoSet, flowInfoByDirectionResult.get(FlowDirection.INBOUND));
    assertSame(builderResult, actualPutFlowInfoByDirectionResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowGraphSummary.Builder#putFlowInfoByDirection(FlowDirection, Set)}
   */
  @Test
  void testBuilderPutFlowInfoByDirection3() {
    // Arrange
    ImmutableLogicalFlowGraphSummary.Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();
    HashSet<FlowInfo> value = new HashSet<>();

    // Act
    ImmutableLogicalFlowGraphSummary.Builder actualPutFlowInfoByDirectionResult = builderResult
        .putFlowInfoByDirection(FlowDirection.INBOUND, value);

    // Assert
    Map<FlowDirection, Set<FlowInfo>> flowInfoByDirectionResult = builderResult.build().flowInfoByDirection();
    assertEquals(1, flowInfoByDirectionResult.size());
    assertSame(value, flowInfoByDirectionResult.get(FlowDirection.INBOUND));
    assertSame(builderResult, actualPutFlowInfoByDirectionResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowGraphSummary.Builder#putFlowInfoByDirection(FlowDirection, Set)}
   */
  @Test
  void testBuilderPutFlowInfoByDirection4() {
    // Arrange
    ImmutableLogicalFlowGraphSummary.Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();

    HashSet<FlowInfo> value = new HashSet<>();
    value.add(new ImmutableFlowInfo.Json());

    // Act
    ImmutableLogicalFlowGraphSummary.Builder actualPutFlowInfoByDirectionResult = builderResult
        .putFlowInfoByDirection(FlowDirection.INBOUND, value);

    // Assert
    Map<FlowDirection, Set<FlowInfo>> flowInfoByDirectionResult = builderResult.build().flowInfoByDirection();
    assertEquals(1, flowInfoByDirectionResult.size());
    assertSame(value, flowInfoByDirectionResult.get(FlowDirection.INBOUND));
    assertSame(builderResult, actualPutFlowInfoByDirectionResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowGraphSummary.Builder#putFlowInfoByDirection(FlowDirection, Set)}
   */
  @Test
  void testBuilderPutFlowInfoByDirection5() {
    // Arrange
    ImmutableLogicalFlowGraphSummary.Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();

    HashSet<FlowInfo> value = new HashSet<>();
    value.add(new ImmutableFlowInfo.Json());
    value.add(new ImmutableFlowInfo.Json());

    // Act
    ImmutableLogicalFlowGraphSummary.Builder actualPutFlowInfoByDirectionResult = builderResult
        .putFlowInfoByDirection(FlowDirection.INBOUND, value);

    // Assert
    Map<FlowDirection, Set<FlowInfo>> flowInfoByDirectionResult = builderResult.build().flowInfoByDirection();
    assertEquals(1, flowInfoByDirectionResult.size());
    assertSame(value, flowInfoByDirectionResult.get(FlowDirection.INBOUND));
    assertSame(builderResult, actualPutFlowInfoByDirectionResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowGraphSummary.Builder#putFlowInfoByDirection(FlowDirection, Set)}
   */
  @Test
  void testBuilderPutFlowInfoByDirection6() {
    // Arrange
    ImmutableLogicalFlowGraphSummary.Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();
    builderResult.startingDataType(mock(DataType.class));
    HashSet<FlowInfo> value = new HashSet<>();

    // Act
    ImmutableLogicalFlowGraphSummary.Builder actualPutFlowInfoByDirectionResult = builderResult
        .putFlowInfoByDirection(FlowDirection.INBOUND, value);

    // Assert
    Map<FlowDirection, Set<FlowInfo>> flowInfoByDirectionResult = builderResult.build().flowInfoByDirection();
    assertEquals(1, flowInfoByDirectionResult.size());
    assertSame(value, flowInfoByDirectionResult.get(FlowDirection.INBOUND));
    assertSame(builderResult, actualPutFlowInfoByDirectionResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowGraphSummary#copyOf(LogicalFlowGraphSummary)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    LogicalFlowGraphSummary instance = mock(LogicalFlowGraphSummary.class);
    when(instance.flowInfoByDirection()).thenReturn(new HashMap<>());
    when(instance.parentDataType()).thenReturn(null);
    when(instance.startingDataType()).thenReturn(null);

    // Act
    ImmutableLogicalFlowGraphSummary actualCopyOfResult = ImmutableLogicalFlowGraphSummary.copyOf(instance);

    // Assert
    verify(instance).flowInfoByDirection();
    verify(instance).parentDataType();
    verify(instance).startingDataType();
    assertNull(actualCopyOfResult.parentDataType());
    assertNull(actualCopyOfResult.startingDataType());
    assertTrue(actualCopyOfResult.flowInfoByDirection().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowGraphSummary#copyOf(LogicalFlowGraphSummary)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashMap<FlowDirection, Set<FlowInfo>> flowDirectionSetMap = new HashMap<>();
    flowDirectionSetMap.put(FlowDirection.INBOUND, new HashSet<>());
    LogicalFlowGraphSummary instance = mock(LogicalFlowGraphSummary.class);
    when(instance.flowInfoByDirection()).thenReturn(flowDirectionSetMap);
    when(instance.parentDataType()).thenReturn(null);
    when(instance.startingDataType()).thenReturn(null);

    // Act
    ImmutableLogicalFlowGraphSummary actualCopyOfResult = ImmutableLogicalFlowGraphSummary.copyOf(instance);

    // Assert
    verify(instance).flowInfoByDirection();
    verify(instance).parentDataType();
    verify(instance).startingDataType();
    assertNull(actualCopyOfResult.parentDataType());
    assertNull(actualCopyOfResult.startingDataType());
    assertEquals(flowDirectionSetMap, actualCopyOfResult.flowInfoByDirection());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowGraphSummary#copyOf(LogicalFlowGraphSummary)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    LogicalFlowGraphSummary instance = mock(LogicalFlowGraphSummary.class);
    when(instance.flowInfoByDirection()).thenReturn(new HashMap<>());
    when(instance.parentDataType()).thenReturn(mock(DataType.class));
    when(instance.startingDataType()).thenReturn(null);

    // Act
    ImmutableLogicalFlowGraphSummary actualCopyOfResult = ImmutableLogicalFlowGraphSummary.copyOf(instance);

    // Assert
    verify(instance).flowInfoByDirection();
    verify(instance).parentDataType();
    verify(instance).startingDataType();
    assertNull(actualCopyOfResult.startingDataType());
    assertTrue(actualCopyOfResult.flowInfoByDirection().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowGraphSummary#copyOf(LogicalFlowGraphSummary)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    LogicalFlowGraphSummary instance = mock(LogicalFlowGraphSummary.class);
    when(instance.flowInfoByDirection()).thenReturn(new HashMap<>());
    when(instance.parentDataType()).thenReturn(null);
    when(instance.startingDataType()).thenReturn(mock(DataType.class));

    // Act
    ImmutableLogicalFlowGraphSummary actualCopyOfResult = ImmutableLogicalFlowGraphSummary.copyOf(instance);

    // Assert
    verify(instance).flowInfoByDirection();
    verify(instance).parentDataType();
    verify(instance).startingDataType();
    assertNull(actualCopyOfResult.parentDataType());
    assertTrue(actualCopyOfResult.flowInfoByDirection().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowGraphSummary#fromJson(ImmutableLogicalFlowGraphSummary.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableLogicalFlowGraphSummary.Json json = new ImmutableLogicalFlowGraphSummary.Json();

    // Act
    ImmutableLogicalFlowGraphSummary actualFromJsonResult = ImmutableLogicalFlowGraphSummary.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.parentDataType());
    assertNull(actualFromJsonResult.startingDataType());
    Map<FlowDirection, Set<FlowInfo>> flowInfoByDirectionResult = actualFromJsonResult.flowInfoByDirection();
    assertTrue(flowInfoByDirectionResult.isEmpty());
    assertSame(json.flowInfoByDirection, flowInfoByDirectionResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowGraphSummary#fromJson(ImmutableLogicalFlowGraphSummary.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableLogicalFlowGraphSummary.Json json = new ImmutableLogicalFlowGraphSummary.Json();
    json.setStartingDataType(null);
    json.setParentDataType(null);
    json.setFlowInfoByDirection(null);

    // Act
    ImmutableLogicalFlowGraphSummary actualFromJsonResult = ImmutableLogicalFlowGraphSummary.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.parentDataType());
    assertNull(actualFromJsonResult.startingDataType());
    assertTrue(actualFromJsonResult.flowInfoByDirection().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowGraphSummary#fromJson(ImmutableLogicalFlowGraphSummary.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ImmutableLogicalFlowGraphSummary.Json json = new ImmutableLogicalFlowGraphSummary.Json();
    json.setStartingDataType(mock(DataType.class));

    // Act
    ImmutableLogicalFlowGraphSummary actualFromJsonResult = ImmutableLogicalFlowGraphSummary.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.parentDataType());
    Map<FlowDirection, Set<FlowInfo>> flowInfoByDirectionResult = actualFromJsonResult.flowInfoByDirection();
    assertTrue(flowInfoByDirectionResult.isEmpty());
    assertSame(json.flowInfoByDirection, flowInfoByDirectionResult);
    DataType expectedStartingDataTypeResult = json.startingDataType;
    assertSame(expectedStartingDataTypeResult, actualFromJsonResult.startingDataType());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowGraphSummary#fromJson(ImmutableLogicalFlowGraphSummary.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    ImmutableLogicalFlowGraphSummary.Json json = new ImmutableLogicalFlowGraphSummary.Json();
    json.setParentDataType(mock(DataType.class));

    // Act
    ImmutableLogicalFlowGraphSummary actualFromJsonResult = ImmutableLogicalFlowGraphSummary.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.startingDataType());
    Map<FlowDirection, Set<FlowInfo>> flowInfoByDirectionResult = actualFromJsonResult.flowInfoByDirection();
    assertTrue(flowInfoByDirectionResult.isEmpty());
    assertSame(json.flowInfoByDirection, flowInfoByDirectionResult);
    DataType expectedParentDataTypeResult = json.parentDataType;
    assertSame(expectedParentDataTypeResult, actualFromJsonResult.parentDataType());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowGraphSummary#fromJson(ImmutableLogicalFlowGraphSummary.Json)}
   */
  @Test
  void testFromJson5() {
    // Arrange
    HashMap<FlowDirection, Set<FlowInfo>> flowInfoByDirection = new HashMap<>();
    flowInfoByDirection.put(FlowDirection.INBOUND, new HashSet<>());

    ImmutableLogicalFlowGraphSummary.Json json = new ImmutableLogicalFlowGraphSummary.Json();
    json.setFlowInfoByDirection(flowInfoByDirection);

    // Act
    ImmutableLogicalFlowGraphSummary actualFromJsonResult = ImmutableLogicalFlowGraphSummary.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.parentDataType());
    assertNull(actualFromJsonResult.startingDataType());
    assertEquals(flowInfoByDirection, actualFromJsonResult.flowInfoByDirection());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowGraphSummary.Json#flowInfoByDirection()}
   */
  @Test
  void testJsonFlowInfoByDirection() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLogicalFlowGraphSummary.Json()).flowInfoByDirection());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableLogicalFlowGraphSummary.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableLogicalFlowGraphSummary.Json actualJson = new ImmutableLogicalFlowGraphSummary.Json();

    // Assert
    assertNull(actualJson.parentDataType);
    assertNull(actualJson.startingDataType);
    assertTrue(actualJson.flowInfoByDirection.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowGraphSummary.Json#parentDataType()}
   */
  @Test
  void testJsonParentDataType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLogicalFlowGraphSummary.Json()).parentDataType());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowGraphSummary.Json#startingDataType()}
   */
  @Test
  void testJsonStartingDataType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLogicalFlowGraphSummary.Json()).startingDataType());
  }
}
