package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ObjectUtilitiesDiffblueTest {
  /**
   * Test {@link ObjectUtilities#dump(Object)}.
   * <p>
   * Method under test: {@link ObjectUtilities#dump(Object)}
   */
  @Test
  @DisplayName("Test dump(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ObjectUtilities.dump(Object)"})
  void testDump() {
    // Arrange, Act and Assert
    assertEquals("42", ObjectUtilities.dump("42"));
  }

  /**
   * Test {@link ObjectUtilities#firstNotNull(Object[])}.
   * <ul>
   *   <li>When {@code Ts}.</li>
   *   <li>Then return {@code Ts}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectUtilities#firstNotNull(Object[])}
   */
  @Test
  @DisplayName("Test firstNotNull(Object[]); when 'Ts'; then return 'Ts'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ObjectUtilities.firstNotNull(Object[])"})
  void testFirstNotNull_whenTs_thenReturnTs() {
    // Arrange, Act and Assert
    assertEquals("Ts", ObjectUtilities.firstNotNull("Ts"));
  }

  /**
   * Test {@link ObjectUtilities#any(Predicate, Object[])}.
   * <ul>
   *   <li>When {@link RangeBand}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectUtilities#any(Predicate, Object[])}
   */
  @Test
  @DisplayName("Test any(Predicate, Object[]); when RangeBand; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ObjectUtilities.any(Predicate, Object[])"})
  void testAny_whenRangeBand_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ObjectUtilities.any(mock(RangeBand.class)::equals, "Ts"));
  }
}
