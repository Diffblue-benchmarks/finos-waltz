package org.finos.waltz.model.physical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalFlowDeleteCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowDeleteCommand.Builder#flowId(long)}
   */
  @Test
  void testBuilderFlowId() {
    // Arrange
    ImmutablePhysicalFlowDeleteCommand.Builder builderResult = ImmutablePhysicalFlowDeleteCommand.builder();

    // Act
    ImmutablePhysicalFlowDeleteCommand.Builder actualFlowIdResult = builderResult.flowId(1L);

    // Assert
    assertEquals(1L, actualFlowIdResult.build().flowId());
    assertEquals(1L, builderResult.build().flowId());
    assertSame(builderResult, actualFlowIdResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowDeleteCommand.Builder#from(PhysicalFlowDeleteCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutablePhysicalFlowDeleteCommand.Builder builderResult = ImmutablePhysicalFlowDeleteCommand.builder();
    PhysicalFlowDeleteCommand instance = mock(PhysicalFlowDeleteCommand.class);
    when(instance.flowId()).thenReturn(1L);

    // Act
    ImmutablePhysicalFlowDeleteCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).flowId();
    assertEquals(1L, actualFromResult.build().flowId());
    assertEquals(1L, builderResult.build().flowId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowDeleteCommand#copyOf(PhysicalFlowDeleteCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    PhysicalFlowDeleteCommand instance = mock(PhysicalFlowDeleteCommand.class);
    when(instance.flowId()).thenReturn(1L);

    // Act
    ImmutablePhysicalFlowDeleteCommand actualCopyOfResult = ImmutablePhysicalFlowDeleteCommand.copyOf(instance);

    // Assert
    verify(instance).flowId();
    assertEquals(1L, actualCopyOfResult.flowId());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlowDeleteCommand.Json#flowId()}
   */
  @Test
  void testJsonFlowId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlowDeleteCommand.Json()).flowId());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutablePhysicalFlowDeleteCommand.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutablePhysicalFlowDeleteCommand.Json actualJson = new ImmutablePhysicalFlowDeleteCommand.Json();

    // Assert
    assertEquals(0L, actualJson.flowId);
    assertFalse(actualJson.flowIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowDeleteCommand.Json#setFlowId(long)}
   */
  @Test
  void testJsonSetFlowId() {
    // Arrange
    ImmutablePhysicalFlowDeleteCommand.Json json = new ImmutablePhysicalFlowDeleteCommand.Json();

    // Act
    json.setFlowId(1L);

    // Assert
    assertEquals(1L, json.flowId);
    assertTrue(json.flowIdIsSet);
  }
}
