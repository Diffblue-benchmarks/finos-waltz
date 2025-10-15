package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RandomUtilitiesDiffblueTest {
  /**
   * Test {@link RandomUtilities#randomIntBetween(int, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link RandomUtilities#randomIntBetween(int, int)}
   */
  @Test
  @DisplayName("Test randomIntBetween(int, int); when one; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RandomUtilities.randomIntBetween(int, int)"})
  void testRandomIntBetween_whenOne_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(2, RandomUtilities.randomIntBetween(1, 3));
  }

  /**
   * Test {@link RandomUtilities#randomPick(Collection, int)} with {@code Collection}, {@code int}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link RandomUtilities#randomPick(Collection, int)}
   */
  @Test
  @DisplayName(
      "Test randomPick(Collection, int) with 'Collection', 'int'; given '42'; when ArrayList() add '42'; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RandomUtilities.randomPick(Collection, int)"})
  void testRandomPickWithCollectionInt_given42_whenArrayListAdd42_thenReturnArrayList() {
    // Arrange
    ArrayList<Object> choices = new ArrayList<>();
    choices.add("42");

    // Act
    List<Object> actualRandomPickResult = RandomUtilities.randomPick(choices, 1);

    // Assert
    assertEquals(choices, actualRandomPickResult);
  }

  /**
   * Test {@link RandomUtilities#randomPick(Collection, int)} with {@code Collection}, {@code int}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link RandomUtilities#randomPick(Collection, int)}
   */
  @Test
  @DisplayName(
      "Test randomPick(Collection, int) with 'Collection', 'int'; given '42'; when ArrayList() add '42'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RandomUtilities.randomPick(Collection, int)"})
  void testRandomPickWithCollectionInt_given42_whenArrayListAdd42_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Object> choices = new ArrayList<>();
    choices.add("42");
    choices.add("42");

    // Act
    List<Object> actualRandomPickResult = RandomUtilities.randomPick(choices, 1);

    // Assert
    assertEquals(1, actualRandomPickResult.size());
    assertEquals("42", actualRandomPickResult.get(0));
  }

  /**
   * Test {@link RandomUtilities#randomPick(Collection, int)} with {@code Collection}, {@code int}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When zero.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RandomUtilities#randomPick(Collection, int)}
   */
  @Test
  @DisplayName(
      "Test randomPick(Collection, int) with 'Collection', 'int'; given '42'; when zero; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RandomUtilities.randomPick(Collection, int)"})
  void testRandomPickWithCollectionInt_given42_whenZero_thenReturnEmpty() {
    // Arrange
    ArrayList<Object> choices = new ArrayList<>();
    choices.add("42");

    // Act
    List<Object> actualRandomPickResult = RandomUtilities.randomPick(choices, 0);

    // Assert
    assertTrue(actualRandomPickResult.isEmpty());
  }

  /**
   * Test {@link RandomUtilities#randomPick(Collection, int)} with {@code Collection}, {@code int}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RandomUtilities#randomPick(Collection, int)}
   */
  @Test
  @DisplayName(
      "Test randomPick(Collection, int) with 'Collection', 'int'; when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RandomUtilities.randomPick(Collection, int)"})
  void testRandomPickWithCollectionInt_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualRandomPickResult = RandomUtilities.randomPick(new ArrayList<>(), 1);

    // Assert
    assertTrue(actualRandomPickResult.isEmpty());
  }

  /**
   * Test {@link RandomUtilities#randomPick(Collection, int)} with {@code Collection}, {@code int}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RandomUtilities#randomPick(Collection, int)}
   */
  @Test
  @DisplayName(
      "Test randomPick(Collection, int) with 'Collection', 'int'; when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RandomUtilities.randomPick(Collection, int)"})
  void testRandomPickWithCollectionInt_whenNull_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualRandomPickResult = RandomUtilities.randomPick(null, 0);

    // Assert
    assertTrue(actualRandomPickResult.isEmpty());
  }

  /**
   * Test {@link RandomUtilities#randomPick(Collection)} with {@code Collection}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link RandomUtilities#randomPick(Collection)}
   */
  @Test
  @DisplayName(
      "Test randomPick(Collection) with 'Collection'; given '42'; when ArrayList() add '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object RandomUtilities.randomPick(Collection)"})
  void testRandomPickWithCollection_given42_whenArrayListAdd42_thenReturn42() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    // Act and Assert
    assertEquals("42", RandomUtilities.randomPick((Collection<Object>) xs));
  }

  /**
   * Test {@link RandomUtilities#randomPick(Collection)} with {@code Collection}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link RandomUtilities#randomPick(Collection)}
   */
  @Test
  @DisplayName(
      "Test randomPick(Collection) with 'Collection'; given '42'; when ArrayList() add '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object RandomUtilities.randomPick(Collection)"})
  void testRandomPickWithCollection_given42_whenArrayListAdd42_thenReturn422() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");

    // Act and Assert
    assertEquals("42", RandomUtilities.randomPick((Collection<Object>) xs));
  }

  /**
   * Test {@link RandomUtilities#randomPick(Collection)} with {@code Collection}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link RandomUtilities#randomPick(Collection)}
   */
  @Test
  @DisplayName(
      "Test randomPick(Collection) with 'Collection'; given '42'; when HashSet() add '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object RandomUtilities.randomPick(Collection)"})
  void testRandomPickWithCollection_given42_whenHashSetAdd42_thenReturn42() {
    // Arrange
    HashSet<Object> xs = new HashSet<>();
    xs.add("42");

    // Act and Assert
    assertEquals("42", RandomUtilities.randomPick(xs));
  }

  /**
   * Test {@link RandomUtilities#randomPick(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link RandomUtilities#randomPick(List)}
   */
  @Test
  @DisplayName(
      "Test randomPick(List) with 'List'; given '42'; when ArrayList() add '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object RandomUtilities.randomPick(List)"})
  void testRandomPickWithList_given42_whenArrayListAdd42_thenReturn42() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act and Assert
    assertEquals("42", RandomUtilities.randomPick((List<Object>) ts));
  }

  /**
   * Test {@link RandomUtilities#randomPick(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link RandomUtilities#randomPick(List)}
   */
  @Test
  @DisplayName(
      "Test randomPick(List) with 'List'; given '42'; when ArrayList() add '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object RandomUtilities.randomPick(List)"})
  void testRandomPickWithList_given42_whenArrayListAdd42_thenReturn422() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    // Act and Assert
    assertEquals("42", RandomUtilities.randomPick((List<Object>) ts));
  }

  /**
   * Test {@link RandomUtilities#randomPick(Object[])} with {@code Object[]}.
   *
   * <ul>
   *   <li>When {@code Ts}.
   *   <li>Then return {@code Ts}.
   * </ul>
   *
   * <p>Method under test: {@link RandomUtilities#randomPick(Object[])}
   */
  @Test
  @DisplayName("Test randomPick(Object[]) with 'Object[]'; when 'Ts'; then return 'Ts'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object RandomUtilities.randomPick(Object[])"})
  void testRandomPickWithObject_whenTs_thenReturnTs() {
    // Arrange, Act and Assert
    assertEquals("Ts", RandomUtilities.randomPick("Ts"));
  }

  /**
   * Test {@link RandomUtilities#randomPickSome(Collection, double)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@code 0.5}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RandomUtilities#randomPickSome(Collection, double)}
   */
  @Test
  @DisplayName("Test randomPickSome(Collection, double); given '42'; when '0.5'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RandomUtilities.randomPickSome(Collection, double)"})
  void testRandomPickSome_given42_when05_thenReturnEmpty() {
    // Arrange
    ArrayList<Object> choices = new ArrayList<>();
    choices.add("42");

    // Act
    List<Object> actualRandomPickSomeResult = RandomUtilities.randomPickSome(choices, 0.5d);

    // Assert
    assertTrue(actualRandomPickSomeResult.isEmpty());
  }

  /**
   * Test {@link RandomUtilities#randomPickSome(Collection, double)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When ten.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link RandomUtilities#randomPickSome(Collection, double)}
   */
  @Test
  @DisplayName(
      "Test randomPickSome(Collection, double); given '42'; when ten; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RandomUtilities.randomPickSome(Collection, double)"})
  void testRandomPickSome_given42_whenTen_thenReturnArrayList() {
    // Arrange
    ArrayList<Object> choices = new ArrayList<>();
    choices.add("42");

    // Act
    List<Object> actualRandomPickSomeResult = RandomUtilities.randomPickSome(choices, 10.0d);

    // Assert
    assertEquals(choices, actualRandomPickSomeResult);
  }

  /**
   * Test {@link RandomUtilities#randomPickSome(Collection, double)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When ten.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link RandomUtilities#randomPickSome(Collection, double)}
   */
  @Test
  @DisplayName(
      "Test randomPickSome(Collection, double); given '42'; when ten; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RandomUtilities.randomPickSome(Collection, double)"})
  void testRandomPickSome_given42_whenTen_thenReturnArrayList2() {
    // Arrange
    ArrayList<Object> choices = new ArrayList<>();
    choices.add("42");
    choices.add("42");

    // Act
    List<Object> actualRandomPickSomeResult = RandomUtilities.randomPickSome(choices, 10.0d);

    // Assert
    assertEquals(choices, actualRandomPickSomeResult);
  }

  /**
   * Test {@link RandomUtilities#randomPickSome(Collection, double)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When zero.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RandomUtilities#randomPickSome(Collection, double)}
   */
  @Test
  @DisplayName("Test randomPickSome(Collection, double); given '42'; when zero; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RandomUtilities.randomPickSome(Collection, double)"})
  void testRandomPickSome_given42_whenZero_thenReturnEmpty() {
    // Arrange
    ArrayList<Object> choices = new ArrayList<>();
    choices.add("42");

    // Act
    List<Object> actualRandomPickSomeResult = RandomUtilities.randomPickSome(choices, 0.0d);

    // Assert
    assertTrue(actualRandomPickSomeResult.isEmpty());
  }

  /**
   * Test {@link RandomUtilities#randomPickSome(Collection, double)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RandomUtilities#randomPickSome(Collection, double)}
   */
  @Test
  @DisplayName("Test randomPickSome(Collection, double); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RandomUtilities.randomPickSome(Collection, double)"})
  void testRandomPickSome_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualRandomPickSomeResult =
        RandomUtilities.randomPickSome(new ArrayList<>(), 10.0d);

    // Assert
    assertTrue(actualRandomPickSomeResult.isEmpty());
  }

  /**
   * Test {@link RandomUtilities#randomPickSome(Collection, double)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RandomUtilities#randomPickSome(Collection, double)}
   */
  @Test
  @DisplayName("Test randomPickSome(Collection, double); when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RandomUtilities.randomPickSome(Collection, double)"})
  void testRandomPickSome_whenNull_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualRandomPickSomeResult = RandomUtilities.randomPickSome(null, 0.0d);

    // Assert
    assertTrue(actualRandomPickSomeResult.isEmpty());
  }

  /**
   * Test {@link RandomUtilities#pickAndRemove(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link RandomUtilities#pickAndRemove(List)}
   */
  @Test
  @DisplayName(
      "Test pickAndRemove(List); given '42'; when ArrayList() add '42'; then ArrayList() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Tuple2 RandomUtilities.pickAndRemove(List)"})
  void testPickAndRemove_given42_whenArrayListAdd42_thenArrayListSizeIsOne() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    // Act
    Tuple2<Object, List<Object>> actualPickAndRemoveResult = RandomUtilities.pickAndRemove(xs);

    // Assert
    assertEquals(1, xs.size());
    List<?> toListResult = actualPickAndRemoveResult.toList();
    assertEquals(2, toListResult.size());
    Object getResult = toListResult.get(1);
    assertTrue(getResult instanceof List);
    Object getResult2 = toListResult.get(0);
    assertEquals("42", getResult2);
    assertTrue(((List<Object>) getResult).isEmpty());
    Object object = actualPickAndRemoveResult.v1;
    assertSame(object, xs.get(0));
    assertSame(object, getResult2);
    assertSame(actualPickAndRemoveResult.v2, getResult);
  }

  /**
   * Test {@link RandomUtilities#pickAndRemove(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link RandomUtilities#pickAndRemove(List)}
   */
  @Test
  @DisplayName(
      "Test pickAndRemove(List); given '42'; when ArrayList() add '42'; then ArrayList() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Tuple2 RandomUtilities.pickAndRemove(List)"})
  void testPickAndRemove_given42_whenArrayListAdd42_thenArrayListSizeIsTwo() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");

    // Act
    Tuple2<Object, List<Object>> actualPickAndRemoveResult = RandomUtilities.pickAndRemove(xs);

    // Assert
    assertEquals(2, xs.size());
    List<?> toListResult = actualPickAndRemoveResult.toList();
    assertEquals(2, toListResult.size());
    Object getResult = toListResult.get(1);
    assertTrue(getResult instanceof List);
    assertEquals(1, ((List<String>) getResult).size());
    assertEquals("42", ((List<String>) getResult).get(0));
    assertSame(actualPickAndRemoveResult.v1, xs.get(1));
  }

  /**
   * Test {@link RandomUtilities#randomTrue(double)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RandomUtilities#randomTrue(double)}
   */
  @Test
  @DisplayName("Test randomTrue(double); when ten; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RandomUtilities.randomTrue(double)"})
  void testRandomTrue_whenTen_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(RandomUtilities.randomTrue(10.0d));
  }
}
