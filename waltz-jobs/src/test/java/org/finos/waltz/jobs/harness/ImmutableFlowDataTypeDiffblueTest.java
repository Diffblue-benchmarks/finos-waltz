package org.finos.waltz.jobs.harness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.jobs.harness.FlowClassificationRule2Harness.FlowDataType;
import org.finos.waltz.jobs.harness.ImmutableFlowDataType.Builder;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableFlowDataTypeDiffblueTest {
  /**
   * Test {@link ImmutableFlowDataType#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableFlowDataType#builder()}
   *   <li>{@link ImmutableFlowDataType#inboundRuleId(Long)}
   *   <li>{@link ImmutableFlowDataType#outboundRuleId(Long)}
   *   <li>{@link ImmutableFlowDataType#sourceOuId(Long)}
   *   <li>{@link ImmutableFlowDataType#targetOuId(Long)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableFlowDataType Builder.build()", "Builder Builder.inboundRuleId(Long)",
      "Builder Builder.outboundRuleId(Long)", "Builder Builder.sourceOuId(Long)", "Builder Builder.targetOuId(Long)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualSourceOuIdResult = ImmutableFlowDataType.builder()
        .inboundRuleId(1L)
        .outboundRuleId(1L)
        .sourceOuId(1L);

    // Assert
    assertSame(actualSourceOuIdResult, actualSourceOuIdResult.targetOuId(1L));
  }

  /**
   * Test Builder {@link Builder#dtId(long)}.
   * <p>
   * Method under test: {@link Builder#dtId(long)}
   */
  @Test
  @DisplayName("Test Builder dtId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.dtId(long)"})
  void testBuilderDtId() {
    // Arrange
    Builder builderResult = ImmutableFlowDataType.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dtId(1L));
  }

  /**
   * Test Builder {@link Builder#from(FlowDataType)}.
   * <ul>
   *   <li>Then return build inboundRuleId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowDataType)}
   */
  @Test
  @DisplayName("Test Builder from(FlowDataType); then return build inboundRuleId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowDataType)"})
  void testBuilderFrom_thenReturnBuildInboundRuleIdIsNull() {
    // Arrange
    Builder builderResult = ImmutableFlowDataType.builder();
    FlowDataType instance = mock(FlowDataType.class);
    when(instance.inboundRuleId()).thenReturn(null);
    when(instance.outboundRuleId()).thenReturn(1L);
    when(instance.sourceOuId()).thenReturn(1L);
    when(instance.targetOuId()).thenReturn(1L);
    when(instance.dtId()).thenReturn(1L);
    when(instance.lfId()).thenReturn(1L);
    when(instance.lfdId()).thenReturn(1L);
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).dtId();
    verify(instance).inboundRuleId();
    verify(instance).lfId();
    verify(instance).lfdId();
    verify(instance).outboundRuleId();
    verify(instance).source();
    verify(instance).sourceOuId();
    verify(instance).target();
    verify(instance).targetOuId();
    ImmutableFlowDataType buildResult = actualFromResult.build();
    assertNull(buildResult.inboundRuleId());
    ImmutableFlowDataType buildResult2 = builderResult.build();
    assertNull(buildResult2.inboundRuleId());
    assertEquals(1L, buildResult.outboundRuleId().longValue());
    assertEquals(1L, buildResult2.outboundRuleId().longValue());
    assertEquals(1L, buildResult.sourceOuId().longValue());
    assertEquals(1L, buildResult2.sourceOuId().longValue());
    assertEquals(1L, buildResult.targetOuId().longValue());
    assertEquals(1L, buildResult2.targetOuId().longValue());
  }

  /**
   * Test Builder {@link Builder#from(FlowDataType)}.
   * <ul>
   *   <li>Then return build inboundRuleId longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowDataType)}
   */
  @Test
  @DisplayName("Test Builder from(FlowDataType); then return build inboundRuleId longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowDataType)"})
  void testBuilderFrom_thenReturnBuildInboundRuleIdLongValueIsOne() {
    // Arrange
    Builder builderResult = ImmutableFlowDataType.builder();
    FlowDataType instance = mock(FlowDataType.class);
    when(instance.inboundRuleId()).thenReturn(1L);
    when(instance.outboundRuleId()).thenReturn(1L);
    when(instance.sourceOuId()).thenReturn(1L);
    when(instance.targetOuId()).thenReturn(1L);
    when(instance.dtId()).thenReturn(1L);
    when(instance.lfId()).thenReturn(1L);
    when(instance.lfdId()).thenReturn(1L);
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).dtId();
    verify(instance).inboundRuleId();
    verify(instance).lfId();
    verify(instance).lfdId();
    verify(instance).outboundRuleId();
    verify(instance).source();
    verify(instance).sourceOuId();
    verify(instance).target();
    verify(instance).targetOuId();
    ImmutableFlowDataType buildResult = actualFromResult.build();
    assertEquals(1L, buildResult.inboundRuleId().longValue());
    ImmutableFlowDataType buildResult2 = builderResult.build();
    assertEquals(1L, buildResult2.inboundRuleId().longValue());
    assertEquals(1L, buildResult.outboundRuleId().longValue());
    assertEquals(1L, buildResult2.outboundRuleId().longValue());
    assertEquals(1L, buildResult.sourceOuId().longValue());
    assertEquals(1L, buildResult2.sourceOuId().longValue());
    assertEquals(1L, buildResult.targetOuId().longValue());
    assertEquals(1L, buildResult2.targetOuId().longValue());
  }

  /**
   * Test Builder {@link Builder#from(FlowDataType)}.
   * <ul>
   *   <li>Then return build outboundRuleId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowDataType)}
   */
  @Test
  @DisplayName("Test Builder from(FlowDataType); then return build outboundRuleId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowDataType)"})
  void testBuilderFrom_thenReturnBuildOutboundRuleIdIsNull() {
    // Arrange
    Builder builderResult = ImmutableFlowDataType.builder();
    FlowDataType instance = mock(FlowDataType.class);
    when(instance.inboundRuleId()).thenReturn(1L);
    when(instance.outboundRuleId()).thenReturn(null);
    when(instance.sourceOuId()).thenReturn(1L);
    when(instance.targetOuId()).thenReturn(1L);
    when(instance.dtId()).thenReturn(1L);
    when(instance.lfId()).thenReturn(1L);
    when(instance.lfdId()).thenReturn(1L);
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).dtId();
    verify(instance).inboundRuleId();
    verify(instance).lfId();
    verify(instance).lfdId();
    verify(instance).outboundRuleId();
    verify(instance).source();
    verify(instance).sourceOuId();
    verify(instance).target();
    verify(instance).targetOuId();
    ImmutableFlowDataType buildResult = actualFromResult.build();
    assertNull(buildResult.outboundRuleId());
    ImmutableFlowDataType buildResult2 = builderResult.build();
    assertNull(buildResult2.outboundRuleId());
    assertEquals(1L, buildResult.inboundRuleId().longValue());
    assertEquals(1L, buildResult2.inboundRuleId().longValue());
    assertEquals(1L, buildResult.sourceOuId().longValue());
    assertEquals(1L, buildResult2.sourceOuId().longValue());
    assertEquals(1L, buildResult.targetOuId().longValue());
    assertEquals(1L, buildResult2.targetOuId().longValue());
  }

  /**
   * Test Builder {@link Builder#from(FlowDataType)}.
   * <ul>
   *   <li>Then return build sourceOuId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowDataType)}
   */
  @Test
  @DisplayName("Test Builder from(FlowDataType); then return build sourceOuId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowDataType)"})
  void testBuilderFrom_thenReturnBuildSourceOuIdIsNull() {
    // Arrange
    Builder builderResult = ImmutableFlowDataType.builder();
    FlowDataType instance = mock(FlowDataType.class);
    when(instance.inboundRuleId()).thenReturn(1L);
    when(instance.outboundRuleId()).thenReturn(1L);
    when(instance.sourceOuId()).thenReturn(null);
    when(instance.targetOuId()).thenReturn(1L);
    when(instance.dtId()).thenReturn(1L);
    when(instance.lfId()).thenReturn(1L);
    when(instance.lfdId()).thenReturn(1L);
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).dtId();
    verify(instance).inboundRuleId();
    verify(instance).lfId();
    verify(instance).lfdId();
    verify(instance).outboundRuleId();
    verify(instance).source();
    verify(instance).sourceOuId();
    verify(instance).target();
    verify(instance).targetOuId();
    ImmutableFlowDataType buildResult = actualFromResult.build();
    assertNull(buildResult.sourceOuId());
    ImmutableFlowDataType buildResult2 = builderResult.build();
    assertNull(buildResult2.sourceOuId());
    assertEquals(1L, buildResult.inboundRuleId().longValue());
    assertEquals(1L, buildResult2.inboundRuleId().longValue());
    assertEquals(1L, buildResult.outboundRuleId().longValue());
    assertEquals(1L, buildResult2.outboundRuleId().longValue());
    assertEquals(1L, buildResult.targetOuId().longValue());
    assertEquals(1L, buildResult2.targetOuId().longValue());
  }

  /**
   * Test Builder {@link Builder#from(FlowDataType)}.
   * <ul>
   *   <li>Then return build targetOuId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowDataType)}
   */
  @Test
  @DisplayName("Test Builder from(FlowDataType); then return build targetOuId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowDataType)"})
  void testBuilderFrom_thenReturnBuildTargetOuIdIsNull() {
    // Arrange
    Builder builderResult = ImmutableFlowDataType.builder();
    FlowDataType instance = mock(FlowDataType.class);
    when(instance.inboundRuleId()).thenReturn(1L);
    when(instance.outboundRuleId()).thenReturn(1L);
    when(instance.sourceOuId()).thenReturn(1L);
    when(instance.targetOuId()).thenReturn(null);
    when(instance.dtId()).thenReturn(1L);
    when(instance.lfId()).thenReturn(1L);
    when(instance.lfdId()).thenReturn(1L);
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).dtId();
    verify(instance).inboundRuleId();
    verify(instance).lfId();
    verify(instance).lfdId();
    verify(instance).outboundRuleId();
    verify(instance).source();
    verify(instance).sourceOuId();
    verify(instance).target();
    verify(instance).targetOuId();
    ImmutableFlowDataType buildResult = actualFromResult.build();
    assertNull(buildResult.targetOuId());
    ImmutableFlowDataType buildResult2 = builderResult.build();
    assertNull(buildResult2.targetOuId());
    assertEquals(1L, buildResult.inboundRuleId().longValue());
    assertEquals(1L, buildResult2.inboundRuleId().longValue());
    assertEquals(1L, buildResult.outboundRuleId().longValue());
    assertEquals(1L, buildResult2.outboundRuleId().longValue());
    assertEquals(1L, buildResult.sourceOuId().longValue());
    assertEquals(1L, buildResult2.sourceOuId().longValue());
  }

  /**
   * Test Builder {@link Builder#from(FlowDataType)}.
   * <ul>
   *   <li>When {@link FlowDataType} {@link FlowDataType#sourceOuId()} throw {@link IllegalStateException#IllegalStateException(String)} with {@code instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowDataType)}
   */
  @Test
  @DisplayName("Test Builder from(FlowDataType); when FlowDataType sourceOuId() throw IllegalStateException(String) with 'instance'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowDataType)"})
  void testBuilderFrom_whenFlowDataTypeSourceOuIdThrowIllegalStateExceptionWithInstance() {
    // Arrange
    Builder builderResult = ImmutableFlowDataType.builder();
    FlowDataType instance = mock(FlowDataType.class);
    when(instance.sourceOuId()).thenThrow(new IllegalStateException("instance"));
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).source();
    verify(instance).sourceOuId();
    verify(instance).target();
  }

  /**
   * Test Builder {@link Builder#from(FlowDataType)}.
   * <ul>
   *   <li>When {@link FlowDataType} {@link FlowDataType#source()} throw {@link IllegalStateException#IllegalStateException(String)} with {@code instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowDataType)}
   */
  @Test
  @DisplayName("Test Builder from(FlowDataType); when FlowDataType source() throw IllegalStateException(String) with 'instance'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowDataType)"})
  void testBuilderFrom_whenFlowDataTypeSourceThrowIllegalStateExceptionWithInstance() {
    // Arrange
    Builder builderResult = ImmutableFlowDataType.builder();
    FlowDataType instance = mock(FlowDataType.class);
    when(instance.source()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).source();
  }

  /**
   * Test Builder {@link Builder#from(FlowDataType)}.
   * <ul>
   *   <li>When {@link FlowDataType} {@link FlowDataType#target()} throw {@link IllegalStateException#IllegalStateException(String)} with {@code instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowDataType)}
   */
  @Test
  @DisplayName("Test Builder from(FlowDataType); when FlowDataType target() throw IllegalStateException(String) with 'instance'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowDataType)"})
  void testBuilderFrom_whenFlowDataTypeTargetThrowIllegalStateExceptionWithInstance() {
    // Arrange
    Builder builderResult = ImmutableFlowDataType.builder();
    FlowDataType instance = mock(FlowDataType.class);
    when(instance.target()).thenThrow(new IllegalStateException("instance"));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).source();
    verify(instance).target();
  }

  /**
   * Test Builder {@link Builder#lfId(long)}.
   * <p>
   * Method under test: {@link Builder#lfId(long)}
   */
  @Test
  @DisplayName("Test Builder lfId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.lfId(long)"})
  void testBuilderLfId() {
    // Arrange
    Builder builderResult = ImmutableFlowDataType.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lfId(1L));
  }

  /**
   * Test Builder {@link Builder#lfdId(long)}.
   * <p>
   * Method under test: {@link Builder#lfdId(long)}
   */
  @Test
  @DisplayName("Test Builder lfdId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.lfdId(long)"})
  void testBuilderLfdId() {
    // Arrange
    Builder builderResult = ImmutableFlowDataType.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lfdId(1L));
  }

  /**
   * Test Builder {@link Builder#source(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#source(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder source(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.source(EntityReference)"})
  void testBuilderSource_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowDataType.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.source(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#target(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#target(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder target(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.target(EntityReference)"})
  void testBuilderTarget_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowDataType.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.target(mock(EntityReference.class)));
  }
}
