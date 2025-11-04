package org.finos.waltz.model.datatype;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.rating.AuthoritativenessRatingValue;
import org.junit.jupiter.api.Test;

class ImmutableFlowDataTypeDiffblueTest {
  /**
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
  void testBuilder() {
    // Arrange and Act
    ImmutableFlowDataType.Builder actualSourceOuIdResult = ImmutableFlowDataType.builder()
        .inboundRuleId(1L)
        .outboundRuleId(1L)
        .sourceOuId(1L);

    // Assert
    assertSame(actualSourceOuIdResult, actualSourceOuIdResult.targetOuId(1L));
  }

  /**
   * Method under test: {@link ImmutableFlowDataType.Builder#dtId(long)}
   */
  @Test
  void testBuilderDtId() {
    // Arrange
    ImmutableFlowDataType.Builder builderResult = ImmutableFlowDataType.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dtId(1L));
  }

  /**
   * Method under test: {@link ImmutableFlowDataType.Builder#from(FlowDataType)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableFlowDataType.Builder builderResult = ImmutableFlowDataType.builder();
    FlowDataType instance = mock(FlowDataType.class);
    when(instance.source()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).source();
  }

  /**
   * Method under test: {@link ImmutableFlowDataType.Builder#from(FlowDataType)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableFlowDataType.Builder builderResult = ImmutableFlowDataType.builder();
    FlowDataType instance = mock(FlowDataType.class);
    when(instance.target()).thenThrow(new IllegalStateException("instance"));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).source();
    verify(instance).target();
  }

  /**
   * Method under test: {@link ImmutableFlowDataType.Builder#from(FlowDataType)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableFlowDataType.Builder builderResult = ImmutableFlowDataType.builder();
    FlowDataType instance = mock(FlowDataType.class);
    AuthoritativenessRatingValue ofResult = AuthoritativenessRatingValue.of("42");
    when(instance.targetInboundRating()).thenReturn(ofResult);
    when(instance.inboundRuleId()).thenReturn(1L);
    when(instance.outboundRuleId()).thenReturn(1L);
    when(instance.sourceOuId()).thenReturn(1L);
    when(instance.targetOuId()).thenReturn(1L);
    when(instance.dtId()).thenReturn(1L);
    when(instance.lfId()).thenReturn(1L);
    when(instance.lfdId()).thenReturn(1L);
    AuthoritativenessRatingValue ofResult2 = AuthoritativenessRatingValue.of("42");
    when(instance.sourceOutboundRating()).thenReturn(ofResult2);
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableFlowDataType.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).dtId();
    verify(instance).inboundRuleId();
    verify(instance).lfId();
    verify(instance).lfdId();
    verify(instance).outboundRuleId();
    verify(instance).source();
    verify(instance).sourceOuId();
    verify(instance).sourceOutboundRating();
    verify(instance).target();
    verify(instance).targetInboundRating();
    verify(instance).targetOuId();
    ImmutableFlowDataType buildResult = builderResult.build();
    assertEquals(1L, buildResult.inboundRuleId().longValue());
    assertEquals(1L, buildResult.outboundRuleId().longValue());
    assertEquals(1L, buildResult.sourceOuId().longValue());
    assertEquals(1L, buildResult.targetOuId().longValue());
    assertEquals(1L, buildResult.dtId());
    assertEquals(1L, buildResult.lfId());
    assertEquals(1L, buildResult.lfdId());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult2, buildResult.sourceOutboundRating());
    assertSame(ofResult, buildResult.targetInboundRating());
  }

  /**
   * Method under test: {@link ImmutableFlowDataType.Builder#from(FlowDataType)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableFlowDataType.Builder builderResult = ImmutableFlowDataType.builder();
    FlowDataType instance = mock(FlowDataType.class);
    when(instance.targetInboundRating()).thenThrow(new IllegalStateException("instance"));
    when(instance.inboundRuleId()).thenReturn(1L);
    when(instance.outboundRuleId()).thenReturn(1L);
    when(instance.sourceOuId()).thenReturn(1L);
    when(instance.targetOuId()).thenReturn(1L);
    when(instance.dtId()).thenReturn(1L);
    when(instance.lfId()).thenReturn(1L);
    when(instance.lfdId()).thenReturn(1L);
    when(instance.sourceOutboundRating()).thenReturn(AuthoritativenessRatingValue.of("42"));
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).dtId();
    verify(instance).inboundRuleId();
    verify(instance).lfId();
    verify(instance).lfdId();
    verify(instance).outboundRuleId();
    verify(instance).source();
    verify(instance).sourceOuId();
    verify(instance).sourceOutboundRating();
    verify(instance).target();
    verify(instance).targetInboundRating();
    verify(instance).targetOuId();
  }

  /**
   * Method under test: {@link ImmutableFlowDataType.Builder#from(FlowDataType)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableFlowDataType.Builder builderResult = ImmutableFlowDataType.builder();
    FlowDataType instance = mock(FlowDataType.class);
    AuthoritativenessRatingValue ofResult = AuthoritativenessRatingValue.of("42");
    when(instance.targetInboundRating()).thenReturn(ofResult);
    when(instance.inboundRuleId()).thenReturn(null);
    when(instance.outboundRuleId()).thenReturn(1L);
    when(instance.sourceOuId()).thenReturn(1L);
    when(instance.targetOuId()).thenReturn(1L);
    when(instance.dtId()).thenReturn(1L);
    when(instance.lfId()).thenReturn(1L);
    when(instance.lfdId()).thenReturn(1L);
    AuthoritativenessRatingValue ofResult2 = AuthoritativenessRatingValue.of("42");
    when(instance.sourceOutboundRating()).thenReturn(ofResult2);
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableFlowDataType.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).dtId();
    verify(instance).inboundRuleId();
    verify(instance).lfId();
    verify(instance).lfdId();
    verify(instance).outboundRuleId();
    verify(instance).source();
    verify(instance).sourceOuId();
    verify(instance).sourceOutboundRating();
    verify(instance).target();
    verify(instance).targetInboundRating();
    verify(instance).targetOuId();
    ImmutableFlowDataType buildResult = builderResult.build();
    assertNull(buildResult.inboundRuleId());
    assertEquals(1L, buildResult.outboundRuleId().longValue());
    assertEquals(1L, buildResult.sourceOuId().longValue());
    assertEquals(1L, buildResult.targetOuId().longValue());
    assertEquals(1L, buildResult.dtId());
    assertEquals(1L, buildResult.lfId());
    assertEquals(1L, buildResult.lfdId());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult2, buildResult.sourceOutboundRating());
    assertSame(ofResult, buildResult.targetInboundRating());
  }

  /**
   * Method under test: {@link ImmutableFlowDataType.Builder#from(FlowDataType)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableFlowDataType.Builder builderResult = ImmutableFlowDataType.builder();
    FlowDataType instance = mock(FlowDataType.class);
    AuthoritativenessRatingValue ofResult = AuthoritativenessRatingValue.of("42");
    when(instance.targetInboundRating()).thenReturn(ofResult);
    when(instance.inboundRuleId()).thenReturn(1L);
    when(instance.outboundRuleId()).thenReturn(null);
    when(instance.sourceOuId()).thenReturn(1L);
    when(instance.targetOuId()).thenReturn(1L);
    when(instance.dtId()).thenReturn(1L);
    when(instance.lfId()).thenReturn(1L);
    when(instance.lfdId()).thenReturn(1L);
    AuthoritativenessRatingValue ofResult2 = AuthoritativenessRatingValue.of("42");
    when(instance.sourceOutboundRating()).thenReturn(ofResult2);
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableFlowDataType.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).dtId();
    verify(instance).inboundRuleId();
    verify(instance).lfId();
    verify(instance).lfdId();
    verify(instance).outboundRuleId();
    verify(instance).source();
    verify(instance).sourceOuId();
    verify(instance).sourceOutboundRating();
    verify(instance).target();
    verify(instance).targetInboundRating();
    verify(instance).targetOuId();
    ImmutableFlowDataType buildResult = builderResult.build();
    assertNull(buildResult.outboundRuleId());
    assertEquals(1L, buildResult.inboundRuleId().longValue());
    assertEquals(1L, buildResult.sourceOuId().longValue());
    assertEquals(1L, buildResult.targetOuId().longValue());
    assertEquals(1L, buildResult.dtId());
    assertEquals(1L, buildResult.lfId());
    assertEquals(1L, buildResult.lfdId());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult2, buildResult.sourceOutboundRating());
    assertSame(ofResult, buildResult.targetInboundRating());
  }

  /**
   * Method under test: {@link ImmutableFlowDataType.Builder#from(FlowDataType)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableFlowDataType.Builder builderResult = ImmutableFlowDataType.builder();
    FlowDataType instance = mock(FlowDataType.class);
    AuthoritativenessRatingValue ofResult = AuthoritativenessRatingValue.of("42");
    when(instance.targetInboundRating()).thenReturn(ofResult);
    when(instance.inboundRuleId()).thenReturn(1L);
    when(instance.outboundRuleId()).thenReturn(1L);
    when(instance.sourceOuId()).thenReturn(null);
    when(instance.targetOuId()).thenReturn(1L);
    when(instance.dtId()).thenReturn(1L);
    when(instance.lfId()).thenReturn(1L);
    when(instance.lfdId()).thenReturn(1L);
    AuthoritativenessRatingValue ofResult2 = AuthoritativenessRatingValue.of("42");
    when(instance.sourceOutboundRating()).thenReturn(ofResult2);
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableFlowDataType.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).dtId();
    verify(instance).inboundRuleId();
    verify(instance).lfId();
    verify(instance).lfdId();
    verify(instance).outboundRuleId();
    verify(instance).source();
    verify(instance).sourceOuId();
    verify(instance).sourceOutboundRating();
    verify(instance).target();
    verify(instance).targetInboundRating();
    verify(instance).targetOuId();
    ImmutableFlowDataType buildResult = builderResult.build();
    assertNull(buildResult.sourceOuId());
    assertEquals(1L, buildResult.inboundRuleId().longValue());
    assertEquals(1L, buildResult.outboundRuleId().longValue());
    assertEquals(1L, buildResult.targetOuId().longValue());
    assertEquals(1L, buildResult.dtId());
    assertEquals(1L, buildResult.lfId());
    assertEquals(1L, buildResult.lfdId());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult2, buildResult.sourceOutboundRating());
    assertSame(ofResult, buildResult.targetInboundRating());
  }

  /**
   * Method under test: {@link ImmutableFlowDataType.Builder#from(FlowDataType)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableFlowDataType.Builder builderResult = ImmutableFlowDataType.builder();
    FlowDataType instance = mock(FlowDataType.class);
    AuthoritativenessRatingValue ofResult = AuthoritativenessRatingValue.of("42");
    when(instance.targetInboundRating()).thenReturn(ofResult);
    when(instance.inboundRuleId()).thenReturn(1L);
    when(instance.outboundRuleId()).thenReturn(1L);
    when(instance.sourceOuId()).thenReturn(1L);
    when(instance.targetOuId()).thenReturn(null);
    when(instance.dtId()).thenReturn(1L);
    when(instance.lfId()).thenReturn(1L);
    when(instance.lfdId()).thenReturn(1L);
    AuthoritativenessRatingValue ofResult2 = AuthoritativenessRatingValue.of("42");
    when(instance.sourceOutboundRating()).thenReturn(ofResult2);
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableFlowDataType.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).dtId();
    verify(instance).inboundRuleId();
    verify(instance).lfId();
    verify(instance).lfdId();
    verify(instance).outboundRuleId();
    verify(instance).source();
    verify(instance).sourceOuId();
    verify(instance).sourceOutboundRating();
    verify(instance).target();
    verify(instance).targetInboundRating();
    verify(instance).targetOuId();
    ImmutableFlowDataType buildResult = builderResult.build();
    assertNull(buildResult.targetOuId());
    assertEquals(1L, buildResult.inboundRuleId().longValue());
    assertEquals(1L, buildResult.outboundRuleId().longValue());
    assertEquals(1L, buildResult.sourceOuId().longValue());
    assertEquals(1L, buildResult.dtId());
    assertEquals(1L, buildResult.lfId());
    assertEquals(1L, buildResult.lfdId());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult2, buildResult.sourceOutboundRating());
    assertSame(ofResult, buildResult.targetInboundRating());
  }

  /**
   * Method under test: {@link ImmutableFlowDataType.Builder#lfId(long)}
   */
  @Test
  void testBuilderLfId() {
    // Arrange
    ImmutableFlowDataType.Builder builderResult = ImmutableFlowDataType.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lfId(1L));
  }

  /**
   * Method under test: {@link ImmutableFlowDataType.Builder#lfdId(long)}
   */
  @Test
  void testBuilderLfdId() {
    // Arrange
    ImmutableFlowDataType.Builder builderResult = ImmutableFlowDataType.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lfdId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDataType.Builder#source(EntityReference)}
   */
  @Test
  void testBuilderSource() {
    // Arrange
    ImmutableFlowDataType.Builder builderResult = ImmutableFlowDataType.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.source(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDataType.Builder#sourceOutboundRating(AuthoritativenessRatingValue)}
   */
  @Test
  void testBuilderSourceOutboundRating() {
    // Arrange
    ImmutableFlowDataType.Builder builderResult = ImmutableFlowDataType.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42")));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDataType.Builder#target(EntityReference)}
   */
  @Test
  void testBuilderTarget() {
    // Arrange
    ImmutableFlowDataType.Builder builderResult = ImmutableFlowDataType.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.target(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowDataType.Builder#targetInboundRating(AuthoritativenessRatingValue)}
   */
  @Test
  void testBuilderTargetInboundRating() {
    // Arrange
    ImmutableFlowDataType.Builder builderResult = ImmutableFlowDataType.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetInboundRating(AuthoritativenessRatingValue.of("42")));
  }

  /**
   * Method under test: {@link ImmutableFlowDataType#copyOf(FlowDataType)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    FlowDataType instance = mock(FlowDataType.class);
    AuthoritativenessRatingValue ofResult = AuthoritativenessRatingValue.of("42");
    when(instance.targetInboundRating()).thenReturn(ofResult);
    when(instance.inboundRuleId()).thenReturn(1L);
    when(instance.outboundRuleId()).thenReturn(1L);
    when(instance.sourceOuId()).thenReturn(1L);
    when(instance.targetOuId()).thenReturn(1L);
    when(instance.dtId()).thenReturn(1L);
    when(instance.lfId()).thenReturn(1L);
    when(instance.lfdId()).thenReturn(1L);
    AuthoritativenessRatingValue ofResult2 = AuthoritativenessRatingValue.of("42");
    when(instance.sourceOutboundRating()).thenReturn(ofResult2);
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableFlowDataType actualCopyOfResult = ImmutableFlowDataType.copyOf(instance);

    // Assert
    verify(instance).dtId();
    verify(instance).inboundRuleId();
    verify(instance).lfId();
    verify(instance).lfdId();
    verify(instance).outboundRuleId();
    verify(instance).source();
    verify(instance).sourceOuId();
    verify(instance).sourceOutboundRating();
    verify(instance).target();
    verify(instance).targetInboundRating();
    verify(instance).targetOuId();
    AuthoritativenessRatingValue sourceOutboundRatingResult = actualCopyOfResult.sourceOutboundRating();
    assertEquals("42", sourceOutboundRatingResult.value());
    AuthoritativenessRatingValue targetInboundRatingResult = actualCopyOfResult.targetInboundRating();
    assertEquals("42", targetInboundRatingResult.value());
    assertEquals(1L, actualCopyOfResult.inboundRuleId().longValue());
    assertEquals(1L, actualCopyOfResult.outboundRuleId().longValue());
    assertEquals(1L, actualCopyOfResult.sourceOuId().longValue());
    assertEquals(1L, actualCopyOfResult.targetOuId().longValue());
    assertEquals(1L, actualCopyOfResult.dtId());
    assertEquals(1L, actualCopyOfResult.lfId());
    assertEquals(1L, actualCopyOfResult.lfdId());
    assertSame(ofResult2, sourceOutboundRatingResult);
    assertSame(ofResult, targetInboundRatingResult);
  }
}
