package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Function;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PairDiffResultDiffblueTest {
  /**
   * Method under test:
   * {@link PairDiffResult#mkPairDiff(Collection, Collection, Function, Function, BiPredicate)}
   */
  @Test
  void testMkPairDiff() {
    // Arrange
    ArrayList<Object> waltzRecords = new ArrayList<>();

    // Act
    PairDiffResult<Object, Object> actualMkPairDiffResult = PairDiffResult.<Object, Object, Object>mkPairDiff(
        waltzRecords, new ArrayList<>(), mock(Function.class), mock(Function.class), mock(BiPredicate.class));

    // Assert
    Collection<Tuple2<Object, Object>> allIntersectionResult = actualMkPairDiffResult.allIntersection();
    assertTrue(allIntersectionResult instanceof Set);
    Collection<Tuple2<Object, Object>> differingIntersectionResult = actualMkPairDiffResult.differingIntersection();
    assertTrue(differingIntersectionResult instanceof Set);
    Collection<Object> otherOnlyResult = actualMkPairDiffResult.otherOnly();
    assertTrue(otherOnlyResult instanceof Set);
    Collection<Object> waltzOnlyResult = actualMkPairDiffResult.waltzOnly();
    assertTrue(waltzOnlyResult instanceof Set);
    assertTrue(actualMkPairDiffResult instanceof ImmutablePairDiffResult);
    assertTrue(allIntersectionResult.isEmpty());
    assertTrue(differingIntersectionResult.isEmpty());
    assertTrue(otherOnlyResult.isEmpty());
    assertTrue(waltzOnlyResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link PairDiffResult#mkPairDiff(Collection, Collection, Function, Function, BiPredicate)}
   */
  @Test
  void testMkPairDiff2() {
    // Arrange
    ArrayList<Object> waltzRecords = new ArrayList<>();
    waltzRecords.add("42");
    ArrayList<Object> otherRecords = new ArrayList<>();
    Function<Object, Object> aKeyFn = mock(Function.class);
    when(aKeyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    PairDiffResult<Object, Object> actualMkPairDiffResult = PairDiffResult.mkPairDiff(waltzRecords, otherRecords,
        aKeyFn, mock(Function.class), mock(BiPredicate.class));

    // Assert
    verify(aKeyFn, atLeast(1)).apply(isA(Object.class));
    Collection<Tuple2<Object, Object>> allIntersectionResult = actualMkPairDiffResult.allIntersection();
    assertTrue(allIntersectionResult instanceof Set);
    Collection<Tuple2<Object, Object>> differingIntersectionResult = actualMkPairDiffResult.differingIntersection();
    assertTrue(differingIntersectionResult instanceof Set);
    Collection<Object> otherOnlyResult = actualMkPairDiffResult.otherOnly();
    assertTrue(otherOnlyResult instanceof Set);
    Collection<Object> waltzOnlyResult = actualMkPairDiffResult.waltzOnly();
    assertEquals(1, waltzOnlyResult.size());
    assertTrue(waltzOnlyResult instanceof Set);
    assertTrue(actualMkPairDiffResult instanceof ImmutablePairDiffResult);
    assertTrue(allIntersectionResult.isEmpty());
    assertTrue(differingIntersectionResult.isEmpty());
    assertTrue(otherOnlyResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link PairDiffResult#mkPairDiff(Collection, Collection, Function, Function, BiPredicate)}
   */
  @Test
  void testMkPairDiff3() {
    // Arrange
    ArrayList<Object> waltzRecords = new ArrayList<>();
    waltzRecords.add("42");
    waltzRecords.add("42");
    ArrayList<Object> otherRecords = new ArrayList<>();
    Function<Object, Object> aKeyFn = mock(Function.class);
    when(aKeyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    PairDiffResult<Object, Object> actualMkPairDiffResult = PairDiffResult.mkPairDiff(waltzRecords, otherRecords,
        aKeyFn, mock(Function.class), mock(BiPredicate.class));

    // Assert
    verify(aKeyFn, atLeast(1)).apply(isA(Object.class));
    Collection<Tuple2<Object, Object>> allIntersectionResult = actualMkPairDiffResult.allIntersection();
    assertTrue(allIntersectionResult instanceof Set);
    Collection<Tuple2<Object, Object>> differingIntersectionResult = actualMkPairDiffResult.differingIntersection();
    assertTrue(differingIntersectionResult instanceof Set);
    Collection<Object> otherOnlyResult = actualMkPairDiffResult.otherOnly();
    assertTrue(otherOnlyResult instanceof Set);
    Collection<Object> waltzOnlyResult = actualMkPairDiffResult.waltzOnly();
    assertEquals(1, waltzOnlyResult.size());
    assertTrue(waltzOnlyResult instanceof Set);
    assertTrue(actualMkPairDiffResult instanceof ImmutablePairDiffResult);
    assertTrue(allIntersectionResult.isEmpty());
    assertTrue(differingIntersectionResult.isEmpty());
    assertTrue(otherOnlyResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link PairDiffResult#mkPairDiff(Collection, Collection, Function, Function, BiPredicate)}
   */
  @Test
  void testMkPairDiff4() {
    // Arrange
    ArrayList<Object> waltzRecords = new ArrayList<>();
    waltzRecords.add("42");

    ArrayList<Object> otherRecords = new ArrayList<>();
    otherRecords.add("42");
    Function<Object, Object> aKeyFn = mock(Function.class);
    when(aKeyFn.apply(Mockito.<Object>any())).thenReturn("Apply");
    Function<Object, Object> bKeyFn = mock(Function.class);
    when(bKeyFn.apply(Mockito.<Object>any())).thenReturn("Apply");
    BiPredicate<Object, Object> equalityPredicate = mock(BiPredicate.class);
    when(equalityPredicate.test(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(true);

    // Act
    PairDiffResult<Object, Object> actualMkPairDiffResult = PairDiffResult.mkPairDiff(waltzRecords, otherRecords,
        aKeyFn, bKeyFn, equalityPredicate);

    // Assert
    verify(equalityPredicate).test(isA(Object.class), isA(Object.class));
    verify(aKeyFn, atLeast(1)).apply(isA(Object.class));
    verify(bKeyFn, atLeast(1)).apply(isA(Object.class));
    Collection<Tuple2<Object, Object>> allIntersectionResult = actualMkPairDiffResult.allIntersection();
    assertEquals(1, allIntersectionResult.size());
    assertTrue(allIntersectionResult instanceof Set);
    Collection<Tuple2<Object, Object>> differingIntersectionResult = actualMkPairDiffResult.differingIntersection();
    assertTrue(differingIntersectionResult instanceof Set);
    Collection<Object> otherOnlyResult = actualMkPairDiffResult.otherOnly();
    assertTrue(otherOnlyResult instanceof Set);
    Collection<Object> waltzOnlyResult = actualMkPairDiffResult.waltzOnly();
    assertTrue(waltzOnlyResult instanceof Set);
    assertTrue(actualMkPairDiffResult instanceof ImmutablePairDiffResult);
    assertTrue(differingIntersectionResult.isEmpty());
    assertTrue(otherOnlyResult.isEmpty());
    assertTrue(waltzOnlyResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link PairDiffResult#mkPairDiff(Collection, Collection, Function, Function, BiPredicate)}
   */
  @Test
  void testMkPairDiff5() {
    // Arrange
    ArrayList<Object> waltzRecords = new ArrayList<>();
    waltzRecords.add(null);

    ArrayList<Object> otherRecords = new ArrayList<>();
    otherRecords.add("42");
    Function<Object, Object> aKeyFn = mock(Function.class);
    when(aKeyFn.apply(Mockito.<Object>any())).thenReturn("Apply");
    Function<Object, Object> bKeyFn = mock(Function.class);
    when(bKeyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    PairDiffResult<Object, Object> actualMkPairDiffResult = PairDiffResult.mkPairDiff(waltzRecords, otherRecords,
        aKeyFn, bKeyFn, mock(BiPredicate.class));

    // Assert
    verify(aKeyFn, atLeast(1)).apply(isNull());
    verify(bKeyFn, atLeast(1)).apply(isA(Object.class));
    Collection<Tuple2<Object, Object>> allIntersectionResult = actualMkPairDiffResult.allIntersection();
    assertTrue(allIntersectionResult instanceof Set);
    Collection<Tuple2<Object, Object>> differingIntersectionResult = actualMkPairDiffResult.differingIntersection();
    assertTrue(differingIntersectionResult instanceof Set);
    Collection<Object> otherOnlyResult = actualMkPairDiffResult.otherOnly();
    assertTrue(otherOnlyResult instanceof Set);
    Collection<Object> waltzOnlyResult = actualMkPairDiffResult.waltzOnly();
    assertTrue(waltzOnlyResult instanceof Set);
    assertTrue(actualMkPairDiffResult instanceof ImmutablePairDiffResult);
    assertTrue(allIntersectionResult.isEmpty());
    assertTrue(differingIntersectionResult.isEmpty());
    assertTrue(otherOnlyResult.isEmpty());
    assertTrue(waltzOnlyResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link PairDiffResult#mkPairDiff(Collection, Collection, Function, Function, BiPredicate)}
   */
  @Test
  void testMkPairDiff6() {
    // Arrange
    ArrayList<Object> waltzRecords = new ArrayList<>();
    waltzRecords.add("42");

    ArrayList<Object> otherRecords = new ArrayList<>();
    otherRecords.add("42");
    otherRecords.add("42");
    Function<Object, Object> aKeyFn = mock(Function.class);
    when(aKeyFn.apply(Mockito.<Object>any())).thenReturn("Apply");
    Function<Object, Object> bKeyFn = mock(Function.class);
    when(bKeyFn.apply(Mockito.<Object>any())).thenReturn("Apply");
    BiPredicate<Object, Object> equalityPredicate = mock(BiPredicate.class);
    when(equalityPredicate.test(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(true);

    // Act
    PairDiffResult<Object, Object> actualMkPairDiffResult = PairDiffResult.mkPairDiff(waltzRecords, otherRecords,
        aKeyFn, bKeyFn, equalityPredicate);

    // Assert
    verify(equalityPredicate).test(isA(Object.class), isA(Object.class));
    verify(aKeyFn, atLeast(1)).apply(isA(Object.class));
    verify(bKeyFn, atLeast(1)).apply(isA(Object.class));
    Collection<Tuple2<Object, Object>> allIntersectionResult = actualMkPairDiffResult.allIntersection();
    assertEquals(1, allIntersectionResult.size());
    assertTrue(allIntersectionResult instanceof Set);
    Collection<Tuple2<Object, Object>> differingIntersectionResult = actualMkPairDiffResult.differingIntersection();
    assertTrue(differingIntersectionResult instanceof Set);
    Collection<Object> otherOnlyResult = actualMkPairDiffResult.otherOnly();
    assertTrue(otherOnlyResult instanceof Set);
    Collection<Object> waltzOnlyResult = actualMkPairDiffResult.waltzOnly();
    assertTrue(waltzOnlyResult instanceof Set);
    assertTrue(actualMkPairDiffResult instanceof ImmutablePairDiffResult);
    assertTrue(differingIntersectionResult.isEmpty());
    assertTrue(otherOnlyResult.isEmpty());
    assertTrue(waltzOnlyResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link PairDiffResult#mkPairDiff(Collection, Collection, Function, Function, BiPredicate)}
   */
  @Test
  void testMkPairDiff7() {
    // Arrange
    ArrayList<Object> waltzRecords = new ArrayList<>();
    waltzRecords.add("42");

    ArrayList<Object> otherRecords = new ArrayList<>();
    otherRecords.add("42");
    Function<Object, Object> aKeyFn = mock(Function.class);
    when(aKeyFn.apply(Mockito.<Object>any())).thenReturn(new HashMap<>());
    Function<Object, Object> bKeyFn = mock(Function.class);
    when(bKeyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    PairDiffResult<Object, Object> actualMkPairDiffResult = PairDiffResult.mkPairDiff(waltzRecords, otherRecords,
        aKeyFn, bKeyFn, mock(BiPredicate.class));

    // Assert
    verify(aKeyFn, atLeast(1)).apply(isA(Object.class));
    verify(bKeyFn, atLeast(1)).apply(isA(Object.class));
    Collection<Tuple2<Object, Object>> allIntersectionResult = actualMkPairDiffResult.allIntersection();
    assertTrue(allIntersectionResult instanceof Set);
    Collection<Tuple2<Object, Object>> differingIntersectionResult = actualMkPairDiffResult.differingIntersection();
    assertTrue(differingIntersectionResult instanceof Set);
    Collection<Object> otherOnlyResult = actualMkPairDiffResult.otherOnly();
    assertEquals(1, otherOnlyResult.size());
    assertTrue(otherOnlyResult instanceof Set);
    Collection<Object> waltzOnlyResult = actualMkPairDiffResult.waltzOnly();
    assertEquals(1, waltzOnlyResult.size());
    assertTrue(waltzOnlyResult instanceof Set);
    assertTrue(actualMkPairDiffResult instanceof ImmutablePairDiffResult);
    assertTrue(allIntersectionResult.isEmpty());
    assertTrue(differingIntersectionResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link PairDiffResult#mkPairDiff(Collection, Collection, Function, Function, BiPredicate)}
   */
  @Test
  void testMkPairDiff8() {
    // Arrange
    ArrayList<Object> waltzRecords = new ArrayList<>();
    waltzRecords.add("42");

    ArrayList<Object> otherRecords = new ArrayList<>();
    otherRecords.add("42");
    Function<Object, Object> aKeyFn = mock(Function.class);
    when(aKeyFn.apply(Mockito.<Object>any())).thenReturn("Apply");
    Function<Object, Object> bKeyFn = mock(Function.class);
    when(bKeyFn.apply(Mockito.<Object>any())).thenReturn("Apply");
    BiPredicate<Object, Object> equalityPredicate = mock(BiPredicate.class);
    when(equalityPredicate.test(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(false);

    // Act
    PairDiffResult<Object, Object> actualMkPairDiffResult = PairDiffResult.mkPairDiff(waltzRecords, otherRecords,
        aKeyFn, bKeyFn, equalityPredicate);

    // Assert
    verify(equalityPredicate).test(isA(Object.class), isA(Object.class));
    verify(aKeyFn, atLeast(1)).apply(isA(Object.class));
    verify(bKeyFn, atLeast(1)).apply(isA(Object.class));
    Collection<Tuple2<Object, Object>> allIntersectionResult = actualMkPairDiffResult.allIntersection();
    assertEquals(1, allIntersectionResult.size());
    assertTrue(allIntersectionResult instanceof Set);
    Collection<Tuple2<Object, Object>> differingIntersectionResult = actualMkPairDiffResult.differingIntersection();
    assertEquals(1, differingIntersectionResult.size());
    assertTrue(differingIntersectionResult instanceof Set);
    Collection<Object> otherOnlyResult = actualMkPairDiffResult.otherOnly();
    assertTrue(otherOnlyResult instanceof Set);
    Collection<Object> waltzOnlyResult = actualMkPairDiffResult.waltzOnly();
    assertTrue(waltzOnlyResult instanceof Set);
    assertTrue(actualMkPairDiffResult instanceof ImmutablePairDiffResult);
    assertTrue(otherOnlyResult.isEmpty());
    assertTrue(waltzOnlyResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link PairDiffResult#mkPairDiff(Collection, Collection, Function, Function, BiPredicate)}
   */
  @Test
  void testMkPairDiff9() {
    // Arrange
    ArrayList<Object> waltzRecords = new ArrayList<>();
    waltzRecords.add("42");

    ArrayList<Object> otherRecords = new ArrayList<>();
    otherRecords.add("42");
    otherRecords.add(new HashMap<>());
    Function<Object, Object> aKeyFn = mock(Function.class);
    when(aKeyFn.apply(Mockito.<Object>any())).thenReturn("Apply");
    Function<Object, Object> bKeyFn = mock(Function.class);
    when(bKeyFn.apply(Mockito.<Object>any())).thenReturn("Apply");
    BiPredicate<Object, Object> equalityPredicate = mock(BiPredicate.class);
    when(equalityPredicate.test(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(true);

    // Act
    PairDiffResult<Object, Object> actualMkPairDiffResult = PairDiffResult.mkPairDiff(waltzRecords, otherRecords,
        aKeyFn, bKeyFn, equalityPredicate);

    // Assert
    verify(equalityPredicate, atLeast(1)).test(isA(Object.class), Mockito.<Object>any());
    verify(aKeyFn, atLeast(1)).apply(isA(Object.class));
    verify(bKeyFn, atLeast(1)).apply(Mockito.<Object>any());
    Collection<Tuple2<Object, Object>> allIntersectionResult = actualMkPairDiffResult.allIntersection();
    assertEquals(2, allIntersectionResult.size());
    assertTrue(allIntersectionResult instanceof Set);
    Collection<Tuple2<Object, Object>> differingIntersectionResult = actualMkPairDiffResult.differingIntersection();
    assertTrue(differingIntersectionResult instanceof Set);
    Collection<Object> otherOnlyResult = actualMkPairDiffResult.otherOnly();
    assertTrue(otherOnlyResult instanceof Set);
    Collection<Object> waltzOnlyResult = actualMkPairDiffResult.waltzOnly();
    assertTrue(waltzOnlyResult instanceof Set);
    assertTrue(actualMkPairDiffResult instanceof ImmutablePairDiffResult);
    assertTrue(differingIntersectionResult.isEmpty());
    assertTrue(otherOnlyResult.isEmpty());
    assertTrue(waltzOnlyResult.isEmpty());
  }
}
