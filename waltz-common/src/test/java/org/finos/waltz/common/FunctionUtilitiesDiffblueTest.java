package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link FunctionUtilities#time(String, Runnable)}
   */
  @Test
  @DisplayName("Test time(String, Runnable) with 'name', 'runner'; given RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FunctionUtilities.time(String, Runnable)"})
  void testTimeWithNameRunner_givenRuntimeException() {
    // Arrange
    Runnable runner = mock(Runnable.class);
    doThrow(new RuntimeException()).when(runner).run();

    // Act
    FunctionUtilities.time("Name", runner);

    // Assert
    verify(runner).run();
  }

  /**
   * Test {@link FunctionUtilities#time(String, Runnable)} with {@code name}, {@code runner}.
   *
   * <ul>
   *   <li>When {@link Runnable} {@link Runnable#run()} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link FunctionUtilities#time(String, Runnable)}
   */
  @Test
  @DisplayName(
      "Test time(String, Runnable) with 'name', 'runner'; when Runnable run() does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FunctionUtilities.time(String, Runnable)"})
  void testTimeWithNameRunner_whenRunnableRunDoesNothing() {
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
   *
   * <ul>
   *   <li>Given {@code Get}.
   *   <li>When {@link Supplier} {@link Supplier#get()} return {@code Get}.
   *   <li>Then return {@code Get}.
   * </ul>
   *
   * <p>Method under test: {@link FunctionUtilities#time(String, Supplier)}
   */
  @Test
  @DisplayName(
      "Test time(String, Supplier) with 'name', 'supplier'; given 'Get'; when Supplier get() return 'Get'; then return 'Get'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FunctionUtilities.time(String, Supplier)"})
  void testTimeWithNameSupplier_givenGet_whenSupplierGetReturnGet_thenReturnGet() {
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
   * Test {@link FunctionUtilities#time(String, Supplier)} with {@code name}, {@code supplier}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FunctionUtilities#time(String, Supplier)}
   */
  @Test
  @DisplayName(
      "Test time(String, Supplier) with 'name', 'supplier'; given RuntimeException(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object FunctionUtilities.time(String, Supplier)"})
  void testTimeWithNameSupplier_givenRuntimeException_thenReturnNull() {
    // Arrange
    Supplier<Object> supplier = mock(Supplier.class);
    when(supplier.get()).thenThrow(new RuntimeException());

    // Act
    Object actualTimeResult = FunctionUtilities.time("Name", supplier);

    // Assert
    verify(supplier).get();
    assertNull(actualTimeResult);
  }

  /**
   * Test {@link FunctionUtilities#alwaysBi(Object)}.
   *
   * <p>Method under test: {@link FunctionUtilities#alwaysBi(Object)}
   */
  @Test
  @DisplayName("Test alwaysBi(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BiFunction FunctionUtilities.alwaysBi(Object)"})
  void testAlwaysBi() {
    // Arrange and Act
    BiFunction<Object, Object, Object> actualAlwaysBiResult = FunctionUtilities.alwaysBi("Result");

    // Assert
    assertEquals("Result", actualAlwaysBiResult.apply("42", "42"));
  }

  /**
   * Test {@link FunctionUtilities#always(Object)}.
   *
   * <p>Method under test: {@link FunctionUtilities#always(Object)}
   */
  @Test
  @DisplayName("Test always(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Function FunctionUtilities.always(Object)"})
  void testAlways() {
    // Arrange and Act
    Function<? super Object, Object> actualAlwaysResult = FunctionUtilities.always("Result");

    // Assert
    assertEquals("Result", actualAlwaysResult.apply("42"));
  }
}
