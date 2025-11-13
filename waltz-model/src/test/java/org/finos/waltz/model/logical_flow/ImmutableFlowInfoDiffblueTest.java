package org.finos.waltz.model.logical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.logical_flow.ImmutableFlowInfo.Builder;
import org.finos.waltz.model.logical_flow.ImmutableFlowInfo.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableFlowInfoDiffblueTest {
  /**
   * Test Builder {@link Builder#actualDataType(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#actualDataType(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder actualDataType(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.actualDataType(EntityReference)"})
  void testBuilderActualDataType_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();

    // Act
    Builder actualActualDataTypeResult =
        builderResult.actualDataType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualActualDataTypeResult);
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
  @MethodsUnderTest({"ImmutableFlowInfo Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableFlowInfo.builder();
    ImmutableEntityReference actualDataType =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualClassificationIdResult =
        actualBuilderResult.actualDataType(actualDataType).classificationId(1L);
    ImmutableEntityReference counterpart =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualFlowIdResult =
        actualClassificationIdResult
            .counterpart(counterpart)
            .flowEntityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .flowId(1L);
    ImmutableEntityReference rollupDataType =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableFlowInfo actualImmutableFlowInfo =
        actualFlowIdResult.rollupDataType(rollupDataType).build();

    // Assert
    assertEquals(1L, actualImmutableFlowInfo.classificationId().longValue());
    assertEquals(1L, actualImmutableFlowInfo.flowId().longValue());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualImmutableFlowInfo.flowEntityLifecycleStatus());
    assertSame(actualDataType, actualImmutableFlowInfo.actualDataType());
    assertSame(counterpart, actualImmutableFlowInfo.counterpart());
    assertSame(rollupDataType, actualImmutableFlowInfo.rollupDataType());
  }

  /**
   * Test Builder {@link Builder#classificationId(Long)}.
   *
   * <p>Method under test: {@link Builder#classificationId(Long)}
   */
  @Test
  @DisplayName("Test Builder classificationId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.classificationId(Long)"})
  void testBuilderClassificationId() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();

    // Act
    Builder actualClassificationIdResult = builderResult.classificationId(1L);

    // Assert
    assertSame(builderResult, actualClassificationIdResult);
  }

  /**
   * Test Builder {@link Builder#counterpart(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#counterpart(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder counterpart(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.counterpart(EntityReference)"})
  void testBuilderCounterpart_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();

    // Act
    Builder actualCounterpartResult =
        builderResult.counterpart(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualCounterpartResult);
  }

  /**
   * Test Builder {@link Builder#flowEntityLifecycleStatus(EntityLifecycleStatus)}.
   *
   * <p>Method under test: {@link Builder#flowEntityLifecycleStatus(EntityLifecycleStatus)}
   */
  @Test
  @DisplayName("Test Builder flowEntityLifecycleStatus(EntityLifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.flowEntityLifecycleStatus(EntityLifecycleStatus)"})
  void testBuilderFlowEntityLifecycleStatus() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();

    // Act
    Builder actualFlowEntityLifecycleStatusResult =
        builderResult.flowEntityLifecycleStatus(EntityLifecycleStatus.ACTIVE);

    // Assert
    assertSame(builderResult, actualFlowEntityLifecycleStatusResult);
  }

  /**
   * Test Builder {@link Builder#flowId(Long)}.
   *
   * <p>Method under test: {@link Builder#flowId(Long)}
   */
  @Test
  @DisplayName("Test Builder flowId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.flowId(Long)"})
  void testBuilderFlowId() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();

    // Act
    Builder actualFlowIdResult = builderResult.flowId(1L);

    // Assert
    assertSame(builderResult, actualFlowIdResult);
  }

  /**
   * Test Builder {@link Builder#from(FlowInfo)}.
   *
   * <p>Method under test: {@link Builder#from(FlowInfo)}
   */
  @Test
  @DisplayName("Test Builder from(FlowInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowInfo)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();

    Builder builderResult2 = ImmutableFlowInfo.builder();

    Builder classificationIdResult =
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

    Builder flowIdResult =
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
    ImmutableFlowInfo instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableFlowInfo actualImmutableFlowInfo = builderResult.build();
    assertEquals(instance, actualImmutableFlowInfo);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#rollupDataType(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#rollupDataType(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder rollupDataType(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.rollupDataType(EntityReference)"})
  void testBuilderRollupDataType_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();

    // Act
    Builder actualRollupDataTypeResult =
        builderResult.rollupDataType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualRollupDataTypeResult);
  }

  /**
   * Test {@link ImmutableFlowInfo#copyOf(FlowInfo)}.
   *
   * <ul>
   *   <li>Then actualDataType return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowInfo#copyOf(FlowInfo)}
   */
  @Test
  @DisplayName("Test copyOf(FlowInfo); then actualDataType return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowInfo ImmutableFlowInfo.copyOf(FlowInfo)"})
  void testCopyOf_thenActualDataTypeReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();

    Builder classificationIdResult =
        builderResult
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

    Builder flowIdResult =
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
    ImmutableFlowInfo instance =
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
            .build();

    // Act
    ImmutableFlowInfo actualCopyOfResult = ImmutableFlowInfo.copyOf(instance);

    // Assert
    EntityReference actualDataTypeResult = actualCopyOfResult.actualDataType();
    assertTrue(actualDataTypeResult instanceof ImmutableEntityReference);
    EntityReference counterpartResult = actualCopyOfResult.counterpart();
    assertTrue(counterpartResult instanceof ImmutableEntityReference);
    EntityReference rollupDataTypeResult = actualCopyOfResult.rollupDataType();
    assertTrue(rollupDataTypeResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", actualDataTypeResult.description());
    assertEquals(1L, actualCopyOfResult.classificationId().longValue());
    assertEquals(1L, actualCopyOfResult.flowId().longValue());
    assertEquals(1L, actualDataTypeResult.id());
    assertEquals(EntityKind.ALL, actualDataTypeResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualDataTypeResult.entityLifecycleStatus());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.flowEntityLifecycleStatus());
    assertEquals(actualDataTypeResult, counterpartResult);
    assertEquals(actualDataTypeResult, rollupDataTypeResult);
  }

  /**
   * Test {@link ImmutableFlowInfo#equals(Object)}, and {@link ImmutableFlowInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowInfo#equals(Object)}
   *   <li>{@link ImmutableFlowInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowInfo.equals(Object)",
    "int ImmutableFlowInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();

    Builder classificationIdResult =
        builderResult
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

    Builder flowIdResult =
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
    ImmutableFlowInfo immutableFlowInfo =
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
            .build();

    Builder builderResult2 = ImmutableFlowInfo.builder();

    Builder classificationIdResult2 =
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

    Builder flowIdResult2 =
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
    ImmutableFlowInfo immutableFlowInfo2 =
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
            .build();

    // Act and Assert
    assertEquals(immutableFlowInfo, immutableFlowInfo2);
    assertEquals(immutableFlowInfo.hashCode(), immutableFlowInfo2.hashCode());
  }

  /**
   * Test {@link ImmutableFlowInfo#equals(Object)}, and {@link ImmutableFlowInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowInfo#equals(Object)}
   *   <li>{@link ImmutableFlowInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowInfo.equals(Object)",
    "int ImmutableFlowInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();

    Builder classificationIdResult =
        builderResult
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

    Builder flowIdResult =
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
    ImmutableFlowInfo immutableFlowInfo =
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
            .build();

    // Act and Assert
    assertEquals(immutableFlowInfo, immutableFlowInfo);
    int expectedHashCodeResult = immutableFlowInfo.hashCode();
    assertEquals(expectedHashCodeResult, immutableFlowInfo.hashCode());
  }

  /**
   * Test {@link ImmutableFlowInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowInfo.equals(Object)",
    "int ImmutableFlowInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();

    Builder classificationIdResult =
        builderResult
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

    Builder flowIdResult =
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
    ImmutableFlowInfo immutableFlowInfo =
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
            .build();

    Builder builderResult2 = ImmutableFlowInfo.builder();

    Builder classificationIdResult2 =
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

    Builder flowIdResult2 =
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

    // Act and Assert
    assertNotEquals(
        immutableFlowInfo,
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
  }

  /**
   * Test {@link ImmutableFlowInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowInfo.equals(Object)",
    "int ImmutableFlowInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();

    Builder classificationIdResult =
        builderResult
            .actualDataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .classificationId(2L);

    Builder flowIdResult =
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
    ImmutableFlowInfo immutableFlowInfo =
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
            .build();

    Builder builderResult2 = ImmutableFlowInfo.builder();

    Builder classificationIdResult2 =
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

    Builder flowIdResult2 =
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

    // Act and Assert
    assertNotEquals(
        immutableFlowInfo,
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
  }

  /**
   * Test {@link ImmutableFlowInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowInfo.equals(Object)",
    "int ImmutableFlowInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();

    Builder classificationIdResult =
        builderResult
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

    Builder flowIdResult =
        classificationIdResult
            .counterpart(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowEntityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .flowId(1L);
    ImmutableFlowInfo immutableFlowInfo =
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
            .build();

    Builder builderResult2 = ImmutableFlowInfo.builder();

    Builder classificationIdResult2 =
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

    Builder flowIdResult2 =
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

    // Act and Assert
    assertNotEquals(
        immutableFlowInfo,
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
  }

  /**
   * Test {@link ImmutableFlowInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowInfo.equals(Object)",
    "int ImmutableFlowInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();

    Builder classificationIdResult =
        builderResult
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

    Builder flowIdResult =
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
            .flowEntityLifecycleStatus(EntityLifecycleStatus.PENDING)
            .flowId(1L);
    ImmutableFlowInfo immutableFlowInfo =
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
            .build();

    Builder builderResult2 = ImmutableFlowInfo.builder();

    Builder classificationIdResult2 =
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

    Builder flowIdResult2 =
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

    // Act and Assert
    assertNotEquals(
        immutableFlowInfo,
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
  }

  /**
   * Test {@link ImmutableFlowInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowInfo.equals(Object)",
    "int ImmutableFlowInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();

    Builder classificationIdResult =
        builderResult
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

    Builder flowIdResult =
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
            .flowId(2L);
    ImmutableFlowInfo immutableFlowInfo =
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
            .build();

    Builder builderResult2 = ImmutableFlowInfo.builder();

    Builder classificationIdResult2 =
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

    Builder flowIdResult2 =
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

    // Act and Assert
    assertNotEquals(
        immutableFlowInfo,
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
  }

  /**
   * Test {@link ImmutableFlowInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowInfo.equals(Object)",
    "int ImmutableFlowInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();

    Builder classificationIdResult =
        builderResult
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

    Builder flowIdResult =
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
    ImmutableFlowInfo immutableFlowInfo =
        flowIdResult
            .rollupDataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder builderResult2 = ImmutableFlowInfo.builder();

    Builder classificationIdResult2 =
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

    Builder flowIdResult2 =
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

    // Act and Assert
    assertNotEquals(
        immutableFlowInfo,
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
  }

  /**
   * Test {@link ImmutableFlowInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowInfo.equals(Object)",
    "int ImmutableFlowInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();

    Builder classificationIdResult =
        builderResult
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

    Builder flowIdResult =
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

    // Act and Assert
    assertNotEquals(
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
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableFlowInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowInfo.equals(Object)",
    "int ImmutableFlowInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();

    Builder classificationIdResult =
        builderResult
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

    Builder flowIdResult =
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

    // Act and Assert
    assertNotEquals(
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
            .build(),
        "Different type to ImmutableFlowInfo");
  }

  /**
   * Test {@link ImmutableFlowInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return classificationId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowInfo#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return classificationId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowInfo ImmutableFlowInfo.fromJson(Json)"})
  void testFromJson_thenReturnClassificationIdLongValueIsOne() {
    // Arrange
    Json json = new Json();
    json.setClassificationId(1L);
    json.setFlowId(1L);
    json.setFlowEntityLifecycleStatus(EntityLifecycleStatus.ACTIVE);
    json.setCounterpart(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setRollupDataType(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setActualDataType(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    ImmutableFlowInfo actualFromJsonResult = ImmutableFlowInfo.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.classificationId().longValue());
    assertEquals(1L, actualFromJsonResult.flowId().longValue());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualFromJsonResult.flowEntityLifecycleStatus());
    EntityReference expectedActualDataTypeResult = json.actualDataType;
    assertSame(expectedActualDataTypeResult, actualFromJsonResult.actualDataType());
    EntityReference expectedCounterpartResult = json.counterpart;
    assertSame(expectedCounterpartResult, actualFromJsonResult.counterpart());
    EntityReference expectedRollupDataTypeResult = json.rollupDataType;
    assertSame(expectedRollupDataTypeResult, actualFromJsonResult.rollupDataType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowInfo#toString()}
   *   <li>{@link ImmutableFlowInfo#actualDataType()}
   *   <li>{@link ImmutableFlowInfo#classificationId()}
   *   <li>{@link ImmutableFlowInfo#counterpart()}
   *   <li>{@link ImmutableFlowInfo#flowEntityLifecycleStatus()}
   *   <li>{@link ImmutableFlowInfo#flowId()}
   *   <li>{@link ImmutableFlowInfo#rollupDataType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityReference ImmutableFlowInfo.actualDataType()",
    "Long ImmutableFlowInfo.classificationId()",
    "EntityReference ImmutableFlowInfo.counterpart()",
    "EntityLifecycleStatus ImmutableFlowInfo.flowEntityLifecycleStatus()",
    "Long ImmutableFlowInfo.flowId()",
    "EntityReference ImmutableFlowInfo.rollupDataType()",
    "String ImmutableFlowInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();

    Builder classificationIdResult =
        builderResult
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

    Builder flowIdResult =
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
    ImmutableFlowInfo immutableFlowInfo =
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
            .build();

    // Act
    String actualToStringResult = immutableFlowInfo.toString();
    EntityReference actualActualDataTypeResult = immutableFlowInfo.actualDataType();
    Long actualClassificationIdResult = immutableFlowInfo.classificationId();
    EntityReference actualCounterpartResult = immutableFlowInfo.counterpart();
    EntityLifecycleStatus actualFlowEntityLifecycleStatusResult =
        immutableFlowInfo.flowEntityLifecycleStatus();
    Long actualFlowIdResult = immutableFlowInfo.flowId();
    EntityReference actualRollupDataTypeResult = immutableFlowInfo.rollupDataType();

    // Assert
    assertTrue(actualActualDataTypeResult instanceof ImmutableEntityReference);
    assertTrue(actualCounterpartResult instanceof ImmutableEntityReference);
    assertTrue(actualRollupDataTypeResult instanceof ImmutableEntityReference);
    assertEquals(
        "FlowInfo{classificationId=1, flowId=1, flowEntityLifecycleStatus=ACTIVE, counterpart=EntityReference"
            + "{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, rollupDataType=EntityReference{kind=ALL, id=1,"
            + " entityLifecycleStatus=ACTIVE}, actualDataType=EntityReference{kind=ALL, id=1, entityLifecycleStatus"
            + "=ACTIVE}}",
        actualToStringResult);
    assertEquals(1L, actualClassificationIdResult.longValue());
    assertEquals(1L, actualFlowIdResult.longValue());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualFlowEntityLifecycleStatusResult);
    assertEquals(actualActualDataTypeResult, actualCounterpartResult);
    assertEquals(actualActualDataTypeResult, actualRollupDataTypeResult);
  }

  /**
   * Test Json {@link Json#actualDataType()}.
   *
   * <p>Method under test: {@link Json#actualDataType()}
   */
  @Test
  @DisplayName("Test Json actualDataType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.actualDataType()"})
  void testJsonActualDataType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().actualDataType());
  }

  /**
   * Test Json {@link Json#classificationId()}.
   *
   * <p>Method under test: {@link Json#classificationId()}
   */
  @Test
  @DisplayName("Test Json classificationId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.classificationId()"})
  void testJsonClassificationId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().classificationId());
  }

  /**
   * Test Json {@link Json#counterpart()}.
   *
   * <p>Method under test: {@link Json#counterpart()}
   */
  @Test
  @DisplayName("Test Json counterpart()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.counterpart()"})
  void testJsonCounterpart() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().counterpart());
  }

  /**
   * Test Json {@link Json#flowEntityLifecycleStatus()}.
   *
   * <p>Method under test: {@link Json#flowEntityLifecycleStatus()}
   */
  @Test
  @DisplayName("Test Json flowEntityLifecycleStatus()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityLifecycleStatus Json.flowEntityLifecycleStatus()"})
  void testJsonFlowEntityLifecycleStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().flowEntityLifecycleStatus());
  }

  /**
   * Test Json {@link Json#flowId()}.
   *
   * <p>Method under test: {@link Json#flowId()}
   */
  @Test
  @DisplayName("Test Json flowId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.flowId()"})
  void testJsonFlowId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().flowId());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setActualDataType(EntityReference)}
   *   <li>{@link Json#setClassificationId(Long)}
   *   <li>{@link Json#setCounterpart(EntityReference)}
   *   <li>{@link Json#setFlowEntityLifecycleStatus(EntityLifecycleStatus)}
   *   <li>{@link Json#setFlowId(Long)}
   *   <li>{@link Json#setRollupDataType(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setActualDataType(EntityReference)",
    "void Json.setClassificationId(Long)",
    "void Json.setCounterpart(EntityReference)",
    "void Json.setFlowEntityLifecycleStatus(EntityLifecycleStatus)",
    "void Json.setFlowId(Long)",
    "void Json.setRollupDataType(EntityReference)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setActualDataType(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setClassificationId(1L);
    actualJson.setCounterpart(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setFlowEntityLifecycleStatus(EntityLifecycleStatus.ACTIVE);
    actualJson.setFlowId(1L);
    actualJson.setRollupDataType(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Assert
    assertEquals(1L, actualJson.classificationId.longValue());
    assertEquals(1L, actualJson.flowId.longValue());
  }

  /**
   * Test Json {@link Json#rollupDataType()}.
   *
   * <p>Method under test: {@link Json#rollupDataType()}
   */
  @Test
  @DisplayName("Test Json rollupDataType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.rollupDataType()"})
  void testJsonRollupDataType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().rollupDataType());
  }

  /**
   * Test {@link ImmutableFlowInfo#withActualDataType(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableFlowInfo#withActualDataType(EntityReference)}
   */
  @Test
  @DisplayName("Test withActualDataType(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowInfo ImmutableFlowInfo.withActualDataType(EntityReference)"})
  void testWithActualDataType() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();

    Builder classificationIdResult =
        builderResult
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

    Builder flowIdResult =
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
    ImmutableFlowInfo immutableFlowInfo =
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
            .build();

    // Act
    ImmutableFlowInfo actualWithActualDataTypeResult =
        immutableFlowInfo.withActualDataType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableFlowInfo, actualWithActualDataTypeResult);
  }

  /**
   * Test {@link ImmutableFlowInfo#withClassificationId(Long)}.
   *
   * <p>Method under test: {@link ImmutableFlowInfo#withClassificationId(Long)}
   */
  @Test
  @DisplayName("Test withClassificationId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowInfo ImmutableFlowInfo.withClassificationId(Long)"})
  void testWithClassificationId() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();

    Builder classificationIdResult =
        builderResult
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

    Builder flowIdResult =
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
    ImmutableFlowInfo immutableFlowInfo =
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
            .build();

    // Act
    ImmutableFlowInfo actualWithClassificationIdResult = immutableFlowInfo.withClassificationId(1L);

    // Assert
    assertSame(immutableFlowInfo, actualWithClassificationIdResult);
  }

  /**
   * Test {@link ImmutableFlowInfo#withClassificationId(Long)}.
   *
   * <ul>
   *   <li>Then actualDataType return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowInfo#withClassificationId(Long)}
   */
  @Test
  @DisplayName(
      "Test withClassificationId(Long); then actualDataType return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowInfo ImmutableFlowInfo.withClassificationId(Long)"})
  void testWithClassificationId_thenActualDataTypeReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();

    Builder classificationIdResult =
        builderResult
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

    Builder flowIdResult =
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

    // Act
    ImmutableFlowInfo actualWithClassificationIdResult =
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
            .build()
            .withClassificationId(42L);

    // Assert
    EntityReference actualDataTypeResult = actualWithClassificationIdResult.actualDataType();
    assertTrue(actualDataTypeResult instanceof ImmutableEntityReference);
    EntityReference counterpartResult = actualWithClassificationIdResult.counterpart();
    assertTrue(counterpartResult instanceof ImmutableEntityReference);
    EntityReference rollupDataTypeResult = actualWithClassificationIdResult.rollupDataType();
    assertTrue(rollupDataTypeResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", actualDataTypeResult.description());
    assertEquals(1L, actualWithClassificationIdResult.flowId().longValue());
    assertEquals(1L, actualDataTypeResult.id());
    assertEquals(42L, actualWithClassificationIdResult.classificationId().longValue());
    assertEquals(EntityKind.ALL, actualDataTypeResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualDataTypeResult.entityLifecycleStatus());
    assertEquals(
        EntityLifecycleStatus.ACTIVE, actualWithClassificationIdResult.flowEntityLifecycleStatus());
    assertEquals(actualDataTypeResult, counterpartResult);
    assertEquals(actualDataTypeResult, rollupDataTypeResult);
  }

  /**
   * Test {@link ImmutableFlowInfo#withCounterpart(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableFlowInfo#withCounterpart(EntityReference)}
   */
  @Test
  @DisplayName("Test withCounterpart(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowInfo ImmutableFlowInfo.withCounterpart(EntityReference)"})
  void testWithCounterpart() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();

    Builder classificationIdResult =
        builderResult
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

    Builder flowIdResult =
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
    ImmutableFlowInfo immutableFlowInfo =
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
            .build();

    // Act
    ImmutableFlowInfo actualWithCounterpartResult =
        immutableFlowInfo.withCounterpart(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableFlowInfo, actualWithCounterpartResult);
  }

  /**
   * Test {@link ImmutableFlowInfo#withFlowEntityLifecycleStatus(EntityLifecycleStatus)}.
   *
   * <p>Method under test: {@link
   * ImmutableFlowInfo#withFlowEntityLifecycleStatus(EntityLifecycleStatus)}
   */
  @Test
  @DisplayName("Test withFlowEntityLifecycleStatus(EntityLifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowInfo ImmutableFlowInfo.withFlowEntityLifecycleStatus(EntityLifecycleStatus)"
  })
  void testWithFlowEntityLifecycleStatus() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();

    Builder classificationIdResult =
        builderResult
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

    Builder flowIdResult =
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
    ImmutableFlowInfo immutableFlowInfo =
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
            .build();

    // Act
    ImmutableFlowInfo actualWithFlowEntityLifecycleStatusResult =
        immutableFlowInfo.withFlowEntityLifecycleStatus(EntityLifecycleStatus.ACTIVE);

    // Assert
    assertSame(immutableFlowInfo, actualWithFlowEntityLifecycleStatusResult);
  }

  /**
   * Test {@link ImmutableFlowInfo#withFlowEntityLifecycleStatus(EntityLifecycleStatus)}.
   *
   * <p>Method under test: {@link
   * ImmutableFlowInfo#withFlowEntityLifecycleStatus(EntityLifecycleStatus)}
   */
  @Test
  @DisplayName("Test withFlowEntityLifecycleStatus(EntityLifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowInfo ImmutableFlowInfo.withFlowEntityLifecycleStatus(EntityLifecycleStatus)"
  })
  void testWithFlowEntityLifecycleStatus2() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();

    Builder classificationIdResult =
        builderResult
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

    Builder flowIdResult =
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
            .flowEntityLifecycleStatus(EntityLifecycleStatus.PENDING)
            .flowId(1L);

    // Act
    ImmutableFlowInfo actualWithFlowEntityLifecycleStatusResult =
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
            .build()
            .withFlowEntityLifecycleStatus(EntityLifecycleStatus.ACTIVE);

    // Assert
    EntityReference actualDataTypeResult =
        actualWithFlowEntityLifecycleStatusResult.actualDataType();
    assertTrue(actualDataTypeResult instanceof ImmutableEntityReference);
    EntityReference counterpartResult = actualWithFlowEntityLifecycleStatusResult.counterpart();
    assertTrue(counterpartResult instanceof ImmutableEntityReference);
    EntityReference rollupDataTypeResult =
        actualWithFlowEntityLifecycleStatusResult.rollupDataType();
    assertTrue(rollupDataTypeResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", actualDataTypeResult.description());
    assertEquals(1L, actualWithFlowEntityLifecycleStatusResult.classificationId().longValue());
    assertEquals(1L, actualWithFlowEntityLifecycleStatusResult.flowId().longValue());
    assertEquals(1L, actualDataTypeResult.id());
    assertEquals(EntityKind.ALL, actualDataTypeResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualDataTypeResult.entityLifecycleStatus());
    assertEquals(
        EntityLifecycleStatus.ACTIVE,
        actualWithFlowEntityLifecycleStatusResult.flowEntityLifecycleStatus());
    assertEquals(actualDataTypeResult, counterpartResult);
    assertEquals(actualDataTypeResult, rollupDataTypeResult);
  }

  /**
   * Test {@link ImmutableFlowInfo#withFlowId(Long)}.
   *
   * <p>Method under test: {@link ImmutableFlowInfo#withFlowId(Long)}
   */
  @Test
  @DisplayName("Test withFlowId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowInfo ImmutableFlowInfo.withFlowId(Long)"})
  void testWithFlowId() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();

    Builder classificationIdResult =
        builderResult
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

    Builder flowIdResult =
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
    ImmutableFlowInfo immutableFlowInfo =
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
            .build();

    // Act
    ImmutableFlowInfo actualWithFlowIdResult = immutableFlowInfo.withFlowId(1L);

    // Assert
    assertSame(immutableFlowInfo, actualWithFlowIdResult);
  }

  /**
   * Test {@link ImmutableFlowInfo#withFlowId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then actualDataType return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowInfo#withFlowId(Long)}
   */
  @Test
  @DisplayName(
      "Test withFlowId(Long); when forty-two; then actualDataType return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowInfo ImmutableFlowInfo.withFlowId(Long)"})
  void testWithFlowId_whenFortyTwo_thenActualDataTypeReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();

    Builder classificationIdResult =
        builderResult
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

    Builder flowIdResult =
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

    // Act
    ImmutableFlowInfo actualWithFlowIdResult =
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
            .build()
            .withFlowId(42L);

    // Assert
    EntityReference actualDataTypeResult = actualWithFlowIdResult.actualDataType();
    assertTrue(actualDataTypeResult instanceof ImmutableEntityReference);
    EntityReference counterpartResult = actualWithFlowIdResult.counterpart();
    assertTrue(counterpartResult instanceof ImmutableEntityReference);
    EntityReference rollupDataTypeResult = actualWithFlowIdResult.rollupDataType();
    assertTrue(rollupDataTypeResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", actualDataTypeResult.description());
    assertEquals(1L, actualWithFlowIdResult.classificationId().longValue());
    assertEquals(1L, actualDataTypeResult.id());
    assertEquals(42L, actualWithFlowIdResult.flowId().longValue());
    assertEquals(EntityKind.ALL, actualDataTypeResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualDataTypeResult.entityLifecycleStatus());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithFlowIdResult.flowEntityLifecycleStatus());
    assertEquals(actualDataTypeResult, counterpartResult);
    assertEquals(actualDataTypeResult, rollupDataTypeResult);
  }

  /**
   * Test {@link ImmutableFlowInfo#withRollupDataType(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableFlowInfo#withRollupDataType(EntityReference)}
   */
  @Test
  @DisplayName("Test withRollupDataType(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowInfo ImmutableFlowInfo.withRollupDataType(EntityReference)"})
  void testWithRollupDataType() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();

    Builder classificationIdResult =
        builderResult
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

    Builder flowIdResult =
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
    ImmutableFlowInfo immutableFlowInfo =
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
            .build();

    // Act
    ImmutableFlowInfo actualWithRollupDataTypeResult =
        immutableFlowInfo.withRollupDataType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableFlowInfo, actualWithRollupDataTypeResult);
  }
}
