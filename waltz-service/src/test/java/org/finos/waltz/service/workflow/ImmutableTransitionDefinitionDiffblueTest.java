package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableTransitionDefinitionDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableTransitionDefinition.Builder#from(TransitionDefinition)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableTransitionDefinition.Builder builderResult = ImmutableTransitionDefinition.builder();
    TransitionDefinition instance = mock(TransitionDefinition.class);
    when(instance.targetState()).thenReturn("Target State");
    when(instance.initialState()).thenReturn("Initial State");
    when(instance.predicate()).thenReturn("Predicate");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableTransitionDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).initialState();
    verify(instance).name();
    verify(instance).predicate();
    verify(instance).targetState();
    ImmutableTransitionDefinition buildResult = builderResult.build();
    assertEquals("Initial State", buildResult.initialState());
    assertEquals("Name", buildResult.name());
    assertEquals("Predicate", buildResult.predicate());
    assertEquals("Target State", buildResult.targetState());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableTransitionDefinition.Builder#from(TransitionDefinition)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableTransitionDefinition.Builder builderResult = ImmutableTransitionDefinition.builder();
    TransitionDefinition instance = mock(TransitionDefinition.class);
    when(instance.targetState()).thenThrow(new IllegalStateException("instance"));
    when(instance.initialState()).thenReturn("Initial State");
    when(instance.predicate()).thenReturn("Predicate");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).initialState();
    verify(instance).name();
    verify(instance).predicate();
    verify(instance).targetState();
  }

  /**
   * Method under test:
   * {@link ImmutableTransitionDefinition.Builder#initialState(String)}
   */
  @Test
  void testBuilderInitialState() {
    // Arrange
    ImmutableTransitionDefinition.Builder builderResult = ImmutableTransitionDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.initialState("Initial State"));
  }

  /**
   * Method under test: {@link ImmutableTransitionDefinition.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableTransitionDefinition.Builder builderResult = ImmutableTransitionDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableTransitionDefinition.Builder#predicate(String)}
   */
  @Test
  void testBuilderPredicate() {
    // Arrange
    ImmutableTransitionDefinition.Builder builderResult = ImmutableTransitionDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.predicate("Predicate"));
  }

  /**
   * Method under test:
   * {@link ImmutableTransitionDefinition.Builder#targetState(String)}
   */
  @Test
  void testBuilderTargetState() {
    // Arrange
    ImmutableTransitionDefinition.Builder builderResult = ImmutableTransitionDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetState("Target State"));
  }

  /**
   * Method under test:
   * {@link ImmutableTransitionDefinition#copyOf(TransitionDefinition)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    TransitionDefinition instance = mock(TransitionDefinition.class);
    when(instance.targetState()).thenReturn("Target State");
    when(instance.initialState()).thenReturn("Initial State");
    when(instance.predicate()).thenReturn("Predicate");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableTransitionDefinition actualCopyOfResult = ImmutableTransitionDefinition.copyOf(instance);

    // Assert
    verify(instance).initialState();
    verify(instance).name();
    verify(instance).predicate();
    verify(instance).targetState();
    assertEquals("Initial State", actualCopyOfResult.initialState());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Predicate", actualCopyOfResult.predicate());
    assertEquals("Target State", actualCopyOfResult.targetState());
  }
}
