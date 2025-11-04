package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;

class DebugUtilitiesDiffblueTest {
  /**
   * Method under test: {@link DebugUtilities#logValue(Object, Object[])}
   */
  @Test
  void testLogValue() {
    // Arrange, Act and Assert
    assertEquals("Result", DebugUtilities.logValue("Result", "Ctx"));
  }

  /**
   * Method under test: {@link DebugUtilities#logValue(Supplier, Object[])}
   */
  @Test
  void testLogValue2() {
    // Arrange
    Supplier<Object> resultFn = mock(Supplier.class);
    when(resultFn.get()).thenReturn("Get");

    // Act
    Object actualLogValueResult = DebugUtilities.logValue(resultFn, "Ctx");

    // Assert
    verify(resultFn).get();
    assertEquals("Get", actualLogValueResult);
  }
}
