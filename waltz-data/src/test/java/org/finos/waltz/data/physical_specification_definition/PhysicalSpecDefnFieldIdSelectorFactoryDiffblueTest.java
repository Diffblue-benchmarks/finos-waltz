package org.finos.waltz.data.physical_specification_definition;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdSelectionOptions;
import org.junit.jupiter.api.Test;

class PhysicalSpecDefnFieldIdSelectorFactoryDiffblueTest {
  /**
   * Method under test:
   * {@link PhysicalSpecDefnFieldIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  void testApply() {
    // Arrange
    PhysicalSpecDefnFieldIdSelectorFactory physicalSpecDefnFieldIdSelectorFactory = new PhysicalSpecDefnFieldIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> physicalSpecDefnFieldIdSelectorFactory.apply(options));
    verify(entityReference).kind();
    verify(options).entityReference();
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDefnFieldIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  void testApply2() {
    // Arrange
    PhysicalSpecDefnFieldIdSelectorFactory physicalSpecDefnFieldIdSelectorFactory = new PhysicalSpecDefnFieldIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenThrow(new UnsupportedOperationException("options cannot be null"));
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> physicalSpecDefnFieldIdSelectorFactory.apply(options));
    verify(entityReference).kind();
    verify(options).entityReference();
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDefnFieldIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  void testApply3() {
    // Arrange
    PhysicalSpecDefnFieldIdSelectorFactory physicalSpecDefnFieldIdSelectorFactory = new PhysicalSpecDefnFieldIdSelectorFactory();
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenThrow(new UnsupportedOperationException("options cannot be null"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> physicalSpecDefnFieldIdSelectorFactory.apply(options));
    verify(options).entityReference();
  }
}
