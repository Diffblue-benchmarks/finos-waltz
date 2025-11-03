package org.finos.waltz.model.logical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.finos.waltz.model.FlowDirection;
import org.finos.waltz.model.datatype.DataType;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlowGraphSummary.Builder;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlowGraphSummary.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableLogicalFlowGraphSummaryDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#parentDataType(DataType)}
   *   <li>{@link Builder#startingDataType(DataType)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableLogicalFlowGraphSummary Builder.build()", "Builder Builder.parentDataType(DataType)",
      "Builder Builder.startingDataType(DataType)"})
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
   * Test Builder {@link Builder#flowInfoByDirection(Map)}.
   * <ul>
   *   <li>Then return build flowInfoByDirection size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#flowInfoByDirection(Map)}
   */
  @Test
  @DisplayName("Test Builder flowInfoByDirection(Map); then return build flowInfoByDirection size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.flowInfoByDirection(Map)"})
  void testBuilderFlowInfoByDirection_thenReturnBuildFlowInfoByDirectionSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();

    HashMap<FlowDirection, Set<FlowInfo>> entries = new HashMap<>();
    entries.put(FlowDirection.INBOUND, new HashSet<>());

    // Act and Assert
    Map<FlowDirection, Set<FlowInfo>> flowInfoByDirectionResult = builderResult.flowInfoByDirection(entries)
        .build()
        .flowInfoByDirection();
    assertEquals(1, flowInfoByDirectionResult.size());
    assertTrue(flowInfoByDirectionResult.get(FlowDirection.INBOUND).isEmpty());
    assertEquals(entries, builderResult.build().flowInfoByDirection());
  }

  /**
   * Test Builder {@link Builder#flowInfoByDirection(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#flowInfoByDirection(Map)}
   */
  @Test
  @DisplayName("Test Builder flowInfoByDirection(Map); when HashMap(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.flowInfoByDirection(Map)"})
  void testBuilderFlowInfoByDirection_whenHashMap_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.flowInfoByDirection(new HashMap<>()));
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlowGraphSummary)}.
   * <p>
   * Method under test: {@link Builder#from(LogicalFlowGraphSummary)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlowGraphSummary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LogicalFlowGraphSummary)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();
    ImmutableLogicalFlowGraphSummary instance = ImmutableLogicalFlowGraphSummary.builder()
        .parentDataType(null)
        .startingDataType(mock(DataType.class))
        .build();

    // Act and Assert
    assertEquals(instance, builderResult.from(instance).build());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlowGraphSummary)}.
   * <p>
   * Method under test: {@link Builder#from(LogicalFlowGraphSummary)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlowGraphSummary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LogicalFlowGraphSummary)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();
    ImmutableLogicalFlowGraphSummary instance = ImmutableLogicalFlowGraphSummary.builder()
        .parentDataType(mock(DataType.class))
        .startingDataType(null)
        .build();

    // Act and Assert
    assertEquals(instance, builderResult.from(instance).build());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlowGraphSummary)}.
   * <ul>
   *   <li>Given {@code INBOUND}.</li>
   *   <li>Then return build flowInfoByDirection size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LogicalFlowGraphSummary)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlowGraphSummary); given 'INBOUND'; then return build flowInfoByDirection size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LogicalFlowGraphSummary)"})
  void testBuilderFrom_givenInbound_thenReturnBuildFlowInfoByDirectionSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();
    Builder builderResult2 = ImmutableLogicalFlowGraphSummary.builder();
    builderResult2.putFlowInfoByDirection(FlowDirection.INBOUND, new HashSet<>());
    ImmutableLogicalFlowGraphSummary instance = builderResult2.parentDataType(mock(DataType.class))
        .startingDataType(mock(DataType.class))
        .build();

    // Act and Assert
    Map<FlowDirection, Set<FlowInfo>> flowInfoByDirectionResult = builderResult.from(instance)
        .build()
        .flowInfoByDirection();
    assertEquals(1, flowInfoByDirectionResult.size());
    assertTrue(flowInfoByDirectionResult.get(FlowDirection.INBOUND).isEmpty());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlowGraphSummary)}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LogicalFlowGraphSummary)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlowGraphSummary); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LogicalFlowGraphSummary)"})
  void testBuilderFrom_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();
    ImmutableLogicalFlowGraphSummary instance = ImmutableLogicalFlowGraphSummary.builder()
        .parentDataType(mock(DataType.class))
        .startingDataType(mock(DataType.class))
        .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#putAllFlowInfoByDirection(Map)}.
   * <ul>
   *   <li>Then return build flowInfoByDirection size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#putAllFlowInfoByDirection(Map)}
   */
  @Test
  @DisplayName("Test Builder putAllFlowInfoByDirection(Map); then return build flowInfoByDirection size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.putAllFlowInfoByDirection(Map)"})
  void testBuilderPutAllFlowInfoByDirection_thenReturnBuildFlowInfoByDirectionSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();

    HashMap<FlowDirection, Set<FlowInfo>> entries = new HashMap<>();
    entries.put(FlowDirection.INBOUND, new HashSet<>());

    // Act and Assert
    Map<FlowDirection, Set<FlowInfo>> flowInfoByDirectionResult = builderResult.putAllFlowInfoByDirection(entries)
        .build()
        .flowInfoByDirection();
    assertEquals(1, flowInfoByDirectionResult.size());
    assertTrue(flowInfoByDirectionResult.get(FlowDirection.INBOUND).isEmpty());
    assertEquals(entries, builderResult.build().flowInfoByDirection());
  }

  /**
   * Test Builder {@link Builder#putAllFlowInfoByDirection(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#putAllFlowInfoByDirection(Map)}
   */
  @Test
  @DisplayName("Test Builder putAllFlowInfoByDirection(Map); when HashMap(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.putAllFlowInfoByDirection(Map)"})
  void testBuilderPutAllFlowInfoByDirection_whenHashMap_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.putAllFlowInfoByDirection(new HashMap<>()));
  }

  /**
   * Test Builder {@link Builder#putFlowInfoByDirection(Entry)} with {@code entry}.
   * <p>
   * Method under test: {@link Builder#putFlowInfoByDirection(Entry)}
   */
  @Test
  @DisplayName("Test Builder putFlowInfoByDirection(Entry) with 'entry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.putFlowInfoByDirection(Entry)"})
  void testBuilderPutFlowInfoByDirectionWithEntry() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();
    HashSet<FlowInfo> flowInfoSet = new HashSet<>();

    // Act
    Builder actualPutFlowInfoByDirectionResult = builderResult
        .putFlowInfoByDirection(new SimpleEntry<>(FlowDirection.INBOUND, flowInfoSet));

    // Assert
    Map<FlowDirection, Set<FlowInfo>> flowInfoByDirectionResult = builderResult.build().flowInfoByDirection();
    assertEquals(1, flowInfoByDirectionResult.size());
    assertSame(flowInfoSet, flowInfoByDirectionResult.get(FlowDirection.INBOUND));
    assertSame(builderResult, actualPutFlowInfoByDirectionResult);
  }

  /**
   * Test Builder {@link Builder#putFlowInfoByDirection(FlowDirection, Set)} with {@code key}, {@code value}.
   * <ul>
   *   <li>Given {@link ImmutableFlowInfo.Json} (default constructor).</li>
   *   <li>When {@link HashSet#HashSet()} add {@link ImmutableFlowInfo.Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#putFlowInfoByDirection(FlowDirection, Set)}
   */
  @Test
  @DisplayName("Test Builder putFlowInfoByDirection(FlowDirection, Set) with 'key', 'value'; given Json (default constructor); when HashSet() add Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.putFlowInfoByDirection(FlowDirection, Set)"})
  void testBuilderPutFlowInfoByDirectionWithKeyValue_givenJson_whenHashSetAddJson() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();

    HashSet<FlowInfo> value = new HashSet<>();
    value.add(new ImmutableFlowInfo.Json());

    // Act
    Builder actualPutFlowInfoByDirectionResult = builderResult.putFlowInfoByDirection(FlowDirection.INBOUND, value);

    // Assert
    Map<FlowDirection, Set<FlowInfo>> flowInfoByDirectionResult = builderResult.build().flowInfoByDirection();
    assertEquals(1, flowInfoByDirectionResult.size());
    assertSame(value, flowInfoByDirectionResult.get(FlowDirection.INBOUND));
    assertSame(builderResult, actualPutFlowInfoByDirectionResult);
  }

  /**
   * Test Builder {@link Builder#putFlowInfoByDirection(FlowDirection, Set)} with {@code key}, {@code value}.
   * <ul>
   *   <li>Given {@link ImmutableFlowInfo.Json} (default constructor).</li>
   *   <li>When {@link HashSet#HashSet()} add {@link ImmutableFlowInfo.Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#putFlowInfoByDirection(FlowDirection, Set)}
   */
  @Test
  @DisplayName("Test Builder putFlowInfoByDirection(FlowDirection, Set) with 'key', 'value'; given Json (default constructor); when HashSet() add Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.putFlowInfoByDirection(FlowDirection, Set)"})
  void testBuilderPutFlowInfoByDirectionWithKeyValue_givenJson_whenHashSetAddJson2() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();

    HashSet<FlowInfo> value = new HashSet<>();
    value.add(new ImmutableFlowInfo.Json());
    value.add(new ImmutableFlowInfo.Json());

    // Act
    Builder actualPutFlowInfoByDirectionResult = builderResult.putFlowInfoByDirection(FlowDirection.INBOUND, value);

    // Assert
    Map<FlowDirection, Set<FlowInfo>> flowInfoByDirectionResult = builderResult.build().flowInfoByDirection();
    assertEquals(1, flowInfoByDirectionResult.size());
    assertSame(value, flowInfoByDirectionResult.get(FlowDirection.INBOUND));
    assertSame(builderResult, actualPutFlowInfoByDirectionResult);
  }

  /**
   * Test Builder {@link Builder#putFlowInfoByDirection(FlowDirection, Set)} with {@code key}, {@code value}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#putFlowInfoByDirection(FlowDirection, Set)}
   */
  @Test
  @DisplayName("Test Builder putFlowInfoByDirection(FlowDirection, Set) with 'key', 'value'; when HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.putFlowInfoByDirection(FlowDirection, Set)"})
  void testBuilderPutFlowInfoByDirectionWithKeyValue_whenHashSet() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();
    HashSet<FlowInfo> value = new HashSet<>();

    // Act
    Builder actualPutFlowInfoByDirectionResult = builderResult.putFlowInfoByDirection(FlowDirection.INBOUND, value);

    // Assert
    Map<FlowDirection, Set<FlowInfo>> flowInfoByDirectionResult = builderResult.build().flowInfoByDirection();
    assertEquals(1, flowInfoByDirectionResult.size());
    assertSame(value, flowInfoByDirectionResult.get(FlowDirection.INBOUND));
    assertSame(builderResult, actualPutFlowInfoByDirectionResult);
  }

  /**
   * Test {@link ImmutableLogicalFlowGraphSummary#copyOf(LogicalFlowGraphSummary)}.
   * <ul>
   *   <li>Then return flowInfoByDirection Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalFlowGraphSummary#copyOf(LogicalFlowGraphSummary)}
   */
  @Test
  @DisplayName("Test copyOf(LogicalFlowGraphSummary); then return flowInfoByDirection Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableLogicalFlowGraphSummary ImmutableLogicalFlowGraphSummary.copyOf(LogicalFlowGraphSummary)"})
  void testCopyOf_thenReturnFlowInfoByDirectionEmpty() {
    // Arrange
    ImmutableLogicalFlowGraphSummary instance = ImmutableLogicalFlowGraphSummary.builder()
        .parentDataType(mock(DataType.class))
        .startingDataType(mock(DataType.class))
        .build();

    // Act and Assert
    assertTrue(ImmutableLogicalFlowGraphSummary.copyOf(instance).flowInfoByDirection().isEmpty());
  }

  /**
   * Test {@link ImmutableLogicalFlowGraphSummary#equals(Object)}, and {@link ImmutableLogicalFlowGraphSummary#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableLogicalFlowGraphSummary#equals(Object)}
   *   <li>{@link ImmutableLogicalFlowGraphSummary#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableLogicalFlowGraphSummary.equals(Object)",
      "int ImmutableLogicalFlowGraphSummary.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableLogicalFlowGraphSummary buildResult = ImmutableLogicalFlowGraphSummary.builder()
        .parentDataType(null)
        .startingDataType(null)
        .build();
    ImmutableLogicalFlowGraphSummary buildResult2 = ImmutableLogicalFlowGraphSummary.builder()
        .parentDataType(null)
        .startingDataType(null)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableLogicalFlowGraphSummary#equals(Object)}, and {@link ImmutableLogicalFlowGraphSummary#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableLogicalFlowGraphSummary#equals(Object)}
   *   <li>{@link ImmutableLogicalFlowGraphSummary#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableLogicalFlowGraphSummary.equals(Object)",
      "int ImmutableLogicalFlowGraphSummary.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableLogicalFlowGraphSummary buildResult = ImmutableLogicalFlowGraphSummary.builder()
        .parentDataType(null)
        .startingDataType(null)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableLogicalFlowGraphSummary#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalFlowGraphSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableLogicalFlowGraphSummary.equals(Object)",
      "int ImmutableLogicalFlowGraphSummary.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();
    builderResult.putFlowInfoByDirection(FlowDirection.INBOUND, new HashSet<>());
    ImmutableLogicalFlowGraphSummary buildResult = builderResult.parentDataType(null).startingDataType(null).build();
    ImmutableLogicalFlowGraphSummary buildResult2 = ImmutableLogicalFlowGraphSummary.builder()
        .parentDataType(null)
        .startingDataType(null)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableLogicalFlowGraphSummary#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalFlowGraphSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableLogicalFlowGraphSummary.equals(Object)",
      "int ImmutableLogicalFlowGraphSummary.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableLogicalFlowGraphSummary buildResult = ImmutableLogicalFlowGraphSummary.builder()
        .parentDataType(mock(DataType.class))
        .startingDataType(null)
        .build();
    ImmutableLogicalFlowGraphSummary buildResult2 = ImmutableLogicalFlowGraphSummary.builder()
        .parentDataType(null)
        .startingDataType(null)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableLogicalFlowGraphSummary#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalFlowGraphSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableLogicalFlowGraphSummary.equals(Object)",
      "int ImmutableLogicalFlowGraphSummary.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableLogicalFlowGraphSummary buildResult = ImmutableLogicalFlowGraphSummary.builder()
        .parentDataType(null)
        .startingDataType(mock(DataType.class))
        .build();
    ImmutableLogicalFlowGraphSummary buildResult2 = ImmutableLogicalFlowGraphSummary.builder()
        .parentDataType(null)
        .startingDataType(null)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableLogicalFlowGraphSummary#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalFlowGraphSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableLogicalFlowGraphSummary.equals(Object)",
      "int ImmutableLogicalFlowGraphSummary.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableLogicalFlowGraphSummary buildResult = ImmutableLogicalFlowGraphSummary.builder()
        .parentDataType(null)
        .startingDataType(null)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableLogicalFlowGraphSummary#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalFlowGraphSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableLogicalFlowGraphSummary.equals(Object)",
      "int ImmutableLogicalFlowGraphSummary.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableLogicalFlowGraphSummary buildResult = ImmutableLogicalFlowGraphSummary.builder()
        .parentDataType(null)
        .startingDataType(null)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableLogicalFlowGraphSummary");
  }

  /**
   * Test {@link ImmutableLogicalFlowGraphSummary#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code INBOUND} is {@link HashSet#HashSet()}.</li>
   *   <li>Then return flowInfoByDirection size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalFlowGraphSummary#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given HashMap() 'INBOUND' is HashSet(); then return flowInfoByDirection size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableLogicalFlowGraphSummary ImmutableLogicalFlowGraphSummary.fromJson(Json)"})
  void testFromJson_givenHashMapInboundIsHashSet_thenReturnFlowInfoByDirectionSizeIsOne() {
    // Arrange
    HashMap<FlowDirection, Set<FlowInfo>> flowInfoByDirection = new HashMap<>();
    flowInfoByDirection.put(FlowDirection.INBOUND, new HashSet<>());

    Json json = new Json();
    json.setFlowInfoByDirection(flowInfoByDirection);

    // Act and Assert
    Map<FlowDirection, Set<FlowInfo>> flowInfoByDirectionResult = ImmutableLogicalFlowGraphSummary.fromJson(json)
        .flowInfoByDirection();
    assertEquals(1, flowInfoByDirectionResult.size());
    assertTrue(flowInfoByDirectionResult.get(FlowDirection.INBOUND).isEmpty());
  }

  /**
   * Test {@link ImmutableLogicalFlowGraphSummary#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Json} (default constructor) StartingDataType is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalFlowGraphSummary#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'null'; when Json (default constructor) StartingDataType is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableLogicalFlowGraphSummary ImmutableLogicalFlowGraphSummary.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonStartingDataTypeIsNull() {
    // Arrange
    Json json = new Json();
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
   * Test {@link ImmutableLogicalFlowGraphSummary#fromJson(Json)}.
   * <ul>
   *   <li>Then return parentDataType is {@link Json} (default constructor) {@link Json#parentDataType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalFlowGraphSummary#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return parentDataType is Json (default constructor) parentDataType")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableLogicalFlowGraphSummary ImmutableLogicalFlowGraphSummary.fromJson(Json)"})
  void testFromJson_thenReturnParentDataTypeIsJsonParentDataType() {
    // Arrange
    Json json = new Json();
    json.setParentDataType(mock(DataType.class));

    // Act
    ImmutableLogicalFlowGraphSummary actualFromJsonResult = ImmutableLogicalFlowGraphSummary.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.startingDataType());
    assertTrue(actualFromJsonResult.flowInfoByDirection().isEmpty());
    DataType expectedParentDataTypeResult = json.parentDataType;
    assertSame(expectedParentDataTypeResult, actualFromJsonResult.parentDataType());
  }

  /**
   * Test {@link ImmutableLogicalFlowGraphSummary#fromJson(Json)}.
   * <ul>
   *   <li>Then return startingDataType is {@link Json} (default constructor) {@link Json#startingDataType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalFlowGraphSummary#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return startingDataType is Json (default constructor) startingDataType")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableLogicalFlowGraphSummary ImmutableLogicalFlowGraphSummary.fromJson(Json)"})
  void testFromJson_thenReturnStartingDataTypeIsJsonStartingDataType() {
    // Arrange
    Json json = new Json();
    json.setStartingDataType(mock(DataType.class));

    // Act
    ImmutableLogicalFlowGraphSummary actualFromJsonResult = ImmutableLogicalFlowGraphSummary.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.parentDataType());
    assertTrue(actualFromJsonResult.flowInfoByDirection().isEmpty());
    DataType expectedStartingDataTypeResult = json.startingDataType;
    assertSame(expectedStartingDataTypeResult, actualFromJsonResult.startingDataType());
  }

  /**
   * Test {@link ImmutableLogicalFlowGraphSummary#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return parentDataType is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalFlowGraphSummary#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return parentDataType is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableLogicalFlowGraphSummary ImmutableLogicalFlowGraphSummary.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnParentDataTypeIsNull() {
    // Arrange and Act
    ImmutableLogicalFlowGraphSummary actualFromJsonResult = ImmutableLogicalFlowGraphSummary.fromJson(new Json());

    // Assert
    assertNull(actualFromJsonResult.parentDataType());
    assertNull(actualFromJsonResult.startingDataType());
    assertTrue(actualFromJsonResult.flowInfoByDirection().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableLogicalFlowGraphSummary#toString()}
   *   <li>{@link ImmutableLogicalFlowGraphSummary#flowInfoByDirection()}
   *   <li>{@link ImmutableLogicalFlowGraphSummary#parentDataType()}
   *   <li>{@link ImmutableLogicalFlowGraphSummary#startingDataType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map ImmutableLogicalFlowGraphSummary.flowInfoByDirection()",
      "DataType ImmutableLogicalFlowGraphSummary.parentDataType()",
      "DataType ImmutableLogicalFlowGraphSummary.startingDataType()",
      "String ImmutableLogicalFlowGraphSummary.toString()"})
  void testGettersAndSetters() {
    // Arrange
    ImmutableLogicalFlowGraphSummary buildResult = ImmutableLogicalFlowGraphSummary.builder()
        .parentDataType(null)
        .startingDataType(null)
        .build();

    // Act
    String actualToStringResult = buildResult.toString();
    Map<FlowDirection, Set<FlowInfo>> actualFlowInfoByDirectionResult = buildResult.flowInfoByDirection();
    DataType actualParentDataTypeResult = buildResult.parentDataType();

    // Assert
    assertEquals("LogicalFlowGraphSummary{startingDataType=null, parentDataType=null, flowInfoByDirection={}}",
        actualToStringResult);
    assertNull(actualParentDataTypeResult);
    assertNull(buildResult.startingDataType());
    assertTrue(actualFlowInfoByDirectionResult.isEmpty());
  }

  /**
   * Test Json {@link Json#flowInfoByDirection()}.
   * <p>
   * Method under test: {@link Json#flowInfoByDirection()}
   */
  @Test
  @DisplayName("Test Json flowInfoByDirection()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map Json.flowInfoByDirection()"})
  void testJsonFlowInfoByDirection() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).flowInfoByDirection());
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
    assertNull(actualJson.parentDataType);
    assertNull(actualJson.startingDataType);
    assertTrue(actualJson.flowInfoByDirection.isEmpty());
  }

  /**
   * Test Json {@link Json#parentDataType()}.
   * <p>
   * Method under test: {@link Json#parentDataType()}
   */
  @Test
  @DisplayName("Test Json parentDataType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataType Json.parentDataType()"})
  void testJsonParentDataType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).parentDataType());
  }

  /**
   * Test Json {@link Json#startingDataType()}.
   * <p>
   * Method under test: {@link Json#startingDataType()}
   */
  @Test
  @DisplayName("Test Json startingDataType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataType Json.startingDataType()"})
  void testJsonStartingDataType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).startingDataType());
  }

  /**
   * Test {@link ImmutableLogicalFlowGraphSummary#withFlowInfoByDirection(Map)}.
   * <p>
   * Method under test: {@link ImmutableLogicalFlowGraphSummary#withFlowInfoByDirection(Map)}
   */
  @Test
  @DisplayName("Test withFlowInfoByDirection(Map)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableLogicalFlowGraphSummary ImmutableLogicalFlowGraphSummary.withFlowInfoByDirection(Map)"})
  void testWithFlowInfoByDirection() {
    // Arrange
    ImmutableLogicalFlowGraphSummary buildResult = ImmutableLogicalFlowGraphSummary.builder()
        .parentDataType(mock(DataType.class))
        .startingDataType(mock(DataType.class))
        .build();

    // Act and Assert
    assertTrue(buildResult.withFlowInfoByDirection(new HashMap<>()).flowInfoByDirection().isEmpty());
  }

  /**
   * Test {@link ImmutableLogicalFlowGraphSummary#withParentDataType(DataType)}.
   * <p>
   * Method under test: {@link ImmutableLogicalFlowGraphSummary#withParentDataType(DataType)}
   */
  @Test
  @DisplayName("Test withParentDataType(DataType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableLogicalFlowGraphSummary ImmutableLogicalFlowGraphSummary.withParentDataType(DataType)"})
  void testWithParentDataType() {
    // Arrange
    ImmutableLogicalFlowGraphSummary buildResult = ImmutableLogicalFlowGraphSummary.builder()
        .parentDataType(null)
        .startingDataType(mock(DataType.class))
        .build();

    // Act and Assert
    assertSame(buildResult, buildResult.withParentDataType(null));
  }

  /**
   * Test {@link ImmutableLogicalFlowGraphSummary#withParentDataType(DataType)}.
   * <ul>
   *   <li>Then return flowInfoByDirection Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalFlowGraphSummary#withParentDataType(DataType)}
   */
  @Test
  @DisplayName("Test withParentDataType(DataType); then return flowInfoByDirection Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableLogicalFlowGraphSummary ImmutableLogicalFlowGraphSummary.withParentDataType(DataType)"})
  void testWithParentDataType_thenReturnFlowInfoByDirectionEmpty() {
    // Arrange
    ImmutableLogicalFlowGraphSummary buildResult = ImmutableLogicalFlowGraphSummary.builder()
        .parentDataType(mock(DataType.class))
        .startingDataType(mock(DataType.class))
        .build();
    DataType value = mock(DataType.class);

    // Act
    ImmutableLogicalFlowGraphSummary actualWithParentDataTypeResult = buildResult.withParentDataType(value);

    // Assert
    assertTrue(actualWithParentDataTypeResult.flowInfoByDirection().isEmpty());
    assertSame(value, actualWithParentDataTypeResult.parentDataType());
  }

  /**
   * Test {@link ImmutableLogicalFlowGraphSummary#withStartingDataType(DataType)}.
   * <p>
   * Method under test: {@link ImmutableLogicalFlowGraphSummary#withStartingDataType(DataType)}
   */
  @Test
  @DisplayName("Test withStartingDataType(DataType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableLogicalFlowGraphSummary ImmutableLogicalFlowGraphSummary.withStartingDataType(DataType)"})
  void testWithStartingDataType() {
    // Arrange
    ImmutableLogicalFlowGraphSummary buildResult = ImmutableLogicalFlowGraphSummary.builder()
        .parentDataType(mock(DataType.class))
        .startingDataType(null)
        .build();

    // Act and Assert
    assertSame(buildResult, buildResult.withStartingDataType(null));
  }

  /**
   * Test {@link ImmutableLogicalFlowGraphSummary#withStartingDataType(DataType)}.
   * <ul>
   *   <li>Then return flowInfoByDirection Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLogicalFlowGraphSummary#withStartingDataType(DataType)}
   */
  @Test
  @DisplayName("Test withStartingDataType(DataType); then return flowInfoByDirection Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableLogicalFlowGraphSummary ImmutableLogicalFlowGraphSummary.withStartingDataType(DataType)"})
  void testWithStartingDataType_thenReturnFlowInfoByDirectionEmpty() {
    // Arrange
    ImmutableLogicalFlowGraphSummary buildResult = ImmutableLogicalFlowGraphSummary.builder()
        .parentDataType(mock(DataType.class))
        .startingDataType(mock(DataType.class))
        .build();
    DataType value = mock(DataType.class);

    // Act
    ImmutableLogicalFlowGraphSummary actualWithStartingDataTypeResult = buildResult.withStartingDataType(value);

    // Assert
    assertTrue(actualWithStartingDataTypeResult.flowInfoByDirection().isEmpty());
    assertSame(value, actualWithStartingDataTypeResult.startingDataType());
  }
}
