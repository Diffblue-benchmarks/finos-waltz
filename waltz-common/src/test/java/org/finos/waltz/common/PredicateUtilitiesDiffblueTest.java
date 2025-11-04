package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;
import org.junit.jupiter.api.Test;

class PredicateUtilitiesDiffblueTest {
  /**
   * Method under test: {@link PredicateUtilities#all(Collection, Predicate)}
   */
  @Test
  void testAll() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();

    // Act and Assert
    assertTrue(PredicateUtilities.all(ts, mock(RangeBand.class)::equals));
  }

  /**
   * Method under test: {@link PredicateUtilities#all(Collection, Predicate)}
   */
  @Test
  void testAll2() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act and Assert
    assertFalse(PredicateUtilities.all(ts, mock(RangeBand.class)::equals));
  }

  /**
   * Method under test: {@link PredicateUtilities#all(Collection, Predicate)}
   */
  @Test
  void testAll3() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    // Act and Assert
    assertFalse(PredicateUtilities.all(ts, mock(RangeBand.class)::equals));
  }

  /**
   * Method under test: {@link PredicateUtilities#all(Object[], Predicate)}
   */
  @Test
  void testAll4() {
    // Arrange, Act and Assert
    assertFalse(PredicateUtilities.all(new Object[]{"Ts"}, mock(RangeBand.class)::equals));
  }

  /**
   * Method under test: {@link PredicateUtilities#all(Object[], Predicate)}
   */
  @Test
  void testAll5() {
    // Arrange, Act and Assert
    assertTrue(PredicateUtilities.all(new Object[]{}, mock(RangeBand.class)::equals));
  }

  /**
   * Method under test: {@link PredicateUtilities#any(Collection, Predicate)}
   */
  @Test
  void testAny() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();

    // Act and Assert
    assertFalse(PredicateUtilities.any(ts, mock(RangeBand.class)::equals));
  }

  /**
   * Method under test: {@link PredicateUtilities#any(Collection, Predicate)}
   */
  @Test
  void testAny2() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act and Assert
    assertFalse(PredicateUtilities.any(ts, mock(RangeBand.class)::equals));
  }

  /**
   * Method under test: {@link PredicateUtilities#any(Collection, Predicate)}
   */
  @Test
  void testAny3() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    // Act and Assert
    assertFalse(PredicateUtilities.any(ts, mock(RangeBand.class)::equals));
  }

  /**
   * Method under test: {@link PredicateUtilities#any(Object[], Predicate)}
   */
  @Test
  void testAny4() {
    // Arrange, Act and Assert
    assertFalse(PredicateUtilities.any(new Object[]{"Ts"}, mock(RangeBand.class)::equals));
  }

  /**
   * Method under test: {@link PredicateUtilities#none(Collection, Predicate)}
   */
  @Test
  void testNone() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();

    // Act and Assert
    assertTrue(PredicateUtilities.none(ts, mock(RangeBand.class)::equals));
  }

  /**
   * Method under test: {@link PredicateUtilities#none(Collection, Predicate)}
   */
  @Test
  void testNone2() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act and Assert
    assertTrue(PredicateUtilities.none(ts, mock(RangeBand.class)::equals));
  }

  /**
   * Method under test: {@link PredicateUtilities#none(Collection, Predicate)}
   */
  @Test
  void testNone3() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    // Act and Assert
    assertTrue(PredicateUtilities.none(ts, mock(RangeBand.class)::equals));
  }

  /**
   * Method under test: {@link PredicateUtilities#none(Object[], Predicate)}
   */
  @Test
  void testNone4() {
    // Arrange, Act and Assert
    assertTrue(PredicateUtilities.none(new Object[]{"Ts"}, mock(RangeBand.class)::equals));
  }
}
