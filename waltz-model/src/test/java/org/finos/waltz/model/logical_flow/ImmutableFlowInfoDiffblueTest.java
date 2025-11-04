package org.finos.waltz.model.logical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableFlowInfoDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableFlowInfo.Builder#actualDataType(EntityReference)}
   */
  @Test
  void testBuilderActualDataType() {
    // Arrange
    ImmutableFlowInfo.Builder builderResult = ImmutableFlowInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.actualDataType(mock(EntityReference.class)));
  }

  /**
   * Method under test: {@link ImmutableFlowInfo.Builder#classificationId(Long)}
   */
  @Test
  void testBuilderClassificationId() {
    // Arrange
    ImmutableFlowInfo.Builder builderResult = ImmutableFlowInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.classificationId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowInfo.Builder#counterpart(EntityReference)}
   */
  @Test
  void testBuilderCounterpart() {
    // Arrange
    ImmutableFlowInfo.Builder builderResult = ImmutableFlowInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.counterpart(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowInfo.Builder#flowEntityLifecycleStatus(EntityLifecycleStatus)}
   */
  @Test
  void testBuilderFlowEntityLifecycleStatus() {
    // Arrange
    ImmutableFlowInfo.Builder builderResult = ImmutableFlowInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.flowEntityLifecycleStatus(EntityLifecycleStatus.ACTIVE));
  }

  /**
   * Method under test: {@link ImmutableFlowInfo.Builder#flowId(Long)}
   */
  @Test
  void testBuilderFlowId() {
    // Arrange
    ImmutableFlowInfo.Builder builderResult = ImmutableFlowInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.flowId(1L));
  }

  /**
   * Method under test: {@link ImmutableFlowInfo.Builder#from(FlowInfo)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableFlowInfo.Builder builderResult = ImmutableFlowInfo.builder();
    FlowInfo instance = mock(FlowInfo.class);
    when(instance.counterpart()).thenThrow(new IllegalStateException("instance"));
    when(instance.classificationId()).thenReturn(1L);
    when(instance.flowId()).thenReturn(1L);
    when(instance.flowEntityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).classificationId();
    verify(instance).counterpart();
    verify(instance).flowEntityLifecycleStatus();
    verify(instance).flowId();
  }

  /**
   * Method under test: {@link ImmutableFlowInfo.Builder#from(FlowInfo)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableFlowInfo.Builder builderResult = ImmutableFlowInfo.builder();
    FlowInfo instance = mock(FlowInfo.class);
    when(instance.rollupDataType()).thenThrow(new IllegalStateException("instance"));
    when(instance.counterpart()).thenReturn(mock(EntityReference.class));
    when(instance.classificationId()).thenReturn(1L);
    when(instance.flowId()).thenReturn(1L);
    when(instance.flowEntityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).classificationId();
    verify(instance).counterpart();
    verify(instance).flowEntityLifecycleStatus();
    verify(instance).flowId();
    verify(instance).rollupDataType();
  }

  /**
   * Method under test: {@link ImmutableFlowInfo.Builder#from(FlowInfo)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableFlowInfo.Builder builderResult = ImmutableFlowInfo.builder();
    FlowInfo instance = mock(FlowInfo.class);
    when(instance.actualDataType()).thenThrow(new IllegalStateException("instance"));
    when(instance.rollupDataType()).thenReturn(mock(EntityReference.class));
    when(instance.counterpart()).thenReturn(mock(EntityReference.class));
    when(instance.classificationId()).thenReturn(1L);
    when(instance.flowId()).thenReturn(1L);
    when(instance.flowEntityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).actualDataType();
    verify(instance).classificationId();
    verify(instance).counterpart();
    verify(instance).flowEntityLifecycleStatus();
    verify(instance).flowId();
    verify(instance).rollupDataType();
  }

  /**
   * Method under test: {@link ImmutableFlowInfo.Builder#from(FlowInfo)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableFlowInfo.Builder builderResult = ImmutableFlowInfo.builder();
    FlowInfo instance = mock(FlowInfo.class);
    when(instance.actualDataType()).thenReturn(mock(EntityReference.class));
    when(instance.rollupDataType()).thenReturn(mock(EntityReference.class));
    when(instance.counterpart()).thenReturn(mock(EntityReference.class));
    when(instance.classificationId()).thenReturn(1L);
    when(instance.flowId()).thenReturn(1L);
    when(instance.flowEntityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    // Act
    ImmutableFlowInfo.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).actualDataType();
    verify(instance).classificationId();
    verify(instance).counterpart();
    verify(instance).flowEntityLifecycleStatus();
    verify(instance).flowId();
    verify(instance).rollupDataType();
    ImmutableFlowInfo buildResult = builderResult.build();
    assertEquals(1L, buildResult.classificationId().longValue());
    assertEquals(1L, buildResult.flowId().longValue());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.flowEntityLifecycleStatus());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowInfo.Builder#rollupDataType(EntityReference)}
   */
  @Test
  void testBuilderRollupDataType() {
    // Arrange
    ImmutableFlowInfo.Builder builderResult = ImmutableFlowInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rollupDataType(mock(EntityReference.class)));
  }

  /**
   * Method under test: {@link ImmutableFlowInfo#copyOf(FlowInfo)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    FlowInfo instance = mock(FlowInfo.class);
    when(instance.actualDataType()).thenReturn(mock(EntityReference.class));
    when(instance.rollupDataType()).thenReturn(mock(EntityReference.class));
    when(instance.counterpart()).thenReturn(mock(EntityReference.class));
    when(instance.classificationId()).thenReturn(1L);
    when(instance.flowId()).thenReturn(1L);
    when(instance.flowEntityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    // Act
    ImmutableFlowInfo actualCopyOfResult = ImmutableFlowInfo.copyOf(instance);

    // Assert
    verify(instance).actualDataType();
    verify(instance).classificationId();
    verify(instance).counterpart();
    verify(instance).flowEntityLifecycleStatus();
    verify(instance).flowId();
    verify(instance).rollupDataType();
    assertEquals(1L, actualCopyOfResult.classificationId().longValue());
    assertEquals(1L, actualCopyOfResult.flowId().longValue());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.flowEntityLifecycleStatus());
  }

  /**
   * Method under test: {@link ImmutableFlowInfo.Json#actualDataType()}
   */
  @Test
  void testJsonActualDataType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowInfo.Json()).actualDataType());
  }

  /**
   * Method under test: {@link ImmutableFlowInfo.Json#classificationId()}
   */
  @Test
  void testJsonClassificationId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowInfo.Json()).classificationId());
  }

  /**
   * Method under test: {@link ImmutableFlowInfo.Json#counterpart()}
   */
  @Test
  void testJsonCounterpart() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowInfo.Json()).counterpart());
  }

  /**
   * Method under test: {@link ImmutableFlowInfo.Json#flowEntityLifecycleStatus()}
   */
  @Test
  void testJsonFlowEntityLifecycleStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowInfo.Json()).flowEntityLifecycleStatus());
  }

  /**
   * Method under test: {@link ImmutableFlowInfo.Json#flowId()}
   */
  @Test
  void testJsonFlowId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowInfo.Json()).flowId());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ImmutableFlowInfo.Json}
   *   <li>{@link ImmutableFlowInfo.Json#setActualDataType(EntityReference)}
   *   <li>{@link ImmutableFlowInfo.Json#setClassificationId(Long)}
   *   <li>{@link ImmutableFlowInfo.Json#setCounterpart(EntityReference)}
   *   <li>
   * {@link ImmutableFlowInfo.Json#setFlowEntityLifecycleStatus(EntityLifecycleStatus)}
   *   <li>{@link ImmutableFlowInfo.Json#setFlowId(Long)}
   *   <li>{@link ImmutableFlowInfo.Json#setRollupDataType(EntityReference)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableFlowInfo.Json actualJson = new ImmutableFlowInfo.Json();
    actualJson.setActualDataType(null);
    actualJson.setClassificationId(1L);
    actualJson.setCounterpart(null);
    actualJson.setFlowEntityLifecycleStatus(EntityLifecycleStatus.ACTIVE);
    actualJson.setFlowId(1L);
    actualJson.setRollupDataType(null);

    // Assert
    assertEquals(1L, actualJson.classificationId.longValue());
    assertEquals(1L, actualJson.flowId.longValue());
  }

  /**
   * Method under test: {@link ImmutableFlowInfo.Json#rollupDataType()}
   */
  @Test
  void testJsonRollupDataType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowInfo.Json()).rollupDataType());
  }
}
