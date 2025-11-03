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
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CollectionUtilitiesDiffblueTest {
  /**
   * Test {@link CollectionUtilities#find(Predicate, Collection)} with {@code pred}, {@code ts}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link RangeBand}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#find(Predicate, Collection)}
   */
  @Test
  @DisplayName("Test find(Predicate, Collection) with 'pred', 'ts'; given '42'; when RangeBand; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional CollectionUtilities.find(Predicate, Collection)"})
  void testFindWithPredTs_given42_whenRangeBand_thenReturnNotPresent() {
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
   * Test {@link CollectionUtilities#find(Predicate, Collection)} with {@code pred}, {@code ts}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link RangeBand}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#find(Predicate, Collection)}
   */
  @Test
  @DisplayName("Test find(Predicate, Collection) with 'pred', 'ts'; given '42'; when RangeBand; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional CollectionUtilities.find(Predicate, Collection)"})
  void testFindWithPredTs_given42_whenRangeBand_thenReturnNotPresent2() {
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
   * Test {@link CollectionUtilities#find(Predicate, Collection)} with {@code pred}, {@code ts}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#find(Predicate, Collection)}
   */
  @Test
  @DisplayName("Test find(Predicate, Collection) with 'pred', 'ts'; when ArrayList(); then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional CollectionUtilities.find(Predicate, Collection)"})
  void testFindWithPredTs_whenArrayList_thenReturnNotPresent() {
    // Arrange
    Predicate<Object> pred = mock(RangeBand.class)::equals;

    // Act
    Optional<Object> actualFindResult = CollectionUtilities.find(pred, new ArrayList<>());

    // Assert
    assertFalse(actualFindResult.isPresent());
  }

  /**
   * Test {@link CollectionUtilities#find(Collection, Predicate)} with {@code ts}, {@code pred}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#find(Collection, Predicate)}
   */
  @Test
  @DisplayName("Test find(Collection, Predicate) with 'ts', 'pred'; given '42'; when ArrayList() add '42'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional CollectionUtilities.find(Collection, Predicate)"})
  void testFindWithTsPred_given42_whenArrayListAdd42_thenReturnNotPresent() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act
    Optional<Object> actualFindResult = CollectionUtilities.find(ts, mock(RangeBand.class)::equals);

    // Assert
    assertFalse(actualFindResult.isPresent());
  }

  /**
   * Test {@link CollectionUtilities#find(Collection, Predicate)} with {@code ts}, {@code pred}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#find(Collection, Predicate)}
   */
  @Test
  @DisplayName("Test find(Collection, Predicate) with 'ts', 'pred'; given '42'; when ArrayList() add '42'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional CollectionUtilities.find(Collection, Predicate)"})
  void testFindWithTsPred_given42_whenArrayListAdd42_thenReturnNotPresent2() {
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
   * Test {@link CollectionUtilities#find(Collection, Predicate)} with {@code ts}, {@code pred}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#find(Collection, Predicate)}
   */
  @Test
  @DisplayName("Test find(Collection, Predicate) with 'ts', 'pred'; when ArrayList(); then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional CollectionUtilities.find(Collection, Predicate)"})
  void testFindWithTsPred_whenArrayList_thenReturnNotPresent() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();

    // Act
    Optional<Object> actualFindResult = CollectionUtilities.find(ts, mock(RangeBand.class)::equals);

    // Assert
    assertFalse(actualFindResult.isPresent());
  }

  /**
   * Test {@link CollectionUtilities#any(Collection, Predicate)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#any(Collection, Predicate)}
   */
  @Test
  @DisplayName("Test any(Collection, Predicate); given '42'; when ArrayList() add '42'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CollectionUtilities.any(Collection, Predicate)"})
  void testAny_given42_whenArrayListAdd42_thenReturnFalse() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act and Assert
    assertFalse(CollectionUtilities.any(ts, mock(RangeBand.class)::equals));
  }

  /**
   * Test {@link CollectionUtilities#any(Collection, Predicate)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#any(Collection, Predicate)}
   */
  @Test
  @DisplayName("Test any(Collection, Predicate); given '42'; when ArrayList() add '42'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CollectionUtilities.any(Collection, Predicate)"})
  void testAny_given42_whenArrayListAdd42_thenReturnFalse2() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    // Act and Assert
    assertFalse(CollectionUtilities.any(ts, mock(RangeBand.class)::equals));
  }

  /**
   * Test {@link CollectionUtilities#any(Collection, Predicate)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#any(Collection, Predicate)}
   */
  @Test
  @DisplayName("Test any(Collection, Predicate); when ArrayList(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CollectionUtilities.any(Collection, Predicate)"})
  void testAny_whenArrayList_thenReturnFalse() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();

    // Act and Assert
    assertFalse(CollectionUtilities.any(ts, mock(RangeBand.class)::equals));
  }

  /**
   * Test {@link CollectionUtilities#all(Collection, Predicate)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#all(Collection, Predicate)}
   */
  @Test
  @DisplayName("Test all(Collection, Predicate); given '42'; when ArrayList() add '42'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CollectionUtilities.all(Collection, Predicate)"})
  void testAll_given42_whenArrayListAdd42_thenReturnFalse() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act and Assert
    assertFalse(CollectionUtilities.all(ts, mock(RangeBand.class)::equals));
  }

  /**
   * Test {@link CollectionUtilities#all(Collection, Predicate)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#all(Collection, Predicate)}
   */
  @Test
  @DisplayName("Test all(Collection, Predicate); given '42'; when ArrayList() add '42'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CollectionUtilities.all(Collection, Predicate)"})
  void testAll_given42_whenArrayListAdd42_thenReturnFalse2() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    // Act and Assert
    assertFalse(CollectionUtilities.all(ts, mock(RangeBand.class)::equals));
  }

  /**
   * Test {@link CollectionUtilities#all(Collection, Predicate)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#all(Collection, Predicate)}
   */
  @Test
  @DisplayName("Test all(Collection, Predicate); when ArrayList(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CollectionUtilities.all(Collection, Predicate)"})
  void testAll_whenArrayList_thenReturnTrue() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();

    // Act and Assert
    assertTrue(CollectionUtilities.all(ts, mock(RangeBand.class)::equals));
  }

  /**
   * Test {@link CollectionUtilities#first(Collection)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#first(Collection)}
   */
  @Test
  @DisplayName("Test first(Collection); given '42'; when ArrayList() add '42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object CollectionUtilities.first(Collection)"})
  void testFirst_given42_whenArrayListAdd42_thenReturn42() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act and Assert
    assertEquals("42", CollectionUtilities.first(ts));
  }

  /**
   * Test {@link CollectionUtilities#first(Collection)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#first(Collection)}
   */
  @Test
  @DisplayName("Test first(Collection); given '42'; when ArrayList() add '42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object CollectionUtilities.first(Collection)"})
  void testFirst_given42_whenArrayListAdd42_thenReturn422() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    // Act and Assert
    assertEquals("42", CollectionUtilities.first(ts));
  }

  /**
   * Test {@link CollectionUtilities#map(Collection, Function)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#map(Collection, Function)}
   */
  @Test
  @DisplayName("Test map(Collection, Function); given '42'; when ArrayList() add '42'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection CollectionUtilities.map(Collection, Function)"})
  void testMap_given42_whenArrayListAdd42_thenReturnSizeIsOne() {
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
   * Test {@link CollectionUtilities#map(Collection, Function)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#map(Collection, Function)}
   */
  @Test
  @DisplayName("Test map(Collection, Function); given '42'; when ArrayList() add '42'; then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection CollectionUtilities.map(Collection, Function)"})
  void testMap_given42_whenArrayListAdd42_thenReturnSizeIsTwo() {
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
   * Test {@link CollectionUtilities#map(Collection, Function)}.
   * <ul>
   *   <li>When {@link Function}.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#map(Collection, Function)}
   */
  @Test
  @DisplayName("Test map(Collection, Function); when Function; then return ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection CollectionUtilities.map(Collection, Function)"})
  void testMap_whenFunction_thenReturnArrayList() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();

    // Act
    Collection<Object> actualMapResult = CollectionUtilities.<Object, Object>map(xs, mock(Function.class));

    // Assert
    assertEquals(xs, actualMapResult);
  }

  /**
   * Test {@link CollectionUtilities#filter(Collection, Predicate)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#filter(Collection, Predicate)}
   */
  @Test
  @DisplayName("Test filter(Collection, Predicate); given '42'; when ArrayList() add '42'; then return List")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection CollectionUtilities.filter(Collection, Predicate)"})
  void testFilter_given42_whenArrayListAdd42_thenReturnList() {
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
   * Test {@link CollectionUtilities#filter(Collection, Predicate)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#filter(Collection, Predicate)}
   */
  @Test
  @DisplayName("Test filter(Collection, Predicate); given '42'; when ArrayList() add '42'; then return List")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection CollectionUtilities.filter(Collection, Predicate)"})
  void testFilter_given42_whenArrayListAdd42_thenReturnList2() {
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
   * Test {@link CollectionUtilities#filter(Collection, Predicate)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#filter(Collection, Predicate)}
   */
  @Test
  @DisplayName("Test filter(Collection, Predicate); when ArrayList(); then return ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection CollectionUtilities.filter(Collection, Predicate)"})
  void testFilter_whenArrayList_thenReturnArrayList() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();

    // Act
    Collection<Object> actualFilterResult = CollectionUtilities.filter(xs, mock(RangeBand.class)::equals);

    // Assert
    assertEquals(xs, actualFilterResult);
  }

  /**
   * Test {@link CollectionUtilities#maybe(Collection, Consumer)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#maybe(Collection, Consumer)}
   */
  @Test
  @DisplayName("Test maybe(Collection, Consumer); given '42'; when ArrayList() add '42'; then calls accept(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CollectionUtilities.maybe(Collection, Consumer)"})
  void testMaybe_given42_whenArrayListAdd42_thenCallsAccept() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    Consumer<Collection<Object>> fn = mock(Consumer.class);
    doNothing().when(fn).accept(Mockito.<Collection<Object>>any());

    // Act
    CollectionUtilities.maybe(xs, fn);

    // Assert
    verify(fn).accept(isA(Collection.class));
  }

  /**
   * Test {@link CollectionUtilities#maybe(Collection, Consumer)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#maybe(Collection, Consumer)}
   */
  @Test
  @DisplayName("Test maybe(Collection, Consumer); given '42'; when ArrayList() add '42'; then calls accept(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CollectionUtilities.maybe(Collection, Consumer)"})
  void testMaybe_given42_whenArrayListAdd42_thenCallsAccept2() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");
    Consumer<Collection<Object>> fn = mock(Consumer.class);
    doNothing().when(fn).accept(Mockito.<Collection<Object>>any());

    // Act
    CollectionUtilities.maybe(xs, fn);

    // Assert
    verify(fn).accept(isA(Collection.class));
  }

  /**
   * Test {@link CollectionUtilities#notEmpty(Collection)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#notEmpty(Collection)}
   */
  @Test
  @DisplayName("Test notEmpty(Collection); given '42'; when ArrayList() add '42'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CollectionUtilities.notEmpty(Collection)"})
  void testNotEmpty_given42_whenArrayListAdd42_thenReturnTrue() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");

    // Act and Assert
    assertTrue(CollectionUtilities.notEmpty(ts));
  }

  /**
   * Test {@link CollectionUtilities#notEmpty(Collection)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#notEmpty(Collection)}
   */
  @Test
  @DisplayName("Test notEmpty(Collection); given '42'; when ArrayList() add '42'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CollectionUtilities.notEmpty(Collection)"})
  void testNotEmpty_given42_whenArrayListAdd42_thenReturnTrue2() {
    // Arrange
    ArrayList<Object> ts = new ArrayList<>();
    ts.add("42");
    ts.add("42");

    // Act and Assert
    assertTrue(CollectionUtilities.notEmpty(ts));
  }

  /**
   * Test {@link CollectionUtilities#notEmpty(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#notEmpty(Collection)}
   */
  @Test
  @DisplayName("Test notEmpty(Collection); when ArrayList(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CollectionUtilities.notEmpty(Collection)"})
  void testNotEmpty_whenArrayList_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(CollectionUtilities.notEmpty(new ArrayList<>()));
  }

  /**
   * Test {@link CollectionUtilities#notEmpty(Collection)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#notEmpty(Collection)}
   */
  @Test
  @DisplayName("Test notEmpty(Collection); when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CollectionUtilities.notEmpty(Collection)"})
  void testNotEmpty_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(CollectionUtilities.notEmpty(null));
  }

  /**
   * Test {@link CollectionUtilities#head(Collection)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@link Optional#get()} is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#head(Collection)}
   */
  @Test
  @DisplayName("Test head(Collection); given '42'; when ArrayList() add '42'; then return get() is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional CollectionUtilities.head(Collection)"})
  void testHead_given42_whenArrayListAdd42_thenReturnGetIs42() {
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
   * Test {@link CollectionUtilities#head(Collection)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@link Optional#get()} is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#head(Collection)}
   */
  @Test
  @DisplayName("Test head(Collection); given '42'; when ArrayList() add '42'; then return get() is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional CollectionUtilities.head(Collection)"})
  void testHead_given42_whenArrayListAdd42_thenReturnGetIs422() {
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
   * Test {@link CollectionUtilities#head(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#head(Collection)}
   */
  @Test
  @DisplayName("Test head(Collection); when ArrayList(); then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional CollectionUtilities.head(Collection)"})
  void testHead_whenArrayList_thenReturnNotPresent() {
    // Arrange and Act
    Optional<Object> actualHeadResult = CollectionUtilities.head(new ArrayList<>());

    // Assert
    assertFalse(actualHeadResult.isPresent());
  }

  /**
   * Test {@link CollectionUtilities#head(Collection)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#head(Collection)}
   */
  @Test
  @DisplayName("Test head(Collection); when 'null'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional CollectionUtilities.head(Collection)"})
  void testHead_whenNull_thenReturnNotPresent() {
    // Arrange and Act
    Optional<Object> actualHeadResult = CollectionUtilities.head(null);

    // Assert
    assertFalse(actualHeadResult.isPresent());
  }

  /**
   * Test {@link CollectionUtilities#sort(Collection, Comparator)} with {@code xs}, {@code comparator}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#sort(Collection, Comparator)}
   */
  @Test
  @DisplayName("Test sort(Collection, Comparator) with 'xs', 'comparator'; given '42'; when ArrayList() add '42'; then return ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List CollectionUtilities.sort(Collection, Comparator)"})
  void testSortWithXsComparator_given42_whenArrayListAdd42_thenReturnArrayList() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    // Act
    List<Object> actualSortResult = CollectionUtilities.sort(xs, mock(Comparator.class));

    // Assert
    assertEquals(xs, actualSortResult);
  }

  /**
   * Test {@link CollectionUtilities#sort(Collection, Comparator)} with {@code xs}, {@code comparator}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then calls {@link Comparator#compare(Object, Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#sort(Collection, Comparator)}
   */
  @Test
  @DisplayName("Test sort(Collection, Comparator) with 'xs', 'comparator'; given one; then calls compare(Object, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List CollectionUtilities.sort(Collection, Comparator)"})
  void testSortWithXsComparator_givenOne_thenCallsCompare() {
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
   * Test {@link CollectionUtilities#sort(Collection, Comparator)} with {@code xs}, {@code comparator}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#sort(Collection, Comparator)}
   */
  @Test
  @DisplayName("Test sort(Collection, Comparator) with 'xs', 'comparator'; when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List CollectionUtilities.sort(Collection, Comparator)"})
  void testSortWithXsComparator_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualSortResult = CollectionUtilities.sort(new ArrayList<>(), mock(Comparator.class));

    // Assert
    assertTrue(actualSortResult.isEmpty());
  }

  /**
   * Test {@link CollectionUtilities#sort(Collection)} with {@code xs}.
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#sort(Collection)}
   */
  @Test
  @DisplayName("Test sort(Collection) with 'xs'; then return ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List CollectionUtilities.sort(Collection)"})
  void testSortWithXs_thenReturnArrayList() {
    // Arrange
    ArrayList<File> xs = new ArrayList<>();
    xs.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    List<File> actualSortResult = CollectionUtilities.sort(xs);

    // Assert
    assertEquals(xs, actualSortResult);
  }

  /**
   * Test {@link CollectionUtilities#sort(Collection)} with {@code xs}.
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#sort(Collection)}
   */
  @Test
  @DisplayName("Test sort(Collection) with 'xs'; then return ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List CollectionUtilities.sort(Collection)"})
  void testSortWithXs_thenReturnArrayList2() {
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
   * Test {@link CollectionUtilities#isEmpty(Collection)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#isEmpty(Collection)}
   */
  @Test
  @DisplayName("Test isEmpty(Collection); given '42'; when ArrayList() add '42'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CollectionUtilities.isEmpty(Collection)"})
  void testIsEmpty_given42_whenArrayListAdd42_thenReturnFalse() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    // Act and Assert
    assertFalse(CollectionUtilities.isEmpty(xs));
  }

  /**
   * Test {@link CollectionUtilities#isEmpty(Collection)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#isEmpty(Collection)}
   */
  @Test
  @DisplayName("Test isEmpty(Collection); given '42'; when ArrayList() add '42'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CollectionUtilities.isEmpty(Collection)"})
  void testIsEmpty_given42_whenArrayListAdd42_thenReturnFalse2() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");

    // Act and Assert
    assertFalse(CollectionUtilities.isEmpty(xs));
  }

  /**
   * Test {@link CollectionUtilities#isEmpty(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#isEmpty(Collection)}
   */
  @Test
  @DisplayName("Test isEmpty(Collection); when ArrayList(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CollectionUtilities.isEmpty(Collection)"})
  void testIsEmpty_whenArrayList_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(CollectionUtilities.isEmpty(new ArrayList<>()));
  }

  /**
   * Test {@link CollectionUtilities#isEmpty(Collection)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#isEmpty(Collection)}
   */
  @Test
  @DisplayName("Test isEmpty(Collection); when 'null'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CollectionUtilities.isEmpty(Collection)"})
  void testIsEmpty_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(CollectionUtilities.isEmpty(null));
  }

  /**
   * Test {@link CollectionUtilities#maybeFirst(Collection, Predicate)} with {@code xs}, {@code predicate}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#maybeFirst(Collection, Predicate)}
   */
  @Test
  @DisplayName("Test maybeFirst(Collection, Predicate) with 'xs', 'predicate'; given '42'; when ArrayList() add '42'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional CollectionUtilities.maybeFirst(Collection, Predicate)"})
  void testMaybeFirstWithXsPredicate_given42_whenArrayListAdd42_thenReturnNotPresent() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    // Act
    Optional<Object> actualMaybeFirstResult = CollectionUtilities.maybeFirst(xs, mock(RangeBand.class)::equals);

    // Assert
    assertFalse(actualMaybeFirstResult.isPresent());
  }

  /**
   * Test {@link CollectionUtilities#maybeFirst(Collection, Predicate)} with {@code xs}, {@code predicate}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#maybeFirst(Collection, Predicate)}
   */
  @Test
  @DisplayName("Test maybeFirst(Collection, Predicate) with 'xs', 'predicate'; given '42'; when ArrayList() add '42'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional CollectionUtilities.maybeFirst(Collection, Predicate)"})
  void testMaybeFirstWithXsPredicate_given42_whenArrayListAdd42_thenReturnNotPresent2() {
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
   * Test {@link CollectionUtilities#maybeFirst(Collection, Predicate)} with {@code xs}, {@code predicate}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#maybeFirst(Collection, Predicate)}
   */
  @Test
  @DisplayName("Test maybeFirst(Collection, Predicate) with 'xs', 'predicate'; when ArrayList(); then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional CollectionUtilities.maybeFirst(Collection, Predicate)"})
  void testMaybeFirstWithXsPredicate_whenArrayList_thenReturnNotPresent() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();

    // Act
    Optional<Object> actualMaybeFirstResult = CollectionUtilities.maybeFirst(xs, mock(RangeBand.class)::equals);

    // Assert
    assertFalse(actualMaybeFirstResult.isPresent());
  }

  /**
   * Test {@link CollectionUtilities#maybeFirst(Collection, Predicate)} with {@code xs}, {@code predicate}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#maybeFirst(Collection, Predicate)}
   */
  @Test
  @DisplayName("Test maybeFirst(Collection, Predicate) with 'xs', 'predicate'; when 'null'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional CollectionUtilities.maybeFirst(Collection, Predicate)"})
  void testMaybeFirstWithXsPredicate_whenNull_thenReturnNotPresent() {
    // Arrange and Act
    Optional<Object> actualMaybeFirstResult = CollectionUtilities.maybeFirst(null, mock(RangeBand.class)::equals);

    // Assert
    assertFalse(actualMaybeFirstResult.isPresent());
  }

  /**
   * Test {@link CollectionUtilities#maybeFirst(Collection)} with {@code xs}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@link Optional#get()} is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#maybeFirst(Collection)}
   */
  @Test
  @DisplayName("Test maybeFirst(Collection) with 'xs'; given '42'; when ArrayList() add '42'; then return get() is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional CollectionUtilities.maybeFirst(Collection)"})
  void testMaybeFirstWithXs_given42_whenArrayListAdd42_thenReturnGetIs42() {
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
   * Test {@link CollectionUtilities#maybeFirst(Collection)} with {@code xs}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@link Optional#get()} is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#maybeFirst(Collection)}
   */
  @Test
  @DisplayName("Test maybeFirst(Collection) with 'xs'; given '42'; when ArrayList() add '42'; then return get() is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional CollectionUtilities.maybeFirst(Collection)"})
  void testMaybeFirstWithXs_given42_whenArrayListAdd42_thenReturnGetIs422() {
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
   * Test {@link CollectionUtilities#maybeFirst(Collection)} with {@code xs}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#maybeFirst(Collection)}
   */
  @Test
  @DisplayName("Test maybeFirst(Collection) with 'xs'; when ArrayList(); then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional CollectionUtilities.maybeFirst(Collection)"})
  void testMaybeFirstWithXs_whenArrayList_thenReturnNotPresent() {
    // Arrange and Act
    Optional<Object> actualMaybeFirstResult = CollectionUtilities.maybeFirst(new ArrayList<>());

    // Assert
    assertFalse(actualMaybeFirstResult.isPresent());
  }

  /**
   * Test {@link CollectionUtilities#maybeFirst(Collection)} with {@code xs}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#maybeFirst(Collection)}
   */
  @Test
  @DisplayName("Test maybeFirst(Collection) with 'xs'; when 'null'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional CollectionUtilities.maybeFirst(Collection)"})
  void testMaybeFirstWithXs_whenNull_thenReturnNotPresent() {
    // Arrange and Act
    Optional<Object> actualMaybeFirstResult = CollectionUtilities.maybeFirst(null);

    // Assert
    assertFalse(actualMaybeFirstResult.isPresent());
  }

  /**
   * Test {@link CollectionUtilities#sumInts(Collection)}.
   * <ul>
   *   <li>Given {@link Columns#AQ}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@link Columns#AQ}.</li>
   *   <li>Then return longValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#sumInts(Collection)}
   */
  @Test
  @DisplayName("Test sumInts(Collection); given AQ; when LinkedHashSet() add AQ; then return longValue is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Long CollectionUtilities.sumInts(Collection)"})
  void testSumInts_givenAq_whenLinkedHashSetAddAq_thenReturnLongValueIsFortyTwo() {
    // Arrange
    LinkedHashSet<Integer> values = new LinkedHashSet<>();
    values.add(Columns.AQ);

    // Act and Assert
    assertEquals(42L, CollectionUtilities.sumInts(values).longValue());
  }

  /**
   * Test {@link CollectionUtilities#sumInts(Collection)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link ArrayList#ArrayList()} add one.</li>
   *   <li>Then return longValue is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#sumInts(Collection)}
   */
  @Test
  @DisplayName("Test sumInts(Collection); given one; when ArrayList() add one; then return longValue is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Long CollectionUtilities.sumInts(Collection)"})
  void testSumInts_givenOne_whenArrayListAddOne_thenReturnLongValueIsThree() {
    // Arrange
    ArrayList<Integer> values = new ArrayList<>();
    values.add(1);
    values.add(2);

    // Act and Assert
    assertEquals(3L, CollectionUtilities.sumInts(values).longValue());
  }

  /**
   * Test {@link CollectionUtilities#sumInts(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return longValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionUtilities#sumInts(Collection)}
   */
  @Test
  @DisplayName("Test sumInts(Collection); when ArrayList(); then return longValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Long CollectionUtilities.sumInts(Collection)"})
  void testSumInts_whenArrayList_thenReturnLongValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0L, CollectionUtilities.sumInts(new ArrayList<>()).longValue());
  }
}
