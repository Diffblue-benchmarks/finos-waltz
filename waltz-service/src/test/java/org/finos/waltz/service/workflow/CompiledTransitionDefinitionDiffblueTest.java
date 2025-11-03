package org.finos.waltz.service.workflow;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.commons.jexl3.MapContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CompiledTransitionDefinitionDiffblueTest {
  /**
   * Test {@link CompiledTransitionDefinition#test(MapContext)} with {@code MapContext}.
   * <ul>
   *   <li>Given {@link CompiledTransitionDefinition} {@link CompiledTransitionDefinition#test(MapContext)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompiledTransitionDefinition#test(MapContext)}
   */
  @Test
  @DisplayName("Test test(MapContext) with 'MapContext'; given CompiledTransitionDefinition test(MapContext) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CompiledTransitionDefinition.test(MapContext)"})
  void testTestWithMapContext_givenCompiledTransitionDefinitionTestReturnFalse() {
    // Arrange
    CompiledTransitionDefinition compiledTransitionDefinition = mock(CompiledTransitionDefinition.class);
    when(compiledTransitionDefinition.test(Mockito.<MapContext>any())).thenReturn(false);

    // Act
    compiledTransitionDefinition.test(new MapContext());

    // Assert
    verify(compiledTransitionDefinition).test(isA(MapContext.class));
  }

  /**
   * Test {@link CompiledTransitionDefinition#test(MapContext)} with {@code MapContext}.
   * <ul>
   *   <li>Given {@link CompiledTransitionDefinition} {@link CompiledTransitionDefinition#test(MapContext)} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompiledTransitionDefinition#test(MapContext)}
   */
  @Test
  @DisplayName("Test test(MapContext) with 'MapContext'; given CompiledTransitionDefinition test(MapContext) return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CompiledTransitionDefinition.test(MapContext)"})
  void testTestWithMapContext_givenCompiledTransitionDefinitionTestReturnTrue() {
    // Arrange
    CompiledTransitionDefinition compiledTransitionDefinition = mock(CompiledTransitionDefinition.class);
    when(compiledTransitionDefinition.test(Mockito.<MapContext>any())).thenReturn(true);

    // Act
    compiledTransitionDefinition.test(new MapContext());

    // Assert
    verify(compiledTransitionDefinition).test(isA(MapContext.class));
  }
}
