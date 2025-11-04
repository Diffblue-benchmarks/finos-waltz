package org.finos.waltz.data.person;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdSelectionOptions;
import org.junit.jupiter.api.Test;

class PersonIdSelectorFactoryDiffblueTest {
  /**
   * Method under test:
   * {@link PersonIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  void testMkForOptions() {
    // Arrange
    PersonIdSelectorFactory personIdSelectorFactory = new PersonIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> personIdSelectorFactory.mkForOptions(options));
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
  }

  /**
   * Method under test:
   * {@link PersonIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  void testMkForOptions2() {
    // Arrange
    PersonIdSelectorFactory personIdSelectorFactory = new PersonIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenThrow(new UnsupportedOperationException("foo"));
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> personIdSelectorFactory.mkForOptions(options));
    verify(entityReference).kind();
    verify(options).entityReference();
  }

  /**
   * Method under test:
   * {@link PersonIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  void testMkForOptions3() {
    // Arrange
    PersonIdSelectorFactory personIdSelectorFactory = new PersonIdSelectorFactory();
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenThrow(new UnsupportedOperationException("foo"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> personIdSelectorFactory.mkForOptions(options));
    verify(options).entityReference();
  }
}
