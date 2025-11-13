package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CriticalityDiffblueTest {
  /**
   * Test {@link Criticality#parse(String, Function)}.
   *
   * <ul>
   *   <li>When {@code HIGH}.
   *   <li>Then return {@code HIGH}.
   * </ul>
   *
   * <p>Method under test: {@link Criticality#parse(String, Function)}
   */
  @Test
  @DisplayName("Test parse(String, Function); when 'HIGH'; then return 'HIGH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Criticality Criticality.parse(String, Function)"})
  void testParse_whenHigh_thenReturnHigh() {
    // Arrange, Act and Assert
    assertEquals(Criticality.HIGH, Criticality.parse("HIGH", Criticality::valueOf));
  }

  /**
   * Test {@link Criticality#parse(String, Function)}.
   *
   * <ul>
   *   <li>When {@code LOW}.
   *   <li>Then return {@code LOW}.
   * </ul>
   *
   * <p>Method under test: {@link Criticality#parse(String, Function)}
   */
  @Test
  @DisplayName("Test parse(String, Function); when 'LOW'; then return 'LOW'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Criticality Criticality.parse(String, Function)"})
  void testParse_whenLow_thenReturnLow() {
    // Arrange, Act and Assert
    assertEquals(Criticality.LOW, Criticality.parse("LOW", Criticality::valueOf));
  }
}
