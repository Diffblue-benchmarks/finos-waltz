package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.commons.jexl3.JexlExpression;
import org.finos.waltz.service.workflow.ImmutableCompiledTransitionDefinition.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCompiledTransitionDefinitionDiffblueTest {
  /**
   * Test Builder {@link Builder#from(CompiledTransitionDefinition)}.
   * <ul>
   *   <li>Given {@code Target State}.</li>
   *   <li>Then builder build initialState is {@code Initial State}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CompiledTransitionDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(CompiledTransitionDefinition); given 'Target State'; then builder build initialState is 'Initial State'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CompiledTransitionDefinition)"})
  void testBuilderFrom_givenTargetState_thenBuilderBuildInitialStateIsInitialState() {
    // Arrange
    Builder builderResult = ImmutableCompiledTransitionDefinition.builder();
    CompiledTransitionDefinition instance = mock(CompiledTransitionDefinition.class);
    when(instance.targetState()).thenReturn("Target State");
    when(instance.initialState()).thenReturn("Initial State");
    when(instance.predicate()).thenReturn(mock(JexlExpression.class));
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(CompiledTransitionDefinition)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CompiledTransitionDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(CompiledTransitionDefinition); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CompiledTransitionDefinition)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableCompiledTransitionDefinition.builder();
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
   * Test Builder {@link Builder#initialState(String)}.
   * <p>
   * Method under test: {@link Builder#initialState(String)}
   */
  @Test
  @DisplayName("Test Builder initialState(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.initialState(String)"})
  void testBuilderInitialState() {
    // Arrange
    Builder builderResult = ImmutableCompiledTransitionDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.initialState("Initial State"));
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   * <p>
   * Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder builderResult = ImmutableCompiledTransitionDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Builder {@link Builder#predicate(JexlExpression)}.
   * <p>
   * Method under test: {@link Builder#predicate(JexlExpression)}
   */
  @Test
  @DisplayName("Test Builder predicate(JexlExpression)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.predicate(JexlExpression)"})
  void testBuilderPredicate() {
    // Arrange
    Builder builderResult = ImmutableCompiledTransitionDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.predicate(mock(JexlExpression.class)));
  }

  /**
   * Test Builder {@link Builder#targetState(String)}.
   * <p>
   * Method under test: {@link Builder#targetState(String)}
   */
  @Test
  @DisplayName("Test Builder targetState(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.targetState(String)"})
  void testBuilderTargetState() {
    // Arrange
    Builder builderResult = ImmutableCompiledTransitionDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetState("Target State"));
  }
}
