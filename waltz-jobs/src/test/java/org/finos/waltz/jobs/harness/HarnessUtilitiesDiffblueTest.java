package org.finos.waltz.jobs.harness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HarnessUtilitiesDiffblueTest {
  /**
   * Test {@link HarnessUtilities#time(String, Supplier)}.
   * <p>
   * Method under test: {@link HarnessUtilities#time(String, Supplier)}
   */
  @Test
  @DisplayName("Test time(String, Supplier)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object HarnessUtilities.time(String, Supplier)"})
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
