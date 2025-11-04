package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import ch.qos.logback.core.util.COWArrayList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;

class OptionalUtilitiesDiffblueTest {
  /**
   * Method under test: {@link OptionalUtilities#maybe(Object)}
   */
  @Test
  void testMaybe() {
    // Arrange and Act
    Optional<Object> actualMaybeResult = OptionalUtilities.maybe("Value");

    // Assert
    assertEquals("Value", actualMaybeResult.get());
    assertTrue(actualMaybeResult.isPresent());
  }

  /**
   * Method under test: {@link OptionalUtilities#toList(Optional[])}
   */
  @Test
  void testToList() {
    // Arrange
    Optional<Object> ofResult = Optional.of("42");

    // Act
    List<Object> actualToListResult = OptionalUtilities.toList(ofResult);

    // Assert
    assertEquals(1, actualToListResult.size());
    assertEquals("42", actualToListResult.get(0));
  }

  /**
   * Method under test: {@link OptionalUtilities#toList(Optional[])}
   */
  @Test
  void testToList2() {
    // Arrange and Act
    List<Object> actualToListResult = OptionalUtilities.toList(null);

    // Assert
    assertTrue(actualToListResult.isEmpty());
  }

  /**
   * Method under test: {@link OptionalUtilities#toList(Optional[])}
   */
  @Test
  void testToList3() {
    // Arrange
    Optional<Object> ofResult = Optional.<Object>of(mock(COWArrayList.class));

    // Act
    List<Object> actualToListResult = OptionalUtilities.toList(ofResult);

    // Assert
    assertEquals(1, actualToListResult.size());
  }

  /**
   * Method under test: {@link OptionalUtilities#toSet(Collection)}
   */
  @Test
  void testToSet() {
    // Arrange and Act
    Set<Object> actualToSetResult = OptionalUtilities.toSet(new ArrayList<>());

    // Assert
    assertTrue(actualToSetResult.isEmpty());
  }

  /**
   * Method under test: {@link OptionalUtilities#toSet(Collection)}
   */
  @Test
  void testToSet2() {
    // Arrange
    ArrayList<Optional<Object>> xs = new ArrayList<>();
    Optional<Object> ofResult = Optional.of("42");
    xs.add(ofResult);

    // Act
    Set<Object> actualToSetResult = OptionalUtilities.toSet(xs);

    // Assert
    assertEquals(1, actualToSetResult.size());
  }

  /**
   * Method under test: {@link OptionalUtilities#toSet(Collection)}
   */
  @Test
  void testToSet3() {
    // Arrange
    ArrayList<Optional<Object>> xs = new ArrayList<>();
    Optional<Object> ofResult = Optional.of("42");
    xs.add(ofResult);
    Optional<Object> ofResult2 = Optional.of("42");
    xs.add(ofResult2);

    // Act
    Set<Object> actualToSetResult = OptionalUtilities.toSet(xs);

    // Assert
    assertEquals(1, actualToSetResult.size());
  }

  /**
   * Method under test: {@link OptionalUtilities#contentsEqual(Optional, Object)}
   */
  @Test
  void testContentsEqual() {
    // Arrange
    Optional<Object> opt = Optional.of("42");

    // Act and Assert
    assertFalse(OptionalUtilities.contentsEqual(opt, "Val"));
  }

  /**
   * Method under test: {@link OptionalUtilities#contentsEqual(Optional, Object)}
   */
  @Test
  void testContentsEqual2() {
    // Arrange
    Optional<Object> opt = Optional.of("42");

    // Act and Assert
    assertFalse(OptionalUtilities.contentsEqual(opt, null));
  }

  /**
   * Method under test: {@link OptionalUtilities#contentsEqual(Optional, Object)}
   */
  @Test
  void testContentsEqual3() {
    // Arrange
    Optional<Object> opt = Optional.of("Val");

    // Act and Assert
    assertTrue(OptionalUtilities.contentsEqual(opt, "Val"));
  }

  /**
   * Method under test: {@link OptionalUtilities#contentsEqual(Optional, Object)}
   */
  @Test
  void testContentsEqual4() {
    // Arrange
    Optional<Object> opt = Optional.empty();

    // Act and Assert
    assertFalse(OptionalUtilities.contentsEqual(opt, "Val"));
  }

  /**
   * Method under test: {@link OptionalUtilities#ofNullableOptional(Optional)}
   */
  @Test
  void testOfNullableOptional() {
    // Arrange
    Optional<Object> nullable = Optional.of("42");

    // Act
    Optional<Object> actualOfNullableOptionalResult = OptionalUtilities.ofNullableOptional(nullable);

    // Assert
    assertEquals("42", actualOfNullableOptionalResult.get());
    assertTrue(actualOfNullableOptionalResult.isPresent());
  }

  /**
   * Method under test: {@link OptionalUtilities#ofNullableOptional(Optional)}
   */
  @Test
  void testOfNullableOptional2() {
    // Arrange and Act
    Optional<Object> actualOfNullableOptionalResult = OptionalUtilities.ofNullableOptional(null);

    // Assert
    assertFalse(actualOfNullableOptionalResult.isPresent());
  }

  /**
   * Method under test: {@link OptionalUtilities#ofExplodable(Supplier)}
   */
  @Test
  void testOfExplodable() {
    // Arrange
    Supplier<Object> supplier = mock(Supplier.class);
    when(supplier.get()).thenReturn("Get");

    // Act
    Optional<Object> actualOfExplodableResult = OptionalUtilities.ofExplodable(supplier);

    // Assert
    verify(supplier).get();
    assertEquals("Get", actualOfExplodableResult.get());
    assertTrue(actualOfExplodableResult.isPresent());
  }
}
