package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DiffResultDiffblueTest {
  /**
   * Test {@link DiffResult#mkDiff(Collection, Collection, Function, BiPredicate)} with {@code waltzRecords}, {@code otherRecords}, {@code keyFn}, {@code equalityPredicate}.
   * <p>
   * Method under test: {@link DiffResult#mkDiff(Collection, Collection, Function, BiPredicate)}
   */
  @Test
  @DisplayName("Test mkDiff(Collection, Collection, Function, BiPredicate) with 'waltzRecords', 'otherRecords', 'keyFn', 'equalityPredicate'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DiffResult DiffResult.mkDiff(Collection, Collection, Function, BiPredicate)"})
  void testMkDiffWithWaltzRecordsOtherRecordsKeyFnEqualityPredicate() {
    // Arrange
    ArrayList<Object> waltzRecords = new ArrayList<>();

    // Act
    DiffResult<Object> actualMkDiffResult = DiffResult.<Object, Object>mkDiff(waltzRecords, new ArrayList<>(),
        mock(Function.class), mock(BiPredicate.class));

    // Assert
    Collection<Object> differingIntersectionResult = actualMkDiffResult.differingIntersection();
    assertTrue(differingIntersectionResult instanceof Set);
    assertTrue(actualMkDiffResult instanceof ImmutableDiffResult);
    assertTrue(differingIntersectionResult.isEmpty());
    assertEquals(differingIntersectionResult, actualMkDiffResult.intersection());
    assertEquals(differingIntersectionResult, actualMkDiffResult.waltzOnly());
  }

  /**
   * Test {@link DiffResult#mkDiff(Collection, Collection, Function, BiPredicate)} with {@code waltzRecords}, {@code otherRecords}, {@code keyFn}, {@code equalityPredicate}.
   * <p>
   * Method under test: {@link DiffResult#mkDiff(Collection, Collection, Function, BiPredicate)}
   */
  @Test
  @DisplayName("Test mkDiff(Collection, Collection, Function, BiPredicate) with 'waltzRecords', 'otherRecords', 'keyFn', 'equalityPredicate'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DiffResult DiffResult.mkDiff(Collection, Collection, Function, BiPredicate)"})
  void testMkDiffWithWaltzRecordsOtherRecordsKeyFnEqualityPredicate2() {
    // Arrange
    ArrayList<Object> waltzRecords = new ArrayList<>();

    // Act
    DiffResult<Object> actualMkDiffResult = DiffResult.<Object, Object>mkDiff(waltzRecords, new ArrayList<>(),
        mock(Function.class), null);

    // Assert
    Collection<Object> differingIntersectionResult = actualMkDiffResult.differingIntersection();
    assertTrue(differingIntersectionResult instanceof Set);
    assertTrue(actualMkDiffResult instanceof ImmutableDiffResult);
    assertTrue(differingIntersectionResult.isEmpty());
    assertEquals(differingIntersectionResult, actualMkDiffResult.intersection());
    assertEquals(differingIntersectionResult, actualMkDiffResult.otherOnly());
    assertEquals(differingIntersectionResult, actualMkDiffResult.waltzOnly());
  }

  /**
   * Test {@link DiffResult#mkDiff(Collection, Collection, Function, BiPredicate)} with {@code waltzRecords}, {@code otherRecords}, {@code keyFn}, {@code equalityPredicate}.
   * <p>
   * Method under test: {@link DiffResult#mkDiff(Collection, Collection, Function, BiPredicate)}
   */
  @Test
  @DisplayName("Test mkDiff(Collection, Collection, Function, BiPredicate) with 'waltzRecords', 'otherRecords', 'keyFn', 'equalityPredicate'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DiffResult DiffResult.mkDiff(Collection, Collection, Function, BiPredicate)"})
  void testMkDiffWithWaltzRecordsOtherRecordsKeyFnEqualityPredicate3() {
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
    Collection<Object> waltzOnlyResult = actualMkDiffResult.waltzOnly();
    assertEquals(1, waltzOnlyResult.size());
    assertTrue(waltzOnlyResult instanceof Set);
    assertTrue(actualMkDiffResult instanceof ImmutableDiffResult);
  }

  /**
   * Test {@link DiffResult#mkDiff(Collection, Collection, Function, BiPredicate)} with {@code waltzRecords}, {@code otherRecords}, {@code keyFn}, {@code equalityPredicate}.
   * <p>
   * Method under test: {@link DiffResult#mkDiff(Collection, Collection, Function, BiPredicate)}
   */
  @Test
  @DisplayName("Test mkDiff(Collection, Collection, Function, BiPredicate) with 'waltzRecords', 'otherRecords', 'keyFn', 'equalityPredicate'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DiffResult DiffResult.mkDiff(Collection, Collection, Function, BiPredicate)"})
  void testMkDiffWithWaltzRecordsOtherRecordsKeyFnEqualityPredicate4() {
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
    Collection<Object> waltzOnlyResult = actualMkDiffResult.waltzOnly();
    assertEquals(1, waltzOnlyResult.size());
    assertTrue(waltzOnlyResult instanceof Set);
    assertTrue(actualMkDiffResult instanceof ImmutableDiffResult);
  }

  /**
   * Test {@link DiffResult#mkDiff(Collection, Collection, Function, BiPredicate)} with {@code waltzRecords}, {@code otherRecords}, {@code keyFn}, {@code equalityPredicate}.
   * <p>
   * Method under test: {@link DiffResult#mkDiff(Collection, Collection, Function, BiPredicate)}
   */
  @Test
  @DisplayName("Test mkDiff(Collection, Collection, Function, BiPredicate) with 'waltzRecords', 'otherRecords', 'keyFn', 'equalityPredicate'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DiffResult DiffResult.mkDiff(Collection, Collection, Function, BiPredicate)"})
  void testMkDiffWithWaltzRecordsOtherRecordsKeyFnEqualityPredicate5() {
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
    Collection<Object> intersectionResult = actualMkDiffResult.intersection();
    assertEquals(1, intersectionResult.size());
    assertTrue(intersectionResult instanceof Set);
    assertTrue(actualMkDiffResult instanceof ImmutableDiffResult);
  }

  /**
   * Test {@link DiffResult#mkDiff(Collection, Collection, Function, BiPredicate)} with {@code waltzRecords}, {@code otherRecords}, {@code keyFn}, {@code equalityPredicate}.
   * <p>
   * Method under test: {@link DiffResult#mkDiff(Collection, Collection, Function, BiPredicate)}
   */
  @Test
  @DisplayName("Test mkDiff(Collection, Collection, Function, BiPredicate) with 'waltzRecords', 'otherRecords', 'keyFn', 'equalityPredicate'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DiffResult DiffResult.mkDiff(Collection, Collection, Function, BiPredicate)"})
  void testMkDiffWithWaltzRecordsOtherRecordsKeyFnEqualityPredicate6() {
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
    Collection<Object> intersectionResult = actualMkDiffResult.intersection();
    assertEquals(1, intersectionResult.size());
    assertTrue(intersectionResult instanceof Set);
    assertTrue(actualMkDiffResult instanceof ImmutableDiffResult);
  }

  /**
   * Test {@link DiffResult#mkDiff(Collection, Collection, Function, BiPredicate)} with {@code waltzRecords}, {@code otherRecords}, {@code keyFn}, {@code equalityPredicate}.
   * <p>
   * Method under test: {@link DiffResult#mkDiff(Collection, Collection, Function, BiPredicate)}
   */
  @Test
  @DisplayName("Test mkDiff(Collection, Collection, Function, BiPredicate) with 'waltzRecords', 'otherRecords', 'keyFn', 'equalityPredicate'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DiffResult DiffResult.mkDiff(Collection, Collection, Function, BiPredicate)"})
  void testMkDiffWithWaltzRecordsOtherRecordsKeyFnEqualityPredicate7() {
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
    Collection<Object> otherOnlyResult = actualMkDiffResult.otherOnly();
    assertTrue(otherOnlyResult instanceof Set);
    assertTrue(actualMkDiffResult instanceof ImmutableDiffResult);
    assertTrue(otherOnlyResult.isEmpty());
    assertEquals(otherOnlyResult, actualMkDiffResult.waltzOnly());
  }

  /**
   * Test {@link DiffResult#mkDiff(Collection, Collection, Function, BiPredicate)} with {@code waltzRecords}, {@code otherRecords}, {@code keyFn}, {@code equalityPredicate}.
   * <p>
   * Method under test: {@link DiffResult#mkDiff(Collection, Collection, Function, BiPredicate)}
   */
  @Test
  @DisplayName("Test mkDiff(Collection, Collection, Function, BiPredicate) with 'waltzRecords', 'otherRecords', 'keyFn', 'equalityPredicate'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DiffResult DiffResult.mkDiff(Collection, Collection, Function, BiPredicate)"})
  void testMkDiffWithWaltzRecordsOtherRecordsKeyFnEqualityPredicate8() {
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
    Collection<Object> intersectionResult = actualMkDiffResult.intersection();
    assertEquals(2, intersectionResult.size());
    assertTrue(intersectionResult instanceof Set);
    assertTrue(actualMkDiffResult instanceof ImmutableDiffResult);
  }

  /**
   * Test {@link DiffResult#mkDiff(Collection, Collection)} with {@code waltzRecords}, {@code otherRecords}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return intersection size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiffResult#mkDiff(Collection, Collection)}
   */
  @Test
  @DisplayName("Test mkDiff(Collection, Collection) with 'waltzRecords', 'otherRecords'; given '42'; then return intersection size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DiffResult DiffResult.mkDiff(Collection, Collection)"})
  void testMkDiffWithWaltzRecordsOtherRecords_given42_thenReturnIntersectionSizeIsOne() {
    // Arrange
    ArrayList<Object> waltzRecords = new ArrayList<>();
    waltzRecords.add("42");

    ArrayList<Object> otherRecords = new ArrayList<>();
    otherRecords.add("42");

    // Act
    DiffResult<Object> actualMkDiffResult = DiffResult.mkDiff(waltzRecords, otherRecords);

    // Assert
    Collection<Object> intersectionResult = actualMkDiffResult.intersection();
    assertEquals(1, intersectionResult.size());
    assertTrue(intersectionResult instanceof Set);
    assertTrue(actualMkDiffResult instanceof ImmutableDiffResult);
  }

  /**
   * Test {@link DiffResult#mkDiff(Collection, Collection)} with {@code waltzRecords}, {@code otherRecords}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return otherOnly size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiffResult#mkDiff(Collection, Collection)}
   */
  @Test
  @DisplayName("Test mkDiff(Collection, Collection) with 'waltzRecords', 'otherRecords'; given '42'; then return otherOnly size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DiffResult DiffResult.mkDiff(Collection, Collection)"})
  void testMkDiffWithWaltzRecordsOtherRecords_given42_thenReturnOtherOnlySizeIsOne() {
    // Arrange
    ArrayList<Object> waltzRecords = new ArrayList<>();

    ArrayList<Object> otherRecords = new ArrayList<>();
    otherRecords.add("42");

    // Act
    DiffResult<Object> actualMkDiffResult = DiffResult.mkDiff(waltzRecords, otherRecords);

    // Assert
    Collection<Object> otherOnlyResult = actualMkDiffResult.otherOnly();
    assertEquals(1, otherOnlyResult.size());
    assertTrue(otherOnlyResult instanceof Set);
    assertTrue(actualMkDiffResult instanceof ImmutableDiffResult);
  }

  /**
   * Test {@link DiffResult#mkDiff(Collection, Collection)} with {@code waltzRecords}, {@code otherRecords}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return otherOnly size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiffResult#mkDiff(Collection, Collection)}
   */
  @Test
  @DisplayName("Test mkDiff(Collection, Collection) with 'waltzRecords', 'otherRecords'; given '42'; then return otherOnly size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DiffResult DiffResult.mkDiff(Collection, Collection)"})
  void testMkDiffWithWaltzRecordsOtherRecords_given42_thenReturnOtherOnlySizeIsOne2() {
    // Arrange
    ArrayList<Object> waltzRecords = new ArrayList<>();

    ArrayList<Object> otherRecords = new ArrayList<>();
    otherRecords.add("42");
    otherRecords.add("42");

    // Act
    DiffResult<Object> actualMkDiffResult = DiffResult.mkDiff(waltzRecords, otherRecords);

    // Assert
    Collection<Object> otherOnlyResult = actualMkDiffResult.otherOnly();
    assertEquals(1, otherOnlyResult.size());
    assertTrue(otherOnlyResult instanceof Set);
    assertTrue(actualMkDiffResult instanceof ImmutableDiffResult);
  }

  /**
   * Test {@link DiffResult#mkDiff(Collection, Collection)} with {@code waltzRecords}, {@code otherRecords}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return waltzOnly size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiffResult#mkDiff(Collection, Collection)}
   */
  @Test
  @DisplayName("Test mkDiff(Collection, Collection) with 'waltzRecords', 'otherRecords'; given '42'; then return waltzOnly size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DiffResult DiffResult.mkDiff(Collection, Collection)"})
  void testMkDiffWithWaltzRecordsOtherRecords_given42_thenReturnWaltzOnlySizeIsOne() {
    // Arrange
    ArrayList<Object> waltzRecords = new ArrayList<>();
    waltzRecords.add("42");

    // Act
    DiffResult<Object> actualMkDiffResult = DiffResult.mkDiff(waltzRecords, new ArrayList<>());

    // Assert
    Collection<Object> waltzOnlyResult = actualMkDiffResult.waltzOnly();
    assertEquals(1, waltzOnlyResult.size());
    assertTrue(waltzOnlyResult instanceof Set);
    assertTrue(actualMkDiffResult instanceof ImmutableDiffResult);
  }

  /**
   * Test {@link DiffResult#mkDiff(Collection, Collection)} with {@code waltzRecords}, {@code otherRecords}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return waltzOnly size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiffResult#mkDiff(Collection, Collection)}
   */
  @Test
  @DisplayName("Test mkDiff(Collection, Collection) with 'waltzRecords', 'otherRecords'; given '42'; then return waltzOnly size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DiffResult DiffResult.mkDiff(Collection, Collection)"})
  void testMkDiffWithWaltzRecordsOtherRecords_given42_thenReturnWaltzOnlySizeIsOne2() {
    // Arrange
    ArrayList<Object> waltzRecords = new ArrayList<>();
    waltzRecords.add("42");
    waltzRecords.add("42");

    // Act
    DiffResult<Object> actualMkDiffResult = DiffResult.mkDiff(waltzRecords, new ArrayList<>());

    // Assert
    Collection<Object> waltzOnlyResult = actualMkDiffResult.waltzOnly();
    assertEquals(1, waltzOnlyResult.size());
    assertTrue(waltzOnlyResult instanceof Set);
    assertTrue(actualMkDiffResult instanceof ImmutableDiffResult);
  }

  /**
   * Test {@link DiffResult#mkDiff(Collection, Collection)} with {@code waltzRecords}, {@code otherRecords}.
   * <ul>
   *   <li>Then differingIntersection return {@link Set}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DiffResult#mkDiff(Collection, Collection)}
   */
  @Test
  @DisplayName("Test mkDiff(Collection, Collection) with 'waltzRecords', 'otherRecords'; then differingIntersection return Set")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DiffResult DiffResult.mkDiff(Collection, Collection)"})
  void testMkDiffWithWaltzRecordsOtherRecords_thenDifferingIntersectionReturnSet() {
    // Arrange
    ArrayList<Object> waltzRecords = new ArrayList<>();

    // Act
    DiffResult<Object> actualMkDiffResult = DiffResult.mkDiff(waltzRecords, new ArrayList<>());

    // Assert
    Collection<Object> differingIntersectionResult = actualMkDiffResult.differingIntersection();
    assertTrue(differingIntersectionResult instanceof Set);
    assertTrue(actualMkDiffResult instanceof ImmutableDiffResult);
    assertTrue(differingIntersectionResult.isEmpty());
    assertEquals(differingIntersectionResult, actualMkDiffResult.otherOnly());
    assertEquals(differingIntersectionResult, actualMkDiffResult.waltzOnly());
  }
}
