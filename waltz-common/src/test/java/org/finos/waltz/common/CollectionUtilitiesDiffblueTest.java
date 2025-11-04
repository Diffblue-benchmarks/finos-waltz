package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CollectionUtilitiesDiffblueTest {
  /**
   * Method under test: {@link CollectionUtilities#find(Collection, Predicate)}
   */
  @Test
  void testFind() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();

    // Act
    Optional<Object> actualFindResult = CollectionUtilities.find(ts, mock(RangeBand.class)::equals);

    // Assert
    assertFalse(actualFindResult.isPresent());
  }

  /**
   * Method under test: {@link CollectionUtilities#find(Collection, Predicate)}
   */
  @Test
  void testFind2() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act
    Optional<Object> actualFindResult = CollectionUtilities.find(ts, mock(RangeBand.class)::equals);

    // Assert
    assertFalse(actualFindResult.isPresent());
  }

  /**
   * Method under test: {@link CollectionUtilities#find(Collection, Predicate)}
   */
  @Test
  void testFind3() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    // Act
    Optional<Object> actualFindResult = CollectionUtilities.find(ts, mock(RangeBand.class)::equals);

    // Assert
    assertFalse(actualFindResult.isPresent());
  }

  /**
   * Method under test: {@link CollectionUtilities#find(Predicate, Collection)}
   */
  @Test
  void testFind4() {
    // Arrange
    Predicate<Object> pred = mock(RangeBand.class)::equals;

    // Act
    Optional<Object> actualFindResult = CollectionUtilities.find(pred, new ArrayList<>());

    // Assert
    assertFalse(actualFindResult.isPresent());
  }

  /**
   * Method under test: {@link CollectionUtilities#find(Predicate, Collection)}
   */
  @Test
  void testFind5() {
    // Arrange
    Predicate<Object> pred = mock(RangeBand.class)::equals;

    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act
    Optional<Object> actualFindResult = CollectionUtilities.find(pred, ts);

    // Assert
    assertFalse(actualFindResult.isPresent());
  }

  /**
   * Method under test: {@link CollectionUtilities#find(Predicate, Collection)}
   */
  @Test
  void testFind6() {
    // Arrange
    Predicate<Object> pred = mock(RangeBand.class)::equals;

    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    // Act
    Optional<Object> actualFindResult = CollectionUtilities.find(pred, ts);

    // Assert
    assertFalse(actualFindResult.isPresent());
  }

  /**
   * Method under test: {@link CollectionUtilities#any(Collection, Predicate)}
   */
  @Test
  void testAny() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();

    // Act and Assert
    assertFalse(CollectionUtilities.any(ts, mock(RangeBand.class)::equals));
  }

  /**
   * Method under test: {@link CollectionUtilities#any(Collection, Predicate)}
   */
  @Test
  void testAny2() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act and Assert
    assertFalse(CollectionUtilities.any(ts, mock(RangeBand.class)::equals));
  }

  /**
   * Method under test: {@link CollectionUtilities#any(Collection, Predicate)}
   */
  @Test
  void testAny3() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    // Act and Assert
    assertFalse(CollectionUtilities.any(ts, mock(RangeBand.class)::equals));
  }

  /**
   * Method under test: {@link CollectionUtilities#all(Collection, Predicate)}
   */
  @Test
  void testAll() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();

    // Act and Assert
    assertTrue(CollectionUtilities.all(ts, mock(RangeBand.class)::equals));
  }

  /**
   * Method under test: {@link CollectionUtilities#all(Collection, Predicate)}
   */
  @Test
  void testAll2() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act and Assert
    assertFalse(CollectionUtilities.all(ts, mock(RangeBand.class)::equals));
  }

  /**
   * Method under test: {@link CollectionUtilities#all(Collection, Predicate)}
   */
  @Test
  void testAll3() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    // Act and Assert
    assertFalse(CollectionUtilities.all(ts, mock(RangeBand.class)::equals));
  }

  /**
   * Method under test: {@link CollectionUtilities#first(Collection)}
   */
  @Test
  void testFirst() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act and Assert
    assertEquals("42", CollectionUtilities.first(ts));
  }

  /**
   * Method under test: {@link CollectionUtilities#first(Collection)}
   */
  @Test
  void testFirst2() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    // Act and Assert
    assertEquals("42", CollectionUtilities.first(ts));
  }

  /**
   * Method under test: {@link CollectionUtilities#map(Collection, Function)}
   */
  @Test
  void testMap() {
    // Arrange and Act
    Collection<Object> actualMapResult = CollectionUtilities.<Object, Object>map(new ArrayList<>(),
        mock(Function.class));

    // Assert
    assertTrue(actualMapResult instanceof List);
    assertTrue(actualMapResult.isEmpty());
  }

  /**
   * Method under test: {@link CollectionUtilities#map(Collection, Function)}
   */
  @Test
  void testMap2() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    Function<Object, Object> fn = mock(Function.class);
    when(fn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Collection<Object> actualMapResult = CollectionUtilities.map(xs, fn);

    // Assert
    verify(fn).apply(isA(Object.class));
    assertTrue(actualMapResult instanceof List);
    assertEquals(1, actualMapResult.size());
    assertEquals("Apply", ((List<Object>) actualMapResult).get(0));
  }

  /**
   * Method under test: {@link CollectionUtilities#map(Collection, Function)}
   */
  @Test
  void testMap3() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");
    Function<Object, Object> fn = mock(Function.class);
    when(fn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Collection<Object> actualMapResult = CollectionUtilities.map(xs, fn);

    // Assert
    verify(fn, atLeast(1)).apply(isA(Object.class));
    assertTrue(actualMapResult instanceof List);
    assertEquals(2, actualMapResult.size());
    assertEquals("Apply", ((List<Object>) actualMapResult).get(0));
    assertEquals("Apply", ((List<Object>) actualMapResult).get(1));
  }

  /**
   * Method under test: {@link CollectionUtilities#filter(Collection, Predicate)}
   */
  @Test
  void testFilter() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();

    // Act
    Collection<Object> actualFilterResult = CollectionUtilities.filter(xs, mock(RangeBand.class)::equals);

    // Assert
    assertTrue(actualFilterResult instanceof List);
    assertTrue(actualFilterResult.isEmpty());
  }

  /**
   * Method under test: {@link CollectionUtilities#filter(Collection, Predicate)}
   */
  @Test
  void testFilter2() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    // Act
    Collection<Object> actualFilterResult = CollectionUtilities.filter(xs, mock(RangeBand.class)::equals);

    // Assert
    assertTrue(actualFilterResult instanceof List);
    assertTrue(actualFilterResult.isEmpty());
  }

  /**
   * Method under test: {@link CollectionUtilities#filter(Collection, Predicate)}
   */
  @Test
  void testFilter3() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");

    // Act
    Collection<Object> actualFilterResult = CollectionUtilities.filter(xs, mock(RangeBand.class)::equals);

    // Assert
    assertTrue(actualFilterResult instanceof List);
    assertTrue(actualFilterResult.isEmpty());
  }

  /**
   * Method under test: {@link CollectionUtilities#maybe(Collection, Consumer)}
   */
  @Test
  void testMaybe() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    Consumer<Collection<Object>> fn = mock(Consumer.class);
    doNothing().when(fn).accept(Mockito.<Collection<Object>>any());

    // Act
    CollectionUtilities.maybe(xs, fn);

    // Assert that nothing has changed
    verify(fn).accept(isA(Collection.class));
  }

  /**
   * Method under test: {@link CollectionUtilities#maybe(Collection, Consumer)}
   */
  @Test
  void testMaybe2() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");
    Consumer<Collection<Object>> fn = mock(Consumer.class);
    doNothing().when(fn).accept(Mockito.<Collection<Object>>any());

    // Act
    CollectionUtilities.maybe(xs, fn);

    // Assert that nothing has changed
    verify(fn).accept(isA(Collection.class));
  }

  /**
   * Method under test: {@link CollectionUtilities#notEmpty(Collection)}
   */
  @Test
  void testNotEmpty() {
    // Arrange, Act and Assert
    assertFalse(CollectionUtilities.notEmpty(new ArrayList<>()));
    assertFalse(CollectionUtilities.notEmpty(null));
  }

  /**
   * Method under test: {@link CollectionUtilities#notEmpty(Collection)}
   */
  @Test
  void testNotEmpty2() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act and Assert
    assertTrue(CollectionUtilities.notEmpty(ts));
  }

  /**
   * Method under test: {@link CollectionUtilities#notEmpty(Collection)}
   */
  @Test
  void testNotEmpty3() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    // Act and Assert
    assertTrue(CollectionUtilities.notEmpty(ts));
  }

  /**
   * Method under test: {@link CollectionUtilities#head(Collection)}
   */
  @Test
  void testHead() {
    // Arrange and Act
    Optional<Object> actualHeadResult = CollectionUtilities.head(new ArrayList<>());

    // Assert
    assertFalse(actualHeadResult.isPresent());
  }

  /**
   * Method under test: {@link CollectionUtilities#head(Collection)}
   */
  @Test
  void testHead2() {
    // Arrange and Act
    Optional<Object> actualHeadResult = CollectionUtilities.head(null);

    // Assert
    assertFalse(actualHeadResult.isPresent());
  }

  /**
   * Method under test: {@link CollectionUtilities#head(Collection)}
   */
  @Test
  void testHead3() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    // Act
    Optional<Object> actualHeadResult = CollectionUtilities.head(xs);

    // Assert
    assertEquals("42", actualHeadResult.get());
    assertTrue(actualHeadResult.isPresent());
  }

  /**
   * Method under test: {@link CollectionUtilities#head(Collection)}
   */
  @Test
  void testHead4() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");

    // Act
    Optional<Object> actualHeadResult = CollectionUtilities.head(xs);

    // Assert
    assertEquals("42", actualHeadResult.get());
    assertTrue(actualHeadResult.isPresent());
  }

  /**
   * Method under test: {@link CollectionUtilities#sort(Collection)}
   */
  @Test
  void testSort() {
    // Arrange
    ArrayList<File> xs = new ArrayList<>();
    xs.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    List<File> actualSortResult = CollectionUtilities.sort(xs);

    // Assert
    assertEquals(xs, actualSortResult);
  }

  /**
   * Method under test: {@link CollectionUtilities#sort(Collection)}
   */
  @Test
  void testSort2() {
    // Arrange
    ArrayList<File> xs = new ArrayList<>();
    xs.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    xs.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    List<File> actualSortResult = CollectionUtilities.sort(xs);

    // Assert
    assertEquals(xs, actualSortResult);
  }

  /**
   * Method under test: {@link CollectionUtilities#sort(Collection, Comparator)}
   */
  @Test
  void testSort3() {
    // Arrange and Act
    List<Object> actualSortResult = CollectionUtilities.sort(new ArrayList<>(), mock(Comparator.class));

    // Assert
    assertTrue(actualSortResult.isEmpty());
  }

  /**
   * Method under test: {@link CollectionUtilities#sort(Collection, Comparator)}
   */
  @Test
  void testSort4() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    // Act
    List<Object> actualSortResult = CollectionUtilities.sort(xs, mock(Comparator.class));

    // Assert
    assertEquals(1, actualSortResult.size());
    assertEquals("42", actualSortResult.get(0));
  }

  /**
   * Method under test: {@link CollectionUtilities#sort(Collection, Comparator)}
   */
  @Test
  void testSort5() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");
    Comparator<Object> comparator = mock(Comparator.class);
    when(comparator.compare(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(1);

    // Act
    List<Object> actualSortResult = CollectionUtilities.sort(xs, comparator);

    // Assert
    verify(comparator).compare(isA(Object.class), isA(Object.class));
    assertEquals(xs, actualSortResult);
  }

  /**
   * Method under test: {@link CollectionUtilities#isEmpty(Collection)}
   */
  @Test
  void testIsEmpty() {
    // Arrange, Act and Assert
    assertTrue(CollectionUtilities.isEmpty(new ArrayList<>()));
    assertTrue(CollectionUtilities.isEmpty(null));
  }

  /**
   * Method under test: {@link CollectionUtilities#isEmpty(Collection)}
   */
  @Test
  void testIsEmpty2() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    // Act and Assert
    assertFalse(CollectionUtilities.isEmpty(xs));
  }

  /**
   * Method under test: {@link CollectionUtilities#isEmpty(Collection)}
   */
  @Test
  void testIsEmpty3() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");

    // Act and Assert
    assertFalse(CollectionUtilities.isEmpty(xs));
  }

  /**
   * Method under test: {@link CollectionUtilities#maybeFirst(Collection)}
   */
  @Test
  void testMaybeFirst() {
    // Arrange and Act
    Optional<Object> actualMaybeFirstResult = CollectionUtilities.maybeFirst(new ArrayList<>());

    // Assert
    assertFalse(actualMaybeFirstResult.isPresent());
  }

  /**
   * Method under test: {@link CollectionUtilities#maybeFirst(Collection)}
   */
  @Test
  void testMaybeFirst2() {
    // Arrange and Act
    Optional<Object> actualMaybeFirstResult = CollectionUtilities.maybeFirst(null);

    // Assert
    assertFalse(actualMaybeFirstResult.isPresent());
  }

  /**
   * Method under test: {@link CollectionUtilities#maybeFirst(Collection)}
   */
  @Test
  void testMaybeFirst3() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    // Act
    Optional<Object> actualMaybeFirstResult = CollectionUtilities.maybeFirst(xs);

    // Assert
    assertEquals("42", actualMaybeFirstResult.get());
    assertTrue(actualMaybeFirstResult.isPresent());
  }

  /**
   * Method under test: {@link CollectionUtilities#maybeFirst(Collection)}
   */
  @Test
  void testMaybeFirst4() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");

    // Act
    Optional<Object> actualMaybeFirstResult = CollectionUtilities.maybeFirst(xs);

    // Assert
    assertEquals("42", actualMaybeFirstResult.get());
    assertTrue(actualMaybeFirstResult.isPresent());
  }

  /**
   * Method under test:
   * {@link CollectionUtilities#maybeFirst(Collection, Predicate)}
   */
  @Test
  void testMaybeFirst5() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();

    // Act
    Optional<Object> actualMaybeFirstResult = CollectionUtilities.maybeFirst(xs, mock(RangeBand.class)::equals);

    // Assert
    assertFalse(actualMaybeFirstResult.isPresent());
  }

  /**
   * Method under test:
   * {@link CollectionUtilities#maybeFirst(Collection, Predicate)}
   */
  @Test
  void testMaybeFirst6() {
    // Arrange and Act
    Optional<Object> actualMaybeFirstResult = CollectionUtilities.maybeFirst(null, mock(RangeBand.class)::equals);

    // Assert
    assertFalse(actualMaybeFirstResult.isPresent());
  }

  /**
   * Method under test:
   * {@link CollectionUtilities#maybeFirst(Collection, Predicate)}
   */
  @Test
  void testMaybeFirst7() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    // Act
    Optional<Object> actualMaybeFirstResult = CollectionUtilities.maybeFirst(xs, mock(RangeBand.class)::equals);

    // Assert
    assertFalse(actualMaybeFirstResult.isPresent());
  }

  /**
   * Method under test:
   * {@link CollectionUtilities#maybeFirst(Collection, Predicate)}
   */
  @Test
  void testMaybeFirst8() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");

    // Act
    Optional<Object> actualMaybeFirstResult = CollectionUtilities.maybeFirst(xs, mock(RangeBand.class)::equals);

    // Assert
    assertFalse(actualMaybeFirstResult.isPresent());
  }

  /**
   * Method under test: {@link CollectionUtilities#sumInts(Collection)}
   */
  @Test
  void testSumInts() {
    // Arrange, Act and Assert
    assertEquals(0L, CollectionUtilities.sumInts(new ArrayList<>()).longValue());
  }

  /**
   * Method under test: {@link CollectionUtilities#sumInts(Collection)}
   */
  @Test
  void testSumInts2() {
    // Arrange
    LinkedHashSet<Integer> values = new LinkedHashSet<>();
    values.add(Columns.AQ);

    // Act and Assert
    assertEquals(42L, CollectionUtilities.sumInts(values).longValue());
  }

  /**
   * Method under test: {@link CollectionUtilities#sumInts(Collection)}
   */
  @Test
  void testSumInts3() {
    // Arrange
    ArrayList<Integer> values = new ArrayList<>();
    values.add(1);
    values.add(2);

    // Act and Assert
    assertEquals(3L, CollectionUtilities.sumInts(values).longValue());
  }
}
