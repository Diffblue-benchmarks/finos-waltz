package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Function;
import org.finos.waltz.model.ImmutablePairDiffResult.Builder;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PairDiffResultDiffblueTest {
  /**
   * Test {@link PairDiffResult#mkPairDiff(Collection, Collection, Function, Function,
   * BiPredicate)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return waltzOnly size is one.
   * </ul>
   *
   * <p>Method under test: {@link PairDiffResult#mkPairDiff(Collection, Collection, Function,
   * Function, BiPredicate)}
   */
  @Test
  @DisplayName(
      "Test mkPairDiff(Collection, Collection, Function, Function, BiPredicate); given '42'; when ArrayList(); then return waltzOnly size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PairDiffResult PairDiffResult.mkPairDiff(Collection, Collection, Function, Function, BiPredicate)"
  })
  void testMkPairDiff_given42_whenArrayList_thenReturnWaltzOnlySizeIsOne() {
    // Arrange
    ArrayList<Object> waltzRecords = new ArrayList<>();
    waltzRecords.add("42");
    ArrayList<Object> otherRecords = new ArrayList<>();

    Function<Object, Object> aKeyFn = mock(Function.class);
    when(aKeyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    PairDiffResult<Object, Object> actualMkPairDiffResult =
        PairDiffResult.mkPairDiff(
            waltzRecords, otherRecords, aKeyFn, mock(Function.class), mock(BiPredicate.class));

    // Assert
    verify(aKeyFn, atLeast(1)).apply(isA(Object.class));
    Collection<Tuple2<Object, Object>> allIntersectionResult =
        actualMkPairDiffResult.allIntersection();
    assertTrue(allIntersectionResult instanceof Set);
    Collection<Object> waltzOnlyResult = actualMkPairDiffResult.waltzOnly();
    assertEquals(1, waltzOnlyResult.size());
    assertTrue(waltzOnlyResult instanceof Set);
    assertTrue(actualMkPairDiffResult instanceof ImmutablePairDiffResult);
    assertTrue(allIntersectionResult.isEmpty());
    assertEquals(allIntersectionResult, actualMkPairDiffResult.otherOnly());
  }

  /**
   * Test {@link PairDiffResult#mkPairDiff(Collection, Collection, Function, Function,
   * BiPredicate)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return waltzOnly size is one.
   * </ul>
   *
   * <p>Method under test: {@link PairDiffResult#mkPairDiff(Collection, Collection, Function,
   * Function, BiPredicate)}
   */
  @Test
  @DisplayName(
      "Test mkPairDiff(Collection, Collection, Function, Function, BiPredicate); given '42'; when ArrayList(); then return waltzOnly size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PairDiffResult PairDiffResult.mkPairDiff(Collection, Collection, Function, Function, BiPredicate)"
  })
  void testMkPairDiff_given42_whenArrayList_thenReturnWaltzOnlySizeIsOne2() {
    // Arrange
    ArrayList<Object> waltzRecords = new ArrayList<>();
    waltzRecords.add("42");
    waltzRecords.add("42");
    ArrayList<Object> otherRecords = new ArrayList<>();

    Function<Object, Object> aKeyFn = mock(Function.class);
    when(aKeyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    PairDiffResult<Object, Object> actualMkPairDiffResult =
        PairDiffResult.mkPairDiff(
            waltzRecords, otherRecords, aKeyFn, mock(Function.class), mock(BiPredicate.class));

    // Assert
    verify(aKeyFn, atLeast(1)).apply(isA(Object.class));
    Collection<Tuple2<Object, Object>> allIntersectionResult =
        actualMkPairDiffResult.allIntersection();
    assertTrue(allIntersectionResult instanceof Set);
    Collection<Object> waltzOnlyResult = actualMkPairDiffResult.waltzOnly();
    assertEquals(1, waltzOnlyResult.size());
    assertTrue(waltzOnlyResult instanceof Set);
    assertTrue(actualMkPairDiffResult instanceof ImmutablePairDiffResult);
    assertTrue(allIntersectionResult.isEmpty());
    assertEquals(allIntersectionResult, actualMkPairDiffResult.otherOnly());
  }

  /**
   * Test {@link PairDiffResult#mkPairDiff(Collection, Collection, Function, Function,
   * BiPredicate)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return allIntersection size is one.
   * </ul>
   *
   * <p>Method under test: {@link PairDiffResult#mkPairDiff(Collection, Collection, Function,
   * Function, BiPredicate)}
   */
  @Test
  @DisplayName(
      "Test mkPairDiff(Collection, Collection, Function, Function, BiPredicate); given 'false'; then return allIntersection size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PairDiffResult PairDiffResult.mkPairDiff(Collection, Collection, Function, Function, BiPredicate)"
  })
  void testMkPairDiff_givenFalse_thenReturnAllIntersectionSizeIsOne() {
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
    PairDiffResult<Object, Object> actualMkPairDiffResult =
        PairDiffResult.mkPairDiff(waltzRecords, otherRecords, aKeyFn, bKeyFn, equalityPredicate);

    // Assert
    verify(equalityPredicate).test(isA(Object.class), isA(Object.class));
    verify(aKeyFn, atLeast(1)).apply(isA(Object.class));
    verify(bKeyFn, atLeast(1)).apply(isA(Object.class));
    Collection<Tuple2<Object, Object>> allIntersectionResult =
        actualMkPairDiffResult.allIntersection();
    assertEquals(1, allIntersectionResult.size());
    assertTrue(allIntersectionResult instanceof Set);
    Collection<Object> otherOnlyResult = actualMkPairDiffResult.otherOnly();
    assertTrue(otherOnlyResult instanceof Set);
    assertTrue(actualMkPairDiffResult instanceof ImmutablePairDiffResult);
    assertTrue(otherOnlyResult.isEmpty());
    assertEquals(allIntersectionResult, actualMkPairDiffResult.differingIntersection());
    assertEquals(otherOnlyResult, actualMkPairDiffResult.waltzOnly());
  }

  /**
   * Test {@link PairDiffResult#mkPairDiff(Collection, Collection, Function, Function,
   * BiPredicate)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return allIntersection size is one.
   * </ul>
   *
   * <p>Method under test: {@link PairDiffResult#mkPairDiff(Collection, Collection, Function,
   * Function, BiPredicate)}
   */
  @Test
  @DisplayName(
      "Test mkPairDiff(Collection, Collection, Function, Function, BiPredicate); given 'false'; then return allIntersection size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PairDiffResult PairDiffResult.mkPairDiff(Collection, Collection, Function, Function, BiPredicate)"
  })
  void testMkPairDiff_givenFalse_thenReturnAllIntersectionSizeIsOne2() {
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
    when(equalityPredicate.test(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(false);

    // Act
    PairDiffResult<Object, Object> actualMkPairDiffResult =
        PairDiffResult.mkPairDiff(waltzRecords, otherRecords, aKeyFn, bKeyFn, equalityPredicate);

    // Assert
    verify(equalityPredicate).test(isA(Object.class), isA(Object.class));
    verify(aKeyFn, atLeast(1)).apply(isA(Object.class));
    verify(bKeyFn, atLeast(1)).apply(isA(Object.class));
    Collection<Tuple2<Object, Object>> allIntersectionResult =
        actualMkPairDiffResult.allIntersection();
    assertEquals(1, allIntersectionResult.size());
    assertTrue(allIntersectionResult instanceof Set);
    Collection<Object> otherOnlyResult = actualMkPairDiffResult.otherOnly();
    assertTrue(otherOnlyResult instanceof Set);
    assertTrue(actualMkPairDiffResult instanceof ImmutablePairDiffResult);
    assertTrue(otherOnlyResult.isEmpty());
    assertEquals(allIntersectionResult, actualMkPairDiffResult.differingIntersection());
    assertEquals(otherOnlyResult, actualMkPairDiffResult.waltzOnly());
  }

  /**
   * Test {@link PairDiffResult#mkPairDiff(Collection, Collection, Function, Function,
   * BiPredicate)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return waltzOnly Empty.
   * </ul>
   *
   * <p>Method under test: {@link PairDiffResult#mkPairDiff(Collection, Collection, Function,
   * Function, BiPredicate)}
   */
  @Test
  @DisplayName(
      "Test mkPairDiff(Collection, Collection, Function, Function, BiPredicate); given 'null'; when ArrayList() add 'null'; then return waltzOnly Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PairDiffResult PairDiffResult.mkPairDiff(Collection, Collection, Function, Function, BiPredicate)"
  })
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
    PairDiffResult<Object, Object> actualMkPairDiffResult =
        PairDiffResult.mkPairDiff(
            waltzRecords, otherRecords, aKeyFn, bKeyFn, mock(BiPredicate.class));

    // Assert
    verify(aKeyFn, atLeast(1)).apply(isNull());
    verify(bKeyFn, atLeast(1)).apply(isA(Object.class));
    Collection<Object> waltzOnlyResult = actualMkPairDiffResult.waltzOnly();
    assertTrue(waltzOnlyResult instanceof Set);
    assertTrue(actualMkPairDiffResult instanceof ImmutablePairDiffResult);
    assertTrue(waltzOnlyResult.isEmpty());
  }

  /**
   * Test {@link PairDiffResult#mkPairDiff(Collection, Collection, Function, Function,
   * BiPredicate)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link Function} {@link Function#apply(Object)} return one.
   *   <li>Then return otherOnly size is one.
   * </ul>
   *
   * <p>Method under test: {@link PairDiffResult#mkPairDiff(Collection, Collection, Function,
   * Function, BiPredicate)}
   */
  @Test
  @DisplayName(
      "Test mkPairDiff(Collection, Collection, Function, Function, BiPredicate); given one; when Function apply(Object) return one; then return otherOnly size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PairDiffResult PairDiffResult.mkPairDiff(Collection, Collection, Function, Function, BiPredicate)"
  })
  void testMkPairDiff_givenOne_whenFunctionApplyReturnOne_thenReturnOtherOnlySizeIsOne() {
    // Arrange
    ArrayList<Object> waltzRecords = new ArrayList<>();
    waltzRecords.add("42");

    ArrayList<Object> otherRecords = new ArrayList<>();
    otherRecords.add("42");

    Function<Object, Object> aKeyFn = mock(Function.class);
    when(aKeyFn.apply(Mockito.<Object>any())).thenReturn(1);

    Function<Object, Object> bKeyFn = mock(Function.class);
    when(bKeyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    PairDiffResult<Object, Object> actualMkPairDiffResult =
        PairDiffResult.mkPairDiff(
            waltzRecords, otherRecords, aKeyFn, bKeyFn, mock(BiPredicate.class));

    // Assert
    verify(aKeyFn, atLeast(1)).apply(isA(Object.class));
    verify(bKeyFn, atLeast(1)).apply(isA(Object.class));
    Collection<Object> otherOnlyResult = actualMkPairDiffResult.otherOnly();
    assertEquals(1, otherOnlyResult.size());
    assertTrue(otherOnlyResult instanceof Set);
    assertTrue(actualMkPairDiffResult instanceof ImmutablePairDiffResult);
    assertEquals(otherOnlyResult, actualMkPairDiffResult.waltzOnly());
  }

  /**
   * Test {@link PairDiffResult#mkPairDiff(Collection, Collection, Function, Function,
   * BiPredicate)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then differingIntersection return {@link Set}.
   * </ul>
   *
   * <p>Method under test: {@link PairDiffResult#mkPairDiff(Collection, Collection, Function,
   * Function, BiPredicate)}
   */
  @Test
  @DisplayName(
      "Test mkPairDiff(Collection, Collection, Function, Function, BiPredicate); given 'true'; then differingIntersection return Set")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PairDiffResult PairDiffResult.mkPairDiff(Collection, Collection, Function, Function, BiPredicate)"
  })
  void testMkPairDiff_givenTrue_thenDifferingIntersectionReturnSet() {
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
    PairDiffResult<Object, Object> actualMkPairDiffResult =
        PairDiffResult.mkPairDiff(waltzRecords, otherRecords, aKeyFn, bKeyFn, equalityPredicate);

    // Assert
    verify(equalityPredicate).test(isA(Object.class), isA(Object.class));
    verify(aKeyFn, atLeast(1)).apply(isA(Object.class));
    verify(bKeyFn, atLeast(1)).apply(isA(Object.class));
    Collection<Tuple2<Object, Object>> differingIntersectionResult =
        actualMkPairDiffResult.differingIntersection();
    assertTrue(differingIntersectionResult instanceof Set);
    assertTrue(actualMkPairDiffResult instanceof ImmutablePairDiffResult);
    assertTrue(differingIntersectionResult.isEmpty());
    assertEquals(differingIntersectionResult, actualMkPairDiffResult.otherOnly());
    assertEquals(differingIntersectionResult, actualMkPairDiffResult.waltzOnly());
  }

  /**
   * Test {@link PairDiffResult#mkPairDiff(Collection, Collection, Function, Function,
   * BiPredicate)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link ArrayList#ArrayList()} add two.
   *   <li>Then return allIntersection size is two.
   * </ul>
   *
   * <p>Method under test: {@link PairDiffResult#mkPairDiff(Collection, Collection, Function,
   * Function, BiPredicate)}
   */
  @Test
  @DisplayName(
      "Test mkPairDiff(Collection, Collection, Function, Function, BiPredicate); given two; when ArrayList() add two; then return allIntersection size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PairDiffResult PairDiffResult.mkPairDiff(Collection, Collection, Function, Function, BiPredicate)"
  })
  void testMkPairDiff_givenTwo_whenArrayListAddTwo_thenReturnAllIntersectionSizeIsTwo() {
    // Arrange
    ArrayList<Object> waltzRecords = new ArrayList<>();
    waltzRecords.add("42");

    ArrayList<Object> otherRecords = new ArrayList<>();
    otherRecords.add("42");
    otherRecords.add(2);

    Function<Object, Object> aKeyFn = mock(Function.class);
    when(aKeyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    Function<Object, Object> bKeyFn = mock(Function.class);
    when(bKeyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    BiPredicate<Object, Object> equalityPredicate = mock(BiPredicate.class);
    when(equalityPredicate.test(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(false);

    // Act
    PairDiffResult<Object, Object> actualMkPairDiffResult =
        PairDiffResult.mkPairDiff(waltzRecords, otherRecords, aKeyFn, bKeyFn, equalityPredicate);

    // Assert
    verify(equalityPredicate, atLeast(1)).test(isA(Object.class), Mockito.<Object>any());
    verify(aKeyFn, atLeast(1)).apply(isA(Object.class));
    verify(bKeyFn, atLeast(1)).apply(Mockito.<Object>any());
    Collection<Tuple2<Object, Object>> allIntersectionResult =
        actualMkPairDiffResult.allIntersection();
    assertEquals(2, allIntersectionResult.size());
    assertTrue(allIntersectionResult instanceof Set);
    Collection<Object> otherOnlyResult = actualMkPairDiffResult.otherOnly();
    assertTrue(otherOnlyResult instanceof Set);
    assertTrue(actualMkPairDiffResult instanceof ImmutablePairDiffResult);
    assertTrue(otherOnlyResult.isEmpty());
    assertEquals(allIntersectionResult, actualMkPairDiffResult.differingIntersection());
    assertEquals(otherOnlyResult, actualMkPairDiffResult.waltzOnly());
  }

  /**
   * Test {@link PairDiffResult#mkPairDiff(Collection, Collection, Function, Function,
   * BiPredicate)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return waltzOnly Empty.
   * </ul>
   *
   * <p>Method under test: {@link PairDiffResult#mkPairDiff(Collection, Collection, Function,
   * Function, BiPredicate)}
   */
  @Test
  @DisplayName(
      "Test mkPairDiff(Collection, Collection, Function, Function, BiPredicate); when ArrayList(); then return waltzOnly Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PairDiffResult PairDiffResult.mkPairDiff(Collection, Collection, Function, Function, BiPredicate)"
  })
  void testMkPairDiff_whenArrayList_thenReturnWaltzOnlyEmpty() {
    // Arrange
    ArrayList<Object> waltzRecords = new ArrayList<>();

    // Act
    PairDiffResult<Object, Object> actualMkPairDiffResult =
        PairDiffResult.mkPairDiff(
            waltzRecords,
            new ArrayList<>(),
            mock(Function.class),
            mock(Function.class),
            mock(BiPredicate.class));

    // Assert
    Collection<Object> waltzOnlyResult = actualMkPairDiffResult.waltzOnly();
    assertTrue(waltzOnlyResult instanceof Set);
    assertTrue(actualMkPairDiffResult instanceof ImmutablePairDiffResult);
    assertTrue(waltzOnlyResult.isEmpty());
  }

  /**
   * Test {@link PairDiffResult#toString()}.
   *
   * <p>Method under test: {@link PairDiffResult#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PairDiffResult.toString()"})
  void testToString() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutablePairDiffResult.builder();

    Builder<Object, Object> allIntersectionResult =
        builderResult.allIntersection(new ArrayList<>());

    Builder<Object, Object> differingIntersectionResult =
        allIntersectionResult.differingIntersection(new ArrayList<>());

    Builder<Object, Object> otherOnlyResult =
        differingIntersectionResult.otherOnly(new ArrayList<>());

    // Act and Assert
    assertEquals(
        "org.finos.waltz.model.ImmutablePairDiffResult - [Intersection: 0 records, Other: 0 records, Waltz: 0"
            + " records, Differing Intersection: 0 records]",
        otherOnlyResult.waltzOnly(new ArrayList<>()).build().toString());
  }
}
