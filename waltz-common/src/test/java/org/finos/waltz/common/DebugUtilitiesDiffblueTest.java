package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DebugUtilitiesDiffblueTest {
  /**
   * Test {@link DebugUtilities#logValue(Object, Object[])} with {@code result}, {@code ctx}.
   *
   * <p>Method under test: {@link DebugUtilities#logValue(Object, Object[])}
   */
  @Test
  @DisplayName("Test logValue(Object, Object[]) with 'result', 'ctx'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DebugUtilities.logValue(Object, Object[])"})
  void testLogValueWithResultCtx() {
    // Arrange, Act and Assert
    assertEquals("Result", DebugUtilities.logValue("Result", "Ctx"));
  }

  /**
   * Test {@link DebugUtilities#logValue(Supplier, Object[])} with {@code resultFn}, {@code ctx}.
   *
   * <ul>
   *   <li>Given {@code Get}.
   *   <li>When {@link Supplier} {@link Supplier#get()} return {@code Get}.
   *   <li>Then return {@code Get}.
   * </ul>
   *
   * <p>Method under test: {@link DebugUtilities#logValue(Supplier, Object[])}
   */
  @Test
  @DisplayName(
      "Test logValue(Supplier, Object[]) with 'resultFn', 'ctx'; given 'Get'; when Supplier get() return 'Get'; then return 'Get'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DebugUtilities.logValue(Supplier, Object[])"})
  void testLogValueWithResultFnCtx_givenGet_whenSupplierGetReturnGet_thenReturnGet() {
    // Arrange
    Supplier<Object> resultFn = mock(Supplier.class);
    when(resultFn.get()).thenReturn("Get");

    // Act
    Object actualLogValueResult = DebugUtilities.logValue(resultFn, "Ctx");

    // Assert
    verify(resultFn).get();
    assertEquals("Get", actualLogValueResult);
  }

  /**
   * Test {@link DebugUtilities#logValue(Supplier, Object[])} with {@code resultFn}, {@code ctx}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DebugUtilities#logValue(Supplier, Object[])}
   */
  @Test
  @DisplayName(
      "Test logValue(Supplier, Object[]) with 'resultFn', 'ctx'; given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DebugUtilities.logValue(Supplier, Object[])"})
  void testLogValueWithResultFnCtx_givenRuntimeException_thenThrowRuntimeException() {
    // Arrange
    Supplier<Object> resultFn = mock(Supplier.class);
    when(resultFn.get()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> DebugUtilities.logValue(resultFn, "Ctx"));
    verify(resultFn).get();
  }
}
