package org.finos.waltz.model.logical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.FlowDirection;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.datatype.DataType;
import org.finos.waltz.model.datatype.ImmutableDataType;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlowGraphSummary.Builder;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlowGraphSummary.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableLogicalFlowGraphSummaryDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#parentDataType(DataType)}
   *   <li>{@link Builder#startingDataType(DataType)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowGraphSummary Builder.build()",
    "Builder Builder.parentDataType(DataType)",
    "Builder Builder.startingDataType(DataType)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableLogicalFlowGraphSummary.builder();
    ImmutableDataType parentDataType =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();
    Builder actualParentDataTypeResult = actualBuilderResult.parentDataType(parentDataType);
    ImmutableDataType startingDataType =
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();
    ImmutableLogicalFlowGraphSummary actualImmutableLogicalFlowGraphSummary =
        actualParentDataTypeResult.startingDataType(startingDataType).build();

    // Assert
    assertTrue(actualImmutableLogicalFlowGraphSummary.flowInfoByDirection().isEmpty());
    assertSame(parentDataType, actualImmutableLogicalFlowGraphSummary.parentDataType());
    assertSame(startingDataType, actualImmutableLogicalFlowGraphSummary.startingDataType());
  }

  /**
   * Test Builder {@link Builder#flowInfoByDirection(Map)}.
   *
   * <ul>
   *   <li>Then return build flowInfoByDirection size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#flowInfoByDirection(Map)}
   */
  @Test
  @DisplayName(
      "Test Builder flowInfoByDirection(Map); then return build flowInfoByDirection size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.flowInfoByDirection(Map)"})
  void testBuilderFlowInfoByDirection_thenReturnBuildFlowInfoByDirectionSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();

    HashMap<FlowDirection, Set<FlowInfo>> entries = new HashMap<>();
    entries.put(FlowDirection.INBOUND, new HashSet<>());

    // Act and Assert
    Map<FlowDirection, Set<FlowInfo>> flowInfoByDirectionResult =
        builderResult.flowInfoByDirection(entries).build().flowInfoByDirection();
    assertEquals(1, flowInfoByDirectionResult.size());
    assertTrue(flowInfoByDirectionResult.get(FlowDirection.INBOUND).isEmpty());
    assertEquals(entries, builderResult.build().flowInfoByDirection());
  }

  /**
   * Test Builder {@link Builder#flowInfoByDirection(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#flowInfoByDirection(Map)}
   */
  @Test
  @DisplayName("Test Builder flowInfoByDirection(Map); when HashMap(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.flowInfoByDirection(Map)"})
  void testBuilderFlowInfoByDirection_whenHashMap_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();

    // Act
    Builder actualFlowInfoByDirectionResult = builderResult.flowInfoByDirection(new HashMap<>());

    // Assert
    assertSame(builderResult, actualFlowInfoByDirectionResult);
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlowGraphSummary)}.
   *
   * <p>Method under test: {@link Builder#from(LogicalFlowGraphSummary)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlowGraphSummary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LogicalFlowGraphSummary)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();

    Builder builderResult2 = ImmutableLogicalFlowGraphSummary.builder();

    Builder parentDataTypeResult =
        builderResult2.parentDataType(
            ImmutableDataType.builder()
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());
    ImmutableLogicalFlowGraphSummary instance =
        parentDataTypeResult
            .startingDataType(
                ImmutableDataType.builder()
                    .code("Code")
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .parentId(1L)
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableLogicalFlowGraphSummary actualImmutableLogicalFlowGraphSummary = builderResult.build();
    assertEquals(instance, actualImmutableLogicalFlowGraphSummary);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlowGraphSummary)}.
   *
   * <ul>
   *   <li>Given {@code INBOUND}.
   *   <li>When builder FlowInfoByDirection {@code INBOUND} is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(LogicalFlowGraphSummary)}
   */
  @Test
  @DisplayName(
      "Test Builder from(LogicalFlowGraphSummary); given 'INBOUND'; when builder FlowInfoByDirection 'INBOUND' is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LogicalFlowGraphSummary)"})
  void testBuilderFrom_givenInbound_whenBuilderFlowInfoByDirectionInboundIsHashSet() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();

    Builder builderResult2 = ImmutableLogicalFlowGraphSummary.builder();
    builderResult2.putFlowInfoByDirection(FlowDirection.INBOUND, new HashSet<>());

    Builder parentDataTypeResult =
        builderResult2.parentDataType(
            ImmutableDataType.builder()
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());
    ImmutableLogicalFlowGraphSummary instance =
        parentDataTypeResult
            .startingDataType(
                ImmutableDataType.builder()
                    .code("Code")
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .parentId(1L)
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableLogicalFlowGraphSummary actualImmutableLogicalFlowGraphSummary = builderResult.build();
    assertEquals(instance, actualImmutableLogicalFlowGraphSummary);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#putAllFlowInfoByDirection(Map)}.
   *
   * <ul>
   *   <li>Then return build flowInfoByDirection size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#putAllFlowInfoByDirection(Map)}
   */
  @Test
  @DisplayName(
      "Test Builder putAllFlowInfoByDirection(Map); then return build flowInfoByDirection size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.putAllFlowInfoByDirection(Map)"})
  void testBuilderPutAllFlowInfoByDirection_thenReturnBuildFlowInfoByDirectionSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();

    HashMap<FlowDirection, Set<FlowInfo>> entries = new HashMap<>();
    entries.put(FlowDirection.INBOUND, new HashSet<>());

    // Act and Assert
    Map<FlowDirection, Set<FlowInfo>> flowInfoByDirectionResult =
        builderResult.putAllFlowInfoByDirection(entries).build().flowInfoByDirection();
    assertEquals(1, flowInfoByDirectionResult.size());
    assertTrue(flowInfoByDirectionResult.get(FlowDirection.INBOUND).isEmpty());
    assertEquals(entries, builderResult.build().flowInfoByDirection());
  }

  /**
   * Test Builder {@link Builder#putAllFlowInfoByDirection(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#putAllFlowInfoByDirection(Map)}
   */
  @Test
  @DisplayName("Test Builder putAllFlowInfoByDirection(Map); when HashMap(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.putAllFlowInfoByDirection(Map)"})
  void testBuilderPutAllFlowInfoByDirection_whenHashMap_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();

    // Act
    Builder actualPutAllFlowInfoByDirectionResult =
        builderResult.putAllFlowInfoByDirection(new HashMap<>());

    // Assert
    assertSame(builderResult, actualPutAllFlowInfoByDirectionResult);
  }

  /**
   * Test Builder {@link Builder#putFlowInfoByDirection(Entry)} with {@code entry}.
   *
   * <p>Method under test: {@link Builder#putFlowInfoByDirection(Entry)}
   */
  @Test
  @DisplayName("Test Builder putFlowInfoByDirection(Entry) with 'entry'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.putFlowInfoByDirection(Entry)"})
  void testBuilderPutFlowInfoByDirectionWithEntry() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();
    HashSet<FlowInfo> flowInfoSet = new HashSet<>();

    // Act
    Builder actualPutFlowInfoByDirectionResult =
        builderResult.putFlowInfoByDirection(new SimpleEntry<>(FlowDirection.INBOUND, flowInfoSet));

    // Assert
    Map<FlowDirection, Set<FlowInfo>> flowInfoByDirectionResult =
        builderResult.build().flowInfoByDirection();
    assertEquals(1, flowInfoByDirectionResult.size());
    assertSame(flowInfoSet, flowInfoByDirectionResult.get(FlowDirection.INBOUND));
    assertSame(builderResult, actualPutFlowInfoByDirectionResult);
  }

  /**
   * Test Builder {@link Builder#putFlowInfoByDirection(FlowDirection, Set)} with {@code key},
   * {@code value}.
   *
   * <p>Method under test: {@link Builder#putFlowInfoByDirection(FlowDirection, Set)}
   */
  @Test
  @DisplayName("Test Builder putFlowInfoByDirection(FlowDirection, Set) with 'key', 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.putFlowInfoByDirection(FlowDirection, Set)"})
  void testBuilderPutFlowInfoByDirectionWithKeyValue() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();

    HashSet<FlowInfo> value = new HashSet<>();

    ImmutableFlowInfo.Builder builderResult2 = ImmutableFlowInfo.builder();

    ImmutableFlowInfo.Builder classificationIdResult =
        builderResult2
            .actualDataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .classificationId(1L);

    ImmutableFlowInfo.Builder flowIdResult =
        classificationIdResult
            .counterpart(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowEntityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .flowId(1L);
    value.add(
        flowIdResult
            .rollupDataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    // Act
    Builder actualPutFlowInfoByDirectionResult =
        builderResult.putFlowInfoByDirection(FlowDirection.INBOUND, value);

    // Assert
    Map<FlowDirection, Set<FlowInfo>> flowInfoByDirectionResult =
        builderResult.build().flowInfoByDirection();
    assertEquals(1, flowInfoByDirectionResult.size());
    assertSame(value, flowInfoByDirectionResult.get(FlowDirection.INBOUND));
    assertSame(builderResult, actualPutFlowInfoByDirectionResult);
  }

  /**
   * Test Builder {@link Builder#putFlowInfoByDirection(FlowDirection, Set)} with {@code key},
   * {@code value}.
   *
   * <p>Method under test: {@link Builder#putFlowInfoByDirection(FlowDirection, Set)}
   */
  @Test
  @DisplayName("Test Builder putFlowInfoByDirection(FlowDirection, Set) with 'key', 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.putFlowInfoByDirection(FlowDirection, Set)"})
  void testBuilderPutFlowInfoByDirectionWithKeyValue2() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();

    HashSet<FlowInfo> value = new HashSet<>();

    ImmutableFlowInfo.Builder builderResult2 = ImmutableFlowInfo.builder();

    ImmutableFlowInfo.Builder classificationIdResult =
        builderResult2
            .actualDataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .classificationId(1L);

    ImmutableFlowInfo.Builder flowIdResult =
        classificationIdResult
            .counterpart(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowEntityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .flowId(1L);
    value.add(
        flowIdResult
            .rollupDataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    ImmutableFlowInfo.Builder builderResult3 = ImmutableFlowInfo.builder();

    ImmutableFlowInfo.Builder classificationIdResult2 =
        builderResult3
            .actualDataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .classificationId(1L);

    ImmutableFlowInfo.Builder flowIdResult2 =
        classificationIdResult2
            .counterpart(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowEntityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .flowId(1L);
    value.add(
        flowIdResult2
            .rollupDataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    // Act
    Builder actualPutFlowInfoByDirectionResult =
        builderResult.putFlowInfoByDirection(FlowDirection.INBOUND, value);

    // Assert
    Map<FlowDirection, Set<FlowInfo>> flowInfoByDirectionResult =
        builderResult.build().flowInfoByDirection();
    assertEquals(1, flowInfoByDirectionResult.size());
    assertSame(value, flowInfoByDirectionResult.get(FlowDirection.INBOUND));
    assertSame(builderResult, actualPutFlowInfoByDirectionResult);
  }

  /**
   * Test Builder {@link Builder#putFlowInfoByDirection(FlowDirection, Set)} with {@code key},
   * {@code value}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#putFlowInfoByDirection(FlowDirection, Set)}
   */
  @Test
  @DisplayName(
      "Test Builder putFlowInfoByDirection(FlowDirection, Set) with 'key', 'value'; when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.putFlowInfoByDirection(FlowDirection, Set)"})
  void testBuilderPutFlowInfoByDirectionWithKeyValue_whenHashSet() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();
    HashSet<FlowInfo> value = new HashSet<>();

    // Act
    Builder actualPutFlowInfoByDirectionResult =
        builderResult.putFlowInfoByDirection(FlowDirection.INBOUND, value);

    // Assert
    Map<FlowDirection, Set<FlowInfo>> flowInfoByDirectionResult =
        builderResult.build().flowInfoByDirection();
    assertEquals(1, flowInfoByDirectionResult.size());
    assertSame(value, flowInfoByDirectionResult.get(FlowDirection.INBOUND));
    assertSame(builderResult, actualPutFlowInfoByDirectionResult);
  }

  /**
   * Test {@link ImmutableLogicalFlowGraphSummary#copyOf(LogicalFlowGraphSummary)}.
   *
   * <ul>
   *   <li>Then parentDataType return {@link ImmutableDataType}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowGraphSummary#copyOf(LogicalFlowGraphSummary)}
   */
  @Test
  @DisplayName("Test copyOf(LogicalFlowGraphSummary); then parentDataType return ImmutableDataType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowGraphSummary ImmutableLogicalFlowGraphSummary.copyOf(LogicalFlowGraphSummary)"
  })
  void testCopyOf_thenParentDataTypeReturnImmutableDataType() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();

    Builder parentDataTypeResult =
        builderResult.parentDataType(
            ImmutableDataType.builder()
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());
    ImmutableLogicalFlowGraphSummary instance =
        parentDataTypeResult
            .startingDataType(
                ImmutableDataType.builder()
                    .code("Code")
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .parentId(1L)
                    .build())
            .build();

    // Act
    ImmutableLogicalFlowGraphSummary actualCopyOfResult =
        ImmutableLogicalFlowGraphSummary.copyOf(instance);

    // Assert
    DataType parentDataTypeResult2 = actualCopyOfResult.parentDataType();
    assertTrue(parentDataTypeResult2 instanceof ImmutableDataType);
    DataType startingDataTypeResult = actualCopyOfResult.startingDataType();
    assertTrue(startingDataTypeResult instanceof ImmutableDataType);
    assertEquals("Code", parentDataTypeResult2.code());
    assertEquals("Name", parentDataTypeResult2.name());
    assertEquals(
        "The characteristics of someone or something", parentDataTypeResult2.description());
    assertEquals(EntityKind.ALL, parentDataTypeResult2.kind());
    assertFalse(parentDataTypeResult2.deprecated());
    assertFalse(parentDataTypeResult2.unknown());
    assertTrue(actualCopyOfResult.flowInfoByDirection().isEmpty());
    assertTrue(parentDataTypeResult2.concrete());
    assertEquals(parentDataTypeResult2, startingDataTypeResult);
  }

  /**
   * Test {@link ImmutableLogicalFlowGraphSummary#equals(Object)}, and {@link
   * ImmutableLogicalFlowGraphSummary#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLogicalFlowGraphSummary#equals(Object)}
   *   <li>{@link ImmutableLogicalFlowGraphSummary#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowGraphSummary.equals(Object)",
    "int ImmutableLogicalFlowGraphSummary.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();

    Builder parentDataTypeResult =
        builderResult.parentDataType(
            ImmutableDataType.builder()
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());
    ImmutableLogicalFlowGraphSummary immutableLogicalFlowGraphSummary =
        parentDataTypeResult
            .startingDataType(
                ImmutableDataType.builder()
                    .code("Code")
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .parentId(1L)
                    .build())
            .build();

    Builder builderResult2 = ImmutableLogicalFlowGraphSummary.builder();

    Builder parentDataTypeResult2 =
        builderResult2.parentDataType(
            ImmutableDataType.builder()
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());
    ImmutableLogicalFlowGraphSummary immutableLogicalFlowGraphSummary2 =
        parentDataTypeResult2
            .startingDataType(
                ImmutableDataType.builder()
                    .code("Code")
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .parentId(1L)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableLogicalFlowGraphSummary, immutableLogicalFlowGraphSummary2);
    assertEquals(
        immutableLogicalFlowGraphSummary.hashCode(), immutableLogicalFlowGraphSummary2.hashCode());
  }

  /**
   * Test {@link ImmutableLogicalFlowGraphSummary#equals(Object)}, and {@link
   * ImmutableLogicalFlowGraphSummary#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLogicalFlowGraphSummary#equals(Object)}
   *   <li>{@link ImmutableLogicalFlowGraphSummary#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowGraphSummary.equals(Object)",
    "int ImmutableLogicalFlowGraphSummary.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();

    Builder parentDataTypeResult =
        builderResult.parentDataType(
            ImmutableDataType.builder()
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());
    ImmutableLogicalFlowGraphSummary immutableLogicalFlowGraphSummary =
        parentDataTypeResult
            .startingDataType(
                ImmutableDataType.builder()
                    .code("Code")
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .parentId(1L)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableLogicalFlowGraphSummary, immutableLogicalFlowGraphSummary);
    int expectedHashCodeResult = immutableLogicalFlowGraphSummary.hashCode();
    assertEquals(expectedHashCodeResult, immutableLogicalFlowGraphSummary.hashCode());
  }

  /**
   * Test {@link ImmutableLogicalFlowGraphSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowGraphSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowGraphSummary.equals(Object)",
    "int ImmutableLogicalFlowGraphSummary.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();
    builderResult.putFlowInfoByDirection(FlowDirection.INBOUND, new HashSet<>());

    Builder parentDataTypeResult =
        builderResult.parentDataType(
            ImmutableDataType.builder()
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());
    ImmutableLogicalFlowGraphSummary immutableLogicalFlowGraphSummary =
        parentDataTypeResult
            .startingDataType(
                ImmutableDataType.builder()
                    .code("Code")
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .parentId(1L)
                    .build())
            .build();

    Builder builderResult2 = ImmutableLogicalFlowGraphSummary.builder();

    Builder parentDataTypeResult2 =
        builderResult2.parentDataType(
            ImmutableDataType.builder()
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());

    // Act and Assert
    assertNotEquals(
        immutableLogicalFlowGraphSummary,
        parentDataTypeResult2
            .startingDataType(
                ImmutableDataType.builder()
                    .code("Code")
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .parentId(1L)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableLogicalFlowGraphSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowGraphSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowGraphSummary.equals(Object)",
    "int ImmutableLogicalFlowGraphSummary.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();

    Builder parentDataTypeResult =
        builderResult.parentDataType(
            ImmutableDataType.builder()
                .code("Name")
                .description("The characteristics of someone or something")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());
    ImmutableLogicalFlowGraphSummary immutableLogicalFlowGraphSummary =
        parentDataTypeResult
            .startingDataType(
                ImmutableDataType.builder()
                    .code("Code")
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .parentId(1L)
                    .build())
            .build();

    Builder builderResult2 = ImmutableLogicalFlowGraphSummary.builder();

    Builder parentDataTypeResult2 =
        builderResult2.parentDataType(
            ImmutableDataType.builder()
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());

    // Act and Assert
    assertNotEquals(
        immutableLogicalFlowGraphSummary,
        parentDataTypeResult2
            .startingDataType(
                ImmutableDataType.builder()
                    .code("Code")
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .parentId(1L)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableLogicalFlowGraphSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowGraphSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowGraphSummary.equals(Object)",
    "int ImmutableLogicalFlowGraphSummary.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();

    Builder parentDataTypeResult =
        builderResult.parentDataType(
            ImmutableDataType.builder()
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());
    ImmutableLogicalFlowGraphSummary immutableLogicalFlowGraphSummary =
        parentDataTypeResult
            .startingDataType(
                ImmutableDataType.builder()
                    .code("Name")
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .parentId(1L)
                    .build())
            .build();

    Builder builderResult2 = ImmutableLogicalFlowGraphSummary.builder();

    Builder parentDataTypeResult2 =
        builderResult2.parentDataType(
            ImmutableDataType.builder()
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());

    // Act and Assert
    assertNotEquals(
        immutableLogicalFlowGraphSummary,
        parentDataTypeResult2
            .startingDataType(
                ImmutableDataType.builder()
                    .code("Code")
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .parentId(1L)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableLogicalFlowGraphSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowGraphSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowGraphSummary.equals(Object)",
    "int ImmutableLogicalFlowGraphSummary.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();

    Builder parentDataTypeResult =
        builderResult.parentDataType(
            ImmutableDataType.builder()
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());

    // Act and Assert
    assertNotEquals(
        parentDataTypeResult
            .startingDataType(
                ImmutableDataType.builder()
                    .code("Code")
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .parentId(1L)
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableLogicalFlowGraphSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowGraphSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowGraphSummary.equals(Object)",
    "int ImmutableLogicalFlowGraphSummary.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();

    Builder parentDataTypeResult =
        builderResult.parentDataType(
            ImmutableDataType.builder()
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());

    // Act and Assert
    assertNotEquals(
        parentDataTypeResult
            .startingDataType(
                ImmutableDataType.builder()
                    .code("Code")
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .parentId(1L)
                    .build())
            .build(),
        "Different type to ImmutableLogicalFlowGraphSummary");
  }

  /**
   * Test {@link ImmutableLogicalFlowGraphSummary#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code INBOUND} is {@link HashSet#HashSet()}.
   *   <li>Then return flowInfoByDirection size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowGraphSummary#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashMap() 'INBOUND' is HashSet(); then return flowInfoByDirection size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowGraphSummary ImmutableLogicalFlowGraphSummary.fromJson(Json)"
  })
  void testFromJson_givenHashMapInboundIsHashSet_thenReturnFlowInfoByDirectionSizeIsOne() {
    // Arrange
    HashMap<FlowDirection, Set<FlowInfo>> flowInfoByDirection = new HashMap<>();
    flowInfoByDirection.put(FlowDirection.INBOUND, new HashSet<>());

    Json json = new Json();
    json.setFlowInfoByDirection(flowInfoByDirection);

    // Act
    ImmutableLogicalFlowGraphSummary actualFromJsonResult =
        ImmutableLogicalFlowGraphSummary.fromJson(json);

    // Assert
    Map<FlowDirection, Set<FlowInfo>> flowInfoByDirectionResult =
        actualFromJsonResult.flowInfoByDirection();
    assertEquals(1, flowInfoByDirectionResult.size());
    assertTrue(flowInfoByDirectionResult.get(FlowDirection.INBOUND).isEmpty());
  }

  /**
   * Test {@link ImmutableLogicalFlowGraphSummary#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return parentDataType is {@link Json} (default constructor) {@link
   *       Json#parentDataType}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowGraphSummary#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return parentDataType is Json (default constructor) parentDataType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowGraphSummary ImmutableLogicalFlowGraphSummary.fromJson(Json)"
  })
  void testFromJson_thenReturnParentDataTypeIsJsonParentDataType() {
    // Arrange
    Json json = new Json();
    json.setStartingDataType(null);
    json.setParentDataType(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());
    json.setFlowInfoByDirection(null);

    // Act
    ImmutableLogicalFlowGraphSummary actualFromJsonResult =
        ImmutableLogicalFlowGraphSummary.fromJson(json);

    // Assert
    DataType expectedParentDataTypeResult = json.parentDataType;
    assertSame(expectedParentDataTypeResult, actualFromJsonResult.parentDataType());
  }

  /**
   * Test {@link ImmutableLogicalFlowGraphSummary#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return startingDataType is {@link Json} (default constructor) {@link
   *       Json#startingDataType}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowGraphSummary#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return startingDataType is Json (default constructor) startingDataType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowGraphSummary ImmutableLogicalFlowGraphSummary.fromJson(Json)"
  })
  void testFromJson_thenReturnStartingDataTypeIsJsonStartingDataType() {
    // Arrange
    Json json = new Json();
    json.setStartingDataType(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());
    json.setParentDataType(null);
    json.setFlowInfoByDirection(null);

    // Act
    ImmutableLogicalFlowGraphSummary actualFromJsonResult =
        ImmutableLogicalFlowGraphSummary.fromJson(json);

    // Assert
    DataType expectedStartingDataTypeResult = json.startingDataType;
    assertSame(expectedStartingDataTypeResult, actualFromJsonResult.startingDataType());
  }

  /**
   * Test {@link ImmutableLogicalFlowGraphSummary#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) StartingDataType is {@code null}.
   *   <li>Then return parentDataType is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowGraphSummary#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) StartingDataType is 'null'; then return parentDataType is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowGraphSummary ImmutableLogicalFlowGraphSummary.fromJson(Json)"
  })
  void testFromJson_whenJsonStartingDataTypeIsNull_thenReturnParentDataTypeIsNull() {
    // Arrange
    Json json = new Json();
    json.setStartingDataType(null);
    json.setParentDataType(null);
    json.setFlowInfoByDirection(null);

    // Act
    ImmutableLogicalFlowGraphSummary actualFromJsonResult =
        ImmutableLogicalFlowGraphSummary.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.parentDataType());
    assertNull(actualFromJsonResult.startingDataType());
    assertTrue(actualFromJsonResult.flowInfoByDirection().isEmpty());
  }

  /**
   * Test {@link ImmutableLogicalFlowGraphSummary#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return parentDataType is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowGraphSummary#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return parentDataType is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowGraphSummary ImmutableLogicalFlowGraphSummary.fromJson(Json)"
  })
  void testFromJson_whenJson_thenReturnParentDataTypeIsNull() {
    // Arrange and Act
    ImmutableLogicalFlowGraphSummary actualFromJsonResult =
        ImmutableLogicalFlowGraphSummary.fromJson(new Json());

    // Assert
    assertNull(actualFromJsonResult.parentDataType());
    assertNull(actualFromJsonResult.startingDataType());
    assertTrue(actualFromJsonResult.flowInfoByDirection().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLogicalFlowGraphSummary#toString()}
   *   <li>{@link ImmutableLogicalFlowGraphSummary#flowInfoByDirection()}
   *   <li>{@link ImmutableLogicalFlowGraphSummary#parentDataType()}
   *   <li>{@link ImmutableLogicalFlowGraphSummary#startingDataType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map ImmutableLogicalFlowGraphSummary.flowInfoByDirection()",
    "DataType ImmutableLogicalFlowGraphSummary.parentDataType()",
    "DataType ImmutableLogicalFlowGraphSummary.startingDataType()",
    "String ImmutableLogicalFlowGraphSummary.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();

    Builder parentDataTypeResult =
        builderResult.parentDataType(
            ImmutableDataType.builder()
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());
    ImmutableLogicalFlowGraphSummary immutableLogicalFlowGraphSummary =
        parentDataTypeResult
            .startingDataType(
                ImmutableDataType.builder()
                    .code("Code")
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .parentId(1L)
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableLogicalFlowGraphSummary.toString();
    Map<FlowDirection, Set<FlowInfo>> actualFlowInfoByDirectionResult =
        immutableLogicalFlowGraphSummary.flowInfoByDirection();
    DataType actualParentDataTypeResult = immutableLogicalFlowGraphSummary.parentDataType();
    DataType actualStartingDataTypeResult = immutableLogicalFlowGraphSummary.startingDataType();

    // Assert
    assertTrue(actualParentDataTypeResult instanceof ImmutableDataType);
    assertTrue(actualStartingDataTypeResult instanceof ImmutableDataType);
    assertEquals(
        "LogicalFlowGraphSummary{startingDataType=DataType{name=Name, code=Code, id=1, parentId=1, concrete=true,"
            + " deprecated=false, kind=ALL, unknown=false}, parentDataType=DataType{name=Name, code=Code, id=1,"
            + " parentId=1, concrete=true, deprecated=false, kind=ALL, unknown=false}, flowInfoByDirection={}}",
        actualToStringResult);
    assertTrue(actualFlowInfoByDirectionResult.isEmpty());
    assertEquals(actualParentDataTypeResult, actualStartingDataTypeResult);
  }

  /**
   * Test Json {@link Json#flowInfoByDirection()}.
   *
   * <p>Method under test: {@link Json#flowInfoByDirection()}
   */
  @Test
  @DisplayName("Test Json flowInfoByDirection()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map Json.flowInfoByDirection()"})
  void testJsonFlowInfoByDirection() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().flowInfoByDirection());
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
    assertNull(actualJson.parentDataType);
    assertNull(actualJson.startingDataType);
    assertTrue(actualJson.flowInfoByDirection.isEmpty());
  }

  /**
   * Test Json {@link Json#parentDataType()}.
   *
   * <p>Method under test: {@link Json#parentDataType()}
   */
  @Test
  @DisplayName("Test Json parentDataType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataType Json.parentDataType()"})
  void testJsonParentDataType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().parentDataType());
  }

  /**
   * Test Json {@link Json#startingDataType()}.
   *
   * <p>Method under test: {@link Json#startingDataType()}
   */
  @Test
  @DisplayName("Test Json startingDataType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataType Json.startingDataType()"})
  void testJsonStartingDataType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().startingDataType());
  }

  /**
   * Test {@link ImmutableLogicalFlowGraphSummary#withFlowInfoByDirection(Map)}.
   *
   * <p>Method under test: {@link ImmutableLogicalFlowGraphSummary#withFlowInfoByDirection(Map)}
   */
  @Test
  @DisplayName("Test withFlowInfoByDirection(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowGraphSummary ImmutableLogicalFlowGraphSummary.withFlowInfoByDirection(Map)"
  })
  void testWithFlowInfoByDirection() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();

    Builder parentDataTypeResult =
        builderResult.parentDataType(
            ImmutableDataType.builder()
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());
    ImmutableLogicalFlowGraphSummary immutableLogicalFlowGraphSummary =
        parentDataTypeResult
            .startingDataType(
                ImmutableDataType.builder()
                    .code("Code")
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .parentId(1L)
                    .build())
            .build();

    // Act
    ImmutableLogicalFlowGraphSummary actualWithFlowInfoByDirectionResult =
        immutableLogicalFlowGraphSummary.withFlowInfoByDirection(new HashMap<>());

    // Assert
    assertEquals(immutableLogicalFlowGraphSummary, actualWithFlowInfoByDirectionResult);
  }

  /**
   * Test {@link ImmutableLogicalFlowGraphSummary#withParentDataType(DataType)}.
   *
   * <p>Method under test: {@link ImmutableLogicalFlowGraphSummary#withParentDataType(DataType)}
   */
  @Test
  @DisplayName("Test withParentDataType(DataType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowGraphSummary ImmutableLogicalFlowGraphSummary.withParentDataType(DataType)"
  })
  void testWithParentDataType() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();

    Builder parentDataTypeResult =
        builderResult.parentDataType(
            ImmutableDataType.builder()
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());
    ImmutableLogicalFlowGraphSummary immutableLogicalFlowGraphSummary =
        parentDataTypeResult
            .startingDataType(
                ImmutableDataType.builder()
                    .code("Code")
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .parentId(1L)
                    .build())
            .build();

    // Act
    ImmutableLogicalFlowGraphSummary actualWithParentDataTypeResult =
        immutableLogicalFlowGraphSummary.withParentDataType(
            ImmutableDataType.builder()
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());

    // Assert
    assertEquals(immutableLogicalFlowGraphSummary, actualWithParentDataTypeResult);
  }

  /**
   * Test {@link ImmutableLogicalFlowGraphSummary#withStartingDataType(DataType)}.
   *
   * <p>Method under test: {@link ImmutableLogicalFlowGraphSummary#withStartingDataType(DataType)}
   */
  @Test
  @DisplayName("Test withStartingDataType(DataType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowGraphSummary ImmutableLogicalFlowGraphSummary.withStartingDataType(DataType)"
  })
  void testWithStartingDataType() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowGraphSummary.builder();

    Builder parentDataTypeResult =
        builderResult.parentDataType(
            ImmutableDataType.builder()
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());
    ImmutableLogicalFlowGraphSummary immutableLogicalFlowGraphSummary =
        parentDataTypeResult
            .startingDataType(
                ImmutableDataType.builder()
                    .code("Code")
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .parentId(1L)
                    .build())
            .build();

    // Act
    ImmutableLogicalFlowGraphSummary actualWithStartingDataTypeResult =
        immutableLogicalFlowGraphSummary.withStartingDataType(
            ImmutableDataType.builder()
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());

    // Assert
    assertEquals(immutableLogicalFlowGraphSummary, actualWithStartingDataTypeResult);
  }
}
