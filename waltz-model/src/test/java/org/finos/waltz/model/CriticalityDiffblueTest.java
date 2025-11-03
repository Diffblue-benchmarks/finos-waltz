package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CriticalityDiffblueTest {
  /**
   * Test {@link Criticality#parse(String, Function)}.
   * <ul>
   *   <li>When {@code LOW}.</li>
   *   <li>Then return {@code LOW}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Criticality#parse(String, Function)}
   */
  @Test
  @DisplayName("Test parse(String, Function); when 'LOW'; then return 'LOW'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Criticality Criticality.parse(String, Function)"})
  void testParse_whenLow_thenReturnLow() {
    // Arrange, Act and Assert
    assertEquals(Criticality.LOW, Criticality.parse("LOW", Criticality::valueOf));
  }
}
