package org.finos.waltz.jobs.harness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HarnessUtilitiesDiffblueTest {
  /**
   * Test {@link HarnessUtilities#time(String, Supplier)}.
   *
   * <ul>
   *   <li>Given {@code Get}.
   *   <li>When {@link Supplier} {@link Supplier#get()} return {@code Get}.
   *   <li>Then return {@code Get}.
   * </ul>
   *
   * <p>Method under test: {@link HarnessUtilities#time(String, Supplier)}
   */
  @Test
  @DisplayName(
      "Test time(String, Supplier); given 'Get'; when Supplier get() return 'Get'; then return 'Get'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object HarnessUtilities.time(String, Supplier)"})
  void testTime_givenGet_whenSupplierGetReturnGet_thenReturnGet() {
    // Arrange
    Supplier<Object> s = mock(Supplier.class);
    when(s.get()).thenReturn("Get");

    // Act
    Object actualTimeResult = HarnessUtilities.time("Name", s);

    // Assert
    verify(s).get();
    assertEquals("Get", actualTimeResult);
  }

  /**
   * Test {@link HarnessUtilities#time(String, Supplier)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link HarnessUtilities#time(String, Supplier)}
   */
  @Test
  @DisplayName("Test time(String, Supplier); given RuntimeException(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object HarnessUtilities.time(String, Supplier)"})
  void testTime_givenRuntimeException_thenReturnNull() {
    // Arrange
    Supplier<Object> s = mock(Supplier.class);
    when(s.get()).thenThrow(new RuntimeException());

    // Act
    Object actualTimeResult = HarnessUtilities.time("Name", s);

    // Assert
    verify(s).get();
    assertNull(actualTimeResult);
  }
}
