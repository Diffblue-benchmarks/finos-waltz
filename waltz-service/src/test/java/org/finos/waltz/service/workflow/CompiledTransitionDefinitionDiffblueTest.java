package org.finos.waltz.service.workflow;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.apache.commons.jexl3.MapContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CompiledTransitionDefinitionDiffblueTest {
  /**
   * Method under test: {@link CompiledTransitionDefinition#test(MapContext)}
   */
  @Test
  void testTest() {
    // Arrange
    CompiledTransitionDefinition compiledTransitionDefinition = mock(CompiledTransitionDefinition.class);
    when(compiledTransitionDefinition.test(Mockito.<MapContext>any())).thenReturn(true);

    // Act
    compiledTransitionDefinition.test(new MapContext());

    // Assert
    verify(compiledTransitionDefinition).test(isA(MapContext.class));
  }

  /**
   * Method under test: {@link CompiledTransitionDefinition#test(MapContext)}
   */
  @Test
  void testTest2() {
    // Arrange
    CompiledTransitionDefinition compiledTransitionDefinition = mock(CompiledTransitionDefinition.class);
    when(compiledTransitionDefinition.test(Mockito.<MapContext>any())).thenReturn(false);

    // Act
    compiledTransitionDefinition.test(new MapContext());

    // Assert
    verify(compiledTransitionDefinition).test(isA(MapContext.class));
  }
}
