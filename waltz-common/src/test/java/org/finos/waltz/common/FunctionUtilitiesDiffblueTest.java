package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FunctionUtilitiesDiffblueTest {
  /**
   * Test {@link FunctionUtilities#time(String, Runnable)} with {@code name}, {@code runner}.
   * <p>
   * Method under test: {@link FunctionUtilities#time(String, Runnable)}
   */
  @Test
  @DisplayName("Test time(String, Runnable) with 'name', 'runner'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FunctionUtilities.time(String, Runnable)"})
  void testTimeWithNameRunner() {
    // Arrange
    Runnable runner = mock(Runnable.class);
    doNothing().when(runner).run();

    // Act
    FunctionUtilities.time("Name", runner);

    // Assert
    verify(runner).run();
  }

  /**
   * Test {@link FunctionUtilities#time(String, Supplier)} with {@code name}, {@code supplier}.
   * <p>
   * Method under test: {@link FunctionUtilities#time(String, Supplier)}
   */
  @Test
  @DisplayName("Test time(String, Supplier) with 'name', 'supplier'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object FunctionUtilities.time(String, Supplier)"})
  void testTimeWithNameSupplier() {
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
   * Test {@link FunctionUtilities#alwaysBi(Object)}.
   * <p>
   * Method under test: {@link FunctionUtilities#alwaysBi(Object)}
   */
  @Test
  @DisplayName("Test alwaysBi(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BiFunction FunctionUtilities.alwaysBi(Object)"})
  void testAlwaysBi() {
    // Arrange and Act
    BiFunction<Object, Object, Object> actualAlwaysBiResult = FunctionUtilities.alwaysBi("Result");

    // Assert
    assertEquals("Result", actualAlwaysBiResult.apply("42", "42"));
  }

  /**
   * Test {@link FunctionUtilities#always(Object)}.
   * <p>
   * Method under test: {@link FunctionUtilities#always(Object)}
   */
  @Test
  @DisplayName("Test always(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Function FunctionUtilities.always(Object)"})
  void testAlways() {
    // Arrange and Act
    Function<? super Object, Object> actualAlwaysResult = FunctionUtilities.always("Result");

    // Assert
    assertEquals("Result", actualAlwaysResult.apply("42"));
  }
}
