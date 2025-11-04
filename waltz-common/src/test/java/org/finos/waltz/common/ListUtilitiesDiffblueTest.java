package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import ch.qos.logback.core.util.COWArrayList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ListUtilitiesDiffblueTest {
  /**
   * Method under test: {@link ListUtilities#newArrayList(Object[])}
   */
  @Test
  void testNewArrayList() {
    // Arrange and Act
    ArrayList<Object> actualNewArrayListResult = ListUtilities.newArrayList("Ts");

    // Assert
    assertEquals(1, actualNewArrayListResult.size());
    assertEquals("Ts", actualNewArrayListResult.get(0));
  }

  /**
   * Method under test: {@link ListUtilities#append(List, Object)}
   */
  @Test
  void testAppend() {
    // Arrange and Act
    List<Object> actualAppendResult = ListUtilities.append(new ArrayList<>(), "42");

    // Assert
    assertEquals(1, actualAppendResult.size());
    assertEquals("42", actualAppendResult.get(0));
  }

  /**
   * Method under test: {@link ListUtilities#append(List, Object)}
   */
  @Test
  void testAppend2() {
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
   * Method under test: {@link ListUtilities#append(List, Object)}
   */
  @Test
  void testAppend3() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    // Act
    List<Object> actualAppendResult = ListUtilities.append(ts, "42");

    // Assert
    assertEquals(3, actualAppendResult.size());
    assertEquals("42", actualAppendResult.get(0));
    assertEquals("42", actualAppendResult.get(1));
    assertEquals("42", actualAppendResult.get(2));
  }

  /**
   * Method under test: {@link ListUtilities#asList(Object[])}
   */
  @Test
  void testAsList() {
    // Arrange and Act
    List<Object> actualAsListResult = ListUtilities.asList("Ts");

    // Assert
    assertEquals(1, actualAsListResult.size());
    assertEquals("Ts", actualAsListResult.get(0));
  }

  /**
   * Method under test: {@link ListUtilities#compact(Collection)}
   */
  @Test
  void testCompact() {
    // Arrange and Act
    List<Object> actualCompactResult = ListUtilities.compact(new ArrayList<>());

    // Assert
    assertTrue(actualCompactResult.isEmpty());
  }

  /**
   * Method under test: {@link ListUtilities#compact(Collection)}
   */
  @Test
  void testCompact2() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act
    List<Object> actualCompactResult = ListUtilities.compact(ts);

    // Assert
    assertEquals(1, actualCompactResult.size());
    assertEquals("42", actualCompactResult.get(0));
  }

  /**
   * Method under test: {@link ListUtilities#compact(Collection)}
   */
  @Test
  void testCompact3() {
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
   * Method under test: {@link ListUtilities#compact(Collection)}
   */
  @Test
  void testCompact4() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add(mock(COWArrayList.class));

    // Act
    List<Object> actualCompactResult = ListUtilities.compact(ts);

    // Assert
    assertEquals(1, actualCompactResult.size());
  }

  /**
   * Method under test: {@link ListUtilities#concat(List[])}
   */
  @Test
  void testConcat() {
    // Arrange and Act
    List<Object> actualConcatResult = ListUtilities.concat(new ArrayList<>());

    // Assert
    assertTrue(actualConcatResult.isEmpty());
  }

  /**
   * Method under test: {@link ListUtilities#map(Collection, Function)}
   */
  @Test
  void testMap() {
    // Arrange and Act
    List<Object> actualMapResult = ListUtilities.<Object, Object>map(new ArrayList<>(), mock(Function.class));

    // Assert
    assertTrue(actualMapResult.isEmpty());
  }

  /**
   * Method under test: {@link ListUtilities#map(Collection, Function)}
   */
  @Test
  void testMap2() {
    // Arrange
    ArrayList<Object> as = new ArrayList<>();
    as.add("42");
    Function<Object, Object> mapper = mock(Function.class);
    when(mapper.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    List<Object> actualMapResult = ListUtilities.map(as, mapper);

    // Assert
    verify(mapper).apply(isA(Object.class));
    assertEquals(1, actualMapResult.size());
    assertEquals("Apply", actualMapResult.get(0));
  }

  /**
   * Method under test: {@link ListUtilities#map(Collection, Function)}
   */
  @Test
  void testMap3() {
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
   * Method under test: {@link ListUtilities#isEmpty(List)}
   */
  @Test
  void testIsEmpty() {
    // Arrange, Act and Assert
    assertTrue(ListUtilities.isEmpty(new ArrayList<>()));
    assertTrue(ListUtilities.isEmpty(null));
  }

  /**
   * Method under test: {@link ListUtilities#isEmpty(List)}
   */
  @Test
  void testIsEmpty2() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act and Assert
    assertFalse(ListUtilities.isEmpty(ts));
  }

  /**
   * Method under test: {@link ListUtilities#isEmpty(List)}
   */
  @Test
  void testIsEmpty3() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    // Act and Assert
    assertFalse(ListUtilities.isEmpty(ts));
  }

  /**
   * Method under test: {@link ListUtilities#isEmpty(List)}
   */
  @Test
  void testIsEmpty4() {
    // Arrange
    COWArrayList<Object> ts = mock(COWArrayList.class);
    when(ts.isEmpty()).thenReturn(true);

    // Act
    boolean actualIsEmptyResult = ListUtilities.isEmpty(ts);

    // Assert
    verify(ts).isEmpty();
    assertTrue(actualIsEmptyResult);
  }

  /**
   * Method under test: {@link ListUtilities#filter(Predicate, List)}
   */
  @Test
  void testFilter() {
    // Arrange
    Predicate<Object> predicate = mock(RangeBand.class)::equals;

    // Act
    List<Object> actualFilterResult = ListUtilities.filter(predicate, new ArrayList<>());

    // Assert
    assertTrue(actualFilterResult.isEmpty());
  }

  /**
   * Method under test: {@link ListUtilities#filter(Predicate, List)}
   */
  @Test
  void testFilter2() {
    // Arrange
    Predicate<Object> predicate = mock(RangeBand.class)::equals;

    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act
    List<Object> actualFilterResult = ListUtilities.filter(predicate, ts);

    // Assert
    assertTrue(actualFilterResult.isEmpty());
  }

  /**
   * Method under test: {@link ListUtilities#filter(Predicate, List)}
   */
  @Test
  void testFilter3() {
    // Arrange
    Predicate<Object> predicate = mock(RangeBand.class)::equals;

    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    // Act
    List<Object> actualFilterResult = ListUtilities.filter(predicate, ts);

    // Assert
    assertTrue(actualFilterResult.isEmpty());
  }

  /**
   * Method under test: {@link ListUtilities#drop(List, int)}
   */
  @Test
  void testDrop() {
    // Arrange and Act
    List<Object> actualDropResult = ListUtilities.drop(new ArrayList<>(), 3);

    // Assert
    assertTrue(actualDropResult.isEmpty());
  }

  /**
   * Method under test: {@link ListUtilities#drop(List, int)}
   */
  @Test
  void testDrop2() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act
    List<Object> actualDropResult = ListUtilities.drop(ts, 3);

    // Assert
    assertTrue(actualDropResult.isEmpty());
  }

  /**
   * Method under test: {@link ListUtilities#drop(List, int)}
   */
  @Test
  void testDrop3() {
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
   * Method under test: {@link ListUtilities#drop(List, int)}
   */
  @Test
  void testDrop4() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add(mock(COWArrayList.class));

    // Act
    List<Object> actualDropResult = ListUtilities.drop(ts, 3);

    // Assert
    assertTrue(actualDropResult.isEmpty());
  }

  /**
   * Method under test: {@link ListUtilities#reverse(List)}
   */
  @Test
  void testReverse() {
    // Arrange and Act
    List<Object> actualReverseResult = ListUtilities.reverse(new ArrayList<>());

    // Assert
    assertTrue(actualReverseResult.isEmpty());
  }

  /**
   * Method under test: {@link ListUtilities#reverse(List)}
   */
  @Test
  void testReverse2() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act
    List<Object> actualReverseResult = ListUtilities.reverse(ts);

    // Assert
    assertEquals(1, actualReverseResult.size());
    assertEquals("42", actualReverseResult.get(0));
  }

  /**
   * Method under test: {@link ListUtilities#reverse(List)}
   */
  @Test
  void testReverse3() {
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
   * Method under test: {@link ListUtilities#reverse(List)}
   */
  @Test
  void testReverse4() {
    // Arrange
    COWArrayList<Object> ts = mock(COWArrayList.class);
    when(ts.toArray()).thenReturn(new Object[]{"Array"});

    // Act
    List<Object> actualReverseResult = ListUtilities.reverse(ts);

    // Assert
    verify(ts).toArray();
    assertEquals(1, actualReverseResult.size());
    assertEquals("Array", actualReverseResult.get(0));
  }

  /**
   * Method under test: {@link ListUtilities#ensureNotNull(Collection)}
   */
  @Test
  void testEnsureNotNull() {
    // Arrange and Act
    List<Object> actualEnsureNotNullResult = ListUtilities.ensureNotNull(new ArrayList<>());

    // Assert
    assertTrue(actualEnsureNotNullResult.isEmpty());
  }

  /**
   * Method under test: {@link ListUtilities#ensureNotNull(Collection)}
   */
  @Test
  void testEnsureNotNull2() {
    // Arrange and Act
    List<Object> actualEnsureNotNullResult = ListUtilities.ensureNotNull(null);

    // Assert
    assertTrue(actualEnsureNotNullResult.isEmpty());
  }

  /**
   * Method under test: {@link ListUtilities#ensureNotNull(Collection)}
   */
  @Test
  void testEnsureNotNull3() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act
    List<Object> actualEnsureNotNullResult = ListUtilities.ensureNotNull(ts);

    // Assert
    assertEquals(1, actualEnsureNotNullResult.size());
    assertEquals("42", actualEnsureNotNullResult.get(0));
  }

  /**
   * Method under test: {@link ListUtilities#ensureNotNull(Collection)}
   */
  @Test
  void testEnsureNotNull4() {
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
   * Method under test: {@link ListUtilities#push(List, Object[])}
   */
  @Test
  void testPush() {
    // Arrange and Act
    List<Object> actualPushResult = ListUtilities.push(new ArrayList<>(), "Elems");

    // Assert
    assertEquals(1, actualPushResult.size());
    assertEquals("Elems", actualPushResult.get(0));
  }

  /**
   * Method under test: {@link ListUtilities#push(List, Object[])}
   */
  @Test
  void testPush2() {
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
   * Method under test: {@link ListUtilities#push(List, Object[])}
   */
  @Test
  void testPush3() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");

    // Act
    List<Object> actualPushResult = ListUtilities.push(xs, "Elems");

    // Assert
    assertEquals(3, actualPushResult.size());
    assertEquals("42", actualPushResult.get(0));
    assertEquals("42", actualPushResult.get(1));
    assertEquals("Elems", actualPushResult.get(2));
  }

  /**
   * Method under test: {@link ListUtilities#applyToFirst(List, Function)}
   */
  @Test
  void testApplyToFirst() {
    // Arrange and Act
    Optional<Object> actualApplyToFirstResult = ListUtilities.<Object, Object>applyToFirst(new ArrayList<>(),
        mock(Function.class));

    // Assert
    assertFalse(actualApplyToFirstResult.isPresent());
  }

  /**
   * Method under test: {@link ListUtilities#applyToFirst(List, Function)}
   */
  @Test
  void testApplyToFirst2() {
    // Arrange and Act
    Optional<Object> actualApplyToFirstResult = ListUtilities.<Object, Object>applyToFirst(null, mock(Function.class));

    // Assert
    assertFalse(actualApplyToFirstResult.isPresent());
  }

  /**
   * Method under test: {@link ListUtilities#applyToFirst(List, Function)}
   */
  @Test
  void testApplyToFirst3() {
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
   * Method under test: {@link ListUtilities#applyToFirst(List, Function)}
   */
  @Test
  void testApplyToFirst4() {
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
   * Method under test: {@link ListUtilities#zip(List, List)}
   */
  @Test
  void testZip() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();

    // Act
    List<Tuple2<Object, Object>> actualZipResult = ListUtilities.zip(xs, new ArrayList<>());

    // Assert
    assertTrue(actualZipResult.isEmpty());
  }

  /**
   * Method under test: {@link ListUtilities#zip(List, List)}
   */
  @Test
  void testZip2() {
    // Arrange and Act
    List<Tuple2<Object, Object>> actualZipResult = ListUtilities.zip(null, null);

    // Assert
    assertTrue(actualZipResult.isEmpty());
  }

  /**
   * Method under test: {@link ListUtilities#zip(List, List)}
   */
  @Test
  void testZip3() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    // Act
    List<Tuple2<Object, Object>> actualZipResult = ListUtilities.zip(xs, new ArrayList<>());

    // Assert
    assertTrue(actualZipResult.isEmpty());
  }

  /**
   * Method under test: {@link ListUtilities#zip(List, List)}
   */
  @Test
  void testZip4() {
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
   * Method under test: {@link ListUtilities#zip(List, List)}
   */
  @Test
  void testZip5() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add(mock(COWArrayList.class));

    // Act
    List<Tuple2<Object, Object>> actualZipResult = ListUtilities.zip(xs, new ArrayList<>());

    // Assert
    assertTrue(actualZipResult.isEmpty());
  }

  /**
   * Method under test: {@link ListUtilities#zip(List, List)}
   */
  @Test
  void testZip6() {
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
   * Method under test: {@link ListUtilities#zip(List, List)}
   */
  @Test
  void testZip7() {
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
   * Method under test: {@link ListUtilities#zip(List, List)}
   */
  @Test
  void testZip8() {
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
   * Method under test: {@link ListUtilities#containsDuplicates(List)}
   */
  @Test
  void testContainsDuplicates() {
    // Arrange, Act and Assert
    assertFalse(ListUtilities.containsDuplicates(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ListUtilities#containsDuplicates(List)}
   */
  @Test
  void testContainsDuplicates2() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act and Assert
    assertFalse(ListUtilities.containsDuplicates(ts));
  }

  /**
   * Method under test: {@link ListUtilities#containsDuplicates(List)}
   */
  @Test
  void testContainsDuplicates3() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    // Act and Assert
    assertTrue(ListUtilities.containsDuplicates(ts));
  }

  /**
   * Method under test: {@link ListUtilities#maybeGet(List, int)}
   */
  @Test
  void testMaybeGet() {
    // Arrange and Act
    Optional<Object> actualMaybeGetResult = ListUtilities.maybeGet(new ArrayList<>(), 1);

    // Assert
    assertFalse(actualMaybeGetResult.isPresent());
  }

  /**
   * Method under test: {@link ListUtilities#maybeGet(List, int)}
   */
  @Test
  void testMaybeGet2() {
    // Arrange and Act
    Optional<Object> actualMaybeGetResult = ListUtilities.maybeGet(new ArrayList<>(), -1);

    // Assert
    assertFalse(actualMaybeGetResult.isPresent());
  }

  /**
   * Method under test: {@link ListUtilities#maybeGet(List, int)}
   */
  @Test
  void testMaybeGet3() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    // Act
    Optional<Object> actualMaybeGetResult = ListUtilities.maybeGet(xs, 1);

    // Assert
    assertFalse(actualMaybeGetResult.isPresent());
  }

  /**
   * Method under test: {@link ListUtilities#maybeGet(List, int)}
   */
  @Test
  void testMaybeGet4() {
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
   * Method under test: {@link ListUtilities#getOrDefault(List, int, Object)}
   */
  @Test
  void testGetOrDefault() {
    // Arrange, Act and Assert
    assertEquals("Default Value", ListUtilities.getOrDefault(new ArrayList<>(), 1, "Default Value"));
    assertEquals("Default Value", ListUtilities.getOrDefault(new ArrayList<>(), -1, "Default Value"));
  }

  /**
   * Method under test: {@link ListUtilities#getOrDefault(List, int, Object)}
   */
  @Test
  void testGetOrDefault2() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    // Act and Assert
    assertEquals("Default Value", ListUtilities.getOrDefault(xs, 1, "Default Value"));
  }

  /**
   * Method under test: {@link ListUtilities#getOrDefault(List, int, Object)}
   */
  @Test
  void testGetOrDefault3() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");

    // Act and Assert
    assertEquals("42", ListUtilities.getOrDefault(xs, 1, "Default Value"));
  }

  /**
   * Method under test: {@link ListUtilities#take(Collection, int)}
   */
  @Test
  void testTake() {
    // Arrange and Act
    List<Object> actualTakeResult = ListUtilities.take(new ArrayList<>(), Columns.K);

    // Assert
    assertTrue(actualTakeResult.isEmpty());
  }

  /**
   * Method under test: {@link ListUtilities#take(Collection, int)}
   */
  @Test
  void testTake2() {
    // Arrange and Act
    List<Object> actualTakeResult = ListUtilities.take(null, Columns.K);

    // Assert
    assertTrue(actualTakeResult.isEmpty());
  }

  /**
   * Method under test: {@link ListUtilities#take(Collection, int)}
   */
  @Test
  void testTake3() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    // Act
    List<Object> actualTakeResult = ListUtilities.take(xs, Columns.K);

    // Assert
    assertEquals(1, actualTakeResult.size());
    assertEquals("42", actualTakeResult.get(0));
  }

  /**
   * Method under test: {@link ListUtilities#take(Collection, int)}
   */
  @Test
  void testTake4() {
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
   * Method under test: {@link ListUtilities#take(Collection, int)}
   */
  @Test
  void testTake5() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add(mock(COWArrayList.class));

    // Act
    List<Object> actualTakeResult = ListUtilities.take(xs, Columns.K);

    // Assert
    assertEquals(1, actualTakeResult.size());
  }

  /**
   * Method under test: {@link ListUtilities#distinct(List)}
   */
  @Test
  void testDistinct() {
    // Arrange and Act
    List<Object> actualDistinctResult = ListUtilities.distinct(new ArrayList<>());

    // Assert
    assertTrue(actualDistinctResult.isEmpty());
  }

  /**
   * Method under test: {@link ListUtilities#distinct(List)}
   */
  @Test
  void testDistinct2() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act
    List<Object> actualDistinctResult = ListUtilities.distinct(ts);

    // Assert
    assertEquals(1, actualDistinctResult.size());
    assertEquals("42", actualDistinctResult.get(0));
  }

  /**
   * Method under test: {@link ListUtilities#distinct(List)}
   */
  @Test
  void testDistinct3() {
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
   * Method under test: {@link ListUtilities#distinct(List)}
   */
  @Test
  void testDistinct4() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add(mock(COWArrayList.class));

    // Act
    List<Object> actualDistinctResult = ListUtilities.distinct(ts);

    // Assert
    assertEquals(1, actualDistinctResult.size());
  }
}
