package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlExpression;
import org.apache.commons.jexl3.MapContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CompiledTransitionDefinitionDiffblueTest {
  /**
   * Test {@link CompiledTransitionDefinition#test(MapContext)} with {@code MapContext}.
   *
   * <ul>
   *   <li>Given {@link JexlExpression} {@link JexlExpression#evaluate(JexlContext)} return {@code
   *       Evaluate}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CompiledTransitionDefinition#test(MapContext)}
   */
  @Test
  @DisplayName(
      "Test test(MapContext) with 'MapContext'; given JexlExpression evaluate(JexlContext) return 'Evaluate'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CompiledTransitionDefinition.test(MapContext)"})
  void testTestWithMapContext_givenJexlExpressionEvaluateReturnEvaluate_thenReturnFalse() {
    // Arrange
    JexlExpression predicate = mock(JexlExpression.class);
    when(predicate.evaluate(Mockito.<JexlContext>any())).thenReturn("Evaluate");
    ImmutableCompiledTransitionDefinition immutableCompiledTransitionDefinition =
        ImmutableCompiledTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate(predicate)
            .targetState("Target State")
            .build();

    // Act
    boolean actualTestResult = immutableCompiledTransitionDefinition.test(new MapContext());

    // Assert
    verify(predicate).evaluate(isA(JexlContext.class));
    assertFalse(actualTestResult);
  }

  /**
   * Test {@link CompiledTransitionDefinition#test(MapContext)} with {@code MapContext}.
   *
   * <ul>
   *   <li>Given {@link JexlExpression} {@link JexlExpression#evaluate(JexlContext)} return {@code
   *       true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CompiledTransitionDefinition#test(MapContext)}
   */
  @Test
  @DisplayName(
      "Test test(MapContext) with 'MapContext'; given JexlExpression evaluate(JexlContext) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CompiledTransitionDefinition.test(MapContext)"})
  void testTestWithMapContext_givenJexlExpressionEvaluateReturnTrue_thenReturnTrue() {
    // Arrange
    JexlExpression predicate = mock(JexlExpression.class);
    when(predicate.evaluate(Mockito.<JexlContext>any())).thenReturn(true);
    ImmutableCompiledTransitionDefinition immutableCompiledTransitionDefinition =
        ImmutableCompiledTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate(predicate)
            .targetState("Target State")
            .build();

    // Act
    boolean actualTestResult = immutableCompiledTransitionDefinition.test(new MapContext());

    // Assert
    verify(predicate).evaluate(isA(JexlContext.class));
    assertTrue(actualTestResult);
  }
}
