package org.finos.waltz.jobs.harness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.jobs.harness.FlowClassificationRule2Harness.FlowDataType;
import org.finos.waltz.jobs.harness.ImmutableFlowDataType.Builder;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableFlowDataTypeDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#inboundRuleId(Long)}
   *   <li>{@link Builder#outboundRuleId(Long)}
   *   <li>{@link Builder#sourceOuId(Long)}
   *   <li>{@link Builder#targetOuId(Long)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDataType Builder.build()",
    "Builder Builder.inboundRuleId(Long)",
    "Builder Builder.outboundRuleId(Long)",
    "Builder Builder.sourceOuId(Long)",
    "Builder Builder.targetOuId(Long)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualOutboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);
    ImmutableEntityReference source =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualSourceOuIdResult = actualOutboundRuleIdResult.source(source).sourceOuId(1L);
    ImmutableEntityReference target =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableFlowDataType actualImmutableFlowDataType =
        actualSourceOuIdResult.target(target).targetOuId(1L).build();

    // Assert
    assertEquals(1L, actualImmutableFlowDataType.inboundRuleId().longValue());
    assertEquals(1L, actualImmutableFlowDataType.outboundRuleId().longValue());
    assertEquals(1L, actualImmutableFlowDataType.sourceOuId().longValue());
    assertEquals(1L, actualImmutableFlowDataType.targetOuId().longValue());
    assertEquals(1L, actualImmutableFlowDataType.dtId());
    assertEquals(1L, actualImmutableFlowDataType.lfId());
    assertEquals(1L, actualImmutableFlowDataType.lfdId());
    assertSame(source, actualImmutableFlowDataType.source());
    assertSame(target, actualImmutableFlowDataType.target());
  }

  /**
   * Test Builder {@link Builder#dtId(long)}.
   *
   * <p>Method under test: {@link Builder#dtId(long)}
   */
  @Test
  @DisplayName("Test Builder dtId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.dtId(long)"})
  void testBuilderDtId() {
    // Arrange
    Builder builderResult = ImmutableFlowDataType.builder();

    // Act
    Builder actualDtIdResult = builderResult.dtId(1L);

    // Assert
    assertSame(builderResult, actualDtIdResult);
  }

  /**
   * Test Builder {@link Builder#from(FlowDataType)}.
   *
   * <p>Method under test: {@link Builder#from(FlowDataType)}
   */
  @Test
  @DisplayName("Test Builder from(FlowDataType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowDataType)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableFlowDataType.builder();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);
    ImmutableFlowDataType instance =
        sourceOuIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build();

    // Act and Assert
    ImmutableFlowDataType actualImmutableFlowDataType = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableFlowDataType);
    ImmutableFlowDataType actualImmutableFlowDataType2 = builderResult.build();
    assertEquals(instance, actualImmutableFlowDataType2);
  }

  /**
   * Test Builder {@link Builder#from(FlowDataType)}.
   *
   * <p>Method under test: {@link Builder#from(FlowDataType)}
   */
  @Test
  @DisplayName("Test Builder from(FlowDataType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowDataType)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableFlowDataType.builder();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(null)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);
    ImmutableFlowDataType instance =
        sourceOuIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build();

    // Act and Assert
    ImmutableFlowDataType actualImmutableFlowDataType = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableFlowDataType);
    ImmutableFlowDataType actualImmutableFlowDataType2 = builderResult.build();
    assertEquals(instance, actualImmutableFlowDataType2);
  }

  /**
   * Test Builder {@link Builder#from(FlowDataType)}.
   *
   * <p>Method under test: {@link Builder#from(FlowDataType)}
   */
  @Test
  @DisplayName("Test Builder from(FlowDataType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowDataType)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutableFlowDataType.builder();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(null);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);
    ImmutableFlowDataType instance =
        sourceOuIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build();

    // Act and Assert
    ImmutableFlowDataType actualImmutableFlowDataType = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableFlowDataType);
    ImmutableFlowDataType actualImmutableFlowDataType2 = builderResult.build();
    assertEquals(instance, actualImmutableFlowDataType2);
  }

  /**
   * Test Builder {@link Builder#from(FlowDataType)}.
   *
   * <p>Method under test: {@link Builder#from(FlowDataType)}
   */
  @Test
  @DisplayName("Test Builder from(FlowDataType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowDataType)"})
  void testBuilderFrom4() {
    // Arrange
    Builder builderResult = ImmutableFlowDataType.builder();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(null);
    ImmutableFlowDataType instance =
        sourceOuIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build();

    // Act and Assert
    ImmutableFlowDataType actualImmutableFlowDataType = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableFlowDataType);
    ImmutableFlowDataType actualImmutableFlowDataType2 = builderResult.build();
    assertEquals(instance, actualImmutableFlowDataType2);
  }

  /**
   * Test Builder {@link Builder#from(FlowDataType)}.
   *
   * <p>Method under test: {@link Builder#from(FlowDataType)}
   */
  @Test
  @DisplayName("Test Builder from(FlowDataType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowDataType)"})
  void testBuilderFrom5() {
    // Arrange
    Builder builderResult = ImmutableFlowDataType.builder();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);
    ImmutableFlowDataType instance =
        sourceOuIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(null)
            .build();

    // Act and Assert
    ImmutableFlowDataType actualImmutableFlowDataType = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableFlowDataType);
    ImmutableFlowDataType actualImmutableFlowDataType2 = builderResult.build();
    assertEquals(instance, actualImmutableFlowDataType2);
  }

  /**
   * Test Builder {@link Builder#lfId(long)}.
   *
   * <p>Method under test: {@link Builder#lfId(long)}
   */
  @Test
  @DisplayName("Test Builder lfId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.lfId(long)"})
  void testBuilderLfId() {
    // Arrange
    Builder builderResult = ImmutableFlowDataType.builder();

    // Act
    Builder actualLfIdResult = builderResult.lfId(1L);

    // Assert
    assertSame(builderResult, actualLfIdResult);
  }

  /**
   * Test Builder {@link Builder#lfdId(long)}.
   *
   * <p>Method under test: {@link Builder#lfdId(long)}
   */
  @Test
  @DisplayName("Test Builder lfdId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.lfdId(long)"})
  void testBuilderLfdId() {
    // Arrange
    Builder builderResult = ImmutableFlowDataType.builder();

    // Act
    Builder actualLfdIdResult = builderResult.lfdId(1L);

    // Assert
    assertSame(builderResult, actualLfdIdResult);
  }

  /**
   * Test Builder {@link Builder#source(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#source(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder source(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.source(EntityReference)"})
  void testBuilderSource_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowDataType.builder();

    // Act
    Builder actualSourceResult =
        builderResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualSourceResult);
  }

  /**
   * Test Builder {@link Builder#target(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#target(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder target(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.target(EntityReference)"})
  void testBuilderTarget_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowDataType.builder();

    // Act
    Builder actualTargetResult =
        builderResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualTargetResult);
  }

  /**
   * Test {@link ImmutableFlowDataType#copyOf(FlowDataType)}.
   *
   * <ul>
   *   <li>Then source return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDataType#copyOf(FlowDataType)}
   */
  @Test
  @DisplayName("Test copyOf(FlowDataType); then source return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDataType ImmutableFlowDataType.copyOf(FlowDataType)"})
  void testCopyOf_thenSourceReturnImmutableEntityReference() {
    // Arrange
    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);
    ImmutableFlowDataType instance =
        sourceOuIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build();

    // Act
    ImmutableFlowDataType actualCopyOfResult = ImmutableFlowDataType.copyOf(instance);

    // Assert
    EntityReference sourceResult = actualCopyOfResult.source();
    assertTrue(sourceResult instanceof ImmutableEntityReference);
    EntityReference targetResult = actualCopyOfResult.target();
    assertTrue(targetResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", sourceResult.description());
    assertEquals(1L, actualCopyOfResult.inboundRuleId().longValue());
    assertEquals(1L, actualCopyOfResult.outboundRuleId().longValue());
    assertEquals(1L, actualCopyOfResult.sourceOuId().longValue());
    assertEquals(1L, actualCopyOfResult.targetOuId().longValue());
    assertEquals(1L, actualCopyOfResult.dtId());
    assertEquals(1L, actualCopyOfResult.lfId());
    assertEquals(1L, actualCopyOfResult.lfdId());
    assertEquals(1L, sourceResult.id());
    assertEquals(EntityKind.ALL, sourceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, sourceResult.entityLifecycleStatus());
    assertEquals(sourceResult, targetResult);
  }

  /**
   * Test {@link ImmutableFlowDataType#equals(Object)}, and {@link
   * ImmutableFlowDataType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowDataType#equals(Object)}
   *   <li>{@link ImmutableFlowDataType#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDataType.equals(Object)",
    "int ImmutableFlowDataType.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);
    ImmutableFlowDataType immutableFlowDataType =
        sourceOuIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build();

    Builder outboundRuleIdResult2 =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult2 =
        outboundRuleIdResult2
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);
    ImmutableFlowDataType immutableFlowDataType2 =
        sourceOuIdResult2
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableFlowDataType, immutableFlowDataType2);
    assertEquals(immutableFlowDataType.hashCode(), immutableFlowDataType2.hashCode());
  }

  /**
   * Test {@link ImmutableFlowDataType#equals(Object)}, and {@link
   * ImmutableFlowDataType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowDataType#equals(Object)}
   *   <li>{@link ImmutableFlowDataType#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDataType.equals(Object)",
    "int ImmutableFlowDataType.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);
    ImmutableFlowDataType immutableFlowDataType =
        sourceOuIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableFlowDataType, immutableFlowDataType);
    int expectedHashCodeResult = immutableFlowDataType.hashCode();
    assertEquals(expectedHashCodeResult, immutableFlowDataType.hashCode());
  }

  /**
   * Test {@link ImmutableFlowDataType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDataType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDataType.equals(Object)",
    "int ImmutableFlowDataType.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(2L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);
    ImmutableFlowDataType immutableFlowDataType =
        sourceOuIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build();

    Builder outboundRuleIdResult2 =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult2 =
        outboundRuleIdResult2
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    // Act and Assert
    assertNotEquals(
        immutableFlowDataType,
        sourceOuIdResult2
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableFlowDataType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDataType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDataType.equals(Object)",
    "int ImmutableFlowDataType.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(2L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);
    ImmutableFlowDataType immutableFlowDataType =
        sourceOuIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build();

    Builder outboundRuleIdResult2 =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult2 =
        outboundRuleIdResult2
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    // Act and Assert
    assertNotEquals(
        immutableFlowDataType,
        sourceOuIdResult2
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableFlowDataType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDataType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDataType.equals(Object)",
    "int ImmutableFlowDataType.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(2L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);
    ImmutableFlowDataType immutableFlowDataType =
        sourceOuIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build();

    Builder outboundRuleIdResult2 =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult2 =
        outboundRuleIdResult2
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    // Act and Assert
    assertNotEquals(
        immutableFlowDataType,
        sourceOuIdResult2
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableFlowDataType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDataType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDataType.equals(Object)",
    "int ImmutableFlowDataType.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(2L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);
    ImmutableFlowDataType immutableFlowDataType =
        sourceOuIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build();

    Builder outboundRuleIdResult2 =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult2 =
        outboundRuleIdResult2
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    // Act and Assert
    assertNotEquals(
        immutableFlowDataType,
        sourceOuIdResult2
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableFlowDataType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDataType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDataType.equals(Object)",
    "int ImmutableFlowDataType.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(2L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);
    ImmutableFlowDataType immutableFlowDataType =
        sourceOuIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build();

    Builder outboundRuleIdResult2 =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult2 =
        outboundRuleIdResult2
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    // Act and Assert
    assertNotEquals(
        immutableFlowDataType,
        sourceOuIdResult2
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableFlowDataType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDataType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDataType.equals(Object)",
    "int ImmutableFlowDataType.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);
    ImmutableFlowDataType immutableFlowDataType =
        sourceOuIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build();

    Builder outboundRuleIdResult2 =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult2 =
        outboundRuleIdResult2
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    // Act and Assert
    assertNotEquals(
        immutableFlowDataType,
        sourceOuIdResult2
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableFlowDataType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDataType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDataType.equals(Object)",
    "int ImmutableFlowDataType.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(2L);
    ImmutableFlowDataType immutableFlowDataType =
        sourceOuIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build();

    Builder outboundRuleIdResult2 =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult2 =
        outboundRuleIdResult2
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    // Act and Assert
    assertNotEquals(
        immutableFlowDataType,
        sourceOuIdResult2
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableFlowDataType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDataType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDataType.equals(Object)",
    "int ImmutableFlowDataType.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);
    ImmutableFlowDataType immutableFlowDataType =
        sourceOuIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build();

    Builder outboundRuleIdResult2 =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult2 =
        outboundRuleIdResult2
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    // Act and Assert
    assertNotEquals(
        immutableFlowDataType,
        sourceOuIdResult2
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableFlowDataType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDataType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDataType.equals(Object)",
    "int ImmutableFlowDataType.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);
    ImmutableFlowDataType immutableFlowDataType =
        sourceOuIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(2L)
            .build();

    Builder outboundRuleIdResult2 =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult2 =
        outboundRuleIdResult2
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    // Act and Assert
    assertNotEquals(
        immutableFlowDataType,
        sourceOuIdResult2
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableFlowDataType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDataType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDataType.equals(Object)",
    "int ImmutableFlowDataType.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    // Act and Assert
    assertNotEquals(
        sourceOuIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableFlowDataType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDataType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDataType.equals(Object)",
    "int ImmutableFlowDataType.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    // Act and Assert
    assertNotEquals(
        sourceOuIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build(),
        "Different type to ImmutableFlowDataType");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowDataType#toString()}
   *   <li>{@link ImmutableFlowDataType#dtId()}
   *   <li>{@link ImmutableFlowDataType#inboundRuleId()}
   *   <li>{@link ImmutableFlowDataType#lfId()}
   *   <li>{@link ImmutableFlowDataType#lfdId()}
   *   <li>{@link ImmutableFlowDataType#outboundRuleId()}
   *   <li>{@link ImmutableFlowDataType#source()}
   *   <li>{@link ImmutableFlowDataType#sourceOuId()}
   *   <li>{@link ImmutableFlowDataType#target()}
   *   <li>{@link ImmutableFlowDataType#targetOuId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long ImmutableFlowDataType.dtId()",
    "Long ImmutableFlowDataType.inboundRuleId()",
    "long ImmutableFlowDataType.lfId()",
    "long ImmutableFlowDataType.lfdId()",
    "Long ImmutableFlowDataType.outboundRuleId()",
    "EntityReference ImmutableFlowDataType.source()",
    "Long ImmutableFlowDataType.sourceOuId()",
    "EntityReference ImmutableFlowDataType.target()",
    "Long ImmutableFlowDataType.targetOuId()",
    "String ImmutableFlowDataType.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);
    ImmutableFlowDataType immutableFlowDataType =
        sourceOuIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build();

    // Act
    String actualToStringResult = immutableFlowDataType.toString();
    long actualDtIdResult = immutableFlowDataType.dtId();
    Long actualInboundRuleIdResult = immutableFlowDataType.inboundRuleId();
    long actualLfIdResult = immutableFlowDataType.lfId();
    long actualLfdIdResult = immutableFlowDataType.lfdId();
    Long actualOutboundRuleIdResult = immutableFlowDataType.outboundRuleId();
    EntityReference actualSourceResult = immutableFlowDataType.source();
    Long actualSourceOuIdResult = immutableFlowDataType.sourceOuId();
    EntityReference actualTargetResult = immutableFlowDataType.target();
    Long actualTargetOuIdResult = immutableFlowDataType.targetOuId();

    // Assert
    assertTrue(actualSourceResult instanceof ImmutableEntityReference);
    assertTrue(actualTargetResult instanceof ImmutableEntityReference);
    assertEquals(
        "FlowDataType{source=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, target=EntityReference"
            + "{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, sourceOuId=1, targetOuId=1, lfId=1, lfdId=1, dtId=1,"
            + " outboundRuleId=1, inboundRuleId=1}",
        actualToStringResult);
    assertEquals(1L, actualInboundRuleIdResult.longValue());
    assertEquals(1L, actualOutboundRuleIdResult.longValue());
    assertEquals(1L, actualSourceOuIdResult.longValue());
    assertEquals(1L, actualTargetOuIdResult.longValue());
    assertEquals(1L, actualDtIdResult);
    assertEquals(1L, actualLfIdResult);
    assertEquals(1L, actualLfdIdResult);
    assertEquals(actualSourceResult, actualTargetResult);
  }

  /**
   * Test {@link ImmutableFlowDataType#withDtId(long)}.
   *
   * <p>Method under test: {@link ImmutableFlowDataType#withDtId(long)}
   */
  @Test
  @DisplayName("Test withDtId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDataType ImmutableFlowDataType.withDtId(long)"})
  void testWithDtId() {
    // Arrange
    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(42L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);
    ImmutableFlowDataType immutableFlowDataType =
        sourceOuIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build();

    // Act
    ImmutableFlowDataType actualWithDtIdResult = immutableFlowDataType.withDtId(42L);

    // Assert
    assertSame(immutableFlowDataType, actualWithDtIdResult);
  }

  /**
   * Test {@link ImmutableFlowDataType#withDtId(long)}.
   *
   * <ul>
   *   <li>Then source return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDataType#withDtId(long)}
   */
  @Test
  @DisplayName("Test withDtId(long); then source return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDataType ImmutableFlowDataType.withDtId(long)"})
  void testWithDtId_thenSourceReturnImmutableEntityReference() {
    // Arrange
    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    // Act
    ImmutableFlowDataType actualWithDtIdResult =
        sourceOuIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build()
            .withDtId(42L);

    // Assert
    EntityReference sourceResult = actualWithDtIdResult.source();
    assertTrue(sourceResult instanceof ImmutableEntityReference);
    EntityReference targetResult = actualWithDtIdResult.target();
    assertTrue(targetResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", sourceResult.description());
    assertEquals(1L, sourceResult.id());
    assertEquals(EntityKind.ALL, sourceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, sourceResult.entityLifecycleStatus());
    assertEquals(sourceResult, targetResult);
  }

  /**
   * Test {@link ImmutableFlowDataType#withInboundRuleId(Long)}.
   *
   * <p>Method under test: {@link ImmutableFlowDataType#withInboundRuleId(Long)}
   */
  @Test
  @DisplayName("Test withInboundRuleId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDataType ImmutableFlowDataType.withInboundRuleId(Long)"})
  void testWithInboundRuleId() {
    // Arrange
    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);
    ImmutableFlowDataType immutableFlowDataType =
        sourceOuIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build();

    // Act
    ImmutableFlowDataType actualWithInboundRuleIdResult =
        immutableFlowDataType.withInboundRuleId(1L);

    // Assert
    assertSame(immutableFlowDataType, actualWithInboundRuleIdResult);
  }

  /**
   * Test {@link ImmutableFlowDataType#withInboundRuleId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then source return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDataType#withInboundRuleId(Long)}
   */
  @Test
  @DisplayName(
      "Test withInboundRuleId(Long); when forty-two; then source return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDataType ImmutableFlowDataType.withInboundRuleId(Long)"})
  void testWithInboundRuleId_whenFortyTwo_thenSourceReturnImmutableEntityReference() {
    // Arrange
    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    // Act
    ImmutableFlowDataType actualWithInboundRuleIdResult =
        sourceOuIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build()
            .withInboundRuleId(42L);

    // Assert
    EntityReference sourceResult = actualWithInboundRuleIdResult.source();
    assertTrue(sourceResult instanceof ImmutableEntityReference);
    EntityReference targetResult = actualWithInboundRuleIdResult.target();
    assertTrue(targetResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", sourceResult.description());
    assertEquals(1L, sourceResult.id());
    assertEquals(42L, actualWithInboundRuleIdResult.inboundRuleId().longValue());
    assertEquals(EntityKind.ALL, sourceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, sourceResult.entityLifecycleStatus());
    assertEquals(sourceResult, targetResult);
  }

  /**
   * Test {@link ImmutableFlowDataType#withLfId(long)}.
   *
   * <p>Method under test: {@link ImmutableFlowDataType#withLfId(long)}
   */
  @Test
  @DisplayName("Test withLfId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDataType ImmutableFlowDataType.withLfId(long)"})
  void testWithLfId() {
    // Arrange
    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(42L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);
    ImmutableFlowDataType immutableFlowDataType =
        sourceOuIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build();

    // Act
    ImmutableFlowDataType actualWithLfIdResult = immutableFlowDataType.withLfId(42L);

    // Assert
    assertSame(immutableFlowDataType, actualWithLfIdResult);
  }

  /**
   * Test {@link ImmutableFlowDataType#withLfId(long)}.
   *
   * <ul>
   *   <li>Then source return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDataType#withLfId(long)}
   */
  @Test
  @DisplayName("Test withLfId(long); then source return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDataType ImmutableFlowDataType.withLfId(long)"})
  void testWithLfId_thenSourceReturnImmutableEntityReference() {
    // Arrange
    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    // Act
    ImmutableFlowDataType actualWithLfIdResult =
        sourceOuIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build()
            .withLfId(42L);

    // Assert
    EntityReference sourceResult = actualWithLfIdResult.source();
    assertTrue(sourceResult instanceof ImmutableEntityReference);
    EntityReference targetResult = actualWithLfIdResult.target();
    assertTrue(targetResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", sourceResult.description());
    assertEquals(1L, sourceResult.id());
    assertEquals(EntityKind.ALL, sourceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, sourceResult.entityLifecycleStatus());
    assertEquals(sourceResult, targetResult);
  }

  /**
   * Test {@link ImmutableFlowDataType#withLfdId(long)}.
   *
   * <p>Method under test: {@link ImmutableFlowDataType#withLfdId(long)}
   */
  @Test
  @DisplayName("Test withLfdId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDataType ImmutableFlowDataType.withLfdId(long)"})
  void testWithLfdId() {
    // Arrange
    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(42L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);
    ImmutableFlowDataType immutableFlowDataType =
        sourceOuIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build();

    // Act
    ImmutableFlowDataType actualWithLfdIdResult = immutableFlowDataType.withLfdId(42L);

    // Assert
    assertSame(immutableFlowDataType, actualWithLfdIdResult);
  }

  /**
   * Test {@link ImmutableFlowDataType#withLfdId(long)}.
   *
   * <ul>
   *   <li>Then source return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDataType#withLfdId(long)}
   */
  @Test
  @DisplayName("Test withLfdId(long); then source return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDataType ImmutableFlowDataType.withLfdId(long)"})
  void testWithLfdId_thenSourceReturnImmutableEntityReference() {
    // Arrange
    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    // Act
    ImmutableFlowDataType actualWithLfdIdResult =
        sourceOuIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build()
            .withLfdId(42L);

    // Assert
    EntityReference sourceResult = actualWithLfdIdResult.source();
    assertTrue(sourceResult instanceof ImmutableEntityReference);
    EntityReference targetResult = actualWithLfdIdResult.target();
    assertTrue(targetResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", sourceResult.description());
    assertEquals(1L, sourceResult.id());
    assertEquals(EntityKind.ALL, sourceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, sourceResult.entityLifecycleStatus());
    assertEquals(sourceResult, targetResult);
  }

  /**
   * Test {@link ImmutableFlowDataType#withOutboundRuleId(Long)}.
   *
   * <p>Method under test: {@link ImmutableFlowDataType#withOutboundRuleId(Long)}
   */
  @Test
  @DisplayName("Test withOutboundRuleId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDataType ImmutableFlowDataType.withOutboundRuleId(Long)"})
  void testWithOutboundRuleId() {
    // Arrange
    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);
    ImmutableFlowDataType immutableFlowDataType =
        sourceOuIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build();

    // Act
    ImmutableFlowDataType actualWithOutboundRuleIdResult =
        immutableFlowDataType.withOutboundRuleId(1L);

    // Assert
    assertSame(immutableFlowDataType, actualWithOutboundRuleIdResult);
  }

  /**
   * Test {@link ImmutableFlowDataType#withOutboundRuleId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then source return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDataType#withOutboundRuleId(Long)}
   */
  @Test
  @DisplayName(
      "Test withOutboundRuleId(Long); when forty-two; then source return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDataType ImmutableFlowDataType.withOutboundRuleId(Long)"})
  void testWithOutboundRuleId_whenFortyTwo_thenSourceReturnImmutableEntityReference() {
    // Arrange
    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    // Act
    ImmutableFlowDataType actualWithOutboundRuleIdResult =
        sourceOuIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build()
            .withOutboundRuleId(42L);

    // Assert
    EntityReference sourceResult = actualWithOutboundRuleIdResult.source();
    assertTrue(sourceResult instanceof ImmutableEntityReference);
    EntityReference targetResult = actualWithOutboundRuleIdResult.target();
    assertTrue(targetResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", sourceResult.description());
    assertEquals(1L, sourceResult.id());
    assertEquals(42L, actualWithOutboundRuleIdResult.outboundRuleId().longValue());
    assertEquals(EntityKind.ALL, sourceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, sourceResult.entityLifecycleStatus());
    assertEquals(sourceResult, targetResult);
  }

  /**
   * Test {@link ImmutableFlowDataType#withSource(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableFlowDataType#withSource(EntityReference)}
   */
  @Test
  @DisplayName("Test withSource(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDataType ImmutableFlowDataType.withSource(EntityReference)"})
  void testWithSource() {
    // Arrange
    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);
    ImmutableFlowDataType immutableFlowDataType =
        sourceOuIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build();

    // Act
    ImmutableFlowDataType actualWithSourceResult =
        immutableFlowDataType.withSource(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableFlowDataType, actualWithSourceResult);
  }

  /**
   * Test {@link ImmutableFlowDataType#withSourceOuId(Long)}.
   *
   * <p>Method under test: {@link ImmutableFlowDataType#withSourceOuId(Long)}
   */
  @Test
  @DisplayName("Test withSourceOuId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDataType ImmutableFlowDataType.withSourceOuId(Long)"})
  void testWithSourceOuId() {
    // Arrange
    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);
    ImmutableFlowDataType immutableFlowDataType =
        sourceOuIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build();

    // Act
    ImmutableFlowDataType actualWithSourceOuIdResult = immutableFlowDataType.withSourceOuId(1L);

    // Assert
    assertSame(immutableFlowDataType, actualWithSourceOuIdResult);
  }

  /**
   * Test {@link ImmutableFlowDataType#withSourceOuId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then source return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDataType#withSourceOuId(Long)}
   */
  @Test
  @DisplayName(
      "Test withSourceOuId(Long); when forty-two; then source return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDataType ImmutableFlowDataType.withSourceOuId(Long)"})
  void testWithSourceOuId_whenFortyTwo_thenSourceReturnImmutableEntityReference() {
    // Arrange
    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    // Act
    ImmutableFlowDataType actualWithSourceOuIdResult =
        sourceOuIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build()
            .withSourceOuId(42L);

    // Assert
    EntityReference sourceResult = actualWithSourceOuIdResult.source();
    assertTrue(sourceResult instanceof ImmutableEntityReference);
    EntityReference targetResult = actualWithSourceOuIdResult.target();
    assertTrue(targetResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", sourceResult.description());
    assertEquals(1L, sourceResult.id());
    assertEquals(42L, actualWithSourceOuIdResult.sourceOuId().longValue());
    assertEquals(EntityKind.ALL, sourceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, sourceResult.entityLifecycleStatus());
    assertEquals(sourceResult, targetResult);
  }

  /**
   * Test {@link ImmutableFlowDataType#withTarget(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableFlowDataType#withTarget(EntityReference)}
   */
  @Test
  @DisplayName("Test withTarget(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDataType ImmutableFlowDataType.withTarget(EntityReference)"})
  void testWithTarget() {
    // Arrange
    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);
    ImmutableFlowDataType immutableFlowDataType =
        sourceOuIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build();

    // Act
    ImmutableFlowDataType actualWithTargetResult =
        immutableFlowDataType.withTarget(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableFlowDataType, actualWithTargetResult);
  }

  /**
   * Test {@link ImmutableFlowDataType#withTargetOuId(Long)}.
   *
   * <p>Method under test: {@link ImmutableFlowDataType#withTargetOuId(Long)}
   */
  @Test
  @DisplayName("Test withTargetOuId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDataType ImmutableFlowDataType.withTargetOuId(Long)"})
  void testWithTargetOuId() {
    // Arrange
    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);
    ImmutableFlowDataType immutableFlowDataType =
        sourceOuIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build();

    // Act
    ImmutableFlowDataType actualWithTargetOuIdResult = immutableFlowDataType.withTargetOuId(1L);

    // Assert
    assertSame(immutableFlowDataType, actualWithTargetOuIdResult);
  }

  /**
   * Test {@link ImmutableFlowDataType#withTargetOuId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then source return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDataType#withTargetOuId(Long)}
   */
  @Test
  @DisplayName(
      "Test withTargetOuId(Long); when forty-two; then source return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDataType ImmutableFlowDataType.withTargetOuId(Long)"})
  void testWithTargetOuId_whenFortyTwo_thenSourceReturnImmutableEntityReference() {
    // Arrange
    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    // Act
    ImmutableFlowDataType actualWithTargetOuIdResult =
        sourceOuIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .targetOuId(1L)
            .build()
            .withTargetOuId(42L);

    // Assert
    EntityReference sourceResult = actualWithTargetOuIdResult.source();
    assertTrue(sourceResult instanceof ImmutableEntityReference);
    EntityReference targetResult = actualWithTargetOuIdResult.target();
    assertTrue(targetResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", sourceResult.description());
    assertEquals(1L, sourceResult.id());
    assertEquals(42L, actualWithTargetOuIdResult.targetOuId().longValue());
    assertEquals(EntityKind.ALL, sourceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, sourceResult.entityLifecycleStatus());
    assertEquals(sourceResult, targetResult);
  }
}
