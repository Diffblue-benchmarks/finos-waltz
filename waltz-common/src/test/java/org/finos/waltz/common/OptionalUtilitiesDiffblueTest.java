package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OptionalUtilitiesDiffblueTest {
  /**
   * Test {@link OptionalUtilities#maybe(Object)}.
   * <p>
   * Method under test: {@link OptionalUtilities#maybe(Object)}
   */
  @Test
  @DisplayName("Test maybe(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional OptionalUtilities.maybe(Object)"})
  void testMaybe() {
    // Arrange and Act
    Optional<Object> actualMaybeResult = OptionalUtilities.maybe("Value");

    // Assert
    assertEquals("Value", actualMaybeResult.get());
    assertTrue(actualMaybeResult.isPresent());
  }

  /**
   * Test {@link OptionalUtilities#toList(Optional[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OptionalUtilities#toList(Optional[])}
   */
  @Test
  @DisplayName("Test toList(Optional[]); when 'null'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List OptionalUtilities.toList(Optional[])"})
  void testToList_whenNull_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualToListResult = OptionalUtilities.toList(null);

    // Assert
    assertTrue(actualToListResult.isEmpty());
  }

  /**
   * Test {@link OptionalUtilities#toList(Optional[])}.
   * <ul>
   *   <li>When {@link Optional} with {@code 42}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OptionalUtilities#toList(Optional[])}
   */
  @Test
  @DisplayName("Test toList(Optional[]); when Optional with '42'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List OptionalUtilities.toList(Optional[])"})
  void testToList_whenOptionalWith42_thenReturnSizeIsOne() {
    // Arrange
    Optional<Object> ofResult = Optional.of("42");

    // Act
    List<Object> actualToListResult = OptionalUtilities.toList(ofResult);

    // Assert
    assertEquals(1, actualToListResult.size());
    assertEquals("42", actualToListResult.get(0));
  }

  /**
   * Test {@link OptionalUtilities#toSet(Collection)}.
   * <ul>
   *   <li>Given {@link Optional} with {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link Optional} with {@code 42}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OptionalUtilities#toSet(Collection)}
   */
  @Test
  @DisplayName("Test toSet(Collection); given Optional with '42'; when ArrayList() add Optional with '42'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set OptionalUtilities.toSet(Collection)"})
  void testToSet_givenOptionalWith42_whenArrayListAddOptionalWith42_thenReturnSizeIsOne() {
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
   * Test {@link OptionalUtilities#toSet(Collection)}.
   * <ul>
   *   <li>Given {@link Optional} with {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link Optional} with {@code 42}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OptionalUtilities#toSet(Collection)}
   */
  @Test
  @DisplayName("Test toSet(Collection); given Optional with '42'; when ArrayList() add Optional with '42'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set OptionalUtilities.toSet(Collection)"})
  void testToSet_givenOptionalWith42_whenArrayListAddOptionalWith42_thenReturnSizeIsOne2() {
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
   * Test {@link OptionalUtilities#toSet(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OptionalUtilities#toSet(Collection)}
   */
  @Test
  @DisplayName("Test toSet(Collection); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set OptionalUtilities.toSet(Collection)"})
  void testToSet_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    Set<Object> actualToSetResult = OptionalUtilities.toSet(new ArrayList<>());

    // Assert
    assertTrue(actualToSetResult.isEmpty());
  }

  /**
   * Test {@link OptionalUtilities#contentsEqual(Optional, Object)}.
   * <ul>
   *   <li>When empty.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OptionalUtilities#contentsEqual(Optional, Object)}
   */
  @Test
  @DisplayName("Test contentsEqual(Optional, Object); when empty; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OptionalUtilities.contentsEqual(Optional, Object)"})
  void testContentsEqual_whenEmpty_thenReturnFalse() {
    // Arrange
    Optional<Object> opt = Optional.empty();

    // Act and Assert
    assertFalse(OptionalUtilities.contentsEqual(opt, "Val"));
  }

  /**
   * Test {@link OptionalUtilities#contentsEqual(Optional, Object)}.
   * <ul>
   *   <li>When {@link Optional} with {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OptionalUtilities#contentsEqual(Optional, Object)}
   */
  @Test
  @DisplayName("Test contentsEqual(Optional, Object); when Optional with '42'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OptionalUtilities.contentsEqual(Optional, Object)"})
  void testContentsEqual_whenOptionalWith42_thenReturnFalse() {
    // Arrange
    Optional<Object> opt = Optional.of("42");

    // Act and Assert
    assertFalse(OptionalUtilities.contentsEqual(opt, "Val"));
  }

  /**
   * Test {@link OptionalUtilities#contentsEqual(Optional, Object)}.
   * <ul>
   *   <li>When {@link Optional} with {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OptionalUtilities#contentsEqual(Optional, Object)}
   */
  @Test
  @DisplayName("Test contentsEqual(Optional, Object); when Optional with '42'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OptionalUtilities.contentsEqual(Optional, Object)"})
  void testContentsEqual_whenOptionalWith42_thenReturnFalse2() {
    // Arrange
    Optional<Object> opt = Optional.of("42");

    // Act and Assert
    assertFalse(OptionalUtilities.contentsEqual(opt, null));
  }

  /**
   * Test {@link OptionalUtilities#contentsEqual(Optional, Object)}.
   * <ul>
   *   <li>When {@link Optional} with {@code Val}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OptionalUtilities#contentsEqual(Optional, Object)}
   */
  @Test
  @DisplayName("Test contentsEqual(Optional, Object); when Optional with 'Val'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OptionalUtilities.contentsEqual(Optional, Object)"})
  void testContentsEqual_whenOptionalWithVal_thenReturnTrue() {
    // Arrange
    Optional<Object> opt = Optional.of("Val");

    // Act and Assert
    assertTrue(OptionalUtilities.contentsEqual(opt, "Val"));
  }

  /**
   * Test {@link OptionalUtilities#ofNullableOptional(Optional)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link OptionalUtilities#ofNullableOptional(Optional)}
   */
  @Test
  @DisplayName("Test ofNullableOptional(Optional); when 'null'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional OptionalUtilities.ofNullableOptional(Optional)"})
  void testOfNullableOptional_whenNull_thenReturnNotPresent() {
    // Arrange and Act
    Optional<Object> actualOfNullableOptionalResult = OptionalUtilities.ofNullableOptional(null);

    // Assert
    assertFalse(actualOfNullableOptionalResult.isPresent());
  }

  /**
   * Test {@link OptionalUtilities#ofNullableOptional(Optional)}.
   * <ul>
   *   <li>When {@link Optional} with {@code 42}.</li>
   *   <li>Then return {@link Optional#get()} is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OptionalUtilities#ofNullableOptional(Optional)}
   */
  @Test
  @DisplayName("Test ofNullableOptional(Optional); when Optional with '42'; then return get() is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional OptionalUtilities.ofNullableOptional(Optional)"})
  void testOfNullableOptional_whenOptionalWith42_thenReturnGetIs42() {
    // Arrange
    Optional<Object> nullable = Optional.of("42");

    // Act
    Optional<Object> actualOfNullableOptionalResult = OptionalUtilities.ofNullableOptional(nullable);

    // Assert
    assertEquals("42", actualOfNullableOptionalResult.get());
    assertTrue(actualOfNullableOptionalResult.isPresent());
  }

  /**
   * Test {@link OptionalUtilities#isEmpty(Optional)}.
   * <ul>
   *   <li>When empty.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OptionalUtilities#isEmpty(Optional)}
   */
  @Test
  @DisplayName("Test isEmpty(Optional); when empty; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OptionalUtilities.isEmpty(Optional)"})
  void testIsEmpty_whenEmpty_thenReturnTrue() {
    // Arrange
    Optional<?> d = Optional.empty();

    // Act and Assert
    assertTrue(OptionalUtilities.isEmpty(d));
  }

  /**
   * Test {@link OptionalUtilities#isEmpty(Optional)}.
   * <ul>
   *   <li>When {@link Optional} with {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OptionalUtilities#isEmpty(Optional)}
   */
  @Test
  @DisplayName("Test isEmpty(Optional); when Optional with '42'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OptionalUtilities.isEmpty(Optional)"})
  void testIsEmpty_whenOptionalWith42_thenReturnFalse() {
    // Arrange
    Optional<?> d = Optional.of("42");

    // Act and Assert
    assertFalse(OptionalUtilities.isEmpty(d));
  }

  /**
   * Test {@link OptionalUtilities#ofExplodable(Supplier)}.
   * <p>
   * Method under test: {@link OptionalUtilities#ofExplodable(Supplier)}
   */
  @Test
  @DisplayName("Test ofExplodable(Supplier)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional OptionalUtilities.ofExplodable(Supplier)"})
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
