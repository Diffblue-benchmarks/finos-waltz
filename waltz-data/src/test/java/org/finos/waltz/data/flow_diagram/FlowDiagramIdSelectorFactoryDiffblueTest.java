package org.finos.waltz.data.flow_diagram;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.junit.jupiter.api.Test;

class FlowDiagramIdSelectorFactoryDiffblueTest {
  /**
   * Method under test:
   * {@link FlowDiagramIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  void testApply() {
    // Arrange
    FlowDiagramIdSelectorFactory flowDiagramIdSelectorFactory = new FlowDiagramIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> flowDiagramIdSelectorFactory.apply(options));
    verify(entityReference).kind();
    verify(options).entityReference();
  }

  /**
   * Method under test:
   * {@link FlowDiagramIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  void testApply2() {
    // Arrange
    FlowDiagramIdSelectorFactory flowDiagramIdSelectorFactory = new FlowDiagramIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenThrow(new UnsupportedOperationException("options cannot be null"));
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> flowDiagramIdSelectorFactory.apply(options));
    verify(entityReference).kind();
    verify(options).entityReference();
  }

  /**
   * Method under test:
   * {@link FlowDiagramIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  void testApply3() {
    // Arrange
    FlowDiagramIdSelectorFactory flowDiagramIdSelectorFactory = new FlowDiagramIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    flowDiagramIdSelectorFactory.apply(options);

    // Assert
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
  }

  /**
   * Method under test:
   * {@link FlowDiagramIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  void testApply4() {
    // Arrange
    FlowDiagramIdSelectorFactory flowDiagramIdSelectorFactory = new FlowDiagramIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenThrow(new UnsupportedOperationException("options cannot be null"));
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> flowDiagramIdSelectorFactory.apply(options));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
  }
}
