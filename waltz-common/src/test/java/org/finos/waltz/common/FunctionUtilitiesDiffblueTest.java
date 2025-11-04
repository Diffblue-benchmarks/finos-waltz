package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;

class FunctionUtilitiesDiffblueTest {
  /**
   * Method under test: {@link FunctionUtilities#time(String, Runnable)}
   */
  @Test
  void testTime() {
    // Arrange
    Runnable runner = mock(Runnable.class);
    doNothing().when(runner).run();

    // Act
    FunctionUtilities.time("Name", runner);

    // Assert that nothing has changed
    verify(runner).run();
  }

  /**
   * Method under test: {@link FunctionUtilities#time(String, Supplier)}
   */
  @Test
  void testTime2() {
    // Arrange
    Supplier<Object> supplier = mock(Supplier.class);
    when(supplier.get()).thenReturn("Get");

    // Act
    Object actualTimeResult = FunctionUtilities.time("Name", supplier);

    // Assert
    verify(supplier).get();
    assertEquals("Get", actualTimeResult);
  }

  /**
   * Method under test: {@link FunctionUtilities#alwaysBi(Object)}
   */
  @Test
  void testAlwaysBi() {
    // Arrange and Act
    BiFunction<Object, Object, Object> actualAlwaysBiResult = FunctionUtilities.alwaysBi("Result");

    // Assert
    assertEquals("Result", actualAlwaysBiResult.apply("42", "42"));
  }

  /**
   * Method under test: {@link FunctionUtilities#always(Object)}
   */
  @Test
  void testAlways() {
    // Arrange and Act
    Function<? super Object, Object> actualAlwaysResult = FunctionUtilities.always("Result");

    // Assert
    assertEquals("Result", actualAlwaysResult.apply("42"));
  }
}
