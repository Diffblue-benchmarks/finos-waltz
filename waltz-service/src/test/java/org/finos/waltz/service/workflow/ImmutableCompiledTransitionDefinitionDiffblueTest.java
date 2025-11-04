package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.apache.commons.jexl3.JexlExpression;
import org.junit.jupiter.api.Test;

class ImmutableCompiledTransitionDefinitionDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableCompiledTransitionDefinition.Builder#from(CompiledTransitionDefinition)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableCompiledTransitionDefinition.Builder builderResult = ImmutableCompiledTransitionDefinition.builder();
    CompiledTransitionDefinition instance = mock(CompiledTransitionDefinition.class);
    when(instance.targetState()).thenReturn("Target State");
    when(instance.initialState()).thenReturn("Initial State");
    when(instance.predicate()).thenReturn(mock(JexlExpression.class));
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableCompiledTransitionDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).initialState();
    verify(instance).name();
    verify(instance).predicate();
    verify(instance).targetState();
    ImmutableCompiledTransitionDefinition buildResult = builderResult.build();
    assertEquals("Initial State", buildResult.initialState());
    assertEquals("Name", buildResult.name());
    assertEquals("Target State", buildResult.targetState());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCompiledTransitionDefinition.Builder#from(CompiledTransitionDefinition)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableCompiledTransitionDefinition.Builder builderResult = ImmutableCompiledTransitionDefinition.builder();
    CompiledTransitionDefinition instance = mock(CompiledTransitionDefinition.class);
    when(instance.targetState()).thenThrow(new IllegalStateException("instance"));
    when(instance.initialState()).thenReturn("Initial State");
    when(instance.predicate()).thenReturn(mock(JexlExpression.class));
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
   * {@link ImmutableCompiledTransitionDefinition.Builder#initialState(String)}
   */
  @Test
  void testBuilderInitialState() {
    // Arrange
    ImmutableCompiledTransitionDefinition.Builder builderResult = ImmutableCompiledTransitionDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.initialState("Initial State"));
  }

  /**
   * Method under test:
   * {@link ImmutableCompiledTransitionDefinition.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableCompiledTransitionDefinition.Builder builderResult = ImmutableCompiledTransitionDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableCompiledTransitionDefinition.Builder#predicate(JexlExpression)}
   */
  @Test
  void testBuilderPredicate() {
    // Arrange
    ImmutableCompiledTransitionDefinition.Builder builderResult = ImmutableCompiledTransitionDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.predicate(mock(JexlExpression.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableCompiledTransitionDefinition.Builder#targetState(String)}
   */
  @Test
  void testBuilderTargetState() {
    // Arrange
    ImmutableCompiledTransitionDefinition.Builder builderResult = ImmutableCompiledTransitionDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetState("Target State"));
  }

  /**
   * Method under test:
   * {@link ImmutableCompiledTransitionDefinition#copyOf(CompiledTransitionDefinition)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    CompiledTransitionDefinition instance = mock(CompiledTransitionDefinition.class);
    when(instance.targetState()).thenReturn("Target State");
    when(instance.initialState()).thenReturn("Initial State");
    when(instance.predicate()).thenReturn(mock(JexlExpression.class));
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableCompiledTransitionDefinition actualCopyOfResult = ImmutableCompiledTransitionDefinition.copyOf(instance);

    // Assert
    verify(instance).initialState();
    verify(instance).name();
    verify(instance).predicate();
    verify(instance).targetState();
    assertEquals("Initial State", actualCopyOfResult.initialState());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Target State", actualCopyOfResult.targetState());
  }
}
