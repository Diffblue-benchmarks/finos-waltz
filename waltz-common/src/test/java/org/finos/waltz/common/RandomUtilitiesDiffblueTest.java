package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RandomUtilitiesDiffblueTest {
  /**
   * Test {@link RandomUtilities#randomPick(Object[])} with {@code Object[]}.
   * <ul>
   *   <li>When {@code Ts}.</li>
   *   <li>Then return {@code Ts}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomUtilities#randomPick(Object[])}
   */
  @Test
  @DisplayName("Test randomPick(Object[]) with 'Object[]'; when 'Ts'; then return 'Ts'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object RandomUtilities.randomPick(Object[])"})
  void testRandomPickWithObject_whenTs_thenReturnTs() {
    // Arrange, Act and Assert
    assertEquals("Ts", RandomUtilities.randomPick("Ts"));
  }

  /**
   * Test {@link RandomUtilities#randomPickSome(Collection, double)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@code 0.5}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomUtilities#randomPickSome(Collection, double)}
   */
  @Test
  @DisplayName("Test randomPickSome(Collection, double); given '42'; when '0.5'; then return Empty")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When ten.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomUtilities#randomPickSome(Collection, double)}
   */
  @Test
  @DisplayName("Test randomPickSome(Collection, double); given '42'; when ten; then return ArrayList()")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When ten.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomUtilities#randomPickSome(Collection, double)}
   */
  @Test
  @DisplayName("Test randomPickSome(Collection, double); given '42'; when ten; then return ArrayList()")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When zero.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomUtilities#randomPickSome(Collection, double)}
   */
  @Test
  @DisplayName("Test randomPickSome(Collection, double); given '42'; when zero; then return Empty")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomUtilities#randomPickSome(Collection, double)}
   */
  @Test
  @DisplayName("Test randomPickSome(Collection, double); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List RandomUtilities.randomPickSome(Collection, double)"})
  void testRandomPickSome_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualRandomPickSomeResult = RandomUtilities.randomPickSome(new ArrayList<>(), 10.0d);

    // Assert
    assertTrue(actualRandomPickSomeResult.isEmpty());
  }

  /**
   * Test {@link RandomUtilities#randomPickSome(Collection, double)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomUtilities#randomPickSome(Collection, double)}
   */
  @Test
  @DisplayName("Test randomPickSome(Collection, double); when 'null'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List RandomUtilities.randomPickSome(Collection, double)"})
  void testRandomPickSome_whenNull_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualRandomPickSomeResult = RandomUtilities.randomPickSome(null, 0.0d);

    // Assert
    assertTrue(actualRandomPickSomeResult.isEmpty());
  }

  /**
   * Test {@link RandomUtilities#pickAndRemove(List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomUtilities#pickAndRemove(List)}
   */
  @Test
  @DisplayName("Test pickAndRemove(List); given '42'; when ArrayList() add '42'; then ArrayList() size is one")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomUtilities#pickAndRemove(List)}
   */
  @Test
  @DisplayName("Test pickAndRemove(List); given '42'; when ArrayList() add '42'; then ArrayList() size is two")
  @Tag("MaintainedByDiffblue")
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
    Object expectedGetResult = actualPickAndRemoveResult.v1;
    assertSame(expectedGetResult, xs.get(1));
  }

  /**
   * Test {@link RandomUtilities#randomTrue(double)}.
   * <ul>
   *   <li>When ten.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomUtilities#randomTrue(double)}
   */
  @Test
  @DisplayName("Test randomTrue(double); when ten; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RandomUtilities.randomTrue(double)"})
  void testRandomTrue_whenTen_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(RandomUtilities.randomTrue(10.0d));
  }
}
