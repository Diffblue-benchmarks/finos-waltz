package org.finos.waltz.model.checkpoint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.checkpoint.ImmutableCheckpointGoal.Builder;
import org.finos.waltz.model.checkpoint.ImmutableCheckpointGoal.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCheckpointGoalDiffblueTest {
  /**
   * Test Builder {@link Builder#checkpointId(long)}.
   * <p>
   * Method under test: {@link Builder#checkpointId(long)}
   */
  @Test
  @DisplayName("Test Builder checkpointId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.checkpointId(long)"})
  void testBuilderCheckpointId() {
    // Arrange
    Builder builderResult = ImmutableCheckpointGoal.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.checkpointId(1L));
  }

  /**
   * Test Builder {@link Builder#from(CheckpointGoal)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>Then builder build value is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CheckpointGoal)}
   */
  @Test
  @DisplayName("Test Builder from(CheckpointGoal); given ten; then builder build value is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CheckpointGoal)"})
  void testBuilderFrom_givenTen_thenBuilderBuildValueIsTen() {
    // Arrange
    Builder builderResult = ImmutableCheckpointGoal.builder();
    CheckpointGoal instance = mock(CheckpointGoal.class);
    when(instance.value()).thenReturn(10.0d);
    when(instance.checkpointId()).thenReturn(1L);
    when(instance.goalType()).thenReturn(GoalType.ABOVE_THRESHOLD);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#goalType(GoalType)}.
   * <p>
   * Method under test: {@link Builder#goalType(GoalType)}
   */
  @Test
  @DisplayName("Test Builder goalType(GoalType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.goalType(GoalType)"})
  void testBuilderGoalType() {
    // Arrange
    Builder builderResult = ImmutableCheckpointGoal.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.goalType(GoalType.ABOVE_THRESHOLD));
  }

  /**
   * Test Builder {@link Builder#value(double)}.
   * <p>
   * Method under test: {@link Builder#value(double)}
   */
  @Test
  @DisplayName("Test Builder value(double)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.value(double)"})
  void testBuilderValue() {
    // Arrange
    Builder builderResult = ImmutableCheckpointGoal.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.value(10.0d));
  }

  /**
   * Test Json {@link Json#checkpointId()}.
   * <p>
   * Method under test: {@link Json#checkpointId()}
   */
  @Test
  @DisplayName("Test Json checkpointId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.checkpointId()"})
  void testJsonCheckpointId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).checkpointId());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setGoalType(GoalType)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setGoalType(GoalType)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setGoalType(GoalType.ABOVE_THRESHOLD);

    // Assert
    assertEquals(0.0d, actualJson.value);
    assertEquals(0L, actualJson.checkpointId);
    assertEquals(GoalType.ABOVE_THRESHOLD, actualJson.goalType);
    assertFalse(actualJson.checkpointIdIsSet);
    assertFalse(actualJson.valueIsSet);
  }

  /**
   * Test Json {@link Json#goalType()}.
   * <p>
   * Method under test: {@link Json#goalType()}
   */
  @Test
  @DisplayName("Test Json goalType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GoalType Json.goalType()"})
  void testJsonGoalType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).goalType());
  }

  /**
   * Test Json {@link Json#setCheckpointId(long)}.
   * <p>
   * Method under test: {@link Json#setCheckpointId(long)}
   */
  @Test
  @DisplayName("Test Json setCheckpointId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setCheckpointId(long)"})
  void testJsonSetCheckpointId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setCheckpointId(1L);

    // Assert
    assertEquals(1L, json.checkpointId);
    assertTrue(json.checkpointIdIsSet);
  }

  /**
   * Test Json {@link Json#setValue(double)}.
   * <p>
   * Method under test: {@link Json#setValue(double)}
   */
  @Test
  @DisplayName("Test Json setValue(double)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setValue(double)"})
  void testJsonSetValue() {
    // Arrange
    Json json = new Json();

    // Act
    json.setValue(10.0d);

    // Assert
    assertEquals(10.0d, json.value);
    assertTrue(json.valueIsSet);
  }

  /**
   * Test Json {@link Json#value()}.
   * <p>
   * Method under test: {@link Json#value()}
   */
  @Test
  @DisplayName("Test Json value()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double Json.value()"})
  void testJsonValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).value());
  }
}
