package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ChecksDiffblueTest {
  /**
   * Method under test: {@link Checks#checkNotNull(Object, String, Object[])}
   */
  @Test
  void testCheckNotNull() {
    // Arrange, Act and Assert
    assertEquals("42", Checks.checkNotNull("42", "Not all who wander are lost", "Args"));
    assertThrows(IllegalArgumentException.class,
        () -> Checks.checkNotNull(null, "Not all who wander are lost", "Args"));
  }

  /**
   * Method under test: {@link Checks#checkAll(Collection, Predicate, String)}
   */
  @Test
  void testCheckAll() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> Checks.checkAll((Collection<Object>) null, null, "Not all who wander are lost"));
    assertThrows(IllegalArgumentException.class,
        () -> Checks.checkAll(new ArrayList<>(), null, "Not all who wander are lost"));
    assertThrows(IllegalArgumentException.class,
        () -> Checks.checkAll((Object[]) null, null, "Not all who wander are lost"));
    assertThrows(IllegalArgumentException.class,
        () -> Checks.checkAll(new Object[]{"Ts"}, null, "Not all who wander are lost"));
    assertThrows(IllegalArgumentException.class,
        () -> Checks.checkAll(new Object[]{"Ts"}, mock(RangeBand.class)::equals, "Not all who wander are lost"));
    assertEquals(0,
        Checks.checkAll(new Object[]{}, mock(RangeBand.class)::equals, "Not all who wander are lost").length);
  }

  /**
   * Method under test: {@link Checks#checkAll(Collection, Predicate, String)}
   */
  @Test
  void testCheckAll2() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();

    // Act
    Collection<Object> actualCheckAllResult = Checks.checkAll(ts, mock(RangeBand.class)::equals,
        "Not all who wander are lost");

    // Assert
    assertTrue(actualCheckAllResult instanceof List);
    assertTrue(actualCheckAllResult.isEmpty());
  }

  /**
   * Method under test: {@link Checks#checkAll(Collection, Predicate, String)}
   */
  @Test
  void testCheckAll3() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> Checks.checkAll(ts, mock(RangeBand.class)::equals, "Not all who wander are lost"));
  }

  /**
   * Method under test: {@link Checks#checkAll(Collection, Predicate, String)}
   */
  @Test
  void testCheckAll4() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> Checks.checkAll(ts, mock(RangeBand.class)::equals, "Not all who wander are lost"));
  }

  /**
   * Method under test: {@link Checks#checkAll(Object[], Predicate, String)}
   */
  @Test
  void testCheckAll5() {
    // Arrange
    Predicate<Object> check = mock(Predicate.class);
    when(check.test(Mockito.<Object>any())).thenReturn(true);

    // Act
    Object[] actualCheckAllResult = Checks.checkAll(new Object[]{"Ts"}, check, "Not all who wander are lost");

    // Assert
    verify(check).test(isA(Object.class));
    assertEquals("Ts", actualCheckAllResult[0]);
    assertEquals(1, actualCheckAllResult.length);
  }

  /**
   * Method under test: {@link Checks#checkTrue(boolean, String, Object[])}
   */
  @Test
  void testCheckTrue() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Checks.checkTrue(false, "Msg", "Args"));
  }

  /**
   * Method under test: {@link Checks#checkFalse(boolean, String)}
   */
  @Test
  void testCheckFalse() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Checks.checkFalse(true, "Not all who wander are lost"));
  }

  /**
   * Method under test: {@link Checks#checkOptionalIsPresent(Optional, String)}
   */
  @Test
  void testCheckOptionalIsPresent() {
    // Arrange
    Optional<Object> optional = Optional.of("42");

    // Act and Assert
    assertEquals("42", Checks.checkOptionalIsPresent(optional, "Not all who wander are lost"));
  }

  /**
   * Method under test: {@link Checks#checkOptionalIsPresent(Optional, String)}
   */
  @Test
  void testCheckOptionalIsPresent2() {
    // Arrange
    Optional<Object> optional = Optional.empty();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> Checks.checkOptionalIsPresent(optional, "Not all who wander are lost"));
  }

  /**
   * Method under test: {@link Checks#checkNotEmpty(String, String)}
   */
  @Test
  void testCheckNotEmpty() {
    // Arrange, Act and Assert
    assertEquals("Str", Checks.checkNotEmpty("Str", "Not all who wander are lost"));
    assertThrows(IllegalArgumentException.class, () -> Checks.checkNotEmpty("", "Not all who wander are lost"));
    assertThrows(IllegalArgumentException.class,
        () -> Checks.checkNotEmpty(new ArrayList<>(), "Not all who wander are lost"));
    assertThrows(IllegalArgumentException.class,
        () -> Checks.checkNotEmpty((Collection<Object>) null, "Not all who wander are lost"));
    assertThrows(IllegalArgumentException.class,
        () -> Checks.checkNotEmpty((Object[]) null, "Not all who wander are lost"));
    assertThrows(IllegalArgumentException.class,
        () -> Checks.checkNotEmpty(new Object[]{}, "Not all who wander are lost"));
  }

  /**
   * Method under test: {@link Checks#fail(String, Object[])}
   */
  @Test
  void testFail() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Checks.fail("Msg", "Args"));
  }

  /**
   * Method under test: {@link Checks#mkFail(String, Object[])}
   */
  @Test
  void testMkFail() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Checks.mkFail("Msg", "Args"));
  }

  /**
   * Method under test: {@link Checks#checkEmpty(Collection, String)}
   */
  @Test
  void testCheckEmpty() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Checks.checkEmpty(ts, "Not all who wander are lost"));
  }

  /**
   * Method under test: {@link Checks#checkEmpty(Collection, String)}
   */
  @Test
  void testCheckEmpty2() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Checks.checkEmpty(ts, "Not all who wander are lost"));
  }

  /**
   * Method under test: {@link Checks#checkEmpty(Collection, Supplier)}
   */
  @Test
  void testCheckEmpty3() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Checks.checkEmpty(ts, mock(RangeBand.class)::toString));
  }

  /**
   * Method under test: {@link Checks#checkEmpty(Collection, Supplier)}
   */
  @Test
  void testCheckEmpty4() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Checks.checkEmpty(ts, mock(RangeBand.class)::toString));
  }
}
