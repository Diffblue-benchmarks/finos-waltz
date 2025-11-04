package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
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
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DiffResultDiffblueTest {
  /**
   * Method under test: {@link DiffResult#mkDiff(Collection, Collection)}
   */
  @Test
  void testMkDiff() {
    // Arrange
    ArrayList<Object> waltzRecords = new ArrayList<>();

    // Act
    DiffResult<Object> actualMkDiffResult = DiffResult.mkDiff(waltzRecords, new ArrayList<>());

    // Assert
    Collection<Object> differingIntersectionResult = actualMkDiffResult.differingIntersection();
    assertTrue(differingIntersectionResult instanceof Set);
    Collection<Object> intersectionResult = actualMkDiffResult.intersection();
    assertTrue(intersectionResult instanceof Set);
    Collection<Object> otherOnlyResult = actualMkDiffResult.otherOnly();
    assertTrue(otherOnlyResult instanceof Set);
    Collection<Object> waltzOnlyResult = actualMkDiffResult.waltzOnly();
    assertTrue(waltzOnlyResult instanceof Set);
    assertTrue(actualMkDiffResult instanceof ImmutableDiffResult);
    assertTrue(differingIntersectionResult.isEmpty());
    assertTrue(intersectionResult.isEmpty());
    assertTrue(otherOnlyResult.isEmpty());
    assertTrue(waltzOnlyResult.isEmpty());
  }

  /**
   * Method under test: {@link DiffResult#mkDiff(Collection, Collection)}
   */
  @Test
  void testMkDiff2() {
    // Arrange
    ArrayList<Object> waltzRecords = new ArrayList<>();
    waltzRecords.add("42");

    // Act
    DiffResult<Object> actualMkDiffResult = DiffResult.mkDiff(waltzRecords, new ArrayList<>());

    // Assert
    Collection<Object> differingIntersectionResult = actualMkDiffResult.differingIntersection();
    assertTrue(differingIntersectionResult instanceof Set);
    Collection<Object> intersectionResult = actualMkDiffResult.intersection();
    assertTrue(intersectionResult instanceof Set);
    Collection<Object> otherOnlyResult = actualMkDiffResult.otherOnly();
    assertTrue(otherOnlyResult instanceof Set);
    Collection<Object> waltzOnlyResult = actualMkDiffResult.waltzOnly();
    assertEquals(1, waltzOnlyResult.size());
    assertTrue(waltzOnlyResult instanceof Set);
    assertTrue(actualMkDiffResult instanceof ImmutableDiffResult);
    assertTrue(differingIntersectionResult.isEmpty());
    assertTrue(intersectionResult.isEmpty());
    assertTrue(otherOnlyResult.isEmpty());
  }

  /**
   * Method under test: {@link DiffResult#mkDiff(Collection, Collection)}
   */
  @Test
  void testMkDiff3() {
    // Arrange
    ArrayList<Object> waltzRecords = new ArrayList<>();
    waltzRecords.add("42");
    waltzRecords.add("42");

    // Act
    DiffResult<Object> actualMkDiffResult = DiffResult.mkDiff(waltzRecords, new ArrayList<>());

    // Assert
    Collection<Object> differingIntersectionResult = actualMkDiffResult.differingIntersection();
    assertTrue(differingIntersectionResult instanceof Set);
    Collection<Object> intersectionResult = actualMkDiffResult.intersection();
    assertTrue(intersectionResult instanceof Set);
    Collection<Object> otherOnlyResult = actualMkDiffResult.otherOnly();
    assertTrue(otherOnlyResult instanceof Set);
    Collection<Object> waltzOnlyResult = actualMkDiffResult.waltzOnly();
    assertEquals(1, waltzOnlyResult.size());
    assertTrue(waltzOnlyResult instanceof Set);
    assertTrue(actualMkDiffResult instanceof ImmutableDiffResult);
    assertTrue(differingIntersectionResult.isEmpty());
    assertTrue(intersectionResult.isEmpty());
    assertTrue(otherOnlyResult.isEmpty());
  }

  /**
   * Method under test: {@link DiffResult#mkDiff(Collection, Collection)}
   */
  @Test
  void testMkDiff4() {
    // Arrange
    ArrayList<Object> waltzRecords = new ArrayList<>();

    ArrayList<Object> otherRecords = new ArrayList<>();
    otherRecords.add("42");

    // Act
    DiffResult<Object> actualMkDiffResult = DiffResult.mkDiff(waltzRecords, otherRecords);

    // Assert
    Collection<Object> differingIntersectionResult = actualMkDiffResult.differingIntersection();
    assertTrue(differingIntersectionResult instanceof Set);
    Collection<Object> intersectionResult = actualMkDiffResult.intersection();
    assertTrue(intersectionResult instanceof Set);
    Collection<Object> otherOnlyResult = actualMkDiffResult.otherOnly();
    assertEquals(1, otherOnlyResult.size());
    assertTrue(otherOnlyResult instanceof Set);
    Collection<Object> waltzOnlyResult = actualMkDiffResult.waltzOnly();
    assertTrue(waltzOnlyResult instanceof Set);
    assertTrue(actualMkDiffResult instanceof ImmutableDiffResult);
    assertTrue(differingIntersectionResult.isEmpty());
    assertTrue(intersectionResult.isEmpty());
    assertTrue(waltzOnlyResult.isEmpty());
  }

  /**
   * Method under test: {@link DiffResult#mkDiff(Collection, Collection)}
   */
  @Test
  void testMkDiff5() {
    // Arrange
    ArrayList<Object> waltzRecords = new ArrayList<>();

    ArrayList<Object> otherRecords = new ArrayList<>();
    otherRecords.add("42");
    otherRecords.add("42");

    // Act
    DiffResult<Object> actualMkDiffResult = DiffResult.mkDiff(waltzRecords, otherRecords);

    // Assert
    Collection<Object> differingIntersectionResult = actualMkDiffResult.differingIntersection();
    assertTrue(differingIntersectionResult instanceof Set);
    Collection<Object> intersectionResult = actualMkDiffResult.intersection();
    assertTrue(intersectionResult instanceof Set);
    Collection<Object> otherOnlyResult = actualMkDiffResult.otherOnly();
    assertEquals(1, otherOnlyResult.size());
    assertTrue(otherOnlyResult instanceof Set);
    Collection<Object> waltzOnlyResult = actualMkDiffResult.waltzOnly();
    assertTrue(waltzOnlyResult instanceof Set);
    assertTrue(actualMkDiffResult instanceof ImmutableDiffResult);
    assertTrue(differingIntersectionResult.isEmpty());
    assertTrue(intersectionResult.isEmpty());
    assertTrue(waltzOnlyResult.isEmpty());
  }

  /**
   * Method under test: {@link DiffResult#mkDiff(Collection, Collection)}
   */
  @Test
  void testMkDiff6() {
    // Arrange
    ArrayList<Object> waltzRecords = new ArrayList<>();
    waltzRecords.add("42");

    ArrayList<Object> otherRecords = new ArrayList<>();
    otherRecords.add("42");

    // Act
    DiffResult<Object> actualMkDiffResult = DiffResult.mkDiff(waltzRecords, otherRecords);

    // Assert
    Collection<Object> differingIntersectionResult = actualMkDiffResult.differingIntersection();
    assertTrue(differingIntersectionResult instanceof Set);
    Collection<Object> intersectionResult = actualMkDiffResult.intersection();
    assertEquals(1, intersectionResult.size());
    assertTrue(intersectionResult instanceof Set);
    Collection<Object> otherOnlyResult = actualMkDiffResult.otherOnly();
    assertTrue(otherOnlyResult instanceof Set);
    Collection<Object> waltzOnlyResult = actualMkDiffResult.waltzOnly();
    assertTrue(waltzOnlyResult instanceof Set);
    assertTrue(actualMkDiffResult instanceof ImmutableDiffResult);
    assertTrue(differingIntersectionResult.isEmpty());
    assertTrue(otherOnlyResult.isEmpty());
    assertTrue(waltzOnlyResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link DiffResult#mkDiff(Collection, Collection, Function, BiPredicate)}
   */
  @Test
  void testMkDiff7() {
    // Arrange
    ArrayList<Object> waltzRecords = new ArrayList<>();

    // Act
    DiffResult<Object> actualMkDiffResult = DiffResult.<Object, Object>mkDiff(waltzRecords, new ArrayList<>(),
        mock(Function.class), mock(BiPredicate.class));

    // Assert
    Collection<Object> differingIntersectionResult = actualMkDiffResult.differingIntersection();
    assertTrue(differingIntersectionResult instanceof Set);
    Collection<Object> intersectionResult = actualMkDiffResult.intersection();
    assertTrue(intersectionResult instanceof Set);
    Collection<Object> otherOnlyResult = actualMkDiffResult.otherOnly();
    assertTrue(otherOnlyResult instanceof Set);
    Collection<Object> waltzOnlyResult = actualMkDiffResult.waltzOnly();
    assertTrue(waltzOnlyResult instanceof Set);
    assertTrue(actualMkDiffResult instanceof ImmutableDiffResult);
    assertTrue(differingIntersectionResult.isEmpty());
    assertTrue(intersectionResult.isEmpty());
    assertTrue(otherOnlyResult.isEmpty());
    assertTrue(waltzOnlyResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link DiffResult#mkDiff(Collection, Collection, Function, BiPredicate)}
   */
  @Test
  void testMkDiff8() {
    // Arrange
    ArrayList<Object> waltzRecords = new ArrayList<>();

    // Act
    DiffResult<Object> actualMkDiffResult = DiffResult.<Object, Object>mkDiff(waltzRecords, new ArrayList<>(),
        mock(Function.class), null);

    // Assert
    Collection<Object> differingIntersectionResult = actualMkDiffResult.differingIntersection();
    assertTrue(differingIntersectionResult instanceof Set);
    Collection<Object> intersectionResult = actualMkDiffResult.intersection();
    assertTrue(intersectionResult instanceof Set);
    Collection<Object> otherOnlyResult = actualMkDiffResult.otherOnly();
    assertTrue(otherOnlyResult instanceof Set);
    Collection<Object> waltzOnlyResult = actualMkDiffResult.waltzOnly();
    assertTrue(waltzOnlyResult instanceof Set);
    assertTrue(actualMkDiffResult instanceof ImmutableDiffResult);
    assertTrue(differingIntersectionResult.isEmpty());
    assertTrue(intersectionResult.isEmpty());
    assertTrue(otherOnlyResult.isEmpty());
    assertTrue(waltzOnlyResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link DiffResult#mkDiff(Collection, Collection, Function, BiPredicate)}
   */
  @Test
  void testMkDiff9() {
    // Arrange
    ArrayList<Object> waltzRecords = new ArrayList<>();
    waltzRecords.add("42");
    ArrayList<Object> otherRecords = new ArrayList<>();
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    DiffResult<Object> actualMkDiffResult = DiffResult.mkDiff(waltzRecords, otherRecords, keyFn,
        mock(BiPredicate.class));

    // Assert
    verify(keyFn, atLeast(1)).apply(isA(Object.class));
    Collection<Object> differingIntersectionResult = actualMkDiffResult.differingIntersection();
    assertTrue(differingIntersectionResult instanceof Set);
    Collection<Object> intersectionResult = actualMkDiffResult.intersection();
    assertTrue(intersectionResult instanceof Set);
    Collection<Object> otherOnlyResult = actualMkDiffResult.otherOnly();
    assertTrue(otherOnlyResult instanceof Set);
    Collection<Object> waltzOnlyResult = actualMkDiffResult.waltzOnly();
    assertEquals(1, waltzOnlyResult.size());
    assertTrue(waltzOnlyResult instanceof Set);
    assertTrue(actualMkDiffResult instanceof ImmutableDiffResult);
    assertTrue(differingIntersectionResult.isEmpty());
    assertTrue(intersectionResult.isEmpty());
    assertTrue(otherOnlyResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link DiffResult#mkDiff(Collection, Collection, Function, BiPredicate)}
   */
  @Test
  void testMkDiff10() {
    // Arrange
    ArrayList<Object> waltzRecords = new ArrayList<>();
    waltzRecords.add("42");
    waltzRecords.add("42");
    ArrayList<Object> otherRecords = new ArrayList<>();
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    DiffResult<Object> actualMkDiffResult = DiffResult.mkDiff(waltzRecords, otherRecords, keyFn,
        mock(BiPredicate.class));

    // Assert
    verify(keyFn, atLeast(1)).apply(isA(Object.class));
    Collection<Object> differingIntersectionResult = actualMkDiffResult.differingIntersection();
    assertTrue(differingIntersectionResult instanceof Set);
    Collection<Object> intersectionResult = actualMkDiffResult.intersection();
    assertTrue(intersectionResult instanceof Set);
    Collection<Object> otherOnlyResult = actualMkDiffResult.otherOnly();
    assertTrue(otherOnlyResult instanceof Set);
    Collection<Object> waltzOnlyResult = actualMkDiffResult.waltzOnly();
    assertEquals(1, waltzOnlyResult.size());
    assertTrue(waltzOnlyResult instanceof Set);
    assertTrue(actualMkDiffResult instanceof ImmutableDiffResult);
    assertTrue(differingIntersectionResult.isEmpty());
    assertTrue(intersectionResult.isEmpty());
    assertTrue(otherOnlyResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link DiffResult#mkDiff(Collection, Collection, Function, BiPredicate)}
   */
  @Test
  void testMkDiff11() {
    // Arrange
    ArrayList<Object> waltzRecords = new ArrayList<>();
    waltzRecords.add("42");

    ArrayList<Object> otherRecords = new ArrayList<>();
    otherRecords.add("42");
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");
    BiPredicate<Object, Object> equalityPredicate = mock(BiPredicate.class);
    when(equalityPredicate.test(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(true);

    // Act
    DiffResult<Object> actualMkDiffResult = DiffResult.mkDiff(waltzRecords, otherRecords, keyFn, equalityPredicate);

    // Assert
    verify(equalityPredicate).test(isA(Object.class), isA(Object.class));
    verify(keyFn, atLeast(1)).apply(isA(Object.class));
    Collection<Object> differingIntersectionResult = actualMkDiffResult.differingIntersection();
    assertTrue(differingIntersectionResult instanceof Set);
    Collection<Object> intersectionResult = actualMkDiffResult.intersection();
    assertEquals(1, intersectionResult.size());
    assertTrue(intersectionResult instanceof Set);
    Collection<Object> otherOnlyResult = actualMkDiffResult.otherOnly();
    assertTrue(otherOnlyResult instanceof Set);
    Collection<Object> waltzOnlyResult = actualMkDiffResult.waltzOnly();
    assertTrue(waltzOnlyResult instanceof Set);
    assertTrue(actualMkDiffResult instanceof ImmutableDiffResult);
    assertTrue(differingIntersectionResult.isEmpty());
    assertTrue(otherOnlyResult.isEmpty());
    assertTrue(waltzOnlyResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link DiffResult#mkDiff(Collection, Collection, Function, BiPredicate)}
   */
  @Test
  void testMkDiff12() {
    // Arrange
    ArrayList<Object> waltzRecords = new ArrayList<>();
    waltzRecords.add("42");

    ArrayList<Object> otherRecords = new ArrayList<>();
    otherRecords.add("42");
    otherRecords.add("42");
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");
    BiPredicate<Object, Object> equalityPredicate = mock(BiPredicate.class);
    when(equalityPredicate.test(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(true);

    // Act
    DiffResult<Object> actualMkDiffResult = DiffResult.mkDiff(waltzRecords, otherRecords, keyFn, equalityPredicate);

    // Assert
    verify(equalityPredicate).test(isA(Object.class), isA(Object.class));
    verify(keyFn, atLeast(1)).apply(isA(Object.class));
    Collection<Object> differingIntersectionResult = actualMkDiffResult.differingIntersection();
    assertTrue(differingIntersectionResult instanceof Set);
    Collection<Object> intersectionResult = actualMkDiffResult.intersection();
    assertEquals(1, intersectionResult.size());
    assertTrue(intersectionResult instanceof Set);
    Collection<Object> otherOnlyResult = actualMkDiffResult.otherOnly();
    assertTrue(otherOnlyResult instanceof Set);
    Collection<Object> waltzOnlyResult = actualMkDiffResult.waltzOnly();
    assertTrue(waltzOnlyResult instanceof Set);
    assertTrue(actualMkDiffResult instanceof ImmutableDiffResult);
    assertTrue(differingIntersectionResult.isEmpty());
    assertTrue(otherOnlyResult.isEmpty());
    assertTrue(waltzOnlyResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link DiffResult#mkDiff(Collection, Collection, Function, BiPredicate)}
   */
  @Test
  void testMkDiff13() {
    // Arrange
    ArrayList<Object> waltzRecords = new ArrayList<>();
    waltzRecords.add("42");

    ArrayList<Object> otherRecords = new ArrayList<>();
    otherRecords.add("42");
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");
    BiPredicate<Object, Object> equalityPredicate = mock(BiPredicate.class);
    when(equalityPredicate.test(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(false);

    // Act
    DiffResult<Object> actualMkDiffResult = DiffResult.mkDiff(waltzRecords, otherRecords, keyFn, equalityPredicate);

    // Assert
    verify(equalityPredicate).test(isA(Object.class), isA(Object.class));
    verify(keyFn, atLeast(1)).apply(isA(Object.class));
    Collection<Object> differingIntersectionResult = actualMkDiffResult.differingIntersection();
    assertEquals(1, differingIntersectionResult.size());
    assertTrue(differingIntersectionResult instanceof Set);
    Collection<Object> intersectionResult = actualMkDiffResult.intersection();
    assertEquals(1, intersectionResult.size());
    assertTrue(intersectionResult instanceof Set);
    Collection<Object> otherOnlyResult = actualMkDiffResult.otherOnly();
    assertTrue(otherOnlyResult instanceof Set);
    Collection<Object> waltzOnlyResult = actualMkDiffResult.waltzOnly();
    assertTrue(waltzOnlyResult instanceof Set);
    assertTrue(actualMkDiffResult instanceof ImmutableDiffResult);
    assertTrue(otherOnlyResult.isEmpty());
    assertTrue(waltzOnlyResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link DiffResult#mkDiff(Collection, Collection, Function, BiPredicate)}
   */
  @Test
  void testMkDiff14() {
    // Arrange
    ArrayList<Object> waltzRecords = new ArrayList<>();
    waltzRecords.add("42");

    ArrayList<Object> otherRecords = new ArrayList<>();
    otherRecords.add("42");
    otherRecords.add(new HashMap<>());
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");
    BiPredicate<Object, Object> equalityPredicate = mock(BiPredicate.class);
    when(equalityPredicate.test(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(true);

    // Act
    DiffResult<Object> actualMkDiffResult = DiffResult.mkDiff(waltzRecords, otherRecords, keyFn, equalityPredicate);

    // Assert
    verify(equalityPredicate, atLeast(1)).test(Mockito.<Object>any(), isA(Object.class));
    verify(keyFn, atLeast(1)).apply(Mockito.<Object>any());
    Collection<Object> differingIntersectionResult = actualMkDiffResult.differingIntersection();
    assertTrue(differingIntersectionResult instanceof Set);
    Collection<Object> intersectionResult = actualMkDiffResult.intersection();
    assertEquals(2, intersectionResult.size());
    assertTrue(intersectionResult instanceof Set);
    Collection<Object> otherOnlyResult = actualMkDiffResult.otherOnly();
    assertTrue(otherOnlyResult instanceof Set);
    Collection<Object> waltzOnlyResult = actualMkDiffResult.waltzOnly();
    assertTrue(waltzOnlyResult instanceof Set);
    assertTrue(actualMkDiffResult instanceof ImmutableDiffResult);
    assertTrue(differingIntersectionResult.isEmpty());
    assertTrue(otherOnlyResult.isEmpty());
    assertTrue(waltzOnlyResult.isEmpty());
  }
}
