package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.function.Function;
import java.util.function.Predicate;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ArrayUtilitiesDiffblueTest {
  /**
   * Method under test: {@link ArrayUtilities#all(Object[], Predicate)}
   */
  @Test
  void testAll() {
    // Arrange, Act and Assert
    assertFalse(ArrayUtilities.all(new Object[]{"Ts"}, mock(RangeBand.class)::equals));
    assertTrue(ArrayUtilities.all(new Object[]{}, mock(RangeBand.class)::equals));
  }

  /**
   * Method under test: {@link ArrayUtilities#all(Object[], Predicate)}
   */
  @Test
  void testAll2() {
    // Arrange
    Predicate<Object> check = mock(Predicate.class);
    when(check.test(Mockito.<Object>any())).thenReturn(true);

    // Act
    boolean actualAllResult = ArrayUtilities.all(new Object[]{"Ts"}, check);

    // Assert
    verify(check).test(isA(Object.class));
    assertTrue(actualAllResult);
  }

  /**
   * Method under test: {@link ArrayUtilities#isEmpty(Object[])}
   */
  @Test
  void testIsEmpty() {
    // Arrange, Act and Assert
    assertFalse(ArrayUtilities.isEmpty(new Object[]{"Arr"}));
    assertTrue(ArrayUtilities.isEmpty(null));
    assertTrue(ArrayUtilities.isEmpty(new Object[]{}));
  }

  /**
   * Method under test: {@link ArrayUtilities#sum(int[])}
   */
  @Test
  void testSum() {
    // Arrange, Act and Assert
    assertEquals(2, ArrayUtilities.sum(new int[]{1, 0, 1, 0}));
  }

  /**
   * Method under test: {@link ArrayUtilities#last(Object[])}
   */
  @Test
  void testLast() {
    // Arrange, Act and Assert
    assertEquals("Arr", ArrayUtilities.last(new Object[]{"Arr"}));
  }

  /**
   * Method under test: {@link ArrayUtilities#initial(Object[])}
   */
  @Test
  void testInitial() {
    // Arrange, Act and Assert
    assertEquals(0, ArrayUtilities.initial(new Object[]{"Arr"}).length);
  }

  /**
   * Method under test: {@link ArrayUtilities#map(Object[], Function)}
   */
  @Test
  void testMap() {
    // Arrange
    Function<Object, Object> mapper = mock(Function.class);
    when(mapper.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Object[] actualMapResult = ArrayUtilities.map(new Object[]{"Arr"}, mapper);

    // Assert
    verify(mapper).apply(isA(Object.class));
    assertEquals("Apply", actualMapResult[0]);
    assertEquals(1, actualMapResult.length);
  }

  /**
   * Method under test: {@link ArrayUtilities#idx(Object[], int, Object)}
   */
  @Test
  void testIdx() {
    // Arrange, Act and Assert
    assertEquals("Dflt", ArrayUtilities.idx(new Object[]{"Arr"}, 1, "Dflt"));
    assertEquals("Arr", ArrayUtilities.idx(new Object[]{"Arr", "Arr"}, 1, "Dflt"));
  }
}
