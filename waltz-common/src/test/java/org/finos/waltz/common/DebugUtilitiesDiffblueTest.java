package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DebugUtilitiesDiffblueTest {
  /**
   * Test {@link DebugUtilities#logValue(Object, Object[])} with {@code result}, {@code ctx}.
   * <p>
   * Method under test: {@link DebugUtilities#logValue(Object, Object[])}
   */
  @Test
  @DisplayName("Test logValue(Object, Object[]) with 'result', 'ctx'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object DebugUtilities.logValue(Object, Object[])"})
  void testLogValueWithResultCtx() {
    // Arrange, Act and Assert
    assertEquals("Result", DebugUtilities.logValue("Result", "Ctx"));
  }

  /**
   * Test {@link DebugUtilities#logValue(Supplier, Object[])} with {@code resultFn}, {@code ctx}.
   * <p>
   * Method under test: {@link DebugUtilities#logValue(Supplier, Object[])}
   */
  @Test
  @DisplayName("Test logValue(Supplier, Object[]) with 'resultFn', 'ctx'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object DebugUtilities.logValue(Supplier, Object[])"})
  void testLogValueWithResultFnCtx() {
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
