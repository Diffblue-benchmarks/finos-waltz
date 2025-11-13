package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlExpression;
import org.apache.commons.jexl3.internal.Engine;
import org.apache.commons.jexl3.internal.Script;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TransitionDefinitionDiffblueTest {
  /**
   * Test {@link TransitionDefinition#compile(JexlEngine)}.
   *
   * <ul>
   *   <li>Then return {@code Initial State}.
   * </ul>
   *
   * <p>Method under test: {@link TransitionDefinition#compile(JexlEngine)}
   */
  @Test
  @DisplayName("Test compile(JexlEngine); then return 'Initial State'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompiledTransitionDefinition TransitionDefinition.compile(JexlEngine)"})
  void testCompile_thenReturnInitialState() {
    // Arrange
    ImmutableTransitionDefinition immutableTransitionDefinition =
        ImmutableTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate("Predicate")
            .targetState("Target State")
            .build();
    Engine jexl = new Engine();

    // Act
    CompiledTransitionDefinition actualCompileResult = immutableTransitionDefinition.compile(jexl);

    // Assert
    JexlExpression predicateResult = actualCompileResult.predicate();
    JexlEngine engine = ((Script) predicateResult).getEngine();
    assertTrue(engine instanceof Engine);
    assertTrue(predicateResult instanceof Script);
    assertTrue(actualCompileResult instanceof ImmutableCompiledTransitionDefinition);
    assertEquals("Initial State", actualCompileResult.initialState());
    assertEquals("Name", actualCompileResult.name());
    assertEquals("Predicate", predicateResult.getParsedText());
    assertEquals("Predicate", predicateResult.getSourceText());
    assertEquals("Target State", actualCompileResult.targetState());
    assertNull(((Script) predicateResult).getLocalVariables());
    assertNull(((Script) predicateResult).getParameters());
    assertNull(((Script) predicateResult).getUnboundParameters());
    assertEquals(1, ((Script) predicateResult).getVariables().size());
    assertTrue(((Script) predicateResult).getPragmas().isEmpty());
    assertSame(jexl, engine);
  }

  /**
   * Test {@link TransitionDefinition#compile(JexlEngine)}.
   *
   * <ul>
   *   <li>Then return initialState is {@code name}.
   * </ul>
   *
   * <p>Method under test: {@link TransitionDefinition#compile(JexlEngine)}
   */
  @Test
  @DisplayName("Test compile(JexlEngine); then return initialState is 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompiledTransitionDefinition TransitionDefinition.compile(JexlEngine)"})
  void testCompile_thenReturnInitialStateIsName() {
    // Arrange
    ImmutableTransitionDefinition immutableTransitionDefinition =
        ImmutableTransitionDefinition.builder()
            .initialState("name")
            .name("Name")
            .predicate("Predicate")
            .targetState("Target State")
            .build();
    Engine jexl = new Engine();

    // Act
    CompiledTransitionDefinition actualCompileResult = immutableTransitionDefinition.compile(jexl);

    // Assert
    JexlExpression predicateResult = actualCompileResult.predicate();
    JexlEngine engine = ((Script) predicateResult).getEngine();
    assertTrue(engine instanceof Engine);
    assertTrue(predicateResult instanceof Script);
    assertTrue(actualCompileResult instanceof ImmutableCompiledTransitionDefinition);
    assertEquals("Name", actualCompileResult.name());
    assertEquals("Predicate", predicateResult.getParsedText());
    assertEquals("Predicate", predicateResult.getSourceText());
    assertEquals("Target State", actualCompileResult.targetState());
    assertEquals("name", actualCompileResult.initialState());
    assertNull(((Script) predicateResult).getLocalVariables());
    assertNull(((Script) predicateResult).getParameters());
    assertNull(((Script) predicateResult).getUnboundParameters());
    assertEquals(1, ((Script) predicateResult).getVariables().size());
    assertTrue(((Script) predicateResult).getPragmas().isEmpty());
    assertSame(jexl, engine);
  }
}
