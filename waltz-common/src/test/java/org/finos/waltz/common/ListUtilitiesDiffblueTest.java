package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ListUtilitiesDiffblueTest {
  /**
   * Test {@link ListUtilities#newArrayList(Object[])}.
   *
   * <p>Method under test: {@link ListUtilities#newArrayList(Object[])}
   */
  @Test
  @DisplayName("Test newArrayList(Object[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayList ListUtilities.newArrayList(Object[])"})
  void testNewArrayList() {
    // Arrange and Act
    ArrayList<Object> actualNewArrayListResult = ListUtilities.newArrayList("Ts");

    // Assert
    assertEquals(1, actualNewArrayListResult.size());
    assertEquals("Ts", actualNewArrayListResult.get(0));
  }

  /**
   * Test {@link ListUtilities#append(List, Object)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return size is three.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#append(List, Object)}
   */
  @Test
  @DisplayName(
      "Test append(List, Object); given '42'; when ArrayList() add '42'; then return size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.append(List, Object)"})
  void testAppend_given42_whenArrayListAdd42_thenReturnSizeIsThree() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    // Act
    List<Object> actualAppendResult = ListUtilities.append(ts, "42");

    // Assert
    assertEquals(3, actualAppendResult.size());
    assertEquals("42", actualAppendResult.get(1));
    assertEquals("42", actualAppendResult.get(2));
  }

  /**
   * Test {@link ListUtilities#append(List, Object)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#append(List, Object)}
   */
  @Test
  @DisplayName(
      "Test append(List, Object); given '42'; when ArrayList() add '42'; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.append(List, Object)"})
  void testAppend_given42_whenArrayListAdd42_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act
    List<Object> actualAppendResult = ListUtilities.append(ts, "42");

    // Assert
    assertEquals(2, actualAppendResult.size());
    assertEquals("42", actualAppendResult.get(0));
    assertEquals("42", actualAppendResult.get(1));
  }

  /**
   * Test {@link ListUtilities#append(List, Object)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#append(List, Object)}
   */
  @Test
  @DisplayName("Test append(List, Object); when ArrayList(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.append(List, Object)"})
  void testAppend_whenArrayList_thenReturnSizeIsOne() {
    // Arrange and Act
    List<Object> actualAppendResult = ListUtilities.append(new ArrayList<>(), "42");

    // Assert
    assertEquals(1, actualAppendResult.size());
    assertEquals("42", actualAppendResult.get(0));
  }

  /**
   * Test {@link ListUtilities#asList(Object[])}.
   *
   * <p>Method under test: {@link ListUtilities#asList(Object[])}
   */
  @Test
  @DisplayName("Test asList(Object[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.asList(Object[])"})
  void testAsList() {
    // Arrange and Act
    List<Object> actualAsListResult = ListUtilities.asList("Ts");

    // Assert
    assertEquals(1, actualAsListResult.size());
    assertEquals("Ts", actualAsListResult.get(0));
  }

  /**
   * Test {@link ListUtilities#compact(Collection)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#compact(Collection)}
   */
  @Test
  @DisplayName(
      "Test compact(Collection); given '42'; when ArrayList() add '42'; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.compact(Collection)"})
  void testCompact_given42_whenArrayListAdd42_thenReturnArrayList() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act
    List<Object> actualCompactResult = ListUtilities.compact(ts);

    // Assert
    assertEquals(ts, actualCompactResult);
  }

  /**
   * Test {@link ListUtilities#compact(Collection)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#compact(Collection)}
   */
  @Test
  @DisplayName(
      "Test compact(Collection); given '42'; when ArrayList() add '42'; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.compact(Collection)"})
  void testCompact_given42_whenArrayListAdd42_thenReturnArrayList2() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    // Act
    List<Object> actualCompactResult = ListUtilities.compact(ts);

    // Assert
    assertEquals(ts, actualCompactResult);
  }

  /**
   * Test {@link ListUtilities#compact(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#compact(Collection)}
   */
  @Test
  @DisplayName("Test compact(Collection); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.compact(Collection)"})
  void testCompact_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualCompactResult = ListUtilities.compact(new ArrayList<>());

    // Assert
    assertTrue(actualCompactResult.isEmpty());
  }

  /**
   * Test {@link ListUtilities#concat(List[])}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#concat(List[])}
   */
  @Test
  @DisplayName("Test concat(List[]); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.concat(List[])"})
  void testConcat_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualConcatResult = ListUtilities.concat(new ArrayList<>());

    // Assert
    assertTrue(actualConcatResult.isEmpty());
  }

  /**
   * Test {@link ListUtilities#map(Collection, Function)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#map(Collection, Function)}
   */
  @Test
  @DisplayName(
      "Test map(Collection, Function); given '42'; when ArrayList() add '42'; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.map(Collection, Function)"})
  void testMap_given42_whenArrayListAdd42_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<Object> as = new ArrayList<>();
    as.add("42");
    as.add("42");

    Function<Object, Object> mapper = mock(Function.class);
    when(mapper.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    List<Object> actualMapResult = ListUtilities.map(as, mapper);

    // Assert
    verify(mapper, atLeast(1)).apply(isA(Object.class));
    assertEquals(2, actualMapResult.size());
    assertEquals("Apply", actualMapResult.get(0));
    assertEquals("Apply", actualMapResult.get(1));
  }

  /**
   * Test {@link ListUtilities#map(Collection, Function)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#map(Collection, Function)}
   */
  @Test
  @DisplayName("Test map(Collection, Function); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.map(Collection, Function)"})
  void testMap_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualMapResult = ListUtilities.map(new ArrayList<>(), mock(Function.class));

    // Assert
    assertTrue(actualMapResult.isEmpty());
  }

  /**
   * Test {@link ListUtilities#isEmpty(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#isEmpty(List)}
   */
  @Test
  @DisplayName("Test isEmpty(List); given '42'; when ArrayList() add '42'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ListUtilities.isEmpty(List)"})
  void testIsEmpty_given42_whenArrayListAdd42_thenReturnFalse() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act and Assert
    assertFalse(ListUtilities.isEmpty(ts));
  }

  /**
   * Test {@link ListUtilities#isEmpty(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#isEmpty(List)}
   */
  @Test
  @DisplayName("Test isEmpty(List); given '42'; when ArrayList() add '42'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ListUtilities.isEmpty(List)"})
  void testIsEmpty_given42_whenArrayListAdd42_thenReturnFalse2() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    // Act and Assert
    assertFalse(ListUtilities.isEmpty(ts));
  }

  /**
   * Test {@link ListUtilities#isEmpty(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#isEmpty(List)}
   */
  @Test
  @DisplayName("Test isEmpty(List); when ArrayList(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ListUtilities.isEmpty(List)"})
  void testIsEmpty_whenArrayList_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ListUtilities.isEmpty(new ArrayList<>()));
  }

  /**
   * Test {@link ListUtilities#isEmpty(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#isEmpty(List)}
   */
  @Test
  @DisplayName("Test isEmpty(List); when 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ListUtilities.isEmpty(List)"})
  void testIsEmpty_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ListUtilities.isEmpty(null));
  }

  /**
   * Test {@link ListUtilities#filter(Predicate, List)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link Predicate} {@link Predicate#test(Object)} return {@code true}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#filter(Predicate, List)}
   */
  @Test
  @DisplayName(
      "Test filter(Predicate, List); given 'true'; when Predicate test(Object) return 'true'; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.filter(Predicate, List)"})
  void testFilter_givenTrue_whenPredicateTestReturnTrue_thenReturnArrayList() {
    // Arrange
    Predicate<Object> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<Object>any())).thenReturn(true);

    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    // Act
    List<Object> actualFilterResult = ListUtilities.filter(predicate, ts);

    // Assert
    verify(predicate, atLeast(1)).test(isA(Object.class));
    assertEquals(ts, actualFilterResult);
  }

  /**
   * Test {@link ListUtilities#filter(Predicate, List)}.
   *
   * <ul>
   *   <li>When {@link Predicate}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#filter(Predicate, List)}
   */
  @Test
  @DisplayName("Test filter(Predicate, List); when Predicate; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.filter(Predicate, List)"})
  void testFilter_whenPredicate_thenReturnEmpty() {
    // Arrange
    Predicate<Object> predicate = mock(Predicate.class);

    // Act
    List<Object> actualFilterResult = ListUtilities.filter(predicate, new ArrayList<>());

    // Assert
    assertTrue(actualFilterResult.isEmpty());
  }

  /**
   * Test {@link ListUtilities#drop(List, int)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#drop(List, int)}
   */
  @Test
  @DisplayName("Test drop(List, int); given '42'; when ArrayList() add '42'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.drop(List, int)"})
  void testDrop_given42_whenArrayListAdd42_thenReturnEmpty() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act
    List<Object> actualDropResult = ListUtilities.drop(ts, 3);

    // Assert
    assertTrue(actualDropResult.isEmpty());
  }

  /**
   * Test {@link ListUtilities#drop(List, int)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#drop(List, int)}
   */
  @Test
  @DisplayName("Test drop(List, int); given '42'; when ArrayList() add '42'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.drop(List, int)"})
  void testDrop_given42_whenArrayListAdd42_thenReturnEmpty2() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    // Act
    List<Object> actualDropResult = ListUtilities.drop(ts, 3);

    // Assert
    assertTrue(actualDropResult.isEmpty());
  }

  /**
   * Test {@link ListUtilities#drop(List, int)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#drop(List, int)}
   */
  @Test
  @DisplayName("Test drop(List, int); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.drop(List, int)"})
  void testDrop_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualDropResult = ListUtilities.drop(new ArrayList<>(), 3);

    // Assert
    assertTrue(actualDropResult.isEmpty());
  }

  /**
   * Test {@link ListUtilities#reverse(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#reverse(List)}
   */
  @Test
  @DisplayName("Test reverse(List); given '42'; when ArrayList() add '42'; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.reverse(List)"})
  void testReverse_given42_whenArrayListAdd42_thenReturnArrayList() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act
    List<Object> actualReverseResult = ListUtilities.reverse(ts);

    // Assert
    assertEquals(ts, actualReverseResult);
  }

  /**
   * Test {@link ListUtilities#reverse(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#reverse(List)}
   */
  @Test
  @DisplayName("Test reverse(List); given '42'; when ArrayList() add '42'; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.reverse(List)"})
  void testReverse_given42_whenArrayListAdd42_thenReturnArrayList2() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    // Act
    List<Object> actualReverseResult = ListUtilities.reverse(ts);

    // Assert
    assertEquals(ts, actualReverseResult);
  }

  /**
   * Test {@link ListUtilities#reverse(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#reverse(List)}
   */
  @Test
  @DisplayName("Test reverse(List); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.reverse(List)"})
  void testReverse_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualReverseResult = ListUtilities.reverse(new ArrayList<>());

    // Assert
    assertTrue(actualReverseResult.isEmpty());
  }

  /**
   * Test {@link ListUtilities#ensureNotNull(Collection)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#ensureNotNull(Collection)}
   */
  @Test
  @DisplayName(
      "Test ensureNotNull(Collection); given '42'; when ArrayList() add '42'; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.ensureNotNull(Collection)"})
  void testEnsureNotNull_given42_whenArrayListAdd42_thenReturnArrayList() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act
    List<Object> actualEnsureNotNullResult = ListUtilities.ensureNotNull(ts);

    // Assert
    assertEquals(ts, actualEnsureNotNullResult);
  }

  /**
   * Test {@link ListUtilities#ensureNotNull(Collection)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#ensureNotNull(Collection)}
   */
  @Test
  @DisplayName(
      "Test ensureNotNull(Collection); given '42'; when ArrayList() add '42'; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.ensureNotNull(Collection)"})
  void testEnsureNotNull_given42_whenArrayListAdd42_thenReturnArrayList2() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    // Act
    List<Object> actualEnsureNotNullResult = ListUtilities.ensureNotNull(ts);

    // Assert
    assertEquals(ts, actualEnsureNotNullResult);
  }

  /**
   * Test {@link ListUtilities#ensureNotNull(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#ensureNotNull(Collection)}
   */
  @Test
  @DisplayName("Test ensureNotNull(Collection); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.ensureNotNull(Collection)"})
  void testEnsureNotNull_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualEnsureNotNullResult = ListUtilities.ensureNotNull(new ArrayList<>());

    // Assert
    assertTrue(actualEnsureNotNullResult.isEmpty());
  }

  /**
   * Test {@link ListUtilities#ensureNotNull(Collection)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#ensureNotNull(Collection)}
   */
  @Test
  @DisplayName("Test ensureNotNull(Collection); when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.ensureNotNull(Collection)"})
  void testEnsureNotNull_whenNull_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualEnsureNotNullResult = ListUtilities.ensureNotNull(null);

    // Assert
    assertTrue(actualEnsureNotNullResult.isEmpty());
  }

  /**
   * Test {@link ListUtilities#push(List, Object[])}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return size is three.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#push(List, Object[])}
   */
  @Test
  @DisplayName(
      "Test push(List, Object[]); given '42'; when ArrayList() add '42'; then return size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.push(List, Object[])"})
  void testPush_given42_whenArrayListAdd42_thenReturnSizeIsThree() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");

    // Act
    List<Object> actualPushResult = ListUtilities.push(xs, "Elems");

    // Assert
    assertEquals(3, actualPushResult.size());
    assertEquals("42", actualPushResult.get(1));
    assertEquals("Elems", actualPushResult.get(2));
  }

  /**
   * Test {@link ListUtilities#push(List, Object[])}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#push(List, Object[])}
   */
  @Test
  @DisplayName(
      "Test push(List, Object[]); given '42'; when ArrayList() add '42'; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.push(List, Object[])"})
  void testPush_given42_whenArrayListAdd42_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    // Act
    List<Object> actualPushResult = ListUtilities.push(xs, "Elems");

    // Assert
    assertEquals(2, actualPushResult.size());
    assertEquals("42", actualPushResult.get(0));
    assertEquals("Elems", actualPushResult.get(1));
  }

  /**
   * Test {@link ListUtilities#push(List, Object[])}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#push(List, Object[])}
   */
  @Test
  @DisplayName("Test push(List, Object[]); when ArrayList(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.push(List, Object[])"})
  void testPush_whenArrayList_thenReturnSizeIsOne() {
    // Arrange and Act
    List<Object> actualPushResult = ListUtilities.push(new ArrayList<>(), "Elems");

    // Assert
    assertEquals(1, actualPushResult.size());
    assertEquals("Elems", actualPushResult.get(0));
  }

  /**
   * Test {@link ListUtilities#applyToFirst(List, Function)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@link Optional#get()} is {@code Apply}.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#applyToFirst(List, Function)}
   */
  @Test
  @DisplayName(
      "Test applyToFirst(List, Function); given '42'; when ArrayList() add '42'; then return get() is 'Apply'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ListUtilities.applyToFirst(List, Function)"})
  void testApplyToFirst_given42_whenArrayListAdd42_thenReturnGetIsApply() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    Function<Object, Object> mapFn = mock(Function.class);
    when(mapFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Optional<Object> actualApplyToFirstResult = ListUtilities.applyToFirst(xs, mapFn);

    // Assert
    verify(mapFn).apply(isA(Object.class));
    assertEquals("Apply", actualApplyToFirstResult.get());
    assertTrue(actualApplyToFirstResult.isPresent());
  }

  /**
   * Test {@link ListUtilities#applyToFirst(List, Function)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@link Optional#get()} is {@code Apply}.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#applyToFirst(List, Function)}
   */
  @Test
  @DisplayName(
      "Test applyToFirst(List, Function); given '42'; when ArrayList() add '42'; then return get() is 'Apply'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ListUtilities.applyToFirst(List, Function)"})
  void testApplyToFirst_given42_whenArrayListAdd42_thenReturnGetIsApply2() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");

    Function<Object, Object> mapFn = mock(Function.class);
    when(mapFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Optional<Object> actualApplyToFirstResult = ListUtilities.applyToFirst(xs, mapFn);

    // Assert
    verify(mapFn).apply(isA(Object.class));
    assertEquals("Apply", actualApplyToFirstResult.get());
    assertTrue(actualApplyToFirstResult.isPresent());
  }

  /**
   * Test {@link ListUtilities#applyToFirst(List, Function)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#applyToFirst(List, Function)}
   */
  @Test
  @DisplayName("Test applyToFirst(List, Function); when ArrayList(); then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ListUtilities.applyToFirst(List, Function)"})
  void testApplyToFirst_whenArrayList_thenReturnNotPresent() {
    // Arrange and Act
    Optional<Object> actualApplyToFirstResult =
        ListUtilities.applyToFirst(new ArrayList<>(), mock(Function.class));

    // Assert
    assertFalse(actualApplyToFirstResult.isPresent());
  }

  /**
   * Test {@link ListUtilities#applyToFirst(List, Function)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#applyToFirst(List, Function)}
   */
  @Test
  @DisplayName("Test applyToFirst(List, Function); when 'null'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ListUtilities.applyToFirst(List, Function)"})
  void testApplyToFirst_whenNull_thenReturnNotPresent() {
    // Arrange and Act
    Optional<Object> actualApplyToFirstResult =
        ListUtilities.applyToFirst(null, mock(Function.class));

    // Assert
    assertFalse(actualApplyToFirstResult.isPresent());
  }

  /**
   * Test {@link ListUtilities#zip(List, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#zip(List, List)}
   */
  @Test
  @DisplayName("Test zip(List, List); given '42'; when ArrayList() add '42'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.zip(List, List)"})
  void testZip_given42_whenArrayListAdd42_thenReturnEmpty() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    // Act
    List<Tuple2<Object, Object>> actualZipResult = ListUtilities.zip(xs, new ArrayList<>());

    // Assert
    assertTrue(actualZipResult.isEmpty());
  }

  /**
   * Test {@link ListUtilities#zip(List, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#zip(List, List)}
   */
  @Test
  @DisplayName("Test zip(List, List); given '42'; when ArrayList() add '42'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.zip(List, List)"})
  void testZip_given42_whenArrayListAdd42_thenReturnEmpty2() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");

    // Act
    List<Tuple2<Object, Object>> actualZipResult = ListUtilities.zip(xs, new ArrayList<>());

    // Assert
    assertTrue(actualZipResult.isEmpty());
  }

  /**
   * Test {@link ListUtilities#zip(List, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#zip(List, List)}
   */
  @Test
  @DisplayName("Test zip(List, List); given '42'; when ArrayList() add '42'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.zip(List, List)"})
  void testZip_given42_whenArrayListAdd42_thenReturnEmpty3() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();

    ArrayList<Object> ys = new ArrayList<>();
    ys.add("42");

    // Act
    List<Tuple2<Object, Object>> actualZipResult = ListUtilities.zip(xs, ys);

    // Assert
    assertTrue(actualZipResult.isEmpty());
  }

  /**
   * Test {@link ListUtilities#zip(List, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#zip(List, List)}
   */
  @Test
  @DisplayName("Test zip(List, List); given '42'; when ArrayList() add '42'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.zip(List, List)"})
  void testZip_given42_whenArrayListAdd42_thenReturnEmpty4() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();

    ArrayList<Object> ys = new ArrayList<>();
    ys.add("42");
    ys.add("42");

    // Act
    List<Tuple2<Object, Object>> actualZipResult = ListUtilities.zip(xs, ys);

    // Assert
    assertTrue(actualZipResult.isEmpty());
  }

  /**
   * Test {@link ListUtilities#zip(List, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#zip(List, List)}
   */
  @Test
  @DisplayName(
      "Test zip(List, List); given '42'; when ArrayList() add '42'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.zip(List, List)"})
  void testZip_given42_whenArrayListAdd42_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    ArrayList<Object> ys = new ArrayList<>();
    ys.add("42");

    // Act
    List<Tuple2<Object, Object>> actualZipResult = ListUtilities.zip(xs, ys);

    // Assert
    assertEquals(1, actualZipResult.size());
    List<?> toListResult = actualZipResult.get(0).toList();
    assertEquals(2, toListResult.size());
    assertEquals("42", toListResult.get(0));
    assertEquals("42", toListResult.get(1));
  }

  /**
   * Test {@link ListUtilities#zip(List, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#zip(List, List)}
   */
  @Test
  @DisplayName("Test zip(List, List); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.zip(List, List)"})
  void testZip_whenArrayList_thenReturnEmpty() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();

    // Act
    List<Tuple2<Object, Object>> actualZipResult = ListUtilities.zip(xs, new ArrayList<>());

    // Assert
    assertTrue(actualZipResult.isEmpty());
  }

  /**
   * Test {@link ListUtilities#zip(List, List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#zip(List, List)}
   */
  @Test
  @DisplayName("Test zip(List, List); when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.zip(List, List)"})
  void testZip_whenNull_thenReturnEmpty() {
    // Arrange and Act
    List<Tuple2<Object, Object>> actualZipResult = ListUtilities.zip(new ArrayList<>(), null);

    // Assert
    assertTrue(actualZipResult.isEmpty());
  }

  /**
   * Test {@link ListUtilities#containsDuplicates(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#containsDuplicates(List)}
   */
  @Test
  @DisplayName(
      "Test containsDuplicates(List); given '42'; when ArrayList() add '42'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ListUtilities.containsDuplicates(List)"})
  void testContainsDuplicates_given42_whenArrayListAdd42_thenReturnFalse() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act and Assert
    assertFalse(ListUtilities.containsDuplicates(ts));
  }

  /**
   * Test {@link ListUtilities#containsDuplicates(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#containsDuplicates(List)}
   */
  @Test
  @DisplayName(
      "Test containsDuplicates(List); given '42'; when ArrayList() add '42'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ListUtilities.containsDuplicates(List)"})
  void testContainsDuplicates_given42_whenArrayListAdd42_thenReturnTrue() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    // Act and Assert
    assertTrue(ListUtilities.containsDuplicates(ts));
  }

  /**
   * Test {@link ListUtilities#containsDuplicates(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#containsDuplicates(List)}
   */
  @Test
  @DisplayName("Test containsDuplicates(List); when ArrayList(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ListUtilities.containsDuplicates(List)"})
  void testContainsDuplicates_whenArrayList_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ListUtilities.containsDuplicates(new ArrayList<>()));
  }

  /**
   * Test {@link ListUtilities#maybeGet(List, int)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@link Optional#get()} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#maybeGet(List, int)}
   */
  @Test
  @DisplayName(
      "Test maybeGet(List, int); given '42'; when ArrayList() add '42'; then return get() is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ListUtilities.maybeGet(List, int)"})
  void testMaybeGet_given42_whenArrayListAdd42_thenReturnGetIs42() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");

    // Act
    Optional<Object> actualMaybeGetResult = ListUtilities.maybeGet(xs, 1);

    // Assert
    assertEquals("42", actualMaybeGetResult.get());
    assertTrue(actualMaybeGetResult.isPresent());
  }

  /**
   * Test {@link ListUtilities#maybeGet(List, int)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#maybeGet(List, int)}
   */
  @Test
  @DisplayName(
      "Test maybeGet(List, int); given '42'; when ArrayList() add '42'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ListUtilities.maybeGet(List, int)"})
  void testMaybeGet_given42_whenArrayListAdd42_thenReturnNotPresent() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    // Act
    Optional<Object> actualMaybeGetResult = ListUtilities.maybeGet(xs, 1);

    // Assert
    assertFalse(actualMaybeGetResult.isPresent());
  }

  /**
   * Test {@link ListUtilities#maybeGet(List, int)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#maybeGet(List, int)}
   */
  @Test
  @DisplayName("Test maybeGet(List, int); when ArrayList(); then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ListUtilities.maybeGet(List, int)"})
  void testMaybeGet_whenArrayList_thenReturnNotPresent() {
    // Arrange and Act
    Optional<Object> actualMaybeGetResult = ListUtilities.maybeGet(new ArrayList<>(), 1);

    // Assert
    assertFalse(actualMaybeGetResult.isPresent());
  }

  /**
   * Test {@link ListUtilities#maybeGet(List, int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#maybeGet(List, int)}
   */
  @Test
  @DisplayName("Test maybeGet(List, int); when minus one; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ListUtilities.maybeGet(List, int)"})
  void testMaybeGet_whenMinusOne_thenReturnNotPresent() {
    // Arrange and Act
    Optional<Object> actualMaybeGetResult = ListUtilities.maybeGet(new ArrayList<>(), -1);

    // Assert
    assertFalse(actualMaybeGetResult.isPresent());
  }

  /**
   * Test {@link ListUtilities#getOrDefault(List, int, Object)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#getOrDefault(List, int, Object)}
   */
  @Test
  @DisplayName(
      "Test getOrDefault(List, int, Object); given '42'; when ArrayList() add '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ListUtilities.getOrDefault(List, int, Object)"})
  void testGetOrDefault_given42_whenArrayListAdd42_thenReturn42() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");

    // Act and Assert
    assertEquals("42", ListUtilities.getOrDefault(xs, 1, "Default Value"));
  }

  /**
   * Test {@link ListUtilities#getOrDefault(List, int, Object)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code Default Value}.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#getOrDefault(List, int, Object)}
   */
  @Test
  @DisplayName(
      "Test getOrDefault(List, int, Object); given '42'; when ArrayList() add '42'; then return 'Default Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ListUtilities.getOrDefault(List, int, Object)"})
  void testGetOrDefault_given42_whenArrayListAdd42_thenReturnDefaultValue() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    // Act and Assert
    assertEquals("Default Value", ListUtilities.getOrDefault(xs, 1, "Default Value"));
  }

  /**
   * Test {@link ListUtilities#getOrDefault(List, int, Object)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code Default Value}.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#getOrDefault(List, int, Object)}
   */
  @Test
  @DisplayName(
      "Test getOrDefault(List, int, Object); when ArrayList(); then return 'Default Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ListUtilities.getOrDefault(List, int, Object)"})
  void testGetOrDefault_whenArrayList_thenReturnDefaultValue() {
    // Arrange, Act and Assert
    assertEquals(
        "Default Value", ListUtilities.getOrDefault(new ArrayList<>(), 1, "Default Value"));
  }

  /**
   * Test {@link ListUtilities#getOrDefault(List, int, Object)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code Default Value}.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#getOrDefault(List, int, Object)}
   */
  @Test
  @DisplayName("Test getOrDefault(List, int, Object); when minus one; then return 'Default Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ListUtilities.getOrDefault(List, int, Object)"})
  void testGetOrDefault_whenMinusOne_thenReturnDefaultValue() {
    // Arrange, Act and Assert
    assertEquals(
        "Default Value", ListUtilities.getOrDefault(new ArrayList<>(), -1, "Default Value"));
  }

  /**
   * Test {@link ListUtilities#take(Collection, int)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#take(Collection, int)}
   */
  @Test
  @DisplayName(
      "Test take(Collection, int); given '42'; when ArrayList() add '42'; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.take(Collection, int)"})
  void testTake_given42_whenArrayListAdd42_thenReturnArrayList() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    // Act
    List<Object> actualTakeResult = ListUtilities.take(xs, Columns.K);

    // Assert
    assertEquals(xs, actualTakeResult);
  }

  /**
   * Test {@link ListUtilities#take(Collection, int)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#take(Collection, int)}
   */
  @Test
  @DisplayName(
      "Test take(Collection, int); given '42'; when ArrayList() add '42'; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.take(Collection, int)"})
  void testTake_given42_whenArrayListAdd42_thenReturnArrayList2() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");

    // Act
    List<Object> actualTakeResult = ListUtilities.take(xs, Columns.K);

    // Assert
    assertEquals(xs, actualTakeResult);
  }

  /**
   * Test {@link ListUtilities#take(Collection, int)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#take(Collection, int)}
   */
  @Test
  @DisplayName("Test take(Collection, int); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.take(Collection, int)"})
  void testTake_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualTakeResult = ListUtilities.take(new ArrayList<>(), Columns.K);

    // Assert
    assertTrue(actualTakeResult.isEmpty());
  }

  /**
   * Test {@link ListUtilities#take(Collection, int)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#take(Collection, int)}
   */
  @Test
  @DisplayName("Test take(Collection, int); when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.take(Collection, int)"})
  void testTake_whenNull_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualTakeResult = ListUtilities.take(null, Columns.K);

    // Assert
    assertTrue(actualTakeResult.isEmpty());
  }

  /**
   * Test {@link ListUtilities#distinct(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#distinct(List)}
   */
  @Test
  @DisplayName(
      "Test distinct(List); given '42'; when ArrayList() add '42'; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.distinct(List)"})
  void testDistinct_given42_whenArrayListAdd42_thenReturnArrayList() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act
    List<Object> actualDistinctResult = ListUtilities.distinct(ts);

    // Assert
    assertEquals(ts, actualDistinctResult);
  }

  /**
   * Test {@link ListUtilities#distinct(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#distinct(List)}
   */
  @Test
  @DisplayName(
      "Test distinct(List); given '42'; when ArrayList() add '42'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.distinct(List)"})
  void testDistinct_given42_whenArrayListAdd42_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    // Act
    List<Object> actualDistinctResult = ListUtilities.distinct(ts);

    // Assert
    assertEquals(1, actualDistinctResult.size());
    assertEquals("42", actualDistinctResult.get(0));
  }

  /**
   * Test {@link ListUtilities#distinct(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ListUtilities#distinct(List)}
   */
  @Test
  @DisplayName("Test distinct(List); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ListUtilities.distinct(List)"})
  void testDistinct_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualDistinctResult = ListUtilities.distinct(new ArrayList<>());

    // Assert
    assertTrue(actualDistinctResult.isEmpty());
  }
}
