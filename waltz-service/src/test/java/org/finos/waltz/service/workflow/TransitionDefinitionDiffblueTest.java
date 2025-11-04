package org.finos.waltz.service.workflow;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.internal.Engine;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TransitionDefinitionDiffblueTest {
  /**
   * Method under test: {@link TransitionDefinition#compile(JexlEngine)}
   */
  @Test
  void testCompile() {
    // Arrange
    TransitionDefinition transitionDefinition = mock(TransitionDefinition.class);
    when(transitionDefinition.compile(Mockito.<JexlEngine>any())).thenReturn(null);

    // Act
    transitionDefinition.compile(new Engine());

    // Assert
    verify(transitionDefinition).compile(isA(JexlEngine.class));
  }
}
