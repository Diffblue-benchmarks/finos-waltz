package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Function;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PairDiffResultDiffblueTest {
  /**
   * Test {@link PairDiffResult#mkPairDiff(Collection, Collection, Function, Function, BiPredicate)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return waltzOnly size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PairDiffResult#mkPairDiff(Collection, Collection, Function, Function, BiPredicate)}
   */
  @Test
  @DisplayName("Test mkPairDiff(Collection, Collection, Function, Function, BiPredicate); given '42'; when ArrayList(); then return waltzOnly size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PairDiffResult PairDiffResult.mkPairDiff(Collection, Collection, Function, Function, BiPredicate)"})
  void testMkPairDiff_given42_whenArrayList_thenReturnWaltzOnlySizeIsOne() {
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
    Collection<Object> waltzOnlyResult = actualMkPairDiffResult.waltzOnly();
    assertEquals(1, waltzOnlyResult.size());
    assertTrue(waltzOnlyResult instanceof Set);
    assertTrue(actualMkPairDiffResult instanceof ImmutablePairDiffResult);
  }

  /**
   * Test {@link PairDiffResult#mkPairDiff(Collection, Collection, Function, Function, BiPredicate)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return waltzOnly size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PairDiffResult#mkPairDiff(Collection, Collection, Function, Function, BiPredicate)}
   */
  @Test
  @DisplayName("Test mkPairDiff(Collection, Collection, Function, Function, BiPredicate); given '42'; when ArrayList(); then return waltzOnly size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PairDiffResult PairDiffResult.mkPairDiff(Collection, Collection, Function, Function, BiPredicate)"})
  void testMkPairDiff_given42_whenArrayList_thenReturnWaltzOnlySizeIsOne2() {
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
    Collection<Object> waltzOnlyResult = actualMkPairDiffResult.waltzOnly();
    assertEquals(1, waltzOnlyResult.size());
    assertTrue(waltzOnlyResult instanceof Set);
    assertTrue(actualMkPairDiffResult instanceof ImmutablePairDiffResult);
  }

  /**
   * Test {@link PairDiffResult#mkPairDiff(Collection, Collection, Function, Function, BiPredicate)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then return otherOnly Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PairDiffResult#mkPairDiff(Collection, Collection, Function, Function, BiPredicate)}
   */
  @Test
  @DisplayName("Test mkPairDiff(Collection, Collection, Function, Function, BiPredicate); given 'false'; then return otherOnly Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PairDiffResult PairDiffResult.mkPairDiff(Collection, Collection, Function, Function, BiPredicate)"})
  void testMkPairDiff_givenFalse_thenReturnOtherOnlyEmpty() {
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
    Collection<Object> otherOnlyResult = actualMkPairDiffResult.otherOnly();
    assertTrue(otherOnlyResult instanceof Set);
    assertTrue(actualMkPairDiffResult instanceof ImmutablePairDiffResult);
    assertTrue(otherOnlyResult.isEmpty());
    assertEquals(otherOnlyResult, actualMkPairDiffResult.waltzOnly());
  }

  /**
   * Test {@link PairDiffResult#mkPairDiff(Collection, Collection, Function, Function, BiPredicate)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then return waltzOnly Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PairDiffResult#mkPairDiff(Collection, Collection, Function, Function, BiPredicate)}
   */
  @Test
  @DisplayName("Test mkPairDiff(Collection, Collection, Function, Function, BiPredicate); given 'null'; when ArrayList() add 'null'; then return waltzOnly Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PairDiffResult PairDiffResult.mkPairDiff(Collection, Collection, Function, Function, BiPredicate)"})
  void testMkPairDiff_givenNull_whenArrayListAddNull_thenReturnWaltzOnlyEmpty() {
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
    Collection<Object> waltzOnlyResult = actualMkPairDiffResult.waltzOnly();
    assertTrue(waltzOnlyResult instanceof Set);
    assertTrue(actualMkPairDiffResult instanceof ImmutablePairDiffResult);
    assertTrue(waltzOnlyResult.isEmpty());
  }

  /**
   * Test {@link PairDiffResult#mkPairDiff(Collection, Collection, Function, Function, BiPredicate)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return allIntersection size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PairDiffResult#mkPairDiff(Collection, Collection, Function, Function, BiPredicate)}
   */
  @Test
  @DisplayName("Test mkPairDiff(Collection, Collection, Function, Function, BiPredicate); given 'true'; then return allIntersection size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PairDiffResult PairDiffResult.mkPairDiff(Collection, Collection, Function, Function, BiPredicate)"})
  void testMkPairDiff_givenTrue_thenReturnAllIntersectionSizeIsOne() {
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
    assertTrue(actualMkPairDiffResult instanceof ImmutablePairDiffResult);
    assertTrue(differingIntersectionResult.isEmpty());
    assertEquals(differingIntersectionResult, actualMkPairDiffResult.otherOnly());
    assertEquals(differingIntersectionResult, actualMkPairDiffResult.waltzOnly());
  }

  /**
   * Test {@link PairDiffResult#mkPairDiff(Collection, Collection, Function, Function, BiPredicate)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return allIntersection size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PairDiffResult#mkPairDiff(Collection, Collection, Function, Function, BiPredicate)}
   */
  @Test
  @DisplayName("Test mkPairDiff(Collection, Collection, Function, Function, BiPredicate); given 'true'; then return allIntersection size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PairDiffResult PairDiffResult.mkPairDiff(Collection, Collection, Function, Function, BiPredicate)"})
  void testMkPairDiff_givenTrue_thenReturnAllIntersectionSizeIsOne2() {
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
    assertTrue(actualMkPairDiffResult instanceof ImmutablePairDiffResult);
    assertTrue(differingIntersectionResult.isEmpty());
    assertEquals(differingIntersectionResult, actualMkPairDiffResult.otherOnly());
    assertEquals(differingIntersectionResult, actualMkPairDiffResult.waltzOnly());
  }

  /**
   * Test {@link PairDiffResult#mkPairDiff(Collection, Collection, Function, Function, BiPredicate)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link HashMap#HashMap()}.</li>
   *   <li>Then return allIntersection size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PairDiffResult#mkPairDiff(Collection, Collection, Function, Function, BiPredicate)}
   */
  @Test
  @DisplayName("Test mkPairDiff(Collection, Collection, Function, Function, BiPredicate); when ArrayList() add HashMap(); then return allIntersection size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PairDiffResult PairDiffResult.mkPairDiff(Collection, Collection, Function, Function, BiPredicate)"})
  void testMkPairDiff_whenArrayListAddHashMap_thenReturnAllIntersectionSizeIsTwo() {
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
    assertTrue(actualMkPairDiffResult instanceof ImmutablePairDiffResult);
    assertTrue(differingIntersectionResult.isEmpty());
    assertEquals(differingIntersectionResult, actualMkPairDiffResult.otherOnly());
    assertEquals(differingIntersectionResult, actualMkPairDiffResult.waltzOnly());
  }

  /**
   * Test {@link PairDiffResult#mkPairDiff(Collection, Collection, Function, Function, BiPredicate)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return waltzOnly Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PairDiffResult#mkPairDiff(Collection, Collection, Function, Function, BiPredicate)}
   */
  @Test
  @DisplayName("Test mkPairDiff(Collection, Collection, Function, Function, BiPredicate); when ArrayList(); then return waltzOnly Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PairDiffResult PairDiffResult.mkPairDiff(Collection, Collection, Function, Function, BiPredicate)"})
  void testMkPairDiff_whenArrayList_thenReturnWaltzOnlyEmpty() {
    // Arrange
    ArrayList<Object> waltzRecords = new ArrayList<>();

    // Act
    PairDiffResult<Object, Object> actualMkPairDiffResult = PairDiffResult.<Object, Object, Object>mkPairDiff(
        waltzRecords, new ArrayList<>(), mock(Function.class), mock(Function.class), mock(BiPredicate.class));

    // Assert
    Collection<Object> waltzOnlyResult = actualMkPairDiffResult.waltzOnly();
    assertTrue(waltzOnlyResult instanceof Set);
    assertTrue(actualMkPairDiffResult instanceof ImmutablePairDiffResult);
    assertTrue(waltzOnlyResult.isEmpty());
  }

  /**
   * Test {@link PairDiffResult#mkPairDiff(Collection, Collection, Function, Function, BiPredicate)}.
   * <ul>
   *   <li>When {@link Function} {@link Function#apply(Object)} return {@link HashMap#HashMap()}.</li>
   *   <li>Then return otherOnly size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PairDiffResult#mkPairDiff(Collection, Collection, Function, Function, BiPredicate)}
   */
  @Test
  @DisplayName("Test mkPairDiff(Collection, Collection, Function, Function, BiPredicate); when Function apply(Object) return HashMap(); then return otherOnly size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PairDiffResult PairDiffResult.mkPairDiff(Collection, Collection, Function, Function, BiPredicate)"})
  void testMkPairDiff_whenFunctionApplyReturnHashMap_thenReturnOtherOnlySizeIsOne() {
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
    Collection<Object> otherOnlyResult = actualMkPairDiffResult.otherOnly();
    assertEquals(1, otherOnlyResult.size());
    assertTrue(otherOnlyResult instanceof Set);
    assertTrue(actualMkPairDiffResult instanceof ImmutablePairDiffResult);
    assertEquals(otherOnlyResult, actualMkPairDiffResult.waltzOnly());
  }
}
