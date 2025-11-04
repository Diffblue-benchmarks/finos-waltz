package org.finos.waltz.jobs.tools.flows;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableFlowUpdateCommandDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableFlowUpdateCommand#builder()}
   *   <li>{@link ImmutableFlowUpdateCommand#logicalFlowId(Long)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableFlowUpdateCommand.Builder actualBuilderResult = ImmutableFlowUpdateCommand.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.logicalFlowId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowUpdateCommand.Builder#action(FlowUpdateCommandType)}
   */
  @Test
  void testBuilderAction() {
    // Arrange
    ImmutableFlowUpdateCommand.Builder builderResult = ImmutableFlowUpdateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.action(FlowUpdateCommandType.ADD));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowUpdateCommand.Builder#dataTypeRef(EntityReference)}
   */
  @Test
  void testBuilderDataTypeRef() {
    // Arrange
    ImmutableFlowUpdateCommand.Builder builderResult = ImmutableFlowUpdateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dataTypeRef(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowUpdateCommand.Builder#from(FlowUpdateCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableFlowUpdateCommand.Builder builderResult = ImmutableFlowUpdateCommand.builder();
    FlowUpdateCommand instance = mock(FlowUpdateCommand.class);
    when(instance.sourceEntityRef()).thenThrow(new IllegalStateException("instance"));
    when(instance.action()).thenReturn(FlowUpdateCommandType.ADD);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).action();
    verify(instance).sourceEntityRef();
  }

  /**
   * Method under test:
   * {@link ImmutableFlowUpdateCommand.Builder#from(FlowUpdateCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableFlowUpdateCommand.Builder builderResult = ImmutableFlowUpdateCommand.builder();
    FlowUpdateCommand instance = mock(FlowUpdateCommand.class);
    when(instance.targetEntityRef()).thenThrow(new IllegalStateException("instance"));
    when(instance.sourceEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.action()).thenReturn(FlowUpdateCommandType.ADD);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).action();
    verify(instance).sourceEntityRef();
    verify(instance).targetEntityRef();
  }

  /**
   * Method under test:
   * {@link ImmutableFlowUpdateCommand.Builder#from(FlowUpdateCommand)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableFlowUpdateCommand.Builder builderResult = ImmutableFlowUpdateCommand.builder();
    FlowUpdateCommand instance = mock(FlowUpdateCommand.class);
    when(instance.dataTypeRef()).thenThrow(new IllegalStateException("instance"));
    when(instance.targetEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.sourceEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.action()).thenReturn(FlowUpdateCommandType.ADD);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).action();
    verify(instance).dataTypeRef();
    verify(instance).sourceEntityRef();
    verify(instance).targetEntityRef();
  }

  /**
   * Method under test:
   * {@link ImmutableFlowUpdateCommand.Builder#from(FlowUpdateCommand)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableFlowUpdateCommand.Builder builderResult = ImmutableFlowUpdateCommand.builder();
    FlowUpdateCommand instance = mock(FlowUpdateCommand.class);
    when(instance.logicalFlowId()).thenReturn(1L);
    when(instance.dataTypeRef()).thenReturn(mock(EntityReference.class));
    when(instance.targetEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.sourceEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.action()).thenReturn(FlowUpdateCommandType.ADD);

    // Act
    ImmutableFlowUpdateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).action();
    verify(instance).dataTypeRef();
    verify(instance).logicalFlowId();
    verify(instance).sourceEntityRef();
    verify(instance).targetEntityRef();
    ImmutableFlowUpdateCommand buildResult = builderResult.build();
    assertEquals(1L, buildResult.logicalFlowId().longValue());
    assertEquals(FlowUpdateCommandType.ADD, buildResult.action());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowUpdateCommand.Builder#from(FlowUpdateCommand)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableFlowUpdateCommand.Builder builderResult = ImmutableFlowUpdateCommand.builder();
    FlowUpdateCommand instance = mock(FlowUpdateCommand.class);
    when(instance.logicalFlowId()).thenReturn(null);
    when(instance.dataTypeRef()).thenReturn(mock(EntityReference.class));
    when(instance.targetEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.sourceEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.action()).thenReturn(FlowUpdateCommandType.ADD);

    // Act
    ImmutableFlowUpdateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).action();
    verify(instance).dataTypeRef();
    verify(instance).logicalFlowId();
    verify(instance).sourceEntityRef();
    verify(instance).targetEntityRef();
    ImmutableFlowUpdateCommand buildResult = builderResult.build();
    assertNull(buildResult.logicalFlowId());
    assertEquals(FlowUpdateCommandType.ADD, buildResult.action());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowUpdateCommand.Builder#from(FlowUpdateCommand)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableFlowUpdateCommand.Builder builderResult = ImmutableFlowUpdateCommand.builder();
    FlowUpdateCommand instance = mock(FlowUpdateCommand.class);
    when(instance.logicalFlowId()).thenThrow(new IllegalStateException("instance"));
    when(instance.dataTypeRef()).thenReturn(mock(EntityReference.class));
    when(instance.targetEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.sourceEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.action()).thenReturn(FlowUpdateCommandType.ADD);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).action();
    verify(instance).dataTypeRef();
    verify(instance).logicalFlowId();
    verify(instance).sourceEntityRef();
    verify(instance).targetEntityRef();
  }

  /**
   * Method under test:
   * {@link ImmutableFlowUpdateCommand.Builder#sourceEntityRef(EntityReference)}
   */
  @Test
  void testBuilderSourceEntityRef() {
    // Arrange
    ImmutableFlowUpdateCommand.Builder builderResult = ImmutableFlowUpdateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.sourceEntityRef(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowUpdateCommand.Builder#targetEntityRef(EntityReference)}
   */
  @Test
  void testBuilderTargetEntityRef() {
    // Arrange
    ImmutableFlowUpdateCommand.Builder builderResult = ImmutableFlowUpdateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetEntityRef(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowUpdateCommand#copyOf(FlowUpdateCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    FlowUpdateCommand instance = mock(FlowUpdateCommand.class);
    when(instance.logicalFlowId()).thenReturn(1L);
    when(instance.dataTypeRef()).thenReturn(mock(EntityReference.class));
    when(instance.targetEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.sourceEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.action()).thenReturn(FlowUpdateCommandType.ADD);

    // Act
    ImmutableFlowUpdateCommand actualCopyOfResult = ImmutableFlowUpdateCommand.copyOf(instance);

    // Assert
    verify(instance).action();
    verify(instance).dataTypeRef();
    verify(instance).logicalFlowId();
    verify(instance).sourceEntityRef();
    verify(instance).targetEntityRef();
    assertEquals(1L, actualCopyOfResult.logicalFlowId().longValue());
    assertEquals(FlowUpdateCommandType.ADD, actualCopyOfResult.action());
  }
}
