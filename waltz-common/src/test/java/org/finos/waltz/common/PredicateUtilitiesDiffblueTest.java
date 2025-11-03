package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PredicateUtilitiesDiffblueTest {
  /**
   * Test {@link PredicateUtilities#all(Object[], Predicate)} with {@code Object[]}, {@code Predicate}.
   * <ul>
   *   <li>When array of {@link Object} with {@code Ts}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PredicateUtilities#all(Object[], Predicate)}
   */
  @Test
  @DisplayName("Test all(Object[], Predicate) with 'Object[]', 'Predicate'; when array of Object with 'Ts'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PredicateUtilities.all(Object[], Predicate)"})
  void testAllWithObjectPredicate_whenArrayOfObjectWithTs_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(PredicateUtilities.all(new Object[]{"Ts"}, mock(RangeBand.class)::equals));
  }

  /**
   * Test {@link PredicateUtilities#all(Object[], Predicate)} with {@code Object[]}, {@code Predicate}.
   * <ul>
   *   <li>When empty array of {@link Object}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PredicateUtilities#all(Object[], Predicate)}
   */
  @Test
  @DisplayName("Test all(Object[], Predicate) with 'Object[]', 'Predicate'; when empty array of Object; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PredicateUtilities.all(Object[], Predicate)"})
  void testAllWithObjectPredicate_whenEmptyArrayOfObject_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(PredicateUtilities.all(new Object[]{}, mock(RangeBand.class)::equals));
  }

  /**
   * Test {@link PredicateUtilities#any(Object[], Predicate)} with {@code Object[]}, {@code Predicate}.
   * <ul>
   *   <li>When {@link RangeBand}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PredicateUtilities#any(Object[], Predicate)}
   */
  @Test
  @DisplayName("Test any(Object[], Predicate) with 'Object[]', 'Predicate'; when RangeBand; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PredicateUtilities.any(Object[], Predicate)"})
  void testAnyWithObjectPredicate_whenRangeBand_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(PredicateUtilities.any(new Object[]{"Ts"}, mock(RangeBand.class)::equals));
  }

  /**
   * Test {@link PredicateUtilities#none(Object[], Predicate)} with {@code Object[]}, {@code Predicate}.
   * <ul>
   *   <li>When {@link RangeBand}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PredicateUtilities#none(Object[], Predicate)}
   */
  @Test
  @DisplayName("Test none(Object[], Predicate) with 'Object[]', 'Predicate'; when RangeBand; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PredicateUtilities.none(Object[], Predicate)"})
  void testNoneWithObjectPredicate_whenRangeBand_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(PredicateUtilities.none(new Object[]{"Ts"}, mock(RangeBand.class)::equals));
  }
}
