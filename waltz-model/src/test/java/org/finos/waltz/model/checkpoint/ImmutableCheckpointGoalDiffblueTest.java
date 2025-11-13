package org.finos.waltz.model.checkpoint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.checkpoint.ImmutableCheckpointGoal.Builder;
import org.finos.waltz.model.checkpoint.ImmutableCheckpointGoal.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCheckpointGoalDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCheckpointGoal Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableCheckpointGoal actualImmutableCheckpointGoal =
        ImmutableCheckpointGoal.builder()
            .checkpointId(1L)
            .goalType(GoalType.ABOVE_THRESHOLD)
            .value(10.0d)
            .build();

    // Assert
    assertEquals(10.0d, actualImmutableCheckpointGoal.value());
    assertEquals(1L, actualImmutableCheckpointGoal.checkpointId());
    assertEquals(GoalType.ABOVE_THRESHOLD, actualImmutableCheckpointGoal.goalType());
  }

  /**
   * Test Builder {@link Builder#checkpointId(long)}.
   *
   * <p>Method under test: {@link Builder#checkpointId(long)}
   */
  @Test
  @DisplayName("Test Builder checkpointId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.checkpointId(long)"})
  void testBuilderCheckpointId() {
    // Arrange
    Builder builderResult = ImmutableCheckpointGoal.builder();

    // Act
    Builder actualCheckpointIdResult = builderResult.checkpointId(1L);

    // Assert
    assertSame(builderResult, actualCheckpointIdResult);
  }

  /**
   * Test Builder {@link Builder#from(CheckpointGoal)}.
   *
   * <p>Method under test: {@link Builder#from(CheckpointGoal)}
   */
  @Test
  @DisplayName("Test Builder from(CheckpointGoal)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CheckpointGoal)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableCheckpointGoal.builder();
    ImmutableCheckpointGoal instance =
        ImmutableCheckpointGoal.builder()
            .checkpointId(1L)
            .goalType(GoalType.ABOVE_THRESHOLD)
            .value(10.0d)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableCheckpointGoal actualImmutableCheckpointGoal = builderResult.build();
    assertEquals(instance, actualImmutableCheckpointGoal);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#goalType(GoalType)}.
   *
   * <p>Method under test: {@link Builder#goalType(GoalType)}
   */
  @Test
  @DisplayName("Test Builder goalType(GoalType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.goalType(GoalType)"})
  void testBuilderGoalType() {
    // Arrange
    Builder builderResult = ImmutableCheckpointGoal.builder();

    // Act
    Builder actualGoalTypeResult = builderResult.goalType(GoalType.ABOVE_THRESHOLD);

    // Assert
    assertSame(builderResult, actualGoalTypeResult);
  }

  /**
   * Test Builder {@link Builder#value(double)}.
   *
   * <p>Method under test: {@link Builder#value(double)}
   */
  @Test
  @DisplayName("Test Builder value(double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.value(double)"})
  void testBuilderValue() {
    // Arrange
    Builder builderResult = ImmutableCheckpointGoal.builder();

    // Act
    Builder actualValueResult = builderResult.value(10.0d);

    // Assert
    assertSame(builderResult, actualValueResult);
  }

  /**
   * Test {@link ImmutableCheckpointGoal#copyOf(CheckpointGoal)}.
   *
   * <ul>
   *   <li>Then return value is ten.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCheckpointGoal#copyOf(CheckpointGoal)}
   */
  @Test
  @DisplayName("Test copyOf(CheckpointGoal); then return value is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCheckpointGoal ImmutableCheckpointGoal.copyOf(CheckpointGoal)"})
  void testCopyOf_thenReturnValueIsTen() {
    // Arrange
    ImmutableCheckpointGoal instance =
        ImmutableCheckpointGoal.builder()
            .checkpointId(1L)
            .goalType(GoalType.ABOVE_THRESHOLD)
            .value(10.0d)
            .build();

    // Act
    ImmutableCheckpointGoal actualCopyOfResult = ImmutableCheckpointGoal.copyOf(instance);

    // Assert
    assertEquals(10.0d, actualCopyOfResult.value());
    assertEquals(1L, actualCopyOfResult.checkpointId());
    assertEquals(GoalType.ABOVE_THRESHOLD, actualCopyOfResult.goalType());
  }

  /**
   * Test {@link ImmutableCheckpointGoal#equals(Object)}, and {@link
   * ImmutableCheckpointGoal#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCheckpointGoal#equals(Object)}
   *   <li>{@link ImmutableCheckpointGoal#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCheckpointGoal.equals(Object)",
    "int ImmutableCheckpointGoal.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableCheckpointGoal immutableCheckpointGoal =
        ImmutableCheckpointGoal.builder()
            .checkpointId(1L)
            .goalType(GoalType.ABOVE_THRESHOLD)
            .value(10.0d)
            .build();
    ImmutableCheckpointGoal immutableCheckpointGoal2 =
        ImmutableCheckpointGoal.builder()
            .checkpointId(1L)
            .goalType(GoalType.ABOVE_THRESHOLD)
            .value(10.0d)
            .build();

    // Act and Assert
    assertEquals(immutableCheckpointGoal, immutableCheckpointGoal2);
    assertEquals(immutableCheckpointGoal.hashCode(), immutableCheckpointGoal2.hashCode());
  }

  /**
   * Test {@link ImmutableCheckpointGoal#equals(Object)}, and {@link
   * ImmutableCheckpointGoal#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCheckpointGoal#equals(Object)}
   *   <li>{@link ImmutableCheckpointGoal#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCheckpointGoal.equals(Object)",
    "int ImmutableCheckpointGoal.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableCheckpointGoal immutableCheckpointGoal =
        ImmutableCheckpointGoal.builder()
            .checkpointId(1L)
            .goalType(GoalType.ABOVE_THRESHOLD)
            .value(10.0d)
            .build();

    // Act and Assert
    assertEquals(immutableCheckpointGoal, immutableCheckpointGoal);
    int expectedHashCodeResult = immutableCheckpointGoal.hashCode();
    assertEquals(expectedHashCodeResult, immutableCheckpointGoal.hashCode());
  }

  /**
   * Test {@link ImmutableCheckpointGoal#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCheckpointGoal#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCheckpointGoal.equals(Object)",
    "int ImmutableCheckpointGoal.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableCheckpointGoal immutableCheckpointGoal =
        ImmutableCheckpointGoal.builder()
            .checkpointId(2L)
            .goalType(GoalType.ABOVE_THRESHOLD)
            .value(10.0d)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableCheckpointGoal,
        ImmutableCheckpointGoal.builder()
            .checkpointId(1L)
            .goalType(GoalType.ABOVE_THRESHOLD)
            .value(10.0d)
            .build());
  }

  /**
   * Test {@link ImmutableCheckpointGoal#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCheckpointGoal#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCheckpointGoal.equals(Object)",
    "int ImmutableCheckpointGoal.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableCheckpointGoal immutableCheckpointGoal =
        ImmutableCheckpointGoal.builder()
            .checkpointId(1L)
            .goalType(GoalType.BELOW_THRESHOLD)
            .value(10.0d)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableCheckpointGoal,
        ImmutableCheckpointGoal.builder()
            .checkpointId(1L)
            .goalType(GoalType.ABOVE_THRESHOLD)
            .value(10.0d)
            .build());
  }

  /**
   * Test {@link ImmutableCheckpointGoal#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCheckpointGoal#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCheckpointGoal.equals(Object)",
    "int ImmutableCheckpointGoal.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableCheckpointGoal immutableCheckpointGoal =
        ImmutableCheckpointGoal.builder()
            .checkpointId(1L)
            .goalType(GoalType.ABOVE_THRESHOLD)
            .value(0.5d)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableCheckpointGoal,
        ImmutableCheckpointGoal.builder()
            .checkpointId(1L)
            .goalType(GoalType.ABOVE_THRESHOLD)
            .value(10.0d)
            .build());
  }

  /**
   * Test {@link ImmutableCheckpointGoal#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCheckpointGoal#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCheckpointGoal.equals(Object)",
    "int ImmutableCheckpointGoal.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableCheckpointGoal.builder()
            .checkpointId(1L)
            .goalType(GoalType.ABOVE_THRESHOLD)
            .value(10.0d)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableCheckpointGoal#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCheckpointGoal#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCheckpointGoal.equals(Object)",
    "int ImmutableCheckpointGoal.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableCheckpointGoal.builder()
            .checkpointId(1L)
            .goalType(GoalType.ABOVE_THRESHOLD)
            .value(10.0d)
            .build(),
        "Different type to ImmutableCheckpointGoal");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCheckpointGoal#toString()}
   *   <li>{@link ImmutableCheckpointGoal#checkpointId()}
   *   <li>{@link ImmutableCheckpointGoal#goalType()}
   *   <li>{@link ImmutableCheckpointGoal#value()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long ImmutableCheckpointGoal.checkpointId()",
    "GoalType ImmutableCheckpointGoal.goalType()",
    "String ImmutableCheckpointGoal.toString()",
    "double ImmutableCheckpointGoal.value()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableCheckpointGoal immutableCheckpointGoal =
        ImmutableCheckpointGoal.builder()
            .checkpointId(1L)
            .goalType(GoalType.ABOVE_THRESHOLD)
            .value(10.0d)
            .build();

    // Act
    String actualToStringResult = immutableCheckpointGoal.toString();
    long actualCheckpointIdResult = immutableCheckpointGoal.checkpointId();
    GoalType actualGoalTypeResult = immutableCheckpointGoal.goalType();

    // Assert
    assertEquals(
        "CheckpointGoal{checkpointId=1, value=10.0, goalType=ABOVE_THRESHOLD}",
        actualToStringResult);
    assertEquals(10.0d, immutableCheckpointGoal.value());
    assertEquals(1L, actualCheckpointIdResult);
    assertEquals(GoalType.ABOVE_THRESHOLD, actualGoalTypeResult);
  }

  /**
   * Test Json {@link Json#checkpointId()}.
   *
   * <p>Method under test: {@link Json#checkpointId()}
   */
  @Test
  @DisplayName("Test Json checkpointId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.checkpointId()"})
  void testJsonCheckpointId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().checkpointId());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setGoalType(GoalType)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Json#goalType()}
   */
  @Test
  @DisplayName("Test Json goalType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GoalType Json.goalType()"})
  void testJsonGoalType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().goalType());
  }

  /**
   * Test Json {@link Json#setCheckpointId(long)}.
   *
   * <p>Method under test: {@link Json#setCheckpointId(long)}
   */
  @Test
  @DisplayName("Test Json setCheckpointId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Json#setValue(double)}
   */
  @Test
  @DisplayName("Test Json setValue(double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Json#value()}
   */
  @Test
  @DisplayName("Test Json value()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double Json.value()"})
  void testJsonValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().value());
  }

  /**
   * Test {@link ImmutableCheckpointGoal#withCheckpointId(long)}.
   *
   * <p>Method under test: {@link ImmutableCheckpointGoal#withCheckpointId(long)}
   */
  @Test
  @DisplayName("Test withCheckpointId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCheckpointGoal ImmutableCheckpointGoal.withCheckpointId(long)"})
  void testWithCheckpointId() {
    // Arrange
    ImmutableCheckpointGoal immutableCheckpointGoal =
        ImmutableCheckpointGoal.builder()
            .checkpointId(42L)
            .goalType(GoalType.ABOVE_THRESHOLD)
            .value(10.0d)
            .build();

    // Act
    ImmutableCheckpointGoal actualWithCheckpointIdResult =
        immutableCheckpointGoal.withCheckpointId(42L);

    // Assert
    assertSame(immutableCheckpointGoal, actualWithCheckpointIdResult);
  }

  /**
   * Test {@link ImmutableCheckpointGoal#withCheckpointId(long)}.
   *
   * <ul>
   *   <li>Then return value is ten.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCheckpointGoal#withCheckpointId(long)}
   */
  @Test
  @DisplayName("Test withCheckpointId(long); then return value is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCheckpointGoal ImmutableCheckpointGoal.withCheckpointId(long)"})
  void testWithCheckpointId_thenReturnValueIsTen() {
    // Arrange and Act
    ImmutableCheckpointGoal actualWithCheckpointIdResult =
        ImmutableCheckpointGoal.builder()
            .checkpointId(1L)
            .goalType(GoalType.ABOVE_THRESHOLD)
            .value(10.0d)
            .build()
            .withCheckpointId(42L);

    // Assert
    assertEquals(10.0d, actualWithCheckpointIdResult.value());
    assertEquals(42L, actualWithCheckpointIdResult.checkpointId());
    assertEquals(GoalType.ABOVE_THRESHOLD, actualWithCheckpointIdResult.goalType());
  }

  /**
   * Test {@link ImmutableCheckpointGoal#withGoalType(GoalType)}.
   *
   * <p>Method under test: {@link ImmutableCheckpointGoal#withGoalType(GoalType)}
   */
  @Test
  @DisplayName("Test withGoalType(GoalType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCheckpointGoal ImmutableCheckpointGoal.withGoalType(GoalType)"})
  void testWithGoalType() {
    // Arrange
    ImmutableCheckpointGoal immutableCheckpointGoal =
        ImmutableCheckpointGoal.builder()
            .checkpointId(1L)
            .goalType(GoalType.ABOVE_THRESHOLD)
            .value(10.0d)
            .build();

    // Act
    ImmutableCheckpointGoal actualWithGoalTypeResult =
        immutableCheckpointGoal.withGoalType(GoalType.ABOVE_THRESHOLD);

    // Assert
    assertSame(immutableCheckpointGoal, actualWithGoalTypeResult);
  }

  /**
   * Test {@link ImmutableCheckpointGoal#withGoalType(GoalType)}.
   *
   * <ul>
   *   <li>Then return value is ten.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCheckpointGoal#withGoalType(GoalType)}
   */
  @Test
  @DisplayName("Test withGoalType(GoalType); then return value is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCheckpointGoal ImmutableCheckpointGoal.withGoalType(GoalType)"})
  void testWithGoalType_thenReturnValueIsTen() {
    // Arrange and Act
    ImmutableCheckpointGoal actualWithGoalTypeResult =
        ImmutableCheckpointGoal.builder()
            .checkpointId(1L)
            .goalType(GoalType.BELOW_THRESHOLD)
            .value(10.0d)
            .build()
            .withGoalType(GoalType.ABOVE_THRESHOLD);

    // Assert
    assertEquals(10.0d, actualWithGoalTypeResult.value());
    assertEquals(1L, actualWithGoalTypeResult.checkpointId());
    assertEquals(GoalType.ABOVE_THRESHOLD, actualWithGoalTypeResult.goalType());
  }

  /**
   * Test {@link ImmutableCheckpointGoal#withValue(double)}.
   *
   * <p>Method under test: {@link ImmutableCheckpointGoal#withValue(double)}
   */
  @Test
  @DisplayName("Test withValue(double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCheckpointGoal ImmutableCheckpointGoal.withValue(double)"})
  void testWithValue() {
    // Arrange
    ImmutableCheckpointGoal immutableCheckpointGoal =
        ImmutableCheckpointGoal.builder()
            .checkpointId(1L)
            .goalType(GoalType.ABOVE_THRESHOLD)
            .value(10.0d)
            .build();

    // Act
    ImmutableCheckpointGoal actualWithValueResult = immutableCheckpointGoal.withValue(10.0d);

    // Assert
    assertSame(immutableCheckpointGoal, actualWithValueResult);
  }

  /**
   * Test {@link ImmutableCheckpointGoal#withValue(double)}.
   *
   * <ul>
   *   <li>Then return value is ten.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCheckpointGoal#withValue(double)}
   */
  @Test
  @DisplayName("Test withValue(double); then return value is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCheckpointGoal ImmutableCheckpointGoal.withValue(double)"})
  void testWithValue_thenReturnValueIsTen() {
    // Arrange and Act
    ImmutableCheckpointGoal actualWithValueResult =
        ImmutableCheckpointGoal.builder()
            .checkpointId(1L)
            .goalType(GoalType.ABOVE_THRESHOLD)
            .value(0.5d)
            .build()
            .withValue(10.0d);

    // Assert
    assertEquals(10.0d, actualWithValueResult.value());
    assertEquals(1L, actualWithValueResult.checkpointId());
    assertEquals(GoalType.ABOVE_THRESHOLD, actualWithValueResult.goalType());
  }
}
