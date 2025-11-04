package org.finos.waltz.data.legal_entity;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdSelectionOptions;
import org.junit.jupiter.api.Test;

class LegalEntityIdSelectorFactoryDiffblueTest {
  /**
   * Method under test:
   * {@link LegalEntityIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  void testMkForOptions() {
    // Arrange
    LegalEntityIdSelectorFactory legalEntityIdSelectorFactory = new LegalEntityIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> legalEntityIdSelectorFactory.mkForOptions(options));
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
  }

  /**
   * Method under test:
   * {@link LegalEntityIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  void testMkForOptions2() {
    // Arrange
    LegalEntityIdSelectorFactory legalEntityIdSelectorFactory = new LegalEntityIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenThrow(new UnsupportedOperationException("foo"));
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> legalEntityIdSelectorFactory.mkForOptions(options));
    verify(entityReference).kind();
    verify(options).entityReference();
  }

  /**
   * Method under test:
   * {@link LegalEntityIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  void testMkForOptions3() {
    // Arrange
    LegalEntityIdSelectorFactory legalEntityIdSelectorFactory = new LegalEntityIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    legalEntityIdSelectorFactory.mkForOptions(options);

    // Assert
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
  }

  /**
   * Method under test:
   * {@link LegalEntityIdSelectorFactory#mkForOptions(IdSelectionOptions)}
   */
  @Test
  void testMkForOptions4() {
    // Arrange
    LegalEntityIdSelectorFactory legalEntityIdSelectorFactory = new LegalEntityIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenThrow(new UnsupportedOperationException("foo"));
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> legalEntityIdSelectorFactory.mkForOptions(options));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link LegalEntityIdSelectorFactory}
   */
  @Test
  void testNewLegalEntityIdSelectorFactory() {
    // Arrange and Act
    LegalEntityIdSelectorFactory actualLegalEntityIdSelectorFactory = new LegalEntityIdSelectorFactory();
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);
    actualLegalEntityIdSelectorFactory.apply(options);

    // Assert
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
  }
}
