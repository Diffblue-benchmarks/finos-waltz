package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class NameHelperDiffblueTest {
  /**
   * Method under test: {@link NameHelper#toName(EntityReference)}
   */
  @Test
  void testToName() {
    // Arrange
    EntityReference ref = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(ref.name()).thenReturn(ofResult);

    // Act
    String actualToNameResult = NameHelper.toName(ref);

    // Assert
    verify(ref).name();
    assertEquals("foo", actualToNameResult);
  }

  /**
   * Method under test: {@link NameHelper#toName(EntityReference)}
   */
  @Test
  void testToName2() {
    // Arrange
    EntityReference ref = mock(EntityReference.class);
    Optional<String> emptyResult = Optional.empty();
    when(ref.name()).thenReturn(emptyResult);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> NameHelper.toName(ref));
    verify(ref).name();
  }

  /**
   * Method under test: {@link NameHelper#toName(EntityReference)}
   */
  @Test
  void testToName3() {
    // Arrange
    EntityReference ref = mock(EntityReference.class);
    when(ref.name()).thenThrow(new IllegalStateException("Reference %s, has no name!"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> NameHelper.toName(ref));
    verify(ref).name();
  }
}
