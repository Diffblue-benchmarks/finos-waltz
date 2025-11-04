package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import ch.qos.logback.core.util.COWArrayList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.Test;

class RandomUtilitiesDiffblueTest {
  /**
   * Method under test: {@link RandomUtilities#randomPick(Collection)}
   */
  @Test
  void testRandomPick() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    // Act and Assert
    assertEquals("42", RandomUtilities.randomPick((Collection<Object>) xs));
  }

  /**
   * Method under test: {@link RandomUtilities#randomPick(Collection)}
   */
  @Test
  void testRandomPick2() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");

    // Act and Assert
    assertEquals("42", RandomUtilities.randomPick((Collection<Object>) xs));
  }

  /**
   * Method under test: {@link RandomUtilities#randomPick(Collection, int)}
   */
  @Test
  void testRandomPick3() {
    // Arrange and Act
    List<Object> actualRandomPickResult = RandomUtilities.randomPick(new ArrayList<>(), 1);

    // Assert
    assertTrue(actualRandomPickResult.isEmpty());
  }

  /**
   * Method under test: {@link RandomUtilities#randomPick(Collection, int)}
   */
  @Test
  void testRandomPick4() {
    // Arrange and Act
    List<Object> actualRandomPickResult = RandomUtilities.randomPick(null, 0);

    // Assert
    assertTrue(actualRandomPickResult.isEmpty());
  }

  /**
   * Method under test: {@link RandomUtilities#randomPick(Collection, int)}
   */
  @Test
  void testRandomPick5() {
    // Arrange
    ArrayList<Object> choices = new ArrayList<>();
    choices.add("42");

    // Act
    List<Object> actualRandomPickResult = RandomUtilities.randomPick(choices, 1);

    // Assert
    assertEquals(1, actualRandomPickResult.size());
    assertEquals("42", actualRandomPickResult.get(0));
  }

  /**
   * Method under test: {@link RandomUtilities#randomPick(Collection, int)}
   */
  @Test
  void testRandomPick6() {
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
   * Method under test: {@link RandomUtilities#randomPick(Collection, int)}
   */
  @Test
  void testRandomPick7() {
    // Arrange
    ArrayList<Object> choices = new ArrayList<>();
    choices.add(mock(COWArrayList.class));

    // Act
    List<Object> actualRandomPickResult = RandomUtilities.randomPick(choices, 1);

    // Assert
    assertEquals(1, actualRandomPickResult.size());
  }

  /**
   * Method under test: {@link RandomUtilities#randomPick(Collection, int)}
   */
  @Test
  void testRandomPick8() {
    // Arrange
    ArrayList<Object> choices = new ArrayList<>();
    choices.add("42");

    // Act
    List<Object> actualRandomPickResult = RandomUtilities.randomPick(choices, 0);

    // Assert
    assertTrue(actualRandomPickResult.isEmpty());
  }

  /**
   * Method under test: {@link RandomUtilities#randomPick(List)}
   */
  @Test
  void testRandomPick9() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act and Assert
    assertEquals("42", RandomUtilities.randomPick((List<Object>) ts));
  }

  /**
   * Method under test: {@link RandomUtilities#randomPick(List)}
   */
  @Test
  void testRandomPick10() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    // Act and Assert
    assertEquals("42", RandomUtilities.randomPick((List<Object>) ts));
  }

  /**
   * Method under test: {@link RandomUtilities#randomPick(Object[])}
   */
  @Test
  void testRandomPick11() {
    // Arrange, Act and Assert
    assertEquals("Ts", RandomUtilities.randomPick("Ts"));
  }

  /**
   * Method under test: {@link RandomUtilities#randomPickSome(Collection, double)}
   */
  @Test
  void testRandomPickSome() {
    // Arrange and Act
    List<Object> actualRandomPickSomeResult = RandomUtilities.randomPickSome(new ArrayList<>(), 10.0d);

    // Assert
    assertTrue(actualRandomPickSomeResult.isEmpty());
  }

  /**
   * Method under test: {@link RandomUtilities#randomPickSome(Collection, double)}
   */
  @Test
  void testRandomPickSome2() {
    // Arrange and Act
    List<Object> actualRandomPickSomeResult = RandomUtilities.randomPickSome(null, 0.0d);

    // Assert
    assertTrue(actualRandomPickSomeResult.isEmpty());
  }

  /**
   * Method under test: {@link RandomUtilities#randomPickSome(Collection, double)}
   */
  @Test
  void testRandomPickSome3() {
    // Arrange
    ArrayList<Object> choices = new ArrayList<>();
    choices.add("42");

    // Act
    List<Object> actualRandomPickSomeResult = RandomUtilities.randomPickSome(choices, 10.0d);

    // Assert
    assertEquals(1, actualRandomPickSomeResult.size());
    assertEquals("42", actualRandomPickSomeResult.get(0));
  }

  /**
   * Method under test: {@link RandomUtilities#randomPickSome(Collection, double)}
   */
  @Test
  void testRandomPickSome4() {
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
   * Method under test: {@link RandomUtilities#randomPickSome(Collection, double)}
   */
  @Test
  void testRandomPickSome5() {
    // Arrange
    ArrayList<Object> choices = new ArrayList<>();
    choices.add("42");

    // Act
    List<Object> actualRandomPickSomeResult = RandomUtilities.randomPickSome(choices, 0.0d);

    // Assert
    assertTrue(actualRandomPickSomeResult.isEmpty());
  }

  /**
   * Method under test: {@link RandomUtilities#randomPickSome(Collection, double)}
   */
  @Test
  void testRandomPickSome6() {
    // Arrange
    ArrayList<Object> choices = new ArrayList<>();
    choices.add("42");

    // Act
    List<Object> actualRandomPickSomeResult = RandomUtilities.randomPickSome(choices, 0.5d);

    // Assert
    assertTrue(actualRandomPickSomeResult.isEmpty());
  }

  /**
   * Method under test: {@link RandomUtilities#randomPickSome(Collection, double)}
   */
  @Test
  void testRandomPickSome7() {
    // Arrange
    ArrayList<Object> choices = new ArrayList<>();
    choices.add(mock(COWArrayList.class));

    // Act
    List<Object> actualRandomPickSomeResult = RandomUtilities.randomPickSome(choices, 0.5d);

    // Assert
    assertTrue(actualRandomPickSomeResult.isEmpty());
  }

  /**
   * Method under test: {@link RandomUtilities#pickAndRemove(List)}
   */
  @Test
  void testPickAndRemove() {
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
   * Method under test: {@link RandomUtilities#pickAndRemove(List)}
   */
  @Test
  void testPickAndRemove2() {
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
    Object getResult2 = toListResult.get(0);
    assertEquals("42", getResult2);
    Object object = actualPickAndRemoveResult.v1;
    assertSame(object, xs.get(0));
    assertSame(object, xs.get(1));
    assertSame(object, getResult2);
    assertSame(actualPickAndRemoveResult.v2, getResult);
  }

  /**
   * Method under test: {@link RandomUtilities#randomTrue(double)}
   */
  @Test
  void testRandomTrue() {
    // Arrange, Act and Assert
    assertTrue(RandomUtilities.randomTrue(10.0d));
  }
}
