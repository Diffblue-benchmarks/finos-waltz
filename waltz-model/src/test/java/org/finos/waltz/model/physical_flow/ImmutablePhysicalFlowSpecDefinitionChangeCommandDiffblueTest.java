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

class ImmutablePhysicalFlowSpecDefinitionChangeCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowSpecDefinitionChangeCommand.Builder#from(PhysicalFlowSpecDefinitionChangeCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutablePhysicalFlowSpecDefinitionChangeCommand.Builder builderResult = ImmutablePhysicalFlowSpecDefinitionChangeCommand
        .builder();
    PhysicalFlowSpecDefinitionChangeCommand instance = mock(PhysicalFlowSpecDefinitionChangeCommand.class);
    when(instance.newSpecDefinitionId()).thenReturn(1L);

    // Act
    ImmutablePhysicalFlowSpecDefinitionChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).newSpecDefinitionId();
    assertEquals(1L, actualFromResult.build().newSpecDefinitionId());
    assertEquals(1L, builderResult.build().newSpecDefinitionId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowSpecDefinitionChangeCommand.Builder#newSpecDefinitionId(long)}
   */
  @Test
  void testBuilderNewSpecDefinitionId() {
    // Arrange
    ImmutablePhysicalFlowSpecDefinitionChangeCommand.Builder builderResult = ImmutablePhysicalFlowSpecDefinitionChangeCommand
        .builder();

    // Act
    ImmutablePhysicalFlowSpecDefinitionChangeCommand.Builder actualNewSpecDefinitionIdResult = builderResult
        .newSpecDefinitionId(1L);

    // Assert
    assertEquals(1L, actualNewSpecDefinitionIdResult.build().newSpecDefinitionId());
    assertEquals(1L, builderResult.build().newSpecDefinitionId());
    assertSame(builderResult, actualNewSpecDefinitionIdResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowSpecDefinitionChangeCommand#copyOf(PhysicalFlowSpecDefinitionChangeCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    PhysicalFlowSpecDefinitionChangeCommand instance = mock(PhysicalFlowSpecDefinitionChangeCommand.class);
    when(instance.newSpecDefinitionId()).thenReturn(1L);

    // Act
    ImmutablePhysicalFlowSpecDefinitionChangeCommand actualCopyOfResult = ImmutablePhysicalFlowSpecDefinitionChangeCommand
        .copyOf(instance);

    // Assert
    verify(instance).newSpecDefinitionId();
    assertEquals(1L, actualCopyOfResult.newSpecDefinitionId());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutablePhysicalFlowSpecDefinitionChangeCommand.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutablePhysicalFlowSpecDefinitionChangeCommand.Json actualJson = new ImmutablePhysicalFlowSpecDefinitionChangeCommand.Json();

    // Assert
    assertEquals(0L, actualJson.newSpecDefinitionId);
    assertFalse(actualJson.newSpecDefinitionIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowSpecDefinitionChangeCommand.Json#newSpecDefinitionId()}
   */
  @Test
  void testJsonNewSpecDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowSpecDefinitionChangeCommand.Json()).newSpecDefinitionId());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowSpecDefinitionChangeCommand.Json#setNewSpecDefinitionId(long)}
   */
  @Test
  void testJsonSetNewSpecDefinitionId() {
    // Arrange
    ImmutablePhysicalFlowSpecDefinitionChangeCommand.Json json = new ImmutablePhysicalFlowSpecDefinitionChangeCommand.Json();

    // Act
    json.setNewSpecDefinitionId(1L);

    // Assert
    assertEquals(1L, json.newSpecDefinitionId);
    assertTrue(json.newSpecDefinitionIdIsSet);
  }
}
