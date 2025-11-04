package org.finos.waltz.jobs.harness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;

class HarnessUtilitiesDiffblueTest {
  /**
   * Method under test: {@link HarnessUtilities#time(String, Supplier)}
   */
  @Test
  void testTime() {
    // Arrange
    Supplier<Object> s = mock(Supplier.class);
    when(s.get()).thenReturn("Get");

    // Act
    Object actualTimeResult = HarnessUtilities.time("Name", s);

    // Assert
    verify(s).get();
    assertEquals("Get", actualTimeResult);
  }
}
