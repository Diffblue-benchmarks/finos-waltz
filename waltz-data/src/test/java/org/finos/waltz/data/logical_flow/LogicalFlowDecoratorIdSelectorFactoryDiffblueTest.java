package org.finos.waltz.data.logical_flow;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdSelectionOptions;
import org.junit.jupiter.api.Test;

class LogicalFlowDecoratorIdSelectorFactoryDiffblueTest {
  /**
   * Method under test:
   * {@link LogicalFlowDecoratorIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  void testApply() {
    // Arrange
    LogicalFlowDecoratorIdSelectorFactory logicalFlowDecoratorIdSelectorFactory = new LogicalFlowDecoratorIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> logicalFlowDecoratorIdSelectorFactory.apply(options));
    verify(entityReference).kind();
    verify(options).entityReference();
  }

  /**
   * Method under test:
   * {@link LogicalFlowDecoratorIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  void testApply2() {
    // Arrange
    LogicalFlowDecoratorIdSelectorFactory logicalFlowDecoratorIdSelectorFactory = new LogicalFlowDecoratorIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenThrow(new UnsupportedOperationException("options cannot be null"));
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> logicalFlowDecoratorIdSelectorFactory.apply(options));
    verify(entityReference).kind();
    verify(options).entityReference();
  }

  /**
   * Method under test:
   * {@link LogicalFlowDecoratorIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  void testApply3() {
    // Arrange
    LogicalFlowDecoratorIdSelectorFactory logicalFlowDecoratorIdSelectorFactory = new LogicalFlowDecoratorIdSelectorFactory();
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenThrow(new UnsupportedOperationException("options cannot be null"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> logicalFlowDecoratorIdSelectorFactory.apply(options));
    verify(options).entityReference();
  }
}
