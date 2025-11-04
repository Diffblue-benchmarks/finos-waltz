package org.finos.waltz.data.software_catalog;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdSelectionOptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SoftwareVersionIdSelectorFactory.class})
@ExtendWith(SpringExtension.class)
class SoftwareVersionIdSelectorFactoryDiffblueTest {
  @Autowired
  private SoftwareVersionIdSelectorFactory softwareVersionIdSelectorFactory;

  /**
   * Method under test:
   * {@link SoftwareVersionIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  void testApply() {
    // Arrange
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenThrow(new UnsupportedOperationException("options cannot be null"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> softwareVersionIdSelectorFactory.apply(options));
    verify(options).entityReference();
  }

  /**
   * Method under test:
   * {@link SoftwareVersionIdSelectorFactory#apply(IdSelectionOptions)}
   */
  @Test
  void testApply2() {
    // Arrange
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> softwareVersionIdSelectorFactory.apply(options));
    verify(entityReference).kind();
    verify(options).entityReference();
  }
}
