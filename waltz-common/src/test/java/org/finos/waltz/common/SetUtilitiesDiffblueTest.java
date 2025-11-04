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
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SetUtilitiesDiffblueTest {
  /**
   * Method under test: {@link SetUtilities#asSet(Object[])}
   */
  @Test
  void testAsSet() {
    // Arrange and Act
    Set<Object> actualAsSetResult = SetUtilities.asSet("Ts");

    // Assert
    assertEquals(1, actualAsSetResult.size());
  }

  /**
   * Method under test: {@link SetUtilities#asSet(Object[])}
   */
  @Test
  void testAsSet2() {
    // Arrange and Act
    Set<Object> actualAsSetResult = SetUtilities.asSet(null);

    // Assert
    assertTrue(actualAsSetResult.isEmpty());
  }

  /**
   * Method under test: {@link SetUtilities#asSet(Object[])}
   */
  @Test
  void testAsSet3() {
    // Arrange and Act
    Set<Object> actualAsSetResult = SetUtilities.asSet();

    // Assert
    assertTrue(actualAsSetResult.isEmpty());
  }

  /**
   * Method under test: {@link SetUtilities#fromArray(Object[])}
   */
  @Test
  void testFromArray() {
    // Arrange and Act
    Set<Object> actualFromArrayResult = SetUtilities.fromArray("Ts");

    // Assert
    assertEquals(1, actualFromArrayResult.size());
  }

  /**
   * Method under test: {@link SetUtilities#fromArray(Object[])}
   */
  @Test
  void testFromArray2() {
    // Arrange and Act
    Set<Object> actualFromArrayResult = SetUtilities.fromArray(null);

    // Assert
    assertTrue(actualFromArrayResult.isEmpty());
  }

  /**
   * Method under test: {@link SetUtilities#fromArray(Object[])}
   */
  @Test
  void testFromArray3() {
    // Arrange and Act
    Set<Object> actualFromArrayResult = SetUtilities.fromArray();

    // Assert
    assertTrue(actualFromArrayResult.isEmpty());
  }

  /**
   * Method under test: {@link SetUtilities#fromCollection(Collection)}
   */
  @Test
  void testFromCollection() {
    // Arrange and Act
    Set<Object> actualFromCollectionResult = SetUtilities.fromCollection(new ArrayList<>());

    // Assert
    assertTrue(actualFromCollectionResult.isEmpty());
  }

  /**
   * Method under test: {@link SetUtilities#fromCollection(Collection)}
   */
  @Test
  void testFromCollection2() {
    // Arrange and Act
    Set<Object> actualFromCollectionResult = SetUtilities.fromCollection(null);

    // Assert
    assertTrue(actualFromCollectionResult.isEmpty());
  }

  /**
   * Method under test: {@link SetUtilities#fromCollection(Collection)}
   */
  @Test
  void testFromCollection3() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act
    Set<Object> actualFromCollectionResult = SetUtilities.fromCollection(ts);

    // Assert
    assertEquals(1, actualFromCollectionResult.size());
  }

  /**
   * Method under test: {@link SetUtilities#fromCollection(Collection)}
   */
  @Test
  void testFromCollection4() {
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
   * Method under test: {@link SetUtilities#map(Collection, Function)}
   */
  @Test
  void testMap() {
    // Arrange and Act
    Set<Object> actualMapResult = SetUtilities.<Object, Object>map(new ArrayList<>(), mock(Function.class));

    // Assert
    assertTrue(actualMapResult.isEmpty());
  }

  /**
   * Method under test: {@link SetUtilities#map(Collection, Function)}
   */
  @Test
  void testMap2() {
    // Arrange and Act
    Set<Object> actualMapResult = SetUtilities.<Object, Object>map(null, mock(Function.class));

    // Assert
    assertTrue(actualMapResult.isEmpty());
  }

  /**
   * Method under test: {@link SetUtilities#map(Collection, Function)}
   */
  @Test
  void testMap3() {
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
   * Method under test: {@link SetUtilities#map(Collection, Function)}
   */
  @Test
  void testMap4() {
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
   * Method under test: {@link SetUtilities#filter(Collection, Predicate)}
   */
  @Test
  void testFilter() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();

    // Act
    Set<Object> actualFilterResult = SetUtilities.filter(xs, mock(RangeBand.class)::equals);

    // Assert
    assertTrue(actualFilterResult.isEmpty());
  }

  /**
   * Method under test: {@link SetUtilities#filter(Collection, Predicate)}
   */
  @Test
  void testFilter2() {
    // Arrange and Act
    Set<Object> actualFilterResult = SetUtilities.filter(null, mock(RangeBand.class)::equals);

    // Assert
    assertTrue(actualFilterResult.isEmpty());
  }

  /**
   * Method under test: {@link SetUtilities#filter(Collection, Predicate)}
   */
  @Test
  void testFilter3() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    // Act
    Set<Object> actualFilterResult = SetUtilities.filter(xs, mock(RangeBand.class)::equals);

    // Assert
    assertTrue(actualFilterResult.isEmpty());
  }

  /**
   * Method under test: {@link SetUtilities#filter(Collection, Predicate)}
   */
  @Test
  void testFilter4() {
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
   * Method under test: {@link SetUtilities#union(Collection[])}
   */
  @Test
  void testUnion() {
    // Arrange and Act
    Set<Object> actualUnionResult = SetUtilities.union(new ArrayList<>());

    // Assert
    assertTrue(actualUnionResult.isEmpty());
  }

  /**
   * Method under test: {@link SetUtilities#orderedUnion(Collection[])}
   */
  @Test
  void testOrderedUnion() {
    // Arrange and Act
    Set<Object> actualOrderedUnionResult = SetUtilities.orderedUnion(new ArrayList<>());

    // Assert
    assertTrue(actualOrderedUnionResult.isEmpty());
  }

  /**
   * Method under test: {@link SetUtilities#minus(Set, Set[])}
   */
  @Test
  void testMinus() {
    // Arrange
    HashSet<Object> xs = new HashSet<>();

    // Act
    Set<Object> actualMinusResult = SetUtilities.minus(xs, new HashSet<>());

    // Assert
    assertTrue(actualMinusResult.isEmpty());
  }

  /**
   * Method under test: {@link SetUtilities#minus(Set, Set[])}
   */
  @Test
  void testMinus2() {
    // Arrange
    HashSet<Object> xs = new HashSet<>();
    xs.add("42");

    // Act
    Set<Object> actualMinusResult = SetUtilities.minus(xs, new HashSet<>());

    // Assert
    assertEquals(1, actualMinusResult.size());
  }

  /**
   * Method under test: {@link SetUtilities#minus(Set, Set[])}
   */
  @Test
  void testMinus3() {
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
   * Method under test: {@link SetUtilities#intersection(Set, Set)}
   */
  @Test
  void testIntersection() {
    // Arrange
    HashSet<Object> xs = new HashSet<>();

    // Act
    Set<Object> actualIntersectionResult = SetUtilities.intersection(xs, new HashSet<>());

    // Assert
    assertTrue(actualIntersectionResult.isEmpty());
  }

  /**
   * Method under test: {@link SetUtilities#intersection(Set, Set)}
   */
  @Test
  void testIntersection2() {
    // Arrange
    HashSet<Object> xs = new HashSet<>();
    xs.add("42");

    // Act
    Set<Object> actualIntersectionResult = SetUtilities.intersection(xs, new HashSet<>());

    // Assert
    assertTrue(actualIntersectionResult.isEmpty());
  }

  /**
   * Method under test: {@link SetUtilities#intersection(Set, Set)}
   */
  @Test
  void testIntersection3() {
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
   * Method under test: {@link SetUtilities#intersection(Set, Set)}
   */
  @Test
  void testIntersection4() {
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
   * Method under test: {@link SetUtilities#intersection(Set, Set)}
   */
  @Test
  void testIntersection5() {
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
   * Method under test: {@link SetUtilities#uniqBy(Collection, Function)}
   */
  @Test
  void testUniqBy() {
    // Arrange and Act
    Set<Object> actualUniqByResult = SetUtilities.<Object, Object>uniqBy(new ArrayList<>(), mock(Function.class));

    // Assert
    assertTrue(actualUniqByResult.isEmpty());
  }

  /**
   * Method under test: {@link SetUtilities#uniqBy(Collection, Function)}
   */
  @Test
  void testUniqBy2() {
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
   * Method under test: {@link SetUtilities#uniqBy(Collection, Function)}
   */
  @Test
  void testUniqBy3() {
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
   * Method under test: {@link SetUtilities#unionAll(Collection)}
   */
  @Test
  void testUnionAll() {
    // Arrange and Act
    Collection<Object> actualUnionAllResult = SetUtilities.unionAll(new ArrayList<>());

    // Assert
    assertTrue(actualUnionAllResult instanceof Set);
    assertTrue(actualUnionAllResult.isEmpty());
  }

  /**
   * Method under test: {@link SetUtilities#unionAll(Collection)}
   */
  @Test
  void testUnionAll2() {
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
   * Method under test: {@link SetUtilities#unionAll(Collection)}
   */
  @Test
  void testUnionAll3() {
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
   * Method under test: {@link SetUtilities#complement(Set, Set)}
   */
  @Test
  void testComplement() {
    // Arrange
    HashSet<Object> xs = new HashSet<>();

    // Act
    Set<Object> actualComplementResult = SetUtilities.complement(xs, new HashSet<>());

    // Assert
    assertTrue(actualComplementResult.isEmpty());
  }

  /**
   * Method under test: {@link SetUtilities#complement(Set, Set)}
   */
  @Test
  void testComplement2() {
    // Arrange
    HashSet<Object> xs = new HashSet<>();
    xs.add("42");

    // Act
    Set<Object> actualComplementResult = SetUtilities.complement(xs, new HashSet<>());

    // Assert
    assertEquals(1, actualComplementResult.size());
  }

  /**
   * Method under test: {@link SetUtilities#complement(Set, Set)}
   */
  @Test
  void testComplement3() {
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
   * Method under test: {@link SetUtilities#complement(Set, Set)}
   */
  @Test
  void testComplement4() {
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
   * Method under test: {@link SetUtilities#complement(Set, Set)}
   */
  @Test
  void testComplement5() {
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
   * Method under test: {@link SetUtilities#hasIntersection(Set, Set)}
   */
  @Test
  void testHasIntersection() {
    // Arrange
    HashSet<Object> xs = new HashSet<>();

    // Act and Assert
    assertFalse(SetUtilities.hasIntersection(xs, new HashSet<>()));
  }

  /**
   * Method under test: {@link SetUtilities#hasIntersection(Set, Set)}
   */
  @Test
  void testHasIntersection2() {
    // Arrange
    HashSet<Object> xs = new HashSet<>();
    xs.add("42");

    // Act and Assert
    assertFalse(SetUtilities.hasIntersection(xs, new HashSet<>()));
  }

  /**
   * Method under test: {@link SetUtilities#hasIntersection(Set, Set)}
   */
  @Test
  void testHasIntersection3() {
    // Arrange
    HashSet<Object> xs = new HashSet<>();
    xs.add(2);
    xs.add("42");

    // Act and Assert
    assertFalse(SetUtilities.hasIntersection(xs, new HashSet<>()));
  }

  /**
   * Method under test: {@link SetUtilities#hasIntersection(Set, Set)}
   */
  @Test
  void testHasIntersection4() {
    // Arrange
    HashSet<Object> xs = new HashSet<>();

    HashSet<Object> ys = new HashSet<>();
    ys.add("42");

    // Act and Assert
    assertFalse(SetUtilities.hasIntersection(xs, ys));
  }

  /**
   * Method under test: {@link SetUtilities#hasIntersection(Set, Set)}
   */
  @Test
  void testHasIntersection5() {
    // Arrange
    HashSet<Object> xs = new HashSet<>();

    HashSet<Object> ys = new HashSet<>();
    ys.add(2);
    ys.add("42");

    // Act and Assert
    assertFalse(SetUtilities.hasIntersection(xs, ys));
  }

  /**
   * Method under test: {@link SetUtilities#hasIntersection(Set, Set)}
   */
  @Test
  void testHasIntersection6() {
    // Arrange
    HashSet<Object> xs = new HashSet<>();
    xs.add("42");

    HashSet<Object> ys = new HashSet<>();
    ys.add("42");

    // Act and Assert
    assertTrue(SetUtilities.hasIntersection(xs, ys));
  }

  /**
   * Method under test: {@link SetUtilities#fromOptionals(Collection)}
   */
  @Test
  void testFromOptionals() {
    // Arrange and Act
    Set<Object> actualFromOptionalsResult = SetUtilities.fromOptionals(new ArrayList<>());

    // Assert
    assertTrue(actualFromOptionalsResult.isEmpty());
  }

  /**
   * Method under test: {@link SetUtilities#fromOptionals(Collection)}
   */
  @Test
  void testFromOptionals2() {
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
   * Method under test: {@link SetUtilities#fromOptionals(Collection)}
   */
  @Test
  void testFromOptionals3() {
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
   * Method under test: {@link SetUtilities#maybeAdd(Set, Optional)}
   */
  @Test
  void testMaybeAdd() {
    // Arrange
    HashSet<Object> ts = new HashSet<>();
    Optional<Object> toAdd = Optional.of("42");

    // Act
    Set<Object> actualMaybeAddResult = SetUtilities.maybeAdd(ts, toAdd);

    // Assert
    assertEquals(1, actualMaybeAddResult.size());
  }

  /**
   * Method under test: {@link SetUtilities#maybeAdd(Set, Optional)}
   */
  @Test
  void testMaybeAdd2() {
    // Arrange
    HashSet<Object> ts = new HashSet<>();
    ts.add("42");
    Optional<Object> toAdd = Optional.of("42");

    // Act
    Set<Object> actualMaybeAddResult = SetUtilities.maybeAdd(ts, toAdd);

    // Assert
    assertEquals(1, actualMaybeAddResult.size());
  }

  /**
   * Method under test: {@link SetUtilities#maybeAdd(Set, Optional)}
   */
  @Test
  void testMaybeAdd3() {
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
   * Method under test: {@link SetUtilities#maybeAdd(Set, Optional)}
   */
  @Test
  void testMaybeAdd4() {
    // Arrange
    HashSet<Object> ts = new HashSet<>();
    Optional<Object> toAdd = Optional.empty();

    // Act
    Set<Object> actualMaybeAddResult = SetUtilities.maybeAdd(ts, toAdd);

    // Assert
    assertTrue(actualMaybeAddResult.isEmpty());
  }

  /**
   * Method under test: {@link SetUtilities#add(Set, Object[])}
   */
  @Test
  void testAdd() {
    // Arrange and Act
    Set<Object> actualAddResult = SetUtilities.add(new HashSet<>(), "Ts");

    // Assert
    assertEquals(1, actualAddResult.size());
  }

  /**
   * Method under test: {@link SetUtilities#add(Set, Object[])}
   */
  @Test
  void testAdd2() {
    // Arrange and Act
    Set<Object> actualAddResult = SetUtilities.add(new HashSet<>(), null);

    // Assert
    assertTrue(actualAddResult.isEmpty());
  }

  /**
   * Method under test: {@link SetUtilities#add(Set, Object[])}
   */
  @Test
  void testAdd3() {
    // Arrange
    HashSet<Object> orig = new HashSet<>();
    orig.add("42");

    // Act
    Set<Object> actualAddResult = SetUtilities.add(orig, "Ts");

    // Assert
    assertEquals(2, actualAddResult.size());
  }

  /**
   * Method under test: {@link SetUtilities#add(Set, Object[])}
   */
  @Test
  void testAdd4() {
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
   * Method under test: {@link SetUtilities#add(Set, Object[])}
   */
  @Test
  void testAdd5() {
    // Arrange and Act
    Set<Object> actualAddResult = SetUtilities.add(new HashSet<>());

    // Assert
    assertTrue(actualAddResult.isEmpty());
  }

  /**
   * Method under test: {@link SetUtilities#remove(Set, Object[])}
   */
  @Test
  void testRemove() {
    // Arrange and Act
    Set<Object> actualRemoveResult = SetUtilities.remove(new HashSet<>(), "Ts");

    // Assert
    assertTrue(actualRemoveResult.isEmpty());
  }

  /**
   * Method under test: {@link SetUtilities#remove(Set, Object[])}
   */
  @Test
  void testRemove2() {
    // Arrange
    HashSet<Object> orig = new HashSet<>();
    orig.add("42");

    // Act
    Set<Object> actualRemoveResult = SetUtilities.remove(orig, "Ts");

    // Assert
    assertEquals(1, actualRemoveResult.size());
  }

  /**
   * Method under test: {@link SetUtilities#remove(Set, Object[])}
   */
  @Test
  void testRemove3() {
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
   * Method under test: {@link SetUtilities#remove(Set, Object[])}
   */
  @Test
  void testRemove4() {
    // Arrange and Act
    Set<Object> actualRemoveResult = SetUtilities.remove(new HashSet<>());

    // Assert
    assertTrue(actualRemoveResult.isEmpty());
  }

  /**
   * Method under test: {@link SetUtilities#compact(Object[])}
   */
  @Test
  void testCompact() {
    // Arrange and Act
    Set<Object> actualCompactResult = SetUtilities.compact("Ts");

    // Assert
    assertEquals(1, actualCompactResult.size());
  }

  /**
   * Method under test: {@link SetUtilities#compact(Object[])}
   */
  @Test
  void testCompact2() {
    // Arrange and Act
    Set<Object> actualCompactResult = SetUtilities.compact(null);

    // Assert
    assertTrue(actualCompactResult.isEmpty());
  }

  /**
   * Method under test: {@link SetUtilities#compact(Object[])}
   */
  @Test
  void testCompact3() {
    // Arrange and Act
    Set<Object> actualCompactResult = SetUtilities.compact();

    // Assert
    assertTrue(actualCompactResult.isEmpty());
  }
}
