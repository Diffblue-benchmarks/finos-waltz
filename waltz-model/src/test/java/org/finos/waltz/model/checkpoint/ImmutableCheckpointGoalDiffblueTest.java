package org.finos.waltz.model.checkpoint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableCheckpointGoalDiffblueTest {
  /**
   * Method under test: {@link ImmutableCheckpointGoal.Builder#checkpointId(long)}
   */
  @Test
  void testBuilderCheckpointId() {
    // Arrange
    ImmutableCheckpointGoal.Builder builderResult = ImmutableCheckpointGoal.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.checkpointId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableCheckpointGoal.Builder#from(CheckpointGoal)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableCheckpointGoal.Builder builderResult = ImmutableCheckpointGoal.builder();
    CheckpointGoal instance = mock(CheckpointGoal.class);
    when(instance.value()).thenReturn(10.0d);
    when(instance.checkpointId()).thenReturn(1L);
    when(instance.goalType()).thenReturn(GoalType.ABOVE_THRESHOLD);

    // Act
    ImmutableCheckpointGoal.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).checkpointId();
    verify(instance).goalType();
    verify(instance).value();
    ImmutableCheckpointGoal buildResult = builderResult.build();
    assertEquals(10.0d, buildResult.value());
    assertEquals(1L, buildResult.checkpointId());
    assertEquals(GoalType.ABOVE_THRESHOLD, buildResult.goalType());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableCheckpointGoal.Builder#goalType(GoalType)}
   */
  @Test
  void testBuilderGoalType() {
    // Arrange
    ImmutableCheckpointGoal.Builder builderResult = ImmutableCheckpointGoal.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.goalType(GoalType.ABOVE_THRESHOLD));
  }

  /**
   * Method under test: {@link ImmutableCheckpointGoal.Builder#value(double)}
   */
  @Test
  void testBuilderValue() {
    // Arrange
    ImmutableCheckpointGoal.Builder builderResult = ImmutableCheckpointGoal.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.value(10.0d));
  }

  /**
   * Method under test: {@link ImmutableCheckpointGoal#copyOf(CheckpointGoal)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    CheckpointGoal instance = mock(CheckpointGoal.class);
    when(instance.value()).thenReturn(10.0d);
    when(instance.checkpointId()).thenReturn(1L);
    when(instance.goalType()).thenReturn(GoalType.ABOVE_THRESHOLD);

    // Act
    ImmutableCheckpointGoal actualCopyOfResult = ImmutableCheckpointGoal.copyOf(instance);

    // Assert
    verify(instance).checkpointId();
    verify(instance).goalType();
    verify(instance).value();
    assertEquals(10.0d, actualCopyOfResult.value());
    assertEquals(1L, actualCopyOfResult.checkpointId());
    assertEquals(GoalType.ABOVE_THRESHOLD, actualCopyOfResult.goalType());
  }

  /**
   * Method under test: {@link ImmutableCheckpointGoal.Json#checkpointId()}
   */
  @Test
  void testJsonCheckpointId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCheckpointGoal.Json()).checkpointId());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableCheckpointGoal.Json}
   *   <li>{@link ImmutableCheckpointGoal.Json#setGoalType(GoalType)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableCheckpointGoal.Json actualJson = new ImmutableCheckpointGoal.Json();
    actualJson.setGoalType(GoalType.ABOVE_THRESHOLD);

    // Assert
    assertEquals(0.0d, actualJson.value);
    assertEquals(0L, actualJson.checkpointId);
    assertEquals(GoalType.ABOVE_THRESHOLD, actualJson.goalType);
    assertFalse(actualJson.checkpointIdIsSet);
    assertFalse(actualJson.valueIsSet);
  }

  /**
   * Method under test: {@link ImmutableCheckpointGoal.Json#goalType()}
   */
  @Test
  void testJsonGoalType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCheckpointGoal.Json()).goalType());
  }

  /**
   * Method under test: {@link ImmutableCheckpointGoal.Json#setCheckpointId(long)}
   */
  @Test
  void testJsonSetCheckpointId() {
    // Arrange
    ImmutableCheckpointGoal.Json json = new ImmutableCheckpointGoal.Json();

    // Act
    json.setCheckpointId(1L);

    // Assert
    assertEquals(1L, json.checkpointId);
    assertTrue(json.checkpointIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableCheckpointGoal.Json#setValue(double)}
   */
  @Test
  void testJsonSetValue() {
    // Arrange
    ImmutableCheckpointGoal.Json json = new ImmutableCheckpointGoal.Json();

    // Act
    json.setValue(10.0d);

    // Assert
    assertEquals(10.0d, json.value);
    assertTrue(json.valueIsSet);
  }

  /**
   * Method under test: {@link ImmutableCheckpointGoal.Json#value()}
   */
  @Test
  void testJsonValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCheckpointGoal.Json()).value());
  }
}
