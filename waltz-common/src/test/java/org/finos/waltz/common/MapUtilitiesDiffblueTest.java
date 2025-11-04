package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MapUtilitiesDiffblueTest {
  /**
   * Method under test: {@link MapUtilities#newHashMap()}
   */
  @Test
  void testNewHashMap() {
    // Arrange and Act
    HashMap<Object, Object> actualNewHashMapResult = MapUtilities.newHashMap();

    // Assert
    assertTrue(actualNewHashMapResult.isEmpty());
  }

  /**
   * Method under test: {@link MapUtilities#newHashMap(Object, Object)}
   */
  @Test
  void testNewHashMap2() {
    // Arrange and Act
    Map<Object, Object> actualNewHashMapResult = MapUtilities.newHashMap("Key", "Val");

    // Assert
    assertEquals(1, actualNewHashMapResult.size());
    assertEquals("Val", actualNewHashMapResult.get("Key"));
  }

  /**
   * Method under test:
   * {@link MapUtilities#newHashMap(Object, Object, Object, Object)}
   */
  @Test
  void testNewHashMap3() {
    // Arrange and Act
    Map<Object, Object> actualNewHashMapResult = MapUtilities.newHashMap("K1", "V1", "K2", "V2");

    // Assert
    assertEquals(2, actualNewHashMapResult.size());
    assertEquals("V1", actualNewHashMapResult.get("K1"));
    assertEquals("V2", actualNewHashMapResult.get("K2"));
  }

  /**
   * Method under test:
   * {@link MapUtilities#newHashMap(Object, Object, Object, Object, Object, Object)}
   */
  @Test
  void testNewHashMap4() {
    // Arrange and Act
    Map<Object, Object> actualNewHashMapResult = MapUtilities.newHashMap("K1", "V1", "K2", "V2", "K3", "V3");

    // Assert
    assertEquals(3, actualNewHashMapResult.size());
    assertEquals("V1", actualNewHashMapResult.get("K1"));
    assertEquals("V2", actualNewHashMapResult.get("K2"));
    assertEquals("V3", actualNewHashMapResult.get("K3"));
  }

  /**
   * Method under test:
   * {@link MapUtilities#newHashMap(Object, Object, Object, Object, Object, Object, Object, Object)}
   */
  @Test
  void testNewHashMap5() {
    // Arrange and Act
    Map<Object, Object> actualNewHashMapResult = MapUtilities.newHashMap("K1", "V1", "K2", "V2", "K3", "V3", "K4",
        "V4");

    // Assert
    assertEquals(4, actualNewHashMapResult.size());
    assertEquals("V1", actualNewHashMapResult.get("K1"));
    assertEquals("V2", actualNewHashMapResult.get("K2"));
    assertEquals("V3", actualNewHashMapResult.get("K3"));
    assertEquals("V4", actualNewHashMapResult.get("K4"));
  }

  /**
   * Method under test:
   * {@link MapUtilities#newHashMap(Object, Object, Object, Object, Object, Object, Object, Object, Object, Object)}
   */
  @Test
  void testNewHashMap6() {
    // Arrange and Act
    Map<Object, Object> actualNewHashMapResult = MapUtilities.newHashMap("K1", "V1", "K2", "V2", "K3", "V3", "K4", "V4",
        "K5", "V5");

    // Assert
    assertEquals(5, actualNewHashMapResult.size());
    assertEquals("V1", actualNewHashMapResult.get("K1"));
    assertEquals("V2", actualNewHashMapResult.get("K2"));
    assertEquals("V3", actualNewHashMapResult.get("K3"));
    assertEquals("V4", actualNewHashMapResult.get("K4"));
    assertEquals("V5", actualNewHashMapResult.get("K5"));
  }

  /**
   * Method under test:
   * {@link MapUtilities#newHashMap(Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object)}
   */
  @Test
  void testNewHashMap7() {
    // Arrange and Act
    Map<Object, Object> actualNewHashMapResult = MapUtilities.newHashMap("K1", "V1", "K2", "V2", "K3", "V3", "K4", "V4",
        "K5", "V5", "K6", "V6");

    // Assert
    assertEquals(6, actualNewHashMapResult.size());
    assertEquals("V1", actualNewHashMapResult.get("K1"));
    assertEquals("V2", actualNewHashMapResult.get("K2"));
    assertEquals("V3", actualNewHashMapResult.get("K3"));
    assertEquals("V4", actualNewHashMapResult.get("K4"));
    assertEquals("V5", actualNewHashMapResult.get("K5"));
    assertEquals("V6", actualNewHashMapResult.get("K6"));
  }

  /**
   * Method under test: {@link MapUtilities#groupBy(Collection, Function)}
   */
  @Test
  void testGroupBy() {
    // Arrange and Act
    Map<Object, Collection<Object>> actualGroupByResult = MapUtilities.<Object, Object>groupBy(new ArrayList<>(),
        mock(Function.class));

    // Assert
    assertTrue(actualGroupByResult.isEmpty());
  }

  /**
   * Method under test: {@link MapUtilities#groupBy(Collection, Function)}
   */
  @Test
  void testGroupBy2() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Map<Object, Collection<Object>> actualGroupByResult = MapUtilities.groupBy(xs, keyFn);

    // Assert
    verify(keyFn).apply(isA(Object.class));
    assertEquals(1, actualGroupByResult.size());
    Collection<Object> getResult = actualGroupByResult.get("Apply");
    assertEquals(1, getResult.size());
    assertTrue(getResult instanceof List);
    assertEquals("42", ((List<Object>) getResult).get(0));
  }

  /**
   * Method under test: {@link MapUtilities#groupBy(Collection, Function)}
   */
  @Test
  void testGroupBy3() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Map<Object, Collection<Object>> actualGroupByResult = MapUtilities.groupBy(xs, keyFn);

    // Assert
    verify(keyFn, atLeast(1)).apply(isA(Object.class));
    assertEquals(1, actualGroupByResult.size());
    assertEquals(xs, actualGroupByResult.get("Apply"));
  }

  /**
   * Method under test:
   * {@link MapUtilities#groupBy(Collection, Function, Function)}
   */
  @Test
  void testGroupBy4() {
    // Arrange and Act
    Map<Object, Collection<Object>> actualGroupByResult = MapUtilities
        .<Object, Object, Object>groupBy(new ArrayList<>(), mock(Function.class), mock(Function.class));

    // Assert
    assertTrue(actualGroupByResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link MapUtilities#groupBy(Collection, Function, Function)}
   */
  @Test
  void testGroupBy5() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");
    Function<Object, Object> valueFn = mock(Function.class);
    when(valueFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Map<Object, Collection<Object>> actualGroupByResult = MapUtilities.groupBy(xs, keyFn, valueFn);

    // Assert
    verify(keyFn).apply(isA(Object.class));
    verify(valueFn).apply(isA(Object.class));
    assertEquals(1, actualGroupByResult.size());
    Collection<Object> getResult = actualGroupByResult.get("Apply");
    assertEquals(1, getResult.size());
    assertTrue(getResult instanceof List);
    assertEquals("Apply", ((List<Object>) getResult).get(0));
  }

  /**
   * Method under test:
   * {@link MapUtilities#groupBy(Collection, Function, Function)}
   */
  @Test
  void testGroupBy6() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");
    Function<Object, Object> valueFn = mock(Function.class);
    when(valueFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Map<Object, Collection<Object>> actualGroupByResult = MapUtilities.groupBy(xs, keyFn, valueFn);

    // Assert
    verify(keyFn, atLeast(1)).apply(isA(Object.class));
    verify(valueFn, atLeast(1)).apply(isA(Object.class));
    assertEquals(1, actualGroupByResult.size());
    Collection<Object> getResult = actualGroupByResult.get("Apply");
    assertEquals(2, getResult.size());
    assertTrue(getResult instanceof List);
    assertEquals("Apply", ((List<Object>) getResult).get(0));
    assertEquals("Apply", ((List<Object>) getResult).get(1));
  }

  /**
   * Method under test: {@link MapUtilities#groupBy(Function, Collection)}
   */
  @Test
  void testGroupBy7() {
    // Arrange
    Function<Object, Object> keyFn = mock(Function.class);

    // Act
    Map<Object, Collection<Object>> actualGroupByResult = MapUtilities.groupBy(keyFn, new ArrayList<>());

    // Assert
    assertTrue(actualGroupByResult.isEmpty());
  }

  /**
   * Method under test: {@link MapUtilities#groupBy(Function, Collection)}
   */
  @Test
  void testGroupBy8() {
    // Arrange
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    // Act
    Map<Object, Collection<Object>> actualGroupByResult = MapUtilities.groupBy(keyFn, xs);

    // Assert
    verify(keyFn).apply(isA(Object.class));
    assertEquals(1, actualGroupByResult.size());
    Collection<Object> getResult = actualGroupByResult.get("Apply");
    assertEquals(1, getResult.size());
    assertTrue(getResult instanceof List);
    assertEquals("42", ((List<Object>) getResult).get(0));
  }

  /**
   * Method under test: {@link MapUtilities#groupBy(Function, Collection)}
   */
  @Test
  void testGroupBy9() {
    // Arrange
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");

    // Act
    Map<Object, Collection<Object>> actualGroupByResult = MapUtilities.groupBy(keyFn, xs);

    // Assert
    verify(keyFn, atLeast(1)).apply(isA(Object.class));
    assertEquals(1, actualGroupByResult.size());
    assertEquals(xs, actualGroupByResult.get("Apply"));
  }

  /**
   * Method under test:
   * {@link MapUtilities#groupBy(Function, Function, Collection)}
   */
  @Test
  void testGroupBy10() {
    // Arrange
    Function<Object, Object> keyFn = mock(Function.class);
    Function<Object, Object> valueFn = mock(Function.class);

    // Act
    Map<Object, Collection<Object>> actualGroupByResult = MapUtilities.groupBy(keyFn, valueFn, new ArrayList<>());

    // Assert
    assertTrue(actualGroupByResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link MapUtilities#groupBy(Function, Function, Collection)}
   */
  @Test
  void testGroupBy11() {
    // Arrange
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");
    Function<Object, Object> valueFn = mock(Function.class);
    when(valueFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    // Act
    Map<Object, Collection<Object>> actualGroupByResult = MapUtilities.groupBy(keyFn, valueFn, xs);

    // Assert
    verify(keyFn).apply(isA(Object.class));
    verify(valueFn).apply(isA(Object.class));
    assertEquals(1, actualGroupByResult.size());
    Collection<Object> getResult = actualGroupByResult.get("Apply");
    assertEquals(1, getResult.size());
    assertTrue(getResult instanceof List);
    assertEquals("Apply", ((List<Object>) getResult).get(0));
  }

  /**
   * Method under test:
   * {@link MapUtilities#groupBy(Function, Function, Collection)}
   */
  @Test
  void testGroupBy12() {
    // Arrange
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");
    Function<Object, Object> valueFn = mock(Function.class);
    when(valueFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");

    // Act
    Map<Object, Collection<Object>> actualGroupByResult = MapUtilities.groupBy(keyFn, valueFn, xs);

    // Assert
    verify(keyFn, atLeast(1)).apply(isA(Object.class));
    verify(valueFn, atLeast(1)).apply(isA(Object.class));
    assertEquals(1, actualGroupByResult.size());
    Collection<Object> getResult = actualGroupByResult.get("Apply");
    assertEquals(2, getResult.size());
    assertTrue(getResult instanceof List);
    assertEquals("Apply", ((List<Object>) getResult).get(0));
    assertEquals("Apply", ((List<Object>) getResult).get(1));
  }

  /**
   * Method under test: {@link MapUtilities#indexBy(Collection, Function)}
   */
  @Test
  void testIndexBy() {
    // Arrange and Act
    Map<Object, Object> actualIndexByResult = MapUtilities.<Object, Object>indexBy(new ArrayList<>(),
        mock(Function.class));

    // Assert
    assertTrue(actualIndexByResult.isEmpty());
  }

  /**
   * Method under test: {@link MapUtilities#indexBy(Collection, Function)}
   */
  @Test
  void testIndexBy2() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Map<Object, Object> actualIndexByResult = MapUtilities.indexBy(xs, keyFn);

    // Assert
    verify(keyFn).apply(isA(Object.class));
    assertEquals(1, actualIndexByResult.size());
    assertEquals("42", actualIndexByResult.get("Apply"));
  }

  /**
   * Method under test: {@link MapUtilities#indexBy(Collection, Function)}
   */
  @Test
  void testIndexBy3() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Map<Object, Object> actualIndexByResult = MapUtilities.indexBy(xs, keyFn);

    // Assert
    verify(keyFn, atLeast(1)).apply(isA(Object.class));
    assertEquals(1, actualIndexByResult.size());
    assertEquals("42", actualIndexByResult.get("Apply"));
  }

  /**
   * Method under test:
   * {@link MapUtilities#indexBy(Collection, Function, Function)}
   */
  @Test
  void testIndexBy4() {
    // Arrange and Act
    Map<Object, Object> actualIndexByResult = MapUtilities.<Object, Object, Object>indexBy(new ArrayList<>(),
        mock(Function.class), mock(Function.class));

    // Assert
    assertTrue(actualIndexByResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link MapUtilities#indexBy(Collection, Function, Function)}
   */
  @Test
  void testIndexBy5() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");
    Function<Object, Object> valueFn = mock(Function.class);
    when(valueFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Map<Object, Object> actualIndexByResult = MapUtilities.indexBy(xs, keyFn, valueFn);

    // Assert
    verify(keyFn).apply(isA(Object.class));
    verify(valueFn).apply(isA(Object.class));
    assertEquals(1, actualIndexByResult.size());
    assertEquals("Apply", actualIndexByResult.get("Apply"));
  }

  /**
   * Method under test:
   * {@link MapUtilities#indexBy(Collection, Function, Function)}
   */
  @Test
  void testIndexBy6() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");
    Function<Object, Object> valueFn = mock(Function.class);
    when(valueFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Map<Object, Object> actualIndexByResult = MapUtilities.indexBy(xs, keyFn, valueFn);

    // Assert
    verify(keyFn, atLeast(1)).apply(isA(Object.class));
    verify(valueFn, atLeast(1)).apply(isA(Object.class));
    assertEquals(1, actualIndexByResult.size());
    assertEquals("Apply", actualIndexByResult.get("Apply"));
  }

  /**
   * Method under test:
   * {@link MapUtilities#indexBy(Collection, Function, Function, BinaryOperator)}
   */
  @Test
  void testIndexBy7() {
    // Arrange and Act
    Map<Object, Object> actualIndexByResult = MapUtilities.<Object, Object, Object>indexBy(new ArrayList<>(),
        mock(Function.class), mock(Function.class), mock(BinaryOperator.class));

    // Assert
    assertTrue(actualIndexByResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link MapUtilities#indexBy(Collection, Function, Function, BinaryOperator)}
   */
  @Test
  void testIndexBy8() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");
    Function<Object, Object> valueFn = mock(Function.class);
    when(valueFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Map<Object, Object> actualIndexByResult = MapUtilities.indexBy(xs, keyFn, valueFn, mock(BinaryOperator.class));

    // Assert
    verify(keyFn).apply(isA(Object.class));
    verify(valueFn).apply(isA(Object.class));
    assertEquals(1, actualIndexByResult.size());
    assertEquals("Apply", actualIndexByResult.get("Apply"));
  }

  /**
   * Method under test:
   * {@link MapUtilities#indexBy(Collection, Function, Function, BinaryOperator)}
   */
  @Test
  void testIndexBy9() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");
    Function<Object, Object> valueFn = mock(Function.class);
    when(valueFn.apply(Mockito.<Object>any())).thenReturn("Apply");
    BinaryOperator<Object> mergeFunction = mock(BinaryOperator.class);
    when(mergeFunction.apply(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Map<Object, Object> actualIndexByResult = MapUtilities.indexBy(xs, keyFn, valueFn, mergeFunction);

    // Assert
    verify(mergeFunction).apply(isA(Object.class), isA(Object.class));
    verify(keyFn, atLeast(1)).apply(isA(Object.class));
    verify(valueFn, atLeast(1)).apply(isA(Object.class));
    assertEquals(1, actualIndexByResult.size());
    assertEquals("Apply", actualIndexByResult.get("Apply"));
  }

  /**
   * Method under test: {@link MapUtilities#indexBy(Function, Collection)}
   */
  @Test
  void testIndexBy10() {
    // Arrange
    Function<Object, Object> keyFn = mock(Function.class);

    // Act
    Map<Object, Object> actualIndexByResult = MapUtilities.indexBy(keyFn, new ArrayList<>());

    // Assert
    assertTrue(actualIndexByResult.isEmpty());
  }

  /**
   * Method under test: {@link MapUtilities#indexBy(Function, Collection)}
   */
  @Test
  void testIndexBy11() {
    // Arrange
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    // Act
    Map<Object, Object> actualIndexByResult = MapUtilities.indexBy(keyFn, xs);

    // Assert
    verify(keyFn).apply(isA(Object.class));
    assertEquals(1, actualIndexByResult.size());
    assertEquals("42", actualIndexByResult.get("Apply"));
  }

  /**
   * Method under test: {@link MapUtilities#indexBy(Function, Collection)}
   */
  @Test
  void testIndexBy12() {
    // Arrange
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");

    // Act
    Map<Object, Object> actualIndexByResult = MapUtilities.indexBy(keyFn, xs);

    // Assert
    verify(keyFn, atLeast(1)).apply(isA(Object.class));
    assertEquals(1, actualIndexByResult.size());
    assertEquals("42", actualIndexByResult.get("Apply"));
  }

  /**
   * Method under test:
   * {@link MapUtilities#indexBy(Function, Function, Collection)}
   */
  @Test
  void testIndexBy13() {
    // Arrange
    Function<Object, Object> keyFn = mock(Function.class);
    Function<Object, Object> valueFn = mock(Function.class);

    // Act
    Map<Object, Object> actualIndexByResult = MapUtilities.indexBy(keyFn, valueFn, new ArrayList<>());

    // Assert
    assertTrue(actualIndexByResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link MapUtilities#indexBy(Function, Function, Collection)}
   */
  @Test
  void testIndexBy14() {
    // Arrange
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");
    Function<Object, Object> valueFn = mock(Function.class);
    when(valueFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    // Act
    Map<Object, Object> actualIndexByResult = MapUtilities.indexBy(keyFn, valueFn, xs);

    // Assert
    verify(keyFn).apply(isA(Object.class));
    verify(valueFn).apply(isA(Object.class));
    assertEquals(1, actualIndexByResult.size());
    assertEquals("Apply", actualIndexByResult.get("Apply"));
  }

  /**
   * Method under test:
   * {@link MapUtilities#indexBy(Function, Function, Collection)}
   */
  @Test
  void testIndexBy15() {
    // Arrange
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");
    Function<Object, Object> valueFn = mock(Function.class);
    when(valueFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");

    // Act
    Map<Object, Object> actualIndexByResult = MapUtilities.indexBy(keyFn, valueFn, xs);

    // Assert
    verify(keyFn, atLeast(1)).apply(isA(Object.class));
    verify(valueFn, atLeast(1)).apply(isA(Object.class));
    assertEquals(1, actualIndexByResult.size());
    assertEquals("Apply", actualIndexByResult.get("Apply"));
  }

  /**
   * Method under test:
   * {@link MapUtilities#indexBy(Function, Function, Collection, BinaryOperator)}
   */
  @Test
  void testIndexBy16() {
    // Arrange
    Function<Object, Object> keyFn = mock(Function.class);
    Function<Object, Object> valueFn = mock(Function.class);

    // Act
    Map<Object, Object> actualIndexByResult = MapUtilities.indexBy(keyFn, valueFn, new ArrayList<>(),
        mock(BinaryOperator.class));

    // Assert
    assertTrue(actualIndexByResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link MapUtilities#indexBy(Function, Function, Collection, BinaryOperator)}
   */
  @Test
  void testIndexBy17() {
    // Arrange
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");
    Function<Object, Object> valueFn = mock(Function.class);
    when(valueFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    // Act
    Map<Object, Object> actualIndexByResult = MapUtilities.indexBy(keyFn, valueFn, xs, mock(BinaryOperator.class));

    // Assert
    verify(keyFn).apply(isA(Object.class));
    verify(valueFn).apply(isA(Object.class));
    assertEquals(1, actualIndexByResult.size());
    assertEquals("Apply", actualIndexByResult.get("Apply"));
  }

  /**
   * Method under test:
   * {@link MapUtilities#indexBy(Function, Function, Collection, BinaryOperator)}
   */
  @Test
  void testIndexBy18() {
    // Arrange
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");
    Function<Object, Object> valueFn = mock(Function.class);
    when(valueFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");
    BinaryOperator<Object> mergeFunction = mock(BinaryOperator.class);
    when(mergeFunction.apply(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Map<Object, Object> actualIndexByResult = MapUtilities.indexBy(keyFn, valueFn, xs, mergeFunction);

    // Assert
    verify(mergeFunction).apply(isA(Object.class), isA(Object.class));
    verify(keyFn, atLeast(1)).apply(isA(Object.class));
    verify(valueFn, atLeast(1)).apply(isA(Object.class));
    assertEquals(1, actualIndexByResult.size());
    assertEquals("Apply", actualIndexByResult.get("Apply"));
  }

  /**
   * Method under test: {@link MapUtilities#countBy(Collection, Function)}
   */
  @Test
  void testCountBy() {
    // Arrange and Act
    Map<Object, Long> actualCountByResult = MapUtilities.<Object, Object>countBy(new ArrayList<>(),
        mock(Function.class));

    // Assert
    assertTrue(actualCountByResult.isEmpty());
  }

  /**
   * Method under test: {@link MapUtilities#countBy(Collection, Function)}
   */
  @Test
  void testCountBy2() {
    // Arrange and Act
    Map<Object, Long> actualCountByResult = MapUtilities.<Object, Object>countBy(null, mock(Function.class));

    // Assert
    assertTrue(actualCountByResult.isEmpty());
  }

  /**
   * Method under test: {@link MapUtilities#countBy(Collection, Function)}
   */
  @Test
  void testCountBy3() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Map<Object, Long> actualCountByResult = MapUtilities.countBy(xs, keyFn);

    // Assert
    verify(keyFn).apply(isA(Object.class));
    assertEquals(1, actualCountByResult.size());
    assertEquals(1L, actualCountByResult.get("Apply").longValue());
  }

  /**
   * Method under test: {@link MapUtilities#countBy(Collection, Function)}
   */
  @Test
  void testCountBy4() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Map<Object, Long> actualCountByResult = MapUtilities.countBy(xs, keyFn);

    // Assert
    verify(keyFn, atLeast(1)).apply(isA(Object.class));
    assertEquals(1, actualCountByResult.size());
    assertEquals(2L, actualCountByResult.get("Apply").longValue());
  }

  /**
   * Method under test: {@link MapUtilities#countBy(Function, Collection)}
   */
  @Test
  void testCountBy5() {
    // Arrange
    Function<Object, Object> keyFn = mock(Function.class);

    // Act
    Map<Object, Long> actualCountByResult = MapUtilities.countBy(keyFn, new ArrayList<>());

    // Assert
    assertTrue(actualCountByResult.isEmpty());
  }

  /**
   * Method under test: {@link MapUtilities#countBy(Function, Collection)}
   */
  @Test
  void testCountBy6() {
    // Arrange and Act
    Map<Object, Long> actualCountByResult = MapUtilities.<Object, Object>countBy(mock(Function.class), null);

    // Assert
    assertTrue(actualCountByResult.isEmpty());
  }

  /**
   * Method under test: {@link MapUtilities#countBy(Function, Collection)}
   */
  @Test
  void testCountBy7() {
    // Arrange
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    // Act
    Map<Object, Long> actualCountByResult = MapUtilities.countBy(keyFn, xs);

    // Assert
    verify(keyFn).apply(isA(Object.class));
    assertEquals(1, actualCountByResult.size());
    assertEquals(1L, actualCountByResult.get("Apply").longValue());
  }

  /**
   * Method under test: {@link MapUtilities#countBy(Function, Collection)}
   */
  @Test
  void testCountBy8() {
    // Arrange
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");

    // Act
    Map<Object, Long> actualCountByResult = MapUtilities.countBy(keyFn, xs);

    // Assert
    verify(keyFn, atLeast(1)).apply(isA(Object.class));
    assertEquals(1, actualCountByResult.size());
    assertEquals(2L, actualCountByResult.get("Apply").longValue());
  }

  /**
   * Method under test: {@link MapUtilities#ensureNotNull(Map)}
   */
  @Test
  void testEnsureNotNull() {
    // Arrange and Act
    Map<Object, Object> actualEnsureNotNullResult = MapUtilities.ensureNotNull(null);

    // Assert
    assertTrue(actualEnsureNotNullResult.isEmpty());
  }

  /**
   * Method under test: {@link MapUtilities#isEmpty(Map)}
   */
  @Test
  void testIsEmpty() {
    // Arrange
    HashMap<String, Object> map = MapUtilities.newHashMap();

    // Act and Assert
    assertTrue(MapUtilities.isEmpty(map));
  }

  /**
   * Method under test: {@link MapUtilities#isEmpty(Map)}
   */
  @Test
  void testIsEmpty2() {
    // Arrange, Act and Assert
    assertTrue(MapUtilities.isEmpty(null));
  }

  /**
   * Method under test: {@link MapUtilities#isEmpty(Map)}
   */
  @Test
  void testIsEmpty3() {
    // Arrange
    HashMap<String, Object> map = MapUtilities.newHashMap();
    map.put("foo", "42");

    // Act and Assert
    assertFalse(MapUtilities.isEmpty(map));
  }

  /**
   * Method under test: {@link MapUtilities#isEmpty(Map)}
   */
  @Test
  void testIsEmpty4() {
    // Arrange
    HashMap<String, Object> map = MapUtilities.newHashMap();
    map.computeIfPresent("foo", mock(BiFunction.class));
    map.put("foo", "42");

    // Act and Assert
    assertFalse(MapUtilities.isEmpty(map));
  }

  /**
   * Method under test: {@link MapUtilities#maybeGet(Map, Object)}
   */
  @Test
  void testMaybeGet() {
    // Arrange
    HashMap<String, Object> map = MapUtilities.newHashMap();

    // Act
    Optional<Object> actualMaybeGetResult = MapUtilities.maybeGet(map, "Key");

    // Assert
    assertFalse(actualMaybeGetResult.isPresent());
  }

  /**
   * Method under test: {@link MapUtilities#maybeGet(Map, Object)}
   */
  @Test
  void testMaybeGet2() {
    // Arrange and Act
    Optional<Object> actualMaybeGetResult = MapUtilities.maybeGet(null, "Key");

    // Assert
    assertFalse(actualMaybeGetResult.isPresent());
  }

  /**
   * Method under test: {@link MapUtilities#maybeGet(Map, Object)}
   */
  @Test
  void testMaybeGet3() {
    // Arrange
    HashMap<String, Object> map = MapUtilities.newHashMap();
    map.computeIfPresent("foo", mock(BiFunction.class));

    // Act
    Optional<Object> actualMaybeGetResult = MapUtilities.maybeGet(map, "Key");

    // Assert
    assertFalse(actualMaybeGetResult.isPresent());
  }

  /**
   * Method under test:
   * {@link MapUtilities#groupAndThen(Collection, Function, Function)}
   */
  @Test
  void testGroupAndThen() {
    // Arrange and Act
    Map<Object, Object> actualGroupAndThenResult = MapUtilities.<Object, Object, Object>groupAndThen(new ArrayList<>(),
        mock(Function.class), mock(Function.class));

    // Assert
    assertTrue(actualGroupAndThenResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link MapUtilities#groupAndThen(Collection, Function, Function)}
   */
  @Test
  void testGroupAndThen2() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");
    Function<Collection<Object>, Object> valueFn = mock(Function.class);
    when(valueFn.apply(Mockito.<Collection<Object>>any())).thenReturn("Apply");

    // Act
    Map<Object, Object> actualGroupAndThenResult = MapUtilities.groupAndThen(xs, keyFn, valueFn);

    // Assert
    verify(keyFn).apply(isA(Object.class));
    verify(valueFn).apply(isA(Collection.class));
    assertEquals(1, actualGroupAndThenResult.size());
    assertEquals("Apply", actualGroupAndThenResult.get("Apply"));
  }

  /**
   * Method under test:
   * {@link MapUtilities#groupAndThen(Collection, Function, Function)}
   */
  @Test
  void testGroupAndThen3() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");
    Function<Collection<Object>, Object> valueFn = mock(Function.class);
    when(valueFn.apply(Mockito.<Collection<Object>>any())).thenReturn("Apply");

    // Act
    Map<Object, Object> actualGroupAndThenResult = MapUtilities.groupAndThen(xs, keyFn, valueFn);

    // Assert
    verify(valueFn).apply(isA(Collection.class));
    verify(keyFn, atLeast(1)).apply(isA(Object.class));
    assertEquals(1, actualGroupAndThenResult.size());
    assertEquals("Apply", actualGroupAndThenResult.get("Apply"));
  }
}
