package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SetUtilitiesDiffblueTest {
  /**
   * Test {@link SetUtilities#asSet(Object[])}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#asSet(Object[])}
   */
  @Test
  @DisplayName("Test asSet(Object[]); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.asSet(Object[])"})
  void testAsSet_thenReturnEmpty() {
    // Arrange and Act
    Set<Object> actualAsSetResult = SetUtilities.asSet();

    // Assert
    assertTrue(actualAsSetResult.isEmpty());
  }

  /**
   * Test {@link SetUtilities#asSet(Object[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#asSet(Object[])}
   */
  @Test
  @DisplayName("Test asSet(Object[]); when 'null'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.asSet(Object[])"})
  void testAsSet_whenNull_thenReturnEmpty() {
    // Arrange and Act
    Set<Object> actualAsSetResult = SetUtilities.asSet(null);

    // Assert
    assertTrue(actualAsSetResult.isEmpty());
  }

  /**
   * Test {@link SetUtilities#asSet(Object[])}.
   * <ul>
   *   <li>When {@code Ts}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#asSet(Object[])}
   */
  @Test
  @DisplayName("Test asSet(Object[]); when 'Ts'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.asSet(Object[])"})
  void testAsSet_whenTs_thenReturnSizeIsOne() {
    // Arrange and Act
    Set<Object> actualAsSetResult = SetUtilities.asSet("Ts");

    // Assert
    assertEquals(1, actualAsSetResult.size());
  }

  /**
   * Test {@link SetUtilities#fromArray(Object[])}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#fromArray(Object[])}
   */
  @Test
  @DisplayName("Test fromArray(Object[]); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.fromArray(Object[])"})
  void testFromArray_thenReturnEmpty() {
    // Arrange and Act
    Set<Object> actualFromArrayResult = SetUtilities.fromArray();

    // Assert
    assertTrue(actualFromArrayResult.isEmpty());
  }

  /**
   * Test {@link SetUtilities#fromArray(Object[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#fromArray(Object[])}
   */
  @Test
  @DisplayName("Test fromArray(Object[]); when 'null'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.fromArray(Object[])"})
  void testFromArray_whenNull_thenReturnEmpty() {
    // Arrange and Act
    Set<Object> actualFromArrayResult = SetUtilities.fromArray(null);

    // Assert
    assertTrue(actualFromArrayResult.isEmpty());
  }

  /**
   * Test {@link SetUtilities#fromArray(Object[])}.
   * <ul>
   *   <li>When {@code Ts}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#fromArray(Object[])}
   */
  @Test
  @DisplayName("Test fromArray(Object[]); when 'Ts'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.fromArray(Object[])"})
  void testFromArray_whenTs_thenReturnSizeIsOne() {
    // Arrange and Act
    Set<Object> actualFromArrayResult = SetUtilities.fromArray("Ts");

    // Assert
    assertEquals(1, actualFromArrayResult.size());
  }

  /**
   * Test {@link SetUtilities#fromCollection(Collection)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#fromCollection(Collection)}
   */
  @Test
  @DisplayName("Test fromCollection(Collection); given '42'; when ArrayList() add '42'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.fromCollection(Collection)"})
  void testFromCollection_given42_whenArrayListAdd42_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act
    Set<Object> actualFromCollectionResult = SetUtilities.fromCollection(ts);

    // Assert
    assertEquals(1, actualFromCollectionResult.size());
  }

  /**
   * Test {@link SetUtilities#fromCollection(Collection)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#fromCollection(Collection)}
   */
  @Test
  @DisplayName("Test fromCollection(Collection); given '42'; when ArrayList() add '42'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.fromCollection(Collection)"})
  void testFromCollection_given42_whenArrayListAdd42_thenReturnSizeIsOne2() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    // Act
    Set<Object> actualFromCollectionResult = SetUtilities.fromCollection(ts);

    // Assert
    assertEquals(1, actualFromCollectionResult.size());
  }

  /**
   * Test {@link SetUtilities#fromCollection(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#fromCollection(Collection)}
   */
  @Test
  @DisplayName("Test fromCollection(Collection); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.fromCollection(Collection)"})
  void testFromCollection_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    Set<Object> actualFromCollectionResult = SetUtilities.fromCollection(new ArrayList<>());

    // Assert
    assertTrue(actualFromCollectionResult.isEmpty());
  }

  /**
   * Test {@link SetUtilities#fromCollection(Collection)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#fromCollection(Collection)}
   */
  @Test
  @DisplayName("Test fromCollection(Collection); when 'null'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.fromCollection(Collection)"})
  void testFromCollection_whenNull_thenReturnEmpty() {
    // Arrange and Act
    Set<Object> actualFromCollectionResult = SetUtilities.fromCollection(null);

    // Assert
    assertTrue(actualFromCollectionResult.isEmpty());
  }

  /**
   * Test {@link SetUtilities#map(Collection, Function)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#map(Collection, Function)}
   */
  @Test
  @DisplayName("Test map(Collection, Function); given '42'; when ArrayList() add '42'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.map(Collection, Function)"})
  void testMap_given42_whenArrayListAdd42_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    Function<Object, Object> fn = mock(Function.class);
    when(fn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Set<Object> actualMapResult = SetUtilities.map(xs, fn);

    // Assert
    verify(fn).apply(isA(Object.class));
    assertEquals(1, actualMapResult.size());
  }

  /**
   * Test {@link SetUtilities#map(Collection, Function)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#map(Collection, Function)}
   */
  @Test
  @DisplayName("Test map(Collection, Function); given '42'; when ArrayList() add '42'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.map(Collection, Function)"})
  void testMap_given42_whenArrayListAdd42_thenReturnSizeIsOne2() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");
    Function<Object, Object> fn = mock(Function.class);
    when(fn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Set<Object> actualMapResult = SetUtilities.map(xs, fn);

    // Assert
    verify(fn, atLeast(1)).apply(isA(Object.class));
    assertEquals(1, actualMapResult.size());
  }

  /**
   * Test {@link SetUtilities#map(Collection, Function)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#map(Collection, Function)}
   */
  @Test
  @DisplayName("Test map(Collection, Function); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.map(Collection, Function)"})
  void testMap_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    Set<Object> actualMapResult = SetUtilities.<Object, Object>map(new ArrayList<>(), mock(Function.class));

    // Assert
    assertTrue(actualMapResult.isEmpty());
  }

  /**
   * Test {@link SetUtilities#map(Collection, Function)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#map(Collection, Function)}
   */
  @Test
  @DisplayName("Test map(Collection, Function); when 'null'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.map(Collection, Function)"})
  void testMap_whenNull_thenReturnEmpty() {
    // Arrange and Act
    Set<Object> actualMapResult = SetUtilities.<Object, Object>map(null, mock(Function.class));

    // Assert
    assertTrue(actualMapResult.isEmpty());
  }

  /**
   * Test {@link SetUtilities#filter(Collection, Predicate)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#filter(Collection, Predicate)}
   */
  @Test
  @DisplayName("Test filter(Collection, Predicate); given '42'; when ArrayList() add '42'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.filter(Collection, Predicate)"})
  void testFilter_given42_whenArrayListAdd42_thenReturnEmpty() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    // Act
    Set<Object> actualFilterResult = SetUtilities.filter(xs, mock(RangeBand.class)::equals);

    // Assert
    assertTrue(actualFilterResult.isEmpty());
  }

  /**
   * Test {@link SetUtilities#filter(Collection, Predicate)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#filter(Collection, Predicate)}
   */
  @Test
  @DisplayName("Test filter(Collection, Predicate); given '42'; when ArrayList() add '42'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.filter(Collection, Predicate)"})
  void testFilter_given42_whenArrayListAdd42_thenReturnEmpty2() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");

    // Act
    Set<Object> actualFilterResult = SetUtilities.filter(xs, mock(RangeBand.class)::equals);

    // Assert
    assertTrue(actualFilterResult.isEmpty());
  }

  /**
   * Test {@link SetUtilities#filter(Collection, Predicate)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#filter(Collection, Predicate)}
   */
  @Test
  @DisplayName("Test filter(Collection, Predicate); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.filter(Collection, Predicate)"})
  void testFilter_whenArrayList_thenReturnEmpty() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();

    // Act
    Set<Object> actualFilterResult = SetUtilities.filter(xs, mock(RangeBand.class)::equals);

    // Assert
    assertTrue(actualFilterResult.isEmpty());
  }

  /**
   * Test {@link SetUtilities#filter(Collection, Predicate)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#filter(Collection, Predicate)}
   */
  @Test
  @DisplayName("Test filter(Collection, Predicate); when 'null'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.filter(Collection, Predicate)"})
  void testFilter_whenNull_thenReturnEmpty() {
    // Arrange and Act
    Set<Object> actualFilterResult = SetUtilities.filter(null, mock(RangeBand.class)::equals);

    // Assert
    assertTrue(actualFilterResult.isEmpty());
  }

  /**
   * Test {@link SetUtilities#union(Collection[])}.
   * <p>
   * Method under test: {@link SetUtilities#union(Collection[])}
   */
  @Test
  @DisplayName("Test union(Collection[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.union(Collection[])"})
  void testUnion() {
    // Arrange and Act
    Set<Object> actualUnionResult = SetUtilities.union(new ArrayList<>());

    // Assert
    assertTrue(actualUnionResult.isEmpty());
  }

  /**
   * Test {@link SetUtilities#orderedUnion(Collection[])}.
   * <p>
   * Method under test: {@link SetUtilities#orderedUnion(Collection[])}
   */
  @Test
  @DisplayName("Test orderedUnion(Collection[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.orderedUnion(Collection[])"})
  void testOrderedUnion() {
    // Arrange and Act
    Set<Object> actualOrderedUnionResult = SetUtilities.orderedUnion(new ArrayList<>());

    // Assert
    assertTrue(actualOrderedUnionResult.isEmpty());
  }

  /**
   * Test {@link SetUtilities#minus(Set, Set[])}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.</li>
   *   <li>Then return {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#minus(Set, Set[])}
   */
  @Test
  @DisplayName("Test minus(Set, Set[]); given '42'; when HashSet() add '42'; then return HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.minus(Set, Set[])"})
  void testMinus_given42_whenHashSetAdd42_thenReturnHashSet() {
    // Arrange
    HashSet<Object> xs = new HashSet<>();
    xs.add("42");

    // Act
    Set<Object> actualMinusResult = SetUtilities.minus(xs, new HashSet<>());

    // Assert
    assertEquals(xs, actualMinusResult);
  }

  /**
   * Test {@link SetUtilities#minus(Set, Set[])}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link HashSet#HashSet()} add two.</li>
   *   <li>Then return {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#minus(Set, Set[])}
   */
  @Test
  @DisplayName("Test minus(Set, Set[]); given two; when HashSet() add two; then return HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.minus(Set, Set[])"})
  void testMinus_givenTwo_whenHashSetAddTwo_thenReturnHashSet() {
    // Arrange
    HashSet<Object> xs = new HashSet<>();
    xs.add(2);
    xs.add("42");

    // Act
    Set<Object> actualMinusResult = SetUtilities.minus(xs, new HashSet<>());

    // Assert
    assertEquals(xs, actualMinusResult);
  }

  /**
   * Test {@link SetUtilities#minus(Set, Set[])}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#minus(Set, Set[])}
   */
  @Test
  @DisplayName("Test minus(Set, Set[]); when HashSet(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.minus(Set, Set[])"})
  void testMinus_whenHashSet_thenReturnEmpty() {
    // Arrange
    HashSet<Object> xs = new HashSet<>();

    // Act
    Set<Object> actualMinusResult = SetUtilities.minus(xs, new HashSet<>());

    // Assert
    assertTrue(actualMinusResult.isEmpty());
  }

  /**
   * Test {@link SetUtilities#intersection(Set, Set)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#intersection(Set, Set)}
   */
  @Test
  @DisplayName("Test intersection(Set, Set); given '42'; when HashSet() add '42'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.intersection(Set, Set)"})
  void testIntersection_given42_whenHashSetAdd42_thenReturnEmpty() {
    // Arrange
    HashSet<Object> xs = new HashSet<>();
    xs.add("42");

    // Act
    Set<Object> actualIntersectionResult = SetUtilities.intersection(xs, new HashSet<>());

    // Assert
    assertTrue(actualIntersectionResult.isEmpty());
  }

  /**
   * Test {@link SetUtilities#intersection(Set, Set)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#intersection(Set, Set)}
   */
  @Test
  @DisplayName("Test intersection(Set, Set); given '42'; when HashSet() add '42'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.intersection(Set, Set)"})
  void testIntersection_given42_whenHashSetAdd42_thenReturnEmpty2() {
    // Arrange
    HashSet<Object> xs = new HashSet<>();

    HashSet<Object> ys = new HashSet<>();
    ys.add("42");

    // Act
    Set<Object> actualIntersectionResult = SetUtilities.intersection(xs, ys);

    // Assert
    assertTrue(actualIntersectionResult.isEmpty());
  }

  /**
   * Test {@link SetUtilities#intersection(Set, Set)}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link HashSet#HashSet()} add two.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#intersection(Set, Set)}
   */
  @Test
  @DisplayName("Test intersection(Set, Set); given two; when HashSet() add two; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.intersection(Set, Set)"})
  void testIntersection_givenTwo_whenHashSetAddTwo_thenReturnEmpty() {
    // Arrange
    HashSet<Object> xs = new HashSet<>();
    xs.add(2);
    xs.add("42");

    // Act
    Set<Object> actualIntersectionResult = SetUtilities.intersection(xs, new HashSet<>());

    // Assert
    assertTrue(actualIntersectionResult.isEmpty());
  }

  /**
   * Test {@link SetUtilities#intersection(Set, Set)}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link HashSet#HashSet()} add two.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#intersection(Set, Set)}
   */
  @Test
  @DisplayName("Test intersection(Set, Set); given two; when HashSet() add two; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.intersection(Set, Set)"})
  void testIntersection_givenTwo_whenHashSetAddTwo_thenReturnEmpty2() {
    // Arrange
    HashSet<Object> xs = new HashSet<>();

    HashSet<Object> ys = new HashSet<>();
    ys.add(2);
    ys.add("42");

    // Act
    Set<Object> actualIntersectionResult = SetUtilities.intersection(xs, ys);

    // Assert
    assertTrue(actualIntersectionResult.isEmpty());
  }

  /**
   * Test {@link SetUtilities#intersection(Set, Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#intersection(Set, Set)}
   */
  @Test
  @DisplayName("Test intersection(Set, Set); when HashSet(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.intersection(Set, Set)"})
  void testIntersection_whenHashSet_thenReturnEmpty() {
    // Arrange
    HashSet<Object> xs = new HashSet<>();

    // Act
    Set<Object> actualIntersectionResult = SetUtilities.intersection(xs, new HashSet<>());

    // Assert
    assertTrue(actualIntersectionResult.isEmpty());
  }

  /**
   * Test {@link SetUtilities#uniqBy(Collection, Function)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#uniqBy(Collection, Function)}
   */
  @Test
  @DisplayName("Test uniqBy(Collection, Function); given '42'; when ArrayList() add '42'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.uniqBy(Collection, Function)"})
  void testUniqBy_given42_whenArrayListAdd42_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    Function<Object, Object> comparator = mock(Function.class);
    when(comparator.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Set<Object> actualUniqByResult = SetUtilities.uniqBy(xs, comparator);

    // Assert
    verify(comparator).apply(isA(Object.class));
    assertEquals(1, actualUniqByResult.size());
  }

  /**
   * Test {@link SetUtilities#uniqBy(Collection, Function)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#uniqBy(Collection, Function)}
   */
  @Test
  @DisplayName("Test uniqBy(Collection, Function); given '42'; when ArrayList() add '42'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.uniqBy(Collection, Function)"})
  void testUniqBy_given42_whenArrayListAdd42_thenReturnSizeIsOne2() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");
    Function<Object, Object> comparator = mock(Function.class);
    when(comparator.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Set<Object> actualUniqByResult = SetUtilities.uniqBy(xs, comparator);

    // Assert
    verify(comparator, atLeast(1)).apply(isA(Object.class));
    assertEquals(1, actualUniqByResult.size());
  }

  /**
   * Test {@link SetUtilities#uniqBy(Collection, Function)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#uniqBy(Collection, Function)}
   */
  @Test
  @DisplayName("Test uniqBy(Collection, Function); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.uniqBy(Collection, Function)"})
  void testUniqBy_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    Set<Object> actualUniqByResult = SetUtilities.<Object, Object>uniqBy(new ArrayList<>(), mock(Function.class));

    // Assert
    assertTrue(actualUniqByResult.isEmpty());
  }

  /**
   * Test {@link SetUtilities#unionAll(Collection)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link Set}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#unionAll(Collection)}
   */
  @Test
  @DisplayName("Test unionAll(Collection); given ArrayList(); when ArrayList() add ArrayList(); then return Set")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection SetUtilities.unionAll(Collection)"})
  void testUnionAll_givenArrayList_whenArrayListAddArrayList_thenReturnSet() {
    // Arrange
    ArrayList<Collection<Object>> values = new ArrayList<>();
    values.add(new ArrayList<>());

    // Act
    Collection<Object> actualUnionAllResult = SetUtilities.unionAll(values);

    // Assert
    assertTrue(actualUnionAllResult instanceof Set);
    assertTrue(actualUnionAllResult.isEmpty());
  }

  /**
   * Test {@link SetUtilities#unionAll(Collection)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link Set}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#unionAll(Collection)}
   */
  @Test
  @DisplayName("Test unionAll(Collection); given ArrayList(); when ArrayList() add ArrayList(); then return Set")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection SetUtilities.unionAll(Collection)"})
  void testUnionAll_givenArrayList_whenArrayListAddArrayList_thenReturnSet2() {
    // Arrange
    ArrayList<Collection<Object>> values = new ArrayList<>();
    values.add(new ArrayList<>());
    values.add(new ArrayList<>());

    // Act
    Collection<Object> actualUnionAllResult = SetUtilities.unionAll(values);

    // Assert
    assertTrue(actualUnionAllResult instanceof Set);
    assertTrue(actualUnionAllResult.isEmpty());
  }

  /**
   * Test {@link SetUtilities#unionAll(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link Set}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#unionAll(Collection)}
   */
  @Test
  @DisplayName("Test unionAll(Collection); when ArrayList(); then return Set")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection SetUtilities.unionAll(Collection)"})
  void testUnionAll_whenArrayList_thenReturnSet() {
    // Arrange and Act
    Collection<Object> actualUnionAllResult = SetUtilities.unionAll(new ArrayList<>());

    // Assert
    assertTrue(actualUnionAllResult instanceof Set);
    assertTrue(actualUnionAllResult.isEmpty());
  }

  /**
   * Test {@link SetUtilities#complement(Set, Set)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.</li>
   *   <li>Then return {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#complement(Set, Set)}
   */
  @Test
  @DisplayName("Test complement(Set, Set); given '42'; when HashSet() add '42'; then return HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.complement(Set, Set)"})
  void testComplement_given42_whenHashSetAdd42_thenReturnHashSet() {
    // Arrange
    HashSet<Object> xs = new HashSet<>();
    xs.add("42");

    // Act
    Set<Object> actualComplementResult = SetUtilities.complement(xs, new HashSet<>());

    // Assert
    assertEquals(xs, actualComplementResult);
  }

  /**
   * Test {@link SetUtilities#complement(Set, Set)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#complement(Set, Set)}
   */
  @Test
  @DisplayName("Test complement(Set, Set); given '42'; when HashSet() add '42'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.complement(Set, Set)"})
  void testComplement_given42_whenHashSetAdd42_thenReturnSizeIsOne() {
    // Arrange
    HashSet<Object> xs = new HashSet<>();

    HashSet<Object> ys = new HashSet<>();
    ys.add("42");

    // Act
    Set<Object> actualComplementResult = SetUtilities.complement(xs, ys);

    // Assert
    assertEquals(1, actualComplementResult.size());
  }

  /**
   * Test {@link SetUtilities#complement(Set, Set)}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link HashSet#HashSet()} add two.</li>
   *   <li>Then return {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#complement(Set, Set)}
   */
  @Test
  @DisplayName("Test complement(Set, Set); given two; when HashSet() add two; then return HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.complement(Set, Set)"})
  void testComplement_givenTwo_whenHashSetAddTwo_thenReturnHashSet() {
    // Arrange
    HashSet<Object> xs = new HashSet<>();
    xs.add(2);
    xs.add("42");

    // Act
    Set<Object> actualComplementResult = SetUtilities.complement(xs, new HashSet<>());

    // Assert
    assertEquals(xs, actualComplementResult);
  }

  /**
   * Test {@link SetUtilities#complement(Set, Set)}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link HashSet#HashSet()} add two.</li>
   *   <li>Then return {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#complement(Set, Set)}
   */
  @Test
  @DisplayName("Test complement(Set, Set); given two; when HashSet() add two; then return HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.complement(Set, Set)"})
  void testComplement_givenTwo_whenHashSetAddTwo_thenReturnHashSet2() {
    // Arrange
    HashSet<Object> xs = new HashSet<>();

    HashSet<Object> ys = new HashSet<>();
    ys.add(2);
    ys.add("42");

    // Act
    Set<Object> actualComplementResult = SetUtilities.complement(xs, ys);

    // Assert
    assertEquals(ys, actualComplementResult);
  }

  /**
   * Test {@link SetUtilities#complement(Set, Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#complement(Set, Set)}
   */
  @Test
  @DisplayName("Test complement(Set, Set); when HashSet(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.complement(Set, Set)"})
  void testComplement_whenHashSet_thenReturnEmpty() {
    // Arrange
    HashSet<Object> xs = new HashSet<>();

    // Act
    Set<Object> actualComplementResult = SetUtilities.complement(xs, new HashSet<>());

    // Assert
    assertTrue(actualComplementResult.isEmpty());
  }

  /**
   * Test {@link SetUtilities#hasIntersection(Set, Set)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#hasIntersection(Set, Set)}
   */
  @Test
  @DisplayName("Test hasIntersection(Set, Set); given '42'; when HashSet() add '42'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SetUtilities.hasIntersection(Set, Set)"})
  void testHasIntersection_given42_whenHashSetAdd42_thenReturnFalse() {
    // Arrange
    HashSet<Object> xs = new HashSet<>();
    xs.add("42");

    // Act and Assert
    assertFalse(SetUtilities.hasIntersection(xs, new HashSet<>()));
  }

  /**
   * Test {@link SetUtilities#hasIntersection(Set, Set)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#hasIntersection(Set, Set)}
   */
  @Test
  @DisplayName("Test hasIntersection(Set, Set); given '42'; when HashSet() add '42'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SetUtilities.hasIntersection(Set, Set)"})
  void testHasIntersection_given42_whenHashSetAdd42_thenReturnFalse2() {
    // Arrange
    HashSet<Object> xs = new HashSet<>();

    HashSet<Object> ys = new HashSet<>();
    ys.add("42");

    // Act and Assert
    assertFalse(SetUtilities.hasIntersection(xs, ys));
  }

  /**
   * Test {@link SetUtilities#hasIntersection(Set, Set)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#hasIntersection(Set, Set)}
   */
  @Test
  @DisplayName("Test hasIntersection(Set, Set); given '42'; when HashSet() add '42'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SetUtilities.hasIntersection(Set, Set)"})
  void testHasIntersection_given42_whenHashSetAdd42_thenReturnTrue() {
    // Arrange
    HashSet<Object> xs = new HashSet<>();
    xs.add("42");

    HashSet<Object> ys = new HashSet<>();
    ys.add("42");

    // Act and Assert
    assertTrue(SetUtilities.hasIntersection(xs, ys));
  }

  /**
   * Test {@link SetUtilities#hasIntersection(Set, Set)}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link HashSet#HashSet()} add two.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#hasIntersection(Set, Set)}
   */
  @Test
  @DisplayName("Test hasIntersection(Set, Set); given two; when HashSet() add two; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SetUtilities.hasIntersection(Set, Set)"})
  void testHasIntersection_givenTwo_whenHashSetAddTwo_thenReturnFalse() {
    // Arrange
    HashSet<Object> xs = new HashSet<>();
    xs.add(2);
    xs.add("42");

    // Act and Assert
    assertFalse(SetUtilities.hasIntersection(xs, new HashSet<>()));
  }

  /**
   * Test {@link SetUtilities#hasIntersection(Set, Set)}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link HashSet#HashSet()} add two.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#hasIntersection(Set, Set)}
   */
  @Test
  @DisplayName("Test hasIntersection(Set, Set); given two; when HashSet() add two; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SetUtilities.hasIntersection(Set, Set)"})
  void testHasIntersection_givenTwo_whenHashSetAddTwo_thenReturnFalse2() {
    // Arrange
    HashSet<Object> xs = new HashSet<>();

    HashSet<Object> ys = new HashSet<>();
    ys.add(2);
    ys.add("42");

    // Act and Assert
    assertFalse(SetUtilities.hasIntersection(xs, ys));
  }

  /**
   * Test {@link SetUtilities#hasIntersection(Set, Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#hasIntersection(Set, Set)}
   */
  @Test
  @DisplayName("Test hasIntersection(Set, Set); when HashSet(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SetUtilities.hasIntersection(Set, Set)"})
  void testHasIntersection_whenHashSet_thenReturnFalse() {
    // Arrange
    HashSet<Object> xs = new HashSet<>();

    // Act and Assert
    assertFalse(SetUtilities.hasIntersection(xs, new HashSet<>()));
  }

  /**
   * Test {@link SetUtilities#fromOptionals(Collection)}.
   * <ul>
   *   <li>Given {@link Optional} with {@code 42}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#fromOptionals(Collection)}
   */
  @Test
  @DisplayName("Test fromOptionals(Collection); given Optional with '42'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.fromOptionals(Collection)"})
  void testFromOptionals_givenOptionalWith42_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Optional<Object>> ts = new ArrayList<>();
    Optional<Object> ofResult = Optional.of("42");
    ts.add(ofResult);

    // Act
    Set<Object> actualFromOptionalsResult = SetUtilities.fromOptionals(ts);

    // Assert
    assertEquals(1, actualFromOptionalsResult.size());
  }

  /**
   * Test {@link SetUtilities#fromOptionals(Collection)}.
   * <ul>
   *   <li>Given {@link Optional} with {@code 42}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#fromOptionals(Collection)}
   */
  @Test
  @DisplayName("Test fromOptionals(Collection); given Optional with '42'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.fromOptionals(Collection)"})
  void testFromOptionals_givenOptionalWith42_thenReturnSizeIsOne2() {
    // Arrange
    ArrayList<Optional<Object>> ts = new ArrayList<>();
    Optional<Object> ofResult = Optional.of("42");
    ts.add(ofResult);
    Optional<Object> ofResult2 = Optional.of("42");
    ts.add(ofResult2);

    // Act
    Set<Object> actualFromOptionalsResult = SetUtilities.fromOptionals(ts);

    // Assert
    assertEquals(1, actualFromOptionalsResult.size());
  }

  /**
   * Test {@link SetUtilities#fromOptionals(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#fromOptionals(Collection)}
   */
  @Test
  @DisplayName("Test fromOptionals(Collection); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.fromOptionals(Collection)"})
  void testFromOptionals_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    Set<Object> actualFromOptionalsResult = SetUtilities.fromOptionals(new ArrayList<>());

    // Assert
    assertTrue(actualFromOptionalsResult.isEmpty());
  }

  /**
   * Test {@link SetUtilities#maybeAdd(Set, Optional)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.</li>
   *   <li>Then return {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#maybeAdd(Set, Optional)}
   */
  @Test
  @DisplayName("Test maybeAdd(Set, Optional); given '42'; when HashSet() add '42'; then return HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.maybeAdd(Set, Optional)"})
  void testMaybeAdd_given42_whenHashSetAdd42_thenReturnHashSet() {
    // Arrange
    HashSet<Object> ts = new HashSet<>();
    ts.add("42");
    Optional<Object> toAdd = Optional.of("42");

    // Act
    Set<Object> actualMaybeAddResult = SetUtilities.maybeAdd(ts, toAdd);

    // Assert
    assertEquals(ts, actualMaybeAddResult);
  }

  /**
   * Test {@link SetUtilities#maybeAdd(Set, Optional)}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link HashSet#HashSet()} add two.</li>
   *   <li>Then return {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#maybeAdd(Set, Optional)}
   */
  @Test
  @DisplayName("Test maybeAdd(Set, Optional); given two; when HashSet() add two; then return HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.maybeAdd(Set, Optional)"})
  void testMaybeAdd_givenTwo_whenHashSetAddTwo_thenReturnHashSet() {
    // Arrange
    HashSet<Object> ts = new HashSet<>();
    ts.add(2);
    ts.add("42");
    Optional<Object> toAdd = Optional.of("42");

    // Act
    Set<Object> actualMaybeAddResult = SetUtilities.maybeAdd(ts, toAdd);

    // Assert
    assertEquals(ts, actualMaybeAddResult);
  }

  /**
   * Test {@link SetUtilities#maybeAdd(Set, Optional)}.
   * <ul>
   *   <li>When empty.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#maybeAdd(Set, Optional)}
   */
  @Test
  @DisplayName("Test maybeAdd(Set, Optional); when empty; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.maybeAdd(Set, Optional)"})
  void testMaybeAdd_whenEmpty_thenReturnEmpty() {
    // Arrange
    HashSet<Object> ts = new HashSet<>();
    Optional<Object> toAdd = Optional.empty();

    // Act
    Set<Object> actualMaybeAddResult = SetUtilities.maybeAdd(ts, toAdd);

    // Assert
    assertTrue(actualMaybeAddResult.isEmpty());
  }

  /**
   * Test {@link SetUtilities#maybeAdd(Set, Optional)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#maybeAdd(Set, Optional)}
   */
  @Test
  @DisplayName("Test maybeAdd(Set, Optional); when HashSet(); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.maybeAdd(Set, Optional)"})
  void testMaybeAdd_whenHashSet_thenReturnSizeIsOne() {
    // Arrange
    HashSet<Object> ts = new HashSet<>();
    Optional<Object> toAdd = Optional.of("42");

    // Act
    Set<Object> actualMaybeAddResult = SetUtilities.maybeAdd(ts, toAdd);

    // Assert
    assertEquals(1, actualMaybeAddResult.size());
  }

  /**
   * Test {@link SetUtilities#add(Set, Object[])}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#add(Set, Object[])}
   */
  @Test
  @DisplayName("Test add(Set, Object[]); given '42'; when HashSet() add '42'; then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.add(Set, Object[])"})
  void testAdd_given42_whenHashSetAdd42_thenReturnSizeIsTwo() {
    // Arrange
    HashSet<Object> orig = new HashSet<>();
    orig.add("42");

    // Act
    Set<Object> actualAddResult = SetUtilities.add(orig, "Ts");

    // Assert
    assertEquals(2, actualAddResult.size());
  }

  /**
   * Test {@link SetUtilities#add(Set, Object[])}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link HashSet#HashSet()} add two.</li>
   *   <li>Then return size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#add(Set, Object[])}
   */
  @Test
  @DisplayName("Test add(Set, Object[]); given two; when HashSet() add two; then return size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.add(Set, Object[])"})
  void testAdd_givenTwo_whenHashSetAddTwo_thenReturnSizeIsThree() {
    // Arrange
    HashSet<Object> orig = new HashSet<>();
    orig.add(2);
    orig.add("42");

    // Act
    Set<Object> actualAddResult = SetUtilities.add(orig, "Ts");

    // Assert
    assertEquals(3, actualAddResult.size());
  }

  /**
   * Test {@link SetUtilities#add(Set, Object[])}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#add(Set, Object[])}
   */
  @Test
  @DisplayName("Test add(Set, Object[]); when HashSet(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.add(Set, Object[])"})
  void testAdd_whenHashSet_thenReturnEmpty() {
    // Arrange and Act
    Set<Object> actualAddResult = SetUtilities.add(new HashSet<>());

    // Assert
    assertTrue(actualAddResult.isEmpty());
  }

  /**
   * Test {@link SetUtilities#add(Set, Object[])}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#add(Set, Object[])}
   */
  @Test
  @DisplayName("Test add(Set, Object[]); when HashSet(); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.add(Set, Object[])"})
  void testAdd_whenHashSet_thenReturnSizeIsOne() {
    // Arrange and Act
    Set<Object> actualAddResult = SetUtilities.add(new HashSet<>(), "Ts");

    // Assert
    assertEquals(1, actualAddResult.size());
  }

  /**
   * Test {@link SetUtilities#add(Set, Object[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#add(Set, Object[])}
   */
  @Test
  @DisplayName("Test add(Set, Object[]); when 'null'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.add(Set, Object[])"})
  void testAdd_whenNull_thenReturnEmpty() {
    // Arrange and Act
    Set<Object> actualAddResult = SetUtilities.add(new HashSet<>(), null);

    // Assert
    assertTrue(actualAddResult.isEmpty());
  }

  /**
   * Test {@link SetUtilities#remove(Set, Object[])}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.</li>
   *   <li>Then return {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#remove(Set, Object[])}
   */
  @Test
  @DisplayName("Test remove(Set, Object[]); given '42'; when HashSet() add '42'; then return HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.remove(Set, Object[])"})
  void testRemove_given42_whenHashSetAdd42_thenReturnHashSet() {
    // Arrange
    HashSet<Object> orig = new HashSet<>();
    orig.add("42");

    // Act
    Set<Object> actualRemoveResult = SetUtilities.remove(orig, "Ts");

    // Assert
    assertEquals(orig, actualRemoveResult);
  }

  /**
   * Test {@link SetUtilities#remove(Set, Object[])}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link HashSet#HashSet()} add two.</li>
   *   <li>Then return {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#remove(Set, Object[])}
   */
  @Test
  @DisplayName("Test remove(Set, Object[]); given two; when HashSet() add two; then return HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.remove(Set, Object[])"})
  void testRemove_givenTwo_whenHashSetAddTwo_thenReturnHashSet() {
    // Arrange
    HashSet<Object> orig = new HashSet<>();
    orig.add(2);
    orig.add("42");

    // Act
    Set<Object> actualRemoveResult = SetUtilities.remove(orig, "Ts");

    // Assert
    assertEquals(orig, actualRemoveResult);
  }

  /**
   * Test {@link SetUtilities#remove(Set, Object[])}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#remove(Set, Object[])}
   */
  @Test
  @DisplayName("Test remove(Set, Object[]); when HashSet(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.remove(Set, Object[])"})
  void testRemove_whenHashSet_thenReturnEmpty() {
    // Arrange and Act
    Set<Object> actualRemoveResult = SetUtilities.remove(new HashSet<>(), "Ts");

    // Assert
    assertTrue(actualRemoveResult.isEmpty());
  }

  /**
   * Test {@link SetUtilities#remove(Set, Object[])}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#remove(Set, Object[])}
   */
  @Test
  @DisplayName("Test remove(Set, Object[]); when HashSet(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.remove(Set, Object[])"})
  void testRemove_whenHashSet_thenReturnEmpty2() {
    // Arrange and Act
    Set<Object> actualRemoveResult = SetUtilities.remove(new HashSet<>());

    // Assert
    assertTrue(actualRemoveResult.isEmpty());
  }

  /**
   * Test {@link SetUtilities#compact(Object[])}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#compact(Object[])}
   */
  @Test
  @DisplayName("Test compact(Object[]); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.compact(Object[])"})
  void testCompact_thenReturnEmpty() {
    // Arrange and Act
    Set<Object> actualCompactResult = SetUtilities.compact();

    // Assert
    assertTrue(actualCompactResult.isEmpty());
  }

  /**
   * Test {@link SetUtilities#compact(Object[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#compact(Object[])}
   */
  @Test
  @DisplayName("Test compact(Object[]); when 'null'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.compact(Object[])"})
  void testCompact_whenNull_thenReturnEmpty() {
    // Arrange and Act
    Set<Object> actualCompactResult = SetUtilities.compact(null);

    // Assert
    assertTrue(actualCompactResult.isEmpty());
  }

  /**
   * Test {@link SetUtilities#compact(Object[])}.
   * <ul>
   *   <li>When {@code Ts}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetUtilities#compact(Object[])}
   */
  @Test
  @DisplayName("Test compact(Object[]); when 'Ts'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set SetUtilities.compact(Object[])"})
  void testCompact_whenTs_thenReturnSizeIsOne() {
    // Arrange and Act
    Set<Object> actualCompactResult = SetUtilities.compact("Ts");

    // Assert
    assertEquals(1, actualCompactResult.size());
  }
}
