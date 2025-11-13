package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ObjectUtilitiesDiffblueTest {
  /**
   * Test {@link ObjectUtilities#dump(Object)}.
   *
   * <p>Method under test: {@link ObjectUtilities#dump(Object)}
   */
  @Test
  @DisplayName("Test dump(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ObjectUtilities.dump(Object)"})
  void testDump() {
    // Arrange, Act and Assert
    assertEquals("42", ObjectUtilities.dump("42"));
  }

  /**
   * Test {@link ObjectUtilities#firstNotNull(Object[])}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectUtilities#firstNotNull(Object[])}
   */
  @Test
  @DisplayName("Test firstNotNull(Object[]); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ObjectUtilities.firstNotNull(Object[])"})
  void testFirstNotNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ObjectUtilities.firstNotNull());
  }

  /**
   * Test {@link ObjectUtilities#firstNotNull(Object[])}.
   *
   * <ul>
   *   <li>When {@code Ts}.
   *   <li>Then return {@code Ts}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectUtilities#firstNotNull(Object[])}
   */
  @Test
  @DisplayName("Test firstNotNull(Object[]); when 'Ts'; then return 'Ts'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ObjectUtilities.firstNotNull(Object[])"})
  void testFirstNotNull_whenTs_thenReturnTs() {
    // Arrange, Act and Assert
    assertEquals("Ts", ObjectUtilities.firstNotNull("Ts"));
  }

  /**
   * Test {@link ObjectUtilities#any(Predicate, Object[])}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectUtilities#any(Predicate, Object[])}
   */
  @Test
  @DisplayName(
      "Test any(Predicate, Object[]); given 'false'; when Predicate test(Object) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ObjectUtilities.any(Predicate, Object[])"})
  void testAny_givenFalse_whenPredicateTestReturnFalse_thenReturnFalse() {
    // Arrange
    Predicate<Object> pred = mock(Predicate.class);
    when(pred.test(Mockito.<Object>any())).thenReturn(false);

    // Act
    boolean actualAnyResult = ObjectUtilities.any(pred, "Ts");

    // Assert
    verify(pred).test(isA(Object.class));
    assertFalse(actualAnyResult);
  }

  /**
   * Test {@link ObjectUtilities#any(Predicate, Object[])}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link Predicate} {@link Predicate#test(Object)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectUtilities#any(Predicate, Object[])}
   */
  @Test
  @DisplayName(
      "Test any(Predicate, Object[]); given 'true'; when Predicate test(Object) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ObjectUtilities.any(Predicate, Object[])"})
  void testAny_givenTrue_whenPredicateTestReturnTrue_thenReturnTrue() {
    // Arrange
    Predicate<Object> pred = mock(Predicate.class);
    when(pred.test(Mockito.<Object>any())).thenReturn(true);

    // Act
    boolean actualAnyResult = ObjectUtilities.any(pred, "Ts");

    // Assert
    verify(pred).test(isA(Object.class));
    assertTrue(actualAnyResult);
  }
}
